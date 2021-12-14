package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AirCompanyPage extends AbstractPage {
    private final By airCompanyNameLocator = By.xpath("//h1[@class='fKwHO b']");

    public AirCompanyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AirCompanyPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public String getAirCompanyName(){
        return getElementText(airCompanyNameLocator);
    }

}
