package br.com.agilles.talao;

import br.com.agilles.despacho.Despacho;
import org.primefaces.context.RequestContext;

import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jilles on 31/01/2017.
 */
@Named
@RequestScoped
public class TalaoBean implements Serializable {
    @Inject
    private Talao talao;
    private Talao talaoAbertoSelecionado = new Talao();

    @Inject
    private TalaoDAO dao;

    private List<Talao> taloesEmAberto = new ArrayList<>();

    public Talao getTalao() {
        return talao;
    }

    public void setTalao(Talao talao) {
        this.talao = talao;
    }

    public void abrirTalao() {
        if (dao.abrirTalao(talao)) {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Sucesso!', 'Novo talão inserido no sistema!', 'success')");
            this.talao = new Talao();
            this.talao.setTalao(dao.pegarUltimoTalao() + 1);
            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
            this.talao.setHoraInicial(time.format(formatter));

        } else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Erro!', 'Não foi possível inserir o talão!', 'error')");
        }

    }

    public void encerrarTalao() {
        if (dao.encerrarTalao(talaoAbertoSelecionado)) {

            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Sucesso!', 'Talão Encerrado!', 'success')");
            init();
        }else {
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("swal('Erro!', 'Não foi possível encerrar o talão!', 'error')");
        }
    }


    @PostConstruct
    public void init() {
        limpar();
        taloesEmAberto = dao.listarTaloesEmAberto();

    }

    public void limpar() {
        this.talao.setTalao(dao.pegarUltimoTalao() + 1);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        this.talao.setHoraInicial(time.format(formatter));


    }

    public List<Talao> getTaloesEmAberto() {
        return taloesEmAberto;
    }

    public void setDao(TalaoDAO dao) {
        this.dao = dao;
    }

    public Talao getTalaoAbertoSelecionado() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        talaoAbertoSelecionado.setHoraFinal(time.format(formatter));
        return talaoAbertoSelecionado;
    }

    public void setTalaoAbertoSelecionado(Talao talaoAbertoSelecionado) {
        this.talaoAbertoSelecionado = talaoAbertoSelecionado;

    }
}
