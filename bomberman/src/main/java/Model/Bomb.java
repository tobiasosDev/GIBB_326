package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Bomb extends GameElement{

    private float explodeTime;
    private int force;

    public Bomb(byte[] graphics, float size,float explodeTime, int force) {
        super(graphics, size);
        this.explodeTime = explodeTime;
        this.force = force;
    }
}
