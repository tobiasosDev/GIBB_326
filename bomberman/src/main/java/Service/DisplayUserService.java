package Service;

import Model.Player;
import View.Main;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayUserService {

    public void displayUsers(){
        FieldService.getInstance().getPlayers().stream().forEach(player -> {
             Main.getMazeLayout().getChildren().add(getFxUser(player));
        });
    }

    private Rectangle getFxUser(Player player) {
        Rectangle r = new Rectangle(90, 90);
        r.setFill(Color.web("red", 0.1));
        r.setArcHeight(90);
        r.setArcWidth(90);
        r.relocate((player.getX()*90), (player.getY()*90));
        return r;
    }

}
