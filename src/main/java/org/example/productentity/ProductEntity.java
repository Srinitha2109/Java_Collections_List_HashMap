package org.example.productentity;

public class ProductEntity {
    private int pid;
    private String pName;
    private double cost;
    private String brand;
    private String category;
    private float rating;
    private float disPerc;

    public ProductEntity(int pid, String pName, String brand, double cost, String category,float disPerc, float rating) {
        this.pid = pid;
        this.pName = pName;
        this.brand = brand;
        this.cost = cost;
        this.category = category;
        this.disPerc = disPerc;
        this.rating = rating;
    }

    public ProductEntity( String pName, String brand, double cost, String category,float disPerc, float rating) {
        this.pName = pName;
        this.brand = brand;
        this.cost = cost;
        this.category = category;
        this.disPerc = disPerc;
        this.rating = rating;

    }

    public ProductEntity() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getDisPerc() {
        return disPerc;
    }



    public void setDisPerc(float disPerc) {
        this.disPerc = disPerc;
    }

    @Override
    public String toString() {
        return
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", disPerc=" + disPerc;
    }


}
