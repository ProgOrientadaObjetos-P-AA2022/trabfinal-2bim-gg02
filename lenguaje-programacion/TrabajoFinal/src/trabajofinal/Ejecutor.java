/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajofinal;

import enlaces.Enlace01;
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
        boolean bandera = true;
        boolean banderin = true;

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
        while (bandera || banderin) {
            System.out.println("[*]Para registar datos de telefonía celular ingrese\n"
                    + "un número que se corresponda con el tipo de plan que desea:\n"
                    + "[1]Plan PostPagoMinutos\n"
                    + "[2]Plan PostPagoMegas\n"
                    + "[3]Plan PostPagoMinutosMegas\n"
                    + "[4]Plan PostPagoMinutosMegasEconómico\n"
                    + "[5]Presentar datos registrados\n"
                    + "[6]Salir del Programa\n"
            );
            String option = a.nextLine();
            switch (option) {
                case "1":
                    plan.add(planPostPagoMinutos(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    break;
                case "2":
                    plan.add(planPostPagoMegas(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    break;
                case "3":
                    plan.add(planPostPagoMinutosMegas(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                case "4":
                    plan.add(planPostPagoMinutosMegasEconomico(nombre, id, ciudad,
                            marca, modelo, numeroCelular));
                    break;
                case "5":
                    break;
                case "6":
                    bandera = false;
                    break;
                default:
                    System.out.println("Ingresar un valor correcto por favor...");
                    break;
            }
            if (plan.isEmpty()) {
                System.out.printf("[*ALERTA*]\nNo ha ingresado ningún plan"
                        + " celular para el"
                        + " cliente %s, con identificación: %s\n"
                        + "¿Desea Continuar?[Si]/[No]", nombre, id);
                String rta = a.nextLine().toLowerCase(Locale.US);
                if (rta.equals("si")) {
                    banderin = false;
                }
            }
        }

    }

    public static PlanPostPagoMinutos planPostPagoMinutos(String nombre,
            String id, String ciudad,
            String marca, String modelo, String numeroCelular) {
        Scanner a = new Scanner(System.in);
        a.useLocale(Locale.US);

        System.out.println("Ingrese el [NÚMERO DE MINUTOS] Nacionales"
                + " Consumidos: ");
        double minutos = a.nextDouble();
        System.out.println("Ingrese el [COSTO DE MINUTOS] consumido"
                + " nacionalmente: ");
        double costoNacional = a.nextDouble();
        System.out.println("Ingrese el [NÚMERO DE MINUTOS] consumidos"
                + " Internacionales: ");
        double minutosInternacionales = a.nextDouble();
        System.out.println("Ingrese el [NÚMERO DE MINUTO] consumido"
                + " Internacionalmente: ");
        double costoInternacional = a.nextDouble();

        PlanPostPagoMinutos plan = new PlanPostPagoMinutos(minutos,
                costoNacional, minutosInternacionales,
                costoInternacional, nombre,
                id, ciudad, marca, modelo, numeroCelular);
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
        return plan;
    }

}
