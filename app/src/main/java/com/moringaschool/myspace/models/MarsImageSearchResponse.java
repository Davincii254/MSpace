package com.moringaschool.myspace.models;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarsImageSearchResponse {

    @SerializedName("photos")
    @Expose
    private List<Object> photos = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public MarsImageSearchResponse() {
    }

    /**
     *
     * @param photos
     */
    public MarsImageSearchResponse(List<Object> photos) {
        super();
        this.photos = photos;
    }

    public List<Object> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Object> photos) {
        this.photos = photos;
    }

}