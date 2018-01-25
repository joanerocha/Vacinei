package com.joanerocha.vacinei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class BuscarPaciente extends AppCompatActivity {

    ListView list;
    Paciente p = new Paciente();
    List<Paciente> lista = p.listAll(Paciente.class);
    Bundle b;

    List<String> susPacientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_paciente);

        b = new Bundle();

        SugarContext.init(this);
        for (Paciente p : lista) { //Carrega nome dos pacientes para lista
            if (p.getSus() != null) {
                susPacientes.add(p.getSus());
            }
        }
        AutoCompleteTextView pacientes = (AutoCompleteTextView) findViewById(R.id.completePaciente);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, susPacientes);
        pacientes.setAdapter(adaptador);

        list = (ListView) findViewById(R.id.listViewPaciente);
        list.setAdapter(new PacienteAdapter(this));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent cartao = new Intent(BuscarPaciente.this, CartaoVacina.class);
                startActivity(cartao);
            }
        });
    }
}
