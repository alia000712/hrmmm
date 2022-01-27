package com.demo3;

import java.io.Serializable;

public class worker  implements Serializable
{
    public String workerID;
    public String workerName;
    public String workerIC;
    public String workerAddress;
    public String workerEmail;
    public String workerPhone;
    public String workerPass;
    public String workerUsername;
    public String branchID;

    public worker(){}

    public worker(String workerID, String workerName, String workerIC, String workerAddress, String workerEmail, String workerPhone, String workerPass, String workerUsername, String branchID)
    {
        this.workerID = workerID;
        this.workerName = workerName;
        this.workerIC = workerIC;
        this.workerAddress = workerAddress;
        this.workerEmail = workerEmail;
        this.workerPhone = workerPhone;
        this.workerPass = workerPass;
        this.workerUsername = workerUsername;
        this.branchID = branchID;
    }

    public String getWorkerID() {return workerID;}
    public String getWorkerName() {return workerName;}
    public String getWorkerIC() {return workerIC;}
    public String getWorkerAddress() {return workerAddress;}
    public String getWorkerEmail() {return workerEmail;}
    public String getWorkerPhone() {return workerPhone;}
    public String getWorkerPass() {return workerPass;}
    public String getWorkerUsername() {return workerUsername;}
    public String getBranchID() {return branchID;}

    public void setWorkerID(String workerID) {this.workerID = workerID;}
    public void setWorkerName(String workerName) {this.workerName = workerName;}
    public void setWorkerIC(String workerIC) {this.workerIC = workerIC;}
    public void setWorkerAddress(String workerAddress) {this.workerAddress = workerAddress;}
    public void setWorkerEmail(String workerEmail) {this.workerEmail = workerEmail;}
    public void setWorkerPhone(String workerPhone) {this.workerPhone = workerPhone;}
    public void setWorkerPass(String workerPass) {this.workerPass = workerPass;}
    public void setWorkerUsername(String workerUsername) {this.workerUsername = workerUsername;}
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
                ", workerPass='" + workerPass + '\'' +
                ", workerUsername='" + workerUsername + '\'' +
                ", branchID='" + branchID + '\'' +
                '}';
    }
}
