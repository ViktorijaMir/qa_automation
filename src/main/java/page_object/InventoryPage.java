package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class InventoryPage {

    private By titleElement = By.className("title");

    private WebDriver driver;

    public  InventoryPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getTitleElement(){
        return driver.findElement(titleElement);
    }
}
