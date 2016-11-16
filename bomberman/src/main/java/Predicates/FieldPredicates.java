package Predicates;

import org.w3c.dom.Node;

import java.util.function.Predicate;

/**
 * Created by tobiasluscher on 16.11.16.
 */
public class FieldPredicates {

    public static Predicate<Node> isTiles() {
        return p -> p.getNodeName().equals("Tiles");
    }
}
