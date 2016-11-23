package Controller;

import Service.FieldService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

/**
 * Created by lukas on 23.11.2016.
 */
public class GameConroller {
    @FXML
    protected void KeyInputs(KeyEvent event) {
        FieldService.getInstance().getGear().triggerAction(event.getCode());
    }
}
