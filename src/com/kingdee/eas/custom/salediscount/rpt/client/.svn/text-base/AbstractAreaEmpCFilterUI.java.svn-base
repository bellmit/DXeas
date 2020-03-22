/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

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
public abstract class AbstractAreaEmpCFilterUI extends com.kingdee.eas.framework.report.client.CommRptBaseConditionUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractAreaEmpCFilterUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisEmp;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCustom;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisArea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbAreaLevel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbtnSaleOrder;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbtnSaleIssue;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbtnOtherBill;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup kDButtonGroup1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisyhl;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBeginEmp;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBeginCustomer;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtEndEmp;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtEndCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBeginArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtEndArea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbLevel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbLevelA;
    /**
     * output class constructor
     */
    public AbstractAreaEmpCFilterUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractAreaEmpCFilterUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisEmp = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisCustom = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisArea = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cmbAreaLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.rbtnSaleOrder = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rbtnSaleIssue = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rbtnOtherBill = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.kDButtonGroup1 = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.chkisyhl = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBeginEmp = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBeginCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtEndEmp = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtEndCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBeginArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtEndArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cmbLevel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cmbLevelA = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.chkisEmp.setName("chkisEmp");
        this.chkisCustom.setName("chkisCustom");
        this.chkisArea.setName("chkisArea");
        this.cmbAreaLevel.setName("cmbAreaLevel");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.rbtnSaleOrder.setName("rbtnSaleOrder");
        this.rbtnSaleIssue.setName("rbtnSaleIssue");
        this.rbtnOtherBill.setName("rbtnOtherBill");
        this.chkisyhl.setName("chkisyhl");
        this.prmtCompany.setName("prmtCompany");
        this.prmtBeginEmp.setName("prmtBeginEmp");
        this.prmtBeginCustomer.setName("prmtBeginCustomer");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.prmtEndEmp.setName("prmtEndEmp");
        this.prmtEndCustomer.setName("prmtEndCustomer");
        this.prmtBeginArea.setName("prmtBeginArea");
        this.prmtEndArea.setName("prmtEndArea");
        this.cmbLevel.setName("cmbLevel");
        this.cmbLevelA.setName("cmbLevelA");
        // CustomerQueryPanel
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // chkisEmp		
        this.chkisEmp.setText(resHelper.getString("chkisEmp.text"));
        // chkisCustom		
        this.chkisCustom.setText(resHelper.getString("chkisCustom.text"));
        // chkisArea		
        this.chkisArea.setText(resHelper.getString("chkisArea.text"));
        // cmbAreaLevel		
        this.cmbAreaLevel.setVisible(false);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelLength(100);		
        this.kDLabelContainer8.setVisible(false);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelLength(100);		
        this.kDLabelContainer9.setVisible(false);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelLength(100);		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelLength(100);		
        this.kDLabelContainer11.setVisible(false);
        // rbtnSaleOrder		
        this.rbtnSaleOrder.setText(resHelper.getString("rbtnSaleOrder.text"));
        // rbtnSaleIssue		
        this.rbtnSaleIssue.setText(resHelper.getString("rbtnSaleIssue.text"));
        // rbtnOtherBill		
        this.rbtnOtherBill.setText(resHelper.getString("rbtnOtherBill.text"));
        // kDButtonGroup1
        this.kDButtonGroup1.add(this.rbtnSaleOrder);
        this.kDButtonGroup1.add(this.rbtnSaleIssue);
        this.kDButtonGroup1.add(this.rbtnOtherBill);
        // chkisyhl		
        this.chkisyhl.setText(resHelper.getString("chkisyhl.text"));
        // prmtCompany
        // prmtBeginEmp
        // prmtBeginCustomer
        // dpBeginDate
        // dpEndDate
        // prmtEndEmp
        // prmtEndCustomer
        // prmtBeginArea
        // prmtEndArea
        // cmbLevel
        // cmbLevelA
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
        this.setBounds(new Rectangle(10, 10, 640, 430));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(-1000, -1000, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(30, 60, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(30, 90, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(30, 240, 270, 19));
        this.add(kDLabelContainer4, null);
        kDLabelContainer5.setBounds(new Rectangle(340, 240, 270, 19));
        this.add(kDLabelContainer5, null);
        chkisEmp.setBounds(new Rectangle(340, 150, 140, 19));
        this.add(chkisEmp, null);
        chkisCustom.setBounds(new Rectangle(30, 180, 140, 19));
        this.add(chkisCustom, null);
        chkisArea.setBounds(new Rectangle(30, 150, 120, 19));
        this.add(chkisArea, null);
        cmbAreaLevel.setBounds(new Rectangle(390, 5, 120, 19));
        this.add(cmbAreaLevel, null);
        kDLabelContainer6.setBounds(new Rectangle(340, 60, 270, 19));
        this.add(kDLabelContainer6, null);
        kDLabelContainer7.setBounds(new Rectangle(340, 90, 270, 19));
        this.add(kDLabelContainer7, null);
        kDLabelContainer8.setBounds(new Rectangle(30, 30, 270, 19));
        this.add(kDLabelContainer8, null);
        kDLabelContainer9.setBounds(new Rectangle(340, 30, 270, 19));
        this.add(kDLabelContainer9, null);
        kDLabelContainer10.setBounds(new Rectangle(340, 120, 270, 19));
        this.add(kDLabelContainer10, null);
        kDLabelContainer11.setBounds(new Rectangle(30, 120, 270, 19));
        this.add(kDLabelContainer11, null);
        rbtnSaleOrder.setBounds(new Rectangle(30, 210, 140, 19));
        this.add(rbtnSaleOrder, null);
        rbtnSaleIssue.setBounds(new Rectangle(230, 210, 140, 19));
        this.add(rbtnSaleIssue, null);
        rbtnOtherBill.setBounds(new Rectangle(430, 210, 140, 19));
        this.add(rbtnOtherBill, null);
        chkisyhl.setBounds(new Rectangle(30, 270, 140, 19));
        this.add(chkisyhl, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCompany);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtBeginEmp);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(prmtBeginCustomer);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(dpBeginDate);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(dpEndDate);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(prmtEndEmp);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(prmtEndCustomer);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(prmtBeginArea);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(prmtEndArea);
        //kDLabelContainer10
        kDLabelContainer10.setBoundEditor(cmbLevel);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(cmbLevelA);

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
	    return "com.kingdee.eas.custom.salediscount.rpt.app.AreaEmpCFilterUIHandler";
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
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.rpt.client", "AreaEmpCFilterUI");
    }




}