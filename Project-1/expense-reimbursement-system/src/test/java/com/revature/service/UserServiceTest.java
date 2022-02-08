package com.revature.service;

import com.revature.dao.UserDAO;
import com.revature.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UsersService usersService;
    UserDAO mockUsersDao;

    @BeforeEach
    public void setUp() {
        this.usersService = new UsersService();
        this.mockUsersDao = mock(UserDAO.class);
    }

    @Test
        // Happy Path
    void getUsernameAndPassword_PositiveTest() throws SQLException, FailedLoginException, FailedLoginException, SQLException {

        Users user = new Users(1, "singh.tanveer", "password", "Tanveer",
                "Singh", "tanveer.singh@list.com",
                "Manager");

        when(mockUsersDao.getUsernameAndPassword(eq("singh.tanveer"), eq("password"))).thenReturn(user);

        usersService = new UsersService(mockUsersDao);

        Users actual = usersService.getUsernameAndPassword("singh.tanveer", "password");

        Users expected = new Users(1, "singh.tanveer", "password", "Tanveer",
                "Singh", "tanveer.singh@list.com",
                "Manager");

        Assertions.assertEquals(expected, actual);
    }

    @Test // Sad Path
    void getUserNameAndPassword_NegativeTest_UsersReturnsNull() {

        usersService = new UsersService(mockUsersDao);

        Assertions.assertThrows(FailedLoginException.class, () -> {
            usersService.getUsernameAndPassword("singh.tanveer", "password");
        });
    }

}
