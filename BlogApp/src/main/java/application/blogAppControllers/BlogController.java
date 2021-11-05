package application.blogAppControllers;

import application.blogAppServices.BlogServices;

import application.blogAppServices.UserService;
import application.models.Blogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private BlogServices service;
    private UserService service2;

    @Autowired
    public BlogController(BlogServices service, UserService service2) {
        this.service = service;
        this.service2 = service2;
    }

    @GetMapping("/allBlogs")
        public List<Blogs> allBlogs(){
        return service.getAllBlogs();
    }

    @GetMapping("/newBlog")
    // TODO
    public String addNewBlog(){
         return null;
    }

    @GetMapping("/deleteBlog")
    public Blogs deleteBlog(){
        // TODO
        return null;
    }
}
