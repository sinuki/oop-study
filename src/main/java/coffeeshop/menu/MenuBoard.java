package coffeeshop.menu;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class MenuBoard {

    private final Map<String, MenuItem> items = new HashMap<>();

    public MenuBoard() {
        MenuItem americanoItem = new MenuItem("americano", 1500);
        MenuItem capuchinoItem = new MenuItem("capuchino", 2000);
        MenuItem espressoItem = new MenuItem("espresso", 2500);
        MenuItem latteItem = new MenuItem("latte", 2000);
        List<MenuItem> menuItems = Arrays.asList(americanoItem, capuchinoItem, espressoItem, latteItem);
        for (MenuItem item : menuItems) {
            this.items.put(item.getName(), item);
        }
    }

    public MenuItem select(String itemName) {
        if (!this.items.containsKey(itemName)) {
            throw new IllegalStateException("존재하지 않는 메뉴입니다.");
        }
        return this.items.get(itemName);
    }
}
