package ru.job4j.ood.lsp.sorter.controller;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.sorter.food.Food;
import ru.job4j.ood.lsp.sorter.store.Shop;
import ru.job4j.ood.lsp.sorter.store.Store;
import ru.job4j.ood.lsp.sorter.store.Trash;
import ru.job4j.ood.lsp.sorter.store.Warehouse;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ControlQualityTest {

    @Test
    void addOneFoodInEachStore() {
        Store shop = new Shop();
        Store wareHouse = new Warehouse();
        Store trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        stores.add(wareHouse);
        stores.add(trash);
        ControlQuality cq = new ControlQuality(stores);
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(2, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                135.8,
                23
        );
        Food bread = new Food(
                "bread",
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                56.4,
                0
        );
        Food cheese = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                200.0,
                10
        );
        cq.sort(milk);
        cq.sort(bread);
        cq.sort(cheese);
        assertThat(shop.findAll()).contains(cheese);
        assertThat(wareHouse.findAll()).contains(milk);
        assertThat(trash.findAll()).contains(bread);
    }

    @Test
    void addTwoFoodInTrash() {
        Store shop = new Shop();
        Store trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(shop);
        stores.add(trash);
        ControlQuality cq = new ControlQuality(stores);
        Food milk = new Food(
                "milk",
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                135.8,
                23
        );
        Food bread = new Food(
                "bread",
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                56.4,
                0
        );
        cq.sort(milk);
        cq.sort(bread);
        assertThat(trash.findAll()).contains(milk, bread);
    }

    @Test
    void firstThreeFoodsLocateInWarehouseThenResortAndOneFoodInEachStore() {
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(2, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                135.8,
                23
        );
        Food bread = new Food(
                "bread",
                LocalDate.now().minus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                56.4,
                0
        );
        Food cheese = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                200.0,
                10
        );
        Store shop = new Shop();
        Store wareHouse = new Warehouse();
        Store trash = new Trash();
        List<Store> stores = new ArrayList<>();
        wareHouse.add(milk);
        wareHouse.add(bread);
        wareHouse.add(cheese);
        stores.add(shop);
        stores.add(wareHouse);
        stores.add(trash);
        ControlQuality cq = new ControlQuality(stores);
        cq.resort();
        assertThat(shop.findAll()).contains(cheese);
        assertThat(wareHouse.findAll()).contains(milk);
        assertThat(trash.findAll()).contains(bread);
    }

}