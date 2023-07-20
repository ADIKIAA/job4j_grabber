package ru.job4j.ood.lsp.parking;

public interface Parking {

    void parkCar(Car car);

    void leaveCar(Car car);

    int checkFreeSpace();

}
