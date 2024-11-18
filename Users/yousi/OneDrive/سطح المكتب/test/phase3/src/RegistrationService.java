
package business;

import data.UserRepository;

/**
 * RegistrationService class - Core business logic for user registration.
 * This class is responsible for validating new user information and interacting
 * with the data layer to ensure that only unique usernames are registered.
 * It acts as a bridge between the presentation layer and data layer.
 */
public class RegistrationService {

    // Instance of UserRepository for data access
    private UserRepository userRepository = new UserRepository();

    /**
     * registerUser - Handles the registration logic for a new user.
     * Checks if the username is already in use and, if not, requests
     * the data layer to store the new user.
     *
     * @param username The username provided by the user
     * @param password The password provided by the user
     * @return boolean indicating if the registration was successful
     */
    public boolean registerUser(String username, String password) {
        // Verify if username already exists
        if (userRepository.userExists(username)) {
            // Registration failed due to username conflict
            return false;
        }
        // Save new user details to data storage
        userRepository.saveUser(username, password);
        return true;
    }
}
