package edu.badpals.valorantapi.Model;


import java.util.ArrayList;

public class Consulta {
    ArrayList<Character> consultas = new ArrayList<>();

    public ArrayList<Character> getConsultas() {
        return consultas;
    }

    public void agregarConsulta(Character character) {
        consultas.add(character);
    }
}



