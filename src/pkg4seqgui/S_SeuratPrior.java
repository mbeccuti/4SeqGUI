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
import static pkg4seqgui.MainFrame.getPreferences;
/**
 *
 * @author user
 */
public class S_SeuratPrior extends javax.swing.JPanel {

    /**
     * Creates new form S_SeuratPrior
     */
    public S_SeuratPrior() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333342L;
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
        S_SeuratPriorPanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        S_SeuratPrior_Button = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        S_countTable = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        sScratchFolder = new javax.swing.JTextField();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        S_geneNumber = new javax.swing.JTextField();
        S_logTen = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        S_sep = new javax.swing.JComboBox<>();
        jLabel121 = new javax.swing.JLabel();
        S_PcaDimensions = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        S_nCluster = new javax.swing.JTextField();
        S_seed = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_SeuratPriorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Seurat Prior", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_SeuratPriorPanel.setToolTipText(null);
        S_SeuratPriorPanel.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_SeuratPriorPanel.add(vCloseButton5, gridBagConstraints);

        S_SeuratPrior_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        S_SeuratPrior_Button.setText("Execute");
        S_SeuratPrior_Button.setToolTipText(null);
        S_SeuratPrior_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_SeuratPrior_ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_SeuratPriorPanel.add(S_SeuratPrior_Button, gridBagConstraints);

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
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_SeuratPriorPanel.add(jButton40, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText(null);
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Matrix Count:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
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
        gridBagConstraints.gridx = 6;
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
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
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
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_countTable, gridBagConstraints);

        jLabel111.setText("Scratch folder:");
        jLabel111.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel111, gridBagConstraints);

        sScratchFolder.setEditable(false);
        sScratchFolder.setToolTipText("This folder will be mounted in the docker container.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(sScratchFolder, gridBagConstraints);

        jToggleButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton34.setText("Browse");
        jToggleButton34.setToolTipText(null);
        jToggleButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton34ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton34, gridBagConstraints);

        jToggleButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton35.setText("Cancel");
        jToggleButton35.setToolTipText(null);
        jToggleButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton35ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton35, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_SeuratPriorPanel.add(jPanel30, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(248, 248, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("Gene Number:");
        jLabel120.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel120, gridBagConstraints);

        S_geneNumber.setText("20");
        S_geneNumber.setToolTipText(null);
        S_geneNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_geneNumberFocusLost(evt);
            }
        });
        S_geneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_geneNumberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_geneNumber, gridBagConstraints);

        S_logTen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_logTen, gridBagConstraints);

        jLabel5.setText("logTen:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel4.setText("Sep:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel4, gridBagConstraints);

        S_sep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TAB", "COMMA" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_sep, gridBagConstraints);

        jLabel121.setText("PCA Dim:");
        jLabel121.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel121, gridBagConstraints);

        S_PcaDimensions.setToolTipText(null);
        S_PcaDimensions.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_PcaDimensionsFocusLost(evt);
            }
        });
        S_PcaDimensions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_PcaDimensionsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_PcaDimensions, gridBagConstraints);

        jLabel123.setText("nCluster:");
        jLabel123.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel123, gridBagConstraints);

        S_nCluster.setToolTipText(null);
        S_nCluster.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_nClusterFocusLost(evt);
            }
        });
        S_nCluster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_nClusterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_nCluster, gridBagConstraints);

        S_seed.setText("111");
        S_seed.setToolTipText(null);
        S_seed.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_seedFocusLost(evt);
            }
        });
        S_seed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_seedActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_seed, gridBagConstraints);

        jLabel125.setText("Seed:");
        jLabel125.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel125, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_SeuratPriorPanel.add(jPanel4, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
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
        S_SeuratPriorPanel.add(jPanel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(S_SeuratPriorPanel, gridBagConstraints);
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

    private void S_SeuratPrior_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_SeuratPrior_ButtonActionPerformed

        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execSeuratPrior.sh "};
            if (cSudoRadioButton.isSelected()){
                cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                cmd[2]+= "group=\\\"docker\\\"";
            }
            cmd[2]+=" scratch.folder=\\\""+sScratchFolder.getText()+"\\\"";
            cmd[2]+=" file=\\\""+S_countTable.getText()+"\\\"";
            cmd[2]+=" separator=\\\""+S_sep.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" logTen=\\\""+S_logTen.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" seed=\\\""+S_seed.getText()+"\\\"";
            cmd[2]+=" PcaDimensions=\\\""+S_PcaDimensions.getText()+"\\\"";
            cmd[2]+=" geneNumber=\\\""+S_geneNumber.getText()+"\\\"";

            cmd[2]+=" nCluster=\\\""+S_nCluster.getText()+"\\\"";

            Path p = Paths.get(S_countTable.getText());
            Path folder = p.getParent();

            cmd[2]+=" "+ folder.toString()+" >& "+folder.toString()+"/outputExecution ";

            //ProcessStatus.setText(pr.toString());
            if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("Seurat prior ", folder.toString(),pr,MainFrame.listModel.getSize());
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
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("Seurat prior ",folder.toString(),cmd,MainFrame.listModel.getSize());
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
        JOptionPane.showMessageDialog(this, "Seurat Prior task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);

        //execute code
    }//GEN-LAST:event_S_SeuratPrior_ButtonActionPerformed

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

    private void jToggleButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton34ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(sScratchFolder.getText().equals(""))){
            File file =new File(sScratchFolder.getText());
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
            sScratchFolder.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton34ActionPerformed

    private void jToggleButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton35ActionPerformed
        sScratchFolder.setText("");
    }//GEN-LAST:event_jToggleButton35ActionPerformed

    private void S_geneNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_geneNumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_geneNumberFocusLost

    private void S_geneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_geneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_geneNumberActionPerformed

    private void S_PcaDimensionsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_PcaDimensionsFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_PcaDimensionsFocusLost

    private void S_PcaDimensionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_PcaDimensionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_PcaDimensionsActionPerformed

    private void S_nClusterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_nClusterFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_nClusterFocusLost

    private void S_nClusterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_nClusterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_nClusterActionPerformed

    private void S_seedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_seedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_seedFocusLost

    private void S_seedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_seedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_seedActionPerformed

    private void cDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDockerRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField S_PcaDimensions;
    private javax.swing.JPanel S_SeuratPriorPanel;
    private javax.swing.JButton S_SeuratPrior_Button;
    private javax.swing.JTextField S_countTable;
    public static javax.swing.JTextField S_geneNumber;
    private javax.swing.JComboBox<String> S_logTen;
    public static javax.swing.JTextField S_nCluster;
    public static javax.swing.JTextField S_seed;
    private javax.swing.JComboBox<String> S_sep;
    private javax.swing.JRadioButton cDockerRadioButton;
    private javax.swing.JRadioButton cSudoRadioButton;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton40;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.ButtonGroup mExecution;
    private javax.swing.JTextField sScratchFolder;
    private javax.swing.JButton vCloseButton5;
    // End of variables declaration//GEN-END:variables
}
