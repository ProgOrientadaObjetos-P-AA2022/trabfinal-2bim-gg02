/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author ronni
 */
public class PlanPostPagoMegas extends PlanCelular {

    private double gigas;
    private double costoGiga;
    private double tarifaBase;
    
    // Constructor Base de Datos

    public PlanPostPagoMegas(double gig, double costo, double base,
            double pfinal, String a, String b, String c,
            String d, String e, String f) {
        super(a, b, c, d, e, f);
        gigas = gig;
        costoGiga = costo;
        tarifaBase = base;
        pagoMensual = pfinal;
    }
// Constructor Main
    public PlanPostPagoMegas(double gig, double costo, double base,
            String a, String b, String c, String d, String e, String f) {
        super(a, b, c, d, e, f);
        establecerGigas(gig);
        costoGiga = costo;
        tarifaBase = base;
    }

    public void establecerGigas(double a) {
        gigas = a / 1024;
        gigas = .2f;
    }

    public void establecerCostoGiga(double a) {
        costoGiga = a;
    }

    public void establecerTarifaBase(double a) {
        tarifaBase = a;
    }

    public double obtenerGigas() {
        return gigas;
    }

    public double obtenerCostoGiga() {
        return costoGiga;
    }

    public double obtenerTarifaBase() {
        return tarifaBase;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (gigas * costoGiga) + tarifaBase;
    }

    @Override
    public String toString() {
        String mensaje = String.format("\t<--PlanPostPagoMegas-->\n"
                + "%s\n"
                + "Megas expresado en Gigas: %.2f\n"
                + "Costo por Giga: %.2f\n"
                + "Tarifa Base: %.2f\n"
                + "Total a pagar: %.2f\n", super.toString(), gigas, costoGiga,
                tarifaBase, pagoMensual);
        return mensaje;
    }
}
