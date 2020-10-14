package com.moringaschool.myspace;

import java.util.ArrayList;

public class Satellite {
    private String Name;
    private String LaunchedDay;
    private String Function;
    private String imageUrl;
    private ArrayList<String> Satellite = new ArrayList<>();

    public Satellite(String Name, String LaunchedDay, String Function, String imageUrl, ArrayList Satellite
    ){
        this.Name = Name;
        this.LaunchedDay = LaunchedDay;
        this.Function = Function;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public String getLaunchedDay() {
        return LaunchedDay;
    }

    public String getFunction() {
        return Function;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArrayList<String> getSatellite() {
        return Satellite;
    }
}
