package org.example.phoneDao;

import org.example.phoneEntity.PhoneEntity;

import java.util.List;

public interface PhoneDao {
    List<PhoneEntity> findAll();
    void addPhone(PhoneEntity ph);
    void deletePhoneById(int id);
    List<PhoneEntity> sortByNameDesc();
    List<PhoneEntity> sortByCostDesc();
    List<PhoneEntity> sortByPurchasedDate();
    List<PhoneEntity> sortByBrandDesc();
    List<PhoneEntity> filterByBrand(String brand);
    List<PhoneEntity> filterByName(String name);
}
