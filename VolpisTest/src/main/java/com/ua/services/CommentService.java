package com.ua.services;

import com.ua.commands.CommentForm;
import com.ua.domain.Comment;

import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
public interface CommentService {
    List<Comment> listAll();

    Comment getById(String id);

    Comment saveOrUpdate(Comment comment);

    void delete(String id);

    Comment saveOrUpdateCommentForm(CommentForm commentForm);

}
