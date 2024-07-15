package com.restful.booker.model;

public class BookingPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;

    public BookingDataPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDataPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    private BookingDataPojo bookingdates;
    private String additionalneeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }


    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }


    public static  BookingPojo getBookingPojo(String firstName,String lastName,int totalPrice, boolean depositPaid,String checkin,String  checkout,String additionalNeeds){

        BookingDataPojo bookingDatePojo = new BookingDataPojo();
        bookingDatePojo.setCheckin(checkin);
        bookingDatePojo.setCheckout(checkout);

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice(totalPrice);
        bookingPojo.setDepositpaid(depositPaid);
        bookingPojo.setBookingdates(bookingDatePojo);
        bookingPojo.setAdditionalneeds(additionalNeeds);
        return bookingPojo;
    }


}

