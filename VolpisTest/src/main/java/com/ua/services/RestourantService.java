package com.ua.services;

import com.ua.commands.RestourantForm;
import com.ua.domain.Comment;
import com.ua.domain.Restourant;

import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */
public interface RestourantService {

    List<Restourant> listAll();

    Restourant getById(String id);

    Restourant saveOrUpdate(Restourant restourant);

    void delete(String id);

    Restourant saveOrUpdateRestourantForm(RestourantForm restourantForm);

    List<Restourant> findByLatitude(double latitude);


}
