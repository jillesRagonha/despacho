package br.com.agilles.viatura;

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
public class ViaturaBean implements Serializable {
    @Inject
    private Viatura viatura;

    @Inject
    private ViaturaDAO dao;

    public void salvar(){
        if(dao.salvarViatura(viatura)){
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Sucesso!', 'Viatura Salva com sucesso!', 'success')");
            viatura= new Viatura();
        }else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Erro!', 'Não foi possível cadastrar a viatura!', 'error')");
        }
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setDao(ViaturaDAO dao) {
        this.dao = dao;
    }

    public void setViatura(Viatura viatura) {
        this.viatura = viatura;
    }

    public ViaturaDAO getDao() {
        return dao;
    }
}
