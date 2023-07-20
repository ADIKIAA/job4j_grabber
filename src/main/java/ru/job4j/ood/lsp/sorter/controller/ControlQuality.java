package ru.job4j.ood.lsp.sorter.controller;

import ru.job4j.ood.lsp.sorter.food.Food;
import ru.job4j.ood.lsp.sorter.store.Shop;
import ru.job4j.ood.lsp.sorter.store.Store;
import ru.job4j.ood.lsp.sorter.store.Trash;
import ru.job4j.ood.lsp.sorter.store.Warehouse;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void sort(Food food) {
        stores.stream()
                .filter((s) -> s.validate(food))
                .findFirst()
                .get()
                .add(food);
    }

    public static void main(String[] args) {
        List<Store> s = new ArrayList<>();
        s.add(new Trash());
        s.add(new Shop());
        s.add(new Warehouse());
        System.out.println(s.size());
        ControlQuality cq = new ControlQuality(s);
        Food milk = new Food("milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
                );
        System.out.println(milk);
        cq.sort(milk);
    }

}
