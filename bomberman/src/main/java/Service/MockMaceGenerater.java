package Service;

import application.network.protocol.Field;
import application.network.protocol.Maze;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobiasluscher on 16.11.16.
 */
public class MockMaceGenerater {

    public Maze createMockMace(){
        List<Field> fields = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Field field = new Field();
                if(i == 4){
                    field.setContent(Field.Content.WALL);
                }else {
                    field.setContent(Field.Content.EMPTY);
                }
                field.setPositionX(j);
                field.setPositionY(i);
                fields.add(field);
            }
        }
        Maze mockMace = new Maze();
        mockMace.setFields(fields);
        return mockMace;
    }
}
