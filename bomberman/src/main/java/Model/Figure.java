package Model;

/**
 * Created by lukas on 08.11.2016.
 */
public class Figure extends GameElement{

    private String name;
    private String farbe;
    private PlayerFunctions currentFunction;

    public Figure(byte[] graphics, float size, String name, String farbe, PlayerFunctions currentFunction) {
        super(graphics, size);
        this.name = name;
        this.farbe = farbe;
        this.currentFunction = currentFunction;
    }
}
