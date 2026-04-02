package org.example.demoQa.drivers;

import org.example.demoQa.helpers.FastFirefoxConfig;
import org.example.demoQa.utils.FileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        // ЕСЛИ драйвер уже создан - возвращаем его
        if(driver != null){
            return driver;
        }

        // ИНАЧЕ создаем новый
        switch(FileReader.getValue("browser").toLowerCase()){
            case "chrome":
                driver = ChromeWebDriver.loadChromeDriver();
                break;
            case "edge":
                driver = EdgeWebDriver.loadEdgeDriver();
                break;
            case "firefox": // ← исправьте "mozila" на "firefox"
            case "mozila":
                FirefoxOptions options = FastFirefoxConfig.getFastOptions();
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Wrong driver: " +
                        FileReader.getValue("browser"));
        }
        return driver;
    }

    public static void closeDriver(){
        try {
            if(driver != null){
                //driver.quit(); // ← только quit(), close() не нужен
                driver = null;
            }
        } catch (Exception e){
            System.err.println("Error while closing driver: " + e.getMessage());
        }
    }
}
