package com.github.irshulx.servishero.models;

/**
 * Created by mkallingal on 7/30/2016.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("searchTerms")
    @Expose
    private String searchTerms;
    @SerializedName("schedulingType")
    @Expose
    private String schedulingType;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("availableCities")
    @Expose
    private List<String> availableCities = new ArrayList<String>();
    @SerializedName("questionSet")
    @Expose
    private Integer questionSet;
    @SerializedName("providerTaxonym")
    @Expose
    private String providerTaxonym;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;

    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The searchTerms
     */
    public String getSearchTerms() {
        return searchTerms;
    }

    /**
     *
     * @param searchTerms
     *     The searchTerms
     */
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    /**
     *
     * @return
     *     The schedulingType
     */
    public String getSchedulingType() {
        return schedulingType;
    }

    /**
     *
     * @param schedulingType
     *     The schedulingType
     */
    public void setSchedulingType(String schedulingType) {
        this.schedulingType = schedulingType;
    }

    /**
     *
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     *     The availableCities
     */
    public List<String> getAvailableCities() {
        return availableCities;
    }

    /**
     *
     * @param availableCities
     *     The availableCities
     */
    public void setAvailableCities(List<String> availableCities) {
        this.availableCities = availableCities;
    }

    /**
     *
     * @return
     *     The questionSet
     */
    public Integer getQuestionSet() {
        return questionSet;
    }

    /**
     *
     * @param questionSet
     *     The questionSet
     */
    public void setQuestionSet(Integer questionSet) {
        this.questionSet = questionSet;
    }

    /**
     *
     * @return
     *     The providerTaxonym
     */
    public String getProviderTaxonym() {
        return providerTaxonym;
    }

    /**
     *
     * @param providerTaxonym
     *     The providerTaxonym
     */
    public void setProviderTaxonym(String providerTaxonym) {
        this.providerTaxonym = providerTaxonym;
    }

    /**
     *
     * @return
     *     The serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     *
     * @param serviceName
     *     The serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

}
