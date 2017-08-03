package com.ua.controllers;

import com.ua.commands.CommentForm;
import com.ua.converters.CommentToCommentForm;
import com.ua.domain.Comment;
import com.ua.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by -rom- on 01.08.2017.
 */
@Controller
public class CommentController {

    private CommentService commentService;

    private CommentToCommentForm commentToCommentForm;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    @Autowired
    public void setCommentToCommentForm(CommentToCommentForm commentToCommentForm) {
        this.commentToCommentForm = commentToCommentForm;
    }

    @RequestMapping({"/comment/listComment", "/comment"})
    public String listComments(Model model){
        model.addAttribute("comments", commentService.listAll());
        return "comment/listComment";
    }

    @RequestMapping("/comment/showComment/{id}")
    public String getComment(@PathVariable String id, Model model){
        model.addAttribute("comment", commentService.getById(id));
        return "comment/showComment";
    }

    @RequestMapping("/comment/editComment/{id}")
    public String edit(@PathVariable String id, Model model){
        Comment comment = commentService.getById(id);
        CommentForm commentForm= commentToCommentForm.convert(comment);

        model.addAttribute("commentForm", commentForm);
        return "comment/commentForm";
    }

    @RequestMapping("/comment/newComment")
    public String newComment(Model model , Comment comment){
        model.addAttribute("commentForm", new CommentForm());

        return "comment/commentForm";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String saveOrUpdateComment(@Valid CommentForm commentForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "comment/commentForm";
        }

        Comment savedComment = commentService.saveOrUpdateCommentForm(commentForm);


        return "redirect:/comment/showComment/" + savedComment.get_id();
    }

    @RequestMapping("/comment/deleteComment/{id}")
    public String delete(@PathVariable String id){
        commentService.delete(id);
        return "redirect:/comment/listComment";
    }



}
