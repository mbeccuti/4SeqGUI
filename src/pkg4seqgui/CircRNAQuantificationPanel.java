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
public class CircRNAQuantificationPanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 9778212338L;
    /**
     * Creates new form CircRNAQuantificationPanel
     */
    public CircRNAQuantificationPanel() {
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
        QuantificationPanel = new javax.swing.JPanel();
        PostCiriDataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rnaseqDataTextField = new javax.swing.JTextField();
        bsjunctionsDataTextField = new javax.swing.JTextField();
        browseRnaSeqDataButton = new javax.swing.JButton();
        cancelRnaSeqDataButton = new javax.swing.JButton();
        browseBSJunctionsDataButton = new javax.swing.JButton();
        cancelBSJunctionsDataButton = new javax.swing.JButton();
        browseCircrnaDataButton = new javax.swing.JButton();
        cancelCircrnaDataButton = new javax.swing.JButton();
        circrnaDataTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton2 = new javax.swing.JButton();
        cancelScratchFolderButton1 = new javax.swing.JButton();
        closeFormPostProcessingButton = new javax.swing.JButton();
        executeFormPostProcessingButton = new javax.swing.JButton();
        resetFormPostProcessingButton = new javax.swing.JButton();
        HashCircParamsPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kmerSizeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        numThreadsTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        matchingKmersTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numPerfectKmersTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        hashtableSizeTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        collisionListSizeTextField = new javax.swing.JTextField();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        QuantificationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "CircRNA quantification", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(194, 16, 29))); // NOI18N
        QuantificationPanel.setLayout(new java.awt.GridBagLayout());

        PostCiriDataPanel.setBackground(new java.awt.Color(248, 248, 248));
        PostCiriDataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PostCiriDataPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("RNA-seq file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("BS-Junctions data:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Dati circRNA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel3, gridBagConstraints);

        rnaseqDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(rnaseqDataTextField, gridBagConstraints);

        bsjunctionsDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(bsjunctionsDataTextField, gridBagConstraints);

        browseRnaSeqDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseRnaSeqDataButton.setText("Browse");
        browseRnaSeqDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseRnaSeqDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseRnaSeqDataButton, gridBagConstraints);

        cancelRnaSeqDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelRnaSeqDataButton.setText("Cancel");
        cancelRnaSeqDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRnaSeqDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelRnaSeqDataButton, gridBagConstraints);

        browseBSJunctionsDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseBSJunctionsDataButton.setText("Browse");
        browseBSJunctionsDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBSJunctionsDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseBSJunctionsDataButton, gridBagConstraints);

        cancelBSJunctionsDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelBSJunctionsDataButton.setText("Cancel");
        cancelBSJunctionsDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBSJunctionsDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelBSJunctionsDataButton, gridBagConstraints);

        browseCircrnaDataButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        browseCircrnaDataButton.setText("Browse");
        browseCircrnaDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseCircrnaDataButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
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
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(cancelCircrnaDataButton, gridBagConstraints);

        circrnaDataTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(circrnaDataTextField, gridBagConstraints);

        jLabel10.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(jLabel10, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(scratchFolderTextField, gridBagConstraints);

        browseScratchFolderButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        browseScratchFolderButton2.setText("Browse");
        browseScratchFolderButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchFolderButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PostCiriDataPanel.add(browseScratchFolderButton2, gridBagConstraints);

        cancelScratchFolderButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        cancelScratchFolderButton1.setText("Cancel");
        cancelScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
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
        QuantificationPanel.add(PostCiriDataPanel, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        QuantificationPanel.add(closeFormPostProcessingButton, gridBagConstraints);

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
        QuantificationPanel.add(executeFormPostProcessingButton, gridBagConstraints);

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
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        QuantificationPanel.add(resetFormPostProcessingButton, gridBagConstraints);

        HashCircParamsPanel.setBackground(new java.awt.Color(248, 248, 248));
        HashCircParamsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HashCirc Parameters", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(208, 31, 31))); // NOI18N
        HashCircParamsPanel.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("k-mer size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(kmerSizeTextField, gridBagConstraints);

        jLabel5.setText("perfect matching k-mers:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(numThreadsTextField, gridBagConstraints);

        jLabel6.setText("matching k-mers:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(matchingKmersTextField, gridBagConstraints);

        jLabel7.setText("hashtable size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(numPerfectKmersTextField, gridBagConstraints);

        jLabel8.setText("threads:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(hashtableSizeTextField, gridBagConstraints);

        jLabel9.setText("collision list size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        HashCircParamsPanel.add(collisionListSizeTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        QuantificationPanel.add(HashCircParamsPanel, gridBagConstraints);

        ExecutionPanel.setBackground(new java.awt.Color(248, 248, 248));
        ExecutionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ExecutionPanel.setToolTipText(null);
        ExecutionPanel.setLayout(new java.awt.GridBagLayout());

        jLabel142.setText("Execution:");
        jLabel142.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(jLabel142, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 60, 10, 10);
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
        QuantificationPanel.add(ExecutionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(QuantificationPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void browseRnaSeqDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseRnaSeqDataButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(rnaseqDataTextField.getText().equals(""))){
            File file =new File(rnaseqDataTextField.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            rnaseqDataTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseRnaSeqDataButtonActionPerformed

    private void cancelRnaSeqDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRnaSeqDataButtonActionPerformed
        rnaseqDataTextField.setText("");
    }//GEN-LAST:event_cancelRnaSeqDataButtonActionPerformed

    private void browseBSJunctionsDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBSJunctionsDataButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(bsjunctionsDataTextField.getText().equals(""))){
            File file =new File(bsjunctionsDataTextField.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            bsjunctionsDataTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseBSJunctionsDataButtonActionPerformed

    private void cancelBSJunctionsDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBSJunctionsDataButtonActionPerformed
        bsjunctionsDataTextField.setText("");
    }//GEN-LAST:event_cancelBSJunctionsDataButtonActionPerformed

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

        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);

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
        bsjunctionsDataTextField.setText("");
        rnaseqDataTextField.setText("");
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_resetFormPostProcessingButtonActionPerformed

    private void executeFormPostProcessingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormPostProcessingButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String rnaseqPath = rnaseqDataTextField.getText(), 
               junctionsPath = bsjunctionsDataTextField.getText(), 
               circrnaPath = circrnaDataTextField.getText(), 
               scratchFolder = scratchFolderTextField.getText();

        if (rnaseqPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the RNA-seq data file.",
                "Error: RNA-seq data", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (junctionsPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the backsplicing juctions data file.",
                "Error: backsplicing-junctions data", 
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
        
        //validating hashcirc parameters
        int kmerSize, numThreads, hashtableSize, collisionListSize, numMatchingKmers, numPerfectKmers; 
        
        try {
            kmerSize = Integer.parseInt(kmerSizeTextField.getText()); 
            numThreads = Integer.parseInt(numThreadsTextField.getText()); 
            hashtableSize = Integer.parseInt(hashtableSizeTextField.getText()); 
            collisionListSize = Integer.parseInt(collisionListSizeTextField.getText()); 
            numMatchingKmers = Integer.parseInt(matchingKmersTextField.getText()); 
            numPerfectKmers = Integer.parseInt(numPerfectKmersTextField.getText()); 
            
            int temp[] = {kmerSize, numThreads, hashtableSize, collisionListSize, numMatchingKmers, numPerfectKmers};
            for (int x: temp) 
                if (x <= 0)
                    throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "HashCirc parameters must be integer values greater than zero.",
                "Error: HashCirc parameters", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        
        String command = String.format(
            "group='%s' scratch.folder='%s' rnaseq.data='%s' backsplicing_junctions.data='%s' " + 
            "hcp1=%d hcp2=%d hcp3=%d hcp4=%d hcp5=%d hcp6=%d", 
            execution, scratchFolder, rnaseqPath, junctionsPath, 
            kmerSize, numThreads, hashtableSize, collisionListSize, numMatchingKmers, numPerfectKmers)
                .replace("'", "\\\"");
      
        Path p = Paths.get(circrnaPath);
        Path folder = p.getParent();
        
        MainFrame.execCommand(this, "CircRNA quantification", "execCircRNAQuantification.sh", command, folder.toString());
    }//GEN-LAST:event_executeFormPostProcessingButtonActionPerformed

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void browseScratchFolderButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseScratchFolderButton2ActionPerformed
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
    }//GEN-LAST:event_browseScratchFolderButton2ActionPerformed

    private void cancelScratchFolderButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelScratchFolderButton1ActionPerformed
        scratchFolderTextField.setText("");
    }//GEN-LAST:event_cancelScratchFolderButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JPanel HashCircParamsPanel;
    private javax.swing.JPanel PostCiriDataPanel;
    private javax.swing.JPanel QuantificationPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JButton browseBSJunctionsDataButton;
    private javax.swing.JButton browseCircrnaDataButton;
    private javax.swing.JButton browseRnaSeqDataButton;
    private javax.swing.JButton browseScratchFolderButton2;
    private javax.swing.JTextField bsjunctionsDataTextField;
    private javax.swing.JButton cancelBSJunctionsDataButton;
    private javax.swing.JButton cancelCircrnaDataButton;
    private javax.swing.JButton cancelRnaSeqDataButton;
    private javax.swing.JButton cancelScratchFolderButton1;
    private javax.swing.JTextField circrnaDataTextField;
    private javax.swing.JButton closeFormPostProcessingButton;
    private javax.swing.JTextField collisionListSizeTextField;
    private javax.swing.JButton executeFormPostProcessingButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JTextField hashtableSizeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField kmerSizeTextField;
    private javax.swing.JTextField matchingKmersTextField;
    private javax.swing.JTextField numPerfectKmersTextField;
    private javax.swing.JTextField numThreadsTextField;
    private javax.swing.JButton resetFormPostProcessingButton;
    private javax.swing.JTextField rnaseqDataTextField;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
