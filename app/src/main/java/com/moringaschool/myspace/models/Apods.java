
package com.moringaschool.myspace.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Apods {
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("date")
    @Expose
    public static String date;
    @SerializedName("explanation")
    @Expose
    public String explanation;
    @SerializedName("hdurl")
    @Expose
    public String hdurl;
    @SerializedName("media_type")
    @Expose
    public String mediaType;
    @SerializedName("service_version")
    @Expose
    public String serviceVersion;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;

    /**
     * No args constructor for use in serialization
     *
     */
    public Apods() {
    }

    /**
     *
     * @param date
     * @param serviceVersion
     * @param copyright
     * @param mediaType
     * @param hdurl
     * @param explanation
     * @param title
     * @param url
     */
    public Apods(String copyright, String date, String explanation, String hdurl, String mediaType, String serviceVersion, String title, String url) {
        super();
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public static String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void add(Apods apods) {
    }
}
