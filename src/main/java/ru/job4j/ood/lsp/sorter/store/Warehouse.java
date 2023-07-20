package ru.job4j.ood.lsp.sorter.store;

import ru.job4j.ood.lsp.sorter.food.Food;

public class Warehouse extends AbstractStore {

    @Override
    public boolean validate(Food food) {
        int percent = checkDate(food);
        return percent < 25;
    }

    @Override
    public void add(Food food) {
        super.add(food);
    }
}
