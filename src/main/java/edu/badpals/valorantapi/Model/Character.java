package edu.badpals.valorantapi.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Character {

    HashMap<String, String> Characters = new HashMap<>();
    String nombre;
    String uuid;
    String rol;
    String descripcion;
    ArrayList<String> abilidades;
    String urlImg;

    public Character(String uuid, String nombre, String descripcion, String urlImg, String rol, ArrayList<String> abilities) {
        this.nombre = nombre;
        this.uuid = uuid;
        this.rol = rol;
        this.descripcion = descripcion;
        this.abilidades = abilities;
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return uuid + "," + nombre + "," + descripcion + "," + urlImg + "," + rol + "," + abilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public ArrayList<String> getAbilidades() {
        return abilidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImg() {
        return urlImg;
    }
}