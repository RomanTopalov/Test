package com.ua.services;

import com.ua.commands.CommentForm;
import com.ua.converters.CommentFormToComment;
import com.ua.domain.Comment;
import com.ua.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CommentFormToComment commentFormToComment;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentFormToComment commentFormToComment) {
        this.commentRepository = commentRepository;
        this.commentFormToComment = commentFormToComment;
    }

    @Override
    public List<Comment> listAll() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);

        return comments;
    }

    @Override
    public Comment getById(String id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment saveOrUpdate(Comment comment) {
        commentRepository.save(comment);
        ////
      /*  comment.setStatus("Ok");*/
        ///
        return comment;
    }

    @Override
    public void delete(String id) {
        commentRepository.delete(id);

    }

    @Override
    public Comment saveOrUpdateCommentForm(CommentForm commentForm) {

        commentForm.setStatus("OK");
        Comment savedComment = saveOrUpdate(commentFormToComment.convert(commentForm));
        System.out.println("Saved comment id : " + savedComment.get_id());

        return savedComment;
    }
}
