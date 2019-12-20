package com.example.ejemplo;

public class DatosMarca {
    private String id_marca;
    private String marca_desc;
    private String marca_estatus;


    public DatosMarca() {

    }

    public DatosMarca(String id_marca, String marca_desc, String marca_estatus) {
        this.id_marca = id_marca;
        this.marca_desc = marca_desc;
        this.marca_estatus = marca_estatus;

    }

    public String getId_marca() {
        return id_marca;
    }

    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca_desc() {
        return marca_desc;
    }

    public void setMarca_desc(String marca_desc) {
        this.marca_desc = marca_desc;
    }

    public String getMarca_estatus() {
        return marca_estatus;
    }

    public void setMarca_estatus(String marca_estatus) {
        this.marca_estatus = marca_estatus;
    }


}

