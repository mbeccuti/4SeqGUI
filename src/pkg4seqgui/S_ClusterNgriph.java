/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import static pkg4seqgui.MainFrame.getPreferences;
/**
 *
 * @author user
 */
public class S_ClusterNgriph extends javax.swing.JPanel {

    /**
     * Creates new form S_ClusterNgriph
     */
    public S_ClusterNgriph() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333325L;
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
        S_ClusterNgriphPanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        S_ClusterNgriph_jButton = new javax.swing.JButton();
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
        S_permAtTime = new javax.swing.JTextField();
        S_logTen = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        S_sep = new javax.swing.JComboBox<>();
        jLabel122 = new javax.swing.JLabel();
        S_seed = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        S_percent = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        S_nPerm = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_ClusterNgriphPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Defining a range of number of Clusters to inspect with SIMLR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_ClusterNgriphPanel.setToolTipText(null);
        S_ClusterNgriphPanel.setLayout(new java.awt.GridBagLayout());

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
        S_ClusterNgriphPanel.add(vCloseButton5, gridBagConstraints);

        S_ClusterNgriph_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        S_ClusterNgriph_jButton.setText("Execute");
        S_ClusterNgriph_jButton.setToolTipText(null);
        S_ClusterNgriph_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_ClusterNgriph_jButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_ClusterNgriphPanel.add(S_ClusterNgriph_jButton, gridBagConstraints);

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
        S_ClusterNgriphPanel.add(jButton40, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText(null);
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Counts table: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
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
        gridBagConstraints.gridx = 7;
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
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel30.add(S_countTable, gridBagConstraints);

        jLabel111.setText("Scratch folder:");
        jLabel111.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel111, gridBagConstraints);

        sScratchFolder.setEditable(false);
        sScratchFolder.setToolTipText("This folder will be mounted in the docker container.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton35, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_ClusterNgriphPanel.add(jPanel30, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(248, 248, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("Permutations group:");
        jLabel120.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel120, gridBagConstraints);

        S_permAtTime.setText("8");
        S_permAtTime.setToolTipText(null);
        S_permAtTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_permAtTimeFocusLost(evt);
            }
        });
        S_permAtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_permAtTimeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_permAtTime, gridBagConstraints);

        S_logTen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "false", "true" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_logTen, gridBagConstraints);

        jLabel5.setText("log10:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel4.setText("Sep:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel4, gridBagConstraints);

        S_sep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TAB", "COMMA" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_sep, gridBagConstraints);

        jLabel122.setText("Seed: ");
        jLabel122.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel122, gridBagConstraints);

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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_seed, gridBagConstraints);

        jLabel121.setText("% of removed cells:");
        jLabel121.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel121, gridBagConstraints);

        S_percent.setText("10");
        S_percent.setToolTipText(null);
        S_percent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_percentFocusLost(evt);
            }
        });
        S_percent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_percentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_percent, gridBagConstraints);

        jLabel123.setText("# of permutations:");
        jLabel123.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel123, gridBagConstraints);

        S_nPerm.setText("160");
        S_nPerm.setToolTipText(null);
        S_nPerm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_nPermFocusLost(evt);
            }
        });
        S_nPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_nPermActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(S_nPerm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_ClusterNgriphPanel.add(jPanel4, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 10, 10);
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
        S_ClusterNgriphPanel.add(jPanel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(S_ClusterNgriphPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void vCloseButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton5ActionPerformed
        //RESET FIELDS
        jButton40ActionPerformed(evt); 
        //RESET FIELDS
        MainFrame.setCard(null);
        //GL.setAvoidProcListValueChanged(-1);
        //        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton5ActionPerformed

    private void S_ClusterNgriph_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_ClusterNgriph_jButtonActionPerformed
        String countsFile = S_countTable.getText(), 
               scratchFolder = sScratchFolder.getText(); 
        Integer seed, nperm, permtime, percentage;
        
        if (MainFrame.checkPath(this, countsFile, "counts table file") ||
            MainFrame.checkPath(this, scratchFolder, "scratch folder"))
            return; 
        
        if ((nperm = MainFrame.checkIntValue(this, S_nPerm.getText(), "number of permutations")) == null ||
             (seed = MainFrame.checkIntValue(this, S_seed.getText(), "seed")) == null ||
             (permtime = MainFrame.checkIntValue(this, S_permAtTime.getText(), "permutation groups")) == null ||
             (percentage = MainFrame.checkIntValue(this, S_percent.getText(), "percentage")) == null) 
            return; 
        
        String outputFolder = Paths.get(countsFile).getParent().toString();
        ScriptCaller params = new ScriptCaller("clusterNgriph.R", outputFolder)
                .addArg("group", cSudoRadioButton.isSelected() ? "sudo" : "docker")
                .addArg("scratch.folder", scratchFolder)
                .addArg("file", countsFile)
                .addArg("nPerm", nperm)
                .addArg("permAtTime", permtime)
                .addArg("percent", percentage)
                .addArg("separator", S_sep.getSelectedItem().toString())
                .addArg("logTen", S_logTen.getSelectedItem().toString().equals("true") ? 1 : 0)
                .addArg("seed", seed);
        MainFrame.execCommand(this, "Cluster N griph", params);
    }//GEN-LAST:event_S_ClusterNgriph_jButtonActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        S_countTable.setText("");
    }//GEN-LAST:event_jButton40ActionPerformed

    private void S_permAtTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_permAtTimeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_permAtTimeFocusLost

    private void S_permAtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_permAtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_permAtTimeActionPerformed

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

    private void S_seedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_seedFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_seedFocusLost

    private void S_seedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_seedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_seedActionPerformed

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

    private void cDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDockerRadioButtonActionPerformed

    private void S_percentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_percentFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_percentFocusLost

    private void S_percentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_percentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_percentActionPerformed

    private void S_nPermFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_nPermFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_nPermFocusLost

    private void S_nPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_nPermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_nPermActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel S_ClusterNgriphPanel;
    private javax.swing.JButton S_ClusterNgriph_jButton;
    private javax.swing.JTextField S_countTable;
    private javax.swing.JComboBox<String> S_logTen;
    public static javax.swing.JTextField S_nPerm;
    public static javax.swing.JTextField S_percent;
    public static javax.swing.JTextField S_permAtTime;
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
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
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
