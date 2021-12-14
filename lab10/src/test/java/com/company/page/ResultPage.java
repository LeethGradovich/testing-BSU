package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ResultPage extends AbstractPage {
    private final By cityNameLocator = By.xpath("//*[@class='{geoClass}']");
    private final By restaurantNameLocator = By.xpath("//h1[@data-test-target='top-info-header']");

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ResultPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public String getCityName() {
        return getElementText(cityNameLocator);
    }





    public String getRestaurantName(){
        return getElementText(restaurantNameLocator);
    }
}
