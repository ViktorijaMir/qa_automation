import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.InventoryPage;
import page_object.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.InventoryPage;
import page_object.LoginPage;

import java.util.List;

import static constants.Generic.SAUCE_URL;

public class TestSauceDemo {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod(description = "Preconditions")
        public void initialize() {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver();
            loginPage = new LoginPage(driver);
            inventoryPage = new InventoryPage(driver);
            driver.get(SAUCE_URL);
        }
        @Test
        public void  authorizeTest(){
            driver.get(SAUCE_URL);
            loginPage.authorize("standard_user","secret_sauce");
            Assert.assertEquals(inventoryPage.getTitleElement().getText(),"PRODUCTS");
        }
        @Test(description = "Failure: Test authorization error message with incorrect credentials")
        public void invalidCredentialTest() {
            loginPage.authorize("standard_user", "incorrect_pw");
            Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
        }
        @Test
        public void openProductTest () {
            loginPage.authorize("standard_user", "secret_sauce");
            Assert.assertEquals(inventoryPage.getTitleElement().getText(), "PRODUCTS");
            inventoryPage.clickOnProductByLabel("Sauce Labs Bold T-Shirt");
            System.out.println();
        }
        @AfterMethod

            public void tearDown() {
                driver.close();
                driver.quit();
            }

    }