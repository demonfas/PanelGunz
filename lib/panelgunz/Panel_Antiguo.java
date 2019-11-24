/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelgunz;



/**
 *
 * @author Demon
 */
public class Panel_Antiguo extends javax.swing.JFrame {

    
    Conn cnn = new Conn();
    public Panel_Antiguo() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        Cuentas = new javax.swing.JButton();
        Personajes = new javax.swing.JButton();
        Editar_Cuentas = new javax.swing.JButton();
        Editar_Personajes = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        Bienvenido = new javax.swing.JLabel();
        Conectados = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_AllAccounts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        Cuentas.setText("Cuentas");
        Cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentasActionPerformed(evt);
            }
        });

        Personajes.setText("Personajes");
        Personajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonajesActionPerformed(evt);
            }
        });

        Editar_Cuentas.setText("Editar Cuentas");
        Editar_Cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_CuentasActionPerformed(evt);
            }
        });

        Editar_Personajes.setText("Editar Personajes");
        Editar_Personajes.setToolTipText("");

        jButton5.setText("jButton1");

        jButton6.setText("jButton1");

        jButton7.setText("jButton1");

        jButton8.setText("jButton1");

        jButton9.setText("jButton1");

        jButton10.setText("jButton1");

        jButton11.setText("jButton1");

        jButton12.setText("jButton1");

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editar_Personajes, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editar_Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Personajes, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cuentas)
                .addGap(18, 18, 18)
                .addComponent(Personajes)
                .addGap(18, 18, 18)
                .addComponent(Editar_Cuentas)
                .addGap(18, 18, 18)
                .addComponent(Editar_Personajes)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(Logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(204, 204, 204));
        panel2.setForeground(new java.awt.Color(153, 255, 255));
        panel2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panel2ComponentAdded(evt);
            }
        });

        Bienvenido.setText("Bienvenido $user");

        Conectados.setText("Usuarios conectados $usersonline");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bienvenido)
                    .addComponent(Conectados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bienvenido)
                .addGap(18, 18, 18)
                .addComponent(Conectados)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Table_AllAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "AID", "UserID", "UGradeID", "Coins", "ECoins", "RedColor", "GreenColor", "BlueColor", "Country", "Question", "Answer", "NÂ°", "CID", "AID", "Name", "Sex", "Level", "XP", "BP", "PlayTime", "Kill", "Death", "Ranking"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_AllAccounts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table_AllAccounts.setSelectionBackground(new java.awt.Color(204, 204, 204));
        Table_AllAccounts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Table_AllAccounts.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Table_AllAccounts);
        if (Table_AllAccounts.getColumnModel().getColumnCount() > 0) {
            Table_AllAccounts.getColumnModel().getColumn(0).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(1).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(2).setPreferredWidth(80);
            Table_AllAccounts.getColumnModel().getColumn(3).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(4).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(5).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(6).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(7).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(8).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(9).setPreferredWidth(10);
            Table_AllAccounts.getColumnModel().getColumn(10).setPreferredWidth(100);
            Table_AllAccounts.getColumnModel().getColumn(11).setPreferredWidth(100);
            Table_AllAccounts.getColumnModel().getColumn(12).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(12).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(12).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(13).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(13).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(13).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(14).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(14).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(14).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(15).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(15).setPreferredWidth(80);
            Table_AllAccounts.getColumnModel().getColumn(15).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(16).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(16).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(16).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(17).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(17).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(17).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(18).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(18).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(18).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(19).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(19).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(19).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(20).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(20).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(20).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(21).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(21).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(21).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(22).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(22).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(22).setMaxWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(23).setMinWidth(0);
            Table_AllAccounts.getColumnModel().getColumn(23).setPreferredWidth(20);
            Table_AllAccounts.getColumnModel().getColumn(23).setMaxWidth(0);
        }
        Table_AllAccounts.getAccessibleContext().setAccessibleParent(jPanel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentasActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        cnn.Actualizar_Accounts(Table_AllAccounts);
    }//GEN-LAST:event_CuentasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jPanel1.setVisible(false);
        Bienvenido.setText("Bienvenido '" + LoginO.T_USERID.getText() +"'");
        Conectados.setText("Usuarios conectados: " + LoginO.U_C);
        Conn.login = true;
    }//GEN-LAST:event_formWindowOpened

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        LoginO lgn = new LoginO();
        lgn.PLoginFrame();
        Conn.logged = false;
        this.dispose();
    }//GEN-LAST:event_LogoutActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Conn.login = false;
    }//GEN-LAST:event_formWindowClosed

    private void PersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonajesActionPerformed
        jPanel1.setVisible(true);
        cnn.Actualizar_Characters(Table_AllAccounts);
    }//GEN-LAST:event_PersonajesActionPerformed

    private void panel2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panel2ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_panel2ComponentAdded

    private void Editar_CuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_CuentasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Editar_CuentasActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel_Antiguo().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenido;
    private javax.swing.JLabel Conectados;
    private javax.swing.JButton Cuentas;
    private javax.swing.JButton Editar_Cuentas;
    private javax.swing.JButton Editar_Personajes;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Personajes;
    public static javax.swing.JTable Table_AllAccounts;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    public static java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
