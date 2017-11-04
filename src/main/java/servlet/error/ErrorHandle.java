package servlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/errorHandle")
public class ErrorHandle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int status_code = (Integer) req.getAttribute("javax.servlet.error.status_code");
        Class exception_type = (Class) req.getAttribute("javax.servlet.error.exception_type");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        String request_uri = (String) req.getAttribute("javax.servlet.error.request_uri");
        Throwable exception = (Throwable) req.getAttribute("javax.servlet.error.exception");
        String servlet_name = (String) req.getAttribute("javax.servlet.error.servlet_name");
        resp.getWriter().println("status_code:" + status_code);
        resp.getWriter().println("exception_type:" + exception_type);
        resp.getWriter().println("message:" + message);
        resp.getWriter().println("request_uri:" + request_uri);
        resp.getWriter().println("exception:" + exception);
        resp.getWriter().println("servlet_name:" + servlet_name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
