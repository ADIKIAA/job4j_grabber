package ru.job4j.ood.lsp.sorter.store;

import ru.job4j.ood.lsp.sorter.food.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractStore implements Store {

    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public void delete(Food food) {
        store.remove(food);
    }

    @Override
    public void deleteByName(String name) {
        store.remove(findByName(name).get(0));
    }

    @Override
    public int checkDate(Food food) {
        return (int) (((double) ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now())
                / (double) ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate())) * 100);
    }

    @Override
    public List<Food> findByName(String name) {
        return store.stream().filter((e) -> e.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Food> findByPrice(double price) {
        return store.stream().filter((e) -> e.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public List<Food> findAll() {
        return store;
    }
}
