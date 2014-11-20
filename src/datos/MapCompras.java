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

public class MapCompras {
    
     
    private HashMap <Integer, Compra> listaCompras;

    public HashMap<Integer, Compra> getMapsCompras() {
        return listaCompras;
    }

    public void setMapsCompras(HashMap<Integer, Compra> mapsCompras) {
        this.listaCompras = mapsCompras;
    }
    
    
}
