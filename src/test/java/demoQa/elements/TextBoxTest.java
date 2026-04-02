package demoQa.elements;

import demoQa.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("UI")
public class TextBoxTest extends BaseTest {
    @Test
    void textBoxTest(){
        driver.get("https://demoqa.com/text-box");
        textBoxPage.fillUserName("Naaame").
                fillUserEmail("amanturov2471@gmail.com").
                fillCurrentAddress("Koko 123").
                fillPermanentAddress("mira 123").
                submit();
    }
}
