package com.example.ejemplo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class detallestoks extends AppCompatActivity {
    String DB_NAME = "catalogo.db";
    private static final int DATABASE_VERSION = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallestoks);

        BaseDeDatos db2 = new BaseDeDatos(this, DB_NAME, null,DATABASE_VERSION);
        try {
            db2.createDataBase();
            db2.openDataBase();
            final List<DatosMarca2> valores = db2.getAllmarca2();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recicler2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            Adaptador2 adaptador2 = new Adaptador2(valores);
            recyclerView.setAdapter(adaptador2);
            help ayuda=new help(valores,recyclerView,adaptador2,db2);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
