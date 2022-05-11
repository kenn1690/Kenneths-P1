package Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used in the services class to check whether what gets input from
 * the front matches certain formats. This can be done in the front, but I wanted to show
 * off backend skills.
 */

public class Regex {



    public boolean emailCheck(String email){
        //regex to validate email
        //must start with something besides @
        //must have letters before and after @
        String reggie = "^(.+)@(.+)(..+)$";
        Pattern pat = Pattern.compile(reggie);
        Matcher mat = pat.matcher(email);
        return mat.matches();
    }

    public boolean userNameCheck(String username){
        //regex to validate username
        //must start with letter A-Z or a-z
        //must be alphanumeric after that
        //min length is 3, max is 15
        String reggie = "^[A-Za-z]\\w{2,16}$";
        Pattern pat = Pattern.compile(reggie);
        Matcher mat = pat.matcher(username);
        return mat.matches();
    }
    public boolean passwordCheck(String password){
        //regex to validate password
        //matches literally (case-sensitive)
        //must contain lowercase
        //must contain upper case
        //must contain special character
        //must be between 8 and 15 characters
        String reggie = "^^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*-+=()])(?=\\S+$).{8,20}$";
        Pattern pat = Pattern.compile(reggie);
        Matcher mat = pat.matcher(password);
        return mat.matches();
    }

    public boolean descriptionCheck(String description){
        //confirms there are at least 3 characters
        String reggie = "^.{3,}$";
        Pattern pat = Pattern.compile(reggie);
        Matcher mat = pat.matcher(description);
        return mat.matches();
    }

    public boolean dollarCheck(double amount) {
        //confirms there are at least two numbers after the decimal
        String reggie = "^^[0-9]+(\\.[0-9][0-9])?$";
        Pattern pat = Pattern.compile(reggie);
        Matcher mat = pat.matcher(String.valueOf(amount));
        return mat.matches();
    }
}
