package com.joanerocha.vacinei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class CadastroPaciente extends AppCompatActivity {

    EditText nomeP;
    EditText susP;
    EditText cpfP;
    EditText emailP;
    EditText idadeP;

    ImageView image;
    Button gen_btn;

    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);

        nomeP = (EditText) findViewById(R.id.nomePaciente);
        susP = (EditText) findViewById(R.id.sus);
        cpfP = (EditText) findViewById(R.id.cpf);
        emailP = (EditText) findViewById(R.id.emailPaciente);
        idadeP = (EditText) findViewById(R.id.idade);

        gen_btn = (Button) findViewById(R.id.gen_btn);
        image = (ImageView) findViewById(R.id.image);
    }

    public void voltarTelaEnfermeiro(View view) {
        Intent voltarTelaEnfermeiro = new Intent(this, Home.class);
        startActivity(voltarTelaEnfermeiro);
        finish();
    }

    public Boolean verificaCampoPreenchido() {
        String nomePaciente = nomeP.getText().toString();
        String sus = susP.getText().toString();
        String cpf = cpfP.getText().toString();
        String email = emailP.getText().toString();

        if (nomePaciente.equals("") || sus.equals("") || cpf.equals("") || email.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificandoSusExistente() {
        String verificaSus = susP.getText().toString();
        Boolean flagSus = true; // era true
        Paciente p = new Paciente();
        List<Paciente> listapaciente = p.listAll(Paciente.class);

        for (Paciente paciente : listapaciente) {
            if (paciente.getSus().equals(verificaSus)) {
                flagSus = false; // era false
            }
        }
        return flagSus;
    }

    public boolean verificandoCPFExistente() {
        String verificaCpf = cpfP.getText().toString();
        Boolean flagCPF = true; // era true
        Paciente p = new Paciente();
        List<Paciente> listapaciente = p.listAll(Paciente.class);
        for (Paciente paciente : listapaciente) {
            if (paciente.getCpf().equals(verificaCpf)) {
                flagCPF = false; // era false
            }
        }
        return flagCPF;
    }

    public void TelaGerarQR(final View view) {
        if (verificaCampoPreenchido() == false) { // Verifica se os campos estão vazios
            Toast.makeText(CadastroPaciente.this, "Preencha os dados", Toast.LENGTH_SHORT).show();  // Mensagem de campos vazios
        } else {
            if (verificandoSusExistente() == false) {
                Toast.makeText(CadastroPaciente.this, "SUS já cadastrado!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
            } else {
                if (Validacao.validateSUS(susP.getText().toString()) == false) {
                    Toast.makeText(CadastroPaciente.this, "Digite um SUS Valido!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
                } else {
                    if (verificandoCPFExistente() == false) {
                        Toast.makeText(CadastroPaciente.this, "CPF já cadastrado!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
                    } else {
                        if (Validacao.validateCPF(cpfP.getText().toString()) == false) {
                            Toast.makeText(CadastroPaciente.this, "Digite um CPF Valido!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
                        } else {
                            if (Validacao.validateEmail(emailP.getText().toString()) == false) {
                                Toast.makeText(CadastroPaciente.this, "Digite um email Valido!", Toast.LENGTH_SHORT).show(); // Verifica se o CRM ja existe
                            } else {
                                voltarTelaEnfermeiro(view);
                                Paciente p = new Paciente(nomeP.getText().toString(), susP.getText().toString(), cpfP.getText().toString(), emailP.getText().toString(), Integer.parseInt(idadeP.getText().toString()));
                                p.save(); // salvar
                                Intent gerarQR = new Intent(this, GerarQR.class);
                                b = new Bundle();
                                b.putString("susP", susP.getText().toString());
                                gerarQR.putExtras(b);
                                startActivity(gerarQR);
                                finish();
                            }
                        }

                    }
                }
            }
        }
    }
}

