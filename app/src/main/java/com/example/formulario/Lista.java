package com.example.formulario;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

import android.os.Parcelable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import com.airbnb.lottie.L;


public class Lista extends AppCompatActivity {

    public GestureDetectorCompat gestureDetectorCompat;
    public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float veloX, float veloY) {
            if(event2.getX() > event1.getX()){
                Intent intent = new Intent(Lista.this, MainActivity.class);
                startActivity(intent);
            }
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    ListView listaItensLV;
    Bundle argumento = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        gestureDetectorCompat = new GestureDetectorCompat(Lista.this, new MyGestureListener());

        Intent intent = getIntent();
        argumento     = (Bundle) intent.getBundleExtra(MainActivity.BUNDLE);

        ArrayList<Parcelable> clientes;
        clientes = (ArrayList<Parcelable>) argumento.getParcelableArrayList("clientes");

        listaItensLV = (ListView) findViewById(R.id.listaItensLV);
        listaItensLV.setAdapter(new Adaptador(Lista.this, clientes));

        listaItensLV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Lista.this, "LONG CLICK LISTENER",
                        Toast.LENGTH_SHORT).show();
//                final int which_item = position;
//                new AlertDialog.Builder(Lista.this)
//                        .setIcon(android.R.drawable.ic_delete)
//                        .setTitle("Deletar cliente ?")
//                        .setMessage("Deseja de deletar o cliente selecioanado?")
//                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                clientes.remove(which_item);
//                            }
//                        })
//                        .setNegativeButton("Não", null)
//                        .show();
                return true;
            }
        });

    }

    public void setArguments(Bundle bundle) {
        argumento = (Bundle) bundle;
    }

    public Bundle getArguments() {
        return argumento;
    }
}