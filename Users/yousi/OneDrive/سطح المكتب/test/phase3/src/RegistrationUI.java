// RegistrationUI.java
package presentation;

import business.RegistrationService;
import java.util.Scanner;

/**
 * RegistrationUI class - Handles user interaction for the registration process.
 * This class is responsible for gathering user input, such as username and password,
 * and relaying it to the business layer for processing. It also provides feedback
 * to the user on whether the registration was successful or failed.
 */
public class RegistrationUI {

    // Instance of RegistrationService for processing registration logic
    private RegistrationService registrationService = new RegistrationService();

    /**
     * startRegistration - Begins the registration process by prompting the user
     * to enter a username and password, which are then passed to the business
     * layer for validation and storage. Provides feedback to the user based on
     * the success or failure of the registration.
     */
    public void startRegistration() {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for username
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        // Prompt user for password
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Register user via business layer and provide feedback
        boolean isRegistered = registrationService.registerUser(username, password);
        if (isRegistered) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Username might already be taken.");
        }


        scanner.close();
    }
}