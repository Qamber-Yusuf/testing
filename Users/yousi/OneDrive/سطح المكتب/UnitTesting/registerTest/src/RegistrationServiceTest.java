import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import testing.Register use case.business.business.RegistrationService;

public class RegistrationServiceTest {
  private RegistrationService registrationService;

    @BeforeEach
    void setUp() {
        registrationService = new RegistrationService();
    }

    @Test
    void testRegisterUser_Success() {~
        // Test case: new username and password
        boolean result = registrationService.registerUser("newUser", "password123");
        assertTrue(result, "Registration should succeed for a new username");
    }

    @Test
    void testRegisterUser_UsernameExists() {
        // Test case: username already exists
        registrationService.registerUser("existingUser", "password123");
        boolean result = registrationService.registerUser("existingUser", "newPassword");
        assertFalse(result, "Registration should fail for an existing username");
    }

    @AfterEach
    void tearDown() {
        registrationService = null;
    }
}
