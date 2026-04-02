import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SuperFastTest {
    public static void main(String[] args) throws Exception {
        long totalStart = System.currentTimeMillis();

        // 1. Firefox драйвер (5-6 секунд)
        WebDriver driver = new FirefoxDriver();
        long driverReady = System.currentTimeMillis();
        System.out.println("Driver ready: " + (driverReady - totalStart) + "ms");

        try {
            // 2. Загрузка страницы (может быть долго первый раз)
            long pageStart = System.currentTimeMillis();
            driver.get("https://demoqa.com/automation-practice-form");
            System.out.println("First page load: " +
                    (System.currentTimeMillis() - pageStart) + "ms");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // 3. МНОГО тестов на одной странице
            for (int i = 1; i <= 5; i++) {
                long testStart = System.currentTimeMillis();

                // Очистить
                js.executeScript("""
                    document.getElementById('firstName').value = '';
                    document.getElementById('lastName').value = '';
                    document.getElementById('userEmail').value = 'test" + i + "@example.com';
                """);

                // Заполнить
                js.executeScript("document.getElementById('firstName').value='User" + i + "';");
                js.executeScript("document.getElementById('lastName').value='Test" + i + "';");

                // Выбрать gender
                String genderSelector = i % 2 == 0 ?
                        "label[for='gender-radio-2']" : "label[for='gender-radio-1']";
                driver.findElement(By.cssSelector(genderSelector)).click();

                // Телефон
                js.executeScript("document.getElementById('userNumber').value='123456789" + i + "';");

                // Submit
                js.executeScript("document.getElementById('submit').click();");

                // Закрыть модальное окно
                Thread.sleep(300);
                js.executeScript("""
                    var closeBtn = document.getElementById('closeLargeModal');
                    if (closeBtn) closeBtn.click();
                """);

                System.out.println("Test " + i + " completed in: " +
                        (System.currentTimeMillis() - testStart) + "ms");
            }

            System.out.println("\n✅ All tests completed!");
            System.out.println("Total time: " +
                    (System.currentTimeMillis() - totalStart) + "ms");

        } finally {
            driver.quit();
        }
    }
}