package pages.mobilepage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SuccessLoginPage {

    AndroidDriver driver;
    private By SUCCESS_TEXT = By.className("android.widget.TextView");

    public SuccessLoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessMessageShown() {
    return driver.findElement(SUCCESS_TEXT).getAttribute("text").equals("Вход в Alfa-Test выполнен");
    }

//    String text = driver.findElement(SUCCESS_TEXT).getText();


//    public void getText() {
//        System.out.println(text);
//    }

}
