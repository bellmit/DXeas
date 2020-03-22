/**
 * output package name
 */
package com.kingdee.eas.custom.test.client;

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
public abstract class AbstractCrbTestUI extends com.kingdee.eas.framework.report.client.CommRptBaseConditionUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCrbTestUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCheckedStatus;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkFiVouchered;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPeriod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDepType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox kDCheckBox1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboCheckedStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPeriod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox comboDepType;
    protected com.kingdee.eas.fi.fa.manage.FaDepreciationInfo entityFaDepreciation = null;
    /**
     * output class constructor
     */
    public AbstractCrbTestUI() throws Exception
    {
        super();
        this.defaultObjectName = "entityFaDepreciation";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractCrbTestUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCheckedStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkFiVouchered = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDepType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDCheckBox1 = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.comboCheckedStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.comboDepType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contCompany.setName("contCompany");
        this.contCheckedStatus.setName("contCheckedStatus");
        this.chkFiVouchered.setName("chkFiVouchered");
        this.contPeriod.setName("contPeriod");
        this.contDepType.setName("contDepType");
        this.kDCheckBox1.setName("kDCheckBox1");
        this.prmtCompany.setName("prmtCompany");
        this.comboCheckedStatus.setName("comboCheckedStatus");
        this.prmtPeriod.setName("prmtPeriod");
        this.comboDepType.setName("comboDepType");
        // CustomerQueryPanel
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelLength(100);		
        this.contCompany.setBoundLabelUnderline(true);
        // contCheckedStatus		
        this.contCheckedStatus.setBoundLabelText(resHelper.getString("contCheckedStatus.boundLabelText"));		
        this.contCheckedStatus.setBoundLabelLength(100);		
        this.contCheckedStatus.setBoundLabelUnderline(true);
        // chkFiVouchered		
        this.chkFiVouchered.setText(resHelper.getString("chkFiVouchered.text"));
        // contPeriod		
        this.contPeriod.setBoundLabelText(resHelper.getString("contPeriod.boundLabelText"));		
        this.contPeriod.setBoundLabelLength(100);		
        this.contPeriod.setBoundLabelUnderline(true);
        // contDepType		
        this.contDepType.setBoundLabelText(resHelper.getString("contDepType.boundLabelText"));		
        this.contDepType.setBoundLabelLength(100);		
        this.contDepType.setBoundLabelUnderline(true);
        // kDCheckBox1		
        this.kDCheckBox1.setText(resHelper.getString("kDCheckBox1.text"));
        // prmtCompany
        // comboCheckedStatus		
        this.comboCheckedStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.framework.CheckedStatusEnum").toArray());
        // prmtPeriod
        // comboDepType		
        this.comboDepType.addItems(EnumUtils.getEnumList("com.kingdee.eas.fi.fa.manage.FaDepType").toArray());
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
        this.setBounds(new Rectangle(10, 10, 600, 150));
        this.setLayout(null);
        contCompany.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contCompany, null);
        contCheckedStatus.setBounds(new Rectangle(300, 10, 270, 19));
        this.add(contCheckedStatus, null);
        chkFiVouchered.setBounds(new Rectangle(10, 40, 140, 19));
        this.add(chkFiVouchered, null);
        contPeriod.setBounds(new Rectangle(300, 40, 270, 19));
        this.add(contPeriod, null);
        contDepType.setBounds(new Rectangle(10, 70, 270, 19));
        this.add(contDepType, null);
        kDCheckBox1.setBounds(new Rectangle(110, 40, 140, 19));
        this.add(kDCheckBox1, null);
        //contCompany
        contCompany.setBoundEditor(prmtCompany);
        //contCheckedStatus
        contCheckedStatus.setBoundEditor(comboCheckedStatus);
        //contPeriod
        contPeriod.setBoundEditor(prmtPeriod);
        //contDepType
        contDepType.setBoundEditor(comboDepType);

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
		dataBinder.registerBinding("fiVouchered", boolean.class, this.chkFiVouchered, "selected");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtCompany, "data");
		dataBinder.registerBinding("checkedStatus", com.kingdee.eas.framework.CheckedStatusEnum.class, this.comboCheckedStatus, "selectedItem");
		dataBinder.registerBinding("period", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtPeriod, "data");
		dataBinder.registerBinding("depType", com.kingdee.eas.fi.fa.manage.FaDepType.class, this.comboDepType, "selectedItem");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.test.app.CrbTestUIHandler";
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
        this.entityFaDepreciation = (com.kingdee.eas.fi.fa.manage.FaDepreciationInfo)ov;
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
		getValidateHelper().registerBindProperty("fiVouchered", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("checkedStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("period", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("depType", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
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
        sic.add(new SelectorItemInfo("fiVouchered"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("checkedStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("period.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("period.id"));
        	sic.add(new SelectorItemInfo("period.number"));
		}
        sic.add(new SelectorItemInfo("depType"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.test.client", "CrbTestUI");
    }




}