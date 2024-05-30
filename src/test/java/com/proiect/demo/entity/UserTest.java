package com.proiect.demo.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testId() {
        int id = 1;
        user.setId(id);
        user.getId();
        System.out.println(user.getId());
        assertEquals(id, user.getId());
    }

    @Test
    void testFirstName() {
        String firstName = "Test";
        user.setFirstName(firstName);
        System.out.println(user.getFirstName());
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    void testLastName() {
        String lastName = "User";
        user.setLastName(lastName);
        System.out.println(user.getLastName());
        assertEquals(lastName, user.getLastName());
    }

    @Test
    void testEmail() {
        String email = "test@example.com";
        user.setEmail(email);
        System.out.println(user.getEmail());
        assertEquals(email, user.getEmail());
    }

    @Test
    void testPassword() {
        String password = "password";
        user.setPassword(password);
        System.out.println(user.getPassword());
        assertEquals(password, user.getPassword());
    }

    @Test
    void testRole() {
        User.Role role = User.Role.CLIENT;
        user.setRole(role);
        System.out.println(user.getRole());
        assertEquals(role, user.getRole());
    }
}