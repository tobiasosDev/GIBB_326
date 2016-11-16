package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Player extends Figure{

    private Gear gear;

    public Player(byte[] graphics, float size, String name, String farbe, PlayerFunctions currentFunction, Gear gear) {
        super(graphics, size, name, farbe, currentFunction);
        this.gear = gear;
    }

    public void move (PlayerFunctions direction){

    }

    public void aktion (PlayerFunctions function){

    }

    public void dropBomb(){

    }

    public void joinGame(){

    }

    public void startGame(){

    }
}
