package org.example.demoQa.helpers;


import org.example.demoQa.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementActions {
    Actions action = new Actions(DriverManager.getDriver());

    public ElementActions waitElementToBeClickable(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(5)).until(ExpectedConditions.
                elementToBeClickable(element));
        return this;
    }

    public ElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(1)).until(ExpectedConditions.
                visibilityOf(element));
        return this;
    }

    public ElementActions clickBtn(WebElement element){
        scrollToElement(element);
        waitElementToBeClickable(element);
        element.click();
        return this;
    }

    public ElementActions inputText(WebElement element,String text){
        scrollToElement(element);
        waitElementToBeVisible(element);
        element.sendKeys(text);
        return this;
    }

    public ElementActions scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public ElementActions selectByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;
    }

    public ElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        action.doubleClick(element).perform();
        return this;
    }

    public ElementActions rightClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickable(element);
        action.contextClick(element).perform();
        return this;
    }

}
