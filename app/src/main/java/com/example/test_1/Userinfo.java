package com.example.test_1;

public class Userinfo {
    private String fullname;
    private String phonenumber;
    private String email;
    private  String passwrord;
    private String citylocation;
    private String DeviceName;
    private String  DeviceModel;
    private String Description;

    public Userinfo(String fullname, String phonenumber, String email, String passwrord, String citylocation, String deviceName, String deviceModel, String description) {
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.passwrord = passwrord;
        this.citylocation = citylocation;
        DeviceName = deviceName;
        DeviceModel = deviceModel;
        Description = description;
    }

    public String  getFullname(){
        return fullname;
    }
    public String getPhonenumber(){
        return phonenumber;
    }
    public String getEmail(){
        return email;
    }
    public String getPasswrord(){
        return passwrord;
    }
    public String getCitylocation(){
        return citylocation;
    }
    public String  getDeviceName(){
        return DeviceName;
    }
    public String getDeviceModel(){
        return DeviceModel;
    }
    public String getDescription(){
        return Description;
    }


}
