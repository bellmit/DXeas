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
public abstract class AbstractSaleForecastFilterAUI extends com.kingdee.eas.base.commonquery.client.CustomerQueryPanel
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSaleForecastFilterAUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labBizDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer labStOrgUnitFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer wuliao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker bizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker bizDateTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptStOrgUnitFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptCustomerFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptCustomerTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptMaterialNumFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox bizPromptMaterialNumTo;
    /**
     * output class constructor
     */
    public AbstractSaleForecastFilterAUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSaleForecastFilterAUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.labBizDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labBizDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labStOrgUnitFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.wuliao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.bizDateFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizDateTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.bizPromptStOrgUnitFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptCustomerFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptCustomerTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptMaterialNumFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.bizPromptMaterialNumTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.labBizDateFrom.setName("labBizDateFrom");
        this.labBizDateTo.setName("labBizDateTo");
        this.labStOrgUnitFrom.setName("labStOrgUnitFrom");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.wuliao.setName("wuliao");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.bizDateFrom.setName("bizDateFrom");
        this.bizDateTo.setName("bizDateTo");
        this.bizPromptStOrgUnitFrom.setName("bizPromptStOrgUnitFrom");
        this.bizPromptCustomerFrom.setName("bizPromptCustomerFrom");
        this.bizPromptCustomerTo.setName("bizPromptCustomerTo");
        this.bizPromptMaterialNumFrom.setName("bizPromptMaterialNumFrom");
        this.bizPromptMaterialNumTo.setName("bizPromptMaterialNumTo");
        // CustomerQueryPanel
        // labBizDateFrom		
        this.labBizDateFrom.setBoundLabelText(resHelper.getString("labBizDateFrom.boundLabelText"));		
        this.labBizDateFrom.setBoundLabelLength(100);		
        this.labBizDateFrom.setBoundLabelUnderline(true);
        // labBizDateTo		
        this.labBizDateTo.setBoundLabelText(resHelper.getString("labBizDateTo.boundLabelText"));		
        this.labBizDateTo.setBoundLabelLength(100);		
        this.labBizDateTo.setBoundLabelUnderline(true);
        // labStOrgUnitFrom		
        this.labStOrgUnitFrom.setBoundLabelText(resHelper.getString("labStOrgUnitFrom.boundLabelText"));		
        this.labStOrgUnitFrom.setBoundLabelLength(100);		
        this.labStOrgUnitFrom.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // wuliao		
        this.wuliao.setBoundLabelText(resHelper.getString("wuliao.boundLabelText"));		
        this.wuliao.setBoundLabelLength(100);		
        this.wuliao.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // bizDateFrom
        // bizDateTo
        // bizPromptStOrgUnitFrom
        // bizPromptCustomerFrom
        // bizPromptCustomerTo
        // bizPromptMaterialNumFrom
        // bizPromptMaterialNumTo
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
        labBizDateFrom.setBounds(new Rectangle(9, 30, 185, 19));
        this.add(labBizDateFrom, new KDLayout.Constraints(9, 30, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labBizDateTo.setBounds(new Rectangle(205, 30, 185, 19));
        this.add(labBizDateTo, new KDLayout.Constraints(205, 30, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        labStOrgUnitFrom.setBounds(new Rectangle(10, 120, 380, 19));
        this.add(labStOrgUnitFrom, new KDLayout.Constraints(10, 120, 380, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer4.setBounds(new Rectangle(10, 60, 185, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(10, 60, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(205, 60, 185, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(205, 60, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        wuliao.setBounds(new Rectangle(10, 90, 185, 19));
        this.add(wuliao, new KDLayout.Constraints(10, 90, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(205, 90, 185, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(205, 90, 185, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //labBizDateFrom
        labBizDateFrom.setBoundEditor(bizDateFrom);
        //labBizDateTo
        labBizDateTo.setBoundEditor(bizDateTo);
        //labStOrgUnitFrom
        labStOrgUnitFrom.setBoundEditor(bizPromptStOrgUnitFrom);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(bizPromptCustomerFrom);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(bizPromptCustomerTo);
        //wuliao
        wuliao.setBoundEditor(bizPromptMaterialNumFrom);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(bizPromptMaterialNumTo);

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
	    return "com.kingdee.eas.custom.lhsm.app.SaleForecastFilterAUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "SaleForecastFilterAUI");
    }




}