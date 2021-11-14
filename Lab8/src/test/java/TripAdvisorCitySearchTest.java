import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TripAdvisorCitySearchTest {
    private WebDriver driver;
    private static final String CITY = "Лондон";

    @BeforeMethod(alwaysRun = true)
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "/usr/lib/chromium-browser/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void citySearchTest() throws InterruptedException {
        TripAdvisorHomePage homePage = new TripAdvisorHomePage(driver);
        homePage.openHomePage().
                acceptCookie().
                openSearch().
                enterCity(CITY);
        Thread.sleep(2000);
        homePage.selectCity();

        TripAdvisorResultPage resultPage = new TripAdvisorResultPage(driver);
        resultPage.openResultPage();

        Assert.assertEquals(homePage.getCurrentUrl(), resultPage.getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
