package org.example.demoQa.alertsFrameWindow;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage {

    @FindBy(id = "alertButton")
    private WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    @FindBy(id = "promtButton")
    private WebElement promtButton;

    public AlertPage clickAlertBtn(){
        elementActions.clickBtn(alertButton);
        return this;
    }

    public AlertPage timerAlertButton(){
        elementActions.clickBtn(timerAlertButton);
        return this;
    }

    public AlertPage confirmButton(){
        elementActions.clickBtn(confirmButton);
        return this;
    }

    public AlertPage promtButton(){
        elementActions.clickBtn(promtButton);
        return this;
    }
}
