
package com.moringaschool.myspace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class EarthImages {

    @SerializedName("lon")
    @Expose
    private String lon;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("dim")
    @Expose
    private String dim;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("cloud_score")
    @Expose
    private String cloudScore;
    @SerializedName("EarthImages")
    @Expose
    private List<EarthImages> earthImages = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EarthImages() {
    }

    /**
     * @param date
     * @param dim
     * @param lon
     * @param cloudScore
     * @param lat
     * @param earthImages
     */
    public EarthImages(String lon, String lat, String dim, String date, String cloudScore, List<EarthImages> earthImages) {
        super();
        this.lon = lon;
        this.lat = lat;
        this.dim = dim;
        this.date = date;
        this.cloudScore = cloudScore;
        this.earthImages = earthImages;
    }


    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCloudScore() {
        return cloudScore;
    }

    public void setCloudScore(String cloudScore) {
        this.cloudScore = cloudScore;
    }

    public List<EarthImages> getEarthImages() {
        return earthImages;
    }

    public void setEarthImages(List<EarthImages> earthImages) {
        this.earthImages = earthImages;
    }


}
