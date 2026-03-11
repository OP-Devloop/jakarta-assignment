package se.iths.oscarp.jakartaassignment.web;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import se.iths.oscarp.jakartaassignment.entity.AppUser;
import se.iths.oscarp.jakartaassignment.service.AppUserService;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AppUserBean implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Inject
    private AppUserService appUserService;
    private String username;
    private String password;


    public List<AppUser> getAppUsers() {
        return appUserService.getAllAppUsers();
    }

    public void saveAppUser() {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUserService.saveUser(appUser);
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
