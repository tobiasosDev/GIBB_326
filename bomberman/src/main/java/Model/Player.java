package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Player extends GameElement{

    private String name;
    private int x;
    private int y;

    public Player(byte[] graphics, float size, String name, int x, int y) {
        super(graphics, size);
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }
}
