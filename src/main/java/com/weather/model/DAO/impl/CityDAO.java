package com.weather.model.DAO.impl;

import com.weather.model.DAO.entities.ICityDAO;
import com.weather.model.DTO.City;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(City city) {

        String sql = "INSERT INTO CITY (ID, NAME, LATITUDE, LONGITUDE, COUNTRY_CODE) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, city.getId());
            preparedStatement.setString(2, city.getName());
            preparedStatement.setDouble(3, city.getLongitude());
            preparedStatement.setDouble(4, city.getLatitude());
            preparedStatement.setString(5, city.getCountryCode());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<City> findAll() {
        String sql = "SELECT * FROM CITY";

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            List<City> cityList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City newCity = new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5));
                cityList.add(newCity);
            }

            resultSet.close();
            preparedStatement.close();
            return cityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<City> getCitiesTop1000() {
        String sql = "SELECT * FROM CITY LIMIT 1000";

        try (Connection conn = dataSource.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            List<City> cityList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                City newCity = new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5));
                cityList.add(newCity);
            }

            resultSet.close();
            preparedStatement.close();
            return cityList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
