package com.github.irshulx.servishero.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mkallingal on 7/30/2016.
 */
public class Category {

    public Category(String categoryName, int categoryId){
        this.categoryName=categoryName;
        this.categoryId= categoryId;
    }

    @SerializedName("serviceName")
    @Expose
    private String categoryName;
    @SerializedName("categoryId")
    @Expose
    private Integer categoryId;

    /**
     *
     * @return
     *     The serviceName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     *
     * @param categoryName
     *     The serviceName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     *
     * @return
     *     The categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     *     The categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}

