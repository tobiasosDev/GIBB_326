package Service;

import Model.*;

/**
 * Created by lukas on 16.11.2016.
 */
public class FieldService {

    private static  FieldService fieldService = new FieldService();

    private Field field;
    private Gear gear;
    private GameMode gameMode;

    private FieldService() {

        Key up = new Key('w', PlayerFunctions.UP);
        Key down = new Key('s', PlayerFunctions.DOWN);
        Key right = new Key('d', PlayerFunctions.RIGHT);
        Key left = new Key('a', PlayerFunctions.LEFT);
        Key drop = new Key(' ', PlayerFunctions.DROPBOMB);
        Key[] keys = {up, down, right, left, drop};

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

    public FieldService getInstance(){
        return fieldService;
    }
}
