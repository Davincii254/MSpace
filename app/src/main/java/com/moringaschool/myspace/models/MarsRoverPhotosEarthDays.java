
package com.moringaschool.myspace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MarsRoverPhotosEarthDays {

    @SerializedName("earth_date")
    @Expose
    private String earthDate;
    @SerializedName("camera")
    @Expose
    private String camera;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("MarsPhotos")
    @Expose
    private List<MarsRoverPhotosEarthDays> marsRoverPhotosEarthDays = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MarsRoverPhotosEarthDays() {
    }

    /**
     *
     * @param page
     * @param earthDate
     * @param camera
     * @param marsRoverPhotosEarthDays
     */
    public MarsRoverPhotosEarthDays(String earthDate, String camera, Integer page, List<MarsRoverPhotosEarthDays> marsRoverPhotosEarthDays) {
        super();
        this.earthDate = earthDate;
        this.camera = camera;
        this.page = page;
        this.marsRoverPhotosEarthDays = marsRoverPhotosEarthDays;
    }

    public List<MarsRoverPhotosEarthDays> getMarsRoverPhotosEarthDays() {
        return marsRoverPhotosEarthDays;
    }

    public void setMarsRoverPhotosEarthDays(List<MarsRoverPhotosEarthDays> marsRoverPhotosEarthDays) {
        this.marsRoverPhotosEarthDays = marsRoverPhotosEarthDays;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



}
