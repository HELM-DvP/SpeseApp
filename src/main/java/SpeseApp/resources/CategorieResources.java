/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TCategorie;
import SpeseApp.entity.TUtenti;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
    TokenManager tokenManager;
    
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
    public List<TCategorie> findByUserAndGeneral(@PathParam("id") int id) {
        return categorieManager.findByUserAndGeneral(id);
    }

    //OK
    @DELETE
    @Path("{id}")
    @TokenNeeded
    public void cancellaCat(@PathParam("id") int id) {
        System.out.println("**************** entro...");
        
        if (id == 1) {
            System.out.println("********************** non puoi cancellare una categoria predefinita!!!");
        } else {
            categorieManager.remove(id);
        }
        
    }

    //OK
    @POST
    @Path("crea")
    @Consumes(MediaType.APPLICATION_JSON)
    @TokenNeeded
    public TCategorie create(TCategorie categoria) {
        categoria.setUtente(tokenManager.getCurrentUser());
        return categorieManager.save(categoria);
    }

    /*
    curl -i -X PUT -H 'id_token:10' -H 'Content-Type: application/json' -d '{"idCategoria":5,"nome":"cagne"}' http://localhost:8080/SpeseApp/resources/categorie/
     */
    //MANCA CONTROLLO SU PROPRIETARIO CATEGORIE
    @PUT
    @Path("{id}")
    @TokenNeeded
    public void update(@PathParam("id") int id, TCategorie c) {
        System.out.println("************* update entro");

//        if (!Objects.equals(id, c.getIdCategoria())) {
//            System.out.println("generare errore..");
//        } else {
        c.setUtente(tokenManager.getCurrentUser());
        c.setIdCategoria(id);
        categorieManager.save(c);
//        }

//        if (categorieManager.findUserByIdCategoria(c.getIdCategoria()) == 1) {
//            System.out.println("generare errore..");
//        }
//        c.setUtente(tokenManager.getCurrentUser());
//        categorieManager.save(c);
    }
//    @GET
//    @Path("specifica")
//    public List<TCategorie> findUserAndGeneral() {
//        return categorieManager.findByUserAndGeneral(10);
//    }
}
