/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author ronni
 */
public class PlanPostPagoMinutosMegasEconomico extends PlanCelular{
    private double minutos; 
    private double costoMinutos; 
    private double gigas; 
    private double costoGigas; 
    private double porcentajeDescuento;

    public PlanPostPagoMinutosMegasEconomico(double g, double h, double i
            , double j, double k, String a, String b
            , String c, String d, String e, String f) {
        super(a, b, c, d, e, f);
        minutos = g;
        costoMinutos = h;
        gigas = i;
        costoGigas = j;
        porcentajeDescuento = k;
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

    public void establecerCostoGigas(double a) {
        costoGigas = a;
    }

    public void establecerPorcentajeDescuento(double a) {
        porcentajeDescuento = a;
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

    public double obtenerCostoGigas() {
        return costoGigas;
    }

    public double obtenerPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    
    
    
    

    @Override
    public void establecerPagoMensual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String mensaje = String.format("Minutos: %.2f\n"
                + "Costo por minuto: %.2f\n"
                + "Megas expresado en Gigas: %.2f\n"
                + "Costo por Giga: %.2f\n"
                + "Porcentaje de Descuento: %.2f\n"
                + "Total a pagar: %.2f",minutos, costoMinutos, gigas
                , costoGigas, porcentajeDescuento, pagoMensual);
        return mensaje; 
    }
}
