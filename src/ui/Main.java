package ui;

import model.*;
import java.util.Random;
import static java.lang.System.out;

public class Main{
    private static Vivero vivero;
    public static Random random = new Random();

    public Main(){
        vivero = new Vivero("Vivero", "Dirección");
    }

    public static void main(String[] args){
        Main program = new Main();
        int num_plantas = 10;
        boolean add_frutal = false;

        for(int i = 0; i < num_plantas; i++){
            add_frutal = random.nextBoolean();
            if(add_frutal)
                out.println(vivero.addFrutal(generarString(7), random.nextDouble()*3, generarString(5)));
            else
                out.println(vivero.addOrnamental(generarString(7), random.nextDouble()*2, random.nextInt(10)));
        }

        out.println(vivero.listarOrnamentalesMayoresAUnmetro());
        out.println(vivero.mostrar());
        for(Frutal frutal : vivero.getFrutales())
            out.print( (frutal != null) ? frutal.proximoFlorecimiento(10, 2019, 3, 2020) + "\n" : "");
        out.println(vivero.listarNombresDeFrutos());
    }

    public static String generarString(int max_caracteres){
        char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String string_aleatorio = "";
        for(int j = 0; j <= max_caracteres; j++)
            string_aleatorio += letras[random.nextInt(letras.length)];
        return string_aleatorio;
    }
}