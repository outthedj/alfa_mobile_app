package elements;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Input {

    AndroidDriver driver;
    String label;
    String inputXpath = "//*[contains(@resource-id, '%s')]";

    public Input(AndroidDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void inputText(String text) {
        inputXpath = String.format(inputXpath, label);
        driver.findElement(By.xpath(inputXpath)).sendKeys(text);       // Обертка для Инпута
    }
}
