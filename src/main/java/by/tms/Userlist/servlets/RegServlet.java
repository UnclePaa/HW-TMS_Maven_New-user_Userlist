package by.tms.Userlist.servlets;

import by.tms.Userlist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/reg", name = "regServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String pass = req.getParameter("pass");

        if (name.length() < 2 || name == null) {
            resp.getWriter().println("Name should contain at least two characters");
        } else if (age == null) {
            resp.getWriter().println("Please enter your age");
        } else if (age.length() > 3 || !age.matches("\\d+?")) {
            resp.getWriter().println("Please enter the correct age");
        } else if (pass.length() < 6) {
            resp.getWriter().println("Password must contain at least six characters");
        } else {
            User user = new User(Integer.parseInt(age), name, pass);
            LinkedList<User> registeredUsers = ((LinkedList<User>) getServletContext().getAttribute("registeredUsers"));
            registeredUsers.add(user);
            resp.getWriter().println("Registration successful. Hello, " + name);
        }
    }
}