package org.example.ProdList;

import org.example.List.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductList {
    private int pid;
    private String pName;
    private double cost;
    private String brand;
    private String category;
    private float rating;
    private float disPerc;

    public ProductList(int pid,String pName,  String category, String brand, double cost,float disPerc, float rating) {
        this.pid = pid;
        this.pName = pName;
        this.category = category;
        this.brand = brand;
        this.cost = cost;
        this.disPerc = disPerc;
        this.rating = rating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
        return " pid=" + pid +
                ", pName='" + pName + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                ", disPerc=" + disPerc  +
                ", rating=" + rating;
    }

    private static List<ProductList> productList = new ArrayList<>();

    public static void addProduct(ProductList prodList){
       productList.add(prodList);
    }

    public static void getproductList() {
        for (ProductList p : productList) {
            System.out.println(p);
        }
    }

    public static void sortByCostAsc() {
        Collections.sort(productList, (p1, p2) -> {
            return Double.compare(p1.getCost(), p2.getCost());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }

    public static void sortByCostDesc(){
        Collections.sort(productList,(p1,p2)->{
            return Double.compare(p2.getCost(),p1.getCost());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }

    public static void sortByDiscAsc(){
        Collections.sort(productList,(p1,p2)->{
            return Double.compare(p1.getDisPerc(),p2.getDisPerc());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }

    public static void sortByDiscDesc(){
        Collections.sort(productList,(p1,p2)->{
            return Double.compare(p2.getDisPerc(),p1.getDisPerc());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }

    public static void sortByRatingAsc(){
        Collections.sort(productList,(p1,p2)->{
            return Double.compare(p1.getRating(),p2.getRating());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }

    public static void sortByRatingDesc(){
        Collections.sort(productList,(p1,p2)->{
            return Double.compare(p2.getRating(),p1.getRating());
        });
        for(ProductList p:productList){
            System.out.println(p);
        }
    }
    public static void filterByName(String pname){
        for(ProductList p:productList){
            if(pname.equals(p.getpName())) {
                System.out.println(p);
            }
        }
    }

    public static void filterByBrand(String brand){
        for(ProductList p:productList){
            if(brand.equals(p.getBrand())) {
                System.out.println(p);
            }
        }
    }

    public static void filterByCategory(String category){
        for(ProductList p:productList){
            if(category.equals(p.getCategory())) {
                System.out.println(p);
            }
        }
    }
    public static void filterByCostRange(double minCost,double maxCost){
        for(ProductList p:productList){
            if(p.getCost()>=minCost && p.getCost()<=maxCost){
                System.out.println(p);
            }
        }
    }
}
