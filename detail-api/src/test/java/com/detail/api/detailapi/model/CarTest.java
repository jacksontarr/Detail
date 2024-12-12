package com.detail.api.detailapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.detail.api.detailapi.model.Car.Progress;

@Tag("model-tier")
public class CarTest {
    private int expectedYear;
    private String expectedMake;
    private String expectedModel;
    private String expectedStockNumber;
    private int expectedSoldBy;
    private int expectedSoldTo;
    private Progress expectedProgress;
    private int expectedNumDetailers;
    private Car car;

    @BeforeEach
    public void setupCar() {
        expectedYear = 2024;
        expectedMake = "Ford";
        expectedModel = "Mustang Dark Horse";
        expectedStockNumber = "24P632";
        expectedSoldBy = 1;
        expectedSoldTo = 2;
        expectedProgress = Progress.NOT_STARTED;
        expectedNumDetailers = 2;
        car = new Car(expectedYear, expectedMake, expectedModel, expectedStockNumber, expectedSoldBy, expectedSoldTo, expectedProgress, expectedNumDetailers);
    }

    @Test
    public void testYear() {
        assertEquals(expectedYear, car.getYear());
    }

    @Test
    public void testMake() {
        assertEquals(expectedMake, car.getMake());
    }

    @Test
    public void testModel() {
        assertEquals(expectedModel, car.getModel());
    }

    @Test
    public void testStockNumber() {
        assertEquals(expectedStockNumber, car.getStockNumber());
    }

    @Test
    public void testSoldBy() {
        assertEquals(expectedSoldBy, car.getSoldBy());
    }

    @Test
    public void testSoldTo() {
        assertEquals(expectedSoldTo, car.getSoldTo());
    }

    @Test
    public void testProgress() {
        assertEquals(expectedProgress, car.getProgress());
    }

    @Test
    public void testNumDetailers() {
        assertEquals(expectedNumDetailers, car.getNumDetailers());
    }
}
