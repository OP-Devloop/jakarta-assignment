package se.iths.oscarp.jakartaassignment.web;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.oscarp.jakartaassignment.entity.AppUser;
import se.iths.oscarp.jakartaassignment.service.AppUserService;

import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    private AppUserService appUserService;

    private String username;
    private String password;

    private AppUser loggedInUser;

    public String login() {

        AppUser user = appUserService.getAppUser(username, password);

        if (user != null) {
            loggedInUser = user;
            return "website?faces-redirect=true";
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Login failed", "Invalid username or password"));

        return null;
    }

    public String logout() {

        loggedInUser = null;
        username = null;
        password = null;

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "login?faces-redirect=true";
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public AppUser getLoggedInUser() {
        return loggedInUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
