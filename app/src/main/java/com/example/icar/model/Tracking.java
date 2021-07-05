package com.example.icar.model;

public class Tracking {
    public String bookingKey;
    public String driverId;
    public String date;
    public String location;
    public boolean isFinished;

    public Tracking() {
    }

    public Tracking(String bookingKey, String driverId, String date, String location, boolean isFinished) {
        this.bookingKey = bookingKey;
        this.driverId = driverId;
        this.date = date;
        this.location = location;
        this.isFinished = isFinished;
    }
}
