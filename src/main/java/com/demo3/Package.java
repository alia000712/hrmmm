package com.demo3;

import java.io.Serializable;

public class Package implements Serializable
{
    public String packageID;
    public String packageName;
    public double packageprice;
    public int totalPackage;
    public double totalPackagePrice;

    public Package(){}

    public Package(String packageID, String packageName, double packageprice, int totalPackage, double totalPackagePrice)
    {
        this.packageID = packageID;
        this.packageName = packageName;
        this.packageprice = packageprice;
        this.totalPackage = totalPackage;
        this.totalPackagePrice = totalPackagePrice;
    }

    public String getPackageID() {return packageID;}
    public String getPackageName() {return packageName;}
    public double getPackageprice() {return packageprice;}
    public int getTotalPackage() {return totalPackage;}
    public double getTotalPackagePrice() {return totalPackagePrice;}

    public void setPackageID(String packageID) {this.packageID = packageID;}
    public void setPackageName(String packageName) {this.packageName = packageName;}
    public void setPackageprice(double packageprice) {this.packageprice = packageprice;}
    public void setTotalPackage(int totalPackage) {this.totalPackage = totalPackage;}
    public void setTotalPackagePrice(double totalPackagePrice) {this.totalPackagePrice = totalPackagePrice;}

    public String printPackage()
    {
        return "Package{" +
                "packageID='" + packageID + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageprice=" + packageprice +
                ", totalPackage=" + totalPackage +
                ", totalPackagePrice=" + totalPackagePrice +
                '}';
    }
}
