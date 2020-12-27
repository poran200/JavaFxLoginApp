package com.mycompany.mydbgui.dao;

import com.mycompany.mydbgui.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {
    UserDAO userDAO = new UserDAOImpl();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void register() {
    }

    @Test
    @DisplayName("user log in successfully")
    void login() {
        var user = new User("poran", "pass");
        var login = userDAO.login(user);
        assertTrue(login);
    }
    @Test
    @DisplayName("user log in failed bad credential")
    void loginFailed() {
        var user = new User("poran", "");
        var login = userDAO.login(user);
        assertFalse(login);
    }

    @Test
    void save() {
    }

    @Test
    void findByModel() {
    }

    @Test
    void update() {
    }

    @Test
    @DisplayName("find by user name")
    void finById() {
        var poran = userDAO.finById("poran");
        assertTrue(poran.isPresent());
        assertEquals(poran.get().getUserName(),"poran");
    }

    @Test
    void findAll() {
    }

    @Test
    void removeBYId() {
    }
}