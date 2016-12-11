package Controller;

import Model.Bomb;
import Model.Player;
import Service.DisplayBombService;
import Service.DisplayUserService;
import Service.FieldService;
import Service.GameCreater;
import application.network.api.Message;
import application.network.protocol.*;


/**
 * Created by tobiasluscher on 29.11.16.
 */
public class MessageFactory {

    public void executeMessageMethod(Message message){
        if(message == null){

        }
        if(message instanceof UpdateGame){
            GameCreater creater = new GameCreater();
            creater.createMaze((UpdateGame) message);

        } else if(message instanceof StartGame){
            GameCreater creater = new GameCreater();
            creater.createMaze((StartGame) message);

        } else if(message instanceof PlayerJoined){
            PlayerJoined playerJoined = (PlayerJoined)message;
            DisplayUserService displayUserService = new DisplayUserService();
            Player player = new Player(playerJoined.getPlayerName(), playerJoined.getPositionX(), playerJoined.getPositionY());
            FieldService.getInstance().addPlayer(player);
            displayUserService.displayUsers();

        } else if(message instanceof PlayerMoved){
            //Todo
            //Validation of Movement
            //FieldService.getInstance().getPlayer(((PlayerMoved) message).getPlayerName()).setY();
        } else if(message instanceof BombDropped){
            BombDropped bombDropped = (BombDropped)message;
            DisplayBombService displayBombService = new DisplayBombService();
            Bomb bomb = new Bomb(bombDropped.getId(), bombDropped.getPositionX(), bombDropped.getPositionY());
            FieldService.getInstance().getBombs().add(bomb);
            displayBombService.displayBombs();
        } else if(message instanceof BombExploded){
            BombExploded bombExploded = (BombExploded)message;
            final Bomb[] bomb = {null};
            FieldService.getInstance().getBombs().forEach(bombIn -> {
                if(bombIn.getId() == bombExploded.getId()){
                    bomb[0] = bombIn;
                }
            });
            FieldService.getInstance().getBombs().remove(bomb[0]);
        }
    }
}
