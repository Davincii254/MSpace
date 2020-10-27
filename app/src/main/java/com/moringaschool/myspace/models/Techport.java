
package com.moringaschool.myspace.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Techport {

    @SerializedName("id_parameter")
    @Expose
    public String idParameter;
    @SerializedName("Techport")
    @Expose
    public List<Techport> techport = null;


    /**
     * No args constructor for use in serialization
     * 
     */
    public Techport() {
    }

    /**
     * @param idParameter
     * @param techport
     */
    public Techport(String idParameter, List<Techport> techport) {
        super();
        this.idParameter = idParameter;
        this.techport = techport;
    }

    public List<Techport> getTechport() {
        return techport;
    }

    public void setTechport(List<Techport> techport) {
        this.techport = techport;
    }

    public String getIdParameter() {
        return idParameter;
    }

    public void setIdParameter(String idParameter) {
        this.idParameter = idParameter;
    }


}
