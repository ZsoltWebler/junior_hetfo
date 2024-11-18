package java_database.repository;

import java_database.Database;
import java_database.model.ApartmentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentRepository {

    private final Connection connection = new Database().getConnection();

    public List<ApartmentDao> getAll() {

        String sql = "SELECT * FROM Apartment";
        List<ApartmentDao> apartments = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                apartments.add(getApartmentFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return apartments;
    }

    public ApartmentDao getById(int id) {
        String sql = "SELECT * FROM Apartment where apartment.apartment_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getApartmentFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void save(ApartmentDao apartment) {
        String sql = "INSERT INTO Apartment (apartment_city,apartment_address,apartment_area,apartment_price,apartment_reserved) VALUES (?, ?, ?,?,?)";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, apartment.getCity());
            preparedStatement.setString(2, apartment.getAddress());
            preparedStatement.setDouble(3, apartment.getArea());
            preparedStatement.setInt(4, apartment.getPrice());
            preparedStatement.setBoolean(5, apartment.isReserved());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private ApartmentDao getApartmentFromResultSet(ResultSet resultSet) throws SQLException {

        int apartmentId = resultSet.getInt("apartment_id");
        String city = resultSet.getString("apartment_city");
        String address = resultSet.getString("apartment_address");
        double area = resultSet.getDouble("apartment_area");
        int price = resultSet.getInt("apartment_price");
        boolean reserved = resultSet.getBoolean("apartment_reserved");


        return new ApartmentDao(apartmentId, city, address, area, price, reserved);
    }

}
