/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

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
public abstract class AbstractSaleConditionsEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleConditionsEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuser;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtuser;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAREntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAREntry_detailPanel = null;
    protected com.kingdee.eas.custom.lhsm.SaleConditionsInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSaleConditionsEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSaleConditionsEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contuser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtuser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAREntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contuser.setName("contuser");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtuser.setName("prmtuser");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntry.setName("kdtEntry");
        this.kdtAREntry.setName("kdtAREntry");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contuser		
        this.contuser.setBoundLabelText(resHelper.getString("contuser.boundLabelText"));		
        this.contuser.setBoundLabelLength(100);		
        this.contuser.setBoundLabelUnderline(true);		
        this.contuser.setVisible(true);
        // kDTabbedPane1
        // prmtuser		
        this.prmtuser.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtuser.setEditable(true);		
        this.prmtuser.setDisplayFormat("$name$");		
        this.prmtuser.setEditFormat("$number$");		
        this.prmtuser.setCommitFormat("$number$");		
        this.prmtuser.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"condition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"choose\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fieldName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sqlString\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{condition}</t:Cell><t:Cell>$Resource{choose}</t:Cell><t:Cell>$Resource{fieldName}</t:Cell><t:Cell>$Resource{sqlString}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

                this.kdtEntry.putBindContents("editData",new String[] {"seq","condition","choose","fieldName","sqlString"});


        this.kdtEntry.checkParsed();
        KDTextField kdtEntry_condition_TextField = new KDTextField();
        kdtEntry_condition_TextField.setName("kdtEntry_condition_TextField");
        kdtEntry_condition_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_condition_CellEditor = new KDTDefaultCellEditor(kdtEntry_condition_TextField);
        this.kdtEntry.getColumn("condition").setEditor(kdtEntry_condition_CellEditor);
        KDCheckBox kdtEntry_choose_CheckBox = new KDCheckBox();
        kdtEntry_choose_CheckBox.setName("kdtEntry_choose_CheckBox");
        KDTDefaultCellEditor kdtEntry_choose_CellEditor = new KDTDefaultCellEditor(kdtEntry_choose_CheckBox);
        this.kdtEntry.getColumn("choose").setEditor(kdtEntry_choose_CellEditor);
        KDTextField kdtEntry_fieldName_TextField = new KDTextField();
        kdtEntry_fieldName_TextField.setName("kdtEntry_fieldName_TextField");
        kdtEntry_fieldName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_fieldName_CellEditor = new KDTDefaultCellEditor(kdtEntry_fieldName_TextField);
        this.kdtEntry.getColumn("fieldName").setEditor(kdtEntry_fieldName_CellEditor);
        KDTextArea kdtEntry_sqlString_TextArea = new KDTextArea();
        kdtEntry_sqlString_TextArea.setName("kdtEntry_sqlString_TextArea");
        kdtEntry_sqlString_TextArea.setMaxLength(2000);
        KDTDefaultCellEditor kdtEntry_sqlString_CellEditor = new KDTDefaultCellEditor(kdtEntry_sqlString_TextArea);
        this.kdtEntry.getColumn("sqlString").setEditor(kdtEntry_sqlString_CellEditor);
        // kdtAREntry
		String kdtAREntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"condition\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"choose\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"fieldName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"sqlString\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{condition}</t:Cell><t:Cell>$Resource{choose}</t:Cell><t:Cell>$Resource{fieldName}</t:Cell><t:Cell>$Resource{sqlString}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAREntry.setFormatXml(resHelper.translateString("kdtAREntry",kdtAREntryStrXML));

                this.kdtAREntry.putBindContents("editData",new String[] {"seq","condition","choose","fieldName","sqlString"});


        this.kdtAREntry.checkParsed();
        KDTextField kdtAREntry_condition_TextField = new KDTextField();
        kdtAREntry_condition_TextField.setName("kdtAREntry_condition_TextField");
        kdtAREntry_condition_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAREntry_condition_CellEditor = new KDTDefaultCellEditor(kdtAREntry_condition_TextField);
        this.kdtAREntry.getColumn("condition").setEditor(kdtAREntry_condition_CellEditor);
        KDCheckBox kdtAREntry_choose_CheckBox = new KDCheckBox();
        kdtAREntry_choose_CheckBox.setName("kdtAREntry_choose_CheckBox");
        KDTDefaultCellEditor kdtAREntry_choose_CellEditor = new KDTDefaultCellEditor(kdtAREntry_choose_CheckBox);
        this.kdtAREntry.getColumn("choose").setEditor(kdtAREntry_choose_CellEditor);
        KDTextField kdtAREntry_fieldName_TextField = new KDTextField();
        kdtAREntry_fieldName_TextField.setName("kdtAREntry_fieldName_TextField");
        kdtAREntry_fieldName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtAREntry_fieldName_CellEditor = new KDTDefaultCellEditor(kdtAREntry_fieldName_TextField);
        this.kdtAREntry.getColumn("fieldName").setEditor(kdtAREntry_fieldName_CellEditor);
        KDTextArea kdtAREntry_sqlString_TextArea = new KDTextArea();
        kdtAREntry_sqlString_TextArea.setName("kdtAREntry_sqlString_TextArea");
        kdtAREntry_sqlString_TextArea.setMaxLength(2000);
        KDTDefaultCellEditor kdtAREntry_sqlString_CellEditor = new KDTDefaultCellEditor(kdtAREntry_sqlString_TextArea);
        this.kdtAREntry.getColumn("sqlString").setEditor(kdtAREntry_sqlString_CellEditor);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtuser,kdtAREntry}));
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
        this.setBounds(new Rectangle(0, 0, 385, 623));
        this.setLayout(null);
        contuser.setBounds(new Rectangle(17, 13, 353, 19));
        this.add(contuser, null);
        kDTabbedPane1.setBounds(new Rectangle(13, 49, 360, 560));
        this.add(kDTabbedPane1, null);
        //contuser
        contuser.setBoundEditor(prmtuser);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtEntry.setBounds(new Rectangle(2, 10, 346, 509));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.lhsm.SaleConditionsEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtAREntry.setBounds(new Rectangle(5, 11, 342, 505));
        kdtAREntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAREntry,new com.kingdee.eas.custom.lhsm.SaleConditionsAREntryInfo(),null,false);
        kDPanel2.add(kdtAREntry_detailPanel, null);

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
		dataBinder.registerBinding("user", com.kingdee.eas.base.permission.UserInfo.class, this.prmtuser, "data");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.lhsm.SaleConditionsEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.condition", String.class, this.kdtEntry, "condition.text");
		dataBinder.registerBinding("Entry.choose", boolean.class, this.kdtEntry, "choose.text");
		dataBinder.registerBinding("Entry.fieldName", String.class, this.kdtEntry, "fieldName.text");
		dataBinder.registerBinding("Entry.sqlString", String.class, this.kdtEntry, "sqlString.text");
		dataBinder.registerBinding("AREntry.seq", int.class, this.kdtAREntry, "seq.text");
		dataBinder.registerBinding("AREntry", com.kingdee.eas.custom.lhsm.SaleConditionsAREntryInfo.class, this.kdtAREntry, "userObject");
		dataBinder.registerBinding("AREntry.condition", String.class, this.kdtAREntry, "condition.text");
		dataBinder.registerBinding("AREntry.choose", boolean.class, this.kdtAREntry, "choose.text");
		dataBinder.registerBinding("AREntry.fieldName", String.class, this.kdtAREntry, "fieldName.text");
		dataBinder.registerBinding("AREntry.sqlString", String.class, this.kdtAREntry, "sqlString.text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.lhsm.app.SaleConditionsEditUIHandler";
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
        this.prmtuser.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.lhsm.SaleConditionsInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
	 * ????????ßµ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("user", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.condition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.choose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.fieldName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.sqlString", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry.condition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry.choose", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry.fieldName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AREntry.sqlString", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("user.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("user.id"));
        	sic.add(new SelectorItemInfo("user.number"));
        	sic.add(new SelectorItemInfo("user.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entry.condition"));
    	sic.add(new SelectorItemInfo("Entry.choose"));
    	sic.add(new SelectorItemInfo("Entry.fieldName"));
    	sic.add(new SelectorItemInfo("Entry.sqlString"));
    	sic.add(new SelectorItemInfo("AREntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AREntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("AREntry.condition"));
    	sic.add(new SelectorItemInfo("AREntry.choose"));
    	sic.add(new SelectorItemInfo("AREntry.fieldName"));
    	sic.add(new SelectorItemInfo("AREntry.sqlString"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "SaleConditionsEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.lhsm.client.SaleConditionsEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.lhsm.SaleConditionsFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.lhsm.SaleConditionsInfo objectValue = new com.kingdee.eas.custom.lhsm.SaleConditionsInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtuser.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"”√ªß"});
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}