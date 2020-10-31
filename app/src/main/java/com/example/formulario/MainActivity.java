// ListView referência --> https://www.youtube.com/watch?v=Uur6-64KqxI

package com.example.formulario;


import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.Button;
import android.widget.Switch;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    Switch switchBT;
    Toolbar toolbar;
    FloatingActionButton fab;
    Button saveBT, searchBT;
    TextView tituloTV, ratingTV, cupomTV;
    EditText clientInput, seguimentoInput, notaInput;

    public static final String BUNDLE = "com.example.formulario.BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        final Lista lista = new Lista();

        List<Cliente> clientes = new ArrayList<Cliente>();

        saveBT = (Button) findViewById(R.id.saveBT);
        searchBT = (Button) findViewById(R.id.searchBT);

        switchBT = (Switch) findViewById(R.id.switchBT);

        cupomTV = (TextView) findViewById(R.id.cupomTV);
        tituloTV = (TextView) findViewById(R.id.tituloTV);
        ratingTV = (TextView) findViewById(R.id.ratingTV);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        notaInput = (EditText) findViewById(R.id.notaInput);
        clientInput = (EditText) findViewById(R.id.clientInput);
        seguimentoInput = (EditText) findViewById(R.id.seguimentoInput);

        /*toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/

        switchBT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switchBT.setText(""+(isChecked ? "Sim" : "Não"));
            }
        });


        saveBT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String cupom      = switchBT.getText().toString();
                String nota       = notaInput.getText().toString();
                String nome       = clientInput.getText().toString();
                String seguimento = seguimentoInput.getText().toString();

                if (nome.equals("") || nota.equals("") || seguimento.equals("")) {
                    Toast.makeText(MainActivity.this, "Erro! Campo em branco.",
                            Toast.LENGTH_SHORT).show();
                } else if ((Integer.parseInt(nota)<0) || (Integer.parseInt(nota)>10)) {
                    Toast.makeText(MainActivity.this, "Erro! Inserir nota entre 0 a 10.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    clientes.add(new Cliente(nome, seguimento, nota, cupom));

                    notaInput.setText("");
                    clientInput.setText("");
                    seguimentoInput.setText("");

                    Toast.makeText(MainActivity.this, "Adicionado",
                            Toast.LENGTH_SHORT).show();
                }
                return;
            }
        });


        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String cupom      = switchBT.getText().toString();
                String nota       = notaInput.getText().toString();
                String nome       = clientInput.getText().toString();
                String seguimento = seguimentoInput.getText().toString();

                if (nome.equals("") || nota.equals("") || seguimento.equals("")) {
                    Toast.makeText(MainActivity.this, "Erro! Campo em branco.",
                            Toast.LENGTH_SHORT).show();
                } else if ((Integer.parseInt(nota)<0) || (Integer.parseInt(nota)>10)) {
                    Toast.makeText(MainActivity.this, "Erro! Inserir nota entre 0 a 10.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    clientes.add(new Cliente(nome, seguimento, nota, cupom));

                    notaInput.setText("");
                    clientInput.setText("");
                    seguimentoInput.setText("");

                    Toast.makeText(MainActivity.this, "Adicionado",
                            Toast.LENGTH_SHORT).show();
                }
                return;
            }
        });


        searchBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clientes.size() <= 0){
                    Toast.makeText(MainActivity.this, "Erro! Lista vazia.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, Lista.class);

                bundle.putParcelableArrayList("clientes", (ArrayList<? extends Parcelable>) clientes);
                /*lista.setArguments(bundle);*/

                intent.putExtra(BUNDLE, bundle);
                startActivity(intent);
            }

        });

    }
}