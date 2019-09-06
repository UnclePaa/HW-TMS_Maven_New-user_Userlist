package by.tms.Userlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("currentUser") != null) {
            resp.getWriter().println("Hello " + ((User) req.getSession().getAttribute("currentUser")).getName());
        }

        if (req.getParameter("logout").equals("true")) {
            String name = ((User) req.getSession().getAttribute("currentUser")).getName();
            req.getSession().invalidate();
            resp.getWriter().println(name + " has successfully logged out");
            resp.sendRedirect("/index");
        }
    }
}