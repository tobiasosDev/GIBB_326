package Service;

import View.Main;


/**
 * Created by tobiasluscher on 11.12.16.
 */
public class DisplayAllElementsService {

    public void displayAll() {
        int objectSum = Main.getMazeLayout().getChildren().size();

        for (int i = 1; i < objectSum; i++) {
            Main.getMazeLayout().getChildren().remove(Main.getMazeLayout().getChildren().size()-1);
        }

        DisplayUserService displayUserService = new DisplayUserService();
        DisplayBombService displayBombService = new DisplayBombService();
        displayUserService.displayUsers();
        displayBombService.displayBombs();
        //Main.getPrimaryStage().show();
    }
}
