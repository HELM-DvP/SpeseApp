/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TUtenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tss
 */
@Stateless
@Path("utenti")
@Produces({MediaType.APPLICATION_JSON})
public class UtentiResources {

    @Inject
    UtentiManager utentiManager;

    @GET
    public List<TUtenti> all() {
        return utentiManager.findAll();
    }

    @GET
    @Path("{id}")
    public TUtenti find(@PathParam("id") int id) {
        return utentiManager.findById(id);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") int id) {
        utentiManager.remove(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public TUtenti create(TUtenti utente) {
        return utentiManager.save(utente);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void create(@FormParam("user") String user,
            @FormParam("pwd") String pwd,
            @FormParam("mail") String mail) {

        TUtenti utente = new TUtenti(user, pwd, mail);
        utentiManager.save(utente);
    }

    @POST
    @Path("login")
    public Response login(TUtenti u) {
        if (u == null) {
            return Response.serverError()
                    .header("caused-by", "nessun dato per effettuare la login")
                    .build();
        }

        TUtenti finded = utentiManager.findByUserAndPwd(u.getUser(), u.getPwd());
        if (finded == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("caused-by", "login failed")
                    .build();
        }
        System.out.println(finded + " loggato...");
        JsonObject json = Json
                .createObjectBuilder()
//                .add("id_token", finded.getIdUtente())
                .build();
        return Response.ok(json).build();
    }

}
