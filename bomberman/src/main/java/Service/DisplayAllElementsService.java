package Service;

import View.Main;

/**
 * Created by tobiasluscher on 11.12.16.
 */
public class DisplayAllElementsService {

    public void displayAll() {
        int objectSum = Main.getMazeLayout().getChildren().size();

        for (int i = 1; i < FieldService.getInstance().getPlayers().size(); i++) {
            Main.getMazeLayout().getChildren().remove(i);
        }
        DisplayBombService displayBombService = new DisplayBombService();
        DisplayUserService displayUserService = new DisplayUserService();
        displayUserService.displayUsers();
        displayBombService.displayBombs();
        Main.getPrimaryStage().show();
    }
}
