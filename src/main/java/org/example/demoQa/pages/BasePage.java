package org.example.demoQa.pages;

import org.example.demoQa.drivers.DriverManager;
import org.example.demoQa.helpers.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public ElementActions elementActions = new ElementActions();

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(),this);

    }
}
