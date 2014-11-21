/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import static factoria.TiposToXML.JAXB;
import static factoria.TiposToXML.SERIALIZADO;
import static factoria.TiposToXML.XML;

/**
 *
 * @author profesor
 */
public class ToXMLFactory {
    
    
    public ToXMLable build(TiposToXML tipo)
            
    {
        ToXMLable interfaz = null;
        switch(tipo)
        {
            case XSTREAM : interfaz = new XstreamMio(); break;
            case JAXB: interfaz = new JaxbMio(); break;
            case XML: interfaz = new XMLMio(); break;
            case SERIALIZADO: interfaz = new SerializadoMio(); break;
            case GSON: interfaz = new gsonMio(); break;
                
            
        }
        
        return interfaz;
    }
    
    
    
}
