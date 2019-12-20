package com.example.ejemplo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class help {
    List<DatosModelo> lista;
    RecyclerView recyclerView;
    RecyclerView.Adapter adaptador;
    BaseDeDatos bd;

    public help(List<DatosModelo> lista, RecyclerView recyclerView, RecyclerView.Adapter adaptador,BaseDeDatos bd) {
        this.lista = lista;
        this.recyclerView = recyclerView;
        this.adaptador = adaptador;
        this.bd=bd;
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            return false;
        }


        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Log.d("hola", String.valueOf(lista.get(viewHolder.getLayoutPosition()).getTitulo()));
            bd.deleterow("marca2",lista.get(viewHolder.getAdapterPosition()).getTitulo());
            lista.remove(viewHolder.getAdapterPosition());
            adaptador.notifyDataSetChanged();

        }
    };

}
