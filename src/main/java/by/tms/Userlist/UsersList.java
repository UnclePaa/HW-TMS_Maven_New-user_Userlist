package by.tms.Userlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/index")
public class UsersList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LinkedList<Object> history = (LinkedList<Object>) req.getServletContext().getAttribute("history");
        if (history != null) {
            history.addFirst(req.getSession().getAttribute("User"));
            resp.getWriter().println(history.toString());
        } else
            resp.getWriter().println("No users found");
    }
}