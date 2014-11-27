/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Persona;
import datos.Compra;
import factoria.TiposToXML;
import factoria.ToXMLFactory;
import factoria.ToXMLable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathExpression;
import util.Constantes;

/**
 *
 * /**
 *
 * @author dam2
 */
public class FicherosDatos {
    
    static TiposToXML tipo = TiposToXML.XSTREAM;
    private ToXMLFactory fac = new ToXMLFactory();
    private ToXMLable mio = fac.build(tipo);
    


     
     
    public Document cargarPersonasXML(String file2) {
        Document document = null;
        try {       
        
            SAXBuilder saxBuilder = new SAXBuilder();
            File file = new File(file2);
            document = saxBuilder.build(file);
            
            

        } catch (JDOMException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
        
    }

    public void guardarPersonasXML(Document document, String file) {
       
        try {

            XMLOutputter xmlOutput = new XMLOutputter();

            xmlOutput.output(document, System.out);
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(document, new FileWriter(file));

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }
    
    
    public HashMap<Integer, Compra> cargarCompraXml(String file2) {
       return mio.fromXMLCompras(file2);
    }
    
    public void guardarComprasXML(int id, JTable table) {
//        Element compras = new Element("Compras");
//        
//        XPathFactory xFactory = XPathFactory.instance();
//        XPathExpression<Element> expr = xFactory.compile("/personas/persona[@id='s2']", Filters.element());
//        
//        List<Element> links = expr.evaluate(document);
//        
//        Element persona = links.get(0);
//        persona.addContent(compras);
//        
//        
//       for (int i = 0; i < tabla.getRowCount(); i++) {
//           
//           Element persona = new Element("persona");
//           persona.setAttribute("id", tabla.getModel().getValueAt(i, Constantes.COLUMN_ID).toString());
//           Element nombrePersona = new Element("nombre");
//           nombrePersona.addContent((String) tabla.getModel().getValueAt(i, Constantes.COLUMN_NOMBRE));
//        }
    }
    
    public void borrarCompras(Integer  id, String ruta){
        File f = new File(ruta + "/" + id.toString());
        if (f.exists()) {
            f.delete();
        }       
        
    }

    public void setTipo(String tipo) {
        switch(tipo)
        {
            case "XSTREAM" : this.tipo = TiposToXML.XSTREAM; break;
            case "JAXB": this.tipo = TiposToXML.JAXB; break;
            case "XML": this.tipo = TiposToXML.XML; break;
            case "SERIALIZADO": this.tipo = TiposToXML.SERIALIZADO; break;            
        }
    }
}
