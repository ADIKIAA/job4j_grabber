package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SimpleParkingTest {

    @Test
    void parkThreeCarsThenLeaveOneAndCheckEmptySize() {
        Parking parking = new SimpleParking(5);
        Car auto1 = new Automobile();
        Car auto2 = new Automobile();
        Car truck1 = new Truck(3);
        parking.parkCar(auto1);
        parking.parkCar(auto2);
        parking.parkCar(truck1);
        parking.leaveCar(truck1);
        assertThat(parking.checkFreeSpace()).isEqualTo(3);
    }

    @Test
    void addMoreCarThenHaveFreeSpaceAndThenThrowException() {
        Parking parking = new SimpleParking(5);
        Car auto1 = new Automobile();
        Car auto2 = new Automobile();
        Car truck1 = new Truck(3);
        Car truck2 = new Truck(3);
        parking.parkCar(auto1);
        parking.parkCar(auto2);
        parking.parkCar(truck1);
        assertThatThrownBy(() -> parking.parkCar(truck2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Недостаточно места для парковки");
    }

}