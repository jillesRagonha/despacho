package br.com.agilles.guarda;

import br.com.agilles.endereco.Endereco;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jilles on 03/02/2017.
 */
@Entity
public class Guarda implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String ra;
    private String nome;
    private String nomeGuerra;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGuerra() {
        return nomeGuerra;
    }

    public void setNomeGuerra(String nomeGuerra) {
        this.nomeGuerra = nomeGuerra;
    }
}
