package com.example.ejemplo;

public class DatosMarca2 {
    private String id_marca;
    private String id_unidad;
    private String uni_desc;


    public DatosMarca2() {

    }

    public DatosMarca2(String id_marca, String id_unidad, String uni_desc) {
        this.id_marca = id_marca;
        this.id_unidad = id_unidad;
        this.uni_desc = uni_desc;

    }

    public String getId_marca() {
        return id_marca;
    }

    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
    }

    public String getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(String id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getUni_desc() {
        return uni_desc;
    }

    public void setUni_desc(String uni_desc) {
        this.uni_desc = uni_desc;
    }


}

