package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class orderPage {
    private AndroidDriver<MobileElement> driver;

    @AndroidFindBy (id= "com.outback.tampa.internal:id/menuFragment").click ();
    private static MobileElement botaoOrder;
    public homePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
