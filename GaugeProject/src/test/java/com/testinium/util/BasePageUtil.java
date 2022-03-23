package com.testinium.util;

import com.testinium.baseTest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageUtil {

    public WebDriver driver = BaseTest.getDriver();
    public WebDriverWait wait = BaseTest.getWait();

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }
    public void clickElementOnList (By by, int index){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElements(by).get(index).click();
    }
    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void doubleClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Actions act = new Actions(driver);
        act.doubleClick().perform();
    }
    public void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).sendKeys(text);
    }

    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(findElement(by)).build().perform();
    }
    public void swipeToElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        getExecutor().executeScript("arguments[0].scrollIntoViewIfNeeded();",by);
    }
    public String getText(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }

    public String getAttribute(By by,String text)  {
        return findElement(by).getAttribute(text);
    }

    public boolean isElementDisplayed(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return findElement(by).isDisplayed();
    }

    public boolean isEnabled(By by) {
        return  findElement(by).isEnabled();
    }

    public void keyENTER(By by){
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public JavascriptExecutor getExecutor(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor;
    }

    public void thread(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
