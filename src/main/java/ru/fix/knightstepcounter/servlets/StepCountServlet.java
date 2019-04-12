package ru.fix.knightstepcounter.servlets;

import org.springframework.beans.factory.annotation.Autowired;
import ru.fix.knightstepcounter.models.Result;
import ru.fix.knightstepcounter.services.StepCountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hourse/servlet/count")
public class StepCountServlet extends HttpServlet {

    @Autowired
    private StepCountService stepCountService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        Integer width;
        Integer height;

        if (start == null || end == null || start.isEmpty() || end.isEmpty()) {
            resp.getWriter().println("Some of required parameters are missing!");
            resp.getWriter().println("\nRequest example:");
            resp.getWriter().println("/hourse/servlet/count?width=10&height=14&start=6&end=A3");
            return;
        }
        if (start.length() != 2 || end.length() != 2) {
            resp.getWriter().println("Wrong format of 'start' or 'end' parameters! Example: start=A4");
            return;
        }
        try {
            width = Integer.parseInt(req.getParameter("width"));
            height = Integer.parseInt(req.getParameter("height"));
        }
        catch (NumberFormatException e) {
            resp.getWriter().println("Wrong number format (or missing) of 'width' or 'height' parameters!");
            return;
        }

        Result result = stepCountService.getStepCount(start, end, width, height);
        resp.getWriter().println(result.getStepCount());
    }
}
