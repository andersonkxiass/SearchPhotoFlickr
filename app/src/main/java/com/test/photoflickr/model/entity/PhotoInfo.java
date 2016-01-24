package com.test.photoflickr.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoInfo {

    @SerializedName("photo")
    @Expose
    private Photo_ photo;
    @SerializedName("stat")
    @Expose
    private String stat;

    /**
     *
     * @return
     * The photo
     */
    public Photo_ getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    /**
     *
     * @return
     * The stat
     */
    public String getStat() {
        return stat;
    }

    /**
     *
     * @param stat
     * The stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }
}