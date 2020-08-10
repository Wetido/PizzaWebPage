package jakub.pizzaweb.pizza;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private final String username;
    private final String password;
    private final String fullname;
    private final String street;
    private final String zip;
    private final String phoneNumber;


    public User toUser(PasswordEncoder passwordEncoder){

        return new User(username, passwordEncoder.encode(password), fullname, street, zip, phoneNumber);
    }
}
