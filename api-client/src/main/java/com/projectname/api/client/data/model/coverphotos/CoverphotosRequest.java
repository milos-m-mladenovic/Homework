package com.projectname.api.client.data.model.coverphotos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CoverphotosRequest implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idBook")
    @Expose
    private Integer idBook;
    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = 4187084649935043548L;

    public CoverphotosRequest() {
    }

    public CoverphotosRequest(Integer id, Integer idBook, String url) {
        super();
        this.id = id;
        this.idBook = idBook;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
