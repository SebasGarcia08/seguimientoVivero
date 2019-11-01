package model;

public class Frutal extends Planta implements Florecimiento{
    String nombre_fruto;
    public static int meses_en_florecer = 8; // meses
    public static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julo","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Frutal(String nombre, double costo, String nombre_fruto) {
        super(nombre, costo);
        this.nombre_fruto = nombre_fruto;
    }

    public Frutal() {
        this.nombre_fruto = "";
    }

    public String proximoFlorecimiento(int mesSiembra, int anioSiembra, int mesActual, int anioActual) {
        // String respuesta = "";
        // int meses_de_diferencia;
        int mes_florecimiento, anio_florecimiento;
        int meses_minimos_para_que_florezca_en_el_mismo_anio = 12 - meses_en_florecer;
        
        if(mesSiembra <= meses_minimos_para_que_florezca_en_el_mismo_anio){
            mes_florecimiento = mesSiembra + 8;
            anio_florecimiento = anioSiembra; 
        } else {
            mes_florecimiento = 8 - (12 - mesSiembra);
            anio_florecimiento = ++anioSiembra;
        }
        return meses[mes_florecimiento-1] + " " + anio_florecimiento;
    }
    
    public String getNombreFruto() {
        return nombre_fruto;
    }
    
    public void setNombreFruto(String nombre_fruto) {
        this.nombre_fruto = nombre_fruto;
    }

    @Override
    public String toString() {
        return "Frutal [nombre_fruto=" + nombre_fruto + "]";
    }
}