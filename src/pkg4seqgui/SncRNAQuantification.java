/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicola Licheri
 */
public class SncRNAQuantification extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212351L;

    /**
     * Creates new form MiRNAIndexing
     */
    public SncRNAQuantification() {
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
        modeGroup = new javax.swing.ButtonGroup();
        mirnaQuantificationPanel = new javax.swing.JPanel();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        numThreadsTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        modeMiRNAButton = new javax.swing.JRadioButton();
        modeNcRNAButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        genomeFolderTextField = new javax.swing.JTextField();
        scratchFolderTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        browseGenomeButton = new javax.swing.JButton();
        cancelGenomeButton = new javax.swing.JButton();
        browseScratchButton = new javax.swing.JButton();
        cancelScratchButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fastqFolderTextField = new javax.swing.JTextField();
        browseFastqFolderButton = new javax.swing.JButton();
        cancelFastqFolderButton = new javax.swing.JButton();
        executeFormMiRNAQuantificationButton = new javax.swing.JButton();
        resetFormMiRNAQuantificationButton = new javax.swing.JButton();
        closeFormMiRNAQuantificationButton = new javax.swing.JButton();
        mirnaParametersPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mirbaseVersionTextField = new javax.swing.JTextField();
        mirbaseSpeciesTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        mirnaQuantificationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "miRNA quantification", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(53, 73, 161))); // NOI18N
        mirnaQuantificationPanel.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(DockerRadioButton, gridBagConstraints);

        jLabel5.setText("Num. threads: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(numThreadsTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 10.0;
        ExecutionPanel.add(jLabel7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(ExecutionPanel, gridBagConstraints);

        inputPanel.setBackground(new java.awt.Color(248, 248, 248));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        inputPanel.setLayout(new java.awt.GridBagLayout());

        modeGroup.add(modeMiRNAButton);
        modeMiRNAButton.setSelected(true);
        modeMiRNAButton.setText("miRNA");
        modeMiRNAButton.setName("mirna"); // NOI18N
        modeMiRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeMiRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(modeMiRNAButton, gridBagConstraints);

        modeGroup.add(modeNcRNAButton);
        modeNcRNAButton.setText("ncRNA");
        modeNcRNAButton.setName("ncrna"); // NOI18N
        modeNcRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeNcRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(modeNcRNAButton, gridBagConstraints);

        jLabel1.setText("Mode:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(jLabel1, gridBagConstraints);

        genomeFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(genomeFolderTextField, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(scratchFolderTextField, gridBagConstraints);

        jLabel2.setText("Scratch folder: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(jLabel2, gridBagConstraints);

        browseGenomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseGenomeButton.setText("Browse");
        browseGenomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseGenomeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(browseGenomeButton, gridBagConstraints);

        cancelGenomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelGenomeButton.setText("Cancel");
        cancelGenomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelGenomeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(cancelGenomeButton, gridBagConstraints);

        browseScratchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchButton.setText("Browse");
        browseScratchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(browseScratchButton, gridBagConstraints);

        cancelScratchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchButton.setText("Cancel");
        cancelScratchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(cancelScratchButton, gridBagConstraints);

        jLabel14.setText("Genome file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(jLabel14, gridBagConstraints);

        jLabel3.setText("Fastq folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(jLabel3, gridBagConstraints);

        fastqFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(fastqFolderTextField, gridBagConstraints);

        browseFastqFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseFastqFolderButton.setText("Browse");
        browseFastqFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFastqFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(browseFastqFolderButton, gridBagConstraints);

        cancelFastqFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelFastqFolderButton.setText("Cancel");
        cancelFastqFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFastqFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        inputPanel.add(cancelFastqFolderButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(inputPanel, gridBagConstraints);

        executeFormMiRNAQuantificationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        executeFormMiRNAQuantificationButton.setText("Execute");
        executeFormMiRNAQuantificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormMiRNAQuantificationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(executeFormMiRNAQuantificationButton, gridBagConstraints);

        resetFormMiRNAQuantificationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        resetFormMiRNAQuantificationButton.setText("Reset");
        resetFormMiRNAQuantificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormMiRNAQuantificationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(resetFormMiRNAQuantificationButton, gridBagConstraints);

        closeFormMiRNAQuantificationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        closeFormMiRNAQuantificationButton.setText("Close");
        closeFormMiRNAQuantificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormMiRNAQuantificationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 50.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(closeFormMiRNAQuantificationButton, gridBagConstraints);

        mirnaParametersPanel.setBackground(new java.awt.Color(248, 248, 248));
        mirnaParametersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mirnaParametersPanel.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("miRBase version:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaParametersPanel.add(jLabel4, gridBagConstraints);

        jLabel6.setText("miRBase species:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaParametersPanel.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        mirnaParametersPanel.add(mirbaseVersionTextField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        mirnaParametersPanel.add(mirbaseSpeciesTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mirnaQuantificationPanel.add(mirnaParametersPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(mirnaQuantificationPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void modeMiRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeMiRNAButtonActionPerformed
        mirbaseSpeciesTextField.setEnabled(true);
        mirbaseVersionTextField.setEnabled(true);
        
        mirnaParametersPanel.setVisible(true);
    }//GEN-LAST:event_modeMiRNAButtonActionPerformed

    private void modeNcRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeNcRNAButtonActionPerformed
        mirbaseSpeciesTextField.setEnabled(false);
        mirbaseVersionTextField.setEnabled(false);
        
        mirnaParametersPanel.setVisible(false);
        
    }//GEN-LAST:event_modeNcRNAButtonActionPerformed

    private void cancelFastqFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFastqFolderButtonActionPerformed
        fastqFolderTextField.setText("");
    }//GEN-LAST:event_cancelFastqFolderButtonActionPerformed

    private void cancelGenomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelGenomeButtonActionPerformed
        genomeFolderTextField.setText("");
    }//GEN-LAST:event_cancelGenomeButtonActionPerformed

    private void cancelScratchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchButtonActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchButtonActionPerformed

    private void resetFormMiRNAQuantificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormMiRNAQuantificationButtonActionPerformed
        fastqFolderTextField.setText("");
        genomeFolderTextField.setText("");
        scratchFolderTextField.setText("");
        mirbaseSpeciesTextField.setText("");
        mirbaseVersionTextField.setText("");
    }//GEN-LAST:event_resetFormMiRNAQuantificationButtonActionPerformed

    private void closeFormMiRNAQuantificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormMiRNAQuantificationButtonActionPerformed
        MainFrame.setCard(null);
    }//GEN-LAST:event_closeFormMiRNAQuantificationButtonActionPerformed

    private void browseFastqFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFastqFolderButtonActionPerformed
        MainFrame.browseTextFieldContent(this, fastqFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseFastqFolderButtonActionPerformed

    private void browseGenomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseGenomeButtonActionPerformed
        MainFrame.browseTextFieldContent(this, genomeFolderTextField, JFileChooser.FILES_ONLY);
    }//GEN-LAST:event_browseGenomeButtonActionPerformed

    private void browseScratchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchButtonActionPerformed
        MainFrame.browseTextFieldContent(this, scratchFolderTextField, JFileChooser.DIRECTORIES_ONLY);
    }//GEN-LAST:event_browseScratchButtonActionPerformed

    private void executeFormMiRNAQuantificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormMiRNAQuantificationButtonActionPerformed
        String group = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String mode = modeMiRNAButton.isSelected() ? "miRNA" : "ncRNA";
        int nthreads = 0; 
        String fastqFolder = fastqFolderTextField.getText(), 
               genomeFile = genomeFolderTextField.getText(), 
               scratchFolder = scratchFolderTextField.getText();
        String mbVersion = mirbaseVersionTextField.getText(), 
               mbSpecies = mirbaseSpeciesTextField.getText();
        
        try {
            nthreads = Integer.parseInt(numThreadsTextField.getText());
            
            if (nthreads <= 0) 
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The number of threads must be a positive integer greater than zero.",
                "Error: number of threads", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        if (fastqFolder.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the fastq folder.",
                "Error: fastq folder", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (genomeFile.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the genome file.",
                "Error: genome file", 
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
        if (mode.equals("miRNA")) {
            if (mbVersion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "You have to specify the mirbase version.",
                    "Error: mirbase version", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (mbSpecies.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "You have to specify the mirbase species.",
                    "Error: mirbase species", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        String mirnaArgs = mode.equals("miRNA") ? 
            String.format("mb.version='%s' mb.species='%s'", mbVersion, mbSpecies) : "";
        
        String command = String.format(
            "group='%s' fastq.folder='%s' scratch.folder='%s' reference='%s' " + 
            "mode='%s' threads=%d %s", 
            group, fastqFolder, scratchFolder, genomeFile, mode, nthreads, mirnaArgs)
                .replace("'", "\\\"");
        
        MainFrame.execCommand(this, "miRNA quantification", "execMiRNAQuantification.sh", command, fastqFolder);
    }//GEN-LAST:event_executeFormMiRNAQuantificationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JButton browseFastqFolderButton;
    private javax.swing.JButton browseGenomeButton;
    private javax.swing.JButton browseScratchButton;
    private javax.swing.JButton cancelFastqFolderButton;
    private javax.swing.JButton cancelGenomeButton;
    private javax.swing.JButton cancelScratchButton;
    private javax.swing.JButton closeFormMiRNAQuantificationButton;
    private javax.swing.JButton executeFormMiRNAQuantificationButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JTextField fastqFolderTextField;
    private javax.swing.JTextField genomeFolderTextField;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField mirbaseSpeciesTextField;
    private javax.swing.JTextField mirbaseVersionTextField;
    private javax.swing.JPanel mirnaParametersPanel;
    private javax.swing.JPanel mirnaQuantificationPanel;
    private javax.swing.ButtonGroup modeGroup;
    private javax.swing.JRadioButton modeMiRNAButton;
    private javax.swing.JRadioButton modeNcRNAButton;
    private javax.swing.JTextField numThreadsTextField;
    private javax.swing.JButton resetFormMiRNAQuantificationButton;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
