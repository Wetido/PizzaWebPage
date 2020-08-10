package jakub.pizzaweb.pizza;

import lombok.Data;
import net.bytebuddy.description.field.FieldDescription;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Nazwam musi skladac sie przynajmniej z 5 znaków")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    //@Size(min = 1, message = "Wybierz przynajmniej jeden skladnik")
    private List<Ingredient> ingredients = new ArrayList<>();


    @PrePersist
    void createdAt(){

        this.createdAt = new Date();
    }

}

