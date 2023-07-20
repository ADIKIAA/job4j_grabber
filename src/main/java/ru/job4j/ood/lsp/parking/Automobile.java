package ru.job4j.ood.lsp.parking;

public class Automobile implements Car {

    private int size = 1;

    @Override
    public int getSize() {
        return size;
    }
}
