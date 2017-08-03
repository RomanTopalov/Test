package com.ua.commands;

import com.ua.domain.Comment;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
public class RestourantForm {

    private String id;
    private String restourant_title;
    private double latitude;
    private double longitude;

    private Comment comment;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestourant_title() {
        return restourant_title;
    }

    public void setRestourant_title(String restourant_title) {
        this.restourant_title = restourant_title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
