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
        users.put("11111","11111");
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
}
