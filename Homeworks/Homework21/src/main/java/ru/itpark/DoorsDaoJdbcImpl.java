package ru.itpark;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoorsDaoJdbcImpl implements DoorsDao {

    Connection connection;
    PreparedStatement findAll;
    PreparedStatement findOneByName;
    PreparedStatement findAllByPrice;
    PreparedStatement find;
    PreparedStatement save;
    PreparedStatement update;
    PreparedStatement delete;

    public DoorsDaoJdbcImpl(DataSource dataSource){

        try {
            connection = dataSource.getConnection();
            findAll = connection.prepareStatement("SELECT * FROM owner"); //Название таблицы
            findAllByPrice = connection.prepareStatement("SELECT * FROM owner WHERE price=?");
            findOneByName = connection.prepareStatement("SELECT * FROM owner WHERE name=?");
            find = connection.prepareStatement("SELECT * FROM owner WHERE id=?");
            save = connection.prepareStatement("INSERT INTO owner(price, name) VALUES (?, ?)");
            update = connection.prepareStatement("UPDATE owner SET price=?, name=?, WHERE id=?");
            delete = connection.prepareStatement("DELETE FROM owner WHERE id=?");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Ошибка создания JdbcImpl");
        }

    }

    private Door createDoor(ResultSet resultSet) {
        try {
            return Door.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .price(resultSet.getInt("price"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Ошибка создания юзверя");
        }
    }

    @Override
    public List<Door> findAllByPrice(int price) {
        List<Door> list = new ArrayList<>();
        try {
            findAllByPrice.setInt(1, price);
            ResultSet resultSet = findAllByPrice.executeQuery();
            while (resultSet.next()) {
                list.add(createDoor(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find All exception");
        }
        return list;
    }

    @Override
    public Door findOneByName(String name) {
        try {
            findOneByName.setString(1, name);
            ResultSet resultSet = findOneByName.executeQuery();
            if (resultSet.next()) {
                return createDoor(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find by one err");
        }
        return null;
    }

    @Override
    public void save(Door model) {
        try {
            if (model.getId() == null) {
                save.setInt(1, model.getPrice());
                save.setString(2, model.getName());
                save.executeUpdate();
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("save err");
        }
    }

    @Override
    public Door find(Long id) {
        try {
            find.setLong(1, id);
            ResultSet resultSet = find.executeQuery();
            if (resultSet.next()) {
                return createDoor(resultSet);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find by one err");
        }
        return null;
    }

    @Override
    public void update(Door model) {
        try {
            update.setInt(1, model.getPrice());
            update.setString(2, model.getName());
            update.setLong(3, model.getId());
            update.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("update err");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            delete.setLong(1,id);
            delete.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("delete err");
        }
    }

    @Override
    public List<Door> findAll() {
        List<Door> list = new ArrayList<>();
        try {
            ResultSet resultSet = findAll.executeQuery();
            while (resultSet.next()) {
                list.add(createDoor(resultSet));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("find All exception");
        }
        return list;
    }
}
