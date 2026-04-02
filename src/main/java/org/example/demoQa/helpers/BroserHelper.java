package org.example.demoQa.helpers;

import org.example.demoQa.drivers.DriverManager;
import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BroserHelper {

    private WebDriver driver = DriverManager.getDriver();

    public BroserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url){
        driver.navigate().to(url);
    }

    public void goBack(){
        driver.navigate().back();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public Set<String> getWindows(){
        return driver.getWindowHandles();
    }

    public  void switchToWindow(int index){
        LinkedList<String> windowId = new LinkedList<>(getWindows());
        if(index < 0 || index > windowId.size()){
            throw new IllegalArgumentException("Invalid index " + index);
        }
        driver.switchTo().window(windowId.get(index));
    }

    public void switchToParent(){
        LinkedList<String> windowId = new LinkedList<>(getWindows());
        driver.switchTo().window(windowId.getFirst());
    }
}
