package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.TestValues.BASE_URL;

public class MainPage extends BasePage {
    public Map<String, String> addedItems = new HashMap<>();
    @FindBy(xpath = "//div[@class='shelf-item']/p[@class='shelf-item__title']")
    private List<WebElement> itemsByTitle;
    @FindBy(xpath = "//div[@class='shelf-item']/div[@class='shelf-item__price']/div[@class='val']")
    private List<WebElement> itemsByPrice;
    @FindBy(xpath = "//div[@class='shelf-item']/div[@class='shelf-item__buy-btn']")
    private List<WebElement> addToCartBtn;
    @FindBy(xpath = "//*[@class = 'float-cart float-cart--open']//div[@class = 'shelf-item__del']")
    private WebElement deleteItemFromCart;
    @FindBy(xpath = "//*[@class = 'float-cart float-cart--open']//p[@class = 'sub-price__val']")
    private WebElement totalCostValue;
    @FindBy(className = "bag__quantity")
    private WebElement cartQuantity;
    @FindBy(xpath = "//*[@class='float-cart__footer']/div[@class='buy-btn']")
    private WebElement checkoutBtn;

    public MainPage() {
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }

    public void addItemToCartByTitle(String... itemsTitle) {
        for (int i = 0; i < itemsByTitle.size(); i++) {
            String currentTitle = itemsByTitle.get(i).getText();
            for (String title : itemsTitle) {
                if (currentTitle.equals(title)) {
                    addedItems.put(title, itemsByPrice.get(i).getText().substring(1));
                    addToCartBtn.get(i).click();
                    break;
                }
            }
        }
    }

    public void deleteItemFromCart() {
        deleteItemFromCart.click();
    }

    public String getCartQuantity() {
        return cartQuantity.getText();
    }

    public String checkoutBtnText() {
        return checkoutBtn.getText();
    }

    public boolean checkoutBtnIsDisplayed() {
        return checkoutBtn.isDisplayed();
    }

    public String getTotalCostValue() {
        return totalCostValue.getText().substring(2);
    }
}
