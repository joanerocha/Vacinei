package com.joanerocha.vacinei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

import static com.joanerocha.vacinei.R.id.coren;
import static com.joanerocha.vacinei.R.id.nome;

public class MainActivity extends AppCompatActivity {
    EditText login;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText) findViewById(R.id.loginLogin);
        senha = (EditText) findViewById(R.id.senhaLogin);

        SugarContext.init(this);
    }

    public void cadastrarEnfermeiro(View view) {
        Intent cadastrarEnfermeiro = new Intent(this, CadastroEnfermeiro.class);
        startActivity(cadastrarEnfermeiro);
//        finish();
    }

    public Boolean verificaCampoLogin() {
        String loginEnfermeiro = login.getText().toString();
        String senhaEnfermeiro = senha.getText().toString();

        if (loginEnfermeiro.equals("") || senhaEnfermeiro.equals("")) {
            return false;
        }
        return true;
    }

    public void logar(View view) {
        String lgin = login.getText().toString();
        String pass = senha.getText().toString();
        Boolean flagE = true;

        if (verificaCampoLogin() == false) { // Verifica se os campos estão vazios
            Toast.makeText(MainActivity.this, "Preencha os dados", Toast.LENGTH_SHORT).show();  // Mensagem de campos vazios
        }else{
            Enfermeiro e = new Enfermeiro();
            List<Enfermeiro> listaEnfermeiro = e.listAll(Enfermeiro.class);

            for (Enfermeiro enfermeiro : listaEnfermeiro) {
                if (enfermeiro.getCoren().equals(lgin)) {
                    if (enfermeiro.getSenha().equals(pass)) {
                        flagE = false;
                        Intent home = new Intent(this, Home.class);
                        //home.putExtra("nome", enfermeiro.getNomeEnfermeiro());
                        startActivity(home);
                        //finish();
                    }
                }
            }
            if (flagE) {
                Toast.makeText(MainActivity.this, "Enfermeiro não cadastrado!", Toast.LENGTH_SHORT).show();
            }
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        SugarContext.terminate();
//    }
}
