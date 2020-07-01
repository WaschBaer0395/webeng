package transferobjects;


import io.ebean.annotation.Length;
import io.ebean.annotation.NotNull;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@RequestScoped
@Named
//@Entity
//@Table(name = "users")
public class User {


    private long id;
    private String userName;
    private String birthDate;
    private String email;
    private String contactNumber;
    private String address;
    private String password;


    public void setId(long id){this.id = id;}
    public long getId(){return this.id;}
    public void setUserName(String userName){this.userName=userName;}
    public String getUserName(){return this.userName;}
    public void setBirthDate(String birthDate){this.birthDate=birthDate;}
    public String getBirthDate(){return this.birthDate;}
    public void setEmail(String email){this.email=email;}
    public String getEmail(){return this.email;}
    public void setContactNumber(String contactNumber){this.contactNumber=contactNumber;}
    public String getContactNumber(){return this.contactNumber;}
    public void setAddress(String address){this.address=address;}
    public String getAddress(){return this.address;}
    public void setPassword(String password){this.password=password;}
    public String getPassword(){return this.password;}
}