/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import static pkg4seqgui.MainFrame.contextMenu;
import static pkg4seqgui.MainFrame.getPreferences;

/**
 *
 * @author beccuti
 */
public class FilterCountsPanel extends javax.swing.JPanel {

    /**
     * Creates new form FilterCountsPanel
     */
    public FilterCountsPanel() {
        initComponents();
        //contextMenu.add(fFPKMfileText);
        //contextMenu.add(fOutputFolderText);
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

        DataFilter = new javax.swing.ButtonGroup();
        filterCountsPanel = new javax.swing.JPanel();
        vCloseButton6 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        fFPKMfileText = new javax.swing.JTextField();
        jToggleButton38 = new javax.swing.JToggleButton();
        fCancelButton4 = new javax.swing.JToggleButton();
        jLabel121 = new javax.swing.JLabel();
        fOutputFolderText = new javax.swing.JTextField();
        jToggleButton39 = new javax.swing.JToggleButton();
        fCancelButton5 = new javax.swing.JToggleButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        fgeneRadioButton = new javax.swing.JRadioButton();
        fisoformRadioButton = new javax.swing.JRadioButton();
        fmirnaRadioButton = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        filterCountsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Filter Counts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 51, 51))); // NOI18N
        filterCountsPanel.setToolTipText(null);
        filterCountsPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton6.setText("Close");
        vCloseButton6.setToolTipText(null);
        vCloseButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(vCloseButton6, gridBagConstraints);

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton42.setText("Execute");
        jButton42.setToolTipText(null);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(jButton42, gridBagConstraints);

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton43.setText("Reset");
        jButton43.setToolTipText(null);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(jButton43, gridBagConstraints);

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton44.setText("Save conf.");
        jButton44.setToolTipText(null);
        jButton44.setEnabled(false);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(jButton44, gridBagConstraints);

        jPanel33.setBackground(new java.awt.Color(248, 248, 248));
        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel33.setToolTipText(null);
        jPanel33.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("Output folder:");
        jLabel120.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(jLabel120, gridBagConstraints);

        fFPKMfileText.setEditable(false);
        fFPKMfileText.setToolTipText("Input data folder.");
        fFPKMfileText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fFPKMfileTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel33.add(fFPKMfileText, gridBagConstraints);

        jToggleButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton38.setText("Browse");
        jToggleButton38.setToolTipText(null);
        jToggleButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton38ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(jToggleButton38, gridBagConstraints);

        fCancelButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton4.setText("Cancel");
        fCancelButton4.setToolTipText(null);
        fCancelButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(fCancelButton4, gridBagConstraints);

        jLabel121.setText("Input folder:");
        jLabel121.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(jLabel121, gridBagConstraints);

        fOutputFolderText.setEditable(false);
        fOutputFolderText.setToolTipText("Output data folder.");
        fOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel33.add(fOutputFolderText, gridBagConstraints);

        jToggleButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton39.setText("Browse");
        jToggleButton39.setToolTipText(null);
        jToggleButton39.setEnabled(false);
        jToggleButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton39ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(jToggleButton39, gridBagConstraints);

        fCancelButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton5.setText("Cancel");
        fCancelButton5.setToolTipText(null);
        fCancelButton5.setEnabled(false);
        fCancelButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel33.add(fCancelButton5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(jPanel33, gridBagConstraints);

        jPanel34.setBackground(new java.awt.Color(248, 248, 248));
        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel34.setToolTipText(null);
        jPanel34.setLayout(new java.awt.GridBagLayout());

        jLabel124.setText("Data type:");
        jLabel124.setToolTipText(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel34.add(jLabel124, gridBagConstraints);

        fgeneRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataFilter.add(fgeneRadioButton);
        fgeneRadioButton.setText("gene");
        fgeneRadioButton.setToolTipText(null);
        fgeneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fgeneRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel34.add(fgeneRadioButton, gridBagConstraints);

        fisoformRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataFilter.add(fisoformRadioButton);
        fisoformRadioButton.setSelected(true);
        fisoformRadioButton.setText("isoform");
        fisoformRadioButton.setToolTipText(null);
        fisoformRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fisoformRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel34.add(fisoformRadioButton, gridBagConstraints);

        fmirnaRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataFilter.add(fmirnaRadioButton);
        fmirnaRadioButton.setText("mirna");
        fmirnaRadioButton.setToolTipText(null);
        fmirnaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fmirnaRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 25, 10, 10);
        jPanel34.add(fmirnaRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        filterCountsPanel.add(jPanel34, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(filterCountsPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void vCloseButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton6ActionPerformed

        //RESET FIELDS
        fisoformRadioButton.setSelected(true);
        fFPKMfileText.setText("");
        fOutputFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainFrame.MainPanel.getLayout();
        card.show(MainFrame.MainPanel, "Empty");
        MainFrame.CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
        //        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton6ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed

        //Field check

        if (fFPKMfileText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: input file",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output  folder","Error: output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }

        Runtime rt = Runtime.getRuntime();
        //execute code

        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execFilterCounts.sh "};
            cmd[2]+= " data.folder=\\\""+ fFPKMfileText.getText() +"\\\"";
            if (fisoformRadioButton.isSelected())
                cmd[2]+= " type=\\\"isoform\\\"";
            else
                if (fmirnaRadioButton.isSelected())
                    cmd[2]+= " type=\\\"mirna\\\"";
                else
                    cmd[2]+= " type=\\\"gene\\\"";
            cmd[2]+= " output.folder=\\\""+ fOutputFolderText.getText() +"\\\"";
            // File outputFolder= new File(pFPKMfileText.getText());
            // String output= outputFolder.getAbsolutePath().substring(0,outputFolder.getAbsolutePath().lastIndexOf(File.separator));
            cmd[2]+=" "+ fOutputFolderText.getText()+" >& "+fOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (MainFrame.listProcRunning.size()<MainFrame.GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd);
                System.out.println(cmd[2]);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning("Count Filter ", fOutputFolderText.getText() ,pr,MainFrame.listModel.getSize());
                MainFrame.listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                MainFrame.GL.setAvoidProcListValueChanged(0);
                if(MainFrame.listProcRunning.size()==1){
                    MainFrame.t=new Timer();
                    MainFrame.t.scheduleAtFixedRate(new MainFrame.MyTask(), 5000, 5000);
                }
            }
            else{
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting("Count filter ", fOutputFolderText.getText(),cmd,MainFrame.listModel.getSize());
                MainFrame.listProcWaiting.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                MainFrame.GL.setAvoidProcListValueChanged(0);
            }
            MainFrame.GL.setAvoidProcListValueChanged(-1);
            MainFrame.ProcList.setModel(MainFrame.listModel);
            MainFrame.ProcList.setCellRenderer(new MainFrame.ListEntryCellRenderer());
            MainFrame.GL.setAvoidProcListValueChanged(0);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(this, "A count filter task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        fisoformRadioButton.setSelected(true);
        fFPKMfileText.setText("");
        fOutputFolderText.setText("");
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        //saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void fFPKMfileTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fFPKMfileTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fFPKMfileTextActionPerformed

    private void jToggleButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton38ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(fFPKMfileText.getText().equals(""))){
            File file =new File(fOutputFolderText.getText());
            if (file.isDirectory())
            openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
        }
        openDir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            fFPKMfileText.setText(String.valueOf(f));
            //UPDATE TO REMOVE OUTPUT FOLDER
            fOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton38ActionPerformed

    private void fCancelButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton4ActionPerformed
        fFPKMfileText.setText("");
        fOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButton4ActionPerformed

    private void fOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fOutputFolderTextActionPerformed

    private void jToggleButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton39ActionPerformed

    private void fCancelButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fCancelButton5ActionPerformed

    private void fgeneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fgeneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fgeneRadioButtonActionPerformed

    private void fisoformRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fisoformRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fisoformRadioButtonActionPerformed

    private void fmirnaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmirnaRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmirnaRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup DataFilter;
    private javax.swing.JToggleButton fCancelButton4;
    private javax.swing.JToggleButton fCancelButton5;
    private javax.swing.JTextField fFPKMfileText;
    private javax.swing.JTextField fOutputFolderText;
    private javax.swing.JRadioButton fgeneRadioButton;
    private javax.swing.JPanel filterCountsPanel;
    private javax.swing.JRadioButton fisoformRadioButton;
    private javax.swing.JRadioButton fmirnaRadioButton;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JButton vCloseButton6;
    // End of variables declaration//GEN-END:variables
}
