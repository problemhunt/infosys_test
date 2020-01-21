package com.problemhunt.shailendra.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.problemhunt.shailendra.Utils;



public class AboutModel implements Parcelable {

    private String title;
    private String description;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * To check whether any one of the value in the model is present.
     *
     * @return {@link boolean}
     */
    public boolean isEmpty() {
        return Utils.isEmptyOrNull(title) && Utils.isEmptyOrNull(description) && Utils.isEmptyOrNull(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
    }

    public AboutModel() {
    }

    private AboutModel(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<AboutModel> CREATOR = new Parcelable.Creator<AboutModel>() {
        @Override
        public AboutModel createFromParcel(Parcel source) {
            return new AboutModel(source);
        }

        @Override
        public AboutModel[] newArray(int size) {
            return new AboutModel[size];
        }
    };
}
