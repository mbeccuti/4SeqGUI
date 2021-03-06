/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.nio.file.Paths;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNADownloadData extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212335L;
    /**
     * Creates new form CircRNADownloadData
     */
    public CircRNADownloadData() {
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
        assemblyVersion = new javax.swing.ButtonGroup();
        DownloadDataPanel = new javax.swing.JPanel();
        AssemblyPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        outputFolderTextField = new javax.swing.JTextField();
        browseOutputFolderButton = new javax.swing.JButton();
        cancelOutputFolderButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton1 = new javax.swing.JButton();
        cancelScratchFolderButton1 = new javax.swing.JButton();
        assemblyComboBox = new javax.swing.JComboBox<>();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        DownloadDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Download Exon & Isoform Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(27, 126, 131))); // NOI18N
        DownloadDataPanel.setLayout(new java.awt.GridBagLayout());

        AssemblyPanel.setBackground(new java.awt.Color(248, 248, 248));
        AssemblyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AssemblyPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Assembly version: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Output folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(jLabel2, gridBagConstraints);

        outputFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(outputFolderTextField, gridBagConstraints);

        browseOutputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseOutputFolderButton.setText("Browse");
        browseOutputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseOutputFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(browseOutputFolderButton, gridBagConstraints);

        cancelOutputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelOutputFolderButton.setText("Cancel");
        cancelOutputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOutputFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(cancelOutputFolderButton, gridBagConstraints);

        jLabel3.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(jLabel3, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(scratchFolderTextField, gridBagConstraints);

        browseScratchFolderButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchFolderButton1.setText("Browse");
        browseScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(browseScratchFolderButton1, gridBagConstraints);

        cancelScratchFolderButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchFolderButton1.setText("Cancel");
        cancelScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(cancelScratchFolderButton1, gridBagConstraints);

        assemblyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hg18", "hg19", "hg38", "mm9", "mm10", "rn6", "dm6", "ce11" }));
        assemblyComboBox.setSelectedIndex(1);
        assemblyComboBox.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        AssemblyPanel.add(assemblyComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DownloadDataPanel.add(AssemblyPanel, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 64, 10, 10);
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
        DownloadDataPanel.add(ExecutionPanel, gridBagConstraints);

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
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DownloadDataPanel.add(closeFormPostProcessingButton, gridBagConstraints);

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
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DownloadDataPanel.add(executeFormPostProcessingButton, gridBagConstraints);

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
        DownloadDataPanel.add(resetFormPostProcessingButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(DownloadDataPanel, gridBagConstraints);
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
        String scratchFolder = scratchFolderTextField.getText();
        
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
                "Error: scratch folder", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        ScriptCaller parameters = new ScriptCaller("CircDownloadData.R", outputFolder)
                .addArg("group", execution)
                .addArg("scratch.folder", scratchFolder)
                .addArg("data.folder", outputFolder)
                .addArg("assembly", (String) assemblyComboBox.getSelectedItem()); 
        MainFrame.execCommand(this, "CircRNA prepare files", parameters);
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        outputFolderTextField.setText("");
        scratchFolderTextField.setText("");
        assemblyComboBox.setSelectedIndex(1);
        DockerRadioButton.setSelected(true);
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void browseOutputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseOutputFolderButtonActionPerformed
        MainFrame.browseTextFieldContent(this, outputFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseOutputFolderButtonActionPerformed

    private void cancelOutputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOutputFolderButtonActionPerformed
        outputFolderTextField.setText("");
    }//GEN-LAST:event_cancelOutputFolderButtonActionPerformed

    private void browseScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchFolderButton1ActionPerformed
        MainFrame.browseTextFieldContent(this, scratchFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseScratchFolderButton1ActionPerformed

    private void cancelScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchFolderButton1ActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchFolderButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssemblyPanel;
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel DownloadDataPanel;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JComboBox<String> assemblyComboBox;
    private javax.swing.ButtonGroup assemblyVersion;
    private javax.swing.JButton browseOutputFolderButton;
    private javax.swing.JButton browseScratchFolderButton1;
    private javax.swing.JButton cancelOutputFolderButton;
    private javax.swing.JButton cancelScratchFolderButton1;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField outputFolderTextField;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
