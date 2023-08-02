package tests.mobiletests;

import driver.mobiledriver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import mobilePages.loginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginWithEmptyCredentialsTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test(dataProvider = "createEmptyData")
    public void loginWithEmptyDataTest(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername(login) //Chain of Invocations
                .inputPassword(password)  //Chain of Invocations
                .clickConfirmButton();  //Chain of Invocations
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @DataProvider(name = "createEmptyData")
    private Object[][] getCreatedNegativeData() {
        return new Object[][]{
                {"", ""},
                {"Login", ""},
                {"", "Password"}
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
