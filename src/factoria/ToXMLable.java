/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import datos.Compra;
import datos.Persona;
import java.util.HashMap;

/**
 *
 * @author profesor
 */
public interface ToXMLable {
    
    public void toXMLPersonas(HashMap<Integer, Persona> map,String file);
    
    public void toXMLCompras(HashMap<Integer, Compra> map,String file);
    
    public HashMap<Integer, Persona> fromXMLPersonas(String file);
    
    public HashMap<Integer, Compra> fromXMLCompras(String file);
    
    
}
