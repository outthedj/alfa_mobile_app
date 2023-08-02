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

import static mobilePages.loginPage.LoginErrorMessages.ERROR_VALIDATION_FAILED;
import static utilities.GenerateFakeMessage.generateStringOfLength;

public class LoginWithInvalidCredentialsTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test(dataProvider = "createInvalidData")
    public void loginWithInvalidDataTest(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername(login) //Chain of Invocations
                .inputPassword(password)  //Chain of Invocations
                .clickConfirmButton();  //Chain of Invocations
        loginPage.isElementLoaded(ERROR_VALIDATION_FAILED.getFieldPath(), "Введены неверные данные");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

    @DataProvider(name = "createInvalidData")
    private Object[][] getCreatedNegativeData() {
        return new Object[][]{
                {"123456789","Password"},
                {generateStringOfLength(51),"Password"},
                {"!&$%?*()+=@#><}{[]", "Password"},
                {"Але", "Password"},
                {"Login","123456789"},
                {"Login",generateStringOfLength(51)},
                {"Login", "!&$%?*()+=@#><}{[]"},
                {"Login", "Але"}
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
