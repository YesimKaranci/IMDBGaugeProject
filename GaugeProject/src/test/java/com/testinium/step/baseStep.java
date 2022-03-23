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
    public By yearsRow = By.xpath("//div[@class='event-history-widget__years-row']//span//a");
    List<WebElement> list = driver.findElements(yearsRow);

    @Step("Websitesi anasayfasına git")
    public void homePage() {
        Assert.assertTrue("Web sitesi görüntülenmedi!", isEnabled(menu));
    }

    @Step("Arama çubuğunun solunda bulunan Menü butonuna basılır")
    public void clickMenu() {
        click(menu);
    }

    @Step("Gelen ekranda <Oscars> butonuna tıklanır")
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


    @Step("Event History başlığı altında <1929> seçilir")
    public void selectHistory(String tarih) {
        for (WebElement i : list) {
            if (i.getText() == tarih) {
                System.out.println(i.getText() + " tarihi seçildi");
                i.click();

            }
        }
    }
}







