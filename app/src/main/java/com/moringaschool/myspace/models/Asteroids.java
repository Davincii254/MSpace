
package com.moringaschool.myspace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Asteroids {

    @SerializedName("start_date")
    @Expose
    public String startDate;
    @SerializedName("end_date")
    @Expose
    public String endDate;

    @SerializedName("Asteroids")
    @Expose
    public List<Asteroids> asteroids = null;
    @SerializedName("name")
    @Expose
    public String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Asteroids() {
    }

    /**
     *
     * @param endDate
     * @param startDate
     * @param asteroids
     * @param name
     * @param skip
     */
    public Asteroids(String startDate, String endDate, List<Asteroids> asteroids, Integer skip, String name) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
        this.asteroids = asteroids;
        this.name = name;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Asteroids> getAsteroids() {
        return asteroids;
    }

    public void setAsteroids(List<Asteroids> asteroids) {
        this.asteroids = asteroids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
