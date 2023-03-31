package com.stackoverflow;

import com.stackoverflow.controller.UserController;
import com.stackoverflow.entity.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
        public void testUserCreation() {
            User user = new User();
            user.setUserId(15L);
            user.setFirstName("John");
            user.setLastName("Doe");
            user.setEmail("");
            UserController userController = new UserController();
            userController.createUser(user);

            assert userController.retrieveById().getFirstName().equals("John");

        }

}
