package edu.badpals.valorantapi.Model;

public class Agentes {
    private int id_ag;
    private String nombre_ag;
    private String descrip_ag;
    private int id_rol_ag;

    public Agentes(int id_ag, String nombre_ag, String descrip_ag, int id_rol_ag) {
        this.id_ag = id_ag;
        this.nombre_ag = nombre_ag;
        this.descrip_ag = descrip_ag;
        this.id_rol_ag = id_rol_ag;
    }

    public int getId_ag() {
        return id_ag;
    }

    public String getNombre_ag() {
        return nombre_ag;
    }

    public String getDescrip_ag() {
        return descrip_ag;
    }

    public int getId_rol_ag() {
        return id_rol_ag;
    }
}
