package org.example.List;

public class Main {
    public static void main(String[] args) {

        Phone p1 = new Phone(1, "iphone17", "apple", 80000,"01-09-2024");
        Phone p2 = new Phone(2, "galaxys23", "samsung", 75000,"02-10-2025");
        Phone p3 = new Phone(3, "note12", "realme", 20000,"10-09-2024");
        Phone p4 = new Phone(4, "google pixel", "google", 50000,"15-11-2026");


        Phone.addPhone(p1);
        Phone.addPhone(p2);
        Phone.addPhone(p3);
        Phone.addPhone(p4);
//        Phone.sortByNameAscending();
        Phone.sortByNameAsceAny();
//        Phone.sortByCost();
//        Phone.sortByPurchasedDateAscInt();
//        Phone.sortByCostDesc();
//        Phone.sortByName();
//        Phone.removePhoneById(2);

        Phone.displayPhones();


    }
}
