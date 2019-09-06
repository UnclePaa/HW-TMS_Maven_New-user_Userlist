package by.tms.Userlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/new")
public class NewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getSession().getId();
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        if (req.getSession().isNew()) {
            if (name != null && age != null) {
                req.getSession().setAttribute("CurrentUser", req.getParameter("name"));
                req.getServletContext().setAttribute("history", new LinkedList<>());
                req.getSession().setAttribute("User", new User(name, age, id));

                resp.getWriter().println("Welcome, " + name + " aged " + age);
                resp.getWriter().println("Your id is : " + id);
            } else
                resp.getWriter().println("Name and/or age haven't entered");
        } else
            resp.getWriter().println("You are already logged in");
    }
}