package edu.badpals.valorantapi.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class User {
    HashMap<String,String> users = new HashMap<>();

    private void admiUsers() {
        users.put("Admin", "Dosp!");
        users.put("Usuario","1234a");
    }

    private void registerUser(String usuario, String contraseña){
        if ((usuario.length() >= 5) && (contraseña.length() >= 5)){
            users.put(usuario,contraseña);
        } else if (usuario.length() >= 5) {
            System.out.println("La contrseña de usuario es muy corta");
        } else{
            System.out.println("El nombre de usuario es muy corto");
        }
    }

    public void saveUser(){
        admiUsers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/BD/users.txt"))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newUser(String usuario, String contraseña){
        users.put(usuario,encriptedPassword(contraseña));
        saveUser();
    }

    public String encriptedPassword(String password){
        try {
            // Crear un objeto MessageDigest con el algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Calcular el hash de la contraseña
            byte[] hash = digest.digest(password.getBytes());

            // Convertir el hash a una representación hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString(); // Retornar la contraseña encriptada
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error en el algoritmo de encriptación", e);
        }
    }
}
