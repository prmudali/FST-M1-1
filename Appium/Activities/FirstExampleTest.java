package examples;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstExampleTest {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("deviceId","emulator-5554");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        URL serverURL= new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver<>(serverURL,caps);

    }
    @Test
    public void additionTest()
    {
        driver.findElementById("com.android.calculator2:id/digit_3").click();
        driver.findElementByAccessibilityId("plus").click();
        driver.findElementById("com.android.calculator2:id/digit_6").click();
        driver.findElementByAccessibilityId("equals").click();
        //Find result and Assert
        String result= driver.findElementById("com.android.calculator2:id/result").getText();
        System.out.println("Result of the addition is "+result);
        Assert.assertTrue(result.contains("9"));
        driver.findElement(MobileBy.AndroidUIAutomator("value"));
    }
    /*@Test
    public void scroll()
    {
        String UiScrollable="UiScrollable(UiSelector().scrollable(true))";
        WebDriver wait= (WebDriver) new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));
        driver.findElementByAndroidUIAutomator(
                UiScrollable+".scrollForward(5).scrollIntoView(text(\"Tab Opener\"))").click();
        driver.findElementByAndroidUIAutomator(
                UiScrollable+".scrollForward(3)");
        driver.findElementByAccessibilityId("Tab Opener").click();
        //
    }*/
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}