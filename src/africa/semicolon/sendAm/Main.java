package africa.semicolon.sendAm;

import africa.semicolon.sendAm.Dtos.requests.RegisterUserRequest;
import africa.semicolon.sendAm.Dtos.responses.FindUserResponse;
import africa.semicolon.sendAm.Dtos.responses.RegisterUserResponse;
import africa.semicolon.sendAm.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication
public class Main {
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
//        load options
//        loadOptions();
//        if option is register
//        load form
//        print output
//        load option

//    if option is search by email
//        ask for email
//        show
//        load options
    }
    private static void loadOptions(){
        String options = """
                -> A for Register
                -> B for Find by email
                """;
        String input = collectStringInput(options);
        switch (input.toLowerCase()) {
            case "a":
                loadRegisterForm();
                break;
            case "b":
                askUserForEmail();
                break;
            default: {
                display("get sense");
                loadOptions();
            }
        }

    }
    private static void askUserForEmail(){
        String userEmail = collectStringInput("Enter the email you want to search");
        FindUserResponse response = userController.getUserByEmail(userEmail);
        loadOptions();
    }
    private static String collectStringInput(String message){
        Scanner scanner = new Scanner(System.in);
        display(message);
        return scanner.nextLine();
    }
    private static void display(String message){
        System.out.println(message);

    }
    private static void loadRegisterForm(){
        RegisterUserRequest form = new RegisterUserRequest();
        form.setFirstName(collectStringInput("Enter your first name"));
        form.setLastName(collectStringInput("Enter your last name"));
        form.setEmailAddress(collectStringInput("Enter your email address"));
        form.setPhoneNumber(collectStringInput("Enter your phone number"));
        form.setAddress(collectStringInput("Enter your home address"));

        RegisterUserResponse response = userController.registerNewUser(form);
        display(response.toString());
        loadOptions();
    }
}
