package Controller;

/**
 * Created by lukas on 09.11.2016.
 */
import Service.GameManager;
import application.network.api.client.ClientIdInUseException;
import application.network.api.client.LobbyFullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

//    public void startGame(){
//
//    }
    @FXML protected void startGame(ActionEvent event) {
        GameManager gameManager = new GameManager();
        try {
            gameManager.startupClient();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LobbyFullException e) {
            e.printStackTrace();
        } catch (ClientIdInUseException e) {
            e.printStackTrace();
        }
    }
}
