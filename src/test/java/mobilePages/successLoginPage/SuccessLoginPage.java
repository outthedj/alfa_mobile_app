package mobilePages.successLoginPage;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j
public class SuccessLoginPage {

    AndroidDriver driver;
    private By SUCCESS_TEXT = By.className("android.widget.TextView");

    public SuccessLoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessMessageShown() {
        log.info("Checking is success message shown");
      return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeContains(SUCCESS_TEXT, "text", "Вход в Alfa-Test выполнен"));
    }
}
