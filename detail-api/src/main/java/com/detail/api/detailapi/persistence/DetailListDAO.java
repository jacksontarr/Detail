package com.detail.api.detailapi.persistence;

import java.io.IOException;

import com.detail.api.detailapi.model.Car;

public interface DetailListDAO {
    Car[] getDetailList() throws IOException;

    Car[] findCar(String search) throws IOException;

    Car getCar(int stockNumber) throws IOException;

    Car createCar(Car car) throws IOException;

    Car updateCar(Car car) throws IOException;

    boolean deleteCar(int stockNumber) throws IOException;
}
