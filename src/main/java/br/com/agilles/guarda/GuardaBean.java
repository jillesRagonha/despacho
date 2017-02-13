package br.com.agilles.guarda;

import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Jilles on 03/02/2017.
 */
@Named
@RequestScoped
public class GuardaBean implements Serializable {

    @Inject
    private Guarda guarda;

    @Inject
    private GuardaDAO dao;

    public Guarda getGuarda() {
        return guarda;
    }

    public void setGuarda(Guarda guarda) {
        this.guarda = guarda;
    }

    public void setDao(GuardaDAO dao) {
        this.dao = dao;
    }

    public GuardaDAO getDao() {
        return dao;
    }

    public void salvar(){
        if(dao.salvarGuarda(guarda)){
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Sucesso!', 'Guarda Salvo com sucesso!', 'success')");
            guarda = new Guarda();
        }else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Erro!', 'Não foi possível cadastrar o guarda!', 'error')");
        }
    }


}
