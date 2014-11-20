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
 * @author dam2
 */
public class gsonMio implements ToXMLable{
    
    public void toXML(Object obj,String file) {
       HashMap<Integer, Object> map = (HashMap<Integer, Object>) obj;
       
//       Gson gson = new Gson();
//
//         //Second way to create a Gson object using GsonBuilder
//
//       Gson gson1 = new GsonBuilder()
//                      .disableHtmlEscaping()
//                      .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                      .setPrettyPrinting()
//                      .serializeNulls()
//                      .create();
//       try {
//               FileWriter fw = new FileWriter("gsonJSONHashMap.json");
//         gson.toJson(hash,fw);
//         fw.close();
//         fw = new FileWriter("gsonJSONlista.json");
//
//         gson.toJson(a,fw);
//         fw.close();
//         fw = new FileWriter("gsonJSONObject.json");
//         gson.toJson(p,fw);
//         fw.close();
//       } catch (IOException ex) {
//               Logger.getLogger(Serialize.class.getName()).log(Level.SEVERE, null, ex);
//       }
//       

       
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
