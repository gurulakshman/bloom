package com.bloom.resources;

import com.bloom.dao.InfoDao;
import com.bloom.models.Info;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

/**
 * Created by harshvardhan on 12/07/18.
 */
@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    private InfoDao infoDao;

    public MyResource(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @GET
    @Timed
    @Path("/getName")
    public String getName() {
        return "Harsh";
    }

    @POST
    @Timed
    @Path("/postName")
    public String postName(String name) {
        System.out.println("Name given by : "+name);
        return "Ok";
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/findAllEmp")
    public List<Info> findAllEmp() {
        System.out.println("All Emp  : "+infoDao.findAll());
        return infoDao.findAll();
    }
}