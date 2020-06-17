package presentation;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.Date;

@Named
@ManagedBean
@SessionScoped
public class TestJSF implements Serializable {



    private String message = "Test Shop!";
    private static final long serialVersionUID = 1L;


    public TestJSF() {
        System.out.println("Test has started!");
    }

    public String update()
    {
        System.out.println("TestShop: update called");
        message = "Hier ist die Liste " ;
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}
