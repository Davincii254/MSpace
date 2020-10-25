package com.moringaschool.myspace.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageSearchResponse{
        @SerializedName("photos")
        @Expose
        private List<Object> photos = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public ImageSearchResponse() {
        }

        /**
         *
         * @param photos
         */
        public ImageSearchResponse(List<Object> photos) {
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