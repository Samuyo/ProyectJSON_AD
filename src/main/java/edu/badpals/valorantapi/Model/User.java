package edu.badpals.valorantapi.Model;

public class User {

    //Variables
    private String nombreUsuario;
    private String contraseña;
    private boolean administrador;

    //Constructor
    public User(String nombreUsuario, String contraseña, boolean administrador) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.administrador = administrador;
    }


    //Getters and Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    //To String
    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombreUsuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", administrador=" + administrador +
                '}';
    }
}
