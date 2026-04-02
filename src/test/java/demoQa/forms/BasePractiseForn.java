package demoQa.forms;

import org.example.demoQa.drivers.DriverManager;
import org.example.demoQa.forms.PractiseForm;
import org.example.demoQa.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BasePractiseForn {

    protected static RandomUtils randomUtils;
    protected static WebDriver driver;
    protected static PractiseForm practiseForm;

    @BeforeAll
    public static void setUpBrowser(){
        driver = DriverManager.getDriver();
        practiseForm = new PractiseForm();
    }

//    @AfterAll
//    public static void tearDown(){
//        DriverManager.closeDriver();
//    }
}
