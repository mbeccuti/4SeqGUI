/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;


import java.io.File;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.layout.VBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class WebBrowser extends javax.swing.JPanel {

    /**
     * Creates new form WebBrowser
     */
    public WebBrowser() {
        initComponents();
    }

    private static final long serialVersionUID = 5778212334L;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        executionMode = new javax.swing.ButtonGroup();
        statusGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sudoRadioButton = new javax.swing.JRadioButton();
        dockerRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        countTableTextField = new javax.swing.JTextField();
        browseCountTable = new javax.swing.JButton();
        cancelCountTable = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        outputFolderTextField = new javax.swing.JTextField();
        browseOutputFolder = new javax.swing.JButton();
        cancelOutputFolder = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        geneListTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        separatorField = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        statusLogRadioButton = new javax.swing.JRadioButton();
        statusRawRadioButton = new javax.swing.JRadioButton();
        browseFilterFile = new javax.swing.JButton();
        cancelFilterFile = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        browseScratch = new javax.swing.JButton();
        cancelScratch = new javax.swing.JButton();
        scratchFolderTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Heatmap creation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(16, 5, 134))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Execution: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel1, gridBagConstraints);

        executionMode.add(sudoRadioButton);
        sudoRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 10);
        jPanel2.add(sudoRadioButton, gridBagConstraints);

        executionMode.add(dockerRadioButton);
        dockerRadioButton.setSelected(true);
        dockerRadioButton.setText("docker");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(dockerRadioButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel2.add(jLabel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Count table:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel2, gridBagConstraints);

        countTableTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(countTableTextField, gridBagConstraints);

        browseCountTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseCountTable.setText("Browse");
        browseCountTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseCountTableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(browseCountTable, gridBagConstraints);

        cancelCountTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelCountTable.setText("Cancel");
        cancelCountTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelCountTableActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(cancelCountTable, gridBagConstraints);

        jLabel3.setText("Output folder:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel3, gridBagConstraints);

        outputFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(outputFolderTextField, gridBagConstraints);

        browseOutputFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseOutputFolder.setText("Browse");
        browseOutputFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseOutputFolderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(browseOutputFolder, gridBagConstraints);

        cancelOutputFolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelOutputFolder.setText("Cancel");
        cancelOutputFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOutputFolderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(cancelOutputFolder, gridBagConstraints);

        jLabel4.setText("Gene list:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel4, gridBagConstraints);

        geneListTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(geneListTextField, gridBagConstraints);

        jLabel5.setText("Separator:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel5, gridBagConstraints);

        separatorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TAB", "COMMA", "SPACE" }));
        separatorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separatorFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(separatorField, gridBagConstraints);

        jLabel6.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel6, gridBagConstraints);

        statusGroup.add(statusLogRadioButton);
        statusLogRadioButton.setSelected(true);
        statusLogRadioButton.setText("Log ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(statusLogRadioButton, gridBagConstraints);

        statusGroup.add(statusRawRadioButton);
        statusRawRadioButton.setText("Raw counts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(statusRawRadioButton, gridBagConstraints);

        browseFilterFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseFilterFile.setText("Browse");
        browseFilterFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFilterFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(browseFilterFile, gridBagConstraints);

        cancelFilterFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelFilterFile.setText("Cancel");
        cancelFilterFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFilterFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(cancelFilterFile, gridBagConstraints);

        jLabel7.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel7, gridBagConstraints);

        browseScratch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratch.setText("Browse");
        browseScratch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(browseScratch, gridBagConstraints);

        cancelScratch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratch.setText("Cancel");
        cancelScratch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(cancelScratch, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(scratchFolderTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jPanel3, gridBagConstraints);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton2, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton3, gridBagConstraints);

        jButton4.setText("Show");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String group = dockerRadioButton.isSelected() ? "docker" : "sudo"; 
        String countTableFile = countTableTextField.getText().trim(); 
        String geneListFile = geneListTextField.getText().trim();
        String outputFolder = outputFolderTextField.getText().trim();
        boolean logStatus = statusLogRadioButton.isSelected();
        String separator = (String) separatorField.getSelectedItem(); 
        String scratchFolder = scratchFolderTextField.getText().trim(); 
        
        if (countTableFile.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the count table file.",
                "Error: count table file", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (geneListFile.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the gene list file .",
                "Error: gene list file", 
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
                "Error: scratch folder", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        ScriptCaller parameters = new ScriptCaller("heatmaply.R", outputFolder)
                .addArg("group", group)
                .addArg("count.table", countTableFile)
                .addArg("gene.list", geneListFile)
                .addArg("output.folder", outputFolder)
                .addArg("scratch.folder", scratchFolder)
                .addArg("status", logStatus ? "log" : "raw")
                .addArg("separator", separator); 
        
        MainFrame.execCommand(this, "Heatmaply generation", parameters);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void browseCountTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseCountTableActionPerformed
        MainFrame.browseTextFieldContent(this, countTableTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseCountTableActionPerformed

    private void cancelCountTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelCountTableActionPerformed
        countTableTextField.setText("");
    }//GEN-LAST:event_cancelCountTableActionPerformed

    private void browseOutputFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseOutputFolderActionPerformed
        MainFrame.browseTextFieldContent(this, outputFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseOutputFolderActionPerformed

    private void cancelOutputFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOutputFolderActionPerformed
        outputFolderTextField.setText("");
    }//GEN-LAST:event_cancelOutputFolderActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MainFrame.setCard(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        countTableTextField.setText("");
        outputFolderTextField.setText("");
        scratchFolderTextField.setText("");
        geneListTextField.setText("");
        separatorField.setSelectedItem("TAB");
        dockerRadioButton.setSelected(true);
        statusLogRadioButton.setSelected(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void separatorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_separatorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_separatorFieldActionPerformed

    private void browseFilterFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFilterFileActionPerformed
        MainFrame.browseTextFieldContent(this, geneListTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseFilterFileActionPerformed

    private void cancelFilterFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFilterFileActionPerformed
        geneListTextField.setText("");
    }//GEN-LAST:event_cancelFilterFileActionPerformed

    private void browseScratchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchActionPerformed
        MainFrame.browseTextFieldContent(this, scratchFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseScratchActionPerformed

    private void cancelScratchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("HTML FILES", "html", "htm");
        String htmlfile = MainFrame.browsePath(this, JFileChooser.FILES_ONLY, filter);
        
        if (htmlfile != null) {
            if (!htmlfile.endsWith(".html")) {
                JOptionPane.showMessageDialog(this, 
                    "You have to specify a HTML file to visualize.",
                    "Error: unsupported file format", 
                    JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            openWebBrowser(htmlfile);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void openWebBrowser(String htmlFile) {
        JFrame jframe = new JFrame("Visualizing " + new File(htmlFile).getName());
        JFXPanel fxPanel = new JFXPanel();
        jframe.add(fxPanel);
        
        jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Platform.setImplicitExit(false); 
        Platform.runLater(() -> {
            VBox root = new VBox();
            WebView webView = new WebView(); 
            
            root.getChildren().add(webView);
            root.setStyle(
              "-fx-padding: 10;-fx-border-style: solid inside;-fx-border-color: blue;" +
              "-fx-border-width: 2;-fx-border-insets: 5;-fx-border-radius: 5;" 
            );
            fxPanel.setScene(new Scene(root));
            
            webView.getEngine().load(String.format("file:///%s", htmlFile));
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseCountTable;
    private javax.swing.JButton browseFilterFile;
    private javax.swing.JButton browseOutputFolder;
    private javax.swing.JButton browseScratch;
    private javax.swing.JButton cancelCountTable;
    private javax.swing.JButton cancelFilterFile;
    private javax.swing.JButton cancelOutputFolder;
    private javax.swing.JButton cancelScratch;
    private javax.swing.JTextField countTableTextField;
    private javax.swing.JRadioButton dockerRadioButton;
    private javax.swing.ButtonGroup executionMode;
    private javax.swing.JTextField geneListTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField outputFolderTextField;
    private javax.swing.JTextField scratchFolderTextField;
    private javax.swing.JComboBox<String> separatorField;
    private javax.swing.ButtonGroup statusGroup;
    private javax.swing.JRadioButton statusLogRadioButton;
    private javax.swing.JRadioButton statusRawRadioButton;
    private javax.swing.JRadioButton sudoRadioButton;
    // End of variables declaration//GEN-END:variables
}
