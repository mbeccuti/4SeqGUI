/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class S_TopX extends javax.swing.JPanel {

    /**
     * Creates new form S_TopX
     */
    public S_TopX() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333346L;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        S_GenesUmiPanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        S_Threshold = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        S_Logged = new javax.swing.JComboBox<>();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        S_countTable = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        S_Type = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        S_separator = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_GenesUmiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "topX", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_GenesUmiPanel.setToolTipText(null);
        S_GenesUmiPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton5.setText("Close");
        vCloseButton5.setToolTipText(null);
        vCloseButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_GenesUmiPanel.add(vCloseButton5, gridBagConstraints);

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton39.setText("Execute");
        jButton39.setToolTipText(null);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_GenesUmiPanel.add(jButton39, gridBagConstraints);

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton40.setText("Reset");
        jButton40.setToolTipText(null);
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_GenesUmiPanel.add(jButton40, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText(null);
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("Top expressed genes:");
        jLabel120.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel120, gridBagConstraints);

        S_Threshold.setText("10000");
        S_Threshold.setToolTipText(null);
        S_Threshold.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_ThresholdFocusLost(evt);
            }
        });
        S_Threshold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_ThresholdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_Threshold, gridBagConstraints);

        jLabel2.setText("Counts table:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel2, gridBagConstraints);

        S_Logged.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_Logged, gridBagConstraints);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jButton29.setText("Browse");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jButton29, gridBagConstraints);

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton30.setText("Cancel");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jButton30, gridBagConstraints);

        jLabel3.setText("Logged:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel3, gridBagConstraints);

        S_countTable.setEditable(false);
        S_countTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_countTableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_countTable, gridBagConstraints);

        jLabel4.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel4, gridBagConstraints);

        S_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "variance", "expression" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_Type, gridBagConstraints);

        jLabel5.setText("separator");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel5, gridBagConstraints);

        S_separator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TAB", "comma" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_separator, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_GenesUmiPanel.add(jPanel30, gridBagConstraints);

        jPanel31.setBackground(new java.awt.Color(248, 248, 248));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel31.setToolTipText(null);
        jPanel31.setLayout(new java.awt.GridBagLayout());

        jLabel113.setText("Execution:");
        jLabel113.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(jLabel113, gridBagConstraints);

        cSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cSudoRadioButton.setText("sudo");
        cSudoRadioButton.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 82, 10, 10);
        jPanel31.add(cSudoRadioButton, gridBagConstraints);

        cDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cDockerRadioButton.setSelected(true);
        cDockerRadioButton.setText("docker");
        cDockerRadioButton.setToolTipText(null);
        cDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(cDockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_GenesUmiPanel.add(jPanel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 280;
        gridBagConstraints.ipady = 395;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(S_GenesUmiPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void vCloseButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton5ActionPerformed
        //RESET FIELDS
        S_countTable.setText("");
        S_Threshold.setText("0");
        S_Logged.setSelectedIndex(0);
        //RESET FIELDS
        
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
        //        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton5ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed

        //Field check

        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execTopX.sh "};
    if (cSudoRadioButton.isSelected()){
                cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                cmd[2]+= "group=\\\"docker\\\"";
            }
    
    
            cmd[2]+=" file=\\\""+S_countTable.getText()+"\\\"";
            cmd[2]+=" threshold=\\\""+S_Threshold.getText()+"\\\"";
            cmd[2]+=" separator=\\\""+S_separator.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" logged=\\\""+S_Logged.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" type=\\\""+S_Type.getSelectedItem().toString()+"\\\"";

            Path p = Paths.get(S_countTable.getText());
            Path folder = p.getParent();

            cmd[2]+=" "+ folder.toString()+" >& "+folder.toString()+"/outputExecution ";

            //ProcessStatus.setText(pr.toString());
            if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("TopX ", folder.toString(),pr,MainFrame.listModel.getSize());
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
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("TopX ",folder.toString(),cmd,MainFrame.listModel.getSize());
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
        JOptionPane.showMessageDialog(this, "TopX task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);

        //execute code
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        S_countTable.setText("");
        S_Threshold.setText("10000");
        S_Logged.setSelectedIndex(0);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void S_ThresholdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_ThresholdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_ThresholdFocusLost

    private void S_ThresholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_ThresholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_ThresholdActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        Path p = Paths.get(S_countTable.getText());
        Path folder = p.getParent();

        JFileChooser openDir = new JFileChooser();
        if (!(S_countTable.getText().equals(""))){
            File file =new File(folder.toString());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            S_countTable.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        S_countTable.setText("");
    }//GEN-LAST:event_jButton30ActionPerformed

    private void S_countTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_countTableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_countTableActionPerformed

    private void cDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDockerRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel S_GenesUmiPanel;
    private javax.swing.JComboBox<String> S_Logged;
    public static javax.swing.JTextField S_Threshold;
    private javax.swing.JComboBox<String> S_Type;
    private javax.swing.JTextField S_countTable;
    private javax.swing.JComboBox<String> S_separator;
    private javax.swing.JRadioButton cDockerRadioButton;
    private javax.swing.JRadioButton cSudoRadioButton;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JButton vCloseButton5;
    // End of variables declaration//GEN-END:variables
}
