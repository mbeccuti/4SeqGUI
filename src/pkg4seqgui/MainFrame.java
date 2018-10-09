/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;
import javax.swing.DefaultCellEditor;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;

/**
 *
 * @author beccuti
 */
public class MainFrame extends javax.swing.JFrame {

    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {       
        
 
        initComponents();
        java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/dna.png");
        ImageIcon image = new ImageIcon(imgURL);
        
        //DefaultTreeCellRenderer renderer =(DefaultTreeCellRenderer) AnalysisTree.getCellRenderer();
        //renderer.setLeafIcon(image);
        //imgURL = getClass().getResource("/pkg4seqgui/images/dna2.png");
       // ImageIcon image2 = new ImageIcon(imgURL);
        //renderer.setOpenIcon(image2);
       // expandAllNodes(AnalysisTree, 0, AnalysisTree.getRowCount());
                

        //JTREE MULTIPLEFILE
       

        //adding here all the textarea that must be maneged with right button mouse
        
        //vRNAPanel
        contextMenu.add(vThreadText);
        contextMenu.add(vAdapter5Text);
        contextMenu.add(vAdapter3Text);
        contextMenu.add(vMinLengthText);
        contextMenu.add(vOrganismText);
        //indexingSTARPanel
        contextMenu.add(iThreadText);
        contextMenu.add(iGenomeURLText);
        contextMenu.add(iGTFURLText);
        //miRNAPanel
        contextMenu.add(mmiRBaseText);
        //PCA
         contextMenu.add(pComponent1Text);
         contextMenu.add(pComponent2Text);  
        //DES
        contextMenu.add(dLog2fcText);
        contextMenu.add(dFDRText);  
        //indexingBW
        contextMenu.add(iThreadBText);
        contextMenu.add(iGenomeURLBText);
        //indexingSalmonPanel
        contextMenu.add(iThreadSText);
        contextMenu.add(iGenomeURLSText);
        contextMenu.add(iGTFURLSText);
        //countingSalmon
        contextMenu.add(cThreadText);
        contextMenu.add(cAdapter5Text);
        contextMenu.add(cAdapter3Text);
        contextMenu.add(cMinLengthText);
        //filterCount
        contextMenu.add(fFPKMfileText);
        contextMenu.add(fOutputFolderText);
        //Configuration
        contextMenu.add(Adapter3TextField);
        contextMenu.add(Adapter5TextField);
        
        
        FPKMFileTable.getColumn("Folder").setPreferredWidth(1000);

        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        String HorSplPan = getPreferences().get("4SeqGUI_HorizontalSplitPanel", null);
        if (HorSplPan!=null){
         HorizontalSplitPanel.setDividerLocation(Integer.valueOf(HorSplPan));   
        }
        else{
         HorizontalSplitPanel.setDividerLocation(screenSize.height*3/10);   
        }
  
        String VerSplPan = getPreferences().get("4SeqGUI_VerticalSplitPanel", null);
        if (VerSplPan!=null){
            VerticalSplitPanel.setDividerLocation(Integer.valueOf(VerSplPan));
        }
        else {
        VerticalSplitPanel.setDividerLocation(screenSize.height*7/10);
        }
        
        String  WindowWidth= getPreferences().get("4SeqGUI_WindowWidth", null);
        String  WindowHeight= getPreferences().get("4SeqGUI_WindowHeight", null); 
        if ((WindowWidth!=null)&&(WindowHeight!=null)){
          setSize(Integer.valueOf(WindowWidth),Integer.valueOf(WindowHeight));  
        }
        else{
            setSize(screenSize.width*95/100,screenSize.height*95/100);
        }

        //OUTPUT FRAME
        int OutputframeWidth= Integer.valueOf(getPreferences().get("4SeqGUI_WindowOutputWidth", "0"));
        int OutputframeHeight= Integer.valueOf(getPreferences().get("4SeqGUI_WindowOutputHeight", "0"));
        
        if ((OutputframeWidth==0)||(OutputframeHeight==0)){
              OutputframeWidth=screenSize.width*4/100;
              OutputframeHeight=screenSize.height*5/100;
        }

        OutputFrame.setSize(OutputframeWidth,OutputframeHeight);
        
        
        int DownloadframeWidth= Integer.valueOf(getPreferences().get("4SeqGUI_WindowDownloadWidth", "0"));
        int DownloadframeHeight= Integer.valueOf(getPreferences().get("4SeqGUI_WindowDownloadHeight", "0")); 
        if ((DownloadframeWidth==0)||(DownloadframeHeight==0)){
              DownloadframeWidth=screenSize.width*4/100;
              DownloadframeHeight=screenSize.height*5/100;
        }

        DownloadFrame.setSize(DownloadframeWidth,DownloadframeHeight);
        
        String WidthGroup = getPreferences().get("4SeqGUI_GroupCellWidth", null);
        String WidthBatch = getPreferences().get("4SeqGUI_BatchCellWidth", null);
        String WidthFolder = getPreferences().get("4SeqGUI_FolderCellWidth", null);
        if ((WidthGroup!=null)&&(WidthBatch!=null)&&(WidthFolder!=null)){
             FPKMFileTable.getColumnModel().getColumn(1).setPreferredWidth(Integer.valueOf(WidthGroup));
             FPKMFileTable.getColumnModel().getColumn(2).setPreferredWidth(Integer.valueOf(WidthBatch));
             FPKMFileTable.getColumnModel().getColumn(0).setPreferredWidth(Integer.valueOf(WidthFolder));
        }    
        else
            FPKMFileTable.getColumnModel().getColumn(1).setPreferredWidth(FPKMFileTable.getWidth()*10/100);
        
        
        
        String WidthGroup1 = getPreferences().get("4SeqGUI_Group1CellWidth", null);
        String WidthBatch1 = getPreferences().get("4SeqGUI_Batch1CellWidth", null);
        String WidthHeader = getPreferences().get("4SeqGUI_HeaderCellWidth", null);
        if ((WidthGroup1!=null)&&(WidthBatch1!=null)&&(WidthHeader!=null)){
             CCountHeaderTable.getColumnModel().getColumn(1).setPreferredWidth(Integer.valueOf(WidthGroup1));
             CCountHeaderTable.getColumnModel().getColumn(2).setPreferredWidth(Integer.valueOf(WidthBatch1));
             CCountHeaderTable.getColumnModel().getColumn(0).setPreferredWidth(Integer.valueOf(WidthHeader));
        }    
        else
            CCountHeaderTable.getColumnModel().getColumn(1).setPreferredWidth(CCountHeaderTable.getWidth()*10/100);
        
 


        setLocationRelativeTo(null);
        invalidate();
        doLayout();
        
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

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        vExecution = new javax.swing.ButtonGroup();
        vSeq = new javax.swing.ButtonGroup();
        Strand = new javax.swing.ButtonGroup();
        Truncating = new javax.swing.ButtonGroup();
        Annotation = new javax.swing.ButtonGroup();
        mExecution = new javax.swing.ButtonGroup();
        mDownload = new javax.swing.ButtonGroup();
        mTrimmed = new javax.swing.ButtonGroup();
        OutputFrame = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        OutputText = new javax.swing.JTextArea();
        CloseOutput = new javax.swing.JToggleButton();
        ReloadOutput = new javax.swing.JToggleButton();
        RemoveOutput = new javax.swing.JButton();
        DlogButton = new javax.swing.JButton();
        IExecutionStarRSEM = new javax.swing.ButtonGroup();
        ConfigurationFrame = new javax.swing.JFrame();
        jLabel18 = new javax.swing.JLabel();
        ParallelTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ThreadTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Adapter5TextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Adapter3TextField = new javax.swing.JTextField();
        ConfCancell = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jMenuItem5 = new javax.swing.JMenuItem();
        CovComboBox = new javax.swing.JComboBox<>();
        DataType = new javax.swing.ButtonGroup();
        Covariates = new javax.swing.ButtonGroup();
        DEStype = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        IExecutionBWA = new javax.swing.ButtonGroup();
        GATK = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        MExecution = new javax.swing.ButtonGroup();
        MSeq = new javax.swing.ButtonGroup();
        MRemoveDuplicates = new javax.swing.ButtonGroup();
        MAdapter = new javax.swing.ButtonGroup();
        BatchComboBox = new javax.swing.JComboBox<>();
        DESBatch = new javax.swing.ButtonGroup();
        DownloadFrame = new javax.swing.JFrame();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        Downloadtext = new javax.swing.JTextField();
        About4SeqGUIFrame = new javax.swing.JFrame();
        jLabel96 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        jLabel99 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        IExecutionSalmon = new javax.swing.ButtonGroup();
        cExecutiionSalmon = new javax.swing.ButtonGroup();
        cSeq = new javax.swing.ButtonGroup();
        cStrand = new javax.swing.ButtonGroup();
        DataFilter = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MultiQCGroup = new javax.swing.ButtonGroup();
        heatmapGroup = new javax.swing.ButtonGroup();
        heatmapGroupLog = new javax.swing.ButtonGroup();
        heatmapBaseGroup = new javax.swing.ButtonGroup();
        ANOVAGroup = new javax.swing.ButtonGroup();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jButton9 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        VerticalSplitPanel = new javax.swing.JSplitPane();
        BottomPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProcStatusPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcList = new javax.swing.JList<>();
        HorizontalSplitPanel = new javax.swing.JSplitPane();
        MainPanel = new javax.swing.JPanel();
        Empty = new javax.swing.JScrollPane();
        EmptyPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        IndexingStarRSEM = new javax.swing.JScrollPane();
        IndexingStarRSEMPanel = new javax.swing.JPanel();
        iCloseButton = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        iResetButton = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        iGenomeFolderText = new javax.swing.JTextField();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jLabel30 = new javax.swing.JLabel();
        iGenomeURLText = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        iGTFURLText = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        iSudoRadioButton = new javax.swing.JRadioButton();
        iDockerRadioButton = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        iThreadText = new javax.swing.JTextField();
        mRNA = new javax.swing.JScrollPane();
        mRNAPanel = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        vCloseButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        mmiRBaseText = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        mDTrueRadioButton = new javax.swing.JRadioButton();
        mDFalseRadioButton = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        mANEBRadioButton = new javax.swing.JRadioButton();
        mAILLUMINARadioButton = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        mTTrueRadioButton = new javax.swing.JRadioButton();
        mTFalseRadioButton = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        mFastQFolderText = new javax.swing.JTextField();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        mOutputFolderText = new javax.swing.JTextField();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        mSudoRadioButton = new javax.swing.JRadioButton();
        mDockerRadioButton = new javax.swing.JRadioButton();
        FPKM = new javax.swing.JScrollPane();
        FPKMPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        FPKMFileTable = new javax.swing.JTable();
        FAddFile = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        FtypesComboBox = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        FOutputFolderText = new javax.swing.JTextField();
        Fbrowes = new javax.swing.JButton();
        Fcancel = new javax.swing.JButton();
        FExecuteButton = new javax.swing.JButton();
        FSaveButton = new javax.swing.JButton();
        FResetButton = new javax.swing.JButton();
        FCloseButton = new javax.swing.JButton();
        vmRNA = new javax.swing.JScrollPane();
        vmRNAPanel = new javax.swing.JPanel();
        vCloseButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        vFastQFolderText = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        vOutputFolderText = new javax.swing.JTextField();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        vGenomeFolderText = new javax.swing.JTextField();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        vSudoRadioButton = new javax.swing.JRadioButton();
        vDockerRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        vThreadText = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        vAdapter5Text = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vAdapter3Text = new javax.swing.JTextField();
        vPeRadioButton = new javax.swing.JRadioButton();
        vSeRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        vMinLengthText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        vSNoneRadioButton = new javax.swing.JRadioButton();
        vSForwardRadioButton = new javax.swing.JRadioButton();
        vSReverseRadioButton = new javax.swing.JRadioButton();
        vOrganismText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        vBAMyesRadioButton = new javax.swing.JRadioButton();
        vBAMnoLRadioButton = new javax.swing.JRadioButton();
        PCA = new javax.swing.JScrollPane();
        PCAPanel = new javax.swing.JPanel();
        vCloseButton2 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        pFPKMfileText = new javax.swing.JTextField();
        jToggleButton12 = new javax.swing.JToggleButton();
        fCancelButton = new javax.swing.JToggleButton();
        jLabel34 = new javax.swing.JLabel();
        pOutputFolderText = new javax.swing.JTextField();
        jToggleButton13 = new javax.swing.JToggleButton();
        fCancelButton1 = new javax.swing.JToggleButton();
        jPanel11 = new javax.swing.JPanel();
        pComponent1Text = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pComponent2Text = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        pCountsRadioButton = new javax.swing.JRadioButton();
        pFPKMRadioButton = new javax.swing.JRadioButton();
        pTPMRadioButton = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        pCovYesRadioButton = new javax.swing.JRadioButton();
        pCovNoRadioButton = new javax.swing.JRadioButton();
        pLegendComboBox = new javax.swing.JComboBox<>();
        DES = new javax.swing.JScrollPane();
        DESPanel = new javax.swing.JPanel();
        vCloseButton3 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        dFPKMfileText = new javax.swing.JTextField();
        jToggleButton14 = new javax.swing.JToggleButton();
        fCancelButton2 = new javax.swing.JToggleButton();
        jLabel36 = new javax.swing.JLabel();
        dOutputFolderText = new javax.swing.JTextField();
        jToggleButton17 = new javax.swing.JToggleButton();
        fCancelButton3 = new javax.swing.JToggleButton();
        jPanel12 = new javax.swing.JPanel();
        dLog2fcText = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        dFDRText = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        dGeneRadioButton = new javax.swing.JRadioButton();
        jLabel47 = new javax.swing.JLabel();
        dCovComboBox = new javax.swing.JComboBox<>();
        dmiRNARadioButton = new javax.swing.JRadioButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        dIsoformRadioButton = new javax.swing.JRadioButton();
        jLabel62 = new javax.swing.JLabel();
        dBatchesTrue = new javax.swing.JRadioButton();
        DBatchesFalse = new javax.swing.JRadioButton();
        IndexingBWA = new javax.swing.JScrollPane();
        IndexingBWAPanel = new javax.swing.JPanel();
        iCloseButton1 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        iResetButton1 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        iGenomeFolderBText = new javax.swing.JTextField();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jLabel46 = new javax.swing.JLabel();
        iGenomeURLBText = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        idbSPNText = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        iBTrueRadioButton = new javax.swing.JRadioButton();
        iBFalseRadioButton = new javax.swing.JRadioButton();
        i1000GenomeText = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        i1000BrowseButton = new javax.swing.JToggleButton();
        i1000CancelButton = new javax.swing.JToggleButton();
        idbSPNBrowseButton = new javax.swing.JToggleButton();
        idbSPNCancelButton = new javax.swing.JToggleButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        iSudoBRadioButton = new javax.swing.JRadioButton();
        iDockerBRadioButton = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        iThreadBText = new javax.swing.JTextField();
        MACS = new javax.swing.JScrollPane();
        MACSPanel = new javax.swing.JPanel();
        vCloseButton4 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        MOutputFolderText = new javax.swing.JTextField();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jLabel54 = new javax.swing.JLabel();
        MScratchFolderText = new javax.swing.JTextField();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jLabel55 = new javax.swing.JLabel();
        MMockFolderText = new javax.swing.JTextField();
        jToggleButton24 = new javax.swing.JToggleButton();
        jToggleButton25 = new javax.swing.JToggleButton();
        MGenomeFolderText = new javax.swing.JTextField();
        jToggleButton26 = new javax.swing.JToggleButton();
        jToggleButton27 = new javax.swing.JToggleButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        MTestFolderText = new javax.swing.JTextField();
        jToggleButton28 = new javax.swing.JToggleButton();
        jToggleButton29 = new javax.swing.JToggleButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        MSudoRadioButton = new javax.swing.JRadioButton();
        MDockerRadioButton = new javax.swing.JRadioButton();
        jLabel57 = new javax.swing.JLabel();
        MThreadText = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        MToolComboBox = new javax.swing.JComboBox<>();
        Tool = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        MMaxmfoldText = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        MMinmfoldText = new javax.swing.JTextField();
        MMpvalueText = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        MSgsizeText = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        MSWindowsText = new javax.swing.JTextField();
        MSFDRText = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        MAdapter5Text = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        MAdapter3Text = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        MTTSText = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        MRyesRadioButton = new javax.swing.JRadioButton();
        MRnoRadioButton = new javax.swing.JRadioButton();
        jLabel74 = new javax.swing.JLabel();
        MOrgComboBox = new javax.swing.JComboBox<>();
        MMinLengthText = new javax.swing.JTextField();
        MMaxUpstreamText = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        MReadLengthTextField = new javax.swing.JTextField();
        SampleSize = new javax.swing.JScrollPane();
        SampleSizePanel = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        SSOutputFolderText = new javax.swing.JTextField();
        SSbrowes = new javax.swing.JButton();
        SScancel = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        SSCountTableText = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        SSExecuteButton = new javax.swing.JButton();
        SSSaveButton = new javax.swing.JButton();
        SSResetButton = new javax.swing.JButton();
        SSCloseButton = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        SSPowerText = new javax.swing.JTextField();
        SSGeneText = new javax.swing.JTextField();
        SSlog2Text = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        SSFDRtext = new javax.swing.JTextField();
        ExperimentPower = new javax.swing.JScrollPane();
        ExperimentPowerPanel = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        EPOutputFolderText = new javax.swing.JTextField();
        SSbrowes1 = new javax.swing.JButton();
        SScancel1 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        EPCountTableText = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        EPExecuteButton1 = new javax.swing.JButton();
        EPSaveButton = new javax.swing.JButton();
        EPResetButton = new javax.swing.JButton();
        EPCloseButton = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        EPSampleText = new javax.swing.JTextField();
        EPGeneText = new javax.swing.JTextField();
        EPlog2Text = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        EPFDRtext = new javax.swing.JTextField();
        mRNABatch = new javax.swing.JScrollPane();
        mRNABatchPanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        CCountHeaderTable = new javax.swing.JTable();
        CCovInputFileText = new javax.swing.JTextField();
        Cinbrowes = new javax.swing.JButton();
        Cincancel = new javax.swing.JButton();
        jLabel98 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        COutputFolderText = new javax.swing.JTextField();
        Coutbrowes = new javax.swing.JButton();
        Coutcancel = new javax.swing.JButton();
        FExecuteButton1 = new javax.swing.JButton();
        FSaveButton1 = new javax.swing.JButton();
        CResetButton1 = new javax.swing.JButton();
        CCloseButton1 = new javax.swing.JButton();
        IndexingSalmon = new javax.swing.JScrollPane();
        IndexingSalmonPanel = new javax.swing.JPanel();
        iCloseButton2 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        iResetButton2 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        iGenomeFolderSText = new javax.swing.JTextField();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jLabel104 = new javax.swing.JLabel();
        iGenomeURLSText = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        iGTFURLSText = new javax.swing.JTextField();
        iKmerSText = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        iSudoRadioSButton = new javax.swing.JRadioButton();
        iDockerRadioSButton = new javax.swing.JRadioButton();
        jLabel107 = new javax.swing.JLabel();
        iThreadSText = new javax.swing.JTextField();
        CountingSalmon = new javax.swing.JScrollPane();
        CountingSalmonPanel = new javax.swing.JPanel();
        vCloseButton5 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        cFastQFolderText = new javax.swing.JTextField();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jLabel111 = new javax.swing.JLabel();
        cOutputFolderText = new javax.swing.JTextField();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jLabel112 = new javax.swing.JLabel();
        cGenomeFolderText = new javax.swing.JTextField();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        cSudoRadioButton = new javax.swing.JRadioButton();
        cDockerRadioButton = new javax.swing.JRadioButton();
        jLabel114 = new javax.swing.JLabel();
        cThreadText = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        cAdapter5Text = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        cAdapter3Text = new javax.swing.JTextField();
        cPeRadioButton = new javax.swing.JRadioButton();
        cSeRadioButton = new javax.swing.JRadioButton();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        cMinLengthText = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        cSNoneRadioButton = new javax.swing.JRadioButton();
        cSForwardRadioButton = new javax.swing.JRadioButton();
        cSReverseRadioButton = new javax.swing.JRadioButton();
        filterCounts = new javax.swing.JScrollPane();
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
        MultiQC = new javax.swing.JScrollPane();
        MultiQCpanel = new javax.swing.JPanel();
        jButton45 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        vCloseButton7 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        QdataFolderText = new javax.swing.JTextField();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        QSudoRadioButton = new javax.swing.JRadioButton();
        QDockerRadioButton = new javax.swing.JRadioButton();
        Heatmap = new javax.swing.JScrollPane();
        Heatmappanel = new javax.swing.JPanel();
        jButton46 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        vCloseButton8 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        HscratchText = new javax.swing.JTextField();
        jToggleButton42 = new javax.swing.JToggleButton();
        jToggleButton43 = new javax.swing.JToggleButton();
        jLabel131 = new javax.swing.JLabel();
        HdataFileText = new javax.swing.JTextField();
        jToggleButton44 = new javax.swing.JToggleButton();
        jToggleButton45 = new javax.swing.JToggleButton();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        HStatus1RadioButton = new javax.swing.JRadioButton();
        HStatus0RadioButton = new javax.swing.JRadioButton();
        jToggleButton46 = new javax.swing.JToggleButton();
        jToggleButton47 = new javax.swing.JToggleButton();
        HOutputFolderText = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        HLowerRangeText = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        HUpperRangeText = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        HSudoRadioButton = new javax.swing.JRadioButton();
        HDockerRadioButton = new javax.swing.JRadioButton();
        ANOVAlike = new javax.swing.JScrollPane();
        ANOVAlikePanel = new javax.swing.JPanel();
        vCloseButton9 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        ANinputfileText = new javax.swing.JTextField();
        jToggleButton48 = new javax.swing.JToggleButton();
        fCancelButton6 = new javax.swing.JToggleButton();
        jLabel123 = new javax.swing.JLabel();
        ANOutputFolderText = new javax.swing.JTextField();
        jToggleButton49 = new javax.swing.JToggleButton();
        fCancelButton7 = new javax.swing.JToggleButton();
        jPanel40 = new javax.swing.JPanel();
        ANLog2fcText = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        ANLogCPMText = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        ANadjPText = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        ANSudoRadioButton = new javax.swing.JRadioButton();
        ANDockerRadioButton1 = new javax.swing.JRadioButton();
        LeftPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        RNAseqPanel = new javax.swing.JPanel();
        SalmonIndexingButton = new javax.swing.JButton();
        vmRNAButton = new javax.swing.JButton();
        mRNAButton = new javax.swing.JButton();
        PCAButton = new javax.swing.JButton();
        countingSalmonButton = new javax.swing.JButton();
        SampleExpButton = new javax.swing.JButton();
        CountButton = new javax.swing.JButton();
        SampleSizeButton = new javax.swing.JButton();
        ExpPowerButton = new javax.swing.JButton();
        DeseqButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ANOVAlikeButton = new javax.swing.JButton();
        miRNAPanel = new javax.swing.JPanel();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        PCAButton1 = new javax.swing.JButton();
        CountButton1 = new javax.swing.JButton();
        SampleSizeButton1 = new javax.swing.JButton();
        ExpPowerButton1 = new javax.swing.JButton();
        DeseqButton2 = new javax.swing.JButton();
        ChipSeqPanel = new javax.swing.JPanel();
        indexingBButton = new javax.swing.JButton();
        CountButton2 = new javax.swing.JButton();
        ToolPanel = new javax.swing.JPanel();
        MultiQCButton = new javax.swing.JButton();
        HeatmapButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        OutputFrame.setTitle("Process Output");
        OutputFrame.setAlwaysOnTop(true);
        OutputFrame.setLocation(new java.awt.Point(100, 100));
        OutputFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                OutputFrameWindowClosing(evt);
            }
        });
        OutputFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        OutputText.setEditable(false);
        OutputText.setColumns(20);
        OutputText.setRows(5);
        jScrollPane3.setViewportView(OutputText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OutputFrame.getContentPane().add(jScrollPane3, gridBagConstraints);

        CloseOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        CloseOutput.setText("Close");
        CloseOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseOutputActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OutputFrame.getContentPane().add(CloseOutput, gridBagConstraints);

        ReloadOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        ReloadOutput.setText("Reload Output");
        ReloadOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReloadOutputActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OutputFrame.getContentPane().add(ReloadOutput, gridBagConstraints);

        RemoveOutput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/remove.png"))); // NOI18N
        RemoveOutput.setText("Remove Entry");
        RemoveOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveOutputActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OutputFrame.getContentPane().add(RemoveOutput, gridBagConstraints);

        DlogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/log.png"))); // NOI18N
        DlogButton.setText("Docker Logs");
        DlogButton.setEnabled(false);
        DlogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DlogButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        OutputFrame.getContentPane().add(DlogButton, gridBagConstraints);

        ConfigurationFrame.setTitle("Configuration");
        ConfigurationFrame.setLocation(new java.awt.Point(200, 200));
        ConfigurationFrame.setName("ConfigurationFrame"); // NOI18N
        ConfigurationFrame.setResizable(false);

        jLabel18.setText("Maximum number of parallel proceses:");

        jLabel19.setText("Maximum number of threads for process:");

        jLabel21.setText("Default adapter 5':");

        jLabel22.setText("Default adapter 3':");

        ConfCancell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        ConfCancell.setText("Cancel");
        ConfCancell.setToolTipText("");
        ConfCancell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfCancellActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton10.setText("Save&Close");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfigurationFrameLayout = new javax.swing.GroupLayout(ConfigurationFrame.getContentPane());
        ConfigurationFrame.getContentPane().setLayout(ConfigurationFrameLayout);
        ConfigurationFrameLayout.setHorizontalGroup(
            ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                        .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ParallelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                            .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ThreadTextField)))
                        .addGap(627, 627, 627))
                    .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Adapter5TextField)
                        .addContainerGap())
                    .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Adapter3TextField)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConfigurationFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(ConfCancell)
                .addContainerGap())
        );
        ConfigurationFrameLayout.setVerticalGroup(
            ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfigurationFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ParallelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ThreadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(Adapter5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(Adapter3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(ConfigurationFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfCancell)
                    .addComponent(jButton10)
                    .addComponent(jButton11))
                .addContainerGap())
        );

        jMenuItem5.setText("jMenuItem5");

        CovComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cov.1", "Cov.2", "Cov.3", "Cov.4", "Cov.5", "Cov.6", "Cov.7", "Cov.8", "Cov.9", "Cov.10", "Cov.11", "Cov.12", "Cov.13", "Cov.14", "Cov.15", "Cov.16", "Cov.17", "Cov.18", "Cov.19", "Cov.20", "Cov.21", "Cov.22", "Cov.23", "Cov.24", "Cov.25", "Cov.26", "Cov.27", "Cov.28", "Cov.29", "Cov.30" }));

        jRadioButton1.setText("jRadioButton1");

        BatchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Batch1", "Batch2", "Batch3", "Batch4", "Batch5", "Batch6", "Batch7", "Batch8", "Batch9", "Batch10", "Batch11", "Batch12", "Batch13", "Batch14", "Batch15", "Batch16", "Batch17", "Batch18", "Batch19", "Batch20" }));

        DownloadFrame.setTitle("Download Docker imges");
        DownloadFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        jButton31.setText("Cancel");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 8);
        DownloadFrame.getContentPane().add(jButton31, gridBagConstraints);

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/downloadb.png"))); // NOI18N
        jButton32.setText("Download");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DownloadFrame.getContentPane().add(jButton32, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(194, 238, 194));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select a subset of Images (Optional)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 102, 51))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel12.setText("Container list  file: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        jPanel1.add(jLabel12, gridBagConstraints);

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton33.setText("Cancel");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton33, gridBagConstraints);

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jButton34.setText("Browse ");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jButton34, gridBagConstraints);

        Downloadtext.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 10, 10);
        jPanel1.add(Downloadtext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        DownloadFrame.getContentPane().add(jPanel1, gridBagConstraints);

        About4SeqGUIFrame.setTitle("About 4SeqGUI");
        About4SeqGUIFrame.setResizable(false);
        About4SeqGUIFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/4SeqGUI.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 10, 1);
        About4SeqGUIFrame.getContentPane().add(jLabel96, gridBagConstraints);

        jLabel100.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel100.setText("Version 3.2.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        About4SeqGUIFrame.getContentPane().add(jLabel100, gridBagConstraints);

        jLabel101.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel101.setText("Copyright © January 2017");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        About4SeqGUIFrame.getContentPane().add(jLabel101, gridBagConstraints);

        jButton36.setText("OK");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        About4SeqGUIFrame.getContentPane().add(jButton36, gridBagConstraints);

        jLabel99.setFont(jLabel99.getFont());
        jLabel99.setText("M. Beccuti, R. Calogero and F. Cordero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 10, 20);
        About4SeqGUIFrame.getContentPane().add(jLabel99, gridBagConstraints);
        About4SeqGUIFrame.getContentPane().add(jLabel102, new java.awt.GridBagConstraints());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4SeqGUI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jToolBar1.setBackground(new java.awt.Color(237, 237, 237));
        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52.png"))); // NOI18N
        jButton1.setToolTipText("Open a previous execution");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 5));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86.png"))); // NOI18N
        jButton2.setToolTipText("Save current executions");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/preference.png"))); // NOI18N
        jToggleButton11.setToolTipText("Configure 4SeqGUI");
        jToggleButton11.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        jToggleButton11.setFocusable(false);
        jToggleButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton11);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/docker.png"))); // NOI18N
        jButton9.setToolTipText("Remove docker containers");
        jButton9.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/download.png"))); // NOI18N
        jButton26.setToolTipText("Download docker images");
        jButton26.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton26.setFocusable(false);
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setMargin(new java.awt.Insets(2, 140, 2, 140));
        jButton26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton26);

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/iconDNA-small.png"))); // NOI18N
        jButton35.setToolTipText("About 4SeqGUI");
        jButton35.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        jButton35.setFocusable(false);
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton35);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        VerticalSplitPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        VerticalSplitPanel.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        BottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BottomPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane4.setBorder(null);
        jScrollPane4.setToolTipText("");

        ProcStatusPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setBorder(null);

        ProcList.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1), "Process status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 82, 150))); // NOI18N
        ProcList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ProcList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcListMouseClicked(evt);
            }
        });
        ProcList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ProcListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ProcList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        ProcStatusPanel.add(jScrollPane2, gridBagConstraints);

        jScrollPane4.setViewportView(ProcStatusPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        BottomPanel.add(jScrollPane4, gridBagConstraints);

        VerticalSplitPanel.setBottomComponent(BottomPanel);

        HorizontalSplitPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new java.awt.CardLayout());

        Empty.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        EmptyPanel.setBackground(new java.awt.Color(255, 255, 255));
        EmptyPanel.setLayout(new java.awt.GridBagLayout());

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/background.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        EmptyPanel.add(jLabel24, gridBagConstraints);

        Empty.setViewportView(EmptyPanel);

        MainPanel.add(Empty, "Empty");

        IndexingStarRSEM.setBorder(null);

        IndexingStarRSEMPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Genome indexing STAR-RSEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        IndexingStarRSEMPanel.setToolTipText("");
        IndexingStarRSEMPanel.setLayout(new java.awt.GridBagLayout());

        iCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        iCloseButton.setText("Close");
        iCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(iCloseButton, gridBagConstraints);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton12.setText("Execute");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(jButton12, gridBagConstraints);

        iResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        iResetButton.setText("Reset");
        iResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iResetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(iResetButton, gridBagConstraints);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton14.setText("Save conf.");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(jButton14, gridBagConstraints);

        jPanel13.setBackground(new java.awt.Color(248, 248, 248));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel28.setText("Genome  folder:");
        jLabel28.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(jLabel28, gridBagConstraints);

        iGenomeFolderText.setEditable(false);
        iGenomeFolderText.setToolTipText("The folder that will contain the indexed genome.");
        iGenomeFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iGenomeFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(iGenomeFolderText, gridBagConstraints);

        jToggleButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton15.setText("Browse");
        jToggleButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(jToggleButton15, gridBagConstraints);

        jToggleButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton16.setText("Cancel");
        jToggleButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(jToggleButton16, gridBagConstraints);

        jLabel30.setText("Genome url:");
        jLabel30.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(jLabel30, gridBagConstraints);

        iGenomeURLText.setToolTipText("The URL which will be used to download the genome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(iGenomeURLText, gridBagConstraints);

        jLabel33.setText("GTF url:");
        jLabel33.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(jLabel33, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel13.add(iGTFURLText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(jPanel13, gridBagConstraints);

        jPanel14.setBackground(new java.awt.Color(248, 248, 248));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setLayout(new java.awt.GridBagLayout());

        jLabel31.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel14.add(jLabel31, gridBagConstraints);

        iSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        IExecutionStarRSEM.add(iSudoRadioButton);
        iSudoRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel14.add(iSudoRadioButton, gridBagConstraints);

        iDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        IExecutionStarRSEM.add(iDockerRadioButton);
        iDockerRadioButton.setSelected(true);
        iDockerRadioButton.setText("docker");
        iDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel14.add(iDockerRadioButton, gridBagConstraints);

        jLabel32.setText("Thread number:");
        jLabel32.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel14.add(jLabel32, gridBagConstraints);

        iThreadText.setText("8");
        iThreadText.setToolTipText("The number of threads which will be used during the computation.");
        iThreadText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                iThreadTextFocusLost(evt);
            }
        });
        iThreadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iThreadTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel14.add(iThreadText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingStarRSEMPanel.add(jPanel14, gridBagConstraints);

        IndexingStarRSEM.setViewportView(IndexingStarRSEMPanel);

        MainPanel.add(IndexingStarRSEM, "indexing");

        mRNA.setBorder(null);

        mRNAPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "miRNA counting", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(141, 38, 56))); // NOI18N
        mRNAPanel.setLayout(new java.awt.GridBagLayout());

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton6.setText("Execute");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jButton6, gridBagConstraints);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton8.setText("Save conf.");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jButton8, gridBagConstraints);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton7.setText("Reset");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jButton7, gridBagConstraints);

        vCloseButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton1.setText("Close");
        vCloseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(vCloseButton1, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(248, 248, 248));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel17.setText("miRBase organism:");
        jLabel17.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(jLabel17, gridBagConstraints);

        mmiRBaseText.setText("hsa");
        mmiRBaseText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mmiRBaseTextFocusLost(evt);
            }
        });
        mmiRBaseText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmiRBaseTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mmiRBaseText, gridBagConstraints);

        jLabel20.setText("mirBase donwload: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(jLabel20, gridBagConstraints);

        mDTrueRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mDownload.add(mDTrueRadioButton);
        mDTrueRadioButton.setText("True");
        mDTrueRadioButton.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mDTrueRadioButton, gridBagConstraints);

        mDFalseRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mDownload.add(mDFalseRadioButton);
        mDFalseRadioButton.setText("False");
        mDFalseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDFalseRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mDFalseRadioButton, gridBagConstraints);

        jLabel23.setText("Adapter type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(jLabel23, gridBagConstraints);

        mANEBRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MAdapter.add(mANEBRadioButton);
        mANEBRadioButton.setText("NEB");
        mANEBRadioButton.setToolTipText("");
        mANEBRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mANEBRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mANEBRadioButton, gridBagConstraints);

        mAILLUMINARadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MAdapter.add(mAILLUMINARadioButton);
        mAILLUMINARadioButton.setText("ILLUMINA");
        mAILLUMINARadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAILLUMINARadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mAILLUMINARadioButton, gridBagConstraints);

        jLabel25.setText("Save trimmed Fastq:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(jLabel25, gridBagConstraints);

        mTTrueRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mTrimmed.add(mTTrueRadioButton);
        mTTrueRadioButton.setText("True");
        mTTrueRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTTrueRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mTTrueRadioButton, gridBagConstraints);

        mTFalseRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mTrimmed.add(mTFalseRadioButton);
        mTFalseRadioButton.setText("False");
        mTFalseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTFalseRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel9.add(mTFalseRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jPanel9, gridBagConstraints);

        jPanel8.setBackground(new java.awt.Color(248, 248, 248));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel15.setText("FastQ  folder:");
        jLabel15.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel15, gridBagConstraints);

        mFastQFolderText.setEditable(false);
        mFastQFolderText.setToolTipText("The folder containing the input reads");
        mFastQFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mFastQFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel8.add(mFastQFolderText, gridBagConstraints);

        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton8.setText("Browse");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jToggleButton8, gridBagConstraints);

        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton7.setText("Cancel");
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jToggleButton7, gridBagConstraints);

        mOutputFolderText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel8.add(mOutputFolderText, gridBagConstraints);

        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton9.setText("Cancel");
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jToggleButton9, gridBagConstraints);

        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton10.setText("Browse");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jToggleButton10, gridBagConstraints);

        jLabel16.setText("Scratch folder:");
        jLabel16.setToolTipText("This folder will be mounted in the docker container");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel8.add(jLabel16, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jPanel8, gridBagConstraints);

        jPanel7.setBackground(new java.awt.Color(248, 248, 248));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel14.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(jLabel14, gridBagConstraints);

        mSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(mSudoRadioButton);
        mSudoRadioButton.setText("sudo");
        mSudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 85, 10, 10);
        jPanel7.add(mSudoRadioButton, gridBagConstraints);

        mDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        mExecution.add(mDockerRadioButton);
        mDockerRadioButton.setText("docker");
        mDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel7.add(mDockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNAPanel.add(jPanel7, gridBagConstraints);

        mRNA.setViewportView(mRNAPanel);

        MainPanel.add(mRNA, "mRNA");

        FPKM.setBorder(null);

        FPKMPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "From samples to experiment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(102, 0, 153))); // NOI18N
        FPKMPanel.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(248, 248, 248));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        FPKMFileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folder", "Grouping", "Batch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        FPKMFileTable.setColumnSelectionAllowed(true);
        FPKMFileTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        FPKMFileTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(FPKMFileTable);
        FPKMFileTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (FPKMFileTable.getColumnModel().getColumnCount() > 0) {
            FPKMFileTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(CovComboBox));
            FPKMFileTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(BatchComboBox));
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jScrollPane6, gridBagConstraints);

        FAddFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        FAddFile.setText("Add");
        FAddFile.setToolTipText("");
        FAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FAddFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(FAddFile, gridBagConstraints);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/remove.png"))); // NOI18N
        jButton13.setText("Remove");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jButton13, gridBagConstraints);

        jLabel26.setText("Biological Types:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel26, gridBagConstraints);

        FtypesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "protein_coding", "unitary_pseudogene", "unprocessed_pseudogene", "processed_pseudogene", "transcribed_unprocessed_pseudogene", "processed_transcript", "antisense", "transcribed_unitary_pseudogene", "polymorphic_pseudogene", "lincRNA", "sense_intronic", "transcribed_processed_pseudogene", "sense_overlapping", "IG_V_pseudogene", "pseudogene", "TR_V_gene", "3prime_overlapping_ncRNA", "IG_V_gene", "bidirectional_promoter_lncRNA", "snRNA", "miRNA", "misc_RNA", "snoRNA", "rRNA", "IG_C_gene", "IG_J_gene", "TR_J_gene", "TR_C_gene", "TR_V_pseudogene", "TR_J_pseudogene", "IG_D_gene", "ribozyme", "IG_C_pseudogene", "TR_D_gene", "TEC", "IG_J_pseudogene", "scRNA", "scaRNA", "vaultRNA", "sRNA", "macro_lncRNA", "non_coding", "IG_pseudogene" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(FtypesComboBox, gridBagConstraints);

        jLabel27.setText("Output Folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(jLabel27, gridBagConstraints);

        FOutputFolderText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(FOutputFolderText, gridBagConstraints);

        Fbrowes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        Fbrowes.setText("Browse");
        Fbrowes.setToolTipText("");
        Fbrowes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FbrowesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(Fbrowes, gridBagConstraints);

        Fcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        Fcancel.setText("Cancel");
        Fcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FcancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel4.add(Fcancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FPKMPanel.add(jPanel4, gridBagConstraints);

        FExecuteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        FExecuteButton.setText("Execute");
        FExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FExecuteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FPKMPanel.add(FExecuteButton, gridBagConstraints);

        FSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        FSaveButton.setText("Save conf.");
        FSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FSaveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FPKMPanel.add(FSaveButton, gridBagConstraints);

        FResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        FResetButton.setText("Reset");
        FResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FResetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FPKMPanel.add(FResetButton, gridBagConstraints);

        FCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        FCloseButton.setText("Close");
        FCloseButton.setToolTipText("");
        FCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FCloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        FPKMPanel.add(FCloseButton, gridBagConstraints);

        FPKM.setViewportView(FPKMPanel);

        MainPanel.add(FPKM, "FPKMCounting");

        vmRNA.setBorder(null);

        vmRNAPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Genes, isoforms counting RSEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 102, 102))); // NOI18N
        vmRNAPanel.setToolTipText("");
        vmRNAPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton.setText("Close");
        vCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(vCloseButton, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton4.setText("Execute");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jButton4, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jButton5, gridBagConstraints);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton3.setText("Save conf.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jButton3, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(248, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("FastQ  folder:");
        jLabel2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel2, gridBagConstraints);

        vFastQFolderText.setEditable(false);
        vFastQFolderText.setToolTipText("The folder containing the input reads in FastQ format.");
        vFastQFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vFastQFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel2.add(vFastQFolderText, gridBagConstraints);

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton2.setText("Browse");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton2, gridBagConstraints);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton1.setText("Cancel");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton1, gridBagConstraints);

        jLabel3.setText("Scratch folder:");
        jLabel3.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel3, gridBagConstraints);

        vOutputFolderText.setEditable(false);
        vOutputFolderText.setToolTipText("This folder will be mounted in the docker container.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel2.add(vOutputFolderText, gridBagConstraints);

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton4.setText("Browse");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton4, gridBagConstraints);

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton3.setText("Cancel");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton3, gridBagConstraints);

        jLabel9.setText("Genome folder:");
        jLabel9.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel9, gridBagConstraints);

        vGenomeFolderText.setEditable(false);
        vGenomeFolderText.setToolTipText("The folder containing the indexed genome.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel2.add(vGenomeFolderText, gridBagConstraints);

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton5.setText("Browse");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton5, gridBagConstraints);

        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton6.setText("Cancel");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jToggleButton6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jPanel2, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(248, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel1, gridBagConstraints);

        vSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        vExecution.add(vSudoRadioButton);
        vSudoRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel3.add(vSudoRadioButton, gridBagConstraints);

        vDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        vExecution.add(vDockerRadioButton);
        vDockerRadioButton.setSelected(true);
        vDockerRadioButton.setText("docker");
        vDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(vDockerRadioButton, gridBagConstraints);

        jLabel4.setText("Thread number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel3.add(jLabel4, gridBagConstraints);

        vThreadText.setText("8");
        vThreadText.setToolTipText("The number of threads which will be used during the computation.");
        vThreadText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vThreadTextFocusLost(evt);
            }
        });
        vThreadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vThreadTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel3.add(vThreadText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jPanel3, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(248, 248, 248));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        vAdapter5Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vAdapter5TextFocusLost(evt);
            }
        });
        vAdapter5Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vAdapter5TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vAdapter5Text, gridBagConstraints);

        jLabel5.setText("Adapter 5':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Adapter 3':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel6, gridBagConstraints);

        vAdapter3Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vAdapter3TextFocusLost(evt);
            }
        });
        vAdapter3Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vAdapter3TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vAdapter3Text, gridBagConstraints);

        vPeRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        vSeq.add(vPeRadioButton);
        vPeRadioButton.setSelected(true);
        vPeRadioButton.setText("paired-end");
        vPeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vPeRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vPeRadioButton, gridBagConstraints);

        vSeRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        vSeq.add(vSeRadioButton);
        vSeRadioButton.setText("single-end");
        vSeRadioButton.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vSeRadioButton, gridBagConstraints);

        jLabel7.setText("Type of Sequence");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Min length:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel8, gridBagConstraints);

        vMinLengthText.setText("40");
        vMinLengthText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vMinLengthTextFocusLost(evt);
            }
        });
        vMinLengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vMinLengthTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vMinLengthText, gridBagConstraints);

        jLabel10.setText("Strandness:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel10, gridBagConstraints);

        vSNoneRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Strand.add(vSNoneRadioButton);
        vSNoneRadioButton.setSelected(true);
        vSNoneRadioButton.setText("none");
        vSNoneRadioButton.setToolTipText("");
        vSNoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vSNoneRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vSNoneRadioButton, gridBagConstraints);

        vSForwardRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Strand.add(vSForwardRadioButton);
        vSForwardRadioButton.setText("forward");
        vSForwardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vSForwardRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vSForwardRadioButton, gridBagConstraints);

        vSReverseRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Strand.add(vSReverseRadioButton);
        vSReverseRadioButton.setText("reverse");
        vSReverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vSReverseRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vSReverseRadioButton, gridBagConstraints);

        vOrganismText.setText("hg38");
        vOrganismText.setToolTipText("");
        vOrganismText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vOrganismTextFocusLost(evt);
            }
        });
        vOrganismText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vOrganismTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vOrganismText, gridBagConstraints);

        jLabel11.setText("Organism:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel13.setText("Save alignments:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(jLabel13, gridBagConstraints);

        vBAMyesRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Annotation.add(vBAMyesRadioButton);
        vBAMyesRadioButton.setText("Yes");
        vBAMyesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBAMyesRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vBAMyesRadioButton, gridBagConstraints);

        vBAMnoLRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Annotation.add(vBAMnoLRadioButton);
        vBAMnoLRadioButton.setSelected(true);
        vBAMnoLRadioButton.setText("No");
        vBAMnoLRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vBAMnoLRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(vBAMnoLRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        vmRNAPanel.add(jPanel6, gridBagConstraints);

        vmRNA.setViewportView(vmRNAPanel);

        MainPanel.add(vmRNA, "vmRNA");

        PCA.setBorder(null);

        PCAPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "PCA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(204, 102, 0))); // NOI18N
        PCAPanel.setToolTipText("");
        PCAPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton2.setText("Close");
        vCloseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(vCloseButton2, gridBagConstraints);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton15.setText("Execute");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(jButton15, gridBagConstraints);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton16.setText("Reset");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(jButton16, gridBagConstraints);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton17.setText("Save conf.");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(jButton17, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(248, 248, 248));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel29.setText("Output folders:");
        jLabel29.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel29, gridBagConstraints);

        pFPKMfileText.setEditable(false);
        pFPKMfileText.setToolTipText("Input data folder.");
        pFPKMfileText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFPKMfileTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel5.add(pFPKMfileText, gridBagConstraints);

        jToggleButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jToggleButton12.setText("Browse");
        jToggleButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jToggleButton12, gridBagConstraints);

        fCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton.setText("Cancel");
        fCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(fCancelButton, gridBagConstraints);

        jLabel34.setText("Input  file:");
        jLabel34.setToolTipText("TheCounts or FPKM or TPM table file name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jLabel34, gridBagConstraints);

        pOutputFolderText.setEditable(false);
        pOutputFolderText.setToolTipText("Output data folder.");
        pOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel5.add(pOutputFolderText, gridBagConstraints);

        jToggleButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton13.setText("Browse");
        jToggleButton13.setEnabled(false);
        jToggleButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(jToggleButton13, gridBagConstraints);

        fCancelButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton1.setText("Cancel");
        fCancelButton1.setEnabled(false);
        fCancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel5.add(fCancelButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(jPanel5, gridBagConstraints);

        jPanel11.setBackground(new java.awt.Color(248, 248, 248));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        pComponent1Text.setToolTipText("First component number");
        pComponent1Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pComponent1TextFocusLost(evt);
            }
        });
        pComponent1Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pComponent1TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pComponent1Text, gridBagConstraints);

        jLabel38.setText("Component 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(jLabel38, gridBagConstraints);

        jLabel39.setText("Component 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(jLabel39, gridBagConstraints);

        pComponent2Text.setToolTipText("Second componet number");
        pComponent2Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pComponent2TextFocusLost(evt);
            }
        });
        pComponent2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pComponent2TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pComponent2Text, gridBagConstraints);

        jLabel42.setText("Data type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(jLabel42, gridBagConstraints);

        pCountsRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataType.add(pCountsRadioButton);
        pCountsRadioButton.setText("counts");
        pCountsRadioButton.setToolTipText("");
        pCountsRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCountsRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pCountsRadioButton, gridBagConstraints);

        pFPKMRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataType.add(pFPKMRadioButton);
        pFPKMRadioButton.setSelected(true);
        pFPKMRadioButton.setText("FPKM");
        pFPKMRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFPKMRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pFPKMRadioButton, gridBagConstraints);

        pTPMRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DataType.add(pTPMRadioButton);
        pTPMRadioButton.setText("TPM");
        pTPMRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pTPMRadioButtonActionPerformed(evt);
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
        jPanel11.add(pTPMRadioButton, gridBagConstraints);

        jLabel43.setText("Legend position:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(jLabel43, gridBagConstraints);

        jLabel44.setText("Covariates:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(jLabel44, gridBagConstraints);

        pCovYesRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Covariates.add(pCovYesRadioButton);
        pCovYesRadioButton.setSelected(true);
        pCovYesRadioButton.setText("yes");
        pCovYesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCovYesRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pCovYesRadioButton, gridBagConstraints);

        pCovNoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        Covariates.add(pCovNoRadioButton);
        pCovNoRadioButton.setText("no");
        pCovNoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pCovNoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pCovNoRadioButton, gridBagConstraints);

        pLegendComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bottom", "bottomleft", "left", "topleft", "top", "topright", "right", "center" }));
        pLegendComboBox.setSelectedIndex(1);
        pLegendComboBox.setToolTipText("Plot legend position.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel11.add(pLegendComboBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PCAPanel.add(jPanel11, gridBagConstraints);

        PCA.setViewportView(PCAPanel);

        MainPanel.add(PCA, "PCA");

        DES.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        DESPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "DESeq2 analysis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 153, 204))); // NOI18N
        DESPanel.setToolTipText("");
        DESPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton3.setText("Close");
        vCloseButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(vCloseButton3, gridBagConstraints);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton18.setText("Execute");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(jButton18, gridBagConstraints);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton19.setText("Reset");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(jButton19, gridBagConstraints);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton20.setText("Save conf.");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(jButton20, gridBagConstraints);

        jPanel10.setBackground(new java.awt.Color(248, 248, 248));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel35.setText("Output folders:");
        jLabel35.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(jLabel35, gridBagConstraints);

        dFPKMfileText.setEditable(false);
        dFPKMfileText.setToolTipText("Input data folder.");
        dFPKMfileText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dFPKMfileTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 65, 10, 10);
        jPanel10.add(dFPKMfileText, gridBagConstraints);

        jToggleButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jToggleButton14.setText("Browse");
        jToggleButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(jToggleButton14, gridBagConstraints);

        fCancelButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton2.setText("Cancel");
        fCancelButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(fCancelButton2, gridBagConstraints);

        jLabel36.setText("Count file:");
        jLabel36.setToolTipText("The FPKM or TPM table file nam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(jLabel36, gridBagConstraints);

        dOutputFolderText.setEditable(false);
        dOutputFolderText.setToolTipText("Output data folder.");
        dOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 65, 10, 10);
        jPanel10.add(dOutputFolderText, gridBagConstraints);

        jToggleButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton17.setText("Browse");
        jToggleButton17.setEnabled(false);
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(jToggleButton17, gridBagConstraints);

        fCancelButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton3.setText("Cancel");
        fCancelButton3.setEnabled(false);
        fCancelButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel10.add(fCancelButton3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(jPanel10, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(248, 248, 248));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        dLog2fcText.setToolTipText("Log_2 fold change threshold for differetially expressed genes");
        dLog2fcText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dLog2fcTextFocusLost(evt);
            }
        });
        dLog2fcText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dLog2fcTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dLog2fcText, gridBagConstraints);

        jLabel40.setText("Log2fc threshold:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel40, gridBagConstraints);

        jLabel41.setText("adj. p-value threshold:");
        jLabel41.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel41, gridBagConstraints);

        dFDRText.setToolTipText("adjusted p-value  threshold");
        dFDRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dFDRTextFocusLost(evt);
            }
        });
        dFDRText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dFDRTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dFDRText, gridBagConstraints);

        jLabel45.setText("Data type:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel45, gridBagConstraints);

        dGeneRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DEStype.add(dGeneRadioButton);
        dGeneRadioButton.setText("gene");
        dGeneRadioButton.setToolTipText("");
        dGeneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dGeneRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dGeneRadioButton, gridBagConstraints);

        jLabel47.setText("Ref. Covariates:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel47, gridBagConstraints);

        dCovComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cov.1", "Cov.2", "Cov.3", "Cov.4", "Cov.5", "Cov.6", "Cov.7", "Cov.8", "Cov.9", "Cov.10" }));
        dCovComboBox.setToolTipText("Plot legend position.");
        dCovComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dCovComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dCovComboBox, gridBagConstraints);

        dmiRNARadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DEStype.add(dmiRNARadioButton);
        dmiRNARadioButton.setText("miRNA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dmiRNARadioButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        jPanel12.add(jLabel58, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        jPanel12.add(jLabel59, gridBagConstraints);

        dIsoformRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        DEStype.add(dIsoformRadioButton);
        dIsoformRadioButton.setSelected(true);
        dIsoformRadioButton.setText("isoform");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dIsoformRadioButton, gridBagConstraints);

        jLabel62.setText("Batches:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(jLabel62, gridBagConstraints);

        dBatchesTrue.setBackground(new java.awt.Color(248, 248, 248));
        DESBatch.add(dBatchesTrue);
        dBatchesTrue.setText("TRUE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(dBatchesTrue, gridBagConstraints);

        DBatchesFalse.setBackground(new java.awt.Color(248, 248, 248));
        DESBatch.add(DBatchesFalse);
        DBatchesFalse.setSelected(true);
        DBatchesFalse.setText("FALSE");
        DBatchesFalse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBatchesFalseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel12.add(DBatchesFalse, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DESPanel.add(jPanel12, gridBagConstraints);

        DES.setViewportView(DESPanel);

        MainPanel.add(DES, "DES");

        IndexingBWA.setBorder(null);

        IndexingBWAPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Genome indexing BWA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N
        IndexingBWAPanel.setToolTipText("");
        IndexingBWAPanel.setLayout(new java.awt.GridBagLayout());

        iCloseButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        iCloseButton1.setText("Close");
        iCloseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCloseButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(iCloseButton1, gridBagConstraints);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton21.setText("Execute");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(jButton21, gridBagConstraints);

        iResetButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        iResetButton1.setText("Reset");
        iResetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iResetButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(iResetButton1, gridBagConstraints);

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton22.setText("Save conf.");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(jButton22, gridBagConstraints);

        jPanel15.setBackground(new java.awt.Color(247, 248, 248));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jLabel37.setText("Genome  folder:");
        jLabel37.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jLabel37, gridBagConstraints);

        iGenomeFolderBText.setEditable(false);
        iGenomeFolderBText.setToolTipText("The folder that will contain the indexed genome.");
        iGenomeFolderBText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iGenomeFolderBTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel15.add(iGenomeFolderBText, gridBagConstraints);

        jToggleButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton18.setText("Browse");
        jToggleButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jToggleButton18, gridBagConstraints);

        jToggleButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton19.setText("Cancel");
        jToggleButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton19ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jToggleButton19, gridBagConstraints);

        jLabel46.setText("USCS Genome url:");
        jLabel46.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jLabel46, gridBagConstraints);

        iGenomeURLBText.setToolTipText("The URL which will be used to download the genome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel15.add(iGenomeURLBText, gridBagConstraints);

        jLabel48.setText("dbSNP VCF file:");
        jLabel48.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jLabel48, gridBagConstraints);

        idbSPNText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel15.add(idbSPNText, gridBagConstraints);

        jLabel51.setText("GATK:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jLabel51, gridBagConstraints);

        iBTrueRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        GATK.add(iBTrueRadioButton);
        iBTrueRadioButton.setText("True");
        iBTrueRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBTrueRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel15.add(iBTrueRadioButton, gridBagConstraints);

        iBFalseRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        GATK.add(iBFalseRadioButton);
        iBFalseRadioButton.setSelected(true);
        iBFalseRadioButton.setText("False");
        iBFalseRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                iBFalseRadioButtonStateChanged(evt);
            }
        });
        iBFalseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iBFalseRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(iBFalseRadioButton, gridBagConstraints);

        i1000GenomeText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel15.add(i1000GenomeText, gridBagConstraints);

        jLabel52.setText("1000 Genome  VCF file:");
        jLabel52.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(jLabel52, gridBagConstraints);

        i1000BrowseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        i1000BrowseButton.setText("Browse");
        i1000BrowseButton.setEnabled(false);
        i1000BrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i1000BrowseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(i1000BrowseButton, gridBagConstraints);

        i1000CancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        i1000CancelButton.setText("Cancel");
        i1000CancelButton.setEnabled(false);
        i1000CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                i1000CancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(i1000CancelButton, gridBagConstraints);

        idbSPNBrowseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        idbSPNBrowseButton.setText("Browse");
        idbSPNBrowseButton.setEnabled(false);
        idbSPNBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbSPNBrowseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(idbSPNBrowseButton, gridBagConstraints);

        idbSPNCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        idbSPNCancelButton.setText("Cancel");
        idbSPNCancelButton.setEnabled(false);
        idbSPNCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idbSPNCancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel15.add(idbSPNCancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(jPanel15, gridBagConstraints);

        jPanel16.setBackground(new java.awt.Color(247, 248, 248));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jLabel49.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(jLabel49, gridBagConstraints);

        iSudoBRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        IExecutionBWA.add(iSudoBRadioButton);
        iSudoBRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel16.add(iSudoBRadioButton, gridBagConstraints);

        iDockerBRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        IExecutionBWA.add(iDockerBRadioButton);
        iDockerBRadioButton.setSelected(true);
        iDockerBRadioButton.setText("docker");
        iDockerBRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDockerBRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(iDockerBRadioButton, gridBagConstraints);

        jLabel50.setText("Thread number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel16.add(jLabel50, gridBagConstraints);

        iThreadBText.setText("8");
        iThreadBText.setToolTipText("The number of threads which will be used during the computation.");
        iThreadBText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                iThreadBTextFocusLost(evt);
            }
        });
        iThreadBText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iThreadBTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 70, 10, 10);
        jPanel16.add(iThreadBText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingBWAPanel.add(jPanel16, gridBagConstraints);

        IndexingBWA.setViewportView(IndexingBWAPanel);

        MainPanel.add(IndexingBWA, "indexingB");

        MACS.setBorder(null);

        MACSPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "MACS & SICER analysis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 153, 0))); // NOI18N
        MACSPanel.setToolTipText("");
        MACSPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton4.setText("Close");
        vCloseButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(vCloseButton4, gridBagConstraints);

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton23.setText("Execute");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jButton23, gridBagConstraints);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton24.setText("Reset");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jButton24, gridBagConstraints);

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton25.setText("Save conf.");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jButton25, gridBagConstraints);

        jPanel17.setBackground(new java.awt.Color(247, 248, 248));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(new java.awt.GridBagLayout());

        jLabel53.setText("Output  folder:");
        jLabel53.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jLabel53, gridBagConstraints);

        MOutputFolderText.setEditable(false);
        MOutputFolderText.setToolTipText("The ouput folder, where the data will be saved.");
        MOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel17.add(MOutputFolderText, gridBagConstraints);

        jToggleButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton20.setText("Browse");
        jToggleButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton20ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton20, gridBagConstraints);

        jToggleButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton21.setText("Cancel");
        jToggleButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton21, gridBagConstraints);

        jLabel54.setText("Scratch folder:");
        jLabel54.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jLabel54, gridBagConstraints);

        MScratchFolderText.setEditable(false);
        MScratchFolderText.setToolTipText("This folder will be mounted in the docker container.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel17.add(MScratchFolderText, gridBagConstraints);

        jToggleButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton22.setText("Browse");
        jToggleButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton22, gridBagConstraints);

        jToggleButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton23.setText("Cancel");
        jToggleButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton23, gridBagConstraints);

        jLabel55.setText("Mock folder:");
        jLabel55.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jLabel55, gridBagConstraints);

        MMockFolderText.setEditable(false);
        MMockFolderText.setToolTipText("The folder containing the indexed genome.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel17.add(MMockFolderText, gridBagConstraints);

        jToggleButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton24.setText("Browse");
        jToggleButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton24ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton24, gridBagConstraints);

        jToggleButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton25.setText("Cancel");
        jToggleButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton25ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton25, gridBagConstraints);

        MGenomeFolderText.setEditable(false);
        MGenomeFolderText.setToolTipText("The folder containing the indexed genome.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel17.add(MGenomeFolderText, gridBagConstraints);

        jToggleButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton26.setText("Browse");
        jToggleButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton26ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton26, gridBagConstraints);

        jToggleButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton27.setText("Cancel");
        jToggleButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton27ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton27, gridBagConstraints);

        jLabel60.setText("Genome folder:");
        jLabel60.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jLabel60, gridBagConstraints);

        jLabel67.setText("Test  folder:");
        jLabel67.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jLabel67, gridBagConstraints);

        MTestFolderText.setEditable(false);
        MTestFolderText.setToolTipText("The folder containing the indexed genome.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel17.add(MTestFolderText, gridBagConstraints);

        jToggleButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton28.setText("Browse");
        jToggleButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton28ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton28, gridBagConstraints);

        jToggleButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton29.setText("Cancel");
        jToggleButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel17.add(jToggleButton29, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jPanel17, gridBagConstraints);

        jPanel18.setBackground(new java.awt.Color(247, 248, 248));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jLabel56.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel18.add(jLabel56, gridBagConstraints);

        MSudoRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        MExecution.add(MSudoRadioButton);
        MSudoRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 35, 10, 10);
        jPanel18.add(MSudoRadioButton, gridBagConstraints);

        MDockerRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        MExecution.add(MDockerRadioButton);
        MDockerRadioButton.setSelected(true);
        MDockerRadioButton.setText("docker");
        MDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel18.add(MDockerRadioButton, gridBagConstraints);

        jLabel57.setText("Thread number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel18.add(jLabel57, gridBagConstraints);

        MThreadText.setText("8");
        MThreadText.setToolTipText("The number of threads which will be used during the computation.");
        MThreadText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MThreadTextFocusLost(evt);
            }
        });
        MThreadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MThreadTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.05;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel18.add(MThreadText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel18.add(jLabel61, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jPanel18, gridBagConstraints);

        jPanel19.setBackground(new java.awt.Color(247, 248, 248));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel19.setLayout(new java.awt.GridBagLayout());

        jLabel63.setText("Tool selection:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel19.add(jLabel63, gridBagConstraints);

        MToolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "macs", "sicer" }));
        MToolComboBox.setToolTipText("");
        MToolComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MToolComboBoxItemStateChanged(evt);
            }
        });
        MToolComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MToolComboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 10);
        jPanel19.add(MToolComboBox, gridBagConstraints);

        Tool.setLayout(new java.awt.CardLayout());

        jPanel22.setBackground(new java.awt.Color(247, 248, 248));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel78.setText("MACS min. mfold:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel22.add(jLabel78, gridBagConstraints);

        MMaxmfoldText.setText("30");
        MMaxmfoldText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MMaxmfoldTextFocusLost(evt);
            }
        });
        MMaxmfoldText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMaxmfoldTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel22.add(MMaxmfoldText, gridBagConstraints);

        jLabel79.setText("MACS p-value:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel22.add(jLabel79, gridBagConstraints);

        jLabel82.setText("MACS max. mfold:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel22.add(jLabel82, gridBagConstraints);

        MMinmfoldText.setText("10");
        MMinmfoldText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MMinmfoldTextFocusLost(evt);
            }
        });
        MMinmfoldText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMinmfoldTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel22.add(MMinmfoldText, gridBagConstraints);

        MMpvalueText.setText("1e-5");
        MMpvalueText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MMpvalueTextFocusLost(evt);
            }
        });
        MMpvalueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMpvalueTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel22.add(MMpvalueText, gridBagConstraints);

        Tool.add(jPanel22, "MACS");

        jPanel23.setBackground(new java.awt.Color(247, 248, 248));
        jPanel23.setLayout(new java.awt.GridBagLayout());

        jLabel80.setText("SICER windows:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel23.add(jLabel80, gridBagConstraints);

        MSgsizeText.setText("200");
        MSgsizeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MSgsizeTextFocusLost(evt);
            }
        });
        MSgsizeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSgsizeTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel23.add(MSgsizeText, gridBagConstraints);

        jLabel81.setText("SICER FDR:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel23.add(jLabel81, gridBagConstraints);

        jLabel83.setText("SICER gsize:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel23.add(jLabel83, gridBagConstraints);

        MSWindowsText.setText("200");
        MSWindowsText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MSWindowsTextFocusLost(evt);
            }
        });
        MSWindowsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSWindowsTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 30, 10, 10);
        jPanel23.add(MSWindowsText, gridBagConstraints);

        MSFDRText.setText("0.1");
        MSFDRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MSFDRTextFocusLost(evt);
            }
        });
        MSFDRText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MSFDRTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 10);
        jPanel23.add(MSFDRText, gridBagConstraints);

        Tool.add(jPanel23, "SICER");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        jPanel19.add(Tool, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jPanel19, gridBagConstraints);

        jPanel20.setBackground(new java.awt.Color(247, 248, 248));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel20.setLayout(new java.awt.GridBagLayout());

        MAdapter5Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MAdapter5TextFocusLost(evt);
            }
        });
        MAdapter5Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAdapter5TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MAdapter5Text, gridBagConstraints);

        jLabel68.setText("Adapter 5':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel68, gridBagConstraints);

        jLabel69.setText("Adapter 3':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel69, gridBagConstraints);

        MAdapter3Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MAdapter3TextFocusLost(evt);
            }
        });
        MAdapter3Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAdapter3TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MAdapter3Text, gridBagConstraints);

        jLabel70.setText("Min length:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel70, gridBagConstraints);

        MTTSText.setText("0");
        MTTSText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MTTSTextFocusLost(evt);
            }
        });
        MTTSText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MTTSTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MTTSText, gridBagConstraints);

        jLabel71.setText("Max. upstream distance:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel71, gridBagConstraints);

        jLabel72.setText("Organism:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel72, gridBagConstraints);

        jLabel73.setText("Remove duplicates:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel73, gridBagConstraints);

        MRyesRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        MRemoveDuplicates.add(MRyesRadioButton);
        MRyesRadioButton.setText("yes");
        MRyesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRyesRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MRyesRadioButton, gridBagConstraints);

        MRnoRadioButton.setBackground(new java.awt.Color(247, 248, 248));
        MRemoveDuplicates.add(MRnoRadioButton);
        MRnoRadioButton.setSelected(true);
        MRnoRadioButton.setText("no");
        MRnoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRnoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MRnoRadioButton, gridBagConstraints);

        jLabel74.setText("Read  length:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel74, gridBagConstraints);

        MOrgComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hg19", "hg38", "mm9", "mm10" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MOrgComboBox, gridBagConstraints);

        MMinLengthText.setText("30");
        MMinLengthText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MMinLengthTextFocusLost(evt);
            }
        });
        MMinLengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMinLengthTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MMinLengthText, gridBagConstraints);

        MMaxUpstreamText.setText("10000");
        MMaxUpstreamText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MMaxUpstreamTextFocusLost(evt);
            }
        });
        MMaxUpstreamText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MMaxUpstreamTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MMaxUpstreamText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel20.add(jLabel75, gridBagConstraints);

        jLabel76.setText("TTS distance:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(jLabel76, gridBagConstraints);

        MReadLengthTextField.setText("50");
        MReadLengthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MReadLengthTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel20.add(MReadLengthTextField, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MACSPanel.add(jPanel20, gridBagConstraints);

        MACS.setViewportView(MACSPanel);

        MainPanel.add(MACS, "MACS");

        SampleSize.setBorder(null);

        SampleSizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Sample size estimator", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(218, 174, 0))); // NOI18N
        SampleSizePanel.setLayout(new java.awt.GridBagLayout());

        jPanel21.setBackground(new java.awt.Color(247, 248, 248));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel21.setLayout(new java.awt.GridBagLayout());

        jLabel64.setText("Output Folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(jLabel64, gridBagConstraints);

        SSOutputFolderText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 48, 10, 10);
        jPanel21.add(SSOutputFolderText, gridBagConstraints);

        SSbrowes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        SSbrowes.setText("Browse");
        SSbrowes.setToolTipText("");
        SSbrowes.setEnabled(false);
        SSbrowes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSbrowesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(SSbrowes, gridBagConstraints);

        SScancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        SScancel.setText("Cancel");
        SScancel.setEnabled(false);
        SScancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SScancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(SScancel, gridBagConstraints);
        jPanel21.add(jLabel65, new java.awt.GridBagConstraints());

        jLabel66.setText("Count table file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(jLabel66, gridBagConstraints);

        SSCountTableText.setEditable(false);
        SSCountTableText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCountTableTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 48, 10, 10);
        jPanel21.add(SSCountTableText, gridBagConstraints);

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jButton27.setText("Browse");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(jButton27, gridBagConstraints);

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton28.setText("Cancel");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel21.add(jButton28, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(jPanel21, gridBagConstraints);

        SSExecuteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        SSExecuteButton.setText("Execute");
        SSExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSExecuteButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(SSExecuteButton, gridBagConstraints);

        SSSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        SSSaveButton.setText("Save conf.");
        SSSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSSaveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(SSSaveButton, gridBagConstraints);

        SSResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        SSResetButton.setText("Reset");
        SSResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSResetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(SSResetButton, gridBagConstraints);

        SSCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        SSCloseButton.setText("Close");
        SSCloseButton.setToolTipText("");
        SSCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSCloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(SSCloseButton, gridBagConstraints);

        jPanel24.setBackground(new java.awt.Color(247, 248, 248));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel24.setLayout(new java.awt.GridBagLayout());

        jLabel77.setText("Log2 fold change:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(jLabel77, gridBagConstraints);

        jLabel84.setText("#gene for dispertion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(jLabel84, gridBagConstraints);
        jPanel24.add(jLabel85, new java.awt.GridBagConstraints());

        jLabel86.setText("Statistical power:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(jLabel86, gridBagConstraints);

        SSPowerText.setText("0.8");
        SSPowerText.setToolTipText("expected statistical power required to detect prognostic genes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(SSPowerText, gridBagConstraints);

        SSGeneText.setText("200");
        SSGeneText.setToolTipText(" an integer indicating the number of genes used in estimation of read counts and dispersion distribution");
        SSGeneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSGeneTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(SSGeneText, gridBagConstraints);

        SSlog2Text.setText("1");
        SSlog2Text.setToolTipText("an integer indicating the minimum log2 fold change for prognostic genes between two group");
        SSlog2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSlog2TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(SSlog2Text, gridBagConstraints);

        jLabel87.setText("False discovery rate:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(jLabel87, gridBagConstraints);

        SSFDRtext.setText("0.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel24.add(SSFDRtext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SampleSizePanel.add(jPanel24, gridBagConstraints);

        SampleSize.setViewportView(SampleSizePanel);

        MainPanel.add(SampleSize, "SampleSize");

        ExperimentPower.setBorder(null);

        ExperimentPowerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Experiment power", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 51, 102))); // NOI18N
        ExperimentPowerPanel.setLayout(new java.awt.GridBagLayout());

        jPanel25.setBackground(new java.awt.Color(247, 248, 248));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel25.setLayout(new java.awt.GridBagLayout());

        jLabel88.setText("Output Folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(jLabel88, gridBagConstraints);

        EPOutputFolderText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 48, 10, 10);
        jPanel25.add(EPOutputFolderText, gridBagConstraints);

        SSbrowes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        SSbrowes1.setText("Browse");
        SSbrowes1.setToolTipText("");
        SSbrowes1.setEnabled(false);
        SSbrowes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSbrowes1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(SSbrowes1, gridBagConstraints);

        SScancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        SScancel1.setText("Cancel");
        SScancel1.setEnabled(false);
        SScancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SScancel1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(SScancel1, gridBagConstraints);
        jPanel25.add(jLabel89, new java.awt.GridBagConstraints());

        jLabel90.setText("Count table file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(jLabel90, gridBagConstraints);

        EPCountTableText.setEditable(false);
        EPCountTableText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPCountTableTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 48, 10, 10);
        jPanel25.add(EPCountTableText, gridBagConstraints);

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jButton29.setText("Browse");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(jButton29, gridBagConstraints);

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jButton30.setText("Cancel");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel25.add(jButton30, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(jPanel25, gridBagConstraints);

        EPExecuteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        EPExecuteButton1.setText("Execute");
        EPExecuteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPExecuteButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(EPExecuteButton1, gridBagConstraints);

        EPSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        EPSaveButton.setText("Save conf.");
        EPSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPSaveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(EPSaveButton, gridBagConstraints);

        EPResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        EPResetButton.setText("Reset");
        EPResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPResetButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(EPResetButton, gridBagConstraints);

        EPCloseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        EPCloseButton.setText("Close");
        EPCloseButton.setToolTipText("");
        EPCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPCloseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(EPCloseButton, gridBagConstraints);

        jPanel26.setBackground(new java.awt.Color(247, 248, 248));
        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel26.setLayout(new java.awt.GridBagLayout());

        jLabel91.setText("Log2 fold change:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(jLabel91, gridBagConstraints);

        jLabel92.setText("#gene for dispertion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(jLabel92, gridBagConstraints);
        jPanel26.add(jLabel93, new java.awt.GridBagConstraints());

        jLabel94.setText("Number of samples:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(jLabel94, gridBagConstraints);

        EPSampleText.setText("3");
        EPSampleText.setToolTipText("the number of samples in each group");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(EPSampleText, gridBagConstraints);

        EPGeneText.setText("200");
        EPGeneText.setToolTipText(" an integer indicating the number of genes used in estimation of read counts and dispersion distribution");
        EPGeneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPGeneTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(EPGeneText, gridBagConstraints);

        EPlog2Text.setText("1");
        EPlog2Text.setToolTipText("an integer indicating the minimum log2 fold change for prognostic genes between two group");
        EPlog2Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EPlog2TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(EPlog2Text, gridBagConstraints);

        jLabel95.setText("False discovery rate:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(jLabel95, gridBagConstraints);

        EPFDRtext.setText("0.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel26.add(EPFDRtext, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExperimentPowerPanel.add(jPanel26, gridBagConstraints);

        ExperimentPower.setViewportView(ExperimentPowerPanel);

        MainPanel.add(ExperimentPower, "ExperimentPower");

        mRNABatch.setBorder(null);

        mRNABatchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Adding covariates and batch information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 153, 153))); // NOI18N
        mRNABatchPanel.setLayout(new java.awt.GridBagLayout());

        jPanel27.setBackground(new java.awt.Color(248, 248, 248));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel27.setToolTipText("the all.counts.txt file generated from miRNAseq step");
        jPanel27.setLayout(new java.awt.GridBagLayout());

        CCountHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Count Header", "Grouping", "Batch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        CCountHeaderTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CCountHeaderTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(CCountHeaderTable);
        CCountHeaderTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (CCountHeaderTable.getColumnModel().getColumnCount() > 0) {
            CCountHeaderTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(CovComboBox));
            CCountHeaderTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(BatchComboBox));
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(jScrollPane7, gridBagConstraints);

        CCovInputFileText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(CCovInputFileText, gridBagConstraints);

        Cinbrowes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        Cinbrowes.setText("Browse");
        Cinbrowes.setToolTipText("");
        Cinbrowes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CinbrowesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(Cinbrowes, gridBagConstraints);

        Cincancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        Cincancel.setText("Cancel");
        Cincancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CincancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(Cincancel, gridBagConstraints);

        jLabel98.setText("Output Folder:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(jLabel98, gridBagConstraints);

        jLabel97.setText("Count file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(jLabel97, gridBagConstraints);

        COutputFolderText.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(COutputFolderText, gridBagConstraints);

        Coutbrowes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        Coutbrowes.setText("Browse");
        Coutbrowes.setToolTipText("");
        Coutbrowes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoutbrowesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(Coutbrowes, gridBagConstraints);

        Coutcancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        Coutcancel.setText("Cancel");
        Coutcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoutcancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel27.add(Coutcancel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNABatchPanel.add(jPanel27, gridBagConstraints);

        FExecuteButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        FExecuteButton1.setText("Execute");
        FExecuteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FExecuteButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNABatchPanel.add(FExecuteButton1, gridBagConstraints);

        FSaveButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        FSaveButton1.setText("Save conf.");
        FSaveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FSaveButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNABatchPanel.add(FSaveButton1, gridBagConstraints);

        CResetButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        CResetButton1.setText("Reset");
        CResetButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CResetButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNABatchPanel.add(CResetButton1, gridBagConstraints);

        CCloseButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        CCloseButton1.setText("Close");
        CCloseButton1.setToolTipText("");
        CCloseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CCloseButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mRNABatchPanel.add(CCloseButton1, gridBagConstraints);

        mRNABatch.setViewportView(mRNABatchPanel);

        MainPanel.add(mRNABatch, "AddingCovmRNA");

        IndexingSalmon.setBorder(null);

        IndexingSalmonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Transcriptome pseudo-reference building with Salmon\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        IndexingSalmonPanel.setToolTipText("");
        IndexingSalmonPanel.setLayout(new java.awt.GridBagLayout());

        iCloseButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        iCloseButton2.setText("Close");
        iCloseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iCloseButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(iCloseButton2, gridBagConstraints);

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton37.setText("Execute");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(jButton37, gridBagConstraints);

        iResetButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        iResetButton2.setText("Reset");
        iResetButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iResetButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(iResetButton2, gridBagConstraints);

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton38.setText("Save conf.");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(jButton38, gridBagConstraints);

        jPanel28.setBackground(new java.awt.Color(248, 248, 248));
        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel28.setLayout(new java.awt.GridBagLayout());

        jLabel103.setText("Genome  folder:");
        jLabel103.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel103, gridBagConstraints);

        iGenomeFolderSText.setEditable(false);
        iGenomeFolderSText.setToolTipText("The folder that will contain the indexed genome.");
        iGenomeFolderSText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iGenomeFolderSTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(iGenomeFolderSText, gridBagConstraints);

        jToggleButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton30.setText("Browse");
        jToggleButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton30ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton30, gridBagConstraints);

        jToggleButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton31.setText("Cancel");
        jToggleButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton31ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jToggleButton31, gridBagConstraints);

        jLabel104.setText("Genome url:");
        jLabel104.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel104, gridBagConstraints);

        iGenomeURLSText.setToolTipText("The URL which will be used to download the genome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(iGenomeURLSText, gridBagConstraints);

        jLabel105.setText("GTF url:");
        jLabel105.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel105, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(iGTFURLSText, gridBagConstraints);

        iKmerSText.setText("31");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.05;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(iKmerSText, gridBagConstraints);

        jLabel108.setText("K-mer size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel28.add(jLabel108, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel28.add(jLabel109, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(jPanel28, gridBagConstraints);

        jPanel29.setBackground(new java.awt.Color(248, 248, 248));
        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel29.setLayout(new java.awt.GridBagLayout());

        jLabel106.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(jLabel106, gridBagConstraints);

        iSudoRadioSButton.setBackground(new java.awt.Color(248, 248, 248));
        IExecutionSalmon.add(iSudoRadioSButton);
        iSudoRadioSButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(iSudoRadioSButton, gridBagConstraints);

        iDockerRadioSButton.setBackground(new java.awt.Color(248, 248, 248));
        IExecutionSalmon.add(iDockerRadioSButton);
        iDockerRadioSButton.setSelected(true);
        iDockerRadioSButton.setText("docker");
        iDockerRadioSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iDockerRadioSButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(iDockerRadioSButton, gridBagConstraints);

        jLabel107.setText("Thread number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(jLabel107, gridBagConstraints);

        iThreadSText.setText("8");
        iThreadSText.setToolTipText("The number of threads which will be used during the computation.");
        iThreadSText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                iThreadSTextFocusLost(evt);
            }
        });
        iThreadSText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iThreadSTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel29.add(iThreadSText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        IndexingSalmonPanel.add(jPanel29, gridBagConstraints);

        IndexingSalmon.setViewportView(IndexingSalmonPanel);

        MainPanel.add(IndexingSalmon, "indexingSalmon");

        CountingSalmon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        CountingSalmonPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Transcripts and genes counting with Salmon ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N
        CountingSalmonPanel.setToolTipText("");
        CountingSalmonPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton5.setText("Close");
        vCloseButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(vCloseButton5, gridBagConstraints);

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton39.setText("Execute");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jButton39, gridBagConstraints);

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton40.setText("Reset");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jButton40, gridBagConstraints);

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton41.setText("Save conf.");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jButton41, gridBagConstraints);

        jPanel30.setBackground(new java.awt.Color(248, 248, 248));
        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel30.setToolTipText("");
        jPanel30.setLayout(new java.awt.GridBagLayout());

        jLabel110.setText("FastQ  folder:");
        jLabel110.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel110, gridBagConstraints);

        cFastQFolderText.setEditable(false);
        cFastQFolderText.setToolTipText("The folder containing the input reads in FastQ format.");
        cFastQFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cFastQFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel30.add(cFastQFolderText, gridBagConstraints);

        jToggleButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton32.setText("Browse");
        jToggleButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton32ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton32, gridBagConstraints);

        jToggleButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton33.setText("Cancel");
        jToggleButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton33ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton33, gridBagConstraints);

        jLabel111.setText("Scratch folder:");
        jLabel111.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel111, gridBagConstraints);

        cOutputFolderText.setEditable(false);
        cOutputFolderText.setToolTipText("This folder will be mounted in the docker container.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel30.add(cOutputFolderText, gridBagConstraints);

        jToggleButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton34.setText("Browse");
        jToggleButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton34ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton34, gridBagConstraints);

        jToggleButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton35.setText("Cancel");
        jToggleButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton35ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton35, gridBagConstraints);

        jLabel112.setText("Genome folder:");
        jLabel112.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jLabel112, gridBagConstraints);

        cGenomeFolderText.setEditable(false);
        cGenomeFolderText.setToolTipText("The folder containing the indexed genome.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel30.add(cGenomeFolderText, gridBagConstraints);

        jToggleButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton36.setText("Browse");
        jToggleButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton36ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton36, gridBagConstraints);

        jToggleButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton37.setText("Cancel");
        jToggleButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton37ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel30.add(jToggleButton37, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jPanel30, gridBagConstraints);

        jPanel31.setBackground(new java.awt.Color(248, 248, 248));
        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel31.setToolTipText("");
        jPanel31.setLayout(new java.awt.GridBagLayout());

        jLabel113.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(jLabel113, gridBagConstraints);

        cSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cExecutiionSalmon.add(cSudoRadioButton);
        cSudoRadioButton.setText("sudo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel31.add(cSudoRadioButton, gridBagConstraints);

        cDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cExecutiionSalmon.add(cDockerRadioButton);
        cDockerRadioButton.setSelected(true);
        cDockerRadioButton.setText("docker");
        cDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(cDockerRadioButton, gridBagConstraints);

        jLabel114.setText("Thread number:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel31.add(jLabel114, gridBagConstraints);

        cThreadText.setText("8");
        cThreadText.setToolTipText("The number of threads which will be used during the computation.");
        cThreadText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cThreadTextFocusLost(evt);
            }
        });
        cThreadText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cThreadTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 28, 10, 10);
        jPanel31.add(cThreadText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jPanel31, gridBagConstraints);

        jPanel32.setBackground(new java.awt.Color(248, 248, 248));
        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel32.setLayout(new java.awt.GridBagLayout());

        cAdapter5Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cAdapter5TextFocusLost(evt);
            }
        });
        cAdapter5Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAdapter5TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cAdapter5Text, gridBagConstraints);

        jLabel115.setText("Adapter 5':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(jLabel115, gridBagConstraints);

        jLabel116.setText("Adapter 3':");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(jLabel116, gridBagConstraints);

        cAdapter3Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cAdapter3TextFocusLost(evt);
            }
        });
        cAdapter3Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAdapter3TextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cAdapter3Text, gridBagConstraints);

        cPeRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cSeq.add(cPeRadioButton);
        cPeRadioButton.setSelected(true);
        cPeRadioButton.setText("paired-end");
        cPeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cPeRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cPeRadioButton, gridBagConstraints);

        cSeRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cSeq.add(cSeRadioButton);
        cSeRadioButton.setText("single-end");
        cSeRadioButton.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cSeRadioButton, gridBagConstraints);

        jLabel117.setText("Type of Sequence");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(jLabel117, gridBagConstraints);

        jLabel118.setText("Min length:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(jLabel118, gridBagConstraints);

        cMinLengthText.setText("40");
        cMinLengthText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cMinLengthTextFocusLost(evt);
            }
        });
        cMinLengthText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMinLengthTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cMinLengthText, gridBagConstraints);

        jLabel119.setText("Strandness:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(jLabel119, gridBagConstraints);

        cSNoneRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cStrand.add(cSNoneRadioButton);
        cSNoneRadioButton.setSelected(true);
        cSNoneRadioButton.setText("none");
        cSNoneRadioButton.setToolTipText("");
        cSNoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSNoneRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cSNoneRadioButton, gridBagConstraints);

        cSForwardRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cStrand.add(cSForwardRadioButton);
        cSForwardRadioButton.setText("forward");
        cSForwardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSForwardRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cSForwardRadioButton, gridBagConstraints);

        cSReverseRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        cStrand.add(cSReverseRadioButton);
        cSReverseRadioButton.setText("reverse");
        cSReverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSReverseRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel32.add(cSReverseRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        CountingSalmonPanel.add(jPanel32, gridBagConstraints);

        CountingSalmon.setViewportView(CountingSalmonPanel);

        MainPanel.add(CountingSalmon, "countingSalmon");

        filterCounts.setBorder(null);

        filterCountsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Filter Counts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(255, 51, 51))); // NOI18N
        filterCountsPanel.setToolTipText("");
        filterCountsPanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton6.setText("Close");
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
        jPanel33.setLayout(new java.awt.GridBagLayout());

        jLabel120.setText("Output folder:");
        jLabel120.setToolTipText("Output folder");
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
        jLabel121.setToolTipText("The folder containing FPKM or TPM table files");
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
        jPanel34.setLayout(new java.awt.GridBagLayout());

        jLabel124.setText("Data type:");
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
        fgeneRadioButton.setToolTipText("");
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

        filterCounts.setViewportView(filterCountsPanel);

        MainPanel.add(filterCounts, "filtercounts");

        MultiQCpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "MultiQC ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(153, 0, 204))); // NOI18N
        MultiQCpanel.setLayout(new java.awt.GridBagLayout());

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton45.setText("Execute");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jButton45, gridBagConstraints);

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton47.setText("Reset");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jButton47, gridBagConstraints);

        vCloseButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton7.setText("Close");
        vCloseButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(vCloseButton7, gridBagConstraints);

        jPanel36.setBackground(new java.awt.Color(248, 248, 248));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel36.setLayout(new java.awt.GridBagLayout());

        jLabel127.setText("Data folder:");
        jLabel127.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jLabel127, gridBagConstraints);

        QdataFolderText.setEditable(false);
        QdataFolderText.setToolTipText("The folder containing the input reads");
        QdataFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QdataFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel36.add(QdataFolderText, gridBagConstraints);

        jToggleButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton40.setText("Browse");
        jToggleButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton40ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jToggleButton40, gridBagConstraints);

        jToggleButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton41.setText("Cancel");
        jToggleButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton41ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel36.add(jToggleButton41, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jPanel36, gridBagConstraints);

        jPanel37.setBackground(new java.awt.Color(248, 248, 248));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel37.setLayout(new java.awt.GridBagLayout());

        jLabel129.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel37.add(jLabel129, gridBagConstraints);

        QSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MultiQCGroup.add(QSudoRadioButton);
        QSudoRadioButton.setText("sudo");
        QSudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QSudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 85, 10, 10);
        jPanel37.add(QSudoRadioButton, gridBagConstraints);

        QDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        MultiQCGroup.add(QDockerRadioButton);
        QDockerRadioButton.setSelected(true);
        QDockerRadioButton.setText("docker");
        QDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel37.add(QDockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        MultiQCpanel.add(jPanel37, gridBagConstraints);

        MultiQC.setViewportView(MultiQCpanel);

        MainPanel.add(MultiQC, "multiqc");

        Heatmappanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "Heatmap generation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        Heatmappanel.setLayout(new java.awt.GridBagLayout());

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton46.setText("Execute");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Heatmappanel.add(jButton46, gridBagConstraints);

        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton48.setText("Reset");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Heatmappanel.add(jButton48, gridBagConstraints);

        vCloseButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton8.setText("Close");
        vCloseButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Heatmappanel.add(vCloseButton8, gridBagConstraints);

        jPanel38.setBackground(new java.awt.Color(248, 248, 248));
        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel38.setLayout(new java.awt.GridBagLayout());

        HscratchText.setEditable(false);
        HscratchText.setToolTipText("");
        HscratchText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HscratchTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel38.add(HscratchText, gridBagConstraints);

        jToggleButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton42.setText("Browse");
        jToggleButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton42ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton42, gridBagConstraints);

        jToggleButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton43.setText("Cancel");
        jToggleButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton43ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton43, gridBagConstraints);

        jLabel131.setText("Output folder:");
        jLabel131.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel131, gridBagConstraints);

        HdataFileText.setEditable(false);
        HdataFileText.setToolTipText("The folder containing the input reads");
        HdataFileText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HdataFileTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel38.add(HdataFileText, gridBagConstraints);

        jToggleButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jToggleButton44.setText("Browse");
        jToggleButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton44ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton44, gridBagConstraints);

        jToggleButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton45.setText("Cancel");
        jToggleButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton45ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton45, gridBagConstraints);

        jLabel132.setText("Upper range:");
        jLabel132.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel132, gridBagConstraints);

        jLabel133.setText("Input type:");
        jLabel133.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel133, gridBagConstraints);

        HStatus1RadioButton.setBackground(new java.awt.Color(248, 248, 248));
        heatmapBaseGroup.add(HStatus1RadioButton);
        HStatus1RadioButton.setSelected(true);
        HStatus1RadioButton.setText("row count");
        HStatus1RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HStatus1RadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 45, 0, 10);
        jPanel38.add(HStatus1RadioButton, gridBagConstraints);

        HStatus0RadioButton.setBackground(new java.awt.Color(248, 248, 248));
        heatmapBaseGroup.add(HStatus0RadioButton);
        HStatus0RadioButton.setText("other");
        HStatus0RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HStatus0RadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel38.add(HStatus0RadioButton, gridBagConstraints);

        jToggleButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton46.setText("Browse");
        jToggleButton46.setEnabled(false);
        jToggleButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton46ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton46, gridBagConstraints);

        jToggleButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        jToggleButton47.setText("Cancel");
        jToggleButton47.setEnabled(false);
        jToggleButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton47ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_TRAILING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jToggleButton47, gridBagConstraints);

        HOutputFolderText.setEditable(false);
        HOutputFolderText.setToolTipText("The folder containing the input reads");
        HOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel38.add(HOutputFolderText, gridBagConstraints);

        jLabel134.setText("Input file:");
        jLabel134.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel134, gridBagConstraints);

        jLabel135.setText("Scratch folder:");
        jLabel135.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel135, gridBagConstraints);

        HLowerRangeText.setText("-1");
        HLowerRangeText.setToolTipText("The folder containing the input reads");
        HLowerRangeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HLowerRangeTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel38.add(HLowerRangeText, gridBagConstraints);

        jLabel136.setText("Lower range:");
        jLabel136.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel38.add(jLabel136, gridBagConstraints);

        HUpperRangeText.setText("1");
        HUpperRangeText.setToolTipText("");
        HUpperRangeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HUpperRangeTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel38.add(HUpperRangeText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 3.0;
        jPanel38.add(jLabel139, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Heatmappanel.add(jPanel38, gridBagConstraints);

        jPanel39.setBackground(new java.awt.Color(248, 248, 248));
        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel39.setLayout(new java.awt.GridBagLayout());

        jLabel130.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel39.add(jLabel130, gridBagConstraints);

        HSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        heatmapGroup.add(HSudoRadioButton);
        HSudoRadioButton.setText("sudo");
        HSudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HSudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 77, 10, 10);
        jPanel39.add(HSudoRadioButton, gridBagConstraints);

        HDockerRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        heatmapGroup.add(HDockerRadioButton);
        HDockerRadioButton.setSelected(true);
        HDockerRadioButton.setText("docker");
        HDockerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDockerRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel39.add(HDockerRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Heatmappanel.add(jPanel39, gridBagConstraints);

        Heatmap.setViewportView(Heatmappanel);
        Heatmappanel.getAccessibleContext().setAccessibleName("");

        MainPanel.add(Heatmap, "heatmap");

        ANOVAlikePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(30, 1, 1, 1), "ANOVA-like analysis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(40, 53, 204))); // NOI18N
        ANOVAlikePanel.setToolTipText("");
        ANOVAlikePanel.setLayout(new java.awt.GridBagLayout());

        vCloseButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"))); // NOI18N
        vCloseButton9.setText("Close");
        vCloseButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vCloseButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(vCloseButton9, gridBagConstraints);

        jButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        jButton49.setText("Execute");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jButton49, gridBagConstraints);

        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        jButton50.setText("Reset");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jButton50, gridBagConstraints);

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86b.png"))); // NOI18N
        jButton51.setText("Save conf.");
        jButton51.setEnabled(false);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jButton51, gridBagConstraints);

        jPanel35.setBackground(new java.awt.Color(248, 248, 248));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel35.setLayout(new java.awt.GridBagLayout());

        jLabel122.setText("Output folders:");
        jLabel122.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(jLabel122, gridBagConstraints);

        ANinputfileText.setEditable(false);
        ANinputfileText.setToolTipText("Input data file.");
        ANinputfileText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANinputfileTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 65, 10, 10);
        jPanel35.add(ANinputfileText, gridBagConstraints);

        jToggleButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/fileb.png"))); // NOI18N
        jToggleButton48.setText("Browse");
        jToggleButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton48ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(jToggleButton48, gridBagConstraints);

        fCancelButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton6.setText("Cancel");
        fCancelButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(fCancelButton6, gridBagConstraints);

        jLabel123.setText("Input file:");
        jLabel123.setToolTipText("The FPKM or TPM table file nam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(jLabel123, gridBagConstraints);

        ANOutputFolderText.setEditable(false);
        ANOutputFolderText.setToolTipText("Output data folder.");
        ANOutputFolderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANOutputFolderTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 65, 10, 10);
        jPanel35.add(ANOutputFolderText, gridBagConstraints);

        jToggleButton49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52b.png"))); // NOI18N
        jToggleButton49.setText("Browse");
        jToggleButton49.setEnabled(false);
        jToggleButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton49ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(jToggleButton49, gridBagConstraints);

        fCancelButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        fCancelButton7.setText("Cancel");
        fCancelButton7.setEnabled(false);
        fCancelButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fCancelButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel35.add(fCancelButton7, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jPanel35, gridBagConstraints);

        jPanel40.setBackground(new java.awt.Color(248, 248, 248));
        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel40.setLayout(new java.awt.GridBagLayout());

        ANLog2fcText.setText("1.0");
        ANLog2fcText.setToolTipText("Log_2 fold change threshold for differetially expressed genes");
        ANLog2fcText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ANLog2fcTextFocusLost(evt);
            }
        });
        ANLog2fcText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANLog2fcTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 10);
        jPanel40.add(ANLog2fcText, gridBagConstraints);

        jLabel125.setText("LogFC threshold:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel40.add(jLabel125, gridBagConstraints);

        jLabel126.setText("LogCPM threshold:");
        jLabel126.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel40.add(jLabel126, gridBagConstraints);

        ANLogCPMText.setText("4.0");
        ANLogCPMText.setToolTipText("");
        ANLogCPMText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ANLogCPMTextFocusLost(evt);
            }
        });
        ANLogCPMText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANLogCPMTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 10);
        jPanel40.add(ANLogCPMText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.8;
        jPanel40.add(jLabel137, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.3;
        jPanel40.add(jLabel138, gridBagConstraints);

        jLabel140.setText("Adj. p-value threshold:");
        jLabel140.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel40.add(jLabel140, gridBagConstraints);

        ANadjPText.setText("0.1");
        ANadjPText.setToolTipText("adjusted p-value  threshold");
        ANadjPText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ANadjPTextFocusLost(evt);
            }
        });
        ANadjPText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANadjPTextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 10, 10);
        jPanel40.add(ANadjPText, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        jPanel40.add(jLabel141, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jPanel40, gridBagConstraints);

        jPanel41.setBackground(new java.awt.Color(248, 248, 248));
        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel41.setLayout(new java.awt.GridBagLayout());

        jLabel142.setText("Execution:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel41.add(jLabel142, gridBagConstraints);

        ANSudoRadioButton.setBackground(new java.awt.Color(248, 248, 248));
        ANOVAGroup.add(ANSudoRadioButton);
        ANSudoRadioButton.setText("sudo");
        ANSudoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANSudoRadioButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(10, 95, 10, 10);
        jPanel41.add(ANSudoRadioButton, gridBagConstraints);

        ANDockerRadioButton1.setBackground(new java.awt.Color(248, 248, 248));
        ANOVAGroup.add(ANDockerRadioButton1);
        ANDockerRadioButton1.setSelected(true);
        ANDockerRadioButton1.setText("docker");
        ANDockerRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANDockerRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel41.add(ANDockerRadioButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ANOVAlikePanel.add(jPanel41, gridBagConstraints);

        ANOVAlike.setViewportView(ANOVAlikePanel);

        MainPanel.add(ANOVAlike, "NOVAlike");

        HorizontalSplitPanel.setRightComponent(MainPanel);

        LeftPanel.setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setBackground(new java.awt.Color(238, 238, 238));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        RNAseqPanel.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanel.setLayout(new java.awt.GridBagLayout());

        SalmonIndexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/salmon.png"))); // NOI18N
        SalmonIndexingButton.setText("Trans. pseudo-reference building (Salmon)  ");
        SalmonIndexingButton.setBorder(null);
        SalmonIndexingButton.setBorderPainted(false);
        SalmonIndexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalmonIndexingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(SalmonIndexingButton, gridBagConstraints);

        vmRNAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        vmRNAButton.setText("Genome indexing STAR-RSEM  ");
        vmRNAButton.setBorder(null);
        vmRNAButton.setBorderPainted(false);
        vmRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        RNAseqPanel.add(vmRNAButton, gridBagConstraints);

        mRNAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        mRNAButton.setText("Genes, isoforms counting RSEM  ");
        mRNAButton.setBorder(null);
        mRNAButton.setBorderPainted(false);
        mRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(mRNAButton, gridBagConstraints);

        PCAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/PCA.png"))); // NOI18N
        PCAButton.setText(" PCA  analysis");
        PCAButton.setBorder(null);
        PCAButton.setBorderPainted(false);
        PCAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(PCAButton, gridBagConstraints);

        countingSalmonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/salmon.png"))); // NOI18N
        countingSalmonButton.setText("Trans. and genes counting (Salmon)  ");
        countingSalmonButton.setBorder(null);
        countingSalmonButton.setBorderPainted(false);
        countingSalmonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countingSalmonButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(countingSalmonButton, gridBagConstraints);

        SampleExpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sample.png"))); // NOI18N
        SampleExpButton.setText("From samples to experiment  ");
        SampleExpButton.setBorder(null);
        SampleExpButton.setBorderPainted(false);
        SampleExpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleExpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(SampleExpButton, gridBagConstraints);

        CountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        CountButton.setText("Count Filter  ");
        CountButton.setBorder(null);
        CountButton.setBorderPainted(false);
        CountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(CountButton, gridBagConstraints);

        SampleSizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SampleSizeButton.setText("Sample size estimator  ");
        SampleSizeButton.setBorder(null);
        SampleSizeButton.setBorderPainted(false);
        SampleSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSizeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(SampleSizeButton, gridBagConstraints);

        ExpPowerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/power.png"))); // NOI18N
        ExpPowerButton.setText("Experiment statistical  Power  ");
        ExpPowerButton.setBorder(null);
        ExpPowerButton.setBorderPainted(false);
        ExpPowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpPowerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(ExpPowerButton, gridBagConstraints);

        DeseqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        DeseqButton.setText("DESeq2 analysis  ");
        DeseqButton.setBorder(null);
        DeseqButton.setBorderPainted(false);
        DeseqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseqButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(DeseqButton, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(51, 255, 51));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        RNAseqPanel.add(jSeparator1, gridBagConstraints);

        ANOVAlikeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/anovaLike.png"))); // NOI18N
        ANOVAlikeButton.setText("ANOVA-like  ");
        ANOVAlikeButton.setBorder(null);
        ANOVAlikeButton.setBorderPainted(false);
        ANOVAlikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANOVAlikeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanel.add(ANOVAlikeButton, gridBagConstraints);

        jTabbedPane1.addTab("RNAseq", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), RNAseqPanel); // NOI18N

        miRNAPanel.setBackground(new java.awt.Color(255, 255, 255));
        miRNAPanel.setLayout(new java.awt.GridBagLayout());

        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAcount.png"))); // NOI18N
        jButton59.setText(" miRNA counting  ");
        jButton59.setBorder(null);
        jButton59.setBorderPainted(false);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        miRNAPanel.add(jButton59, gridBagConstraints);

        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAcov.png"))); // NOI18N
        jButton60.setText("Adding covariates and batchs  ");
        jButton60.setBorder(null);
        jButton60.setBorderPainted(false);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(jButton60, gridBagConstraints);

        PCAButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/PCA.png"))); // NOI18N
        PCAButton1.setText(" PCA  analysis");
        PCAButton1.setBorder(null);
        PCAButton1.setBorderPainted(false);
        PCAButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(PCAButton1, gridBagConstraints);

        CountButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        CountButton1.setText("Count Filter  ");
        CountButton1.setBorder(null);
        CountButton1.setBorderPainted(false);
        CountButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(CountButton1, gridBagConstraints);

        SampleSizeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SampleSizeButton1.setText("Sample size estimator  ");
        SampleSizeButton1.setBorder(null);
        SampleSizeButton1.setBorderPainted(false);
        SampleSizeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSizeButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(SampleSizeButton1, gridBagConstraints);

        ExpPowerButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/power.png"))); // NOI18N
        ExpPowerButton1.setText("Experiment statistical  Power  ");
        ExpPowerButton1.setBorder(null);
        ExpPowerButton1.setBorderPainted(false);
        ExpPowerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpPowerButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(ExpPowerButton1, gridBagConstraints);

        DeseqButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        DeseqButton2.setText("DESeq2 analysis  ");
        DeseqButton2.setBorder(null);
        DeseqButton2.setBorderPainted(false);
        DeseqButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseqButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNAPanel.add(DeseqButton2, gridBagConstraints);

        jTabbedPane1.addTab("miRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAtab.png")), miRNAPanel); // NOI18N

        ChipSeqPanel.setBackground(new java.awt.Color(255, 255, 255));
        ChipSeqPanel.setLayout(new java.awt.GridBagLayout());

        indexingBButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqIndex.png"))); // NOI18N
        indexingBButton.setText("Genome indexing BWA  ");
        indexingBButton.setBorder(null);
        indexingBButton.setBorderPainted(false);
        indexingBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexingBButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ChipSeqPanel.add(indexingBButton, gridBagConstraints);

        CountButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqAl.png"))); // NOI18N
        CountButton2.setText("  MACS & SICER analysis");
        CountButton2.setBorder(null);
        CountButton2.setBorderPainted(false);
        CountButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        ChipSeqPanel.add(CountButton2, gridBagConstraints);

        jTabbedPane1.addTab("Chipseq", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqtab.png")), ChipSeqPanel); // NOI18N

        ToolPanel.setBackground(new java.awt.Color(255, 255, 255));
        ToolPanel.setLayout(new java.awt.GridBagLayout());

        MultiQCButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        MultiQCButton.setText("MultiQC analysis  ");
        MultiQCButton.setToolTipText("");
        MultiQCButton.setBorder(null);
        MultiQCButton.setBorderPainted(false);
        MultiQCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiQCButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(MultiQCButton, gridBagConstraints);

        HeatmapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        HeatmapButton.setText("Heatmap generation    ");
        HeatmapButton.setBorder(null);
        HeatmapButton.setBorderPainted(false);
        HeatmapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatmapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(HeatmapButton, gridBagConstraints);

        jTabbedPane1.addTab("Tools", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/tooltab.png")), ToolPanel); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        LeftPanel.add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        HorizontalSplitPanel.setLeftComponent(LeftPanel);

        VerticalSplitPanel.setTopComponent(HorizontalSplitPanel);

        getContentPane().add(VerticalSplitPanel, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 3, 5, 3));

        jMenu3.setText("File");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52.png"))); // NOI18N
        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86.png"))); // NOI18N
        jMenuItem4.setText("Save");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33.png"))); // NOI18N
        jMenuItem6.setText("Exit");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/preference.png"))); // NOI18N
        jMenuItem1.setText("Configure 4SeqGUI");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/download.png"))); // NOI18N
        jMenuItem8.setText("Download Docker Images");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/docker.png"))); // NOI18N
        jMenuItem2.setText("Remove Docker Containers");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("?");
        jMenu5.setToolTipText("");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/iconDNA-small.png"))); // NOI18N
        jMenuItem7.setText("About 4SeqGUI");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
        private static final Pattern adapter = Pattern.compile("[acgtACGT]+"
);
        
        private static final Pattern org = Pattern.compile("[a-zA-Z0-9]+"
);
    
        private static final Pattern miRBase = Pattern.compile("[a-zA-Z0-9]{3,3}"
);
        
        
        
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        mDockerRadioButton.setSelected(true);
        mFastQFolderText.setText("");
        mOutputFolderText.setText("");
        mmiRBaseText.setText("hsa");
        mDFalseRadioButton.setSelected(true);
        mAILLUMINARadioButton.setSelected(true);
        mTFalseRadioButton.setSelected(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        if (mFastQFolderText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "You have to specified an input folder","Error: FastQ  folder",JOptionPane.ERROR_MESSAGE);
           //mFastQFolderText.requestFocusInWindow();   
           //return;
        }
        else
           if (mOutputFolderText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "You have to specified an output folder","Error: Output folder",JOptionPane.ERROR_MESSAGE);
           //mOutputFolderText.requestFocusInWindow();   
           //return;
           }    
           else
            if (!miRBase.matcher(mmiRBaseText.getText()).matches()){
                    JOptionPane.showMessageDialog(this, "The specified miRBase  id is not valid.","Error: miRBase",JOptionPane.ERROR_MESSAGE);
                    mmiRBaseText.requestFocusInWindow();   
            }
            else
            {
            //execute code
            Runtime rt = Runtime.getRuntime();
            try{
                String[] cmd = {"/bin/bash","-c"," bash ./execmirna.sh "};
                if (mSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
                }
                else{
                    cmd[2]+= "group=\\\"docker\\\"";
                }
                cmd[2]+= " fastq.folder=\\\""+mFastQFolderText.getText()+"\\\" scratch.folder=\\\""+mOutputFolderText.getText()+"\\\" mirbase.id=\\\""+mmiRBaseText.getText()+"\\\"";
                if (mDTrueRadioButton.isSelected()){
                    cmd[2]+= " download.status=TRUE";
                }
                else{
                    cmd[2]+= " download.status=FALSE";
                }
                if (mANEBRadioButton.isSelected())
                    cmd[2]+= " adapter.type=\\\"NEB\\\"";
                else
                    cmd[2]+= " adapter.type=\\\"ILLUMINA\\\"";
                if (mTTrueRadioButton.isSelected())
                    cmd[2]+= " trimmed.fastq=TRUE";
                else
                    cmd[2]+= " trimmed.fastq=FALSE";

                cmd[2]+=" "+mFastQFolderText.getText() +" >& "+mFastQFolderText.getText()+"/outputExecution ";

                if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                    Process pr = rt.exec(cmd);                          
                    ElProcRunning tmp= new ElProcRunning("miRNA counting ", mFastQFolderText.getText(),pr,listModel.getSize());
                    listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                    GL.setAvoidProcListValueChanged(0);
                    if(listProcRunning.size()==1){
                        t=new Timer();
                        t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                        }
                }    
                else{
                     ElProcWaiting tmp= new ElProcWaiting("miRNA counting", mFastQFolderText.getText(),cmd,listModel.getSize());
                     listProcWaiting.add(tmp);
                     java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                     ImageIcon image2 = new ImageIcon(imgURL);
                     GL.setAvoidProcListValueChanged(-1);
                     listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                     GL.setAvoidProcListValueChanged(0);
                    }
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer());
                GL.setAvoidProcListValueChanged(0);
                }   
            catch(IOException e) {
                JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
                }
            JOptionPane.showMessageDialog(this, "miRNA counting task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE); 
            }
                  //execute code     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void vCloseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton1ActionPerformed
        mDockerRadioButton.setSelected(true);
        mFastQFolderText.setText("");
        mOutputFolderText.setText("");
        mmiRBaseText.setText("hsa");
        mDFalseRadioButton.setSelected(true);
        mAILLUMINARadioButton.setSelected(true);
        mTFalseRadioButton.setSelected(true);
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
//        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton1ActionPerformed

    private void mTFalseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTFalseRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTFalseRadioButtonActionPerformed

    private void mTTrueRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTTrueRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTTrueRadioButtonActionPerformed

    private void mAILLUMINARadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAILLUMINARadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mAILLUMINARadioButtonActionPerformed

    private void mANEBRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mANEBRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mANEBRadioButtonActionPerformed

    private void mDFalseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDFalseRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mDFalseRadioButtonActionPerformed

    private void mmiRBaseTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmiRBaseTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mmiRBaseTextActionPerformed

    private void mmiRBaseTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mmiRBaseTextFocusLost
        if (mmiRBaseText.getText().isEmpty())
            return;
        mmiRBaseText.setForeground(Color.black);
        if (!miRBase.matcher(mmiRBaseText.getText()).matches()){
            mmiRBaseText.setForeground(Color.red);
        }
    }//GEN-LAST:event_mmiRBaseTextFocusLost

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        JFileChooser openDir = new JFileChooser();  
        if (!(mOutputFolderText.getText().equals(""))){
            File file =new File(mOutputFolderText.getText());
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
            mOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        mOutputFolderText.setText("");
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(mFastQFolderText.getText().equals(""))){
            File file =new File(mFastQFolderText.getText());
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
            mFastQFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        mFastQFolderText.setText("");
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void mFastQFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mFastQFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mFastQFolderTextActionPerformed

    private void vThreadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vThreadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vThreadTextActionPerformed

    private void vThreadTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vThreadTextFocusLost
        if (vThreadText.getText().isEmpty())
            return;
        vThreadText.setForeground(Color.black);
        try
        {
            Integer x = Integer.valueOf(vThreadText.getText());
            if (x<=0){
                vThreadText.setForeground(Color.red);
            }
        }
        catch (NumberFormatException e) {
            vThreadText.setForeground(Color.red);
            vThreadText.setText("");
          //  return;
        }
    }//GEN-LAST:event_vThreadTextFocusLost

    private void vDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vDockerRadioButtonActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        vGenomeFolderText.setText("");
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(vGenomeFolderText.getText().equals(""))){
            File file =new File(vGenomeFolderText.getText());
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
            vGenomeFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed

        vOutputFolderText.setText("");
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
       
        JFileChooser openDir = new JFileChooser();
        if (!(vOutputFolderText.getText().equals(""))){
            File file =new File(vOutputFolderText.getText());
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
            vOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        vFastQFolderText.setText("");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(vFastQFolderText.getText().equals(""))){
            File file =new File(vFastQFolderText.getText());
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
            vFastQFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void vFastQFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vFastQFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vFastQFolderTextActionPerformed
        
    private void DownloadMenuItemActionPerformed(java.awt.event.ActionEvent evt){
        
        DownloadFrame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int DownloadframeWidth= Integer.valueOf(getPreferences().get("4SeqGUI_WindowDownloadWidth", "0"));
        int DownloadframeHeight= Integer.valueOf(getPreferences().get("4SeqGUI_WindowDownloadHeight", "0")); 
        if ((DownloadframeWidth==0)||(DownloadframeHeight==0)){
              DownloadframeWidth=screenSize.width*50/100;
              DownloadframeHeight=screenSize.height*20/100;
        }

        DownloadFrame.setSize(DownloadframeWidth,DownloadframeHeight);
        
        DownloadFrame.setVisible(true);
    }
    
    
    private void configurationMenuItemActionPerformed(java.awt.event.ActionEvent evt){
        ConfigurationFrame.pack();
        ConfigurationFrame.setVisible(true);
        ParallelTextField.setText(Integer.toString(GS.getMaxSizelistProcRunning()));
        ThreadTextField.setText(Integer.toString(GS.getDefaultThread()));
        Adapter5TextField.setText(GS.getDefaultAdapter5());
        Adapter3TextField.setText(GS.getDefaultAdapter3());
        
    }
    
     private void  removeDockerContainer(java.awt.event.ActionEvent evt){
        
        String[] cmd = {"/bin/bash","-c"," docker rm $(docker ps -q -f status=exited); docker rm $(docker ps -q -f status=dead)"}; 
        try{
            Runtime.getRuntime().exec(cmd);
            JOptionPane.showMessageDialog(this, "All docker containers were removed!!","Confermation",JOptionPane.INFORMATION_MESSAGE);
            }
        catch (IOException e){
            System.out.println("Docker containers were not removed\n");
        } 
     }
    
    
      private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
      
         
        if (!"Empty".equals(CurrentLayout)){ 
            JFileChooser openFile = new JFileChooser();
            String curDir = getPreferences().get("saved-file", null);
            openFile.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
            if (openFile.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
                try{
                File f = openFile.getSelectedFile();
                FileReader fw = new FileReader(f.getAbsoluteFile());
                    try (BufferedReader br = new BufferedReader(fw)) {
                        if ("vmRNA".equals(CurrentLayout)){
                            int line=0;
                            //chekc right file
                            String y=br.readLine();
                            if (!y.equals("vmRNA")){
                                throw(new NumberFormatException());
                            }
                            for (String x = br.readLine(); x != null; x = br.readLine()){
                                switch (line){
                                    case 0:
                                        if (x.equals("sudo"))
                                            vSudoRadioButton.setSelected(true);
                                        else
                                            vDockerRadioButton.setSelected(true);
                                        break;
                                    case 1:
                                        vFastQFolderText.setText(x);
                                        break;
                                    case 2:
                                        vOutputFolderText.setText(x);
                                        break;  
                                    case 3:
                                        vAdapter5Text.setText(x);
                                        break;
                                    case 4:
                                        vAdapter3Text.setText(x);
                                        break;
                                    case 5:
                                        if (x.equals("se"))
                                            vSeRadioButton.setSelected(true);
                                        else
                                            vPeRadioButton.setSelected(true);
                                        break;
                                    case 6:
                                        vThreadText.setText(x);
                                        break;
                                    case 7:
                                        vMinLengthText.setText(x);
                                        break;
                                    case 8:
                                        vGenomeFolderText.setText(x);
                                        break;
                                    case 9:
                                        switch (x) {
                                            case "none":
                                                vSNoneRadioButton.setSelected(true);
                                                break;
                                            case "forward":
                                                vSForwardRadioButton.setSelected(true);
                                                break;
                                            default:
                                                vSReverseRadioButton.setSelected(true);
                                                break;
                                        }
                                        break;
                                    case 10:
                                        if (x.equals("gtfENSEMBL"))
                                            vBAMnoLRadioButton.setSelected(true);
                                        else
                                            vBAMyesRadioButton.setSelected(true);
                                        break;
                                    case 11:
                                        vOrganismText.setText(x);
                                        break;
                                    default:
                                        System.out.print("Too much lines\n");
                                        throw(new NumberFormatException());                                
                                }
                                line++;
                            }
                        }
                        else
                            if ( "mRNA".equals(CurrentLayout)){
                                int line=0;
                                //chekc right file
                                String y=br.readLine();
                                if (!y.equals("mRNA")){
                                    throw(new NumberFormatException());
                                }
                                for (String x = br.readLine(); x != null; x = br.readLine()){
                                    switch (line){
                                        case 0:
                                            if (x.equals("sudo"))
                                                mSudoRadioButton.setSelected(true);
                                            else
                                                mDockerRadioButton.setSelected(true);
                                            break;
                                        case 1:
                                            mFastQFolderText.setText(x);
                                            break;
                                        case 2:
                                            mOutputFolderText.setText(x);
                                            break;
                                        case 3:
                                            mmiRBaseText.setText(x);
                                            break;
                                        case 4:
                                            if (x.equals("TRUE"))
                                                mDTrueRadioButton.setSelected(true);
                                            else
                                                mDFalseRadioButton.setSelected(true);
                                            break;
                                        case 5:
                                            if (x.equals("NEB"))
                                                mANEBRadioButton.setSelected(true);
                                            else
                                                mAILLUMINARadioButton.setSelected(true);
                                            break;
                                        case 6:
                                            if (x.equals("TRUE"))
                                                mTTrueRadioButton.setSelected(true);
                                            else
                                                mTFalseRadioButton.setSelected(true);
                                            break;
                                        default:
                                            System.out.print("Too much lines\n");
                                            throw(new NumberFormatException());
                                    }
                                    line++;
                                }
                            }
                            else
                                if ("indexing".equals(CurrentLayout)){
                                    int line=0;
                                    //chekc right file
                                    if (!br.readLine().equals("indexing")){
                                        throw(new NumberFormatException());
                                    }
                                    for (String x = br.readLine(); x != null; x = br.readLine()){
                                        switch (line){
                                            case 0:
                                                if (x.equals("sudo"))
                                                    iSudoRadioButton.setSelected(true);
                                                else
                                                    iDockerRadioButton.setSelected(true);
                                                break;
                                            case 1:
                                                iGenomeFolderText.setText(x);
                                                break;
                                            case 2:
                                                iThreadText.setText(x);
                                                break;
                                            case 3:
                                                iGenomeURLText.setText(x);
                                                break;
                                            case 4:
                                                iGTFURLText.setText(x);
                                                break;
                                            default:
                                                throw(new NumberFormatException());
                                        }
                                        line++;
                                    }
                                }
                                else
                                    if ("FPKMCounting".equals(CurrentLayout)){
                                        //chekc right file
                                        if (!br.readLine().equals("FPKMCounting")){
                                            throw(new NumberFormatException());
                                        }
                                        int line=0;
                                        for (String x = br.readLine(); x != null; x = br.readLine()){
                                            switch (line){
                                                case 0:
                                                    FtypesComboBox.setSelectedIndex(Integer.valueOf(x));
                                                    break;
                                                default:
                                                    DefaultTableModel model = (DefaultTableModel) FPKMFileTable.getModel();
                                                    String col2 = br.readLine();                                
                                                    String col3 = br.readLine();
                                                    if (col2==null)
                                                        col2="Cov.1";
                                                    if (col3==null)
                                                        col3="Batch1";
                                                    model.addRow(new Object[]{x,col2,col3});
                                            }
                                            line++;
                                        }
                                    }
                                    else
                                        if("PCA".equals(CurrentLayout)){
                                            if (!br.readLine().equals("PCA")){
                                                throw(new NumberFormatException());
                                            }
                                            int line=0;
                                            for (String x = br.readLine(); x != null; x = br.readLine()){
                                                switch (line){
                                                    case 0:
                                                        pFPKMfileText.setText(x);
                                                        break;
                                                    case 1:
                                                        pComponent1Text.setText(x);
                                                        break;
                                                    case 2:
                                                        pComponent2Text.setText(x);
                                                        break;
                                                    case 3:
                                                        switch (x) {
                                                            case "Counts":
                                                                pCountsRadioButton.setSelected(true);
                                                                break;
                                                            case "FPKM": 
                                                                pFPKMRadioButton.setSelected(true);
                                                                break;
                                                            default:
                                                                pTPMRadioButton.setSelected(true);
                                                                break;
                                                        }
                                                        break;
                                                    case 4:
                                                        pLegendComboBox.setSelectedIndex(Integer.valueOf(x));
                                                        break;
                                                    case 5:
                                                        if (x.equals("Yes"))
                                                            pCovYesRadioButton.setSelected(true);
                                                        else
                                                            pCovNoRadioButton.setSelected(true);
                                                        break;
                                                    case 6:
                                                        pOutputFolderText.setText(x);
                                                        break;
                                                }
                                                line++;
                                            }
                                        }
                                        else
                                            if("DES".equals(CurrentLayout)){
                                                if (!br.readLine().equals("DES")){
                                                    throw(new NumberFormatException());
                                                }
                                                int line=0;
                                                for (String x = br.readLine(); x != null; x = br.readLine()){
                                                    switch (line){
                                                        case 0:
                                                            dFPKMfileText.setText(x);
                                                            break;
                                                        case 1:
                                                            dLog2fcText.setText(x);
                                                            break;
                                                        case 2:
                                                            dFDRText.setText(x);
                                                            break;
                                                        case 3:
                                                            dCovComboBox.setSelectedIndex(Integer.valueOf(x));
                                                            break;
                                                        case 4:
                                                            switch (x) {
                                                                case "isoform":
                                                                    dIsoformRadioButton.setSelected(true);
                                                                    break;
                                                                case "miRNA":
                                                                    dmiRNARadioButton.setSelected(true);
                                                                    break;
                                                                default:
                                                                    dGeneRadioButton.setSelected(true);
                                                                    break;
                                                            }
                                                            break;
                                                        case 5:
                                                            dOutputFolderText.setText(x);
                                                            break;
                                                        case 6:
                                                            if (x.equals("TRUE"))
                                                                dBatchesTrue.setSelected(true);
                                                            else
                                                                DBatchesFalse.setSelected(true);
                                                            break;
                                                    }
                                                    line++;
                                                }
                                            }
                                            else
                                                if ("indexingB".equals(CurrentLayout)){
                                                    int line=0;
                                                    //chekc right file
                                                    if (!br.readLine().equals("indexingBWA")){
                                                        throw(new NumberFormatException());
                                                    }
                                                    for (String x = br.readLine(); x != null; x = br.readLine()){
                                                        switch (line){
                                                            case 0:
                                                                if (x.equals("sudo"))
                                                                    iSudoRadioButton.setSelected(true);
                                                                else
                                                                    iDockerRadioButton.setSelected(true);
                                                                break;
                                                            case 1:
                                                                iGenomeFolderBText.setText(x);
                                                                break;
                                                            case 2:
                                                                iThreadBText.setText(x);
                                                                break; 
                                                            case 3:
                                                                iGenomeURLBText.setText(x);
                                                                break;  
                                                            case 4:
                                                                if (x.equals("true"))
                                                                    iBTrueRadioButton.setSelected(true); 
                                                                else
                                                                    iBFalseRadioButton.setSelected(true);
                                                                break;
                                                            case 5:
                                                                i1000GenomeText.setText(x);
                                                                break;
                                                            case 6:
                                                                idbSPNText.setText(x);
                                                                break;
                                                            default:
                                                                throw(new NumberFormatException());
                                                        }
                                                        line++;
                                                    } 
                                                }
                                                else
                                                    if ("MACS".equals(CurrentLayout)){
                                                        int line=0;
                                                        //chekc right file
                                                        if (!br.readLine().equals("MACS")){
                                                            throw(new NumberFormatException());
                                                        }
                                                        for (String x = br.readLine(); x != null; x = br.readLine()){
                                                            switch (line){
                                                                case 0:
                                                                    if (x.equals("sudo"))
                                                                        MSudoRadioButton.setSelected(true);
                                                                    else
                                                                        MDockerRadioButton.setSelected(true);
                                                                    break;
                                                                case 1:
                                                                    MOutputFolderText.setText(x);
                                                                    break;
                                                                case 2:
                                                                    MScratchFolderText.setText(x);
                                                                    break;
                                                                case 3:
                                                                    MGenomeFolderText.setText(x);
                                                                    break;
                                                                case 4:
                                                                    MTestFolderText.setText(x);
                                                                    break;
                                                                case 5:
                                                                    MMockFolderText.setText(x);
                                                                    break;
                                                                case 6:
                                                                    MThreadText.setText(x);
                                                                    break;
                                                                case 7:
                                                                    MAdapter5Text.setText(x);
                                                                    break;
                                                                case 8:
                                                                    MAdapter3Text.setText(x);
                                                                    break;
                                                                case 9:
                                                                    MMinLengthText.setText(x);
                                                                    break;
                                                                case 10:
                                                                    MReadLengthTextField.setText(x);
                                                                    break;
                                                                case 11:
                                                                    MOrgComboBox.setSelectedIndex(Integer.valueOf(x));
                                                                    break;
                                                                case 12:
                                                                    if (x.equals("no"))
                                                                        MRnoRadioButton.setSelected(true);
                                                                    else
                                                                        MRyesRadioButton.setSelected(true);
                                                                    break;
                                                                case 13:
                                                                    MMaxUpstreamText.setText(x);
                                                                    break;
                                                                case 14:
                                                                    MTTSText.setText(x);
                                                                    break;
                                                                case 15:
                                                                    MMinmfoldText.setText(x);
                                                                    break;
                                                                case 16:
                                                                    MMpvalueText.setText(x);
                                                                    break;
                                                                case 17:
                                                                    MMaxmfoldText.setText(x);
                                                                    break;
                                                                case 18:
                                                                    MSWindowsText.setText(x);
                                                                    break;
                                                                case 19:
                                                                    MSgsizeText.setText(x);
                                                                    break;
                                                                case 20:
                                                                    MSFDRText.setText(x);
                                                                    break;
                                                                case 21:
                                                                    MToolComboBox.setSelectedIndex(Integer.valueOf(x));
                                                                    break;
                                                                default:
                                                                    throw(new NumberFormatException());
                                                            }
                                                            line++;
                                                        }
                                                    }
                                                    else
                                                        if("SampleSize".equals(CurrentLayout)){
                                                            int line=0;
                                                            //chekc right file
                                                            if (!br.readLine().equals("SampleSize")){
                                                                throw(new NumberFormatException());
                                                            }
                                                            for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                switch (line){
                                                                    case 0:
                                                                        SSCountTableText.setText(x);
                                                                        break;
                                                                    case 1:
                                                                        SSOutputFolderText.setText(x);
                                                                        break;
                                                                    case 2:
                                                                        SSPowerText.setText(x);
                                                                        break;
                                                                    case 3:
                                                                        SSGeneText.setText(x);
                                                                        break;
                                                                    case 4:
                                                                        SSlog2Text.setText(x);
                                                                        break;
                                                                    case 5:
                                                                        SSFDRtext.setText(x);
                                                                        break;
                                                                    default:
                                                                        throw(new NumberFormatException());
                                                                }
                                                                line++;
                                                                
                                                            }
                                                        }
                                                        else
                                                            if("ExperimentPower".equals(CurrentLayout)){
                                                                
                                                                //chekc right file
                                                                if (!br.readLine().equals("ExperimentPower")){
                                                                    throw(new NumberFormatException());
                                                                }
                                                                int line=0;
                                                                for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                    switch (line){
                                                                        case 0:
                                                                            EPCountTableText.setText(x);
                                                                            break;
                                                                        case 1:
                                                                            EPOutputFolderText.setText(x);
                                                                            break;
                                                                        case 2:
                                                                            EPSampleText.setText(x);
                                                                            break;
                                                                        case 3:
                                                                            EPGeneText.setText(x);
                                                                            break;
                                                                        case 4:
                                                                            EPlog2Text.setText(x);
                                                                            break;
                                                                        case 5:
                                                                            EPFDRtext.setText(x);
                                                                            break;
                                                                        default:
                                                                            throw(new NumberFormatException());
                                                                    }
                                                                    line++;
                                                                    
                                                                }
                                                            }
                                                            else
                                                                if("AddingCovmRNA".equals(CurrentLayout)){
                                                                    if (!br.readLine().equals("AddingCovmRNA")){
                                                                        throw(new NumberFormatException());
                                                                    }
                                                                    int line=0;
                                                                    for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                        switch (line){
                                                                            case 0:
                                                                                CCovInputFileText.setText(x);
                                                                                break;
                                                                            case 1:
                                                                                COutputFolderText.setText(x);
                                                                                break;
                                                                            default:
                                                                                DefaultTableModel model = (DefaultTableModel) CCountHeaderTable.getModel();
                                                                                String col2 = br.readLine();
                                                                                String col3 = br.readLine();
                                                                                if (col2==null)
                                                                                    col2="Cov.1";
                                                                                if (col3==null)
                                                                                    col3="Batch1";
                                                                                model.addRow(new Object[]{x,col2,col3});
                                                                        }
                                                                        line++;
                                                                    }
                                                                }
                                                                else
                                                                    if ("indexingSalmon".equals(CurrentLayout)){
                                                                        //chekc right file
                                                                        if (!br.readLine().equals("indexingSalmon")){
                                                                            throw(new NumberFormatException());
                                                                        }
                                                                        int line=0;
                                                                        for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                            switch (line){
                                                                                case 0:
                                                                                    if (x.equals("sudo"))
                                                                                        iSudoRadioSButton.setSelected(true);
                                                                                    else
                                                                                        iDockerRadioSButton.setSelected(true);
                                                                                    break;
                                                                                case 1:
                                                                                    iGenomeFolderSText.setText(x);
                                                                                    break;
                                                                                case 2:
                                                                                    iThreadSText.setText(x);
                                                                                    break;
                                                                                case 3:
                                                                                    iGenomeURLSText.setText(x);
                                                                                    break;
                                                                                case 4:
                                                                                    iGTFURLSText.setText(x);
                                                                                    break;
                                                                                case 5:
                                                                                    iKmerSText.setText(x);
                                                                                    break;
                                                                                default:
                                                                                    throw(new NumberFormatException());
                                                                            }
                                                                            line++;
                                                                        }
                                                                    }
                                                                    else
                                                                        if ("countingSalmon".equals(CurrentLayout)){
                                                                            
                                                                            //chekc right file
                                                                            String y=br.readLine();
                                                                            if (!y.equals("countingSalmon")){
                                                                                throw(new NumberFormatException());
                                                                            }
                                                                            int line=0;
                                                                            for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                                switch (line){
                                                                                    case 0:
                                                                                        if (x.equals("sudo"))
                                                                                            cSudoRadioButton.setSelected(true);
                                                                                        else
                                                                                            cDockerRadioButton.setSelected(true);
                                                                                        break;
                                                                                    case 1:
                                                                                        cFastQFolderText.setText(x);
                                                                                        break;
                                                                                    case 2:
                                                                                        cOutputFolderText.setText(x);
                                                                                        break;
                                                                                    case 3:
                                                                                        cAdapter5Text.setText(x);
                                                                                        break;
                                                                                    case 4:
                                                                                        cAdapter3Text.setText(x);
                                                                                        break;
                                                                                    case 5:
                                                                                        if (x.equals("se"))
                                                                                            cSeRadioButton.setSelected(true);
                                                                                        else
                                                                                            cPeRadioButton.setSelected(true);
                                                                                        break;
                                                                                    case 6:
                                                                                        cThreadText.setText(x);
                                                                                        break;
                                                                                    case 7:
                                                                                        cMinLengthText.setText(x);
                                                                                        break;
                                                                                    case 8:
                                                                                        cGenomeFolderText.setText(x);
                                                                                        break;
                                                                                    case 9:
                                                                                        switch (x) {
                                                                                            case "none":
                                                                                                cSNoneRadioButton.setSelected(true);
                                                                                                break;
                                                                                            case "forward":
                                                                                                cSForwardRadioButton.setSelected(true);
                                                                                                break;
                                                                                            default:
                                                                                                cSReverseRadioButton.setSelected(true);
                                                                                                break;
                                                                                        }
                                                                                        break;
                                                                                    default:
                                                                                        System.out.print("Too much lines\n");
                                                                                        throw(new NumberFormatException());
                                                                                }
                                                                                line++;
                                                                            }
                                                                        }
                                                                        else
                                                                            if("filtercounts".equals(CurrentLayout)){
                                                                                if (!br.readLine().equals("filtercounts")){
                                                                                    throw(new NumberFormatException());
                                                                                }
                                                                                int line=0;
                                                                                for (String x = br.readLine(); x != null; x = br.readLine()){
                                                                                    switch (line){
                                                                                        case 0:
                                                                                            fFPKMfileText.setText(x);
                                                                                            break;
                                                                                        case 1:
                                                                                            switch (x) {
                                                                                                case "gene":
                                                                                                    fgeneRadioButton.setSelected(true);
                                                                                                    break;
                                                                                                case "isoform":
                                                                                                    fisoformRadioButton.setSelected(true);
                                                                                                    break;
                                                                                                default:
                                                                                                    fmirnaRadioButton.setSelected(true);
                                                                                                    break;
                                                                                            }
                                                                                            break;
                                                                                        case 2:
                                                                                            fOutputFolderText.setText(x);
                                                                                            break;
                                                                                    }
                                                                                    line++;
                                                                                }
                                                                            }
                        getPreferences().put("saved-file",openFile.getCurrentDirectory().getAbsolutePath());
                    }
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error opening file","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(this, "Error reading file","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    } 
    
    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (!"Empty".equals(CurrentLayout)){  
            JFileChooser saveFile = new JFileChooser(); 
            String curDir = getPreferences().get("saved-file", null);
            saveFile.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
            if (saveFile.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
                try        
                {               
                    File f = saveFile.getSelectedFile();              
                    if (!f.exists()) {
                        f.createNewFile();
                    }
                    FileWriter fw = new FileWriter(f.getAbsoluteFile());
                    try (BufferedWriter bw = new BufferedWriter(fw)) {
                        if ("vmRNA".equals(CurrentLayout)){
                            bw.write("vmRNA\n");
                            if (vSudoRadioButton.isSelected()){
                                bw.write("sudo\n");
                            }                    
                            else{
                                bw.write("docker\n");
                            }
                            bw.write(vFastQFolderText.getText());
                            bw.write("\n");
                            bw.write(vOutputFolderText.getText());
                            bw.write("\n");
                            bw.write(vAdapter5Text.getText());
                            bw.write("\n");
                            bw.write(vAdapter3Text.getText());
                            bw.write("\n");
                            if (vPeRadioButton.isSelected()){
                                bw.write("pe\n");
                            }
                            else{
                                bw.write("se\n");
                            }
                            bw.write(vThreadText.getText());
                            bw.write("\n");
                            bw.write(vMinLengthText.getText());
                            bw.write("\n");
                            bw.write(vGenomeFolderText.getText());
                            bw.write("\n");
                            if (vSNoneRadioButton.isSelected())
                                bw.write("none\n");
                            else
                                if (vSForwardRadioButton.isSelected())
                                    bw.write("forward\n");
                                else
                                    bw.write("reverse\n");
                            
                            if (vBAMnoLRadioButton.isSelected())
                                bw.write("gtfENSEMBL\n");
                            else
                                bw.write("biocENSEMBL\n");
                            bw.write(vOrganismText.getText());
                        }
                        else
                            if ( CurrentLayout=="mRNA"){
                                bw.write("mRNA\n");
                                if (mSudoRadioButton.isSelected()){
                                    bw.write("sudo\n");
                                }                
                                else{
                                    bw.write("docker\n");
                                }
                                bw.write(mFastQFolderText.getText());
                                bw.write("\n");
                                bw.write(mOutputFolderText.getText());
                                bw.write("\n");
                                bw.write(mmiRBaseText.getText());
                                bw.write("\n");
                                if (mDTrueRadioButton.isSelected()){
                                    bw.write("TRUE\n");
                                }
                                else{
                                    bw.write("FALSE\n");
                                }
                                if (mANEBRadioButton.isSelected()){
                                    bw.write("NEB\n");
                                }
                                else{
                                    bw.write("ILLUMINA\n");
                                }
                                if (mTTrueRadioButton.isSelected()){
                                    bw.write("TRUE\n");
                                }
                                else{
                                    bw.write("FALSE\n");
                                }
                            }
                            else{
                                if ("indexing".equals(CurrentLayout)){
                                    bw.write("indexingSTAR\n");
                                    if (iSudoRadioButton.isSelected()){
                                        bw.write("sudo\n");
                                    }
                                    else{
                                        bw.write("docker\n");
                                    }
                                    
                                    bw.write(iGenomeFolderText.getText());
                                    bw.write("\n");
                                    bw.write(iThreadText.getText());
                                    bw.write("\n");
                                    bw.write(iGenomeURLText.getText());
                                    bw.write("\n");
                                    bw.write(iGTFURLText.getText());
                                }
                                else
                                    if("FPKMCounting".equals(CurrentLayout)){
                                        bw.write("FPKMCounting\n");
                                        bw.write(Integer.toString(FtypesComboBox.getSelectedIndex()));
                                        bw.write("\n");
                                        for (int i=0;i<FPKMFileTable.getRowCount();i++){
                                            bw.write(FPKMFileTable.getModel().getValueAt(i,0).toString());
                                            bw.write("\n");
                                            bw.write(FPKMFileTable.getModel().getValueAt(i,1).toString());
                                            bw.write("\n");
                                            bw.write(FPKMFileTable.getModel().getValueAt(i,2).toString());
                                            bw.write("\n");
                                        }
                                    }
                                    else
                                        if("PCA".equals(CurrentLayout)){
                                            bw.write("PCA\n");
                                            bw.write(pFPKMfileText.getText());
                                            bw.write("\n");
                                            bw.write(pComponent1Text.getText());
                                            bw.write("\n");
                                            bw.write(pComponent2Text.getText());
                                            bw.write("\n");
                                            if (pCountsRadioButton.isSelected()){
                                                bw.write("Counts\n");
                                            }
                                            else
                                                if (pFPKMRadioButton.isSelected()){
                                                    bw.write("FPKM\n");
                                                }
                                                else{
                                                    bw.write("TPM\n");
                                                }
                                            bw.write(Integer.toString(pLegendComboBox.getSelectedIndex()));
                                            bw.write("\n");
                                            if (pCovYesRadioButton.isSelected()){
                                                bw.write("Yes\n");
                                            }
                                            else
                                                bw.write("No\n");
                                            bw.write(pOutputFolderText.getText());
                                        }
                                        else
                                            if("DES".equals(CurrentLayout)){
                                                bw.write("DES\n");
                                                bw.write(dFPKMfileText.getText());
                                                bw.write("\n");
                                                bw.write(dLog2fcText.getText());
                                                bw.write("\n");
                                                bw.write(dFDRText.getText());
                                                bw.write("\n");
                                                bw.write(Integer.toString(dCovComboBox.getSelectedIndex()));
                                                bw.write("\n");
                                                if (dIsoformRadioButton.isSelected()){
                                                    bw.write("isoform\n");
                                                }
                                                else
                                                    if (dGeneRadioButton.isSelected())
                                                        bw.write("gene\n");
                                                    else
                                                        bw.write("miRNA\n");
                                                bw.write(dOutputFolderText.getText());
                                                if (dBatchesTrue.isSelected())
                                                    bw.write("TRUE\n");
                                                else
                                                    bw.write("FALSE\n");
                                            }
                                            else
                                                if ("indexingB".equals(CurrentLayout)){
                                                    bw.write("indexingBWA\n");
                                                    if (iSudoBRadioButton.isSelected()){
                                                        bw.write("sudo\n");
                                                    }
                                                    else{
                                                        bw.write("docker\n");
                                                    }
                                                    bw.write(iGenomeFolderBText.getText());
                                                    bw.write("\n");
                                                    bw.write(iThreadBText.getText());
                                                    bw.write("\n");
                                                    bw.write(iGenomeURLBText.getText());
                                                    bw.write("\n");
                                                    if (iBTrueRadioButton.isSelected()){
                                                        bw.write("true\n");
                                                    }
                                                    else{
                                                        bw.write("false\n");
                                                    }
                                                    bw.write(i1000GenomeText.getText());
                                                    bw.write("\n");
                                                    bw.write(idbSPNText.getText());
                                                }
                                                else
                                                    if ("MACS".equals(CurrentLayout)){
                                                        bw.write("MACS\n");
                                                        if (MSudoRadioButton.isSelected()){
                                                            bw.write("sudo\n");
                                                        }
                                                        else{
                                                            bw.write("docker\n");
                                                        }
                                                        bw.write(MOutputFolderText.getText());
                                                        bw.write("\n");
                                                        bw.write(MScratchFolderText.getText());
                                                        bw.write("\n");
                                                        bw.write(MGenomeFolderText.getText());
                                                        bw.write("\n");
                                                        bw.write(MTestFolderText.getText());
                                                        bw.write("\n");
                                                        bw.write(MMockFolderText.getText());
                                                        bw.write("\n");
                                                        bw.write(MThreadText.getText());
                                                        bw.write("\n");
                                                        bw.write(MAdapter5Text.getText());
                                                        bw.write("\n");
                                                        bw.write(MAdapter3Text.getText());
                                                        bw.write("\n");
                                                        bw.write(MMinLengthText.getText());
                                                        bw.write("\n");
                                                        bw.write(MReadLengthTextField.getText());
                                                        bw.write("\n");
                                                        bw.write(Integer.toString(MOrgComboBox.getSelectedIndex()));
                                                        bw.write("\n");
                                                        if ( MRnoRadioButton.isSelected()){
                                                            bw.write("no\n");
                                                        }
                                                        else{
                                                            bw.write("yes\n");
                                                        }
                                                        bw.write(MMaxUpstreamText.getText());
                                                        bw.write("\n");
                                                        bw.write(MTTSText.getText());
                                                        bw.write("\n");
                                                        bw.write(MMinmfoldText.getText());
                                                        bw.write("\n");
                                                        bw.write(MMpvalueText.getText());
                                                        bw.write("\n");
                                                        bw.write(MMaxmfoldText.getText());
                                                        bw.write("\n");
                                                        bw.write(MSWindowsText.getText());
                                                        bw.write("\n");
                                                        bw.write(MSgsizeText.getText());
                                                        bw.write("\n");
                                                        bw.write(MSFDRText.getText());
                                                        bw.write("\n");
                                                        bw.write(Integer.toString(MToolComboBox.getSelectedIndex()));
                                                    }else
                                                        if("SampleSize".equals(CurrentLayout)){
                                                            bw.write("SampleSize\n");
                                                            bw.write(SSCountTableText.getText());
                                                            bw.write("\n");
                                                            bw.write(SSOutputFolderText.getText());
                                                            bw.write("\n");
                                                            bw.write(SSPowerText.getText());
                                                            bw.write("\n");
                                                            bw.write(SSGeneText.getText());
                                                            bw.write("\n");
                                                            bw.write(SSlog2Text.getText());
                                                            bw.write("\n");
                                                            bw.write(SSFDRtext.getText());
                                                        }
                                                        else
                                                            if("ExperimentPower".equals(CurrentLayout)){
                                                                bw.write("ExperimentPower\n");
                                                                bw.write(EPCountTableText.getText());
                                                                bw.write("\n");
                                                                bw.write(EPOutputFolderText.getText());
                                                                bw.write("\n");
                                                                bw.write(EPSampleText.getText());
                                                                bw.write("\n");
                                                                bw.write(EPGeneText.getText());
                                                                bw.write("\n");
                                                                bw.write(EPlog2Text.getText());
                                                                bw.write("\n");
                                                                bw.write(EPFDRtext.getText());
                                                            }
                                                            else
                                                                if("AddingCovmRNA".equals(CurrentLayout)){
                                                                    bw.write("AddingCovmRNA\n");
                                                                    bw.write(CCovInputFileText.getText());
                                                                    bw.write("\n");
                                                                    bw.write(COutputFolderText.getText());
                                                                    bw.write("\n");
                                                                    for (int i=0;i<CCountHeaderTable.getRowCount();i++){
                                                                        bw.write(CCountHeaderTable.getModel().getValueAt(i,0).toString());
                                                                        bw.write("\n");
                                                                        bw.write(CCountHeaderTable.getModel().getValueAt(i,1).toString());
                                                                        bw.write("\n");
                                                                        bw.write(CCountHeaderTable.getModel().getValueAt(i,2).toString());
                                                                        bw.write("\n");
                                                                    }
                                                                }
                                                                else
                                                                    if ("indexingSalmon".equals(CurrentLayout)){
                                                                        bw.write("indexingSalmon\n");
                                                                        if (iSudoRadioSButton.isSelected()){
                                                                            bw.write("sudo\n");
                                                                        }
                                                                        else{
                                                                            bw.write("docker\n");
                                                                        }
                                                                        bw.write(iGenomeFolderSText.getText());
                                                                        bw.write("\n");
                                                                        bw.write(iThreadSText.getText());
                                                                        bw.write("\n");
                                                                        bw.write(iGenomeURLSText.getText());
                                                                        bw.write("\n");
                                                                        bw.write(iGTFURLSText.getText());
                                                                        bw.write("\n");
                                                                        bw.write(iKmerSText.getText());
                                                                    }
                                                                    else
                                                                        if ("countingSalmon".equals(CurrentLayout)){
                                                                            bw.write("countingSalmon\n");
                                                                            if (cSudoRadioButton.isSelected()){
                                                                                bw.write("sudo\n");
                                                                            }
                                                                            else{
                                                                                bw.write("docker\n");
                                                                            }
                                                                            bw.write(cFastQFolderText.getText());
                                                                            bw.write("\n");
                                                                            bw.write(cOutputFolderText.getText());
                                                                            bw.write("\n");
                                                                            bw.write(cAdapter5Text.getText());
                                                                            bw.write("\n");
                                                                            bw.write(cAdapter3Text.getText());
                                                                            bw.write("\n");
                                                                            if (cPeRadioButton.isSelected()){
                                                                                bw.write("pe\n");
                                                                            }
                                                                            else{
                                                                                bw.write("se\n");
                                                                            }
                                                                            bw.write(cThreadText.getText());
                                                                            bw.write("\n");
                                                                            bw.write(cMinLengthText.getText());
                                                                            bw.write("\n");
                                                                            bw.write(cGenomeFolderText.getText());
                                                                            bw.write("\n");
                                                                            if (cSNoneRadioButton.isSelected())
                                                                                bw.write("none\n");
                                                                            else
                                                                                if (cSForwardRadioButton.isSelected())
                                                                                    bw.write("forward\n");
                                                                                else
                                                                                    bw.write("reverse\n");
                                                                            
                                                                        }
                                                                        else
                                                                            if("filtercounts".equals(CurrentLayout)){
                                                                                bw.write("filtercounts\n");
                                                                                bw.write(fFPKMfileText.getText());
                                                                                bw.write("\n");
                                                                                if (fgeneRadioButton.isSelected()){
                                                                                    bw.write("gene\n");
                                                                                }
                                                                                else
                                                                                    if (fisoformRadioButton.isSelected()){
                                                                                        bw.write("isoform\n");
                                                                                    }
                                                                                    else{
                                                                                        bw.write("mirna\n");
                                                                                    }
                                                                                bw.write(fOutputFolderText.getText());
                                                                            }
                            }
                    }
                    JOptionPane.showMessageDialog(this,"File "+f.getName()+" saved","Save",JOptionPane.INFORMATION_MESSAGE);
                    getPreferences().put("saved-file",saveFile.getCurrentDirectory().getAbsolutePath());                                          
                }
             
                catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saving file","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
                
    }   
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        vDockerRadioButton.setSelected(true);
        vFastQFolderText.setText("");
        vOutputFolderText.setText("");
        vThreadText.setText(Integer.toString(GS.getDefaultThread()));
        vAdapter5Text.setText(GS.getDefaultAdapter5());
        vAdapter3Text.setText(GS.getDefaultAdapter3());
        vSeRadioButton.setSelected(true);
        vMinLengthText.setText("40");
        vGenomeFolderText.setText("");
        vSNoneRadioButton.setSelected(true);
        vOrganismText.setText("hg38");
        vPeRadioButton.setSelected(true);
        vBAMnoLRadioButton.setSelected(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //Field check

        if (vFastQFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input folder","Error: FastQ  folder",JOptionPane.ERROR_MESSAGE);
            //vFastQFolderText.requestFocusInWindow();
            return;
        }
        else
        if (vOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output folder","Error: Output folder",JOptionPane.ERROR_MESSAGE);
            //vOutputFolderText.requestFocusInWindow();
            return;
        }
        else
        if (vGenomeFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            //vGenomeFolderText.requestFocusInWindow();
            return;
        }
        else
        if (vThreadText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            vThreadText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(vThreadText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                vThreadText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            vThreadText.requestFocusInWindow();
            return;
        }

        if ((!vAdapter5Text.getText().isEmpty())&&(!adapter.matcher(vAdapter5Text.getText()).matches())){
            JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 5'",JOptionPane.ERROR_MESSAGE);
            vAdapter5Text.requestFocusInWindow();
        }
        else{
            if ((!vAdapter3Text.getText().isEmpty())&&(!adapter.matcher(vAdapter3Text.getText()).matches())){
                JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 3'",JOptionPane.ERROR_MESSAGE);
                vAdapter3Text.requestFocusInWindow();
            }
            else{
                if (vMinLengthText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "You have to specified a value for the minimum lenght.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    vMinLengthText.requestFocusInWindow();
                    return;
                }
                try{
                    Integer x = Integer.valueOf(vMinLengthText.getText());
                    if (x<0){
                        JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                        vMinLengthText.requestFocusInWindow();
                        return;
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    vMinLengthText.requestFocusInWindow();
                    return;
                }
                if (!org.matcher(vOrganismText.getText()).matches()){
                    JOptionPane.showMessageDialog(this, "The specified organism is not valid.","Error: Organism",JOptionPane.ERROR_MESSAGE);
                    vOrganismText.requestFocusInWindow();
                }
                else{
                    //execute code
                    Runtime rt = Runtime.getRuntime();
                    try{
                        String[] cmd = {"/bin/bash","-c"," bash ./execRNA.sh "};
                        
                        if (vSudoRadioButton.isSelected()){
                            cmd[2]+= "group=\\\"sudo\\\"";
                        }
                        else{
                            cmd[2]+= "group=\\\"docker\\\"";
                        }
                        cmd[2]+= " fastq.folder=\\\""+vFastQFolderText.getText()+"\\\" scratch.folder=\\\""+vOutputFolderText.getText()+"\\\" adapter5=\\\""+vAdapter5Text.getText()+"\\\" adapter3=\\\""+vAdapter3Text.getText()+"\\\"";
                    
                        if (vPeRadioButton.isSelected()){
                            cmd[2]+= " seq.type=\\\"pe\\\"";
                        }
                        else{
                            cmd[2]+= " seq.type=\\\"se\\\"";
                        }
                       cmd[2]+= " threads="+vThreadText.getText()+" min.length="+vMinLengthText.getText()+" genome.folder=\\\""+vGenomeFolderText.getText()+"\\\"";
                       
                       if (vSNoneRadioButton.isSelected())
                             cmd[2]+= " strandness=\\\"none\\\"";
                       else
                           if (vSForwardRadioButton.isSelected())
                               cmd[2]+= " strandness=\\\"forward\\\"";
                           else
                               cmd[2]+= " strandness=\\\"reverse\\\"";
                       
                       cmd[2]+= " annotation.type=\\\"gtfENSEMBL\\\"";
                       
                       if (vBAMyesRadioButton.isSelected())
                           cmd[2]+= " save.bam=TRUE";
                       else
                           cmd[2]+= " save.bam=FALSE";
                       
                       cmd[2]+=" org=\\\""+vOrganismText.getText()+"\\\"";
                       
                        cmd[2]+=" "+vFastQFolderText.getText() +" >& "+vFastQFolderText.getText()+"/outputExecution ";
                        
                        //ProcessStatus.setText(pr.toString());
                        if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                            Process pr = rt.exec(cmd); 
                            //System.out.println("lanciato "+pr);                            
                            ElProcRunning tmp= new ElProcRunning("Genes, isoforms counting RSEM ", vFastQFolderText.getText(),pr,listModel.getSize());
                            listProcRunning.add(tmp);
                            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                            ImageIcon image2 = new ImageIcon(imgURL);
                            GL.setAvoidProcListValueChanged(-1);
                            listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                            GL.setAvoidProcListValueChanged(0);
                                    //addElement("RNAseq counting workflow (data input: "+vFastQFolderText.getText()+")            [Runnig]");
                            if(listProcRunning.size()==1){
                                t=new Timer();
                                t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                            }
                        }
                         
                        else{
                            ElProcWaiting tmp= new ElProcWaiting("Genes, isoforms counting RSEM ",vFastQFolderText.getText(),cmd,listModel.getSize());
                            listProcWaiting.add(tmp);
                            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                            ImageIcon image2 = new ImageIcon(imgURL);
                            GL.setAvoidProcListValueChanged(-1);
                            listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                            GL.setAvoidProcListValueChanged(0);

                        }
                        GL.setAvoidProcListValueChanged(-1);
                        ProcList.setModel(listModel);
                        ProcList.setCellRenderer(new ListEntryCellRenderer());
                        GL.setAvoidProcListValueChanged(0);
                        } 
                    catch(IOException e) {
                        JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                        System.out.println(e.toString());
                        }
                    JOptionPane.showMessageDialog(this, "Genes, isoforms counting RSEM task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
                    }
                  //execute code
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void vCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButtonActionPerformed

        //RESET FIELDS
        vDockerRadioButton.setSelected(true);
        vFastQFolderText.setText("");
        vOutputFolderText.setText("");
        vThreadText.setText(Integer.toString(GS.getDefaultThread()));
        vAdapter5Text.setText(GS.getDefaultAdapter5());
        vAdapter3Text.setText(GS.getDefaultAdapter3());
        vSeRadioButton.setSelected(true);
        vMinLengthText.setText("40");
        vGenomeFolderText.setText("");
        vSNoneRadioButton.setSelected(true);
        vOrganismText.setText("hg38");
        vBAMyesRadioButton.setSelected(true);
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
       // AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButtonActionPerformed

    private void mDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mDockerRadioButtonActionPerformed

    private void mSudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSudoRadioButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         openMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProcListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ProcListValueChanged
        
      
        if (!evt.getValueIsAdjusting()){
            
        //System.out.println("****Open ProcListValueChanged : \n"+GL.getAvoidProcListValueChanged()+" "+GL.getListProcStatuSelection()+" "+evt.getLastIndex());
        if ((GL.getAvoidProcListValueChanged()==-1)){
           // GL.setAvoidProcListValueChanged(0);
            return;
        }
        //if (evt.getLastIndex()<0 ||evt.getLastIndex()>=listModel.getSize()){
        //    return;
        //}
  
        if ((evt!=null)){
        OutputFrame.pack();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int OutputframeWidth= Integer.valueOf(getPreferences().get("4SeqGUI_WindowOutputWidth", "0"));
        int OutputframeHeight= Integer.valueOf(getPreferences().get("4SeqGUI_WindowOutputHeight", "0")); 
        
        if ((OutputframeWidth==0)||(OutputframeHeight==0)){
              OutputframeWidth=screenSize.width*40/100;
              OutputframeHeight=screenSize.height*50/100;
        }
        
        OutputFrame.setSize(OutputframeWidth,OutputframeHeight);
//automatically update file

     
            
        OutputFrame.setLocationRelativeTo(null);   
        OutputFrame.setVisible(true);
        OutputFrame.setAlwaysOnTop(true);
        
        //System.out.println("QUII->-Inizio\n"+listModel.getSize()+" "+evt.getLastIndex()+"\n"+evt.getSource());
        ListEntry tmpListEntry;
        if ((evt.getLastIndex()!=GL.getListProcStatuSelection()&& (evt.getLastIndex()>=0 && evt.getLastIndex()<listModel.getSize())) ){
                tmpListEntry=  listModel.get(evt.getLastIndex());
                GL.setListProcStatuSelection(evt.getLastIndex());
                
                   //System.out.println("\t------- Selected Last\n");
        }
        else    {
                if (evt.getFirstIndex()>=0 && evt.getFirstIndex()<listModel.getSize()){
                tmpListEntry=  listModel.get(evt.getFirstIndex());
                 //System.out.println("\t------- Selected First\n");
                GL.setListProcStatuSelection(evt.getFirstIndex());
                }
                else
                    return;
        }
        
        if (tmpListEntry.status.equals("Running") || tmpListEntry.status.equals("Finished")){ 
            //System.out.println("\tQUII->-RUNNING\n");
            String text="";
            OutputText.setEnabled(true);
            try{
                File file = new File( tmpListEntry.path+"/Routput.Rout");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String strLine;
                    //Read File Line By Line
                    while ((strLine = reader.readLine()) != null)   {
                        text+="\n"+strLine;
                    }
                }
            }
            catch (IOException e){//Catch exception if any
                //System.err.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error reading R output file","Error",JOptionPane.ERROR_MESSAGE);
            }
            OutputText.setText(text);
           if (tmpListEntry.status.equals("Running")){
                outputTime=new Timer();
                outputTime.scheduleAtFixedRate(new MyFileUpdate(), 5000, 5000);  
            }
           else{
            DlogButton.setEnabled(true);
           }
        }
        else
        {
          OutputText.setEnabled(false);  
          //System.out.println("\tQUIFINE WAITING\n");
        }
        //System.out.println("QUIFINE\n");
        //GL.setListProcStatuSelection(evt.getLastIndex());
        //System.out.println("End ProcListValueChanged\n");
        }
        }

    }//GEN-LAST:event_ProcListValueChanged

    private void CloseOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseOutputActionPerformed
    OutputFrame.setVisible(false);        // TODO add your handling code here:
    OutputText.setText("");
    OutputText.setEnabled(true);
    DlogButton.setEnabled(false);
    
    GL.setAvoidProcListValueChanged(-1);
    //GL.setListProcStatuSelection(-1);  
    ProcList.clearSelection();
    GL.setAvoidProcListValueChanged(0);
    getPreferences().put("4SeqGUI_WindowOutputWidth", Integer.toString(OutputFrame.getWidth()));
    getPreferences().put("4SeqGUI_WindowOutputHeight", Integer.toString(OutputFrame.getHeight())); 
    //System.out.println("@@@@@@@@@@@@Close: \n");
    outputTime.cancel();
    }//GEN-LAST:event_CloseOutputActionPerformed

    private void ProcListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcListMouseClicked

    private void ReloadOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReloadOutputActionPerformed
       
         ListEntry tmpListEntry =  listModel.get(GL.getListProcStatuSelection());
        //
        if (tmpListEntry.status.equals("Running") || tmpListEntry.status.equals("Finished")){
             OutputText.setEnabled(true);
            String text="";
            try{
                File file = new File( tmpListEntry.path+"/Routput.Rout");
                 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                     String strLine;
                     //Read File Line By Line
                     while ((strLine = reader.readLine()) != null)   {
                         text+="\n"+strLine;
                     }}    
            }
            catch (IOException e){//Catch exception if any
                System.err.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Error reading file","Error",JOptionPane.ERROR_MESSAGE);
            }
            OutputText.setText(text);
        }
        ReloadOutput.setSelected(false);
    }//GEN-LAST:event_ReloadOutputActionPerformed

    
    private void RemoveOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveOutputActionPerformed
       
        int pos=GL.getListProcStatuSelection();
        //System.out.println("Pos:"+pos+"\n");
        int tmpPos=-1;
        for(int i=0;i<listProcRunning.size();i++){
           
            if (listProcRunning.get(i).pos>pos){
                listProcRunning.get(i).pos--;
            }
            else
                if (listProcRunning.get(i).pos==pos){
                    tmpPos=i;
                }
        }
        if (tmpPos!=-1){
            //try{
            //if Docker is runnning
            String[] cmd = {"/bin/bash","-c"," "};
            try{
                    File file = new File(listProcRunning.get(tmpPos).path+"/dockerID");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String dockerID = reader.readLine();
                    cmd[2]="docker kill " +dockerID +" ; rm " + listProcRunning.get(tmpPos).path+"/dockerID"; 
                    Runtime.getRuntime().exec(cmd);
                }    
                }
            catch (IOException e){//Catch exception if any
                System.out.println("No docker running \n");
                } 
            long pID=getPidOfProcess(listProcRunning.get(tmpPos).pr);
            //System.out.println("lanciato PID:"+pID +"\n");  
            if (pID!=-1){
                try{
                   cmd[2]="kill $(./list_descendants.sh " +Long.toString(pID)+")"; 
                   Runtime.getRuntime().exec(cmd);
                }
                catch(IOException e){
                    System.err.println("Error in Killing the process children:" + e);
                }
                
            }
            try{
                    File file = new File(listProcRunning.get(tmpPos).path+"/tempFolderID");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String tempFolderID = reader.readLine();
                    if (!(tempFolderID.equals(""))){
                        cmd[2]="rm -R " + tempFolderID +" ; rm " + listProcRunning.get(tmpPos).path+"/tempFolderID"; 
                        Runtime.getRuntime().exec(cmd);
                    }
                }    
                }    
            catch (IOException e){//Catch exception if any
                System.out.println("No temporary folder\n");
                } 
            //listProcRunning.get(tmpPos).pr.destroy();
           // listProcRunning.get(tmpPos).pr.waitFor();
            //}
            //catch (InterruptedException e) {
           // System.err.println("Error in Killing the process:" + e);
            //}
            /*Field field;
            try{
            final Runtime runtime = Runtime.getRuntime();
            field=listProcRunning.get(tmpPos).pr.getClass().getField("pid");
            field.setAccessible(true);
            final Object processID = field.get(listProcRunning.get(tmpPos).pr);
            final int pid = (Integer) processID;
            runtime.exec("sudo kill -9 " + pid);
            }
            catch (IOException e) {
                   System.err.println("Error in Killing the process:" + e);
                } catch (SecurityException e) {
                    System.err.println("Error in Killing the process:" + e);
                } catch (NoSuchFieldException e) {
                    System.err.println("Error in Killing the process:" + e);
                } catch (IllegalArgumentException e) {
                     System.err.println("Error in Killing the process:" + e);
                } catch (IllegalAccessException e) {
                     System.err.println("Error in Killing the process:" + e);
                }
            */
            listProcRunning.remove(tmpPos);
            tmpPos=-1;
        }
        
        for(int i=0;i<listProcWaiting.size();i++){
            if (listProcWaiting.get(i).pos>pos){
                listProcWaiting.get(i).pos--;    
            }
            else
                if (listProcWaiting.get(i).pos==pos){
                    tmpPos=i;
                } 
        }
         if (tmpPos!=-1){
            listProcWaiting.remove(tmpPos);
            tmpPos=-1;
        }
        //System.out.println("Pos1:"+pos+"\n");
        GL.setListProcStatuSelection(-1);
        listModel.remove(pos);
        //System.out.println("Pos2:"+pos+"\n");
        OutputFrame.setVisible(false);
        OutputText.setText("");
        GL.setAvoidProcListValueChanged(-1);
        ProcList.clearSelection();
        GL.setAvoidProcListValueChanged(0);
    }//GEN-LAST:event_RemoveOutputActionPerformed

    private void iCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCloseButtonActionPerformed
        iDockerRadioButton.setSelected(true);
        iGenomeFolderText.setText("");
        iThreadText.setText(Integer.toString(GS.getDefaultThread()));
        iGenomeURLText.setText("");
        iGTFURLText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
//        AnalysisTree.clearSelection();
    }//GEN-LAST:event_iCloseButtonActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (iGenomeFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (iGenomeURLText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome URL ","Error: Genome URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
             if (iGTFURLText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an GTF URL ","Error: GTF URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (iThreadText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(iThreadText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                iThreadText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadText.requestFocusInWindow();
            return;
        }
        
        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execIndexingSTAR.sh "};
            if (iSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                    cmd[2]+= "group=\\\"docker\\\"";
            }
            cmd[2]+= " genome.folder=\\\""+iGenomeFolderText.getText()+"\\\" ensembl.urlgenome=\\\""+iGenomeURLText.getText()+"\\\" ensembl.urlgtf=\\\""+iGTFURLText.getText()+"\\\"";
            cmd[2]+= " threads="+iThreadText.getText()+ " "+iGenomeFolderText.getText() + " >& "+iGenomeFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println("Runing PID:"+ getPidOfProcess(pr)+"\n");
                
                ElProcRunning tmp= new ElProcRunning("Genome indexing STAR-RSEM ", iGenomeFolderText.getText(),pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
                }         
                else{
                    ElProcWaiting tmp= new ElProcWaiting("Genome indexing STAR-RSEM ",iGenomeFolderText.getText(),cmd,listModel.getSize());
                    listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    GL.setAvoidProcListValueChanged(0);
                    }  
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer()); 
                GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            }
                    
        
        JOptionPane.showMessageDialog(this, "Genome indexing STAR-RSEM task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void iResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResetButtonActionPerformed
        iDockerRadioButton.setSelected(true);
        iGenomeFolderText.setText("");
        iThreadText.setText(Integer.toString(GS.getDefaultThread()));
        iGenomeURLText.setText("");
        iGTFURLText.setText("");
              
    }//GEN-LAST:event_iResetButtonActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
    saveAsMenuItemActionPerformed(evt);      
    }//GEN-LAST:event_jButton14ActionPerformed

    private void iGenomeFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iGenomeFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iGenomeFolderTextActionPerformed

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton15ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(iGenomeFolderText.getText().equals(""))){
            File file =new File(iGenomeFolderText.getText());
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
            iGenomeFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton15ActionPerformed

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton16ActionPerformed
    iGenomeFolderText.setText("");
    }//GEN-LAST:event_jToggleButton16ActionPerformed

    private void iDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDockerRadioButtonActionPerformed

    private void iThreadTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iThreadTextFocusLost
        if (iThreadText.getText().isEmpty())
            return;
        iThreadText.setForeground(Color.black);
        try
        {
            Integer x = Integer.valueOf(iThreadText.getText());
            if (x<=0){
                iThreadText.setForeground(Color.red);
            }
        }
        catch (NumberFormatException e) {
            iThreadText.setForeground(Color.red);
            iThreadText.setText("");
            //return;
        }    // TODO add your handling code here:
    }//GEN-LAST:event_iThreadTextFocusLost

    private void iThreadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iThreadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iThreadTextActionPerformed

    private void vBAMnoLRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBAMnoLRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vBAMnoLRadioButtonActionPerformed

    private void vBAMyesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vBAMyesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vBAMyesRadioButtonActionPerformed

    private void vOrganismTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vOrganismTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vOrganismTextActionPerformed

    private void vOrganismTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vOrganismTextFocusLost
        // TODO add your handling code here:
        if (vOrganismText.getText().isEmpty())
            return;
        vOrganismText.setForeground(Color.black);
        if (!org.matcher(vOrganismText.getText()).matches()){
            vOrganismText.setForeground(Color.red);
        }
    }//GEN-LAST:event_vOrganismTextFocusLost

    private void vSReverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vSReverseRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vSReverseRadioButtonActionPerformed

    private void vSForwardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vSForwardRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vSForwardRadioButtonActionPerformed

    private void vSNoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vSNoneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vSNoneRadioButtonActionPerformed

    private void vMinLengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vMinLengthTextActionPerformed
        if (vMinLengthText.getText().isEmpty())
            return;
        vMinLengthText.setForeground(Color.black);
        try
        {
            Integer x = Integer.valueOf(vMinLengthText.getText());
            if (x<=0){
                vMinLengthText.setForeground(Color.red);
            }
        }
        catch (NumberFormatException e) {
            vMinLengthText.setForeground(Color.red);
            vMinLengthText.setText("");
            //return;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_vMinLengthTextActionPerformed

    private void vMinLengthTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vMinLengthTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vMinLengthTextFocusLost

    private void vPeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vPeRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vPeRadioButtonActionPerformed

    private void vAdapter3TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vAdapter3TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vAdapter3TextActionPerformed

    private void vAdapter3TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vAdapter3TextFocusLost
        // TODO add your handling code here:
        if (vAdapter3Text.getText().isEmpty())
            return;
        vAdapter3Text.setForeground(Color.black);
        if (!adapter.matcher(vAdapter3Text.getText()).matches()){
            vAdapter3Text.setForeground(Color.red);
        }
    }//GEN-LAST:event_vAdapter3TextFocusLost

    private void vAdapter5TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vAdapter5TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vAdapter5TextActionPerformed

    private void vAdapter5TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vAdapter5TextFocusLost
        // TODO add your handling code here:
        if (vAdapter5Text.getText().isEmpty())
            return;
        vAdapter5Text.setForeground(Color.black);
        if (!adapter.matcher(vAdapter5Text.getText()).matches()){
            vAdapter5Text.setForeground(Color.red);
        }
    }//GEN-LAST:event_vAdapter5TextFocusLost

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
         configurationMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void ConfCancellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfCancellActionPerformed
        ConfigurationFrame.setVisible(false);
    }//GEN-LAST:event_ConfCancellActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
       
        GS.setMaxSizelistProcRunning(Integer.valueOf(ParallelTextField.getText()));
        GS.setDefaultAdapter5(Adapter5TextField.getText());
        GS.setDefaultAdapter3(Adapter3TextField.getText());
        GS.setDefaultThread(Integer.valueOf(ThreadTextField.getText()));
        GS.save();
        ConfigurationFrame.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        ParallelTextField.setText(Integer.toString(GS.getMaxSizelistProcRunning()));
        ThreadTextField.setText(Integer.toString(GS.getDefaultThread()));
        Adapter5TextField.setText(GS.getDefaultAdapter5());
        Adapter3TextField.setText(GS.getDefaultAdapter3());
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       removeDockerContainer(evt);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       configurationMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       removeDockerContainer(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    
        formWindowClosing(null);    
        setVisible(false);
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        saveAsMenuItemActionPerformed(evt);   
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
     openMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void FAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FAddFileActionPerformed
    final JFileChooser fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    fc.setMultiSelectionEnabled(true);
    String curDir = getPreferences().get("open-dir", null);
        fc.setCurrentDirectory(curDir!=null ? new File(curDir) : null);
       
    if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
        File[] files = fc.getSelectedFiles();
        for (File file : files) {
            DefaultTableModel model = (DefaultTableModel) FPKMFileTable.getModel();
            model.addRow(new Object[]{file.toString(), "Cov.1", "Batch1"});
        }
        }
    curDir = fc.getCurrentDirectory().getAbsolutePath();
    getPreferences().put("open-dir", curDir);
    }//GEN-LAST:event_FAddFileActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    
    while( FPKMFileTable.getSelectedRowCount()!=0){
        int selectedRow = FPKMFileTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) FPKMFileTable.getModel();
        if(selectedRow != -1) {
            model.removeRow(selectedRow);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void FSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FSaveButtonActionPerformed
    saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_FSaveButtonActionPerformed

    private void FCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCloseButtonActionPerformed

        FtypesComboBox.setSelectedIndex(0);        
        while( FPKMFileTable.getRowCount()!=0){
            DefaultTableModel model = (DefaultTableModel) FPKMFileTable.getModel();
            model.removeRow(0);
        }
        FOutputFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
     //   AnalysisTree.clearSelection();
    }//GEN-LAST:event_FCloseButtonActionPerformed

    private void FResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FResetButtonActionPerformed
        FtypesComboBox.setSelectedIndex(0);        
        while( FPKMFileTable.getRowCount()!=0){
            DefaultTableModel model = (DefaultTableModel) FPKMFileTable.getModel();
            model.removeRow(0);
        }
        FOutputFolderText.setText("");
    }//GEN-LAST:event_FResetButtonActionPerformed

    private void FExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FExecuteButtonActionPerformed
        if (FPKMFileTable.getRowCount()<2){
            JOptionPane.showMessageDialog(this, "You have to specified at least two folders","Error: Data  folders",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (FOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output folders","Error: Output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execFPKM.sh "};
            cmd[2]+="sample.folders=c\\(\\\"";
            cmd[2]+=FPKMFileTable.getModel().getValueAt(0,0).toString();
            for (int i = 1; i <  FPKMFileTable.getRowCount(); i++){
                  cmd[2]+="\\\",\\\""+FPKMFileTable.getModel().getValueAt(i,0).toString();
            }
            cmd[2]+= "\\\"\\)";
            cmd[2]+=" covariates=c\\(\\\"";
            cmd[2]+=FPKMFileTable.getModel().getValueAt(0,1).toString();
            for (int i = 1; i <  FPKMFileTable.getRowCount(); i++){
                  cmd[2]+="\\\",\\\""+FPKMFileTable.getModel().getValueAt(i,1).toString();
            }
            cmd[2]+= "\\\"\\)";

            cmd[2]+=" batch=c\\(\\\"";
            cmd[2]+=FPKMFileTable.getModel().getValueAt(0,2).toString();
            for (int i = 1; i <  FPKMFileTable.getRowCount(); i++){
                  cmd[2]+="\\\",\\\""+FPKMFileTable.getModel().getValueAt(i,2).toString();
            }
            cmd[2]+= "\\\"\\)";            
            
            cmd[2]+="  bio.type=\\\""+FtypesComboBox.getSelectedItem().toString()+"\\\"";
            cmd[2]+="  output.prefix=\\\""+FOutputFolderText.getText() + "\\\" " + FOutputFolderText.getText() +">& "+FOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println("Running PID:"+ getPidOfProcess(pr)+"\n");
                //System.out.println(cmd[2]+"\n");
                ElProcRunning tmp= new ElProcRunning("From samples to experiment ", FOutputFolderText.getText(),pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
                }         
                else{
                    ElProcWaiting tmp= new ElProcWaiting("From samples to experiment ",FOutputFolderText.getText(),cmd,listModel.getSize());
                    listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    GL.setAvoidProcListValueChanged(0);
                    }  
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer()); 
                GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            }
                    
        
        JOptionPane.showMessageDialog(this, "From samples to experiment task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
        
        
        
    }//GEN-LAST:event_FExecuteButtonActionPerformed

    private void FcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FcancelActionPerformed
    FOutputFolderText.setText("");
    }//GEN-LAST:event_FcancelActionPerformed

    private void FbrowesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FbrowesActionPerformed
    JFileChooser openDir = new JFileChooser();
     if (!(FOutputFolderText.getText().equals(""))){
            File file =new File(FOutputFolderText.getText());
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
            FOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());                                          
    }//GEN-LAST:event_FbrowesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       getPreferences().put("4SeqGUI_HorizontalSplitPanel", Integer.toString(HorizontalSplitPanel.getDividerLocation()));
       getPreferences().put("4SeqGUI_VerticalSplitPanel", Integer.toString(VerticalSplitPanel.getDividerLocation()));
       getPreferences().put("4SeqGUI_WindowWidth", Integer.toString(getSize().width));
       getPreferences().put("4SeqGUI_WindowHeight",Integer.toString(getSize().height));
       getPreferences().put("4SeqGUI_GroupCellWidth",Integer.toString(FPKMFileTable.getColumnModel().getColumn(1).getWidth()));
       getPreferences().put("4SeqGUI_BatchCellWidth",Integer.toString(FPKMFileTable.getColumnModel().getColumn(2).getWidth())); 
       getPreferences().put("4SeqGUI_FolderCellWidth",Integer.toString(FPKMFileTable.getColumnModel().getColumn(0).getWidth())); 
       getPreferences().put("4SeqGUI_Group1CellWidth",Integer.toString(CCountHeaderTable.getColumnModel().getColumn(1).getWidth()));
       getPreferences().put("4SeqGUI_Batch1CellWidth",Integer.toString(CCountHeaderTable.getColumnModel().getColumn(2).getWidth())); 
       getPreferences().put("4SeqGUI_HeaderCellWidth",Integer.toString(CCountHeaderTable.getColumnModel().getColumn(0).getWidth())); 
    }//GEN-LAST:event_formWindowClosing

    private void vCloseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton2ActionPerformed

        //RESET FIELDS
        pLegendComboBox.setSelectedIndex(1);
        pCovYesRadioButton.setSelected(true);
        pFPKMRadioButton.setSelected(true);
        pFPKMfileText.setText("");
        pComponent1Text.setText("");
        pComponent2Text.setText("");
        pOutputFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
       // AnalysisTree.clearSelection();    
        

    }//GEN-LAST:event_vCloseButton2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      
        //Field check

        if (pFPKMfileText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: input file",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (pOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output  folder","Error: output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try
        {
            Integer x = Integer.valueOf(pComponent1Text.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Component 1 number",JOptionPane.ERROR_MESSAGE);
                pComponent1Text.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of component 1.","Error: Component 1 number",JOptionPane.ERROR_MESSAGE);
            pComponent1Text.requestFocusInWindow();
            return;
        }
        
        try
        {
            Integer x = Integer.valueOf(pComponent2Text.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Component 2 number",JOptionPane.ERROR_MESSAGE);
                pComponent2Text.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of component 2.","Error: Component 2 number",JOptionPane.ERROR_MESSAGE);
            pComponent2Text.requestFocusInWindow();
            return;
        }
        
        Runtime rt = Runtime.getRuntime();
        //execute code
            
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execPCA.sh "};
            cmd[2]+= " experiment.table=\\\""+ pFPKMfileText.getText() +"\\\"";
            if (pFPKMRadioButton.isSelected())
                cmd[2]+= " type=\\\"FPKM\\\"";
            else
                 if (pTPMRadioButton.isSelected())
                     cmd[2]+= " type=\\\"TPM\\\"";
                 else
                     cmd[2]+= " type=\\\"counts\\\"";
            if (pCovYesRadioButton.isSelected())
                cmd[2]+= " covariatesInNames=\\\"TRUE\\\"";
            else
                cmd[2]+= " covariatesInNames=\\\"FALSE\\\"";
            cmd[2]+= " principal.components=c\\("+pComponent1Text.getText()+","+pComponent2Text.getText()+"\\)";
            cmd[2]+= " legend.position=\\\""+pLegendComboBox.getSelectedItem().toString()+"\\\"";
            cmd[2]+= " output.folder=\\\""+ pOutputFolderText.getText() +"\\\"";
           // File outputFolder= new File(pFPKMfileText.getText());
           // String output= outputFolder.getAbsolutePath().substring(0,outputFolder.getAbsolutePath().lastIndexOf(File.separator));
            cmd[2]+=" "+ pOutputFolderText.getText()+" >& "+pOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println(cmd[2]);                            
                ElProcRunning tmp= new ElProcRunning("PCA ", pOutputFolderText.getText() ,pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
            }             
            else{
                 ElProcWaiting tmp= new ElProcWaiting("PCA ", pOutputFolderText.getText(),cmd,listModel.getSize());
                 listProcWaiting.add(tmp);
                 java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                 ImageIcon image2 = new ImageIcon(imgURL);
                 GL.setAvoidProcListValueChanged(-1);
                 listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                 GL.setAvoidProcListValueChanged(0);
                }
            GL.setAvoidProcListValueChanged(-1);
            ProcList.setModel(listModel);
            ProcList.setCellRenderer(new ListEntryCellRenderer());
            GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(this, "A PCA task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
          //RESET FIELDS
        pLegendComboBox.setSelectedIndex(1);
        pCovYesRadioButton.setSelected(true);
        pFPKMRadioButton.setSelected(true);
        pFPKMfileText.setText("");
        pComponent1Text.setText("");
        pComponent2Text.setText("");
        pOutputFolderText.setText("");
        //RESET FIELDS
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void pFPKMfileTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFPKMfileTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pFPKMfileTextActionPerformed

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton12ActionPerformed
    JFileChooser openDir = new JFileChooser();
        if (!(pFPKMfileText.getText().equals(""))){
            File file =new File(pOutputFolderText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
        }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            pFPKMfileText.setText(String.valueOf(f));
            //UPDATE TO REMOVE OUTPUT FOLDER            
            pOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton12ActionPerformed

    private void fCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButtonActionPerformed
    pFPKMfileText.setText("");
    //UPDATE TO REMOVE OUTPUT FOLDER    
    pOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButtonActionPerformed

    private void pComponent1TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pComponent1TextFocusLost
        if (pComponent1Text.getText().isEmpty())
            return;
        pComponent1Text.setForeground(Color.black);
        try
        {
            Integer x = Integer.valueOf(pComponent1Text.getText());
            if (x<=0){
                pComponent1Text.setForeground(Color.red);
            }
        }
        catch (NumberFormatException e) {
            pComponent1Text.setForeground(Color.red);
            //pComponent1Text.setText("");
            //return;
        }        
    }//GEN-LAST:event_pComponent1TextFocusLost

    private void pComponent1TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pComponent1TextActionPerformed
         
    }//GEN-LAST:event_pComponent1TextActionPerformed

    private void pComponent2TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pComponent2TextFocusLost
        
        if (pComponent2Text.getText().isEmpty())
            return;
        pComponent2Text.setForeground(Color.black);
        try
        {
            Integer x = Integer.valueOf(pComponent2Text.getText());
            if (x<=0){
                pComponent2Text.setForeground(Color.red);
            }
        }
        catch (NumberFormatException e) {
            pComponent2Text.setForeground(Color.red);
            //pComponent2Text.setText("");
            //return;
        }  
    }//GEN-LAST:event_pComponent2TextFocusLost

    private void pComponent2TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pComponent2TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pComponent2TextActionPerformed

    private void pCountsRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCountsRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pCountsRadioButtonActionPerformed

    private void pFPKMRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFPKMRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pFPKMRadioButtonActionPerformed

    private void pTPMRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pTPMRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pTPMRadioButtonActionPerformed

    private void pCovYesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCovYesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pCovYesRadioButtonActionPerformed

    private void pCovNoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pCovNoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pCovNoRadioButtonActionPerformed

    private void pOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pOutputFolderTextActionPerformed

    private void jToggleButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton13ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(pOutputFolderText.getText().equals(""))){
            File file =new File(pOutputFolderText.getText());
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
            pOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton13ActionPerformed

    private void fCancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton1ActionPerformed
    pOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButton1ActionPerformed

    private void vCloseButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton3ActionPerformed
        //RESET FIELDS
        dCovComboBox.setSelectedIndex(0);
        dIsoformRadioButton.setSelected(true);
        dFPKMfileText.setText("");
        dLog2fcText.setText("");
        dFDRText.setText("");
        dOutputFolderText.setText("");
        dBatchesTrue.setSelected(true);
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
     //   AnalysisTree.clearSelection();    
    }//GEN-LAST:event_vCloseButton3ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
//Field check

        if (dFPKMfileText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: input file",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (dOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output  folder","Error: output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try
        {
            Float x = Float.valueOf(dLog2fcText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Log2fc threashold",JOptionPane.ERROR_MESSAGE);
                dLog2fcText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified  a value for Log2fc threashold.","Error: Log2fc threashold",JOptionPane.ERROR_MESSAGE);
            dLog2fcText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(dFDRText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
                dFDRText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
            dFDRText.requestFocusInWindow();
            return;
        }
        
        Runtime rt = Runtime.getRuntime();
        //execute code
            
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execDES.sh "};
            cmd[2]+= " experiment.table=\\\""+ dFPKMfileText.getText() +"\\\"";
            if (dIsoformRadioButton.isSelected())
                cmd[2]+= " type=\\\"isoform\\\"";
            else
                if (dGeneRadioButton.isSelected())
                    cmd[2]+= " type=\\\"gene\\\"";
                else
                    cmd[2]+= " type=\\\"mirna\\\"";
            cmd[2]+= " log2fc="+dLog2fcText.getText()+" fdr="+dFDRText.getText();
            cmd[2]+= " ref.covar=\\\""+dCovComboBox.getSelectedItem().toString()+"\\\"";
            cmd[2]+= " output.folder=\\\""+ dOutputFolderText.getText() +"\\\"";
            if (dBatchesTrue.isSelected())
                cmd[2]+= " batch=\\\"TRUE\\\"";
            else
                cmd[2]+= " batch=\\\"FALSE\\\"";
            cmd[2]+=" "+ dOutputFolderText.getText()+" >& "+dOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println(cmd[2]);                            
                ElProcRunning tmp= new ElProcRunning("DESeq2 analysis ", dOutputFolderText.getText() ,pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
            }             
            else{
                 ElProcWaiting tmp= new ElProcWaiting("DESeq2 analysis ", dOutputFolderText.getText(),cmd,listModel.getSize());
                 listProcWaiting.add(tmp);
                 java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                 ImageIcon image2 = new ImageIcon(imgURL);
                 GL.setAvoidProcListValueChanged(-1);
                 listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                 GL.setAvoidProcListValueChanged(0);
                }
            GL.setAvoidProcListValueChanged(-1);
            ProcList.setModel(listModel);
            ProcList.setCellRenderer(new ListEntryCellRenderer());
            GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(this, "DESeq2 analysis task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);      
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        dCovComboBox.setSelectedIndex(0);
        dIsoformRadioButton.setSelected(true);
        dFPKMfileText.setText("");
        dLog2fcText.setText("");
        dFDRText.setText("");
        dOutputFolderText.setText("");
        dBatchesTrue.setSelected(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void dFPKMfileTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dFPKMfileTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dFPKMfileTextActionPerformed

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton14ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(dFPKMfileText.getText().equals(""))){
            File file =new File(dOutputFolderText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
        }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            dFPKMfileText.setText(String.valueOf(f));
            dOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton14ActionPerformed

    private void fCancelButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton2ActionPerformed
        dFPKMfileText.setText("");
        dOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButton2ActionPerformed

    private void dOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dOutputFolderTextActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton17ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(dOutputFolderText.getText().equals(""))){
            File file =new File(dOutputFolderText.getText());
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
            dOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
         
    }//GEN-LAST:event_jToggleButton17ActionPerformed

    private void fCancelButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton3ActionPerformed
       dOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButton3ActionPerformed

    private void dLog2fcTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dLog2fcTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dLog2fcTextFocusLost

    private void dLog2fcTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dLog2fcTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dLog2fcTextActionPerformed

    private void dFDRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dFDRTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dFDRTextFocusLost

    private void dFDRTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dFDRTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dFDRTextActionPerformed

    private void dGeneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dGeneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dGeneRadioButtonActionPerformed

    private void dCovComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dCovComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dCovComboBoxActionPerformed

    private void iCloseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCloseButton1ActionPerformed
    iBFalseRadioButton.setSelected(true);
    i1000GenomeText.setText("");
    idbSPNText.setText("");
    iGenomeFolderBText.setText("");
    iDockerRadioButton.setSelected(true);
    iGenomeURLBText.setText("");
    iThreadBText.setText(Integer.toString(GS.getDefaultThread()));
    CardLayout card = (CardLayout)MainPanel.getLayout();
    card.show(MainPanel, "Empty");
    CurrentLayout="Empty";
   // AnalysisTree.clearSelection();
    }//GEN-LAST:event_iCloseButton1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (iGenomeFolderBText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome folder","Error: Genome  folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (iGenomeURLBText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome URL ","Error: Genome URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
             if (iBTrueRadioButton.isSelected()&&(i1000GenomeText.getText().isEmpty())){
            JOptionPane.showMessageDialog(this, "You have to specified the 1000 Genome file  ","Error: 1000 Genome file",JOptionPane.ERROR_MESSAGE);
            return;
        }else
            if (iBTrueRadioButton.isSelected()&&(idbSPNText.getText().isEmpty())){
            JOptionPane.showMessageDialog(this, "You have to specified the dbSPN file  ","Error: dbSPN file",JOptionPane.ERROR_MESSAGE);
            return;
        }     
        else
        if (iThreadBText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(iThreadBText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                iThreadBText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadBText.requestFocusInWindow();
            return;
        }
        
        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execIndexingBWA.sh "};
            if (iSudoBRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                    cmd[2]+= "group=\\\"docker\\\"";
            }
            cmd[2]+= " genome.folder=\\\""+iGenomeFolderBText.getText()+"\\\" uscs.urlgenome=\\\""+iGenomeURLBText.getText() +"\\\"";
            if (iBTrueRadioButton.isSelected()){
                    cmd[2]+= " gatk=TRUE";
                    cmd[2]+= " dbsnp.file=\\\""+idbSPNText.getText()+"\\\"  g1000.file=\\\""+i1000GenomeText.getText()+"\\\"";
            }
            else{
                    cmd[2]+= " gatk=FALSE";
                    cmd[2]+= " dbsnp.file=NULL  g1000.file=NULL";
            }        
            
                    
            cmd[2]+= " threads="+iThreadBText.getText()+ " "+iGenomeFolderBText.getText() + " >& "+iGenomeFolderBText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println("Runing PID:"+ getPidOfProcess(pr)+"\n");
                System.out.println(cmd[2]);
                ElProcRunning tmp= new ElProcRunning("Genome indexing BWA ", iGenomeFolderBText.getText(),pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
                }         
                else{
                    ElProcWaiting tmp= new ElProcWaiting("Genome indexing BWA ",iGenomeFolderBText.getText(),cmd,listModel.getSize());
                    listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    GL.setAvoidProcListValueChanged(0);
                    }  
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer()); 
                GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            }
                    
        
        JOptionPane.showMessageDialog(this, "Genome indexing BWA task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
   
    }//GEN-LAST:event_jButton21ActionPerformed

    private void iResetButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResetButton1ActionPerformed
    iBFalseRadioButton.setSelected(true);
    i1000GenomeText.setText("");
    idbSPNText.setText("");
    iGenomeFolderBText.setText("");
    iDockerRadioButton.setSelected(true);
    iGenomeURLBText.setText("");
    iThreadBText.setText(Integer.toString(GS.getDefaultThread()));
    }//GEN-LAST:event_iResetButton1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void iGenomeFolderBTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iGenomeFolderBTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iGenomeFolderBTextActionPerformed

    private void jToggleButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ActionPerformed
    JFileChooser openDir = new JFileChooser();
     if (!(iGenomeFolderBText.getText().equals(""))){
            File file =new File(iGenomeFolderBText.getText());
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
            iGenomeFolderBText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());   
    }//GEN-LAST:event_jToggleButton18ActionPerformed

    private void jToggleButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton19ActionPerformed
        iGenomeFolderBText.setText("");
    }//GEN-LAST:event_jToggleButton19ActionPerformed

    private void iDockerBRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDockerBRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDockerBRadioButtonActionPerformed

    private void iThreadBTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iThreadBTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_iThreadBTextFocusLost

    private void iThreadBTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iThreadBTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iThreadBTextActionPerformed

    private void iBTrueRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBTrueRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iBTrueRadioButtonActionPerformed

    private void iBFalseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iBFalseRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iBFalseRadioButtonActionPerformed

    private void iBFalseRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_iBFalseRadioButtonStateChanged
       if (iBFalseRadioButton.isSelected())
       {
        i1000BrowseButton.setEnabled(false);
        i1000CancelButton.setEnabled(false);
        idbSPNBrowseButton.setEnabled(false);
        idbSPNCancelButton.setEnabled(false);
       }
       else
       {
        i1000BrowseButton.setEnabled(true);
        i1000CancelButton.setEnabled(true);
        idbSPNBrowseButton.setEnabled(true);
        idbSPNCancelButton.setEnabled(true);
       }   
    }//GEN-LAST:event_iBFalseRadioButtonStateChanged

    private void i1000BrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i1000BrowseButtonActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(i1000GenomeText.getText().equals(""))){
            File file =new File(i1000GenomeText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            i1000GenomeText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
    }//GEN-LAST:event_i1000BrowseButtonActionPerformed

    private void i1000CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_i1000CancelButtonActionPerformed
     i1000GenomeText.setText("");
    }//GEN-LAST:event_i1000CancelButtonActionPerformed

    private void idbSPNBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbSPNBrowseButtonActionPerformed
           JFileChooser openDir = new JFileChooser();
     if (!(idbSPNText.getText().equals(""))){
            File file =new File(idbSPNText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            idbSPNText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
    }//GEN-LAST:event_idbSPNBrowseButtonActionPerformed

    private void idbSPNCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idbSPNCancelButtonActionPerformed
    idbSPNText.setText("");
    }//GEN-LAST:event_idbSPNCancelButtonActionPerformed

    private void vCloseButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton4ActionPerformed
        //RESET FIELDS
        MDockerRadioButton.setSelected(true);
        MOutputFolderText.setText("");
        MScratchFolderText.setText("");
        MGenomeFolderText.setText("");
        MTestFolderText.setText("");
        MMockFolderText.setText("");
        MThreadText.setText(Integer.toString(GS.getDefaultThread()));
        MAdapter5Text.setText(GS.getDefaultAdapter3());
        MAdapter3Text.setText(GS.getDefaultAdapter3());
        MMinLengthText.setText("30");
        MOrgComboBox.setSelectedIndex(0);
        MRnoRadioButton.setSelected(true);
        MMaxUpstreamText.setText("10000");
        MTTSText.setText("0");
        MMinmfoldText.setText("10");
        MMpvalueText.setText("1e-5");
        MMaxmfoldText.setText("30");
        MSWindowsText.setText("200");
        MSgsizeText.setText("200");
        MSFDRText.setText("0.1");
        MReadLengthTextField.setText("50");
        MToolComboBox.setSelectedIndex(0);
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
//        AnalysisTree.clearSelection();    
    }//GEN-LAST:event_vCloseButton4ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
      //Field check
        if (MReadLengthTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified a read length value","Error: read length  value",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (MToolComboBox.getSelectedIndex()==0){
            if (MMinmfoldText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a MACS min. mfold  value","Error:  MACS min. mfold  value",JOptionPane.ERROR_MESSAGE);
            return;
            }
            else
            if (MMpvalueText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a MACS p-value","Error: MACS p-velue",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            if (MMaxmfoldText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a MACS max. mfold value","Error: MACS max. mfold value",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        }
        else
        {
            if (MSWindowsText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a  SICER window  value","Error:  SICER window  value",JOptionPane.ERROR_MESSAGE);
            return;
            }
            else
            if (MSgsizeText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a SICER g-size value","Error: SICER g-size  value",JOptionPane.ERROR_MESSAGE);
                return;
            }
            else
            if (MSFDRText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a SICER FDR value","Error: SICER FDR value",JOptionPane.ERROR_MESSAGE);
                return;
            }   
            
        }    
        if (MTTSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an MTTS   value","Error: MTTS   value",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (MMaxUpstreamText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified a maximum upstream  value","Error: Max upstream   value",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        
        if (MOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output folder","Error: Output  folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (MScratchFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified a scratch folder","Error:  scratch folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (MGenomeFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified a genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (MMockFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Mock folder","Error: Mock folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else    
        if (MThreadText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            MThreadText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(MThreadText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                MThreadText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            MThreadText.requestFocusInWindow();
            return;
        }

        if ((!MAdapter5Text.getText().isEmpty())&&(!adapter.matcher(MAdapter5Text.getText()).matches())){
            JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 5'",JOptionPane.ERROR_MESSAGE);
            MAdapter5Text.requestFocusInWindow();
        }
        else{
            if ((!MAdapter3Text.getText().isEmpty())&&(!adapter.matcher(MAdapter3Text.getText()).matches())){
                JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 3'",JOptionPane.ERROR_MESSAGE);
                MAdapter3Text.requestFocusInWindow();
            }
            else{
                if (MMinLengthText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "You have to specified a value for the minimum lenght.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    MMinLengthText.requestFocusInWindow();
                    return;
                }
                try{
                    Integer x = Integer.valueOf(MMinLengthText.getText());
                    if (x<0){
                        JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                        MMinLengthText.requestFocusInWindow();
                        return;
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    MMinLengthText.requestFocusInWindow();
                    return;
                }
                
                if (!org.matcher(vOrganismText.getText()).matches()){
                    JOptionPane.showMessageDialog(this, "The specified organism is not valid.","Error: Organism",JOptionPane.ERROR_MESSAGE);
                    vOrganismText.requestFocusInWindow();
                }
                else{
                    //execute code                 
                    Runtime rt = Runtime.getRuntime();
                    try{
                        String[] cmd = {"/bin/bash","-c","   bash ./execMACS-SICER.sh "}; 
                        
                        if (MSudoRadioButton.isSelected()){
                            cmd[2]+= "group=\\\"sudo\\\"";
                        }
                        else{
                            cmd[2]+= "group=\\\"docker\\\"";
                        }
                        cmd[2]+= " output.folder=\\\""+MOutputFolderText.getText()+"\\\" scratch.folder=\\\""+MScratchFolderText.getText()+"\\\" adapter5=\\\""+MAdapter5Text.getText()+"\\\" adapter3=\\\""+MAdapter3Text.getText()+"\\\"";
                        cmd[2]+= " mock.folder=\\\""+MMockFolderText.getText()+"\\\" test.folder=\\\""+MTestFolderText.getText()+"\\\"";
                        cmd[2]+= " seq.type=\\\"se\\\" threads="+vThreadText.getText()+" min.length="+MMinLengthText.getText()+" genome.folder=\\\""+MGenomeFolderText.getText()+"\\\"";
                        cmd[2]+= " mock.id=\\\"igg\\\"  test.id=\\\"tf\\\" genome=\\\""+MOrgComboBox.getSelectedItem().toString()+"\\\" read.size="+MReadLengthTextField.getText();
                        cmd[2]+= " tool=\\\""+MToolComboBox.getSelectedItem().toString()+"\\\" macs.min.mfold="+MMinmfoldText.getText()+" macs.max.mfold="+MMaxmfoldText.getText()+" macs.pval=\\\""+MMpvalueText.getText()+"\\\"";
                        cmd[2]+= " sicer.wsize="+MSWindowsText.getText()+" sicer.gsize="+MSgsizeText.getText()+" sicer.fdr="+MSFDRText.getText()+ " tss.distance="+MTTSText.getText()+" max.upstream.distance="+MMaxUpstreamText.getText();
                        if (MRyesRadioButton.isSelected())
                             cmd[2]+= " remove.duplicates=\\\"Y\\\"";
                        else
                             cmd[2]+= " remove.duplicates=\\\"N\\\"";
                        cmd[2]+=" "+MOutputFolderText.getText() +" >& "+MOutputFolderText.getText()+"/outputExecution ";
                        
                        //ProcessStatus.setText(pr.toString());
                        if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                            Process pr = rt.exec(cmd); 
                            //System.out.println("lanciato "+pr);                            
                            ElProcRunning tmp= new ElProcRunning("MACS & SICER analysis", MOutputFolderText.getText(),pr,listModel.getSize());
                            listProcRunning.add(tmp);
                            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                            ImageIcon image2 = new ImageIcon(imgURL);
                            GL.setAvoidProcListValueChanged(-1);
                            listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                            GL.setAvoidProcListValueChanged(0);
                                    //addElement("RNAseq counting workflow (data input: "+vFastQFolderText.getText()+")            [Runnig]");
                            if(listProcRunning.size()==1){
                                t=new Timer();
                                t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                            }
                        }
                         
                        else{
                            ElProcWaiting tmp= new ElProcWaiting("MACS & SICER analysis",MOutputFolderText.getText(),cmd,listModel.getSize());
                            listProcWaiting.add(tmp);
                            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                            ImageIcon image2 = new ImageIcon(imgURL);
                            GL.setAvoidProcListValueChanged(-1);
                            listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                            GL.setAvoidProcListValueChanged(0);

                        }
                        GL.setAvoidProcListValueChanged(-1);
                        ProcList.setModel(listModel);
                        ProcList.setCellRenderer(new ListEntryCellRenderer());
                        GL.setAvoidProcListValueChanged(0);
                        } 
                    catch(IOException e) {
                        JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                        System.out.println(e.toString());
                        }
                    JOptionPane.showMessageDialog(this, "MACS & SICER analysis task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
                    }
                  //execute code
            }
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        MDockerRadioButton.setSelected(true);
        MOutputFolderText.setText("");
        MScratchFolderText.setText("");
        MGenomeFolderText.setText("");
        MTestFolderText.setText("");
        MMockFolderText.setText("");
        MThreadText.setText(Integer.toString(GS.getDefaultThread()));
        MAdapter5Text.setText(GS.getDefaultAdapter5());
        MAdapter3Text.setText(GS.getDefaultAdapter3());
        MMinLengthText.setText("30");
        MOrgComboBox.setSelectedIndex(0);
        MRnoRadioButton.setSelected(true);
        MMaxUpstreamText.setText("10000");
        MTTSText.setText("0");
        MMinmfoldText.setText("10");
        MMpvalueText.setText("1e-5");
        MMaxmfoldText.setText("30");
        MSWindowsText.setText("200");
        MSgsizeText.setText("200");
        MSFDRText.setText("0.1");
        MReadLengthTextField.setText("50");
        MToolComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
       saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void MOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MOutputFolderTextActionPerformed

    private void jToggleButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton20ActionPerformed
     JFileChooser openDir = new JFileChooser();
        if (!(MOutputFolderText.getText().equals(""))){
            File file =new File(MOutputFolderText.getText());
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
            MOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton20ActionPerformed

    private void jToggleButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton21ActionPerformed
    MOutputFolderText.setText("");
    }//GEN-LAST:event_jToggleButton21ActionPerformed

    private void jToggleButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton22ActionPerformed
     JFileChooser openDir = new JFileChooser();
        if (!(MScratchFolderText.getText().equals(""))){
            File file =new File(MScratchFolderText.getText());
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
            MScratchFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton22ActionPerformed

    private void jToggleButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton23ActionPerformed
    MScratchFolderText.setText("");
    }//GEN-LAST:event_jToggleButton23ActionPerformed

    private void jToggleButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton24ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(MMockFolderText.getText().equals(""))){
            File file =new File(MMockFolderText.getText());
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
            MMockFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton24ActionPerformed

    private void jToggleButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton25ActionPerformed
       MMockFolderText.setText("");
    }//GEN-LAST:event_jToggleButton25ActionPerformed

    private void MDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MDockerRadioButtonActionPerformed

    private void MThreadTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MThreadTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MThreadTextFocusLost

    private void MThreadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MThreadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MThreadTextActionPerformed

    private void jToggleButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton26ActionPerformed
     JFileChooser openDir = new JFileChooser();
        if (!(MGenomeFolderText.getText().equals(""))){
            File file =new File(MGenomeFolderText.getText());
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
            MGenomeFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton26ActionPerformed

    private void jToggleButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton27ActionPerformed
    MGenomeFolderText.setText("");
    }//GEN-LAST:event_jToggleButton27ActionPerformed

    private void jToggleButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton28ActionPerformed
         JFileChooser openDir = new JFileChooser();
        if (!(MTestFolderText.getText().equals(""))){
            File file =new File(MTestFolderText.getText());
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
            MTestFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton28ActionPerformed

    private void jToggleButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton29ActionPerformed
    MTestFolderText.setText("");
    }//GEN-LAST:event_jToggleButton29ActionPerformed

    private void MAdapter5TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MAdapter5TextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MAdapter5TextFocusLost

    private void MAdapter5TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAdapter5TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MAdapter5TextActionPerformed

    private void MAdapter3TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MAdapter3TextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MAdapter3TextFocusLost

    private void MAdapter3TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAdapter3TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MAdapter3TextActionPerformed

    private void MTTSTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MTTSTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MTTSTextFocusLost

    private void MTTSTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTTSTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MTTSTextActionPerformed

    private void MRyesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRyesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MRyesRadioButtonActionPerformed

    private void MRnoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRnoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MRnoRadioButtonActionPerformed

    private void MMinLengthTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MMinLengthTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MMinLengthTextFocusLost

    private void MMinLengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMinLengthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMinLengthTextActionPerformed

    private void MMaxUpstreamTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MMaxUpstreamTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MMaxUpstreamTextFocusLost

    private void MMaxUpstreamTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMaxUpstreamTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMaxUpstreamTextActionPerformed

    private void MToolComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MToolComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MToolComboBoxActionPerformed

    private void MMaxmfoldTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MMaxmfoldTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MMaxmfoldTextFocusLost

    private void MMaxmfoldTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMaxmfoldTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMaxmfoldTextActionPerformed

    private void MMinmfoldTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MMinmfoldTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MMinmfoldTextFocusLost

    private void MMinmfoldTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMinmfoldTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMinmfoldTextActionPerformed

    private void MMpvalueTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MMpvalueTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MMpvalueTextFocusLost

    private void MMpvalueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MMpvalueTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MMpvalueTextActionPerformed

    private void MSgsizeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MSgsizeTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MSgsizeTextFocusLost

    private void MSgsizeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSgsizeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSgsizeTextActionPerformed

    private void MSWindowsTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MSWindowsTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MSWindowsTextFocusLost

    private void MSWindowsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSWindowsTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSWindowsTextActionPerformed

    private void MSFDRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MSFDRTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_MSFDRTextFocusLost

    private void MSFDRTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MSFDRTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MSFDRTextActionPerformed

    private void MToolComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MToolComboBoxItemStateChanged
    if ((MToolComboBox.getSelectedItem().toString()).equals("macs")){
        CardLayout cardTool = (CardLayout)Tool.getLayout();
        cardTool.show(Tool, "MACS");
    }
    else{
        CardLayout cardTool = (CardLayout)Tool.getLayout();
        cardTool.show(Tool, "SICER");
    }
    }//GEN-LAST:event_MToolComboBoxItemStateChanged

    private void SSbrowesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSbrowesActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(SSOutputFolderText.getText().equals(""))){
            File file =new File(SSOutputFolderText.getText());
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
            SSOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());              
    }//GEN-LAST:event_SSbrowesActionPerformed

    private void SScancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SScancelActionPerformed
        SSOutputFolderText.setText("");
    }//GEN-LAST:event_SScancelActionPerformed

    private void SSExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSExecuteButtonActionPerformed
      if (SSCountTableText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: input file",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (SSOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output  folder","Error: output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try
        {
            Float x = Float.valueOf(SSPowerText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error:  Statistical power",JOptionPane.ERROR_MESSAGE);
                SSPowerText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified  a value for Log2fc threashold.","Error: Statistical power",JOptionPane.ERROR_MESSAGE);
            SSPowerText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(SSFDRtext.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
                SSFDRtext.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
            SSFDRtext.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(SSGeneText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: #gene for dispertion",JOptionPane.ERROR_MESSAGE);
                SSGeneText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: #gene for dispertion",JOptionPane.ERROR_MESSAGE);
            SSGeneText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(SSlog2Text.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Log2 fold change",JOptionPane.ERROR_MESSAGE);
                SSlog2Text.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: Log2 fold change",JOptionPane.ERROR_MESSAGE);
            SSlog2Text.requestFocusInWindow();
            return;
        }
        
          
        Runtime rt = Runtime.getRuntime();
        //execute code
            
        try{
            String[] cmd = {"/bin/bash","-c","   bash ./execSampleSize.sh "};
  
            cmd[2]+= " filename=\\\""+ SSCountTableText.getText() +"\\\"";
            cmd[2]+= " power="+ SSPowerText.getText();
            cmd[2]+= " FDR="+ SSFDRtext.getText();
            cmd[2]+= " genes4dispersion="+ SSGeneText.getText();
            cmd[2]+= " log2fold.change="+ SSlog2Text.getText();
            cmd[2]+= " output.folder=\\\""+ SSOutputFolderText.getText() +"\\\"";
            cmd[2]+=" "+ SSOutputFolderText.getText()+" >& "+SSOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println(cmd[2]);                            
                ElProcRunning tmp= new ElProcRunning("Sample Size Estimator ", SSOutputFolderText.getText() ,pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
            }             
            else{
                 ElProcWaiting tmp= new ElProcWaiting("Sample Size Estimator  ", SSOutputFolderText.getText(),cmd,listModel.getSize());
                 listProcWaiting.add(tmp);
                 java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                 ImageIcon image2 = new ImageIcon(imgURL);
                 GL.setAvoidProcListValueChanged(-1);
                 listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                 GL.setAvoidProcListValueChanged(0);
                }
            GL.setAvoidProcListValueChanged(-1);
            ProcList.setModel(listModel);
            ProcList.setCellRenderer(new ListEntryCellRenderer());
            GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(this, "Sample Size Estimator task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);  
    }//GEN-LAST:event_SSExecuteButtonActionPerformed

    private void SSSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSSaveButtonActionPerformed
    saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_SSSaveButtonActionPerformed

    private void SSResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSResetButtonActionPerformed
       SSCountTableText.setText("");
       SSFDRtext.setText("0.1");
       SSGeneText.setText("200");
       SSOutputFolderText.setText("");
       SSPowerText.setText("0.8");
       SSlog2Text.setText("1"); 
    }//GEN-LAST:event_SSResetButtonActionPerformed

    private void SSCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCloseButtonActionPerformed
       SSCountTableText.setText("");
       SSFDRtext.setText("0.1");
       SSGeneText.setText("200");
       SSOutputFolderText.setText("");
       SSPowerText.setText("0.8");
       SSlog2Text.setText("1"); 
       CardLayout card = (CardLayout)MainPanel.getLayout();
       card.show(MainPanel, "Empty");
       CurrentLayout="Empty";
      // AnalysisTree.clearSelection();      
    }//GEN-LAST:event_SSCloseButtonActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
    JFileChooser openDir = new JFileChooser();
     if (!(SSCountTableText.getText().equals(""))){
            File file =new File(SSOutputFolderText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            SSCountTableText.setText(String.valueOf(f));
            SSOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());           
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
       SSCountTableText.setText("");
       SSOutputFolderText.setText("");
    }//GEN-LAST:event_jButton28ActionPerformed

    private void SSlog2TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSlog2TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSlog2TextActionPerformed

    private void SSGeneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSGeneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSGeneTextActionPerformed

    private void SSCountTableTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSCountTableTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SSCountTableTextActionPerformed

    private void SSbrowes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSbrowes1ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(EPOutputFolderText.getText().equals(""))){
            File file =new File(EPOutputFolderText.getText());
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
            EPOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());          
    }//GEN-LAST:event_SSbrowes1ActionPerformed

    private void SScancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SScancel1ActionPerformed
    EPOutputFolderText.setText("");
    }//GEN-LAST:event_SScancel1ActionPerformed

    private void EPCountTableTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPCountTableTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EPCountTableTextActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(EPCountTableText.getText().equals(""))){
            File file =new File(EPOutputFolderText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            EPCountTableText.setText(String.valueOf(f));
            EPOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());             
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
      EPCountTableText.setText("");
       EPOutputFolderText.setText("");
    }//GEN-LAST:event_jButton30ActionPerformed

    private void EPExecuteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPExecuteButton1ActionPerformed
        if (EPCountTableText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: input file",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (EPOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output  folder","Error: output folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        try
        {
            Float x = Float.valueOf(EPSampleText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error:  number of samples used in each group",JOptionPane.ERROR_MESSAGE);
                EPSampleText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified  a value for Log2fc threashold.","Error: number of samples used in each group",JOptionPane.ERROR_MESSAGE);
            EPSampleText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(EPFDRtext.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
                EPFDRtext.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: FDR threashold",JOptionPane.ERROR_MESSAGE);
            EPFDRtext.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(EPGeneText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: #gene for dispertion",JOptionPane.ERROR_MESSAGE);
                EPGeneText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: #gene for dispertion",JOptionPane.ERROR_MESSAGE);
            EPGeneText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(EPlog2Text.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Log2 fold change",JOptionPane.ERROR_MESSAGE);
                EPlog2Text.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a value for the FDR threashold","Error: Log2 fold change",JOptionPane.ERROR_MESSAGE);
            EPlog2Text.requestFocusInWindow();
            return;
        }
        
          
        Runtime rt = Runtime.getRuntime();
        //execute code
            
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execExperimentPower.sh "};
  
            cmd[2]+= " filename=\\\""+ EPCountTableText.getText() +"\\\"";
            cmd[2]+= " replicatesXgroup="+ EPSampleText.getText();
            cmd[2]+= " FDR="+ EPFDRtext.getText();
            cmd[2]+= " genes4dispersion="+ EPGeneText.getText();
            cmd[2]+= " log2fold.change="+ EPlog2Text.getText();
            cmd[2]+= " output.folder=\\\""+ EPOutputFolderText.getText() +"\\\"";
            cmd[2]+=" "+ EPOutputFolderText.getText()+" >& "+EPOutputFolderText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println(cmd[2]);                            
                ElProcRunning tmp= new ElProcRunning("Experiment Stat. Power ", EPOutputFolderText.getText() ,pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
            }             
            else{
                 ElProcWaiting tmp= new ElProcWaiting("Experiment Stat. Power  ", EPOutputFolderText.getText(),cmd,listModel.getSize());
                 listProcWaiting.add(tmp);
                 java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                 ImageIcon image2 = new ImageIcon(imgURL);
                 GL.setAvoidProcListValueChanged(-1);
                 listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                 GL.setAvoidProcListValueChanged(0);
                }
            GL.setAvoidProcListValueChanged(-1);
            ProcList.setModel(listModel);
            ProcList.setCellRenderer(new ListEntryCellRenderer());
            GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(this, "Experiment Stat. Power task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);  

    }//GEN-LAST:event_EPExecuteButton1ActionPerformed

    private void EPSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPSaveButtonActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_EPSaveButtonActionPerformed

    private void EPResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPResetButtonActionPerformed
       EPCountTableText.setText("");
       EPFDRtext.setText("0.1");
       EPGeneText.setText("200");
       EPOutputFolderText.setText("");
       EPSampleText.setText("3");
       EPlog2Text.setText("1"); 
    }//GEN-LAST:event_EPResetButtonActionPerformed

    private void EPCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPCloseButtonActionPerformed
       EPCountTableText.setText("");
       EPFDRtext.setText("0.1");
       EPGeneText.setText("200");
       EPOutputFolderText.setText("");
       EPSampleText.setText("3");
       EPlog2Text.setText("1"); 
       CardLayout card = (CardLayout)MainPanel.getLayout();
       card.show(MainPanel, "Empty");
       CurrentLayout="Empty";
     //  AnalysisTree.clearSelection();      
    }//GEN-LAST:event_EPCloseButtonActionPerformed

    private void EPGeneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPGeneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EPGeneTextActionPerformed

    private void EPlog2TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EPlog2TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EPlog2TextActionPerformed

    private void DBatchesFalseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBatchesFalseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DBatchesFalseActionPerformed

    private void CinbrowesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CinbrowesActionPerformed
        JFileChooser openDir = new JFileChooser();
        //reseting header table
        while( CCountHeaderTable.getRowCount()!=0){
            DefaultTableModel model = (DefaultTableModel) CCountHeaderTable.getModel();
            model.removeRow(0);
        }
        //reseting header table
        if (!(CCovInputFileText.getText().equals(""))){
            File file =new File(CCovInputFileText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
        }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            try{
                FileReader fw = new FileReader(f.getAbsoluteFile());
                try (BufferedReader br = new BufferedReader(fw)) {
                    String header = br.readLine();
                    DefaultTableModel model = (DefaultTableModel) CCountHeaderTable.getModel();
                    for (String retval:header.split("\\t")){
                        if (!(retval.equals("\"\"")))
                            model.addRow(new Object[]{retval,"Cov.1","Batch1"}); 
                    }
                    CCovInputFileText.setText(String.valueOf(f));
                }
            }
            catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error opening file","Error",JOptionPane.ERROR_MESSAGE);
            }
           catch (NumberFormatException e) {
                  JOptionPane.showMessageDialog(this, "Error reading file","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
       
        
    }//GEN-LAST:event_CinbrowesActionPerformed

    private void CincancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CincancelActionPerformed
    CCovInputFileText.setText("");  
    while( CCountHeaderTable.getRowCount()!=0){
        DefaultTableModel model = (DefaultTableModel) CCountHeaderTable.getModel();
        model.removeRow(0);
        }
    }//GEN-LAST:event_CincancelActionPerformed

    private void FExecuteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FExecuteButton1ActionPerformed
  
        
    if (CCovInputFileText.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "You have to specified the count file","Error: Input file",JOptionPane.ERROR_MESSAGE);
        return;
    }    
    if (COutputFolderText.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "You have to specified an output folders","Error: Output folder",JOptionPane.ERROR_MESSAGE);
        return;
    }
    File f =new File(CCovInputFileText.getText());
   
    //execute code
    Runtime rt = Runtime.getRuntime();
    try{
        String[] cmd = {"/bin/bash","-c","  bash ./execmiRNACovar.sh "};
        cmd[2]+="experiment.folder=\\\""+ f.getAbsolutePath()+"\\\"";
        cmd[2]+=" covariates=c\\(\\\"";
        cmd[2]+=CCountHeaderTable.getModel().getValueAt(0,1).toString();
        for (int i = 1; i <  CCountHeaderTable.getRowCount(); i++){
            cmd[2]+="\\\",\\\""+CCountHeaderTable.getModel().getValueAt(i,1).toString();
        }
        cmd[2]+= "\\\"\\)";
        cmd[2]+=" batch=c\\(\\\"";
        cmd[2]+=CCountHeaderTable.getModel().getValueAt(0,2).toString();
        for (int i = 1; i <  CCountHeaderTable.getRowCount(); i++){
            cmd[2]+="\\\",\\\""+CCountHeaderTable.getModel().getValueAt(i,2).toString();
        }
        cmd[2]+= "\\\"\\)";            
        cmd[2]+="  output.folder=\\\""+COutputFolderText.getText() + "\\\" " + COutputFolderText.getText() +">& "+COutputFolderText.getText()+"/outputExecution ";
        //ProcessStatus.setText(pr.toString());
        if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
            Process pr = rt.exec(cmd); 
            System.out.println("Running PID:"+ getPidOfProcess(pr)+"\n");
            //System.out.println(cmd[2]+"\n");
            ElProcRunning tmp= new ElProcRunning("Adding covariates and batch information ", COutputFolderText.getText(),pr,listModel.getSize());
            listProcRunning.add(tmp);
            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
            ImageIcon image2 = new ImageIcon(imgURL);
            GL.setAvoidProcListValueChanged(-1);
            listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
            GL.setAvoidProcListValueChanged(0);
            if(listProcRunning.size()==1){
                t=new Timer();
                t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
            }
        }         
        else{
            ElProcWaiting tmp= new ElProcWaiting("Adding covariates and batch information",COutputFolderText.getText(),cmd,listModel.getSize());
            listProcWaiting.add(tmp);
            java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
            ImageIcon image2 = new ImageIcon(imgURL);
            GL.setAvoidProcListValueChanged(-1);
            listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
            GL.setAvoidProcListValueChanged(0);
            }  
        GL.setAvoidProcListValueChanged(-1);
        ProcList.setModel(listModel);
        ProcList.setCellRenderer(new ListEntryCellRenderer()); 
        GL.setAvoidProcListValueChanged(0);
        } 
    catch(IOException e) {
        JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
        System.out.println(e.toString());
        }
                   
    JOptionPane.showMessageDialog(this, "Adding covariates and batch information task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
               
    }//GEN-LAST:event_FExecuteButton1ActionPerformed

    private void FSaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FSaveButton1ActionPerformed
        saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_FSaveButton1ActionPerformed

    private void CResetButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CResetButton1ActionPerformed
    CCovInputFileText.setText("");
    COutputFolderText.setText("");
    while( CCountHeaderTable.getRowCount()!=0){
        DefaultTableModel model = (DefaultTableModel) CCountHeaderTable.getModel();
        model.removeRow(0);
        }
    }//GEN-LAST:event_CResetButton1ActionPerformed

    private void CCloseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CCloseButton1ActionPerformed
    CCovInputFileText.setText("");
    COutputFolderText.setText("");
    while( CCountHeaderTable.getRowCount()!=0){
        DefaultTableModel model = (DefaultTableModel)  CCountHeaderTable.getModel();
        model.removeRow(0);
        }
     //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
       // AnalysisTree.clearSelection();
    }//GEN-LAST:event_CCloseButton1ActionPerformed

    private void CoutbrowesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoutbrowesActionPerformed
    JFileChooser openDir = new JFileChooser();
        if (!(COutputFolderText.getText().equals(""))){
            File file =new File(COutputFolderText.getText());
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
            COutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_CoutbrowesActionPerformed

    private void CoutcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CoutcancelActionPerformed
    COutputFolderText.setText("");
    }//GEN-LAST:event_CoutcancelActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
     DownloadMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        DownloadFrame.setVisible(false);
        Downloadtext.setText("");
        getPreferences().put("4SeqGUI_WindowDownloadWidth", Integer.toString(DownloadFrame.getWidth()));
        getPreferences().put("4SeqGUI_WindowDownloadHeight", Integer.toString(DownloadFrame.getHeight())); 
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
      Downloadtext.setText("");
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(Downloadtext.getText().equals(""))){
            File file =new File(Downloadtext.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
        else
        {
            String curDir = getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
        }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            Downloadtext.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
        DownloadFrame.toFront();
        DownloadFrame.requestFocus();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c","  bash ./execDownloadImage.sh "};
            
            if (!(Downloadtext.getText().equals(""))){
                 cmd[2]+= "containers.file=\\\""+Downloadtext.getText()+"\\\"";
            }
            else{
                 cmd[2]+= "containers.file=NULL";
            }
            cmd[2]+= " "+System.getProperty("user.dir") +" >& "+System.getProperty("user.dir")+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println("Runing PID:"+ getPidOfProcess(pr)+"\n");
                
                ElProcRunning tmp= new ElProcRunning("Download Docker images ", System.getProperty("user.dir"),pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
                }         
                else{
                    ElProcWaiting tmp= new ElProcWaiting("Download Docker images ", System.getProperty("user.dir"),cmd,listModel.getSize());
                    listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    GL.setAvoidProcListValueChanged(0);
                    }  
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer()); 
                GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            }
                    
        
        JOptionPane.showMessageDialog(this, "Download Docker image task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
        DownloadFrame.setVisible(false);
        Downloadtext.setText("");
        getPreferences().put("4SeqGUI_WindowDownloadWidth", Integer.toString(DownloadFrame.getWidth()));
        getPreferences().put("4SeqGUI_WindowDownloadHeight", Integer.toString(DownloadFrame.getHeight())); 
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        openAbout4SeqGUI(evt);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        openAbout4SeqGUI(evt);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
       About4SeqGUIFrame.setVisible(false);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void OutputFrameWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_OutputFrameWindowClosing
      outputTime.cancel();
    }//GEN-LAST:event_OutputFrameWindowClosing

    private void iCloseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iCloseButton2ActionPerformed
    iDockerRadioSButton.setSelected(true);
    iGenomeFolderSText.setText("");
    iThreadSText.setText(Integer.toString(GS.getDefaultThread()));
    iGenomeURLSText.setText("");
    iGTFURLSText.setText("");
    iKmerSText.setText("31");
    //RESET FIELDS
    CardLayout card = (CardLayout)MainPanel.getLayout();
    card.show(MainPanel, "Empty");
    CurrentLayout="Empty";
//    AnalysisTree.clearSelection();
    }//GEN-LAST:event_iCloseButton2ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
     if (iGenomeFolderSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (iGenomeURLSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an Genome URL ","Error: Genome URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
             if (iGTFURLSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an GTF URL ","Error: GTF URL",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        if (iThreadSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadSText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(iThreadSText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                iThreadSText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            iThreadSText.requestFocusInWindow();
            return;
        }
        
        if (iKmerSText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the k-mer size that will be used.","Error: k-mer  number",JOptionPane.ERROR_MESSAGE);
            iKmerSText.requestFocusInWindow();
            return;
        }
        try
        {
            Integer x = Integer.valueOf(iKmerSText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: k-mer  number",JOptionPane.ERROR_MESSAGE);
                iKmerSText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the k-mer size that will be used.","Error: k-mer number",JOptionPane.ERROR_MESSAGE);
            iKmerSText.requestFocusInWindow();
            return;
        }
        
        
        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execIndexingSalmon.sh "};
            if (iSudoRadioSButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
            }
            else{
                    cmd[2]+= "group=\\\"docker\\\"";
            }
            cmd[2]+= " index.folder=\\\""+iGenomeFolderSText.getText()+"\\\" ensembl.urltranscriptome=\\\""+iGenomeURLSText.getText()+"\\\" ensembl.urlgtf=\\\""+iGTFURLSText.getText()+"\\\"";
            cmd[2]+= " threads="+iThreadSText.getText()+ " k="+iKmerSText.getText()+" "+iGenomeFolderSText.getText() + " >& "+iGenomeFolderSText.getText()+"/outputExecution ";
            //ProcessStatus.setText(pr.toString());
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println("Runing PID:"+ getPidOfProcess(pr)+"\n");
                
                ElProcRunning tmp= new ElProcRunning("Pseudo-reference building Salmon ", iGenomeFolderSText.getText(),pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
                }         
                else{
                    ElProcWaiting tmp= new ElProcWaiting("Pseudo-reference building Salmon  ",iGenomeFolderSText.getText(),cmd,listModel.getSize());
                    listProcWaiting.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                    GL.setAvoidProcListValueChanged(0);
                    }  
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer()); 
                GL.setAvoidProcListValueChanged(0);
            } 
        catch(IOException e) {
            JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            }
                    
        
        JOptionPane.showMessageDialog(this, "Transcriptome pseudo-reference Salmon task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButton37ActionPerformed

    private void iResetButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iResetButton2ActionPerformed
     iDockerRadioSButton.setSelected(true);
     iGenomeFolderSText.setText("");
     iThreadSText.setText(Integer.toString(GS.getDefaultThread()));
     iGenomeURLSText.setText("");
     iGTFURLSText.setText("");
     iKmerSText.setText("31");
    }//GEN-LAST:event_iResetButton2ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
    saveAsMenuItemActionPerformed(evt);    
    }//GEN-LAST:event_jButton38ActionPerformed

    private void iGenomeFolderSTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iGenomeFolderSTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iGenomeFolderSTextActionPerformed

    private void jToggleButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton30ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(iGenomeFolderSText.getText().equals(""))){
            File file =new File(iGenomeFolderSText.getText());
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
            iGenomeFolderSText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton30ActionPerformed

    private void jToggleButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton31ActionPerformed
    iGenomeFolderSText.setText("");
    }//GEN-LAST:event_jToggleButton31ActionPerformed

    private void iDockerRadioSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iDockerRadioSButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iDockerRadioSButtonActionPerformed

    private void iThreadSTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iThreadSTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_iThreadSTextFocusLost

    private void iThreadSTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iThreadSTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iThreadSTextActionPerformed

    private void vCloseButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton5ActionPerformed
    //RESET FIELDS
        cDockerRadioButton.setSelected(true);
        cFastQFolderText.setText("");
        cOutputFolderText.setText("");
        cThreadText.setText(Integer.toString(GS.getDefaultThread()));
        cAdapter5Text.setText(GS.getDefaultAdapter5());
        cAdapter3Text.setText(GS.getDefaultAdapter3());
        cSeRadioButton.setSelected(true);
        cMinLengthText.setText("40");
        cGenomeFolderText.setText("");
        cSNoneRadioButton.setSelected(true);
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
        //GL.setAvoidProcListValueChanged(-1);
//        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton5ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
    
        //Field check

        if (cFastQFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an input folder","Error: FastQ  folder",JOptionPane.ERROR_MESSAGE);
            //vFastQFolderText.requestFocusInWindow();
            return;
        }
        else
        if (cOutputFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an output folder","Error: Output folder",JOptionPane.ERROR_MESSAGE);
            //vOutputFolderText.requestFocusInWindow();
            return;
        }
        else
        if (cGenomeFolderText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified an genome folder","Error: Genome folder",JOptionPane.ERROR_MESSAGE);
            //vGenomeFolderText.requestFocusInWindow();
            return;
        }
        else
        if (cThreadText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            cThreadText.requestFocusInWindow();
            return;
        }
    try
        {
            Integer x = Integer.valueOf(cThreadText.getText());
            if (x<=0){
                JOptionPane.showMessageDialog(this, "You have to specified a value greater than 0.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
                cThreadText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number of threads that will be used.","Error: Thread  number",JOptionPane.ERROR_MESSAGE);
            cThreadText.requestFocusInWindow();
            return;
        }

        if ((!cAdapter5Text.getText().isEmpty())&&(!adapter.matcher(cAdapter5Text.getText()).matches())){
            JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 5'",JOptionPane.ERROR_MESSAGE);
            cAdapter5Text.requestFocusInWindow();
        }
        else{
            if ((!cAdapter3Text.getText().isEmpty())&&(!adapter.matcher(cAdapter3Text.getText()).matches())){
                JOptionPane.showMessageDialog(this, "The specified Adapter format is not valid.","Error: Adapter 3'",JOptionPane.ERROR_MESSAGE);
                cAdapter3Text.requestFocusInWindow();
            }
            else{
                if (cMinLengthText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "You have to specified a value for the minimum lenght.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    cMinLengthText.requestFocusInWindow();
                    return;
                }
                try{
                    Integer x = Integer.valueOf(cMinLengthText.getText());
                    if (x<0){
                        JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                        cMinLengthText.requestFocusInWindow();
                        return;
                    }
                }
                catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "You have to specified a positive value.","Error: Minimum read length",JOptionPane.ERROR_MESSAGE);
                    cMinLengthText.requestFocusInWindow();
                    return;
                }
                
                    //execute code
                 Runtime rt = Runtime.getRuntime();
                 try{
                    String[] cmd = {"/bin/bash","-c"," bash ./execSalmon.sh "};
     
                    if (cSudoRadioButton.isSelected()){
                        cmd[2]+= "group=\\\"sudo\\\"";
                    }
                    else{
                        cmd[2]+= "group=\\\"docker\\\"";
                    }
                    cmd[2]+= " fastq.folder=\\\""+cFastQFolderText.getText()+"\\\" scratch.folder=\\\""+cOutputFolderText.getText()+"\\\" adapter5=\\\""+cAdapter5Text.getText()+"\\\" adapter3=\\\""+cAdapter3Text.getText()+"\\\"";
                    
                    if (cPeRadioButton.isSelected()){
                        cmd[2]+= " seq.type=\\\"pe\\\"";
                    }
                    else{
                        cmd[2]+= " seq.type=\\\"se\\\"";
                    }
                    cmd[2]+= " threads="+cThreadText.getText()+" min.length="+cMinLengthText.getText()+"  index.folder=\\\""+cGenomeFolderText.getText()+"\\\"";
                       
                    if (cSNoneRadioButton.isSelected())
                        cmd[2]+= " strandness=\\\"none\\\"";
                    else
                        if (cSForwardRadioButton.isSelected())
                            cmd[2]+= " strandness=\\\"forward\\\"";
                        else
                            cmd[2]+= " strandness=\\\"reverse\\\"";

                    cmd[2]+=" "+cFastQFolderText.getText() +" >& "+cFastQFolderText.getText()+"/outputExecution ";
                        
                    //ProcessStatus.setText(pr.toString());
                    if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                        Process pr = rt.exec(cmd);                             
                        ElProcRunning tmp= new ElProcRunning("Transcripts and genes counting with Salmon ", cFastQFolderText.getText(),pr,listModel.getSize());
                        listProcRunning.add(tmp);
                        java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                        ImageIcon image2 = new ImageIcon(imgURL);
                        GL.setAvoidProcListValueChanged(-1);
                        listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                        GL.setAvoidProcListValueChanged(0);
                        //addElement("RNAseq counting workflow (data input: "+vFastQFolderText.getText()+")            [Runnig]");
                        if(listProcRunning.size()==1){
                            t=new Timer();
                            t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                        }
                    }     
                    else{
                        ElProcWaiting tmp= new ElProcWaiting("Transcripts and genes counting with Salmon ",cFastQFolderText.getText(),cmd,listModel.getSize());
                        listProcWaiting.add(tmp);
                        java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                        ImageIcon image2 = new ImageIcon(imgURL);
                        GL.setAvoidProcListValueChanged(-1);
                        listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                        GL.setAvoidProcListValueChanged(0);
                        }
                    GL.setAvoidProcListValueChanged(-1);
                    ProcList.setModel(listModel);
                    ProcList.setCellRenderer(new ListEntryCellRenderer());
                    GL.setAvoidProcListValueChanged(0);
                    } 
                catch(IOException e) {
                    JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.toString());
                }
                JOptionPane.showMessageDialog(this, "Transcripts and genes counting Salmon task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE);
            }
            //execute code
        }
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        cDockerRadioButton.setSelected(true);
        cFastQFolderText.setText("");
        cOutputFolderText.setText("");
        cThreadText.setText(Integer.toString(GS.getDefaultThread()));
        cAdapter5Text.setText(GS.getDefaultAdapter5());
        cAdapter3Text.setText(GS.getDefaultAdapter3());
        cSeRadioButton.setSelected(true);
        cMinLengthText.setText("40");
        cGenomeFolderText.setText("");
        cSNoneRadioButton.setSelected(true);
        cPeRadioButton.setSelected(true);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
    saveAsMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void cFastQFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cFastQFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cFastQFolderTextActionPerformed

    private void jToggleButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton32ActionPerformed
      JFileChooser openDir = new JFileChooser();
        if (!(cFastQFolderText.getText().equals(""))){
            File file =new File(cFastQFolderText.getText());
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
            cFastQFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton32ActionPerformed

    private void jToggleButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton33ActionPerformed
    cFastQFolderText.setText("");
    }//GEN-LAST:event_jToggleButton33ActionPerformed

    private void jToggleButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton34ActionPerformed
    JFileChooser openDir = new JFileChooser();
        if (!(cOutputFolderText.getText().equals(""))){
            File file =new File(cOutputFolderText.getText());
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
            cOutputFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton34ActionPerformed

    private void jToggleButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton35ActionPerformed
     cOutputFolderText.setText("");  
    }//GEN-LAST:event_jToggleButton35ActionPerformed

    private void jToggleButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton36ActionPerformed
     JFileChooser openDir = new JFileChooser();
        if (!(cGenomeFolderText.getText().equals(""))){
            File file =new File(cGenomeFolderText.getText());
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
            cGenomeFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath()); 
    }//GEN-LAST:event_jToggleButton36ActionPerformed

    private void jToggleButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton37ActionPerformed
     cGenomeFolderText.setText("");   
    }//GEN-LAST:event_jToggleButton37ActionPerformed

    private void cDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cDockerRadioButtonActionPerformed

    private void cThreadTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cThreadTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cThreadTextFocusLost

    private void cThreadTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cThreadTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cThreadTextActionPerformed

    private void cAdapter5TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cAdapter5TextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cAdapter5TextFocusLost

    private void cAdapter5TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAdapter5TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cAdapter5TextActionPerformed

    private void cAdapter3TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cAdapter3TextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cAdapter3TextFocusLost

    private void cAdapter3TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAdapter3TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cAdapter3TextActionPerformed

    private void cPeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cPeRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cPeRadioButtonActionPerformed

    private void cMinLengthTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cMinLengthTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cMinLengthTextFocusLost

    private void cMinLengthTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMinLengthTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cMinLengthTextActionPerformed

    private void cSNoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSNoneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cSNoneRadioButtonActionPerformed

    private void cSForwardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSForwardRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cSForwardRadioButtonActionPerformed

    private void cSReverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSReverseRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cSReverseRadioButtonActionPerformed

    private void vCloseButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton6ActionPerformed
        
        //RESET FIELDS
        fisoformRadioButton.setSelected(true);
        fFPKMfileText.setText("");
        fOutputFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
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
            if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                Process pr = rt.exec(cmd); 
                System.out.println(cmd[2]);                            
                ElProcRunning tmp= new ElProcRunning("Count Filter ", fOutputFolderText.getText() ,pr,listModel.getSize());
                listProcRunning.add(tmp);
                java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                GL.setAvoidProcListValueChanged(-1);
                listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                GL.setAvoidProcListValueChanged(0);
                if(listProcRunning.size()==1){
                    t=new Timer();
                    t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                    }
            }             
            else{
                 ElProcWaiting tmp= new ElProcWaiting("Count filter ", fOutputFolderText.getText(),cmd,listModel.getSize());
                 listProcWaiting.add(tmp);
                 java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                 ImageIcon image2 = new ImageIcon(imgURL);
                 GL.setAvoidProcListValueChanged(-1);
                 listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                 GL.setAvoidProcListValueChanged(0);
                }
            GL.setAvoidProcListValueChanged(-1);
            ProcList.setModel(listModel);
            ProcList.setCellRenderer(new ListEntryCellRenderer());
            GL.setAvoidProcListValueChanged(0);
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
        saveAsMenuItemActionPerformed(evt);
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

    private void fmirnaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fmirnaRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fmirnaRadioButtonActionPerformed

    private void fisoformRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fisoformRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fisoformRadioButtonActionPerformed

    private void fgeneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fgeneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fgeneRadioButtonActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DownloadMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void MReadLengthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MReadLengthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MReadLengthTextFieldActionPerformed

    private void DlogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DlogButtonActionPerformed
    JFileChooser openFile = new JFileChooser();
    ListEntry tmpListEntry =  listModel.get(GL.getListProcStatuSelection());
    openFile.setCurrentDirectory(new File(tmpListEntry.path));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("LOG FILES", "log", "text");
    openFile.setFileFilter(filter);
    if (openFile.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
        
        try{
            File file = openFile.getSelectedFile();
            String text;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String strLine;
                text = "";
                //Read File Line By Line
                while ((strLine = reader.readLine()) != null)   {
                    text+="\n"+strLine;
                }
            }
            OutputText.setText(text);
                }
                catch (IOException e){//Catch exception if any
                    System.err.println("Error: " + e.getMessage());
                    //JOptionPane.showMessageDialog(this, "Error reading R output file","Error",JOptionPane.ERROR_MESSAGE);
                }
        }
    
    }//GEN-LAST:event_DlogButtonActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
    
        if (QdataFolderText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "You have to specified an input folder","Error: Data  folder",JOptionPane.ERROR_MESSAGE);
            //mFastQFolderText.requestFocusInWindow();
        }
        else
        {
         //execute code
            Runtime rt = Runtime.getRuntime();
            try{
                String[] cmd = {"/bin/bash","-c"," bash ./execmultiqc.sh "};
                if (QSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
                }
                else{
                    cmd[2]+= "group=\\\"docker\\\"";
                }
                cmd[2]+= " data.folder=\\\""+QdataFolderText.getText()+"\\\"";

                cmd[2]+=" "+QdataFolderText.getText() +" >& "+QdataFolderText.getText()+"/outputExecution ";

                if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                    Process pr = rt.exec(cmd);                          
                    ElProcRunning tmp= new ElProcRunning("MultiQC  ", QdataFolderText.getText(),pr,listModel.getSize());
                    listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                    GL.setAvoidProcListValueChanged(0);
                    if(listProcRunning.size()==1){
                        t=new Timer();
                        t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                        }
                }    
                else{
                     ElProcWaiting tmp= new ElProcWaiting("MultiQC", QdataFolderText.getText(),cmd,listModel.getSize());
                     listProcWaiting.add(tmp);
                     java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                     ImageIcon image2 = new ImageIcon(imgURL);
                     GL.setAvoidProcListValueChanged(-1);
                     listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                     GL.setAvoidProcListValueChanged(0);
                    }
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer());
                GL.setAvoidProcListValueChanged(0);
                }   
            catch(IOException e) {
                JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
                }
            JOptionPane.showMessageDialog(this, "MultiQC task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE); 
        }
                  //execute code      
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        QDockerRadioButton.setSelected(true);
        QdataFolderText.setText("");
    }//GEN-LAST:event_jButton47ActionPerformed

    private void vCloseButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton7ActionPerformed
        QDockerRadioButton.setSelected(true);
        QdataFolderText.setText("");
        //RESET FIELDS
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";
//        AnalysisTree.clearSelection();
    }//GEN-LAST:event_vCloseButton7ActionPerformed

    private void QdataFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QdataFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QdataFolderTextActionPerformed

    private void jToggleButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton40ActionPerformed
        JFileChooser openDir = new JFileChooser();
        if (!(QdataFolderText.getText().equals(""))){
            File file =new File(QdataFolderText.getText());
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
            QdataFolderText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton40ActionPerformed

    private void jToggleButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton41ActionPerformed
      QdataFolderText.setText("");
    }//GEN-LAST:event_jToggleButton41ActionPerformed

    private void QSudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QSudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QSudoRadioButtonActionPerformed

    private void QDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QDockerRadioButtonActionPerformed

    private void MultiQCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiQCButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "multiqc");
        CurrentLayout="multiqc";
    }//GEN-LAST:event_MultiQCButtonActionPerformed

    private void CountButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButton2ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "MACS");
        CurrentLayout="MACS";
        MThreadText.setText(Integer.toString(GS.getDefaultThread()));
        MAdapter5Text.setText(GS.getDefaultAdapter5());
        MAdapter3Text.setText(GS.getDefaultAdapter3());
        CardLayout cardTool = (CardLayout)Tool.getLayout();
        cardTool.show(Tool, "MACS");
    }//GEN-LAST:event_CountButton2ActionPerformed

    private void indexingBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexingBButtonActionPerformed
        iThreadBText.setText(Integer.toString(GS.getDefaultThread()));
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "indexingB");
        CurrentLayout="indexingB";    // TODO add your handling code here:
    }//GEN-LAST:event_indexingBButtonActionPerformed

    private void DeseqButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseqButton2ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "DES");
        CurrentLayout="DES";
    }//GEN-LAST:event_DeseqButton2ActionPerformed

    private void ExpPowerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpPowerButton1ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "ExperimentPower");
        CurrentLayout="ExperimentPower";
    }//GEN-LAST:event_ExpPowerButton1ActionPerformed

    private void SampleSizeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSizeButton1ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "SampleSize");
        CurrentLayout="SampleSize";
    }//GEN-LAST:event_SampleSizeButton1ActionPerformed

    private void CountButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButton1ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "filtercounts");
        CurrentLayout="filtercounts";
    }//GEN-LAST:event_CountButton1ActionPerformed

    private void PCAButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAButton1ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "PCA");
        CurrentLayout="PCA";
    }//GEN-LAST:event_PCAButton1ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "AddingCovmRNA");
        CurrentLayout="AddingCovmRNA";
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed

        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "mRNA");
        CurrentLayout="mRNA";
    }//GEN-LAST:event_jButton59ActionPerformed

    private void DeseqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseqButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "DES");
        CurrentLayout="DES";
    }//GEN-LAST:event_DeseqButtonActionPerformed

    private void ExpPowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpPowerButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "ExperimentPower");
        CurrentLayout="ExperimentPower";
    }//GEN-LAST:event_ExpPowerButtonActionPerformed

    private void SampleSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSizeButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "SampleSize");
        CurrentLayout="SampleSize";
    }//GEN-LAST:event_SampleSizeButtonActionPerformed

    private void CountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "filtercounts");
        CurrentLayout="filtercounts";
    }//GEN-LAST:event_CountButtonActionPerformed

    private void SampleExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleExpButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "FPKMCounting");
        CurrentLayout="FPKMCounting";
    }//GEN-LAST:event_SampleExpButtonActionPerformed

    private void countingSalmonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countingSalmonButtonActionPerformed
        cThreadText.setText(Integer.toString(GS.getDefaultThread()));
        cAdapter5Text.setText(GS.getDefaultAdapter5());
        cAdapter3Text.setText(GS.getDefaultAdapter3());
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "countingSalmon");
        CurrentLayout="countingSalmon";
    }//GEN-LAST:event_countingSalmonButtonActionPerformed

    private void PCAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "PCA");
        CurrentLayout="PCA";
    }//GEN-LAST:event_PCAButtonActionPerformed

    private void mRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRNAButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        vThreadText.setText(Integer.toString(GS.getDefaultThread()));
        vAdapter5Text.setText(GS.getDefaultAdapter5());
        vAdapter3Text.setText(GS.getDefaultAdapter3());
        card.show(MainPanel, "vmRNA");
        CurrentLayout="vmRNA";
    }//GEN-LAST:event_mRNAButtonActionPerformed

    private void vmRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmRNAButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        iThreadText.setText(Integer.toString(GS.getDefaultThread()));
        card.show(MainPanel, "indexing");
        CurrentLayout="indexing";
    }//GEN-LAST:event_vmRNAButtonActionPerformed

    private void SalmonIndexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalmonIndexingButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        iThreadSText.setText(Integer.toString(GS.getDefaultThread()));
        card.show(MainPanel, "indexingSalmon");
        CurrentLayout="indexingSalmon";
    }//GEN-LAST:event_SalmonIndexingButtonActionPerformed

    private void HeatmapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatmapButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "heatmap");
        CurrentLayout="heatmap";
    }//GEN-LAST:event_HeatmapButtonActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
    
        
        if (HLowerRangeText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the lower bound.","Error: lower bound",JOptionPane.ERROR_MESSAGE);
            //HLowerRangeText.requestFocusInWindow();
            return;
        }
        
         
        if (HUpperRangeText.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "You have to specified the upper bound.","Error: upper bound",JOptionPane.ERROR_MESSAGE);
            //HUpperRangeText.requestFocusInWindow();
            return;
        }
        
        
        try
        {
            Float x = Float.valueOf(HLowerRangeText.getText());
            Float y = Float.valueOf(HUpperRangeText.getText());
            if (x>=y){
                JOptionPane.showMessageDialog(this, "Upper bound must be greater than lower bound.","Error: bounds",JOptionPane.ERROR_MESSAGE);
                //HLowerRangeText.requestFocusInWindow();
                return;
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified the number for the bounds.","Error: bound  number",JOptionPane.ERROR_MESSAGE);
            ///HLowerRangeText.requestFocusInWindow();
            return;
        }
        
        
        if (HdataFileText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: Data  input file ",JOptionPane.ERROR_MESSAGE);   
        }
        else
            if (HscratchText.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "You have to specified a scratch folder","Error: scratch folder ",JOptionPane.ERROR_MESSAGE);   
            }
             else
            { 
            //execute code
            Runtime rt = Runtime.getRuntime();
            try{
                String[] cmd = {"/bin/bash","-c"," bash ./execHeatmap.sh "};
                if (HSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
                }
                else{
                    cmd[2]+= "group=\\\"docker\\\"";
                }
                cmd[2]+= " file=\\\""+HdataFileText.getText()+"\\\"";
                cmd[2]+= " scratch.folder=\\\""+HscratchText.getText()+"\\\"";
                if (HStatus1RadioButton.isSelected()){
                    cmd[2]+= " status=1";
                }
                else{
                    cmd[2]+= " status=0";
                }
                cmd[2]+= " lower.range="+HLowerRangeText.getText()+" upper.range="+HUpperRangeText.getText();
                cmd[2]+=" "+HOutputFolderText.getText() +" >& "+HOutputFolderText.getText()+"/outputExecution ";

                if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                    Process pr = rt.exec(cmd);                          
                    ElProcRunning tmp= new ElProcRunning("Heatmap  ", HOutputFolderText.getText(),pr,listModel.getSize());
                    listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                    GL.setAvoidProcListValueChanged(0);
                    if(listProcRunning.size()==1){
                        t=new Timer();
                        t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                        }
                }    
                else{
                     ElProcWaiting tmp= new ElProcWaiting("Heatmap", HOutputFolderText.getText(),cmd,listModel.getSize());
                     listProcWaiting.add(tmp);
                     java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                     ImageIcon image2 = new ImageIcon(imgURL);
                     GL.setAvoidProcListValueChanged(-1);
                     listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                     GL.setAvoidProcListValueChanged(0);
                    }
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer());
                GL.setAvoidProcListValueChanged(0);
                }   
            catch(IOException e) {
                JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
                }
            JOptionPane.showMessageDialog(this, "Heatmap task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE); 
        }
        
        
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
       HDockerRadioButton.setSelected(true);
       HOutputFolderText.setText("");
       HdataFileText.setText("");
       HscratchText.setText("");
       HLowerRangeText.setText("-1");
       HUpperRangeText.setText("1");
       HStatus1RadioButton.setSelected(true);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void vCloseButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton8ActionPerformed
       HDockerRadioButton.setSelected(true);
       HOutputFolderText.setText("");
       HStatus1RadioButton.setSelected(true);
       HdataFileText.setText("");
       HscratchText.setText("");
       HLowerRangeText.setText("-1");
       HUpperRangeText.setText("1");
       CardLayout card = (CardLayout)MainPanel.getLayout();
       card.show(MainPanel, "Empty");
       CurrentLayout="Empty";   
    }//GEN-LAST:event_vCloseButton8ActionPerformed

    private void HscratchTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HscratchTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HscratchTextActionPerformed

    private void jToggleButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton42ActionPerformed
     JFileChooser openDir = new JFileChooser();
        if (!(HscratchText.getText().equals(""))){
            File file =new File(HscratchText.getText());
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
            HscratchText.setText(String.valueOf(f));
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_jToggleButton42ActionPerformed

    private void jToggleButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton43ActionPerformed
       HscratchText.setText("");
    }//GEN-LAST:event_jToggleButton43ActionPerformed

    private void HSudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HSudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HSudoRadioButtonActionPerformed

    private void HDockerRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDockerRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HDockerRadioButtonActionPerformed

    private void HdataFileTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HdataFileTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HdataFileTextActionPerformed

    private void jToggleButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton44ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(HdataFileText.getText().equals(""))){
            File file =new File(HOutputFolderText.getText());
            //file=  new File(file.getAbsolutePath());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            HdataFileText.setText(String.valueOf(f));
            HOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());    
    }//GEN-LAST:event_jToggleButton44ActionPerformed

    private void jToggleButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton45ActionPerformed
        HdataFileText.setText("");
        HOutputFolderText.setText("");
    }//GEN-LAST:event_jToggleButton45ActionPerformed

    private void HStatus1RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HStatus1RadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HStatus1RadioButtonActionPerformed

    private void HStatus0RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HStatus0RadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HStatus0RadioButtonActionPerformed

    private void jToggleButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton46ActionPerformed

    private void jToggleButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton47ActionPerformed

    private void HOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HOutputFolderTextActionPerformed

    private void ANOVAlikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANOVAlikeButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "NOVAlike");
        CurrentLayout="NOVAlike";
    }//GEN-LAST:event_ANOVAlikeButtonActionPerformed

    private void vCloseButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vCloseButton9ActionPerformed
        ANinputfileText.setText("");
        ANOutputFolderText.setText("");
        ANLog2fcText.setText("1.0");
        ANLogCPMText.setText("4.0");
        ANadjPText.setText("0.1");
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "Empty");
        CurrentLayout="Empty";   
    }//GEN-LAST:event_vCloseButton9ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        if (ANinputfileText.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "You have to specified an input file","Error: Data  input file ",JOptionPane.ERROR_MESSAGE);   
           return;
        }
            
        try
        {
            Float x = Float.valueOf(ANLog2fcText.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a number for LogFG threshold.","Error: bound  number",JOptionPane.ERROR_MESSAGE);
            ///HLowerRangeText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(ANLogCPMText.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a number for LogCPM threshold.","Error: bound  number",JOptionPane.ERROR_MESSAGE);
            ///HLowerRangeText.requestFocusInWindow();
            return;
        }
        
        try
        {
            Float x = Float.valueOf(ANadjPText.getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "You have to specified a number for  Adj. p-value threshold.","Error: bound  number",JOptionPane.ERROR_MESSAGE);
            ///HLowerRangeText.requestFocusInWindow();
            return;
        }
        
       
        //execute code
        Runtime rt = Runtime.getRuntime();
        try{
            String[] cmd = {"/bin/bash","-c"," bash ./execANOVAlike.sh "};
                if (ANSudoRadioButton.isSelected()){
                    cmd[2]+= "group=\\\"sudo\\\"";
                }
                else{
                    cmd[2]+= "group=\\\"docker\\\"";
                }
                cmd[2]+= " file=\\\""+ANinputfileText.getText()+"\\\""+" logFC.threshold="+ANLog2fcText.getText();
                cmd[2]+= " FDR.threshold="+ANadjPText.getText()+" logCPM.threshold="+ANLogCPMText.getText();
                cmd[2]+=" "+ANOutputFolderText.getText() +" >& "+ANOutputFolderText.getText()+"/outputExecution ";

                if (listProcRunning.size()<GS.getMaxSizelistProcRunning()){
                    Process pr = rt.exec(cmd);                          
                    ElProcRunning tmp= new ElProcRunning("ANOVA-like  ", ANOutputFolderText.getText(),pr,listModel.getSize());
                    listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    GL.setAvoidProcListValueChanged(-1);
                    listModel.addElement(new ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                    GL.setAvoidProcListValueChanged(0);
                    if(listProcRunning.size()==1){
                        t=new Timer();
                        t.scheduleAtFixedRate(new MyTask(), 5000, 5000);
                        }
                }    
                else{
                     ElProcWaiting tmp= new ElProcWaiting("ANOVA-like", ANOutputFolderText.getText(),cmd,listModel.getSize());
                     listProcWaiting.add(tmp);
                     java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/waiting.png");
                     ImageIcon image2 = new ImageIcon(imgURL);
                     GL.setAvoidProcListValueChanged(-1);
                     listModel.addElement(new ListEntry(" [Waiting]   "+tmp.toString(),"Waiting",tmp.path,image2));
                     GL.setAvoidProcListValueChanged(0);
                    }
                GL.setAvoidProcListValueChanged(-1);
                ProcList.setModel(listModel);
                ProcList.setCellRenderer(new ListEntryCellRenderer());
                GL.setAvoidProcListValueChanged(0);
                }   
            catch(IOException e) {
                JOptionPane.showMessageDialog(this, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
                }
            JOptionPane.showMessageDialog(this, "ANOVA-lie task was scheduled","Confermation",JOptionPane.INFORMATION_MESSAGE); 
        
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
    
        ANinputfileText.setText("");
        ANOutputFolderText.setText("");
        ANLog2fcText.setText("1.0");
        ANLogCPMText.setText("4.0");
        ANadjPText.setText("0.1");
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton51ActionPerformed

    private void ANinputfileTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANinputfileTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANinputfileTextActionPerformed

    private void jToggleButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton48ActionPerformed
     JFileChooser openDir = new JFileChooser();
     if (!(ANinputfileText.getText().equals(""))){
            File file =new File(ANOutputFolderText.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
     else
     {
        String curDir = getPreferences().get("open-dir", null);
        openDir.setCurrentDirectory(curDir!=null ? new File(curDir) : null);   
     }
        openDir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (openDir.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File f = openDir.getSelectedFile();
            ANinputfileText.setText(String.valueOf(f));
            ANOutputFolderText.setText(openDir.getCurrentDirectory().getAbsolutePath());
        }
        getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());    
    }//GEN-LAST:event_jToggleButton48ActionPerformed

    private void fCancelButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton6ActionPerformed
    ANinputfileText.setText("");
    ANOutputFolderText.setText("");
    }//GEN-LAST:event_fCancelButton6ActionPerformed

    private void ANOutputFolderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANOutputFolderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANOutputFolderTextActionPerformed

    private void jToggleButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton49ActionPerformed

    private void fCancelButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fCancelButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fCancelButton7ActionPerformed

    private void ANLog2fcTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ANLog2fcTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ANLog2fcTextFocusLost

    private void ANLog2fcTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANLog2fcTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANLog2fcTextActionPerformed

    private void ANLogCPMTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ANLogCPMTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ANLogCPMTextFocusLost

    private void ANLogCPMTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANLogCPMTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANLogCPMTextActionPerformed

    private void ANadjPTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ANadjPTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ANadjPTextFocusLost

    private void ANadjPTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANadjPTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANadjPTextActionPerformed

    private void HLowerRangeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HLowerRangeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HLowerRangeTextActionPerformed

    private void HUpperRangeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HUpperRangeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HUpperRangeTextActionPerformed

    private void ANSudoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANSudoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANSudoRadioButtonActionPerformed

    private void ANDockerRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANDockerRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ANDockerRadioButton1ActionPerformed
    
    
    private void  openAbout4SeqGUI(java.awt.event.ActionEvent evt) {  
        About4SeqGUIFrame.pack(); 
        About4SeqGUIFrame.setLocationRelativeTo(null);                                       
        About4SeqGUIFrame.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //Anti-aliasing code
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");
        boolean nofound=true;
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeels".equals(info.getClassName())) {   
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    nofound=false;
                     break;
                } 
                if (nofound=true)
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName()); 
        }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
        
        try{
        Thread.sleep(800L);
        }
        catch ( InterruptedException e ) { } 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ANDockerRadioButton1;
    private javax.swing.JTextField ANLog2fcText;
    private javax.swing.JTextField ANLogCPMText;
    private javax.swing.ButtonGroup ANOVAGroup;
    private javax.swing.JScrollPane ANOVAlike;
    private javax.swing.JButton ANOVAlikeButton;
    private javax.swing.JPanel ANOVAlikePanel;
    private javax.swing.JTextField ANOutputFolderText;
    private javax.swing.JRadioButton ANSudoRadioButton;
    private javax.swing.JTextField ANadjPText;
    private javax.swing.JTextField ANinputfileText;
    private javax.swing.JFrame About4SeqGUIFrame;
    private javax.swing.JTextField Adapter3TextField;
    private javax.swing.JTextField Adapter5TextField;
    private javax.swing.ButtonGroup Annotation;
    private javax.swing.JComboBox<String> BatchComboBox;
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JButton CCloseButton1;
    private javax.swing.JTable CCountHeaderTable;
    private javax.swing.JTextField CCovInputFileText;
    private javax.swing.JTextField COutputFolderText;
    private javax.swing.JButton CResetButton1;
    private javax.swing.JPanel ChipSeqPanel;
    private javax.swing.JButton Cinbrowes;
    private javax.swing.JButton Cincancel;
    private javax.swing.JToggleButton CloseOutput;
    private javax.swing.JButton ConfCancell;
    private javax.swing.JFrame ConfigurationFrame;
    private javax.swing.JButton CountButton;
    private javax.swing.JButton CountButton1;
    private javax.swing.JButton CountButton2;
    private javax.swing.JScrollPane CountingSalmon;
    private javax.swing.JPanel CountingSalmonPanel;
    private javax.swing.JButton Coutbrowes;
    private javax.swing.JButton Coutcancel;
    private javax.swing.JComboBox<String> CovComboBox;
    private javax.swing.ButtonGroup Covariates;
    private javax.swing.JRadioButton DBatchesFalse;
    private javax.swing.JScrollPane DES;
    private javax.swing.ButtonGroup DESBatch;
    private javax.swing.JPanel DESPanel;
    private javax.swing.ButtonGroup DEStype;
    private javax.swing.ButtonGroup DataFilter;
    private javax.swing.ButtonGroup DataType;
    private javax.swing.JButton DeseqButton;
    private javax.swing.JButton DeseqButton2;
    private javax.swing.JButton DlogButton;
    private javax.swing.JFrame DownloadFrame;
    private javax.swing.JTextField Downloadtext;
    private javax.swing.JButton EPCloseButton;
    private javax.swing.JTextField EPCountTableText;
    private javax.swing.JButton EPExecuteButton1;
    private javax.swing.JTextField EPFDRtext;
    private javax.swing.JTextField EPGeneText;
    private javax.swing.JTextField EPOutputFolderText;
    private javax.swing.JButton EPResetButton;
    private javax.swing.JTextField EPSampleText;
    private javax.swing.JButton EPSaveButton;
    private javax.swing.JTextField EPlog2Text;
    private javax.swing.JScrollPane Empty;
    private javax.swing.JPanel EmptyPanel;
    private javax.swing.JButton ExpPowerButton;
    private javax.swing.JButton ExpPowerButton1;
    private javax.swing.JScrollPane ExperimentPower;
    private javax.swing.JPanel ExperimentPowerPanel;
    private javax.swing.JButton FAddFile;
    private javax.swing.JButton FCloseButton;
    private javax.swing.JButton FExecuteButton;
    private javax.swing.JButton FExecuteButton1;
    private javax.swing.JTextField FOutputFolderText;
    private javax.swing.JScrollPane FPKM;
    private javax.swing.JTable FPKMFileTable;
    private javax.swing.JPanel FPKMPanel;
    private javax.swing.JButton FResetButton;
    private javax.swing.JButton FSaveButton;
    private javax.swing.JButton FSaveButton1;
    private javax.swing.JButton Fbrowes;
    private javax.swing.JButton Fcancel;
    private javax.swing.JComboBox<String> FtypesComboBox;
    private javax.swing.ButtonGroup GATK;
    private javax.swing.JRadioButton HDockerRadioButton;
    private javax.swing.JTextField HLowerRangeText;
    private javax.swing.JTextField HOutputFolderText;
    private javax.swing.JRadioButton HStatus0RadioButton;
    private javax.swing.JRadioButton HStatus1RadioButton;
    private javax.swing.JRadioButton HSudoRadioButton;
    private javax.swing.JTextField HUpperRangeText;
    private javax.swing.JTextField HdataFileText;
    private javax.swing.JScrollPane Heatmap;
    private javax.swing.JButton HeatmapButton;
    private javax.swing.JPanel Heatmappanel;
    private javax.swing.JSplitPane HorizontalSplitPanel;
    private javax.swing.JTextField HscratchText;
    private javax.swing.ButtonGroup IExecutionBWA;
    private javax.swing.ButtonGroup IExecutionSalmon;
    private javax.swing.ButtonGroup IExecutionStarRSEM;
    private javax.swing.JScrollPane IndexingBWA;
    private javax.swing.JPanel IndexingBWAPanel;
    private javax.swing.JScrollPane IndexingSalmon;
    private javax.swing.JPanel IndexingSalmonPanel;
    private javax.swing.JScrollPane IndexingStarRSEM;
    private javax.swing.JPanel IndexingStarRSEMPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JScrollPane MACS;
    private javax.swing.JPanel MACSPanel;
    private javax.swing.ButtonGroup MAdapter;
    private javax.swing.JTextField MAdapter3Text;
    private javax.swing.JTextField MAdapter5Text;
    private javax.swing.JRadioButton MDockerRadioButton;
    private javax.swing.ButtonGroup MExecution;
    private javax.swing.JTextField MGenomeFolderText;
    private javax.swing.JTextField MMaxUpstreamText;
    private javax.swing.JTextField MMaxmfoldText;
    private javax.swing.JTextField MMinLengthText;
    private javax.swing.JTextField MMinmfoldText;
    private javax.swing.JTextField MMockFolderText;
    private javax.swing.JTextField MMpvalueText;
    private javax.swing.JComboBox<String> MOrgComboBox;
    private javax.swing.JTextField MOutputFolderText;
    private javax.swing.JTextField MReadLengthTextField;
    private javax.swing.ButtonGroup MRemoveDuplicates;
    private javax.swing.JRadioButton MRnoRadioButton;
    private javax.swing.JRadioButton MRyesRadioButton;
    private javax.swing.JTextField MSFDRText;
    private javax.swing.JTextField MSWindowsText;
    private javax.swing.JTextField MScratchFolderText;
    private javax.swing.ButtonGroup MSeq;
    private javax.swing.JTextField MSgsizeText;
    private javax.swing.JRadioButton MSudoRadioButton;
    private javax.swing.JTextField MTTSText;
    private javax.swing.JTextField MTestFolderText;
    private javax.swing.JTextField MThreadText;
    private javax.swing.JComboBox<String> MToolComboBox;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MultiQC;
    private javax.swing.JButton MultiQCButton;
    private javax.swing.ButtonGroup MultiQCGroup;
    private javax.swing.JPanel MultiQCpanel;
    private javax.swing.JFrame OutputFrame;
    private javax.swing.JTextArea OutputText;
    private javax.swing.JScrollPane PCA;
    private javax.swing.JButton PCAButton;
    private javax.swing.JButton PCAButton1;
    private javax.swing.JPanel PCAPanel;
    private javax.swing.JTextField ParallelTextField;
    private javax.swing.JList<ListEntry> ProcList;
    private javax.swing.JPanel ProcStatusPanel;
    private javax.swing.JRadioButton QDockerRadioButton;
    private javax.swing.JRadioButton QSudoRadioButton;
    private javax.swing.JTextField QdataFolderText;
    private javax.swing.JPanel RNAseqPanel;
    private javax.swing.JToggleButton ReloadOutput;
    private javax.swing.JButton RemoveOutput;
    private javax.swing.JButton SSCloseButton;
    private javax.swing.JTextField SSCountTableText;
    private javax.swing.JButton SSExecuteButton;
    private javax.swing.JTextField SSFDRtext;
    private javax.swing.JTextField SSGeneText;
    private javax.swing.JTextField SSOutputFolderText;
    private javax.swing.JTextField SSPowerText;
    private javax.swing.JButton SSResetButton;
    private javax.swing.JButton SSSaveButton;
    private javax.swing.JButton SSbrowes;
    private javax.swing.JButton SSbrowes1;
    private javax.swing.JButton SScancel;
    private javax.swing.JButton SScancel1;
    private javax.swing.JTextField SSlog2Text;
    private javax.swing.JButton SalmonIndexingButton;
    private javax.swing.JButton SampleExpButton;
    private javax.swing.JScrollPane SampleSize;
    private javax.swing.JButton SampleSizeButton;
    private javax.swing.JButton SampleSizeButton1;
    private javax.swing.JPanel SampleSizePanel;
    private javax.swing.ButtonGroup Strand;
    private javax.swing.JTextField ThreadTextField;
    private javax.swing.JPanel Tool;
    private javax.swing.JPanel ToolPanel;
    private javax.swing.ButtonGroup Truncating;
    private javax.swing.JSplitPane VerticalSplitPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cAdapter3Text;
    private javax.swing.JTextField cAdapter5Text;
    private javax.swing.JRadioButton cDockerRadioButton;
    private javax.swing.ButtonGroup cExecutiionSalmon;
    private javax.swing.JTextField cFastQFolderText;
    private javax.swing.JTextField cGenomeFolderText;
    private javax.swing.JTextField cMinLengthText;
    private javax.swing.JTextField cOutputFolderText;
    private javax.swing.JRadioButton cPeRadioButton;
    private javax.swing.JRadioButton cSForwardRadioButton;
    private javax.swing.JRadioButton cSNoneRadioButton;
    private javax.swing.JRadioButton cSReverseRadioButton;
    private javax.swing.JRadioButton cSeRadioButton;
    private javax.swing.ButtonGroup cSeq;
    private javax.swing.ButtonGroup cStrand;
    private javax.swing.JRadioButton cSudoRadioButton;
    private javax.swing.JTextField cThreadText;
    private javax.swing.JButton countingSalmonButton;
    private javax.swing.JRadioButton dBatchesTrue;
    private javax.swing.JComboBox<String> dCovComboBox;
    private javax.swing.JTextField dFDRText;
    private javax.swing.JTextField dFPKMfileText;
    private javax.swing.JRadioButton dGeneRadioButton;
    private javax.swing.JRadioButton dIsoformRadioButton;
    private javax.swing.JTextField dLog2fcText;
    private javax.swing.JTextField dOutputFolderText;
    private javax.swing.JRadioButton dmiRNARadioButton;
    private javax.swing.JToggleButton fCancelButton;
    private javax.swing.JToggleButton fCancelButton1;
    private javax.swing.JToggleButton fCancelButton2;
    private javax.swing.JToggleButton fCancelButton3;
    private javax.swing.JToggleButton fCancelButton4;
    private javax.swing.JToggleButton fCancelButton5;
    private javax.swing.JToggleButton fCancelButton6;
    private javax.swing.JToggleButton fCancelButton7;
    private javax.swing.JTextField fFPKMfileText;
    private javax.swing.JTextField fOutputFolderText;
    private javax.swing.JRadioButton fgeneRadioButton;
    private javax.swing.JScrollPane filterCounts;
    private javax.swing.JPanel filterCountsPanel;
    private javax.swing.JRadioButton fisoformRadioButton;
    private javax.swing.JRadioButton fmirnaRadioButton;
    private javax.swing.ButtonGroup heatmapBaseGroup;
    private javax.swing.ButtonGroup heatmapGroup;
    private javax.swing.ButtonGroup heatmapGroupLog;
    private javax.swing.JToggleButton i1000BrowseButton;
    private javax.swing.JToggleButton i1000CancelButton;
    private javax.swing.JTextField i1000GenomeText;
    private javax.swing.JRadioButton iBFalseRadioButton;
    private javax.swing.JRadioButton iBTrueRadioButton;
    private javax.swing.JButton iCloseButton;
    private javax.swing.JButton iCloseButton1;
    private javax.swing.JButton iCloseButton2;
    private javax.swing.JRadioButton iDockerBRadioButton;
    private javax.swing.JRadioButton iDockerRadioButton;
    private javax.swing.JRadioButton iDockerRadioSButton;
    private javax.swing.JTextField iGTFURLSText;
    private javax.swing.JTextField iGTFURLText;
    private javax.swing.JTextField iGenomeFolderBText;
    private javax.swing.JTextField iGenomeFolderSText;
    private javax.swing.JTextField iGenomeFolderText;
    private javax.swing.JTextField iGenomeURLBText;
    private javax.swing.JTextField iGenomeURLSText;
    private javax.swing.JTextField iGenomeURLText;
    private javax.swing.JTextField iKmerSText;
    private javax.swing.JButton iResetButton;
    private javax.swing.JButton iResetButton1;
    private javax.swing.JButton iResetButton2;
    private javax.swing.JRadioButton iSudoBRadioButton;
    private javax.swing.JRadioButton iSudoRadioButton;
    private javax.swing.JRadioButton iSudoRadioSButton;
    private javax.swing.JTextField iThreadBText;
    private javax.swing.JTextField iThreadSText;
    private javax.swing.JTextField iThreadText;
    private javax.swing.JToggleButton idbSPNBrowseButton;
    private javax.swing.JToggleButton idbSPNCancelButton;
    private javax.swing.JTextField idbSPNText;
    private javax.swing.JButton indexingBButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton25;
    private javax.swing.JToggleButton jToggleButton26;
    private javax.swing.JToggleButton jToggleButton27;
    private javax.swing.JToggleButton jToggleButton28;
    private javax.swing.JToggleButton jToggleButton29;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton jToggleButton42;
    private javax.swing.JToggleButton jToggleButton43;
    private javax.swing.JToggleButton jToggleButton44;
    private javax.swing.JToggleButton jToggleButton45;
    private javax.swing.JToggleButton jToggleButton46;
    private javax.swing.JToggleButton jToggleButton47;
    private javax.swing.JToggleButton jToggleButton48;
    private javax.swing.JToggleButton jToggleButton49;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton mAILLUMINARadioButton;
    private javax.swing.JRadioButton mANEBRadioButton;
    private javax.swing.JRadioButton mDFalseRadioButton;
    private javax.swing.JRadioButton mDTrueRadioButton;
    private javax.swing.JRadioButton mDockerRadioButton;
    private javax.swing.ButtonGroup mDownload;
    private javax.swing.ButtonGroup mExecution;
    private javax.swing.JTextField mFastQFolderText;
    private javax.swing.JTextField mOutputFolderText;
    private javax.swing.JScrollPane mRNA;
    private javax.swing.JScrollPane mRNABatch;
    private javax.swing.JPanel mRNABatchPanel;
    private javax.swing.JButton mRNAButton;
    private javax.swing.JPanel mRNAPanel;
    private javax.swing.JRadioButton mSudoRadioButton;
    private javax.swing.JRadioButton mTFalseRadioButton;
    private javax.swing.JRadioButton mTTrueRadioButton;
    private javax.swing.ButtonGroup mTrimmed;
    private javax.swing.JPanel miRNAPanel;
    private javax.swing.JTextField mmiRBaseText;
    private javax.swing.JTextField pComponent1Text;
    private javax.swing.JTextField pComponent2Text;
    private javax.swing.JRadioButton pCountsRadioButton;
    private javax.swing.JRadioButton pCovNoRadioButton;
    private javax.swing.JRadioButton pCovYesRadioButton;
    private javax.swing.JRadioButton pFPKMRadioButton;
    private javax.swing.JTextField pFPKMfileText;
    private javax.swing.JComboBox<String> pLegendComboBox;
    private javax.swing.JTextField pOutputFolderText;
    private javax.swing.JRadioButton pTPMRadioButton;
    private javax.swing.JTextField vAdapter3Text;
    private javax.swing.JTextField vAdapter5Text;
    private javax.swing.JRadioButton vBAMnoLRadioButton;
    private javax.swing.JRadioButton vBAMyesRadioButton;
    private javax.swing.JButton vCloseButton;
    private javax.swing.JButton vCloseButton1;
    private javax.swing.JButton vCloseButton2;
    private javax.swing.JButton vCloseButton3;
    private javax.swing.JButton vCloseButton4;
    private javax.swing.JButton vCloseButton5;
    private javax.swing.JButton vCloseButton6;
    private javax.swing.JButton vCloseButton7;
    private javax.swing.JButton vCloseButton8;
    private javax.swing.JButton vCloseButton9;
    private javax.swing.JRadioButton vDockerRadioButton;
    private javax.swing.ButtonGroup vExecution;
    private javax.swing.JTextField vFastQFolderText;
    private javax.swing.JTextField vGenomeFolderText;
    private javax.swing.JTextField vMinLengthText;
    private javax.swing.JTextField vOrganismText;
    private javax.swing.JTextField vOutputFolderText;
    private javax.swing.JRadioButton vPeRadioButton;
    private javax.swing.JRadioButton vSForwardRadioButton;
    private javax.swing.JRadioButton vSNoneRadioButton;
    private javax.swing.JRadioButton vSReverseRadioButton;
    private javax.swing.JRadioButton vSeRadioButton;
    private javax.swing.ButtonGroup vSeq;
    private javax.swing.JRadioButton vSudoRadioButton;
    private javax.swing.JTextField vThreadText;
    private javax.swing.JScrollPane vmRNA;
    private javax.swing.JButton vmRNAButton;
    private javax.swing.JPanel vmRNAPanel;
    // End of variables declaration//GEN-END:variables


        


public class ElProcRunning {
    public String type;
    public String path;
    public Process pr;
    public int  pos;
    //constructor
    public ElProcRunning(String type,String path, Process pr,int i) {
        this.type = type;
        this.path = path;
        this.pr = pr;
        pos=i;
    }
   public String toString() {
      return new String(type+" ( data: "+path+" )");
   }
}

public class ElProcWaiting {
    public String type;
    public String path;
    public String[] cmd;
    public int  pos;
    //constructor
    public ElProcWaiting(String type, String path, String[] cmd, int i) {
        this.type = type;
        this.path =path;
        this.cmd = cmd;
        pos=i;
    }
    public String toString() {
      return new String(type+" ( data: "+path+")");
   }
}


class GlobalStatus{
 private int ListProcStatusSelection;
 private int AvoidProcListValueChanged; //-1 avoid  ProcListValueChanged
 public GlobalStatus(){
     ListProcStatusSelection=-1;
     AvoidProcListValueChanged=0;
 }
 
 public int getListProcStatuSelection(){
     return ListProcStatusSelection;
 }
  public void setListProcStatuSelection(int ListProcStatusSelection){
     //System.out.print("Updating..."+ListProcStatusSelection+"\n");
     this.ListProcStatusSelection=ListProcStatusSelection;
 }
 
 public int getAvoidProcListValueChanged(){
     return AvoidProcListValueChanged;
 }
  public void setAvoidProcListValueChanged(int AvoidProcListValueChanged){
     this.AvoidProcListValueChanged=AvoidProcListValueChanged;
 }
}

class ListEntry
{
   private String value;
   private ImageIcon icon;
   private  String status;
   private  String path;
   private static final long serialVersionUID = 57782123311L;
   public ListEntry(String value, String status,String path, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
      this.status=status;
      this.path=path;
   }
  
   public String getValue() {
      return value;
   }
  
   public ImageIcon getIcon() {
      return icon;
   }
   public String getStatus() {
      return status;
   }
  
   public String getPath() {
      return path;
   }
   
   public String toString() {
      return value;
   }
}

class GlobalSetting{
    private int DefaultThread= 8;
    private int MaxSizelistProcRunning=1;
    private String DefaultAdapter5="";
    private String DefaultAdapter3="";
    
    public GlobalSetting(){
    boolean findFile=false;    
    try{
                File file = new File(".4SeqGUI");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                int line=0;
                //Read File Line By Line
                 for (String x = reader.readLine(); x != null; x = reader.readLine()){
                                switch (line){
                                    case 0:
                                        DefaultThread=Integer.valueOf(x);
                                        if (DefaultThread<=0){ 
                                            throw(new NumberFormatException()); 
                                        }
                                    break;
                                    case 1:
                                       MaxSizelistProcRunning=Integer.valueOf(x);
                                        if (MaxSizelistProcRunning<=0){ 
                                            throw(new NumberFormatException()); 
                                        }
                                    break;
                                    case 2:
                                        DefaultAdapter5=x;
                                    break;  
                                    case 3:
                                        DefaultAdapter3=x;
                                    break;
                                    default:
                                        throw(new NumberFormatException()); 
                                }                                
                                line++;
                            }
                reader.close();    
        }
    catch (Exception e){//Catch exception if any
                //System.err.println("Error: " + e.getMessage());
            return;
            }    
    }
    
    public void save(){
        
        try{
            FileWriter fw = new FileWriter(".4SeqGUI");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(DefaultThread+"\n");
            bw.write(MaxSizelistProcRunning+"\n"); 
            bw.write(DefaultAdapter5+"\n");
            bw.write(DefaultAdapter3+"\n"); 
            bw.close();    
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(ConfigurationFrame, "Error saving file","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    int getDefaultThread(){
    return DefaultThread;
    }
    
    String getDefaultAdapter5(){
    return DefaultAdapter5;
    }
    
    String getDefaultAdapter3(){
    return DefaultAdapter3;
    }
    
    int getMaxSizelistProcRunning(){
    return MaxSizelistProcRunning;
    }
    
    
    void  setDefaultThread(int DefaultThread){
    this.DefaultThread=DefaultThread;
    }
    
    void setDefaultAdapter5(String DefaultAdapter5){
    this.DefaultAdapter5=DefaultAdapter5;
    }
    
    void setDefaultAdapter3(String DefaultAdapter3){
    this.DefaultAdapter3=DefaultAdapter3;
    }
    
    void setMaxSizelistProcRunning(int MaxSizelistProcRunning){
    this.MaxSizelistProcRunning=MaxSizelistProcRunning;
    }
}

  
class ListEntryCellRenderer
extends JLabel implements ListCellRenderer<Object> 
{
   private JLabel label;
   private static final long serialVersionUID = 5778212331L;
   public Component getListCellRendererComponent(JList<?> list, Object value,
                                                 int index, boolean isSelected,
                                                 boolean cellHasFocus) {
      ListEntry entry = (ListEntry) value;
  
      setText(value.toString());
      setIcon(entry.getIcon());
   
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      }
  
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      setOpaque(true);
  
      return this;
   }
}
    private String CurrentLayout="Empty";
    

  Timer t,outputTime;

  class MyFileUpdate extends TimerTask{
       public void run() {
        if (GL.getListProcStatuSelection()>=0){
            ListEntry tmpListEntry =  listModel.get(GL.getListProcStatuSelection());
            //
            if (tmpListEntry.status.equals("Running") || tmpListEntry.status.equals("Finished")){
             OutputText.setEnabled(true);
            String text="";
            try{
                File file = new File( tmpListEntry.path+"/Routput.Rout");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String strLine;
                //Read File Line By Line
                while ((strLine = reader.readLine()) != null)   {
                    text+="\n"+strLine;
                }
                reader.close();    
            }
            catch (Exception e){//Catch exception if any
                //To avoid to recall infinitelly this error
                outputTime.cancel();
                System.err.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(OutputFrame, "Error reading file","Error",JOptionPane.ERROR_MESSAGE);
                }
            OutputText.setText(text);
            }
        ReloadOutput.setSelected(false);   
       }
    }
  }
  class MyTask extends TimerTask {
      
        public void run() {

            //System.out.format("Checking running !%n");
            for (int i=0;i<listProcRunning.size();i++){
                if (listProcRunning.get(i).pr.isAlive()){
                    //System.out.format("TRUE\n");
                }                    
                else
                {
                    //System.out.format("False\n");
                    int index=listProcRunning.get(i).pos;
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/end.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    ImageIcon image3 = new ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"));
                    //listModel.remove(index+1);
                    //GL.setAvoidProcListValueChanged(-1);
                    boolean error=false;
                    try{
                        File f = new File(listProcRunning.get(i).path+"/ExitStatusFile");
                         System.out.print("file:"+ f.getAbsoluteFile().toString() );
                        FileReader fw = new FileReader(f.getAbsoluteFile());
                        BufferedReader br = new BufferedReader(fw);
                        String ExitStatus=br.readLine();
                        System.out.print("br: "+ExitStatus+" "+listProcRunning.get(i).path);
                        if (!(ExitStatus.equals("0"))){
                            error=true;
                        }
                    }
                    catch(IOException | NumberFormatException e) {
                       System.out.print(listProcRunning.get(i).path);
                       error=true;
                    }
                    
                    if (error)
                        listModel.set(index,new ListEntry(" [Error]   " + listProcRunning.get(i).toString(), "Error",listProcRunning.get(i).path,image3));
                    else
                        listModel.set(index,new ListEntry(" [Finished]   " + listProcRunning.get(i).toString(), "Finished",listProcRunning.get(i).path,image2));
                    listProcRunning.remove(i);        
                }
            }
            //System.out.format("End Check!\n");    
            //System.out.format("Checking waiting !%n");
            while ((listProcRunning.size()<GS.getMaxSizelistProcRunning())&&(listProcWaiting.size()>0)){
                try{
                
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec(listProcWaiting.get(0).cmd);
                    ElProcRunning tmp= new ElProcRunning(listProcWaiting.get(0).type,listProcWaiting.get(0).path,pr,listProcWaiting.get(0).pos);
                    listProcRunning.add(tmp);
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    //listModel.remove(listProcWaiting.get(0).pos);
                    //GL.setAvoidProcListValueChanged(-1);
                    listModel.set(listProcWaiting.get(0).pos,new ListEntry(" [Running]   " +  listProcWaiting.get(0).toString(),"Running", listProcWaiting.get(0).path,image2));
                    listProcWaiting.remove(0);
                    //System.out.format("Size:"+listProcRunning.size()+"\n");
                } 
                catch(IOException e) {
                    JOptionPane.showMessageDialog(vmRNAPanel, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.toString());
                }
            }
            //System.out.format("End Check!\n"); 
            if (listProcRunning.isEmpty()){
                 //System.out.format("End TimerTask\n");
                 t.cancel();
            }
                
        }
    }
  
  
private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
    for(int i=startingIndex;i<rowCount;++i){
        tree.expandRow(i);
    }

    if(tree.getRowCount()!=rowCount){
        expandAllNodes(tree, rowCount, tree.getRowCount());
    }
}  
  

 public static synchronized long getPidOfProcess(Process p) {
    long pid = -1;

    try {
      if (p.getClass().getName().equals("java.lang.UNIXProcess")) {
        Field f = p.getClass().getDeclaredField("pid");
        f.setAccessible(true);
        pid = f.getLong(p);
        f.setAccessible(false);
      }
    } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
      pid = -1;
    }
    return pid;
  }

 
ArrayList <ElProcRunning> listProcRunning =  new  ArrayList <ElProcRunning> ();
ArrayList <ElProcWaiting> listProcWaiting = new  ArrayList <ElProcWaiting> ();
DefaultListModel<ListEntry> listModel= new DefaultListModel <ListEntry> ();


//int MaxSizelistProcRunning=1; 
GlobalStatus GL =new GlobalStatus();
//String DefaultThread="8";
GlobalSetting GS =new GlobalSetting();




public class DefaultContextMenu extends JPopupMenu
{
    private final Clipboard clipboard;

    private UndoManager undoManager;

    private final JMenuItem undo;
    private final JMenuItem redo;
    private final JMenuItem cut;
    private final JMenuItem copy;
    private final JMenuItem paste;
    private final JMenuItem delete;
    private final JMenuItem selectAll;

    private JTextComponent jTextComponent;
    private static final long serialVersionUID = 5778212333L;
    
    public DefaultContextMenu()
    {
        java.net.URL imgURL;
        
        undoManager = new UndoManager();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        undo = new JMenuItem("Undo");
        undo.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/undomenu.png");
        ImageIcon imageundo = new ImageIcon(imgURL);
        undo.setIcon(imageundo);
        undo.setAccelerator(KeyStroke.getKeyStroke("control Z"));
        undo.addActionListener(event -> undoManager.undo());

        add(undo);

        redo = new JMenuItem("Redo");
        redo.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/redomenu.png");
        ImageIcon imageredo = new ImageIcon(imgURL);
        redo.setIcon(imageredo);
        redo.setAccelerator(KeyStroke.getKeyStroke("control Y"));
        redo.addActionListener(event -> undoManager.redo());

        add(redo);

        add(new JSeparator());

        cut = new JMenuItem("Cut");
        cut.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/cutmenu.png");
        ImageIcon imagecut = new ImageIcon(imgURL);
        cut.setIcon(imagecut);
        cut.setAccelerator(KeyStroke.getKeyStroke("control X"));
        cut.addActionListener(event -> jTextComponent.cut());

        add(cut);

        copy = new JMenuItem("Copy");
        copy.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/copymenu.png");
        ImageIcon imagecopy = new ImageIcon(imgURL);
        copy.setIcon(imagecopy);
        copy.setAccelerator(KeyStroke.getKeyStroke("control C"));
        copy.addActionListener(event -> jTextComponent.copy());

        add(copy);

        paste = new JMenuItem("Paste");
        paste.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/pastemenu.png");
        ImageIcon imagepaste = new ImageIcon(imgURL);
        paste.setIcon(imagepaste);
        paste.setAccelerator(KeyStroke.getKeyStroke("control V"));
        paste.addActionListener(event -> jTextComponent.paste());

        add(paste);

        delete = new JMenuItem("Delete");
        delete.setEnabled(false);
        imgURL = getClass().getResource("/pkg4seqgui/images/deletemenu.png");
        ImageIcon imagedelete = new ImageIcon(imgURL);
        delete.setIcon(imagedelete);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
        delete.addActionListener(event -> jTextComponent.replaceSelection(""));

        add(delete);

        add(new JSeparator());

        selectAll = new JMenuItem("Select All");
        selectAll.setEnabled(false);
        selectAll.setAccelerator(KeyStroke.getKeyStroke("control A"));
        selectAll.addActionListener(event -> jTextComponent.selectAll());

        add(selectAll);
    }

    public void add(JTextComponent jTextComponent)
    {
        jTextComponent.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent pressedEvent)
            {
                if ((pressedEvent.getKeyCode() == KeyEvent.VK_Z)
                        && ((pressedEvent.getModifiers() & KeyEvent.CTRL_MASK) != 0))
                {
                    if (undoManager.canUndo())
                    {
                        undoManager.undo();
                    }
                }

                if ((pressedEvent.getKeyCode() == KeyEvent.VK_Y)
                        && ((pressedEvent.getModifiers() & KeyEvent.CTRL_MASK) != 0))
                {
                    if (undoManager.canRedo())
                    {
                        undoManager.redo();
                    }
                }
            }
        });

        jTextComponent.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseReleased(MouseEvent releasedEvent)
            {
                if (releasedEvent.getButton() == MouseEvent.BUTTON3)
                {
                    processClick(releasedEvent);
                }
            }
        });

        jTextComponent.getDocument().addUndoableEditListener(event -> undoManager.addEdit(event.getEdit()));
    }

    private void processClick(MouseEvent event)
    {
        jTextComponent = (JTextComponent) event.getSource();
        jTextComponent.requestFocus();

        boolean enableUndo = undoManager.canUndo();
        boolean enableRedo = undoManager.canRedo();
        boolean enableCut = false;
        boolean enableCopy = false;
        boolean enablePaste = false;
        boolean enableDelete = false;
        boolean enableSelectAll = false;

        String selectedText = jTextComponent.getSelectedText();
        String text = jTextComponent.getText();

        if (text != null)
        {
            if (text.length() > 0)
            {
                enableSelectAll = true;
            }
        }

        if (selectedText != null)
        {
            if (selectedText.length() > 0)
            {
                enableCut = true;
                enableCopy = true;
                enableDelete = true;
            }
        }

        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor) && jTextComponent.isEnabled())
        {
            enablePaste = true;
        }

        undo.setEnabled(enableUndo);
        redo.setEnabled(enableRedo);
        cut.setEnabled(enableCut);
        copy.setEnabled(enableCopy);
        paste.setEnabled(enablePaste);
        delete.setEnabled(enableDelete);
        selectAll.setEnabled(enableSelectAll);

        show(jTextComponent, event.getX(), event.getY());
    }
    }

DefaultContextMenu contextMenu = new DefaultContextMenu();

  static String prefRootNode = "/org/unito/HashChekerGUI";
   // Preferences
    public static Preferences getPreferences() {
        assert prefRootNode != null;
        Preferences root = Preferences.userRoot();
        return root.node(prefRootNode);
    } 

}
