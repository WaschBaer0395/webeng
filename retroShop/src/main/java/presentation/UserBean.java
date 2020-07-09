package presentation;


import businesslogic.AddressManager;
import businesslogic.SessionUtils;
import businesslogic.UserManager;
import transferobjects.Address;
import transferobjects.Article;
import transferobjects.User;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@ManagedBean
@Named
@SessionScoped
public class UserBean implements Serializable {

    private UserManager userManager = new UserManager();
    private User user = new User();
    private AddressManager addressManager = new AddressManager();
    private Address address = new Address();


    public User getUser(){
        return this.user;
    }

    public String saveUser(){
        userManager.addUser(user);
        user.setId(userManager.loginUser(user).getId());
        address.setUserId(user.getId());
        addressManager.addAddress(address);
        System.out.println(
                FacesContext.getCurrentInstance().getViewRoot().getViewId()
        );
        return  loginUser();
    }

    public String updateUser(){

        userManager.updateUser(user);
        if(address != null) addressManager.updateAddress(address);
        else if (address == null) addressManager.addAddress(address);
        return "myProfile";
    }

    public String loginUser(){
        HttpSession session = SessionUtils.getSession();

        if(session.getAttribute("username") == null) {
            if (userManager.loginUser(user) != null) {
                user = userManager.loginUser(user);
                if(addressManager.getAddress(user.getId()) != null){
                    address = addressManager.getAddress(user.getId());
                }
                System.out.println("User eingeloggt " + FacesContext.getCurrentInstance().getViewRoot().getViewId());
                session.setAttribute("user", user);
                session.setAttribute("username", user.getUserName());
                session.setAttribute("userid",user.getId());

                return "success";
            }
            else{
                System.out.println("User Falsch");
            }
        }
        System.out.println("Error Login");
        return "error";

    }

    public String registerUser(){
        System.out.println(FacesContext.getCurrentInstance().getViewRoot().getViewId());
        return "registerUser";
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

    public String myProfile(){
        return "myProfile";
    }

    public Address getAddress() {
        return this.address;
    }

    public String setAddress(){
        addressManager.addAddress(address);
        return "";
    }
}
