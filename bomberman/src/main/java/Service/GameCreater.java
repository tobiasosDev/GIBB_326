package Service;


import application.network.protocol.Field;
import application.network.protocol.Maze;
import application.network.protocol.StartGame;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameCreater {

    public void createMaze(StartGame startGame) throws IOException, SAXException, ParserConfigurationException {
        Maze maze = startGame.getMaze();
        XMLService xmlService = new XMLService();
        File fXMLField = new File(getClass().getResource("../View/Field.fxml").getFile());
        Document docF = xmlService.convertXMLToDoc(fXMLField);
        Element columnConstraints = (Element) docF.getElementsByTagName("columnConstraints").item(0);
        Element rowConstraints = (Element) docF.getElementsByTagName("rowConstraints").item(0);
        Element children = (Element) docF.getElementsByTagName("children").item(0);

        for (int i = 0; i < Math.sqrt(maze.getFields().size()); i++) {
            Element row = docF.createElement("RowConstraints");
            row.setAttribute("minHeight", "10.0");
            row.setAttribute("prefHeight", "30.0");
            row.setAttribute("vgrow", "SOMETIMES");
            rowConstraints.appendChild(row);
        }

        for (int i = 0; i < Math.sqrt(maze.getFields().size()); i++) {
            Element column = docF.createElement("ColumnConstraints");
            column.setAttribute("minHeight", "10.0");
            column.setAttribute("prefHeight", "30.0");
            column.setAttribute("hgrow", "SOMETIMES");
            columnConstraints.appendChild(column);
        }

        maze.getFields().stream().forEach(field -> {
            Element jfxButton = docF.createElement("JFXButton");
            jfxButton.setAttribute("mnemonicParsing", "false");
            jfxButton.setAttribute("text", "" + field.getContent());
            jfxButton.setAttribute("GridPane.halignment", "CENTER");
            jfxButton.setAttribute("GridPane.rowIndex", "" + field.getPositionY());
            jfxButton.setAttribute("GridPane.valignment", "CENTER");
            jfxButton.setAttribute("GridPane.columnIndex", "" + field.getPositionX());
            columnConstraints.appendChild(jfxButton);
        });

        try {
            String location = getClass().getResource("../View/Field.fxml").getPath().toString();
            // send DOM to file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File(location +"/Test.fxml"));
            Source input = new DOMSource(docF);
            transformer.transform(input, output);

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }

    }
}
