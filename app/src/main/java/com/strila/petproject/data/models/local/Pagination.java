package com.strila.petproject.data.models.local;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by Serhii Strila on 10/2/17
 */

public class Pagination implements Parcelable {

    public static final Parcelable.Creator<Pagination> CREATOR = new Parcelable.Creator<Pagination>() {
        @Override
        public Pagination createFromParcel(Parcel source) {
            return new Pagination(source);
        }

        @Override
        public Pagination[] newArray(int size) {
            return new Pagination[size];
        }
    };
    @Nullable private String after;
    @Nullable private String before;

    public Pagination() {
    }

    protected Pagination(Parcel in) {
        this.after = in.readString();
        this.before = in.readString();
    }

    @Nullable
    public String getAfter() {
        return after;
    }

    public void setAfter(@Nullable String after) {
        this.after = after;
    }

    @Nullable
    public String getBefore() {
        return before;
    }

    public void setBefore(@Nullable String before) {
        this.before = before;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.after);
        dest.writeString(this.before);
    }
}
