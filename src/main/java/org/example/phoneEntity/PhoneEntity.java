package org.example.phoneEntity;

public class PhoneEntity {
    private int id;
    private String name;
    private String brand;
    private double cost;
    private String purchasedDate;

    public PhoneEntity(int id, String name, String brand, double cost, String purchasedDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.purchasedDate = purchasedDate;
    }

    public PhoneEntity(String name, String brand, double cost, String purchasedDate) {
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.purchasedDate = purchasedDate;
    }

    public PhoneEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                ", purchasedDate='" + purchasedDate + '\'' ;
    }
}
