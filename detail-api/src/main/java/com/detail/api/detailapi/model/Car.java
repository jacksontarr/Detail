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

    @JsonProperty("make") String make;
    @JsonProperty("model") String model;
    @JsonProperty("stockNumber") String stockNumber;
    @JsonProperty("soldBy") int soldBy;
    @JsonProperty("soldTo") int soldTo;
    @JsonProperty("progress") Progress progress;
    @JsonProperty("numDetailers") int numDetailers;

    public Car(@JsonProperty("make") String make,
               @JsonProperty("model") String model,
               @JsonProperty("stockNumber") String stockNumber,
               @JsonProperty("soldBy") int soldBy,
               @JsonProperty("soldTo") int soldTo,
               @JsonProperty("progress") Progress progress,
               @JsonProperty("numDetailers") int numDetailers) {
        this.make = make;
        this.model = model;
        this.stockNumber = stockNumber;
        this.soldBy = soldBy;
        this.soldTo = soldTo;
        this.progress = progress;
        this.numDetailers = numDetailers;
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
}
