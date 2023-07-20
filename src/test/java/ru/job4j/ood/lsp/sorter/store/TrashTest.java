package ru.job4j.ood.lsp.sorter.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.sorter.food.Food;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TrashTest {

    @Test
    void addFoodThenFindByName() {
        Store trash = new Trash();
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
        );
        trash.add(milk);
        List<Food> expected = new ArrayList<>();
        expected.add(milk);
        assertThat(trash.findByName("milk")).isEqualTo(expected);
    }

    @Test
    void addThreeFoodThenDeleteByNameOne() {
        Store trash = new Trash();
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
        trash.add(milk);
        trash.add(bread);
        trash.add(cheese);
        trash.deleteByName("bread");
        assertThat(trash.findByName("bread")).doesNotContain(bread).hasSize(0);
    }

    @Test
    void addThreeFoodThenDeleteOneAndDeleteByNameThenFindByName() {
        Store trash = new Trash();
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
        trash.add(milk);
        trash.add(bread);
        trash.add(cheese);
        trash.delete(milk);
        trash.deleteByName("bread");
        assertThat(trash.findByName("cheese")).contains(cheese);
    }
}