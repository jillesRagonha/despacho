package br.com.agilles.natureza;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Jilles on 09/02/2017.
 */
public class NaturezaDao implements Serializable {

    @Inject
    private EntityManager manager;

    public boolean salvarNatureza(Natureza natureza) {
        boolean naturezaSalva = false;
        try {
            manager.getTransaction().begin();
            manager.persist(natureza);
            manager.getTransaction().commit();
            naturezaSalva = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return naturezaSalva;
    }
}
