package Model;

import Predicates.KeyPredicates;
import javafx.scene.input.KeyCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by lukas on 08.11.2016.
 */
public class Gear {
    private boolean aktive;
    private ArrayList<Key> keys;

    public Gear(boolean aktive, ArrayList<Key> keys) {
        this.aktive = aktive;
        this.keys = keys;
    }

    public void triggerAction(KeyCode key){
        if(aktive){
            keys.stream().filter(KeyPredicates.isKey(key)).findFirst().get().getPlayerFunctions().action();
        }
    }
}
