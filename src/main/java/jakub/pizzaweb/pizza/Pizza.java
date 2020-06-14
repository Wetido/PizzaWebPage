package jakub.pizzaweb.pizza;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class Pizza {

    private Long id;
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Nazwam musi skladac sie przynajmniej z 5 znaków")
    private String name;

    @Size(min = 1, message = "Wybierz przynajmniej jeden skladnik")
    private List<String> ingredients;


    public Pizza(Long id, Date createdAt, String name, List<String> ingredients) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Pizza(){}

    public Pizza(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}

