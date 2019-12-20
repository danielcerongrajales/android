package com.example.ejemplo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adaptador adaptador;
    String DB_NAME = "catalogo.db";
    int DB_VERSION=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseDeDatos db2 = new BaseDeDatos(this, DB_NAME, null, DB_VERSION);
        try {

            db2.createDataBase();
            db2.openDataBase();
            final List<DatosModelo> valores = db2.getAll();
            recyclerView=(RecyclerView)findViewById(R.id.recicler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adaptador=new Adaptador(valores);

            recyclerView.setAdapter(adaptador);
            help ayuda=new help(valores,recyclerView,adaptador,db2);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}