package org.yahoo.temp;

import java.io.File;
import javax.xml.bind.*;

public class Main {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SummaryCart.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/main/resources/input.xml");
        SummaryCart sc = (SummaryCart) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "SummaryCart.xsd");
        marshaller.marshal(sc, System.out);
        System.out.println("_______________________________________________");
        System.out.println(sc);
    }

}