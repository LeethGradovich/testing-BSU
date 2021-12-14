package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AirCompanyListPage extends AbstractPage {

    private final By airCompanyLocator = By.xpath("//div[@data-name='Aeroflot']");

    public AirCompanyListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public AirCompanyListPage openPage() {
        driver.navigate().to(driver.getCurrentUrl());
        return this;
    }

    public AirCompanyPage openAirCompanyPage(){
        WebElement airCompany = findByLocator(airCompanyLocator);
        airCompany.click();
        return new AirCompanyPage(driver);
    }
}
