package Servlets;

import Models.User;
import Persistence.UserDAO;
import Services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * This servlet class handles the requests from the front end and sends a response back.
 */

public class UserServlet extends HttpServlet {
    private UserServices userServices;
    private UserDAO udao;
    @Override
    public void init() throws ServletException{
        this.userServices = new UserServices();

        this.udao = new UserDAO();
    }

    /**
     * This request is automatically called on UI page load to get user information.
     * The received information is from the header as the username.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = udao.getUserByUsername(req.getHeader("userName"));
        resp.setStatus(200);
        resp.getWriter().print(new ObjectMapper().writeValueAsString(user));
    }

    /**
     * A request is received ot create new user data here. It first checks whether the entered information for
     * the username and email is unique. If both of those items check, then it will send the entered data to
     * the services layer for validation. Depending on where it fails, the Service layer will respond with a number
     * and based on that number, the response from the backend here will differ. For example, if it sends status
     * 452, then the password requirements are not met. A successful response will creat a new user and send
     * information back to the front end as a token to store the currently logged in user.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    //creation of user
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User model = new ObjectMapper().readValue(req.getInputStream(), User.class);
        if(!udao.checkIfUserNameIsUnique(model.getUserName())){
            resp.setStatus(401);
        }
        else if(!udao.checkIfEmailIsUnique(model.getEmail())){
            resp.setStatus(402);
        }
        else {
            int switchOnReturnService = userServices.createNewUser(model);
            switch(switchOnReturnService){
                case 0:
                    resp.setStatus(201);
                    resp.getWriter().print(new ObjectMapper().writeValueAsString(model));
                    resp.setHeader("access-control-expose-headers", "authToken");
                    resp.setHeader("authToken", model.getUserName());
                    break;
                case 1:
                    resp.setStatus(451);
                    break;
                case 2:
                    resp.setStatus(452);
                    break;
                case 3:
                    resp.setStatus(453);
                    break;
                case 4:
                    resp.setStatus(454);
                    break;
                case 5:
                    resp.setStatus(455);
                    break;
                default:
                    break;
            }
            System.out.println(resp.getStatus());

        }
    }
}
