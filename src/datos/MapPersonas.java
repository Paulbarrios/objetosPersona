/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Frou
 */
@XmlRootElement

public class MapPersonas {
    
     
    private HashMap <Integer, Persona> listaPersonas;

    public HashMap<Integer, Persona> getMapsPersonas() {
        return listaPersonas;
    }

    public void setMapsPersonas(HashMap<Integer, Persona> mapsPersonas) {
        this.listaPersonas = mapsPersonas;
    }
    
    
}
