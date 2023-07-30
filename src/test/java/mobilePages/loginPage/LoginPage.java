package mobilePages.loginPage;

import elements.Button;
import elements.Input;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mobilePages.loginPage.LoginErrorMessages.ERROR_VALIDATION_FAILED;
import static mobilePages.loginPage.LoginFields.PASSWORD_FIELD;

public class LoginPage {

    AndroidDriver driver;
//    private By LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername");
//    private By LOGIN_FIELD = By.xpath("//*[contains(@resource-id, 'etUsername')]");
//    private By PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword");
//    private By PASSWORD_FIELD = By.xpath("//*[contains(@resource-id, 'etPassword')]");
//    private By SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm");

//    String regexPattern = "android.widget.EditText";

    //        WebDriverWait(driver, 10).until(expected_conditions.element_to_be_clickable((AppiumBy.ID, LOGIN_FIELD))).sendKeys('login');
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
        new Input(driver, "etUsername").inputText(text); // Изпользуем обертку
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(LOGIN_FIELD.getFieldPath())).sendKeys("Login"); // Реализация без оберток
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage inputPassword(String text) {
        new Input(driver, "etPassword").inputText(text); // Изпользуем обертку
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(PASSWORD_FIELD.getFieldPath())).sendKeys("Password"); // Реализация без оберток
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage clickConfirmButton() {
        new Button(driver, "btnConfirm").clickButton(); // Изпользуем обертку
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(SUBMIT_BUTTON.getFieldPath())).click(); // Реализация без оберток
        return new LoginPage(driver); //Chain of Invocations
    }

    public LoginPage changePasswordState() {
        driver.findElement(By.className("android.widget.ImageButton")).click();
        return new LoginPage(driver);
    }

    public String isPasswordHidden() {
        return driver.findElement(PASSWORD_FIELD.getFieldPath()).getAttribute("password");
    }

    public boolean isErrorMessageVisible() {
        return driver.findElement(ERROR_VALIDATION_FAILED.getFieldPath()).getAttribute("text").equals("Введены неверные данные");
    }

    public LoginPage isElementLoaded(By locator, String text) {
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(locator, text));
        return this;
    }

//    public LoginPage loginToAccount() {
//        new Input(driver, "etUsername").inputText("Login"); // Изпользуем обертку
//        new Input(driver, "etPassword").inputText("Password"); // Изпользуем обертку
//        new Button(driver, "btnConfirm").clickButton(); // Изпользуем обертку
////        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(LOGIN_FIELD.getFieldPath())).sendKeys("Login"); // Реализация без оберток
////        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(PASSWORD_FIELD.getFieldPath())).sendKeys("Password"); // Реализация без оберток
////        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(SUBMIT_BUTTON.getFieldPath())).click(); // Реализация без оберток
//        return new LoginPage(driver); //Chain of Invocations
//    }
}
