package com.demo3;

import java.io.Serializable;

public class admin implements Serializable
{
    public int adminID;
    public String adminPass;
    public String adminUsername;

    public admin(){}

    public admin(int adminID, String adminPass, String adminUsername)
    {
        this.adminID = adminID;
        this.adminPass = adminPass;
        this.adminUsername = adminUsername;
    }

    public int getAdminID() {return adminID;}
    public String getAdminPass() {return adminPass;}
    public String getAdminUsername() {return adminUsername;}

    public void setAdminID(int adminID) {this.adminID = adminID;}
    public void setAdminPass(String adminPass) {this.adminPass = adminPass;}
    public void setAdminUsername(String adminUsername) {this.adminUsername = adminUsername;}
}
