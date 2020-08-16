package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
