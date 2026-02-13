package org.example.Hashmap;

import java.sql.SQLOutput;
import java.util.*;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private double cost;
    private String purchasedDate;

    public double getCost() {return cost;}

    public void setCost(double cost) { this.cost = cost; }

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand;}

    public void setBrand(String brand) { this.brand = brand; }

    public String getPurchasedDate() {return purchasedDate;}

    public void setPurchasedDate(String purchasedDate) { this.purchasedDate = purchasedDate;}

    public Phone(int id, String purchasedDate, double cost, String brand, String name) {
        this.id = id;
        this.purchasedDate = purchasedDate;
        this.cost = cost;
        this.brand = brand;
        this.name = name;
    }

    private static Map<Integer, Phone> phoneMap = new HashMap<>();

    public static void addPhone(Phone phone) {
        phoneMap.put(phone.getId(), phone);
    }

    public static void removePhoneById(int id) {
        phoneMap.remove(id);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", cost=" + cost +
                ", purchasedDate='" + purchasedDate + '\'' +
                '}';
    }

    public static void displayPhones() {
        for(Map.Entry<Integer,Phone> e: phoneMap.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
    public static void sortByCostDesc() {
        List<Phone> phoneList = new ArrayList<>(phoneMap.values());
//        Collections.sort(phoneList, Comparator.comparing(Phone::getCost));
        Collections.sort(phoneList,(p1,p2)->Double.compare(p2.getCost(),p1.getCost()));
        for (Phone p : phoneList) {
            System.out.println("ID: " + p.getId() + " - " + p);
        }
    }

    //using local class
    public static void sortByName(){
        List<Phone> phoneList = new ArrayList<>(phoneMap.values());
        Collections.sort(phoneList,new SortByName());
        for (Phone p : phoneList) {
            System.out.println("ID: " + p.getId() + " - " + p);
        }
    }

    //using anonymous class
    public static void sortByNameAny(){
        List<Phone> phoneList=new ArrayList<>(phoneMap.values());
        Collections.sort(phoneList, new Comparator<Phone>() {
            public int compare(Phone p1,Phone p2){
                return p1.getName().compareTo(p2.getName());
            }
        });
        for(Phone p:phoneList){
            System.out.println("ID: " + p.getId() + " - " + p);
        }
    }

    //using lambda expression
    public static void sortByNameLambda(){
        List<Phone> phoneList=new ArrayList<>(phoneMap.values());
        Collections.sort(phoneList,( p1, p2)->{
            return p1.getName().compareTo(p2.getName());
        });
        for(Phone p:phoneList){
            System.out.println("Id: "+ p.getId()+"-"+p);
        }
    }

    public static void sortByPurchasedDateAscInt() {
        List<Phone> phoneList = new ArrayList<>(phoneMap.values());
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
        for(Phone p:phoneList){
            System.out.println("ID: " + p.getId() + " - " + p);
        }
    }

}
