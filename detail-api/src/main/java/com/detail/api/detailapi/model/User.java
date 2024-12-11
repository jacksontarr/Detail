package com.detail.api.detailapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("loginID") int loginID;
    @JsonProperty("username") String username;
    @JsonProperty("isAdmin") boolean isAdmin;
    @JsonProperty("carsList") ArrayList<Car> carsList;

    public User(@JsonProperty("loginID") int loginID,
                @JsonProperty("username") String username,
                @JsonProperty("isAdmin") boolean isAdmin,
                @JsonProperty("carsList") ArrayList<Car> carsList) {
        this.loginID = loginID;
        this.username = username;
        this.isAdmin = isAdmin;
        if (carsList == null)
            this.carsList = new ArrayList<>();
        else
            this.carsList = carsList;
    }
    
    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public ArrayList<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(ArrayList<Car> carsList) {
        this.carsList = carsList;
    }
}
