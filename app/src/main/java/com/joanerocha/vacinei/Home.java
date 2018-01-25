package com.joanerocha.vacinei;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private FrameLayout bt_lerQR;
    Bundle b;

    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    ArrayList<Vacina> vacinas = new ArrayList<Vacina>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        b = new Bundle();
        bt_lerQR = (FrameLayout) findViewById(R.id.bt_lerQR);
        final Activity activity = this;
        bt_lerQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scannear QRCode do Paciente");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

    public void cadastrarPaciente(View view) {
        Intent cadastrarPaciente = new Intent(this, CadastroPaciente.class);
        startActivity(cadastrarPaciente);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Você cancelou o Scanner", Toast.LENGTH_LONG).show();
            } else {
                boolean flag = false;
                Paciente p = new Paciente();
                List<Paciente> lista = p.listAll(Paciente.class);
                for (Paciente paciente : lista) {
                    if (paciente.getSus().equals(result.getContents())) {
                        flag = true;
                    }
                }

                if (flag) {
                    Bundle bundle = new Bundle();
                    bundle.putString("susPaciente", result.getContents());
                    Intent cartao = new Intent(this, CartaoVacina.class);
                    cartao.putExtras(bundle);
                    startActivity(cartao);
                } else {
                    Toast.makeText(this, "QR Code inválido!", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(this, Home.class);
                    startActivity(home);
                    finish();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
