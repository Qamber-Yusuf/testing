// UserRepository.java
package data;

import java.util.HashMap;
import java.util.Map;

/**
 * UserRepository class - Data access layer for managing user information.
 * This class provides methods to check if a username already exists and to
 * save a new user to the storage. It uses a HashMap to simulate a database
 * for simplicity.
 */
public class UserRepository {

    // HashMap to store username-password pairs as a mock database
    private Map<String, String> users = new HashMap<>();

    /**
     * userExists - Checks if a username is already registered in the system.
     *
     * @param username The username to check in the storage
     * @return boolean indicating whether the username exists
     */
    public boolean userExists(String username) {
        // Check if the username is a key in the users map
        return users.containsKey(username);
    }

    /**
     * saveUser - Saves a new user to the storage by adding their username
     * and password to the users map.
     *
     * @param username The username of the new user
     * @param password The password of the new user
     */
    public void saveUser(String username, String password) {
        // Store the new user's username and password in the users map
        users.put(username, password);
    }
}
