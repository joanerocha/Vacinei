package com.joanerocha.vacinei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class CartaoVacina extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView list;
    Bundle b;

    Vacina vacina = new Vacina();

    List<Vacina> listaVacina = vacina.listAll(Vacina.class);
    List<Vacina> nomeVacina = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);
        SugarContext.init(this);

        list = (ListView) findViewById(R.id.listViewVacina);

        b = getIntent().getExtras();

        boolean temVacina = false;
        for (Vacina vacina : listaVacina) {
            if (vacina.getSusPaciente().equals(b.getString("susPaciente").toString())) {
                nomeVacina.add(vacina);
                temVacina = true;
            }
        }
        if (!temVacina) {
            Toast.makeText(this, "Não tem vacina", Toast.LENGTH_SHORT).show();
        }
        list = (ListView) findViewById(R.id.listViewVacina);
        list.setAdapter(new TesteVacinasAdapter(this, nomeVacina));
    }

    public void adicionarVacina(View view) {
        Intent adicionarVacina = new Intent(this, AdicionarVacina.class);
        adicionarVacina.putExtras(b);
        startActivity(adicionarVacina);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Vacina vacina = (Vacina) adapterView.getAdapter().getItem(i);
    }
}
