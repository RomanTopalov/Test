package com.ua.commands;

/**
 * Created by -rom- on 01.08.2017.
 */
public class CommentForm {

    private String id;
    private String title_of_comment;
    private String text_of_comment ;
    private int mark ;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
