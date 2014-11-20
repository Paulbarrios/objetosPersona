/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;


import com.thoughtworks.xstream.XStream;
import datos.Compra;
import datos.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class XstreamMio implements ToXMLable{

    
    public void toXML(Object obj,String file) {
       HashMap<Integer, Object> map = (HashMap<Integer, Object>) obj;
       
        try {
            XStream xstream = new XStream();
            xstream.toXML(map, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
       

       
    }

   
    public Object fromXML(String file) {
        HashMap<Integer, Object> map = null;
        XStream xstream = new XStream();

        try {
          map = (HashMap) xstream.fromXML(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XstreamMio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

    @Override
    public void toXMLPersonas(HashMap<Integer, Persona> map, String file) {
        toXML(map, file);
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file) {
        toXML(map, file);
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file) {
        HashMap<Integer, Persona> map = (HashMap<Integer, Persona>) fromXML(file);
        return map;
        
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file) {
        HashMap<Integer, Compra> map = (HashMap<Integer, Compra>) fromXML(file);
        return map;
        
    }
    
}
