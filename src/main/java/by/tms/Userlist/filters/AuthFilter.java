package by.tms.Userlist.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"authServlet", "indexServlet"})
public class AuthFilter extends HttpFilter {

    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") != null) {
            res.getWriter().println("You are already logged in");
        }
        if (req.getServletContext().getAttribute("registeredUsers") == null) {
            res.getWriter().println("Please register");
        }
        chain.doFilter(req, res);
    }
}