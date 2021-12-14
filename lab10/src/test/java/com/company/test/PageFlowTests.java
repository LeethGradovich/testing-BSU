package com.company.test;

import com.company.page.*;
import com.company.service.TestCreatorService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageFlowTests extends CommonConditions {
    private final String EXPECTED_CITY_NAME = TestCreatorService.withCityFromProperty();
    private final String EXPECTED_AIR_COMPANY_NAME = TestCreatorService.withAirCompanyFromProperty();
    private final String EXPECTED_RESTAURANT_NAME = TestCreatorService.withRestaurantFromProperty();
    private final String EXPECTED_CITY_NAME_RUS = "Лондон";
    private final String EXPECTED_AIR_COMPANY_NAME_RUS = "Аэрофлот";

    @Test
    public void citySearchTest() {
        ResultPage testPage = new MainPage(driver)
                .openPage()
                .openSearch()
                .inputCity(EXPECTED_CITY_NAME)
                .selectCity(EXPECTED_CITY_NAME_RUS);
        String resultCityName = testPage.getCityName();

        Assert.assertEquals(EXPECTED_CITY_NAME_RUS, resultCityName);
    }

    @Test
    public void hotelSearchTest() {
        MainPage mainPage = new MainPage(driver);
        HotelsPage hotelsPage = mainPage.openPage()
                .openHotelForm()
                .inputCityHotel(EXPECTED_CITY_NAME)
                .selectHotelCity(EXPECTED_CITY_NAME_RUS);
        String resultCityName = hotelsPage.getHotelCityName();

        Assert.assertEquals(EXPECTED_CITY_NAME_RUS, resultCityName);
    }

    @Test
    public void airCompanyTest(){
        MainPage mainPage = new MainPage(driver);
        AirCompanyListPage airCompanyListPage = mainPage.openPage()
                .openMoreList()
                .openAirCompaniesPage();
        AirCompanyPage airCompanyPage = airCompanyListPage.openAirCompanyPage();
        String resultAirCompanyName = airCompanyPage.getAirCompanyName();

        Assert.assertEquals(EXPECTED_AIR_COMPANY_NAME_RUS, resultAirCompanyName);
    }

    @Test
    public void bestRestaurantTest(){
        MainPage mainPage = new MainPage(driver);
        ContestPage contestPage = mainPage.openPage()
                .openMoreList()
                .openContestPage();
        RestaurantsPage restaurantsPage = contestPage.openContestRestaurants();
        ResultPage resultPage = restaurantsPage.openWinnerRestaurant();
        String resultRestaurant = resultPage.getRestaurantName();

        Assert.assertEquals(EXPECTED_RESTAURANT_NAME, resultRestaurant);
    }
}
