/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TMovimenti;
import SpeseApp.entity.TUtenti;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    @Inject
    TokenManager tokenManager;

    @GET
    public List<TMovimenti> findAll() {
        return movimentiManager.findAll();
    }

    @GET
    @Path("{id}")
    public List<TMovimenti> findByUser(@PathParam("id") int id) {
        return movimentiManager.findByUser(id);
    }

    @POST
    @Path("crea")
    @TokenNeeded
    public void crea(TMovimenti tm) {
        System.out.println("****************************** crea ************************************");

        tm.setUtente(tokenManager.getCurrentUser());
        movimentiManager.save(tm);
    }

    @DELETE
    @Path("{id}")
    @TokenNeeded
    public void delete(@PathParam("id") int id) {
        System.out.println("******* delete ************");

        movimentiManager.remove(id);
    }

    @PUT
    @Path("{id}")
    @TokenNeeded
    public void update(@PathParam("id") int id, TMovimenti tm) {
        System.out.println("******* update **********");

//        if (!Objects.equals(id, tm.getIdMovimento())) {
//            System.out.println("generare errore..");
//        } else {
        tm.setUtente(tokenManager.getCurrentUser());
        tm.setIdMovimento(id);
        movimentiManager.save(tm);
//        }
    }

}
