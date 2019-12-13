package com.hgs.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity extends GeneralModel implements Parcelable {

    public String poster_path;

    public boolean adult;

    public String overview;

    public String release_date;

    public String original_title;

    public int id;

    public String media_type;

    public String original_language;

    public String title;

    public int popularity;

    public boolean video;

    public int vote_average;

    public MovieEntity(){super();}

    protected MovieEntity(Parcel in) {
    }


    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        poster_path = in.readString();
        overview = in.readString();
        release_date = in.readString();
        original_title = in.readString();
        id = in.readInt();
        media_type = in.readString();
        original_language = in.readString();
        title = in.readString();
        popularity = in.readInt();
        vote_average = in.readInt();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(original_title);
        dest.writeString(media_type);
        dest.writeString(original_language);
        dest.writeString(title);
        dest.writeInt(popularity);
        dest.writeInt(vote_average);
    }
}
