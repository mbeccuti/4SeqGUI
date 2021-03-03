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
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.print.Doc;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
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

    private class TabBarController {
        private class SingleTabInfo {
            public final int numTab;
            public final Icon icon;
            public final String text, name;
            public final JScrollPane content;
            private boolean state; //true: visible, false: hidden

            public SingleTabInfo(int index, JTabbedPane tabbedPane) {
                this.numTab = index;
                this.icon = tabbedPane.getIconAt(index);
                this.text = tabbedPane.getTitleAt(index);
                this.content = (JScrollPane) tabbedPane.getComponentAt(index);
                this.name = this.content.getName();
            }

            public void setVisibility() {
                String varname = String.format("4SeqGUI_EnableTab%s", this.name);
                this.state = getPreferences().get(varname, "true").equals("true");
            }

            public boolean getVisibility() {
                return this.state;
            }
        }

        private final JTabbedPane myJTabbedPane;
        private final ArrayList<SingleTabInfo> tabList;

        public TabBarController(JTabbedPane myTab) {
            this.tabList = new ArrayList<>();
            this.myJTabbedPane = myTab;

            //store all tabs in the list
            for (int i = 0, count = myTab.getTabCount(); i < count; i++)
                this.tabList.add(new SingleTabInfo(i, myTab));

        }

        public TabBarController refreshTabs() {
            // remove all tabs
            for (SingleTabInfo tab: this.tabList) {
                this.myJTabbedPane.remove(tab.content);
                tab.setVisibility();
            }
            // add those tabs that are not hidden
            for (SingleTabInfo tab: this.tabList)
                if (tab.getVisibility())
                    this.myJTabbedPane.addTab(tab.text, tab.icon, tab.content);

            return this;
        }
    }

    private class DockerImageManager {
        private final String countDockerImagesVariable = "4SeqGUI_numDockerImages";
        private final String prefixDockerVariable = "4SeqGUI_dockerImage_";
        private final javax.swing.JTable dockerTable;
        private final Map<String, DockerImageDescription> dockerImages;

        public class DockerImageDescription {
            //describe a docker image record
            public final String url, repository, name, tag;
            private String size = "", age = "", img_hash = "";

            /**
             * Describe a docker image record.
             * @param url dockerhub url
             */
            public DockerImageDescription(String url) {
                String tokens[] = url.split("/");
                /* accessing the array starting from the end,
                 * we take into account both parsed and unparsed docker url:
                 * case a: docker.io/repository/image
                 * case b: repository/image */
                String token_name = tokens[tokens.length - 1]; 
                String []name_tag = token_name.split(":"); 
                this.tag = name_tag.length == 1 ? "latest" : name_tag[name_tag.length - 1]; 
                this.name = name_tag[0]; 
                this.repository = tokens.length > 1 ? tokens[tokens.length - 2] : null;
                
                this.url = this.repository != null ? 
                    String.format("%s/%s:%s", repository, name, tag) :
                    String.format("%s:%s", name, tag);
            }
            
            public DockerImageDescription setSize(String size) { 
                this.size = size; 
                return this; 
            }
            
            public DockerImageDescription setAge(String age) {
                this.age = age; 
                return this; 
            }
            
            public DockerImageDescription setHash(String hash) {
                this.img_hash = hash; 
                return this; 
            }
            
            public String getSize() {   return this.size; }
            public String getAge() {    return this.age; }
            public String getHash() {   return this.img_hash; }
            
            @Override
            public int hashCode() {
                int hash = 7;
                hash = 83 * hash + Objects.hashCode(this.url);
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                final DockerImageDescription other = (DockerImageDescription) obj;
                return Objects.equals(this.url, other.url);
            }


        }

        /**
         * Initialize the docker manager.
         *
         * @param dockerTable Table component in GUI responsible to visualize and
         * manage docker images.
         */
        public DockerImageManager(javax.swing.JTable dockerTable) {
            this.dockerImages = new HashMap<>();
            this.dockerTable = dockerTable;
     
    //        resetConfiguration();
            loadConfiguration();
            loadDockerInfo(); 
        }
        
        void loadDockerInfo() {
            try {
                Runtime rt = Runtime.getRuntime(); 
                Process pr = rt.exec("docker images"); 
                
                try (BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()))) {
                    String img_name = "", img_tag = "", img_hash = "", img_age = "", img_size = ""; 
                    String line = br.readLine();  //skip header
                    
                    for (line = br.readLine(); line != null; line = br.readLine()) {
                        int i = 0;

                        for (String s: line.split(" ")) {
                            if ((s = s.trim()).length() > 0) {
                                switch (i) {
                                    case 0: 
                                        img_name = s; 
                                        break; 
                                    case 1: 
                                        img_tag = s; 
                                        break; 
                                    case 2:
                                        img_hash = s; 
                                        break; 
                                    case 3:
                                    case 4:
                                        img_age += s + " "; 
                                        break;
                                    case 5:
                                        img_age += s;
                                        break; 
                                    case 6:
                                        img_size = s; 
                                        break; 
                                    default:
                                        break;
                                }
                                i++;
                            }
                        }

                        String img_fullname = String.format("%s:%s", img_name, img_tag);
                        DockerImageDescription curr = dockerImages.get(new DockerImageDescription(img_fullname).url); 
                        if (curr != null)
                            curr.setSize(img_size).setAge(img_age).setHash(img_hash); 
                    }
                }  
            } catch (IOException e) {
                System.err.println("Cannot exec 'docker images' command!"); 
            }
        }



        /**
         * Add new docker images to the system.
         *
         * @param imageListFile name of the file containing the list of docker
         * images needed to execute all the possible pipelines present in docker4seq
         */
        public void addImages(String imageListFile) {
            try {
                Files.lines(Paths.get(imageListFile)).forEach((String line) -> {
                    DockerImageDescription curr = new DockerImageDescription(line);

                    if (dockerImages.get(curr.url) == null)
                        dockerImages.put(curr.url, curr);
                });
            } catch (IOException ex) {
                System.err.println("IOException during " + imageListFile + " reading");
            }

            loadDockerInfo();
            writeConfiguration();
        }

        /**
         * Show docker images in the apposite jtable.
         */
        public void updateGUI() {
            DefaultTableModel model = (DefaultTableModel) dockerImagesTable.getModel();
            model.setRowCount(0);

            dockerImages.entrySet().forEach((entry) -> {
                DockerImageDescription tmp = entry.getValue();
                model.addRow(new Object[]{false, tmp.url, tmp.getSize()});
            });
        }

        /**
         * Remove the selected images from the system. Docker images whose checkbox
         * are selected are removed from the system
         */
        public void removeImages() {
            getRecords(true).forEach((imageId) -> {
                if (dockerImages.get(imageId) != null)
                    dockerImages.remove(imageId); 
                removeDockerImage(imageId); 
                /*
                if (removeDockerImage(imageId)) {
                    dockerImages.remove(imageId);
                } */
            });

            updateGUI();
            writeConfiguration();
        }
        
        /**
         * Update the selected images at the last version available. Docker images
         * whose checkbox is selected are pulled from Docker Hub. 
         */
        public void updateImages() {
            getRecords(true).forEach((imageId) -> { 
                updateDockerImage(imageId); 
            });
            
        }
        
        

        /**
         * Return the list of docker images (un)selected.
         * @param selected_flag
         */
        private ArrayList<String> getRecords(boolean selected_flag) {
            ArrayList<String> records = new ArrayList<>();
            DefaultTableModel model = (DefaultTableModel) dockerTable.getModel();

            for (int i = 0; i < model.getRowCount(); i++)
                if (((boolean) model.getValueAt(i, 0)) == selected_flag)
                    records.add((String) model.getValueAt(i,1));

            return records;
        }

        private void resetConfiguration() {
            int numImages = getPreferences().getInt(countDockerImagesVariable, 0);
            
            for (int i = 0; i < numImages; i++) {
                String varName = String.format("%s%d", prefixDockerVariable, i);
                getPreferences().put(varName, null);

            }
            getPreferences().putInt(countDockerImagesVariable, 0);
        }
        
        /**
         * Instantiate dockerImages map loading docker images' names from Preferences
         * values */
        private void loadConfiguration() {
            int numImages = getPreferences().getInt(countDockerImagesVariable, 0);

            dockerImages.clear();

            for (int i = 0; i < numImages; i++) {
                String varName = String.format("%s%d", prefixDockerVariable, i);
                String varValue = getPreferences().get(varName, null);
       
                if (varValue != null) {
                    DockerImageDescription tmp = new DockerImageDescription(varValue);
                    dockerImages.put(tmp.url, tmp);
                }
            }
        }

        /**
         *
         */
        private void writeConfiguration() {
            //save number of images
            int numImages = dockerImages.size();
            int index = 0;

            getPreferences().putInt(countDockerImagesVariable, numImages);

            for (String imageUrl: dockerImages.keySet()) {
                String varName = String.format("%s%d", prefixDockerVariable, index);
                getPreferences().put(varName, imageUrl);
                index++;
            }
        }

    }


    private final TabBarController tabsController;
    private final DockerImageManager dockerManager;


    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        tabsController = new TabBarController(jTabbedPane1).refreshTabs();
        dockerManager = new DockerImageManager(dockerImagesTable);

        ImageIcon image = new ImageIcon(getClass().getResource("/pkg4seqgui/images/dna.png"));

        //DefaultTreeCellRenderer renderer =(DefaultTreeCellRenderer) AnalysisTree.getCellRenderer();
        //renderer.setLeafIcon(image);
        //imgURL = getClass().getResource("/pkg4seqgui/images/dna2.png");
       // ImageIcon image2 = new ImageIcon(imgURL);
        //renderer.setOpenIcon(image2);
       // expandAllNodes(AnalysisTree, 0, AnalysisTree.getRowCount());


        //ADDING PANEL
        MultiQC.setViewportView(new MultiQC());
        Heatmap.setViewportView(new HeatmapPanel());
        ANOVAlike.setViewportView(new ANOVApanel());
        filterCounts.setViewportView(new FilterCountsPanel());
        countingSalmon.setViewportView(new CountingSalmon());
        indexingSalmon.setViewportView(new IndexingSalmon());
        indexingStarRSEM.setViewportView(new IndexingStarRSEM());
        mRNA.setViewportView(new MRNAPanel());
        fPKMPanel.setViewportView(new FPKMPanel());
        vmRNA.setViewportView(new VmRNA());
        pCAPanel.setViewportView(new PCAPanel());
        Tools_STVisualization.setViewportView(new ST_Visualization());

        dESPanel.setViewportView(new DESPanel());
        sampleSizePanel.setViewportView(new SampleSizePanel());
        experimentPowerPanel.setViewportView(new ExperimentPowerPanel());
        mRNABatchPanel.setViewportView(new MRNABatchPanel());
        S_indropIndex.setViewportView(new S_IndropIndex());
        S_indropCounts.setViewportView(new S_IndropCounts());
        S_cellRanger.setViewportView(new S_CellRanger());
        S_filterZeros.setViewportView(new S_FilterZeros());
        S_genesUmi.setViewportView(new S_GenesUmi());
        S_topX.setViewportView(new S_TopX());
        S_lorenzFilter.setViewportView(new S_LorenzFilter());
        S_scannoByGtf.setViewportView(new S_ScannoByGtf());
        S_countDepth.setViewportView(new S_CountDepth());
        S_scnorm.setViewportView(new S_Scnorm());
        S_umiNorm.setViewportView(new S_UmiNorm());
        S_counts2Log.setViewportView(new S_Counts2Log());
        S_recatPrediction.setViewportView(new S_RecatPrediction());
        S_ccRemove.setViewportView(new S_CcRemove());
        S_clusterNgriph.setViewportView(new S_ClusterNgriph());
        S_clusterNgriph1.setViewportView(new S_ClusterNgriph1());
        S_simlrBootstrap.setViewportView(new S_SimlrBootstrap());
        S_bootstrapsVideo.setViewportView(new S_BootstrapsVideo());
        S_seuratPCAEval.setViewportView(new S_SeuratPCAEval());
        S_seuratBootstrap.setViewportView(new S_SeuratBootstrap());
        S_tsneBootstrap.setViewportView(new S_TsneBootstrap());
        S_anovaLike.setViewportView(new S_AnovaLike());
        S_clustersFeatures.setViewportView(new S_ClustersFeatures());
        S_hfc.setViewportView(new S_Hfc());
        S_genesPrioritization.setViewportView(new S_GenesPrioritization());
        S_genesSelection.setViewportView(new S_GenesSelection());
        S_seuratPrior.setViewportView(new S_SeuratPrior());
        S_dim.setViewportView(new S_dim());
        S_clusterStability.setViewportView(new S_clusterStability());

        mergeMatrix.setViewportView(new MergeMatrix());
        crossLabel.setViewportView(new S_CrossLabel());
        S_scanpybootstrap.setViewportView(new S_ScanpyBootstrap());
        tenXIndexing.setViewportView(new S_10XGenomics_index());
        S_detwogroups.setViewportView(new S_DeTwoGroups());
        S_sparsetodense.setViewportView(new S_SparseToDense());
        S_densetosparse.setViewportView(new S_DenseToSparse());
        subsetcells.setViewportView(new subSetCells());
        S_splitclusters.setViewportView(new S_SplitClusters());
        S_unstablefiltering.setViewportView(new S_UnstableFiltering());
        SingleCell_SpatialCountGeneration.setViewportView(new S_SpatialCountGeneration());
        SingleCell_GeneSelectionComet.setViewportView(new SC_CometGeneSelection());
        SingleCell_SharpClustering.setViewportView(new SC_SharpClustering());
        
        S_AE.setViewportView(new S_Autoencoder());
        S_AE_Analysis.setViewportView(new S_AutoencoderAnalysis());
        S_AE_Clustering.setViewportView(new S_AutoencoderClustering()); 
        S_AE_Features.setViewportView(new S_AutoencoderFeatures());
        S_AE_Comet.setViewportView(new S_AutoencoderCometSC());
        S_AE_Wrapper.setViewportView(new S_AutoencoderWrapper());
        
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
        circRNA_wrapperSTAR.setViewportView(new CircRNAWrapperSTARChip());
        circRNA_overlap.setViewportView(new CircRNAOverlapPredictions());
        circRNA_reformat.setViewportView(new CircRNAReformatPredictions());
        
        mirnaGenomeIndexing.setViewportView(new SncRNAIndexing());
        mirnaQuantification.setViewportView(new SncRNAQuantification());
        VioplotHTMLbyGenes.setViewportView(new Tools_VioHTMLbyGenesPanel());
        S_SeuratCellCycleEstimation.setViewportView(new SeuratCellCycleEstimation());
        S_BulkClusters.setViewportView((new Tools_BulkClusters()));
        S_SaverNormalisation.setViewportView(new SaverNormalisation());

       // heatmaply.setViewportView(new WebBrowser());
        //chipseq stuff
        MACSv2.setViewportView(new MACSv2Panel());
        bwa.setViewportView(new BWAPanel());
        bwaIndex.setViewportView(new BWAIndexPanel()); 
        chipseqAnnotationPanel.setViewportView(new ChipseqAnnotation());
        /* *** deprecated - to remove *********/
        indexingBWAPanel.setViewportView(new IndexingBWAPanel());
        mACSPanel.setViewportView(new MACSPanel());
        /* **********************************/
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
        downloadDockerImagesButton = new javax.swing.JButton();
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
        ConfigureTabsFrame = new javax.swing.JFrame();
        enableTabsPanel = new javax.swing.JPanel();
        miRNATabChecker = new javax.swing.JCheckBox();
        singleCellTabChecker = new javax.swing.JCheckBox();
        toolsTabChecker = new javax.swing.JCheckBox();
        circRNATabChecker = new javax.swing.JCheckBox();
        rnaSeqTabChecker = new javax.swing.JCheckBox();
        chipseqTabChecker = new javax.swing.JCheckBox();
        miRNA2TabChecker = new javax.swing.JCheckBox();
        confermConfigureTabButton = new javax.swing.JButton();
        closeConfigureTabButton = new javax.swing.JButton();
        dockerImagesManager = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        dockerImagesTable = new javax.swing.JTable();
        commandsPanel = new javax.swing.JPanel();
        addImagesButton = new javax.swing.JButton();
        removeImagesButton = new javax.swing.JButton();
        pullImagesButton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        manageDockerImagesButton = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        ConfigureTabsButton = new javax.swing.JButton();
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
        mirnaGenomeIndexing = new javax.swing.JScrollPane();
        mirnaQuantification = new javax.swing.JScrollPane();
        S_dim = new javax.swing.JScrollPane();
        S_clusterStability = new javax.swing.JScrollPane();
        mergeMatrix = new javax.swing.JScrollPane();
        crossLabel = new javax.swing.JScrollPane();
        tenXIndexing = new javax.swing.JScrollPane();
        subsetcells = new javax.swing.JScrollPane();
        S_splitclusters = new javax.swing.JScrollPane();
        S_unstablefiltering = new javax.swing.JScrollPane();
        S_detwogroups = new javax.swing.JScrollPane();
        heatmaply = new javax.swing.JScrollPane();
        S_clusterNgriph1 = new javax.swing.JScrollPane();
        S_densetosparse = new javax.swing.JScrollPane();
        S_sparsetodense = new javax.swing.JScrollPane();
        S_scanpybootstrap = new javax.swing.JScrollPane();
        MACSv2 = new javax.swing.JScrollPane();
        bwa = new javax.swing.JScrollPane();
        bwaIndex = new javax.swing.JScrollPane();
        chipseqAnnotationPanel = new javax.swing.JScrollPane();
        circRNA_wrapperSTAR = new javax.swing.JScrollPane();
        circRNA_overlap = new javax.swing.JScrollPane();
        circRNA_reformat = new javax.swing.JScrollPane();
        SingleCell_SpatialCountGeneration = new javax.swing.JScrollPane();
        SingleCell_SharpClustering = new javax.swing.JScrollPane();
        SingleCell_GeneSelectionComet = new javax.swing.JScrollPane();
        Tools_STVisualization = new javax.swing.JScrollPane();
        S_AE = new javax.swing.JScrollPane();
        S_AE_Clustering = new javax.swing.JScrollPane();
        S_AE_Features = new javax.swing.JScrollPane();
        S_AE_Analysis = new javax.swing.JScrollPane();
        S_AE_Comet = new javax.swing.JScrollPane();
        S_AE_Wrapper = new javax.swing.JScrollPane();
        VioplotHTMLbyGenes = new javax.swing.JScrollPane();
        S_SeuratCellCycleEstimation = new javax.swing.JScrollPane();
        S_BulkClusters = new javax.swing.JScrollPane();
        S_SaverNormalisation = new javax.swing.JScrollPane();
        LeftPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        miRNAScrollPanel = new javax.swing.JScrollPane();
        miRNAPanel = new javax.swing.JPanel();
        miRNApanelSub1 = new javax.swing.JPanel();
        jLabelmiRNA1 = new javax.swing.JLabel();
        miRNApanelSub1M = new javax.swing.JPanel();
        jButton59 = new javax.swing.JButton();
        miRNApanelSub2 = new javax.swing.JPanel();
        jLabelmiRNA2 = new javax.swing.JLabel();
        miRNApanelSub2M = new javax.swing.JPanel();
        jButton60 = new javax.swing.JButton();
        PCAButton1 = new javax.swing.JButton();
        CountButton1 = new javax.swing.JButton();
        SampleSizeButton1 = new javax.swing.JButton();
        ExpPowerButton1 = new javax.swing.JButton();
        DeseqButton2 = new javax.swing.JButton();
        ChipSeqScrollPanel = new javax.swing.JScrollPane();
        ChipSeqPanel = new javax.swing.JPanel();
        Macs2Button = new javax.swing.JButton();
        chipseqbwaButton = new javax.swing.JButton();
        bwaIndexChipseq = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        CircRNAScrollPanel = new javax.swing.JScrollPane();
        CircRNAPanel = new javax.swing.JPanel();
        crnaP1 = new javax.swing.JPanel();
        PredictionPanel = new javax.swing.JPanel();
        Ciri2PredictionButton = new javax.swing.JButton();
        Ciri2MergeResultsButton = new javax.swing.JButton();
        StarChimericButton = new javax.swing.JButton();
        StarchipCircleButton = new javax.swing.JButton();
        wrapperSTARChipButton = new javax.swing.JButton();
        reformatPredictionButton = new javax.swing.JButton();
        overlapPredictionButton = new javax.swing.JButton();
        crnaPredictionLabel = new javax.swing.JLabel();
        crnaP2 = new javax.swing.JPanel();
        ClassificationAnnotationPanel = new javax.swing.JPanel();
        CirchunterClassificButton2 = new javax.swing.JButton();
        circRNAAnnotationButton2 = new javax.swing.JButton();
        downloadExonIsoformDataButton2 = new javax.swing.JButton();
        crnaClassificationLabel = new javax.swing.JLabel();
        crnaP3 = new javax.swing.JPanel();
        SequenceAnalysisPanel = new javax.swing.JPanel();
        BSJunctionsButton = new javax.swing.JButton();
        CircRNAStructurePredictionButton = new javax.swing.JButton();
        crnaSequenceLabel = new javax.swing.JLabel();
        crnaP4 = new javax.swing.JPanel();
        ExpressionAnalysisPanel = new javax.swing.JPanel();
        CircRNAQuantificationButton = new javax.swing.JButton();
        circRNADESeqButton = new javax.swing.JButton();
        circRNAddingCovarsButtonButton = new javax.swing.JButton();
        crnaExpressionLabel = new javax.swing.JLabel();
        sncRNAScrollPane = new javax.swing.JScrollPane();
        sncRNAPanel = new javax.swing.JPanel();
        srnaP1 = new javax.swing.JPanel();
        sncrnaReferenceLabel = new javax.swing.JLabel();
        srnaFirstStep = new javax.swing.JPanel();
        mirnaQuantificationButton = new javax.swing.JButton();
        mirnaindexingButton = new javax.swing.JButton();
        srnaP2 = new javax.swing.JPanel();
        sncrnaPostProcessingLabel = new javax.swing.JLabel();
        srnaPreprocessCounts = new javax.swing.JPanel();
        jButton61 = new javax.swing.JButton();
        PCAButton2 = new javax.swing.JButton();
        SampleSizeButton2 = new javax.swing.JButton();
        ExpPowerButton2 = new javax.swing.JButton();
        srnaP3 = new javax.swing.JPanel();
        srnaExpression = new javax.swing.JPanel();
        DeseqButton3 = new javax.swing.JButton();
        CountButton3 = new javax.swing.JButton();
        NovaLikeButton3 = new javax.swing.JButton();
        sncrnaExpressionAnaLabel = new javax.swing.JLabel();
        ToolScrollPanel = new javax.swing.JScrollPane();
        ToolPanel = new javax.swing.JPanel();
        MultiQCButton = new javax.swing.JButton();
        HeatmapButton = new javax.swing.JButton();
        MergeMatrixButton = new javax.swing.JButton();
        subSetMatrixButton1 = new javax.swing.JButton();
        SC_dimension = new javax.swing.JButton();
        heatmaplyButton = new javax.swing.JButton();
        SparseToDense = new javax.swing.JButton();
        DenseToSparse = new javax.swing.JButton();
        STVisualization = new javax.swing.JButton();
        VioplotButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        SingleCellScrollPanel = new javax.swing.JScrollPane();
        SingleCellPanel = new javax.swing.JPanel();
        SubCountGenerationPanel = new javax.swing.JPanel();
        sc_countsGenerationLabel = new javax.swing.JLabel();
        sc_innerPanel1 = new javax.swing.JPanel();
        SC_IndropIndexButton = new javax.swing.JButton();
        SC_IndropCountsButton = new javax.swing.JButton();
        SC_CellRangerCountButton = new javax.swing.JButton();
        SC_IndropCountsButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        SubCountManipulationPanel = new javax.swing.JPanel();
        sc_countsManipulationLabel = new javax.swing.JLabel();
        sc_innerPanel2 = new javax.swing.JPanel();
        SC_CCRemoveButton = new javax.swing.JButton();
        SC_ScannoByGtfButton = new javax.swing.JButton();
        SC_UmiNormButton = new javax.swing.JButton();
        SC_GenesUmiButton = new javax.swing.JButton();
        SC_FilterZerosButton = new javax.swing.JButton();
        SC_RecatPredictionButton = new javax.swing.JButton();
        SC_SCNormButton = new javax.swing.JButton();
        SC_TopXButton = new javax.swing.JButton();
        SC_CountDepthButton = new javax.swing.JButton();
        SC_LorenzFilterButton = new javax.swing.JButton();
        SC_Counts2LogButton = new javax.swing.JButton();
        SC_SeuratCellCycleEstimation = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        SubClusteringPanel = new javax.swing.JPanel();
        sc_clusteringLabel = new javax.swing.JLabel();
        sc_innerPanel3 = new javax.swing.JPanel();
        SC_BootstrapVideoButton = new javax.swing.JButton();
        SC_SimlrBootstrapButton = new javax.swing.JButton();
        SC_SeuratBootstrapButton = new javax.swing.JButton();
        SC_ClusteringNgriphButton = new javax.swing.JButton();
        SC_SeuratPCAEvalButton = new javax.swing.JButton();
        SC_TsneBootstrap = new javax.swing.JButton();
        SC_ClusterStabilityButton = new javax.swing.JButton();
        S_crossLabelButton1 = new javax.swing.JButton();
        SC_unstableFilteringButton = new javax.swing.JButton();
        SC_ClusterSplit = new javax.swing.JButton();
        SC_ClusteringNgriphButton1 = new javax.swing.JButton();
        SC_ScanpyBootstrap = new javax.swing.JButton();
        SC_ClusteringNgriphButton2 = new javax.swing.JButton();
        SubFeatureSelectionPanel = new javax.swing.JPanel();
        sc_FeatureSelectionLabel = new javax.swing.JLabel();
        sc_innerPanel4 = new javax.swing.JPanel();
        SC_GenesSelectionSIMLRButton = new javax.swing.JButton();
        SC_HFCButton = new javax.swing.JButton();
        SC_AnovaLikeButton = new javax.swing.JButton();
        SC_SeuratPriorButton = new javax.swing.JButton();
        SC_ClustersFeaturesButton = new javax.swing.JButton();
        SC_GenesPrioritizSIMLRButton = new javax.swing.JButton();
        SC_DeTwoGroupsButton = new javax.swing.JButton();
        SC_GenesSelectionSIMLRButton1 = new javax.swing.JButton();
        SubBottomPanel = new javax.swing.JPanel();
        subAutoencoderPanel = new javax.swing.JPanel();
        sc_autoencoderLabel = new javax.swing.JLabel();
        sc_autoencoderPanel = new javax.swing.JPanel();
        autoencoderButton = new javax.swing.JButton();
        autoencoderClusteringButton = new javax.swing.JButton();
        autoencoderAnalysisButton = new javax.swing.JButton();
        autoencoderFeaturesButton = new javax.swing.JButton();
        autoencoderCometButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        RNAScrollPane = new javax.swing.JScrollPane();
        RNAseqPanel = new javax.swing.JPanel();
        RNAseqPanelSub1 = new javax.swing.JPanel();
        jLabelRNAseq1 = new javax.swing.JLabel();
        RNAseqPanelSub1M = new javax.swing.JPanel();
        vmRNAButton = new javax.swing.JButton();
        mRNAButton = new javax.swing.JButton();
        SalmonIndexingButton = new javax.swing.JButton();
        countingSalmonButton = new javax.swing.JButton();
        RNAseqPanelSub2 = new javax.swing.JPanel();
        jLabelRNAseq2 = new javax.swing.JLabel();
        RNAseqPanelSub2M = new javax.swing.JPanel();
        SampleExpButton = new javax.swing.JButton();
        PCAButton = new javax.swing.JButton();
        SampleSizeButton = new javax.swing.JButton();
        ExpPowerButton = new javax.swing.JButton();
        DeseqButton = new javax.swing.JButton();
        ANOVAlikeButton = new javax.swing.JButton();
        CountButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
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

        downloadDockerImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/downloadb.png"))); // NOI18N
        downloadDockerImagesButton.setText("Download");
        downloadDockerImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadDockerImagesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        DownloadFrame.getContentPane().add(downloadDockerImagesButton, gridBagConstraints);

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

        ConfigureTabsFrame.setTitle("Configure Tabs");
        ConfigureTabsFrame.getContentPane().setLayout(new java.awt.GridBagLayout());

        enableTabsPanel.setBackground(new java.awt.Color(248, 248, 248));
        enableTabsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        enableTabsPanel.setLayout(new java.awt.GridBagLayout());

        miRNATabChecker.setSelected(true);
        miRNATabChecker.setText("miRNA");
        miRNATabChecker.setName("mirna"); // NOI18N
        miRNATabChecker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRNATabCheckerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(miRNATabChecker, gridBagConstraints);

        singleCellTabChecker.setSelected(true);
        singleCellTabChecker.setText("Single Cell");
        singleCellTabChecker.setName("singlecell"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(singleCellTabChecker, gridBagConstraints);

        toolsTabChecker.setSelected(true);
        toolsTabChecker.setText("Tools");
        toolsTabChecker.setName("tools"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 5.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(toolsTabChecker, gridBagConstraints);

        circRNATabChecker.setSelected(true);
        circRNATabChecker.setText("CircRNA");
        circRNATabChecker.setName("circrna"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(circRNATabChecker, gridBagConstraints);

        rnaSeqTabChecker.setSelected(true);
        rnaSeqTabChecker.setText("RNAseq");
        rnaSeqTabChecker.setName("rnaseq"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(rnaSeqTabChecker, gridBagConstraints);

        chipseqTabChecker.setSelected(true);
        chipseqTabChecker.setText("ChipSeq");
        chipseqTabChecker.setName("chipseq"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(chipseqTabChecker, gridBagConstraints);

        miRNA2TabChecker.setSelected(true);
        miRNA2TabChecker.setText("sncRNA");
        miRNA2TabChecker.setName("mirna2"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        enableTabsPanel.add(miRNA2TabChecker, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ConfigureTabsFrame.getContentPane().add(enableTabsPanel, gridBagConstraints);

        confermConfigureTabButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/exec.png"))); // NOI18N
        confermConfigureTabButton.setText("Confirm");
        confermConfigureTabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermConfigureTabButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ConfigureTabsFrame.getContentPane().add(confermConfigureTabButton, gridBagConstraints);

        closeConfigureTabButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        closeConfigureTabButton.setText("Close");
        closeConfigureTabButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeConfigureTabButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ConfigureTabsFrame.getContentPane().add(closeConfigureTabButton, gridBagConstraints);

        dockerImagesManager.getContentPane().setLayout(new java.awt.GridBagLayout());

        dockerImagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flag", "Image", "Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dockerImagesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dockerImagesTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        dockerImagesManager.getContentPane().add(jScrollPane1, gridBagConstraints);

        commandsPanel.setLayout(new java.awt.GridBagLayout());

        addImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/downloadb.png"))); // NOI18N
        addImagesButton.setText("Add");
        addImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        commandsPanel.add(addImagesButton, gridBagConstraints);

        removeImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/33b.png"))); // NOI18N
        removeImagesButton.setText("Remove");
        removeImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeImagesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        commandsPanel.add(removeImagesButton, gridBagConstraints);

        pullImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/reset.png"))); // NOI18N
        pullImagesButton.setText("Update");
        pullImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pullImagesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        commandsPanel.add(pullImagesButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        dockerImagesManager.getContentPane().add(commandsPanel, gridBagConstraints);

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/preference.png"))); // NOI18N
        jButton3.setToolTipText("Configure 4SeqGUI");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

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

        manageDockerImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/manage_docker.png"))); // NOI18N
        manageDockerImagesButton.setToolTipText("Manage Docker images");
        manageDockerImagesButton.setFocusable(false);
        manageDockerImagesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageDockerImagesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageDockerImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDockerImagesButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(manageDockerImagesButton);

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

        ConfigureTabsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/tab.png"))); // NOI18N
        ConfigureTabsButton.setToolTipText("Configure Tabs");
        ConfigureTabsButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        ConfigureTabsButton.setFocusable(false);
        ConfigureTabsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConfigureTabsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConfigureTabsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigureTabsButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(ConfigureTabsButton);

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
        MainPanel.add(mirnaGenomeIndexing, "mirnaIndex");
        MainPanel.add(mirnaQuantification, "mirnaQuantific");
        MainPanel.add(S_dim, "S_dim");
        MainPanel.add(S_clusterStability, "S_clusterStability");
        MainPanel.add(mergeMatrix, "mergeMatrix");
        MainPanel.add(crossLabel, "crossLabel");
        MainPanel.add(tenXIndexing, "tenXGenomics");
        MainPanel.add(subsetcells, "subsetCells");
        MainPanel.add(S_splitclusters, "splitclusters");
        MainPanel.add(S_unstablefiltering, "unstablefiltering");
        MainPanel.add(S_detwogroups, "detwogroups");
        MainPanel.add(heatmaply, "heatmaply");
        MainPanel.add(S_clusterNgriph1, "griphclustering");
        MainPanel.add(S_densetosparse, "densetosparse");
        MainPanel.add(S_sparsetodense, "sparsetodense");
        MainPanel.add(S_scanpybootstrap, "scanpybootstrap");
        S_scanpybootstrap.getAccessibleContext().setAccessibleName("");

        MainPanel.add(MACSv2, "MACSv2");
        MainPanel.add(bwa, "bwa");
        MainPanel.add(bwaIndex, "bwaIndex");
        MainPanel.add(chipseqAnnotationPanel, "chipseqGTFAnnotation");
        MainPanel.add(circRNA_wrapperSTAR, "circRNA_wrapperSTAR");
        MainPanel.add(circRNA_overlap, "circRNA_overlap");
        MainPanel.add(circRNA_reformat, "circRNA_reformat");
        MainPanel.add(SingleCell_SpatialCountGeneration, "SC_spatial_count");
        MainPanel.add(SingleCell_SharpClustering, "sharpclustering");
        MainPanel.add(SingleCell_GeneSelectionComet, "geneSelectionComet");
        MainPanel.add(Tools_STVisualization, "ST_visual");
        MainPanel.add(S_AE, "autoencoder");
        MainPanel.add(S_AE_Clustering, "AE_clustering");
        MainPanel.add(S_AE_Features, "AE_features");
        MainPanel.add(S_AE_Analysis, "AE_analysis");
        MainPanel.add(S_AE_Comet, "AE_comet");
        MainPanel.add(S_AE_Wrapper, "AE_wrapper");
        MainPanel.add(VioplotHTMLbyGenes, "HTMLvioplot");
        MainPanel.add(S_SeuratCellCycleEstimation, "seurat_cce");
        MainPanel.add(S_BulkClusters, "bulk_clusters");
        MainPanel.add(S_SaverNormalisation, "saver_norm");

        HorizontalSplitPanel.setRightComponent(MainPanel);

        LeftPanel.setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setBackground(new java.awt.Color(238, 238, 238));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jTabbedPane1.setAutoscrolls(true);

        miRNAScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        miRNAScrollPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        miRNAScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        miRNAScrollPanel.setName("mirna"); // NOI18N

        miRNAPanel.setBackground(new java.awt.Color(255, 255, 255));
        miRNAPanel.setName("mirna"); // NOI18N
        miRNAPanel.setLayout(new java.awt.GridBagLayout());

        miRNApanelSub1.setBackground(new java.awt.Color(255, 255, 255));
        miRNApanelSub1.setLayout(new java.awt.GridBagLayout());

        jLabelmiRNA1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelmiRNA1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAtabB.png"))); // NOI18N
        jLabelmiRNA1.setText("Count table generation");
        jLabelmiRNA1.setOpaque(true);
        jLabelmiRNA1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelmiRNA1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        miRNApanelSub1.add(jLabelmiRNA1, gridBagConstraints);

        miRNApanelSub1M.setBackground(new java.awt.Color(255, 255, 255));
        miRNApanelSub1M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miRNApanelSub1MMouseEntered(evt);
            }
        });
        miRNApanelSub1M.setLayout(new java.awt.GridBagLayout());

        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAcount.png"))); // NOI18N
        jButton59.setText(" miRNA counting  ");
        jButton59.setBorderPainted(false);
        jButton59.setContentAreaFilled(false);
        jButton59.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton59MouseEntered(evt);
            }
        });
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        miRNApanelSub1M.add(jButton59, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        miRNApanelSub1.add(miRNApanelSub1M, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        miRNAPanel.add(miRNApanelSub1, gridBagConstraints);

        miRNApanelSub2.setBackground(new java.awt.Color(255, 255, 255));
        miRNApanelSub2.setLayout(new java.awt.GridBagLayout());

        jLabelmiRNA2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelmiRNA2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAtabB.png"))); // NOI18N
        jLabelmiRNA2.setText("Count table post-processes");
        jLabelmiRNA2.setOpaque(true);
        jLabelmiRNA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelmiRNA2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 320;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        miRNApanelSub2.add(jLabelmiRNA2, gridBagConstraints);

        miRNApanelSub2M.setBackground(new java.awt.Color(255, 255, 255));
        miRNApanelSub2M.setLayout(new java.awt.GridBagLayout());

        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAcov.png"))); // NOI18N
        jButton60.setText("Adding covariates and batches  ");
        jButton60.setBorderPainted(false);
        jButton60.setContentAreaFilled(false);
        jButton60.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton60MouseEntered(evt);
            }
        });
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
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        miRNApanelSub2M.add(jButton60, gridBagConstraints);

        PCAButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/PCA.png"))); // NOI18N
        PCAButton1.setText(" PCA  analysis");
        PCAButton1.setBorderPainted(false);
        PCAButton1.setContentAreaFilled(false);
        PCAButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PCAButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PCAButton1MouseEntered(evt);
            }
        });
        PCAButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNApanelSub2M.add(PCAButton1, gridBagConstraints);

        CountButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        CountButton1.setText("Count Filter  ");
        CountButton1.setBorderPainted(false);
        CountButton1.setContentAreaFilled(false);
        CountButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CountButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CountButton1MouseEntered(evt);
            }
        });
        CountButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNApanelSub2M.add(CountButton1, gridBagConstraints);

        SampleSizeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SampleSizeButton1.setText("Sample size estimator  ");
        SampleSizeButton1.setBorderPainted(false);
        SampleSizeButton1.setContentAreaFilled(false);
        SampleSizeButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SampleSizeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SampleSizeButton1MouseEntered(evt);
            }
        });
        SampleSizeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSizeButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNApanelSub2M.add(SampleSizeButton1, gridBagConstraints);

        ExpPowerButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/power.png"))); // NOI18N
        ExpPowerButton1.setText("Experiment statistical  Power  ");
        ExpPowerButton1.setBorderPainted(false);
        ExpPowerButton1.setContentAreaFilled(false);
        ExpPowerButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExpPowerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpPowerButton1MouseEntered(evt);
            }
        });
        ExpPowerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpPowerButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNApanelSub2M.add(ExpPowerButton1, gridBagConstraints);

        DeseqButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        DeseqButton2.setText("DESeq2 analysis  ");
        DeseqButton2.setBorderPainted(false);
        DeseqButton2.setContentAreaFilled(false);
        DeseqButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DeseqButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeseqButton2MouseEntered(evt);
            }
        });
        DeseqButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseqButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        miRNApanelSub2M.add(DeseqButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        miRNApanelSub2.add(miRNApanelSub2M, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        miRNAPanel.add(miRNApanelSub2, gridBagConstraints);

        miRNAScrollPanel.setViewportView(miRNAPanel);

        jTabbedPane1.addTab("miRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/miRNAtab.png")), miRNAScrollPanel); // NOI18N

        ChipSeqScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        ChipSeqScrollPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        ChipSeqScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ChipSeqScrollPanel.setName("chipseq"); // NOI18N

        ChipSeqPanel.setBackground(new java.awt.Color(255, 255, 255));
        ChipSeqPanel.setName("chipseq"); // NOI18N
        ChipSeqPanel.setLayout(new java.awt.GridBagLayout());

        Macs2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqAl.png"))); // NOI18N
        Macs2Button.setText("MACS2  ");
        Macs2Button.setBorderPainted(false);
        Macs2Button.setContentAreaFilled(false);
        Macs2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Macs2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Macs2ButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Macs2ButtonMouseEntered(evt);
            }
        });
        Macs2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Macs2ButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ChipSeqPanel.add(Macs2Button, gridBagConstraints);

        chipseqbwaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        chipseqbwaButton.setText("Alignment with BWA");
        chipseqbwaButton.setBorderPainted(false);
        chipseqbwaButton.setContentAreaFilled(false);
        chipseqbwaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chipseqbwaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chipseqbwaButtonMouseEntered(evt);
            }
        });
        chipseqbwaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chipseqbwaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ChipSeqPanel.add(chipseqbwaButton, gridBagConstraints);

        bwaIndexChipseq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        bwaIndexChipseq.setText("BWA index");
        bwaIndexChipseq.setBorderPainted(false);
        bwaIndexChipseq.setContentAreaFilled(false);
        bwaIndexChipseq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bwaIndexChipseq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bwaIndexChipseqMouseEntered(evt);
            }
        });
        bwaIndexChipseq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bwaIndexChipseqActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ChipSeqPanel.add(bwaIndexChipseq, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqIndex.png"))); // NOI18N
        jButton4.setText("Result annotation by GTF");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        ChipSeqPanel.add(jButton4, gridBagConstraints);

        ChipSeqScrollPanel.setViewportView(ChipSeqPanel);

        jTabbedPane1.addTab("Chipseq", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/chipseqtab.png")), ChipSeqScrollPanel); // NOI18N

        CircRNAScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        CircRNAScrollPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        CircRNAScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        CircRNAScrollPanel.setName("circrna"); // NOI18N

        CircRNAPanel.setBackground(new java.awt.Color(255, 255, 255));
        CircRNAPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 0));
        CircRNAPanel.setName("circrna"); // NOI18N
        CircRNAPanel.setLayout(new java.awt.GridBagLayout());

        crnaP1.setLayout(new java.awt.GridBagLayout());

        PredictionPanel.setBackground(new java.awt.Color(255, 255, 255));
        PredictionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PredictionPanel.setLayout(new java.awt.GridBagLayout());

        Ciri2PredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/bwa.png"))); // NOI18N
        Ciri2PredictionButton.setText(" BWA+CIRI2  ");
        Ciri2PredictionButton.setBorderPainted(false);
        Ciri2PredictionButton.setContentAreaFilled(false);
        Ciri2PredictionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Ciri2PredictionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Ciri2PredictionButtonMouseEntered(evt);
            }
        });
        Ciri2PredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ciri2PredictionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(Ciri2PredictionButton, gridBagConstraints);

        Ciri2MergeResultsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/ciri.png"))); // NOI18N
        Ciri2MergeResultsButton.setText("Merge predictions  ");
        Ciri2MergeResultsButton.setBorderPainted(false);
        Ciri2MergeResultsButton.setContentAreaFilled(false);
        Ciri2MergeResultsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Ciri2MergeResultsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Ciri2MergeResultsButtonMouseEntered(evt);
            }
        });
        Ciri2MergeResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ciri2MergeResultsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(Ciri2MergeResultsButton, gridBagConstraints);

        StarChimericButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_starchimeric.png"))); // NOI18N
        StarChimericButton.setText("STAR Chimeric  ");
        StarChimericButton.setBorderPainted(false);
        StarChimericButton.setContentAreaFilled(false);
        StarChimericButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StarChimericButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StarChimericButtonMouseEntered(evt);
            }
        });
        StarChimericButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StarChimericButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(StarChimericButton, gridBagConstraints);

        StarchipCircleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_starchip.png"))); // NOI18N
        StarchipCircleButton.setText("STARchip Circle  ");
        StarchipCircleButton.setBorderPainted(false);
        StarchipCircleButton.setContentAreaFilled(false);
        StarchipCircleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StarchipCircleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StarchipCircleButtonMouseEntered(evt);
            }
        });
        StarchipCircleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StarchipCircleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(StarchipCircleButton, gridBagConstraints);

        wrapperSTARChipButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/bwa.png"))); // NOI18N
        wrapperSTARChipButton.setText("STAR +  STARChip  ");
        wrapperSTARChipButton.setBorderPainted(false);
        wrapperSTARChipButton.setContentAreaFilled(false);
        wrapperSTARChipButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        wrapperSTARChipButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                wrapperSTARChipButtonMouseEntered(evt);
            }
        });
        wrapperSTARChipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrapperSTARChipButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(wrapperSTARChipButton, gridBagConstraints);

        reformatPredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_reformat.png"))); // NOI18N
        reformatPredictionButton.setText("Reformat Predictions  ");
        reformatPredictionButton.setBorderPainted(false);
        reformatPredictionButton.setContentAreaFilled(false);
        reformatPredictionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reformatPredictionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reformatPredictionButtonMouseEntered(evt);
            }
        });
        reformatPredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reformatPredictionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(reformatPredictionButton, gridBagConstraints);

        overlapPredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_overlap.png"))); // NOI18N
        overlapPredictionButton.setText("Overlap Predictions  ");
        overlapPredictionButton.setBorderPainted(false);
        overlapPredictionButton.setContentAreaFilled(false);
        overlapPredictionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        overlapPredictionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                overlapPredictionButtonMouseEntered(evt);
            }
        });
        overlapPredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overlapPredictionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        PredictionPanel.add(overlapPredictionButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        crnaP1.add(PredictionPanel, gridBagConstraints);

        crnaPredictionLabel.setBackground(new java.awt.Color(237, 237, 237));
        crnaPredictionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crnaPredictionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png"))); // NOI18N
        crnaPredictionLabel.setText("Prediction");
        crnaPredictionLabel.setOpaque(true);
        crnaPredictionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crnaPredictionLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;
        crnaP1.add(crnaPredictionLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        CircRNAPanel.add(crnaP1, gridBagConstraints);

        crnaP2.setLayout(new java.awt.GridBagLayout());

        ClassificationAnnotationPanel.setBackground(new java.awt.Color(255, 255, 255));
        ClassificationAnnotationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ClassificationAnnotationPanel.setLayout(new java.awt.GridBagLayout());

        CirchunterClassificButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_classification.png"))); // NOI18N
        CirchunterClassificButton2.setText("CircHunter classification  ");
        CirchunterClassificButton2.setBorderPainted(false);
        CirchunterClassificButton2.setContentAreaFilled(false);
        CirchunterClassificButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CirchunterClassificButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CirchunterClassificButton2MouseEntered(evt);
            }
        });
        CirchunterClassificButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CirchunterClassificButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ClassificationAnnotationPanel.add(CirchunterClassificButton2, gridBagConstraints);

        circRNAAnnotationButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_annotation.png"))); // NOI18N
        circRNAAnnotationButton2.setText("Annotation  ");
        circRNAAnnotationButton2.setBorderPainted(false);
        circRNAAnnotationButton2.setContentAreaFilled(false);
        circRNAAnnotationButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        circRNAAnnotationButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                circRNAAnnotationButton2MouseEntered(evt);
            }
        });
        circRNAAnnotationButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circRNAAnnotationButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ClassificationAnnotationPanel.add(circRNAAnnotationButton2, gridBagConstraints);

        downloadExonIsoformDataButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_ref_preparation.png"))); // NOI18N
        downloadExonIsoformDataButton2.setText("Download Exon and Isoform Data  ");
        downloadExonIsoformDataButton2.setBorderPainted(false);
        downloadExonIsoformDataButton2.setContentAreaFilled(false);
        downloadExonIsoformDataButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        downloadExonIsoformDataButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downloadExonIsoformDataButton2MouseEntered(evt);
            }
        });
        downloadExonIsoformDataButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadExonIsoformDataButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ClassificationAnnotationPanel.add(downloadExonIsoformDataButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        crnaP2.add(ClassificationAnnotationPanel, gridBagConstraints);

        crnaClassificationLabel.setBackground(new java.awt.Color(237, 237, 237));
        crnaClassificationLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crnaClassificationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png"))); // NOI18N
        crnaClassificationLabel.setText("Classification and Annotation");
        crnaClassificationLabel.setOpaque(true);
        crnaClassificationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crnaClassificationLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;
        crnaP2.add(crnaClassificationLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        CircRNAPanel.add(crnaP2, gridBagConstraints);

        crnaP3.setLayout(new java.awt.GridBagLayout());

        SequenceAnalysisPanel.setBackground(new java.awt.Color(255, 255, 255));
        SequenceAnalysisPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SequenceAnalysisPanel.setLayout(new java.awt.GridBagLayout());

        BSJunctionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_seq.png"))); // NOI18N
        BSJunctionsButton.setText("Back-splicing Junctions  ");
        BSJunctionsButton.setBorderPainted(false);
        BSJunctionsButton.setContentAreaFilled(false);
        BSJunctionsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BSJunctionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BSJunctionsButtonMouseEntered(evt);
            }
        });
        BSJunctionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSJunctionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SequenceAnalysisPanel.add(BSJunctionsButton, gridBagConstraints);

        CircRNAStructurePredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_cirias.png"))); // NOI18N
        CircRNAStructurePredictionButton.setText("Predict Structure  ");
        CircRNAStructurePredictionButton.setBorderPainted(false);
        CircRNAStructurePredictionButton.setContentAreaFilled(false);
        CircRNAStructurePredictionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CircRNAStructurePredictionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CircRNAStructurePredictionButtonMouseEntered(evt);
            }
        });
        CircRNAStructurePredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircRNAStructurePredictionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        SequenceAnalysisPanel.add(CircRNAStructurePredictionButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        crnaP3.add(SequenceAnalysisPanel, gridBagConstraints);

        crnaSequenceLabel.setBackground(new java.awt.Color(237, 237, 237));
        crnaSequenceLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crnaSequenceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png"))); // NOI18N
        crnaSequenceLabel.setText("Sequence Analysis");
        crnaSequenceLabel.setOpaque(true);
        crnaSequenceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crnaSequenceLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.3;
        crnaP3.add(crnaSequenceLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        CircRNAPanel.add(crnaP3, gridBagConstraints);

        crnaP4.setLayout(new java.awt.GridBagLayout());

        ExpressionAnalysisPanel.setBackground(new java.awt.Color(255, 255, 255));
        ExpressionAnalysisPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ExpressionAnalysisPanel.setLayout(new java.awt.GridBagLayout());

        CircRNAQuantificationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/icon_quantification.png"))); // NOI18N
        CircRNAQuantificationButton.setText("Quantification  ");
        CircRNAQuantificationButton.setBorderPainted(false);
        CircRNAQuantificationButton.setContentAreaFilled(false);
        CircRNAQuantificationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CircRNAQuantificationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CircRNAQuantificationButtonMouseEntered(evt);
            }
        });
        CircRNAQuantificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CircRNAQuantificationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExpressionAnalysisPanel.add(CircRNAQuantificationButton, gridBagConstraints);

        circRNADESeqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        circRNADESeqButton.setText("DESeq2 analysis  ");
        circRNADESeqButton.setBorderPainted(false);
        circRNADESeqButton.setContentAreaFilled(false);
        circRNADESeqButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        circRNADESeqButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                circRNADESeqButtonMouseEntered(evt);
            }
        });
        circRNADESeqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circRNADESeqButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExpressionAnalysisPanel.add(circRNADESeqButton, gridBagConstraints);

        circRNAddingCovarsButtonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/circRNA_covariates.png"))); // NOI18N
        circRNAddingCovarsButtonButton.setText("Adding covariates and batches");
        circRNAddingCovarsButtonButton.setBorderPainted(false);
        circRNAddingCovarsButtonButton.setContentAreaFilled(false);
        circRNAddingCovarsButtonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        circRNAddingCovarsButtonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                circRNAddingCovarsButtonButtonMouseEntered(evt);
            }
        });
        circRNAddingCovarsButtonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circRNAddingCovarsButtonButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ExpressionAnalysisPanel.add(circRNAddingCovarsButtonButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        crnaP4.add(ExpressionAnalysisPanel, gridBagConstraints);

        crnaExpressionLabel.setBackground(new java.awt.Color(237, 237, 237));
        crnaExpressionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        crnaExpressionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png"))); // NOI18N
        crnaExpressionLabel.setText("Expression Analysis");
        crnaExpressionLabel.setOpaque(true);
        crnaExpressionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crnaExpressionLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 1.0;
        crnaP4.add(crnaExpressionLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        CircRNAPanel.add(crnaP4, gridBagConstraints);

        CircRNAScrollPanel.setViewportView(CircRNAPanel);

        jTabbedPane1.addTab("circRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cRNAtab.png")), CircRNAScrollPanel); // NOI18N

        sncRNAScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        sncRNAScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        sncRNAScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sncRNAScrollPane.setName("mirna2"); // NOI18N

        sncRNAPanel.setBackground(new java.awt.Color(255, 255, 255));
        sncRNAPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sncRNAPanel.setLayout(new java.awt.GridBagLayout());

        srnaP1.setLayout(new java.awt.GridBagLayout());

        sncrnaReferenceLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sncrnaReferenceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA.png"))); // NOI18N
        sncrnaReferenceLabel.setText("Reference definition and sRNA quantification");
        sncrnaReferenceLabel.setOpaque(true);
        sncrnaReferenceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sncrnaReferenceLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        srnaP1.add(sncrnaReferenceLabel, gridBagConstraints);

        srnaFirstStep.setBackground(new java.awt.Color(255, 255, 255));
        srnaFirstStep.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        srnaFirstStep.setLayout(new java.awt.GridBagLayout());

        mirnaQuantificationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA_count.png"))); // NOI18N
        mirnaQuantificationButton.setText("Quantification  ");
        mirnaQuantificationButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mirnaQuantificationButton.setBorderPainted(false);
        mirnaQuantificationButton.setContentAreaFilled(false);
        mirnaQuantificationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mirnaQuantificationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mirnaQuantificationButtonMouseEntered(evt);
            }
        });
        mirnaQuantificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirnaQuantificationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaFirstStep.add(mirnaQuantificationButton, gridBagConstraints);

        mirnaindexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        mirnaindexingButton.setText("Genome Indexing  ");
        mirnaindexingButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        mirnaindexingButton.setBorderPainted(false);
        mirnaindexingButton.setContentAreaFilled(false);
        mirnaindexingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mirnaindexingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mirnaindexingButtonMouseEntered(evt);
            }
        });
        mirnaindexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirnaindexingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaFirstStep.add(mirnaindexingButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        srnaP1.add(srnaFirstStep, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        sncRNAPanel.add(srnaP1, gridBagConstraints);

        srnaP2.setLayout(new java.awt.GridBagLayout());

        sncrnaPostProcessingLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sncrnaPostProcessingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA.png"))); // NOI18N
        sncrnaPostProcessingLabel.setText("Count table post-processes");
        sncrnaPostProcessingLabel.setOpaque(true);
        sncrnaPostProcessingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sncrnaPostProcessingLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        srnaP2.add(sncrnaPostProcessingLabel, gridBagConstraints);

        srnaPreprocessCounts.setBackground(new java.awt.Color(255, 255, 255));
        srnaPreprocessCounts.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        srnaPreprocessCounts.setLayout(new java.awt.GridBagLayout());

        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA_covariate.png"))); // NOI18N
        jButton61.setText("Adding covariates and batches   ");
        jButton61.setBorderPainted(false);
        jButton61.setContentAreaFilled(false);
        jButton61.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton61MouseEntered(evt);
            }
        });
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaPreprocessCounts.add(jButton61, gridBagConstraints);

        PCAButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/PCA.png"))); // NOI18N
        PCAButton2.setText(" PCA  analysis");
        PCAButton2.setBorderPainted(false);
        PCAButton2.setContentAreaFilled(false);
        PCAButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PCAButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PCAButton2MouseEntered(evt);
            }
        });
        PCAButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaPreprocessCounts.add(PCAButton2, gridBagConstraints);

        SampleSizeButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SampleSizeButton2.setText("Sample size estimator  ");
        SampleSizeButton2.setBorderPainted(false);
        SampleSizeButton2.setContentAreaFilled(false);
        SampleSizeButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SampleSizeButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SampleSizeButton2MouseEntered(evt);
            }
        });
        SampleSizeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSizeButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaPreprocessCounts.add(SampleSizeButton2, gridBagConstraints);

        ExpPowerButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/power.png"))); // NOI18N
        ExpPowerButton2.setText("Experiment statistical  Power  ");
        ExpPowerButton2.setBorderPainted(false);
        ExpPowerButton2.setContentAreaFilled(false);
        ExpPowerButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExpPowerButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpPowerButton2MouseEntered(evt);
            }
        });
        ExpPowerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpPowerButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaPreprocessCounts.add(ExpPowerButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        srnaP2.add(srnaPreprocessCounts, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        sncRNAPanel.add(srnaP2, gridBagConstraints);

        srnaP3.setLayout(new java.awt.GridBagLayout());

        srnaExpression.setBackground(new java.awt.Color(255, 255, 255));
        srnaExpression.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        srnaExpression.setLayout(new java.awt.GridBagLayout());

        DeseqButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        DeseqButton3.setText("DESeq2 analysis  ");
        DeseqButton3.setBorderPainted(false);
        DeseqButton3.setContentAreaFilled(false);
        DeseqButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DeseqButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeseqButton3MouseEntered(evt);
            }
        });
        DeseqButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseqButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaExpression.add(DeseqButton3, gridBagConstraints);

        CountButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        CountButton3.setText("Count Filter  ");
        CountButton3.setBorderPainted(false);
        CountButton3.setContentAreaFilled(false);
        CountButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CountButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CountButton3MouseEntered(evt);
            }
        });
        CountButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaExpression.add(CountButton3, gridBagConstraints);

        NovaLikeButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/anovaLike.png"))); // NOI18N
        NovaLikeButton3.setText("Anova Like  ");
        NovaLikeButton3.setBorderPainted(false);
        NovaLikeButton3.setContentAreaFilled(false);
        NovaLikeButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NovaLikeButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NovaLikeButton3MouseEntered(evt);
            }
        });
        NovaLikeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovaLikeButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        srnaExpression.add(NovaLikeButton3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        srnaP3.add(srnaExpression, gridBagConstraints);

        sncrnaExpressionAnaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sncrnaExpressionAnaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA.png"))); // NOI18N
        sncrnaExpressionAnaLabel.setText("Expression Analysis");
        sncrnaExpressionAnaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sncrnaExpressionAnaLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        srnaP3.add(sncrnaExpressionAnaLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        sncRNAPanel.add(srnaP3, gridBagConstraints);

        sncRNAScrollPane.setViewportView(sncRNAPanel);

        jTabbedPane1.addTab("sncRNA", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sncRNA.png")), sncRNAScrollPane); // NOI18N

        ToolScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        ToolScrollPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        ToolScrollPanel.setName("tools"); // NOI18N

        ToolPanel.setBackground(new java.awt.Color(255, 255, 255));
        ToolPanel.setName("tools"); // NOI18N
        ToolPanel.setLayout(new java.awt.GridBagLayout());

        MultiQCButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/MultiQC.png"))); // NOI18N
        MultiQCButton.setText("MultiQC analysis  ");
        MultiQCButton.setBorderPainted(false);
        MultiQCButton.setContentAreaFilled(false);
        MultiQCButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MultiQCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MultiQCButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MultiQCButtonMouseExited(evt);
            }
        });
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
        HeatmapButton.setBorderPainted(false);
        HeatmapButton.setContentAreaFilled(false);
        HeatmapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HeatmapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HeatmapButtonMouseEntered(evt);
            }
        });
        HeatmapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatmapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(HeatmapButton, gridBagConstraints);

        MergeMatrixButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/merge.png"))); // NOI18N
        MergeMatrixButton.setText("Merge Matrix");
        MergeMatrixButton.setBorderPainted(false);
        MergeMatrixButton.setContentAreaFilled(false);
        MergeMatrixButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MergeMatrixButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MergeMatrixButtonMouseEntered(evt);
            }
        });
        MergeMatrixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MergeMatrixButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(MergeMatrixButton, gridBagConstraints);

        subSetMatrixButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter_zero.png"))); // NOI18N
        subSetMatrixButton1.setText("subSet Matrix");
        subSetMatrixButton1.setBorderPainted(false);
        subSetMatrixButton1.setContentAreaFilled(false);
        subSetMatrixButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        subSetMatrixButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                subSetMatrixButton1MouseEntered(evt);
            }
        });
        subSetMatrixButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subSetMatrixButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(subSetMatrixButton1, gridBagConstraints);

        SC_dimension.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SC_dimension.setText("Matrix Dimension");
        SC_dimension.setBorderPainted(false);
        SC_dimension.setContentAreaFilled(false);
        SC_dimension.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_dimension.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_dimensionMouseEntered(evt);
            }
        });
        SC_dimension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_dimensionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(SC_dimension, gridBagConstraints);

        heatmaplyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap1.png"))); // NOI18N
        heatmaplyButton.setText("Heatmaply  ");
        heatmaplyButton.setBorderPainted(false);
        heatmaplyButton.setContentAreaFilled(false);
        heatmaplyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        heatmaplyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                heatmaplyButtonMouseEntered(evt);
            }
        });
        heatmaplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heatmaplyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(heatmaplyButton, gridBagConstraints);

        SparseToDense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter_zero.png"))); // NOI18N
        SparseToDense.setText("Sparse To Dense");
        SparseToDense.setBorderPainted(false);
        SparseToDense.setContentAreaFilled(false);
        SparseToDense.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SparseToDense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SparseToDenseMouseEntered(evt);
            }
        });
        SparseToDense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SparseToDenseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(SparseToDense, gridBagConstraints);

        DenseToSparse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter_zero.png"))); // NOI18N
        DenseToSparse.setText("Dense To Sparse");
        DenseToSparse.setBorderPainted(false);
        DenseToSparse.setContentAreaFilled(false);
        DenseToSparse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DenseToSparse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DenseToSparseMouseEntered(evt);
            }
        });
        DenseToSparse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DenseToSparseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(DenseToSparse, gridBagConstraints);

        STVisualization.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/st40.png"))); // NOI18N
        STVisualization.setText("ST Visualization");
        STVisualization.setBorderPainted(false);
        STVisualization.setContentAreaFilled(false);
        STVisualization.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        STVisualization.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                STVisualizationMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                STVisualizationMouseEntered(evt);
            }
        });
        STVisualization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STVisualizationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(STVisualization, gridBagConstraints);

        VioplotButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/vioplot.png"))); // NOI18N
        VioplotButton.setText("Vioplot HTML by genes");
        VioplotButton.setBorderPainted(false);
        VioplotButton.setContentAreaFilled(false);
        VioplotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VioplotButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(VioplotButton, gridBagConstraints);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        jButton7.setText("Bulk Clusters  ");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        ToolPanel.add(jButton7, gridBagConstraints);

        ToolScrollPanel.setViewportView(ToolPanel);

        jTabbedPane1.addTab("Tools", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/tooltab.png")), ToolScrollPanel); // NOI18N

        SingleCellScrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        SingleCellScrollPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        SingleCellScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        SingleCellScrollPanel.setName("singlecell"); // NOI18N

        SingleCellPanel.setBackground(new java.awt.Color(255, 255, 255));
        SingleCellPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SingleCellPanel.setName("singlecell"); // NOI18N
        SingleCellPanel.setLayout(new java.awt.GridBagLayout());

        SubCountGenerationPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubCountGenerationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SubCountGenerationPanel.setLayout(new java.awt.GridBagLayout());

        sc_countsGenerationLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sc_countsGenerationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCellB.png"))); // NOI18N
        sc_countsGenerationLabel.setText("Counts Generation");
        sc_countsGenerationLabel.setOpaque(true);
        sc_countsGenerationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc_countsGenerationLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        SubCountGenerationPanel.add(sc_countsGenerationLabel, gridBagConstraints);

        sc_innerPanel1.setBackground(new java.awt.Color(255, 255, 255));
        sc_innerPanel1.setLayout(new java.awt.GridBagLayout());

        SC_IndropIndexButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/indrop_counts.png"))); // NOI18N
        SC_IndropIndexButton.setText("Indrop Index  ");
        SC_IndropIndexButton.setBorderPainted(false);
        SC_IndropIndexButton.setContentAreaFilled(false);
        SC_IndropIndexButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_IndropIndexButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_IndropIndexButtonMouseEntered(evt);
            }
        });
        SC_IndropIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_IndropIndexButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel1.add(SC_IndropIndexButton, gridBagConstraints);

        SC_IndropCountsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/indrop_counts.png"))); // NOI18N
        SC_IndropCountsButton.setText("Indrop Counts  ");
        SC_IndropCountsButton.setBorderPainted(false);
        SC_IndropCountsButton.setContentAreaFilled(false);
        SC_IndropCountsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_IndropCountsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_IndropCountsButtonMouseEntered(evt);
            }
        });
        SC_IndropCountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_IndropCountsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel1.add(SC_IndropCountsButton, gridBagConstraints);

        SC_CellRangerCountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cellranger_count.png"))); // NOI18N
        SC_CellRangerCountButton.setText("10XGenomics Counts Generation  ");
        SC_CellRangerCountButton.setBorderPainted(false);
        SC_CellRangerCountButton.setContentAreaFilled(false);
        SC_CellRangerCountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_CellRangerCountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_CellRangerCountButtonMouseEntered(evt);
            }
        });
        SC_CellRangerCountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_CellRangerCountButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel1.add(SC_CellRangerCountButton, gridBagConstraints);

        SC_IndropCountsButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/cellranger_count.png"))); // NOI18N
        SC_IndropCountsButton1.setText("10XGenomics Index  ");
        SC_IndropCountsButton1.setBorderPainted(false);
        SC_IndropCountsButton1.setContentAreaFilled(false);
        SC_IndropCountsButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_IndropCountsButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_IndropCountsButton1MouseEntered(evt);
            }
        });
        SC_IndropCountsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_IndropCountsButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel1.add(SC_IndropCountsButton1, gridBagConstraints);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/st40.png"))); // NOI18N
        jButton5.setText("Spatial Counts Generation  ");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel1.add(jButton5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        SubCountGenerationPanel.add(sc_innerPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        SingleCellPanel.add(SubCountGenerationPanel, gridBagConstraints);

        SubCountManipulationPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubCountManipulationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SubCountManipulationPanel.setLayout(new java.awt.GridBagLayout());

        sc_countsManipulationLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sc_countsManipulationLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCellB.png"))); // NOI18N
        sc_countsManipulationLabel.setText("Counts Manipulation");
        sc_countsManipulationLabel.setOpaque(true);
        sc_countsManipulationLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc_countsManipulationLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        SubCountManipulationPanel.add(sc_countsManipulationLabel, gridBagConstraints);

        sc_innerPanel2.setBackground(new java.awt.Color(255, 255, 255));
        sc_innerPanel2.setLayout(new java.awt.GridBagLayout());

        SC_CCRemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/ccremove.png"))); // NOI18N
        SC_CCRemoveButton.setText("Cell cycle normalization");
        SC_CCRemoveButton.setBorderPainted(false);
        SC_CCRemoveButton.setContentAreaFilled(false);
        SC_CCRemoveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_CCRemoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_CCRemoveButtonMouseEntered(evt);
            }
        });
        SC_CCRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_CCRemoveButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_CCRemoveButton, gridBagConstraints);

        SC_ScannoByGtfButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/ScannoByGTF.png"))); // NOI18N
        SC_ScannoByGtfButton.setText("Annotation and Ribo/Mito filtering");
        SC_ScannoByGtfButton.setBorderPainted(false);
        SC_ScannoByGtfButton.setContentAreaFilled(false);
        SC_ScannoByGtfButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ScannoByGtfButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ScannoByGtfButtonMouseEntered(evt);
            }
        });
        SC_ScannoByGtfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ScannoByGtfButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_ScannoByGtfButton, gridBagConstraints);

        SC_UmiNormButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/count_depth.png"))); // NOI18N
        SC_UmiNormButton.setText("Normalizing samples");
        SC_UmiNormButton.setBorderPainted(false);
        SC_UmiNormButton.setContentAreaFilled(false);
        SC_UmiNormButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_UmiNormButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_UmiNormButtonMouseEntered(evt);
            }
        });
        SC_UmiNormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_UmiNormButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_UmiNormButton, gridBagConstraints);

        SC_GenesUmiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/gene_UMI.png"))); // NOI18N
        SC_GenesUmiButton.setText("Genes vs counts");
        SC_GenesUmiButton.setBorderPainted(false);
        SC_GenesUmiButton.setContentAreaFilled(false);
        SC_GenesUmiButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_GenesUmiButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_GenesUmiButtonMouseEntered(evt);
            }
        });
        SC_GenesUmiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_GenesUmiButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_GenesUmiButton, gridBagConstraints);

        SC_FilterZerosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter_zero.png"))); // NOI18N
        SC_FilterZerosButton.setText("Filter zeros  ");
        SC_FilterZerosButton.setBorderPainted(false);
        SC_FilterZerosButton.setContentAreaFilled(false);
        SC_FilterZerosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_FilterZerosButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_FilterZerosButtonMouseEntered(evt);
            }
        });
        SC_FilterZerosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_FilterZerosButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_FilterZerosButton, gridBagConstraints);

        SC_RecatPredictionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/ccremove.png"))); // NOI18N
        SC_RecatPredictionButton.setText("Cell cycle estimation");
        SC_RecatPredictionButton.setBorderPainted(false);
        SC_RecatPredictionButton.setContentAreaFilled(false);
        SC_RecatPredictionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_RecatPredictionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_RecatPredictionButtonMouseEntered(evt);
            }
        });
        SC_RecatPredictionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_RecatPredictionButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_RecatPredictionButton, gridBagConstraints);

        SC_SCNormButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/count_depth.png"))); // NOI18N
        SC_SCNormButton.setText("Normalizing sequencing depth");
        SC_SCNormButton.setBorderPainted(false);
        SC_SCNormButton.setContentAreaFilled(false);
        SC_SCNormButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_SCNormButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_SCNormButtonMouseEntered(evt);
            }
        });
        SC_SCNormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SCNormButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_SCNormButton, gridBagConstraints);

        SC_TopXButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/topX.png"))); // NOI18N
        SC_TopXButton.setText("Select by expression");
        SC_TopXButton.setBorderPainted(false);
        SC_TopXButton.setContentAreaFilled(false);
        SC_TopXButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_TopXButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_TopXButtonMouseEntered(evt);
            }
        });
        SC_TopXButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_TopXButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_TopXButton, gridBagConstraints);

        SC_CountDepthButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/count_depth.png"))); // NOI18N
        SC_CountDepthButton.setText("Estimating sequencing depth");
        SC_CountDepthButton.setBorderPainted(false);
        SC_CountDepthButton.setContentAreaFilled(false);
        SC_CountDepthButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_CountDepthButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_CountDepthButtonMouseEntered(evt);
            }
        });
        SC_CountDepthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_CountDepthButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_CountDepthButton, gridBagConstraints);

        SC_LorenzFilterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/lorenz_filter.png"))); // NOI18N
        SC_LorenzFilterButton.setText("Lorenz filtering  ");
        SC_LorenzFilterButton.setBorderPainted(false);
        SC_LorenzFilterButton.setContentAreaFilled(false);
        SC_LorenzFilterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_LorenzFilterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_LorenzFilterButtonMouseEntered(evt);
            }
        });
        SC_LorenzFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_LorenzFilterButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_LorenzFilterButton, gridBagConstraints);

        SC_Counts2LogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/log.png"))); // NOI18N
        SC_Counts2LogButton.setText("Counts to log counts");
        SC_Counts2LogButton.setBorderPainted(false);
        SC_Counts2LogButton.setContentAreaFilled(false);
        SC_Counts2LogButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_Counts2LogButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_Counts2LogButtonMouseEntered(evt);
            }
        });
        SC_Counts2LogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_Counts2LogButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_Counts2LogButton, gridBagConstraints);

        SC_SeuratCellCycleEstimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/ccremove.png"))); // NOI18N
        SC_SeuratCellCycleEstimation.setText("Seurat cell cycle estimation");
        SC_SeuratCellCycleEstimation.setBorderPainted(false);
        SC_SeuratCellCycleEstimation.setContentAreaFilled(false);
        SC_SeuratCellCycleEstimation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SeuratCellCycleEstimationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(SC_SeuratCellCycleEstimation, gridBagConstraints);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/saver.png"))); // NOI18N
        jButton8.setText("SAVER normalisation  ");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel2.add(jButton8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        SubCountManipulationPanel.add(sc_innerPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        SingleCellPanel.add(SubCountManipulationPanel, gridBagConstraints);

        SubClusteringPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubClusteringPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SubClusteringPanel.setLayout(new java.awt.GridBagLayout());

        sc_clusteringLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sc_clusteringLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCellB.png"))); // NOI18N
        sc_clusteringLabel.setText("Clustering");
        sc_clusteringLabel.setOpaque(true);
        sc_clusteringLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc_clusteringLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        SubClusteringPanel.add(sc_clusteringLabel, gridBagConstraints);

        sc_innerPanel3.setBackground(new java.awt.Color(255, 255, 255));
        sc_innerPanel3.setLayout(new java.awt.GridBagLayout());

        SC_BootstrapVideoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Bootstrap Video.png"))); // NOI18N
        SC_BootstrapVideoButton.setText("Perturbation effects video");
        SC_BootstrapVideoButton.setBorderPainted(false);
        SC_BootstrapVideoButton.setContentAreaFilled(false);
        SC_BootstrapVideoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_BootstrapVideoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_BootstrapVideoButtonMouseEntered(evt);
            }
        });
        SC_BootstrapVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_BootstrapVideoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_BootstrapVideoButton, gridBagConstraints);

        SC_SimlrBootstrapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_SimlrBootstrapButton.setText("Clustering with SIMLR");
        SC_SimlrBootstrapButton.setBorderPainted(false);
        SC_SimlrBootstrapButton.setContentAreaFilled(false);
        SC_SimlrBootstrapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_SimlrBootstrapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_SimlrBootstrapButtonMouseEntered(evt);
            }
        });
        SC_SimlrBootstrapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SimlrBootstrapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_SimlrBootstrapButton, gridBagConstraints);

        SC_SeuratBootstrapButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Seurat Bootstrap.png"))); // NOI18N
        SC_SeuratBootstrapButton.setText("Clustering with Seurat");
        SC_SeuratBootstrapButton.setBorderPainted(false);
        SC_SeuratBootstrapButton.setContentAreaFilled(false);
        SC_SeuratBootstrapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_SeuratBootstrapButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_SeuratBootstrapButtonMouseEntered(evt);
            }
        });
        SC_SeuratBootstrapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SeuratBootstrapButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_SeuratBootstrapButton, gridBagConstraints);

        SC_ClusteringNgriphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_ClusteringNgriphButton.setText("Defining a range of number of Clusters to inspect with SIMLR  ");
        SC_ClusteringNgriphButton.setBorderPainted(false);
        SC_ClusteringNgriphButton.setContentAreaFilled(false);
        SC_ClusteringNgriphButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClusteringNgriphButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClusteringNgriphButtonMouseEntered(evt);
            }
        });
        SC_ClusteringNgriphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClusteringNgriphButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ClusteringNgriphButton, gridBagConstraints);

        SC_SeuratPCAEvalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/gene_UMI.png"))); // NOI18N
        SC_SeuratPCAEvalButton.setText("Estimating PCA range for Seurat");
        SC_SeuratPCAEvalButton.setBorderPainted(false);
        SC_SeuratPCAEvalButton.setContentAreaFilled(false);
        SC_SeuratPCAEvalButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_SeuratPCAEvalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_SeuratPCAEvalButtonMouseEntered(evt);
            }
        });
        SC_SeuratPCAEvalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SeuratPCAEvalButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_SeuratPCAEvalButton, gridBagConstraints);

        SC_TsneBootstrap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_TsneBootstrap.setText("Clustering with tSne");
        SC_TsneBootstrap.setBorderPainted(false);
        SC_TsneBootstrap.setContentAreaFilled(false);
        SC_TsneBootstrap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_TsneBootstrap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_TsneBootstrapMouseEntered(evt);
            }
        });
        SC_TsneBootstrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_TsneBootstrapActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_TsneBootstrap, gridBagConstraints);

        SC_ClusterStabilityButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/hierarchical-structure.jpg"))); // NOI18N
        SC_ClusterStabilityButton.setText("Estimating Cluster Stability");
        SC_ClusterStabilityButton.setBorderPainted(false);
        SC_ClusterStabilityButton.setContentAreaFilled(false);
        SC_ClusterStabilityButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClusterStabilityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClusterStabilityButtonMouseEntered(evt);
            }
        });
        SC_ClusterStabilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClusterStabilityButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ClusterStabilityButton, gridBagConstraints);

        S_crossLabelButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Indrop.jpg"))); // NOI18N
        S_crossLabelButton1.setText("Cross Label");
        S_crossLabelButton1.setBorderPainted(false);
        S_crossLabelButton1.setContentAreaFilled(false);
        S_crossLabelButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        S_crossLabelButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                S_crossLabelButton1MouseEntered(evt);
            }
        });
        S_crossLabelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_crossLabelButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(S_crossLabelButton1, gridBagConstraints);

        SC_unstableFilteringButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        SC_unstableFilteringButton.setText("UnstableFiltering");
        SC_unstableFilteringButton.setBorderPainted(false);
        SC_unstableFilteringButton.setContentAreaFilled(false);
        SC_unstableFilteringButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_unstableFilteringButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_unstableFilteringButtonMouseEntered(evt);
            }
        });
        SC_unstableFilteringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_unstableFilteringButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_unstableFilteringButton, gridBagConstraints);

        SC_ClusterSplit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        SC_ClusterSplit.setText("Split in Clusters");
        SC_ClusterSplit.setBorderPainted(false);
        SC_ClusterSplit.setContentAreaFilled(false);
        SC_ClusterSplit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClusterSplit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClusterSplitMouseEntered(evt);
            }
        });
        SC_ClusterSplit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClusterSplitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ClusterSplit, gridBagConstraints);

        SC_ClusteringNgriphButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_ClusteringNgriphButton1.setText("Sharp Large scala dataset Clustering");
        SC_ClusteringNgriphButton1.setBorderPainted(false);
        SC_ClusteringNgriphButton1.setContentAreaFilled(false);
        SC_ClusteringNgriphButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClusteringNgriphButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClusteringNgriphButton1MouseEntered(evt);
            }
        });
        SC_ClusteringNgriphButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClusteringNgriphButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ClusteringNgriphButton1, gridBagConstraints);

        SC_ScanpyBootstrap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_ScanpyBootstrap.setText("Clustering with Scanpy");
        SC_ScanpyBootstrap.setBorderPainted(false);
        SC_ScanpyBootstrap.setContentAreaFilled(false);
        SC_ScanpyBootstrap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ScanpyBootstrap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ScanpyBootstrapMouseEntered(evt);
            }
        });
        SC_ScanpyBootstrap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ScanpyBootstrapActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ScanpyBootstrap, gridBagConstraints);

        SC_ClusteringNgriphButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/clusteringNgriph.png"))); // NOI18N
        SC_ClusteringNgriphButton2.setText("Griph Large scala dataset Clustering");
        SC_ClusteringNgriphButton2.setBorderPainted(false);
        SC_ClusteringNgriphButton2.setContentAreaFilled(false);
        SC_ClusteringNgriphButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClusteringNgriphButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClusteringNgriphButton2MouseEntered(evt);
            }
        });
        SC_ClusteringNgriphButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClusteringNgriphButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel3.add(SC_ClusteringNgriphButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        SubClusteringPanel.add(sc_innerPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        SingleCellPanel.add(SubClusteringPanel, gridBagConstraints);

        SubFeatureSelectionPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubFeatureSelectionPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        SubFeatureSelectionPanel.setLayout(new java.awt.GridBagLayout());

        sc_FeatureSelectionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sc_FeatureSelectionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCellB.png"))); // NOI18N
        sc_FeatureSelectionLabel.setText("Feature Selection");
        sc_FeatureSelectionLabel.setToolTipText("");
        sc_FeatureSelectionLabel.setOpaque(true);
        sc_FeatureSelectionLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc_FeatureSelectionLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        SubFeatureSelectionPanel.add(sc_FeatureSelectionLabel, gridBagConstraints);

        sc_innerPanel4.setBackground(new java.awt.Color(255, 255, 255));
        sc_innerPanel4.setLayout(new java.awt.GridBagLayout());

        SC_GenesSelectionSIMLRButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        SC_GenesSelectionSIMLRButton.setText("Genes selection with SIMLR  ");
        SC_GenesSelectionSIMLRButton.setBorderPainted(false);
        SC_GenesSelectionSIMLRButton.setContentAreaFilled(false);
        SC_GenesSelectionSIMLRButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_GenesSelectionSIMLRButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_GenesSelectionSIMLRButtonMouseEntered(evt);
            }
        });
        SC_GenesSelectionSIMLRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_GenesSelectionSIMLRButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_GenesSelectionSIMLRButton, gridBagConstraints);

        SC_HFCButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/heatmap.png"))); // NOI18N
        SC_HFCButton.setText("Clusters heatmap");
        SC_HFCButton.setBorderPainted(false);
        SC_HFCButton.setContentAreaFilled(false);
        SC_HFCButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_HFCButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_HFCButtonMouseEntered(evt);
            }
        });
        SC_HFCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_HFCButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_HFCButton, gridBagConstraints);

        SC_AnovaLikeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/anlovalike.png"))); // NOI18N
        SC_AnovaLikeButton.setText("Anova Like  ");
        SC_AnovaLikeButton.setBorderPainted(false);
        SC_AnovaLikeButton.setContentAreaFilled(false);
        SC_AnovaLikeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_AnovaLikeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_AnovaLikeButtonMouseEntered(evt);
            }
        });
        SC_AnovaLikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_AnovaLikeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_AnovaLikeButton, gridBagConstraints);

        SC_SeuratPriorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        SC_SeuratPriorButton.setText("Genes prioritization with Seurat");
        SC_SeuratPriorButton.setBorderPainted(false);
        SC_SeuratPriorButton.setContentAreaFilled(false);
        SC_SeuratPriorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_SeuratPriorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_SeuratPriorButtonMouseEntered(evt);
            }
        });
        SC_SeuratPriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_SeuratPriorButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_SeuratPriorButton, gridBagConstraints);

        SC_ClustersFeaturesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SC_ClustersFeaturesButton.setText("Anova like gene features counts table");
        SC_ClustersFeaturesButton.setBorderPainted(false);
        SC_ClustersFeaturesButton.setContentAreaFilled(false);
        SC_ClustersFeaturesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_ClustersFeaturesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_ClustersFeaturesButtonMouseEntered(evt);
            }
        });
        SC_ClustersFeaturesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_ClustersFeaturesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_ClustersFeaturesButton, gridBagConstraints);

        SC_GenesPrioritizSIMLRButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        SC_GenesPrioritizSIMLRButton.setText("Genes prioritization with SIMLR  ");
        SC_GenesPrioritizSIMLRButton.setBorderPainted(false);
        SC_GenesPrioritizSIMLRButton.setContentAreaFilled(false);
        SC_GenesPrioritizSIMLRButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_GenesPrioritizSIMLRButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_GenesPrioritizSIMLRButtonMouseEntered(evt);
            }
        });
        SC_GenesPrioritizSIMLRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_GenesPrioritizSIMLRButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_GenesPrioritizSIMLRButton, gridBagConstraints);

        SC_DeTwoGroupsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/anlovalike.png"))); // NOI18N
        SC_DeTwoGroupsButton.setText("De Two groups");
        SC_DeTwoGroupsButton.setBorderPainted(false);
        SC_DeTwoGroupsButton.setContentAreaFilled(false);
        SC_DeTwoGroupsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_DeTwoGroupsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_DeTwoGroupsButtonMouseEntered(evt);
            }
        });
        SC_DeTwoGroupsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_DeTwoGroupsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_DeTwoGroupsButton, gridBagConstraints);

        SC_GenesSelectionSIMLRButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        SC_GenesSelectionSIMLRButton1.setText("Genes selection with Comet   ");
        SC_GenesSelectionSIMLRButton1.setBorderPainted(false);
        SC_GenesSelectionSIMLRButton1.setContentAreaFilled(false);
        SC_GenesSelectionSIMLRButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SC_GenesSelectionSIMLRButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SC_GenesSelectionSIMLRButton1MouseEntered(evt);
            }
        });
        SC_GenesSelectionSIMLRButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_GenesSelectionSIMLRButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_innerPanel4.add(SC_GenesSelectionSIMLRButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        SubFeatureSelectionPanel.add(sc_innerPanel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        SingleCellPanel.add(SubFeatureSelectionPanel, gridBagConstraints);

        SubBottomPanel.setBackground(new java.awt.Color(255, 255, 255));
        SubBottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout SubBottomPanelLayout = new javax.swing.GroupLayout(SubBottomPanel);
        SubBottomPanel.setLayout(SubBottomPanelLayout);
        SubBottomPanelLayout.setHorizontalGroup(
            SubBottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
        SubBottomPanelLayout.setVerticalGroup(
            SubBottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 60.0;
        SingleCellPanel.add(SubBottomPanel, gridBagConstraints);

        subAutoencoderPanel.setLayout(new java.awt.GridBagLayout());

        sc_autoencoderLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sc_autoencoderLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCellB.png"))); // NOI18N
        sc_autoencoderLabel.setText("Pipeline Autoencoder");
        sc_autoencoderLabel.setToolTipText("");
        sc_autoencoderLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc_autoencoderLabelMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        subAutoencoderPanel.add(sc_autoencoderLabel, gridBagConstraints);

        sc_autoencoderPanel.setBackground(new java.awt.Color(255, 255, 255));
        sc_autoencoderPanel.setLayout(new java.awt.GridBagLayout());

        autoencoderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        autoencoderButton.setText("Autoencoder");
        autoencoderButton.setBorderPainted(false);
        autoencoderButton.setContentAreaFilled(false);
        autoencoderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoencoderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(autoencoderButton, gridBagConstraints);

        autoencoderClusteringButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        autoencoderClusteringButton.setText("Autoencoder Clustering");
        autoencoderClusteringButton.setBorderPainted(false);
        autoencoderClusteringButton.setContentAreaFilled(false);
        autoencoderClusteringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoencoderClusteringButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(autoencoderClusteringButton, gridBagConstraints);

        autoencoderAnalysisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        autoencoderAnalysisButton.setText("Autoencoder Analysis");
        autoencoderAnalysisButton.setBorderPainted(false);
        autoencoderAnalysisButton.setContentAreaFilled(false);
        autoencoderAnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoencoderAnalysisButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(autoencoderAnalysisButton, gridBagConstraints);

        autoencoderFeaturesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        autoencoderFeaturesButton.setText("Autoencoder Features");
        autoencoderFeaturesButton.setBorderPainted(false);
        autoencoderFeaturesButton.setContentAreaFilled(false);
        autoencoderFeaturesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoencoderFeaturesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(autoencoderFeaturesButton, gridBagConstraints);

        autoencoderCometButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        autoencoderCometButton.setText("Autoencoder Comet");
        autoencoderCometButton.setBorderPainted(false);
        autoencoderCometButton.setContentAreaFilled(false);
        autoencoderCometButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoencoderCometButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(autoencoderCometButton, gridBagConstraints);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/AE.png"))); // NOI18N
        jButton6.setText("Autoencoder Wrapper");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        sc_autoencoderPanel.add(jButton6, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        subAutoencoderPanel.add(sc_autoencoderPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        SingleCellPanel.add(subAutoencoderPanel, gridBagConstraints);

        SingleCellScrollPanel.setViewportView(SingleCellPanel);

        jTabbedPane1.addTab("Single Cell", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/SingleCell.png")), SingleCellScrollPanel); // NOI18N

        RNAScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        RNAScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 5, 7, 5));
        RNAScrollPane.setHorizontalScrollBar(null);
        RNAScrollPane.setName("rnaseq"); // NOI18N

        RNAseqPanel.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        RNAseqPanel.setName("rnaseq"); // NOI18N
        RNAseqPanel.setLayout(new java.awt.GridBagLayout());

        RNAseqPanelSub1.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanelSub1.setLayout(new java.awt.GridBagLayout());

        jLabelRNAseq1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelRNAseq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtabB.png"))); // NOI18N
        jLabelRNAseq1.setText("Count table generation");
        jLabelRNAseq1.setOpaque(true);
        jLabelRNAseq1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRNAseq1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        RNAseqPanelSub1.add(jLabelRNAseq1, gridBagConstraints);

        RNAseqPanelSub1M.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanelSub1M.setLayout(new java.awt.GridBagLayout());

        vmRNAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        vmRNAButton.setText("Genome indexing STAR-RSEM  ");
        vmRNAButton.setBorderPainted(false);
        vmRNAButton.setContentAreaFilled(false);
        vmRNAButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vmRNAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vmRNAButtonMouseEntered(evt);
            }
        });
        vmRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vmRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        RNAseqPanelSub1M.add(vmRNAButton, gridBagConstraints);

        mRNAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/DNAtab.png"))); // NOI18N
        mRNAButton.setText("Genes, isoforms counting RSEM  ");
        mRNAButton.setBorderPainted(false);
        mRNAButton.setContentAreaFilled(false);
        mRNAButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mRNAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mRNAButtonMouseEntered(evt);
            }
        });
        mRNAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRNAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanelSub1M.add(mRNAButton, gridBagConstraints);

        SalmonIndexingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/salmon.png"))); // NOI18N
        SalmonIndexingButton.setText("Trans. pseudo-reference building (Salmon)  ");
        SalmonIndexingButton.setBorderPainted(false);
        SalmonIndexingButton.setContentAreaFilled(false);
        SalmonIndexingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SalmonIndexingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalmonIndexingButtonMouseEntered(evt);
            }
        });
        SalmonIndexingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalmonIndexingButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanelSub1M.add(SalmonIndexingButton, gridBagConstraints);

        countingSalmonButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/salmon.png"))); // NOI18N
        countingSalmonButton.setText("Trans. and genes counting (Salmon)  ");
        countingSalmonButton.setBorderPainted(false);
        countingSalmonButton.setContentAreaFilled(false);
        countingSalmonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        countingSalmonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countingSalmonButtonMouseEntered(evt);
            }
        });
        countingSalmonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countingSalmonButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanelSub1M.add(countingSalmonButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanelSub1.add(RNAseqPanelSub1M, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanel.add(RNAseqPanelSub1, gridBagConstraints);

        RNAseqPanelSub2.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanelSub2.setLayout(new java.awt.GridBagLayout());

        jLabelRNAseq2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelRNAseq2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtabB.png"))); // NOI18N
        jLabelRNAseq2.setText("Count table post-processes");
        jLabelRNAseq2.setOpaque(true);
        jLabelRNAseq2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRNAseq2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 320;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        RNAseqPanelSub2.add(jLabelRNAseq2, gridBagConstraints);

        RNAseqPanelSub2M.setBackground(new java.awt.Color(255, 255, 255));
        RNAseqPanelSub2M.setLayout(new java.awt.GridBagLayout());

        SampleExpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/sample.png"))); // NOI18N
        SampleExpButton.setText("From samples to experiment  ");
        SampleExpButton.setBorderPainted(false);
        SampleExpButton.setContentAreaFilled(false);
        SampleExpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SampleExpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SampleExpButtonMouseEntered(evt);
            }
        });
        SampleExpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleExpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        RNAseqPanelSub2M.add(SampleExpButton, gridBagConstraints);

        PCAButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/PCA.png"))); // NOI18N
        PCAButton.setText(" PCA  analysis");
        PCAButton.setBorderPainted(false);
        PCAButton.setContentAreaFilled(false);
        PCAButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PCAButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PCAButtonMouseEntered(evt);
            }
        });
        PCAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCAButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(PCAButton, gridBagConstraints);

        SampleSizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/size.png"))); // NOI18N
        SampleSizeButton.setText("Sample size estimator  ");
        SampleSizeButton.setBorderPainted(false);
        SampleSizeButton.setContentAreaFilled(false);
        SampleSizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SampleSizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SampleSizeButtonMouseEntered(evt);
            }
        });
        SampleSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SampleSizeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(SampleSizeButton, gridBagConstraints);

        ExpPowerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/power.png"))); // NOI18N
        ExpPowerButton.setText("Experiment statistical  Power  ");
        ExpPowerButton.setBorderPainted(false);
        ExpPowerButton.setContentAreaFilled(false);
        ExpPowerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExpPowerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpPowerButtonMouseEntered(evt);
            }
        });
        ExpPowerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpPowerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(ExpPowerButton, gridBagConstraints);

        DeseqButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/Deseq2.png"))); // NOI18N
        DeseqButton.setText("DESeq2 analysis  ");
        DeseqButton.setBorderPainted(false);
        DeseqButton.setContentAreaFilled(false);
        DeseqButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DeseqButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeseqButtonMouseEntered(evt);
            }
        });
        DeseqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeseqButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(DeseqButton, gridBagConstraints);

        ANOVAlikeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/anovaLike.png"))); // NOI18N
        ANOVAlikeButton.setText("ANOVA-like  ");
        ANOVAlikeButton.setBorderPainted(false);
        ANOVAlikeButton.setContentAreaFilled(false);
        ANOVAlikeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ANOVAlikeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ANOVAlikeButtonMouseEntered(evt);
            }
        });
        ANOVAlikeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANOVAlikeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(ANOVAlikeButton, gridBagConstraints);

        CountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/filter.png"))); // NOI18N
        CountButton.setText("Count Filter  ");
        CountButton.setBorderPainted(false);
        CountButton.setContentAreaFilled(false);
        CountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CountButtonMouseEntered(evt);
            }
        });
        CountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        RNAseqPanelSub2M.add(CountButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        RNAseqPanelSub2.add(RNAseqPanelSub2M, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        RNAseqPanel.add(RNAseqPanelSub2, gridBagConstraints);

        RNAScrollPane.setViewportView(RNAseqPanel);

        jTabbedPane1.addTab("RNA seq", new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/RNAtab.png")), RNAScrollPane); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        LeftPanel.add(jTabbedPane1, gridBagConstraints);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        HorizontalSplitPanel.setLeftComponent(LeftPanel);

        VerticalSplitPanel.setTopComponent(HorizontalSplitPanel);

        getContentPane().add(VerticalSplitPanel, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 3, 5, 3));

        jMenu3.setText("File");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/52.png"))); // NOI18N
        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/86.png"))); // NOI18N
        jMenuItem4.setText("Save");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/preference.png"))); // NOI18N
        jMenuItem1.setText("Configure 4SeqGUI");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/download.png"))); // NOI18N
        jMenuItem8.setText("Download Docker Images");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/docker.png"))); // NOI18N
        jMenuItem2.setText("Remove Docker Containers");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkg4seqgui/images/tab.png"))); // NOI18N
        jMenuItem9.setText("Configure Tabs");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("?");
        jMenu5.setToolTipText("");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

    private boolean updateDockerImage(String imageName) {
        boolean returnValue = false; 
        String[] cmd = {"/bin/bash", "-c", String.format("docker pull %s", imageName)};
        
        try {
            Process pr = Runtime.getRuntime().exec(cmd);
            pr.waitFor(); 
            
            if (pr.exitValue() == 0) {
                JOptionPane.showMessageDialog(this,
                    "Docker image " + imageName + " has been updated.",
                    "Confermation",
                    JOptionPane.INFORMATION_MESSAGE);
                returnValue = true;
            }
            else {
                JOptionPane.showMessageDialog(this, 
                "Docker image " + imageName + " has not been updated", 
                "Error: Image update", 
                JOptionPane.ERROR_MESSAGE); 
            }
        } 
        catch (InterruptedException e) {
            //System.out.println("esploso per interruptedexc");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Docker image " + imageName + " has not been updated", 
                "Error: Image update", 
                JOptionPane.ERROR_MESSAGE); 
        }
        
        return returnValue;
    }
    
    
    private boolean  removeDockerImage(String imageName) {
        boolean returnValue = false;
        String[] cmd = {"/bin/bash", "-c", String.format("docker rmi %s", imageName)};

        try {
            Process pr = Runtime.getRuntime().exec(cmd);
            pr.waitFor(); 
            
            if (pr.exitValue() == 0) {
                JOptionPane.showMessageDialog(this,
                    "Docker image " + imageName + " has been removed.",
                    "Confermation",
                    JOptionPane.INFORMATION_MESSAGE);
                returnValue = true;
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Docker image " + imageName + " has not been removed", 
                    "Error: Image deletion", 
                    JOptionPane.ERROR_MESSAGE); 
            }
        }
        catch (InterruptedException e) {
            //System.out.println("esploso per interruptedexc");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(this, 
                "Docker image " + imageName + " has not been removed", 
                "Error: Image deletion", 
                JOptionPane.ERROR_MESSAGE); 
        }
        return returnValue;
    }

    private void  removeDockerContainer(java.awt.event.ActionEvent evt){
        String[] cmd = {
            "/bin/bash",
            "-c",
            " docker rm $(docker ps -q -f status=exited);" +
            " docker rm $(docker ps -q -f status=dead)"
        };
        try {
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
                File file = new File(String.format("%s/%s", tmpListEntry.path, tmpListEntry.logfile));
           //     File file = new File( tmpListEntry.path+"/Routput.Rout");
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
            //    File file = new File( tmpListEntry.path+"/Routput.Rout");
                File file = new File(String.format("%s/%s", tmpListEntry.path, tmpListEntry.logfile));
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                     String strLine;
                     //Read File Line By Line
                     while ((strLine = reader.readLine()) != null)  
                         text+="\n"+strLine;
                }
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
        browseTextFieldContent(this, Downloadtext, JFileChooser.FILES_ONLY);

        DownloadFrame.toFront();
        DownloadFrame.requestFocus();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void downloadDockerImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadDockerImagesButtonActionPerformed
        String containerListFile = Downloadtext.getText();
       
        if (containerListFile.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "You have to select the container list file.",
                "Error: Container list file", 
                JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        String outputFolder = Paths.get(containerListFile).getParent().toString();
        ScriptCaller params = new ScriptCaller("DownloadImage.R", outputFolder)
                .addArg("containers.file", containerListFile); 
        execCommand(this, "Download Docker images", params);
        
        DownloadFrame.setVisible(false);
        Downloadtext.setText("");
        getPreferences().put("4SeqGUI_WindowDownloadWidth", Integer.toString(DownloadFrame.getWidth()));
        getPreferences().put("4SeqGUI_WindowDownloadHeight", Integer.toString(DownloadFrame.getHeight()));

        dockerManager.addImages(containerListFile);
        dockerManager.updateGUI();
    }//GEN-LAST:event_downloadDockerImagesButtonActionPerformed

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
        setCard("multiqc");
    }//GEN-LAST:event_MultiQCButtonActionPerformed

    private void DeseqButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseqButton2ActionPerformed
        setCard("DES");
        DESPanel.dGeneRadioButton.setEnabled(true);
        DESPanel.dIsoformRadioButton.setEnabled(true);
        DESPanel.dmiRNARadioButton.setEnabled(true);
    }//GEN-LAST:event_DeseqButton2ActionPerformed

    private void ExpPowerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpPowerButton1ActionPerformed
        setCard("ExperimentPower");
    }//GEN-LAST:event_ExpPowerButton1ActionPerformed

    private void SampleSizeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSizeButton1ActionPerformed
        setCard("SampleSize");
    }//GEN-LAST:event_SampleSizeButton1ActionPerformed

    private void CountButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButton1ActionPerformed
        setCard("filtercounts");
    }//GEN-LAST:event_CountButton1ActionPerformed

    private void PCAButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAButton1ActionPerformed
        setCard("PCA");
    }//GEN-LAST:event_PCAButton1ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        setCard("AddingCovmRNA");
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        setCard("mRNA");
    }//GEN-LAST:event_jButton59ActionPerformed

    private void DeseqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseqButtonActionPerformed
        setCard("DES");
    }//GEN-LAST:event_DeseqButtonActionPerformed

    private void ExpPowerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpPowerButtonActionPerformed
        setCard("ExperimentPower");
    }//GEN-LAST:event_ExpPowerButtonActionPerformed

    private void SampleSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSizeButtonActionPerformed
        setCard("SampleSize");
    }//GEN-LAST:event_SampleSizeButtonActionPerformed

    private void CountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButtonActionPerformed
        setCard("filtercounts");
    }//GEN-LAST:event_CountButtonActionPerformed

    private void SampleExpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleExpButtonActionPerformed
        setCard("FPKMCounting");
    }//GEN-LAST:event_SampleExpButtonActionPerformed

    private void countingSalmonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countingSalmonButtonActionPerformed
        CountingSalmon.cThreadText.setText(Integer.toString(GS.getDefaultThread()));
        CountingSalmon.cAdapter5Text.setText(GS.getDefaultAdapter5());
        CountingSalmon.cAdapter3Text.setText(GS.getDefaultAdapter3());
        setCard("countingSalmon");
    }//GEN-LAST:event_countingSalmonButtonActionPerformed

    private void PCAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAButtonActionPerformed
        setCard("PCA");
    }//GEN-LAST:event_PCAButtonActionPerformed

    private void mRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRNAButtonActionPerformed
        vThreadText.setText(Integer.toString(GS.getDefaultThread()));
        vAdapter5Text.setText(GS.getDefaultAdapter5());
        vAdapter3Text.setText(GS.getDefaultAdapter3());
        setCard("vmRNA");
    }//GEN-LAST:event_mRNAButtonActionPerformed

    private void vmRNAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vmRNAButtonActionPerformed
        iThreadText.setText(Integer.toString(GS.getDefaultThread()));
        setCard("indexing");
    }//GEN-LAST:event_vmRNAButtonActionPerformed

    private void SalmonIndexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalmonIndexingButtonActionPerformed
        IndexingSalmon.iThreadSText.setText(Integer.toString(GS.getDefaultThread()));
        setCard("indexingSalmon");
    }//GEN-LAST:event_SalmonIndexingButtonActionPerformed

    private void HeatmapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeatmapButtonActionPerformed
        setCard("heatmap");
    }//GEN-LAST:event_HeatmapButtonActionPerformed

    private void ANOVAlikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANOVAlikeButtonActionPerformed
        setCard("NOVAlike");
    }//GEN-LAST:event_ANOVAlikeButtonActionPerformed

    private void Ciri2PredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ciri2PredictionButtonActionPerformed
        setCard("wrapperCiriCard");
    }//GEN-LAST:event_Ciri2PredictionButtonActionPerformed

    private void Ciri2MergeResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ciri2MergeResultsButtonActionPerformed
        setCard("circrnaMergeCiri2ResultsCard");
    }//GEN-LAST:event_Ciri2MergeResultsButtonActionPerformed

    private void StarChimericButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StarChimericButtonActionPerformed
        setCard("circrnaStarChimeric");
    }//GEN-LAST:event_StarChimericButtonActionPerformed

    private void StarchipCircleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StarchipCircleButtonActionPerformed
        setCard("circrnaStarPrediction");
    }//GEN-LAST:event_StarchipCircleButtonActionPerformed

    private void CirchunterClassificButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CirchunterClassificButton2ActionPerformed
        setCard("circRNA_ppCard");
    }//GEN-LAST:event_CirchunterClassificButton2ActionPerformed

    private void circRNAAnnotationButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circRNAAnnotationButton2ActionPerformed
        setCard("circrnaAnnotationCard");
    }//GEN-LAST:event_circRNAAnnotationButton2ActionPerformed

    private void downloadExonIsoformDataButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadExonIsoformDataButton2ActionPerformed
        setCard("circrnaPrepareFilesCard");
    }//GEN-LAST:event_downloadExonIsoformDataButton2ActionPerformed

    private void BSJunctionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSJunctionsButtonActionPerformed
        setCard("bsjunctionsCard");
    }//GEN-LAST:event_BSJunctionsButtonActionPerformed

    private void CircRNAStructurePredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircRNAStructurePredictionButtonActionPerformed
        setCard("circrnaStructureCard");
    }//GEN-LAST:event_CircRNAStructurePredictionButtonActionPerformed

    private void CircRNAQuantificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CircRNAQuantificationButtonActionPerformed
        setCard("circrnaquantifCard");
    }//GEN-LAST:event_CircRNAQuantificationButtonActionPerformed

    private void SC_IndropIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_IndropIndexButtonActionPerformed
        setCard("S_indropIndexCard");
    }//GEN-LAST:event_SC_IndropIndexButtonActionPerformed

    private void SC_IndropCountsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_IndropCountsButtonActionPerformed
        setCard("S_indropCountsCard");
    }//GEN-LAST:event_SC_IndropCountsButtonActionPerformed

    private void SC_CellRangerCountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_CellRangerCountButtonActionPerformed
        setCard("S_cellRangerCard");
    }//GEN-LAST:event_SC_CellRangerCountButtonActionPerformed

    private void SC_ScannoByGtfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ScannoByGtfButtonActionPerformed
        setCard("S_scannoByGtfCard");
    }//GEN-LAST:event_SC_ScannoByGtfButtonActionPerformed

    private void SC_TopXButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_TopXButtonActionPerformed
        setCard("S_topXCard");
    }//GEN-LAST:event_SC_TopXButtonActionPerformed

    private void SC_GenesUmiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_GenesUmiButtonActionPerformed
        setCard("S_genesUmiCard");
    }//GEN-LAST:event_SC_GenesUmiButtonActionPerformed

    private void SC_LorenzFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_LorenzFilterButtonActionPerformed
        setCard("S_lorenzFilterCard");
    }//GEN-LAST:event_SC_LorenzFilterButtonActionPerformed

    private void SC_SCNormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SCNormButtonActionPerformed
        setCard("S_scnormCard");
    }//GEN-LAST:event_SC_SCNormButtonActionPerformed

    private void SC_UmiNormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_UmiNormButtonActionPerformed
        setCard("S_umiNormCard");
    }//GEN-LAST:event_SC_UmiNormButtonActionPerformed

    private void SC_CountDepthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_CountDepthButtonActionPerformed
        setCard("S_countDepthCard");
    }//GEN-LAST:event_SC_CountDepthButtonActionPerformed

    private void SC_FilterZerosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_FilterZerosButtonActionPerformed
        setCard("S_filterZerosCard");
    }//GEN-LAST:event_SC_FilterZerosButtonActionPerformed

    private void SC_Counts2LogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_Counts2LogButtonActionPerformed
        setCard("S_counts2LogCard");
    }//GEN-LAST:event_SC_Counts2LogButtonActionPerformed

    private void SC_RecatPredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_RecatPredictionButtonActionPerformed
        setCard("S_recatPredictionCard");
    }//GEN-LAST:event_SC_RecatPredictionButtonActionPerformed

    private void SC_CCRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_CCRemoveButtonActionPerformed
        setCard("S_ccRemoveCard");
    }//GEN-LAST:event_SC_CCRemoveButtonActionPerformed

    private void SC_ClusteringNgriphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButtonActionPerformed
        setCard("clusterNgriphCard");
    }//GEN-LAST:event_SC_ClusteringNgriphButtonActionPerformed

    private void SC_SimlrBootstrapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SimlrBootstrapButtonActionPerformed
        setCard("simlrBootstrapCard");
    }//GEN-LAST:event_SC_SimlrBootstrapButtonActionPerformed

    private void SC_SeuratPCAEvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SeuratPCAEvalButtonActionPerformed
        setCard("S_seuratPCAEvalCard");
    }//GEN-LAST:event_SC_SeuratPCAEvalButtonActionPerformed

    private void SC_SeuratBootstrapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SeuratBootstrapButtonActionPerformed
        setCard("S_seuratBootstrapCard");
    }//GEN-LAST:event_SC_SeuratBootstrapButtonActionPerformed

    private void SC_TsneBootstrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_TsneBootstrapActionPerformed
        setCard("S_tsneBootstrapCard");
    }//GEN-LAST:event_SC_TsneBootstrapActionPerformed

    private void SC_BootstrapVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_BootstrapVideoButtonActionPerformed
        setCard("S_bootstrapsVideoCard");
    }//GEN-LAST:event_SC_BootstrapVideoButtonActionPerformed

    private void SC_AnovaLikeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_AnovaLikeButtonActionPerformed
        setCard("S_anovaLikeCard");
    }//GEN-LAST:event_SC_AnovaLikeButtonActionPerformed

    private void SC_ClustersFeaturesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClustersFeaturesButtonActionPerformed
        setCard("S_clustersFeaturesCard");
    }//GEN-LAST:event_SC_ClustersFeaturesButtonActionPerformed

    private void SC_HFCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_HFCButtonActionPerformed
        setCard("S_hfcCard");
    }//GEN-LAST:event_SC_HFCButtonActionPerformed

    private void SC_SeuratPriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SeuratPriorButtonActionPerformed
        setCard("S_seuratPriorCard");
    }//GEN-LAST:event_SC_SeuratPriorButtonActionPerformed

    private void SC_GenesPrioritizSIMLRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_GenesPrioritizSIMLRButtonActionPerformed
        setCard("S_genesPrioritizationCard");
    }//GEN-LAST:event_SC_GenesPrioritizSIMLRButtonActionPerformed

    private void SC_GenesSelectionSIMLRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_GenesSelectionSIMLRButtonActionPerformed
        setCard("S_genesSelectionCard");
    }//GEN-LAST:event_SC_GenesSelectionSIMLRButtonActionPerformed

    private void ConfigureTabsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigureTabsButtonActionPerformed
        ConfigureTabsFrame.pack();
        ConfigureTabsFrame.setLocationRelativeTo(null);
        ConfigureTabsFrame.setVisible(true);

        //enable and disable checkboxes based on saved preferences
        for (Component c: enableTabsPanel.getComponents()) {
            JCheckBox cb = (JCheckBox) c;
            String varname = String.format("4SeqGUI_EnableTab%s", cb.getName());
            String varvalue = getPreferences().get(varname, "true");

            cb.setSelected(varvalue.equals("true"));
        }
    }//GEN-LAST:event_ConfigureTabsButtonActionPerformed

    private void miRNATabCheckerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRNATabCheckerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miRNATabCheckerActionPerformed

    private void confermConfigureTabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermConfigureTabButtonActionPerformed
        ArrayList<String> disabledTabs = new ArrayList<>();

        //for each tab, set a variable to show/hide it
        for (Component c: enableTabsPanel.getComponents()) {
            JCheckBox cb = (JCheckBox) c;
            String varname = String.format("4SeqGUI_EnableTab%s", cb.getName());

            getPreferences().put(varname, String.valueOf(cb.isSelected()));

            if (!cb.isSelected())
                disabledTabs.add(c.getName());
        }

        tabsController.refreshTabs();

       // visualizeTabs();
        ConfigureTabsFrame.setVisible(false);
    }//GEN-LAST:event_confermConfigureTabButtonActionPerformed

    private void closeConfigureTabButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeConfigureTabButtonActionPerformed
        ConfigureTabsFrame.setVisible(false);
    }//GEN-LAST:event_closeConfigureTabButtonActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ConfigureTabsButtonActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void mirnaindexingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirnaindexingButtonActionPerformed
        setCard("mirnaIndex");
    }//GEN-LAST:event_mirnaindexingButtonActionPerformed

    private void mirnaQuantificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirnaQuantificationButtonActionPerformed
        setCard("mirnaQuantific");
    }//GEN-LAST:event_mirnaQuantificationButtonActionPerformed

    private void circRNADESeqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circRNADESeqButtonActionPerformed
        setCard("DES");
        DESPanel.dGeneRadioButton.setSelected(true);
        DESPanel.dGeneRadioButton.setEnabled(false);
        DESPanel.dIsoformRadioButton.setEnabled(false);
        DESPanel.dmiRNARadioButton.setEnabled(false);
    }//GEN-LAST:event_circRNADESeqButtonActionPerformed

    private void circRNAddingCovarsButtonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circRNAddingCovarsButtonButtonActionPerformed
        setCard("AddingCovmRNA");
    }//GEN-LAST:event_circRNAddingCovarsButtonButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        configurationMenuItemActionPerformed(evt);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void manageDockerImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDockerImagesButtonActionPerformed
        dockerImagesManager.pack();
        dockerImagesManager.setLocationRelativeTo(null);
        dockerImagesManager.setVisible(true);

        dockerManager.updateGUI();
    }//GEN-LAST:event_manageDockerImagesButtonActionPerformed




    private void addImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImagesButtonActionPerformed
        DownloadMenuItemActionPerformed(evt);
    }//GEN-LAST:event_addImagesButtonActionPerformed

    private void removeImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeImagesButtonActionPerformed
        dockerManager.removeImages();
    }//GEN-LAST:event_removeImagesButtonActionPerformed

    private void jLabelRNAseq1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRNAseq1MouseClicked
        toggleMenu(RNAseqPanelSub1M, jLabelRNAseq1, getClass().getResource("/pkg4seqgui/images/RNAtabB.png"));
    }//GEN-LAST:event_jLabelRNAseq1MouseClicked

    private void jLabelRNAseq2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRNAseq2MouseClicked
        toggleMenu(RNAseqPanelSub2M, jLabelRNAseq2, getClass().getResource("/pkg4seqgui/images/RNAtabB.png"));
    }//GEN-LAST:event_jLabelRNAseq2MouseClicked

    private void jLabelmiRNA1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelmiRNA1MouseClicked
        toggleMenu(miRNApanelSub1M, jLabelmiRNA1, getClass().getResource("/pkg4seqgui/images/miRNAtabB.png"));
    }//GEN-LAST:event_jLabelmiRNA1MouseClicked

    private void jLabelmiRNA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelmiRNA2MouseClicked
        toggleMenu(miRNApanelSub2M, jLabelmiRNA2, getClass().getResource("/pkg4seqgui/images/miRNAtabB.png"));
    }//GEN-LAST:event_jLabelmiRNA2MouseClicked

    /**
     * Toggle menu panel
     * @param panel Panel to toggle
     * @param label Label associated to the click event
     * @param img Icon to put when the panel is visible
     */
    private void toggleMenu(javax.swing.JPanel panel, javax.swing.JLabel label, java.net.URL img) {
        java.net.URL imgURLUP = getClass().getResource("/pkg4seqgui/images/download.png");
        boolean is_visible = panel.isVisible();

        ImageIcon image = new ImageIcon(is_visible ? imgURLUP : img);
        label.setIcon(image);
        panel.setVisible(!is_visible);
    }

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        setCard("AddingCovmRNA");
    }//GEN-LAST:event_jButton61ActionPerformed

    private void PCAButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCAButton2ActionPerformed
        setCard("PCA");
    }//GEN-LAST:event_PCAButton2ActionPerformed

    private void CountButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountButton3ActionPerformed
        setCard("filtercounts");
    }//GEN-LAST:event_CountButton3ActionPerformed

    private void SampleSizeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SampleSizeButton2ActionPerformed
        setCard("SampleSize");
    }//GEN-LAST:event_SampleSizeButton2ActionPerformed

    private void ExpPowerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpPowerButton2ActionPerformed
        setCard("ExperimentPower");
    }//GEN-LAST:event_ExpPowerButton2ActionPerformed

    private void DeseqButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeseqButton3ActionPerformed
        setCard("DES");
    }//GEN-LAST:event_DeseqButton3ActionPerformed

    private void crnaPredictionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crnaPredictionLabelMouseClicked
        toggleMenu(PredictionPanel, crnaPredictionLabel, getClass().getResource("/pkg4seqgui/images/cRNAtab.png"));
    }//GEN-LAST:event_crnaPredictionLabelMouseClicked

    private void crnaExpressionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crnaExpressionLabelMouseClicked
        toggleMenu(ExpressionAnalysisPanel, crnaExpressionLabel, getClass().getResource("/pkg4seqgui/images/cRNAtab.png"));
    }//GEN-LAST:event_crnaExpressionLabelMouseClicked

    private void crnaClassificationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crnaClassificationLabelMouseClicked
        toggleMenu(ClassificationAnnotationPanel, crnaClassificationLabel, getClass().getResource("/pkg4seqgui/images/cRNAtab.png"));
    }//GEN-LAST:event_crnaClassificationLabelMouseClicked

    private void crnaSequenceLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crnaSequenceLabelMouseClicked
        toggleMenu(SequenceAnalysisPanel, crnaSequenceLabel, getClass().getResource("/pkg4seqgui/images/cRNAtab.png"));
    }//GEN-LAST:event_crnaSequenceLabelMouseClicked

    private void SC_ClusterStabilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClusterStabilityButtonActionPerformed
        setCard("S_clusterStability");
    }//GEN-LAST:event_SC_ClusterStabilityButtonActionPerformed

    private void sncrnaReferenceLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sncrnaReferenceLabelMouseClicked
        toggleMenu(srnaFirstStep, sncrnaReferenceLabel, getClass().getResource("/pkg4seqgui/images/sncRNA.png"));
    }//GEN-LAST:event_sncrnaReferenceLabelMouseClicked

    private void sncrnaPostProcessingLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sncrnaPostProcessingLabelMouseClicked
        toggleMenu(srnaPreprocessCounts, sncrnaPostProcessingLabel, getClass().getResource("/pkg4seqgui/images/sncRNA.png"));
    }//GEN-LAST:event_sncrnaPostProcessingLabelMouseClicked

    private void sncrnaExpressionAnaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sncrnaExpressionAnaLabelMouseClicked
        toggleMenu(srnaExpression, sncrnaExpressionAnaLabel, getClass().getResource("/pkg4seqgui/images/sncRNA.png"));
    }//GEN-LAST:event_sncrnaExpressionAnaLabelMouseClicked

    private void sc_countsGenerationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc_countsGenerationLabelMouseClicked
        toggleMenu(sc_innerPanel1, sc_countsGenerationLabel, getClass().getResource("/pkg4seqgui/images/SingleCellB.png"));
    }//GEN-LAST:event_sc_countsGenerationLabelMouseClicked

    private void sc_countsManipulationLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc_countsManipulationLabelMouseClicked
        toggleMenu(sc_innerPanel2, sc_countsManipulationLabel, getClass().getResource("/pkg4seqgui/images/SingleCellB.png"));
    }//GEN-LAST:event_sc_countsManipulationLabelMouseClicked

    private void sc_clusteringLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc_clusteringLabelMouseClicked
        toggleMenu(sc_innerPanel3, sc_clusteringLabel, getClass().getResource("/pkg4seqgui/images/SingleCellB.png"));
    }//GEN-LAST:event_sc_clusteringLabelMouseClicked

    private void sc_FeatureSelectionLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc_FeatureSelectionLabelMouseClicked
        toggleMenu(sc_innerPanel4, sc_FeatureSelectionLabel, getClass().getResource("/pkg4seqgui/images/SingleCellB.png"));
    }//GEN-LAST:event_sc_FeatureSelectionLabelMouseClicked

    private void MergeMatrixButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MergeMatrixButtonActionPerformed
        setCard("mergeMatrix");
    }//GEN-LAST:event_MergeMatrixButtonActionPerformed

    private void S_crossLabelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_crossLabelButton1ActionPerformed
        setCard("crossLabel");
    }//GEN-LAST:event_S_crossLabelButton1ActionPerformed

    private void SC_IndropCountsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_IndropCountsButton1ActionPerformed
        setCard("tenXGenomics");
    }//GEN-LAST:event_SC_IndropCountsButton1ActionPerformed

    private void subSetMatrixButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subSetMatrixButton1ActionPerformed
        setCard("subsetCells");
    }//GEN-LAST:event_subSetMatrixButton1ActionPerformed

    private void SC_dimensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_dimensionActionPerformed
        setCard("S_dim");
    }//GEN-LAST:event_SC_dimensionActionPerformed

    private void SC_ClusterSplitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClusterSplitActionPerformed
        setCard("splitclusters");
    }//GEN-LAST:event_SC_ClusterSplitActionPerformed

    private void SC_unstableFilteringButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_unstableFilteringButtonActionPerformed
        setCard("unstablefiltering");
    }//GEN-LAST:event_SC_unstableFilteringButtonActionPerformed

    private void SC_DeTwoGroupsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_DeTwoGroupsButtonActionPerformed
        setCard("detwogroups");
    }//GEN-LAST:event_SC_DeTwoGroupsButtonActionPerformed

    private void heatmaplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heatmaplyButtonActionPerformed
        setCard("heatmaply");
    }//GEN-LAST:event_heatmaplyButtonActionPerformed

    private void SC_ClusteringNgriphButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButton1ActionPerformed
        setCard("sharpclustering");
    }//GEN-LAST:event_SC_ClusteringNgriphButton1ActionPerformed

    private void SparseToDenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SparseToDenseActionPerformed
        setCard("sparsetodense");
    }//GEN-LAST:event_SparseToDenseActionPerformed

    private void DenseToSparseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DenseToSparseActionPerformed
        setCard("densetosparse");
    }//GEN-LAST:event_DenseToSparseActionPerformed

    private void pullImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pullImagesButtonActionPerformed
        dockerManager.updateImages(); 
    }//GEN-LAST:event_pullImagesButtonActionPerformed

    private void NovaLikeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovaLikeButton3ActionPerformed
        setCard("NOVAlike");
    }//GEN-LAST:event_NovaLikeButton3ActionPerformed

    private void SC_ScanpyBootstrapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ScanpyBootstrapActionPerformed
        setCard("scanpybootstrap");
    }//GEN-LAST:event_SC_ScanpyBootstrapActionPerformed

    private void Macs2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Macs2ButtonActionPerformed
        setCard("MACSv2");
    }//GEN-LAST:event_Macs2ButtonActionPerformed

    private void chipseqbwaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chipseqbwaButtonActionPerformed
        setCard("bwa");
    }//GEN-LAST:event_chipseqbwaButtonActionPerformed

    private void bwaIndexChipseqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bwaIndexChipseqActionPerformed
        setCard("bwaIndex");
    }//GEN-LAST:event_bwaIndexChipseqActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setCard("chipseqGTFAnnotation");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void wrapperSTARChipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrapperSTARChipButtonActionPerformed
        setCard("circRNA_wrapperSTAR");
    }//GEN-LAST:event_wrapperSTARChipButtonActionPerformed

    private void reformatPredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reformatPredictionButtonActionPerformed
        setCard("circRNA_reformat");
    }//GEN-LAST:event_reformatPredictionButtonActionPerformed

    private void overlapPredictionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overlapPredictionButtonActionPerformed
        setCard("circRNA_overlap");
    }//GEN-LAST:event_overlapPredictionButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setCard("SC_spatial_count");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void MultiQCButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MultiQCButtonMouseEntered
        MultiQCButton.requestFocus();
    }//GEN-LAST:event_MultiQCButtonMouseEntered

    private void MultiQCButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MultiQCButtonMouseExited
        
    }//GEN-LAST:event_MultiQCButtonMouseExited

    private void DenseToSparseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DenseToSparseMouseEntered
        DenseToSparse.requestFocus();
    }//GEN-LAST:event_DenseToSparseMouseEntered

    private void SparseToDenseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SparseToDenseMouseEntered
       SparseToDense.requestFocus();
    }//GEN-LAST:event_SparseToDenseMouseEntered

    private void subSetMatrixButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subSetMatrixButton1MouseEntered
       subSetMatrixButton1.requestFocus();
    }//GEN-LAST:event_subSetMatrixButton1MouseEntered

    private void SC_dimensionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_dimensionMouseEntered
       SC_dimension.requestFocus();
    }//GEN-LAST:event_SC_dimensionMouseEntered

    private void MergeMatrixButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MergeMatrixButtonMouseEntered
       MergeMatrixButton.requestFocus();
    }//GEN-LAST:event_MergeMatrixButtonMouseEntered

    private void heatmaplyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heatmaplyButtonMouseEntered
       heatmaplyButton.requestFocus();
    }//GEN-LAST:event_heatmaplyButtonMouseEntered

    private void HeatmapButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeatmapButtonMouseEntered
      HeatmapButton.requestFocus();
    }//GEN-LAST:event_HeatmapButtonMouseEntered

    private void vmRNAButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vmRNAButtonMouseEntered
     vmRNAButton.requestFocus();
    }//GEN-LAST:event_vmRNAButtonMouseEntered

    private void mRNAButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mRNAButtonMouseEntered
        mRNAButton.requestFocus();
    }//GEN-LAST:event_mRNAButtonMouseEntered

    private void SalmonIndexingButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalmonIndexingButtonMouseEntered
       SalmonIndexingButton.requestFocus();
    }//GEN-LAST:event_SalmonIndexingButtonMouseEntered

    private void countingSalmonButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countingSalmonButtonMouseEntered
        countingSalmonButton.requestFocus();
    }//GEN-LAST:event_countingSalmonButtonMouseEntered

    private void SampleExpButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SampleExpButtonMouseEntered
       SampleExpButton.requestFocus();
    }//GEN-LAST:event_SampleExpButtonMouseEntered

    private void PCAButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PCAButtonMouseEntered
      PCAButton.requestFocus();
    }//GEN-LAST:event_PCAButtonMouseEntered

    private void SampleSizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SampleSizeButtonMouseEntered
        SampleSizeButton.requestFocus();
    }//GEN-LAST:event_SampleSizeButtonMouseEntered

    private void ExpPowerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpPowerButtonMouseEntered
        ExpPowerButton.requestFocus();
    }//GEN-LAST:event_ExpPowerButtonMouseEntered

    private void DeseqButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeseqButtonMouseEntered
        DeseqButton.requestFocus();
    }//GEN-LAST:event_DeseqButtonMouseEntered

    private void ANOVAlikeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ANOVAlikeButtonMouseEntered
        ANOVAlikeButton.requestFocus();
    }//GEN-LAST:event_ANOVAlikeButtonMouseEntered

    private void CountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountButtonMouseEntered
       CountButton.requestFocus();
    }//GEN-LAST:event_CountButtonMouseEntered

    private void bwaIndexChipseqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bwaIndexChipseqMouseEntered
       bwaIndexChipseq.requestFocus();
    }//GEN-LAST:event_bwaIndexChipseqMouseEntered

    private void Ciri2PredictionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ciri2PredictionButtonMouseEntered
        Ciri2PredictionButton.requestFocus();  
    }//GEN-LAST:event_Ciri2PredictionButtonMouseEntered

    private void Ciri2MergeResultsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ciri2MergeResultsButtonMouseEntered
        Ciri2MergeResultsButton.requestFocus();
    }//GEN-LAST:event_Ciri2MergeResultsButtonMouseEntered

    private void StarChimericButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StarChimericButtonMouseEntered
        StarChimericButton.requestFocus();
    }//GEN-LAST:event_StarChimericButtonMouseEntered

    private void StarchipCircleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StarchipCircleButtonMouseEntered
       StarchipCircleButton.requestFocus();
    }//GEN-LAST:event_StarchipCircleButtonMouseEntered

    private void wrapperSTARChipButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wrapperSTARChipButtonMouseEntered
         wrapperSTARChipButton.requestFocus();
    }//GEN-LAST:event_wrapperSTARChipButtonMouseEntered

    private void overlapPredictionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overlapPredictionButtonMouseEntered
        overlapPredictionButton.requestFocus();
    }//GEN-LAST:event_overlapPredictionButtonMouseEntered

    private void reformatPredictionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reformatPredictionButtonMouseEntered
        reformatPredictionButton.requestFocus();
    }//GEN-LAST:event_reformatPredictionButtonMouseEntered

    private void downloadExonIsoformDataButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadExonIsoformDataButton2MouseEntered
        downloadExonIsoformDataButton2.requestFocus();
    }//GEN-LAST:event_downloadExonIsoformDataButton2MouseEntered

    private void CirchunterClassificButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CirchunterClassificButton2MouseEntered
        CirchunterClassificButton2.requestFocus();
    }//GEN-LAST:event_CirchunterClassificButton2MouseEntered

    private void circRNAAnnotationButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circRNAAnnotationButton2MouseEntered
        circRNAAnnotationButton2.requestFocus();
    }//GEN-LAST:event_circRNAAnnotationButton2MouseEntered

    private void BSJunctionsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BSJunctionsButtonMouseEntered
        BSJunctionsButton.requestFocus();
    }//GEN-LAST:event_BSJunctionsButtonMouseEntered

    private void CircRNAStructurePredictionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CircRNAStructurePredictionButtonMouseEntered
       CircRNAStructurePredictionButton.requestFocus();
    }//GEN-LAST:event_CircRNAStructurePredictionButtonMouseEntered

    private void CircRNAQuantificationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CircRNAQuantificationButtonMouseEntered
        CircRNAQuantificationButton.requestFocus();
    }//GEN-LAST:event_CircRNAQuantificationButtonMouseEntered

    private void circRNAddingCovarsButtonButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circRNAddingCovarsButtonButtonMouseEntered
       circRNAddingCovarsButtonButton.requestFocus();
    }//GEN-LAST:event_circRNAddingCovarsButtonButtonMouseEntered

    private void circRNADESeqButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circRNADESeqButtonMouseEntered
        circRNADESeqButton.requestFocus();
    }//GEN-LAST:event_circRNADESeqButtonMouseEntered

    private void miRNApanelSub1MMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miRNApanelSub1MMouseEntered
        miRNApanelSub1M.requestFocus();
    }//GEN-LAST:event_miRNApanelSub1MMouseEntered

    private void chipseqbwaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chipseqbwaButtonMouseEntered
        chipseqbwaButton.requestFocus();
    }//GEN-LAST:event_chipseqbwaButtonMouseEntered

    private void Macs2ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Macs2ButtonMouseClicked
    
    }//GEN-LAST:event_Macs2ButtonMouseClicked

    private void Macs2ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Macs2ButtonMouseEntered
         Macs2Button.requestFocus();
    }//GEN-LAST:event_Macs2ButtonMouseEntered

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
         jButton4.requestFocus();
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton59MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton59MouseEntered
        jButton59.requestFocus();
    }//GEN-LAST:event_jButton59MouseEntered

    private void jButton60MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton60MouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_jButton60MouseEntered

    private void PCAButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PCAButton1MouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_PCAButton1MouseEntered

    private void SampleSizeButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SampleSizeButton1MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SampleSizeButton1MouseEntered

    private void ExpPowerButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpPowerButton1MouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_ExpPowerButton1MouseEntered

    private void DeseqButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeseqButton2MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_DeseqButton2MouseEntered

    private void CountButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountButton1MouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_CountButton1MouseEntered

    private void mirnaindexingButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mirnaindexingButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_mirnaindexingButtonMouseEntered

    private void mirnaQuantificationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mirnaQuantificationButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_mirnaQuantificationButtonMouseEntered

    private void jButton61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton61MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_jButton61MouseEntered

    private void PCAButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PCAButton2MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_PCAButton2MouseEntered

    private void SampleSizeButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SampleSizeButton2MouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SampleSizeButton2MouseEntered

    private void ExpPowerButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpPowerButton2MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_ExpPowerButton2MouseEntered

    private void NovaLikeButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovaLikeButton3MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_NovaLikeButton3MouseEntered

    private void DeseqButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeseqButton3MouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_DeseqButton3MouseEntered

    private void CountButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CountButton3MouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_CountButton3MouseEntered

    private void SC_IndropIndexButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_IndropIndexButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_IndropIndexButtonMouseEntered

    private void SC_IndropCountsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_IndropCountsButtonMouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_IndropCountsButtonMouseEntered

    private void SC_IndropCountsButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_IndropCountsButton1MouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_IndropCountsButton1MouseEntered

    private void SC_CellRangerCountButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_CellRangerCountButtonMouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_CellRangerCountButtonMouseEntered

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_jButton5MouseEntered

    private void SC_GenesUmiButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_GenesUmiButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_GenesUmiButtonMouseEntered

    private void SC_ScannoByGtfButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ScannoByGtfButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ScannoByGtfButtonMouseEntered

    private void SC_LorenzFilterButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_LorenzFilterButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_LorenzFilterButtonMouseEntered

    private void SC_TopXButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_TopXButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_TopXButtonMouseEntered

    private void SC_FilterZerosButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_FilterZerosButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_FilterZerosButtonMouseEntered

    private void SC_Counts2LogButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_Counts2LogButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_Counts2LogButtonMouseEntered

    private void SC_CountDepthButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_CountDepthButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_CountDepthButtonMouseEntered

    private void SC_SCNormButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_SCNormButtonMouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_SCNormButtonMouseEntered

    private void SC_UmiNormButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_UmiNormButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_UmiNormButtonMouseEntered

    private void SC_RecatPredictionButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_RecatPredictionButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_RecatPredictionButtonMouseEntered

    private void SC_CCRemoveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_CCRemoveButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_CCRemoveButtonMouseEntered

    private void SC_ClusteringNgriphButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ClusteringNgriphButtonMouseEntered

    private void SC_ClusteringNgriphButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButton1MouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ClusteringNgriphButton1MouseEntered

    private void SC_SimlrBootstrapButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_SimlrBootstrapButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_SimlrBootstrapButtonMouseEntered

    private void SC_ClusterStabilityButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClusterStabilityButtonMouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ClusterStabilityButtonMouseEntered

    private void SC_SeuratPCAEvalButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_SeuratPCAEvalButtonMouseEntered
       evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_SeuratPCAEvalButtonMouseEntered

    private void SC_SeuratBootstrapButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_SeuratBootstrapButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_SeuratBootstrapButtonMouseEntered

    private void SC_ScanpyBootstrapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ScanpyBootstrapMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ScanpyBootstrapMouseEntered

    private void SC_TsneBootstrapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_TsneBootstrapMouseEntered
     evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_TsneBootstrapMouseEntered

    private void SC_ClusterSplitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClusterSplitMouseEntered
     evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ClusterSplitMouseEntered

    private void SC_unstableFilteringButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_unstableFilteringButtonMouseEntered
     evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_unstableFilteringButtonMouseEntered

    private void S_crossLabelButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_S_crossLabelButton1MouseEntered
     evt.getComponent().requestFocus();
    }//GEN-LAST:event_S_crossLabelButton1MouseEntered

    private void SC_BootstrapVideoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_BootstrapVideoButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_BootstrapVideoButtonMouseEntered

    private void SC_DeTwoGroupsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_DeTwoGroupsButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_DeTwoGroupsButtonMouseEntered

    private void SC_AnovaLikeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_AnovaLikeButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_AnovaLikeButtonMouseEntered

    private void SC_ClustersFeaturesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClustersFeaturesButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_ClustersFeaturesButtonMouseEntered

    private void SC_HFCButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_HFCButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_HFCButtonMouseEntered

    private void SC_SeuratPriorButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_SeuratPriorButtonMouseEntered
      evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_SeuratPriorButtonMouseEntered

    private void SC_GenesPrioritizSIMLRButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_GenesPrioritizSIMLRButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_GenesPrioritizSIMLRButtonMouseEntered

    private void SC_GenesSelectionSIMLRButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_GenesSelectionSIMLRButtonMouseEntered
        evt.getComponent().requestFocus();
    }//GEN-LAST:event_SC_GenesSelectionSIMLRButtonMouseEntered

    private void STVisualizationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STVisualizationMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_STVisualizationMouseEntered

    private void STVisualizationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STVisualizationMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_STVisualizationMouseExited

    private void STVisualizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STVisualizationActionPerformed
        setCard("ST_visual");
    }//GEN-LAST:event_STVisualizationActionPerformed

    private void SC_ClusteringNgriphButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SC_ClusteringNgriphButton2MouseEntered

    private void SC_ClusteringNgriphButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_ClusteringNgriphButton2ActionPerformed
        setCard("griphclustering");
    }//GEN-LAST:event_SC_ClusteringNgriphButton2ActionPerformed

    private void SC_GenesSelectionSIMLRButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SC_GenesSelectionSIMLRButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_SC_GenesSelectionSIMLRButton1MouseEntered

    private void SC_GenesSelectionSIMLRButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_GenesSelectionSIMLRButton1ActionPerformed
        setCard("geneSelectionComet"); 
    }//GEN-LAST:event_SC_GenesSelectionSIMLRButton1ActionPerformed

    private void autoencoderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoencoderButtonActionPerformed
        setCard("autoencoder"); 
    }//GEN-LAST:event_autoencoderButtonActionPerformed

    private void autoencoderClusteringButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoencoderClusteringButtonActionPerformed
        setCard("AE_clustering");
    }//GEN-LAST:event_autoencoderClusteringButtonActionPerformed

    private void autoencoderAnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoencoderAnalysisButtonActionPerformed
        setCard("AE_analysis"); 
    }//GEN-LAST:event_autoencoderAnalysisButtonActionPerformed

    private void autoencoderFeaturesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoencoderFeaturesButtonActionPerformed
        setCard("AE_features");
    }//GEN-LAST:event_autoencoderFeaturesButtonActionPerformed

    private void autoencoderCometButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoencoderCometButtonActionPerformed
        setCard("AE_comet"); 
    }//GEN-LAST:event_autoencoderCometButtonActionPerformed

    private void sc_autoencoderLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc_autoencoderLabelMouseClicked
        toggleMenu(sc_autoencoderPanel, sc_autoencoderLabel, getClass().getResource("/pkg4seqgui/images/SingleCellB.png"));
    }//GEN-LAST:event_sc_autoencoderLabelMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setCard("AE_wrapper"); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void VioplotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VioplotButtonActionPerformed
        setCard("HTMLvioplot");
    }//GEN-LAST:event_VioplotButtonActionPerformed

    private void SC_SeuratCellCycleEstimationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_SeuratCellCycleEstimationActionPerformed
        setCard("seurat_cce");
    }//GEN-LAST:event_SC_SeuratCellCycleEstimationActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        setCard("bulk_clusters");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        setCard("saver_norm");
    }//GEN-LAST:event_jButton8ActionPerformed


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

       try {
            //set default look and feel
           javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            //set GTK look and feel, if it is present
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel".equals(info.getClassName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }



  //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
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
    private javax.swing.JButton BSJunctionsButton;
    private javax.swing.JComboBox<String> BatchComboBox;
    public static javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel ChipSeqPanel;
    private javax.swing.JScrollPane ChipSeqScrollPanel;
    private javax.swing.JPanel CircRNAPanel;
    private javax.swing.JButton CircRNAQuantificationButton;
    private javax.swing.JScrollPane CircRNAScrollPanel;
    private javax.swing.JButton CircRNAStructurePredictionButton;
    private javax.swing.JButton CirchunterClassificButton2;
    private javax.swing.JButton Ciri2MergeResultsButton;
    private javax.swing.JButton Ciri2PredictionButton;
    private javax.swing.JPanel ClassificationAnnotationPanel;
    private javax.swing.JToggleButton CloseOutput;
    private javax.swing.JButton ConfCancell;
    public static javax.swing.JFrame ConfigurationFrame;
    private javax.swing.JButton ConfigureTabsButton;
    private javax.swing.JFrame ConfigureTabsFrame;
    private javax.swing.JButton CountButton;
    private javax.swing.JButton CountButton1;
    private javax.swing.JButton CountButton3;
    private javax.swing.JComboBox<String> CovComboBox;
    private javax.swing.JButton DenseToSparse;
    private javax.swing.JButton DeseqButton;
    private javax.swing.JButton DeseqButton2;
    private javax.swing.JButton DeseqButton3;
    private javax.swing.JButton DlogButton;
    private javax.swing.JFrame DownloadFrame;
    private javax.swing.JTextField Downloadtext;
    private javax.swing.JScrollPane Empty;
    private javax.swing.JPanel EmptyPanel;
    private javax.swing.JButton ExpPowerButton;
    private javax.swing.JButton ExpPowerButton1;
    private javax.swing.JButton ExpPowerButton2;
    private javax.swing.JPanel ExpressionAnalysisPanel;
    private javax.swing.JScrollPane Heatmap;
    private javax.swing.JButton HeatmapButton;
    private javax.swing.JSplitPane HorizontalSplitPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JScrollPane MACSv2;
    private javax.swing.ButtonGroup MExecution;
    private javax.swing.ButtonGroup MRemoveDuplicates;
    private javax.swing.ButtonGroup MSeq;
    private javax.swing.JButton Macs2Button;
    public static javax.swing.JPanel MainPanel;
    private javax.swing.JButton MergeMatrixButton;
    private javax.swing.JScrollPane MultiQC;
    private javax.swing.JButton MultiQCButton;
    private javax.swing.JButton NovaLikeButton3;
    public static javax.swing.JFrame OutputFrame;
    public static javax.swing.JTextArea OutputText;
    private javax.swing.JButton PCAButton;
    private javax.swing.JButton PCAButton1;
    private javax.swing.JButton PCAButton2;
    private javax.swing.JTextField ParallelTextField;
    private javax.swing.JPanel PredictionPanel;
    public static javax.swing.JList<ListEntry> ProcList;
    private javax.swing.JPanel ProcStatusPanel;
    private javax.swing.JScrollPane RNAScrollPane;
    private javax.swing.JPanel RNAseqPanel;
    private javax.swing.JPanel RNAseqPanelSub1;
    private javax.swing.JPanel RNAseqPanelSub1M;
    private javax.swing.JPanel RNAseqPanelSub2;
    private javax.swing.JPanel RNAseqPanelSub2M;
    public static javax.swing.JToggleButton ReloadOutput;
    private javax.swing.JButton RemoveOutput;
    private javax.swing.JButton SC_AnovaLikeButton;
    private javax.swing.JButton SC_BootstrapVideoButton;
    private javax.swing.JButton SC_CCRemoveButton;
    private javax.swing.JButton SC_CellRangerCountButton;
    private javax.swing.JButton SC_ClusterSplit;
    private javax.swing.JButton SC_ClusterStabilityButton;
    private javax.swing.JButton SC_ClusteringNgriphButton;
    private javax.swing.JButton SC_ClusteringNgriphButton1;
    private javax.swing.JButton SC_ClusteringNgriphButton2;
    private javax.swing.JButton SC_ClustersFeaturesButton;
    private javax.swing.JButton SC_CountDepthButton;
    private javax.swing.JButton SC_Counts2LogButton;
    private javax.swing.JButton SC_DeTwoGroupsButton;
    private javax.swing.JButton SC_FilterZerosButton;
    private javax.swing.JButton SC_GenesPrioritizSIMLRButton;
    private javax.swing.JButton SC_GenesSelectionSIMLRButton;
    private javax.swing.JButton SC_GenesSelectionSIMLRButton1;
    private javax.swing.JButton SC_GenesUmiButton;
    private javax.swing.JButton SC_HFCButton;
    private javax.swing.JButton SC_IndropCountsButton;
    private javax.swing.JButton SC_IndropCountsButton1;
    private javax.swing.JButton SC_IndropIndexButton;
    private javax.swing.JButton SC_LorenzFilterButton;
    private javax.swing.JButton SC_RecatPredictionButton;
    private javax.swing.JButton SC_SCNormButton;
    private javax.swing.JButton SC_ScannoByGtfButton;
    private javax.swing.JButton SC_ScanpyBootstrap;
    private javax.swing.JButton SC_SeuratBootstrapButton;
    private javax.swing.JButton SC_SeuratCellCycleEstimation;
    private javax.swing.JButton SC_SeuratPCAEvalButton;
    private javax.swing.JButton SC_SeuratPriorButton;
    private javax.swing.JButton SC_SimlrBootstrapButton;
    private javax.swing.JButton SC_TopXButton;
    private javax.swing.JButton SC_TsneBootstrap;
    private javax.swing.JButton SC_UmiNormButton;
    private javax.swing.JButton SC_dimension;
    private javax.swing.JButton SC_unstableFilteringButton;
    private javax.swing.JButton STVisualization;
    private javax.swing.JScrollPane S_AE;
    private javax.swing.JScrollPane S_AE_Analysis;
    private javax.swing.JScrollPane S_AE_Clustering;
    private javax.swing.JScrollPane S_AE_Comet;
    private javax.swing.JScrollPane S_AE_Features;
    private javax.swing.JScrollPane S_AE_Wrapper;
    private javax.swing.JScrollPane S_BulkClusters;
    private javax.swing.JScrollPane S_SaverNormalisation;
    private javax.swing.JScrollPane S_SeuratCellCycleEstimation;
    private javax.swing.JScrollPane S_anovaLike;
    private javax.swing.JScrollPane S_bootstrapsVideo;
    private javax.swing.JScrollPane S_ccRemove;
    private javax.swing.JScrollPane S_cellRanger;
    private javax.swing.JScrollPane S_clusterNgriph;
    private javax.swing.JScrollPane S_clusterNgriph1;
    private javax.swing.JScrollPane S_clusterStability;
    private javax.swing.JScrollPane S_clustersFeatures;
    private javax.swing.JScrollPane S_countDepth;
    private javax.swing.JScrollPane S_counts2Log;
    private javax.swing.JButton S_crossLabelButton1;
    private javax.swing.JScrollPane S_densetosparse;
    private javax.swing.JScrollPane S_detwogroups;
    private javax.swing.JScrollPane S_dim;
    private javax.swing.JScrollPane S_filterZeros;
    private javax.swing.JScrollPane S_genesPrioritization;
    private javax.swing.JScrollPane S_genesSelection;
    private javax.swing.JScrollPane S_genesUmi;
    private javax.swing.JScrollPane S_hfc;
    private javax.swing.JScrollPane S_indropCounts;
    private javax.swing.JScrollPane S_indropIndex;
    private javax.swing.JScrollPane S_lorenzFilter;
    private javax.swing.JScrollPane S_recatPrediction;
    private javax.swing.JScrollPane S_scannoByGtf;
    private javax.swing.JScrollPane S_scanpybootstrap;
    private javax.swing.JScrollPane S_scnorm;
    private javax.swing.JScrollPane S_seuratBootstrap;
    private javax.swing.JScrollPane S_seuratPCAEval;
    private javax.swing.JScrollPane S_seuratPrior;
    private javax.swing.JScrollPane S_simlrBootstrap;
    private javax.swing.JScrollPane S_sparsetodense;
    private javax.swing.JScrollPane S_splitclusters;
    private javax.swing.JScrollPane S_topX;
    private javax.swing.JScrollPane S_tsneBootstrap;
    private javax.swing.JScrollPane S_umiNorm;
    private javax.swing.JScrollPane S_unstablefiltering;
    private javax.swing.JButton SalmonIndexingButton;
    private javax.swing.JButton SampleExpButton;
    private javax.swing.JButton SampleSizeButton;
    private javax.swing.JButton SampleSizeButton1;
    private javax.swing.JButton SampleSizeButton2;
    private javax.swing.JPanel SequenceAnalysisPanel;
    private javax.swing.JPanel SingleCellPanel;
    private javax.swing.JScrollPane SingleCellScrollPanel;
    private javax.swing.JScrollPane SingleCell_GeneSelectionComet;
    private javax.swing.JScrollPane SingleCell_SharpClustering;
    private javax.swing.JScrollPane SingleCell_SpatialCountGeneration;
    private javax.swing.JButton SparseToDense;
    private javax.swing.JButton StarChimericButton;
    private javax.swing.JButton StarchipCircleButton;
    private javax.swing.JPanel SubBottomPanel;
    private javax.swing.JPanel SubClusteringPanel;
    private javax.swing.JPanel SubCountGenerationPanel;
    private javax.swing.JPanel SubCountManipulationPanel;
    private javax.swing.JPanel SubFeatureSelectionPanel;
    public javax.swing.JScrollPane Test;
    private javax.swing.JTextField ThreadTextField;
    private javax.swing.JPanel ToolPanel;
    private javax.swing.JScrollPane ToolScrollPanel;
    private javax.swing.JScrollPane Tools_STVisualization;
    private javax.swing.JSplitPane VerticalSplitPanel;
    private javax.swing.JButton VioplotButton;
    private javax.swing.JScrollPane VioplotHTMLbyGenes;
    private javax.swing.JButton addImagesButton;
    private javax.swing.JButton autoencoderAnalysisButton;
    private javax.swing.JButton autoencoderButton;
    private javax.swing.JButton autoencoderClusteringButton;
    private javax.swing.JButton autoencoderCometButton;
    private javax.swing.JButton autoencoderFeaturesButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane bwa;
    private javax.swing.JScrollPane bwaIndex;
    private javax.swing.JButton bwaIndexChipseq;
    private javax.swing.JScrollPane chipseqAnnotationPanel;
    private javax.swing.JCheckBox chipseqTabChecker;
    private javax.swing.JButton chipseqbwaButton;
    private javax.swing.JButton circRNAAnnotationButton2;
    private javax.swing.JButton circRNADESeqButton;
    private javax.swing.JCheckBox circRNATabChecker;
    private javax.swing.JScrollPane circRNA_BSJunctions;
    private javax.swing.JScrollPane circRNA_annotation;
    private javax.swing.JScrollPane circRNA_ciri2;
    private javax.swing.JScrollPane circRNA_mergeCiri2Samples;
    private javax.swing.JScrollPane circRNA_overlap;
    private javax.swing.JScrollPane circRNA_postprocessing;
    private javax.swing.JScrollPane circRNA_prepareExonIsoformFiles;
    private javax.swing.JScrollPane circRNA_quantification;
    private javax.swing.JScrollPane circRNA_reformat;
    private javax.swing.JScrollPane circRNA_starChimeric;
    private javax.swing.JScrollPane circRNA_starPrediction;
    private javax.swing.JScrollPane circRNA_structure;
    private javax.swing.JScrollPane circRNA_wrapperSTAR;
    private javax.swing.JButton circRNAddingCovarsButtonButton;
    private javax.swing.JButton closeConfigureTabButton;
    private javax.swing.JPanel commandsPanel;
    private javax.swing.JButton confermConfigureTabButton;
    private javax.swing.JScrollPane countingSalmon;
    private javax.swing.JButton countingSalmonButton;
    private javax.swing.JLabel crnaClassificationLabel;
    private javax.swing.JLabel crnaExpressionLabel;
    private javax.swing.JPanel crnaP1;
    private javax.swing.JPanel crnaP2;
    private javax.swing.JPanel crnaP3;
    private javax.swing.JPanel crnaP4;
    private javax.swing.JLabel crnaPredictionLabel;
    private javax.swing.JLabel crnaSequenceLabel;
    private javax.swing.JScrollPane crossLabel;
    private javax.swing.JScrollPane dESPanel;
    private javax.swing.JFrame dockerImagesManager;
    private javax.swing.JTable dockerImagesTable;
    private javax.swing.JButton downloadDockerImagesButton;
    private javax.swing.JButton downloadExonIsoformDataButton2;
    private javax.swing.JPanel enableTabsPanel;
    private javax.swing.JScrollPane experimentPowerPanel;
    private javax.swing.JScrollPane fPKMPanel;
    private javax.swing.JScrollPane filterCounts;
    private javax.swing.JScrollPane heatmaply;
    private javax.swing.JButton heatmaplyButton;
    private javax.swing.JScrollPane indexingBWAPanel;
    private javax.swing.JScrollPane indexingSalmon;
    private javax.swing.JScrollPane indexingStarRSEM;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabelRNAseq1;
    private javax.swing.JLabel jLabelRNAseq2;
    private javax.swing.JLabel jLabelmiRNA1;
    private javax.swing.JLabel jLabelmiRNA2;
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
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane mACSPanel;
    private javax.swing.JScrollPane mRNA;
    private javax.swing.JScrollPane mRNABatchPanel;
    private javax.swing.JButton mRNAButton;
    private javax.swing.JButton manageDockerImagesButton;
    private javax.swing.JScrollPane mergeMatrix;
    private javax.swing.JCheckBox miRNA2TabChecker;
    private javax.swing.JPanel miRNAPanel;
    private javax.swing.JScrollPane miRNAScrollPanel;
    private javax.swing.JCheckBox miRNATabChecker;
    private javax.swing.JPanel miRNApanelSub1;
    private javax.swing.JPanel miRNApanelSub1M;
    private javax.swing.JPanel miRNApanelSub2;
    private javax.swing.JPanel miRNApanelSub2M;
    private javax.swing.JScrollPane mirnaGenomeIndexing;
    private javax.swing.JScrollPane mirnaQuantification;
    private javax.swing.JButton mirnaQuantificationButton;
    private javax.swing.JButton mirnaindexingButton;
    private javax.swing.JButton overlapPredictionButton;
    private javax.swing.JScrollPane pCAPanel;
    private javax.swing.JButton pullImagesButton;
    private javax.swing.JButton reformatPredictionButton;
    private javax.swing.JButton removeImagesButton;
    private javax.swing.JCheckBox rnaSeqTabChecker;
    private javax.swing.JScrollPane sampleSizePanel;
    private javax.swing.JLabel sc_FeatureSelectionLabel;
    private javax.swing.JLabel sc_autoencoderLabel;
    private javax.swing.JPanel sc_autoencoderPanel;
    private javax.swing.JLabel sc_clusteringLabel;
    private javax.swing.JLabel sc_countsGenerationLabel;
    private javax.swing.JLabel sc_countsManipulationLabel;
    private javax.swing.JPanel sc_innerPanel1;
    private javax.swing.JPanel sc_innerPanel2;
    private javax.swing.JPanel sc_innerPanel3;
    private javax.swing.JPanel sc_innerPanel4;
    private javax.swing.JCheckBox singleCellTabChecker;
    private javax.swing.JPanel sncRNAPanel;
    private javax.swing.JScrollPane sncRNAScrollPane;
    private javax.swing.JLabel sncrnaExpressionAnaLabel;
    private javax.swing.JLabel sncrnaPostProcessingLabel;
    private javax.swing.JLabel sncrnaReferenceLabel;
    private javax.swing.JPanel srnaExpression;
    private javax.swing.JPanel srnaFirstStep;
    private javax.swing.JPanel srnaP1;
    private javax.swing.JPanel srnaP2;
    private javax.swing.JPanel srnaP3;
    private javax.swing.JPanel srnaPreprocessCounts;
    private javax.swing.JPanel subAutoencoderPanel;
    private javax.swing.JButton subSetMatrixButton1;
    private javax.swing.JScrollPane subsetcells;
    private javax.swing.JScrollPane tenXIndexing;
    private javax.swing.JCheckBox toolsTabChecker;
    private javax.swing.JScrollPane vmRNA;
    private javax.swing.JButton vmRNAButton;
    private javax.swing.JButton wrapperSTARChipButton;
    // End of variables declaration//GEN-END:variables





static public class ElProcRunning {
    public String type;
    public String path;
    public String logfilename; 
    public Process pr;
    public int  pos;
    //constructor
    public ElProcRunning(String type, String path, String logfile, Process pr, int i) {
        this.type = type;
        this.path = path;
        this.logfilename = logfile; 
        this.pr = pr;
        pos = i;
    }
    
    public ElProcRunning(String type, String path, Process pr, int i) {
        this.type = type;
        this.path = path;
        this.logfilename = "Routput.Rout"; 
        this.pr = pr;
        pos = i;
    }
    
    public String toString() {
      return new String(type+" ( data: "+path+" )");
    }
}

static public class ElProcWaiting {
    public String type;
    public String path;
    public String logfilename; 
    public String[] cmd;
    public int  pos;
    //constructor
    public ElProcWaiting(String type, String path, String logfile, String[] cmd, int i) {
        this.type = type;
        this.path = path;
        this.logfilename = logfile; 
        this.cmd = cmd;
        pos=i;
    }
    
    public ElProcWaiting(String type, String path, String[] cmd, int i) {
        this.type = type;
        this.path = path;
        this.logfilename = "Routput.Rout"; 
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
   private  String logfile; 
   
   private static final long serialVersionUID = 57782123311L;
   
   public ListEntry(String value, String status, String path, String logfile, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
      this.status=status;
      this.path=path;
      this.logfile = logfile; 
   }
   
   public ListEntry(String value, String status, String path, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
      this.status=status;
      this.path=path;
      this.logfile = "Routput.out"; 
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
   
   public String getLogfilename() {
       return logfile;
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
                File file = new File(String.format("%s/%s", tmpListEntry.path, tmpListEntry.logfile));
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
                    ElProcRunning procToRun = listProcRunning.get(i); 
                    int index = procToRun.pos;
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/end.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    ImageIcon image3 = new ImageIcon(getClass().getResource("/pkg4seqgui/images/close.png"));
                    //listModel.remove(index+1);
                    //GL.setAvoidProcListValueChanged(-1);
                    boolean error=false;
                    try{
                        File f = new File(procToRun.path+"/ExitStatusFile");
                         System.out.print("file:"+ f.getAbsoluteFile().toString() );
                        FileReader fw = new FileReader(f.getAbsoluteFile());
                        BufferedReader br = new BufferedReader(fw);
                        String ExitStatus=br.readLine();
                        System.out.print("br: "+ExitStatus + " " + procToRun.path);
                        if (!(ExitStatus.equals("0"))){
                            error=true;
                        }
                    }
                    catch(IOException | NumberFormatException e) {
                       System.out.print(procToRun.path);
                       error=true;
                    }

                    if (error)
                        listModel.set(index,new ListEntry(" [Error]   " + procToRun.toString(), "Error", procToRun.path, procToRun.logfilename, image3));
                    else
                        listModel.set(index,new ListEntry(" [Finished]   " + procToRun.toString(), "Finished", procToRun.path, procToRun.logfilename, image2));
                    listProcRunning.remove(i);
                }
            }
            //System.out.format("End Check!\n");
            //System.out.format("Checking waiting !%n");
            while ((listProcRunning.size()<GS.getMaxSizelistProcRunning())&&(listProcWaiting.size()>0)){
                try{
                    ElProcWaiting procToRun = listProcWaiting.get(0);
                    
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec(procToRun.cmd);
                     
                    listProcRunning.add(new ElProcRunning(procToRun.type, procToRun.path, procToRun.logfilename, pr, procToRun.pos));
                    java.net.URL imgURL = getClass().getResource("/pkg4seqgui/images/running.png");
                    ImageIcon image2 = new ImageIcon(imgURL);
                    //listModel.remove(procToRun.pos);
                    //GL.setAvoidProcListValueChanged(-1);
                    listModel.set(procToRun.pos, new ListEntry(" [Running]   " +  procToRun.toString(),"Running", procToRun.path, procToRun.logfilename, image2));
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

    /**
     * @param stuff Component object calling the method
     * @param commandName Name of the task we are going to execute. It will appears in the process status panel
     * @param script ScriptCaller object containing parameters and so on
     */
    public static void execCommand(Component stuff, String commandName, ScriptCaller script) {
        String command = "";
        try {
            command = script.getCommandLineString();
        } catch (IOException e) {
            System.out.println("Unable to create the temporary script");
            return;
        }

        String outputFolder = script.outputFolder;
        String[] cmd = {"/bin/bash","-c", String.format("%s >& %s/%s", command, outputFolder, script.logfile_outputExec)};
        Runtime rt = Runtime.getRuntime();

        try {
            if (MainFrame.listProcRunning.size() < MainFrame.GS.getMaxSizelistProcRunning()) {
                Process pr = rt.exec(cmd);
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning(commandName, outputFolder, script.logfile_R, pr,MainFrame.listModel.getSize());
                MainFrame.listProcRunning.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Running]   "+tmp.toString(), "Running", tmp.path, tmp.logfilename, image2 ));
                MainFrame.GL.setAvoidProcListValueChanged(0);
                if (MainFrame.listProcRunning.size() == 1) {
                    MainFrame.t=new Timer();
                    MainFrame.t.scheduleAtFixedRate(new MainFrame.MyTask(), 5000, 5000);
                }
            }
            else {
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting(commandName, outputFolder, script.logfile_R, cmd,MainFrame.listModel.getSize());
                MainFrame.listProcWaiting.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/waiting.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Waiting]   "+tmp.toString(), "Waiting", tmp.path, tmp.logfilename, image2));
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

    public static void execCommand(Component stuff, String commandName, String script, String commandArgs, String outputFolder) {
        //bash ./nomescript argList outputFolder >& outputFolder/outputExecution
        String bashString = String.format(
            "bash ./%s %s %s >& %s/outputExecution", script, commandArgs, outputFolder, outputFolder);
        String[] cmd = {"/bin/bash","-c", bashString};
        Runtime rt = Runtime.getRuntime();

        try {
            if (MainFrame.listProcRunning.size() < MainFrame.GS.getMaxSizelistProcRunning()) {
                Process pr = rt.exec(cmd);
                //TO FIX: logfile_R name 
                MainFrame.ElProcRunning tmp= new MainFrame.ElProcRunning(commandName, outputFolder, "Routput.Rout", pr,MainFrame.listModel.getSize());
                MainFrame.listProcRunning.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/running.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Running]   "+tmp.toString(), "Running", tmp.path, tmp.logfilename, image2 ));
                MainFrame.GL.setAvoidProcListValueChanged(0);
                if (MainFrame.listProcRunning.size() == 1) {
                    MainFrame.t=new Timer();
                    MainFrame.t.scheduleAtFixedRate(new MainFrame.MyTask(), 5000, 5000);
                }
            }
            else {
                MainFrame.ElProcWaiting tmp= new MainFrame.ElProcWaiting(commandName, outputFolder, "Routput.Rout", cmd,MainFrame.listModel.getSize());
                MainFrame.listProcWaiting.add(tmp);
                java.net.URL imgURL = MainFrame.class.getResource("/pkg4seqgui/images/waiting.png");
                ImageIcon image2 = new ImageIcon(imgURL);
                MainFrame.GL.setAvoidProcListValueChanged(-1);
                MainFrame.listModel.addElement(new MainFrame.ListEntry(" [Waiting]   "+tmp.toString(), "Waiting", tmp.path, tmp.logfilename, image2));
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

    public static void setCard(String cardName) {
        cardName = cardName == null ? "Empty" : cardName;

        CardLayout card = (CardLayout) MainPanel.getLayout();
        card.show(MainPanel, cardName);
        CurrentLayout = cardName;
    }

    public static String browsePath(Component caller, int mode, FileNameExtensionFilter filter) {
        JFileChooser chooser = new JFileChooser();
        String selectedPath = null; 
        
        if (filter != null) 
            chooser.setFileFilter(filter);
        
        chooser.setFileSelectionMode(mode);
        
        String current = MainFrame.getPreferences().get("open-dir", null);
        chooser.setCurrentDirectory(current != null ? new File(current) : null);
        
        if (chooser.showOpenDialog(caller) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            MainFrame.getPreferences().put("open-dir", f.getParent());
            selectedPath = String.valueOf(f);
        }
        return selectedPath; 
    }
    
    public static JFileChooser browseTextFieldContent(Component caller, JTextField textfield, int mode) {
        /** mode = {JFileChooser.FILES_ONLY, JFileChooser.DIRECTORIES_ONLY, JFileChooser.FILES_AND_DIRECTORIES} */
        JFileChooser openDir = new JFileChooser();

        if (!textfield.getText().isEmpty()){
            File file = new File(textfield.getText());
            if (file.isDirectory())
                openDir.setCurrentDirectory(file);
        }
        else {
            String curDir = MainFrame.getPreferences().get("open-dir", null);
            openDir.setCurrentDirectory(curDir != null ? new File(curDir) : null);
        }

        openDir.setFileSelectionMode(mode);

        if (openDir.showOpenDialog(caller) == JFileChooser.APPROVE_OPTION) {
            File f = openDir.getSelectedFile();
            textfield.setText(String.valueOf(f));
        }
        MainFrame.getPreferences().put("open-dir",openDir.getCurrentDirectory().getAbsolutePath());

        return openDir;
    }
    
    
    public static boolean checkPath(Component caller, String path, String pathName) {
        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(caller, 
                "You have to specify the " + pathName,
                "Error: " + pathName,
                JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false; 
    }
    
    public static Integer checkIntValue(Component caller, String text, String varName) {
        Integer value = null; 
        try {
            value = Integer.valueOf(text.trim()); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(caller, 
                    "You have to specify the " + varName + " that will be used.",
                    "Error: " + varName,
                    JOptionPane.ERROR_MESSAGE);
        }
        return value;
    }
    
    public static Float checkFloatValue(Component caller, String text, String varName) {
        Float value = null; 
        try {
            value = Float.valueOf(text.trim()); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(caller, 
                    "You have to specify the " + varName + " that will be used.",
                    "Error: " + varName,
                    JOptionPane.ERROR_MESSAGE);
        }
        return value;
    }
    
    
}
