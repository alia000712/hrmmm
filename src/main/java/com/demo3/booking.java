package com.demo3;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

public class booking implements Serializable
{
    public int bookingID;
    public String branchID;
    public Date bookingDate;
    public String bookingTime;
    public int workerID;
    public int custID;
    public String packageID;

    public booking(){}

    public booking(int bookingID, String branchID, Date bookingDate,String bookingTime, int workerID, int custID, String packageID)
    {
        this.bookingID = bookingID;
        this.branchID = branchID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.workerID = workerID;
        this.custID = custID;
        this.packageID = packageID;
    }

    public int getBookingID() {return bookingID;}
    public String getBranchID() {return branchID;}
    public Date getBookingDate() {return bookingDate;}
    public int getWorkerID() {return workerID;}
    public int getCustID() {return custID;}
    public String getPackageID() {return packageID;}
    public String getBookingTime() {return bookingTime;}

    public void setBookingID(int bookingID) {this.bookingID = bookingID;}
    public void setBranchID(String branchID) {this.branchID = branchID;}
    public void setBookingDate(Date bookingDate) {this.bookingDate = bookingDate;}
    public void setWorkerID(int workerID) {this.workerID = workerID;}
    public void setCustID(int custID) {this.custID = custID;}
    public void setPackageID(String packageID) {this.packageID = packageID;}
    public void setBookingTime(String bookingTime) {this.bookingTime = bookingTime;}
}
