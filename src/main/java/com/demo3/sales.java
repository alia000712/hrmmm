package com.demo3;

import java.io.Serializable;
import java.sql.Date;

public class sales implements Serializable
{
    public int salesID;
    public double salesAmount;
    public Date salesDate;
    public double salesWalkin;
    public double salesBooking;
    public int adminID;
    public int workerID;
    public String branchID;

    public sales(){}

    public sales(int salesID, double salesAmount, Date salesDate, double salesWalkin, double salesBooking, int adminID,int workerID, String branchID)
    {
        this.salesID = salesID;
        this.salesAmount = salesAmount;
        this.salesDate = salesDate;
        this.salesWalkin = salesWalkin;
        this.salesBooking = salesBooking;
        this.adminID = adminID;
        this.workerID = workerID;
        this.branchID = branchID;
    }

    public int getSalesID() {return salesID;}
    public double getSalesAmount() {return salesAmount;}
    public Date getSalesDate() {return salesDate;}
    public double getSalesWalkin() {return salesWalkin;}
    public double getSalesBooking() {return salesBooking;}
    public String getBranchID() {return branchID;}
    public int getAdminID() {return adminID;}
    public int getWorkerID() {return workerID;}

    public void setSalesID(int salesID) {this.salesID = salesID;}
    public void setSalesAmount(double salesAmount) {this.salesAmount = salesAmount;}
    public void setSalesDate(Date salesDate) {this.salesDate = salesDate;}
    public void setSalesWalkin(double salesWalkin) {this.salesWalkin = salesWalkin;}
    public void setSalesBooking(double salesBooking) {this.salesBooking = salesBooking;}
    public void setBranchID(String branchID) {this.branchID = branchID;}
    public void setAdminID(int adminID) {this.adminID = adminID;}
    public void setWorkerID(int workerID) {this.workerID = workerID;}

}
