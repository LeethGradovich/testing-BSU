import org.openqa.selenium.WebDriver;

public class TripAdvisorResultPage {
    private WebDriver driver;
    private static final String RESULT_PAGE = "https://www.tripadvisor.ru/Tourism-g186338-London_England-Vacations.html";

    public TripAdvisorResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public TripAdvisorResultPage openResultPage() {
        driver.get(RESULT_PAGE);
        return this;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
