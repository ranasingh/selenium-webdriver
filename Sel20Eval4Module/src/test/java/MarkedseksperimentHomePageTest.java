package singh.selenium.api;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MarkedseksperimentHomePageTest {

    private static WebDriver webDriver;
    private static long start = 0;
    private static long end = 0;
    private static DesiredCapabilities desiredCapabilities;
    private static String baseUrl = "https://markedseksperiment.app.iterate.no";

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
    public void titleOnPage() {
        assertEquals("Markedseksperiment", webDriver.getTitle());
    }

    @Test
    public void rapidEngagePresent() throws Exception {
        WebElement rapidEngage = webDriver.findElement(By.id("ss_feedback"));
        assertEquals("Assert rapid engage div present", rapidEngage.getTagName(), "div");
    }
}
