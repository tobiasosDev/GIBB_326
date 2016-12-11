package Controller;

import Model.Bomb;
import Model.Player;
import Service.*;
import application.network.api.Message;
import application.network.protocol.*;


/**
 * Created by tobiasluscher on 29.11.16.
 */
public class MessageFactory {

    private DisplayAllElementsService displayAllElementsService = new DisplayAllElementsService();

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
            Player player = new Player(playerJoined.getPlayerName(), playerJoined.getPositionX(), playerJoined.getPositionY());
            FieldService.getInstance().addPlayer(player);
            displayAllElementsService.displayAll();

        } else if(message instanceof PlayerMoved){
            setPositionFromMessage((PlayerMoved) message, FieldService.getInstance().getPlayer(((PlayerMoved) message).getPlayerName()));
            displayAllElementsService.displayAll();
        } else if(message instanceof BombDropped){
            BombDropped bombDropped = (BombDropped)message;
            Bomb bomb = new Bomb(bombDropped.getId(), bombDropped.getPositionX(), bombDropped.getPositionY());
            FieldService.getInstance().getBombs().add(bomb);
            displayAllElementsService.displayAll();
        } else if(message instanceof BombExploded){
            BombExploded bombExploded = (BombExploded)message;
            final Bomb[] bomb = {null};
            FieldService.getInstance().getBombs().forEach(bombIn -> {
                if(bombIn.getId() == bombExploded.getId()){
                    bomb[0] = bombIn;
                }
            });
            FieldService.getInstance().getBombs().remove(bomb[0]);
            displayAllElementsService.displayAll();
        }
    }

    public void setPositionFromMessage(PlayerMoved playerMoved, Player player){
        System.out.println(playerMoved.getDirection());
        if (playerMoved.getDirection() == PlayerMoved.Direction.UP){
            player.setY(player.getY()-1);
        } else if(playerMoved.getDirection() == PlayerMoved.Direction.DOWN){
            player.setY(player.getY()+1);
        } else if(playerMoved.getDirection() == PlayerMoved.Direction.RIGHT){
            player.setY(player.getX()+1);
        } else if(playerMoved.getDirection() == PlayerMoved.Direction.LEFT){
            player.setY(player.getX()-1);
        }
    }

}
