package presentation;


import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;


@ManagedBean
@SessionScoped
public class HelloJSF implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelloJSF() {
	      System.out.println("Hello JSF started!");   
	   }
	private String message = "Hello JSF!";
	
	public String update()
	{
		System.out.println("HelloJSF: update called");
		message = "Hello JSF! " + new Date().toString();
		return null;
	}
	public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
        
    }
}