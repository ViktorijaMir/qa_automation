import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static constants.Generic.GOOGLE_URL;
import static org.testng.Assert.assertEquals;

public class TestChrome {

    ChromeDriver driver = new ChromeDriver();

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test(enabled = false)
    public void chromeTest() {
        driver.get(GOOGLE_URL);

        WebElement acceptButton = driver.findElement(By.xpath("//button//div[contains(text(), 'Accept all')]"));
        acceptButton.click();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("acodemy");

        searchField.sendKeys(Keys.ENTER);

        assertEquals(driver.getTitle(), "acodemy - Google Search");
    }
}
