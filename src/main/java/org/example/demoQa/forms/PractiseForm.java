package org.example.demoQa.forms;

import org.example.demoQa.drivers.DriverManager;
import org.example.demoQa.models.UserPractiseForm;
import org.example.demoQa.pages.BasePage;
import org.example.demoQa.utils.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PractiseForm extends BasePage {
    RandomUtils random = new RandomUtils();


    @FindBy(id = "firstName" )
    private WebElement firstName;

    @FindBy(id = "lastName" )
    private WebElement lastName;

    @FindBy(id = "userEmail" )
    private WebElement userEmail;

    @FindBy(css = "label[for='gender-radio-1']" )
    private WebElement male;

    @FindBy(css = "label[for='gender-radio-2']" )
    private WebElement female;

    @FindBy(css = "label[for='gender-radio-3']" )
    private WebElement other;

    @FindBy(id = "userNumber" )
    private WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;

    @FindBy(id = "subjectsInput" )
    private WebElement subject;

    @FindBy(css = "label[for='hobbies-checkbox-1']" )
    private WebElement sports;

    @FindBy(css = "label[for='hobbies-checkbox-2']" )
    private WebElement reading;

    @FindBy(css = "label[for='hobbies-checkbox-3']" )
    private WebElement music;

    @FindBy(id = "currentAddress" )
    private WebElement currentAddress;
    @FindBy(id = "submit")
    private WebElement button;

    @FindBy(css = ".react-datepicker__input-container")
    private WebElement datePicker;

    @FindBy(id = "uploadPicture")
    public WebElement Picture;

    public PractiseForm uploadPicture(String pictureLink){
        elementActions.inputText(Picture,pictureLink);
        return this;
    }

    public PractiseForm selectDOB(String dateMonthYear){
        String[] dateMonthYearParts = dateMonthYear.split(" ");
        String day = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];
        elementActions.clickBtn(datePicker);
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(), Duration.ofSeconds(10));
        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__month-select")));
        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("react-datepicker__year-select")));
        elementActions.selectByVisibleText(monthDropDown,month);
        elementActions.selectByVisibleText(yearDropDown,year);
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'react-datepicker__day') " +
                        "and not(contains(@class,'react-datepicker__day--outside-month'))" +
                        " and text()='" + day + "']")));
        elementActions.clickBtn(dayElement);
        return this;
    }

    public PractiseForm fillFirstName(String name){
        elementActions.inputText(firstName,name);
        return this;
    }

    public PractiseForm fillLastName(String name){
        elementActions.inputText(lastName,name);
        return this;
    }

    public PractiseForm chooseGender(String name){
        switch (name){
            case "Male": elementActions.waitElementToBeClickable(male);
            break;
            case "Female":elementActions.waitElementToBeClickable(female);
            break;
            case "Other":elementActions.waitElementToBeClickable(other);
            break;
            default:{
                throw new IllegalArgumentException("not found");
            }
        }
        return this;
    }

    public PractiseForm fillMobileNumber(String number){
        elementActions.inputText(mobileNumber,number);
        return this;
    }

    public PractiseForm fillEmail(String email){
        elementActions.inputText(userEmail,email);
        return this;
    }

    public PractiseForm fillDateOfBirth(){

        return this;
    }

    public PractiseForm fillSubject(String subjectP) {
        elementActions.inputText( subject,subjectP);
        subject.click();
        return this;
    }

    public PractiseForm chooseHobbies(String hob){
        if (hob.equalsIgnoreCase("sports")){
            sports.click();
        }else if (hob.equalsIgnoreCase("reading")){
            reading.click();
        }else if (hob.equalsIgnoreCase("music")){
            music.click();
        }else {
            throw new IllegalArgumentException("Not found");
        }
        return this;
    }

    public PractiseForm fillCurrentAddress(String address){
        elementActions.inputText(currentAddress,address);
        return this;
    }

    public PractiseForm submit(){
        elementActions.waitElementToBeClickable(button);
        button.click();
        return this;
    }

    public PractiseForm choseSubject(UserPractiseForm user) {
        int el = random.randomNumberOneToFour();
        List<Integer> usedIndexes = new ArrayList<>();
        while (el > 0) {
            int num;
            do {
                num = random.randomNumber(user.getSubject().size());
            } while (usedIndexes.contains(num));
            usedIndexes.add(num);
            elementActions.waitElementToBeVisible(subject);
            elementActions.inputText(subject, user.getSubject().get(num));
            subject.sendKeys(Keys.ENTER);
            el--;
        }

        return this;
    }

    public  PractiseForm fillPractiseForm(UserPractiseForm user){
        fillFirstName(user.getFirsName()).
                fillLastName(user.getLastName()).
                fillEmail(user.getEmail()).
                chooseGender(user.getGender()).
                fillMobileNumber(user.getPhoneNumber()).
                choseSubject(user).
                chooseHobbies(user.getHobbies()).
                fillCurrentAddress(user.getCurrentAddress());
        return this;
    }

    public void check(){
        System.out.println(RandomUtils.generatePracticeFormUser().getFirsName());
    }
}


//public ElementActions replaceText(WebElement webElement, String text) {
//    waitElementToBeVisible(webElement);
//    webElement.sendKeys(Keys.CONTROL + "a");
//    webElement.sendKeys(text);
//    webElement.sendKeys(Keys.ENTER);
//    return this;
//}