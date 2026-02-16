package org.example.productJdbc;

import org.example.ProdList.ProductList;
import org.example.productDao.ProductDao;
import org.example.productDao.ProductDaoImpl;
import org.example.productDbConnection.DatabaseConnection;
import org.example.productentity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Connection con = DatabaseConnection.getConnection();
//        String sql = "create table products(id int auto_Increment primary key,pName varchar(20),brand varchar(20),cost double,category varchar(20),rating float,disPerc float)";
//        try {
//            PreparedStatement st = con.prepareStatement(sql);
//            st.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        ProductDao productDao = new ProductDaoImpl();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            try {
            System.out.println("\n1. Add Product");
            System.out.println("2. Delete Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Sort by Name in Desc order");
            System.out.println("5. Sort by Cost in Desc order");
            System.out.println("6. Sort by Rating in Desc order");
            System.out.println("7. Sort by Discount in Desc order");
            System.out.println("8. Filter by Name");
            System.out.println("9. Filter by Brand");
            System.out.println("10. Filter by Category");
            System.out.println("11. Filter by Cost Range");
            System.out.println("12. Exit");
            System.out.println("Enter choice:");
            int ch = sc.nextInt();
            sc.nextLine();
            
            switch(ch) {
                case 1:
                    System.out.println("Enter product name:");
                    String pName = sc.nextLine();
                    System.out.println("Enter brand:");
                    String brand = sc.nextLine();
                    System.out.println("Enter cost:");
                    double cost = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter category:");
                    String category = sc.nextLine();
                    System.out.println("Enter rating:");
                    float rating = sc.nextFloat();
                    System.out.println("Enter discount percentage:");
                    float disPerc = sc.nextFloat();
                    productDao.addProduct(new ProductEntity(pName, brand, cost, category, rating, disPerc));
                    break;
                case 2:
                    System.out.println("Enter ID to delete:");
                    int id = sc.nextInt();
                    if(id <= 0) {
                        System.out.println("Invalid id");
                        break;
                    }
                    productDao.deleteProductById(id);
                    break;
                case 3:
                    List<ProductEntity> allProducts = productDao.findAll();
                    if(allProducts.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        allProducts.forEach(System.out::println);
                    }
                    break;
                case 4:
                    List<ProductEntity> sortedByName = productDao.sortByProdNameDesc();
                    if(sortedByName.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        sortedByName.forEach(System.out::println);
                    }
                    break;
                case 5:
                    List<ProductEntity> sortedByCost = productDao.sortByCostDisc();
                    if(sortedByCost.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        sortedByCost.forEach(System.out::println);
                    }
                    break;
                case 6:
                    List<ProductEntity> sortedByRating = productDao.sortByRatingDisc();
                    if(sortedByRating.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        sortedByRating.forEach(System.out::println);
                    }
                    break;
                case 7:
                    List<ProductEntity> sortedByDisc = productDao.sortByDiscDesc();
                    if(sortedByDisc.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        sortedByDisc.forEach(System.out::println);
                    }
                    break;
                case 8:
                    System.out.println("Enter product name:");
                    String name = sc.nextLine();
                    List<ProductEntity> filteredByName = productDao.filterByName(name);
                    filteredByName.forEach(System.out::println);
                    break;
                case 9:
                    System.out.println("Enter brand:");
                    String brandFilter = sc.nextLine();
                    List<ProductEntity> filteredByBrand = productDao.filterByBrand(brandFilter);
                    filteredByBrand.forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("Enter category:");
                    String categoryFilter = sc.nextLine();
                    List<ProductEntity> filteredByCategory = productDao.filterByCategory(categoryFilter);
                    filteredByCategory.forEach(System.out::println);
                    break;
                case 11:
                    System.out.println("Enter min cost:");
                    double min = sc.nextDouble();
                    System.out.println("Enter max cost:");
                    double max = sc.nextDouble();
                    List<ProductEntity> filteredByRange = productDao.filterByCostRange(min, max);
                    if(filteredByRange.isEmpty()) {
                        System.out.println("No products found in cost range: " + min + " - " + max);
                    } else {
                        filteredByRange.forEach(System.out::println);
                    }
                    break;
                case 12:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
            }
        }
    }
}