package ru.job4j.ood.isp.menu;


import java.util.Scanner;

public class TodoApp {

    private Menu menu;

    private MenuPrinter printer;

    private Scanner scanner = new Scanner(System.in);

    public TodoApp() {
        this.menu = new SimpleMenu();
        this.printer = new SimpleMenuPrinter();
    }

    public void addToRoot() {
        System.out.println("Введите имя элемента");
        String name = scanner.next();
        System.out.println("Введите действие для элемента");
        String action = scanner.next();
        ActionDelegate actionDelegate = () -> System.out.println(action);
        menu.add(null, name, actionDelegate);
    }

    public void addToParent() {
        System.out.println("Введите имя родительского элемента");
        String parentName = scanner.next();
        System.out.println("Введите имя элемента");
        String childName = scanner.next();
        System.out.println("Введите действие для элемента");
        String action = scanner.next();
        ActionDelegate actionDelegate = () -> System.out.println(action);
        menu.add(parentName, childName, actionDelegate);
    }

    public void select() {
        System.out.println("Введите имя элемента");
        String itemName = scanner.next();
        menu.select(itemName).ifPresent((i) -> i.getActionDelegate().delegate());
    }

    public void printMenu() {
        printer.print(menu);
    }

    public void init() {
        boolean run = true;
        while (run) {
            System.out.println(String.join(System.lineSeparator(),
                    "1. Добавить элемент в корень",
                    "2. Добавить элемент к родительскому элементу",
                    "3. Выбрать пункт: ",
                    "4. Вывести меню в консоль",
                    "5. Выйти"));
            int select = scanner.nextInt();
            if (select < 1 || select > 6) {
                System.out.println("Введите число от 1 до 5");
                continue;
            }
            if (select == 1) {
                addToRoot();
            } else if (select == 2) {
                addToParent();
            } else if (select == 3) {
                select();
            } else if (select == 4) {
                printMenu();
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        app.init();
    }

}
