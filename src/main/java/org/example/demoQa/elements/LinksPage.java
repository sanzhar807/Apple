package org.example.demoQa.elements;

import org.example.demoQa.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LinksPage extends BasePage {

    @FindBy(id = "simpleLink")
    private WebElement home;
    @FindBy(id = "dynamicLink")
    private WebElement dynamicHome;
    @FindBy(id = "created")
    private WebElement created;
    @FindBy(id = "no-content")
    private WebElement noContent;
    @FindBy(id = "moved")
    private WebElement moved;
    @FindBy(id = "bad-request")
    private WebElement badRequest;
    @FindBy(id = "unauthorized")
    private WebElement unauthorized;
    @FindBy(id = "forbidden")
    private WebElement forbidden;
    @FindBy(id = "invalid-url")
    private WebElement notFound;
    protected List<WebElement> list = List.of(home,dynamicHome,created,noContent,moved,badRequest,unauthorized,
            forbidden,notFound);

    public List<WebElement> list(){
        return list;
    }

//    public LinksPage clickLink(WebElement element){
//
//    }

    public LinksPage homeLink(){
        elementActions.clickBtn(home);
        return this;
    }

    public LinksPage createdLink(){
        elementActions.clickBtn(created);
        return this;
    }

    public LinksPage homeDynamic(){
        elementActions.clickBtn(dynamicHome);
        return this;
    }

    public LinksPage noContent(){
        elementActions.clickBtn(noContent);
        return this;
    }

    public LinksPage moved(){
        elementActions.clickBtn(moved);
        return this;
    }

    public LinksPage badRequest(){
        elementActions.clickBtn(badRequest);
        return this;
    }

    public LinksPage unauthorized(){
        elementActions.clickBtn(unauthorized);
        return this;
    }

    public LinksPage forbidden(){
        elementActions.clickBtn(forbidden);
        return this;
    }

    public LinksPage notFound(){
        elementActions.clickBtn(notFound);
        return this;
    }
}
