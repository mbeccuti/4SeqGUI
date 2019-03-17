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
public class S_ScannoByGtf extends javax.swing.JPanel {

    /**
     * Creates new form S_scannobyGtf
     */
    public S_ScannoByGtf() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333338L;
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
        S_LorenzFilterPanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        S_LorenzFilter_jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        S_umiXgene = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        S_ribo = new javax.swing.JComboBox<>();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        S_countTable = new javax.swing.JTextField();
        S_MT = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        S_gtfname = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        S_biotype = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        S_R1 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        S_R2 = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        S_R3 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        S_R4 = new javax.swing.JTextField();
        S_R5 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_LorenzFilterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Annotation and Ribo/Mito filtering", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_LorenzFilterPanel.setToolTipText(null);
        S_LorenzFilterPanel.setLayout(new java.awt.GridBagLayout());

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
        S_LorenzFilterPanel.add(vCloseButton5, gridBagConstraints);

        S_LorenzFilter_jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        S_LorenzFilter_jButton39.setText("Execute");
        S_LorenzFilter_jButton39.setToolTipText(null);
        S_LorenzFilter_jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_LorenzFilter_jButton39ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_LorenzFilterPanel.add(S_LorenzFilter_jButton39, gridBagConstraints);

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
        S_LorenzFilterPanel.add(jButton40, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText(null);
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("UMIs X gene:");
        jLabel120.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel120, gridBagConstraints);

        S_umiXgene.setText("3");
        S_umiXgene.setToolTipText(null);
        S_umiXgene.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_umiXgeneFocusLost(evt);
            }
        });
        S_umiXgene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_umiXgeneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel30.add(S_umiXgene, gridBagConstraints);

        jLabel2.setText("Counts table:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel2, gridBagConstraints);

        S_ribo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_ribo, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jButton30, gridBagConstraints);

        jLabel3.setText("Ribo proteins:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel30.add(S_countTable, gridBagConstraints);

        S_MT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TRUE", "FALSE" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel30.add(S_MT, gridBagConstraints);

        jLabel4.setText("Mito proteins:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel4, gridBagConstraints);

        jLabel121.setText("gtf.name:");
        jLabel121.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel121, gridBagConstraints);

        S_gtfname.setToolTipText(null);
        S_gtfname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_gtfnameFocusLost(evt);
            }
        });
        S_gtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_gtfnameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel30.add(S_gtfname, gridBagConstraints);

        jLabel122.setText("Biotype:");
        jLabel122.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel122, gridBagConstraints);

        S_biotype.setText("protein_coding");
        S_biotype.setToolTipText(null);
        S_biotype.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_biotypeFocusLost(evt);
            }
        });
        S_biotype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_biotypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(S_biotype, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_LorenzFilterPanel.add(jPanel30, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel123.setText("Ribosomal % Start:");
        jLabel123.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel123, gridBagConstraints);

        S_R1.setText("20");
        S_R1.setToolTipText(null);
        S_R1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_R1FocusLost(evt);
            }
        });
        S_R1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_R1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 21, 10, 10);
        jPanel2.add(S_R1, gridBagConstraints);

        jLabel124.setText("Ribosomal % End:");
        jLabel124.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel124, gridBagConstraints);

        S_R2.setText("70");
        S_R2.setToolTipText(null);
        S_R2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_R2FocusLost(evt);
            }
        });
        S_R2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_R2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(S_R2, gridBagConstraints);

        jLabel125.setText("Mitochondrial % Start:");
        jLabel125.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel125, gridBagConstraints);

        S_R3.setText("1");
        S_R3.setToolTipText(null);
        S_R3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_R3FocusLost(evt);
            }
        });
        S_R3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_R3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 21, 10, 10);
        jPanel2.add(S_R3, gridBagConstraints);

        jLabel126.setText("Genes Threshold");
        jLabel126.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel126, gridBagConstraints);

        S_R4.setText("100");
        S_R4.setToolTipText(null);
        S_R4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_R4FocusLost(evt);
            }
        });
        S_R4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_R4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(S_R4, gridBagConstraints);

        S_R5.setText("250");
        S_R5.setToolTipText(null);
        S_R5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                S_R5FocusLost(evt);
            }
        });
        S_R5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_R5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(S_R5, gridBagConstraints);

        jLabel127.setText("Mitochondrial % End:");
        jLabel127.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel127, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_LorenzFilterPanel.add(jPanel2, gridBagConstraints);

        jPanel31.setBackground(new java.awt.Color(248, 248, 248));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel31.setToolTipText(null);
        jPanel31.setLayout(new java.awt.GridBagLayout());

        jLabel113.setText("Execution:");
        jLabel113.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(jLabel113, gridBagConstraints);

        cSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(cSudoRadioButton);
        cSudoRadioButton.setText("sudo");
        cSudoRadioButton.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 92, 10, 10);
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
        gridBagConstraints.gridx = 2;
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
        S_LorenzFilterPanel.add(jPanel31, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(S_LorenzFilterPanel, gridBagConstraints);
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

    private void S_LorenzFilter_jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_LorenzFilter_jButton39ActionPerformed

        //Field check

        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execScannoByGtf.sh "};
            if (cSudoRadioButton.isSelected()){
                cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                cmd[2]+= "group=\\\"docker\\\"";
            }

            cmd[2]+=" file=\\\""+S_countTable.getText()+"\\\"";
            cmd[2]+=" gtf.name=\\\""+S_gtfname.getText()+"\\\"";
            cmd[2]+=" biotype=\\\""+S_biotype.getText()+"\\\"";
            cmd[2]+=" umiXgene=\\\""+S_umiXgene.getText()+"\\\"";
            cmd[2]+=" ribo.proteins=\\\""+S_ribo.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" mt=\\\""+S_MT.getSelectedItem().toString()+"\\\"";
            cmd[2]+=" R1=\\\""+S_R1.getText()+"\\\"";
            cmd[2]+=" R2=\\\""+S_R2.getText()+"\\\"";
            cmd[2]+=" R3=\\\""+S_R3.getText()+"\\\"";
            cmd[2]+=" R4=\\\""+S_R4.getText()+"\\\"";
            cmd[2]+=" thresholdGenes=\\\""+S_R5.getText()+"\\\"";


            Path p = Paths.get(S_countTable.getText());
            Path folder = p.getParent();

            cmd[2]+=" "+ folder.toString()+" >& "+folder.toString()+"/outputExecution ";

            //ProcessStatus.setText(pr.toString());
            if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("ScannoByGtf ", folder.toString(),pr,MainFrame.listModel.getSize());
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
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("ScannoByGtf ",folder.toString(),cmd,MainFrame.listModel.getSize());
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
        JOptionPane.showMessageDialog(this, "ScannoByGtf task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);

        //execute code
    }//GEN-LAST:event_S_LorenzFilter_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        S_countTable.setText("");
    }//GEN-LAST:event_jButton40ActionPerformed

    private void S_umiXgeneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_umiXgeneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_umiXgeneFocusLost

    private void S_umiXgeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_umiXgeneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_umiXgeneActionPerformed

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

    private void S_gtfnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_gtfnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_gtfnameFocusLost

    private void S_gtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_gtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_gtfnameActionPerformed

    private void S_biotypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_biotypeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_biotypeFocusLost

    private void S_biotypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_biotypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_biotypeActionPerformed

    private void S_R1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_R1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R1FocusLost

    private void S_R1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_R1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R1ActionPerformed

    private void S_R2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_R2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R2FocusLost

    private void S_R2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_R2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R2ActionPerformed

    private void S_R3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_R3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R3FocusLost

    private void S_R3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_R3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R3ActionPerformed

    private void S_R4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_R4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R4FocusLost

    private void S_R4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_R4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R4ActionPerformed

    private void S_R5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_S_R5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R5FocusLost

    private void S_R5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_R5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_R5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel S_LorenzFilterPanel;
    private javax.swing.JButton S_LorenzFilter_jButton39;
    private javax.swing.JComboBox<String> S_MT;
    public static javax.swing.JTextField S_R1;
    public static javax.swing.JTextField S_R2;
    public static javax.swing.JTextField S_R3;
    public static javax.swing.JTextField S_R4;
    public static javax.swing.JTextField S_R5;
    public static javax.swing.JTextField S_biotype;
    private javax.swing.JTextField S_countTable;
    public static javax.swing.JTextField S_gtfname;
    private javax.swing.JComboBox<String> S_ribo;
    public static javax.swing.JTextField S_umiXgene;
    private javax.swing.JRadioButton cDockerRadioButton;
    private javax.swing.JRadioButton cSudoRadioButton;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton40;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.ButtonGroup mExecution;
    private javax.swing.JButton vCloseButton5;
    // End of variables declaration//GEN-END:variables
}
