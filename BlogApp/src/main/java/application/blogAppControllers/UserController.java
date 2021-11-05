package application.blogAppControllers;

import application.blogAppServices.UserService;
import application.models.AllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

   @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home"})
    public String getHello() {
           return "Hello my friend";
    }

    @GetMapping("/user")
    public AllUsers getLoggedInUser() {
        return service.getLoggedInUser();
    }

    @GetMapping("users")
    public List<AllUsers> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{userName}")
    public AllUsers getOneUser(
            @PathVariable("userName") String displayName) { if (displayName != null) {
        return service.getOneUser(displayName);
    }
        return null;
    }

    @GetMapping("/userRegister")
    public String registrationInWebSite(){
       boolean register = service.registerUser();
       if (register) {
           return "Registered users is ready to work!";
       } return "Something wrong!";
    }

    /*@PostMapping (value ={"/userRegister"})
    public AllUsers registrationInWebSite(@RequestBody AllUsers user) {
       try{
           return service.registerUser(user);
       } catch (Exception e){
           return null;
       }
    }*/
}