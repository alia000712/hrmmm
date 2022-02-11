package com.demo3;

import java.io.Serializable;
import java.sql.Date;

public class sales implements Serializable
{
    public int salesID;
    public double salesAmount;
    public String salesDate;
    public double salesWalkin;
    public double salesBooking;
    public int userID;
    public String branchID;

    public sales(){}

    public sales(int salesID, double salesAmount, String salesDate, double salesWalkin, double salesBooking, int userID, String branchID)
    {
        this.salesID = salesID;
        this.salesAmount = salesAmount;
        this.salesDate = salesDate;
        this.salesWalkin = salesWalkin;
        this.salesBooking = salesBooking;
        this.userID = userID;
        this.branchID = branchID;
    }

    public int getSalesID() {return salesID;}
    public double getSalesAmount() {return salesAmount;}
    public String getSalesDate() {return salesDate;}
    public double getSalesWalkin() {return salesWalkin;}
    public double getSalesBooking() {return salesBooking;}
    public int getUserID() {return userID;}
    public String getBranchID() {return branchID;}

    public void setSalesID(int salesID) {this.salesID = salesID;}
    public void setSalesAmount(double salesAmount) {this.salesAmount = salesAmount;}
    public void setSalesDate(String salesDate) {this.salesDate = salesDate;}
    public void setSalesWalkin(double salesWalkin) {this.salesWalkin = salesWalkin;}
    public void setSalesBooking(double salesBooking) {this.salesBooking = salesBooking;}
    public void setUserID(int userID) {this.userID = userID;}
    public void setBranchID(String branchID) {this.branchID = branchID;}

}
