
package com.github.irshulx.servishero.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Question {

    @SerializedName("questionId")
    @Expose
    private Integer questionId;
    @SerializedName("questionText")
    @Expose
    private String questionText;
    @SerializedName("questionOrder")
    @Expose
    private Integer questionOrder;
    @SerializedName("responseType")
    @Expose
    private Integer responseType;
    @SerializedName("responses")
    @Expose
    private List<Response> responses = new ArrayList<Response>();

    /**
     * 
     * @return
     *     The questionId
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 
     * @param questionId
     *     The questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 
     * @return
     *     The questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * 
     * @param questionText
     *     The questionText
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * 
     * @return
     *     The questionOrder
     */
    public Integer getQuestionOrder() {
        return questionOrder;
    }

    /**
     * 
     * @param questionOrder
     *     The questionOrder
     */
    public void setQuestionOrder(Integer questionOrder) {
        this.questionOrder = questionOrder;
    }

    /**
     * 
     * @return
     *     The responseType
     */
    public Integer getResponseType() {
        return responseType;
    }

    /**
     * 
     * @param responseType
     *     The responseType
     */
    public void setResponseType(Integer responseType) {
        this.responseType = responseType;
    }

    /**
     * 
     * @return
     *     The responses
     */
    public List<Response> getResponses() {
        return responses;
    }

    /**
     * 
     * @param responses
     *     The responses
     */
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
