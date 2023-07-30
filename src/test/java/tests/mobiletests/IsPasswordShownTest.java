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
    public void isPasswordShownTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputPassword("Password")  //Chain of Invocations
                .changePasswordState();
        Assert.assertEquals(loginPage.isPasswordHidden(), "false");
        loginPage
                .changePasswordState();
        Assert.assertEquals(loginPage.isPasswordHidden(), "true");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
