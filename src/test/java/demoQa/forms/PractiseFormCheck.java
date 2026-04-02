package demoQa.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PractiseFormCheck extends BasePractiseForn {

    public void check(){

    }
    String text;
    WebElement name = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),"+ text +")]"));

}
