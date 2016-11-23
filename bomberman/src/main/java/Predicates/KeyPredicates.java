package Predicates;

import Model.Key;
import javafx.scene.input.KeyCode;
import org.w3c.dom.Node;

import java.util.function.Predicate;

/**
 * Created by lukas on 23.11.2016.
 */
public class KeyPredicates {

    public static Predicate<Key> isKey(KeyCode keyCode) {
        return  p -> p.getKey().equals(keyCode);
    }

}
