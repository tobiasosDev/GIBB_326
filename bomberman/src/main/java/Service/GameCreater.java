package Service;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class GameCreater {

    public void createMap() throws IOException, SAXException, ParserConfigurationException {
        XMLService xmlService = new XMLService();
        File fieldXML = new File(getClass().getResource("testField.xml").getFile());
        File fXMLField = new File(getClass().getResource("../View/Field.fxml").getFile());
        Document doc = xmlService.convertXMLToDoc(fieldXML);
        Document docF = xmlService.convertXMLToDoc(fXMLField);

        Element root = (Element) doc.getElementsByTagName("Root").item(0);
        Element metaData = (Element) root.getElementsByTagName("MetaDaten").item(0);
        Element labyrinthData = (Element) root.getElementsByTagName("LabyrinthDaten").item(0);
        Element columnConstraints = (Element) docF.getElementsByTagName("columnConstraints").item(0);
        Element rowConstraints = (Element) docF.getElementsByTagName("rowConstraints").item(0);
        Element children = (Element) docF.getElementsByTagName("children").item(0);
        NodeList labRows = labyrinthData.getChildNodes();

        int breite = Integer.parseInt(metaData.getElementsByTagName("Breite").item(0).getFirstChild().getNodeValue());
        int groesse = Integer.parseInt(metaData.getElementsByTagName("Groesse").item(0).getFirstChild().getNodeValue());
        String name = metaData.getElementsByTagName("Name").item(0).getFirstChild().getNodeValue();

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
            int lengthOffRows = ((DeferredElementImpl)labRows.item(i).getChildNodes()).getElementsByTagName("Tiles").getLength();
            for (int j = 0; j < labColumns.getLength(); j++) {
                Node labColumn = ((DeferredElementImpl) labColumns).getElementsByTagName("Tiles").item(j);
                Element jfxButton = docF.createElement("JFXButton");
                jfxButton.setAttribute("mnemonicParsing", "false");
                jfxButton.setAttribute("text", "" + labColumn.getChildNodes().item(0).getNextSibling().getChildNodes().item(0).getNodeValue());
                jfxButton.setAttribute("GridPane.halignment", "CENTER");
                jfxButton.setAttribute("GridPane.rowIndex", "" + i);
                jfxButton.setAttribute("GridPane.valignment", "CENTER");
                jfxButton.setAttribute("GridPane.columnIndex", "" + j);
                columnConstraints.appendChild(jfxButton);
            }
        }

        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();

            // send DOM to file
            tr.transform(new DOMSource(doc),
                    new StreamResult(new FileOutputStream(getClass().getResource("testField.fxml").toString())));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
