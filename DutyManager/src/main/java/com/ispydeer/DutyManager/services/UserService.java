package com.ispydeer.DutyManager.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.function.Function;


/**
 * Service class for managing user-related operations.
 * This class provides functionality to create new user details with encoded passwords.
 */
public class UserService {

    /**
     * Creates a new UserDetails object with the specified username and encoded password.
     *
     * @param username the username of the new user
     * @param password the raw password of the new user
     * @return a UserDetails object representing the newly created user with encoded password
     */
    public static UserDetails createNewUser(String username, String password) {
        Function<String, String> encoder = inputPassword -> PasswordEncoderFactories
                .createDelegatingPasswordEncoder().encode(inputPassword);
        return User.builder()
                .passwordEncoder(encoder)
                .username(username)
                .password(password)
                .roles("USER")
                .build();
    }
}
