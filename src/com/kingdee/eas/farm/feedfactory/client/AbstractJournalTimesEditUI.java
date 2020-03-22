/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import org.apache.log4j.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import javax.swing.KeyStroke;

import com.kingdee.bos.ctrl.swing.*;
import com.kingdee.bos.ctrl.kdf.table.*;
import com.kingdee.bos.ctrl.kdf.data.event.*;
import com.kingdee.bos.dao.*;
import com.kingdee.bos.dao.query.*;
import com.kingdee.bos.metadata.*;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.ui.face.*;
import com.kingdee.bos.ui.util.ResourceBundleHelper;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.swing.event.*;
import com.kingdee.bos.ctrl.kdf.table.event.*;
import com.kingdee.bos.ctrl.extendcontrols.*;
import com.kingdee.bos.ctrl.kdf.util.render.*;
import com.kingdee.bos.ui.face.IItemAction;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.appframework.client.servicebinding.ActionProxyFactory;
import com.kingdee.bos.appframework.uistatemanage.ActionStateConst;
import com.kingdee.bos.appframework.validator.ValidateHelper;
import com.kingdee.bos.appframework.uip.UINavigator;


/**
 * output class name
 */
public abstract class AbstractJournalTimesEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractJournalTimesEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFacToFarmEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFacToFarmEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFarmToFarmEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFarmToFarmEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.eas.farm.feedfactory.JournalTimesInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractJournalTimesEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractJournalTimesEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtFacToFarmEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtFarmToFarmEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtFacToFarmEntrys.setName("kdtFacToFarmEntrys");
        this.kdtFarmToFarmEntrys.setName("kdtFarmToFarmEntrys");
        this.baseStatus.setName("baseStatus");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // kDPanel1
        // kDPanel2
        // kdtFacToFarmEntrys
		String kdtFacToFarmEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"affress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"distance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"loadTimes\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unloadTimes\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{affress}</t:Cell><t:Cell>$Resource{distance}</t:Cell><t:Cell>$Resource{loadTimes}</t:Cell><t:Cell>$Resource{unloadTimes}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFacToFarmEntrys.setFormatXml(resHelper.translateString("kdtFacToFarmEntrys",kdtFacToFarmEntrysStrXML));
        kdtFacToFarmEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFacToFarmEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFacToFarmEntrys.putBindContents("editData",new String[] {"seq","farm","affress","distance","loadTimes","unloadTimes"});


        this.kdtFacToFarmEntrys.checkParsed();
        KDFormattedTextField kdtFacToFarmEntrys_seq_TextField = new KDFormattedTextField();
        kdtFacToFarmEntrys_seq_TextField.setName("kdtFacToFarmEntrys_seq_TextField");
        kdtFacToFarmEntrys_seq_TextField.setVisible(true);
        kdtFacToFarmEntrys_seq_TextField.setEditable(true);
        kdtFacToFarmEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFacToFarmEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFacToFarmEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_seq_TextField);
        this.kdtFacToFarmEntrys.getColumn("seq").setEditor(kdtFacToFarmEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFacToFarmEntrys_farm_PromptBox = new KDBizPromptBox();
        kdtFacToFarmEntrys_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");
        kdtFacToFarmEntrys_farm_PromptBox.setVisible(true);
        kdtFacToFarmEntrys_farm_PromptBox.setEditable(true);
        kdtFacToFarmEntrys_farm_PromptBox.setDisplayFormat("$number$");
        kdtFacToFarmEntrys_farm_PromptBox.setEditFormat("$number$");
        kdtFacToFarmEntrys_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFacToFarmEntrys_farm_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_farm_PromptBox);
        this.kdtFacToFarmEntrys.getColumn("farm").setEditor(kdtFacToFarmEntrys_farm_CellEditor);
        ObjectValueRender kdtFacToFarmEntrys_farm_OVR = new ObjectValueRender();
        kdtFacToFarmEntrys_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFacToFarmEntrys.getColumn("farm").setRenderer(kdtFacToFarmEntrys_farm_OVR);
        KDTextField kdtFacToFarmEntrys_affress_TextField = new KDTextField();
        kdtFacToFarmEntrys_affress_TextField.setName("kdtFacToFarmEntrys_affress_TextField");
        kdtFacToFarmEntrys_affress_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFacToFarmEntrys_affress_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_affress_TextField);
        this.kdtFacToFarmEntrys.getColumn("affress").setEditor(kdtFacToFarmEntrys_affress_CellEditor);
        KDFormattedTextField kdtFacToFarmEntrys_distance_TextField = new KDFormattedTextField();
        kdtFacToFarmEntrys_distance_TextField.setName("kdtFacToFarmEntrys_distance_TextField");
        kdtFacToFarmEntrys_distance_TextField.setVisible(true);
        kdtFacToFarmEntrys_distance_TextField.setEditable(true);
        kdtFacToFarmEntrys_distance_TextField.setHorizontalAlignment(2);
        kdtFacToFarmEntrys_distance_TextField.setDataType(1);
        	kdtFacToFarmEntrys_distance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFacToFarmEntrys_distance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFacToFarmEntrys_distance_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFacToFarmEntrys_distance_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_distance_TextField);
        this.kdtFacToFarmEntrys.getColumn("distance").setEditor(kdtFacToFarmEntrys_distance_CellEditor);
        KDFormattedTextField kdtFacToFarmEntrys_loadTimes_TextField = new KDFormattedTextField();
        kdtFacToFarmEntrys_loadTimes_TextField.setName("kdtFacToFarmEntrys_loadTimes_TextField");
        kdtFacToFarmEntrys_loadTimes_TextField.setVisible(true);
        kdtFacToFarmEntrys_loadTimes_TextField.setEditable(true);
        kdtFacToFarmEntrys_loadTimes_TextField.setHorizontalAlignment(2);
        kdtFacToFarmEntrys_loadTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFacToFarmEntrys_loadTimes_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_loadTimes_TextField);
        this.kdtFacToFarmEntrys.getColumn("loadTimes").setEditor(kdtFacToFarmEntrys_loadTimes_CellEditor);
        KDFormattedTextField kdtFacToFarmEntrys_unloadTimes_TextField = new KDFormattedTextField();
        kdtFacToFarmEntrys_unloadTimes_TextField.setName("kdtFacToFarmEntrys_unloadTimes_TextField");
        kdtFacToFarmEntrys_unloadTimes_TextField.setVisible(true);
        kdtFacToFarmEntrys_unloadTimes_TextField.setEditable(true);
        kdtFacToFarmEntrys_unloadTimes_TextField.setHorizontalAlignment(2);
        kdtFacToFarmEntrys_unloadTimes_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFacToFarmEntrys_unloadTimes_CellEditor = new KDTDefaultCellEditor(kdtFacToFarmEntrys_unloadTimes_TextField);
        this.kdtFacToFarmEntrys.getColumn("unloadTimes").setEditor(kdtFacToFarmEntrys_unloadTimes_CellEditor);
        // kdtFarmToFarmEntrys
		String kdtFarmToFarmEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"startFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"startFarmAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"endFarm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"endFarmAddress\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"distance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"times\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{startFarm}</t:Cell><t:Cell>$Resource{startFarmAddress}</t:Cell><t:Cell>$Resource{endFarm}</t:Cell><t:Cell>$Resource{endFarmAddress}</t:Cell><t:Cell>$Resource{distance}</t:Cell><t:Cell>$Resource{times}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFarmToFarmEntrys.setFormatXml(resHelper.translateString("kdtFarmToFarmEntrys",kdtFarmToFarmEntrysStrXML));
        kdtFarmToFarmEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFarmToFarmEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFarmToFarmEntrys.putBindContents("editData",new String[] {"seq","startFarm","startFarmAddress","endFarm","endFarmAddress","distance","times"});


        this.kdtFarmToFarmEntrys.checkParsed();
        KDFormattedTextField kdtFarmToFarmEntrys_seq_TextField = new KDFormattedTextField();
        kdtFarmToFarmEntrys_seq_TextField.setName("kdtFarmToFarmEntrys_seq_TextField");
        kdtFarmToFarmEntrys_seq_TextField.setVisible(true);
        kdtFarmToFarmEntrys_seq_TextField.setEditable(true);
        kdtFarmToFarmEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtFarmToFarmEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmToFarmEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_seq_TextField);
        this.kdtFarmToFarmEntrys.getColumn("seq").setEditor(kdtFarmToFarmEntrys_seq_CellEditor);
        final KDBizPromptBox kdtFarmToFarmEntrys_startFarm_PromptBox = new KDBizPromptBox();
        kdtFarmToFarmEntrys_startFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");
        kdtFarmToFarmEntrys_startFarm_PromptBox.setVisible(true);
        kdtFarmToFarmEntrys_startFarm_PromptBox.setEditable(true);
        kdtFarmToFarmEntrys_startFarm_PromptBox.setDisplayFormat("$number$");
        kdtFarmToFarmEntrys_startFarm_PromptBox.setEditFormat("$number$");
        kdtFarmToFarmEntrys_startFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmToFarmEntrys_startFarm_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_startFarm_PromptBox);
        this.kdtFarmToFarmEntrys.getColumn("startFarm").setEditor(kdtFarmToFarmEntrys_startFarm_CellEditor);
        ObjectValueRender kdtFarmToFarmEntrys_startFarm_OVR = new ObjectValueRender();
        kdtFarmToFarmEntrys_startFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmToFarmEntrys.getColumn("startFarm").setRenderer(kdtFarmToFarmEntrys_startFarm_OVR);
        KDTextField kdtFarmToFarmEntrys_startFarmAddress_TextField = new KDTextField();
        kdtFarmToFarmEntrys_startFarmAddress_TextField.setName("kdtFarmToFarmEntrys_startFarmAddress_TextField");
        kdtFarmToFarmEntrys_startFarmAddress_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFarmToFarmEntrys_startFarmAddress_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_startFarmAddress_TextField);
        this.kdtFarmToFarmEntrys.getColumn("startFarmAddress").setEditor(kdtFarmToFarmEntrys_startFarmAddress_CellEditor);
        final KDBizPromptBox kdtFarmToFarmEntrys_endFarm_PromptBox = new KDBizPromptBox();
        kdtFarmToFarmEntrys_endFarm_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.BreedStoorgSetQuery");
        kdtFarmToFarmEntrys_endFarm_PromptBox.setVisible(true);
        kdtFarmToFarmEntrys_endFarm_PromptBox.setEditable(true);
        kdtFarmToFarmEntrys_endFarm_PromptBox.setDisplayFormat("$number$");
        kdtFarmToFarmEntrys_endFarm_PromptBox.setEditFormat("$number$");
        kdtFarmToFarmEntrys_endFarm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmToFarmEntrys_endFarm_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_endFarm_PromptBox);
        this.kdtFarmToFarmEntrys.getColumn("endFarm").setEditor(kdtFarmToFarmEntrys_endFarm_CellEditor);
        ObjectValueRender kdtFarmToFarmEntrys_endFarm_OVR = new ObjectValueRender();
        kdtFarmToFarmEntrys_endFarm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmToFarmEntrys.getColumn("endFarm").setRenderer(kdtFarmToFarmEntrys_endFarm_OVR);
        KDTextField kdtFarmToFarmEntrys_endFarmAddress_TextField = new KDTextField();
        kdtFarmToFarmEntrys_endFarmAddress_TextField.setName("kdtFarmToFarmEntrys_endFarmAddress_TextField");
        kdtFarmToFarmEntrys_endFarmAddress_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFarmToFarmEntrys_endFarmAddress_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_endFarmAddress_TextField);
        this.kdtFarmToFarmEntrys.getColumn("endFarmAddress").setEditor(kdtFarmToFarmEntrys_endFarmAddress_CellEditor);
        KDFormattedTextField kdtFarmToFarmEntrys_distance_TextField = new KDFormattedTextField();
        kdtFarmToFarmEntrys_distance_TextField.setName("kdtFarmToFarmEntrys_distance_TextField");
        kdtFarmToFarmEntrys_distance_TextField.setVisible(true);
        kdtFarmToFarmEntrys_distance_TextField.setEditable(true);
        kdtFarmToFarmEntrys_distance_TextField.setHorizontalAlignment(2);
        kdtFarmToFarmEntrys_distance_TextField.setDataType(1);
        	kdtFarmToFarmEntrys_distance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtFarmToFarmEntrys_distance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtFarmToFarmEntrys_distance_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtFarmToFarmEntrys_distance_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_distance_TextField);
        this.kdtFarmToFarmEntrys.getColumn("distance").setEditor(kdtFarmToFarmEntrys_distance_CellEditor);
        KDFormattedTextField kdtFarmToFarmEntrys_times_TextField = new KDFormattedTextField();
        kdtFarmToFarmEntrys_times_TextField.setName("kdtFarmToFarmEntrys_times_TextField");
        kdtFarmToFarmEntrys_times_TextField.setVisible(true);
        kdtFarmToFarmEntrys_times_TextField.setEditable(true);
        kdtFarmToFarmEntrys_times_TextField.setHorizontalAlignment(2);
        kdtFarmToFarmEntrys_times_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmToFarmEntrys_times_CellEditor = new KDTDefaultCellEditor(kdtFarmToFarmEntrys_times_TextField);
        this.kdtFarmToFarmEntrys.getColumn("times").setEditor(kdtFarmToFarmEntrys_times_CellEditor);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,baseStatus,kdtFarmToFarmEntrys,kdtFacToFarmEntrys}));
        this.setFocusCycleRoot(true);
		//Register control's property binding
		registerBindings();
		registerUIState();


    }

	public com.kingdee.bos.ctrl.swing.KDToolBar[] getUIMultiToolBar(){
		java.util.List list = new java.util.ArrayList();
		com.kingdee.bos.ctrl.swing.KDToolBar[] bars = super.getUIMultiToolBar();
		if (bars != null) {
			list.addAll(java.util.Arrays.asList(bars));
		}
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        kDLabelContainer1.setBounds(new Rectangle(30, 31, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(30, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(370, 31, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(370, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(116, -78, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(116, -78, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(710, 31, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(710, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(29, 109, 968, 504));
        this.add(kDTabbedPane1, new KDLayout.Constraints(29, 109, 968, 504, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(708, 66, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(708, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 967, 471));        kdtFacToFarmEntrys.setBounds(new Rectangle(2, 0, 960, 500));
        kdtFacToFarmEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFacToFarmEntrys,new com.kingdee.eas.farm.feedfactory.JournalTimesFacToFarmEntryInfo(),null,false);
        kDPanel1.add(kdtFacToFarmEntrys_detailPanel, new KDLayout.Constraints(2, 0, 960, 500, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 967, 471));        kdtFarmToFarmEntrys.setBounds(new Rectangle(0, 1, 963, 499));
        kdtFarmToFarmEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFarmToFarmEntrys,new com.kingdee.eas.farm.feedfactory.JournalTimesFarmToFarmEntryInfo(),null,false);
        kDPanel2.add(kdtFarmToFarmEntrys_detailPanel, new KDLayout.Constraints(0, 1, 963, 499, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuHelp
        menuHelp.add(menuItemHelp);
        menuHelp.add(kDSeparator12);
        menuHelp.add(menuItemRegPro);
        menuHelp.add(menuItemPersonalSite);
        menuHelp.add(helpseparatorDiv);
        menuHelp.add(menuitemProductval);
        menuHelp.add(kDSeparatorProduct);
        menuHelp.add(menuItemAbout);

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("FacToFarmEntrys.seq", int.class, this.kdtFacToFarmEntrys, "seq.text");
		dataBinder.registerBinding("FacToFarmEntrys", com.kingdee.eas.farm.feedfactory.JournalTimesFacToFarmEntryInfo.class, this.kdtFacToFarmEntrys, "userObject");
		dataBinder.registerBinding("FacToFarmEntrys.farm", java.lang.Object.class, this.kdtFacToFarmEntrys, "farm.text");
		dataBinder.registerBinding("FacToFarmEntrys.affress", String.class, this.kdtFacToFarmEntrys, "affress.text");
		dataBinder.registerBinding("FacToFarmEntrys.loadTimes", int.class, this.kdtFacToFarmEntrys, "loadTimes.text");
		dataBinder.registerBinding("FacToFarmEntrys.unloadTimes", int.class, this.kdtFacToFarmEntrys, "unloadTimes.text");
		dataBinder.registerBinding("FacToFarmEntrys.distance", java.math.BigDecimal.class, this.kdtFacToFarmEntrys, "distance.text");
		dataBinder.registerBinding("FarmToFarmEntrys.seq", int.class, this.kdtFarmToFarmEntrys, "seq.text");
		dataBinder.registerBinding("FarmToFarmEntrys", com.kingdee.eas.farm.feedfactory.JournalTimesFarmToFarmEntryInfo.class, this.kdtFarmToFarmEntrys, "userObject");
		dataBinder.registerBinding("FarmToFarmEntrys.startFarm", java.lang.Object.class, this.kdtFarmToFarmEntrys, "startFarm.text");
		dataBinder.registerBinding("FarmToFarmEntrys.startFarmAddress", String.class, this.kdtFarmToFarmEntrys, "startFarmAddress.text");
		dataBinder.registerBinding("FarmToFarmEntrys.endFarm", java.lang.Object.class, this.kdtFarmToFarmEntrys, "endFarm.text");
		dataBinder.registerBinding("FarmToFarmEntrys.endFarmAddress", String.class, this.kdtFarmToFarmEntrys, "endFarmAddress.text");
		dataBinder.registerBinding("FarmToFarmEntrys.times", int.class, this.kdtFarmToFarmEntrys, "times.text");
		dataBinder.registerBinding("FarmToFarmEntrys.distance", java.math.BigDecimal.class, this.kdtFarmToFarmEntrys, "distance.text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.feedfactory.app.JournalTimesEditUIHandler";
	}
	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
    		request.setClassName(getUIHandlerClassName());
			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
    }
	
	public boolean isPrepareInit() {
    	return false;
    }
    protected void initUIP() {
        super.initUIP();
    }


    /**
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feedfactory.JournalTimesInfo)ov;
    }
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.affress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.loadTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.unloadTimes", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FacToFarmEntrys.distance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.startFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.startFarmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.endFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.endFarmAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.times", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmToFarmEntrys.distance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
        }
    }


    /**
     * output kdtFacToFarmEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFacToFarmEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farm".equalsIgnoreCase(kdtFacToFarmEntrys.getColumn(colIndex).getKey())) {
kdtFacToFarmEntrys.getCell(rowIndex,"affress").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFacToFarmEntrys.getCell(rowIndex,"farm").getValue(),"address")));

}


    }

    /**
     * output kdtFarmToFarmEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFarmToFarmEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("startFarm".equalsIgnoreCase(kdtFarmToFarmEntrys.getColumn(colIndex).getKey())) {
kdtFarmToFarmEntrys.getCell(rowIndex,"startFarmAddress").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmToFarmEntrys.getCell(rowIndex,"startFarm").getValue(),"address")));

}

    if ("endFarm".equalsIgnoreCase(kdtFarmToFarmEntrys.getColumn(colIndex).getKey())) {
kdtFarmToFarmEntrys.getCell(rowIndex,"endFarmAddress").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmToFarmEntrys.getCell(rowIndex,"endFarm").getValue(),"address")));

}


    }
    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
    	sic.add(new SelectorItemInfo("FacToFarmEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FacToFarmEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FacToFarmEntrys.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FacToFarmEntrys.farm.id"));
			sic.add(new SelectorItemInfo("FacToFarmEntrys.farm.name"));
        	sic.add(new SelectorItemInfo("FacToFarmEntrys.farm.number"));
		}
    	sic.add(new SelectorItemInfo("FacToFarmEntrys.affress"));
    	sic.add(new SelectorItemInfo("FacToFarmEntrys.loadTimes"));
    	sic.add(new SelectorItemInfo("FacToFarmEntrys.unloadTimes"));
    	sic.add(new SelectorItemInfo("FacToFarmEntrys.distance"));
    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmToFarmEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmToFarmEntrys.startFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.startFarm.id"));
			sic.add(new SelectorItemInfo("FarmToFarmEntrys.startFarm.name"));
        	sic.add(new SelectorItemInfo("FarmToFarmEntrys.startFarm.number"));
		}
    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.startFarmAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmToFarmEntrys.endFarm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.endFarm.id"));
			sic.add(new SelectorItemInfo("FarmToFarmEntrys.endFarm.name"));
        	sic.add(new SelectorItemInfo("FarmToFarmEntrys.endFarm.number"));
		}
    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.endFarmAddress"));
    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.times"));
    	sic.add(new SelectorItemInfo("FarmToFarmEntrys.distance"));
        sic.add(new SelectorItemInfo("baseStatus"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feedfactory.client", "JournalTimesEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feedfactory.client.JournalTimesEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.JournalTimesFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.JournalTimesInfo objectValue = new com.kingdee.eas.farm.feedfactory.JournalTimesInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtFacToFarmEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}