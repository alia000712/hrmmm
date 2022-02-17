package com.demo3;

import java.io.Serializable;

public class Package implements Serializable
{
    public String packageID;
    public String packageName;
    public double packagePrice;


    public Package(){}

    public Package(String packageID, String packageName, double packagePrice)
    {
        this.packageID = packageID;
        this.packageName = packageName;
        this.packagePrice = packagePrice;
    }

    public String getPackageID() {return packageID;}
    public String getPackageName() {return packageName;}
    public double getPackagePrice() {return packagePrice;}

    public void setPackageID(String packageID) {this.packageID = packageID;}
    public void setPackageName(String packageName) {this.packageName = packageName;}
    public void setPackagePrice(double packagePrice) {this.packagePrice = packagePrice;}

}
