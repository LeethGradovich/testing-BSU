package com.company.service;

public final class TestCreatorService {
    private static final String TESTDATA_TEST_TRIP = "testdata.test.trip";
    private static final String TESTDATA_TEST_CITY = "testdata.test.city";
    private static final String TESTDATA_TEST_AIRCOMPANY = "testdata.test.aircompany";
    private static final String TESTDATA_TEST_RESTAURANT = "testdata.test.restaurant";

    public static String withTripFromProperty(){
        return TestDataReaderService.getTestData(TESTDATA_TEST_TRIP);
    }

    public static String withCityFromProperty(){
        return TestDataReaderService.getTestData(TESTDATA_TEST_CITY);
    }
    public static String withAirCompanyFromProperty(){
        return TestDataReaderService.getTestData(TESTDATA_TEST_AIRCOMPANY);
    }
    public static String withRestaurantFromProperty(){
        return TestDataReaderService.getTestData(TESTDATA_TEST_RESTAURANT);
    }
}
