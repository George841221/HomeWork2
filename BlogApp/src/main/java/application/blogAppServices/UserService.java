package application.blogAppServices;

import application.models.AllUsers;
import application.models.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.SQLDataException;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return em.createQuery("SELECT user FROM AllUsers user WHERE user.displayName = :name", AllUsers.class)
                .setParameter("name", userName)
                .getSingleResult();
    }

    public AllUsers getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof AllUsers) {
                return (AllUsers) principal;
            }
        }
        return null;
    }

    @Transactional
    public List<AllUsers> getAllUsers(){
        return em.createQuery("SELECT user FROM AllUsers user", AllUsers.class)
                .getResultList();
    }

    @Transactional
    public AllUsers getOneUser(String userName) {
        try {
            return (AllUsers) loadUserByUsername(userName);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean registerUser() {
        try {
            String userPassword = encoder.encode("user");
            String adminPassword = encoder.encode("admin");
            String moderatorPassword = encoder.encode("moderator");

            AllUsers user1 = new AllUsers("kismalac", "Pista", "Kiss", userPassword,
                    "valami@valami1.hu", "USER", Gender.MALE);
            AllUsers admin = new AllUsers("kiscica", "Juci", "Fazekas", adminPassword,
                    "valami@valami2.hu", "ADMIN", Gender.FEMALE);
            AllUsers moderator = new AllUsers("kiskutya", "József", "Kolompár", moderatorPassword,
                    "valami@valami3.com", "MODERATOR", Gender.MALE);

            em.persist(user1);
            em.persist(admin);
            em.persist(moderator);
            return true;
        }
     catch (Exception e) {
        return false;

    }
}
      // not working :(
    /*@Transactional
    public AllUsers registerUser(AllUsers user) {
        try {
            user.setPassword(encoder.encode(user.getPassword()));
            em.persist(user);

            return new AllUsers();
        } catch (Exception e) {
            return null;

        }
    }*/
}
