package log;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/21
 **/
public class Log4jServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        String prefix = this.getClass().getClassLoader().getResource("/").getPath();
        String path = config.getInitParameter("log4j-path");
        PropertyConfigurator.configure(prefix + path);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {}
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {}
    public void destroy() {}
}
