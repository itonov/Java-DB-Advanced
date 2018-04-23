package softuni_game_store.dto;

import java.io.Serializable;

public class UserLogoutDto implements Serializable {

    private Boolean isLogged;

    public UserLogoutDto() {
        this.isLogged = true;
    }

    public Boolean getLogged() {
        return this.isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }
}
