package com.ua.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by -rom- on 02.08.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/restourant/listRestourant";
    }

}
