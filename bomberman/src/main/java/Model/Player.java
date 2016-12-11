package Model;

import Service.FieldService;
import application.network.protocol.Maze;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by lukas on 08.11.2016.
 */
public class Player{

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
        Maze maze = FieldService.getInstance().getMaze();
        List<application.network.protocol.Field> fields = maze.getFields();
        boolean emptyfield = false;
        for (application.network.protocol.Field field: fields) {
            if(field.getContent() == application.network.protocol.Field.Content.EMPTY && field.getPositionX() == x) {
                emptyfield = true;
            }
        }
        if(emptyfield){
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        Maze maze = FieldService.getInstance().getMaze();
        List<application.network.protocol.Field> fields = maze.getFields();
        boolean emptyfield = false;
        for (application.network.protocol.Field field: fields) {
            if(field.getContent() == application.network.protocol.Field.Content.EMPTY && field.getPositionY() == y) {
                emptyfield = true;
            }        }
        if(emptyfield){
            this.y = y;
        }
    }

    public String getName() {
        return name;
    }
}
