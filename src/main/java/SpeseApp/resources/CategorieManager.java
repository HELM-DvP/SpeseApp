/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeseApp.resources;

import SpeseApp.entity.TCategorie;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
public class CategorieManager {

    @PersistenceContext
    private EntityManager em;

    public TCategorie save(TCategorie tosave) {
        return em.merge(tosave);
    }

    public void remove(int id) {
        TCategorie c = em.find(TCategorie.class, id);
        em.remove(c);
    }

    public List<TCategorie> findAll() {
        return em.createNamedQuery(TCategorie.FIND_ALL).getResultList();
    }

    
//    public List<TCategorie> findById(List<TCategorie> search) {
//        return em.createQuery("select e from TCategorie e where e in :cat")
//                .setParameter("cat", search)
//                .getResultList();
//    }
//    
//    public List<TCategorie> findById(int... ids) {
//        List<TCategorie> result = new ArrayList<>();
//        for (int id : ids) {
//            result.add(em.find(TCategorie.class, id));
//        }
//        return result;
//    }
}
