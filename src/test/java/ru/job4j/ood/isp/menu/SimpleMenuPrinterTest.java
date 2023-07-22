package ru.job4j.ood.isp.menu;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class SimpleMenuPrinterTest {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        System.setOut(new PrintStream(output));
        MenuPrinter printer = new SimpleMenuPrinter();
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        printer.print(menu);
        System.setOut(null);
        String expected = String.join(System.lineSeparator(),
                "1.Сходить в магазин",
                        "--1.1.Купить продукты",
                        "----1.1.1.Купить хлеб",
                        "----1.1.2.Купить молоко",
                        "2.Покормить собаку",
                        "");
        assertThat(output.toString()).isEqualTo(expected.toString());
    }

}