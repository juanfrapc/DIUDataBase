/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diudatabase;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import model.ConnectionData;
import persistence.MySQLHandler;
import persistence.SQLHandler;
import persistence.SQLiteHandler;

/**
 *
 * @author Entrar
 */
public class DIUApp extends javax.swing.JFrame {

    private List<SQLHandler> connections;
    private final DefaultListModel connectionListModel;
    private final DefaultListModel tableListModel;
    private final DefaultListModel fieldListModel;

    /**
     * Creates new form DIUApp
     */
    public DIUApp() {
        initComponents();
        this.connections = new ArrayList<>();
        this.connectionListModel = (DefaultListModel) connectionList.getModel();
        this.tableListModel = (DefaultListModel) tableList.getModel();
        this.fieldListModel = (DefaultListModel) fieldList.getModel();
        this.fieldList.setSelectionModel(new NoSelectionListModel());
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectionGroup = new javax.swing.ButtonGroup();
        dbPanel = new javax.swing.JPanel();
        tableScrollPanel = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList<>();
        tableFieldScrollPanel = new javax.swing.JScrollPane();
        fieldList = new javax.swing.JList<>();
        singleSelButton = new javax.swing.JToggleButton();
        singleIntervalButton = new javax.swing.JToggleButton();
        multiIntervalButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        connectionPanel = new javax.swing.JPanel();
        connectionsPane = new javax.swing.JScrollPane();
        connectionList = new javax.swing.JList<>();
        addConnectionButton = new javax.swing.JButton();
        delConnectionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DIUDatabase Manager");
        setMinimumSize(new java.awt.Dimension(740, 500));

        dbPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Database Content"));

        tableScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableList.setBorder(javax.swing.BorderFactory.createTitledBorder("Tables"));
        tableList.setModel(new DefaultListModel());
        tableList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tableListValueChanged(evt);
            }
        });
        tableScrollPanel.setViewportView(tableList);

        tableFieldScrollPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        fieldList.setBorder(javax.swing.BorderFactory.createTitledBorder("Table Fields"));
        fieldList.setModel(new DefaultListModel());
        fieldList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableFieldScrollPanel.setViewportView(fieldList);

        selectionGroup.add(singleSelButton);
        singleSelButton.setSelected(true);
        singleSelButton.setText("Single");
        singleSelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleSelButtonActionPerformed(evt);
            }
        });

        selectionGroup.add(singleIntervalButton);
        singleIntervalButton.setText("Single Interval");
        singleIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleIntervalButtonActionPerformed(evt);
            }
        });

        selectionGroup.add(multiIntervalButton);
        multiIntervalButton.setText("Multiple Interval");
        multiIntervalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiIntervalButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Table Selection Mode:");

        clearButton.setText("Clear Selection");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dbPanelLayout = new javax.swing.GroupLayout(dbPanel);
        dbPanel.setLayout(dbPanelLayout);
        dbPanelLayout.setHorizontalGroup(
            dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbPanelLayout.createSequentialGroup()
                .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableFieldScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(dbPanelLayout.createSequentialGroup()
                .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(singleSelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(singleIntervalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(multiIntervalButton))
                    .addComponent(clearButton))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        dbPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {multiIntervalButton, singleIntervalButton, singleSelButton});

        dbPanelLayout.setVerticalGroup(
            dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbPanelLayout.createSequentialGroup()
                .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleSelButton)
                    .addComponent(singleIntervalButton)
                    .addComponent(multiIntervalButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dbPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPanel)
                    .addComponent(tableFieldScrollPanel))
                .addGap(0, 0, 0))
        );

        connectionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Active Connections"));

        connectionsPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        connectionList.setModel(new DefaultListModel());
        connectionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        connectionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                connectionListValueChanged(evt);
            }
        });
        connectionsPane.setViewportView(connectionList);

        addConnectionButton.setBackground(new java.awt.Color(0, 255, 51));
        addConnectionButton.setText("+");
        addConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addConnectionButtonActionPerformed(evt);
            }
        });

        delConnectionButton.setBackground(new java.awt.Color(255, 0, 0));
        delConnectionButton.setText("-");
        delConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delConnectionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout connectionPanelLayout = new javax.swing.GroupLayout(connectionPanel);
        connectionPanel.setLayout(connectionPanelLayout);
        connectionPanelLayout.setHorizontalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(connectionPanelLayout.createSequentialGroup()
                        .addComponent(addConnectionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delConnectionButton))
                    .addComponent(connectionsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        connectionPanelLayout.setVerticalGroup(
            connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(connectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectionsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(connectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addConnectionButton)
                    .addComponent(delConnectionButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(dbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dbPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(connectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singleSelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleSelButtonActionPerformed
        if (singleSelButton.isSelected()) {
            tableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            int[] selectedIndices = tableList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                tableList.setSelectedIndex(selectedIndices[0]);
            }
        }
    }//GEN-LAST:event_singleSelButtonActionPerformed

    private void addConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addConnectionButtonActionPerformed
        ConnectionDialog connectionDialog = new ConnectionDialog(this);
        int dialogStatus = connectionDialog.showDialog();
        if (dialogStatus == ConnectionDialog.APPROVE) {
            createConnection(connectionDialog.getConnectionParams());
        }
    }//GEN-LAST:event_addConnectionButtonActionPerformed

    private void delConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delConnectionButtonActionPerformed
        try {
            int selectedIndex = connectionList.getSelectedIndex();
            if (selectedIndex >= 0) {
                fieldListModel.clear();
                tableListModel.clear();                
                connections.remove(selectedIndex).closeConnection();
                connectionListModel.removeElementAt(selectedIndex);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Unable to disconnect from " + connectionList.getSelectedValue(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delConnectionButtonActionPerformed

    private void connectionListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_connectionListValueChanged
        tableListModel.clear();
        int selectedIndex = connectionList.getSelectedIndex();
        if (selectedIndex >= 0) {
            SQLHandler handler = connections.get(selectedIndex);
            List<String> tables = getTables(handler);
            if (tables != null) {
                for (String table : tables) {
                    tableListModel.addElement(table);
                }
            }

        }

    }//GEN-LAST:event_connectionListValueChanged

    private void singleIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleIntervalButtonActionPerformed
        if (singleIntervalButton.isSelected()) {
            tableList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            int[] selectedIndices = tableList.getSelectedIndices();
            if (selectedIndices.length > 0) {
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(selectedIndices[0]);
                for (int i = 1; i < selectedIndices.length; i++) {
                    if (selectedIndices[i] == selectedIndices[i - 1] + 1) {
                        indexList.add(selectedIndices[i]);
                    } else {
                        break;
                    }
                }
                int[] indices = new int[indexList.size()];
                for (int i = 0; i < indices.length; i++) {
                    indices[i] = indexList.get(i);

                }
                tableList.setSelectedIndices(indices);
            }
        }
    }//GEN-LAST:event_singleIntervalButtonActionPerformed

    private void multiIntervalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiIntervalButtonActionPerformed
        if (multiIntervalButton.isSelected()) {
            tableList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }//GEN-LAST:event_multiIntervalButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        tableList.clearSelection();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void tableListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tableListValueChanged
        fieldListModel.clear();
        List<String> tableNames = tableList.getSelectedValuesList();
        SQLHandler handler = connections.get(connectionList.getSelectedIndex());
        for (String tableName : tableNames) {
            List<String> fields = getFields(handler, tableName);
            for (String field : fields) {
                fieldListModel.addElement(tableName + "." + field);
            }
        }
    }//GEN-LAST:event_tableListValueChanged

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
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIUApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DIUApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addConnectionButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JList<String> connectionList;
    private javax.swing.JPanel connectionPanel;
    private javax.swing.JScrollPane connectionsPane;
    private javax.swing.JPanel dbPanel;
    private javax.swing.JButton delConnectionButton;
    private javax.swing.JList<String> fieldList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton multiIntervalButton;
    private javax.swing.ButtonGroup selectionGroup;
    private javax.swing.JToggleButton singleIntervalButton;
    private javax.swing.JToggleButton singleSelButton;
    private javax.swing.JScrollPane tableFieldScrollPanel;
    private javax.swing.JList<String> tableList;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables

    private void createConnection(ConnectionData params) {
        try {
            switch (params.getConnectionType()) {
                case ConnectionData.SQLITE:
                    connections.add(new SQLiteHandler(params));
                    break;
                case ConnectionData.MYSQL:
                    connections.add(new MySQLHandler(params));
                    break;
            }
            this.connectionListModel.addElement(params.getDbName());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<String> getTables(SQLHandler handler) {
        try {
            return handler.getTables();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Unable to obtain tables from " + connectionList.getSelectedValue(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private List<String> getFields(SQLHandler handler, String tableName) {
        try {
            return handler.getFields(tableName);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Unable to obtain columns from " + connectionList.getSelectedValue() + "." + tableName,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
