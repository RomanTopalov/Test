package com.ua.controllers;

import com.mongodb.Mongo;
import com.ua.commands.CommentForm;
import com.ua.commands.RestourantForm;
import com.ua.converters.RestourantToRestourantForm;
import com.ua.domain.Restourant;
import com.ua.services.RestourantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by -rom- on 01.08.2017.
 */

@Controller
public class RestourantController {

    private RestourantService restourantService;

    private RestourantToRestourantForm restourantToRestourantForm;

    @Autowired
    public void setRestourantToRestourantForm(RestourantToRestourantForm restourantToRestourantForm) {
        this.restourantToRestourantForm = restourantToRestourantForm;
    }
@Autowired
    public void setRestourantService(RestourantService restourantService) {
        this.restourantService = restourantService;
    }



    @RequestMapping({"/restourant/listRestourant", "/restourant"})
    public String listRestourants(Model model){
        model.addAttribute("restourants", restourantService.listAll());
        return "restourant/listRestourant";
    }

    @RequestMapping("/restourant/showRestourant/{id}")
    public String getRestourant(@PathVariable String id, Model model){
        model.addAttribute("restourant", restourantService.getById(id));
        return "restourant/showRestourant";
    }

    @RequestMapping("/restourant/editRestourant/{id}")
    public String edit(@PathVariable String id, Model model){
       Restourant restourant = restourantService.getById(id);
        RestourantForm restourantForm = restourantToRestourantForm.convert(restourant);

        model.addAttribute("restourantForm", restourantForm);
        return "restourant/restourantForm";
    }

    @RequestMapping("/restourant/deleteRestourant/{id}")
    public String delete(@PathVariable String id){
        restourantService.delete(id);
        return "redirect:/restourant/listRestourant";
    }

    @RequestMapping("/restourant/newRestourant")
    public String newRestourant(Model model){
        model.addAttribute("restourantForm", new RestourantForm());
        return "restourant/restourantForm";
    }

    @RequestMapping(value = "/restourant", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid RestourantForm restourantForm, @Valid CommentForm commentForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "restourant/restourantForm";
        }

        Restourant savedRestourant = restourantService.saveOrUpdateRestourantForm(restourantForm);

        return "redirect:/restourant/showRestourant/" + savedRestourant.get_id();
    }


    @RequestMapping({"/restourant/nearestRestourant", "/restourant"})
    public String findByLatitudeAndLongitude( @ModelAttribute Restourant restourant, Model model){



        model.addAttribute("restourants", restourantService.findByLatitude(restourant.getLatitude()));

        return "restourant/nearestRestourant";
    }


    /*@RequestMapping({"/restourant/nearestRestourant", "/restourant"})
    public String nearestRestourant(@PathVariable String id, Model model){

      *//*  Restourant restourant1 = restourantService.getById(id);

        if((restourant1.getLatitude()<=2) && (restourant1.getLongitude()<=2)){
            model.addAttribute("restourants", restourantService.listAll());
        }else {
            System.out.println("NO mf");
        }*//*


                model.addAttribute("restourants", restourantService.listAll());


        return "restourant/nearestRestourant";
    }
*/





}




















