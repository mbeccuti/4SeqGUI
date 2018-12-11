/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4seqgui;

import java.awt.CardLayout;
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
import static pkg4seqgui.DESPanel.dBatchesTrue;
import static pkg4seqgui.DESPanel.dCovComboBox;
import static pkg4seqgui.DESPanel.dFDRText;
import static pkg4seqgui.DESPanel.dFPKMfileText;
import static pkg4seqgui.DESPanel.dGeneRadioButton;
import static pkg4seqgui.DESPanel.dIsoformRadioButton;
import static pkg4seqgui.DESPanel.dLog2fcText;
import static pkg4seqgui.DESPanel.dOutputFolderText;
import static pkg4seqgui.FPKMPanel.FPKMFileTable;
import static pkg4seqgui.FPKMPanel.FtypesComboBox;
import static pkg4seqgui.IndexingBWAPanel.iGenomeURLBText;
import static pkg4seqgui.IndexingBWAPanel.iThreadBText;
import static pkg4seqgui.IndexingStarRSEM.iDockerRadioButton;
import static pkg4seqgui.IndexingStarRSEM.iThreadText;
import static pkg4seqgui.MACSPanel.MAdapter3Text;
import static pkg4seqgui.MACSPanel.MAdapter5Text;
import static pkg4seqgui.MACSPanel.MThreadText;
import static pkg4seqgui.MACSPanel.Tool;
import static pkg4seqgui.MRNABatchPanel.CCountHeaderTable;
import static pkg4seqgui.MRNAPanel.mAILLUMINARadioButton;
import static pkg4seqgui.MRNAPanel.mANEBRadioButton;
import static pkg4seqgui.MRNAPanel.mDFalseRadioButton;
import static pkg4seqgui.MRNAPanel.mDTrueRadioButton;
import static pkg4seqgui.MRNAPanel.mDockerRadioButton;
import static pkg4seqgui.MRNAPanel.mFastQFolderText;
import static pkg4seqgui.MRNAPanel.mOutputFolderText;
import static pkg4seqgui.MRNAPanel.mSudoRadioButton;
import static pkg4seqgui.MRNAPanel.mTFalseRadioButton;
import static pkg4seqgui.MRNAPanel.mTTrueRadioButton;
import static pkg4seqgui.MRNAPanel.mmiRBaseText;
import static pkg4seqgui.VmRNA.vAdapter3Text;
import static pkg4seqgui.VmRNA.vAdapter5Text;
import static pkg4seqgui.VmRNA.vBAMnoLRadioButton;
import static pkg4seqgui.VmRNA.vBAMyesRadioButton;
import static pkg4seqgui.VmRNA.vDockerRadioButton;
import static pkg4seqgui.VmRNA.vFastQFolderText;
import static pkg4seqgui.VmRNA.vGenomeFolderText;
import static pkg4seqgui.VmRNA.vMinLengthText;
import static pkg4seqgui.VmRNA.vOrganismText;
import static pkg4seqgui.VmRNA.vOutputFolderText;
import static pkg4seqgui.VmRNA.vPeRadioButton;
import static pkg4seqgui.VmRNA.vSForwardRadioButton;
import static pkg4seqgui.VmRNA.vSNoneRadioButton;
import static pkg4seqgui.VmRNA.vSReverseRadioButton;
import static pkg4seqgui.VmRNA.vSeRadioButton;
import static pkg4seqgui.VmRNA.vSudoRadioButton;
import static pkg4seqgui.VmRNA.vThreadText;
import static pkg4seqgui.PCAPanel.pComponent1Text;
import static pkg4seqgui.PCAPanel.pComponent2Text;

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
                

        //ADDING PANEL
        MultiQC MQC= new MultiQC();
        MultiQC.setViewportView(MQC);
        HeatmapPanel HPP= new HeatmapPanel();
        Heatmap.setViewportView(HPP);
        ANOVApanel ANV= new ANOVApanel();
        ANOVAlike.setViewportView(ANV);
        FilterCountsPanel FCT= new FilterCountsPanel();
        filterCounts.setViewportView(FCT);
        CountingSalmon CTS= new CountingSalmon();
        countingSalmon.setViewportView(CTS);
        IndexingSalmon IS = new IndexingSalmon();
        indexingSalmon.setViewportView(IS);
            IndexingStarRSEM ISR = new IndexingStarRSEM();
        indexingStarRSEM.setViewportView(ISR);      
        MRNAPanel MRNAP = new MRNAPanel();
        mRNA.setViewportView(MRNAP);
        FPKMPanel FPKM = new FPKMPanel();
        fPKMPanel.setViewportView(FPKM);
        VmRNA VMR = new VmRNA();
        vmRNA.setViewportView(VMR);
        PCAPanel PP = new PCAPanel();
        pCAPanel.setViewportView(PP);
        DESPanel DP = new DESPanel();
        dESPanel.setViewportView(DP);
        IndexingBWAPanel IBWAP = new IndexingBWAPanel();
        indexingBWAPanel.setViewportView(IBWAP);
        MACSPanel MACSP = new MACSPanel();
        mACSPanel.setViewportView(MACSP);
        SampleSizePanel SSP = new SampleSizePanel();
        sampleSizePanel.setViewportView(SSP);
        
        ExperimentPowerPanel EPP = new ExperimentPowerPanel();
        experimentPowerPanel.setViewportView(EPP);
        
        MRNABatchPanel MBP = new MRNABatchPanel();
        mRNABatchPanel.setViewportView(MBP);
        
        S_IndropIndex SII = new S_IndropIndex();
        S_indropIndex.setViewportView(SII);
        
        S_IndropCounts SIC = new S_IndropCounts();
        S_indropCounts.setViewportView(SIC);
        
        S_CellRanger CR = new S_CellRanger();
        S_cellRanger.setViewportView(CR);
        
        S_FilterZeros FZ = new S_FilterZeros();
        S_filterZeros.setViewportView(FZ);
        
              S_GenesUmi GU = new S_GenesUmi();
        S_genesUmi.setViewportView(GU);
        
        S_TopX TPX = new S_TopX();
        S_topX.setViewportView(TPX);
        
        S_LorenzFilter LF = new S_LorenzFilter();
        S_lorenzFilter.setViewportView(LF);
        
        S_ScannoByGtf SBG = new S_ScannoByGtf();
        S_scannoByGtf.setViewportView(SBG);
        
        S_CountDepth CD = new S_CountDepth();
        S_countDepth.setViewportView(CD);
        
        S_Scnorm Scn = new S_Scnorm();
        S_scnorm.setViewportView(Scn);
        
        S_UmiNorm UN= new S_UmiNorm();
        S_umiNorm.setViewportView(UN);
        
        S_Counts2Log C2L = new S_Counts2Log();
        S_counts2Log.setViewportView(C2L);
        
        S_RecatPrediction RP = new S_RecatPrediction();
        S_recatPrediction.setViewportView(RP);
        
        S_CcRemove CRV = new S_CcRemove();
        S_ccRemove.setViewportView(CRV);
        
        S_ClusterNgriph CNG = new S_ClusterNgriph();
        S_clusterNgriph.setViewportView(CNG);

        S_SimlrBootstrap SBTS = new S_SimlrBootstrap();
        S_simlrBootstrap.setViewportView(SBTS);
        
        S_BootstrapsVideo BV = new S_BootstrapsVideo();
        S_bootstrapsVideo.setViewportView(BV);
        
        S_SeuratPCAEval SPE = new S_SeuratPCAEval();
        S_seuratPCAEval.setViewportView(SPE);
        
        S_SeuratBootstrap SBT = new S_SeuratBootstrap();
        S_seuratBootstrap.setViewportView(SBT);
        
        S_TsneBootstrap TB = new S_TsneBootstrap();
        S_tsneBootstrap.setViewportView(TB);

        S_AnovaLike AL = new S_AnovaLike();
        S_anovaLike.setViewportView(AL);
        
        S_ClustersFeatures CF = new S_ClustersFeatures();
        S_clustersFeatures.setViewportView(CF);
        
        S_Hfc HFC = new S_Hfc();
        S_hfc.setViewportView(HFC);
        
        S_GenesPrioritization GPR = new S_GenesPrioritization();
        S_genesPrioritization.setViewportView(GPR);
        
        S_GenesSelection GS = new S_GenesSelection();
        S_genesSelection.setViewportView(GS);
        
        S_SeuratPrior SP= new S_SeuratPrior();
        S_seuratPrior.setViewportView(SP);


        circRNA_ciri2.setViewportView(new CircRNAWrapperCiriPanel());
        circRNA_postprocessing.setViewportView(new CircRNAClassificationPanel());
        circRNA_BSJunctions.setViewportView(new CircRNABSJunctionsPanel());
        circRNA_quantification.setViewportView(new CircRNAQuantificationPanel());
        circRNA_annotation.setViewportView(new CircRNAAnnotationPanel());
        circRNA_structure.setViewportView(new CircRNAPredictStructurePanel());
        circRNA_starPrediction.setViewportView(new CircRNAStarPrediction());
        circRNA_starChimeric.setViewportView(new CircRNAStarChimeric());
        circRNA_prepareExonIsoformFiles.setViewportView(new CircRNADownloadData());
        circRNA_mergeCiri2Samples.setViewportView(new CircRNAMergeSamples());
//ADDING PANEL

        
        //adding here all the textarea that must be maneged with right button mouse
        
        //vRNAPanel
        contextMenu.add(vThreadText);
        contextMenu.add(vAdapter5Text);
        contextMenu.add(vAdapter3Text);
        contextMenu.add(vMinLengthText);
        contextMenu.add(vOrganismText);
        //indexingSTARPanel

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
        //countingSalmon

        //filterCountMainFrame.

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
        OutputFrame = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        OutputText = new javax.swing.JTextArea();
        CloseOutput = new javax.swing.JToggleButton();
        ReloadOutput = new javax.swing.JToggleButton();
        RemoveOutput = new javax.swing.JButton();
        DlogButton = new javax.swing.JButton();
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        MExecution = new javax.swing.ButtonGroup();
        MSeq = new javax.swing.ButtonGroup();
        MRemoveDuplicates = new javax.swing.ButtonGroup();
        BatchComboBox = new javax.swing.JComboBox<>();
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jButton9 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        VerticalSplitPanel = new javax.swing.JSplitPane();
        BottomPanel = new javax.swing.JPanel();
        ProcStatusPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcList = new javax.swing.JList<>();
        HorizontalSplitPanel = new javax.swing.JSplitPane();
        MainPanel = new javax.swing.JPanel();
        Empty = new javax.swing.JScrollPane();
        EmptyPanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        indexingStarRSEM = new javax.swing.JScrollPane();
        mRNA = new javax.swing.JScrollPane();
        fPKMPanel = new javax.swing.JScrollPane();
        vmRNA = new javax.swing.JScrollPane();
        pCAPanel = new javax.swing.JScrollPane();
        dESPanel = new javax.swing.JScrollPane();
        indexingBWAPanel = new javax.swing.JScrollPane();
        mACSPanel = new javax.swing.JScrollPane();
        sampleSizePanel = new javax.swing.JScrollPane();
        experimentPowerPanel = new javax.swing.JScrollPane();
        mRNABatchPanel = new javax.swing.JScrollPane();
        indexingSalmon = new javax.swing.JScrollPane();
        countingSalmon = new javax.swing.JScrollPane();
        filterCounts = new javax.swing.JScrollPane();
        MultiQC = new javax.swing.JScrollPane();
        Heatmap = new javax.swing.JScrollPane();
        ANOVAlike = new javax.swing.JScrollPane();
        Test = new javax.swing.JScrollPane();
        S_indropIndex = new javax.swing.JScrollPane();
        S_indropCounts = new javax.swing.JScrollPane();
        S_cellRanger = new javax.swing.JScrollPane();
        S_filterZeros = new javax.swing.JScrollPane();
        S_genesUmi = new javax.swing.JScrollPane();
        S_topX = new javax.swing.JScrollPane();
        S_lorenzFilter = new javax.swing.JScrollPane();
        S_scannoByGtf = new javax.swing.JScrollPane();
        S_countDepth = new javax.swing.JScrollPane();
        S_scnorm = new javax.swing.JScrollPane();
        S_umiNorm = new javax.swing.JScrollPane();
        S_counts2Log = new javax.swing.JScrollPane();
        S_recatPrediction = new javax.swing.JScrollPane();
        S_ccRemove = new javax.swing.JScrollPane();
        S_clusterNgriph = new javax.swing.JScrollPane();
        S_simlrBootstrap = new javax.swing.JScrollPane();
        S_bootstrapsVideo = new javax.swing.JScrollPane();
        S_seuratPCAEval = new javax.swing.JScrollPane();
        S_seuratBootstrap = new javax.swing.JScrollPane();
        S_tsneBootstrap = new javax.swing.JScrollPane();
        S_anovaLike = new javax.swing.JScrollPane();
        S_clustersFeatures = new javax.swing.JScrollPane();
        S_hfc = new javax.swing.JScrollPane();
        S_seuratPrior = new javax.swing.JScrollPane();
        S_genesPrioritization = new javax.swing.JScrollPane();
        S_genesSelection = new javax.swing.JScrollPane();
        circRNA_ciri2 = new javax.swing.JScrollPane();
        circRNA_postprocessing = new javax.swing.JScrollPane();
        circRNA_BSJunctions = new javax.swing.JScrollPane();
        circRNA_annotation = new javax.swing.JScrollPane();
        circRNA_structure = new javax.swing.JScrollPane();
        circRNA_quantification = new javax.swing.JScrollPane();
        circRNA_starPrediction = new javax.swing.JScrollPane();
        circRNA_starChimeric = new javax.swing.JScrollPane();
        circRNA_prepareExonIsoformFiles = new javax.swing.JScrollPane();
        circRNA_mergeCiri2Samples = new javax.swing.JScrollPane();
        LeftPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
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
        CircRNAPanel = new javax.swing.JPanel();
        SubPreductionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ChipSeqPanel = new javax.swing.JPanel();
        indexingBButton = new javax.swing.JButton();
        CountButton2 = new javax.swing.JButton();
        ToolPanel = new javax.swing.JPanel();
        MultiQCButton = new javax.swing.JButton();
        HeatmapButton = new javax.swing.JButton();
        SingleCellPanel = new javax.swing.JTabbedPane();
        S_CountsGeneration = new javax.swing.JPanel();
        S_IndropIndex = new javax.swing.JButton();
        S_CellRangerCount = new javax.swing.JButton();
        S_IndropCounts = new javax.swing.JButton();
        S_CountsManipulation = new javax.swing.JPanel();
        S_CCRemove = new javax.swing.JButton();
        S_ScannoByGtf = new javax.swing.JButton();
        S_UmiNorm = new javax.swing.JButton();
        S_ScNorm = new javax.swing.JButton();
        S_FilterZeros = new javax.swing.JButton();
        S_TopX = new javax.swing.JButton();
        S_LorenzFilter = new javax.swing.JButton();
        S_GenesUmi = new javax.swing.JButton();
        S_Counts2Log1 = new javax.swing.JButton();
        S_RecatPrediction = new javax.swing.JButton();
        S_checkCountDepth = new javax.swing.JButton();
        S_Clustering = new javax.swing.JPanel();
        S_simlrBootstrapButton = new javax.swing.JButton();
        S_bootstrapVideoButton = new javax.swing.JButton();
        S_clusteringNgriphButton = new javax.swing.JButton();
        S_SeuratPCAEvalButton = new javax.swing.JButton();
        S_SeuratBootstrapButton = new javax.swing.JButton();
        S_TsneBootstrapButton = new javax.swing.JButton();
        S_FeatureSelection = new javax.swing.JPanel();
        S_HFCButton = new javax.swing.JButton();
        S_GenesSelection = new javax.swing.JButton();
        S_AnovaLikeButton = new javax.swing.JButton();
        S_genesPrioritizationButton = new javax.swing.JButton();
        S_ClustersFeatureButton = new javax.swing.JButton();
        S_SeuratPriorButton = new javax.swing.JButton();
        CircRNATabPanel = new javax.swing.JTabbedPane();
        PredictionPanel = new javax.swing.JPanel();
        Ciri2PredictionButton = new javax.swing.JButton();
        StarchipCircleButton = new javax.swing.JButton();
        StarChimericButton = new javax.swing.JButton();
        Ciri2MergeResultsButton = new javax.swing.JButton();
        ClassificationPanel = new javax.swing.JPanel();
        CirchunterClassificButton = new javax.swing.JButton();
        circRNAAnnotationButton = new javax.swing.JButton();
        downloadExonIsoformDataButton = new javax.swing.JButton();
        SequenceAnalysisPanel = new javax.swing.JPanel();
        CirchunterJunctionsButton = new javax.swing.JButton();
        CiriAS_StructureButton = new javax.swing.JButton();
        ExpressionAnalysisPanel = new javax.swing.JPanel();
        HashcircQuantifButton = new javax.swing.JButton();
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select a subset of Images (Optional)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 102, 51))); // NOI18N
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        BottomPanel.add(ProcStatusPanel, gridBagConstraints);

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

        indexingStarRSEM.setBorder(null);
        MainPanel.add(indexingStarRSEM, "indexing");

        mRNA.setBorder(null);
        MainPanel.add(mRNA, "mRNA");

        fPKMPanel.setBorder(null);
        MainPanel.add(fPKMPanel, "FPKMCounting");

        vmRNA.setBorder(null);
        MainPanel.add(vmRNA, "vmRNA");

        pCAPanel.setBorder(null);
        MainPanel.add(pCAPanel, "PCA");

        dESPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MainPanel.add(dESPanel, "DES");

        indexingBWAPanel.setBorder(null);
        MainPanel.add(indexingBWAPanel, "indexingB");

        mACSPanel.setBorder(null);
        MainPanel.add(mACSPanel, "MACS");

        sampleSizePanel.setBorder(null);
        MainPanel.add(sampleSizePanel, "SampleSize");

        experimentPowerPanel.setBorder(null);
        MainPanel.add(experimentPowerPanel, "ExperimentPower");

        mRNABatchPanel.setBorder(null);
        MainPanel.add(mRNABatchPanel, "AddingCovmRNA");

        indexingSalmon.setBorder(null);
        MainPanel.add(indexingSalmon, "indexingSalmon");

        countingSalmon.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MainPanel.add(countingSalmon, "countingSalmon");

        filterCounts.setBorder(null);
        MainPanel.add(filterCounts, "filtercounts");
        MainPanel.add(MultiQC, "multiqc");
        MainPanel.add(Heatmap, "heatmap");
        MainPanel.add(ANOVAlike, "NOVAlike");
        MainPanel.add(Test, "test");
        MainPanel.add(S_indropIndex, "S_indropIndexCard");
        S_indropIndex.getAccessibleContext().setAccessibleName("");

        MainPanel.add(S_indropCounts, "S_indropCountsCard");
        MainPanel.add(S_cellRanger, "S_cellRangerCard");
        MainPanel.add(S_filterZeros, "S_filterZerosCard");
        MainPanel.add(S_genesUmi, "S_genesUmiCard");
        MainPanel.add(S_topX, "S_topXCard");
        MainPanel.add(S_lorenzFilter, "S_lorenzFilterCard");
        MainPanel.add(S_scannoByGtf, "S_scannoByGtfCard");
        MainPanel.add(S_countDepth, "S_countDepthCard");
        MainPanel.add(S_scnorm, "S_scnormCard");
        MainPanel.add(S_umiNorm, "S_umiNormCard");
        MainPanel.add(S_counts2Log, "S_counts2LogCard");
        MainPanel.add(S_recatPrediction, "S_recatPredictionCard");
        MainPanel.add(S_ccRemove, "S_ccRemoveCard");
        MainPanel.add(S_clusterNgriph, "clusterNgriphCard");
        MainPanel.add(S_simlrBootstrap, "simlrBootstrapCard");
        MainPanel.add(S_bootstrapsVideo, "S_bootstrapsVideoCard");
        MainPanel.add(S_seuratPCAEval, "S_seuratPCAEvalCard");
        MainPanel.add(S_seuratBootstrap, "S_seuratBootstrapCard");
        MainPanel.add(S_tsneBootstrap, "S_tsneBootstrapCard");
        MainPanel.add(S_anovaLike, "S_anovaLikeCard");
        MainPanel.add(S_clustersFeatures, "S_clustersFeaturesCard");
        MainPanel.add(S_hfc, "S_hfcCard");
        MainPanel.add(S_seuratPrior, "S_seuratPriorCard");
        MainPanel.add(S_genesPrioritization, "S_genesPrioritizationCard");
        MainPanel.add(S_genesSelection, "S_genesSelectionCard");
        MainPanel.add(circRNA_ciri2, "wrapperCiriCard");
        MainPanel.add(circRNA_postprocessing, "circRNA_ppCard");
        MainPanel.add(circRNA_BSJunctions, "bsjunctionsCard");
        MainPanel.add(circRNA_annotation, "circrnaAnnotationCard");
        MainPanel.add(circRNA_structure, "circrnaStructureCard");
        MainPanel.add(circRNA_quantification, "circrnaquantifCard");
        MainPanel.add(circRNA_starPrediction, "circrnaStarPrediction");
        MainPanel.add(circRNA_starChimeric, "circrnaStarChimeric");
        MainPanel.add(circRNA_prepareExonIsoformFiles, "circrnaPrepareFilesCard");
        MainPanel.add(circRNA_mergeCiri2Samples, "circrnaMergeCiri2ResultsCard");

        HorizontalSplitPanel.setRightComponent(MainPanel);

        LeftPanel.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);

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

        CircRNAPanel.setLayout(new java.awt.GridBagLayout());

        SubPreductionPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubPreductionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "Prediction"));

        javax.swing.GroupLayout SubPreductionPanelLayout = new javax.swing.GroupLayout(SubPreductionPanel);
        SubPreductionPanel.setLayout(SubPreductionPanelLayout);
        SubPreductionPanelLayout.setHorizontalGroup(
            SubPreductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        SubPreductionPanelLayout.setVerticalGroup(
            SubPreductionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        CircRNAPanel.add(SubPreductionPanel, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(204, 204, 204)), "Classification  and Annotation")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        CircRNAPanel.add(jPanel3, gridBagConstraints);

        jTabbedPane1.addTab("CircRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png")), CircRNAPanel); // NOI18N

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
        gridBagConstraints.gridy = 1;
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
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(HeatmapButton, gridBagConstraints);

        jTabbedPane1.addTab("Tools", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/tooltab.png")), ToolPanel); // NOI18N

        SingleCellPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        S_CountsGeneration.setBackground(new java.awt.Color(255, 255, 255));
        S_CountsGeneration.setLayout(new java.awt.GridBagLayout());

        S_IndropIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        S_IndropIndex.setText("Indrop Index");
        S_IndropIndex.setToolTipText("");
        S_IndropIndex.setBorder(null);
        S_IndropIndex.setBorderPainted(false);
        S_IndropIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_IndropIndexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_CountsGeneration.add(S_IndropIndex, gridBagConstraints);

        S_CellRangerCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        S_CellRangerCount.setText("Cell Ranger count");
        S_CellRangerCount.setBorder(null);
        S_CellRangerCount.setBorderPainted(false);
        S_CellRangerCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_CellRangerCountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_CountsGeneration.add(S_CellRangerCount, gridBagConstraints);

        S_IndropCounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_IndropCounts.setText("Indrop Counts");
        S_IndropCounts.setBorder(null);
        S_IndropCounts.setBorderPainted(false);
        S_IndropCounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_IndropCountsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsGeneration.add(S_IndropCounts, gridBagConstraints);

        SingleCellPanel.addTab("Counts Generation", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), S_CountsGeneration); // NOI18N

        S_CountsManipulation.setBackground(new java.awt.Color(255, 255, 255));
        S_CountsManipulation.setLayout(new java.awt.GridBagLayout());

        S_CCRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        S_CCRemove.setText("CC Remove");
        S_CCRemove.setBorder(null);
        S_CCRemove.setBorderPainted(false);
        S_CCRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_CCRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_CountsManipulation.add(S_CCRemove, gridBagConstraints);

        S_ScannoByGtf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        S_ScannoByGtf.setText("ScannoByGtf");
        S_ScannoByGtf.setToolTipText("");
        S_ScannoByGtf.setBorder(null);
        S_ScannoByGtf.setBorderPainted(false);
        S_ScannoByGtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_ScannoByGtfActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_CountsManipulation.add(S_ScannoByGtf, gridBagConstraints);

        S_UmiNorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_UmiNorm.setText("UmiNorm");
        S_UmiNorm.setBorder(null);
        S_UmiNorm.setBorderPainted(false);
        S_UmiNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_UmiNormActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_UmiNorm, gridBagConstraints);

        S_ScNorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_ScNorm.setText("ScNorm");
        S_ScNorm.setBorder(null);
        S_ScNorm.setBorderPainted(false);
        S_ScNorm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_ScNormActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_ScNorm, gridBagConstraints);

        S_FilterZeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_FilterZeros.setText("Filter Zeros");
        S_FilterZeros.setBorder(null);
        S_FilterZeros.setBorderPainted(false);
        S_FilterZeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_FilterZerosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_FilterZeros, gridBagConstraints);

        S_TopX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_TopX.setText("topX");
        S_TopX.setBorder(null);
        S_TopX.setBorderPainted(false);
        S_TopX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_TopXActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_TopX, gridBagConstraints);

        S_LorenzFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_LorenzFilter.setText("Lorenz Filter");
        S_LorenzFilter.setBorder(null);
        S_LorenzFilter.setBorderPainted(false);
        S_LorenzFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_LorenzFilterActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_LorenzFilter, gridBagConstraints);

        S_GenesUmi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_GenesUmi.setText("Genes Umi");
        S_GenesUmi.setBorder(null);
        S_GenesUmi.setBorderPainted(false);
        S_GenesUmi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_GenesUmiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_GenesUmi, gridBagConstraints);

        S_Counts2Log1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_Counts2Log1.setText("Counts 2 Log");
        S_Counts2Log1.setBorder(null);
        S_Counts2Log1.setBorderPainted(false);
        S_Counts2Log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_Counts2Log1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_Counts2Log1, gridBagConstraints);

        S_RecatPrediction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_RecatPrediction.setText("Recat Prediction");
        S_RecatPrediction.setBorder(null);
        S_RecatPrediction.setBorderPainted(false);
        S_RecatPrediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_RecatPredictionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_RecatPrediction, gridBagConstraints);

        S_checkCountDepth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_checkCountDepth.setText("Count Depth");
        S_checkCountDepth.setBorder(null);
        S_checkCountDepth.setBorderPainted(false);
        S_checkCountDepth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_checkCountDepthActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_CountsManipulation.add(S_checkCountDepth, gridBagConstraints);

        SingleCellPanel.addTab("Counts Manipulation", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), S_CountsManipulation); // NOI18N

        S_Clustering.setBackground(new java.awt.Color(255, 255, 255));
        S_Clustering.setLayout(new java.awt.GridBagLayout());

        S_simlrBootstrapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_simlrBootstrapButton.setText("simlrBootstrap");
        S_simlrBootstrapButton.setBorder(null);
        S_simlrBootstrapButton.setBorderPainted(false);
        S_simlrBootstrapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_simlrBootstrapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_Clustering.add(S_simlrBootstrapButton, gridBagConstraints);

        S_bootstrapVideoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        S_bootstrapVideoButton.setText("Bootstrap Video");
        S_bootstrapVideoButton.setBorder(null);
        S_bootstrapVideoButton.setBorderPainted(false);
        S_bootstrapVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_bootstrapVideoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_Clustering.add(S_bootstrapVideoButton, gridBagConstraints);

        S_clusteringNgriphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        S_clusteringNgriphButton.setText("clusteringNgriph");
        S_clusteringNgriphButton.setToolTipText("");
        S_clusteringNgriphButton.setBorder(null);
        S_clusteringNgriphButton.setBorderPainted(false);
        S_clusteringNgriphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_clusteringNgriphButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_Clustering.add(S_clusteringNgriphButton, gridBagConstraints);

        S_SeuratPCAEvalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_SeuratPCAEvalButton.setText("Seurat PCA Eval");
        S_SeuratPCAEvalButton.setBorder(null);
        S_SeuratPCAEvalButton.setBorderPainted(false);
        S_SeuratPCAEvalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_SeuratPCAEvalButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_Clustering.add(S_SeuratPCAEvalButton, gridBagConstraints);

        S_SeuratBootstrapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_SeuratBootstrapButton.setText("Seurat Bootstrap");
        S_SeuratBootstrapButton.setBorder(null);
        S_SeuratBootstrapButton.setBorderPainted(false);
        S_SeuratBootstrapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_SeuratBootstrapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_Clustering.add(S_SeuratBootstrapButton, gridBagConstraints);

        S_TsneBootstrapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_TsneBootstrapButton.setText("Tsne Bootstrap");
        S_TsneBootstrapButton.setBorder(null);
        S_TsneBootstrapButton.setBorderPainted(false);
        S_TsneBootstrapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_TsneBootstrapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_Clustering.add(S_TsneBootstrapButton, gridBagConstraints);

        SingleCellPanel.addTab("Clustering", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), S_Clustering); // NOI18N

        S_FeatureSelection.setBackground(new java.awt.Color(255, 255, 255));
        S_FeatureSelection.setLayout(new java.awt.GridBagLayout());

        S_HFCButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_HFCButton.setText("HFC");
        S_HFCButton.setBorder(null);
        S_HFCButton.setBorderPainted(false);
        S_HFCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_HFCButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_FeatureSelection.add(S_HFCButton, gridBagConstraints);

        S_GenesSelection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        S_GenesSelection.setText("Genes Selection SIMLR");
        S_GenesSelection.setBorder(null);
        S_GenesSelection.setBorderPainted(false);
        S_GenesSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_GenesSelectionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_FeatureSelection.add(S_GenesSelection, gridBagConstraints);

        S_AnovaLikeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        S_AnovaLikeButton.setText("Anova Like");
        S_AnovaLikeButton.setToolTipText("");
        S_AnovaLikeButton.setBorder(null);
        S_AnovaLikeButton.setBorderPainted(false);
        S_AnovaLikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_AnovaLikeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        S_FeatureSelection.add(S_AnovaLikeButton, gridBagConstraints);

        S_genesPrioritizationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_genesPrioritizationButton.setText("Genes Prioritization SIMLR");
        S_genesPrioritizationButton.setBorder(null);
        S_genesPrioritizationButton.setBorderPainted(false);
        S_genesPrioritizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_genesPrioritizationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_FeatureSelection.add(S_genesPrioritizationButton, gridBagConstraints);

        S_ClustersFeatureButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_ClustersFeatureButton.setText("Clusters Features");
        S_ClustersFeatureButton.setBorder(null);
        S_ClustersFeatureButton.setBorderPainted(false);
        S_ClustersFeatureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_ClustersFeatureButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_FeatureSelection.add(S_ClustersFeatureButton, gridBagConstraints);

        S_SeuratPriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        S_SeuratPriorButton.setText("Seurat Prior");
        S_SeuratPriorButton.setBorder(null);
        S_SeuratPriorButton.setBorderPainted(false);
        S_SeuratPriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_SeuratPriorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        S_FeatureSelection.add(S_SeuratPriorButton, gridBagConstraints);

        SingleCellPanel.addTab("Feature Selection", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), S_FeatureSelection); // NOI18N

        jTabbedPane1.addTab("Single Cell", SingleCellPanel);

        CircRNATabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        PredictionPanel.setBackground(new java.awt.Color(255, 255, 255));
        PredictionPanel.setLayout(new java.awt.GridBagLayout());

        Ciri2PredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNA.png"))); // NOI18N
        Ciri2PredictionButton.setText("BWA+CIRI2");
        Ciri2PredictionButton.setBorder(null);
        Ciri2PredictionButton.setBorderPainted(false);
        Ciri2PredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ciri2PredictionButtonActionPerformed(evt);
            }
        });
        PredictionPanel.add(Ciri2PredictionButton, new java.awt.GridBagConstraints());

        StarchipCircleButton.setText("STARChip Circle");
        StarchipCircleButton.setBorder(null);
        StarchipCircleButton.setBorderPainted(false);
        StarchipCircleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StarchipCircleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(StarchipCircleButton, gridBagConstraints);

        StarChimericButton.setText("STAR Chimeric");
        StarChimericButton.setBorder(null);
        StarChimericButton.setBorderPainted(false);
        StarChimericButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StarChimericButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(StarChimericButton, gridBagConstraints);

        Ciri2MergeResultsButton.setText("Merge CIRI2 stuff");
        Ciri2MergeResultsButton.setBorder(null);
        Ciri2MergeResultsButton.setBorderPainted(false);
        Ciri2MergeResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ciri2MergeResultsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(Ciri2MergeResultsButton, gridBagConstraints);

        CircRNATabPanel.addTab("Prediction", PredictionPanel);

        ClassificationPanel.setBackground(new java.awt.Color(255, 255, 255));
        ClassificationPanel.setLayout(new java.awt.GridBagLayout());

        CirchunterClassificButton.setText("CircHunter classification");
        CirchunterClassificButton.setBorder(null);
        CirchunterClassificButton.setBorderPainted(false);
        CirchunterClassificButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CirchunterClassificButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ClassificationPanel.add(CirchunterClassificButton, gridBagConstraints);

        circRNAAnnotationButton.setText("Annotation");
        circRNAAnnotationButton.setBorder(null);
        circRNAAnnotationButton.setBorderPainted(false);
        circRNAAnnotationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circRNAAnnotationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ClassificationPanel.add(circRNAAnnotationButton, gridBagConstraints);

        downloadExonIsoformDataButton.setText("Download Exon and Isoform Data");
        downloadExonIsoformDataButton.setBorder(null);
        downloadExonIsoformDataButton.setBorderPainted(false);
        downloadExonIsoformDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadExonIsoformDataButtonActionPerformed(evt);
            }
        });
        ClassificationPanel.add(downloadExonIsoformDataButton, new java.awt.GridBagConstraints());

        CircRNATabPanel.addTab("Classification and Annotation", ClassificationPanel);

        SequenceAnalysisPanel.setBackground(new java.awt.Color(255, 255, 255));
        SequenceAnalysisPanel.setLayout(new java.awt.GridBagLayout());

        CirchunterJunctionsButton.setText("Back-splicing Junctions");
        CirchunterJunctionsButton.setBorder(null);
        CirchunterJunctionsButton.setBorderPainted(false);
        CirchunterJunctionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CirchunterJunctionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SequenceAnalysisPanel.add(CirchunterJunctionsButton, gridBagConstraints);

        CiriAS_StructureButton.setText("Predict Structure");
        CiriAS_StructureButton.setBorder(null);
        CiriAS_StructureButton.setBorderPainted(false);
        CiriAS_StructureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiriAS_StructureButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SequenceAnalysisPanel.add(CiriAS_StructureButton, gridBagConstraints);

        CircRNATabPanel.addTab("Sequence Analysis", SequenceAnalysisPanel);

        ExpressionAnalysisPanel.setBackground(new java.awt.Color(255, 255, 255));
        ExpressionAnalysisPanel.setLayout(new java.awt.GridBagLayout());

        HashcircQuantifButton.setText("Quantification");
        HashcircQuantifButton.setBorder(null);
        HashcircQuantifButton.setBorderPainted(false);
        HashcircQuantifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HashcircQuantifButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExpressionAnalysisPanel.add(HashcircQuantifButton, gridBagConstraints);

        CircRNATabPanel.addTab("Expression Analysis", ExpressionAnalysisPanel);

        jTabbedPane1.addTab("CircRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png")), CircRNATabPanel); // NOI18N

        jScrollPane1.setViewportView(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        LeftPanel.add(jScrollPane1, gridBagConstraints);

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
   
        public static final Pattern adapter = Pattern.compile("[acgtACGT]+"
);
        
        public static final Pattern org = Pattern.compile("[a-zA-Z0-9]+"
);
    
        public static final Pattern miRBase = Pattern.compile("[a-zA-Z0-9]{3,3}"
);
        
        
                
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
    
    
      public void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
      
         
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
                                if ("indexing".equals(CurrentLayout)){/*
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
                                */}
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
                                            /*
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
                                        */
                                        }
                                        else
                                            if("DES".equals(CurrentLayout)){/*
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
                                                */
                                            }
                                            else
                                                if ("indexingB".equals(CurrentLayout)){/*
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
                                                */}
                                                else
                                                    if ("MACS".equals(CurrentLayout)){
                                                        /*
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
                                                    */}
                                                    else
                                                        if("SampleSize".equals(CurrentLayout)){
                                                            /*
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
                                                        
                                                        */}
                                                        else
                                                            if("ExperimentPower".equals(CurrentLayout)){/*
                                                                
                                                                
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
                                                                */
                                                            }
                                                            else
                                                                if("AddingCovmRNA".equals(CurrentLayout)){/*
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
                                                                */
                                                                }
                                                                else
                                                                    if ("indexingSalmon".equals(CurrentLayout)){/*
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
                                                                        }*/
                                                                    }
                                                                    else
                                                                        if ("countingSalmon".equals(CurrentLayout)){/*
                                                                            
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
                                                                            }*/
                                                                        }
                                                                        else
                                                                            if("filtercounts".equals(CurrentLayout)){/*
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
                                                                                }*/
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
    
    public void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
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
                                if ("indexing".equals(CurrentLayout)){/*
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
                                    bw.write(iGTFURLText.getText());*/
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
                                        if("PCA".equals(CurrentLayout)){/*
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
                                            bw.write(pOutputFolderText.getText());*/
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
                                                if ("indexingB".equals(CurrentLayout)){/*
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
                                               */ }
                                                else
                                                    if ("MACS".equals(CurrentLayout)){
                                                        /*
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
                                                    */
                                                    }else
                                                        if("SampleSize".equals(CurrentLayout)){
                                                            /*
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
                                                            */
                                                        }
                                                        else
                                                            if("ExperimentPower".equals(CurrentLayout)){/*
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
                                                           */
                                                            }
                                                            else
                                                                if("AddingCovmRNA".equals(CurrentLayout)){/*
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
                                                                */
                                                                }
                                                                else
                                                                    if ("indexingSalmon".equals(CurrentLayout)){/*
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
                                                                        bw.write(iKmerSText.getText());*/
                                                                    }
                                                                    else
                                                                        if ("countingSalmon".equals(CurrentLayout)){/*
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
                                                                        */    
                                                                        }
                                                                        else
                                                                            if("filtercounts".equals(CurrentLayout)){/*
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
                                                                                bw.write(fOutputFolderText.getText());*/
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
        
        if (tmpListEntry.status.equals("Running") || tmpListEntry.status.equals("Finished")|| tmpListEntry.status.equals("Error")){ 
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
    OutputFrame.setVisible(false);        
    OutputText.setText("");
    OutputText.setEnabled(true);
    DlogButton.setEnabled(false);
    GL.setAvoidProcListValueChanged(-1);
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
        if (tmpListEntry.status.equals("Running") || tmpListEntry.status.equals("Finished")|| tmpListEntry.status.equals("Error")){
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

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DownloadMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
        CountingSalmon.cThreadText.setText(Integer.toString(GS.getDefaultThread()));
        CountingSalmon.cAdapter5Text.setText(GS.getDefaultAdapter5());
        CountingSalmon.cAdapter3Text.setText(GS.getDefaultAdapter3());
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
        IndexingSalmon.iThreadSText.setText(Integer.toString(GS.getDefaultThread()));
        card.show(MainPanel, "indexingSalmon");
        CurrentLayout="indexingSalmon";
    }//GEN-LAST:event_SalmonIndexingButtonActionPerformed

    private void HeatmapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatmapButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "heatmap");
        CurrentLayout="heatmap";
    }//GEN-LAST:event_HeatmapButtonActionPerformed

    private void ANOVAlikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANOVAlikeButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "NOVAlike");
        CurrentLayout="NOVAlike";
    }//GEN-LAST:event_ANOVAlikeButtonActionPerformed

    private void S_IndropIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_IndropIndexActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_indropIndexCard");
        CurrentLayout="S_indropIndexCard";
    }//GEN-LAST:event_S_IndropIndexActionPerformed

    private void S_CellRangerCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_CellRangerCountActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_cellRangerCard");
        CurrentLayout="S_cellRangerCard";

        // TODO add your handling code here:
    }//GEN-LAST:event_S_CellRangerCountActionPerformed

    private void S_IndropCountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_IndropCountsActionPerformed
   CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_indropCountsCard");
        CurrentLayout="S_indropCountsCard";
    }//GEN-LAST:event_S_IndropCountsActionPerformed

    private void S_CCRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_CCRemoveActionPerformed
  CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_ccRemoveCard");
        CurrentLayout="S_ccRemoveCard";
    }//GEN-LAST:event_S_CCRemoveActionPerformed

    private void S_ScannoByGtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_ScannoByGtfActionPerformed
   CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_scannoByGtfCard");
        CurrentLayout="S_scannoByGtfCard";

    }//GEN-LAST:event_S_ScannoByGtfActionPerformed

    private void S_simlrBootstrapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_simlrBootstrapButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "simlrBootstrapCard");
        CurrentLayout="simlrBootstrapCard";


    }//GEN-LAST:event_S_simlrBootstrapButtonActionPerformed

    private void S_bootstrapVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_bootstrapVideoButtonActionPerformed
                      CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_bootstrapsVideoCard");
        CurrentLayout="S_bootstrapsVideoCard";
    }//GEN-LAST:event_S_bootstrapVideoButtonActionPerformed

    private void S_clusteringNgriphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_clusteringNgriphButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "clusterNgriphCard");
        CurrentLayout="clusterNgriphCard";
    }//GEN-LAST:event_S_clusteringNgriphButtonActionPerformed

    private void S_HFCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_HFCButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_hfcCard");
        CurrentLayout="S_hfcCard";
    }//GEN-LAST:event_S_HFCButtonActionPerformed

    private void S_GenesSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_GenesSelectionActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_genesSelectionCard");
        CurrentLayout="S_genesSelectionCard";
    }//GEN-LAST:event_S_GenesSelectionActionPerformed

    private void S_AnovaLikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_AnovaLikeButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_anovaLikeCard");
        CurrentLayout="S_anovaLikeCard";

    }//GEN-LAST:event_S_AnovaLikeButtonActionPerformed

    private void S_UmiNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_UmiNormActionPerformed


CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_umiNormCard");
        CurrentLayout="S_umiNormCard";

    }//GEN-LAST:event_S_UmiNormActionPerformed

    private void S_ScNormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_ScNormActionPerformed

   CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_scnormCard");
        CurrentLayout="S_scnormCard";

    }//GEN-LAST:event_S_ScNormActionPerformed

    private void S_FilterZerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_FilterZerosActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_filterZerosCard");
        CurrentLayout="S_filterZerosCard";
    }//GEN-LAST:event_S_FilterZerosActionPerformed

    private void S_TopXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_TopXActionPerformed
         CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_topXCard");
        CurrentLayout="S_topXCard";
    }//GEN-LAST:event_S_TopXActionPerformed

    private void S_LorenzFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_LorenzFilterActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_lorenzFilterCard");
        CurrentLayout="S_lorenzFilterCard";    }//GEN-LAST:event_S_LorenzFilterActionPerformed

    private void S_GenesUmiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_GenesUmiActionPerformed

        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_genesUmiCard");
        CurrentLayout="S_genesUmiCard";
    }//GEN-LAST:event_S_GenesUmiActionPerformed

    private void S_Counts2Log1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_Counts2Log1ActionPerformed

 CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_counts2LogCard");
        CurrentLayout="S_counts2LogCard";

    }//GEN-LAST:event_S_Counts2Log1ActionPerformed

    private void S_RecatPredictionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_RecatPredictionActionPerformed

 CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_recatPredictionCard");
        CurrentLayout="S_recatPredictionCard";    }//GEN-LAST:event_S_RecatPredictionActionPerformed

    private void S_checkCountDepthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_checkCountDepthActionPerformed
   CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_countDepthCard");
        CurrentLayout="S_countDepthCard";
    }//GEN-LAST:event_S_checkCountDepthActionPerformed

    private void S_SeuratPCAEvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_SeuratPCAEvalButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_seuratPCAEvalCard");
        CurrentLayout="S_seuratPCAEvalCard";

    }//GEN-LAST:event_S_SeuratPCAEvalButtonActionPerformed

    private void S_SeuratBootstrapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_SeuratBootstrapButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_seuratBootstrapCard");
        CurrentLayout="S_seuratBootstrapCard";
    }//GEN-LAST:event_S_SeuratBootstrapButtonActionPerformed

    private void S_TsneBootstrapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_TsneBootstrapButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_tsneBootstrapCard");
        CurrentLayout="S_tsneBootstrapCard";
    }//GEN-LAST:event_S_TsneBootstrapButtonActionPerformed

    private void S_genesPrioritizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_genesPrioritizationButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_genesPrioritizationCard");
        CurrentLayout="S_genesPrioritizationCard";
        
    }//GEN-LAST:event_S_genesPrioritizationButtonActionPerformed

    private void S_ClustersFeatureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_ClustersFeatureButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_clustersFeaturesCard");
        CurrentLayout="S_clustersFeaturesCard";

    }//GEN-LAST:event_S_ClustersFeatureButtonActionPerformed

    private void S_SeuratPriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_SeuratPriorButtonActionPerformed
CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "S_seuratPriorCard");
        CurrentLayout="S_seuratPriorCard";
    }//GEN-LAST:event_S_SeuratPriorButtonActionPerformed

    private void Ciri2PredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ciri2PredictionButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "wrapperCiriCard");
        CurrentLayout="wrapperCiriCard";
    }//GEN-LAST:event_Ciri2PredictionButtonActionPerformed

    private void CirchunterClassificButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CirchunterClassificButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circRNA_ppCard");
        CurrentLayout="circRNA_ppCard";
    }//GEN-LAST:event_CirchunterClassificButtonActionPerformed

    private void circRNAAnnotationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circRNAAnnotationButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaAnnotationCard");
        CurrentLayout="circrnaAnnotationCard";
    }//GEN-LAST:event_circRNAAnnotationButtonActionPerformed

    private void CirchunterJunctionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CirchunterJunctionsButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "bsjunctionsCard");
        CurrentLayout="bsjunctionsCard";
    }//GEN-LAST:event_CirchunterJunctionsButtonActionPerformed

    private void CiriAS_StructureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiriAS_StructureButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaStructureCard");
        CurrentLayout="circrnaStructureCard";
    }//GEN-LAST:event_CiriAS_StructureButtonActionPerformed

    private void HashcircQuantifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HashcircQuantifButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaquantifCard");
        CurrentLayout="circrnaquantifCard";
    }//GEN-LAST:event_HashcircQuantifButtonActionPerformed

    private void StarchipCircleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StarchipCircleButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaStarPrediction");
        CurrentLayout="circrnaStarPrediction";
    }//GEN-LAST:event_StarchipCircleButtonActionPerformed

    private void StarChimericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StarChimericButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaStarChimeric");
        CurrentLayout="circrnaStarChimeric";
    }//GEN-LAST:event_StarChimericButtonActionPerformed

    private void downloadExonIsoformDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadExonIsoformDataButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaPrepareFilesCard");
        CurrentLayout="circrnaPrepareFilesCard";     
    }//GEN-LAST:event_downloadExonIsoformDataButtonActionPerformed

    private void Ciri2MergeResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ciri2MergeResultsButtonActionPerformed
        CardLayout card = (CardLayout)MainPanel.getLayout();
        card.show(MainPanel, "circrnaMergeCiri2ResultsCard");
        CurrentLayout="circrnaMergeCiri2ResultsCard";     
    }//GEN-LAST:event_Ciri2MergeResultsButtonActionPerformed
    
    
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
    private javax.swing.JScrollPane ANOVAlike;
    private javax.swing.JButton ANOVAlikeButton;
    private javax.swing.JFrame About4SeqGUIFrame;
    private javax.swing.JTextField Adapter3TextField;
    private javax.swing.JTextField Adapter5TextField;
    private javax.swing.JComboBox<String> BatchComboBox;
    public static javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel ChipSeqPanel;
    private javax.swing.JPanel CircRNAPanel;
    private javax.swing.JTabbedPane CircRNATabPanel;
    private javax.swing.JButton CirchunterClassificButton;
    private javax.swing.JButton CirchunterJunctionsButton;
    private javax.swing.JButton Ciri2MergeResultsButton;
    private javax.swing.JButton Ciri2PredictionButton;
    private javax.swing.JButton CiriAS_StructureButton;
    private javax.swing.JPanel ClassificationPanel;
    private javax.swing.JToggleButton CloseOutput;
    private javax.swing.JButton ConfCancell;
    public static javax.swing.JFrame ConfigurationFrame;
    private javax.swing.JButton CountButton;
    private javax.swing.JButton CountButton1;
    private javax.swing.JButton CountButton2;
    private javax.swing.JComboBox<String> CovComboBox;
    private javax.swing.JButton DeseqButton;
    private javax.swing.JButton DeseqButton2;
    private javax.swing.JButton DlogButton;
    private javax.swing.JFrame DownloadFrame;
    private javax.swing.JTextField Downloadtext;
    private javax.swing.JScrollPane Empty;
    private javax.swing.JPanel EmptyPanel;
    private javax.swing.JButton ExpPowerButton;
    private javax.swing.JButton ExpPowerButton1;
    private javax.swing.JPanel ExpressionAnalysisPanel;
    private javax.swing.JButton HashcircQuantifButton;
    private javax.swing.JScrollPane Heatmap;
    private javax.swing.JButton HeatmapButton;
    private javax.swing.JSplitPane HorizontalSplitPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.ButtonGroup MExecution;
    private javax.swing.ButtonGroup MRemoveDuplicates;
    private javax.swing.ButtonGroup MSeq;
    public static javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MultiQC;
    private javax.swing.JButton MultiQCButton;
    public static javax.swing.JFrame OutputFrame;
    public static javax.swing.JTextArea OutputText;
    private javax.swing.JButton PCAButton;
    private javax.swing.JButton PCAButton1;
    private javax.swing.JTextField ParallelTextField;
    private javax.swing.JPanel PredictionPanel;
    public static javax.swing.JList<ListEntry> ProcList;
    private javax.swing.JPanel ProcStatusPanel;
    private javax.swing.JPanel RNAseqPanel;
    public static javax.swing.JToggleButton ReloadOutput;
    private javax.swing.JButton RemoveOutput;
    private javax.swing.JButton S_AnovaLikeButton;
    private javax.swing.JButton S_CCRemove;
    private javax.swing.JButton S_CellRangerCount;
    private javax.swing.JPanel S_Clustering;
    private javax.swing.JButton S_ClustersFeatureButton;
    private javax.swing.JButton S_Counts2Log1;
    private javax.swing.JPanel S_CountsGeneration;
    private javax.swing.JPanel S_CountsManipulation;
    private javax.swing.JPanel S_FeatureSelection;
    private javax.swing.JButton S_FilterZeros;
    private javax.swing.JButton S_GenesSelection;
    private javax.swing.JButton S_GenesUmi;
    private javax.swing.JButton S_HFCButton;
    private javax.swing.JButton S_IndropCounts;
    private javax.swing.JButton S_IndropIndex;
    private javax.swing.JButton S_LorenzFilter;
    private javax.swing.JButton S_RecatPrediction;
    private javax.swing.JButton S_ScNorm;
    private javax.swing.JButton S_ScannoByGtf;
    private javax.swing.JButton S_SeuratBootstrapButton;
    private javax.swing.JButton S_SeuratPCAEvalButton;
    private javax.swing.JButton S_SeuratPriorButton;
    private javax.swing.JButton S_TopX;
    private javax.swing.JButton S_TsneBootstrapButton;
    private javax.swing.JButton S_UmiNorm;
    private javax.swing.JScrollPane S_anovaLike;
    private javax.swing.JButton S_bootstrapVideoButton;
    private javax.swing.JScrollPane S_bootstrapsVideo;
    private javax.swing.JScrollPane S_ccRemove;
    private javax.swing.JScrollPane S_cellRanger;
    private javax.swing.JButton S_checkCountDepth;
    private javax.swing.JScrollPane S_clusterNgriph;
    private javax.swing.JButton S_clusteringNgriphButton;
    private javax.swing.JScrollPane S_clustersFeatures;
    private javax.swing.JScrollPane S_countDepth;
    private javax.swing.JScrollPane S_counts2Log;
    private javax.swing.JScrollPane S_filterZeros;
    private javax.swing.JScrollPane S_genesPrioritization;
    private javax.swing.JButton S_genesPrioritizationButton;
    private javax.swing.JScrollPane S_genesSelection;
    private javax.swing.JScrollPane S_genesUmi;
    private javax.swing.JScrollPane S_hfc;
    private javax.swing.JScrollPane S_indropCounts;
    private javax.swing.JScrollPane S_indropIndex;
    private javax.swing.JScrollPane S_lorenzFilter;
    private javax.swing.JScrollPane S_recatPrediction;
    private javax.swing.JScrollPane S_scannoByGtf;
    private javax.swing.JScrollPane S_scnorm;
    private javax.swing.JScrollPane S_seuratBootstrap;
    private javax.swing.JScrollPane S_seuratPCAEval;
    private javax.swing.JScrollPane S_seuratPrior;
    private javax.swing.JScrollPane S_simlrBootstrap;
    private javax.swing.JButton S_simlrBootstrapButton;
    private javax.swing.JScrollPane S_topX;
    private javax.swing.JScrollPane S_tsneBootstrap;
    private javax.swing.JScrollPane S_umiNorm;
    private javax.swing.JButton SalmonIndexingButton;
    private javax.swing.JButton SampleExpButton;
    private javax.swing.JButton SampleSizeButton;
    private javax.swing.JButton SampleSizeButton1;
    private javax.swing.JPanel SequenceAnalysisPanel;
    private javax.swing.JTabbedPane SingleCellPanel;
    private javax.swing.JButton StarChimericButton;
    private javax.swing.JButton StarchipCircleButton;
    private javax.swing.JPanel SubPreductionPanel;
    public javax.swing.JScrollPane Test;
    private javax.swing.JTextField ThreadTextField;
    private javax.swing.JPanel ToolPanel;
    private javax.swing.JSplitPane VerticalSplitPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton circRNAAnnotationButton;
    private javax.swing.JScrollPane circRNA_BSJunctions;
    private javax.swing.JScrollPane circRNA_annotation;
    private javax.swing.JScrollPane circRNA_ciri2;
    private javax.swing.JScrollPane circRNA_mergeCiri2Samples;
    private javax.swing.JScrollPane circRNA_postprocessing;
    private javax.swing.JScrollPane circRNA_prepareExonIsoformFiles;
    private javax.swing.JScrollPane circRNA_quantification;
    private javax.swing.JScrollPane circRNA_starChimeric;
    private javax.swing.JScrollPane circRNA_starPrediction;
    private javax.swing.JScrollPane circRNA_structure;
    private javax.swing.JScrollPane countingSalmon;
    private javax.swing.JButton countingSalmonButton;
    private javax.swing.JScrollPane dESPanel;
    private javax.swing.JButton downloadExonIsoformDataButton;
    private javax.swing.JScrollPane experimentPowerPanel;
    private javax.swing.JScrollPane fPKMPanel;
    private javax.swing.JScrollPane filterCounts;
    private javax.swing.JButton indexingBButton;
    private javax.swing.JScrollPane indexingBWAPanel;
    private javax.swing.JScrollPane indexingSalmon;
    private javax.swing.JScrollPane indexingStarRSEM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel96;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane mACSPanel;
    private javax.swing.JScrollPane mRNA;
    private javax.swing.JScrollPane mRNABatchPanel;
    private javax.swing.JButton mRNAButton;
    private javax.swing.JPanel miRNAPanel;
    private javax.swing.JScrollPane pCAPanel;
    private javax.swing.JScrollPane sampleSizePanel;
    private javax.swing.JScrollPane vmRNA;
    private javax.swing.JButton vmRNAButton;
    // End of variables declaration//GEN-END:variables


        


static public class ElProcRunning {
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

static public class ElProcWaiting {
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


static public class GlobalStatus{
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

static public class ListEntry
{
   private final String value;
   private final ImageIcon icon;
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

static public class GlobalSetting{
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

  
static public class ListEntryCellRenderer
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
static    String CurrentLayout="Empty";
    

 static public  Timer t,outputTime=new Timer();

 static public class MyFileUpdate extends TimerTask{
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
 static public class MyTask extends TimerTask {
      
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
                    JOptionPane.showMessageDialog(BottomPanel, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
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

 
static public ArrayList <ElProcRunning> listProcRunning =  new  ArrayList <ElProcRunning> ();
static public ArrayList <ElProcWaiting> listProcWaiting = new  ArrayList <ElProcWaiting> ();
static public DefaultListModel<ListEntry> listModel= new DefaultListModel <ListEntry> ();


//int MaxSizelistProcRunning=1; 
static public GlobalStatus GL =new GlobalStatus();
//String DefaultThread="8";
static public GlobalSetting GS =new GlobalSetting();




static public class DefaultContextMenu extends JPopupMenu
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

public static DefaultContextMenu contextMenu = new DefaultContextMenu();

  static String prefRootNode = "/org/unito/HashChekerGUI";
   // Preferences
    public static Preferences getPreferences() {
        assert prefRootNode != null;
        Preferences root = Preferences.userRoot();
        return root.node(prefRootNode);
    } 

    
    
    
    public static void execCommand(Component stuff, String commandName, String script, String commandArgs, String outputFolder) {        
        //bash ./nomescript argList outputFolder >& outputFolder/outputExecution
        String bashString = String.format(
            "bash ./%s %s %s >& %s/outputExecution", script, commandArgs, outputFolder, outputFolder);
        String[] cmd = {"/bin/bash","-c", bashString};
        Runtime rt = Runtime.getRuntime();
        
        try {
            if (MainFrame.listProcRunning.size() < MainFrame.GS.getMaxSizelistProcRunning()) {
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning(commandName, outputFolder,pr,MainFrame.listModel.getSize());
                MainFrame.listProcRunning.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Running]   "+tmp.toString(),"Running",tmp.path, image2 ));
                MainFrame.GL.setAvoidProcListValueChanged(0);
                if (MainFrame.listProcRunning.size() == 1) {
                    MainFrame.t=new Timer();
                    MainFrame.t.scheduleAtFixedRate(new MainFrame.MyTask(), 5000, 5000);
                }
            }
            else {
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting(commandName, outputFolder, cmd,MainFrame.listModel.getSize());
                MainFrame.listProcWaiting.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/waiting.png");
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
        catch (IOException e) {
            JOptionPane.showMessageDialog(stuff, e.toString(),"Error execution",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
        JOptionPane.showMessageDialog(stuff, String.format("%s task was scheduled", commandName),"Confermation",JOptionPane.INFORMATION_MESSAGE);
    }   
    
    
}
