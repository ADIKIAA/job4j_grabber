package ru.job4j.ood.lsp.sorter.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.sorter.food.Food;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    @Test
    void addFoodThenFindByName() {
        Store shop = new Shop();
        Food milk = new Food(
                "milk",
                LocalDate.now().plus(1, ChronoUnit.MONTHS),
                LocalDate.now().minus(1, ChronoUnit.MONTHS),
                135.8,
                23
        );
        shop.add(milk);
        List<Food> expected = new ArrayList<>();
        expected.add(milk);
        assertThat(shop.findByName("milk")).isEqualTo(expected);
    }

    @Test
    void addThreeFoodThenDeleteByNameOne() {
        Store shop = new Shop();
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
        shop.add(milk);
        shop.add(bread);
        shop.add(cheese);
        shop.deleteByName("bread");
        assertThat(shop.findByName("bread")).doesNotContain(bread).hasSize(0);
    }

    @Test
    void addFoodWithDiscountThenFindByPrice() {
        Store shop = new Shop();
        Food cheese = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                200.0,
                10
        );
        Food expected = new Food(
                "cheese",
                LocalDate.now().plus(1, ChronoUnit.DAYS),
                LocalDate.now().minus(2, ChronoUnit.MONTHS),
                180.0,
                10
        );
        shop.add(cheese);
        assertThat(shop.findByPrice(180.0)).contains(expected);
    }

    @Test
    void addThreeFoodThenDeleteOneAndDeleteByNameThenFindByName() {
        Store shop = new Shop();
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
        shop.add(milk);
        shop.add(bread);
        shop.add(cheese);
        shop.delete(milk);
        shop.deleteByName("bread");
        assertThat(shop.findByName("cheese")).contains(cheese);
    }

}