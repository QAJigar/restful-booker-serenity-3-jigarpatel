package com.restful.booker.testbase;

import com.restful.booker.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    public static PropertyReader propertyReader;



    @BeforeClass
    public static void inIt() {

        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = PropertyReader.getInstance().getProperty("baseUrl");
    }

}
