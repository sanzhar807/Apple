package org.example.demoQa.elements;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {

    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement click;

//    public BasePage doubleClick(){
//        elementActions.doubleClick(doubleClickBtn);
//        return this;
//    }
//
//    public BasePage rightClick(){
//        elementActions.rightClick(rightClickBtn);
//        return this;
//    }

    public BasePage click(){
        elementActions.clickBtn(click);
        return this;
    }
}
