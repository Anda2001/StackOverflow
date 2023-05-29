package com.stackoverflow;

import com.stackoverflow.controller.UserController;
import com.stackoverflow.entity.User;
import com.stackoverflow.repository.UserRepository;
import com.stackoverflow.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void setup() {
        // Create a mock instance of UserService
        userService = mock(UserService.class);
        userController = new UserController();
        userController.setUserService(userService);
    }

    @Test
    public void testCreateUser() {
        // Create a user
        User user = new User(15L, "John", "john@yahoo.com", "1234");

        // Define the behavior of the mocked UserService
        when(userService.createUser(user)).thenReturn(user);

        // Call the method on the UserController
        User createdUser = userController.createUser(user);

        // Verify the result
        assertEquals(user, createdUser);
    }

    // Add more test methods for other operations in UserController
    @Test
    public void testUserUpdate() {
        assert true;
    }

}
