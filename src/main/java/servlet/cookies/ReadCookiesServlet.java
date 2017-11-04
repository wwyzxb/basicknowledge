package servlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/readCookies")
public class ReadCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从Request中获得Cookies对象数组
        Cookie[] cookies = req.getCookies();
        PrintWriter printWriter = resp.getWriter();
        for (Cookie cookie : cookies) {
            printWriter.println(cookie.getName() + "," + URLDecoder.decode(cookie.getValue(), "UTF-8"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
