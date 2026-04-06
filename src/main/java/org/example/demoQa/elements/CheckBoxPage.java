package org.example.demoQa.elements;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//span[@class='rc-tree-switcher rc-tree-switcher_close']")
    private WebElement homeBtn;

    @FindBy(css = "label[for = 'tree-node-desktop']")
    private WebElement desktopIkon;
    @FindBy (xpath = "//label[@for = 'tree-node-desktop']/preceding-sibling::button")
    private WebElement desktopBtn;
    @FindBy (css = "label[for ='tree-node-notes']")
    private WebElement notes;
    @FindBy (css = "label[for ='tree-node-commands']")
    private WebElement commands;

    @FindBy (xpath = "//span[@aria-label='Select Documents']" +
            "/preceding-sibling::span[contains(@class, 'rc-tree-switcher')]")
    private WebElement documentsBtn;
    @FindBy(css = "label[for ='tree-node-workspace']")
    private WebElement workSpace;
    @FindBy (xpath = "//span[@aria-label='Select Office']")
    private WebElement office;
    @FindBy (xpath = "//label[@for = 'tree-node-downloads']/preceding-sibling::button")
    private WebElement downloadsBtn;
    @FindBy(css = "label[for ='tree-node-wordFile']")
    private WebElement wordFile;
    @FindBy (css = "label[for ='tree-node-excelFile']")
    private WebElement excelFile;


    public CheckBoxPage clickHome(){
        elementActions.clickBtn(homeBtn);
        return this;
    }

    public CheckBoxPage clickDesktopIkon(){
        elementActions.clickBtn(desktopIkon);
        return this;
    }

    public CheckBoxPage clickDesktop(){
       // elementActions.clickBtn(homeBtn);
        elementActions.clickBtn(desktopBtn);
        return this;
    }

    public CheckBoxPage notes(){
        elementActions.clickBtn(notes);
        return this;
    }

    public CheckBoxPage commands(){
        elementActions.clickBtn(commands);
        return this;
    }

    public CheckBoxPage documents(){
        // elementActions.clickBtn(homeBtn);
        elementActions.clickBtn(documentsBtn);
        return this;
    }

    public CheckBoxPage workSpace(){
        elementActions.clickBtn(workSpace);
        return this;
    }

    public CheckBoxPage office(){
        elementActions.clickBtn(office);
        return this;
    }

    public CheckBoxPage downloads(){
        // elementActions.clickBtn(homeBtn);
        elementActions.clickBtn(downloadsBtn);
        return this;
    }

    public CheckBoxPage wordFile(){
        elementActions.clickBtn(wordFile);
        return this;
    }

    public CheckBoxPage ExcelFile(){
        elementActions.clickBtn(excelFile);
        return this;
    }


}
