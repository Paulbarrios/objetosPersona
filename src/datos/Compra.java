/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author profesor
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Compra implements Serializable{
    private int id;
    private int cantidad;
    private String concepto;

    public Compra() {
    }
    
    

    public Compra(int id, int cantidad, String concepto) {
        this.id = id;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
