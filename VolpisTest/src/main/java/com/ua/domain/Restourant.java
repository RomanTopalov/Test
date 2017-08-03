package com.ua.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
@Document
public class Restourant {
    @Id
    private ObjectId _id;
    private String restourant_title;
	private double latitude;
	private double longitude;

	private String Status;
    @DBRef
	private Comment comment;

    public Restourant() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
