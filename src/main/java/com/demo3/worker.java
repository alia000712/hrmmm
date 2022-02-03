package com.demo3;

import java.io.Serializable;

public class worker  implements Serializable
{
    public int workerID;
    public String workerName;
    public String workerIC;
    public String workerAddress;
    public String workerEmail;
    public String workerPhone;
    public String branchID;

    public worker(){}

    public worker(int workerID, String workerName, String workerIC, String workerAddress, String workerEmail, String workerPhone, String branchID)
    {
        this.workerID = workerID;
        this.workerName = workerName;
        this.workerIC = workerIC;
        this.workerAddress = workerAddress;
        this.workerEmail = workerEmail;
        this.workerPhone = workerPhone;
        this.branchID = branchID;
    }

    public int getWorkerID() {return workerID;}
    public String getWorkerName() {return workerName;}
    public String getWorkerIC() {return workerIC;}
    public String getWorkerAddress() {return workerAddress;}
    public String getWorkerEmail() {return workerEmail;}
    public String getWorkerPhone() {return workerPhone;}
    public String getBranchID() {return branchID;}

    public void setWorkerID(int workerID) {this.workerID = workerID;}
    public void setWorkerName(String workerName) {this.workerName = workerName;}
    public void setWorkerIC(String workerIC) {this.workerIC = workerIC;}
    public void setWorkerAddress(String workerAddress) {this.workerAddress = workerAddress;}
    public void setWorkerEmail(String workerEmail) {this.workerEmail = workerEmail;}
    public void setWorkerPhone(String workerPhone) {this.workerPhone = workerPhone;}
    public void setBranchID(String branchID) {this.branchID = branchID;}

    public String printWorker()
    {
        return "worker{" +
                "workerID='" + workerID + '\'' +
                ", workerName='" + workerName + '\'' +
                ", workerIC='" + workerIC + '\'' +
                ", workerAddress='" + workerAddress + '\'' +
                ", workerEmail='" + workerEmail + '\'' +
                ", workerPhone='" + workerPhone + '\'' +
                ", branchID='" + branchID + '\'' +
                '}';
    }
}
