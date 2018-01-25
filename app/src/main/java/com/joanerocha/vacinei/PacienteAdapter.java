package com.joanerocha.vacinei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joane Rocha on 14/08/2017.
 */

public class PacienteAdapter extends BaseAdapter {

    private Context context;
    ArrayList<Paciente> pacientes;

    public PacienteAdapter(Context context) {
        super();
        this.context = context;
        pacientes = (ArrayList<Paciente>) Paciente.listAll(Paciente.class);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.infla_paciente, viewGroup, false);
        TextView t = (TextView) view.findViewById(R.id.meuTextPaciente);
        Paciente paciente = (Paciente) pacientes.get(position);
        t.setText(paciente.getNomePaciente());
        return view;
    }
}
