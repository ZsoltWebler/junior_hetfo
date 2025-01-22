package java_database.repository;

import java_database.Database;
import java_database.model.PokemonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    private final Connection connection = new Database().getConnection();

    public List<PokemonDao> getAll() {

        String sql = "SELECT * FROM Pokemon";
        List<PokemonDao> pokemon = new ArrayList<>();

        try {
            var preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                pokemon.add(getPokemonFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pokemon;
    }

    public PokemonDao getById(int id) {
        String sql = "SELECT * FROM Pokemon where pokemon.pokemon_id = ?";

        try {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                return getPokemonFromResultSet(resultSet);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public void save(PokemonDao pokemon) {
        String sql = "INSERT INTO Pokemon (pokemon_name, pokemon_type, pokemon_hp, " +
                "pokemon_attack, pokemon_defense, pokemon_speed, pokemon_legendary) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pokemon.getName());
            preparedStatement.setString(2, pokemon.getType());
            preparedStatement.setInt(3, pokemon.getHp());
            preparedStatement.setInt(4, pokemon.getAttack());
            preparedStatement.setInt(5, pokemon.getDefense());
            preparedStatement.setInt(6, pokemon.getSpeed());
            preparedStatement.setBoolean(7, pokemon.isLegendary());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Failed to save the Pokemon record", e);
        }
    }

    private PokemonDao getPokemonFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("pokemon_id");
        String name = resultSet.getString("pokemon_name");
        String type = resultSet.getString("pokemon_type");
        int hp = resultSet.getInt("pokemon_hp");
        int attack = resultSet.getInt("pokemon_attack");
        int defense = resultSet.getInt("pokemon_defense");
        int speed = resultSet.getInt("pokemon_speed");
        boolean legendary = resultSet.getBoolean("pokemon_legendary");

        return new PokemonDao(id, name, type, hp, attack, defense, speed, legendary);
    }

}
