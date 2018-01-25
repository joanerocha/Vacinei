package com.joanerocha.vacinei;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

public class CadastroEnfermeiro extends AppCompatActivity {

    EditText nome;
    EditText coren;
    EditText email;
    EditText senhaE;
    EditText csenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_enfermeiro);

        nome = (EditText) findViewById(R.id.nome);
        coren = (EditText) findViewById(R.id.coren);
        email = (EditText) findViewById(R.id.email);
        senhaE = (EditText) findViewById(R.id.senha);
        csenha = (EditText) findViewById(R.id.csenha);
    }

    public void voltarTelaEnfermeiro(View view) {
        Intent voltarTelaEnfermeiro = new Intent(this, Home.class);
        startActivity(voltarTelaEnfermeiro);
        finish();
    }

    public Boolean verificaCampo() {
        String nomeEnfermeiro = nome.getText().toString();
        String corenEnfermeiro = coren.getText().toString();
        String emailEnfermeiro = email.getText().toString();
        String senhaEnfermeiro = senhaE.getText().toString();
        if (nomeEnfermeiro.equals("") || corenEnfermeiro.equals("") || emailEnfermeiro.equals("") || senhaEnfermeiro.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificandoCorenExistente() {
        String verificaCoren = coren.getText().toString();
        Boolean flagCoren = true; // era true
        Enfermeiro e = new Enfermeiro();
        List<Enfermeiro> listaEnfermeiro = e.listAll(Enfermeiro.class);
        for (Enfermeiro enfermeiro : listaEnfermeiro) {
            if (enfermeiro.getCoren().equals(verificaCoren)) {
                flagCoren = false; // era false
            }
        }
        return flagCoren;
    }

    public void alertaCadastroEnfermeiro(final View view) {
        if (verificaCampo() == false) { // Verifica se os campos estão vazios
            Toast.makeText(CadastroEnfermeiro.this, "Preencha os dados", Toast.LENGTH_SHORT).show();  // Mensagem de campos vazios
        } else {
            if (verificandoCorenExistente() == false) {
                Toast.makeText(CadastroEnfermeiro.this, "Coren existente!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
            } else {
                if (Validacao.validateEmail(email.getText().toString()) == false) {
                    Toast.makeText(CadastroEnfermeiro.this, "Digite um email Valido!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
                } else {
                    if (!senhaE.getText().toString().equals(csenha.getText().toString())) { // Verifica se as senhas são diferentes
                        Toast.makeText(CadastroEnfermeiro.this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show(); // Mostra Alerta de senhas diferentes
                    } else {
                        voltarTelaEnfermeiro(view);
                        Enfermeiro e = new Enfermeiro(nome.getText().toString(), coren.getText().toString(), email.getText().toString(), senhaE.getText().toString());
                        Enfermeiro.save(e); // salvar
                    }
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SugarContext.init(this);
    }
}
