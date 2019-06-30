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
import pkg4seqgui.MainFrame.MyTask;
/**
 *
 * @author user
 */
public class S_10XGenomics_index extends javax.swing.JPanel {

    /**
     * Creates new form S_IndropIndex
     */
    public S_10XGenomics_index() {
        initComponents();
    }
    private static final long serialVersionUID = 67756333334L;
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
        S_indropIndexPanel = new javax.swing.JPanel();
        iCloseButton2 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        iResetButton2 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        S_IndropIndex_indexFolder = new javax.swing.JTextField();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jLabel104 = new javax.swing.JLabel();
        S_indropIndex_EnsembleGenomeUrl = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        S_indropIndex_GTFUrl = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        S_IndropIndex_scratchFolder = new javax.swing.JTextField();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        nThreads = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        iSudoRadioSButton = new javax.swing.JRadioButton();
        iDockerRadioSButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        S_indropIndexPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "10X Genomics indexing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        S_indropIndexPanel.setToolTipText(null);
        S_indropIndexPanel.setLayout(new java.awt.GridBagLayout());

        iCloseButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        iCloseButton2.setText("Close");
        iCloseButton2.setToolTipText(null);
        iCloseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCloseButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_indropIndexPanel.add(iCloseButton2, gridBagConstraints);

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton37.setText("Execute");
        jButton37.setToolTipText(null);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_indropIndexPanel.add(jButton37, gridBagConstraints);

        iResetButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        iResetButton2.setText("Reset");
        iResetButton2.setToolTipText(null);
        iResetButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iResetButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_indropIndexPanel.add(iResetButton2, gridBagConstraints);

        jPanel28.setBackground(new java.awt.Color(248, 248, 248));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel28.setToolTipText(null);
        jPanel28.setLayout(new java.awt.GridBagLayout());

        jLabel103.setText("Genome Folder:");
        jLabel103.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel103, gridBagConstraints);

        S_IndropIndex_indexFolder.setEditable(false);
        S_IndropIndex_indexFolder.setToolTipText(null);
        S_IndropIndex_indexFolder.setSelectionColor(new java.awt.Color(0, 0, 0));
        S_IndropIndex_indexFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_IndropIndex_indexFolderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(S_IndropIndex_indexFolder, gridBagConstraints);

        jToggleButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton30.setText("Browse");
        jToggleButton30.setToolTipText(null);
        jToggleButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton30ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton30, gridBagConstraints);

        jToggleButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton31.setText("Cancel");
        jToggleButton31.setToolTipText(null);
        jToggleButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton31ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton31, gridBagConstraints);

        jLabel104.setText("Ensemble Genome url:");
        jLabel104.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel104, gridBagConstraints);

        S_indropIndex_EnsembleGenomeUrl.setToolTipText("The URL which will be used to download the genome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(S_indropIndex_EnsembleGenomeUrl, gridBagConstraints);

        jLabel105.setText("nThreads:");
        jLabel105.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel105, gridBagConstraints);

        S_indropIndex_GTFUrl.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(S_indropIndex_GTFUrl, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel28.add(jLabel109, gridBagConstraints);

        jLabel107.setText("Scratch Folder:");
        jLabel107.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel107, gridBagConstraints);

        S_IndropIndex_scratchFolder.setEditable(false);
        S_IndropIndex_scratchFolder.setToolTipText(null);
        S_IndropIndex_scratchFolder.setSelectionColor(new java.awt.Color(0, 0, 0));
        S_IndropIndex_scratchFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_IndropIndex_scratchFolderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(S_IndropIndex_scratchFolder, gridBagConstraints);

        jToggleButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton32.setText("Browse");
        jToggleButton32.setToolTipText(null);
        jToggleButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton32ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton32, gridBagConstraints);

        jToggleButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton33.setText("Cancel");
        jToggleButton33.setToolTipText(null);
        jToggleButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton33ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton33, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "protein_coding", "unitary_pseudogene", "unprocessed_pseudogene", "processed_pseudogene", "transcribed_unprocessed_pseudogene", "processed_transcript", "antisense", "transcribed_unitary_pseudogene", "polymorphic_pseudogene", "lincRNA", "sense_intronic", "transcribed_processed_pseudogene", "sense_overlapping", "IG_V_pseudogene", "pseudogene", "TR_V_gene", "3prime_overlapping_ncRNA", "IG_V_gene", "bidirectional_promoter_lncRNA", "snRNA", "miRNA", "misc_RNA", "snoRNA", "rRna", "IG_C_gene", "IG_J_gene", "TR_J_gene", "TR_C_gene", "TR_V_pseudogene", "TR_J_pseudogene", "IG_D_gene", "ribozyme", "IG_C_pseudogene", "TR_D_gene", "TEC", "IG_J_pseudogene", "scRNA", "scaRNA", "vaultRNA", "sRNA", "macro_lncRNA", "non_coding", "IG_pseudogene" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jComboBox1, gridBagConstraints);

        jLabel108.setText("GTF url:");
        jLabel108.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel108, gridBagConstraints);

        nThreads.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(nThreads, gridBagConstraints);

        jLabel110.setText("Bio type:");
        jLabel110.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel110, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_indropIndexPanel.add(jPanel28, gridBagConstraints);

        jPanel29.setBackground(new java.awt.Color(248, 248, 248));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel29.setToolTipText(null);
        jPanel29.setLayout(new java.awt.GridBagLayout());

        jLabel106.setText("Execution:");
        jLabel106.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(jLabel106, gridBagConstraints);

        iSudoRadioSButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(iSudoRadioSButton);
        iSudoRadioSButton.setText("sudo");
        iSudoRadioSButton.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 90, 10, 10);
        jPanel29.add(iSudoRadioSButton, gridBagConstraints);

        iDockerRadioSButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(iDockerRadioSButton);
        iDockerRadioSButton.setSelected(true);
        iDockerRadioSButton.setText("docker");
        iDockerRadioSButton.setToolTipText(null);
        iDockerRadioSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDockerRadioSButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(iDockerRadioSButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_indropIndexPanel.add(jPanel29, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(S_indropIndexPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void iCloseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCloseButton2ActionPerformed
        iResetButton2ActionPerformed(evt); 
        //RESET FIELDS
        MainFrame.setCard(null);
        //    AnalysisTree.clearSelection();
    }//GEN-LAST:event_iCloseButton2ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        String scratchFolder = S_IndropIndex_scratchFolder.getText(), 
               genomeFolder = S_IndropIndex_indexFolder.getText(); 
        String genomeURL = S_indropIndex_EnsembleGenomeUrl.getText().trim(), 
               gtfURL = S_indropIndex_GTFUrl.getText().trim();
        int nthreads; 
        
        if (genomeFolder.isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (genomeURL.isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome URL ","Error: Genome URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (gtfURL.isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an GTF URL ","Error: GTF URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            nthreads = Integer.valueOf(nThreads.getText().trim()); 
            if (nthreads <= 0) {
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                nThreads.requestFocusInWindow();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            nThreads.requestFocusInWindow();
            return;
        }
        
        ScriptCaller params = new ScriptCaller("tenXGenomicsindexing.R", genomeFolder)
                .addArg("group", iSudoRadioSButton.isSelected() ? "sudo" : "docker")
                .addArg("scratch.folder", scratchFolder)
                .addArg("genomeFolder", genomeFolder)
                .addArg("fasta.url", genomeURL)
                .addArg("gtf.url", gtfURL)
                .addArg("bio.type", jComboBox1.getSelectedItem().toString())
                .addArg("nThreads", nthreads);
        MainFrame.execCommand(this, "TenXGenomics indexing", params);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void iResetButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResetButton2ActionPerformed
        iDockerRadioSButton.setSelected(true);
        S_IndropIndex_indexFolder.setText("");
        S_indropIndex_EnsembleGenomeUrl.setText("");
        S_indropIndex_GTFUrl.setText("");
    }//GEN-LAST:event_iResetButton2ActionPerformed

    private void S_IndropIndex_indexFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_IndropIndex_indexFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_IndropIndex_indexFolderActionPerformed

    private void jToggleButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton30ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(S_IndropIndex_indexFolder.getText().equals(""))){
            File file =new File(S_IndropIndex_indexFolder.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }
        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            S_IndropIndex_indexFolder.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton30ActionPerformed

    private void jToggleButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton31ActionPerformed
        S_IndropIndex_indexFolder.setText("");
    }//GEN-LAST:event_jToggleButton31ActionPerformed

    private void iDockerRadioSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDockerRadioSButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDockerRadioSButtonActionPerformed

    private void S_IndropIndex_scratchFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_IndropIndex_scratchFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_IndropIndex_scratchFolderActionPerformed

    private void jToggleButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton32ActionPerformed
  JFileChooser openDir = new JFileChooser();
        if (!(S_IndropIndex_scratchFolder.getText().equals(""))){
            File file =new File(S_IndropIndex_scratchFolder.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }
        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            S_IndropIndex_scratchFolder.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());    }//GEN-LAST:event_jToggleButton32ActionPerformed

    private void jToggleButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton33ActionPerformed
        S_IndropIndex_scratchFolder.setText("");
    }//GEN-LAST:event_jToggleButton33ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField S_IndropIndex_indexFolder;
    private javax.swing.JTextField S_IndropIndex_scratchFolder;
    private javax.swing.JPanel S_indropIndexPanel;
    private javax.swing.JTextField S_indropIndex_EnsembleGenomeUrl;
    private javax.swing.JTextField S_indropIndex_GTFUrl;
    private javax.swing.JButton iCloseButton2;
    private javax.swing.JRadioButton iDockerRadioSButton;
    private javax.swing.JButton iResetButton2;
    private javax.swing.JRadioButton iSudoRadioSButton;
    private javax.swing.JButton jButton37;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.ButtonGroup mExecution;
    private javax.swing.JTextField nThreads;
    // End of variables declaration//GEN-END:variables
}
