package Model;

import Service.FieldService;

/**
 * Created by lukas on 08.11.2016.
 */
public enum PlayerFunctions implements PlayerFunctionsImp{

    UP{
        @Override
        public void action() {
            //move up
            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            player.setY(player.getY()-1);
        }
    }, DOWN {
        @Override
        public void action() {
            //move down
            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            player.setY(player.getY()+1);
        }
    }, LEFT {
        @Override
        public void action() {
            //move left
            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            player.setX(player.getX()-1);
        }
    }, RIGHT {
        @Override
        public void action() {
            //move right
            final Player player = FieldService.getInstance().getPlayer(FieldService.getInstance().getPlayerName());
            player.setX(player.getX()+1);
        }
    }, DROPBOMB {
        @Override
        public void action() {
            //drop bomb

        }
    }
}

