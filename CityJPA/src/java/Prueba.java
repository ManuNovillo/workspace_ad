
import entities.Ciudad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import util.JPAUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diurno
 */
public class Prueba {
    
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("select c from Ciudad c");
        List<Ciudad> ciudades = q.getResultList();
        ciudades.forEach(System.out::println);
    }
}
