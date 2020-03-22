/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

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
public abstract class AbstractSignTableQueryPanel extends com.kingdee.eas.base.commonquery.client.CustomerQueryPanel
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSignTableQueryPanel.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPresentedPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSignTableType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCodeFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCodeTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDateTo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPresentedPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsighTableType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox kDComboBox1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCodeFrom;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCodeTo;
    /**
     * output class constructor
     */
    public AbstractSignTableQueryPanel() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSignTableQueryPanel.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contPresentedPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSignTableType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCodeFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCodeTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkBizDateFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkBizDateTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtPresentedPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsighTableType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDComboBox1 = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtCodeFrom = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCodeTo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCompany.setName("contCompany");
        this.contBizDateFrom.setName("contBizDateFrom");
        this.contBizDateTo.setName("contBizDateTo");
        this.contPresentedPerson.setName("contPresentedPerson");
        this.contSignTableType.setName("contSignTableType");
        this.contBillStatus.setName("contBillStatus");
        this.contCodeFrom.setName("contCodeFrom");
        this.contCodeTo.setName("contCodeTo");
        this.prmtCompany.setName("prmtCompany");
        this.pkBizDateFrom.setName("pkBizDateFrom");
        this.pkBizDateTo.setName("pkBizDateTo");
        this.prmtPresentedPerson.setName("prmtPresentedPerson");
        this.prmtsighTableType.setName("prmtsighTableType");
        this.kDComboBox1.setName("kDComboBox1");
        this.txtCodeFrom.setName("txtCodeFrom");
        this.txtCodeTo.setName("txtCodeTo");
        // CustomerQueryPanel
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelLength(80);		
        this.contCompany.setBoundLabelUnderline(true);
        // contBizDateFrom		
        this.contBizDateFrom.setBoundLabelText(resHelper.getString("contBizDateFrom.boundLabelText"));		
        this.contBizDateFrom.setBoundLabelLength(80);		
        this.contBizDateFrom.setBoundLabelUnderline(true);
        // contBizDateTo		
        this.contBizDateTo.setBoundLabelText(resHelper.getString("contBizDateTo.boundLabelText"));		
        this.contBizDateTo.setBoundLabelLength(80);		
        this.contBizDateTo.setBoundLabelUnderline(true);
        // contPresentedPerson		
        this.contPresentedPerson.setBoundLabelText(resHelper.getString("contPresentedPerson.boundLabelText"));		
        this.contPresentedPerson.setBoundLabelLength(80);		
        this.contPresentedPerson.setBoundLabelUnderline(true);
        // contSignTableType		
        this.contSignTableType.setBoundLabelText(resHelper.getString("contSignTableType.boundLabelText"));		
        this.contSignTableType.setBoundLabelLength(80);		
        this.contSignTableType.setBoundLabelUnderline(true);
        // contBillStatus		
        this.contBillStatus.setBoundLabelText(resHelper.getString("contBillStatus.boundLabelText"));		
        this.contBillStatus.setBoundLabelLength(80);		
        this.contBillStatus.setBoundLabelUnderline(true);
        // contCodeFrom		
        this.contCodeFrom.setBoundLabelText(resHelper.getString("contCodeFrom.boundLabelText"));		
        this.contCodeFrom.setBoundLabelLength(80);		
        this.contCodeFrom.setBoundLabelUnderline(true);
        // contCodeTo		
        this.contCodeTo.setBoundLabelText(resHelper.getString("contCodeTo.boundLabelText"));		
        this.contCodeTo.setBoundLabelLength(80);		
        this.contCodeTo.setBoundLabelUnderline(true);
        // prmtCompany		
        this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");
        // pkBizDateFrom
        // pkBizDateTo
        // prmtPresentedPerson		
        this.prmtPresentedPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        // prmtsighTableType		
        this.prmtsighTableType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.SignBDQuery");
        // kDComboBox1		
        this.kDComboBox1.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.signwasthetable.billStatus").toArray());		
        this.kDComboBox1.setActionCommand("cBoxBillStatus");
        // txtCodeFrom
        // txtCodeTo
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
        this.setBounds(new Rectangle(10, 10, 500, 400));
        this.setLayout(null);
        contCompany.setBounds(new Rectangle(13, 53, 229, 19));
        this.add(contCompany, null);
        contBizDateFrom.setBounds(new Rectangle(13, 101, 229, 19));
        this.add(contBizDateFrom, null);
        contBizDateTo.setBounds(new Rectangle(254, 101, 229, 19));
        this.add(contBizDateTo, null);
        contPresentedPerson.setBounds(new Rectangle(13, 149, 229, 19));
        this.add(contPresentedPerson, null);
        contSignTableType.setBounds(new Rectangle(254, 149, 229, 19));
        this.add(contSignTableType, null);
        contBillStatus.setBounds(new Rectangle(13, 247, 229, 19));
        this.add(contBillStatus, null);
        contCodeFrom.setBounds(new Rectangle(13, 197, 229, 19));
        this.add(contCodeFrom, null);
        contCodeTo.setBounds(new Rectangle(254, 197, 229, 19));
        this.add(contCodeTo, null);
        //contCompany
        contCompany.setBoundEditor(prmtCompany);
        //contBizDateFrom
        contBizDateFrom.setBoundEditor(pkBizDateFrom);
        //contBizDateTo
        contBizDateTo.setBoundEditor(pkBizDateTo);
        //contPresentedPerson
        contPresentedPerson.setBoundEditor(prmtPresentedPerson);
        //contSignTableType
        contSignTableType.setBoundEditor(prmtsighTableType);
        //contBillStatus
        contBillStatus.setBoundEditor(kDComboBox1);
        //contCodeFrom
        contCodeFrom.setBoundEditor(txtCodeFrom);
        //contCodeTo
        contCodeTo.setBoundEditor(txtCodeTo);

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
	    return "com.kingdee.eas.custom.signwasthetable.app.SignTableQueryPanelHandler";
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
        return new MetaDataPK("com.kingdee.eas.custom.signwasthetable.client", "SignTableQueryPanel");
    }




}