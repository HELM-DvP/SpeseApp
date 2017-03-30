/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TCategorie;
import SpeseApp.entity.TMovimenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class MovimentiManager {

    @PersistenceContext
    private EntityManager em;

    //ritorna lista di categorie, di numero variabile, selezionate dall'utente
    public List<TMovimenti> movimentiByCategorie(List<TCategorie> categorie) {
        return em.createQuery("select e from TMovimenti e where e.idCategoria in :cat")
                .setParameter("cat", categorie)
                .getResultList();
    }

    public TMovimenti save(TMovimenti m) {
        return em.merge(m);
    }
    
    public void remove(int id) {
        TMovimenti m = em.find(TMovimenti.class, id);
        em.remove(m);
    }

}
