/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinal;

/**
 *
 * @author ronni
 */
public abstract class PlanCelular {

    protected String propietario;
    protected String cedula;
    protected String ciudad;
    protected String marcaCelular;
    protected String modeloCelular;
    protected String numeroCelular;
    protected double pagoMensual;

    public PlanCelular(String a, String b, String c, String d, String e,
            String f) {
        propietario = a;
        cedula = b;
        ciudad = c;
        marcaCelular = d;
        modeloCelular = e;
        numeroCelular = f;
    }

    public void establecerPropietario(String a) {
        propietario = a;
    }

    public void establecerCedula(String a) {
        cedula = a;
    }

    public void establecerCiudad(String a) {
        ciudad = a;
    }

    public void establecerMarcaCelular(String a) {
        marcaCelular = a;
    }

    public void setModeloCelular(String a) {
        modeloCelular = a;
    }

    public void establecerNumeroCelular(String a) {
        numeroCelular = a;
    }

    public abstract void establecerPagoMensual();

    public String obtenerPropietario() {
        return propietario;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerMarcaCelular() {
        return marcaCelular;
    }

    public String obtenerModeloCelular() {
        return modeloCelular;
    }

    public String obtenerNumeroCelular() {
        return numeroCelular;
    }

    public double obtenerPagoMensual() {
        return pagoMensual;
    }

    @Override
    public String toString() {
        String mensaje = String.format("Propietario: %s\n"
                + "Cédula del propietario: %s\n"
                + "Ciudad del Propietario: %s\n"
                + "Número Celular: %s\n", propietario,
                cedula, ciudad, numeroCelular);
        return mensaje;
    }

}
