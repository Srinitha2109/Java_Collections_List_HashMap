package org.example.productDao;

import org.example.productDbConnection.DatabaseConnection;
import org.example.phoneEntity.PhoneEntity;
import org.example.productentity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> productList = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        String sql = "select * from products";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ProductEntity prod = new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc"));
                productList.add(prod);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void addProduct(ProductEntity prod) {
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into products(pName, brand, cost, category, rating, disPerc) values(?,?,?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, prod.getpName());
            st.setString(2, prod.getBrand());
            st.setDouble(3, prod.getCost());
            st.setString(4, prod.getCategory());
            st.setFloat(5, prod.getRating());
            st.setFloat(6, prod.getDisPerc());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductById(int id) {
        String sql = "delete from products where id=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductEntity> sortByProdNameDesc() {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products order by pName desc";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> sortByCostDisc() {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products order by cost desc";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> sortByDiscDesc() {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products order by disPerc desc";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> sortByRatingDisc() {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY rating DESC";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> filterByName(String name) {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products where pName=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> filterByBrand(String brand) {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products where brand=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, brand);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> filterByCategory(String category) {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products where category=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, category);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductEntity> filterByCostRange(double minCost, double maxCost) {
        List<ProductEntity> productList = new ArrayList<>();
        String sql = "select * from products where cost between ? and ?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setDouble(1, minCost);
            st.setDouble(2, maxCost);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                productList.add(new ProductEntity(rs.getInt("id"),rs.getString("pName"),rs.getString("brand"),rs.getDouble("cost"),rs.getString("category"),rs.getFloat("rating"),rs.getFloat("disPerc")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
