package mobilePages.basePage;

import io.appium.java_client.android.AndroidDriver;

public abstract class BasePage {

    AndroidDriver driver;

    public BasePage(AndroidDriver driver) {          // BasePage класс создал, но он неработает))) Его нужно доработать
        this.driver = driver;
    }
}
