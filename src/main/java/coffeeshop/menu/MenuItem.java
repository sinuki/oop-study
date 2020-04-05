package coffeeshop.menu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class MenuItem {

    private final String name;
    private final int price;
}
