package singh.selenium.api;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class GooglePageTest {

    private static WebDriver webDriver;
    private static long start = 0;
    private static long end = 0;
    private static DesiredCapabilities desiredCapabilities;
    private static String baseUrl = "https://www.google.no";

    @BeforeClass
    public static void before() {
        start = System.nanoTime();

        //webDriver = new FirefoxDriver();
        webDriver = new PhantomJSDriver();
        webDriver.get(baseUrl);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
        end = System.nanoTime();

        long duration = end - start;
        System.out.println("");
        System.out.println("Markedseksperiment Test Suite Took: " + TimeUnit.NANOSECONDS.toMillis(duration));
    }

    @Test
    public void googleOnlyHasOneFormOnPage() throws Exception {
        List<WebElement> formElement = webDriver.findElements(By.tagName("form"));
        assertTrue("Assert google only has one form on page", formElement.size() == 1);
    }
}
