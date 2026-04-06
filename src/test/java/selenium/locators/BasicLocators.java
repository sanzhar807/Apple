package selenium.locators;

import demoQa.BaseTest;
import org.example.demoQa.helpers.ElementActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Tag("UI")
@Tag("REGRESSION")
public class BasicLocators extends BaseTest {

    ElementActions elementActions = new ElementActions();

    @Test
    void byIdTest(){
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
    elementActions.waitElementToBeClickable(submit);

    }

    @Test
    void TagName(){
        driver.get("https://demoqa.com/text-box");
        WebElement textBox = driver.findElement(By.tagName("h1"));
        System.out.println(textBox.getText());
    }

    @Test
    void byLinkTest(){
        driver.get("https://demoqa.com/links");
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();
    }

    @Test
    void byPartialLinkTest(){
        driver.get("https://demoqa.com/links");
        try {
            WebElement ad = driver.findElement(By.id("fixedban"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", ad);
        } catch (NoSuchElementException ignored) {}

        WebElement homeLink = driver.findElement(By.partialLinkText("Bad"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkRes = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse"))
        );

        String str1 = linkRes.getText();
        final String cos = "Link has responded with staus 400 and status text Bad Request";
        Assertions.assertEquals(cos, str1);
    }
}
