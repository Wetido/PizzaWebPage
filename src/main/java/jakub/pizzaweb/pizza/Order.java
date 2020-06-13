package jakub.pizzaweb.pizza;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Order {

    @NotBlank(message="To pole jest obowiazkowe")
    private String name;

    @NotBlank(message="To pole jest obowiazkowe")
    private String street;

    @NotBlank(message="To pole jest obowiazkowe")
    private String zip;

    //@CreditCardNumber(message = "To nie jest prawidlowy numer karty kredytowej")
    @NotBlank(message="To pole jest obowiazkowe")
    private String ccNumber;

    @NotBlank(message="To pole jest obowiazkowe")
    //@Pattern(regexp = "^(0[1-9] | 1[0-2])([\\/])([1-9][0-9])$")
    private String ccExpiration;

    @NotBlank(message="To pole jest obowiazkowe")
    @Digits(integer = 3, fraction = 0, message = "Nieprawidlowy format kodu CVV")
    private String ccCVV;

    public Order(String name, String street, String zip, String ccNumber, String ccExpiration, String ccCVV) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.ccNumber = ccNumber;
        this.ccExpiration = ccExpiration;
        this.ccCVV = ccCVV;
    }

    public Order(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }
}
