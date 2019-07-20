package jp.co.opst.shop.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.opst.shop.Controller.LoginController;

public class LoginCheckFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filgerChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        if (!requestURI.contains("login")) {

            HttpSession session = httpRequest.getSession();
            Object loginInfoObj = session
                    .getAttribute(LoginController.USERINFO_KEY);
            if (loginInfoObj == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath());
                return;
            }
        }
        filgerChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
