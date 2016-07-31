
package com.github.irshulx.servishero.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("responseId")
    @Expose
    private Integer responseId;
    @SerializedName("responseText")
    @Expose
    private String responseText;
    @SerializedName("responseOrder")
    @Expose
    private Integer responseOrder;

    /**
     * 
     * @return
     *     The responseId
     */
    public Integer getResponseId() {
        return responseId;
    }

    /**
     * 
     * @param responseId
     *     The responseId
     */
    public void setResponseId(Integer responseId) {
        this.responseId = responseId;
    }

    /**
     * 
     * @return
     *     The responseText
     */
    public String getResponseText() {
        return responseText;
    }

    /**
     * 
     * @param responseText
     *     The responseText
     */
    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    /**
     * 
     * @return
     *     The responseOrder
     */
    public Integer getResponseOrder() {
        return responseOrder;
    }

    /**
     * 
     * @param responseOrder
     *     The responseOrder
     */
    public void setResponseOrder(Integer responseOrder) {
        this.responseOrder = responseOrder;
    }

}
