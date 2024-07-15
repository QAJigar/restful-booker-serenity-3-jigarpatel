package com.restful.booker.crudtest;

import com.restful.booker.restfulbookerinfo.BookingSteps;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class BookingCrudTest  extends TestBase {

    static String firstName = "Prime";
    static String lastName = "Testing";
    static int totalPrice = 499;
    static boolean depositPaid = true;
    static String checkin = "2024-03-02";
    static String checkout = "2024-07-28";
    static String additionalNeeds = "Dinner";
    static int bookingId;
    ValidatableResponse response;
    @Steps
    BookingSteps bookingSteps;


    @Title("Creating new Booking")
    @Test
    public void verifyBookingCreatedSuccessfully() {

        response = bookingSteps.createBooking(firstName,lastName,totalPrice,depositPaid,checkin,checkout,additionalNeeds);
        response.statusCode(200);
        response.log().body();
        bookingId = response.extract().path("bookingid");
    }

    @Title("Verify that details added successfully")
    @Test
    public void verifyBookingReadSuccessfully() {
       response=bookingSteps.getBookingInfoById(bookingId);
       response.statusCode(200);
    }

    @Title("Updating booking")
    @Test
    public void verifyBookingUpdateSuccessfully() {

        String updatedFirstName = firstName + "Jigar";

        response = bookingSteps.updateBookingInfoById(bookingId, updatedFirstName, lastName, totalPrice, depositPaid, checkin, checkout, additionalNeeds);
        response.statusCode(200);

    }
    @Title("Deleting Booking")
    @Test
    public void VerifyBookingDeleteSuccessfully() {
        bookingSteps.deleteBooking(bookingId)
        .statusCode(201);
        bookingSteps.getBookingInfoById(bookingId)
                .statusCode(404);
    }

}
