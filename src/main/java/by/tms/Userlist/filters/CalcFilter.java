package by.tms.Userlist.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"calcServlet"})
public class CalcFilter extends HttpFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            res.getWriter().println("Please log in");
        } else if (req.getSession().getAttribute("currentUser") != null) {
            chain.doFilter(req, res);
        }
    }
}