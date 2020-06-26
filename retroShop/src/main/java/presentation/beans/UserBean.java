package presentation.beans;


import businesslogic.UserManager;
import transferobjects.User;

import javax.faces.bean.RequestScoped;
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
        return "welcome.xhtml";
    }
}
