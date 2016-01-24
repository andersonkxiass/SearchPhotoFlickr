package com.test.photoflickr.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("_content")
    @Expose
    private String Content;

    /**
     *
     * @return
     * The Content
     */
    public String getContent() {
        return Content;
    }

    /**
     *
     * @param Content
     * The _content
     */
    public void setContent(String Content) {
        this.Content = Content;
    }

}