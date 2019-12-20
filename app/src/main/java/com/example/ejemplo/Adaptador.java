package com.example.ejemplo;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private Context context;
    private List<DatosMarca> lista;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView idmarca,descripcion,status;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idmarca =(TextView)itemView.findViewById(R.id.id_marca2);
            descripcion=(TextView)itemView.findViewById(R.id.id_unidad);
            status=(TextView)itemView.findViewById(R.id.desc_unidad);
            layout =itemView.findViewById(R.id.layout);
        }
    }


    public Adaptador(List<DatosMarca> lista,Context context) {

        this.context = context;
        this.lista = lista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.idmarca.setText(lista.get(position).getId_marca());
        holder.descripcion.setText(lista.get(position).getMarca_desc());
        holder.status.setText(lista.get(position).getMarca_estatus());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lista.get(position).getMarca_desc().equals("TOKS")){

                    Intent i = new Intent(context, detallestoks.class);
                    i.putExtra("PersonID","ss");
                    context.startActivity(i);
                }

               // Toast.makeText(v.getContext(),"ha presionado la posición: "+position,Toast.LENGTH_LONG).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return lista.size();
    }
}
