package softuni_game_store.dto;

import java.io.Serializable;

public class UserLoginDto implements Serializable {

    private String email;
    private String password;

    public UserLoginDto(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!(email.contains("@") && email.contains("."))) {
            throw new IllegalArgumentException("Incorrect email.");
        }
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (password.length() < 5 || !(password.chars().filter(c -> c == Character.toUpperCase(c)).count() > 0 &&
                password.chars().filter(c -> c == Character.toLowerCase(c)).count() > 0)) {
            throw new IllegalArgumentException("Incorrect password");
        }
        this.password = password;
    }
}
