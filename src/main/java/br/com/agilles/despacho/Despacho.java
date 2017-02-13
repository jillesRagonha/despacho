package br.com.agilles.despacho;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Jilles on 31/01/2017.
 */
@Entity
public class Despacho {

    @Id
    @GeneratedValue
    private long codigo;


}
