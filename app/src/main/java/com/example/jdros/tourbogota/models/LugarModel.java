package com.example.jdros.tourbogota.models;

public class LugarModel {
    public String nombre;
    public String descripcion;
    public String ubicacion;
    public String imperdibles;
    public String img;

    public LugarModel() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImg() {
        return img;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getImperdibles() {
        return imperdibles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString(){
        return "Ruta{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen=" +img+ '\''+
                ", ubicacion="+ ubicacion+
                '}';
    }
}
