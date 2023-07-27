package pages.mobilepage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    AndroidDriver driver;
//    private By LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername");
    private By LOGIN_FIELD = By.xpath("//*[contains(@resource-id, 'etUsername')]");
//    private By PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword");
    private By PASSWORD_FIELD = By.xpath("//*[contains(@resource-id, 'etPassword')]");
    private By SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm");

//    String regexPattern = "android.widget.EditText";
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void loginToAccount() {

//        WebDriverWait(driver, 10).until(expected_conditions.element_to_be_clickable((AppiumBy.ID, LOGIN_FIELD))).sendKeys('login');
//        List<WebElement> elements = driver.findElements(By.cssSelector("*[class*='" + regexPattern + "']"));
//        List<WebElement> elements = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"" + regexPattern + "\")"));
//        List<WebElement> elements = driver.findElements(By.xpath("//*[matches(@text, '" + regexPattern + "')]"));
//        List<WebElement> elements = driver.findElementsByXPath("//*[matches(@text, '" + regexPattern + "')]");
//        List<WebElement> elements = driver.findElements(By.xpath("//*[matches(@text,'" + regexPattern + "')]"));
//        List<WebElement> elements = driver.findElements(By.xpath("//*[class$='android.widget.EditText']"));
        System.out.println(driver.getPageSource());

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(LOGIN_FIELD)).sendKeys("Login");


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys("Password");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(SUBMIT_BUTTON)).click();



    }

}
