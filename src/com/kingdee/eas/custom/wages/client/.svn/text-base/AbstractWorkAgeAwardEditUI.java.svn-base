/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractWorkAgeAwardEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlBaseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractWorkAgeAwardEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtBonus;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtBonus_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCalculation;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCalculation_detailPanel = null;
    protected com.kingdee.eas.custom.wages.WorkAgeAwardInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractWorkAgeAwardEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractWorkAgeAwardEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtBonus = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtCalculation = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtBonus.setName("kdtBonus");
        this.kdtCalculation.setName("kdtCalculation");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);		
        this.contapprover.setBoundLabelText(resHelper.getString("contapprover.boundLabelText"));		
        this.contapprover.setBoundLabelLength(100);		
        this.contapprover.setBoundLabelUnderline(true);		
        this.contapprover.setVisible(true);		
        this.contapproveTime.setBoundLabelText(resHelper.getString("contapproveTime.boundLabelText"));		
        this.contapproveTime.setBoundLabelLength(100);		
        this.contapproveTime.setBoundLabelUnderline(true);		
        this.contapproveTime.setVisible(true);		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);		
        this.contcreator.setBoundLabelText(resHelper.getString("contcreator.boundLabelText"));		
        this.contcreator.setBoundLabelLength(100);		
        this.contcreator.setBoundLabelUnderline(true);		
        this.contcreator.setVisible(true);		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);		
        this.txtNumber.setMaxLength(80);		
        this.txtSimpleName.setMaxLength(80);		
        this.txtDescription.setVisible(false);		
        this.prmtapprover.setEditable(true);		
        this.prmtapprover.setDisplayFormat("$number$");		
        this.prmtapprover.setEditFormat("$number$");		
        this.prmtapprover.setCommitFormat("$number$");		
        this.prmtapprover.setRequired(false);		
        this.prmtapprover.setEnabled(false);		
        this.pkapproveTime.setRequired(false);		
        this.pkapproveTime.setEnabled(false);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // kDPanel1
        // kDPanel2
        // kdtBonus
		String kdtBonusStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"workD\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"workX\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"standard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{workD}</t:Cell><t:Cell>$Resource{workX}</t:Cell><t:Cell>$Resource{standard}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtBonus.setFormatXml(resHelper.translateString("kdtBonus",kdtBonusStrXML));

                this.kdtBonus.putBindContents("editData",new String[] {"seq","workD","workX","standard"});


        this.kdtBonus.checkParsed();
        KDFormattedTextField kdtBonus_seq_TextField = new KDFormattedTextField();
        kdtBonus_seq_TextField.setName("kdtBonus_seq_TextField");
        kdtBonus_seq_TextField.setVisible(true);
        kdtBonus_seq_TextField.setEditable(true);
        kdtBonus_seq_TextField.setHorizontalAlignment(2);
        kdtBonus_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtBonus_seq_CellEditor = new KDTDefaultCellEditor(kdtBonus_seq_TextField);
        this.kdtBonus.getColumn("seq").setEditor(kdtBonus_seq_CellEditor);
        KDFormattedTextField kdtBonus_workD_TextField = new KDFormattedTextField();
        kdtBonus_workD_TextField.setName("kdtBonus_workD_TextField");
        kdtBonus_workD_TextField.setVisible(true);
        kdtBonus_workD_TextField.setEditable(true);
        kdtBonus_workD_TextField.setHorizontalAlignment(2);
        kdtBonus_workD_TextField.setDataType(1);
        	kdtBonus_workD_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBonus_workD_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBonus_workD_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBonus_workD_CellEditor = new KDTDefaultCellEditor(kdtBonus_workD_TextField);
        this.kdtBonus.getColumn("workD").setEditor(kdtBonus_workD_CellEditor);
        KDFormattedTextField kdtBonus_workX_TextField = new KDFormattedTextField();
        kdtBonus_workX_TextField.setName("kdtBonus_workX_TextField");
        kdtBonus_workX_TextField.setVisible(true);
        kdtBonus_workX_TextField.setEditable(true);
        kdtBonus_workX_TextField.setHorizontalAlignment(2);
        kdtBonus_workX_TextField.setDataType(1);
        	kdtBonus_workX_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBonus_workX_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBonus_workX_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBonus_workX_CellEditor = new KDTDefaultCellEditor(kdtBonus_workX_TextField);
        this.kdtBonus.getColumn("workX").setEditor(kdtBonus_workX_CellEditor);
        KDFormattedTextField kdtBonus_standard_TextField = new KDFormattedTextField();
        kdtBonus_standard_TextField.setName("kdtBonus_standard_TextField");
        kdtBonus_standard_TextField.setVisible(true);
        kdtBonus_standard_TextField.setEditable(true);
        kdtBonus_standard_TextField.setHorizontalAlignment(2);
        kdtBonus_standard_TextField.setDataType(1);
        	kdtBonus_standard_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtBonus_standard_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtBonus_standard_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtBonus_standard_CellEditor = new KDTDefaultCellEditor(kdtBonus_standard_TextField);
        this.kdtBonus.getColumn("standard").setEditor(kdtBonus_standard_CellEditor);
        // kdtCalculation
		String kdtCalculationStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"daysD\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"daysX\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"percentage\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{daysD}</t:Cell><t:Cell>$Resource{daysX}</t:Cell><t:Cell>$Resource{percentage}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCalculation.setFormatXml(resHelper.translateString("kdtCalculation",kdtCalculationStrXML));

                this.kdtCalculation.putBindContents("editData",new String[] {"seq","daysD","daysX","percentage"});


        this.kdtCalculation.checkParsed();
        KDFormattedTextField kdtCalculation_seq_TextField = new KDFormattedTextField();
        kdtCalculation_seq_TextField.setName("kdtCalculation_seq_TextField");
        kdtCalculation_seq_TextField.setVisible(true);
        kdtCalculation_seq_TextField.setEditable(true);
        kdtCalculation_seq_TextField.setHorizontalAlignment(2);
        kdtCalculation_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtCalculation_seq_CellEditor = new KDTDefaultCellEditor(kdtCalculation_seq_TextField);
        this.kdtCalculation.getColumn("seq").setEditor(kdtCalculation_seq_CellEditor);
        KDFormattedTextField kdtCalculation_daysD_TextField = new KDFormattedTextField();
        kdtCalculation_daysD_TextField.setName("kdtCalculation_daysD_TextField");
        kdtCalculation_daysD_TextField.setVisible(true);
        kdtCalculation_daysD_TextField.setEditable(true);
        kdtCalculation_daysD_TextField.setHorizontalAlignment(2);
        kdtCalculation_daysD_TextField.setDataType(1);
        	kdtCalculation_daysD_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtCalculation_daysD_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtCalculation_daysD_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtCalculation_daysD_CellEditor = new KDTDefaultCellEditor(kdtCalculation_daysD_TextField);
        this.kdtCalculation.getColumn("daysD").setEditor(kdtCalculation_daysD_CellEditor);
        KDFormattedTextField kdtCalculation_daysX_TextField = new KDFormattedTextField();
        kdtCalculation_daysX_TextField.setName("kdtCalculation_daysX_TextField");
        kdtCalculation_daysX_TextField.setVisible(true);
        kdtCalculation_daysX_TextField.setEditable(true);
        kdtCalculation_daysX_TextField.setHorizontalAlignment(2);
        kdtCalculation_daysX_TextField.setDataType(1);
        	kdtCalculation_daysX_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtCalculation_daysX_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtCalculation_daysX_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtCalculation_daysX_CellEditor = new KDTDefaultCellEditor(kdtCalculation_daysX_TextField);
        this.kdtCalculation.getColumn("daysX").setEditor(kdtCalculation_daysX_CellEditor);
        KDFormattedTextField kdtCalculation_percentage_TextField = new KDFormattedTextField();
        kdtCalculation_percentage_TextField.setName("kdtCalculation_percentage_TextField");
        kdtCalculation_percentage_TextField.setVisible(true);
        kdtCalculation_percentage_TextField.setEditable(true);
        kdtCalculation_percentage_TextField.setHorizontalAlignment(2);
        kdtCalculation_percentage_TextField.setDataType(1);
        	kdtCalculation_percentage_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtCalculation_percentage_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtCalculation_percentage_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtCalculation_percentage_CellEditor = new KDTDefaultCellEditor(kdtCalculation_percentage_TextField);
        this.kdtCalculation.getColumn("percentage").setEditor(kdtCalculation_percentage_CellEditor);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompany,pkcreateTime,prmtcreator,txtSimpleName,txtDescription,txtNumber,txtName,baseStatus,pkapproveTime,prmtapprover,kdtCalculation,kdtBonus}));
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
        this.setBounds(new Rectangle(0, 0, 1002, 484));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(15, 18, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(344, 16, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(697, 17, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(697, 55, 270, 19));
        this.add(kDLabelContainer4, null);
        contapprover.setBounds(new Rectangle(697, 401, 270, 19));
        this.add(contapprover, null);
        contapproveTime.setBounds(new Rectangle(697, 445, 270, 19));
        this.add(contapproveTime, null);
        contbaseStatus.setBounds(new Rectangle(15, 55, 270, 19));
        this.add(contbaseStatus, null);
        contcreator.setBounds(new Rectangle(15, 401, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(15, 445, 270, 19));
        this.add(contcreateTime, null);
        contcompany.setBounds(new Rectangle(344, 55, 270, 19));
        this.add(contcompany, null);
        kDTabbedPane1.setBounds(new Rectangle(19, 98, 952, 255));
        this.add(kDTabbedPane1, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contapprover
        contapprover.setBoundEditor(prmtapprover);
        //contapproveTime
        contapproveTime.setBoundEditor(pkapproveTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtBonus.setBounds(new Rectangle(1, 1, 948, 222));
        kdtBonus_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtBonus,new com.kingdee.eas.custom.wages.WorkAgeAwardBonuInfo(),null,false);
        kDPanel1.add(kdtBonus_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtCalculation.setBounds(new Rectangle(1, 1, 948, 224));
        kdtCalculation_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCalculation,new com.kingdee.eas.custom.wages.WorkAgeAwardCalculationInfo(),null,false);
        kDPanel2.add(kdtCalculation_detailPanel, null);

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
        menuBiz.add(mBtnApprove);
        menuBiz.add(mBtnUnApprove);
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
        this.toolBar.add(tBtnApprove);
        this.toolBar.add(tBtnUnApprove);
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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("approver", com.kingdee.eas.base.permission.UserInfo.class, this.prmtapprover, "data");
		dataBinder.registerBinding("approveTime", java.util.Date.class, this.pkapproveTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("Bonus.seq", int.class, this.kdtBonus, "seq.text");
		dataBinder.registerBinding("Bonus", com.kingdee.eas.custom.wages.WorkAgeAwardBonuInfo.class, this.kdtBonus, "userObject");
		dataBinder.registerBinding("Bonus.standard", java.math.BigDecimal.class, this.kdtBonus, "standard.text");
		dataBinder.registerBinding("Bonus.workX", java.math.BigDecimal.class, this.kdtBonus, "workX.text");
		dataBinder.registerBinding("Bonus.workD", java.math.BigDecimal.class, this.kdtBonus, "workD.text");
		dataBinder.registerBinding("Calculation.seq", int.class, this.kdtCalculation, "seq.text");
		dataBinder.registerBinding("Calculation", com.kingdee.eas.custom.wages.WorkAgeAwardCalculationInfo.class, this.kdtCalculation, "userObject");
		dataBinder.registerBinding("Calculation.daysD", java.math.BigDecimal.class, this.kdtCalculation, "daysD.text");
		dataBinder.registerBinding("Calculation.daysX", java.math.BigDecimal.class, this.kdtCalculation, "daysX.text");
		dataBinder.registerBinding("Calculation.percentage", java.math.BigDecimal.class, this.kdtCalculation, "percentage.text");		
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
	    return "com.kingdee.eas.custom.wages.app.WorkAgeAwardEditUIHandler";
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
        this.prmtcompany.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.WorkAgeAwardInfo)ov;
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
		getValidateHelper().registerBindProperty("approver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("approveTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Bonus.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Bonus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Bonus.standard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Bonus.workX", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Bonus.workD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Calculation.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Calculation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Calculation.daysD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Calculation.daysX", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Calculation.percentage", ValidateHelper.ON_SAVE);    		
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("approver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("approver.id"));
        	sic.add(new SelectorItemInfo("approver.number"));
        	sic.add(new SelectorItemInfo("approver.name"));
		}
        sic.add(new SelectorItemInfo("approveTime"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
    	sic.add(new SelectorItemInfo("Bonus.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Bonus.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Bonus.standard"));
    	sic.add(new SelectorItemInfo("Bonus.workX"));
    	sic.add(new SelectorItemInfo("Bonus.workD"));
    	sic.add(new SelectorItemInfo("Calculation.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Calculation.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Calculation.daysD"));
    	sic.add(new SelectorItemInfo("Calculation.daysX"));
    	sic.add(new SelectorItemInfo("Calculation.percentage"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "WorkAgeAwardEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.client.WorkAgeAwardEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.WorkAgeAwardFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.WorkAgeAwardInfo objectValue = new com.kingdee.eas.custom.wages.WorkAgeAwardInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }



    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtBonus;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}