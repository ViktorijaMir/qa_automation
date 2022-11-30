package step_difinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class CommonStepDefs {
    private WebDriver driver = DriverManager.getInstance();

    @Given("user open {string}")
    public void userOpenUrl(String url) {
        driver.get(url);
    }
}
