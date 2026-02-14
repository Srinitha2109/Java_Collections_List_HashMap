package org.example.ProdList;

import java.util.Map;
import java.util.Scanner;

public class ProdMapMain {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        ProdHashMap p1 = new ProdHashMap(1, "iPhone 15", "Smartphone", "Apple", 80000, 10.0f, 4.8f);
        ProdHashMap p2 = new ProdHashMap(2, "One Plus", "Headphones", "Sony", 29999, 8.0f, 4.9f);
        ProdHashMap p3 = new ProdHashMap(3, "Dell Inspiron 15", "Laptop", "Dell", 55999, 18.0f, 4.3f);
        ProdHashMap p4 = new ProdHashMap(4, "Boat Airdopes 141", "Earbuds", "Boat", 1299, 25.0f, 4.2f);
        ProdHashMap p5 = new ProdHashMap(5, "Samsung Smart TV 43", "Television", "Samsung", 39999, 22.0f, 4.6f);

        ProdHashMap.addProductMap(p1);
        ProdHashMap.addProductMap(p2);
        ProdHashMap.addProductMap(p3);
        ProdHashMap.addProductMap(p4);
        ProdHashMap.addProductMap(p5);
//      Map<Integer,ProdHashMap> map= ProdHashMap.sortByBrandDescAndPidAscending();
//        System.out.println(map);
        while(true){
            System.out.println("1. Sort by cost Ascending");
            System.out.println("2. Sort by cost Descending");
            System.out.println("3. Sort by discount Ascending");
            System.out.println("4. Sort by discount Descending");
            System.out.println("5. Sort by rating Ascending");
            System.out.println("6. Sort by rating Descending");
            System.out.println("7. Filter by Name");
            System.out.println("8. Filter by Brand");
            System.out.println("9. Filter by category");
            System.out.println("10. Filter By Cost Range");
            System.out.println("11. Exit");
            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    ProdHashMap.sortByCostAsc();
                    break;
                case 2:
                    ProdHashMap.sortByCostDesc();
                    break;
                case 3:
                    ProdHashMap.sortByDiscAsc();
                    break;

                case 4:
                    ProdHashMap.sortByDiscDesc();
                    break;
                case 5:
                    ProdHashMap.sortByRatingAsc();
                    break;
                case 6:
                    ProdHashMap.sortByRatingDesc();
                    break;

                case 7 :
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    ProdHashMap.filterByName(name);
                    break;
                case 8:
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    ProdHashMap.filterByBrand(brand);
                    break;
                case 9:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    ProdHashMap.filterByCategory(category);
                    break;
                case 10:
                    System.out.println("Enter min and max cost");
                    double min = sc.nextDouble();
                    double max = sc.nextDouble();
                    ProdHashMap.filterByCostRange(min,max);
                    break;
                case 11:
                    return;
            }
        }
    }
}
