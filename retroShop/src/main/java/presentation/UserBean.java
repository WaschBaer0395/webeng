package presentation;


import businesslogic.SessionUtils;
import businesslogic.UserManager;
import transferobjects.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@ManagedBean
@Named
@SessionScoped
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
        HttpSession session = SessionUtils.getSession();

        if(session.getAttribute("username") == null) {
            if (userManager.loginUser(user)) {
                System.out.println("User eingeloggt " + FacesContext.getCurrentInstance().getViewRoot().getViewId());
                session.setAttribute("username", user.getUserName());
                return "success";
            }
            else{
                System.out.println("User Falsch");
                user = null;
            }
        }
        System.out.println("Error Login");
        return "error";

    }

    public String logOut(){
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        user = null;
        return "logout";
    }

    public User getuserById(long id){
        return userManager.getUserById(id);
    }

}
