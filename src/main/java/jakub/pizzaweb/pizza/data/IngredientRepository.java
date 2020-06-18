package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
