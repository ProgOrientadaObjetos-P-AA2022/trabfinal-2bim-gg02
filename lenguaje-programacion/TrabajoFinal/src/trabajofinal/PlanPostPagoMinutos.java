/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author ronni
 */
public class PlanPostPagoMinutos extends PlanCelular {

    private double minutosNacionales;
    private double costoNacional;
    private double minutosInternacionales;
    private double costoInternacional;

    // Constructor Base de Datos
    public PlanPostPagoMinutos(double g, double h, double i, double j, double k,
            String a, String b, String c, String d, String e, String f) {
        super(a, b, c, d, e, f);
        minutosNacionales = g;
        costoNacional = h;
        minutosInternacionales = i;
        costoInternacional = j;
        pagoMensual = k;
    }
// Constructor Main

    public PlanPostPagoMinutos(double g, double h, double i, double j,
            String a, String b, String c, String d, String e, String f) {
        super(a, b, c, d, e, f);
        minutosNacionales = g;
        costoNacional = h;
        minutosInternacionales = i;
        costoInternacional = j;
    }

    public void establecerMinutosNacionales(double a) {
        minutosNacionales = a;
    }

    public void establecerCostoNacional(double a) {
        costoNacional = a;
    }

    public void establecerMinutosInternacionales(double a) {
        minutosInternacionales = a;
    }

    public void establecerCostoInternacional(double a) {
        costoInternacional = a;
    }

    public double obtenerMinutosNacionales() {
        return minutosNacionales;
    }

    public double obtenerCostoNacional() {
        return costoNacional;
    }

    public double obtenerMinutosInternacionales() {
        return minutosInternacionales;
    }

    public double obtenerCostoInternacional() {
        return costoInternacional;
    }

    @Override
    public void establecerPagoMensual() {
        pagoMensual = (costoNacional * minutosNacionales)
                + (minutosInternacionales * costoInternacional);
    }

    @Override
    public String toString() {
        String mensaje = String.format("\t<--PlanPostPagoMinutos-->\n"
                + "%s"
                + "Minutos Nacionales: %.2f\n"
                + "Costo de los minutos Nacionales: %.2f\n"
                + "Minutos Internacionales: %.2f\n"
                + "Costo de los Minutos Internacionales: %.2f\n"
                + "Costo Final: %.2f\n", super.toString(),
                minutosNacionales,
                costoNacional,
                minutosInternacionales,
                costoInternacional, pagoMensual);
        return mensaje;
    }

}
