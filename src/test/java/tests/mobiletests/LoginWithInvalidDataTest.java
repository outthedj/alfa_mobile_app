package tests.mobiletests;

import driver.mobiledriver.AndroidDriverManager;
import io.appium.java_client.android.AndroidDriver;
import mobilePages.loginPage.LoginFields;
import mobilePages.loginPage.LoginPage;
import mobilePages.successLoginPage.SuccessLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static mobilePages.loginPage.LoginFields.LOGIN_FIELD;
import static mobilePages.loginPage.LoginFields.PASSWORD_FIELD;
import static utilities.GenerateFakeMessage.generateDate;
import static utilities.GenerateFakeMessage.generateStringOfLength;

public class LoginWithInvalidDataTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriverManager().createDriver();
    }

    @Test(dataProvider = "createNegativeData")
    public void loginWithInvalidDataTest(HashMap<LoginFields, ?> data, LoginFields field) {
        LoginPage loginPage = new LoginPage(driver);
        data.keySet().forEach(key ->
//                loginPage.inputUsername(key, data.get(key).toString())
                driver.findElement()
        );
    }

    @DataProvider(name = "createNegativeData")
    private Object[][] getCreatedNegativeData() {
        List<String> logins = Arrays.asList("", "123456789", generateStringOfLength(51), "!&$%?*()+=@#><}{[]");
        List<String> passwords = Arrays.asList("", " ", generateStringOfLength(51));
        return new Object[][]{
                {new HashMap<>() {{
                    put(LOGIN_FIELD, logins.get(new Random().nextInt(logins.size())));
                    put(PASSWORD_FIELD, generateStringOfLength(50));
                }}, LOGIN_FIELD
                },
                {new HashMap<>() {{
                    put(LOGIN_FIELD, generateStringOfLength(50));
                    put(PASSWORD_FIELD, passwords.get(new Random().nextInt(passwords.size())));
                }}, PASSWORD_FIELD
                }
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
