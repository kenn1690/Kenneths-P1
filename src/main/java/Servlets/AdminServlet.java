package Servlets;

import DTOs.AdminReimbursementDTO;
import Models.Reimbursement;
import Services.ReimbursementServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This servlet class handles the requests from the front end and sends a response back.
 */

public class AdminServlet extends HttpServlet {
    private ReimbursementServices rServices;

    @Override
    public void init() throws ServletException {
        this.rServices = new ReimbursementServices();
    }

    /**
     * This class will be called automatically when a UI page loads.
     * When it loads, it should load with all reimbursement objects in database
     * that are neither approved nor denied.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Made it to get method in AdminServlet");
        List<Reimbursement> models = rServices.readAllAdmin();
        String json = new ObjectMapper().writeValueAsString(models);
        System.out.println(models);
        resp.setContentType("application/json");
        resp.getWriter().print(json);
        resp.setStatus(200);
    }

    /**
     * This takes in user input from a page and updates the status of the reimbursement
     * It returns 200 status if it went through correctly
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Made it to put section of admin");
        AdminReimbursementDTO ardto = new ObjectMapper().readValue(req.getInputStream(), AdminReimbursementDTO.class);
        System.out.println(ardto);
        rServices.adminUpdateReimbursement(ardto);
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(ardto));
    }
}
