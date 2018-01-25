package com.joanerocha.vacinei;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by Joane Rocha on 07/08/2017.
 */
@Table
public class Enfermeiro extends SugarRecord {
    private long idEnfermeiro;
    private String nomeEnfermeiro;
    private String coren;
    private String email;
    private String senha;

    public Enfermeiro() {

    }

    public Enfermeiro(String nomeEnfermeiro, String coren, String email, String senha) {
        this.nomeEnfermeiro = nomeEnfermeiro;
        this.coren = coren;
        this.email = email;
        this.senha = senha;
    }

    public String getCoren() {
        return coren;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Enfermeiro{" +
                "idEnfermeiro=" + idEnfermeiro +
                ", nomeEnfermeiro='" + nomeEnfermeiro + '\'' +
                ", coren='" + coren + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
