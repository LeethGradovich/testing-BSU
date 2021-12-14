package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsPage extends AbstractPage {
    private final By restaurantLocator = By.xpath("//a[@target='_blank']");

    public RestaurantsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RestaurantsPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public ResultPage openWinnerRestaurant(){
        List<WebElement> winners = findAllByLocator(restaurantLocator);
        winners.get(0).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return new ResultPage(driver);
    }

}
