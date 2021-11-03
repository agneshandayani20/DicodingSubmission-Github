package com.agneshandayani.dicodingsubmission_github.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelSearch {

    @SerializedName("items")
    private List<ModelSearchData> modelSearchData;

    public List<ModelSearchData> getModelSearchData() {
        return modelSearchData;
    }

    public void setModelSearchData(List<ModelSearchData> modelSearchData) {
        this.modelSearchData = modelSearchData;
    }

}