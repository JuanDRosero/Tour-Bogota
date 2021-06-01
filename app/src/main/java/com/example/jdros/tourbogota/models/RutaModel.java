package com.example.jdros.tourbogota.models;

public class RutaModel {
    public String nombre;
    public String descripcion;
    public String img_mapa;
   // public Lugar[] lugares;

    public RutaModel() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

   /* public Lugar[] getLugares() {
        return lugares;
    }*/

    public String getImgmapa() {
        return img_mapa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  /*  public void setLugares(Lugar[] lugares) {
        this.lugares = lugares;
    }*/

    public void setImgmapa(String imgmapa) {
    img_mapa = imgmapa;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen=" +img_mapa+
                '}';
    }
}
