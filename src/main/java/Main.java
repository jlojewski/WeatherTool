import bll.UserService;
import dal.UserDAO;
import dal.UserPreferencesDAO;
import dal.entities.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        UserPreferencesDAO userPreferencesDAO = new UserPreferencesDAO();
        UserService userService = new UserService(userDAO, userPreferencesDAO);

        userService.initializeDefaultUsers();



        System.out.println("Welcome to the Simple Weather Tool!");
        System.out.println("Please enter your login.");

        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();

        System.out.println("Please enter the associated password.");
        String password = scanner.nextLine();


//        if(userService.logIn(login, password))

    }
}
