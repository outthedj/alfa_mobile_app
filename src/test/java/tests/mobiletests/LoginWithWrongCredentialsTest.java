package tests.mobiletests;

import driver.mobiledriver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import mobilePages.loginPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenerateRandomValue;

import java.net.MalformedURLException;

import static mobilePages.loginPage.LoginErrorMessages.ERROR_WRONG_CREDENTIALS;

public class LoginWithWrongCredentialsTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test(dataProvider = "createEmptyData")
    public void loginWithInvalidDataTest(String login, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername(login) //Chain of Invocations
                .inputPassword(password)  //Chain of Invocations
                .clickConfirmButton();  //Chain of Invocations
        loginPage.isElementLoaded(ERROR_WRONG_CREDENTIALS.getFieldPath(), "Введены неверные данные");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @DataProvider(name = "createEmptyData")
    private Object[][] getCreatedNegativeData() {
        return new Object[][]{
                {GenerateRandomValue.getRandomLogin(10), "Password"},
                {"Login",GenerateRandomValue.getRandomPassword(10)}
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
