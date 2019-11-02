package ui;

import model.*;
import java.util.*;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.ZoneId;

public class Main{
    private static Vivero vivero;
    public static Random random = new Random();

    public Main(){
        vivero = new Vivero("Vivero", "Dirección");
    }

    public static void main(String[] args){
        Main program = new Main();
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int num_plantas_aleatorias = 5;
        boolean add_frutal = false;

        out.println("#################################### COMPROBACION REQUERIMIENTO 1 (ANIADIR PLANTA) ####################################");
        for(int i = 0; i < num_plantas_aleatorias; i++){
            add_frutal = random.nextBoolean();
            if(add_frutal)
                out.println(vivero.addFrutal(generarString(2), (random.nextDouble()*100), generarString(3)));
            else
                out.println(vivero.addOrnamental(generarString(2), (random.nextDouble()*100), random.nextDouble()*10));
        }

        out.println("#################################### COMPROBACION REQUERIMIENTO 2 (CALCULAR FLORECIMIENTO) ####################################");
        int mesSiembra, anioSiembra;
        for(Frutal frutal : vivero.getFrutales()){ 
            if(frutal != null){
                mesSiembra = random.nextInt(12 + 1 - 1) + 1;
                anioSiembra = random.nextInt(2019 + 1 - 2000) + 2000;
                out.print("Si se siembra en el " + Frutal.meses[mesSiembra-1] + " de " + anioSiembra);
                out.print( ", florecera en " + frutal.proximoFlorecimiento(mesSiembra, anioSiembra, month, year) + "\n");
            }
        }

        out.println("\n#################################### COMPROBACION REQUERIMIENTO 3 (Buscar planta por nombre) ####################################");
        out.println("Planta aniadida manualmente: " + vivero.addFrutal("Test", 20, "mismo_nombre"));
        out.println("Misma planta con mismo nombre de fruto agregada manualmente: " + vivero.addFrutal("Test1", 20, "mismo_nombre"));
        out.println("\nResultado de buscar planta aniadida manualmente: " + vivero.buscarPlanta("Test").toString()+ "\n");

        out.println("#################################### COMPROBACION REQUERIMIENTO 4 (mostrar ornamentales mayores a un metro) ####################################");
        out.println(vivero.listarOrnamentalesMayoresAUnmetro());
        
        out.println("#################################### COMPROBACION REQUERIMIENTO 5 (mostrar todas las plantas agregadas) ####################################");
        out.println(vivero.mostrar());
        
        out.println("#################################### COMPROBACION REQUERIMIENTO 6 (listar nombres unicos de frutos) #################################");
        out.println(vivero.listarNombresDeFrutos());
        out.println("\nPlantas agregadas aleatoriamente: " + num_plantas_aleatorias + "\nPlantas ornamentales creadas: " + Ornamental.getNumberOfObjs() + "\nPlantas frutales creadas: " + Frutal.getNumberOfObjs());
    }

    public static String generarString(int max_caracteres){
        char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String string_aleatorio = "";
        for(int j = 0; j < max_caracteres; j++)
            string_aleatorio += letras[random.nextInt(letras.length)];
        
        return string_aleatorio;
    }
}