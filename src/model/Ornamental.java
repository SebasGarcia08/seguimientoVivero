package model;

public class Ornamental extends Planta{
    double altura;

    

    public Ornamental(String nombre, double costo, double altura) {
        super(nombre, costo);
        this.altura = altura;
    }

    public Ornamental() {
        super("",0);
        this.altura = 0;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "{" +
            " altura='" + getAltura() + "'" +
            "}";
    }
}