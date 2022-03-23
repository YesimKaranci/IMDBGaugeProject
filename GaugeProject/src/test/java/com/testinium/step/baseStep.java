package com.testinium.step;

import com.testinium.util.BasePageUtil;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class baseStep extends BasePageUtil {

    public By menu = By.id("imdbHeader-navDrawerOpen--desktop");
    public By actual = By.xpath("(//*[@class='ipc-list__item nav-link sc-fKFyDc nwOmR ipc-list__item--indent-one']//*[@class='ipc-list-item__text'])[22]");
    public By yearsRow = By.xpath("//div[@class='event-history-widget__years']//div[@class='event-history-widget__years-row'][16]//span");
    public By move = By.cssSelector("span[class='event-widgets__nominee-name']");
    List<WebElement> list = driver.findElements(move);
    public By award = By.xpath("(//*[@class='event-widgets__award-name'])[2]");

    @Step("Websitesi anasayfasına git")
    public void homePage() {
        Assert.assertTrue("Web sitesi görüntülenmedi!", isEnabled(menu));
    }

    @Step("Arama çubuğunun solunda bulunan Menü butonuna basılır")
    public void clickMenu() {
        click(menu);
    }

    @Step("Gelen ekranda <category> butonuna tıklanır")
    public void clickCategory(String category) {
        click(actual);

        /*
        for (WebElement i:categorylist) {

            String text = i.getText();
            if (text == "Oscars") {
                click(actual);
            } else {
                System.out.println(text + " bulunmadı!!!");
            } */
    }

    @Step("Event History başlığı altında <history> seçilir")
    public void selectHistory(String history) {
        thread(3000);
        clickElementOnList(yearsRow, 3);

        //System.out.println("Listenin boyutu : "+list.size());
        // System.out.println("Listenin son elemanı" +list.get(3).getText());
        //list.get(3).click();
    }

    @Step("Honorary Award başlığı altında <move> seçilir")
    public void selectMove(String move) {
        //hoverElement(award);
        for(WebElement i:list){
            System.out.println("Dizi boyutu " +move.length());
            if (i.getText() == move){
                i.click();
            }
        }

    }
}







