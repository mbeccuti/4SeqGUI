/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicola Licheri
 */
public class CircRNABSJunctionsPanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212333L;
    /**
     * Creates new form CircRNA_BSJunctionsPanel
     */
    public CircRNABSJunctionsPanel() {
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
        BSJunctionPanel = new javax.swing.JPanel();
        PostCiriDataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exonDataTextField = new javax.swing.JTextField();
        isoformDataTextField = new javax.swing.JTextField();
        browseExonDataButton = new javax.swing.JButton();
        cancelExonDataButton = new javax.swing.JButton();
        browseIsoformDataButton = new javax.swing.JButton();
        cancelIsoformDataButton = new javax.swing.JButton();
        browseCircrnaDataButton = new javax.swing.JButton();
        cancelCircrnaDataButton = new javax.swing.JButton();
        circrnaDataTextField = new javax.swing.JTextField();
        buttonAssembly_hg19 = new javax.swing.JRadioButton();
        buttonAssembly_hg18 = new javax.swing.JRadioButton();
        buttonAssembly_hg38 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton1 = new javax.swing.JButton();
        cancelScratchFolderButton1 = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        BSJunctionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Backsplicing junctions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(249, 119, 8))); // NOI18N
        BSJunctionPanel.setLayout(new java.awt.GridBagLayout());

        PostCiriDataPanel.setBackground(new java.awt.Color(248, 248, 248));
        PostCiriDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PostCiriDataPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Exon file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Isoform file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("CircRNA file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel3, gridBagConstraints);

        exonDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(exonDataTextField, gridBagConstraints);

        isoformDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(isoformDataTextField, gridBagConstraints);

        browseExonDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseExonDataButton.setText("Browse");
        browseExonDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseExonDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseExonDataButton, gridBagConstraints);

        cancelExonDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelExonDataButton.setText("Cancel");
        cancelExonDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelExonDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelExonDataButton, gridBagConstraints);

        browseIsoformDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseIsoformDataButton.setText("Browse");
        browseIsoformDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseIsoformDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseIsoformDataButton, gridBagConstraints);

        cancelIsoformDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelIsoformDataButton.setText("Cancel");
        cancelIsoformDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelIsoformDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelIsoformDataButton, gridBagConstraints);

        browseCircrnaDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseCircrnaDataButton.setText("Browse");
        browseCircrnaDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseCircrnaDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelCircrnaDataButton, gridBagConstraints);

        circrnaDataTextField.setEditable(false);
        circrnaDataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circrnaDataTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(circrnaDataTextField, gridBagConstraints);

        assemblyVersion.add(buttonAssembly_hg19);
        buttonAssembly_hg19.setSelected(true);
        buttonAssembly_hg19.setText("hg19");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(buttonAssembly_hg19, gridBagConstraints);

        assemblyVersion.add(buttonAssembly_hg18);
        buttonAssembly_hg18.setText("hg18");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(buttonAssembly_hg18, gridBagConstraints);

        assemblyVersion.add(buttonAssembly_hg38);
        buttonAssembly_hg38.setText("hg38");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(buttonAssembly_hg38, gridBagConstraints);

        jLabel4.setText("Assembly:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel5, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
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
        gridBagConstraints.gridy = 5;
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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelScratchFolderButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        BSJunctionPanel.add(PostCiriDataPanel, gridBagConstraints);

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        BSJunctionPanel.add(closeFormPostProcessingButton, gridBagConstraints);

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
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        BSJunctionPanel.add(executeFormPostProcessingButton, gridBagConstraints);

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
        BSJunctionPanel.add(resetFormPostProcessingButton, gridBagConstraints);

        ExecutionPanel.setBackground(new java.awt.Color(248, 248, 248));
        ExecutionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ExecutionPanel.setToolTipText(null);
        ExecutionPanel.setLayout(new java.awt.GridBagLayout());

        jLabel144.setText("Execution:");
        jLabel144.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(jLabel144, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 95, 10, 10);
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
        BSJunctionPanel.add(ExecutionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(BSJunctionPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void browseExonDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseExonDataButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(exonDataTextField.getText().equals(""))){
            File file =new File(exonDataTextField.getText());
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
            exonDataTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseExonDataButtonActionPerformed

    private void cancelExonDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelExonDataButtonActionPerformed
        exonDataTextField.setText("");
    }//GEN-LAST:event_cancelExonDataButtonActionPerformed

    private void browseIsoformDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseIsoformDataButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(isoformDataTextField.getText().equals(""))){
            File file =new File(isoformDataTextField.getText());
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
            isoformDataTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseIsoformDataButtonActionPerformed

    private void cancelIsoformDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelIsoformDataButtonActionPerformed
        isoformDataTextField.setText("");
    }//GEN-LAST:event_cancelIsoformDataButtonActionPerformed

    private void browseCircrnaDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseCircrnaDataButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(circrnaDataTextField.getText().equals(""))){
            File file =new File(circrnaDataTextField.getText());
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
            circrnaDataTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseCircrnaDataButtonActionPerformed

    private void cancelCircrnaDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCircrnaDataButtonActionPerformed
        circrnaDataTextField.setText("");
    }//GEN-LAST:event_cancelCircrnaDataButtonActionPerformed

    private void closeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormPostProcessingButtonActionPerformed
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";

        resetFormPostProcessingButtonActionPerformed(evt);
    }//GEN-LAST:event_closeFormPostProcessingButtonActionPerformed

    private void resetFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormPostProcessingButtonActionPerformed
        circrnaDataTextField.setText("");
        isoformDataTextField.setText("");
        exonDataTextField.setText("");
        scratchFolderTextField.setText("");
        buttonAssembly_hg19.setSelected(true);

    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void circrnaDataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circrnaDataTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_circrnaDataTextFieldActionPerformed

    private void executeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormPostProcessingButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String exonPath = exonDataTextField.getText(), 
               isoformPath = isoformDataTextField.getText(), 
               circrnaPath = circrnaDataTextField.getText(), 
               scratchFolder = scratchFolderTextField.getText(); 
        String assembly; 
        
        if (exonPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the exon data file.",
                "Error: exon data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (isoformPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the isoform data file.",
                "Error: RNA-seq data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (circrnaPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the CircRNA data file.",
                "Error: CircRNA data", 
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
        
        assembly = "hg19"; 
        
        if (!buttonAssembly_hg19.isSelected())
            assembly = buttonAssembly_hg18.isSelected() ? "hg18" : "hg38";      
        
        String command = String.format(
            "group='%s' scratch.folder='%s' circrna.data='%s' " + 
            "exon.data='%s' assembly='%s'", 
            execution, scratchFolder, circrnaPath, exonPath, assembly)
                .replace("'", "\\\""); 
    
        Path p = Paths.get(circrnaPath);
        Path folder = p.getParent();
        
        MainFrame.execCommand(this, "CircRNA bs-junctions", "execCircRNABSJunctions.sh", command, folder.toString());
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void browseScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchFolderButton1ActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(scratchFolderTextField.getText().equals(""))){
            File file =new File(scratchFolderTextField.getText());
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
            scratchFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseScratchFolderButton1ActionPerformed

    private void cancelScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchFolderButton1ActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchFolderButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BSJunctionPanel;
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JPanel PostCiriDataPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.ButtonGroup assemblyVersion;
    private javax.swing.JButton browseCircrnaDataButton;
    private javax.swing.JButton browseExonDataButton;
    private javax.swing.JButton browseIsoformDataButton;
    private javax.swing.JButton browseScratchFolderButton1;
    private javax.swing.JRadioButton buttonAssembly_hg18;
    private javax.swing.JRadioButton buttonAssembly_hg19;
    private javax.swing.JRadioButton buttonAssembly_hg38;
    private javax.swing.JButton cancelCircrnaDataButton;
    private javax.swing.JButton cancelExonDataButton;
    private javax.swing.JButton cancelIsoformDataButton;
    private javax.swing.JButton cancelScratchFolderButton1;
    private javax.swing.JTextField circrnaDataTextField;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JTextField exonDataTextField;
    private javax.swing.JTextField isoformDataTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
