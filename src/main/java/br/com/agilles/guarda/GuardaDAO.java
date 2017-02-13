package br.com.agilles.guarda;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Jilles on 03/02/2017.
 */
public class GuardaDAO implements Serializable {

    @Inject
    private EntityManager manager;

    public boolean salvarGuarda(Guarda guarda) {
        boolean salvo = false;
        try {
            manager.getTransaction().begin();
            manager.persist(guarda);
            manager.getTransaction().commit();
            salvo = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salvo;

    }
}
