package autotests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static helpers.TestValues.CHECKOUT_BTN_TEXT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemsTest extends BaseTest {
    private static final MainPage mainPage = new MainPage();

    @Test
    public void addItemsToCart() {
        mainPage.addItemToCartByTitle("Pixel 4", "One Plus 7T");
        assertEquals("2", mainPage.getCartQuantity());
        assertEquals("899.00", mainPage.addedItems.get("Pixel 4"));
        assertEquals("599.00", mainPage.addedItems.get("One Plus 7T"));
        assertEquals("1498.00", mainPage.getTotalCostValue());

        assertTrue(mainPage.checkoutBtnIsDisplayed());
        assertEquals(CHECKOUT_BTN_TEXT, mainPage.checkoutBtnText());
    }
}
