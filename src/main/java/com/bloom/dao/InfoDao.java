package com.bloom.dao;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import com.bloom.models.Info;

import java.util.List;

/**
 * Created by harshvardhan on 10/07/18.
 */
public class InfoDao extends AbstractDAO<Info> {

    public InfoDao(SessionFactory factory) {
        super(factory);
    }

    public List<Info> findAll() {
        return list(namedQuery("com.wordpress.nullpointerexception1.info.findAll"));
    }
}
