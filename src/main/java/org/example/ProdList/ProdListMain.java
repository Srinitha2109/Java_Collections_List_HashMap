package org.example.ProdList;

import java.util.Scanner;

public class ProdListMain {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        ProductList p1 = new ProductList(1, "iPhone 15", "Smartphone", "Apple", 80000, 10.0f, 4.8f);
        ProductList p2 = new ProductList(2, "One Plus", "Headphones", "Sony", 29999, 8.0f, 4.9f);
        ProductList p3 = new ProductList(3, "Dell Inspiron 15", "Laptop", "Dell", 55999, 18.0f, 4.3f);
        ProductList p4 = new ProductList(4, "Boat Airdopes 141", "Earbuds", "Boat", 1299, 25.0f, 4.2f);
        ProductList p5 = new ProductList(5, "Samsung Smart TV 43", "Television", "Samsung", 39999, 22.0f, 4.6f);

        ProductList.addProduct(p1);
        ProductList.addProduct(p2);
        ProductList.addProduct(p3);
        ProductList.addProduct(p4);
        ProductList.addProduct(p5);
//        ProductList.filterByName("One Plus");
//        ProductList.filterByBrand("Samsung");
        ProductList.filterByCategory("Smartphone");
//        ProductList.sortByCostAsc();
//        ProductList.sortByCostDesc();
//        ProductList.sortByDiscAsc();
//        ProductList.sortByDiscDesc();
//        ProductList.sortByRatingAsc();
//        ProductList.sortByRatingDesc();
//        ProductList.getproductList();
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
                    ProductList.sortByCostAsc();
                    break;
                case 2:
                    ProductList.sortByCostDesc();
                    break;
                case 3:
                    ProductList.sortByDiscAsc();
                    break;

                case 4:
                    ProductList.sortByDiscAsc();
                    break;
                case 5:
                    ProductList.sortByRatingAsc();
                    break;
                case 6:
                    ProductList.sortByRatingAsc();
                    break;

                case 7 :
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        ProductList.filterByName(name);
                        break;
                case 8:
                    System.out.print("Enter brand: ");
                    String brand = sc.nextLine();
                    ProductList.filterByBrand(brand);
                    break;
                case 9:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    ProductList.filterByCategory(category);
                    break;
                case 10:
                    System.out.println("Enter min and max cost");
                    double min = sc.nextDouble();
                    double max = sc.nextDouble();
                    ProductList.filterByCostRange(min,max);
                case 11:
                    return;
            }


            }


    }

}
