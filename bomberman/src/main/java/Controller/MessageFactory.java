package Controller;

import Model.Player;
import Service.DisplayUserService;
import Service.FieldService;
import Service.GameCreater;
import application.network.api.Message;
import application.network.protocol.PlayerJoined;
import application.network.protocol.PlayerMoved;
import application.network.protocol.StartGame;
import application.network.protocol.UpdateGame;


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

        }
    }
}
