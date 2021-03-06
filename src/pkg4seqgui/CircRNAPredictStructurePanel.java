/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNAPredictStructurePanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212337L;
    /**
     * Creates new form CircRNAPredictStructurePanel
     */
    public CircRNAPredictStructurePanel() {
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

        executionGroup = new javax.swing.ButtonGroup();
        StructurePanel = new javax.swing.JPanel();
        PostCiriDataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alignmentDataTextField = new javax.swing.JTextField();
        referencePathTextField = new javax.swing.JTextField();
        browseAlignmentDataButton = new javax.swing.JButton();
        cancelAlignmentDataButton = new javax.swing.JButton();
        browseReferenceButton = new javax.swing.JButton();
        cancelReferenceButton = new javax.swing.JButton();
        browseCircrnaDataButton = new javax.swing.JButton();
        cancelCircrnaDataButton = new javax.swing.JButton();
        circrnaDataTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        annotationDataTextField = new javax.swing.JTextField();
        browseAnnotationFileButton = new javax.swing.JButton();
        cancelAnnotationFileButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton1 = new javax.swing.JButton();
        cancelScratchFolderButton1 = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        StructurePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "CircRNA structure prediction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(182, 2, 252))); // NOI18N
        StructurePanel.setLayout(new java.awt.GridBagLayout());

        PostCiriDataPanel.setBackground(new java.awt.Color(248, 248, 248));
        PostCiriDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PostCiriDataPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("SAM/BAM file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Genome path:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("CircRNA file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel3, gridBagConstraints);

        alignmentDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(alignmentDataTextField, gridBagConstraints);

        referencePathTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(referencePathTextField, gridBagConstraints);

        browseAlignmentDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseAlignmentDataButton.setText("Browse");
        browseAlignmentDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseAlignmentDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseAlignmentDataButton, gridBagConstraints);

        cancelAlignmentDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelAlignmentDataButton.setText("Cancel");
        cancelAlignmentDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAlignmentDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelAlignmentDataButton, gridBagConstraints);

        browseReferenceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseReferenceButton.setText("Browse");
        browseReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseReferenceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseReferenceButton, gridBagConstraints);

        cancelReferenceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelReferenceButton.setText("Cancel");
        cancelReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReferenceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelReferenceButton, gridBagConstraints);

        browseCircrnaDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseCircrnaDataButton.setText("Browse");
        browseCircrnaDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseCircrnaDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseCircrnaDataButton, gridBagConstraints);

        cancelCircrnaDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelCircrnaDataButton.setText("Cancel");
        cancelCircrnaDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCircrnaDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelCircrnaDataButton, gridBagConstraints);

        circrnaDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(circrnaDataTextField, gridBagConstraints);

        jLabel4.setText("Annotation file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel4, gridBagConstraints);

        annotationDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(annotationDataTextField, gridBagConstraints);

        browseAnnotationFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseAnnotationFileButton.setText("Browse");
        browseAnnotationFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseAnnotationFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseAnnotationFileButton, gridBagConstraints);

        cancelAnnotationFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelAnnotationFileButton.setText("Cancel");
        cancelAnnotationFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAnnotationFileButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelAnnotationFileButton, gridBagConstraints);

        jLabel5.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel5, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(scratchFolderTextField, gridBagConstraints);

        browseScratchFolderButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchFolderButton1.setText("Browse");
        browseScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseScratchFolderButton1, gridBagConstraints);

        cancelScratchFolderButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchFolderButton1.setText("Cancel");
        cancelScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelScratchFolderButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        StructurePanel.add(PostCiriDataPanel, gridBagConstraints);

        closeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        closeFormPostProcessingButton.setText("Close");
        closeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        StructurePanel.add(closeFormPostProcessingButton, gridBagConstraints);

        executeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        executeFormPostProcessingButton.setText("Execute");
        executeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        StructurePanel.add(executeFormPostProcessingButton, gridBagConstraints);

        resetFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        resetFormPostProcessingButton.setText("Reset");
        resetFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        StructurePanel.add(resetFormPostProcessingButton, gridBagConstraints);

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
        StructurePanel.add(ExecutionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(StructurePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void browseAlignmentDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseAlignmentDataButtonActionPerformed
        MainFrame.browseTextFieldContent(this, alignmentDataTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseAlignmentDataButtonActionPerformed

    private void cancelAlignmentDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAlignmentDataButtonActionPerformed
        alignmentDataTextField.setText("");
    }//GEN-LAST:event_cancelAlignmentDataButtonActionPerformed

    private void browseReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseReferenceButtonActionPerformed
        MainFrame.browseTextFieldContent(this, referencePathTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseReferenceButtonActionPerformed

    private void cancelReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReferenceButtonActionPerformed
        referencePathTextField.setText("");
    }//GEN-LAST:event_cancelReferenceButtonActionPerformed

    private void browseCircrnaDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseCircrnaDataButtonActionPerformed
        MainFrame.browseTextFieldContent(this, circrnaDataTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseCircrnaDataButtonActionPerformed

    private void cancelCircrnaDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCircrnaDataButtonActionPerformed
        circrnaDataTextField.setText("");
    }//GEN-LAST:event_cancelCircrnaDataButtonActionPerformed

    private void closeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormPostProcessingButtonActionPerformed
        MainFrame.setCard(null);
        resetFormPostProcessingButtonActionPerformed(evt);
    }//GEN-LAST:event_closeFormPostProcessingButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        circrnaDataTextField.setText("");
        referencePathTextField.setText("");
        alignmentDataTextField.setText("");
        annotationDataTextField.setText("");
        scratchFolderTextField.setText("");
        DockerRadioButton.setSelected(true);
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void executeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormPostProcessingButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String alignmentPath = alignmentDataTextField.getText().trim(), 
               circrnaPath = circrnaDataTextField.getText().trim(), 
               referencePath = referencePathTextField.getText().trim(), 
               scratchFolder = scratchFolderTextField.getText().trim(), 
               annotationPath = annotationDataTextField.getText().trim();
        
        if (alignmentPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the SAM/BAM data file.",
                "Error: alignment data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        else if (!alignmentPath.endsWith(".bam") && !alignmentPath.endsWith(".sam")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the SAM/BAM data file.",
                "Error: alignment data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        if (circrnaPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the CircRNA data file.",
                "Error: CircRNA data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (referencePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the reference file.",
                "Error: reference data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (!annotationPath.isEmpty() && !annotationPath.endsWith(".gtf") && !annotationPath.endsWith(".gff")) {
            JOptionPane.showMessageDialog(this, 
                "The annotation file must be a GTF/GFF file.",
                "Error: annotation file", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (scratchFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the scratch folder.",
                "Error: scratch folder", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
              
        if (annotationPath.isEmpty())
            annotationPath = "NA"; 
        
        String outputFolder = Paths.get(circrnaPath).getParent().toString();
        ScriptCaller parameters = new ScriptCaller("CircGetStructure.R", outputFolder)
                .addArg("group", execution)
                .addArg("scratch.folder", scratchFolder)
                .addArg("sam.file", alignmentPath)
                .addArg("ciri.file", circrnaPath)
                .addArg("genome.file", referencePath)
                .addArg("annotation.file", annotationPath);
        MainFrame.execCommand(this, "CircRNA structure prediction", parameters);  
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void browseAnnotationFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseAnnotationFileButtonActionPerformed
        MainFrame.browseTextFieldContent(this, annotationDataTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseAnnotationFileButtonActionPerformed

    private void cancelAnnotationFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAnnotationFileButtonActionPerformed
        annotationDataTextField.setText("");
    }//GEN-LAST:event_cancelAnnotationFileButtonActionPerformed

    private void browseScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchFolderButton1ActionPerformed
        MainFrame.browseTextFieldContent(this, scratchFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseScratchFolderButton1ActionPerformed

    private void cancelScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchFolderButton1ActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchFolderButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JPanel PostCiriDataPanel;
    private javax.swing.JPanel StructurePanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JTextField alignmentDataTextField;
    private javax.swing.JTextField annotationDataTextField;
    private javax.swing.JButton browseAlignmentDataButton;
    private javax.swing.JButton browseAnnotationFileButton;
    private javax.swing.JButton browseCircrnaDataButton;
    private javax.swing.JButton browseReferenceButton;
    private javax.swing.JButton browseScratchFolderButton1;
    private javax.swing.JButton cancelAlignmentDataButton;
    private javax.swing.JButton cancelAnnotationFileButton;
    private javax.swing.JButton cancelCircrnaDataButton;
    private javax.swing.JButton cancelReferenceButton;
    private javax.swing.JButton cancelScratchFolderButton1;
    private javax.swing.JTextField circrnaDataTextField;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField referencePathTextField;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
