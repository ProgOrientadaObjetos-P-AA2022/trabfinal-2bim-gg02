/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinal;

import enlaces.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author ronni
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);
        ArrayList<PlanCelular> plan = new ArrayList<>();
        ArrayList <ArrayList> planRemasterizado = new ArrayList<>();
        boolean bandera = true;
        String mensaje = "";

        //---------------------Inicio de Solución---------------------
        System.out.println("\t<--PLANES DE TELEFONÍA CELULAR-->");
        System.out.println("Bienvenidos a registro de datos de telefonía "
                + "celular\nPor favor ingrese los datos del cliente: ");
        System.out.println("Nombre del Cliente: ");
        String nombre = a.nextLine();
        System.out.println("Cédula del cliente: ");
        String id = a.nextLine();
        System.out.println("Ciudad del cliente: ");
        String ciudad = a.nextLine();
        System.out.println("Marca del Celular: ");
        String marca = a.nextLine();
        System.out.println("Modelo del Celular: ");
        String modelo = a.nextLine();
        System.out.println("Número Celular: ");
        String numeroCelular = a.nextLine();
        while (bandera) {
            System.out.println("[*]Para registar datos de telefonía celular ingrese\n"
                    + "un número que se corresponda con el tipo de plan que desea:\n"
                    + "[1]Plan PostPagoMinutos\n"
                    + "[2]Plan PostPagoMegas\n"
                    + "[3]Plan PostPagoMinutosMegas\n"
                    + "[4]Plan PostPagoMinutosMegasEconómico\n"
                    + "[5]Cambiar Datos Cliente\n"
                    + "[6]Presentar datos registrados\n"
                    + "[7]Salir del Programa\n"
            );
            String option = a.nextLine();
            switch (option) {
                case "1":
                    plan.add(planPostPagoMinutos(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    Enlace00 c1 = new Enlace00();
                    // plan.get(0).toString();
                    planRemasterizado.add(c1.obtenerDataPlanPostPagoMinutos());
                    break;
                case "2":
                    plan.add(planPostPagoMegas(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    Enlace01 c2 = new Enlace01();
                    planRemasterizado.add(c2.obtenerDataPlanPostPagoMegas());

                    break;
                case "3":
                    plan.add(planPostPagoMinutosMegas(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    Enlace02 c3 = new Enlace02();
                    planRemasterizado.add(c3.obtenerDataPlanPostPagoMinutosMegas());
                    break;
                case "4":
                    plan.add(planPostPagoMinutosMegasEconomico(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    Enlace03 c4 = new Enlace03();
                    planRemasterizado.add(
                            c4.obtenerDataPlanPostPagoMinutosMegasEconomico());
                    break;
                case "5":
                    System.out.println("Nombre del Cliente: ");
                    nombre = a.nextLine();
                    System.out.println("Cédula del cliente: ");
                    id = a.nextLine();
                    System.out.println("Ciudad del cliente: ");
                    ciudad = a.nextLine();
                    System.out.println("Marca del Celular: ");
                    marca = a.nextLine();
                    System.out.println("Modelo del Celular: ");
                    modelo = a.nextLine();
                    System.out.println("Número Celular: ");
                    numeroCelular = a.nextLine();

                    break;
                case "6":
                    String data = "";

                    for (int i = 0; i < planRemasterizado.size(); i++) {
                        for (int j = 0; j < planRemasterizado.get(i).size(); j++) {
                            data = String.format("%s%s\n", data,
                                    planRemasterizado.get(i).get(j));
                        }
                    }
                    System.out.println(data);

                    break;
                case "7":
                    bandera = false;
                    if (plan.isEmpty()) {
                        System.out.printf("[*ALERTA*]\nNo ha ingresado ningún plan"
                                + " celular para el"
                                + " cliente %s, con identificación: %s\n"
                                + "¿Desea Continuar de todos Modos?[Si]/[No]",
                                nombre, id);
                        String rta = a.nextLine().toLowerCase(Locale.US);
                        if (rta.equals("si")) {
                            bandera = false;
                        } else {
                            bandera = true;
                        }
                    }
                    break;
                default:
                    System.out.println("Ingresar un valor correcto por favor...");
                    break;
            }

        }
        if (!plan.isEmpty()) {
            mensaje = String.format("    +-----------------------+\n"
                    + "    |FACTURA PLAN TELEFÓNICO|\n    "
                    + "+-----------------------+\n");

            for (int i = 0; i < planRemasterizado.size(); i++) {
                for (int j = 0; j < planRemasterizado.get(i).size(); j++) {
                    mensaje = String.format("%s%s\n", mensaje,
                            planRemasterizado.get(i).get(j));

                }

            }

            System.out.println(mensaje);

        }
        System.out.println("    +---------------------------------+\n"
                + "    |GRACIAS POR USAR NUESTRO PROGRAMA|\n    "
                + "+---------------------------------+\n");

    }

    public static PlanPostPagoMinutos planPostPagoMinutos(String nombre,
            String id, String ciudad,
            String marca, String modelo, String numeroCelular) {
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);

        System.out.println("Ingrese el [NÚMERO DE MINUTOS] Nacionales"
                + " Consumidos: ");
        double minutos = a.nextDouble();
        System.out.println("Ingrese el [COSTO DE MINUTOS] consumidos"
                + " nacionalmente: ");
        double costoNacional = a.nextDouble();
        System.out.println("Ingrese el [NÚMERO DE MINUTOS] consumidos"
                + " Internacionales: ");
        double minutosInternacionales = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR MINUTO] consumido"
                + " Internacionalmente: ");
        double costoInternacional = a.nextDouble();

        PlanPostPagoMinutos plan = new PlanPostPagoMinutos(minutos,
                costoNacional, minutosInternacionales,
                costoInternacional, nombre,
                id, ciudad, marca, modelo, numeroCelular);

        plan.establecerPagoMensual();
        Enlace00 c = new Enlace00();
        c.insertarPlanPostPagoMinutos(plan);
        return plan;

    }

    public static PlanPostPagoMegas planPostPagoMegas(String nombre,
            String id, String ciudad,
            String marca, String modelo, String numeroCelular) {
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);

        System.out.println("Ingrese el [NÚMERO DE MEGAS] consumidas: ");
        double megas = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR GIGA] consumida: ");
        double costoGiga = a.nextDouble();
        System.out.println("Ingrese la [TARIFA BASE] del plan: ");
        double tarifaBase = a.nextDouble();
        PlanPostPagoMegas plan = new PlanPostPagoMegas(megas, costoGiga,
                tarifaBase,
                nombre, id, ciudad,
                marca, modelo, numeroCelular);
        plan.establecerPagoMensual();
        Enlace01 c = new Enlace01();
        c.insertarPlanPostPagoMegas(plan);
        return plan;

    }

    public static PlanPostPagoMinutosMegas planPostPagoMinutosMegas(String nombre,
            String id, String ciudad,
            String marca, String modelo, String numeroCelular) {
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);

        System.out.println("Ingrese el [NÚMERO DE MINUTOS] consumidos: ");
        double numeroMinutos = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR MINUTO] consumidos: ");
        double costoMinutos = a.nextDouble();
        System.out.println("Ingrese el [NÚMERO DE MEGAS] consumidos: ");
        double numeroMegas = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR GIGA] consumidos: ");
        double costoGiga = a.nextDouble();
        PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(
                numeroMinutos, costoMinutos, numeroMegas,
                costoGiga, nombre, id, ciudad,
                marca, modelo, numeroCelular);

        plan.establecerPagoMensual();
        Enlace02 c = new Enlace02();
        c.insertarPlanPostPagoMinutosMegas(plan);
        return plan;
    }

    public static PlanPostPagoMinutosMegasEconomico
            planPostPagoMinutosMegasEconomico(String nombre,
                    String id, String ciudad,
                    String marca, String modelo, String numeroCelular) {
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);

        System.out.println("Ingrese el [NÚMERO DE MINUTOS] consumidos: ");
        double numeroMinutos = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR MINUTO] consumido: ");
        double costoMinutos = a.nextDouble();
        System.out.println("Ingrese el [NÚMERO DE MEGAS] consumidos: ");
        double numeroMegas = a.nextDouble();
        System.out.println("Ingrese el [COSTO POR GIGA] consumidos: ");
        double costoGiga = a.nextDouble();
        System.out.println("Ingrese el [PORCENTAJE DE DESCUENTO]: ");
        double porcentaje = a.nextDouble();
        PlanPostPagoMinutosMegasEconomico plan
                = new PlanPostPagoMinutosMegasEconomico(numeroMinutos,
                        costoMinutos, numeroMegas,
                        costoGiga, porcentaje, nombre, id, ciudad,
                        marca, modelo, numeroCelular);

        plan.establecerPagoMensual();
        Enlace03 c = new Enlace03();
        c.insertarPlanPostPagoMinutosMegasEconomico(plan);
        return plan;
    }

}
