/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static pkg4seqgui.MainFrame.getPreferences;

/**
 *
 * @author beccuti
 */
public class MultiQC extends javax.swing.JPanel {

    /**
     * Creates new form MultiQC
     */
    public MultiQC() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        MultiQCGroup = new javax.swing.ButtonGroup();
        MultiQCpanel = new javax.swing.JPanel();
        jButton45 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        vCloseButton7 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        QdataFolderText = new javax.swing.JTextField();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        QSudoRadioButton = new javax.swing.JRadioButton();
        QDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        MultiQCpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "MultiQC ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(153, 0, 204))); // NOI18N
        MultiQCpanel.setToolTipText(null);
        MultiQCpanel.setLayout(new java.awt.GridBagLayout());

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton45.setText("Execute");
        jButton45.setToolTipText(null);
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jButton45, gridBagConstraints);

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton47.setText("Reset");
        jButton47.setToolTipText(null);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jButton47, gridBagConstraints);

        vCloseButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton7.setText("Close");
        vCloseButton7.setToolTipText(null);
        vCloseButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(vCloseButton7, gridBagConstraints);

        jPanel36.setBackground(new java.awt.Color(248, 248, 248));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel36.setToolTipText(null);
        jPanel36.setLayout(new java.awt.GridBagLayout());

        jLabel127.setText("Data folder:");
        jLabel127.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jLabel127, gridBagConstraints);

        QdataFolderText.setEditable(false);
        QdataFolderText.setToolTipText("The folder containing the input reads");
        QdataFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QdataFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel36.add(QdataFolderText, gridBagConstraints);

        jToggleButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton40.setText("Browse");
        jToggleButton40.setToolTipText(null);
        jToggleButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton40ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jToggleButton40, gridBagConstraints);

        jToggleButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton41.setText("Cancel");
        jToggleButton41.setToolTipText(null);
        jToggleButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton41ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jToggleButton41, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jPanel36, gridBagConstraints);

        jPanel37.setBackground(new java.awt.Color(248, 248, 248));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel37.setToolTipText(null);
        jPanel37.setLayout(new java.awt.GridBagLayout());

        jLabel129.setText("Execution:");
        jLabel129.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel37.add(jLabel129, gridBagConstraints);

        QSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MultiQCGroup.add(QSudoRadioButton);
        QSudoRadioButton.setText("sudo");
        QSudoRadioButton.setToolTipText(null);
        QSudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QSudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 85, 10, 10);
        jPanel37.add(QSudoRadioButton, gridBagConstraints);

        QDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MultiQCGroup.add(QDockerRadioButton);
        QDockerRadioButton.setSelected(true);
        QDockerRadioButton.setText("docker");
        QDockerRadioButton.setToolTipText(null);
        QDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel37.add(QDockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jPanel37, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(MultiQCpanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed

        if (QdataFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input folder","Error: Data  folder",JOptionPane.ERROR_MESSAGE);
            //mFastQFolderText.requestFocusInWindow();
        }
        else
        {
            //execute code
            Runtime rt = Runtime.getRuntime();
            try{
                String[] cmd = {"/bin/bash","-c"," bash ./execmultiqc.sh "};
                if (QSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
                }
                else{
                    cmd[2]+= "group=\\\"docker\\\"";
                }
                cmd[2]+= " data.folder=\\\""+QdataFolderText.getText()+"\\\"";

                cmd[2]+=" "+QdataFolderText.getText() +" >& "+QdataFolderText.getText()+"/outputExecution ";

                if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                    Process pr = rt.exec(cmd);
                    MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("MultiQC  ", QdataFolderText.getText(),pr,MainFrame.listModel.getSize());
                    MainFrame.listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    MainFrame.GL.setAvoidProcListValueChanged(-1);
                    MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                    MainFrame.GL.setAvoidProcListValueChanged(0);
                    if(MainFrame.listProcRunning.size()==1){
                        MainFrame.t=new Timer();
                        MainFrame.t.scheduleAtFixedRate(new MainFrame.MyTask(), 5000, 5000);
                    }
                }
                else{
                    MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("MultiQC", QdataFolderText.getText(),cmd,MainFrame.listModel.getSize());
                    MainFrame.listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    MainFrame.GL.setAvoidProcListValueChanged(-1);
                    MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    MainFrame.GL.setAvoidProcListValueChanged(0);
                }
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.ProcList.setModel(MainFrame.listModel);
                MainFrame.ProcList.setCellRenderer(new MainFrame.ListEntryCellRenderer());
                MainFrame.GL.setAvoidProcListValueChanged(0);
            }
            catch(IOException e) {
                JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
            JOptionPane.showMessageDialog(this, "MultiQC task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
        }
        //execute code
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        QDockerRadioButton.setSelected(true);
        QdataFolderText.setText("");
    }//GEN-LAST:event_jButton47ActionPerformed

    private void vCloseButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton7ActionPerformed
        QDockerRadioButton.setSelected(true);
        QdataFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";
        //        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton7ActionPerformed

    private void QdataFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QdataFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QdataFolderTextActionPerformed

    private void jToggleButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton40ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(QdataFolderText.getText().equals(""))){
            File file =new File(QdataFolderText.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }
        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            QdataFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton40ActionPerformed

    private void jToggleButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton41ActionPerformed
        QdataFolderText.setText("");
    }//GEN-LAST:event_jToggleButton41ActionPerformed

    private void QSudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QSudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QSudoRadioButtonActionPerformed

    private void QDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QDockerRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup MultiQCGroup;
    private javax.swing.JPanel MultiQCpanel;
    private javax.swing.JRadioButton QDockerRadioButton;
    private javax.swing.JRadioButton QSudoRadioButton;
    private javax.swing.JTextField QdataFolderText;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton47;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JButton vCloseButton7;
    // End of variables declaration//GEN-END:variables
}
