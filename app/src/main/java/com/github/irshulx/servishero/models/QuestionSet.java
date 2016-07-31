
package com.github.irshulx.servishero.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionSet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("questionSet")
    @Expose
    private Integer questionSet;
    @SerializedName("questions")
    @Expose
    private List<Question> questions = new ArrayList<Question>();

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

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
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
     *     The questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * 
     * @param questions
     *     The questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
