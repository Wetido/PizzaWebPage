package jakub.pizzaweb.pizza.web;


import jakub.pizzaweb.pizza.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DesignPizzaController.class);

    @GetMapping("/current")
    public String orderForm(Model model){

        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors){

        if(errors.hasErrors()){

            return "orderForm";
        }

        log.info("Zamowienie zostalo zlozone: " + order);
        return "redirect:/";
    }
}
