package com.example.ejemplo;

public class DatosModelo {
    private String titulo;
    private String descripcion;


    private String status;


    public DatosModelo() {

    }

    public DatosModelo(String titulo, String descripcion,String status) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.status = status;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

