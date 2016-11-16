package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Field {

    private static Field instance = null;

    protected Field() {
        // Exists only to defeat instantiation.
    }

    private GameElement[] gameElements;
    private int size;

    public void draw(){

    }

    public static Field getInstance() {
        if(instance == null) {
            instance = new Field();
        }
        return instance;
    }
}
