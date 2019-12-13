package com.hgs.domain.core;

public class Detail {

    private int id;

    private String poster_path;

    private String iso_639_1;

    private String description;

    private String name;

    private int runtime;

    private String comments;

    private int total_result;

    private Movie movie;

    public Detail(){}

    public Detail(int id, String poster_path, String iso_639_1, String description, String name,
                  int runtime, String comments, int total_result, Movie movie){

        this.id = id;
        this.poster_path = poster_path;
        this.iso_639_1 = iso_639_1;
        this.description = description;
        this.name = name;
        this.runtime = runtime;
        this.comments = comments;
        this.total_result = total_result;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
