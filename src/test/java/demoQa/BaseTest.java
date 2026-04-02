package demoQa;

import org.example.demoQa.HWNavigateBrowser;
import org.example.demoQa.alertsFrameWindow.AlertPage;
import org.example.demoQa.alertsFrameWindow.Frame;
import org.example.demoQa.alertsFrameWindow.WindowPage;
import org.example.demoQa.drivers.DriverManager;
import org.example.demoQa.elements.*;
import org.example.demoQa.helpers.AlertHelper;
import org.example.demoQa.helpers.BroserHelper;
import org.example.demoQa.helpers.IFrameHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

   protected static WebDriver driver;
   protected static TextBoxPage textBoxPage;
   protected static ButtonsPage buttonsPage;
   protected static AlertPage alertPage;
   protected static AlertHelper alertHelper;
   protected static CheckBoxPage checkBoxPage;
   protected static WebTables webTables;
   protected static LinksPage linksPage;
   protected static BroserHelper broserHelper;
   protected static HWNavigateBrowser hwNavigateBrowser;
   protected static WindowPage windowPage;
   protected static Frame frame;
protected static IFrameHelper iFrameHelper;

    @BeforeAll
    public static void setUpBrowser() {
        driver = DriverManager.getDriver();
        textBoxPage = new TextBoxPage();
        webTables = new WebTables();
        windowPage = new WindowPage();
        buttonsPage = new ButtonsPage();
        linksPage = new LinksPage();
        checkBoxPage = new CheckBoxPage();
        alertPage = new AlertPage();
        broserHelper = new BroserHelper(driver);
        hwNavigateBrowser = new HWNavigateBrowser();
        alertHelper = new AlertHelper(driver);
        frame = new Frame();
        iFrameHelper = new IFrameHelper(driver);
    }

    @BeforeEach
    public void checkDriver(){
        driver = DriverManager.getDriver();
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.closeDriver();
    }
}
