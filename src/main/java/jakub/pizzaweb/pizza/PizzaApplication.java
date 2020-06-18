package jakub.pizzaweb.pizza;

import jakub.pizzaweb.pizza.data.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaApplication {

    public static void main(String[] args) {

        SpringApplication.run(PizzaApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Ingredient("QQ", "Kukurycza", Ingredient.Type.WARZYWNE));
                repo.save(new Ingredient("KU", "Kurczak", Ingredient.Type.MIESNE));
                repo.save(new Ingredient("SZ", "Szynka", Ingredient.Type.MIESNE));
                repo.save(new Ingredient("CZ", "Czedar", Ingredient.Type.SER));
                repo.save(new Ingredient("PI", "Pieczarki", Ingredient.Type.INNE));
            }
        };
    }

}
