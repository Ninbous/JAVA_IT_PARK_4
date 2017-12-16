package ru.itpark;

import java.util.List;

public interface DoorsDao extends CrudDao<Door> {
    List<Door> findAllByPrice(int price);
    Door findOneByName(String name);
}