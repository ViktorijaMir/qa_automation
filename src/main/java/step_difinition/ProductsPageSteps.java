package step_difinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import page_object.ProductsPage;
import utils.DriverManager;

public class ProductsPageSteps {
    private WebDriver driver = DriverManager.getInstance();
    private final ProductsPage productPage = new ProductsPage();
    @Given("user selects {string} product from a list")
    public void userSelectsProductFromAList(String productName) {
      productPage.clickOnProductByName(productName);
    }
}
