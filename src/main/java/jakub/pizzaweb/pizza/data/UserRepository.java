package jakub.pizzaweb.pizza.data;

import jakub.pizzaweb.pizza.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}

