
package com.moringaschool.myspace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class TechTransfer {

    @SerializedName("patent")
    @Expose
    public String patent;
    @SerializedName("patent_issued")
    @Expose
    public String patentIssued;
    @SerializedName("software")
    @Expose
    public String software;
    @SerializedName("Spinoff")
    @Expose
    public String spinoff;
    @SerializedName("TechTransfer")
    @Expose
    public List<TechTransfer> techTransfer = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TechTransfer() {
    }

    /**
     ** @param patent
     * @param patentIssued
     * @param software
     * @param spinoff
     * @param techTransfer
     */
    public TechTransfer(String patent, String patentIssued, String software, String spinoff, List<TechTransfer> techTransfer) {
        super();
        this.patent = patent;
        this.patentIssued = patentIssued;
        this.software = software;
        this.spinoff = spinoff;
        this.techTransfer = techTransfer;
    }

    public List<TechTransfer> getTechTransfer() {
        return techTransfer;
    }

    public void setTechTransfer(List<TechTransfer> techTransfer) {
        this.techTransfer = techTransfer;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public String getPatentIssued() {
        return patentIssued;
    }

    public void setPatentIssued(String patentIssued) {
        this.patentIssued = patentIssued;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getSpinoff() {
        return spinoff;
    }

    public void setSpinoff(String spinoff) {
        this.spinoff = spinoff;
    }


}
