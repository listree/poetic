package com.cookbook.testdome;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

/**
 * Created by poet on 7/20/16.
 */
public class Trojan {


    public static int countCompromised(String xml, String infectedFileId) {

        HashSet<String> infectedSet = new HashSet<String>();

        try {
            final InputStream stream = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(stream);

            NodeList snapshots = doc.getDocumentElement().getChildNodes();

            for (int i = 0; i < snapshots.getLength(); i++) {
                Node snapshot = snapshots.item(i);
                if( "snapshot".equals(snapshot.getNodeName() ) ) {
                    doCount(snapshot, infectedFileId, infectedSet);
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
            return 0;
        }

        infectedSet.remove(infectedFileId);
        return infectedSet.size();
    }

    public static void doCount(Node root, String infectedFileId, HashSet infectedSet) {

        NodeList nodes = root.getChildNodes();
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if( "file".equals(node.getNodeName() ) ) {
                String fileId = node.getAttributes().getNamedItem("fileId").getNodeValue();
                set.add(fileId);
            } else if( "folder".equals(node.getNodeName() ) ) {
                doCount(node, infectedFileId, infectedSet);
            }
        }
        if( set.contains(infectedFileId) ) {
            infectedSet.addAll(set);
        }

    }

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<root>" +
                        "   <snapshot>" +
                        "      <folder>" +
                        "         <file fileId=\"1\"/>" +
                        "         <file fileId=\"2\"/>" +
                        "         <folder>" +
                        "            <file fileId=\"3\"/>" +
                        "            <file fileId=\"4\"/>" +
                        "         </folder>" +
                        "      </folder>" +
                        "   </snapshot>" +
                        "   <snapshot>" +
                        "      <file fileId=\"1\"/>" +
                        "      <file fileId=\"3\"/>" +
                        "      <folder>" +
                        "         <file fileId=\"2\"/>" +
                        "         <file fileId=\"4\"/>" +
                        "         <folder>" +
                        "            <file fileId=\"3\"/>" +
                        "            <file fileId=\"4\"/>" +
                        "         </folder>" +
                        "      </folder>" +
                        "   </snapshot>" +
                        "</root>";


        System.out.println(Trojan.countCompromised(xml, "3"));
    }
}