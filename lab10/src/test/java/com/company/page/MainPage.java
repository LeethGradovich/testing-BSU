package com.company.page;

import com.company.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends AbstractPage {

    private static final String BASE_URL = "https://www.tripadvisor.ru/";
    private String parentWindow;
    private final By frameLocator = By.xpath("//iframe[@class='eBsLQ _R B- o']");
    private final By loginFormLocator = By.xpath("//*[@class='fGwNR _G B- z _S c Wc ddFHE fRPQK w fNnhN brHeh']");
    private final By loginByEmailLocator = By.xpath("//*[@class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']");
    private final By tripsLocator = By.xpath("//a[@class='dfuux f u j _T z _F ddFHE bVTsJ dQDUG bsyQH']");

    @FindBy(xpath = "//*[@id='regSignIn.email']")
    private WebElement inputEmail;
    @FindBy(xpath = "//*[@id='regSignIn.password']")
    private WebElement inputPassword;

    private final By buttonLoginLocator = By.xpath("//*[@class='ui_button primary coreRegPrimaryButton  regSubmitBtnEvent']");
    private final By searchLocator = By.xpath("//input[@name='q']");
    private final By cityResultLocator = By.xpath("//*[@class='bPaPP w z _S _F Wc Wh Q B- _G']");
    private final By hotelFormLocator = By.xpath("//a[@class='ebMYO Ra _S z _Z w o v _Y Wh k _T ddFHE']");
    private final By moreListLocator = By.xpath("//button[@class='ebMYO Ra _S z _Z w o v _Y Wh k _T ddFHE']");
    private final By airCompaniesLocator = By.xpath("//*[@id='menu-item-1']");
    private final By contestLocator = By.xpath("//*[@id='menu-item-4']");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public MainPage openLoginForm() {
        parentWindow = driver.getWindowHandle();
        WebElement loginForm = findByLocatorWithClickableCondition(loginFormLocator);
        loginForm.click();
        WebElement fr = findByLocator(frameLocator);
        driver.switchTo().frame(fr);
        WebElement loginByEmailButton = findByLocatorWithClickableCondition(loginByEmailLocator);
        loginByEmailButton.click();
        return this;
    }

    public MainPage login(User user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        WebElement buttonLogin = findByLocatorWithClickableCondition(buttonLoginLocator);
        buttonLogin.click();
        driver.switchTo().window(parentWindow);
        return this;
    }

    public TripsPage invokeTripsPage() {
        WebElement tripsButton = findByLocator(tripsLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(tripsButton).pause(1000).perform();
        tripsButton.click();
        return new TripsPage(driver);
    }

    public MainPage openSearch(){
        List<WebElement> search = findAllByLocator(searchLocator);
        search.get(1).click();
        search.get(1).click();
        return this;
    }

    public MainPage inputCity(String city){
        List<WebElement> search = findAllByLocator(searchLocator);
        search.get(1).sendKeys(city);
        return this;
    }

    public ResultPage selectCity(String city){
        WebElement cityResult = findByLocator(cityResultLocator);
        if (checkTextPresence(cityResult, city)) cityResult.click();
        return new ResultPage(driver);
    }

    public MainPage openHotelForm(){
        WebElement hotelForm = findByLocator(hotelFormLocator);
        hotelForm.click();
        return this;
    }

    public MainPage inputCityHotel(String city){
        List<WebElement> search = findAllByLocator(searchLocator);
        search.get(2).sendKeys(city);
        return this;
    }
    public HotelsPage selectHotelCity(String city){
        WebElement hotelResult = findByLocator(cityResultLocator);
        if (checkTextPresence(hotelResult, city)) hotelResult.click();
        return new HotelsPage(driver);
    }

    public MainPage openMoreList(){
        WebElement moreList = findByLocator(moreListLocator);
        moreList.click();
        return this;
    }
    public AirCompanyListPage openAirCompaniesPage(){
        WebElement airCompanies = findByLocator(airCompaniesLocator);
        airCompanies.click();
        return new AirCompanyListPage(driver);
    }

    public ContestPage openContestPage(){
        WebElement contest = findByLocator(contestLocator);
        contest.click();
        return new ContestPage(driver);
    }
}
