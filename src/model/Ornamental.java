package model;

public class Ornamental extends Planta{
    double altura;
    public static int numberOfObjs = 0;

    public Ornamental(String nombre, double costo, double altura) {
        super(nombre, costo);
        this.altura = altura;
        ++numberOfObjs;
    }

    public static int getNumberOfObjs(){
        return numberOfObjs;
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
        return "[Ornamental, altura = " + altura + super.toString() + "]";
    }

}