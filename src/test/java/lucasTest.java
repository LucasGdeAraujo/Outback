//importação de paginas ou dependencias
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.Thread.*;

//criando os metedos de teste
public class lucasTeste { private AndroidDriver driver;

    //comunicação de script e device
    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "SM G781B");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("app", "C:\\Users\\dti Digital\\Downloads\\Outback-outbackDebug-HEAD-build-112059-d23a51cb-2023-02-28 (1).apk");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("nativeWebScreenshot", true);

        //comunicação com o appium server (server deve estar na mesma URL e Porta para funcionar)
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }
    @Test
    //criação do metodo de teste para verificar a tela de account
        public void verificarAccount() throws MalformedURLException, InterruptedException {
           //clicar no botão dismiss
        sleep(5000);
        MobileElement botaoDismiss = (MobileElement) driver.findElementById("com.outback.tampa.internal:id/dismiss_cta");
            botaoDismiss.click();

            //clicar no botão de Account
        MobileElement botaoAccount = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Account\"]");
        botaoAccount.click();

            //validar título da tela
        MobileElement tituloDaAccount= (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Account\"]");
        Assert.assertEquals(tituloDaAccount.getText(), "Account");

    }

//depois de cada teste, fechar aplicativo
        @AfterEach
        public void finalizarTeste() throws MalformedURLException {
        driver.quit();

}


}
