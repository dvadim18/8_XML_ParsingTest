package com.qa;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaXmlParser {


    @Test
    void xmlParseTest() throws Exception {



        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("phone_detail.xml"); // xml созданные в идее выдают NullPointer.. ну вы поняли)

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);

        NodeList children = document.getElementsByTagName("displayType");
        Element rssElement = (Element) children.item(0);

        //System.out.println(rssElement.getNodeName());
        assertThat(rssElement.getNodeName()).isEqualTo("displayType");

        NodeList name = document.getElementsByTagName("displaySize");
        Element phoneName = (Element) name.item(1);

        assertThat(phoneName.getTextContent()).isEqualTo("16");

        //System.out.println(phoneName.getTextContent());

    }

}
