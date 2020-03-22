/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

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
public abstract class AbstractOrganizationRelationEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractOrganizationRelationEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadminOrgName;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtShrAdminOrg;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtShrAdminOrg_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadminOrg;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtadminOrgName;
    protected com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractOrganizationRelationEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractOrganizationRelationEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadminOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadminOrgName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtShrAdminOrg = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcompanyOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtadminOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtadminOrgName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.contcompanyOrg.setName("contcompanyOrg");
        this.contadminOrg.setName("contadminOrg");
        this.contadminOrgName.setName("contadminOrgName");
        this.kdtShrAdminOrg.setName("kdtShrAdminOrg");
        this.txtNumber.setName("txtNumber");
        this.prmtcompanyOrg.setName("prmtcompanyOrg");
        this.prmtadminOrg.setName("prmtadminOrg");
        this.txtadminOrgName.setName("txtadminOrgName");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // contcompanyOrg		
        this.contcompanyOrg.setBoundLabelText(resHelper.getString("contcompanyOrg.boundLabelText"));		
        this.contcompanyOrg.setBoundLabelLength(100);		
        this.contcompanyOrg.setBoundLabelUnderline(true);		
        this.contcompanyOrg.setVisible(true);
        // contadminOrg		
        this.contadminOrg.setBoundLabelText(resHelper.getString("contadminOrg.boundLabelText"));		
        this.contadminOrg.setBoundLabelLength(100);		
        this.contadminOrg.setBoundLabelUnderline(true);		
        this.contadminOrg.setVisible(true);
        // contadminOrgName		
        this.contadminOrgName.setBoundLabelText(resHelper.getString("contadminOrgName.boundLabelText"));		
        this.contadminOrgName.setBoundLabelLength(100);		
        this.contadminOrgName.setBoundLabelUnderline(true);		
        this.contadminOrgName.setVisible(true);
        // kdtShrAdminOrg
		String kdtShrAdminOrgStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"shrAdminOrg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"shrAdminOrgName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{shrAdminOrg}</t:Cell><t:Cell>$Resource{shrAdminOrgName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtShrAdminOrg.setFormatXml(resHelper.translateString("kdtShrAdminOrg",kdtShrAdminOrgStrXML));

                this.kdtShrAdminOrg.putBindContents("editData",new String[] {"seq","shrAdminOrg","shrAdminOrgName"});


        this.kdtShrAdminOrg.checkParsed();
        KDFormattedTextField kdtShrAdminOrg_seq_TextField = new KDFormattedTextField();
        kdtShrAdminOrg_seq_TextField.setName("kdtShrAdminOrg_seq_TextField");
        kdtShrAdminOrg_seq_TextField.setVisible(true);
        kdtShrAdminOrg_seq_TextField.setEditable(true);
        kdtShrAdminOrg_seq_TextField.setHorizontalAlignment(2);
        kdtShrAdminOrg_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtShrAdminOrg_seq_CellEditor = new KDTDefaultCellEditor(kdtShrAdminOrg_seq_TextField);
        this.kdtShrAdminOrg.getColumn("seq").setEditor(kdtShrAdminOrg_seq_CellEditor);
        KDTextField kdtShrAdminOrg_shrAdminOrg_TextField = new KDTextField();
        kdtShrAdminOrg_shrAdminOrg_TextField.setName("kdtShrAdminOrg_shrAdminOrg_TextField");
        kdtShrAdminOrg_shrAdminOrg_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtShrAdminOrg_shrAdminOrg_CellEditor = new KDTDefaultCellEditor(kdtShrAdminOrg_shrAdminOrg_TextField);
        this.kdtShrAdminOrg.getColumn("shrAdminOrg").setEditor(kdtShrAdminOrg_shrAdminOrg_CellEditor);
        KDTextField kdtShrAdminOrg_shrAdminOrgName_TextField = new KDTextField();
        kdtShrAdminOrg_shrAdminOrgName_TextField.setName("kdtShrAdminOrg_shrAdminOrgName_TextField");
        kdtShrAdminOrg_shrAdminOrgName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtShrAdminOrg_shrAdminOrgName_CellEditor = new KDTDefaultCellEditor(kdtShrAdminOrg_shrAdminOrgName_TextField);
        this.kdtShrAdminOrg.getColumn("shrAdminOrgName").setEditor(kdtShrAdminOrg_shrAdminOrgName_CellEditor);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // prmtcompanyOrg		
        this.prmtcompanyOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrg.setVisible(true);		
        this.prmtcompanyOrg.setEditable(true);		
        this.prmtcompanyOrg.setDisplayFormat("$name$");		
        this.prmtcompanyOrg.setEditFormat("$number$");		
        this.prmtcompanyOrg.setCommitFormat("$number$");		
        this.prmtcompanyOrg.setRequired(true);
        // prmtadminOrg		
        this.prmtadminOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtadminOrg.setEditable(true);		
        this.prmtadminOrg.setDisplayFormat("$number$");		
        this.prmtadminOrg.setEditFormat("$number$");		
        this.prmtadminOrg.setCommitFormat("$number$");		
        this.prmtadminOrg.setRequired(true);		
        this.prmtadminOrg.setVisible(false);
        prmtadminOrg.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtadminOrg_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtadminOrgName		
        this.txtadminOrgName.setHorizontalAlignment(2);		
        this.txtadminOrgName.setMaxLength(80);		
        this.txtadminOrgName.setRequired(true);		
        this.txtadminOrgName.setEnabled(false);		
        this.txtadminOrgName.setVisible(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompanyOrg,prmtadminOrg,txtadminOrgName}));
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
        this.setBounds(new Rectangle(-17, 0, 366, 306));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(19, 23, 318, 19));
        this.add(kDLabelContainer1, null);
        contcompanyOrg.setBounds(new Rectangle(19, 63, 318, 19));
        this.add(contcompanyOrg, null);
        contadminOrg.setBounds(new Rectangle(19, 270, 318, 19));
        this.add(contadminOrg, null);
        contadminOrgName.setBounds(new Rectangle(19, 288, 318, 19));
        this.add(contadminOrgName, null);
        kdtShrAdminOrg.setBounds(new Rectangle(19, 103, 318, 164));
        kdtShrAdminOrg_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtShrAdminOrg,new com.kingdee.eas.custom.salaryvoucher.OrganizationRelationShrAdminOrgInfo(),null,false);
        this.add(kdtShrAdminOrg_detailPanel, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //contcompanyOrg
        contcompanyOrg.setBoundEditor(prmtcompanyOrg);
        //contadminOrg
        contadminOrg.setBoundEditor(prmtadminOrg);
        //contadminOrgName
        contadminOrgName.setBoundEditor(txtadminOrgName);

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
		dataBinder.registerBinding("ShrAdminOrg.seq", int.class, this.kdtShrAdminOrg, "seq.text");
		dataBinder.registerBinding("ShrAdminOrg", com.kingdee.eas.custom.salaryvoucher.OrganizationRelationShrAdminOrgInfo.class, this.kdtShrAdminOrg, "userObject");
		dataBinder.registerBinding("ShrAdminOrg.shrAdminOrg", String.class, this.kdtShrAdminOrg, "shrAdminOrg.text");
		dataBinder.registerBinding("ShrAdminOrg.shrAdminOrgName", String.class, this.kdtShrAdminOrg, "shrAdminOrgName.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("companyOrg", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrg, "data");
		dataBinder.registerBinding("adminOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtadminOrg, "data");
		dataBinder.registerBinding("adminOrgName", String.class, this.txtadminOrgName, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salaryvoucher.app.OrganizationRelationEditUIHandler";
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
        this.prmtcompanyOrg.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo)ov;
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
		getValidateHelper().registerBindProperty("ShrAdminOrg.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ShrAdminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ShrAdminOrg.shrAdminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ShrAdminOrg.shrAdminOrgName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("adminOrgName", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtNumber.setEnabled(false);
        }
    }


    /**
     * output prmtadminOrg_Changed() method
     */
    public void prmtadminOrg_Changed() throws Exception
    {
        System.out.println("prmtadminOrg_Changed() Function is executed!");
            txtadminOrgName.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtadminOrg.getData(),"name")));


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
    	sic.add(new SelectorItemInfo("ShrAdminOrg.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ShrAdminOrg.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("ShrAdminOrg.shrAdminOrg"));
    	sic.add(new SelectorItemInfo("ShrAdminOrg.shrAdminOrgName"));
        sic.add(new SelectorItemInfo("number"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrg.id"));
        	sic.add(new SelectorItemInfo("companyOrg.number"));
        	sic.add(new SelectorItemInfo("companyOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("adminOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("adminOrg.id"));
        	sic.add(new SelectorItemInfo("adminOrg.number"));
        	sic.add(new SelectorItemInfo("adminOrg.name"));
		}
        sic.add(new SelectorItemInfo("adminOrgName"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salaryvoucher.client", "OrganizationRelationEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salaryvoucher.client.OrganizationRelationEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.OrganizationRelationFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.OrganizationRelationInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtShrAdminOrg.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtShrAdminOrg.getCell(i,"shrAdminOrg").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"shr组织编码"});
			}
		}
		for (int i=0,n=kdtShrAdminOrg.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtShrAdminOrg.getCell(i,"shrAdminOrgName").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"shr组织名称"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtadminOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"EAS组织编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtadminOrgName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"EAS组织名称"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtShrAdminOrg;
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