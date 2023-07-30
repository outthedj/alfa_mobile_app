package tests.mobiletests;

import driver.mobiledriver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import mobilePages.loginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class IsPasswordShownTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputPassword("Password")  //Chain of Invocations
                .changePasswordState();
        Assert.assertTrue(loginPage.isPasswordVisible("false"));
        loginPage
                .changePasswordState();
        Assert.assertTrue(loginPage.isPasswordVisible("true"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
