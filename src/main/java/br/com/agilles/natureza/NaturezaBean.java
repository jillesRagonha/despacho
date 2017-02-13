package br.com.agilles.natureza;

import org.primefaces.context.RequestContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Jilles on 09/02/2017.
 */
@Named
@RequestScoped
public class NaturezaBean implements Serializable {

    @Inject
    private Natureza natureza;

    @Inject
    private NaturezaDao dao;

    public void salvarNatureza() {
        if (dao.salvarNatureza(natureza)) {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Sucesso!', 'Nova Natureza inserida no sistema!', 'success')");
            this.natureza = new Natureza();
        } else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Erro!', 'Algo de errado não esta certo!', 'error')");
        }
    }


    public NaturezaDao getDao() {
        return dao;
    }

    public void setDao(NaturezaDao dao) {
        this.dao = dao;
    }

    public Natureza getNatureza() {
        return natureza;
    }

    public void setNatureza(Natureza natureza) {
        this.natureza = natureza;
    }
}
