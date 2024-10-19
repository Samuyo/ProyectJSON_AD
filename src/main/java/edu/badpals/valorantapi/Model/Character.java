package edu.badpals.valorantapi.Model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class Character {

    HashMap<String, String> Characters = new HashMap<>();

    /* Recorre el JSON y llena el hashMap "Characters" con el nombre del agente y su id */
    private void agregarPersonajes(String jsonString) {
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

    /* Recibe como parámetro un nombre dado por el usuario y devuelve un Array con la información de ese AGENTE */
    private String[] buscarPersonaje(String nombre) {
        String[] ficha = new String[5];
        try {
            // Buscamos el ID del personaje
            String id = nameToId(nombre, Characters);

            // Aquí deberías obtener el jsonObject del personaje usando su ID (esto es solo un ejemplo)
            // Supongamos que tienes un método para obtener el jsonObject del personaje por ID
            JSONObject jsonObject = getJsonObjectById(id);

            // Extrae la información del personaje y guárdala en el array
            ficha[0] = id;
            ficha[1] = jsonObject.getString("displayName");
            ficha[2] = jsonObject.getString("rol"); // Ajusta según los campos reales
            ficha[3] = jsonObject.getString("description");
            ficha[4] = jsonObject.getString("abilities");

        } catch (Exception e) {
            System.out.println("Error al definir variables en Character.buscarPersonaje");
        }
        return ficha;
    }

    /* Recibe como parámetro un nombre dado por el usuario y el hashmap de "Characters" y te devuelve su respectivo ID */
    private String nameToId(String nombre, HashMap<String, String> personajes) throws Exception {
        for (HashMap.Entry<String, String> entry : personajes.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(nombre)) {
                return entry.getKey(); // Devuelve el ID como String
            }
        }
        throw new Exception("Personaje no encontrado: " + nombre);
    }

    // Método ejemplo para obtener un JSONObject del personaje por ID (esto es solo una estructura)
    private JSONObject getJsonObjectById(String id) {
        // Implementa la lógica para obtener el JSONObject del personaje por su ID
        return new JSONObject(); // Reemplaza esto con la lógica real
    }
}
