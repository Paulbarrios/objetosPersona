/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * /**
 *
 * @author dam2
 */
public class FicherosDatos {
    
   


     
     
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
    

}