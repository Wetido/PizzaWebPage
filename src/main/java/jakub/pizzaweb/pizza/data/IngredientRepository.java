package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
