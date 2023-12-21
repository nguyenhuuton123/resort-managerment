package com.example.repository.impl;

import com.example.entity.AttachFacility;
import com.example.repository.ConnectionConfig;
import com.example.repository.IAttachFacilityDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityDao implements IAttachFacilityDao {
    private final String SELECT_ALL = "SELECT * FROM attach_facility";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    @Override
    public List<AttachFacility> findAll() {
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double cost = resultSet.getDouble("cost");
                String unit = resultSet.getString("unit");
                String status = resultSet.getString("status");
                boolean isDelete = resultSet.getBoolean("is_delete");
                attachFacilityList.add(new AttachFacility(id, name, cost, unit, status, isDelete));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        return attachFacilityList;
    }

    @Override
    public AttachFacility findById(int id) {
        return null;
    }

    @Override
    public boolean add(AttachFacility attachFacility) {
        return false;
    }

    @Override
    public boolean edit(int id, AttachFacility attachFacility) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
