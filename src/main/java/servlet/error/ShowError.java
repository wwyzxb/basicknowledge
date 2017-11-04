package servlet.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Vincent
 * @Date 2017/10/29 22:47
 */
@WebServlet("/showError")
public class ShowError extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回错误状态码以及信息
        resp.sendError(500,"哈哈，你出错了！");
    }
}
