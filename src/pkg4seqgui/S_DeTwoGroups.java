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
public class S_DeTwoGroups extends javax.swing.JPanel {

    /**
     * Creates new form S_AnovaLike
     */
    public S_DeTwoGroups() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333320L;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mExecution = new javax.swing.ButtonGroup();
        S_AnovaLikePanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        S_AnovaLike_jButton = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        S_countTable = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_AnovaLikePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "DE Two groups", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_AnovaLikePanel.setToolTipText(null);
        S_AnovaLikePanel.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_AnovaLikePanel.add(vCloseButton5, gridBagConstraints);

        S_AnovaLike_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        S_AnovaLike_jButton.setText("Execute");
        S_AnovaLike_jButton.setToolTipText(null);
        S_AnovaLike_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_AnovaLike_jButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_AnovaLikePanel.add(S_AnovaLike_jButton, gridBagConstraints);

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
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_AnovaLikePanel.add(jButton40, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText(null);
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Counts table:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel2, gridBagConstraints);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jButton29.setText("Browse");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
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
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jButton30, gridBagConstraints);

        S_countTable.setEditable(false);
        S_countTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_countTableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 10, 10);
        jPanel30.add(S_countTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_AnovaLikePanel.add(jPanel30, gridBagConstraints);

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
        mExecution.add(cSudoRadioButton);
        cSudoRadioButton.setText("sudo");
        cSudoRadioButton.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 75, 10, 10);
        jPanel31.add(cSudoRadioButton, gridBagConstraints);

        cDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(cDockerRadioButton);
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
        S_AnovaLikePanel.add(jPanel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(S_AnovaLikePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void vCloseButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton5ActionPerformed
        //RESET FIELDS
        //RESET FIELDS
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
        //        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton5ActionPerformed

    private void S_AnovaLike_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_AnovaLike_jButtonActionPerformed

        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execDeTwoGroups.sh "};
            if (cSudoRadioButton.isSelected()){
                cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                cmd[2]+= "group=\\\"docker\\\"";
            }
            cmd[2]+=" file=\\\""+S_countTable.getText()+"\\\"";

            Path p = Paths.get(S_countTable.getText());
            Path folder = p.getParent();

            cmd[2]+=" "+ folder.toString()+" >& "+folder.toString()+"/outputExecution ";

            //ProcessStatus.setText(pr.toString());
            if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("De Two groups ", folder.toString(),pr,MainFrame.listModel.getSize());
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
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("De Two groups ",folder.toString(),cmd,MainFrame.listModel.getSize());
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
        JOptionPane.showMessageDialog(this, "De Two groups task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);

        //execute code
    }//GEN-LAST:event_S_AnovaLike_jButtonActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        S_countTable.setText("");
    }//GEN-LAST:event_jButton40ActionPerformed

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
    private javax.swing.JPanel S_AnovaLikePanel;
    private javax.swing.JButton S_AnovaLike_jButton;
    private javax.swing.JTextField S_countTable;
    private javax.swing.JRadioButton cDockerRadioButton;
    private javax.swing.JRadioButton cSudoRadioButton;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton40;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.ButtonGroup mExecution;
    private javax.swing.JButton vCloseButton5;
    // End of variables declaration//GEN-END:variables
}
