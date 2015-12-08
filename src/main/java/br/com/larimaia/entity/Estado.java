package br.com.larimaia.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kennedy on 07/12/2015.
 */
@Entity
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @Column
    String nome;

    @Column
    String uf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return   uf+"-"+nome ;
    }
}
