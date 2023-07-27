package pages.mobilepage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessLoginPage {

    AndroidDriver driver;
    private By SUCCESS_TEXT = By.className("android.widget.TextView");

    public SuccessLoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessMessageShown() {
//    return driver.findElement(SUCCESS_TEXT).getAttribute("text").equals("Вход в Alfa-Test выполнен");
//        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions. visibilityOfElementLocated(SUCCESS_TEXT)).getAttribute("text").equals("Вход в Alfa-Test выполнен");
      return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(SUCCESS_TEXT, "text", "Вход в Alfa-Test выполнен"));
    }

//    String text = driver.findElement(SUCCESS_TEXT).getText();


//    public void getText() {
//        System.out.println(text);
//    }

}
