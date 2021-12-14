package com.company.test;

import com.company.model.User;
import com.company.page.MainPage;
import com.company.page.TripsPage;
import com.company.service.TestCreatorService;
import com.company.service.UserCreatorService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TripManagementTests extends CommonConditions {

    private final String EXPECTED_TRIP_NAME = TestCreatorService.withTripFromProperty();
    private final String EXPECTED_CITY_NAME = TestCreatorService.withCityFromProperty();
    private final String EXPECTED_CITY_NAME_RUS = "Лондон";

    @Test
    public void tripCreationTest() {
        User testUser = UserCreatorService.withCredentialsFromProperty();
        TripsPage tripsPage = new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login(testUser)
                .invokeTripsPage();
        String createdTripName = tripsPage.openTripCreationForm()
                .createTrip(EXPECTED_TRIP_NAME)
                .getTripName();

        Assert.assertEquals(EXPECTED_TRIP_NAME, createdTripName);
    }

    @Test
    public void addCityToTripTest(){
        User testUser = UserCreatorService.withCredentialsFromProperty();
        TripsPage tripsPage = new MainPage(driver)
                .openPage()
                .openLoginForm()
                .login(testUser)
                .invokeTripsPage();

        String resultName = tripsPage.openCreatedTripPage()
                .inputSearch(EXPECTED_CITY_NAME)
                .selectResult()
                .getPlaceName();

        Assert.assertEquals(EXPECTED_CITY_NAME_RUS, resultName);
    }
}
