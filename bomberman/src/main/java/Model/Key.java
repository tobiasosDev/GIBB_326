package Model;

import javafx.scene.input.KeyCode;

/**
 * Created by lukas on 08.11.2016.
 */
public class Key {
    private KeyCode key;
    private PlayerFunctions functions;

    public Key(KeyCode key, PlayerFunctions functions) {
        this.key = key;
        this.functions = functions;
    }

    public PlayerFunctions getPlayerFunctions(){
        return this.functions;
    }

    public KeyCode getKey() {
        return key;
    }
}
