package se.iths.oscarp.jakartaassignment.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.oscarp.jakartaassignment.entity.AppUser;
import se.iths.oscarp.jakartaassignment.repository.AppUserRepository;
import se.iths.oscarp.jakartaassignment.util.Timed;

import java.util.List;

@ApplicationScoped
public class AppUserService {
    private AppUserRepository appUserRepository;

    public AppUserService() {
    }

    @Inject
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Timed
    @Transactional
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.saveAppUser(appUser);
    }

    @Timed
    public List<AppUser> getAllAppUsers() {
        List<AppUser> appUsers = appUserRepository.findAllAppUsers();

        return appUsers;
    }

    public AppUser getAppUser(String username, String password) {
        return appUserRepository.findAppUser(username, password);
    }
}
