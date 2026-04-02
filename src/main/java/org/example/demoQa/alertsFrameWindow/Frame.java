package org.example.demoQa.alertsFrameWindow;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Frame extends BasePage {

    @FindBy(id  = "sampleHeading")
    private WebElement sampleHeading;

    public String getSampleHeading(){
        return sampleHeading.getText();
    }
}
