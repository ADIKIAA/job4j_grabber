package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParking implements Parking {

    private final int parkingSize;

    private int empty = 0;

    private List<Car> cars = new ArrayList<>();

    public AbstractParking(int parkingSize) {
        this.parkingSize = parkingSize;
        this.empty = parkingSize;
    }

    @Override
    public int checkFreeSpace() {
        return empty;
    }

    @Override
    public void parkCar(Car car) {
        int s = car.getSize();
        if (empty < s) {
            throw new IllegalArgumentException("Недостаточно места для парковки");
        }
        cars.add(car);
        empty -= s;
    }

    @Override
    public void leaveCar(Car car) {
        cars.remove(car);
        empty += car.getSize();
    }
}
