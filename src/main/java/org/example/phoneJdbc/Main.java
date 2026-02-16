package org.example.phoneJdbc;

import org.example.phoneDao.PhoneDao;
import org.example.phoneDao.PhoneDaoImpl;
import org.example.phoneEntity.PhoneEntity;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Connection con = DatabaseConnection.getConnection();
//        String sql = "create table phones(id int  auto_Increment primary key,name varchar(20),brand varchar(20),cost double,purchaseDate varchar(20))";
//        try {
//            PreparedStatement st = con.prepareStatement(sql);
//            st.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        PhoneDao phoneDao = new PhoneDaoImpl();
        Scanner sc = new Scanner(System.in);
        while(true){

                System.out.println("1. Add Phones ");
                System.out.println("2. Delete Phone by id ");
                System.out.println("3. Retrieve the data from phones db");
                System.out.println("4. Retrieve data in descending order by name");
                System.out.println("5. Retrieve data in descending order of cost");
                System.out.println("6. Retrieve data in descending order of purchase date");
                System.out.println("7. Sort by Brand Desc");
                System.out.println("8. Filter by Brand");
                System.out.println("9. Filter by Name");
                System.out.println("10. Exit");
                System.out.println("Enter Your Choice");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch){
                    case 1:
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter brand:");
                        String brand = sc.nextLine();
                        System.out.println("Enter cost:");
                        double cost = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter purchase date:");
                        String date = sc.nextLine();
                        phoneDao.addPhone(new PhoneEntity(name, brand, cost, date));
                        break;
                    case 2:
                        System.out.println("Enter id to delete:");
                        int id = sc.nextInt();
                        if(id <= 0) {
                            System.out.println("Invalid id");
                            break;
                        }
                        phoneDao.deletePhoneById(id);
                        break;
                    case 3:
                        List<PhoneEntity> phoneList = phoneDao.findAll();
                        if(phoneList.isEmpty()) {
                            System.out.println("No phones found");
                        } else {
                            phoneList.forEach(System.out::println);
                        }
                        break;
                    case 4:
                        List<PhoneEntity> sortedByName = phoneDao.sortByNameDesc();
                        if(sortedByName.isEmpty()) {
                            System.out.println("No phones found");
                        } else {
                            sortedByName.forEach(System.out::println);
                        }
                        break;
                    case 5:
                        List<PhoneEntity> sortedByCost = phoneDao.sortByCostDesc();
                        if(sortedByCost.isEmpty()) {
                            System.out.println("No phones found");
                        } else {
                            sortedByCost.forEach(System.out::println);
                        }
                        break;
                    case 6:
                        List<PhoneEntity> sortedByDate = phoneDao.sortByPurchasedDate();
                        if(sortedByDate.isEmpty()) {
                            System.out.println("No phones found");
                        } else {
                            sortedByDate.forEach(System.out::println);
                        }
                        break;
                    case 7:
                        List<PhoneEntity> sortedByBrand = phoneDao.sortByBrandDesc();
                        if(sortedByBrand.isEmpty()) {
                            System.out.println("No phones found");
                        } else {
                            sortedByBrand.forEach(System.out::println);
                        }
                        break;
                    case 8:
                        System.out.println("Enter brand:");
                        String brandFilter = sc.nextLine();
                        List<PhoneEntity> filteredByBrand = phoneDao.filterByBrand(brandFilter);
                        filteredByBrand.forEach(System.out::println);
                        break;
                    case 9:
                        System.out.println("Enter name:");
                        String nameFilter = sc.nextLine();
                        List<PhoneEntity> filteredByName = phoneDao.filterByName(nameFilter);
                        filteredByName.forEach(System.out::println);
                        break;
                    case 10:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("invalid choice");

            }
        }
    }
}
