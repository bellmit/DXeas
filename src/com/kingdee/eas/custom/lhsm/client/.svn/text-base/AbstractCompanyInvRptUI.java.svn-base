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
public abstract class AbstractCompanyInvRptUI extends com.kingdee.eas.framework.client.wizard.WizardPageUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCompanyInvRptUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
    protected com.kingdee.bos.ctrl.swing.KDButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCal;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbByMaterial;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbCumulativeCompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterial;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnInsert;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRemove;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSave;
    protected ActionInsertLine actionInsertLine = null;
    protected ActionDelLine actionDelLine = null;
    /**
     * output class constructor
     */
    public AbstractCompanyInvRptUI() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractCompanyInvRptUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionInsertLine
        this.actionInsertLine = new ActionInsertLine(this);
        getActionManager().registerAction("actionInsertLine", actionInsertLine);
         this.actionInsertLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionDelLine
        this.actionDelLine = new ActionDelLine(this);
        getActionManager().registerAction("actionDelLine", actionDelLine);
         this.actionDelLine.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCal = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cbByMaterial = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbCumulativeCompany = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnInsert = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnRemove = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnSave = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kdtEntry.setName("kdtEntry");
        this.btnQuery.setName("btnQuery");
        this.btnCal.setName("btnCal");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.cbByMaterial.setName("cbByMaterial");
        this.cbCumulativeCompany.setName("cbCumulativeCompany");
        this.prmtMaterial.setName("prmtMaterial");
        this.prmtCompany.setName("prmtCompany");
        this.btnInsert.setName("btnInsert");
        this.btnRemove.setName("btnRemove");
        this.btnSave.setName("btnSave");
        // CoreUI
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"company\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol2\" /><t:Column t:key=\"material\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol3\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol4\" /><t:Column t:key=\"qty1\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{qty1}</t:Cell><t:Cell>$Resource{qty2}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot> ";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));

        

        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        // btnCal		
        this.btnCal.setText(resHelper.getString("btnCal.text"));
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // cbByMaterial		
        this.cbByMaterial.setText(resHelper.getString("cbByMaterial.text"));
        // cbCumulativeCompany		
        this.cbCumulativeCompany.setText(resHelper.getString("cbCumulativeCompany.text"));
        // prmtMaterial
        // prmtCompany
        // btnInsert		
        this.btnInsert.setText(resHelper.getString("btnInsert.text"));
        // btnRemove		
        this.btnRemove.setText(resHelper.getString("btnRemove.text"));
        // btnSave		
        this.btnSave.setText(resHelper.getString("btnSave.text"));
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
        this.setBounds(new Rectangle(10, 10, 700, 500));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 700, 500));
        imgPanel.setBounds(new Rectangle(-1000, -1000, 10, 10));
        this.add(imgPanel, new KDLayout.Constraints(-1000, -1000, 10, 10, 0));
        pageContentPanel.setBounds(new Rectangle(-1000, -1000, 10, 10));
        this.add(pageContentPanel, new KDLayout.Constraints(-1000, -1000, 10, 10, 0));
        kDLabelContainer4.setBounds(new Rectangle(10, 40, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(10, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtEntry.setBounds(new Rectangle(10, 70, 680, 400));
        this.add(kdtEntry, new KDLayout.Constraints(10, 70, 680, 400, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btnQuery.setBounds(new Rectangle(450, 10, 73, 21));
        this.add(btnQuery, new KDLayout.Constraints(450, 10, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnCal.setBounds(new Rectangle(450, 43, 73, 21));
        this.add(btnCal, new KDLayout.Constraints(450, 43, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbByMaterial.setBounds(new Rectangle(288, 40, 102, 19));
        this.add(cbByMaterial, new KDLayout.Constraints(288, 40, 102, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbCumulativeCompany.setBounds(new Rectangle(288, 11, 141, 19));
        this.add(cbCumulativeCompany, new KDLayout.Constraints(288, 11, 141, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //imgPanel
        imgPanel.setLayout(new KDLayout());
        imgPanel.putClientProperty("OriginalBounds", new Rectangle(-1000, -1000, 10, 10));        labWizardImg.setBounds(new Rectangle(0, 0, 135, 77));
        imgPanel.add(labWizardImg, new KDLayout.Constraints(0, 0, 135, 77, 0));
        pageContentPanel.setLayout(null);        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(prmtMaterial);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCompany);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuTool);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemPageSetup);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemCloudShare);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemExitCurrent);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
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
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnInsert);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnRemove);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.lhsm.app.CompanyInvRptUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
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
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
    }

    	

    /**
     * output actionInsertLine_actionPerformed method
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output actionDelLine_actionPerformed method
     */
    public void actionDelLine_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareActionInsertLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionInsertLine() {
    	return false;
    }
	public RequestContext prepareActionDelLine(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDelLine() {
    	return false;
    }

    /**
     * output ActionInsertLine class
     */     
    protected class ActionInsertLine extends ItemAction {     
    
        public ActionInsertLine()
        {
            this(null);
        }

        public ActionInsertLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionInsertLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionInsertLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCompanyInvRptUI.this, "ActionInsertLine", "actionInsertLine_actionPerformed", e);
        }
    }

    /**
     * output ActionDelLine class
     */     
    protected class ActionDelLine extends ItemAction {     
    
        public ActionDelLine()
        {
            this(null);
        }

        public ActionDelLine(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("ActionDelLine.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDelLine.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDelLine.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCompanyInvRptUI.this, "ActionDelLine", "actionDelLine_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "CompanyInvRptUI");
    }




}