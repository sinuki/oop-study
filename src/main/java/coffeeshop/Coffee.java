package coffeeshop;

import coffeeshop.menu.MenuItem;
import lombok.Getter;

@Getter
public class Coffee {

    private final String name;
    private final int price;

    public Coffee(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }
}
