package bll;

import dal.entities.User;
import dal.UserDAO;
import dal.UserPreferencesDAO;

import java.util.Optional;

public class UserService {

    private static final String USER_1_LOGIN = "bob";
    private static final String USER_1_PASSWORD = "bobpass";
    private static final String USER_1_DEFAULT_CITY = "KRAKOW";
    private static final Integer USER_1_DEFAULT_NUMBER_OF_DAYS = 0;
    private static final String USER_2_LOGIN = "jim";
    private static final String USER_2_PASSWORD = "jimpass";
    private static final String USER_2_DEFAULT_CITY = "WROCLAW";
    private static final Integer USER_2_DEFAULT_NUMBER_OF_DAYS = 0;

    private UserDAO userDAO;
    private UserPreferencesDAO userPreferencesDAO;
    private User currentUser;

    public UserService(UserDAO usedUserDAO, UserPreferencesDAO usedUserPreferencesDAO) {
        this.userDAO = usedUserDAO;
        this.userPreferencesDAO = usedUserPreferencesDAO;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean checkIfUserExists(String loginToCheck) {

        if (userDAO.findUser(loginToCheck).isPresent()) {

            return true;
        } else {
            return false;
        }
    }

    public void createDefaultUsers (String login, String password, String defaultCity, Integer defaultDays) {
        if (checkIfUserExists(login) == true) {
        userDAO.addNewUser(login, password, defaultCity, defaultDays);
        }
    }
// tu skonczyles - zrob metode do logowania usera; pewnie dwa ify?

    public boolean login(String login, String password) {

        Optional<User> user = userDAO.findUser(login);
        String foundPassword = null;
        if (user.isPresent()) {
            foundPassword = user.get().getPassword();
            if (foundPassword.equals(password)) {
                this.currentUser = user.get();

                return true;

            } else {
                return false;
            }
        } else {
            System.out.println("No user found!");
            return false;
        }
    }


//    public
//
//    public void initializeDefaultUsers() {

}


