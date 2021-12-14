package com.company.service;

import com.company.model.User;

public class UserCreatorService {
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReaderService.getTestData(TESTDATA_USER_EMAIL),
                TestDataReaderService.getTestData(TESTDATA_USER_PASSWORD));
    }

}
