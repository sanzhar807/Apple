package selenium.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseUiTest {
   static WebDriver driver = new FirefoxDriver();
    @BeforeAll
    public static void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().
                implicitlyWait(Duration.ofSeconds(10));
    }
}
