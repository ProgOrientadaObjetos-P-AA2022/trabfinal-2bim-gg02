/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author ronni
 */
public class PlanPostPagoMinutosMegas extends PlanCelular{
    private double minutos; 
    private double costoMinutos; 
    private double gigas;
    private double costoGiga;

    public PlanPostPagoMinutosMegas(double g, double h, double i, double j
            , String a, String b, String c, String d, String e, String f) {
        super(a, b, c, d, e, f);
        minutos = g;
        costoMinutos = h;
        gigas = i;
        costoGiga = j;
    }

    

    public void establecerMinutos(double a) {
        minutos = a;
    }

    public void establecerCostoMinutos(double a) {
        costoMinutos = a;
    }

    public void establecerGigas(double a) {
        gigas = a;
    }

    public void establecerCostoGiga(double a) {
        costoGiga = a;
    }

    public double obtenerMinutos() {
        return minutos;
    }

    public double obtenerCostoMinutos() {
        return costoMinutos;
    }

    public double obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    @Override
    public String toString() {
        String mensaje = String.format("Minutos: %.2f\n"
                + "Costo de los minutos: %.2f\n"
                + "Megas Expresadas en Gigas: %.2f\n"
                + "Costo por Giga: %.2f\n"
                + "Total a pagar: %.2f", minutos, costoMinutos, gigas
                , costoGiga, pagoMensual);
        return mensaje;
    }
    
    
    
    
    

    @Override
    public void establecerPagoMensual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
