package com.example.ejemplo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador2 extends RecyclerView.Adapter<Adaptador2.ViewHolder> {

    private List<DatosMarca2> lista;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView idmarca, id_unidad, desc_unidad;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idmarca =(TextView)itemView.findViewById(R.id.id_marca2);
            id_unidad =(TextView)itemView.findViewById(R.id.id_unidad);
            desc_unidad =(TextView)itemView.findViewById(R.id.desc_unidad);
            layout =itemView.findViewById(R.id.layout);
        }
    }


    public Adaptador2(List<DatosMarca2> lista) {


        this.lista = lista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items2,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.idmarca.setText(lista.get(position).getId_marca());
        holder.id_unidad.setText(lista.get(position).getId_unidad());
        holder.desc_unidad.setText(lista.get(position).getUni_desc());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(),"ha presionado la posición: "+position,Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return lista.size();
    }
}
