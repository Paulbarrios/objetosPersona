/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.Compra;
import datos.Persona;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import negocio.FicherosDatos;
import org.jdom2.Document;
import org.jdom2.Element;
import util.Constantes;

/**
 *
 * @author profesor
 */
public class FramePersonas extends javax.swing.JFrame {

    /**
     * Creates new form FramePersonas
     */
    
    private Document document;
    private String rutaBD = null;
     
    FicherosDatos fd = new FicherosDatos();
    
    int idActivo ;
    private HashMap<Integer, Persona> personasMemoria;
    
    public FramePersonas() {
        leerProperties();
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("NOMBRE");

        jTable1.setModel(model);
        
        if(new File(this.rutaBD + "/personas").exists()){
            this.document = fd.cargarPersonasXML(this.rutaBD + "/personas");
            cargarTabla(document);
        }else{
            this.document = new Document(new Element("Personas"));
        }

        jTable1.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent tme) {
                //tme.getType() == TableModelEvent.UPDATE
                }
            });
        

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!jTable1.getSelectionModel().isSelectionEmpty()) {
                    textID.setText(
                            jTable1.getValueAt(
                            jTable1.getSelectedRow(), Constantes.COLUMN_ID).toString());
                    textNombre.setText(
                            jTable1.getValueAt(
                            jTable1.getSelectedRow(), Constantes.COLUMN_NOMBRE).toString());
                }
            }
        });








    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        botonCrearCompra = new javax.swing.JButton();
        botonBorrarCompra = new javax.swing.JButton();
        textCantidad = new javax.swing.JTextField();
        textContent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonGuardarCompras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        textID = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonCrear = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonCargar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonVerCompras = new javax.swing.JButton();
        jComboTipo = new javax.swing.JComboBox();

        jDialog1.setAlwaysOnTop(true);
        jDialog1.setBounds(new java.awt.Rectangle(100, 100, 400, 400));
        jDialog1.setModal(true);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        botonCrearCompra.setText("Crear");
        botonCrearCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCompraActionPerformed(evt);
            }
        });

        botonBorrarCompra.setText("Borrar");
        botonBorrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarCompraActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        jLabel4.setText("Concepto");

        botonGuardarCompras.setText("Guardar");
        botonGuardarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(botonGuardarCompras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(botonCrearCompra)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrarCompra))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textContent)))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrearCompra)
                    .addComponent(botonBorrarCompra)
                    .addComponent(botonGuardarCompras))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(100, 100, 200, 200));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Id");

        jLabel2.setText("Nombre");

        botonCrear.setText("Crear");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonBorrar.setText("Borrar");
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonCargar.setText("Cargar");
        botonCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonVerCompras.setText("Ver compras");
        botonVerCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerComprasActionPerformed(evt);
            }
        });

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "XSTREAM", "JAXB", "XML", "SERIALIZADO" }));
        jComboTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboTipoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textID)
                                .addComponent(botonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCargar)
                                .addGap(12, 12, 12)
                                .addComponent(botonGuardar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonVerCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(botonVerCompras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCrear)
                    .addComponent(botonBorrar)
                    .addComponent(botonGuardar)
                    .addComponent(botonCargar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        boolean add = true;
        int id = 0;
        try {
            id = Integer.parseInt(textID.getText());
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if(id == Integer.parseInt(jTable1.getModel().getValueAt(i, Constantes.COLUMN_ID).toString()) ){
                    add = false;
                }
            }
            
            if (add) {
                model.addRow(new Object[]{textID.getText(), textNombre.getText()});
                Element personas = document.getRootElement();
                
                Element persona = new Element("persona");
                persona.setAttribute("id", textID.getText().toString());
                Element nombrePersona = new Element("nombre");
                persona.addContent(nombrePersona);
                nombrePersona.addContent(textNombre.getText());
                personas.addContent(persona);

            } else {
                JOptionPane.showMessageDialog(this, "El id ya se encuentra en la lista");
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Inserta un numero en el campo id");

        }


    }//GEN-LAST:event_botonCrearActionPerformed

    private void cargarTabla(Document document1){
        Element personasXml = document1.getRootElement();

            List<Element> listaPersonas = personasXml.getChildren("persona");
            
            DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());
  
            for (int i = 0; i <= listaPersonas.size() - 1; i++) {
                Element element = listaPersonas.get(i);
                model.addRow(new Object[]{element.getAttributeValue("id"), element.getChildText("nombre")});
               
            }
    }
    
    
    private HashMap<Integer, Persona> deTablaAArray() {
        HashMap<Integer, Persona> personas = new HashMap<>();
        Persona p = null;


        for (int i = 0; i < jTable1.getRowCount(); i++) {

            p = new Persona(
                    Integer.parseInt(jTable1.getModel().getValueAt(i, Constantes.COLUMN_ID).toString()),
                    (String) jTable1.getModel().getValueAt(i, Constantes.COLUMN_NOMBRE));

            personas.put(p.getId(), p);
        }


        return personas;

    }
    
    private HashMap<Integer, Compra> deTablaAArrayCompras() {
        HashMap<Integer, Compra> compras = new HashMap<>();
        Compra c = null;
        for (int i = 0; i < jTable2.getRowCount(); i++) {

            c = new Compra(i,
                    Integer.parseInt(jTable2.getModel().getValueAt(i, Constantes.COLUMN_CANTIDAD).toString()),
                    (String) jTable2.getModel().getValueAt(i, Constantes.COLUMN_CONTENT));

            compras.put(c.getId(), c);
        }


        return compras;

    }


    private void deArrayATabla(HashMap<Integer, Persona> personas) {
        DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());


        for (Persona p : personas.values()) {
            model.addRow(new Object[]{p.getId(), p.getNombre()});
        }


    }
    
    private void deArrayATablaCompras(HashMap<Integer, Compra> compras) {
        DefaultTableModel model = new DefaultTableModel();
        jTable2.removeAll();
        
            model.addColumn("CANTIDAD");
            model.addColumn("CONTENT");
            
          

        for (Compra p : compras.values()) {
            model.addRow(new Object[]{p.getCantidad(), p.getConcepto()});
        }
        jTable2.setModel(model);
        
       


    }

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        
        fd.guardarPersonasXML(document, this.rutaBD + "/personas");

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarActionPerformed
        DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());
        model.setRowCount(0);
        String nombre = "personas";
        File f = new File(this.rutaBD + "/" + nombre);
        if (f.exists()) {
            
            FicherosDatos fd = new FicherosDatos();
           // HashMap<Integer, Persona> personas = fd.cargarPersonasXML(this.rutaBD + "/" + nombre);
            //personasMemoria = personas;
            //deArrayATabla(personas);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ningun archivo para cargar.");
        }

    }//GEN-LAST:event_botonCargarActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        DefaultTableModel model = ((DefaultTableModel) jTable1.getModel());
        int seleccionada = jTable1.getSelectedRow();
        Integer idEliminar = (Integer) jTable1.getModel().getValueAt(seleccionada, Constantes.COLUMN_ID);

        if (seleccionada > -1) {
            model.removeRow(seleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }
        personasMemoria = deTablaAArray();
        FicherosDatos f = new FicherosDatos();
        String nombre = "personas";
        //f.guardarPersonasXML(this.rutaBD + "/" + nombre, personasMemoria);
        f.borrarCompras(idEliminar, rutaBD);
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonVerComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerComprasActionPerformed
        HashMap<Integer, Compra> mapCompras = null;
        FicherosDatos fd = new FicherosDatos();
        int seleccionada = jTable1.getSelectedRow();
        
        
        if(seleccionada == -1){
            JOptionPane.showMessageDialog(this, "Seleccione una fila");
        }else{
            File archivoPersonas = new File(this.rutaBD + "/" + "personas");
            if (archivoPersonas.exists()) {
                if (personasMemoria != null) {
                        String idPersona = jTable1.getModel().getValueAt(seleccionada, Constantes.COLUMN_ID).toString();
                        idActivo = Integer.parseInt(idPersona);
                        if (personasMemoria.containsKey(idActivo)) {
                            Persona p = personasMemoria.get(idActivo);
                            if (p.getCompras() == null) {
                                File archivoCompra = new File(this.rutaBD + "/" + idPersona);
                                if (archivoCompra.exists()) {
                                    mapCompras = fd.cargarCompraXml(this.rutaBD + "/" + idPersona);
                                } else {
                                    mapCompras = new HashMap<Integer, Compra>();
                                }
                            } else {
                                mapCompras = p.getCompras();
                            }   

                            deArrayATablaCompras(mapCompras);

                            jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                                @Override
                                public void valueChanged(ListSelectionEvent lse) {
                                    if (!jTable2.getSelectionModel().isSelectionEmpty()) {
                                        textCantidad.setText(
                                                jTable2.getValueAt(
                                                jTable2.getSelectedRow(), Constantes.COLUMN_CANTIDAD).toString());
                                        textContent.setText(
                                                jTable2.getValueAt(
                                                jTable2.getSelectedRow(), Constantes.COLUMN_CONTENT).toString());
                                    }
                                }
                            });

                            jDialog1.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Tienes que guardar la nuevas personas antes de ver las compras");
                    }
                   
                } else {
                    JOptionPane.showMessageDialog(this, "Tienes que guardar antes de ver las compras");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tienes que guardar antes de ver las compras");
            }
        }
        
              
    }//GEN-LAST:event_botonVerComprasActionPerformed
    

    private void leerProperties() {
        FileReader file = null;
        Properties p;
        try {
            p = new Properties();
            file = new FileReader(Constantes.FICHERO_PROPERTIES);
            p.load(file);
            rutaBD = p.getProperty(Constantes.RUTABD_PROPERTY);
            //JOptionPane.showMessageDialog(this, rutaBD);

            file.close();
        } catch (Exception ex) {
            Logger.getLogger(FramePersonas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void botonCrearCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCompraActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                
        
            try{
                model.addRow(new Object[]{Integer.parseInt(textCantidad.getText()), textContent.getText()});
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(jDialog1, "Inserta un numero en campo de cantidad");

            }   
            jTable2.setModel(model);
    }//GEN-LAST:event_botonCrearCompraActionPerformed

    private void botonGuardarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarComprasActionPerformed
        String nombre = Integer.toString(idActivo);
        HashMap<Integer, Compra> compras = deTablaAArrayCompras();
        FicherosDatos fd = new FicherosDatos();
        //fd.guardarComprasXML(this.rutaBD + "/" + nombre, compras);
        Persona p = personasMemoria.get(idActivo);
        p.setCompras(compras);
        JOptionPane.showMessageDialog(jDialog1, "Compras guardadas.");
    }//GEN-LAST:event_botonGuardarComprasActionPerformed

    private void botonBorrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarCompraActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.removeRow(jTable2.getSelectedRow());
        jTable2.setModel(model);
    }//GEN-LAST:event_botonBorrarCompraActionPerformed

    private void jComboTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboTipoItemStateChanged
       String tipo = jComboTipo.getSelectedItem().toString();
        FicherosDatos fd = new FicherosDatos();
        fd.setTipo(tipo);
    }//GEN-LAST:event_jComboTipoItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePersonas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonBorrarCompra;
    private javax.swing.JButton botonCargar;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonCrearCompra;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonGuardarCompras;
    private javax.swing.JButton botonVerCompras;
    private javax.swing.JComboBox jComboTipo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textContent;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
