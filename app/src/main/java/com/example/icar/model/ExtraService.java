package com.example.icar.model;

public class ExtraService {
    public String extraServiceName;
    public int price;

    public ExtraService() {
    }

    public ExtraService(String extraServiceName, int price) {
        this.extraServiceName = extraServiceName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExtraService{" +
                "extraServiceName='" + extraServiceName + '\'' +
                ", price=" + price +
                '}';
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
