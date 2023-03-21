/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pe.edu.upeu.app.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import pe.com.syscenterlife.formvalid.Validator;
import pe.com.syscenterlife.formvalid.ValidatorItem;
import pe.edu.upeu.app.dao.ClienteDAO;
import pe.edu.upeu.app.dao.ClienteDaoI;
import pe.edu.upeu.app.modelo.ClienteTO;
import pe.edu.upeu.app.util.ErrorLogger;
import pe.edu.upeu.app.util.MsgBox;

/**
 *
 * @author Lab Software
 */
enum TIPOCLXIENTE {
    Natural, General, Juridico
};

public class MainCliente extends javax.swing.JPanel {

    ClienteDaoI cDao;
    DefaultTableModel modelo;
    MsgBox msg;
    TableRowSorter<TableModel> trsfiltro;
    static ErrorLogger log = new ErrorLogger(MainCliente.class.getName());

    public MainCliente() {
        initComponents();
        ListarClientes();
        for (TIPOCLXIENTE myVar : TIPOCLXIENTE.values()) {
            cbxTipo.addItem(myVar.toString());
        }
    }

    public void ListarClientes() {
        cDao = new ClienteDAO();
        List<ClienteTO> listarCleintes = cDao.listarClientes();
        jTable1.setAutoCreateRowSorter(true);
        modelo = (DefaultTableModel) jTable1.getModel();
        Object[] ob = new Object[4];
        for (int i = 0; i < listarCleintes.size(); i++) {
            ob[0] = i + 1;
            ob[1] = listarCleintes.get(i).getDniruc();
            ob[2] = listarCleintes.get(i).getNombresrs();
            ob[3] = listarCleintes.get(i).getTipo();
            modelo.addRow(ob);
        }
        jTable1.setModel(modelo);
    }

    private void paintForm() {
        if (jTable1.getSelectedRow() != -1) {
            modelo = (DefaultTableModel) jTable1.getModel();
            int rowx = jTable1.getSelectedRow();
            Object valor = jTable1.getValueAt(rowx, 1);
//ClienteTO filax = (ClienteTO)
            //modelo.getRow(jTable1.getSelectedRow());
            cDao = new ClienteDAO();
            ClienteTO d
                    = cDao.buscarClientes(valor.toString());
            txtDni.setText(d.getDniruc());
            txtNombres.setText(d.getNombresrs());
            cbxTipo.setSelectedItem(d.getTipo());
            txtDni.setEditable(false);
            btnRegistrar.setText("MODIFICAR");
//guardarButton.setToolTipText("MODIFICAR");
        } else {
            txtDni.setEditable(true);
        }
    }

    public void resetForm() {
        txtDni.setText("");
        txtNombres.setText("");
        cbxTipo.setSelectedIndex(0);
        txtDni.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        jHintTextField2 = new pe.com.syscenterlife.hint.JHintTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        txtDato1 = new javax.swing.JTextField();
        txtDato2 = new javax.swing.JTextField();
        toastMsg1 = new pe.edu.upeu.app.components.ToastMsg();
        jDateChooser1 = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestion de Clientes");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        jHintTextField2.setHintText("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(573, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jHintTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jHintTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 204, 204));

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        jLabel2.setText("Dni/Ruc:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Tipo:");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cbxTipo.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDato2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDato1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 122, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(toastMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(toastMsg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "DNI/RUC", "Nombres", "Tipo"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(60);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        List<ValidatorItem> vals = new ArrayList<>();
        vals.add(new ValidatorItem("required|number|min:8|max:8", txtDni, "DNI"));
        vals.add(new ValidatorItem("required", txtNombres, "Nombre"));
        vals.add(new ValidatorItem("required", cbxTipo, "Tipo"));
        //vals.add(new ValidatorItem("required|date", txtDato1, "Fecha"));
        //vals.add(new ValidatorItem("required|email", txtDato2, "Correo"));
        //vals.add(new ValidatorItem("required|date", jDateChooser1, "Fecha"));
        //vals.add(new ValidatorItem("required", jHintTextField2, "Texto Hint"));

        cDao = new ClienteDAO();
        ClienteTO to = new ClienteTO();
        to.setDniruc(txtDni.getText());
        to.setNombresrs(txtNombres.getText());
        to.setTipo(cbxTipo.getSelectedItem()==null?"":cbxTipo.getSelectedItem().toString());
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            try {
                int resultado = cDao.update(to);
                if (resultado != 0) {
                    modelo = (DefaultTableModel) jTable1.getModel();
                    Object nuevo[] = {fila + 1, to.getDniruc(), to.getNombresrs(), to.getTipo()};
                    modelo.removeRow(fila);
                    modelo.insertRow(fila, nuevo);
                    resetForm();
                    JOptionPane.showMessageDialog(this, "Re registro");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            try {
                Validator validator = new Validator(vals);
                if(validator.isPasses()){
                msg = new MsgBox();
                if (msg.showConfirmCustom("Esta seguro de crear un nuevo cliente ?", "Mensaje de Confirmación", "") == 0) {
                    if (cDao.create(to) != 0) {
                        modelo = (DefaultTableModel) jTable1.getModel();
                        Object nuevo[] = {modelo.getRowCount() + 1, to.getDniruc(), to.getNombresrs(), to.getTipo()};
                        modelo.addRow(nuevo);
                        resetForm();
                        toastMsg1.success("Se inserto correctamente!");
                        //JOptionPane.showMessageDialog(this, "Re registro");
                    }
                }
                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(this, e.getMessage());
                log.log(Level.SEVERE, "Crear Cliente", e);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        cDao = new ClienteDAO();
        if (jTable1.getSelectedRowCount() > 0) {
            try {
                modelo = (DefaultTableModel) jTable1.getModel();
                int rowx = jTable1.getSelectedRow();
                Object valor = jTable1.getValueAt(rowx, 1);

                msg = new MsgBox();
                if (msg.showConfirmCustom("Esta seguro de eliminar este registrtro DNI: " + valor + "?", "Mensaje de Confirmación", "") == 0) {
                    modelo.removeRow(rowx);
                    cDao.delete(valor.toString());
                    resetForm();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un item");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        paintForm();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        resetForm();
        btnRegistrar.setText("REGISTRAR");
        txtDni.setEditable(true);
        jTable1.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // TODO add your handling code here:        
        txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String cadena = (txtFiltro.getText());
                System.out.println("v:" + cadena);
                txtFiltro.setText(cadena);
                repaint();
                trsfiltro.setRowFilter(RowFilter.regexFilter(txtFiltro.getText())
                );
            }
        });
        System.out.println("llego");
        trsfiltro = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(trsfiltro);

    }//GEN-LAST:event_txtFiltroKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxTipo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private pe.com.syscenterlife.hint.JHintTextField jHintTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private pe.edu.upeu.app.components.ToastMsg toastMsg1;
    private javax.swing.JTextField txtDato1;
    private javax.swing.JTextField txtDato2;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
