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
public abstract class AbstractSaleForecastFilterUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleForecastFilterUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labNumberFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labNumberTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBizDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labMaterialNumFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labMaterialNumTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBillState;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labStOrgUnitFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labCustomerFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labCustomerTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptNumberFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptNumberTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker bizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker bizDateTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptMaterialNumFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptMaterialNumTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comBoxBillState;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptStOrgUnitFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptCustomerFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptCustomerTo;
    /**
     * output class constructor
     */
    public AbstractSaleForecastFilterUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSaleForecastFilterUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.labNumberFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labNumberTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labBizDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labBizDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labMaterialNumFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labMaterialNumTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labBillState = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator1 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.labStOrgUnitFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labCustomerFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labCustomerTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.bizPromptNumberFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptNumberTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizDateFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizDateTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizPromptMaterialNumFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptMaterialNumTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.comBoxBillState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.bizPromptStOrgUnitFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptCustomerFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptCustomerTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.labNumberFrom.setName("labNumberFrom");
        this.labNumberTo.setName("labNumberTo");
        this.labBizDateFrom.setName("labBizDateFrom");
        this.labBizDateTo.setName("labBizDateTo");
        this.labMaterialNumFrom.setName("labMaterialNumFrom");
        this.labMaterialNumTo.setName("labMaterialNumTo");
        this.labBillState.setName("labBillState");
        this.kDSeparator1.setName("kDSeparator1");
        this.labStOrgUnitFrom.setName("labStOrgUnitFrom");
        this.labCustomerFrom.setName("labCustomerFrom");
        this.labCustomerTo.setName("labCustomerTo");
        this.bizPromptNumberFrom.setName("bizPromptNumberFrom");
        this.bizPromptNumberTo.setName("bizPromptNumberTo");
        this.bizDateFrom.setName("bizDateFrom");
        this.bizDateTo.setName("bizDateTo");
        this.bizPromptMaterialNumFrom.setName("bizPromptMaterialNumFrom");
        this.bizPromptMaterialNumTo.setName("bizPromptMaterialNumTo");
        this.comBoxBillState.setName("comBoxBillState");
        this.bizPromptStOrgUnitFrom.setName("bizPromptStOrgUnitFrom");
        this.bizPromptCustomerFrom.setName("bizPromptCustomerFrom");
        this.bizPromptCustomerTo.setName("bizPromptCustomerTo");
        // CustomerQueryPanel
        // labNumberFrom		
        this.labNumberFrom.setBoundLabelText(resHelper.getString("labNumberFrom.boundLabelText"));		
        this.labNumberFrom.setBoundLabelLength(80);		
        this.labNumberFrom.setBoundLabelUnderline(true);
        // labNumberTo		
        this.labNumberTo.setBoundLabelText(resHelper.getString("labNumberTo.boundLabelText"));		
        this.labNumberTo.setBoundLabelLength(80);		
        this.labNumberTo.setBoundLabelUnderline(true);
        // labBizDateFrom		
        this.labBizDateFrom.setBoundLabelText(resHelper.getString("labBizDateFrom.boundLabelText"));		
        this.labBizDateFrom.setBoundLabelLength(80);		
        this.labBizDateFrom.setBoundLabelUnderline(true);
        // labBizDateTo		
        this.labBizDateTo.setBoundLabelText(resHelper.getString("labBizDateTo.boundLabelText"));		
        this.labBizDateTo.setBoundLabelLength(80);		
        this.labBizDateTo.setBoundLabelUnderline(true);
        // labMaterialNumFrom		
        this.labMaterialNumFrom.setBoundLabelText(resHelper.getString("labMaterialNumFrom.boundLabelText"));		
        this.labMaterialNumFrom.setBoundLabelLength(80);		
        this.labMaterialNumFrom.setBoundLabelUnderline(true);
        // labMaterialNumTo		
        this.labMaterialNumTo.setBoundLabelText(resHelper.getString("labMaterialNumTo.boundLabelText"));		
        this.labMaterialNumTo.setBoundLabelUnderline(true);		
        this.labMaterialNumTo.setBoundLabelLength(80);
        // labBillState		
        this.labBillState.setBoundLabelText(resHelper.getString("labBillState.boundLabelText"));		
        this.labBillState.setBoundLabelLength(80);		
        this.labBillState.setBoundLabelUnderline(true);
        // kDSeparator1
        // labStOrgUnitFrom		
        this.labStOrgUnitFrom.setBoundLabelText(resHelper.getString("labStOrgUnitFrom.boundLabelText"));		
        this.labStOrgUnitFrom.setBoundLabelUnderline(true);		
        this.labStOrgUnitFrom.setBoundLabelLength(80);
        // labCustomerFrom		
        this.labCustomerFrom.setBoundLabelText(resHelper.getString("labCustomerFrom.boundLabelText"));		
        this.labCustomerFrom.setBoundLabelLength(80);		
        this.labCustomerFrom.setBoundLabelUnderline(true);
        // labCustomerTo		
        this.labCustomerTo.setBoundLabelText(resHelper.getString("labCustomerTo.boundLabelText"));		
        this.labCustomerTo.setBoundLabelUnderline(true);		
        this.labCustomerTo.setBoundLabelLength(80);
        // bizPromptNumberFrom		
        this.bizPromptNumberFrom.setDisplayFormat("$number$");		
        this.bizPromptNumberFrom.setEditFormat("$number$");		
        this.bizPromptNumberFrom.setQueryInfo("com.kingdee.eas.scm.im.inv.SaleIssueFilterQuery");		
        this.bizPromptNumberFrom.setEditable(true);
        // bizPromptNumberTo		
        this.bizPromptNumberTo.setDisplayFormat("$number$");		
        this.bizPromptNumberTo.setEditFormat("$number$");		
        this.bizPromptNumberTo.setQueryInfo("com.kingdee.eas.scm.im.inv.SaleIssueFilterQuery");		
        this.bizPromptNumberTo.setEditable(true);
        // bizDateFrom
        // bizDateTo
        // bizPromptMaterialNumFrom		
        this.bizPromptMaterialNumFrom.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialQuery");		
        this.bizPromptMaterialNumFrom.setEditFormat("$number$");		
        this.bizPromptMaterialNumFrom.setDisplayFormat("$number$");		
        this.bizPromptMaterialNumFrom.setEditable(true);
        // bizPromptMaterialNumTo		
        this.bizPromptMaterialNumTo.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialQuery");		
        this.bizPromptMaterialNumTo.setEditFormat("$number$");		
        this.bizPromptMaterialNumTo.setDisplayFormat("$number$");		
        this.bizPromptMaterialNumTo.setEditable(true);
        // comBoxBillState
        // bizPromptStOrgUnitFrom
        // bizPromptCustomerFrom		
        this.bizPromptCustomerFrom.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");		
        this.bizPromptCustomerFrom.setEditFormat("$number$");		
        this.bizPromptCustomerFrom.setDisplayFormat("$number$");		
        this.bizPromptCustomerFrom.setEditable(true);
        // bizPromptCustomerTo		
        this.bizPromptCustomerTo.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerQuery");		
        this.bizPromptCustomerTo.setEditFormat("$number$");		
        this.bizPromptCustomerTo.setDisplayFormat("$number$");		
        this.bizPromptCustomerTo.setEditable(true);
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
        this.setBounds(new Rectangle(10, 10, 400, 345));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 400, 345));
        labNumberFrom.setBounds(new Rectangle(9, 30, 185, 19));
        this.add(labNumberFrom, new KDLayout.Constraints(9, 30, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labNumberTo.setBounds(new Rectangle(205, 30, 185, 19));
        this.add(labNumberTo, new KDLayout.Constraints(205, 30, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labBizDateFrom.setBounds(new Rectangle(10, 60, 185, 19));
        this.add(labBizDateFrom, new KDLayout.Constraints(10, 60, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labBizDateTo.setBounds(new Rectangle(205, 60, 185, 19));
        this.add(labBizDateTo, new KDLayout.Constraints(205, 60, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labMaterialNumFrom.setBounds(new Rectangle(10, 150, 185, 19));
        this.add(labMaterialNumFrom, new KDLayout.Constraints(10, 150, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labMaterialNumTo.setBounds(new Rectangle(205, 150, 185, 19));
        this.add(labMaterialNumTo, new KDLayout.Constraints(205, 150, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labBillState.setBounds(new Rectangle(10, 180, 185, 19));
        this.add(labBillState, new KDLayout.Constraints(10, 180, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator1.setBounds(new Rectangle(0, 210, 400, 10));
        this.add(kDSeparator1, new KDLayout.Constraints(0, 210, 400, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        labStOrgUnitFrom.setBounds(new Rectangle(10, 90, 380, 19));
        this.add(labStOrgUnitFrom, new KDLayout.Constraints(10, 90, 380, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        labCustomerFrom.setBounds(new Rectangle(10, 120, 185, 19));
        this.add(labCustomerFrom, new KDLayout.Constraints(10, 120, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labCustomerTo.setBounds(new Rectangle(205, 120, 185, 19));
        this.add(labCustomerTo, new KDLayout.Constraints(205, 120, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //labNumberFrom
        labNumberFrom.setBoundEditor(bizPromptNumberFrom);
        //labNumberTo
        labNumberTo.setBoundEditor(bizPromptNumberTo);
        //labBizDateFrom
        labBizDateFrom.setBoundEditor(bizDateFrom);
        //labBizDateTo
        labBizDateTo.setBoundEditor(bizDateTo);
        //labMaterialNumFrom
        labMaterialNumFrom.setBoundEditor(bizPromptMaterialNumFrom);
        //labMaterialNumTo
        labMaterialNumTo.setBoundEditor(bizPromptMaterialNumTo);
        //labBillState
        labBillState.setBoundEditor(comBoxBillState);
        //labStOrgUnitFrom
        labStOrgUnitFrom.setBoundEditor(bizPromptStOrgUnitFrom);
        //labCustomerFrom
        labCustomerFrom.setBoundEditor(bizPromptCustomerFrom);
        //labCustomerTo
        labCustomerTo.setBoundEditor(bizPromptCustomerTo);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.lhsm.app.SaleForecastFilterUIHandler";
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
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "SaleForecastFilterUI");
    }




}