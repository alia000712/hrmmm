package com.demo3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class booking implements Serializable
{
    public String bookingID;
    public String bookingPlace;
    public LocalDateTime bookingDateTime;
    public String workerID;
    public String customerID;
    public String packageID;

    public booking(){}

    public booking(String bookingID, String bookingPlace, LocalDateTime bookingDateTime, String workerID, String customerID, String packageID)
    {
        this.bookingID = bookingID;
        this.bookingPlace = bookingPlace;
        this.bookingDateTime = bookingDateTime;
        this.workerID = workerID;
        this.customerID = customerID;
        this.packageID = packageID;
    }

    public String getBookingID() {return bookingID;}
    public String getBookingPlace() {return bookingPlace;}
    public LocalDateTime getBookingDateTime() {return bookingDateTime;}
    public String getWorkerID() {return workerID;}
    public String getCustomerID() {return customerID;}
    public String getPackageID() {return packageID;}

    public void setBookingID(String bookingID) {this.bookingID = bookingID;}
    public void setBookingPlace(String bookingPlace) {this.bookingPlace = bookingPlace;}
    public void setBookingDateTime(LocalDateTime bookingDateTime) {this.bookingDateTime = bookingDateTime;}
    public void setWorkerID(String workerID) {this.workerID = workerID;}
    public void setCustomerID(String customerID) {this.customerID = customerID;}
    public void setPackageID(String packageID) {this.packageID = packageID;}

    public String printBooking()
    {
        return "booking{" +
                "bookingID='" + bookingID + '\'' +
                ", bookingPlace='" + bookingPlace + '\'' +
                ", bookingDateTime=" + bookingDateTime +
                ", workerID='" + workerID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", packageID='" + packageID + '\'' +
                '}';
    }
}
