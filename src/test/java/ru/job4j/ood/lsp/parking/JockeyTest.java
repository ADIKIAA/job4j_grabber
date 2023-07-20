package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class JockeyTest {

    @Test
    void parkingFourCarThenLeaveTwoAndCheckEmptySpace() {
        SimpleParking simpleParking = new SimpleParking(10);
        Jockey jockey = new Jockey(simpleParking);
        Car auto1 = new Automobile();
        Car auto2 = new Automobile();
        Car truck1 = new Truck(3);
        Car truck2 = new Truck(3);
        jockey.parking(auto1);
        jockey.parking(auto2);
        jockey.parking(truck1);
        jockey.parking(truck2);
        jockey.leave(auto1);
        jockey.leave(truck1);
        assertThat(jockey.checkEmptySpace()).isEqualTo(6);
    }

    @Test
    void parkingCarAndThenTrowException() {
        SimpleParking simpleParking = new SimpleParking(4);
        Jockey jockey = new Jockey(simpleParking);
        Car truck1 = new Truck(3);
        Car truck2 = new Truck(3);
        jockey.parking(truck1);
        assertThatThrownBy(() -> jockey.parking(truck2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Недостаточно места для парковки");
    }

}