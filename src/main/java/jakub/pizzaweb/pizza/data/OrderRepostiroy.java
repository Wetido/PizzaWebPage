package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepostiroy extends CrudRepository<Order, Long> {

    Order save(Order order);
}
