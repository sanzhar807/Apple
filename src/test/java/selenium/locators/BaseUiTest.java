package selenium.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.demoQa.drivers.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseUiTest {
   static WebDriver driver = new ChromeDriver();
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
//         driver.manage().timeouts().
//                implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown(){
        DriverManager.closeDriver();
        driver.close();
        driver.quit();
    }
}
