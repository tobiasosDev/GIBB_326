package Service;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

/**
 * Created by tobiasluscher on 07.11.16.
 */
public class GameCreater {

    private XMLService xmlService;

    public void createMap(){
        File fieldXML = new File(getClass().getResource("testField.xml").getFile());
        File fXMLField = new File(getClass().getResource("View/Field.fxml").getFile());
        Document doc = xmlService.convertXMLToDoc(fieldXML);
        Document docF = xmlService.convertXMLToDoc(fXMLField);

        Element metaData = (Element) doc.getElementsByTagName("Meta-Daten").item(0);
        Element labyrinthData = (Element) doc.getElementsByTagName("Labyrinth-Daten").item(0);
        Element columnConstraints = (Element) doc.getElementsByTagName("columnConstraints").item(0);
        Element rowConstraints = (Element) doc.getElementsByTagName("rowConstraints").item(0);
        Element children = (Element) doc.getElementsByTagName("children").item(0);
        NodeList labRows = labyrinthData.getChildNodes();

        int breite = Integer.parseInt(metaData.getChildNodes().item(0).getNodeValue());
        int groesse = Integer.parseInt(metaData.getChildNodes().item(1).getNodeValue());
        String name = metaData.getChildNodes().item(2).getNodeValue();

        for(int i = 0; i < groesse; i++){
            Element row = docF.createElement("RowConstraints");
            row.setAttribute("minHeight", "10.0");
            row.setAttribute("prefHeight", "30.0");
            row.setAttribute("vgrow", "SOMETIMES");
            rowConstraints.appendChild(row);
        }

        for (int i = 0; i < breite; i++) {
            Element column = docF.createElement("ColumnConstraints");
            column.setAttribute("minHeight", "10.0");
            column.setAttribute("prefHeight", "30.0");
            column.setAttribute("hgrow", "SOMETIMES");
            columnConstraints.appendChild(column);
        }

        for (int i = 0; i < labRows.getLength(); i++) {
            NodeList labColumns = labRows.item(i).getChildNodes();
            for (int j = 0; j < labColumns.getLength(); j++) {
                private Element labColumn = labColumns.item(j);
                Element jfxButton = docF.createElement("JFXButton");
                jfxButton.setAttribute("mnemonicParsing", "false");
                jfxButton.setAttribute("text", "" + labColumn.getChildNodes().item(0).getNodeValue());
                jfxButton.setAttribute("GridPane.halignment", "CENTER");
                jfxButton.setAttribute("GridPane.rowIndex", "" + i);
                jfxButton.setAttribute("GridPane.valignment", "CENTER");
                jfxButton.setAttribute("GridPane.columnIndex", "" + j);
                columnConstraints.appendChild(jfxButton);
            }
        }
    }
}
