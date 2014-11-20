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
import java.util.HashMap;

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

    
     
    public HashMap<Integer, Persona> cargarPersonasXML(String file2) {
        return mio.fromXMLPersonas(file2);
    }

    public void guardarPersonasXML(String file, HashMap<Integer, Persona> map) {
        mio.toXMLPersonas(map, file);
    }
    
    
    public HashMap<Integer, Compra> cargarCompraXml(String file2) {
       return mio.fromXMLCompras(file2);
    }
    
    public void guardarComprasXML(String file, HashMap<Integer, Compra> map) {
        mio.toXMLCompras(map, file);
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
