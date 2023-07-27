package tests.mobiletests;

import driver.mobiledriver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mobilepage.LoginPage;
import pages.mobilepage.SuccessLoginPage;

import java.net.MalformedURLException;

public class LoginTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAccount();
//        Thread.sleep(5000);
        SuccessLoginPage successLoginPage = new SuccessLoginPage(driver);

        Assert.assertTrue(successLoginPage.isSuccessMessageShown());
//        successLoginPage.getText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
