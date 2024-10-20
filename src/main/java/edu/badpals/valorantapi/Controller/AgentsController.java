package edu.badpals.valorantapi.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

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

    HashMap<String, String> agentes = new HashMap<>();

    private void setAgentes(){
        agentes.put("Gekko","e370fa57-4757-3604-3648-499e1f642d3f");
        agentes.put("Fade","dade69b4-4f5a-8528-247b-219e5a1facd6");
        agentes.put("Breach","5f8d3a7f-467b-97f3-062c-13acf203c006");
        agentes.put("Deadlock","cc8b64c8-4b25-4ff9-6e7f-37b4da43d235");
        agentes.put("Raze","f94c3b30-42be-e959-889c-5aa313dba261");
        agentes.put("Chamber","22697a3d-45bf-8dd7-4fec-84a9e28c69d7");
        agentes.put("KAY/O","601dbbe7-43ce-be57-2a40-4abd24953621");
        agentes.put("Skye","6f2a04ca-43e0-be17-7f36-b3908627744d");
        agentes.put("Cypher","117ed9e3-49f3-6512-3ccf-0cada7e3823b");
        agentes.put("Sova","ded3520f-4264-bfed-162d-b080e2abccf9");
        agentes.put("Killjoy","1e58de9c-4950-5125-93e9-a0aee9f98746");
        agentes.put("Harbor","95b78ed7-4637-86d9-7e41-71ba8c293152");
        agentes.put("Vyse","efba5359-4016-a1e5-7626-b1ae76895940");
        agentes.put("Viper","707eab51-4836-f488-046a-cda6bf494859");
        agentes.put("Phoenix","eb93336a-449b-9c1b-0a54-a891f7921d69");
        agentes.put("Astra","41fb69c1-4189-7b37-f117-bcaf1e96f1bf");
        agentes.put("Brimstone","9f0d8ba9-4140-b941-57d3-a7ad57c6b417");
        agentes.put("Iso", "0e38b510-41a8-5780-5e8f-568b2a4f2d6c");
        agentes.put("Clove","1dbf2edd-4729-0984-3115-daa5eed44993");
        agentes.put("Neon","bb2a4828-46eb-8cd1-e765-15848195d751");
        agentes.put("Yoru","7f94d92c-4234-0a36-9646-3a87eb8b5c89");
        agentes.put("Sage","569fdd95-4d10-43ab-ca70-79becc718b46");
        agentes.put("Reyna","a3bfb853-43b2-7238-a4f1-ad90e9e46bcc");
        agentes.put("Omen","8e253930-4c05-31dd-1b6c-968525494517");
        agentes.put("Jett", "add6443a-41bd-e414-f6ad-e58d267f4e95");
    }

    public void handlebtnReturn(ActionEvent event){
        try {
            // Carga la nueva venta
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/badpals/valorantapi/search.fxml"));
            Parent root = loader.load();

            // Obtiene el stado actual
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            // Muestra la ventana
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
