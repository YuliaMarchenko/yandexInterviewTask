package com.telran.testTask.fw;

import com.telran.testTask.models.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MarketHelper extends HelperBase{
    public MarketHelper(WebDriver wd) {
        super(wd);
    }

    public void typeAndSearchInputField(String itemName) {
        type(By.id("header-search"), itemName);
        click(By.cssSelector("[data-r='search-button']"));
    }

    public String getItemName(int number) {
        return wd.findElement(By.cssSelector("div:nth-child(" + number + ") ._2UHry")).getText();
    }

    public void filterItem(Item item) {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        type(By.cssSelector("._1heDd:nth-child(1) ._3qxDp"), item.getPriceFrom());
        type(By.cssSelector("._1heDd:nth-child(2) ._3qxDp"), item.getPriceTo());
        click(By.xpath("//span[text()='" + item.getBrand() + "']"));
    }

    public void selectCategoryType(String type) {
        click(By.xpath("//a[contains(.,'" + type + "')]"));
    }

    public void selectCatalog(String category) {
        click(By.xpath("//*[@data-zone-name='snippet']//a[contains(.,'" + category + "')]"));
    }

    public void selectDepartment(String department) {
        click(By.xpath("//a[contains(.,'" + department + "')]"));
    }

    public void selectMarket() {
        click(By.cssSelector("[data-id='market']"));
    }
}
