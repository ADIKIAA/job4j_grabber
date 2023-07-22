package ru.job4j.ood.isp.menu;

import java.util.Iterator;

public class SimpleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        Iterator<Menu.MenuItemInfo> iterator = menu.iterator();
        Menu.MenuItemInfo item;
        while (iterator.hasNext()) {
            item = iterator.next();
            StringBuilder sb = new StringBuilder(
                    item.getNumber().replaceAll("\\d", "").replaceFirst(".", "")
                                    .replaceAll(".", "--")
            );
            System.out.println(sb.append(item.getNumber()).append(item.getName()));
        }
    }

}
