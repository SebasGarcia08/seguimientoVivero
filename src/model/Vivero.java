package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Vivero {
    private String nombre;
    private String direccion;
    private Planta[][] plantas;
    public static int[] not_found = {-1,-1}; // Indexes for an element not found in Plantas matrix
    public static char SECTOR_A = 'A';
    public static char SECTOR_B = 'B';

    public Vivero(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.plantas = new Planta[12][6];
    }

    // Validators: uniquename;
    // Sectores A: 6 primeras filas con plantas frutales, el resto son ornamentales
    public int[] buscarPorNombre(String nombre){
        int[] idx = not_found;
        for(int i = 0; i < plantas.length; i++)
            for(int j = 0; j < plantas[i].length; j++)
                if(plantas[i][j] != null && plantas[i][j].getNombre().equalsIgnoreCase(nombre)){
                    idx[0] = i;
                    idx[1] = j;
                }
            
        return idx;
    }

    public int[] posicionDisponibleEn(char sector){
        int[] idx_available = not_found;
        boolean in_sector_a = sector == SECTOR_A;
        for(int i =  (in_sector_a ? 0 : 6); i < (in_sector_a ? 6 :  12); i++){
            for(int j = 0; j < plantas[i].length; j++){
                if(plantas[i][j] == null){
                    idx_available[0] = i;
                    idx_available[1] = j;
                }
            }
        } 
        return idx_available;
    }

    public String addFrutal(String nombre, double costo, String nombre_fruto){
        String respuesta = "Aniadido exitosamente";
        int[] posicion_disponible = posicionDisponibleEn(SECTOR_A);
        boolean is_idx_available = !Arrays.equals(posicion_disponible, not_found);
        boolean name_exists = !Arrays.equals(buscarPorNombre(nombre), not_found);

        // if(is_idx_available && !name_exists)
            plantas[posicion_disponible[0]][posicion_disponible[1]] = new Frutal(nombre, costo, nombre_fruto);
        // else 
        //     respuesta = (!is_idx_available) ? "Sector "+ SECTOR_A + " ocupado": "Nombre ya existe";
        
        return respuesta;
    }

    public String addOrnamental(String nombre, double costo, double altura){
        String respuesta = "Aniadido exitosamente";
        int[] posicion_disponible = posicionDisponibleEn(SECTOR_B);
        boolean is_idx_available = !Arrays.equals(posicion_disponible, not_found);
        boolean name_exists = !Arrays.equals(buscarPorNombre(nombre), not_found);
        
        // if(is_idx_available && !name_exists)
            plantas[posicion_disponible[0]][posicion_disponible[1]] = new Ornamental(nombre, costo, altura);
        // else
        //     respuesta = (!is_idx_available) ? "Sector " + SECTOR_B + " ocupado": "Nombre ya existe";
        
            return respuesta;
    }

    public String listarOrnamentalesMayoresAUnmetro(){
    String res = "LISTA DE PLANTAS MAYORES A UN METRO: \n";
        for(int i=6; i < 12; i++)
            for(int j = 0; j < plantas[i].length; j++)
                res += (plantas[i][j] != null && ((Ornamental) plantas[i][j]).getAltura() > 1) ? plantas[i][j].getNombre() + "\n" : "";
        
        return res;
    }

    public String listarPorDiferentesNombres(){
        String res = "";
        for(int i=0; i < plantas.length; i++)
            for(int j = 0; j < plantas[i].length; j++)
                if(plantas[i][j] != null)
                    res += plantas[i][j].getNombre() + "\n";
        return res;
    }

    public Planta buscarPlanta(String nombre){
        Planta planta = null;
        int i_idx = buscarPorNombre(nombre)[0];
        int j_idx = buscarPorNombre(nombre)[1];
        return (i_idx == -1 && j_idx == -1) ? null : plantas[i_idx][j_idx];
    }

    public String listarNombresDeFrutos(){
        String res = "";
        ArrayList<String> nombres_de_frutas = new ArrayList();
        for(Frutal frutal : getFrutales())
            if(!nombres_de_frutas.contains(frutal.getNombreFruto()))
                nombres_de_frutas.add(frutal.getNombreFruto());
        
        for(String nombre_fruto : nombres_de_frutas)
            res += nombre_fruto + "\n";
        return res;
    }

    public String mostrar(){
        String res = "";
        for(int i = 0; i < plantas.length; i++)
            for(int j = 0; j < plantas[i].length; j++)
                res += (plantas[i][j] == null) ?  "" : plantas[i][j].toString() +  "\n";

        return res;
    }

    public Frutal[] getFrutales(){
        Frutal[] frutales = new Frutal[(plantas.length - 6) * 6];
        int idx_frutal = 0;
        for(int i = 0; i < plantas.length; i++)
            for(int j = 0; j < plantas[i].length; j++)
                if( plantas[i][j] != null && plantas[i][j] instanceof Frutal)
                    frutales[idx_frutal++] = (Frutal) plantas[i][j];
        
        return frutales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Planta[][] getPlantas() {
        return plantas;
    }

    // public ArrayList<Frutal> getFrutales(){
    //     ArrayList<Frutal> frutales = new ArrayList<Frutal>();
    //     for(int i = 0; i < plantas.length; i++)
    //         for(int j = 0; j < plantas[i].length; j++)
    //             if (plantas[i][j] instanceof Frutal)
    //                 frutales.add(plantas[i][j]);
    //     return frutales;
    // }

    public void setPlantas(Planta[][] plantas) {
        this.plantas = plantas;
    }
}