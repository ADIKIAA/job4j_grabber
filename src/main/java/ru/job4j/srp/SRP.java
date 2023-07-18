package ru.job4j.srp;

import java.util.Date;
import java.util.List;

public class SRP {

    static class Order {
        String name;
        int number;
        Date createDate;

        void saveToDB() {
        }

        void print() {
        }
    }

    static class Translator {

        void translateToRussian() {
        }

        void sentToEmail() {
        }
    }

    static class Employees {

        List<Employees> list;

        void getAll() {
        }

        void getByName() {
        }

        void logToDB() {

        }
    }

}
