import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;


public class Java2xml {
    public String createXml(String[] input) throws ParserConfigurationException, TransformerException {
        String xmlString = "";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.setXmlStandalone(true);

        Element resp_param = generateElement(document, null, input[0]);
       try {

           for (int i = 0; i <input.length -1 ; i+=2) {

               generateElement(document,input[i],input[i+1]);
           }
       }catch (Exception e){
           System.out.println(e);

       }



        getChildNodes(resp_param);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        // xml transform String
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        transformer.transform(domSource, new StreamResult(bos));
        xmlString = bos.toString();
        System.out.println(xmlString);
        System.out.println(xmlString.replaceAll("\r|\n*",""));
        return xmlString;
    }

    private Element generateElement(Document document, String name, String itemValue2) {
        Element itemValue = document.createElement(itemValue2);
        NodeList tagName = document.getElementsByTagName(name);
        Node item = tagName.item(0);
        if(item != null) {
            item.appendChild(itemValue);
        }else {
            document.appendChild(itemValue);
        }
//        itemValue.setTextContent(" ");
        return itemValue;
    }


    private static void  getChildNodes(Element elem){
        if(!elem.hasChildNodes()) {
            elem.setTextContent("guxw");
        }
        NodeList childNodes = elem.getChildNodes();
        for (int i=0;i < childNodes.getLength();i++) {
            Node node =  childNodes.item(i);
            if (node instanceof Element){
                Element e1 = (Element)node;
                getChildNodes(e1);
            }
        }
    }


}