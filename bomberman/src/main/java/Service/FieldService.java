package Service;

import Model.*;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

/**
 * Created by lukas on 16.11.2016.
 */
public class FieldService {

    private static  FieldService fieldService = new FieldService();

    private Field field;
    private Gear gear;
    private GameMode gameMode;

    private FieldService() {
        ArrayList<Key> keys = new ArrayList<>();
        keys.add( new Key(KeyCode.W, PlayerFunctions.UP));
        keys.add( new Key(KeyCode.S, PlayerFunctions.DOWN));
        keys.add( new Key(KeyCode.D, PlayerFunctions.RIGHT));
        keys.add( new Key(KeyCode.A, PlayerFunctions.LEFT));
        keys.add( new Key(KeyCode.SHIFT, PlayerFunctions.DROPBOMB));


        this.gear = new Gear(true, keys);

        this.gameMode = new GameMode(60000, 3);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public static FieldService getInstance(){
        return fieldService;
    }
}
