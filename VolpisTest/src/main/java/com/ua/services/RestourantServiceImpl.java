package com.ua.services;

import com.ua.commands.CommentForm;
import com.ua.commands.RestourantForm;
import com.ua.converters.CommentFormToComment;
import com.ua.converters.RestourantFormToRestourant;
import com.ua.domain.Comment;
import com.ua.domain.Restourant;
import com.ua.repositories.CommentRepository;
import com.ua.repositories.RestourantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
@Service
public class RestourantServiceImpl  implements  RestourantService{


    private RestourantRepository restourantRepository;

    private CommentRepository commentRepository;
    private CommentFormToComment commentFormToComment;

    private RestourantFormToRestourant restourantFormToRestourant;
    @Autowired
    public RestourantServiceImpl( RestourantRepository restourantRepository, CommentRepository commentRepository, CommentFormToComment commentFormToComment, RestourantFormToRestourant restourantFormToRestourant) {
        this.restourantRepository = restourantRepository;
        this.commentRepository = commentRepository;
        this.commentFormToComment = commentFormToComment;
        this.restourantFormToRestourant = restourantFormToRestourant;
    }


    @Override
    public List<Restourant> listAll() {
    List<Restourant> restourants = new ArrayList<>();
    restourantRepository.findAll().forEach(restourants::add);
        return restourants;
    }

    @Override
    public Restourant getById(String id) {
        return restourantRepository.findOne(id);
    }

    @Override
    public Restourant saveOrUpdate(Restourant restourant) {
////
    commentRepository.save(restourant.getComment());

/////
    restourantRepository.save(restourant);
    return restourant;
    }

    @Override
    public void delete(String id) {
    restourantRepository.delete(id);
    }

    @Override
    public Restourant saveOrUpdateRestourantForm(RestourantForm restourantForm ) {

            restourantForm.setStatus("OK");


        Comment commentNew =new Comment();
        commentNew.set_id(commentNew.get_id());
        commentNew.setTitle_of_comment(commentNew.getTitle_of_comment());
        commentNew.setText_of_comment(commentNew.getText_of_comment());
        commentNew.setMark(commentNew.getMark());
        restourantForm.setComment(commentNew);




      Restourant savedRestourant = saveOrUpdate(restourantFormToRestourant.convert(restourantForm));

        System.out.println("Saved restourant Id: " + savedRestourant.get_id());

        return savedRestourant;
    }

    @Override
    public List<Restourant> findByLatitude(double latitude) {
        return restourantRepository.findByLatitude(latitude);
    }


}
