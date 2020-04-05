package coffeeshop;

import coffeeshop.menu.MenuItem;
import lombok.Getter;

@Getter
public class Barista {

    public Coffee makeCoffee(MenuItem item) {
        return new Coffee(item);
    }

}
