package org.example.List;

import java.util.*;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private double cost;
    private String purchasedDate;

    private static List<Phone> phoneList = new ArrayList<>();

    public Phone(int id, String name, String brand, double cost,String purchasedDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.purchasedDate=purchasedDate;
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

    public static void addPhone(Phone phone) {
        phoneList.add(phone);
    }

    public static void sortByPurchasedDateAscInt() {
        Collections.sort(phoneList, (p1, p2) -> {
                String[] d1 = p1.getPurchasedDate().split("-");
                String[] d2 = p2.getPurchasedDate().split("-");
                int day1 = Integer.parseInt(d1[0]);
                int month1 = Integer.parseInt(d1[1]);
                int year1 = Integer.parseInt(d1[2]);
                int day2 = Integer.parseInt(d2[0]);
                int month2 = Integer.parseInt(d2[1]);
                int year2 = Integer.parseInt(d2[2]);


                if (year1 != year2)
                    return year1 - year2;

                if (month1 != month2)
                    return month1 - month2;
                return day1 - day2;
        });
    }

    //iterator
    public static void removePhoneById(int id){
        Iterator<Phone> it = phoneList.iterator();
        while(it.hasNext()){
            Phone p = it.next();
            if(p.getId()==id){
                it.remove();
            }
        }
    }

    //local class
    public static void sortByNameAscending(){
        Collections.sort(phoneList,new sortByNameAsc());
    }

    public static void displayPhones() {
        for (Phone p : phoneList) {
            System.out.println(p);
        }
    }
    //anonymous class
    public static void sortByNameAsceAny(){
        Collections.sort(phoneList, new Comparator<Phone>() {
            public int compare(Phone p1, Phone p2) {
               return p1.getName().compareToIgnoreCase(p2.getName());
            }
        });
    }

    //lambda expression
    public static void sortByCostDesc() {
        Collections.sort(phoneList, (p1, p2) -> {
            return Double.compare(p2.getCost(), p1.getCost());
        });
    }

    //comparing method
    public static  void sortByCost(){
        Collections.sort(phoneList,Comparator.comparing(Phone::getCost));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + brand + " " + cost + " " + purchasedDate;
    }
}
