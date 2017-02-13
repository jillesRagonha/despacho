package br.com.agilles.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Jilles on 31/01/2017.
 */
@ApplicationScoped
public class JPAUtil {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("despacho");

    @Produces
    @RequestScoped
    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManager manager){
        manager.close();
    }
}
