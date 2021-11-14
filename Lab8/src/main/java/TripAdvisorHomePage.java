import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TripAdvisorHomePage {
    private WebDriver driver ;
    private static final String HOMEPAGE = "https://www.tripadvisor.ru/";

    private By searchLocator = By.xpath("//*[@id='lithium-root']/main/div[3]/div/div/div[2]/form/input[1]");
    private By cookieLocator = By.xpath("//*[@id='_evidon-accept-button']");
    private By cityInputLocator = By.xpath("//*[@id='lithium-root']/main/div[3]/div/div/div[2]/form/input[1]");
    private By cityResultLocator = By.xpath("//*[@id='typeahead_results']/a[1]");
    private By cityHotelLocator = By.xpath("//*[@id='lithium-root']/main/div[1]/div[2]/div/div/div[1]/a");

    public TripAdvisorHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TripAdvisorHomePage openHomePage() {
        driver.get(HOMEPAGE);
        return this;
    }
    public TripAdvisorHomePage acceptCookie(){
        findByLocator(cookieLocator).click();
        return this;
    }

    public TripAdvisorHomePage openSearch(){
     findByLocator(searchLocator).click();
     return this;
    }

    public WebElement findByLocator(By locator){
        return new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public TripAdvisorHomePage enterCity(String city){
        findByLocator(searchLocator).sendKeys(city);
        return this;
    }

    public TripAdvisorHomePage selectCity(){
        findByLocator(cityResultLocator).click();
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
