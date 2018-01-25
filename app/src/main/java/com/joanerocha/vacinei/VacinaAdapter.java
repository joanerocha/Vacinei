package com.joanerocha.vacinei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Joane Rocha on 14/08/2017.
 */

public class VacinaAdapter extends BaseAdapter {

    private Context context;
    private List<Vacina> vacinas;

    public VacinaAdapter(Context context, List<Vacina> vacinasPaciente) {
        super();
        this.context = context;
        vacinas = vacinasPaciente;
    }

    @Override
    public int getCount() {
        return vacinas.size();
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        Vacina vacina = vacinas.get(position);
        LayoutInflater meuTextViewInflater = LayoutInflater.from(context);
        TextView meuTextView = (TextView) meuTextViewInflater.inflate(R.layout.infla_vacina, viewGroup, false);
        meuTextView.setText(vacina.getNomeVacina());
        return meuTextView;
    }
}
