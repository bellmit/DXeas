/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractFarmerInterestEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerInterestEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiod;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExcel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFarmerInterestEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerInterestEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnExcel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtperiod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.contperiod.setName("contperiod");
        this.kdtEntry.setName("kdtEntry");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.btnExcel.setName("btnExcel");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.prmtperiod.setName("prmtperiod");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
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
        // contperiod		
        this.contperiod.setBoundLabelText(resHelper.getString("contperiod.boundLabelText"));		
        this.contperiod.setBoundLabelLength(100);		
        this.contperiod.setBoundLabelUnderline(true);		
        this.contperiod.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"outHouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stockingBatch\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"interest\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"diffInterest\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmer}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{outHouse}</t:Cell><t:Cell>$Resource{stockingBatch}</t:Cell><t:Cell>$Resource{interest}</t:Cell><t:Cell>$Resource{diffInterest}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","farmer","farm","outHouse","stockingBatch","interest","diffInterest"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtEntry_farmer_PromptBox.setVisible(true);
        kdtEntry_farmer_PromptBox.setEditable(true);
        kdtEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtEntry_farmer_PromptBox);
        this.kdtEntry.getColumn("farmer").setEditor(kdtEntry_farmer_CellEditor);
        ObjectValueRender kdtEntry_farmer_OVR = new ObjectValueRender();
        kdtEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("farmer").setRenderer(kdtEntry_farmer_OVR);
        			kdtEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_farmer_PromptBox_F7ListUI));
					kdtEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_farmer_PromptBox.setSelector(kdtEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntry_farm_PromptBox = new KDBizPromptBox();
        kdtEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");
        kdtEntry_farm_PromptBox.setVisible(true);
        kdtEntry_farm_PromptBox.setEditable(true);
        kdtEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtEntry_farm_PromptBox.setEditFormat("$number$");
        kdtEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtEntry_farm_PromptBox);
        this.kdtEntry.getColumn("farm").setEditor(kdtEntry_farm_CellEditor);
        ObjectValueRender kdtEntry_farm_OVR = new ObjectValueRender();
        kdtEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("farm").setRenderer(kdtEntry_farm_OVR);
        			kdtEntry_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI kdtEntry_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_farm_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_farm_PromptBox_F7ListUI));
					kdtEntry_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_farm_PromptBox.setSelector(kdtEntry_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntry_stockingBatch_PromptBox = new KDBizPromptBox();
        kdtEntry_stockingBatch_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");
        kdtEntry_stockingBatch_PromptBox.setVisible(true);
        kdtEntry_stockingBatch_PromptBox.setEditable(true);
        kdtEntry_stockingBatch_PromptBox.setDisplayFormat("$number$");
        kdtEntry_stockingBatch_PromptBox.setEditFormat("$number$");
        kdtEntry_stockingBatch_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_stockingBatch_CellEditor = new KDTDefaultCellEditor(kdtEntry_stockingBatch_PromptBox);
        this.kdtEntry.getColumn("stockingBatch").setEditor(kdtEntry_stockingBatch_CellEditor);
        ObjectValueRender kdtEntry_stockingBatch_OVR = new ObjectValueRender();
        kdtEntry_stockingBatch_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("stockingBatch").setRenderer(kdtEntry_stockingBatch_OVR);
        			kdtEntry_stockingBatch_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI kdtEntry_stockingBatch_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_stockingBatch_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_stockingBatch_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_stockingBatch_PromptBox_F7ListUI));
					kdtEntry_stockingBatch_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_stockingBatch_PromptBox.setSelector(kdtEntry_stockingBatch_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntry_interest_TextField = new KDFormattedTextField();
        kdtEntry_interest_TextField.setName("kdtEntry_interest_TextField");
        kdtEntry_interest_TextField.setVisible(true);
        kdtEntry_interest_TextField.setEditable(true);
        kdtEntry_interest_TextField.setHorizontalAlignment(2);
        kdtEntry_interest_TextField.setDataType(1);
        	kdtEntry_interest_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E22"));
        	kdtEntry_interest_TextField.setMaximumValue(new java.math.BigDecimal("1.0E22"));
        kdtEntry_interest_TextField.setPrecision(6);
        KDTDefaultCellEditor kdtEntry_interest_CellEditor = new KDTDefaultCellEditor(kdtEntry_interest_TextField);
        this.kdtEntry.getColumn("interest").setEditor(kdtEntry_interest_CellEditor);
        KDFormattedTextField kdtEntry_diffInterest_TextField = new KDFormattedTextField();
        kdtEntry_diffInterest_TextField.setName("kdtEntry_diffInterest_TextField");
        kdtEntry_diffInterest_TextField.setVisible(true);
        kdtEntry_diffInterest_TextField.setEditable(true);
        kdtEntry_diffInterest_TextField.setHorizontalAlignment(2);
        kdtEntry_diffInterest_TextField.setDataType(1);
        	kdtEntry_diffInterest_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_diffInterest_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_diffInterest_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_diffInterest_CellEditor = new KDTDefaultCellEditor(kdtEntry_diffInterest_TextField);
        this.kdtEntry.getColumn("diffInterest").setEditor(kdtEntry_diffInterest_CellEditor);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // btnExcel		
        this.btnExcel.setText(resHelper.getString("btnExcel.text"));		
        this.btnExcel.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // prmtperiod		
        this.prmtperiod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiod.setEditable(true);		
        this.prmtperiod.setDisplayFormat("$number$");		
        this.prmtperiod.setEditFormat("$number$");		
        this.prmtperiod.setCommitFormat("$number$");		
        this.prmtperiod.setRequired(true);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,prmtperiod,billStatus,kdtEntry,prmtcompany}));
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
        this.setBounds(new Rectangle(0, 0, 598, 408));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(21, 19, 262, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(21, 60, 262, 19));
        this.add(kDLabelContainer2, null);
        contperiod.setBounds(new Rectangle(302, 19, 262, 19));
        this.add(contperiod, null);
        kdtEntry.setBounds(new Rectangle(20, 133, 551, 251));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.stocking.basedata.FarmerInterestEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, null);
        contbillStatus.setBounds(new Rectangle(302, 60, 262, 19));
        this.add(contbillStatus, null);
        contcompany.setBounds(new Rectangle(21, 98, 262, 19));
        this.add(contcompany, null);
        btnExcel.setBounds(new Rectangle(498, 95, 73, 21));
        this.add(btnExcel, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //contperiod
        contperiod.setBoundEditor(prmtperiod);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.stocking.basedata.FarmerInterestEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.farmer", java.lang.Object.class, this.kdtEntry, "farmer.text");
		dataBinder.registerBinding("Entry.interest", java.math.BigDecimal.class, this.kdtEntry, "interest.text");
		dataBinder.registerBinding("Entry.stockingBatch", java.lang.Object.class, this.kdtEntry, "stockingBatch.text");
		dataBinder.registerBinding("Entry.outHouse", java.lang.Object.class, this.kdtEntry, "outHouse.text");
		dataBinder.registerBinding("Entry.farm", java.lang.Object.class, this.kdtEntry, "farm.text");
		dataBinder.registerBinding("Entry.diffInterest", java.math.BigDecimal.class, this.kdtEntry, "diffInterest.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiod, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.ncm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.basedata.app.FarmerInterestEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo)ov;
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
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.interest", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.stockingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.outHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.diffInterest", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtNumber.setEnabled(false);
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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.farmer.id"));
			sic.add(new SelectorItemInfo("Entry.farmer.name"));
        	sic.add(new SelectorItemInfo("Entry.farmer.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.interest"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.stockingBatch.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.stockingBatch.id"));
			sic.add(new SelectorItemInfo("Entry.stockingBatch.name"));
        	sic.add(new SelectorItemInfo("Entry.stockingBatch.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.outHouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.outHouse.id"));
			sic.add(new SelectorItemInfo("Entry.outHouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.farm.id"));
			sic.add(new SelectorItemInfo("Entry.farm.name"));
        	sic.add(new SelectorItemInfo("Entry.farm.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.diffInterest"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "FarmerInterestEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.FarmerInterestEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmerInterestFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmerInterestInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntry.getCell(i,"farmer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperiod.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"期间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}