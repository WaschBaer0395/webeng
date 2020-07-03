package presentation;


import businesslogic.UserManager;
import transferobjects.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@ManagedBean
@Named
@RequestScoped
public class UserBean implements Serializable {

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
        System.out.println("test");
        return "index";
    }

    public User getuserById(long id){
        return userManager.getUserById(id);
    }

}
