package jakub.pizzaweb.pizza.web;

import jakub.pizzaweb.pizza.Ingredient;
import jakub.pizzaweb.pizza.Ingredient.Type;
import jakub.pizzaweb.pizza.Pizza;
import jakub.pizzaweb.pizza.data.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


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

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DesignPizzaController.class);

    @Autowired
    public DesignPizzaController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping
    public String showDesignForm(Model model){

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();

        for( Ingredient.Type type : types ){

            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Pizza());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Pizza design, Errors errors){

        if(errors.hasErrors()){
            return "design";
        }

        log.info("Przetwarzanie projektu pizza: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType( List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
