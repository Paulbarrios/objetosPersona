/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import datos.Compra;
import datos.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.FicherosDatos;

/**
 *
 * @author dam2
 */
public class SerializadoMio implements ToXMLable{

    @Override
    public void toXMLPersonas(HashMap<Integer, Persona> map, String file2) {
        FileOutputStream file;
        try {
            file = new FileOutputStream(file2);
            ObjectOutputStream object = new ObjectOutputStream(file);
            for (Persona p : map.values()) {
                object.writeObject(p);
            }
            object.close();
            file.close();
        } catch (Exception ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void toXMLCompras(HashMap<Integer, Compra> map, String file2) {
        File f = new File(file2);
        FileOutputStream file = null;
        ObjectOutputStream object = null;
        try {
            file = new FileOutputStream(f);
            object = new ObjectOutputStream(file);
            for (Compra c : map.values()) {
                object.writeObject(c);
            }

        } catch (Exception ex) {
        }

        try {
            object.close();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap<Integer, Persona> fromXMLPersonas(String file2) {
        FileInputStream file;
        HashMap<Integer, Persona> personas = new HashMap<>();
        Persona p = null;
        try {
            file = new FileInputStream(file2);
            ObjectInputStream object = new ObjectInputStream(file);
            while (object.available() >= 0) {
                p = (Persona) object.readObject();
                personas.put(p.getId(), p);

            }
            object.close();
            file.close();
        } catch (Exception ex) {
        }
        return personas;
    }

    @Override
    public HashMap<Integer, Compra> fromXMLCompras(String file2) {
        File f = new File(file2);

        FileInputStream file = null;
        ObjectInputStream object = null;
        HashMap<Integer, Compra> listaCompras = new HashMap<>();
        Compra c = null;

        try {
            file = new FileInputStream(f);
            object = new ObjectInputStream(file);
            while (file.available() > 0) {
                c = (Compra) object.readObject();
                listaCompras.put(c.getId(), c);
            }

        } catch (Exception ex) {
        }

        try {
            object.close();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaCompras;
    }
    
}
