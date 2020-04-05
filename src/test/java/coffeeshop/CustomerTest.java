package coffeeshop;

import coffeeshop.menu.MenuBoard;
import coffeeshop.menu.MenuItem;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CustomerTest {

    private static MenuBoard menuBoard;

    @BeforeClass
    public static void setup() {
        menuBoard = new MenuBoard();
    }

    @Test
    public void 주문_성공() {
        Barista barista = createBarista();
        int initAmount = 10_000;
        Customer customer = createCustomer(initAmount);
        String menuName = "americano";
        MenuItem selectedItem = menuBoard.select(menuName);

        Coffee coffee = customer.order(menuBoard, selectedItem.getName(), barista);

        assertEquals(menuName, coffee.getName());
        assertEquals(initAmount - selectedItem.getPrice(), customer.getAmount());
    }

    @Test(expected = IllegalStateException.class)
    public void 주문_실패_금액부족() {
        Barista barista = createBarista();
        int initAmount = 1_000;
        Customer customer = createCustomer(initAmount);
        String menuName = "americano";
        MenuItem selectedItem = menuBoard.select(menuName);

        Coffee coffee = customer.order(menuBoard, selectedItem.getName(), barista);
        fail("고객의 보유금액보다 주문금액이 크면 실패해야 한다.");
    }

    @Test(expected = IllegalStateException.class)
    public void 메뉴_선택_실패_존재하지_않는_메뉴() {
        Barista barista = createBarista();
        int initAmount = 10_000;
        Customer customer = createCustomer(initAmount);
        String menuName = "luwak";
        MenuItem selectedItem = menuBoard.select(menuName);

        Coffee coffee = customer.order(menuBoard, selectedItem.getName(), barista);
        fail("존재하지 않는 메뉴를 주문하면 실패해야 한다");
    }
    private Barista createBarista() {
        return new Barista();
    }

    private Customer createCustomer(int amount) {
        return new Customer(amount);
    }
}