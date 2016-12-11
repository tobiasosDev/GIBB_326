package Service;

import Model.Bomb;
import Model.Player;
import View.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DisplayBombService {

    public void displayBombs(){
        int objectSum = Main.getMazeLayout().getChildren().size();

        for (int i = 1; i < FieldService.getInstance().getBombs().size(); i++) {
            Main.getMazeLayout().getChildren().remove(i);
        }

        FieldService.getInstance().getBombs().stream().forEach(bomb -> {
//            final Boolean[] exists = {false};
//            Main.getMazeLayout().getChildren().stream().forEach( inGamePlayer -> {
//                if(inGamePlayer.equals(getFxUser(player))){
//                    exists[0] = true;
//                    Main.getMazeLayout().getChildren().remove(inGamePlayer);
//                    Main.getMazeLayout().getChildren().add(getFxUser(player));
//                }
//            });
//            if(exists[0] == false) {
//                Main.getMazeLayout().getChildren().add(getFxUser(player));
//            }
             Main.getMazeLayout().getChildren().add(getFxBomb(bomb));

        });

        Main.getPrimaryStage().show();
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
