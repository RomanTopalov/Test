package com.ua.converters;

import com.ua.commands.CommentForm;
import com.ua.domain.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by -rom- on 01.08.2017.
 */
@Component
public class CommentToCommentForm implements Converter<Comment, CommentForm> {
    @Override
    public CommentForm convert(Comment comment) {
        CommentForm commentForm = new CommentForm();
        commentForm.setId(comment.get_id().toHexString());
        commentForm.setTitle_of_comment(comment.getTitle_of_comment());
        commentForm.setText_of_comment(comment.getText_of_comment());
        commentForm.setMark(comment.getMark());
        commentForm.setStatus(comment.getStatus());
        return commentForm;
    }
}
