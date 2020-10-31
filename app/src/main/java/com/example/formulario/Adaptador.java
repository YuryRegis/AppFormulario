package com.example.formulario;


import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.RatingBar;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;


public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context context;
    ArrayList<Parcelable> clientes;

    public Adaptador(Context contexto, ArrayList<Parcelable> listaClientes) {
        this.context  = contexto;
        this.clientes = (ArrayList<Parcelable>) listaClientes;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cliente elemento = (Cliente) clientes.get(position);

        final View view  = inflater.inflate(R.layout.celula_lista, null);

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        TextView celulaValueTV      = (TextView) view.findViewById(R.id.celulaValueTV);
        TextView celulaClienteTV    = (TextView) view.findViewById(R.id.celulaClienteTV);
        TextView celulaSeguimentoTV = (TextView) view.findViewById(R.id.celulaSeguimentoTV);

        ratingBar.setProgress(Integer.valueOf(elemento.getNota()));

        celulaValueTV.setText(elemento.getCupom());
        celulaClienteTV.setText(elemento.getNome());
        celulaSeguimentoTV.setText(elemento.getSeguimento());

        return view;
    }
}
