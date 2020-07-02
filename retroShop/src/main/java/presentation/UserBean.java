package presentation;


import businesslogic.UserManager;
import transferobjects.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.concurrent.atomic.AtomicInteger;

@Named
@RequestScoped
public class UserBean {

    private UserManager userManager = new UserManager();
    private User user = new User();


    public User getUser(){
        return this.user;
    }

    public String saveUser(){

        userManager.addUser(user);
        return "success";
    }

    public String updateUser(){

        userManager.updateUser(user);
        return "welcome.xhtml";
    }

    public String loginUser(){

        return "error";
    }
}
