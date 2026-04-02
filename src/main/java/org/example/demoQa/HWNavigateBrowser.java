package org.example.demoQa;

import org.example.demoQa.drivers.DriverManager;
import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.example.demoQa.drivers.MozilaWebDriver.driver;

public class HWNavigateBrowser extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'Elements')]")
    private WebElement elementMenu;
    @FindBy(xpath = "//span[@class = 'text' and contains(text(),'Text Box')]")
    private WebElement textBox;
    @FindBy(xpath = "//span[@class = 'text' and contains(text(),'Check Box')]")
    private WebElement checkBox;
    @FindBy(xpath = "//span[@class = 'text' and contains(text(),'Radio Button')]")
    private WebElement radioButton;
    @FindBy(xpath = "//span[@class = 'text' and contains(text(),'Web Tables')]")
    private WebElement webTables;
    @FindBy(xpath = "//span[@class = 'text' and contains(text(),'Buttons')]")
    private WebElement buttons;
    @FindBy(xpath = "//span[text()= 'Links']")
    private WebElement links;
    @FindBy(xpath = "//span[text()= 'Broken Links - Images']")
    private WebElement brokenLinks;
    @FindBy(xpath = "//span[text()= 'Upload and Download']")
    private WebElement uploadAndDownload;
    @FindBy(xpath = "//span[text()= 'Dynamic Properties']")
    private WebElement dynamicProperties;

    @FindBy (xpath = "//div[contains(text(), 'Forms')]")
    protected WebElement forms;
    @FindBy (xpath = "//span[text()= 'Practice Form']")
    protected WebElement practiseForm;

    @FindBy (xpath = "//div[text()= 'Alerts, Frame & Windows']")
    private WebElement alertsWindowsFrame;
    @FindBy(xpath = "//span[text()= 'Browser Windows']")
    private WebElement browserAndWindows;
    @FindBy(xpath = "//span[text()= 'Alerts']")
    private WebElement alerts;
    @FindBy (xpath = "//span[text()= 'Frames']")
    private WebElement frames;

    @FindBy (xpath = "//div[text()= 'Widgets']")
    private WebElement widgets;

    @FindBy (xpath = "//div[text()= 'Interactions']")
    private WebElement interactions;

    @FindBy (xpath = "//div[text()= 'Book Store Application']")
    private WebElement book;

    @FindBy(xpath = "//h5[text() = 'Elements']")
    private WebElement menuElement;
    @FindBy(xpath = "//h5[text() = 'Forms']")
    private WebElement menuForms;
    @FindBy(xpath = "//h5[text() = 'Alerts, Frame & Windows']")
    private WebElement menuAlerts;
    @FindBy(xpath = "//h5[text() = 'Widgets']")
    private WebElement menuWidgets;
    @FindBy(xpath = "//h5[text() = 'Interactions']")
    private WebElement menuInteractions;
    @FindBy(xpath = "//h5[text() = 'Book Store Application']")
    private WebElement menuBook;

    public List<WebElement> listOfMenu() {
        List<WebElement> listOfMenu = List.of(menuElement, menuForms, menuAlerts,
                menuWidgets, menuInteractions, menuBook);
    return listOfMenu;
    }
    public List<WebElement> listOfElements(){
        List<WebElement> list = List.of(textBox,checkBox,radioButton,webTables,buttons,links,
                brokenLinks,uploadAndDownload,dynamicProperties);
        return list;
    }

    public HWNavigateBrowser clickInteractions(){
        elementActions.clickBtn(interactions);
        return this;
    }

    public HWNavigateBrowser clickBook(){
        elementActions.clickBtn(book);
        return this;
    }



    public HWNavigateBrowser clickForms(){
        elementActions.clickBtn(forms);
        return this;
    }

    public HWNavigateBrowser clickWidgets(){
        elementActions.clickBtn(widgets);
        return this;
    }
    public HWNavigateBrowser clickPractiseForms(){
        elementActions.clickBtn(practiseForm);
        return this;
    }
    public HWNavigateBrowser alerts(){
        elementActions.clickBtn(alertsWindowsFrame);
        return this;
    }

    public HWNavigateBrowser click(WebElement element){
        elementActions.waitElementToBeClickable(element);
        elementActions.clickBtn(element);
        return this;
    }

    public HWNavigateBrowser clickElementMenu(){
        elementActions.clickBtn(elementMenu);
        return this;
    }

    public HWNavigateBrowser clickTextBox(){
        elementActions.clickBtn(textBox);
        return this;
    }
}
