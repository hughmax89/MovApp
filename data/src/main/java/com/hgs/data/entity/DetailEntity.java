package com.hgs.data.entity;


import android.os.Parcel;
import android.os.Parcelable;

public class DetailEntity extends GeneralModel implements Parcelable {

    public int id;

    public String poster_path;

    public String iso_639_1;

    public String description;

    public String name;

    public int runtime;

    public String comments;

    public int total_result;

    public DetailEntity(){super();}

    protected DetailEntity(Parcel in) {
    }

    public static final Creator<DetailEntity> CREATOR = new Creator<DetailEntity>() {
        @Override
        public DetailEntity createFromParcel(Parcel in) {
            return new DetailEntity(in);
        }

        @Override
        public DetailEntity[] newArray(int size) {
            return new DetailEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        id = in.readInt();
        poster_path = in.readString();
        iso_639_1 = in.readString();
        description = in.readString();
        name = in.readString();
        runtime = in.readInt();
        comments = in.readString();
        total_result = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(poster_path);
        dest.writeString(iso_639_1);
        dest.writeString(description);
        dest.writeString(name);
        dest.writeInt(runtime);
        dest.writeString(comments);
        dest.writeInt(total_result);
    }
}