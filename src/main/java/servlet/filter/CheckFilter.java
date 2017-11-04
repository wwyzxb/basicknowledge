package servlet.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet 过滤器可以动态地拦截请求和响应，以变换或使用包含在请求或响应中的信息。
 * Filter的主要功能如下：
 * 1.在客户端的请求访问后端资源之前，拦截这些请求。
 * 2.在服务器的响应发送回客户端之前，处理这些响应。
 *
 * @Author Vincent
 * @Date 2017/10/30 23:51
 */
public class CheckFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CheckFilter init...");
    }

    /**
     * 该filter主要用于验证用户帐号和密码
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        boolean usernameCheckStatus = false;
        boolean passwordCheckStatus = false;
        if ("Vincent".equals(username)) {
            usernameCheckStatus = true;
        } else {
            servletResponse.getWriter().println("your username is wrong");
        }

        if ("123456".equals(password)) {
            passwordCheckStatus = true;
        } else {
            servletResponse.getWriter().println("your password is wrong");
        }
        //如果帐号密码严重通过则，则把请求传回过滤链
        if (usernameCheckStatus && passwordCheckStatus) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public void destroy() {
        System.out.println("CheckFilter destroy...");
    }
}
