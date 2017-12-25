package ru.itpark;

import java.util.List;

public interface DoorDao extends CrudDao<Door> {

    List<Door> findAllByPrice(int price);
    Door findOneByModel(String model);
    void deleteByObject(Door door);
}
