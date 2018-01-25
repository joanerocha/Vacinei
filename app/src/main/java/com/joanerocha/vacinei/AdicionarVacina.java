package com.joanerocha.vacinei;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarVacina extends AppCompatActivity {

    EditText nomeVacina;
    EditText doseVacina;
    EditText dataVacina;
    EditText loteVacina;
    EditText localvacina;

    Button validarVacina;
    Button cancelar;

    Bundle bAdicionarVacina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_vacina);

        nomeVacina = (EditText) findViewById(R.id.nomeVacina);
        doseVacina = (EditText) findViewById(R.id.doseVacina);
        dataVacina = (EditText) findViewById(R.id.dataVacina);
        loteVacina = (EditText) findViewById(R.id.lote);
        localvacina = (EditText) findViewById(R.id.local);

        bAdicionarVacina = getIntent().getExtras();
        validarVacina = (Button) findViewById(R.id.validarVacina);
        cancelar = (Button) findViewById(R.id.cancelarVacina);
    }

    public void voltarCartaoVacina(View view) {
        Intent voltarTelaVacina = new Intent(this, CartaoVacina.class);
        voltarTelaVacina.putExtras(bAdicionarVacina);
        startActivity(voltarTelaVacina);
        finish();
    }

    public Boolean verificaCampoPreenchido() {
        String nomeV = nomeVacina.getText().toString();
        String doseV = doseVacina.getText().toString();
        String dataV = dataVacina.getText().toString();
        String loteV = loteVacina.getText().toString();
        String localV = localvacina.getText().toString();
        if (nomeV.equals("") || doseV.equals("") || dataV.equals("") || loteV.equals("") || localV.equals("")) {
            return false;
        }
        return true;
    }

    public void alertaCadastroVacina(final View view) {
        if (verificaCampoPreenchido() == false) { // Verifica se os campos estão vazios
            Toast.makeText(AdicionarVacina.this, "Preencha os dados", Toast.LENGTH_SHORT).show();  // Mensagem de campos vazios
        } else {
            voltarCartaoVacina(view);
            String nomeV = nomeVacina.getText().toString();
            String doseV = doseVacina.getText().toString();
            String dataV = dataVacina.getText().toString();
            String loteV = loteVacina.getText().toString();
            String localV = localvacina.getText().toString();
            String susP = bAdicionarVacina.getString("susPaciente").toString();

            Vacina vacina = new Vacina(nomeV, doseV, dataV, loteV, localV, susP);
            vacina.save(); // salvar
        }
    }
}
