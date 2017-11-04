package servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 设置Cookie：
 * 1.服务器脚本向浏览器发送一组Cookie，例如：姓名、年龄、地址等;
 * 2.浏览器将这些信息存储在本地计算机上，以备将来使用;
 * 3.当下一次浏览器向 Web 服务器发送任何请求时，浏览器会把这些 Cookie 信息发送到服务器，服务器将使用这些信息来识别用户。
 */
@WebServlet("/cookieHandle")
public class CookieHandleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //前端给的参数值
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");

        //新建Cookie对象
        Cookie usernameCookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
        Cookie emailCookie = new Cookie("email", URLEncoder.encode(email, "UTF-8"));
        Cookie mobileCookie = new Cookie("mobile", URLEncoder.encode(mobile, "UTF-8"));
        Cookie addressCookie = new Cookie("address", URLEncoder.encode(address, "UTF-8"));

        //向Response中设置值
        resp.addCookie(usernameCookie);
        resp.addCookie(emailCookie);
        resp.addCookie(mobileCookie);
        resp.addCookie(addressCookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
