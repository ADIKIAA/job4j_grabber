package ru.job4j.ood.lsp.sorter.store;

import ru.job4j.ood.lsp.sorter.food.Food;

import java.util.List;

public interface Store {

    void add(Food food);

    void delete(Food food);

    void deleteByName(String name);

    boolean validate(Food food);

    int checkDate(Food food);

    List<Food> findByName(String name);

    List<Food> findByPrice(double price);

    List<Food> findAll();

}
