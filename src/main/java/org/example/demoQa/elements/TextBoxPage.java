package org.example.demoQa.elements;


import org.example.demoQa.models.UserTextBox;
import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submit;

    public TextBoxPage fillUserName(String name){
        elementActions.inputText(userName,name);
        return this;
    }

    public TextBoxPage fillUserEmail(String email){
        elementActions.inputText(userEmail,email);
        return this;
    }

    public TextBoxPage fillCurrentAddress(String currentAdd){
        elementActions.inputText(currentAddress,currentAdd);
        return this;
    }

    public TextBoxPage fillPermanentAddress(String perAdd){
        elementActions.inputText(permanentAddress,perAdd);
        return this;
    }

    public TextBoxPage submit(){
        elementActions.clickBtn(submit);
        return this;
    }

    public TextBoxPage fillUpTextBoxForm(UserTextBox user){
        fillUserName(user.getUserName()).fillUserEmail(user.getUserEmail()).fillCurrentAddress(user
                .getUserCurrentAddress()).fillPermanentAddress(user.getUserPermanentAddress()).submit();
        return this;
    }
}
