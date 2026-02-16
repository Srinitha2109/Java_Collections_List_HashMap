package org.example.productDao;

import org.example.phoneEntity.PhoneEntity;
import org.example.productentity.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> findAll();
    void addProduct(ProductEntity ph);
    void deleteProductById(int id);
    List<ProductEntity> sortByProdNameDesc();
    List<ProductEntity> sortByCostDisc();
    List<ProductEntity> sortByDiscDesc();
    List<ProductEntity> sortByRatingDisc();
    List<ProductEntity> filterByName(String name);
    List<ProductEntity> filterByBrand(String brand);
    List<ProductEntity> filterByCategory(String category);
    List<ProductEntity> filterByCostRange(double minCost, double maxCost);

}
