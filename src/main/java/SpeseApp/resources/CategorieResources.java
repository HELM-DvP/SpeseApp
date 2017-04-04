/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TCategorie;
import SpeseApp.entity.TUtenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Stateless
@Path("categorie")
@Produces({MediaType.APPLICATION_JSON})
public class CategorieResources {

    @Inject
    CategorieManager categorieManager;

    @Inject
    UtentiManager utentiManager;

    @Context
    HttpHeaders httpHeaders;

    @GET
    public List<TCategorie> findAll() {
        return categorieManager.findAll();
    }

    @GET
    @Path("{id}")
    public List<TCategorie> findUser(@PathParam("id") int id) {
        return categorieManager.findByUser(id);
    }
    
//    @GET
//    @Path("specifica")
//    public List<TCategorie> findUserAndGeneral() {
//        return categorieManager.findByUserAndGeneral(10);
//    }
    
    
    
}
