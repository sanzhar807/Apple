package selenium.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasicLocators {
    @Test
    void byIdTest(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().
                implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demoqa.com/text-box");
        WebElement userName = driver.findElement(
                By.id("userName"));
        userName.sendKeys("Sanzhar Amanturov");
       WebElement email = driver.findElement(
               By.id("userEmail"));
       email.sendKeys("@koko12");
       WebElement text_center= driver.findElement(
               By.className("text-center"));
        System.out.println(text_center.getText());
    WebElement cerrentAddres = driver.findElement(
            By.id("currentAddress"));
    cerrentAddres.sendKeys("woll-strit 123");
    WebElement permanentAddress = driver.findElement(
            By.id("permanentAddress"));
    permanentAddress.sendKeys("Mira 123");
    WebElement submit = driver.findElement(
            By.id("submit"));
    submit.click();

    }
}
