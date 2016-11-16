package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Gear {
    private boolean aktive;
    private Key[] keys;

    public Gear(boolean aktive, Key[] keys) {
        this.aktive = aktive;
        this.keys = keys;
    }
}
