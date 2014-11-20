/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import datos.Compra;
import datos.MapCompras;
import datos.MapPersonas;
import datos.Persona;
import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

/**
 *
 * @author profesor
 */
public class JaxbMio implements ToXMLable{

    @Override
    public void toXMLPersonas(HashMap<Integer, Persona> map, String file) {
         MapPersonas mapPersonas = new MapPersonas();
         mapPersonas.setMapsPersonas(map);
         try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MapPersonas.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mapPersonas, new File(file));
          } catch (JAXBException e) {
            e.printStackTrace();
          }
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file) {
         MapCompras mapCompras = new MapCompras();
         mapCompras.setMapsCompras(map);       
         try {

            JAXBContext jaxbContext = JAXBContext.newInstance(MapCompras.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(mapCompras, new File(file));
          } catch (JAXBException e) {
            e.printStackTrace();
          }
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file2) {
          MapPersonas mapPersonas = null;
          try {

            File file = new File(file2);
            JAXBContext jaxbContext = JAXBContext.newInstance(MapPersonas.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            mapPersonas = (MapPersonas) jaxbUnmarshaller.unmarshal(file);
            
          } catch (JAXBException e) {
            e.printStackTrace();
          }
          
          return mapPersonas.getMapsPersonas();
          
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file2) {
        MapCompras mapCompras = null;
          try {

            File file = new File(file2);
            JAXBContext jaxbContext = JAXBContext.newInstance(MapCompras.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            mapCompras = (MapCompras) jaxbUnmarshaller.unmarshal(file);
            
          } catch (JAXBException e) {
            e.printStackTrace();
          }
          
          return mapCompras.getMapsCompras();

    }
    
}
