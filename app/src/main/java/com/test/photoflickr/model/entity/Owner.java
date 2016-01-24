package com.test.photoflickr.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("nsid")
    @Expose
    private String nsid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("iconserver")
    @Expose
    private String iconserver;
    @SerializedName("iconfarm")
    @Expose
    private Integer iconfarm;
    @SerializedName("path_alias")
    @Expose
    private String pathAlias;

    /**
     *
     * @return
     * The nsid
     */
    public String getNsid() {
        return nsid;
    }

    /**
     *
     * @param nsid
     * The nsid
     */
    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     *
     * @param realname
     * The realname
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     *
     * @return
     * The location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The iconserver
     */
    public String getIconserver() {
        return iconserver;
    }

    /**
     *
     * @param iconserver
     * The iconserver
     */
    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    /**
     *
     * @return
     * The iconfarm
     */
    public Integer getIconfarm() {
        return iconfarm;
    }

    /**
     *
     * @param iconfarm
     * The iconfarm
     */
    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    /**
     *
     * @return
     * The pathAlias
     */
    public String getPathAlias() {
        return pathAlias;
    }

    /**
     *
     * @param pathAlias
     * The path_alias
     */
    public void setPathAlias(String pathAlias) {
        this.pathAlias = pathAlias;
    }

}