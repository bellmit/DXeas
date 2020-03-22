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
public abstract class AbstractCoProductPriceEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCoProductPriceEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbrokenSinglePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgreensPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdirtyPirce;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmutantPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdoublePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contflowPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbrokenDoublePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkeffectDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkunEffectDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbrokenSinglePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgreensPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdirtyPirce;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmutantPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdoublePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtflowPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbrokenDoublePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtunit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton mBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem tBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.CoProductPriceInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCoProductPriceEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCoProductPriceEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "false");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "false");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunEffectDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbrokenSinglePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgreensPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdirtyPirce = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmutantPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdoublePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contflowPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbrokenDoublePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkeffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkunEffectDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtbrokenSinglePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtgreensPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdirtyPirce = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmutantPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdoublePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtflowPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbrokenDoublePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtunit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contremark.setName("contremark");
        this.contbaseStatus.setName("contbaseStatus");
        this.conteffectDate.setName("conteffectDate");
        this.contcompany.setName("contcompany");
        this.contunEffectDate.setName("contunEffectDate");
        this.contbrokenSinglePrice.setName("contbrokenSinglePrice");
        this.contgreensPrice.setName("contgreensPrice");
        this.contdirtyPirce.setName("contdirtyPirce");
        this.contmutantPrice.setName("contmutantPrice");
        this.contdoublePrice.setName("contdoublePrice");
        this.contflowPrice.setName("contflowPrice");
        this.contbrokenDoublePrice.setName("contbrokenDoublePrice");
        this.contunit.setName("contunit");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.baseStatus.setName("baseStatus");
        this.pkeffectDate.setName("pkeffectDate");
        this.prmtcompany.setName("prmtcompany");
        this.pkunEffectDate.setName("pkunEffectDate");
        this.txtbrokenSinglePrice.setName("txtbrokenSinglePrice");
        this.txtgreensPrice.setName("txtgreensPrice");
        this.txtdirtyPirce.setName("txtdirtyPirce");
        this.txtmutantPrice.setName("txtmutantPrice");
        this.txtdoublePrice.setName("txtdoublePrice");
        this.txtflowPrice.setName("txtflowPrice");
        this.txtbrokenDoublePrice.setName("txtbrokenDoublePrice");
        this.prmtunit.setName("prmtunit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setVisible(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(100);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conteffectDate		
        this.conteffectDate.setBoundLabelText(resHelper.getString("conteffectDate.boundLabelText"));		
        this.conteffectDate.setBoundLabelLength(100);		
        this.conteffectDate.setBoundLabelUnderline(true);		
        this.conteffectDate.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contunEffectDate		
        this.contunEffectDate.setBoundLabelText(resHelper.getString("contunEffectDate.boundLabelText"));		
        this.contunEffectDate.setBoundLabelLength(100);		
        this.contunEffectDate.setBoundLabelUnderline(true);		
        this.contunEffectDate.setVisible(true);
        // contbrokenSinglePrice		
        this.contbrokenSinglePrice.setBoundLabelText(resHelper.getString("contbrokenSinglePrice.boundLabelText"));		
        this.contbrokenSinglePrice.setBoundLabelLength(100);		
        this.contbrokenSinglePrice.setBoundLabelUnderline(true);		
        this.contbrokenSinglePrice.setVisible(true);
        // contgreensPrice		
        this.contgreensPrice.setBoundLabelText(resHelper.getString("contgreensPrice.boundLabelText"));		
        this.contgreensPrice.setBoundLabelLength(100);		
        this.contgreensPrice.setBoundLabelUnderline(true);		
        this.contgreensPrice.setVisible(true);
        // contdirtyPirce		
        this.contdirtyPirce.setBoundLabelText(resHelper.getString("contdirtyPirce.boundLabelText"));		
        this.contdirtyPirce.setBoundLabelLength(100);		
        this.contdirtyPirce.setBoundLabelUnderline(true);		
        this.contdirtyPirce.setVisible(true);
        // contmutantPrice		
        this.contmutantPrice.setBoundLabelText(resHelper.getString("contmutantPrice.boundLabelText"));		
        this.contmutantPrice.setBoundLabelLength(100);		
        this.contmutantPrice.setBoundLabelUnderline(true);		
        this.contmutantPrice.setVisible(true);
        // contdoublePrice		
        this.contdoublePrice.setBoundLabelText(resHelper.getString("contdoublePrice.boundLabelText"));		
        this.contdoublePrice.setBoundLabelLength(100);		
        this.contdoublePrice.setBoundLabelUnderline(true);		
        this.contdoublePrice.setVisible(true);
        // contflowPrice		
        this.contflowPrice.setBoundLabelText(resHelper.getString("contflowPrice.boundLabelText"));		
        this.contflowPrice.setBoundLabelLength(100);		
        this.contflowPrice.setBoundLabelUnderline(true);		
        this.contflowPrice.setVisible(true);
        // contbrokenDoublePrice		
        this.contbrokenDoublePrice.setBoundLabelText(resHelper.getString("contbrokenDoublePrice.boundLabelText"));		
        this.contbrokenDoublePrice.setBoundLabelLength(100);		
        this.contbrokenDoublePrice.setBoundLabelUnderline(true);		
        this.contbrokenDoublePrice.setVisible(true);
        // contunit		
        this.contunit.setBoundLabelText(resHelper.getString("contunit.boundLabelText"));		
        this.contunit.setBoundLabelLength(100);		
        this.contunit.setBoundLabelUnderline(true);		
        this.contunit.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // scrollPaneremark
        // txtremark		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(200);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // pkeffectDate		
        this.pkeffectDate.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // pkunEffectDate		
        this.pkunEffectDate.setRequired(true);
        // txtbrokenSinglePrice		
        this.txtbrokenSinglePrice.setVisible(true);		
        this.txtbrokenSinglePrice.setHorizontalAlignment(2);		
        this.txtbrokenSinglePrice.setDataType(1);		
        this.txtbrokenSinglePrice.setSupportedEmpty(true);		
        this.txtbrokenSinglePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbrokenSinglePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbrokenSinglePrice.setPrecision(4);		
        this.txtbrokenSinglePrice.setRequired(true);
        // txtgreensPrice		
        this.txtgreensPrice.setVisible(true);		
        this.txtgreensPrice.setHorizontalAlignment(2);		
        this.txtgreensPrice.setDataType(1);		
        this.txtgreensPrice.setSupportedEmpty(true);		
        this.txtgreensPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtgreensPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtgreensPrice.setPrecision(4);		
        this.txtgreensPrice.setRequired(true);
        // txtdirtyPirce		
        this.txtdirtyPirce.setVisible(true);		
        this.txtdirtyPirce.setHorizontalAlignment(2);		
        this.txtdirtyPirce.setDataType(1);		
        this.txtdirtyPirce.setSupportedEmpty(true);		
        this.txtdirtyPirce.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdirtyPirce.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdirtyPirce.setPrecision(4);		
        this.txtdirtyPirce.setRequired(true);
        // txtmutantPrice		
        this.txtmutantPrice.setVisible(true);		
        this.txtmutantPrice.setHorizontalAlignment(2);		
        this.txtmutantPrice.setDataType(1);		
        this.txtmutantPrice.setSupportedEmpty(true);		
        this.txtmutantPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmutantPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmutantPrice.setPrecision(4);		
        this.txtmutantPrice.setRequired(true);
        // txtdoublePrice		
        this.txtdoublePrice.setVisible(true);		
        this.txtdoublePrice.setHorizontalAlignment(2);		
        this.txtdoublePrice.setDataType(1);		
        this.txtdoublePrice.setSupportedEmpty(true);		
        this.txtdoublePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdoublePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdoublePrice.setPrecision(4);		
        this.txtdoublePrice.setRequired(true);
        // txtflowPrice		
        this.txtflowPrice.setVisible(true);		
        this.txtflowPrice.setHorizontalAlignment(2);		
        this.txtflowPrice.setDataType(1);		
        this.txtflowPrice.setSupportedEmpty(true);		
        this.txtflowPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtflowPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtflowPrice.setPrecision(4);		
        this.txtflowPrice.setRequired(true);
        // txtbrokenDoublePrice		
        this.txtbrokenDoublePrice.setVisible(true);		
        this.txtbrokenDoublePrice.setHorizontalAlignment(2);		
        this.txtbrokenDoublePrice.setDataType(1);		
        this.txtbrokenDoublePrice.setSupportedEmpty(true);		
        this.txtbrokenDoublePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbrokenDoublePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbrokenDoublePrice.setPrecision(4);		
        this.txtbrokenDoublePrice.setRequired(true);
        // prmtunit		
        this.prmtunit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtunit.setVisible(true);		
        this.prmtunit.setEditable(true);		
        this.prmtunit.setDisplayFormat("$name$");		
        this.prmtunit.setEditFormat("$number$");		
        this.prmtunit.setCommitFormat("$number$");		
        this.prmtunit.setRequired(true);
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtremark,baseStatus,pkeffectDate,prmtcompany,pkunEffectDate,txtgreensPrice,txtdirtyPirce,txtdoublePrice,txtmutantPrice,txtbrokenSinglePrice,txtflowPrice,txtbrokenDoublePrice,prmtunit}));
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
        this.setBounds(new Rectangle(0, 0, 661, 359));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(680, 141, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(675, 169, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(768, 172, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(778, 211, 270, 19));
        this.add(kDLabelContainer4, null);
        contremark.setBounds(new Rectangle(30, 115, 599, 23));
        this.add(contremark, null);
        contbaseStatus.setBounds(new Rectangle(360, 37, 270, 19));
        this.add(contbaseStatus, null);
        conteffectDate.setBounds(new Rectangle(362, 76, 270, 19));
        this.add(conteffectDate, null);
        contcompany.setBounds(new Rectangle(30, 37, 270, 19));
        this.add(contcompany, null);
        contunEffectDate.setBounds(new Rectangle(32, 76, 270, 19));
        this.add(contunEffectDate, null);
        contbrokenSinglePrice.setBounds(new Rectangle(32, 277, 270, 19));
        this.add(contbrokenSinglePrice, null);
        contgreensPrice.setBounds(new Rectangle(32, 197, 270, 19));
        this.add(contgreensPrice, null);
        contdirtyPirce.setBounds(new Rectangle(362, 158, 270, 19));
        this.add(contdirtyPirce, null);
        contmutantPrice.setBounds(new Rectangle(362, 197, 270, 19));
        this.add(contmutantPrice, null);
        contdoublePrice.setBounds(new Rectangle(32, 236, 270, 19));
        this.add(contdoublePrice, null);
        contflowPrice.setBounds(new Rectangle(362, 236, 270, 19));
        this.add(contflowPrice, null);
        contbrokenDoublePrice.setBounds(new Rectangle(362, 277, 270, 19));
        this.add(contbrokenDoublePrice, null);
        contunit.setBounds(new Rectangle(30, 158, 270, 19));
        this.add(contunit, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conteffectDate
        conteffectDate.setBoundEditor(pkeffectDate);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contunEffectDate
        contunEffectDate.setBoundEditor(pkunEffectDate);
        //contbrokenSinglePrice
        contbrokenSinglePrice.setBoundEditor(txtbrokenSinglePrice);
        //contgreensPrice
        contgreensPrice.setBoundEditor(txtgreensPrice);
        //contdirtyPirce
        contdirtyPirce.setBoundEditor(txtdirtyPirce);
        //contmutantPrice
        contmutantPrice.setBoundEditor(txtmutantPrice);
        //contdoublePrice
        contdoublePrice.setBoundEditor(txtdoublePrice);
        //contflowPrice
        contflowPrice.setBoundEditor(txtflowPrice);
        //contbrokenDoublePrice
        contbrokenDoublePrice.setBoundEditor(txtbrokenDoublePrice);
        //contunit
        contunit.setBoundEditor(prmtunit);

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
        menuBiz.add(tBtnAudit);
        menuBiz.add(tBtnUnAudit);
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
        this.toolBar.add(mBtnAudit);
        this.toolBar.add(mBtnUnAudit);
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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("effectDate", java.util.Date.class, this.pkeffectDate, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("unEffectDate", java.util.Date.class, this.pkunEffectDate, "value");
		dataBinder.registerBinding("brokenSinglePrice", java.math.BigDecimal.class, this.txtbrokenSinglePrice, "value");
		dataBinder.registerBinding("greensPrice", java.math.BigDecimal.class, this.txtgreensPrice, "value");
		dataBinder.registerBinding("dirtyPirce", java.math.BigDecimal.class, this.txtdirtyPirce, "value");
		dataBinder.registerBinding("mutantPrice", java.math.BigDecimal.class, this.txtmutantPrice, "value");
		dataBinder.registerBinding("doublePrice", java.math.BigDecimal.class, this.txtdoublePrice, "value");
		dataBinder.registerBinding("flowPrice", java.math.BigDecimal.class, this.txtflowPrice, "value");
		dataBinder.registerBinding("brokenDoublePrice", java.math.BigDecimal.class, this.txtbrokenDoublePrice, "value");
		dataBinder.registerBinding("unit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtunit, "data");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.basedata.app.CoProductPriceEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.CoProductPriceInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("effectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unEffectDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("brokenSinglePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("greensPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dirtyPirce", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mutantPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("doublePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("flowPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("brokenDoublePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unit", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("effectDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("unEffectDate"));
        sic.add(new SelectorItemInfo("brokenSinglePrice"));
        sic.add(new SelectorItemInfo("greensPrice"));
        sic.add(new SelectorItemInfo("dirtyPirce"));
        sic.add(new SelectorItemInfo("mutantPrice"));
        sic.add(new SelectorItemInfo("doublePrice"));
        sic.add(new SelectorItemInfo("flowPrice"));
        sic.add(new SelectorItemInfo("brokenDoublePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("unit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("unit.id"));
        	sic.add(new SelectorItemInfo("unit.number"));
        	sic.add(new SelectorItemInfo("unit.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.CoProductPriceFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.CoProductPriceFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCoProductPriceEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCoProductPriceEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "CoProductPriceEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.CoProductPriceEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.CoProductPriceFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.CoProductPriceInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.CoProductPriceInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkeffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkunEffectDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbrokenSinglePrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"破单黄"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtgreensPrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"菜蛋"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdirtyPirce.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"脏蛋"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmutantPrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"畸形蛋"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdoublePrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"双黄蛋"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtflowPrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"流蛋"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtbrokenDoublePrice.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"破双黄"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtunit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"计量单位"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}