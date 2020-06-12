package jakub.pizzaweb.pizza.web;

import jakub.pizzaweb.pizza.Ingredient;
import jakub.pizzaweb.pizza.Ingredient.Type;
import jakub.pizzaweb.pizza.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DesignPizzaController {

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DesignPizzaController.class);

    @GetMapping
    public String showDesignForm(Model model){

        List<Ingredient> ingredients = Arrays.asList(

                new Ingredient("SZ", "Szynka", Ingredient.Type.MIESNE),
                new Ingredient("KU", "Kurczak", Ingredient.Type.MIESNE),
                new Ingredient("QQ", "Kukurydza", Ingredient.Type.WARZYWNE),
                new Ingredient("SF", "Ser feta", Ingredient.Type.SER),
                new Ingredient("PI", "Pieczarki", Ingredient.Type.INNE)
        );

        Type[] types = Ingredient.Type.values();

        for( Ingredient.Type type : types ){

            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Pizza());

        return "design";
    }

    private List<Ingredient> filterByType( List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
