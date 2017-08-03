package com.ua.repositories;

import com.ua.domain.Restourant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */

public interface RestourantRepository extends CrudRepository<Restourant, String> {
/*
    @Autowired
    MongoTemplate mongoTemplate = null;*/

    @Query("{ latitude : { $lt : 2 }, longitude : { $lt : 2} }")
    List<Restourant> findByLatitude(double latitude);





 /*   @Autowired
    MongoTemplate mongoTemplate = null;

    List<Restourant> findByLatitudeAndLongitude(double latitude, double longitude){
        return mongoTemplate.find("")
    }
*/
/* @Query("{ latitude : { $lt : 2 }, longitude : { $lt : 2} }")
 List<Restourant> findByLatitudeAndLongitude(double latitude, double longitude);*/


}

