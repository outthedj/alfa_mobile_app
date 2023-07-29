package elements;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Button {

    AndroidDriver driver;
    String label;
    String inputXpath = "//*[contains(@resource-id, '%s')]";

    public Button(AndroidDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickButton() {
        inputXpath = String.format(inputXpath, label);           // Обертка для Баттона
        driver.findElement(By.xpath(inputXpath)).click();
    }
}
