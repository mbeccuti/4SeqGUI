/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import javax.swing.JFileChooser;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNAOverlapPredictions extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212341L;
    /**
     * Creates new form CircRNAOverlapPredictions
     */
    public CircRNAOverlapPredictions() {
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

        OverlapPredictionPanel = new javax.swing.JPanel();
        executionPanel = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        parametersPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputFolderTextField = new javax.swing.JTextField();
        browseInputFolderButton = new javax.swing.JButton();
        cancelInputFolderButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        outputFolderTextField = new javax.swing.JTextField();
        browseOutputFolderTextField = new javax.swing.JButton();
        cancelOutputFolderButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        thresholdTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton = new javax.swing.JButton();
        cancelScratchFolderButton = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        OverlapPredictionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Overlap Prediction Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 19, 163))); // NOI18N
        OverlapPredictionPanel.setLayout(new java.awt.GridBagLayout());

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
        OverlapPredictionPanel.add(executionPanel, gridBagConstraints);

        parametersPanel.setBackground(new java.awt.Color(248, 248, 248));
        parametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        parametersPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Input folder: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(jLabel1, gridBagConstraints);

        inputFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(inputFolderTextField, gridBagConstraints);

        browseInputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseInputFolderButton.setText("Browse");
        browseInputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseInputFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(browseInputFolderButton, gridBagConstraints);

        cancelInputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelInputFolderButton.setText("Cancel");
        cancelInputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelInputFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(cancelInputFolderButton, gridBagConstraints);

        jLabel2.setText("Output folder: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(jLabel2, gridBagConstraints);

        outputFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(outputFolderTextField, gridBagConstraints);

        browseOutputFolderTextField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseOutputFolderTextField.setText("Browse");
        browseOutputFolderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseOutputFolderTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(browseOutputFolderTextField, gridBagConstraints);

        cancelOutputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelOutputFolderButton.setText("Cancel");
        cancelOutputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOutputFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(cancelOutputFolderButton, gridBagConstraints);

        jLabel3.setText("Min.support: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(thresholdTextField, gridBagConstraints);

        jLabel4.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(jLabel4, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(scratchFolderTextField, gridBagConstraints);

        browseScratchFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchFolderButton.setText("Browse");
        browseScratchFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(browseScratchFolderButton, gridBagConstraints);

        cancelScratchFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchFolderButton.setText("Cancel");
        cancelScratchFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        parametersPanel.add(cancelScratchFolderButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OverlapPredictionPanel.add(parametersPanel, gridBagConstraints);

        closeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        closeFormPostProcessingButton.setText("Close");
        closeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OverlapPredictionPanel.add(closeFormPostProcessingButton, gridBagConstraints);

        executeFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        executeFormPostProcessingButton.setText("Execute");
        executeFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OverlapPredictionPanel.add(executeFormPostProcessingButton, gridBagConstraints);

        resetFormPostProcessingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        resetFormPostProcessingButton.setText("Reset");
        resetFormPostProcessingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormPostProcessingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OverlapPredictionPanel.add(resetFormPostProcessingButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(OverlapPredictionPanel, gridBagConstraints);
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
        String outputFolder = outputFolderTextField.getText();
        String inputFolder = inputFolderTextField.getText();
        String scratchFolder = scratchFolderTextField.getText();

        if (MainFrame.checkPath(this, outputFolder, "output folder") ||
            MainFrame.checkPath(this, inputFolder, "input folder") || 
            MainFrame.checkPath(this, scratchFolder, "scratch folder"))
        return;
        
        Integer min_support = MainFrame.checkIntValue(this, thresholdTextField.getText(), "minimum support for circRNA"); 
        if (min_support == null)
            return; 

        ScriptCaller parameters = new ScriptCaller("CircOverlap.R", outputFolder)
            .addArg("group", execution)
            .addArg("input", inputFolder)
            .addArg("output", outputFolder)
            .addArg("scratch", scratchFolder)
            .addArg("min_support", min_support);

        MainFrame.execCommand(this, "CircRNA overlap prediction files", parameters);
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        DockerRadioButton.setSelected(true);
        outputFolderTextField.setText("");
        inputFolderTextField.setText("");
        scratchFolderTextField.setText("");
        thresholdTextField.setText("");
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void browseInputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseInputFolderButtonActionPerformed
        MainFrame.browseTextFieldContent(this, inputFolderTextField, JFileChooser.DIRECTORIES_ONLY);  
    }//GEN-LAST:event_browseInputFolderButtonActionPerformed

    private void browseScratchFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchFolderButtonActionPerformed
        MainFrame.browseTextFieldContent(this, scratchFolderTextField, JFileChooser.DIRECTORIES_ONLY);  
    }//GEN-LAST:event_browseScratchFolderButtonActionPerformed

    private void browseOutputFolderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseOutputFolderTextFieldActionPerformed
        MainFrame.browseTextFieldContent(this, outputFolderTextField, JFileChooser.DIRECTORIES_ONLY);          // TODO add your handling code here:
    }//GEN-LAST:event_browseOutputFolderTextFieldActionPerformed

    private void cancelInputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelInputFolderButtonActionPerformed
        inputFolderTextField.setText("");
    }//GEN-LAST:event_cancelInputFolderButtonActionPerformed

    private void cancelScratchFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchFolderButtonActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchFolderButtonActionPerformed

    private void cancelOutputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOutputFolderButtonActionPerformed
        outputFolderTextField.setText("");
    }//GEN-LAST:event_cancelOutputFolderButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel OverlapPredictionPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JButton browseInputFolderButton;
    private javax.swing.JButton browseOutputFolderTextField;
    private javax.swing.JButton browseScratchFolderButton;
    private javax.swing.JButton cancelInputFolderButton;
    private javax.swing.JButton cancelOutputFolderButton;
    private javax.swing.JButton cancelScratchFolderButton;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.JPanel executionPanel;
    private javax.swing.JTextField inputFolderTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField outputFolderTextField;
    private javax.swing.JPanel parametersPanel;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField scratchFolderTextField;
    private javax.swing.JTextField thresholdTextField;
    // End of variables declaration//GEN-END:variables
}
