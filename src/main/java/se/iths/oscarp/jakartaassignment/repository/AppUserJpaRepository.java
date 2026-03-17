package se.iths.oscarp.jakartaassignment.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.iths.oscarp.jakartaassignment.entity.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserJpaRepository implements AppUserRepository {

    @PersistenceContext(unitName = "neon-jakarta-assignment_database")
    private EntityManager entityManager;


    @Override
    public AppUser saveAppUser(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public List<AppUser> findAllAppUsers() {
        return entityManager.createQuery(
                "SELECT u FROM AppUser u", AppUser.class).getResultList();
    }

    public AppUser findAppUser(String username, String password) {
        return entityManager.createQuery(
                        "SELECT u FROM AppUser u WHERE u.username = :username " +
                                "AND u.password = :password", AppUser.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }
}
