package Testes;

import Pages.accountPage;
import Pages.homePage;
import Pages.orderPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;


public class orderTest{
    private AndroidDriver<MobileElement> driver;
    private orderPage OrderPage;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "device name");
        desiredCapabilities.setCapability("appPackage", "com.outback.onlineordering");
        desiredCapabilities.setCapability("appActivity", "com.outback.onlineordering.SplashActivity");
        desiredCapabilities.setCapability("noReset", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
        orderPage = new OrderPage (driver);
}

    @Test
    public void verificarAccount() {
        //clickDaPagina.tituloDaOrderPage
        homePage.botaoDismiss();
        homePage.botaoAccount ();
        accountPage.tituloDaAccount ();
        Assert.assertEquals("Account", accountPage.tituloDaAccount().getText());
        orderPage.botaoOrder ();
        Assert.assertEquals("Order", orderPage.tituloDaAccount().getText());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
