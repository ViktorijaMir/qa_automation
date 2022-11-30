package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;

import java.util.List;

public class ProductsPage {

    private WebDriver driver = DriverManager.getInstance();
    private By productLabel = By.xpath("//h2[@class='woocommerce-loop-product__title']");
    public void  clickOnProductByName(String productName){
        List<WebElement>elements = driver.findElements(productLabel);
        for (int i = 0;i<elements.size();i++){
            if (elements.get(i).getText().equals(productName)) {
                elements.get(i).click();
                break;
            }
        }
    }
}