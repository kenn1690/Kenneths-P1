package DTOs;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class is created, so when the user/admin logs in, it will only send the parts needed instead of a full user.
 * It is a pojo but contains the JSon ignore properties, so if more items are given
 * to the backend from the front end, it can ignore those "unknown" fields.
 */

@JsonIgnoreProperties
public class AuthDTO {
    private String userName;
    private String password;

    public AuthDTO() {
    }

    public AuthDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
