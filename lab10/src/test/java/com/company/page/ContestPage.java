package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContestPage extends AbstractPage {
    private final By contestRestaurantsLocator = By.xpath("//a[@href='/TravelersChoice-Restaurants']");

    public ContestPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ContestPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public RestaurantsPage openContestRestaurants(){
        WebElement restaurants = findByLocator(contestRestaurantsLocator);
        restaurants.click();
        return new RestaurantsPage(driver);
    }
}
