package jakub.pizzaweb.pizza.web;


import jakub.pizzaweb.pizza.Order;
import jakub.pizzaweb.pizza.data.IngredientRepository;
import jakub.pizzaweb.pizza.data.OrderRepostiroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DesignPizzaController.class);

    private OrderRepostiroy orderRepostiroy;

    @Autowired
    public OrderController(OrderRepostiroy orderRepostiroy){
        this.orderRepostiroy = orderRepostiroy;
    }

    @GetMapping("/current")
    public String orderForm(Model model){

        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){

        if(errors.hasErrors()){

            return "orderForm";
        }
        orderRepostiroy.save(order);
        sessionStatus.setComplete();

        log.info("Zamowienie zostalo zlozone: " + order);
        return "redirect:/";
    }
}
