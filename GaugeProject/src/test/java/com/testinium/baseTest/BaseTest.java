package com.testinium.baseTest;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private final String driverName = "webdriver.gecko.driver";
    private final String driverPath = "driver/geckodriver";
    private final String url = "https://www.imdb.com/";

    public static WebDriver getDriver() { return driver; }
    public static WebDriverWait getWait(){return wait;}

    @BeforeScenario
    public void setup(){
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty(driverName,driverPath);
        driver=new FirefoxDriver(options); //ön ayarlarla kalkar
        driver.navigate().to(url);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,60,500);
    }

    @AfterScenario
    public void tearDown(){
        driver.quit(); //tarayıcıyı kapat
    }

}
