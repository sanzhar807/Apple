import demoQa.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AmazonComTest extends BaseTest {
    @Test
    void test() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(4000);
       WebElement koko= driver.findElement(By.className("nav-search-field "));
       koko.sendKeys("Iphone" + Keys.RETURN);
    }
}
