package jakub.pizzaweb.pizza;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Pizza_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date PlacedAt;

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


    @ManyToMany(targetEntity = Pizza.class)
    private List<Pizza> pizzas = new ArrayList<>();

    public void addDesign(Pizza design){

        this.pizzas.add(design);
    }

    @PrePersist
    void placedAt(){

        this.PlacedAt = new Date();
    }

}
