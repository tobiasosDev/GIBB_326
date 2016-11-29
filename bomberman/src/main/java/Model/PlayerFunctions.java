package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public enum PlayerFunctions implements PlayerFunctionsImp{
    UP{
        @Override
        public void action() {
            //move up
            System.out.println("up");


        }
    }, DOWN {
        @Override
        public void action() {
            //move down
            System.out.println("down");
        }
    }, LEFT {
        @Override
        public void action() {
            //move left
            System.out.println("left");
        }
    }, RIGHT {
        @Override
        public void action() {
            //move right
            System.out.println("right");
        }
    }, DROPBOMB {
        @Override
        public void action() {
            //drop bomb
            System.out.println("allahuakbar");
        }
    }
}

