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
        int objectSum = Main.getMazeLayout().getChildren().size();

        for (int i = 1; i < FieldService.getInstance().getPlayers().size(); i++) {
            Main.getMazeLayout().getChildren().remove(i);
        }

        FieldService.getInstance().getPlayers().stream().forEach(player -> {
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
             Main.getMazeLayout().getChildren().add(getFxUser(player));

        });

        Main.getPrimaryStage().show();
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
