/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TUtenti;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author tss
 */
@RequestScoped
public class TokenManager {
    
    @Inject
    UtentiManager utentiManager;
    
    private TUtenti utente;

    public boolean validateToken(String token){
        boolean result = false;
        try{
            int id = Integer.parseInt(token);
            utente = utentiManager.findById(id);
            result=true;
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return result;
    }

    public TUtenti getCurrentUser() {
        return utente;
    }
    
    
}
