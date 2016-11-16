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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Field field = new Field();
                field.setContent(Field.Content.WALL);
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
