package com.geomatics.hilarious;

/**
 * Created by Rishant on 11/6/2016.
 */

public class UserInformation {

    public String name;
    public String rooms;

    public String teachers;
    public String staff;
    public String otherattributes1;
    public String otherattributes2;
    public String otherattributes3;
    public String otherattributes4;
    public String Type;
    public String TypeHospital;
    public String Runby;
    public String Toilet;
    public String Building;
    public String Electricity;
    public String Drinkingwater;
    public String Telephone;
    public String Latitude;
    public String Longitude;
    public String WaterType;
    public String Uses;
    public String waterLevel;
    public String powertype;
    public String religion;
    public String commercial;




    public UserInformation(String name,String Powertype,String Commercial,String Religious, String rooms,String WaterType,String Uses ,String WaterLevel,String staff, String teachers, String Typehospital, String otherattributes1,String otherattributes2, String otherattributes3, String otherattributes4, String Type,String Runby,String Toilet, String Building,String Electricity,String Drinkingwater,String Telephone,String Latitude,String Longitude) {
        this.name = name;
        this.rooms = rooms;
        this.Latitude=Latitude;
        this.Longitude=Longitude;
        this.teachers=teachers;
        this.staff=staff;
        this.otherattributes1=otherattributes1;
        this.otherattributes2=otherattributes2;
        this.otherattributes3=otherattributes3;
        this.otherattributes4=otherattributes4;
        this.Type=Type;
        this.TypeHospital=Typehospital;
        this.Runby=Runby;
        this.Building=Building;
        this.Toilet=Toilet;
        this.Electricity=Electricity;
        this.Drinkingwater=Drinkingwater;
        this.Telephone=Telephone;
        this.WaterType=WaterType;
        this.Uses=Uses;
        this.waterLevel = WaterLevel;
        this.powertype = Powertype;
        this.religion = Religious;
        this.commercial = Commercial;

    }
}
