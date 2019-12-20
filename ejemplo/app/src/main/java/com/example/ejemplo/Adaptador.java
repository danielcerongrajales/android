package com.example.ejemplo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private Context context;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView idmarca,descripcion,status;

        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idmarca =(TextView)itemView.findViewById(R.id.idmarca);
            descripcion=(TextView)itemView.findViewById(R.id.descripcion);
            status=(TextView)itemView.findViewById(R.id.status);
            layout =itemView.findViewById(R.id.layout);
        }
    }
    public List<DatosModelo> lista;

    public Adaptador(List<DatosModelo> lista) {
        this.lista = lista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.idmarca.setText(lista.get(position).getTitulo());
        holder.descripcion.setText(lista.get(position).getDescripcion());
        holder.status.setText(lista.get(position).getStatus());
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
