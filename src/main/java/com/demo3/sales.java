package com.demo3;

import java.io.Serializable;
import java.time.LocalDate;

public class sales implements Serializable
{
    public String salesID;
    public String salesAmount;
    public LocalDate salesDate;
    public String adminID;
    public String workerID;

    public sales(){}

    public sales(String salesID, String salesAmount, LocalDate salesDate, String adminID, String workerID)
    {
        this.salesID = salesID;
        this.salesAmount = salesAmount;
        this.salesDate = salesDate;
        this.adminID = adminID;
        this.workerID = workerID;
    }

    public String getSalesID() {return salesID;}
    public String getSalesAmount() {return salesAmount;}
    public LocalDate getSalesDate() {return salesDate;}
    public String getAdminID() {return adminID;}
    public String getWorkerID() {return workerID;}

    public void setSalesID(String salesID) {this.salesID = salesID;}
    public void setSalesAmount(String salesAmount) {this.salesAmount = salesAmount;}
    public void setSalesDate(LocalDate salesDate) {this.salesDate = salesDate;}
    public void setAdminID(String adminID) {this.adminID = adminID;}
    public void setWorkerID(String workerID) {this.workerID = workerID;}

    public String printSales()
    {
        return "sales{" +
                "salesID='" + salesID + '\'' +
                ", salesAmount='" + salesAmount + '\'' +
                ", salesDate=" + salesDate +
                ", adminID='" + adminID + '\'' +
                ", workerID='" + workerID + '\'' +
                '}';
    }
}
