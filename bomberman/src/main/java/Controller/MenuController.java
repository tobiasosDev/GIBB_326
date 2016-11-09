package Controller;

/**
 * Created by lukas on 09.11.2016.
 */
import Service.GameCreater;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MenuController {

//    public void startGame(){
//
//    }
    @FXML protected void startGame(ActionEvent event) {
        GameCreater gameCreater = new GameCreater();
        try {
            gameCreater.createMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
