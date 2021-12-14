package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage extends AbstractPage {

    private final By cityLinkLocator = By.xpath("//a[@id='global-nav-tourism']");

    public HotelsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public HotelsPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public String getHotelCityName(){
        return getElementText(cityLinkLocator);
    }

}
