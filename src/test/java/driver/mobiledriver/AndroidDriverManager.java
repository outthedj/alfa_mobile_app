package driver.mobiledriver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager {

    public AndroidDriver driver;

    public AndroidDriver createDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_3a_API_34_extension_level_7_x86_64");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("appPackage", "com.alfabank.qapp");
        caps.setCapability("appActivity", "com.alfabank.qapp.presentation.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
}
