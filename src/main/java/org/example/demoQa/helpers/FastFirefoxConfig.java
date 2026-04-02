package org.example.demoQa.helpers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FastFirefoxConfig {
    public static FirefoxOptions getFastOptions() {
        FirefoxOptions options = new FirefoxOptions();

        // Отключаем ненужные логи
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_PROFILE, "/dev/null");

        // Быстрые настройки
        options.addArguments("--start-maximized");

        // Отключаем некоторые проверки
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.tabs.remote.autostart", false);
        profile.setPreference("browser.tabs.remote.autostart.2", false);

        options.setProfile(profile);
        return options;
    }
}
