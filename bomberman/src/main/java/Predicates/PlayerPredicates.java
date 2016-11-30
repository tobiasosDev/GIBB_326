package Predicates;

import Model.Player;

import java.util.function.Predicate;

/**
 * Created by lukas on 30.11.2016.
 */
public class PlayerPredicates{
        public static Predicate<Player> isPlayer(String name) {
            return  p -> p.getName().equals(name);
        }
}
