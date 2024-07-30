package databases.cars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarDao implements Dao<Car> {

    private final Connection connection;

    public CarDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Optional<Car> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Car> getAll() {
        String sql = "SELECT * FROM Cars";

        List<Car> cars = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            while (resultSet.next()) {

                String name = resultSet.getString(1);
                int year = resultSet.getInt("carYear");
                int sellingPrice = resultSet.getInt(3);
                int kmDriven = resultSet.getInt(4);
                String fuel = resultSet.getString(5);
                String sellerType = resultSet.getString(6);
                String transmission = resultSet.getString(7);
                String owner = resultSet.getString(8);

                cars.add(new Car(name, year, sellingPrice, kmDriven, fuel, sellerType, transmission, owner));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public void save(Car car) {

        String sql = "INSERT INTO cars(carname, caryear, sellingprice, kmdriven, fuel, sellertype, transmission, carowner) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,car.getName());
            preparedStatement.setInt(2,car.getYear());
            preparedStatement.setInt(3,car.getSellingPrice());
            preparedStatement.setInt(4,car.getKmDriven());
            preparedStatement.setString(5,car.getFuel());
            preparedStatement.setString(6,car.getSellerType());
            preparedStatement.setString(7,car.getTransmission());
            preparedStatement.setString(8,car.getOwner());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Car car, String[] params) {

    }

    @Override
    public void delete(Car car) {

    }
}
