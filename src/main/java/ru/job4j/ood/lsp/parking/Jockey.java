package ru.job4j.ood.lsp.parking;

public class Jockey {

    private Parking parking;

    public Jockey(Parking parking) {
        this.parking = parking;
    }

    public void parking(Car car) {
        parking.parkCar(car);
    }

    public void leave(Car car) {
        parking.leaveCar(car);
    }

    public int checkEmptySpace() {
        return parking.checkFreeSpace();
    }

    public static void main(String[] args) {
        SimpleParking simpleParking = new SimpleParking(10);
        Jockey jockey = new Jockey(simpleParking);
        Car auto1 = new Automobile();
        Car auto2 = new Automobile();
        Car auto3 = new Automobile();
        Car auto4 = new Automobile();
        Car truck1 = new Truck(3);
        Car truck2 = new Truck(3);
        Car truck3 = new Truck(3);
        jockey.parking(auto1);
        jockey.parking(auto2);
        jockey.parking(auto3);
        jockey.parking(auto4);
        jockey.parking(truck1);
        jockey.parking(truck2);
        jockey.leave(auto1);
        System.out.println(simpleParking.checkFreeSpace());
    }

}
