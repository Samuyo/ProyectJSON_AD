package edu.badpals.valorantapi.Model;

public class Rol {
    private int id_rol;
    private Enum<Roles> nombre_rol;
    private String descrip_rol;

    public Rol(int id_rol, Enum<Roles> nombre_rol, String descrip_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.descrip_rol = descrip_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public Enum<Roles> getNombre_rol() {
        return nombre_rol;
    }

    public String getDescrip_rol() {
        return descrip_rol;
    }
}
