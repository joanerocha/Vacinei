package com.joanerocha.vacinei;

import com.orm.SugarRecord;

/**
 * Created by Joane Rocha on 08/08/2017.
 */

public class Paciente extends SugarRecord {
    private long idPaciente;
    private String nomePaciente;
    private String sus;
    private String cpf;
    private String email;
    private int idade;

    public Paciente() {

    }

    public Paciente(String nomePaciente, String sus, String cpf, String email, int idade) {
        this.nomePaciente = nomePaciente;
        this.sus = sus;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getSus() {
        return sus;
    }

    public void setSus(String sus) {
        this.sus = sus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                "nomePaciente='" + nomePaciente + '\'' +
                ", sus='" + sus + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
