package transferobjects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class Address {

    private long userId;
    private String city = "";
    private String region ="";
    private String street ="";
    private String houseNumber ="";
    private String zipCode ="";


    public long getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getRegion() {
        return region;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
