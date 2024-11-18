import org.junit.jupiter.api.*;
import business.RegistrationService;
import presentation.RegistrationUI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationUITest {

    private RegistrationUI registrationUI;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        registrationUI = new RegistrationUI();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testStartRegistration_Success() {
        // Simulate user input
        String input = "newUser\npassword123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Run registration
        registrationUI.startRegistration();

        // Verify output
        String output = outputStream.toString();
        assertTrue(output.contains("Registration successful!"), "Should indicate successful registration");
    }

    @Test
    void testStartRegistration_Failure() {
        // Simulate user input for an existing user
        String input = "existingUser\npassword123\nexistingUser\nnewPassword\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // First registration (success)
        registrationUI.startRegistration();
        // Second registration (failure)
        registrationUI.startRegistration();

        // Verify output
        String output = outputStream.toString();
        assertTrue(output.contains("Registration failed"), "Should indicate registration failure for existing user");
    }

    @AfterEach
    void tearDown() {
        registrationUI = null;
        System.setOut(null);
        System.setIn(System.in);
    }
}
