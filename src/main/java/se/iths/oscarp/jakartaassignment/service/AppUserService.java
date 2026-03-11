package se.iths.oscarp.jakartaassignment.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import se.iths.oscarp.jakartaassignment.entity.AppUser;
import se.iths.oscarp.jakartaassignment.repository.AppUserRepository;

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

    @Transactional
    public AppUser saveUser(AppUser appUser) {
        return appUserRepository.saveAppUser(appUser);
    }

    public List<AppUser> getAllAppUsers() {
        List<AppUser> appUsers = appUserRepository.findAllAppUsers();

        return appUsers;
    }
}
