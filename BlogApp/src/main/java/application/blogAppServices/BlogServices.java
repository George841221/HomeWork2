package application.blogAppServices;

import application.blogAppControllers.UserController;
import application.models.AllUsers;
import application.models.Blogs;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BlogServices{

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public List<Blogs> getAllBlogs(){
        return em.createQuery("SELECT allBlogs FROM Blogs allBlogs", Blogs.class)
                .getResultList();
    }


}
