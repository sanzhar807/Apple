package demoQa.alertFrameWindow;

import demoQa.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class AlertTest extends BaseTest {

    @Test
    void alertTest(){
        driver.get("https://demoqa.com/alerts");
        alertPage.clickAlertBtn();
        alertHelper.accept();
        alertPage.clickAlertBtn();
        alertHelper.dismis();
        alertPage.promtButton();
        alertHelper.sendKeys("koko shnene").accept();
    }
}
