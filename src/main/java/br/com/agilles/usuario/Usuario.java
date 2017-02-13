package br.com.agilles.usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jilles on 03/02/2017.
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
}
