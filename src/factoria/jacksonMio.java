/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import datos.Compra;
import datos.Persona;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author dam2
 */
public class jacksonMio implements ToXMLable{

    @Override
    public void toXMLPersonas(HashMap<Integer, Persona> map, String file) {
      
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(
                mapper.getSerializationConfig().
                getDefaultVisibilityChecker().
                withFieldVisibility(JsonAutoDetect.Visibility.ANY).
                withGetterVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            mapper.writeValue(new File(file), map);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(
                mapper.getSerializationConfig().
                getDefaultVisibilityChecker().
                withFieldVisibility(JsonAutoDetect.Visibility.ANY).
                withGetterVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            mapper.writeValue(new File(file), map);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file) {
        HashMap<Integer, Persona> map = null;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            map = mapper.readValue(new File(file),  
              new TypeReference<HashMap<Integer,Persona>>() { });  

        } catch (JsonGenerationException e)
        {
           e.printStackTrace();
        } catch (JsonMappingException e)
        {
           e.printStackTrace();
        } catch (IOException e)
        {
           e.printStackTrace();
        }
        return map;
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file) {
        HashMap<Integer, Compra> map = null;
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            map = mapper.readValue(new File(file),  
              new TypeReference<HashMap<Integer,Compra>>() { });  

        } catch (JsonGenerationException e)
        {
           e.printStackTrace();
        } catch (JsonMappingException e)
        {
           e.printStackTrace();
        } catch (IOException e)
        {
           e.printStackTrace();
        }
        return map;
    }
    
}
