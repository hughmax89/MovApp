package com.hgs.data.configurations;

import android.os.Parcel;
import android.os.Parcelable;

import com.activeandroid.annotation.Table;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hgs.data.entity.GeneralModel;

import java.util.Date;

@Table(name="TokenWeb")
@JsonIgnoreProperties("data")
public class TokenWeb extends GeneralModel implements Parcelable {

    private String status_code;
    private String status_message;
    private boolean success;


    public TokenWeb() {
        super();
    }


    @JsonCreator
    public TokenWeb(
        @JsonProperty("status_code") String status_code,
        @JsonProperty("status_message") String status_message,
        @JsonProperty("success") boolean success)
        {

        this.status_code = status_code;
        this.status_message = status_message;
        this.success = success;
    }

    public TokenWeb(Parcel in ) {
        readFromParcel( in );
    }

    public static final Parcelable.Creator<TokenWeb> CREATOR = new Parcelable.Creator<TokenWeb>() {
        public TokenWeb createFromParcel(Parcel in ) {
            return new TokenWeb(in);
        }

        public TokenWeb[] newArray(int size) {
            return new TokenWeb[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status_code);
        dest.writeString(status_message);

    }

    private void readFromParcel(Parcel in ) {

        status_code = in.readString();
        status_message = in.readString();

    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
