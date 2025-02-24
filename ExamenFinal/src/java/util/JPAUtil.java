/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf;
    static{
        try{
            emf=Persistence.createEntityManagerFactory("PlayasPU");
        } catch (Throwable ex) {
            System.err.println("Error al crear SessionFactory."+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }
}