/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import datos.Compra;
import datos.Persona;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.FicherosDatos;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author dam2
 */
public class XMLMio implements ToXMLable{

    @Override
    public void toXMLPersonas(HashMap<Integer, Persona> map, String file) {
        try {

            Element personas = new Element("Personas");
            Document document = new Document(personas);

            for (Map.Entry<Integer, Persona> entrySet : map.entrySet()) {
                Persona p = entrySet.getValue();

                Element persona = new Element("Persona");
                persona.setAttribute("id", String.valueOf(p.getId()));

                Element nombrePersona = new Element("nombre");
                persona.addContent(nombrePersona.setText(p.getNombre()));

                document.getRootElement().addContent(persona);

            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.output(document, System.out);
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(file));

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file) {
        try {

            Element compras = new Element("Compras");
            Document document = new Document(compras);

            for (Map.Entry<Integer, Compra> entrySet : map.entrySet()) {
                Compra c = entrySet.getValue();

                Element compra = new Element("Compra");
                compra.setAttribute("id", String.valueOf(c.getId()));
                
                Element cantidad = new Element("Cantidad");
                compra.addContent(cantidad.setText(String.valueOf(c.getCantidad())));

                Element concepto = new Element("Concepto");
                compra.addContent(concepto.setText(c.getConcepto()));

                document.getRootElement().addContent(compra);

            }

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.output(document, System.out);
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(file));

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file2) {
        HashMap<Integer, Persona> personas = null;
        try {

            SAXBuilder saxBuilder = new SAXBuilder();

            File file = new File(file2);



            Document document = saxBuilder.build(file);

            Element personasXml = document.getRootElement();

            List<Element> listaPersonas = personasXml.getChildren("Persona");
            personas = new HashMap<>(listaPersonas.size());

            for (int i = 0; i <= listaPersonas.size() - 1; i++) {
                Element element = listaPersonas.get(i);
                Persona p = new Persona(Integer.parseInt(element.getAttributeValue("id")), element.getChildText("nombre"));
                personas.put(p.getId(), p);
            }



        } catch (JDOMException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file2) {
        HashMap<Integer, Compra> mapCompras = null;
        try {

            SAXBuilder saxBuilder = new SAXBuilder();

            File file = new File(file2);

            Document document = saxBuilder.build(file);

            Element comprasXml = document.getRootElement();

            List<Element> listaCompras = comprasXml.getChildren("Compra");
            mapCompras = new HashMap<>(listaCompras.size());

            for (int i = 0; i <= listaCompras.size() - 1; i++) {
                Element element = listaCompras.get(i);
                Compra c = new Compra(Integer.parseInt(element.getAttributeValue("id")), Integer.parseInt(element.getChildText("Cantidad")), element.getChildText("Concepto"));
                mapCompras.put(c.getId(), c);
            }



        } catch (JDOMException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapCompras;
    }
    
}
