package com.test.photoflickr.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andersonacs on 22/01/16.
 */
public class Photos {

    private Integer page;
    private Integer pages;
    private Integer perpage;
    private String total;
    private List<Photo_> photo = new ArrayList<>();

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The pages
     */
    public Integer getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The perpage
     */
    public Integer getPerpage() {
        return perpage;
    }

    /**
     *
     * @param perpage
     * The perpage
     */
    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    /**
     *
     * @return
     * The total
     */
    public String getTotal() {
        return total;
    }

    /**
     *
     * @param total
     * The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     *
     * @return
     * The photo
     */
    public List<Photo_> getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     * The photo
     */
    public void setPhoto(List<Photo_> photo) {
        this.photo = photo;
    }
}
