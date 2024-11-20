package edu.badpals.valorantapi.Model;

public class Habilidad {
    private int id_ag_per;
    private String nombre_hab;
    private String descrip_hab;

    public Habilidad(int id_ag_per, String nombre_hab, String descrip_hab) {
        this.id_ag_per = id_ag_per;
        this.nombre_hab = nombre_hab;
        this.descrip_hab = descrip_hab;
    }

    public int getId_ag_per() {
        return id_ag_per;
    }

    public String getNombre_hab() {
        return nombre_hab;
    }

    public String getDescrip_hab() {
        return descrip_hab;
    }
}
