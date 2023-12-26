package autotests;

import core.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pages.MainPage;

import static helpers.TestValues.CHECKOUT_BTN_TEXT;
import static helpers.TestValues.CONTINUE_SHOPPING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddRemoveItemTest extends BaseTest {
    private static final MainPage mainPage = new MainPage();

    @Test
    @Order(1)
    public void addItemToCart() {
        mainPage.addItemToCartByTitle("iPhone 12 Pro Max");
        assertEquals("1", mainPage.getCartQuantity());
        assertEquals("1099.00", mainPage.addedItems.get("iPhone 12 Pro Max"));
        assertEquals("1099.00", mainPage.getTotalCostValue());

        assertTrue(mainPage.checkoutBtnIsDisplayed());
        assertEquals(CHECKOUT_BTN_TEXT, mainPage.checkoutBtnText());
    }

    @Test
    @Order(2)
    public void deleteItemFromCart() {
        mainPage.deleteItemFromCart();
        assertEquals("0", mainPage.getCartQuantity());
        assertEquals("0.00", mainPage.getTotalCostValue());

        assertTrue(mainPage.checkoutBtnIsDisplayed());
        assertEquals(CONTINUE_SHOPPING, mainPage.checkoutBtnText());
    }
}
