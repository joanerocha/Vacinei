package com.joanerocha.vacinei;

import com.orm.SugarRecord;

/**
 * Created by Joane Rocha on 07/08/2017.
 */

public class Vacina extends SugarRecord {
    private long idVacina;
    private String nomeVacina;
    private String dose;
    private String data;
    private String lote;
    private String local;
    private String susPaciente;

    public Vacina() {
    }

    public Vacina(String nomeVacina, String dose, String data, String lote, String local, String susPaciente) {
        this.nomeVacina = nomeVacina;
        this.dose = dose;
        this.data = data;
        this.lote = lote;
        this.local = local;
        this.susPaciente = susPaciente;
    }

    public Vacina(String nomeVacina, String dose, String data, String local, String susPaciente) {
        this.nomeVacina = nomeVacina;
        this.dose = dose;
        this.data = data;
        this.local = local;
        this.susPaciente = susPaciente;
    }

    @Override
    public String toString() {
        return "Vacina{" +
                "idVacina=" + idVacina +
                ", nomeVacina='" + nomeVacina + '\'' +
                ", dose='" + dose + '\'' +
                ", data='" + data + '\'' +
                ", lote='" + lote + '\'' +
                ", local='" + local + '\'' +
                ", susPaciente='" + susPaciente + '\'' +
                '}';
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getSusPaciente() {
        return susPaciente;
    }

    public void setSusPaciente(String susPaciente) {
        this.susPaciente = susPaciente;
    }

    public long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(long idVacina) {
        this.idVacina = idVacina;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
