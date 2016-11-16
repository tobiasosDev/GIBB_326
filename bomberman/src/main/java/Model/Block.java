package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Block extends GameElement{

    private boolean destructible;


    public Block(byte[] graphics, float size, boolean destructible) {
        super(graphics, size);
        this.destructible = destructible;
    }
}
