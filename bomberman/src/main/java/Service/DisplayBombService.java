package Service;

import Model.Bomb;
import Model.Player;
import View.Main;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayBombService {

    public void displayBombs(){
        FieldService.getInstance().getBombs().stream().forEach(bomb -> {
            Main.getMazeLayout().getChildren().add(getFxBomb(bomb));
        });
    }

    private Rectangle getFxBomb(Bomb bomb) {
        Rectangle r = new Rectangle(90, 90);
        r.setFill(Color.web("green", 0.1));
        r.setArcHeight(90);
        r.setArcWidth(90);
        r.relocate((bomb.getX()*90), (bomb.getY()*90));
        return r;
    }

}
