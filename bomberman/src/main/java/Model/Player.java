package Model;

import Service.FieldService;
import application.network.protocol.Maze;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by lukas on 08.11.2016.
 */
public class Player {

    private String name;
    private int x;
    private int y;

    public Player(String name, int x, int y) {
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

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }



    public String getName() {
        return name;
    }
}
