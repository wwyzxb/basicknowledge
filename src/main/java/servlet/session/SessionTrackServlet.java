package servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet("/*")
public class SessionTrackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "Servlet session threadlocal!";
        //如果session不存在则创建session对象
        HttpSession session = req.getSession(true);
        //session创建时间
        Date createTime = new Date(session.getCreationTime());
        //最后一次访问时间
        Date lastVisitTime = new Date(session.getLastAccessedTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String visitCountKey = "visitCount";
        Integer visitCount = 1;
        String userIdKey = "userId";
        String userId = "USER" + new Random().nextInt();

        if (session.isNew()) {
            //如果是新登录的用户，设置登录信息
            session.setAttribute(userIdKey, userId);
        } else {
            //如果是老用户则设置老用户信息
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount = visitCount == null ? -1 : visitCount + 1;

            userId = (String) session.getAttribute(userIdKey);
        }
        //记录登录次数
        session.setAttribute(visitCountKey, visitCount);
        //60s后session过期
        session.setMaxInactiveInterval(60);
        //打印用户Session信息
        StringBuffer buffer = new StringBuffer();
        buffer.append("title:" + title + "\r\n");
        buffer.append("sessionId:" + session.getId() + "\r\n");
        buffer.append(userIdKey + ":" + userId + "\r\n");
        buffer.append(visitCountKey + ":" + visitCount + "\r\n");
        buffer.append("createTime:" + sdf.format(createTime) + "\r\n");
        buffer.append("lastVisitTime:" + sdf.format(lastVisitTime) + "\r\n");
        resp.getWriter().println(buffer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
