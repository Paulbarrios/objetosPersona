/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author dam2
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona implements Serializable, Comparable<Persona>{

   
    private String nombre;
    private Integer id;
    private transient HashMap<Integer, Compra> compras;
    
     public Persona() {
    }

    public HashMap<Integer, Compra> getCompras() {
        return compras;
    }

    public void setCompras(HashMap<Integer, Compra> compras) {
        this.compras = compras;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        compras = new HashMap<Integer, Compra>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Persona p) {
         return this.id.compareTo(p.getId());
    }
}
