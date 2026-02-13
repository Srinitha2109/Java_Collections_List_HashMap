package org.example.Hashmap;

public class Main {
    public static void main(String args[]){
        Phone p1=new Phone(1,"20-10-2025",75000,"Samsung","galaxys23");
        Phone p2 = new Phone(2, "15-06-2026", 80000, "Apple", "iphone16");
        Phone p3 = new Phone(3, "21-09-2025", 120000, "Apple", "iphone17");
        Phone p4 = new Phone(4,"12-10-2023",10000,"Realme","note12");

        Phone.addPhone(p1);
        Phone.addPhone(p2);
        Phone.addPhone(p3);
        Phone.addPhone(p4);
//        Phone.sortByPurchasedDateAscInt();
//        Phone.sortByNameAny();
        Phone.sortByNameLambda();
//        Phone.removePhoneById(3);
//        Phone.sortByName();
//        Phone.sortByCostDesc();
//        Phone.displayPhones();
    }
}
