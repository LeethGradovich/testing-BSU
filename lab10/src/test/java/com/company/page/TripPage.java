package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TripPage extends AbstractPage {

    private final By searchLocator = By.xpath("//input[@type='text']");
    private final By searchResultLocator = By.xpath("//div[@class='cMbqE _c _a H Ne']");
    private final By placeNameLocator = By.xpath("//div[@class='OuiNA b']");

    public TripPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TripPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public TripPage inputSearch(String place){
        WebElement search = findByLocator(searchLocator);
        search.click();
        search.sendKeys(place);
        return this;
    }

    public TripPage selectResult(){
        WebElement searchResult = findByLocatorWithClickableCondition(searchResultLocator);
        searchResult.click();
        return this;
    }

    public String getPlaceName(){
        return getElementText(placeNameLocator);
    }
}
