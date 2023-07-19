package ru.job4j.ood.ocp;

public class Example {

    class Car {
        String name;
        int vinNumber;
        String fuel;

        void refill() {
            if (fuel.equals("diesel")) {
                System.out.println("заправка ДТ");
            } else {
                System.out.println("запрвка АИ-92");
            }
        }
    }

    class MessageSender {

        void send(String message, String type) {
            if (type.equals("SMS")) {
                System.out.println("send by sms");
            } else if (type.equals("email")) {
                System.out.println("send by email");
            }
        }
    }

    class Animal {
        String name;

        void sound() {
            if (name.equals("dog")) {
                System.out.println("gaf");
            }
        }
    }

}
