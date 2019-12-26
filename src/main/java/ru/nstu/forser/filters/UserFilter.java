package ru.nstu.forser.filters;


import ru.nstu.forser.dao.UserDAO;
import ru.nstu.forser.entities.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class UserFilter implements Filter {
    private FilterConfig filterConfig;
    private static ArrayList<String> pages;  // хранилище страниц

    /**
     * Конструктор по умолчанию
     */
    public UserFilter() {
        // Создание хранилища страниц
        if (pages == null)
            pages = new ArrayList<>();
    }

    /**
     * Метод инициализации фильтра
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Метод фильтрации
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("userBean");
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String URI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (user != null && user.getRole().equals("user")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect(req.getContextPath() + "/views/notFound.jsp");
        }
    }

    /**
     * Метод освобождения ресурсов
     */
    @Override
    public void destroy() {
        filterConfig = null;
    }
}