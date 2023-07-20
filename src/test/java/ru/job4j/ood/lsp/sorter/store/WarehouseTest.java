package ru.job4j.ood.lsp.sorter.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.sorter.food.Food;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class WarehouseTest {

    @Test
    void addFoodThenFindByName() {
        Store warehouse = new Warehouse();
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
        );
        warehouse.add(milk);
        List<Food> expected = new ArrayList<>();
        expected.add(milk);
        assertThat(warehouse.findByName("milk")).isEqualTo(expected);
    }

    @Test
    void addThreeFoodThenDeleteByNameOne() {
        Store warehouse = new Warehouse();
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
        );
        Food bread = new Food(
                "bread",
                LocalDate.now().plus(1, ChronoUnit.WEEKS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                56.4,
                0
        );
        Food cheese = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                201.45,
                15
        );
        warehouse.add(milk);
        warehouse.add(bread);
        warehouse.add(cheese);
        warehouse.deleteByName("bread");
        assertThat(warehouse.findByName("bread")).doesNotContain(bread).hasSize(0);
    }

    @Test
    void addThreeFoodThenDeleteOneAndDeleteByNameThenFindByName() {
        Store warehouse = new Warehouse();
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
        );
        Food bread = new Food(
                "bread",
                LocalDate.now().plus(1, ChronoUnit.WEEKS),
                LocalDate.now().minus(1, ChronoUnit.WEEKS),
                56.4,
                0
        );
        Food cheese = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                201.45,
                15
        );
        warehouse.add(milk);
        warehouse.add(bread);
        warehouse.add(cheese);
        warehouse.delete(milk);
        warehouse.deleteByName("bread");
        assertThat(warehouse.findByName("cheese")).contains(cheese);
    }
}