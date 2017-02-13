package br.com.agilles.talao;

import br.com.agilles.despacho.Despacho;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jilles on 31/01/2017.
 */
public class TalaoDAO implements Serializable {

    @Inject
    private EntityManager manager;

    public boolean abrirTalao(Talao talao) {
        boolean aberto = false;
        try {
            manager.getTransaction().begin();
            manager.persist(talao);
            manager.getTransaction().commit();
            aberto = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aberto;

    }



    public List<Talao> listarTaloesEmAberto() {
        List<Talao> taloes = new ArrayList<>();
        try {
            TypedQuery<Talao> query = manager.createQuery("SELECT t from Talao t where t.aberto = true", Talao.class);
            taloes = query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        return taloes;
    }

    public Long pegarUltimoTalao() {
        Talao talao = new Talao();
        TypedQuery<Talao> query = manager.createQuery("SELECT  t from Talao t order by t.talao desc", Talao.class);
        talao = query.setMaxResults(1).getSingleResult();
        Long numeroTalao = talao.getTalao();
        return numeroTalao;

    }

    public boolean encerrarTalao(Talao talaoAberto) {
        talaoAberto.setAberto(false);
        boolean encerrado = false;
        try {
            manager.getTransaction().begin();
            manager.merge(talaoAberto);
            manager.getTransaction().commit();
            encerrado = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return encerrado;
    }

}
