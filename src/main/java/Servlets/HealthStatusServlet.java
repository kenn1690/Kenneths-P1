package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple ping servlet. When the servlet is hit, it just responds the page is up.
 * A good way to check if the server is at least up.
 */

public class HealthStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(202);
        resp.getWriter().print("Health status check successful!");
        System.out.println("Health status check successful!");
    }
}
