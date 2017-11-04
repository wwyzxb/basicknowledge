package servlet.count;

import javax.servlet.*;
import java.io.IOException;

public class ViewCountFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //每一个登录请求都记录下来
        RedisUtils.INSTANCE.incr(Contants.VIEW_COUNT_KEY);
        //将请求返回给filter调用链
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
