package com.revature.service;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.UserDAO;
import com.revature.model.Reimbursement;
import com.revature.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.FailedLoginException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UsersService usersService;
    private ReimbursementService reimbursementService;
    UserDAO mockUsersDao;
    ReimbursementDao mockRd;

    @BeforeEach
    public void setUp() {
        this.usersService = new UsersService();
        this.mockUsersDao = mock(UserDAO.class);
        this.mockRd = mock(ReimbursementDao.class);
        this.reimbursementService = new ReimbursementService();
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

    @Test // Sad Path
    void getAllReimbursement_positive() throws SQLException {

        Users user = new Users(1, "singh.tanveer", "password", "Tanveer",
                "Singh", "tanveer.singh@list.com",
                "manager");

        Reimbursement firstReimb = new Reimbursement(1, 100.50, "2021-12-05 14:27:58", null,
                "Pending", 2, 1, "Approved", "travel");
        Reimbursement secondReimb = new Reimbursement(2, 12.50, "2021-12-05 14:28:24", "2021-12-05 14:29:22",
                "Approved", 2, 1, "Approved", "lodging");

        List<Reimbursement> listOfAllReimbursements = new ArrayList<>();
        listOfAllReimbursements.add(firstReimb);
        listOfAllReimbursements.add(secondReimb);

        when(mockRd.getAllReimbursements()).thenReturn(listOfAllReimbursements);
        reimbursementService = new ReimbursementService(mockRd);

        List<Reimbursement> actual = reimbursementService.getAllReimbursements(user);

        List<Reimbursement> expected = new ArrayList<>();

        expected.add(new Reimbursement(1, 100.50, "2021-12-05 14:27:58", null,
                "Pending", 2, 1, "Approved", "travel"));
        expected.add(new Reimbursement(2, 12.50, "2021-12-05 14:28:24", "2021-12-05 14:29:22",
                "Approved", 2, 1, "Approved", "lodging"));

        Assertions.assertEquals(expected, actual);
    }

}
