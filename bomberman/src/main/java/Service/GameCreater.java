package Service;


import View.Main;
import application.network.protocol.Maze;
import application.network.protocol.StartGame;
import application.network.protocol.UpdateGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class GameCreater {

    public void createMaze(UpdateGame updateGame){
        try {
            createMaze(updateGame.getMaze());
            FieldService.getInstance().setMaze(updateGame.getMaze());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void createMaze(StartGame updateGame){
        try {
            createMaze(updateGame.getMaze());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createMaze(Maze maze) throws IOException, SAXException, ParserConfigurationException {
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
            column.setAttribute("minWidth", "10.0");
            column.setAttribute("prefWidth", "30.0");
            column.setAttribute("hgrow", "SOMETIMES");
            columnConstraints.appendChild(column);
        }

        maze.getFields().stream().forEach(field -> {
            Element jfxButton = docF.createElement("JFXButton");
            jfxButton.setAttribute("mnemonicParsing", "false");
            jfxButton.setAttribute("text", field.getContent().toString());
            jfxButton.setAttribute("GridPane.halignment", "CENTER");
            jfxButton.setAttribute("GridPane.rowIndex", "" + field.getPositionY());
            jfxButton.setAttribute("GridPane.valignment", "CENTER");
            jfxButton.setAttribute("GridPane.columnIndex", "" + field.getPositionX());
            children.appendChild(jfxButton);
        });

        //StringReader strReader = new StringReader(docF.toString());


        try {
            String location = getClass().getResource("../View/Field.fxml").getPath().toString().replaceAll("/Field.fxml", "");
            // send DOM to file
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File(location + "/Test.fxml"));
            Source input = new DOMSource(docF);
            transformer.transform(input, output);
            showMaze();
        } catch (TransformerException te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showMaze() {
        try {
            // Load person overview.

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../View/Test.fxml"));
            BorderPane personOverview = (BorderPane) loader.load();
            Main.setMazeLayout(personOverview);
            Scene scene = new Scene(personOverview, 800, 800);
            Main.getPrimaryStage().setScene(scene);
            Main.getPrimaryStage().show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

