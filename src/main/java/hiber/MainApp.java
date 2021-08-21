package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("Ivan", "Ivanov", "ivanov@mail.ru",
                new Car("Mercedes", 600)));

        userService.add(new User("Vladimir", "Alexandrov", "alexandrov@mail.ru",
                new Car("Lexus", 300)));

        userService.add(new User("Veronica", "Sergeeva", "sergeeva@mail.ru",
                new Car("BMW", 520)));

        userService.add(new User("Alejandra", "Moreno Viera", "moreno_viera@mail.ru",
                new Car("Audi", 6)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());

            System.out.println("Model = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
            System.out.println();
        }


        context.close();
    }


}
