package com.demo3;

import java.io.Serializable;

public class customer implements Serializable
{
    public int custID;
    public String custName;
    public String custAddress;
    public String custPhone;
    public String custEmail;
    public String custPass;
    public String custUsername;

    public customer(){}

    public customer(int custID, String custName, String custAddress, String custPhone, String custEmail, String custPass, String custUsername)
    {
        this.custID = custID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
        this.custEmail = custEmail;
        this.custPass = custPass;
        this.custUsername = custUsername;
    }

    public int getCustID() {return custID;}
    public String getCustName() {return custName;}
    public String getCustAddress() {return custAddress;}
    public String getCustPhone() {return custPhone;}
    public String getCustEmail() {return custEmail;}
    public String getCustPass() {return custPass;}
    public String getCustUsername() {return custUsername;}

    public void setCustID(int custID) {this.custID = custID;}
    public void setCustName(String custName) {this.custName = custName;}
    public void setCustAddress(String custAddress) {this.custAddress = custAddress;}
    public void setCustPhone(String custPhone) {this.custPhone = custPhone;}
    public void setCustEmail(String custEmail) {this.custEmail = custEmail;}
    public void setCustPass(String custPass) {this.custPass = custPass;}
    public void setCustUsername(String custUsername) {this.custUsername = custUsername;}

    public String printCustomer()
    {
        return "customer{" +
                "custID='" + custID + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", custPass='" + custPass + '\'' +
                ", custUsername='" + custUsername + '\'' +
                '}';
    }

}
