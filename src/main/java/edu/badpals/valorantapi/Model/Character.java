package edu.badpals.valorantapi.Model;

import java.util.HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class Character {
     HashMap<String, String> Characters = new HashMap<>();
     
     
     
     
     
     
     
     
     /*
     Recorre el JSON y llena el hashMap "Characters" con el nombre del agente y su id
     */
    private void agregarPersonajes(String urlString, HashMap<String, String> Characters) {
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
      
    
    /*
    Recibe como parametro un nombre dado por el usuario y devuelve un Array con la información de ese AGENTE
    */
    private String[] buscarPersonaje (String nombre) {
         String[] ficha = new String[5];
         try {
         String name = nameToId(nombre,Characters);
         String rol = jsonObject.getString("uuid");
         } catch (Exception e) {
            System.out.println("Error al definir variables en Character.buscarPersonaje");
        }
        return ficha;
    }
    
    /*
    Recibe como parametro un nombre dado por el usuario y el hashmap de "Characters" y te
    devuelve su respectivo id
    */
    private String nameToId(String nombre, HashMap<String, String> personajes) throws Exception {
    for (HashMap.Entry<String, String> entry : personajes.entrySet()) {
        if (entry.getValue().equalsIgnoreCase(nombre)) {
            return entry.getKey(); // Devuelve el ID como String
        }
    }
    throw new Exception("Personaje no encontrado: " + nombre);
}
}
