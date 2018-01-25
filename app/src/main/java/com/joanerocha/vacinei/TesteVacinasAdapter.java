package com.joanerocha.vacinei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Joane Rocha on 16/08/2017.
 */

public class TesteVacinasAdapter extends BaseAdapter {
    private Context context;
    private List<Vacina> vacinas;

    public TesteVacinasAdapter(Context context, List<Vacina> vacinas) {
        super();
        this.context = context;
        this.vacinas = vacinas;
    }

    @Override
    public int getCount() {
        return vacinas != null ? vacinas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return vacinas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.infla_vacina, parent, false);
        TextView nome = (TextView) view.findViewById(R.id.nomeVacinaAdapter);
        TextView data = (TextView) view.findViewById(R.id.dataVacinaAdapter);
        TextView dose = (TextView) view.findViewById(R.id.doseVacinaAdapter);
        TextView lote = (TextView) view.findViewById(R.id.loteVacinaAdapter);
        TextView local = (TextView) view.findViewById(R.id.localVacinaAdapter);

        Vacina vacina = (Vacina) vacinas.get(i);
        nome.setText(vacina.getNomeVacina());
        data.setText("Data: " + vacina.getData());
        dose.setText("Dose: " + vacina.getDose());
        lote.setText("Lote: " + vacina.getLote());
        local.setText("Local: " + vacina.getLocal());
        return view;
    }
}
