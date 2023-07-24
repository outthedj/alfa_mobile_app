package pages.mobilepage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    AndroidDriver driver;
    private By LOGIN_FIELD = By.id("com.alfabank.qapp:id/etUsername");
    private By PASSWORD_FIELD = By.id("com.alfabank.qapp:id/etPassword");
    private By SUBMIT_BUTTON = By.id("com.alfabank.qapp:id/btnConfirm");
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void loginToAccount() {
        driver.findElement(LOGIN_FIELD).sendKeys("Login");
        driver.findElement(PASSWORD_FIELD).sendKeys("Password");
        driver.findElement(SUBMIT_BUTTON).click();
    }

}
