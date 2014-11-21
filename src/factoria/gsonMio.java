/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datos.Compra;
import datos.Persona;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.saxon.functions.Serialize;

/**
 *
 * @author dam2
 */
public class gsonMio implements ToXMLable{
    
    public void toXML(Object obj,String file) {
       HashMap<Integer, Object> map = (HashMap<Integer, Object>) obj;
       
       Gson gson = new Gson();
                      
       try {
         FileWriter fw = new FileWriter(file);
         gson.toJson(map,fw);
         fw.close();

       } catch (IOException ex) {
               Logger.getLogger(Serialize.class.getName()).log(Level.SEVERE, null, ex);
       }
       

       
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
        HashMap<Integer, Persona> map = null;
        
        Gson gson = new Gson();
        try{
          FileReader fr = new FileReader(file); 
          Type typeOfHashMap = new TypeToken<HashMap<Integer, Persona>>() {
                        }.getType();
          map = gson.fromJson(fr,typeOfHashMap);

          fr.close();

        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        return map;
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file) {
        HashMap<Integer, Compra> map = null;
        
        Gson gson = new Gson();
        try{
          FileReader fr = new FileReader(file); 
          Type typeOfHashMap = new TypeToken<HashMap<Integer, Compra>>() {
                        }.getType();
          map = gson.fromJson(fr,typeOfHashMap);

          fr.close();

        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        return map;
    }
    
}
