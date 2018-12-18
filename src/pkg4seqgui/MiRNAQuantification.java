/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;

/**
 *
 * @author Nicola Licheri
 */
public class MiRNAQuantification extends javax.swing.JPanel {
    private String mode; 

    /**
     * Creates new form MiRNAQuantification
     */
    public MiRNAQuantification() {
        initComponents();
        this.mode = "general";
    }
    
    private void changeCard(String newMode) {
        if (!newMode.equals(this.mode)) {
            /* TODO - setta card */
            this.mode = newMode; 
            CardLayout card = (CardLayout) modePanel.getLayout();
            card.show(modePanel, this.mode);
        }
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

        indexModeGroup = new javax.swing.ButtonGroup();
        mirnaQuantificPanel = new javax.swing.JPanel();
        ExecutionPanel = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        SudoRadioButton = new javax.swing.JRadioButton();
        DockerRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        numThreadsTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        genomePanel = new javax.swing.JPanel();
        modeGeneralButton = new javax.swing.JRadioButton();
        modeGATKButton = new javax.swing.JRadioButton();
        modeMiRNAButton = new javax.swing.JRadioButton();
        modeNcRNAButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        genomeFolderTextField = new javax.swing.JTextField();
        scratchFolderTextField = new javax.swing.JTextField();
        modePanel = new javax.swing.JPanel();
        generalModePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        generalGenomeUrlTextField = new javax.swing.JTextField();
        gatkModePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        gatkGenomeUrlTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gatkGenomeUrlTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        gatkGenomeUrlTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        mirnaModePanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        mirbaseVersionTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mirnaSpecieTextField = new javax.swing.JTextField();
        ncrnaModePanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        crnaVersionTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        crnaSpecieTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lengthThresholdTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        mirnaQuantificPanel.setLayout(new java.awt.GridBagLayout());

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
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        ExecutionPanel.add(SudoRadioButton, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
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
        mirnaQuantificPanel.add(ExecutionPanel, gridBagConstraints);

        genomePanel.setLayout(new java.awt.GridBagLayout());

        indexModeGroup.add(modeGeneralButton);
        modeGeneralButton.setText("General");
        modeGeneralButton.setName("general"); // NOI18N
        modeGeneralButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeGeneralButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        genomePanel.add(modeGeneralButton, gridBagConstraints);

        indexModeGroup.add(modeGATKButton);
        modeGATKButton.setText("GATK");
        modeGATKButton.setName("gatk"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        genomePanel.add(modeGATKButton, gridBagConstraints);

        indexModeGroup.add(modeMiRNAButton);
        modeMiRNAButton.setText("miRNA");
        modeMiRNAButton.setName("mirna"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        genomePanel.add(modeMiRNAButton, gridBagConstraints);

        indexModeGroup.add(modeNcRNAButton);
        modeNcRNAButton.setText("ncRNA");
        modeNcRNAButton.setName("ncrna"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        genomePanel.add(modeNcRNAButton, gridBagConstraints);

        jLabel1.setText("Mode:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        genomePanel.add(jLabel1, gridBagConstraints);

        genomeFolderTextField.setText("Genomeee");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        genomePanel.add(genomeFolderTextField, gridBagConstraints);

        scratchFolderTextField.setText("Scratchhhh");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        genomePanel.add(scratchFolderTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mirnaQuantificPanel.add(genomePanel, gridBagConstraints);

        modePanel.setLayout(new java.awt.CardLayout());

        generalModePanel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Genome URL:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        generalModePanel.add(jLabel3, gridBagConstraints);

        generalGenomeUrlTextField.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        generalModePanel.add(generalGenomeUrlTextField, gridBagConstraints);

        modePanel.add(generalModePanel, "general");

        gatkModePanel.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Genome URL");
        gatkModePanel.add(jLabel4, new java.awt.GridBagConstraints());

        gatkGenomeUrlTextField.setText("jTextField1");
        gatkModePanel.add(gatkGenomeUrlTextField, new java.awt.GridBagConstraints());

        jLabel6.setText("dbsnp file");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gatkModePanel.add(jLabel6, gridBagConstraints);

        gatkGenomeUrlTextField1.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gatkModePanel.add(gatkGenomeUrlTextField1, gridBagConstraints);

        jLabel8.setText("1000g file");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gatkModePanel.add(jLabel8, gridBagConstraints);

        gatkGenomeUrlTextField2.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gatkModePanel.add(gatkGenomeUrlTextField2, gridBagConstraints);

        jButton4.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gatkModePanel.add(jButton4, gridBagConstraints);

        jButton5.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gatkModePanel.add(jButton5, gridBagConstraints);

        jButton6.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gatkModePanel.add(jButton6, gridBagConstraints);

        jButton7.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gatkModePanel.add(jButton7, gridBagConstraints);

        modePanel.add(gatkModePanel, "gatk");

        mirnaModePanel.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("mirbase version:  ");
        mirnaModePanel.add(jLabel9, new java.awt.GridBagConstraints());

        mirbaseVersionTextField.setText("jTextField1");
        mirnaModePanel.add(mirbaseVersionTextField, new java.awt.GridBagConstraints());

        jLabel10.setText("species:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        mirnaModePanel.add(jLabel10, gridBagConstraints);

        mirnaSpecieTextField.setText("jTextField2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        mirnaModePanel.add(mirnaSpecieTextField, gridBagConstraints);

        modePanel.add(mirnaModePanel, "mirna");

        ncrnaModePanel.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("RC db version: ");
        ncrnaModePanel.add(jLabel11, new java.awt.GridBagConstraints());

        crnaVersionTextField.setText("jTextField1");
        ncrnaModePanel.add(crnaVersionTextField, new java.awt.GridBagConstraints());

        jLabel12.setText("species:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        ncrnaModePanel.add(jLabel12, gridBagConstraints);

        crnaSpecieTextField.setText("jTextField2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        ncrnaModePanel.add(crnaSpecieTextField, gridBagConstraints);

        jLabel13.setText("length:  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        ncrnaModePanel.add(jLabel13, gridBagConstraints);

        lengthThresholdTextField.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        ncrnaModePanel.add(lengthThresholdTextField, gridBagConstraints);

        modePanel.add(ncrnaModePanel, "ncrna");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        mirnaQuantificPanel.add(modePanel, gridBagConstraints);

        jButton1.setText("jButton1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        mirnaQuantificPanel.add(jButton1, gridBagConstraints);

        jButton2.setText("jButton2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        mirnaQuantificPanel.add(jButton2, gridBagConstraints);

        jButton3.setText("jButton3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        mirnaQuantificPanel.add(jButton3, gridBagConstraints);

        add(mirnaQuantificPanel, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void SudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SudoRadioButtonActionPerformed

    private void DockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DockerRadioButtonActionPerformed

    private void modeGeneralButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeGeneralButtonActionPerformed
        ;
    }//GEN-LAST:event_modeGeneralButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton DockerRadioButton;
    private javax.swing.JPanel ExecutionPanel;
    private javax.swing.JRadioButton SudoRadioButton;
    private javax.swing.JTextField crnaSpecieTextField;
    private javax.swing.JTextField crnaVersionTextField;
    private javax.swing.JTextField gatkGenomeUrlTextField;
    private javax.swing.JTextField gatkGenomeUrlTextField1;
    private javax.swing.JTextField gatkGenomeUrlTextField2;
    private javax.swing.JPanel gatkModePanel;
    private javax.swing.JTextField generalGenomeUrlTextField;
    private javax.swing.JPanel generalModePanel;
    private javax.swing.JTextField genomeFolderTextField;
    private javax.swing.JPanel genomePanel;
    private javax.swing.ButtonGroup indexModeGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lengthThresholdTextField;
    private javax.swing.JTextField mirbaseVersionTextField;
    private javax.swing.JPanel mirnaModePanel;
    private javax.swing.JPanel mirnaQuantificPanel;
    private javax.swing.JTextField mirnaSpecieTextField;
    private javax.swing.JRadioButton modeGATKButton;
    private javax.swing.JRadioButton modeGeneralButton;
    private javax.swing.JRadioButton modeMiRNAButton;
    private javax.swing.JRadioButton modeNcRNAButton;
    private javax.swing.JPanel modePanel;
    private javax.swing.JPanel ncrnaModePanel;
    private javax.swing.JTextField numThreadsTextField;
    private javax.swing.JTextField scratchFolderTextField;
    // End of variables declaration//GEN-END:variables
}