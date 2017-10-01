package com.strila.petproject.data.models.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by Serhii Strila on 10/1/17
 */

public class ListingResponse<T> {

    @SerializedName("data") private PaginationData<T> data;

    public PaginationData<T> getData() {
        return data;
    }

    public static class PaginationData<T> {
        @SerializedName("children") private List<Data<T>> dataList = new ArrayList<>();
        @SerializedName("after") @Nullable private String after;
        @SerializedName("before") @Nullable private String before;

        public List<Data<T>> getDataList() {
            return dataList;
        }

        @Nullable
        public String getAfter() {
            return after;
        }

        @Nullable
        public String getBefore() {
            return before;
        }
    }

    public static class Data<T> {
        @SerializedName("data") private T data;

        public T getData() {
            return data;
        }
    }
}
