package se.iths.oscarp.jakartaassignment.repository;

import se.iths.oscarp.jakartaassignment.entity.AppUser;

import java.util.List;

public interface AppUserRepository {
    AppUser saveAppUser(AppUser appUser);

    List<AppUser> findAllAppUsers();

    AppUser findAppUser(String username, String password);

}
