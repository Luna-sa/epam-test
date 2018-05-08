package com.lunasa.flowerstore.services;

import com.lunasa.flowerstore.exceptions.DatabaseException;
import com.lunasa.flowerstore.models.Bouquet;
import com.lunasa.flowerstore.models.BouquetData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBouquetService implements BouquetService {

    @Override
    public List<Bouquet> getAllBouquets() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        }
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM bouquets");
            List<Bouquet> bouquets = new ArrayList<>();
            while (rs.next()) {
                BouquetData data = new BouquetData();
                data.setFlowerId(rs.getString("flowerId"));
                data.setName(rs.getString("name"));
                data.setType(rs.getString("type"));
                data.setDescription(rs.getString("description"));
                data.setFlowerCount(rs.getInt("flowerCount"));
                data.setPricePerFlowerUah(rs.getInt("pricePerFlowerUah"));
                data.setImageUrl(rs.getString("imageUrl"));
                data.setClosedFlowerCount(rs.getInt("closedFlowerCount"));
                data.setRoseLength(rs.getString("roseLength"));
                Bouquet bouquet = data.convertToBouquet();
                bouquets.add(bouquet);
            }
            return bouquets;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        } finally {
            if (rs != null) {
                try { rs.close(); } catch(SQLException e) { e.printStackTrace(); }
            }
            if (st != null) {
                try { st.close(); } catch(SQLException e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) { e.printStackTrace(); }
            }
        }
    }
}
