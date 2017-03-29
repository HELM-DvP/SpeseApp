/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TUtenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

@Stateless
public class UtentiManager {
    @PersistenceContext
    private EntityManager em;
    
    public TUtenti save (TUtenti tosave){
        return em.merge(tosave);
    }
    
    public void remove (int id){
        TUtenti find= em.find(TUtenti.class, id);
        em.remove(find);
    }
    
    public List<TUtenti> findAll(){
        return em.createNamedQuery(TUtenti.FIND_ALL).getResultList();
    }
    
    //Questo è necessario per la login
    public TUtenti findByUserAndPwd(String user, String pwd){
        TUtenti result=null;
        try{
            result=em.createNamedQuery(TUtenti.FIND_BY_USER_AND_PWD, TUtenti.class).setParameter("user", user).setParameter("pwd", pwd).getSingleResult();
        } catch (NoResultException e){
        
        }        
        return result;
    }
    
    public TUtenti findById(int id){
        return em.find(TUtenti.class, id);
    }
    
    //Restituisce l'utente loggato
    public TUtenti getLogged(int id){
        return em.find(TUtenti.class, id);
    }
}
