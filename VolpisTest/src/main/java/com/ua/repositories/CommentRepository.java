package com.ua.repositories;

import com.ua.domain.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by -rom- on 01.08.2017.
 */
public interface CommentRepository extends CrudRepository<Comment,String> {

}
