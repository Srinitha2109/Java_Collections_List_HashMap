package org.example.phoneDao;
import org.example.phoneDbConnection.DatabaseConnection;
import org.example.phoneEntity.PhoneEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {
    @Override
    public List<PhoneEntity> findAll() {
        List<PhoneEntity> phoneList = new ArrayList<>();
        String sql = "select * from phones";
        try (Connection con = DatabaseConnection.getConnection();) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PhoneEntity ph = new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate"));
                phoneList.add(ph);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneList;
    }

    @Override
    public void addPhone(PhoneEntity ph) {
        Connection con = DatabaseConnection.getConnection();
        String sql = "insert into phones(name, brand, cost, purchaseDate) values(?,?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, ph.getName());
            st.setString(2, ph.getBrand());
            st.setDouble(3, ph.getCost());
            st.setString(4, ph.getPurchasedDate());
            int rowsAffected = st.executeUpdate();
            System.out.println("rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePhoneById(int id) {
        String sql = "delete from phones where id=?";
        try (Connection con = DatabaseConnection.getConnection();) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            int rowsAffected = st.executeUpdate();
            System.out.println("deleted row with id :" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhoneEntity> sortByNameDesc() {
        List<PhoneEntity> sortedList = new ArrayList<>();
        String sql = "select * from phones order by name desc";
        Connection con = DatabaseConnection.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PhoneEntity ph = new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate"));
                sortedList.add(ph);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sortedList;
    }

    @Override
    public List<PhoneEntity> sortByCostDesc() {
        List<PhoneEntity> sortedList = new ArrayList<>();
        String sql = "select * from phones order by cost desc";
        Connection con = DatabaseConnection.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PhoneEntity ph = new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate"));
                sortedList.add(ph);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sortedList;
    }

    @Override
    public java.util.List<PhoneEntity> sortByPurchasedDate() {
        List<PhoneEntity> sortedList = new ArrayList<>();
        String sql = "select * from phones order by purchaseDate desc";
        Connection con = DatabaseConnection.getConnection();
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PhoneEntity ph = new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate"));
                sortedList.add(ph);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sortedList;
    }

    @Override
    public List<PhoneEntity> sortByBrandDesc() {
        List<PhoneEntity> sortedList = new ArrayList<>();
        String sql = "select * from phones order by brand desc";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                sortedList.add(new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sortedList;
    }

    @Override
    public List<PhoneEntity> filterByBrand(String brand) {
        List<PhoneEntity> phoneList = new ArrayList<>();
        String sql = "select * from phones where brand=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, brand);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                phoneList.add(new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneList;
    }

    @Override
    public List<PhoneEntity> filterByName(String name) {
        List<PhoneEntity> phoneList = new ArrayList<>();
        String sql = "select * from phones where name=?";
        try (Connection con = DatabaseConnection.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                phoneList.add(new PhoneEntity(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getDouble("cost"), rs.getString("purchaseDate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneList;
    }
}
