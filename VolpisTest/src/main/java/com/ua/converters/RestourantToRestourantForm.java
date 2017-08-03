package com.ua.converters;

import com.ua.commands.CommentForm;
import com.ua.commands.RestourantForm;
import com.ua.domain.Comment;
import com.ua.domain.Restourant;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by -rom- on 01.08.2017.
 */
@Component
public class RestourantToRestourantForm  implements Converter<Restourant, RestourantForm> {
    @Override
    public RestourantForm convert(Restourant restourant) {
        RestourantForm restourantForm= new RestourantForm();
        restourantForm.setId(restourant.get_id().toHexString());
        restourantForm.setRestourant_title(restourant.getRestourant_title());
        restourantForm.setLongitude(restourant.getLongitude());
        restourantForm.setLatitude(restourant.getLatitude());
        restourantForm.setStatus(restourant.getStatus());
        restourantForm.setComment(restourant.getComment());
        return restourantForm;
    }
}
