package com.example.pandavpn.Model;

public class SplitModel {
    String appName;
    int appLogo;
    boolean status;

    public SplitModel( int appLogo, String appName, boolean status) {
        this.appName = appName;
        this.appLogo = appLogo;
        this.status = status;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(int appLogo) {
        this.appLogo = appLogo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
