package com.ua.converters;

import com.ua.commands.RestourantForm;
import com.ua.domain.Restourant;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by -rom- on 01.08.2017.
 */
@Component
public class RestourantFormToRestourant implements Converter<RestourantForm, Restourant> {
    @Override
    public Restourant convert(RestourantForm restourantForm) {
        Restourant restourant = new Restourant();
        if (restourantForm.getId() != null  && !StringUtils.isEmpty(restourantForm.getId())) {
            restourant.set_id(new ObjectId(restourantForm.getId()));
        }
        restourant.setRestourant_title(restourantForm.getRestourant_title());
        restourant.setLatitude(restourantForm.getLatitude());
        restourant.setLongitude(restourantForm.getLongitude());
        restourant.setStatus(restourantForm.getStatus());
        restourant.setComment(restourantForm.getComment());
        return restourant;
    }
}
