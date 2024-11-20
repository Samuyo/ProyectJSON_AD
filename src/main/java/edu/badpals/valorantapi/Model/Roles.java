package edu.badpals.valorantapi.Model;

public enum Roles {
    Duelista ("Duelista"),
    Iniciador ("Iniciador"),
    Controlador ("Controlador"),
    Centinela ("Centinela");

    private final String nombre_rol;

    Roles(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    /**public static Roles getRol(String nombre_rol) {
         for (Roles rol : Roles.values()) {
             if (rol.getNombre_rol().equals(nombre_rol)) {
             return rol;
         }
         }
            return null;
         }
     **/ // DESCOMENTAR PARA USAR EN EL FUTURO
}
