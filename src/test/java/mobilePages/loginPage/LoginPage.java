package mobilePages.loginPage;

import elements.Button;
import elements.Input;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mobilePages.loginPage.LoginErrorMessages.ERROR_VALIDATION_FAILED;
import static mobilePages.loginPage.LoginFields.PASSWORD_FIELD;

@Log4j
public class LoginPage {

    AndroidDriver driver;

                           // Расскажу на собеседовании, что это
//        String regexPattern = "android.widget.EditText";
//
//        List<WebElement> elements = driver.findElements(By.cssSelector("*[class*='" + regexPattern + "']"));
//        List<WebElement> elements = driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().textMatches(\"" + regexPattern + "\")"));
//        List<WebElement> elements = driver.findElements(By.xpath("//*[matches(@text, '" + regexPattern + "')]"));
//        List<WebElement> elements = driver.findElementsByXPath("//*[matches(@text, '" + regexPattern + "')]");
//        List<WebElement> elements = driver.findElements(By.xpath("//*[matches(@text,'" + regexPattern + "')]"));
//        List<WebElement> elements = driver.findElements(By.xpath("//*[class$='android.widget.EditText']"));
//        System.out.println(driver.getPageSource());

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public LoginPage inputUsername(String text) {
        log.info("Inputting username");
        new Input(driver, "etUsername").inputText(text); // Изпользуем обертку
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage inputPassword(String text) {
        log.info("Inputting password");
        new Input(driver, "etPassword").inputText(text); // Изпользуем обертку
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage clickConfirmButton() {
        log.info("Clicking Confirm button");
        new Button(driver, "btnConfirm").clickButton(); // Изпользуем обертку
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage changePasswordState() {
        log.info("Changing password state");
        driver.findElement(By.className("android.widget.ImageButton")).click();
        return new LoginPage(driver);
    }

    public String isPasswordHidden() {
        log.info("Checking password state");
        return driver.findElement(PASSWORD_FIELD.getFieldPath()).getAttribute("password");
    }

    public boolean isErrorMessageVisible() {
        log.info("Checking error message");
        return driver.findElement(ERROR_VALIDATION_FAILED.getFieldPath()).getAttribute("text").equals("Введены неверные данные");
    }

    public LoginPage isElementLoaded(By locator, String text) {
        log.info("Checking if element is loaded");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(locator, text));
        return this;
    }
}
