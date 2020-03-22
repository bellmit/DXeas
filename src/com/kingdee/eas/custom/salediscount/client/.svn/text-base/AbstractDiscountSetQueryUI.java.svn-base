/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

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
public abstract class AbstractDiscountSetQueryUI extends com.kingdee.eas.scm.common.client.SCMBillFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDiscountSetQueryUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer tfNumberaaaaa;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer tfNameaaaa;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleOrgFrom;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleOrgTo;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEffectBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEffectEndDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbDiscountType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbPolicyType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomer;
    protected com.kingdee.bos.ctrl.swing.KDTextField tfNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField tfName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbAuditState;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbDelState;
    /**
     * output class constructor
     */
    public AbstractDiscountSetQueryUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDiscountSetQueryUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.tfNumberaaaaa = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.tfNameaaaa = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtSaleOrgFrom = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSaleOrgTo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dpEffectBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEffectEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cbDiscountType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cbPolicyType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tfNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.tfName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cbAuditState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cbDelState = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.tfNumberaaaaa.setName("tfNumberaaaaa");
        this.tfNameaaaa.setName("tfNameaaaa");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.prmtSaleOrgFrom.setName("prmtSaleOrgFrom");
        this.prmtSaleOrgTo.setName("prmtSaleOrgTo");
        this.dpEffectBeginDate.setName("dpEffectBeginDate");
        this.dpEffectEndDate.setName("dpEffectEndDate");
        this.cbDiscountType.setName("cbDiscountType");
        this.cbPolicyType.setName("cbPolicyType");
        this.prmtCustomer.setName("prmtCustomer");
        this.tfNumber.setName("tfNumber");
        this.tfName.setName("tfName");
        this.cbAuditState.setName("cbAuditState");
        this.cbDelState.setName("cbDelState");
        // CustomerQueryPanel
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(80);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(59);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setVisible(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(80);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(59);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(80);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(59);		
        this.kDLabelContainer6.setBoundLabelUnderline(true);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(80);		
        this.kDLabelContainer7.setVisible(false);
        // tfNumberaaaaa		
        this.tfNumberaaaaa.setBoundLabelText(resHelper.getString("tfNumberaaaaa.boundLabelText"));		
        this.tfNumberaaaaa.setBoundLabelUnderline(true);		
        this.tfNumberaaaaa.setBoundLabelLength(80);
        // tfNameaaaa		
        this.tfNameaaaa.setBoundLabelText(resHelper.getString("tfNameaaaa.boundLabelText"));		
        this.tfNameaaaa.setBoundLabelUnderline(true);		
        this.tfNameaaaa.setBoundLabelLength(59);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(80);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(59);
        // prmtSaleOrgFrom		
        this.prmtSaleOrgFrom.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleOrgUnitQuery");		
        this.prmtSaleOrgFrom.setDisplayFormat("$number$");		
        this.prmtSaleOrgFrom.setEditFormat("$number$");		
        this.prmtSaleOrgFrom.setEditable(true);
        // prmtSaleOrgTo		
        this.prmtSaleOrgTo.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleOrgUnitQuery");		
        this.prmtSaleOrgTo.setDisplayFormat("$number$");		
        this.prmtSaleOrgTo.setEditFormat("$number$");		
        this.prmtSaleOrgTo.setEditable(true);
        // dpEffectBeginDate
        // dpEffectEndDate
        // cbDiscountType
        // cbPolicyType
        // prmtCustomer		
        this.prmtCustomer.setVisible(false);
        // tfNumber
        // tfName
        // cbAuditState
        // cbDelState
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
        this.setBounds(new Rectangle(10, 10, 436, 310));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(10, 69, 210, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(240, 69, 189, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(10, 108, 210, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(240, 108, 189, 19));
        this.add(kDLabelContainer4, null);
        kDLabelContainer5.setBounds(new Rectangle(10, 147, 210, 19));
        this.add(kDLabelContainer5, null);
        kDLabelContainer6.setBounds(new Rectangle(240, 146, 189, 19));
        this.add(kDLabelContainer6, null);
        kDLabelContainer7.setBounds(new Rectangle(10, 184, 210, 19));
        this.add(kDLabelContainer7, null);
        tfNumberaaaaa.setBounds(new Rectangle(10, 33, 210, 19));
        this.add(tfNumberaaaaa, null);
        tfNameaaaa.setBounds(new Rectangle(240, 33, 189, 19));
        this.add(tfNameaaaa, null);
        kDLabelContainer8.setBounds(new Rectangle(10, 262, 210, 19));
        this.add(kDLabelContainer8, null);
        kDLabelContainer9.setBounds(new Rectangle(240, 262, 189, 19));
        this.add(kDLabelContainer9, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtSaleOrgFrom);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtSaleOrgTo);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(dpEffectBeginDate);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(dpEffectEndDate);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(cbDiscountType);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(cbPolicyType);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(prmtCustomer);
        //tfNumberaaaaa
        tfNumberaaaaa.setBoundEditor(tfNumber);
        //tfNameaaaa
        tfNameaaaa.setBoundEditor(tfName);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(cbAuditState);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(cbDelState);

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
	    return "com.kingdee.eas.custom.salediscount.app.DiscountSetQueryUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DiscountSetQueryUI");
    }




}