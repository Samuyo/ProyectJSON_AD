package edu.badpals.valorantapi.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class User {
    HashMap<String,String> users = new HashMap<>();


    private void registerUser(String usuario, String contrasenia){
        if ((usuario.length() >= 5) && (contrasenia.length() >= 5)){
            users.put(usuario,contrasenia);
        } else if (usuario.length() >= 5) {
            System.out.println("La contrseña de usuario es muy corta");
        } else{
            System.out.println("El nombre de usuario es muy corto");
        }
    }

    private void saveUser(){
        users.put("Admin", "Dosp!");
        users.put("Usuario","1234a");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.txt"))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
