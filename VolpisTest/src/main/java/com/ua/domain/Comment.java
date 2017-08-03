package com.ua.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by -rom- on 01.08.2017.
 */

@Document
public class Comment {
    @Id
    private ObjectId _id;
    private String title_of_comment;
	private String text_of_comment ;
	private int mark ;
	private String status;

    public Comment() {
    }



    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getTitle_of_comment() {
        return title_of_comment;
    }

    public void setTitle_of_comment(String title_of_comment) {
        this.title_of_comment = title_of_comment;
    }

    public String getText_of_comment() {
        return text_of_comment;
    }

    public void setText_of_comment(String text_of_comment) {
        this.text_of_comment = text_of_comment;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
