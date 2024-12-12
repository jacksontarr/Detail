package com.detail.api.detailapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.detail.api.detailapi.model.Car.Progress;

@Tag("model-tier")
public class UserTest {
    private int expectedLoginID;
    private String expectedUsername;
    private boolean expectedIsAdmin;
    private ArrayList<Car> expectedCarsList;
    private User user;

    @BeforeEach
    public void setupUser() {
        expectedLoginID = 1;
        expectedUsername = "tarrjac";
        expectedIsAdmin = true;
        expectedCarsList = new ArrayList<>();
        user = new User(expectedLoginID, expectedUsername, expectedIsAdmin, expectedCarsList);
    }

    @Test
    public void testLoginID() {
        assertEquals(expectedLoginID, user.getLoginID());
    }

    @Test
    public void testUsername() {
        assertEquals(expectedUsername, user.getUsername());
    }

    @Test
    public void testIsAdmin() {
        assertEquals(expectedIsAdmin, user.isAdmin());
    }

    @Test
    public void testCarsListEmpty() {
        assertEquals(expectedCarsList, user.getCarsList());
    }

    @Test
    public void testCarsListFull() {
        expectedCarsList.add(new Car(2025, "Mazda", "Cx-5", "25m100", 1, 2, Progress.NOT_STARTED, 2));
        user = new User(expectedLoginID, expectedUsername, expectedIsAdmin, expectedCarsList);
        assertEquals(expectedCarsList, user.getCarsList());
    }
}
