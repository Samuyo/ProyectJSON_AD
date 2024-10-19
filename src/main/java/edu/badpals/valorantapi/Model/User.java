package edu.badpals.valorantapi.Model;

import java.util.HashMap;

public class User {
    HashMap<String,String> users = new HashMap<>();
    private void User(){
        users.put("Admin", "Dosp!");
        users.put("Usuario","1234a");
    }

    private void registerUser(String usuario, String contrasenia){
        if ((usuario.length() >= 5) && (contrasenia.length() >= 5)){
            users.put(usuario,contrasenia);
        } else if (usuario.length() >= 5) {
            System.out.println("La contrseña de usuario es muy corta");
        } else{
            System.out.println("El nombre de usuario es muy corto");
        }
    }
}
