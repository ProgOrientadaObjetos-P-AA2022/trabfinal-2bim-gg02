/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enlaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import trabajofinal.PlanCelular;
import trabajofinal.PlanPostPagoMegas;

/**
 *
 * @author ronni
 */
public class Enlace01 {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/planCelular.bd";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarPlanPostPagoMegas(PlanPostPagoMegas plan) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMegas (nombre,"
                    + "cedula, ciudad, marcaCelular, modeloCelular,"
                    + "numeroCelular, gigas, costoGiga, tarifaBase, pagoMensual ) "
                    + "values ('%s', '%s', '%s', '%s', '%s', '%s', '%.2f'"
                    + ", '%.2f', '%.2f', '%.2f')",
                    plan.obtenerPropietario(),
                    plan.obtenerCedula(),
                    plan.obtenerCiudad(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerGigas(),
                    plan.obtenerCostoGiga(),
                    plan.obtenerTarifaBase(),
                    plan.obtenerPagoMensual());
            System.out.println(data);
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception:");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<PlanCelular> obtenerDataPlanPostPagoMegas() {
        ArrayList<PlanCelular> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMegas plan = new PlanPostPagoMegas(
                        rs.getDouble("gigas"), rs.getDouble("costoGiga"),
                        rs.getDouble("tarifaBase"), rs.getDouble("pagoMensual"),
                         rs.getString("nombre"), rs.getString("cedula"),
                        rs.getString("ciudad"), rs.getString("marcaCelular"),
                         rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"));
                lista.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlan");
            System.out.println(e.getMessage());

        }
        return lista;
    }

}
