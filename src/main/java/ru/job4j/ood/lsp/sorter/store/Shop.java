package ru.job4j.ood.lsp.sorter.store;

import ru.job4j.ood.lsp.sorter.food.Food;

public class Shop extends AbstractStore {

    @Override
    public boolean validate(Food food) {
        int percent = checkDate(food);
        return percent >= 25 && percent < 100;
    }

    @Override
    public void add(Food food) {
        int i = checkDate(food);
        if (checkDate(food) > 75) {
            food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100);
        }
        super.add(food);
    }

}
