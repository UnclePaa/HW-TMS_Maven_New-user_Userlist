package by.tms.Userlist.servlets;

import by.tms.Userlist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/auth", name = "authServlet")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        LinkedList<User> registered = (LinkedList<User>) getServletContext().getAttribute("registeredUsers");
        for (User us : registered) {
            if (us.equals(user)) {
                req.getSession().setAttribute("currentUser", us);
                resp.getWriter().println(us.getName() + " has been successfully authenticated");
            } else {
                resp.getWriter().println("Login and/or password is incorrect");
            }
        }
        LinkedList<User> authenticatedUsers = ((LinkedList<User>) req.getServletContext().getAttribute("authenticatedUsers"));
        authenticatedUsers.addFirst(user);
    }
}