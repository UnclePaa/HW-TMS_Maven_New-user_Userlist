package by.tms.Userlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (getServletContext().getAttribute("users") == null) {
            getServletContext().setAttribute("users", new ArrayList<User>());
        }
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String pass = req.getParameter("pass");

        User user = new User(Integer.parseInt(age), name, pass);
        ArrayList<User> users = ((ArrayList<User>) getServletContext().getAttribute("users"));
        users.add(user);
    }
}