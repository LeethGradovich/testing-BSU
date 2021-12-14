package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TripsPage extends AbstractPage {
    private static final String BASE_URL = "https://www.tripadvisor.ru/Trips";

    private final By tripCreationFormLocator = By.xpath("//*[@class='emUQn u Gi B1 Z BB z _S _Z w']");
    private final By inputTripNameLocator = By.xpath("//*[@name='tripName']");
    private final By tripCreationButtonLocator = By.xpath("//*[@class='fGwNR _G B- z _S c Wc ddFHE ezIjy brHeh bXBfK']");
    private final By tripLocator = By.xpath("//div[contains(@class, 'HOXFJ b o _a') and contains(.,'trip1')]");

    public TripsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public TripsPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public TripsPage openTripCreationForm() {
        WebElement tripCreationForm = findByLocator(tripCreationFormLocator);
        tripCreationForm.click();
        return this;
    }

    public TripsPage createTrip(String name) {
        WebElement inputTripName = findByLocator(inputTripNameLocator);
        inputTripName.sendKeys(name);
        WebElement createTripButton = findByLocatorWithClickableCondition(tripCreationButtonLocator);
        createTripButton.click();
        return this;
    }

    public String getTripName() {
        return getElementText(tripLocator);
    }

    public TripPage openCreatedTripPage(){
        WebElement trip = findByLocator(tripLocator);
        trip.click();
        return new TripPage(driver);
    }

}
