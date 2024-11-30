import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import testing.Register use case.UserRepository;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void testUserExists_False() {
        // Test case: username does not exist
        boolean result = userRepository.userExists("nonExistentUser");
        assertFalse(result, "userExists should return false for a non-existent username");
    }

    @Test
    void testUserExists_True() {
        // Test case: username exists
        userRepository.saveUser("existingUser", "password123");
        boolean result = userRepository.userExists("existingUser");
        assertTrue(result, "userExists should return true for an existing username");
    }

    @Test
    void testSaveUser() {
        // Test case: save a user
        userRepository.saveUser("newUser", "password123");
        assertTrue(userRepository.userExists("newUser"), "saveUser should correctly store the username");
    }

    @AfterEach
    void tearDown() {
        userRepository = null;
    }
}
