package edu.badpals.valorantapi.Model;

import java.sql.*;
import java.util.ArrayList;

public class ConnetBD {
    private final String URLV = "jdbc:mysql://localhost:3306/valorant?";
    private final String URLU = "jdbc:mysql://localhost:3306/usuarios?";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private ArrayList agentes = new ArrayList();
    private ArrayList hab = new ArrayList();
    private ArrayList rol = new ArrayList();
    private ArrayList usuarios = new ArrayList();

    public void ConnetValorant() {
        try (Connection con = DriverManager.getConnection(URLV, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            System.out.println("Conexión exitosa en la base de datos!");

            // Consulta para seleccionar todas las filas de la tabla 'paises'
            String queryAgentes = "SELECT * FROM agentes";
            String queryHabilidades_agentes = "SELECT * FROM Habilidades_agentes";
            String queryRoles = "SELECT * FROM agentes";
            ResultSet resultSetAgentes = stmt.executeQuery(queryRoles);
            ResultSet resultSetHabilidades = stmt.executeQuery(queryHabilidades_agentes);
            ResultSet resultSetRoles = stmt.executeQuery(queryRoles);

            // Procesar resultados
            procesarAgentes(resultSetAgentes);
            procesarHabilidades(resultSetHabilidades);
            procesarRoles(resultSetRoles);


        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        }
    }

    private ArrayList<Agentes> procesarAgentes(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id_ag = resultSet.getInt("id_ag");
            String nombre_ag = resultSet.getString("nombre_ag");
            String descrip_ag = resultSet.getString("descrip_ag");
            int id_rol_ag = resultSet.getInt("id_rol_ag");

            // Crear un objeto Agente y agregarlo a la lista
            Agentes agente = new Agentes(id_ag, nombre_ag, descrip_ag, id_rol_ag);
            agentes.add(agente);
        }
        return agentes;
    }

    private ArrayList<Habilidad> procesarHabilidades(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id_ag_per = resultSet.getInt("id_ag_per");
            String nombre_hab = resultSet.getString("nombre_hab");
            String descrip_hab = resultSet.getString("descrip_hab");

            // Crear un objeto Habilidad y agregarlo a la lista
            Habilidad habilidad = new Habilidad(id_ag_per, nombre_hab, descrip_hab);
            hab.add(habilidad);
        }
        return hab;
    }

    private ArrayList<Rol> procesarRoles(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id_rol = resultSet.getInt("id_rol");
            String nombreRolString = resultSet.getString("nombre_rol");
            Roles nombreRol = Roles.getRol(nombreRolString.toUpperCase());
            String descrip_rol = resultSet.getString("descrip_rol");

            // Crear un objeto Rol y agregarlo a la lista
            Rol rol1 = new Rol(id_rol, nombreRol,  descrip_rol);
            rol.add(rol1);
        }
        return rol;
    }

    public void ConnetUsuario() {
        try (Connection con = DriverManager.getConnection(URLU, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            System.out.println("Conexión exitosa en la base de datos!");

            // Consulta para seleccionar todas las filas de la tabla 'paises'
            String query = "SELECT * FROM ususario";
            ResultSet resultSet = stmt.executeQuery(query);

            // Procesar resultados
            procesarUsuarios(resultSet);

        } catch (SQLException e) {
            System.err.println("Error de establecimiento de conexión: " + e.getMessage());
        };
    }

    private ArrayList<User> procesarUsuarios(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String nombre_usuario = resultSet.getString("nombre");
            String contraseña = resultSet.getString("contraseña");
            Boolean administrador = resultSet.getBoolean("Administrador");

            // Crear un objeto Usuario y agregarlo a la lista
            User usuario = new User(nombre_usuario, contraseña, administrador);
            usuarios.add(usuario);
        }
        return usuarios;
    }
}
