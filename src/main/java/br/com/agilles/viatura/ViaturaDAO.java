package br.com.agilles.viatura;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Jilles on 03/02/2017.
 */
public class ViaturaDAO implements Serializable {
    @Inject
    private EntityManager manager;

    public boolean salvarViatura(Viatura viatura) {
        boolean salvo = false;
        try {
            manager.getTransaction().begin();
            manager.persist(viatura);
            manager.getTransaction().commit();
            salvo = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salvo;

    }
}

