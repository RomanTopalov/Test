package com.ua.converters;

import com.ua.commands.CommentForm;
import com.ua.domain.Comment;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by -rom- on 01.08.2017.
 */
@Component
public class CommentFormToComment implements Converter<CommentForm, Comment> {


    @Override
    public Comment convert(CommentForm commentForm) {
        Comment comment = new Comment();
        if (commentForm.getId() != null  && !StringUtils.isEmpty(commentForm.getId())) {
            comment.set_id(new ObjectId(commentForm.getId()));
        }
       comment.setTitle_of_comment(commentForm.getTitle_of_comment());
       comment.setText_of_comment(commentForm.getText_of_comment());
       comment.setMark(commentForm.getMark());
       comment.setStatus(commentForm.getStatus());
        return comment;
    }
}
