/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TMovimenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Stateless
@Path("movimenti")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MovimentiResources {
    
    @Inject
    UtentiManager utentiManager;
    
    @Inject
    CategorieManager categorieManager;
    
    @Inject
    MovimentiManager movimentiManager;
    
    @GET
    public List<TMovimenti> findAll(){
        return movimentiManager.findAll();
    }
    
    @GET
    @Path("{id}")
    public List<TMovimenti> findByUser(@PathParam("id") int id){
        return movimentiManager.findByUser(id);
    }
}
