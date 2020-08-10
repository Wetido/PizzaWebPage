package jakub.pizzaweb.pizza.web;

import jakub.pizzaweb.pizza.Ingredient;
import jakub.pizzaweb.pizza.Ingredient.Type;
import jakub.pizzaweb.pizza.Order;
import jakub.pizzaweb.pizza.Pizza;
import jakub.pizzaweb.pizza.data.IngredientRepository;
import jakub.pizzaweb.pizza.data.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignPizzaController {

    private final IngredientRepository ingredientRepository;
    private PizzaRepository pizzaRepository;

    @ModelAttribute(name = "order")
    public Order order(){

        return new Order();
    }

    @ModelAttribute(name = "design")
    public Pizza design(){

        return new Pizza();
    }

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepository,
                                 PizzaRepository pizzaRepository) {
        this.ingredientRepository = ingredientRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping
    public String showDesignForm(Model model){

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();

        for( Ingredient.Type type : types ){

            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        //model.addAttribute("design", new Pizza());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Pizza design, Errors errors, @ModelAttribute Order order){

       /* if(errors.hasErrors()){
            return "design";
        }*/


        Pizza saved = pizzaRepository.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType( List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
