package by.tms.Userlist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        User user = new User();
        user.setName(name);
        user.setPassword(pass);
        ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
        for (User us: users) {
            if(us.equals(user)) {
                req.getSession().setAttribute("currentUser", us);
                resp.getWriter().println(us.getName() + " has been successfully authenticated");
            }
        }
    }
}
