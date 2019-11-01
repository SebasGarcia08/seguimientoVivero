package model;

public abstract class Planta{
    String nombre;
    double costo;

    public Planta(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public Planta(){
        this.nombre = "";
        this.costo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}