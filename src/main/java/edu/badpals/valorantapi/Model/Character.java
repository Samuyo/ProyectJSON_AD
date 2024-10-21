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
        return "Agent{" +
                "uuid='" + uuid + '\'' +
                ", displayName='" + nombre + '\'' +
                ", description='" + descripcion + '\'' +
                ", fullPortrait='" + urlImg + '\'' +
                ", roleName='" + rol + '\'' +
                ", abilityNames=" + abilidades +
                '}';
    }

    /* Recorre el JSON y llena el hashMap "Characters" con el nombre del agente y su id */
    private void agregarPersonajes (String jsonString){
        // Convertir la cadena JSON a un JSONArray
        JSONArray jsonArray = new JSONArray(jsonString);

        // Recorrer el JSONArray y agregar al HashMap solo el ID y el nombre
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String id = jsonObject.getString("uuid");
            String nombre = jsonObject.getString("displayName");
            Characters.put(id, nombre);
        }
    }


    /* Recibe como parámetro un nombre dado por el usuario y el hashmap de "Characters" y te devuelve su respectivo ID */
    private String nameToId (String nombre, HashMap < String, String > personajes) throws Exception {
        for (HashMap.Entry<String, String> entry : personajes.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(nombre)) {
                return entry.getKey(); // Devuelve el ID como String
            }
        }
        throw new Exception("Personaje no encontrado: " + nombre);
    }
}