package Model;

import Service.FieldService;
import application.network.api.Network;
import application.network.protocol.BombDropped;
import application.network.protocol.PlayerMoved;

import java.util.List;


/**
 * Created by lukas on 08.11.2016.
 */
public enum PlayerFunctions implements PlayerFunctionsImp {

    UP {
        @Override
        public void action() {
            //move up
            //final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            //player.setY(player.getY()-1);
            if(FieldService.getInstance().checkEmptyField(PlayerMoved.Direction.UP)) {
                Network.getClient().send(new PlayerMoved().setDirection(PlayerMoved.Direction.UP).setPlayerName(FieldService.getInstance().getPlayerName()));
//                Network.getClient().send(new PlayerMoved().setDirection(PlayerMoved.Direction.UP).setPlayerName(FieldService.getInstance().getPlayerName()));
            }
        }
    }, DOWN {
        @Override
        public void action() {
            //move down
//            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
//            player.setY(player.getY()+1);
            if (FieldService.getInstance().checkEmptyField(PlayerMoved.Direction.DOWN)) {
                Network.getClient().send(new PlayerMoved().setDirection(PlayerMoved.Direction.DOWN).setPlayerName(FieldService.getInstance().getPlayerName()));
            }
        }
    }, LEFT {
        @Override
        public void action() {
            //move left
//            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
//            player.setX(player.getX()-1);
            if (FieldService.getInstance().checkEmptyField(PlayerMoved.Direction.LEFT)) {
                Network.getClient().send(new PlayerMoved().setDirection(PlayerMoved.Direction.LEFT).setPlayerName(FieldService.getInstance().getPlayerName()));
            }
        }
    }, RIGHT {
        @Override
        public void action() {
            //move right
//            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
//            player.setX(player.getX()+1);
            if (FieldService.getInstance().checkEmptyField(PlayerMoved.Direction.RIGHT)) {
                Network.getClient().send(new PlayerMoved().setDirection(PlayerMoved.Direction.RIGHT).setPlayerName(FieldService.getInstance().getPlayerName()));
            }
        }
    }, DROPBOMB {
        @Override
        public void action() {
            Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            List<Bomb> bombs = FieldService.getInstance().getBombs();
            boolean empty = true;
            for (Bomb bomb : bombs) {
                if (player.getX() == bomb.getX() && player.getY() == bomb.getY()) empty = false;
            }
            if (empty)
                Network.getClient().send(new BombDropped().setId(10).setPositionX(player.getX()).setPositionY(player.getY()));
            //drop bomb

        }
    }
}

