package coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import coffeeshop.menu.MenuBoard;
import coffeeshop.menu.MenuItem;

import java.util.UUID;

@Getter
@ToString
@AllArgsConstructor
public class Customer {

    private final String customerNo = UUID.randomUUID().toString();
    private int amount;

    public Coffee order(MenuBoard menu, String menuName, Barista barista) {
        MenuItem menuItem = menu.select(menuName);
        paid(menuItem);
        return barista.makeCoffee(menuItem);
    }

    private void paid(MenuItem menuItem) {
        int menuPrice = menuItem.getPrice();
        int remain = this.amount - menuPrice;
        if (0 > remain) {
            String message = String.format("손님(%s)의 보유 금액(%d)이 부족합니다.(주문금액: %d)", this.customerNo, this.amount, menuPrice);
            throw new IllegalStateException(message);
        }
        this.amount = remain;
    }
}
