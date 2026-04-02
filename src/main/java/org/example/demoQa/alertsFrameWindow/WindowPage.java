package org.example.demoQa.alertsFrameWindow;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage {

    @FindBy(id = "tabButton")
    private WebElement  tabButton;

    @FindBy(id = "windowButton")
    private WebElement windowButton ;

    @FindBy(id = "messageWindowButton")
    private WebElement  messageWindowButton;

    public WindowPage  tabButton (){
        elementActions.clickBtn(tabButton);
        return this;
    }

    public WindowPage  windowButton (){
        elementActions.clickBtn(windowButton);
        return this;
    }

    public WindowPage messageWindowButton  (){
        elementActions.clickBtn(messageWindowButton);
        return this;
    }
}
