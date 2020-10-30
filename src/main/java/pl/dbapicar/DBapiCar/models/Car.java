package pl.dbapicar.DBapiCar.models;

import java.sql.Date;

public class Car {

    private int id;
    private String brand;
    private String color;
    private Date dateCol;

    public Car() {
    }

    public Car(int id, String brand, String color, Date date) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.dateCol = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return dateCol;
    }

    public void setDate(Date date) {
        this.dateCol = date;
    }
}
