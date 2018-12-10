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

/**
 *
 * @author nico
 */
public class CircRNAStarChimeric extends javax.swing.JPanel {

    /**
     * Creates new form CircRNAStarChimeric
     */
    public CircRNAStarChimeric() {
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
        StarChimericPanel = new javax.swing.JPanel();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        numThreadsTextField = new javax.swing.JTextField();
        closeFormCircRNAStarChimericButton = new javax.swing.JButton();
        executeFormCircRNAStarChimericButton = new javax.swing.JButton();
        resetFormCircRNAStarChimericButton = new javax.swing.JButton();
        IOFilesPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        genomeFolderTextField = new javax.swing.JTextField();
        fastqFolderTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        scratchFolderTextField = new javax.swing.JTextField();
        browseScratchFolderButton1 = new javax.swing.JButton();
        cancelScratchFolderButton1 = new javax.swing.JButton();
        browseGenomeFolderTextField = new javax.swing.JButton();
        cancelGenomeFolderTextField = new javax.swing.JButton();
        browseFastqFolderButton = new javax.swing.JButton();
        cancelFastqFolderButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        minOverhangTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        minLenOverlapTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.GridBagLayout());

        StarChimericPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("STAR alignment"));
        StarChimericPanel.setLayout(new java.awt.GridBagLayout());

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

        jLabel5.setText("Num. threads: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExecutionPanel.add(numThreadsTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        StarChimericPanel.add(ExecutionPanel, gridBagConstraints);

        closeFormCircRNAStarChimericButton.setText("Close");
        closeFormCircRNAStarChimericButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormCircRNAStarChimericButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        StarChimericPanel.add(closeFormCircRNAStarChimericButton, gridBagConstraints);

        executeFormCircRNAStarChimericButton.setText("Execute");
        executeFormCircRNAStarChimericButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeFormCircRNAStarChimericButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        StarChimericPanel.add(executeFormCircRNAStarChimericButton, gridBagConstraints);

        resetFormCircRNAStarChimericButton.setText("Reset");
        resetFormCircRNAStarChimericButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormCircRNAStarChimericButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        StarChimericPanel.add(resetFormCircRNAStarChimericButton, gridBagConstraints);

        IOFilesPanel.setBackground(new java.awt.Color(248, 248, 248));
        IOFilesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        IOFilesPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("FASTQ folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOFilesPanel.add(jLabel1, gridBagConstraints);

        genomeFolderTextField.setEditable(false);
        genomeFolderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genomeFolderTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOFilesPanel.add(genomeFolderTextField, gridBagConstraints);

        fastqFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOFilesPanel.add(fastqFolderTextField, gridBagConstraints);

        jLabel2.setText("Genome folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IOFilesPanel.add(jLabel2, gridBagConstraints);

        jLabel6.setText("Scratch folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        IOFilesPanel.add(jLabel6, gridBagConstraints);

        scratchFolderTextField.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        IOFilesPanel.add(scratchFolderTextField, gridBagConstraints);

        browseScratchFolderButton1.setText("Browse");
        browseScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        IOFilesPanel.add(browseScratchFolderButton1, gridBagConstraints);

        cancelScratchFolderButton1.setText("Cancel");
        cancelScratchFolderButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelScratchFolderButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        IOFilesPanel.add(cancelScratchFolderButton1, gridBagConstraints);

        browseGenomeFolderTextField.setText("Browse");
        browseGenomeFolderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseGenomeFolderTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        IOFilesPanel.add(browseGenomeFolderTextField, gridBagConstraints);

        cancelGenomeFolderTextField.setText("Cancel");
        cancelGenomeFolderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelGenomeFolderTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        IOFilesPanel.add(cancelGenomeFolderTextField, gridBagConstraints);

        browseFastqFolderButton.setText("Browse");
        browseFastqFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFastqFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        IOFilesPanel.add(browseFastqFolderButton, gridBagConstraints);

        cancelFastqFolderButton.setText("Cancel");
        cancelFastqFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelFastqFolderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        IOFilesPanel.add(cancelFastqFolderButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        StarChimericPanel.add(IOFilesPanel, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(248, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Minimum overhang");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(minOverhangTextField, gridBagConstraints);

        jLabel4.setText("Minimal length overlap");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(minLenOverlapTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        StarChimericPanel.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(StarChimericPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void closeFormCircRNAStarChimericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormCircRNAStarChimericButtonActionPerformed
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";

        resetFormCircRNAStarChimericButtonActionPerformed(evt);
    }//GEN-LAST:event_closeFormCircRNAStarChimericButtonActionPerformed

    private void executeFormCircRNAStarChimericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeFormCircRNAStarChimericButtonActionPerformed
        String execution = DockerRadioButton.isSelected() ? "docker" : "sudo";
        String genomePath = genomeFolderTextField.getText(), 
               fastqPath = fastqFolderTextField.getText(), 
               scratchFolder = scratchFolderTextField.getText();
        int chimSegmentMin, chimJunctionOverhangMin, nthreads; 

        
        if (genomePath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the reference genome path.",
                "Error: reference genome", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        if (fastqPath.equals("")) {
            JOptionPane.showMessageDialog(this, 
                "You have to specify the fastq data path.",
                "Error: fastq data", 
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
        
        try {
            nthreads = Integer.parseInt(numThreadsTextField.getText());
            
            if (nthreads <= 0) 
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The number of threads must be a positive integer value.",
                "Error: thread number", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        try {
            chimSegmentMin = Integer.parseInt(minLenOverlapTextField.getText()); 
            
            if (chimSegmentMin < 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The number of ??? must be a positive integer value.",
                "Error: chimSegmentMin", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        try {
            chimJunctionOverhangMin = Integer.parseInt(minOverhangTextField.getText()); 
            
            if (chimJunctionOverhangMin < 0)
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "The number of ??? must be a positive integer value.",
                "Error: chimJunctionOverhangMin", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        
        
        String command = String.format(
            "group='%s' scratch.folder='%s' genome.folder='%s' " + 
            "fastq.folder='%s' threads='%d' chimSegmentMin='%d' chimJunctionOverhangMin='%d'", 
            execution, scratchFolder, genomePath, 
            fastqPath, nthreads, chimSegmentMin, chimJunctionOverhangMin)
                .replace("'", "\\\"");
        
        Path p = Paths.get(fastqPath);
        Path folder = p.getParent();

        MainFrame.execCommand(this, "CircRNA STAR chimeric", "execCircSTARAlignment.sh", command, folder.toString());
    }//GEN-LAST:event_executeFormCircRNAStarChimericButtonActionPerformed

    private void resetFormCircRNAStarChimericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormCircRNAStarChimericButtonActionPerformed
        genomeFolderTextField.setText("");
        fastqFolderTextField.setText("");
        scratchFolderTextField.setText("");
        minLenOverlapTextField.setText("");
        minOverhangTextField.setText("");
        numThreadsTextField.setText("");
        DockerRadioButton.setSelected(true);
    }//GEN-LAST:event_resetFormCircRNAStarChimericButtonActionPerformed

    private void genomeFolderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genomeFolderTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genomeFolderTextFieldActionPerformed

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

    private void browseGenomeFolderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseGenomeFolderTextFieldActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!genomeFolderTextField.getText().isEmpty()){
            File file =new File(genomeFolderTextField.getText());
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
            genomeFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_browseGenomeFolderTextFieldActionPerformed

    private void browseFastqFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFastqFolderButtonActionPerformed
        JFileChooser openDir = new JFileChooser();

        if (!(fastqFolderTextField.getText().equals(""))){
            File file =new File(fastqFolderTextField.getText());
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
            fastqFolderTextField.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
    }//GEN-LAST:event_browseFastqFolderButtonActionPerformed

    private void cancelGenomeFolderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelGenomeFolderTextFieldActionPerformed
        genomeFolderTextField.setText("");
    }//GEN-LAST:event_cancelGenomeFolderTextFieldActionPerformed

    private void cancelFastqFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelFastqFolderButtonActionPerformed
        fastqFolderTextField.setText("");
    }//GEN-LAST:event_cancelFastqFolderButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JPanel IOFilesPanel;
    private javax.swing.JPanel StarChimericPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JButton browseFastqFolderButton;
    private javax.swing.JButton browseGenomeFolderTextField;
    private javax.swing.JButton browseScratchFolderButton1;
    private javax.swing.JButton cancelFastqFolderButton;
    private javax.swing.JButton cancelGenomeFolderTextField;
    private javax.swing.JButton cancelScratchFolderButton1;
    private javax.swing.JButton closeFormCircRNAStarChimericButton;
    private javax.swing.JButton executeFormCircRNAStarChimericButton;
    private javax.swing.ButtonGroup executionGroup;
    private javax.swing.JTextField fastqFolderTextField;
    private javax.swing.JTextField genomeFolderTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField minLenOverlapTextField;
    private javax.swing.JTextField minOverhangTextField;
    private javax.swing.JTextField numThreadsTextField;
    private javax.swing.JButton resetFormCircRNAStarChimericButton;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}
