package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class AgentsController {

    private String finalURL = "https://valorant-api.com/v1/agents";

    @FXML
    public Label nomeAge;
    @FXML
    public Label lblAbil4Ag;
    @FXML
    public Label lblAbil3Ag;
    @FXML
    public Label lblAbil1Ag;
    @FXML
    public Label lblAbil2Ag;
    @FXML
    public Label lblDescAg;
    @FXML
    public Label lblRolAg;
    @FXML
    public Button btnReturn;

    ArrayList<Character> agentes = new ArrayList<>();

    public void handlebtnReturn(ActionEvent event) {
        try {
            // Carga la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/search.fxml"));
            Parent root = loader.load();
            // Obtiene el estado actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            // Muestra la ventana
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getAgentesJSON() {
        String jsonResponse = accesoAPI();
        if (jsonResponse != null) {
            agentes = procesarRespuesta(jsonResponse);
            System.out.println(agentes);
        }
    }

    private String accesoAPI() {
        StringBuilder response = new StringBuilder();
        try {
            URL obj = new URL(finalURL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // Comprueba si la respuesta es correcta
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.err.println("Error en la conexión: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return response.toString();
    }

    private ArrayList<Character> procesarRespuesta(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray agentsArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < agentsArray.length(); i++) {
            JSONObject agent = agentsArray.getJSONObject(i);
            String uuid = agent.getString("uuid");
            String displayName = agent.getString("displayName");
            String description = agent.getString("description");
            String fullPortrait = agent.get("fullPortrait").toString();
            String roleName = "No role";  // Valor por defecto
            if (agent.has("role") && !agent.isNull("role")) {
                JSONObject role = agent.getJSONObject("role");
                roleName = role.getString("displayName");
            }
            JSONArray abilitiesArray = agent.getJSONArray("abilities");
            ArrayList<String> abilityNames = new ArrayList<>();
            for (int j = 0; j < abilitiesArray.length(); j++) {
                JSONObject ability = abilitiesArray.getJSONObject(j);
                abilityNames.add(ability.getString("displayName"));
            }
            Character character = new Character(uuid, displayName, description, fullPortrait, roleName, abilityNames);
            agentes.add(character);
        }
        return agentes;
    }

    @FXML
    private void setNomeAge(String nome) {
        nomeAge.setText("" + nome);
    }

    @FXML
    private void lblDescAg(String nome) {
        lblDescAg.setText(nome);
    }

    @FXML
    private void lblRolAg(String rol) {
        lblRolAg.setText(rol);
    }

    @FXML
    private void lblAbil1Ag(String Abil1) {
        lblAbil1Ag.setText(Abil1);
    }

    @FXML
    private void lblAbil2Ag(String Abil2) {
        lblAbil2Ag.setText(Abil2);
    }

    @FXML
    private void lblAbil3Ag(String Abil3) {
        lblAbil3Ag.setText(Abil3);
    }

    @FXML
    private void lblAbil4Ag(String Abil4) {
        lblAbil4Ag.setText(Abil4);
    }

    public void setAgentes(Character character) {
        setNomeAge(character.getNombre());
        lblDescAg((character.getDescripcion()));
        lblRolAg(character.getRol());
        lblAbil1Ag(character.getAbilidades().get(0));
        lblAbil2Ag(character.getAbilidades().get(1));
        lblAbil3Ag(character.getAbilidades().get(2));
        lblAbil4Ag(character.getAbilidades().get(3));
    }

    public ArrayList<Character> getAgentes() {
        getAgentesJSON();
        guardarJSON();
        return agentes;
    }

    private void guardarJSON() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/BD/json.txt"))) {

            for (Character character : agentes) {
                writer.write(character.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}