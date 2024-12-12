package com.detail.api.detailapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    public enum Progress {
        NOT_STARTED,
        GAS,
        INTERIOR,
        EXTERIOR,
        DRYING,
        COMPLETED
    }

    @JsonProperty("year") int year;
    @JsonProperty("make") String make;
    @JsonProperty("model") String model;
    @JsonProperty("stockNumber") String stockNumber;
    @JsonProperty("carID") int carID;
    @JsonProperty("soldBy") int soldBy;
    @JsonProperty("soldTo") int soldTo;
    @JsonProperty("progress") Progress progress;
    @JsonProperty("numDetailers") int numDetailers;

    public Car(@JsonProperty("year") int year,
               @JsonProperty("make") String make,
               @JsonProperty("model") String model,
               @JsonProperty("stockNumber") String stockNumber,
               @JsonProperty("soldBy") int soldBy,
               @JsonProperty("soldTo") int soldTo,
               @JsonProperty("progress") Progress progress,
               @JsonProperty("numDetailers") int numDetailers) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.stockNumber = stockNumber;
        this.carID = stockNumberToInt();
        this.soldBy = soldBy;
        this.soldTo = soldTo;
        this.progress = progress;
        this.numDetailers = numDetailers;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public int getCarID() {
        return carID;
    }

    public int getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(int soldBy) {
        this.soldBy = soldBy;
    }

    public int getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(int soldTo) {
        this.soldTo = soldTo;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public int getNumDetailers() {
        return numDetailers;
    }

    public void setNumDetailers(int numDetailers) {
        this.numDetailers = numDetailers;
    }

    public int stockNumberToInt() {
        String strID;
        char mod = stockNumber.charAt(2);

        if (Character.toLowerCase(mod) == 'm')
            strID = "1";  // Mazda --> first char 1
        else
            strID = "2";  // Ford --> first char 2
        for (int i = 0; i < stockNumber.length(); i++) {
            char c = stockNumber.charAt(i);
            if (c >= 48 && c <= 57)
                strID += c;
        }
        return Integer.parseInt(strID);
    }
}
