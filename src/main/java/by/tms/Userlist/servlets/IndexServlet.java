package by.tms.Userlist.servlets;

import by.tms.Userlist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/index", name = "indexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") != null) {
            User currentUser = ((User) req.getSession().getAttribute("currentUser"));
            req.getSession().setAttribute("name", currentUser.getName());
        } else {
            resp.getWriter().println("No users authenticated");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }
}
//        if (req.getParameter("logout").equals("true")) {
//            String name = ((User) req.getSession().getAttribute("currentUser")).getName();
//            resp.getWriter().println(name + " has successfully logged out");
//            req.getSession().invalidate();
//            resp.sendRedirect("/index");