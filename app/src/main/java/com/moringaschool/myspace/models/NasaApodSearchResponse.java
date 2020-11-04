package com.moringaschool.myspace.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NasaApodSearchResponse {

    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("apods")
    @Expose
    public List<Apods> apods;

    /**
     * No args constructor for use in serialization
     *
     */
    public NasaApodSearchResponse() {
    }

    /**
     *
     * @param total
     * @param apods
     */
    public NasaApodSearchResponse(Integer total, List<Apods> apods) {
        super();
        this.total = total;
        this.apods = apods;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Apods> getApods() {
        return apods;
    }

    public void setBusinesses(List<Apods> apods) {
        this.apods = apods;
    }
}

