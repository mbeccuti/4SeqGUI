/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNAWrapperSTARChip extends javax.swing.JPanel {

    /**
     * Creates new form CircRNAWrapperSTARChip
     */
    public CircRNAWrapperSTARChip() {
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

        wrapperSTARChipPanel = new javax.swing.JPanel();
        executionPanel = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        IOPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputFolderTextField = new javax.swing.JTextField();
        browseInputFolderButton = new javax.swing.JButton();
        cancelInputFolderButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseGenomeFolder = new javax.swing.JButton();
        cancelGenomeFolder = new javax.swing.JButton();
        genomeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        browseScratchFolder = new javax.swing.JButton();
        cancelScratchFolderButton = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();
        parametersPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        min_overlap_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        min_overhang_TF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        min_subj_cpm_TF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        min_subj_limit_TF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cpm_cutoff_TF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        reads_cutoff_TF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        annotationCheckBox = new javax.swing.JCheckBox();
        do_spliceCheckBox = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        wrapperSTARChipPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "STAR Alignment & circRNA prediction using STARChip", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 19, 163))); // NOI18N
        wrapperSTARChipPanel.setLayout(new java.awt.GridBagLayout());

        executionPanel.setBackground(new java.awt.Color(248, 248, 248));
        executionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        executionPanel.setLayout(new java.awt.GridBagLayout());

        jLabel149.setText("Execution:");
        jLabel149.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        executionPanel.add(jLabel149, gridBagConstraints);

        SudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        SudoRadioButton.setText("sudo");
        SudoRadioButton.setToolTipText(null);
        SudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 10);
        executionPanel.add(SudoRadioButton, gridBagConstraints);

        DockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DockerRadioButton.setSelected(true);
        DockerRadioButton.setText("docker");
        DockerRadioButton.setToolTipText(null);
        DockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        executionPanel.add(DockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(executionPanel, gridBagConstraints);

        IOPanel.setBackground(new java.awt.Color(248, 248, 248));
        IOPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        IOPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Samples folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(jLabel1, gridBagConstraints);

        inputFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(inputFolderTextField, gridBagConstraints);

        browseInputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseInputFolderButton.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(browseInputFolderButton, gridBagConstraints);

        cancelInputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelInputFolderButton.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(cancelInputFolderButton, gridBagConstraints);

        jLabel2.setText("Genome folder: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(jLabel2, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(scratchFolderTextField, gridBagConstraints);

        browseGenomeFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseGenomeFolder.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(browseGenomeFolder, gridBagConstraints);

        cancelGenomeFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelGenomeFolder.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(cancelGenomeFolder, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(genomeTextField, gridBagConstraints);

        jLabel3.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(jLabel3, gridBagConstraints);

        browseScratchFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchFolder.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(browseScratchFolder, gridBagConstraints);

        cancelScratchFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchFolderButton.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOPanel.add(cancelScratchFolderButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(IOPanel, gridBagConstraints);

        closeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        closeFormPostProcessingButton.setText("Close");
        closeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(closeFormPostProcessingButton, gridBagConstraints);

        executeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        executeFormPostProcessingButton.setText("Execute");
        executeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(executeFormPostProcessingButton, gridBagConstraints);

        resetFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        resetFormPostProcessingButton.setText("Reset");
        resetFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(resetFormPostProcessingButton, gridBagConstraints);

        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        parametersPanel.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "STAR Chimeric parameters", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(154, 24, 24))); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("min. overlap: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(min_overlap_TF, gridBagConstraints);

        jLabel6.setText("min. overhang: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(min_overhang_TF, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        parametersPanel.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(248, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "STARChip Parameters", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(154, 24, 24))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(min_subj_cpm_TF, gridBagConstraints);

        jLabel7.setText("min. subject limit: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(min_subj_limit_TF, gridBagConstraints);

        jLabel8.setText("min. subject CPM: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(cpm_cutoff_TF, gridBagConstraints);

        jLabel9.setText("CPM cutoff: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel3.add(reads_cutoff_TF, gridBagConstraints);

        jLabel10.setText("reads cutoff:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(jLabel10, gridBagConstraints);

        annotationCheckBox.setText("circRNAs are provided w/ annot.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(annotationCheckBox, gridBagConstraints);

        do_spliceCheckBox.setText("Do Splice");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel3.add(do_spliceCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        parametersPanel.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        wrapperSTARChipPanel.add(parametersPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(wrapperSTARChipPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void closeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormPostProcessingButtonActionPerformed
        MainFrame.setCard(null);
        resetFormPostProcessingButtonActionPerformed(evt);
    }//GEN-LAST:event_closeFormPostProcessingButtonActionPerformed

    private void executeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormPostProcessingButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String scratchFolder = scratchFolderTextField.getText();
        String samplesFolder = inputFolderTextField.getText();
        String genomeFolder = genomeTextField.getText();

        if (true) return; //temporarily disabled
        
        if (MainFrame.checkPath(this, scratchFolder, "scratch folder") ||
            MainFrame.checkPath(this, genomeFolder, "genome folder") ||
            MainFrame.checkPath(this, samplesFolder, "samples folder"))
        return;
        
        Integer nthreads = 8; 
        Integer chim_segment = MainFrame.checkIntValue(this, min_overlap_TF.getText(), "minimum length of the overlap");
        Integer chim_overhang = MainFrame.checkIntValue(this, min_overhang_TF.getText(), "minimum overhang for a chimeric junction");
        Integer reads_cutoff = MainFrame.checkIntValue(this, reads_cutoff_TF.getText(), "reads cutoff");
        Integer subj_limit = MainFrame.checkIntValue(this, min_subj_limit_TF.getText(), "minimum #individuals with reads cutoff");
        Integer subj_cpm = MainFrame.checkIntValue(this, min_subj_cpm_TF.getText(), "lower limit #individuals with cpm cutoff");
        Float cpm_cutoff = MainFrame.checkFloatValue(this, cpm_cutoff_TF.getText(), "CPM cutoff");
        
        Object []asca = {nthreads, chim_segment, chim_overhang, reads_cutoff, subj_limit, subj_cpm, cpm_cutoff};
        for (Object o: asca)
            if (o == null) 
                return;
        
        ScriptCaller parameters = new ScriptCaller("CircSTAR.R", samplesFolder)
            .addArg("group", execution)
            .addArg("samples", samplesFolder)
            .addArg("genome", genomeFolder)
            .addArg("scratch", scratchFolder)
            .addArg("nthreads", nthreads)
            .addArg("chim_segment", chim_segment)
            .addArg("chim_overhang", chim_overhang)
            .addArg("reads_cutoff", reads_cutoff)
            .addArg("min_subjects", subj_limit)
            .addArg("do_splice", do_spliceCheckBox.isSelected())
            .addArg("cpm_cutoff", cpm_cutoff)
            .addArg("subject_cpm", subj_cpm)
            .addArg("annotation", annotationCheckBox.isSelected()); 
            

        MainFrame.execCommand(this, "CircRNA prediction using STAR", parameters);
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        DockerRadioButton.setSelected(true);
        scratchFolderTextField.setText("");
        inputFolderTextField.setText("");
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel IOPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JCheckBox annotationCheckBox;
    private javax.swing.JButton browseGenomeFolder;
    private javax.swing.JButton browseInputFolderButton;
    private javax.swing.JButton browseScratchFolder;
    private javax.swing.JButton cancelGenomeFolder;
    private javax.swing.JButton cancelInputFolderButton;
    private javax.swing.JButton cancelScratchFolderButton;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JTextField cpm_cutoff_TF;
    private javax.swing.JCheckBox do_spliceCheckBox;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.JPanel executionPanel;
    private javax.swing.JTextField genomeTextField;
    private javax.swing.JTextField inputFolderTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField min_overhang_TF;
    private javax.swing.JTextField min_overlap_TF;
    private javax.swing.JTextField min_subj_cpm_TF;
    private javax.swing.JTextField min_subj_limit_TF;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JTextField reads_cutoff_TF;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField scratchFolderTextField;
    private javax.swing.JPanel wrapperSTARChipPanel;
    // End of variables declaration//GEN-END:variables
}
