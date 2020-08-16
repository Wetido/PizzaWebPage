package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

    Pizza save(Pizza design);
}
