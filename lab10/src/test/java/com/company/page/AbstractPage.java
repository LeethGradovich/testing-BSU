package com.company.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage
{
    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 30;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement findByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement findByLocatorWithClickableCondition(By locator){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS*2)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> findAllByLocator(By locator) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean checkTextPresence(WebElement element, String text){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public String getElementText(By locator){
        WebElement element = findByLocator(locator);
        return element.getText();
    }

    public String getElementListText(By locator){
        List<WebElement> element = findAllByLocator(locator);
        return element.get(3).getText();
    }
}