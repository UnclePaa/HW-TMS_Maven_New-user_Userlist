package by.tms.Userlist.servlets;

import by.tms.Userlist.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/calc", name = "calcServlet")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = ((User) req.getSession().getAttribute(("currentUser"))).getName();
        LinkedList<String> history = (LinkedList<String>) req.getServletContext().getAttribute("history");

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String act = req.getParameter("act");

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        String result = df.format(Double.valueOf(result(num1, num2, act)));

        history.addFirst("The result received from " + act + " of "
                + num1 + " and " + num2 + " is " + result + " (calculated by " + name + ")");
        resp.getWriter().println(history.toString());
    }

    public double result(String num1, String num2, String act) {
        double result = 0.00;
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);


        if (act.equals("sum")) {
            result = number1 + number2;
        }

        if (act.equals("diff")) {
            result = number1 - number2;
        }

        if (act.equals("mult")) {
            result = number1 * number2;
        }

        if (act.equals("div")) {
            result = number1 / number2;
        }
        return result;
    }
}