package Services;

import Models.User;
import Persistence.UserDAO;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This class is the mediator. It does validation checks and send data to the persistence layer.
 */

public class UserServices {

    private UserDAO udao = new UserDAO();
    private Regex reggie = new Regex();

    /**
     * Does checks and returns corresponding number if something does not pass a check.
     * After all checks are complete, it will send the user model to be created in the DAO.
     * @param model
     * @return
     */
    public int createNewUser(User model){
        if(!reggie.userNameCheck(model.getUserName())){
            System.out.println("Made it to regex username check.");
            return 1;
        }
        else if(!reggie.passwordCheck(model.getPassword())){
            System.out.println("Made it to regex password check.");
            return 2;
        }
        else if(!reggie.userNameCheck(model.getfName())){
            System.out.println("Made it to regex fName check.");
            return 3;
        }
        else if(!reggie.userNameCheck(model.getlName())){
            System.out.println("Made it to regex lName check.");
            return 4;
        }
        else if(!reggie.emailCheck(model.getEmail())){
            System.out.println("Made it to regex email check.");
            return 5;
        }
        else {
            udao.create(model);
            return 0;
        }
    }

    /**
     * confirms username and password entered through the front end matches what is in the
     * database for that user
     * @param username
     * @param password
     * @return
     */
    public User loginCheck(String username, String password){
        User user = udao.getUserByUsername(username);
        if(username != null && user.getPassword().equals(password)){
            return user;
        }
        else {
            return null;
        }
    }

}
