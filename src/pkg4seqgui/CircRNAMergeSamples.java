/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNAMergeSamples extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212336L;
    
    private class TableEntry {
        public final String sample; 
        public final int group; 
        public final int replicate; 
        
        public TableEntry(String sample, int group, int rep) {
            this.sample = sample;
            this.group = group; 
            this.replicate = rep; 
        }
    }
    
    /**
     * Creates new form CircRNAMergeSamples
     */
    public CircRNAMergeSamples() {
        initComponents();
        Dimension d=new Dimension(40,60);
        samplesGroupsTable.setPreferredSize(d);
                //setPreferredSize( 40, 60 );
        //.setSize(d);
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

        executionGroup = new javax.swing.ButtonGroup();
        CircRNAMergePanel = new javax.swing.JPanel();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        SamplesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        samplesGroupsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        browseSamplesFolderButton = new javax.swing.JButton();
        cancelSamplesFolderButton = new javax.swing.JButton();
        samplesFolderTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        outputFolderTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        FilterCircRNAsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        minReadsTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        minReplicatesTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        minAverageTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        CircRNAMergePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Merge CIRI2 output files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(58, 140, 44))); // NOI18N
        CircRNAMergePanel.setLayout(new java.awt.GridBagLayout());

        ExecutionPanel.setBackground(new java.awt.Color(248, 248, 248));
        ExecutionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ExecutionPanel.setToolTipText(null);
        ExecutionPanel.setLayout(new java.awt.GridBagLayout());

        jLabel149.setText("Execution:");
        jLabel149.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(jLabel149, gridBagConstraints);

        SudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        executionGroup.add(SudoRadioButton);
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
        gridBagConstraints.insets = new java.awt.Insets(10, 45, 10, 10);
        ExecutionPanel.add(SudoRadioButton, gridBagConstraints);

        DockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        executionGroup.add(DockerRadioButton);
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
        ExecutionPanel.add(DockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(ExecutionPanel, gridBagConstraints);

        SamplesPanel.setBackground(new java.awt.Color(248, 248, 248));
        SamplesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        SamplesPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(253, 403));

        samplesGroupsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sample", "Group", "Replicate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        samplesGroupsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(samplesGroupsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jScrollPane1, gridBagConstraints);

        jLabel1.setText("Samples folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jLabel1, gridBagConstraints);

        browseSamplesFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseSamplesFolderButton.setText("Browse");
        browseSamplesFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSamplesFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(browseSamplesFolderButton, gridBagConstraints);

        cancelSamplesFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelSamplesFolderButton.setText("Cancel");
        cancelSamplesFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSamplesFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(cancelSamplesFolderButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(samplesFolderTextField, gridBagConstraints);

        jLabel2.setText("Output folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jLabel2, gridBagConstraints);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jButton1, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jButton2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(outputFolderTextField, gridBagConstraints);

        jLabel6.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(scratchFolderTextField, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jButton3, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SamplesPanel.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(SamplesPanel, gridBagConstraints);

        resetFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        resetFormPostProcessingButton.setText("Reset");
        resetFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(resetFormPostProcessingButton, gridBagConstraints);

        executeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        executeFormPostProcessingButton.setText("Execute");
        executeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(executeFormPostProcessingButton, gridBagConstraints);

        closeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        closeFormPostProcessingButton.setText("Close");
        closeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(closeFormPostProcessingButton, gridBagConstraints);

        FilterCircRNAsPanel.setBackground(new java.awt.Color(248, 248, 248));
        FilterCircRNAsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Filter parameters", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(77, 160, 73))); // NOI18N
        FilterCircRNAsPanel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("min reads: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(minReadsTextField, gridBagConstraints);

        jLabel4.setText("min. replicates");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(minReplicatesTextField, gridBagConstraints);

        jLabel5.setText("min. avg");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(jLabel5, gridBagConstraints);

        minAverageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minAverageTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FilterCircRNAsPanel.add(minAverageTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CircRNAMergePanel.add(FilterCircRNAsPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(CircRNAMergePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        outputFolderTextField.setText("");
        samplesFolderTextField.setText("");
        scratchFolderTextField.setText("");
//        hg19AssemblyButton.setSelected(true);
        DockerRadioButton.setSelected(true);
        clearSamplesGroupsTable();
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void executeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormPostProcessingButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String outputFolder = outputFolderTextField.getText(),
               samplesFolder = samplesFolderTextField.getText(), 
               scratchFolder = scratchFolderTextField.getText();
        int min_reads, min_reps, min_avg; 
        
        
        if (samplesFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "You have to specify the input folder.",
                "Error: samples folder",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (outputFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "You have to specify the output folder.",
                "Error: output folder",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (scratchFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "You have to specify the scratch folder.",
                "Error: output folder",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try {
            min_reads = Integer.parseInt(minReadsTextField.getText()); 
            
            if (min_reads < 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The minimum number of reads must be a positive integer value.",
                "Error: min. number of reads", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        try {
            min_reps = Integer.parseInt(minReplicatesTextField.getText()); 
            
            if (min_reps < 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The minimum number of replicates must be a positive integer value.",
                "Error: min. number of replicates", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        try {
            min_avg = Integer.parseInt(minAverageTextField.getText()); 
            
            if (min_avg < 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The minimum average must be a positive integer value.",
                "Error: min. average", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
     

        String samples = ""; 
        String covariates = ""; 
        int counter = 0; 
        
        
        for (TableEntry te: getDataFromTable()) 
            if (te.group != 0) {
                samples += te.sample + " "; 
                covariates += te.group + " ";
                
                counter++; 
            }
        
        if (counter == 0) {
            JOptionPane.showMessageDialog(this,
                "You have to specify at least one sample.",
                "Error: samples",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
 
        String command = String.format(
            "group='%s' scratch.folder='%s' data.folder='%s' " + 
            "samples='%s' covariates='%s' min_reads=%d min_reps=%d min_avg=%d", 
             execution, scratchFolder, samplesFolder, samples, covariates, 
             min_reads, min_reps, min_avg)
                .replace("'", "\\\""); 

        Path p = Paths.get(outputFolder);
        Path folder = p.getParent();
        
        MainFrame.execCommand(this, "CircRNA merge CIRI2 files", "execCircMergeSamples.sh", command, outputFolder);
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void closeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormPostProcessingButtonActionPerformed
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";

        resetFormPostProcessingButtonActionPerformed(evt);
    }//GEN-LAST:event_closeFormPostProcessingButtonActionPerformed

    private void cancelSamplesFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSamplesFolderButtonActionPerformed
        samplesFolderTextField.setText("");
        clearSamplesGroupsTable();
    }//GEN-LAST:event_cancelSamplesFolderButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        outputFolderTextField.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void browseSamplesFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSamplesFolderButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!samplesFolderTextField.getText().isEmpty()){
            File file =new File(samplesFolderTextField.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            samplesFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
        
        fillSamplesGroupsTable(samplesFolderTextField.getText());
    }//GEN-LAST:event_browseSamplesFolderButtonActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(outputFolderTextField.getText().equals(""))){
            File file =new File(outputFolderTextField.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            outputFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void minAverageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minAverageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minAverageTextFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(outputFolderTextField.getText().equals(""))){
            File file =new File(outputFolderTextField.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            outputFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
   
    private ArrayList<TableEntry> getDataFromTable() {
        ArrayList<TableEntry> data = new ArrayList<TableEntry>();
        String sample; 
        int group; 
        
        for (int i = 0; i < samplesGroupsTable.getRowCount(); i++) {
            sample = (String) samplesGroupsTable.getValueAt(i, 0); 
            group = (int) samplesGroupsTable.getValueAt(i, 1); 
            
            data.add(new TableEntry(sample, group, -1));
        }
        
        return data; 
    }
    
    
    private void clearSamplesGroupsTable() {
        DefaultTableModel model = (DefaultTableModel) samplesGroupsTable.getModel();
        
        model.setNumRows(0);
    }
    
    private void fillSamplesGroupsTable(String samplesFolderPath) {
        DefaultTableModel model = (DefaultTableModel) samplesGroupsTable.getModel();
        
        
        for (final File fileEntry: new File(samplesFolderPath).listFiles()) {
            if (fileEntry.isDirectory()) {
                for (final File content: fileEntry.listFiles()) {
                    if (content.getName().endsWith(".ciri")) {
                        model.addRow(new Object[]{content.getName(), 0, 0});
                    }
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CircRNAMergePanel;
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JPanel FilterCircRNAsPanel;
    private javax.swing.JPanel SamplesPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JButton browseSamplesFolderButton;
    private javax.swing.JButton cancelSamplesFolderButton;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField minAverageTextField;
    private javax.swing.JTextField minReadsTextField;
    private javax.swing.JTextField minReplicatesTextField;
    private javax.swing.JTextField outputFolderTextField;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField samplesFolderTextField;
    private javax.swing.JTable samplesGroupsTable;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
