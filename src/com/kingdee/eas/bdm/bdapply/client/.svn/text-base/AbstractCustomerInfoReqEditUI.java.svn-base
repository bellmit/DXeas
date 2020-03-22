/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

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
public abstract class AbstractCustomerInfoReqEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCustomerInfoReqEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcolordisplay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conterrorMsg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCU;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCSSGroup;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsimpleName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforeignname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmnemonicCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparent;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerKind;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbizRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusiLicence;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusiExequatur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGSPAuthentication;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contartificialPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindustry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbarcode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contregion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCredited;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continvoicetype;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contversion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkManAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovince;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmonthSaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpinPai;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpinXiang;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomerType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsimpleName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtforeignname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmnemonicCode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparent;
    protected com.kingdee.bos.ctrl.swing.KDComboBox customerKind;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbizRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusiLicence;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusiExequatur;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtGSPAuthentication;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttaxRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtartificialPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtindustry;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbarcode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcountry;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtregion;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttaxData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttaxRate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox invoicetype;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtversion;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkManAddress;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprovince;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmonthSaleQty;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpinPai;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpinXiang;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCustomerGroupEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCustomerGroupEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSettleCustomerEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSettleCustomerEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox customerType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayCondition;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAccount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountCurrency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpayType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpayCondition;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlementCurrency;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaccountName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAccount;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaccountCurrency;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaccountArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpayType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfax;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contemail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contphone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractPersonPost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmobile;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSalePerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsalerAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpostcode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfax;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtemail;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtphone;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontractPersonPost;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobile;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcontractPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSalePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaleOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsalerAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpostcode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcolordisplay;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneerrorMsg;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txterrorMsg;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCU;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCSSGroup;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem CustomerInfoReqAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem newMenuItem1;
    protected com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo editData = null;
    protected ActionCustomerInfoReqAudit actionCustomerInfoReqAudit = null;
    protected ActionNotby actionNotby = null;
    protected ActionAllAudit actionAllAudit = null;
    /**
     * output class constructor
     */
    public AbstractCustomerInfoReqEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCustomerInfoReqEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionLocate
        actionLocate.setEnabled(true);
        actionLocate.setDaemonRun(false);

        actionLocate.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F6"));
        _tempStr = resHelper.getString("actionLocate.SHORT_DESCRIPTION");
        actionLocate.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionLocate.LONG_DESCRIPTION");
        actionLocate.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("actionLocate.NAME");
        actionLocate.putValue(ItemAction.NAME, _tempStr);
        this.actionLocate.setExtendProperty("userDefined", "false");
        this.actionLocate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionLocate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //actionCustomerInfoReqAudit
        this.actionCustomerInfoReqAudit = new ActionCustomerInfoReqAudit(this);
        getActionManager().registerAction("actionCustomerInfoReqAudit", actionCustomerInfoReqAudit);
        this.actionCustomerInfoReqAudit.setExtendProperty("canForewarn", "true");
        this.actionCustomerInfoReqAudit.setExtendProperty("userDefined", "true");
        this.actionCustomerInfoReqAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionCustomerInfoReqAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionCustomerInfoReqAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionNotby
        this.actionNotby = new ActionNotby(this);
        getActionManager().registerAction("actionNotby", actionNotby);
        this.actionNotby.setExtendProperty("canForewarn", "true");
        this.actionNotby.setExtendProperty("userDefined", "true");
        this.actionNotby.setExtendProperty("isObjectUpdateLock", "false");
         this.actionNotby.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionNotby.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAllAudit
        this.actionAllAudit = new ActionAllAudit(this);
        getActionManager().registerAction("actionAllAudit", actionAllAudit);
        this.actionAllAudit.setBindWorkFlow(true);
        this.actionAllAudit.setExtendProperty("canForewarn", "true");
        this.actionAllAudit.setExtendProperty("userDefined", "true");
        this.actionAllAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAllAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAllAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcolordisplay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conterrorMsg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCU = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCSSGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsimpleName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforeignname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmnemonicCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomerKind = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbizRegisterNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusiLicence = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusiExequatur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGSPAuthentication = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxRegisterNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contartificialPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindustry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbarcode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contregion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisCredited = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.conttaxData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continvoicetype = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contversion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkManAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovince = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmonthSaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpinPai = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpinXiang = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcustomerType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtforeignname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmnemonicCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtparent = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.customerKind = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbizRegisterNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusiLicence = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusiExequatur = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtGSPAuthentication = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttaxRegisterNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtartificialPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtindustry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbarcode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcountry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtregion = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmttaxData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttaxRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.invoicetype = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtversion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlinkManAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtprovince = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmonthSaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpinPai = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpinXiang = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtCustomerGroupEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSettleCustomerEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.customerType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayCondition = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAccount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountCurrency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpayType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpayCondition = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsettlementCurrency = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaccountName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankAccount = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaccountCurrency = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaccountArea = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtpayType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contfax = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contemail = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contphone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractPersonPost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmobile = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSalePerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaleOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsalerAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpostcode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtfax = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtemail = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtphone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcontractPersonPost = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmobile = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcontractPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtsaleGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSalePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsaleOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsalerAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpostcode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcolordisplay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPaneerrorMsg = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txterrorMsg = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCU = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCSSGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.CustomerInfoReqAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.newMenuItem1 = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contNumber.setName("contNumber");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contname.setName("contname");
        this.contcolordisplay.setName("contcolordisplay");
        this.contBizDate.setName("contBizDate");
        this.contAuditor.setName("contAuditor");
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contbillStatus.setName("contbillStatus");
        this.conterrorMsg.setName("conterrorMsg");
        this.contstatus.setName("contstatus");
        this.contCU.setName("contCU");
        this.contCSSGroup.setName("contCSSGroup");
        this.txtNumber.setName("txtNumber");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.contDescription.setName("contDescription");
        this.contsimpleName.setName("contsimpleName");
        this.contforeignname.setName("contforeignname");
        this.contmnemonicCode.setName("contmnemonicCode");
        this.contparent.setName("contparent");
        this.contcustomerKind.setName("contcustomerKind");
        this.contbizRegisterNo.setName("contbizRegisterNo");
        this.contbusiLicence.setName("contbusiLicence");
        this.contbusiExequatur.setName("contbusiExequatur");
        this.contGSPAuthentication.setName("contGSPAuthentication");
        this.conttaxRegisterNo.setName("conttaxRegisterNo");
        this.contartificialPerson.setName("contartificialPerson");
        this.contindustry.setName("contindustry");
        this.contbarcode.setName("contbarcode");
        this.contcountry.setName("contcountry");
        this.contcity.setName("contcity");
        this.contregion.setName("contregion");
        this.contaddress.setName("contaddress");
        this.chkisCredited.setName("chkisCredited");
        this.conttaxData.setName("conttaxData");
        this.conttaxRate.setName("conttaxRate");
        this.continvoicetype.setName("continvoicetype");
        this.contversion.setName("contversion");
        this.contlinkManAddress.setName("contlinkManAddress");
        this.contprovince.setName("contprovince");
        this.contmonthSaleQty.setName("contmonthSaleQty");
        this.contpinPai.setName("contpinPai");
        this.contpinXiang.setName("contpinXiang");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.contcustomerType.setName("contcustomerType");
        this.txtDescription.setName("txtDescription");
        this.txtsimpleName.setName("txtsimpleName");
        this.txtforeignname.setName("txtforeignname");
        this.txtmnemonicCode.setName("txtmnemonicCode");
        this.prmtparent.setName("prmtparent");
        this.customerKind.setName("customerKind");
        this.txtbizRegisterNo.setName("txtbizRegisterNo");
        this.txtbusiLicence.setName("txtbusiLicence");
        this.txtbusiExequatur.setName("txtbusiExequatur");
        this.txtGSPAuthentication.setName("txtGSPAuthentication");
        this.txttaxRegisterNo.setName("txttaxRegisterNo");
        this.txtartificialPerson.setName("txtartificialPerson");
        this.prmtindustry.setName("prmtindustry");
        this.txtbarcode.setName("txtbarcode");
        this.prmtcountry.setName("prmtcountry");
        this.prmtcity.setName("prmtcity");
        this.prmtregion.setName("prmtregion");
        this.txtaddress.setName("txtaddress");
        this.prmttaxData.setName("prmttaxData");
        this.txttaxRate.setName("txttaxRate");
        this.invoicetype.setName("invoicetype");
        this.txtversion.setName("txtversion");
        this.txtlinkManAddress.setName("txtlinkManAddress");
        this.prmtprovince.setName("prmtprovince");
        this.txtmonthSaleQty.setName("txtmonthSaleQty");
        this.txtpinPai.setName("txtpinPai");
        this.txtpinXiang.setName("txtpinXiang");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.kdtCustomerGroupEntry.setName("kdtCustomerGroupEntry");
        this.kdtSettleCustomerEntry.setName("kdtSettleCustomerEntry");
        this.customerType.setName("customerType");
        this.contcompany.setName("contcompany");
        this.contpayCondition.setName("contpayCondition");
        this.contsettlementCurrency.setName("contsettlementCurrency");
        this.contbank.setName("contbank");
        this.contaccountName.setName("contaccountName");
        this.contbankAccount.setName("contbankAccount");
        this.contaccountCurrency.setName("contaccountCurrency");
        this.contbankAddress.setName("contbankAddress");
        this.contaccountArea.setName("contaccountArea");
        this.contpayType.setName("contpayType");
        this.prmtcompany.setName("prmtcompany");
        this.prmtpayCondition.setName("prmtpayCondition");
        this.prmtsettlementCurrency.setName("prmtsettlementCurrency");
        this.txtbank.setName("txtbank");
        this.txtaccountName.setName("txtaccountName");
        this.txtbankAccount.setName("txtbankAccount");
        this.txtaccountCurrency.setName("txtaccountCurrency");
        this.txtbankAddress.setName("txtbankAddress");
        this.txtaccountArea.setName("txtaccountArea");
        this.prmtpayType.setName("prmtpayType");
        this.contfax.setName("contfax");
        this.contemail.setName("contemail");
        this.contphone.setName("contphone");
        this.contcontractPersonPost.setName("contcontractPersonPost");
        this.contmobile.setName("contmobile");
        this.contcontractPerson.setName("contcontractPerson");
        this.contsaleGroup.setName("contsaleGroup");
        this.contSalePerson.setName("contSalePerson");
        this.contsaleOrgUnit.setName("contsaleOrgUnit");
        this.contsalerAddress.setName("contsalerAddress");
        this.contpostcode.setName("contpostcode");
        this.txtfax.setName("txtfax");
        this.txtemail.setName("txtemail");
        this.txtphone.setName("txtphone");
        this.txtcontractPersonPost.setName("txtcontractPersonPost");
        this.txtmobile.setName("txtmobile");
        this.txtcontractPerson.setName("txtcontractPerson");
        this.prmtsaleGroup.setName("prmtsaleGroup");
        this.prmtSalePerson.setName("prmtSalePerson");
        this.prmtsaleOrgUnit.setName("prmtsaleOrgUnit");
        this.txtsalerAddress.setName("txtsalerAddress");
        this.txtpostcode.setName("txtpostcode");
        this.txtname.setName("txtname");
        this.txtcolordisplay.setName("txtcolordisplay");
        this.pkBizDate.setName("pkBizDate");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.billStatus.setName("billStatus");
        this.scrollPaneerrorMsg.setName("scrollPaneerrorMsg");
        this.txterrorMsg.setName("txterrorMsg");
        this.status.setName("status");
        this.prmtCU.setName("prmtCU");
        this.prmtCSSGroup.setName("prmtCSSGroup");
        this.btnPassAudit.setName("btnPassAudit");
        this.btnUnPassAudit.setName("btnUnPassAudit");
        this.CustomerInfoReqAudit.setName("CustomerInfoReqAudit");
        this.newMenuItem1.setName("newMenuItem1");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // contcolordisplay		
        this.contcolordisplay.setBoundLabelText(resHelper.getString("contcolordisplay.boundLabelText"));		
        this.contcolordisplay.setBoundLabelLength(100);		
        this.contcolordisplay.setBoundLabelUnderline(true);		
        this.contcolordisplay.setVisible(false);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(false);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contCreator		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);
        // contCreateTime		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);
        // contLastUpdateUser		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(false);
        // contLastUpdateTime		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(false);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // conterrorMsg		
        this.conterrorMsg.setBoundLabelText(resHelper.getString("conterrorMsg.boundLabelText"));		
        this.conterrorMsg.setBoundLabelLength(100);		
        this.conterrorMsg.setBoundLabelUnderline(true);		
        this.conterrorMsg.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // contCU		
        this.contCU.setBoundLabelText(resHelper.getString("contCU.boundLabelText"));		
        this.contCU.setBoundLabelLength(100);		
        this.contCU.setBoundLabelUnderline(true);		
        this.contCU.setVisible(true);
        // contCSSGroup		
        this.contCSSGroup.setBoundLabelText(resHelper.getString("contCSSGroup.boundLabelText"));		
        this.contCSSGroup.setBoundLabelLength(100);		
        this.contCSSGroup.setBoundLabelUnderline(true);		
        this.contCSSGroup.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contsimpleName		
        this.contsimpleName.setBoundLabelText(resHelper.getString("contsimpleName.boundLabelText"));		
        this.contsimpleName.setBoundLabelLength(100);		
        this.contsimpleName.setBoundLabelUnderline(true);		
        this.contsimpleName.setVisible(false);
        // contforeignname		
        this.contforeignname.setBoundLabelText(resHelper.getString("contforeignname.boundLabelText"));		
        this.contforeignname.setBoundLabelLength(100);		
        this.contforeignname.setBoundLabelUnderline(true);		
        this.contforeignname.setVisible(false);
        // contmnemonicCode		
        this.contmnemonicCode.setBoundLabelText(resHelper.getString("contmnemonicCode.boundLabelText"));		
        this.contmnemonicCode.setBoundLabelLength(100);		
        this.contmnemonicCode.setBoundLabelUnderline(true);		
        this.contmnemonicCode.setVisible(true);
        // contparent		
        this.contparent.setBoundLabelText(resHelper.getString("contparent.boundLabelText"));		
        this.contparent.setBoundLabelLength(100);		
        this.contparent.setBoundLabelUnderline(true);		
        this.contparent.setVisible(false);
        // contcustomerKind		
        this.contcustomerKind.setBoundLabelText(resHelper.getString("contcustomerKind.boundLabelText"));		
        this.contcustomerKind.setBoundLabelLength(100);		
        this.contcustomerKind.setBoundLabelUnderline(true);		
        this.contcustomerKind.setVisible(true);
        // contbizRegisterNo		
        this.contbizRegisterNo.setBoundLabelText(resHelper.getString("contbizRegisterNo.boundLabelText"));		
        this.contbizRegisterNo.setBoundLabelLength(100);		
        this.contbizRegisterNo.setBoundLabelUnderline(true);		
        this.contbizRegisterNo.setVisible(false);
        // contbusiLicence		
        this.contbusiLicence.setBoundLabelText(resHelper.getString("contbusiLicence.boundLabelText"));		
        this.contbusiLicence.setBoundLabelLength(100);		
        this.contbusiLicence.setBoundLabelUnderline(true);		
        this.contbusiLicence.setVisible(true);
        // contbusiExequatur		
        this.contbusiExequatur.setBoundLabelText(resHelper.getString("contbusiExequatur.boundLabelText"));		
        this.contbusiExequatur.setBoundLabelLength(100);		
        this.contbusiExequatur.setBoundLabelUnderline(true);		
        this.contbusiExequatur.setVisible(false);
        // contGSPAuthentication		
        this.contGSPAuthentication.setBoundLabelText(resHelper.getString("contGSPAuthentication.boundLabelText"));		
        this.contGSPAuthentication.setBoundLabelLength(100);		
        this.contGSPAuthentication.setBoundLabelUnderline(true);		
        this.contGSPAuthentication.setVisible(false);
        // conttaxRegisterNo		
        this.conttaxRegisterNo.setBoundLabelText(resHelper.getString("conttaxRegisterNo.boundLabelText"));		
        this.conttaxRegisterNo.setBoundLabelLength(100);		
        this.conttaxRegisterNo.setBoundLabelUnderline(true);		
        this.conttaxRegisterNo.setVisible(true);
        // contartificialPerson		
        this.contartificialPerson.setBoundLabelText(resHelper.getString("contartificialPerson.boundLabelText"));		
        this.contartificialPerson.setBoundLabelLength(100);		
        this.contartificialPerson.setBoundLabelUnderline(true);		
        this.contartificialPerson.setVisible(true);
        // contindustry		
        this.contindustry.setBoundLabelText(resHelper.getString("contindustry.boundLabelText"));		
        this.contindustry.setBoundLabelLength(100);		
        this.contindustry.setBoundLabelUnderline(true);		
        this.contindustry.setVisible(true);
        // contbarcode		
        this.contbarcode.setBoundLabelText(resHelper.getString("contbarcode.boundLabelText"));		
        this.contbarcode.setBoundLabelLength(100);		
        this.contbarcode.setBoundLabelUnderline(true);		
        this.contbarcode.setVisible(false);
        // contcountry		
        this.contcountry.setBoundLabelText(resHelper.getString("contcountry.boundLabelText"));		
        this.contcountry.setBoundLabelLength(100);		
        this.contcountry.setBoundLabelUnderline(true);		
        this.contcountry.setVisible(true);
        // contcity		
        this.contcity.setBoundLabelText(resHelper.getString("contcity.boundLabelText"));		
        this.contcity.setBoundLabelLength(100);		
        this.contcity.setBoundLabelUnderline(true);		
        this.contcity.setVisible(true);
        // contregion		
        this.contregion.setBoundLabelText(resHelper.getString("contregion.boundLabelText"));		
        this.contregion.setBoundLabelLength(100);		
        this.contregion.setBoundLabelUnderline(true);		
        this.contregion.setVisible(true);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // chkisCredited		
        this.chkisCredited.setText(resHelper.getString("chkisCredited.text"));		
        this.chkisCredited.setHorizontalAlignment(2);
        // conttaxData		
        this.conttaxData.setBoundLabelText(resHelper.getString("conttaxData.boundLabelText"));		
        this.conttaxData.setBoundLabelLength(100);		
        this.conttaxData.setBoundLabelUnderline(true);		
        this.conttaxData.setVisible(true);
        // conttaxRate		
        this.conttaxRate.setBoundLabelText(resHelper.getString("conttaxRate.boundLabelText"));		
        this.conttaxRate.setBoundLabelLength(100);		
        this.conttaxRate.setBoundLabelUnderline(true);		
        this.conttaxRate.setVisible(true);
        // continvoicetype		
        this.continvoicetype.setBoundLabelText(resHelper.getString("continvoicetype.boundLabelText"));		
        this.continvoicetype.setBoundLabelLength(100);		
        this.continvoicetype.setBoundLabelUnderline(true);		
        this.continvoicetype.setVisible(true);
        // contversion		
        this.contversion.setBoundLabelText(resHelper.getString("contversion.boundLabelText"));		
        this.contversion.setBoundLabelLength(100);		
        this.contversion.setBoundLabelUnderline(true);		
        this.contversion.setVisible(false);
        // contlinkManAddress		
        this.contlinkManAddress.setBoundLabelText(resHelper.getString("contlinkManAddress.boundLabelText"));		
        this.contlinkManAddress.setBoundLabelLength(100);		
        this.contlinkManAddress.setBoundLabelUnderline(true);		
        this.contlinkManAddress.setVisible(false);
        // contprovince		
        this.contprovince.setBoundLabelText(resHelper.getString("contprovince.boundLabelText"));		
        this.contprovince.setBoundLabelLength(100);		
        this.contprovince.setBoundLabelUnderline(true);		
        this.contprovince.setVisible(true);
        // contmonthSaleQty		
        this.contmonthSaleQty.setBoundLabelText(resHelper.getString("contmonthSaleQty.boundLabelText"));		
        this.contmonthSaleQty.setBoundLabelLength(100);		
        this.contmonthSaleQty.setBoundLabelUnderline(true);		
        this.contmonthSaleQty.setVisible(true);
        // contpinPai		
        this.contpinPai.setBoundLabelText(resHelper.getString("contpinPai.boundLabelText"));		
        this.contpinPai.setBoundLabelLength(100);		
        this.contpinPai.setBoundLabelUnderline(true);		
        this.contpinPai.setVisible(true);
        // contpinXiang		
        this.contpinXiang.setBoundLabelText(resHelper.getString("contpinXiang.boundLabelText"));		
        this.contpinXiang.setBoundLabelLength(100);		
        this.contpinXiang.setBoundLabelUnderline(true);		
        this.contpinXiang.setVisible(true);
        // kDTabbedPane2
        // contcustomerType		
        this.contcustomerType.setBoundLabelText(resHelper.getString("contcustomerType.boundLabelText"));		
        this.contcustomerType.setBoundLabelLength(100);		
        this.contcustomerType.setBoundLabelUnderline(true);		
        this.contcustomerType.setVisible(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);		
        this.txtDescription.setVisible(false);
        // txtsimpleName		
        this.txtsimpleName.setHorizontalAlignment(2);		
        this.txtsimpleName.setMaxLength(100);		
        this.txtsimpleName.setRequired(false);
        // txtforeignname		
        this.txtforeignname.setHorizontalAlignment(2);		
        this.txtforeignname.setMaxLength(100);		
        this.txtforeignname.setRequired(false);
        // txtmnemonicCode		
        this.txtmnemonicCode.setHorizontalAlignment(2);		
        this.txtmnemonicCode.setMaxLength(100);		
        this.txtmnemonicCode.setRequired(true);
        // prmtparent		
        this.prmtparent.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtparent.setEditable(true);		
        this.prmtparent.setDisplayFormat("$name$");		
        this.prmtparent.setEditFormat("$number$");		
        this.prmtparent.setCommitFormat("$number$");		
        this.prmtparent.setRequired(false);
        // customerKind		
        this.customerKind.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.master.cssp.CustomerKindEnum").toArray());		
        this.customerKind.setRequired(false);
        // txtbizRegisterNo		
        this.txtbizRegisterNo.setHorizontalAlignment(2);		
        this.txtbizRegisterNo.setMaxLength(100);		
        this.txtbizRegisterNo.setRequired(false);
        // txtbusiLicence		
        this.txtbusiLicence.setHorizontalAlignment(2);		
        this.txtbusiLicence.setMaxLength(100);		
        this.txtbusiLicence.setRequired(false);
        // txtbusiExequatur		
        this.txtbusiExequatur.setHorizontalAlignment(2);		
        this.txtbusiExequatur.setMaxLength(100);		
        this.txtbusiExequatur.setRequired(false);
        // txtGSPAuthentication		
        this.txtGSPAuthentication.setHorizontalAlignment(2);		
        this.txtGSPAuthentication.setMaxLength(100);		
        this.txtGSPAuthentication.setRequired(false);
        // txttaxRegisterNo		
        this.txttaxRegisterNo.setHorizontalAlignment(2);		
        this.txttaxRegisterNo.setMaxLength(100);		
        this.txttaxRegisterNo.setRequired(true);
        // txtartificialPerson		
        this.txtartificialPerson.setHorizontalAlignment(2);		
        this.txtartificialPerson.setMaxLength(100);		
        this.txtartificialPerson.setRequired(false);
        // prmtindustry		
        this.prmtindustry.setQueryInfo("com.kingdee.eas.basedata.assistant.app.IndustryQuery");		
        this.prmtindustry.setEditable(true);		
        this.prmtindustry.setDisplayFormat("$name$");		
        this.prmtindustry.setEditFormat("$number$");		
        this.prmtindustry.setCommitFormat("$number$");		
        this.prmtindustry.setRequired(false);
        // txtbarcode		
        this.txtbarcode.setHorizontalAlignment(2);		
        this.txtbarcode.setMaxLength(100);		
        this.txtbarcode.setRequired(false);
        // prmtcountry		
        this.prmtcountry.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CountryQuery");		
        this.prmtcountry.setEditable(true);		
        this.prmtcountry.setDisplayFormat("$name$");		
        this.prmtcountry.setEditFormat("$number$");		
        this.prmtcountry.setCommitFormat("$number$");		
        this.prmtcountry.setRequired(true);
        // prmtcity		
        this.prmtcity.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CityQuery");		
        this.prmtcity.setEditable(true);		
        this.prmtcity.setDisplayFormat("$name$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(true);
        // prmtregion		
        this.prmtregion.setQueryInfo("com.kingdee.eas.basedata.assistant.app.RegionQuery");		
        this.prmtregion.setEditable(true);		
        this.prmtregion.setDisplayFormat("$name$");		
        this.prmtregion.setEditFormat("$number$");		
        this.prmtregion.setCommitFormat("$number$");		
        this.prmtregion.setRequired(false);
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(100);		
        this.txtaddress.setRequired(true);
        // prmttaxData		
        this.prmttaxData.setQueryInfo("com.kingdee.eas.basedata.assistant.app.TaxDataQuery");		
        this.prmttaxData.setEditable(true);		
        this.prmttaxData.setDisplayFormat("$type$");		
        this.prmttaxData.setEditFormat("$number$");		
        this.prmttaxData.setCommitFormat("$number$");		
        this.prmttaxData.setRequired(false);
        // txttaxRate		
        this.txttaxRate.setHorizontalAlignment(2);		
        this.txttaxRate.setDataType(1);		
        this.txttaxRate.setSupportedEmpty(true);		
        this.txttaxRate.setMinimumValue( new java.math.BigDecimal("-9.999999999999E10"));		
        this.txttaxRate.setMaximumValue( new java.math.BigDecimal("9.999999999999E10"));		
        this.txttaxRate.setPrecision(2);		
        this.txttaxRate.setRequired(false);
        // invoicetype		
        this.invoicetype.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.master.cssp.PayInvoiceTypeEnum").toArray());		
        this.invoicetype.setRequired(false);
        // txtversion		
        this.txtversion.setHorizontalAlignment(2);		
        this.txtversion.setDataType(0);		
        this.txtversion.setSupportedEmpty(true);		
        this.txtversion.setRequired(false);
        // txtlinkManAddress		
        this.txtlinkManAddress.setHorizontalAlignment(2);		
        this.txtlinkManAddress.setMaxLength(255);		
        this.txtlinkManAddress.setRequired(false);
        // prmtprovince		
        this.prmtprovince.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtprovince.setEditable(true);		
        this.prmtprovince.setDisplayFormat("$name$");		
        this.prmtprovince.setEditFormat("$number$");		
        this.prmtprovince.setCommitFormat("$number$");		
        this.prmtprovince.setRequired(true);
        // txtmonthSaleQty		
        this.txtmonthSaleQty.setVisible(true);		
        this.txtmonthSaleQty.setHorizontalAlignment(2);		
        this.txtmonthSaleQty.setDataType(1);		
        this.txtmonthSaleQty.setSupportedEmpty(true);		
        this.txtmonthSaleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmonthSaleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmonthSaleQty.setPrecision(4);		
        this.txtmonthSaleQty.setRequired(false);
        // txtpinPai		
        this.txtpinPai.setVisible(true);		
        this.txtpinPai.setHorizontalAlignment(2);		
        this.txtpinPai.setMaxLength(100);		
        this.txtpinPai.setRequired(false);
        // txtpinXiang		
        this.txtpinXiang.setVisible(true);		
        this.txtpinXiang.setHorizontalAlignment(2);		
        this.txtpinXiang.setMaxLength(100);		
        this.txtpinXiang.setRequired(false);
        // kDPanel4
        // kDPanel5
        // kdtCustomerGroupEntry
		String kdtCustomerGroupEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"customerGroupstd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customerGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"stdName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"groupName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"groupFullName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{customerGroupstd}</t:Cell><t:Cell>$Resource{customerGroup}</t:Cell><t:Cell>$Resource{stdName}</t:Cell><t:Cell>$Resource{groupName}</t:Cell><t:Cell>$Resource{groupFullName}</t:Cell><t:Cell>$Resource{seq}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCustomerGroupEntry.setFormatXml(resHelper.translateString("kdtCustomerGroupEntry",kdtCustomerGroupEntryStrXML));
        kdtCustomerGroupEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtCustomerGroupEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtCustomerGroupEntry.putBindContents("editData",new String[] {"customerGroupstd","customerGroup","stdName","groupName","groupFullName","seq"});


        this.kdtCustomerGroupEntry.checkParsed();
        KDTextField kdtCustomerGroupEntry_stdName_TextField = new KDTextField();
        kdtCustomerGroupEntry_stdName_TextField.setName("kdtCustomerGroupEntry_stdName_TextField");
        kdtCustomerGroupEntry_stdName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCustomerGroupEntry_stdName_CellEditor = new KDTDefaultCellEditor(kdtCustomerGroupEntry_stdName_TextField);
        this.kdtCustomerGroupEntry.getColumn("stdName").setEditor(kdtCustomerGroupEntry_stdName_CellEditor);
        KDTextField kdtCustomerGroupEntry_groupName_TextField = new KDTextField();
        kdtCustomerGroupEntry_groupName_TextField.setName("kdtCustomerGroupEntry_groupName_TextField");
        kdtCustomerGroupEntry_groupName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCustomerGroupEntry_groupName_CellEditor = new KDTDefaultCellEditor(kdtCustomerGroupEntry_groupName_TextField);
        this.kdtCustomerGroupEntry.getColumn("groupName").setEditor(kdtCustomerGroupEntry_groupName_CellEditor);
        KDTextField kdtCustomerGroupEntry_groupFullName_TextField = new KDTextField();
        kdtCustomerGroupEntry_groupFullName_TextField.setName("kdtCustomerGroupEntry_groupFullName_TextField");
        kdtCustomerGroupEntry_groupFullName_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtCustomerGroupEntry_groupFullName_CellEditor = new KDTDefaultCellEditor(kdtCustomerGroupEntry_groupFullName_TextField);
        this.kdtCustomerGroupEntry.getColumn("groupFullName").setEditor(kdtCustomerGroupEntry_groupFullName_CellEditor);
        // kdtSettleCustomerEntry
		String kdtSettleCustomerEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settleCustomer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settleCustomer}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSettleCustomerEntry.setFormatXml(resHelper.translateString("kdtSettleCustomerEntry",kdtSettleCustomerEntryStrXML));

                this.kdtSettleCustomerEntry.putBindContents("editData",new String[] {"seq","settleCustomer"});


        this.kdtSettleCustomerEntry.checkParsed();
        final KDBizPromptBox kdtSettleCustomerEntry_settleCustomer_PromptBox = new KDBizPromptBox();
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setVisible(true);
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setEditable(true);
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setDisplayFormat("$number$");
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setEditFormat("$number$");
        kdtSettleCustomerEntry_settleCustomer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSettleCustomerEntry_settleCustomer_CellEditor = new KDTDefaultCellEditor(kdtSettleCustomerEntry_settleCustomer_PromptBox);
        this.kdtSettleCustomerEntry.getColumn("settleCustomer").setEditor(kdtSettleCustomerEntry_settleCustomer_CellEditor);
        ObjectValueRender kdtSettleCustomerEntry_settleCustomer_OVR = new ObjectValueRender();
        kdtSettleCustomerEntry_settleCustomer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSettleCustomerEntry.getColumn("settleCustomer").setRenderer(kdtSettleCustomerEntry_settleCustomer_OVR);
        // customerType		
        this.customerType.setVisible(true);		
        this.customerType.addItems(EnumUtils.getEnumList("com.kingdee.eas.bdm.bdapply.CustomerType").toArray());		
        this.customerType.setRequired(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contpayCondition		
        this.contpayCondition.setBoundLabelText(resHelper.getString("contpayCondition.boundLabelText"));		
        this.contpayCondition.setBoundLabelLength(100);		
        this.contpayCondition.setBoundLabelUnderline(true);		
        this.contpayCondition.setVisible(false);
        // contsettlementCurrency		
        this.contsettlementCurrency.setBoundLabelText(resHelper.getString("contsettlementCurrency.boundLabelText"));		
        this.contsettlementCurrency.setBoundLabelLength(100);		
        this.contsettlementCurrency.setBoundLabelUnderline(true);		
        this.contsettlementCurrency.setVisible(true);
        // contbank		
        this.contbank.setBoundLabelText(resHelper.getString("contbank.boundLabelText"));		
        this.contbank.setBoundLabelLength(100);		
        this.contbank.setBoundLabelUnderline(true);		
        this.contbank.setVisible(false);
        // contaccountName		
        this.contaccountName.setBoundLabelText(resHelper.getString("contaccountName.boundLabelText"));		
        this.contaccountName.setBoundLabelLength(100);		
        this.contaccountName.setBoundLabelUnderline(true);		
        this.contaccountName.setVisible(false);
        // contbankAccount		
        this.contbankAccount.setBoundLabelText(resHelper.getString("contbankAccount.boundLabelText"));		
        this.contbankAccount.setBoundLabelLength(100);		
        this.contbankAccount.setBoundLabelUnderline(true);		
        this.contbankAccount.setVisible(false);
        // contaccountCurrency		
        this.contaccountCurrency.setBoundLabelText(resHelper.getString("contaccountCurrency.boundLabelText"));		
        this.contaccountCurrency.setBoundLabelLength(100);		
        this.contaccountCurrency.setBoundLabelUnderline(true);		
        this.contaccountCurrency.setVisible(false);
        // contbankAddress		
        this.contbankAddress.setBoundLabelText(resHelper.getString("contbankAddress.boundLabelText"));		
        this.contbankAddress.setBoundLabelLength(100);		
        this.contbankAddress.setBoundLabelUnderline(true);		
        this.contbankAddress.setVisible(false);
        // contaccountArea		
        this.contaccountArea.setBoundLabelText(resHelper.getString("contaccountArea.boundLabelText"));		
        this.contaccountArea.setBoundLabelLength(100);		
        this.contaccountArea.setBoundLabelUnderline(true);		
        this.contaccountArea.setVisible(false);
        // contpayType		
        this.contpayType.setBoundLabelText(resHelper.getString("contpayType.boundLabelText"));		
        this.contpayType.setBoundLabelLength(100);		
        this.contpayType.setBoundLabelUnderline(true);		
        this.contpayType.setVisible(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtpayCondition		
        this.prmtpayCondition.setQueryInfo("com.kingdee.eas.basedata.assistant.app.PayConditionQuery");		
        this.prmtpayCondition.setEditable(true);		
        this.prmtpayCondition.setDisplayFormat("$name$");		
        this.prmtpayCondition.setEditFormat("$number$");		
        this.prmtpayCondition.setCommitFormat("$number$");		
        this.prmtpayCondition.setRequired(false);
        // prmtsettlementCurrency		
        this.prmtsettlementCurrency.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CurrencyQuery");		
        this.prmtsettlementCurrency.setEditable(true);		
        this.prmtsettlementCurrency.setDisplayFormat("$name$");		
        this.prmtsettlementCurrency.setEditFormat("$number$");		
        this.prmtsettlementCurrency.setCommitFormat("$number$");		
        this.prmtsettlementCurrency.setRequired(true);
        // txtbank		
        this.txtbank.setVisible(false);		
        this.txtbank.setHorizontalAlignment(2);		
        this.txtbank.setMaxLength(100);		
        this.txtbank.setRequired(false);
        // txtaccountName		
        this.txtaccountName.setVisible(false);		
        this.txtaccountName.setHorizontalAlignment(2);		
        this.txtaccountName.setMaxLength(200);		
        this.txtaccountName.setRequired(false);
        // txtbankAccount		
        this.txtbankAccount.setVisible(false);		
        this.txtbankAccount.setHorizontalAlignment(2);		
        this.txtbankAccount.setMaxLength(200);		
        this.txtbankAccount.setRequired(false);
        // txtaccountCurrency		
        this.txtaccountCurrency.setVisible(false);		
        this.txtaccountCurrency.setHorizontalAlignment(2);		
        this.txtaccountCurrency.setMaxLength(100);		
        this.txtaccountCurrency.setRequired(false);
        // txtbankAddress		
        this.txtbankAddress.setVisible(false);		
        this.txtbankAddress.setHorizontalAlignment(2);		
        this.txtbankAddress.setMaxLength(255);		
        this.txtbankAddress.setRequired(false);
        // txtaccountArea		
        this.txtaccountArea.setVisible(false);		
        this.txtaccountArea.setHorizontalAlignment(2);		
        this.txtaccountArea.setMaxLength(200);		
        this.txtaccountArea.setRequired(false);
        // prmtpayType		
        this.prmtpayType.setQueryInfo("com.kingdee.eas.basedata.assistant.app.PaymentTypeQuery");		
        this.prmtpayType.setVisible(true);		
        this.prmtpayType.setEditable(true);		
        this.prmtpayType.setDisplayFormat("$name$");		
        this.prmtpayType.setEditFormat("$number$");		
        this.prmtpayType.setCommitFormat("$number$");		
        this.prmtpayType.setRequired(false);
        // contfax		
        this.contfax.setBoundLabelText(resHelper.getString("contfax.boundLabelText"));		
        this.contfax.setBoundLabelLength(100);		
        this.contfax.setBoundLabelUnderline(true);		
        this.contfax.setVisible(true);
        // contemail		
        this.contemail.setBoundLabelText(resHelper.getString("contemail.boundLabelText"));		
        this.contemail.setBoundLabelLength(100);		
        this.contemail.setBoundLabelUnderline(true);		
        this.contemail.setVisible(true);
        // contphone		
        this.contphone.setBoundLabelText(resHelper.getString("contphone.boundLabelText"));		
        this.contphone.setBoundLabelLength(100);		
        this.contphone.setBoundLabelUnderline(true);		
        this.contphone.setVisible(true);
        // contcontractPersonPost		
        this.contcontractPersonPost.setBoundLabelText(resHelper.getString("contcontractPersonPost.boundLabelText"));		
        this.contcontractPersonPost.setBoundLabelLength(100);		
        this.contcontractPersonPost.setBoundLabelUnderline(true);		
        this.contcontractPersonPost.setVisible(true);
        // contmobile		
        this.contmobile.setBoundLabelText(resHelper.getString("contmobile.boundLabelText"));		
        this.contmobile.setBoundLabelLength(100);		
        this.contmobile.setBoundLabelUnderline(true);		
        this.contmobile.setVisible(true);
        // contcontractPerson		
        this.contcontractPerson.setBoundLabelText(resHelper.getString("contcontractPerson.boundLabelText"));		
        this.contcontractPerson.setBoundLabelLength(100);		
        this.contcontractPerson.setBoundLabelUnderline(true);		
        this.contcontractPerson.setVisible(true);
        // contsaleGroup		
        this.contsaleGroup.setBoundLabelText(resHelper.getString("contsaleGroup.boundLabelText"));		
        this.contsaleGroup.setBoundLabelLength(100);		
        this.contsaleGroup.setBoundLabelUnderline(true);		
        this.contsaleGroup.setVisible(true);
        // contSalePerson		
        this.contSalePerson.setBoundLabelText(resHelper.getString("contSalePerson.boundLabelText"));		
        this.contSalePerson.setBoundLabelLength(100);		
        this.contSalePerson.setBoundLabelUnderline(true);
        // contsaleOrgUnit		
        this.contsaleOrgUnit.setBoundLabelText(resHelper.getString("contsaleOrgUnit.boundLabelText"));		
        this.contsaleOrgUnit.setBoundLabelLength(100);		
        this.contsaleOrgUnit.setBoundLabelUnderline(true);		
        this.contsaleOrgUnit.setVisible(true);
        // contsalerAddress		
        this.contsalerAddress.setBoundLabelText(resHelper.getString("contsalerAddress.boundLabelText"));		
        this.contsalerAddress.setBoundLabelLength(100);		
        this.contsalerAddress.setBoundLabelUnderline(true);		
        this.contsalerAddress.setVisible(true);
        // contpostcode		
        this.contpostcode.setBoundLabelText(resHelper.getString("contpostcode.boundLabelText"));		
        this.contpostcode.setBoundLabelLength(100);		
        this.contpostcode.setBoundLabelUnderline(true);		
        this.contpostcode.setVisible(true);
        // txtfax		
        this.txtfax.setHorizontalAlignment(2);		
        this.txtfax.setMaxLength(100);		
        this.txtfax.setRequired(false);
        // txtemail		
        this.txtemail.setHorizontalAlignment(2);		
        this.txtemail.setMaxLength(100);		
        this.txtemail.setRequired(false);
        // txtphone		
        this.txtphone.setHorizontalAlignment(2);		
        this.txtphone.setMaxLength(100);		
        this.txtphone.setRequired(false);
        // txtcontractPersonPost		
        this.txtcontractPersonPost.setHorizontalAlignment(2);		
        this.txtcontractPersonPost.setMaxLength(100);		
        this.txtcontractPersonPost.setRequired(false);
        // txtmobile		
        this.txtmobile.setHorizontalAlignment(2);		
        this.txtmobile.setMaxLength(100);		
        this.txtmobile.setRequired(true);
        // txtcontractPerson		
        this.txtcontractPerson.setHorizontalAlignment(2);		
        this.txtcontractPerson.setMaxLength(100);		
        this.txtcontractPerson.setRequired(true);
        // prmtsaleGroup		
        this.prmtsaleGroup.setEditable(true);		
        this.prmtsaleGroup.setDisplayFormat("$name$");		
        this.prmtsaleGroup.setEditFormat("$number$");		
        this.prmtsaleGroup.setCommitFormat("$number$");		
        this.prmtsaleGroup.setRequired(false);
        // prmtSalePerson		
        this.prmtSalePerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtSalePerson.setEditable(true);		
        this.prmtSalePerson.setDisplayFormat("$name$");		
        this.prmtSalePerson.setEditFormat("$number$");		
        this.prmtSalePerson.setCommitFormat("$number$");		
        this.prmtSalePerson.setRequired(true);
        this.prmtSalePerson.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtSalePerson_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtsaleOrgUnit		
        this.prmtsaleOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.SaleItemQuery");		
        this.prmtsaleOrgUnit.setEditable(true);		
        this.prmtsaleOrgUnit.setDisplayFormat("$name$");		
        this.prmtsaleOrgUnit.setEditFormat("$number$");		
        this.prmtsaleOrgUnit.setCommitFormat("$number$");		
        this.prmtsaleOrgUnit.setRequired(true);
        // txtsalerAddress		
        this.txtsalerAddress.setHorizontalAlignment(2);		
        this.txtsalerAddress.setMaxLength(255);		
        this.txtsalerAddress.setRequired(false);
        // txtpostcode		
        this.txtpostcode.setHorizontalAlignment(2);		
        this.txtpostcode.setMaxLength(100);		
        this.txtpostcode.setRequired(false);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(100);		
        this.txtname.setRequired(true);
        // txtcolordisplay		
        this.txtcolordisplay.setVisible(false);		
        this.txtcolordisplay.setHorizontalAlignment(2);		
        this.txtcolordisplay.setDataType(0);		
        this.txtcolordisplay.setSupportedEmpty(true);		
        this.txtcolordisplay.setRequired(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(false);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // scrollPaneerrorMsg
        // txterrorMsg		
        this.txterrorMsg.setRequired(false);		
        this.txterrorMsg.setMaxLength(500);		
        this.txterrorMsg.setEnabled(false);
        // status		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.master.cssp.UsedStatusEnum").toArray());		
        this.status.setRequired(false);		
        this.status.setEnabled(false);
        // prmtCU		
        this.prmtCU.setEditable(true);		
        this.prmtCU.setDisplayFormat("$name$");		
        this.prmtCU.setEditFormat("$number$");		
        this.prmtCU.setCommitFormat("$number$");		
        this.prmtCU.setRequired(false);		
        this.prmtCU.setEnabled(false);
        // prmtCSSGroup		
        this.prmtCSSGroup.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerGroupQuery");		
        this.prmtCSSGroup.setEditable(true);		
        this.prmtCSSGroup.setDisplayFormat("$name$");		
        this.prmtCSSGroup.setEditFormat("$number$");		
        this.prmtCSSGroup.setCommitFormat("$number$");		
        this.prmtCSSGroup.setRequired(false);
        // btnPassAudit
        this.btnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionCustomerInfoReqAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPassAudit.setText(resHelper.getString("btnPassAudit.text"));
        // btnUnPassAudit
        this.btnUnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionNotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnPassAudit.setText(resHelper.getString("btnUnPassAudit.text"));
        // CustomerInfoReqAudit
        this.CustomerInfoReqAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionCustomerInfoReqAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.CustomerInfoReqAudit.setText(resHelper.getString("CustomerInfoReqAudit.text"));
        // newMenuItem1
        this.newMenuItem1.setAction((IItemAction)ActionProxyFactory.getProxy(actionNotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.newMenuItem1.setText(resHelper.getString("newMenuItem1.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtCU,txtname,txtNumber,txtsimpleName,txtforeignname,txtmnemonicCode,prmtparent,customerKind,txtbizRegisterNo,txtbusiLicence,txtbusiExequatur,txtGSPAuthentication,txttaxRegisterNo,txtartificialPerson,prmtindustry,txtbarcode,prmtcountry,prmtcity,prmtregion,txtaddress,chkisCredited,prmttaxData,txttaxRate,invoicetype,status,txtversion,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtcolordisplay,billStatus,txterrorMsg,prmtCSSGroup,prmtSalePerson,prmtcompany,prmtpayCondition,prmtsettlementCurrency,txtcontractPerson,txtcontractPersonPost,txtphone,txtmobile,txtfax,txtemail,txtbank,txtbankAccount,txtbankAddress,txtaccountName,txtaccountCurrency,txtaccountArea,prmtsaleGroup,prmtsaleOrgUnit,txtlinkManAddress,txtsalerAddress,txtpostcode,prmtprovince,kdtCustomerGroupEntry,txtmonthSaleQty,txtpinPai,txtpinXiang,customerType,prmtpayType}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contNumber.setBounds(new Rectangle(10, 5, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 5, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(10, 92, 980, 476));
        this.add(kDTabbedPane1, new KDLayout.Constraints(10, 92, 980, 476, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contname.setBounds(new Rectangle(340, 5, 600, 19));
        this.add(contname, new KDLayout.Constraints(340, 5, 600, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcolordisplay.setBounds(new Rectangle(956, 74, 270, 19));
        this.add(contcolordisplay, new KDLayout.Constraints(956, 74, 270, 19, 0));
        contBizDate.setBounds(new Rectangle(10, 29, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(10, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(10, 576, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreator.setBounds(new Rectangle(340, 576, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(340, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(340, 602, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(340, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(680, 576, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(680, 576, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(680, 602, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(680, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(340, 29, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(340, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conterrorMsg.setBounds(new Rectangle(10, 55, 934, 35));
        this.add(conterrorMsg, new KDLayout.Constraints(10, 55, 934, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstatus.setBounds(new Rectangle(670, 29, 270, 19));
        this.add(contstatus, new KDLayout.Constraints(670, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCU.setBounds(new Rectangle(10, 602, 270, 19));
        this.add(contCU, new KDLayout.Constraints(10, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCSSGroup.setBounds(new Rectangle(986, 283, 270, 19));
        this.add(contCSSGroup, new KDLayout.Constraints(986, 283, 270, 19, 0));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 979, 443));        contDescription.setBounds(new Rectangle(350, 133, 270, 19));
        kDPanel1.add(contDescription, new KDLayout.Constraints(350, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsimpleName.setBounds(new Rectangle(12, 272, 270, 19));
        kDPanel1.add(contsimpleName, new KDLayout.Constraints(12, 272, 270, 19, 0));
        contforeignname.setBounds(new Rectangle(326, 295, 270, 19));
        kDPanel1.add(contforeignname, new KDLayout.Constraints(326, 295, 270, 19, 0));
        contmnemonicCode.setBounds(new Rectangle(13, 13, 270, 19));
        kDPanel1.add(contmnemonicCode, new KDLayout.Constraints(13, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contparent.setBounds(new Rectangle(18, 301, 270, 19));
        kDPanel1.add(contparent, new KDLayout.Constraints(18, 301, 270, 19, 0));
        contcustomerKind.setBounds(new Rectangle(350, 13, 270, 19));
        kDPanel1.add(contcustomerKind, new KDLayout.Constraints(350, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbizRegisterNo.setBounds(new Rectangle(659, 302, 270, 19));
        kDPanel1.add(contbizRegisterNo, new KDLayout.Constraints(659, 302, 270, 19, 0));
        contbusiLicence.setBounds(new Rectangle(13, 37, 270, 19));
        kDPanel1.add(contbusiLicence, new KDLayout.Constraints(13, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbusiExequatur.setBounds(new Rectangle(27, 335, 270, 19));
        kDPanel1.add(contbusiExequatur, new KDLayout.Constraints(27, 335, 270, 19, 0));
        contGSPAuthentication.setBounds(new Rectangle(367, 330, 270, 19));
        kDPanel1.add(contGSPAuthentication, new KDLayout.Constraints(367, 330, 270, 19, 0));
        conttaxRegisterNo.setBounds(new Rectangle(687, 37, 270, 19));
        kDPanel1.add(conttaxRegisterNo, new KDLayout.Constraints(687, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contartificialPerson.setBounds(new Rectangle(350, 37, 270, 19));
        kDPanel1.add(contartificialPerson, new KDLayout.Constraints(350, 37, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contindustry.setBounds(new Rectangle(687, 13, 270, 19));
        kDPanel1.add(contindustry, new KDLayout.Constraints(687, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbarcode.setBounds(new Rectangle(653, 279, 270, 19));
        kDPanel1.add(contbarcode, new KDLayout.Constraints(653, 279, 270, 19, 0));
        contcountry.setBounds(new Rectangle(13, 61, 270, 19));
        kDPanel1.add(contcountry, new KDLayout.Constraints(13, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcity.setBounds(new Rectangle(687, 61, 270, 19));
        kDPanel1.add(contcity, new KDLayout.Constraints(687, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contregion.setBounds(new Rectangle(13, 85, 270, 19));
        kDPanel1.add(contregion, new KDLayout.Constraints(13, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaddress.setBounds(new Rectangle(350, 85, 605, 19));
        kDPanel1.add(contaddress, new KDLayout.Constraints(350, 85, 605, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisCredited.setBounds(new Rectangle(13, 109, 140, 19));
        kDPanel1.add(chkisCredited, new KDLayout.Constraints(13, 109, 140, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttaxData.setBounds(new Rectangle(350, 109, 270, 19));
        kDPanel1.add(conttaxData, new KDLayout.Constraints(350, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttaxRate.setBounds(new Rectangle(687, 109, 270, 19));
        kDPanel1.add(conttaxRate, new KDLayout.Constraints(687, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continvoicetype.setBounds(new Rectangle(13, 133, 270, 19));
        kDPanel1.add(continvoicetype, new KDLayout.Constraints(13, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contversion.setBounds(new Rectangle(332, 272, 270, 19));
        kDPanel1.add(contversion, new KDLayout.Constraints(332, 272, 270, 19, 0));
        contlinkManAddress.setBounds(new Rectangle(23, 246, 605, 19));
        kDPanel1.add(contlinkManAddress, new KDLayout.Constraints(23, 246, 605, 19, 0));
        contprovince.setBounds(new Rectangle(350, 61, 270, 19));
        kDPanel1.add(contprovince, new KDLayout.Constraints(350, 61, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmonthSaleQty.setBounds(new Rectangle(13, 158, 270, 19));
        kDPanel1.add(contmonthSaleQty, new KDLayout.Constraints(13, 158, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpinPai.setBounds(new Rectangle(350, 158, 270, 19));
        kDPanel1.add(contpinPai, new KDLayout.Constraints(350, 158, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpinXiang.setBounds(new Rectangle(687, 158, 270, 19));
        kDPanel1.add(contpinXiang, new KDLayout.Constraints(687, 158, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane2.setBounds(new Rectangle(11, 204, 944, 232));
        kDPanel1.add(kDTabbedPane2, new KDLayout.Constraints(11, 204, 944, 232, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcustomerType.setBounds(new Rectangle(687, 133, 270, 19));
        kDPanel1.add(contcustomerType, new KDLayout.Constraints(687, 133, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contsimpleName
        contsimpleName.setBoundEditor(txtsimpleName);
        //contforeignname
        contforeignname.setBoundEditor(txtforeignname);
        //contmnemonicCode
        contmnemonicCode.setBoundEditor(txtmnemonicCode);
        //contparent
        contparent.setBoundEditor(prmtparent);
        //contcustomerKind
        contcustomerKind.setBoundEditor(customerKind);
        //contbizRegisterNo
        contbizRegisterNo.setBoundEditor(txtbizRegisterNo);
        //contbusiLicence
        contbusiLicence.setBoundEditor(txtbusiLicence);
        //contbusiExequatur
        contbusiExequatur.setBoundEditor(txtbusiExequatur);
        //contGSPAuthentication
        contGSPAuthentication.setBoundEditor(txtGSPAuthentication);
        //conttaxRegisterNo
        conttaxRegisterNo.setBoundEditor(txttaxRegisterNo);
        //contartificialPerson
        contartificialPerson.setBoundEditor(txtartificialPerson);
        //contindustry
        contindustry.setBoundEditor(prmtindustry);
        //contbarcode
        contbarcode.setBoundEditor(txtbarcode);
        //contcountry
        contcountry.setBoundEditor(prmtcountry);
        //contcity
        contcity.setBoundEditor(prmtcity);
        //contregion
        contregion.setBoundEditor(prmtregion);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //conttaxData
        conttaxData.setBoundEditor(prmttaxData);
        //conttaxRate
        conttaxRate.setBoundEditor(txttaxRate);
        //continvoicetype
        continvoicetype.setBoundEditor(invoicetype);
        //contversion
        contversion.setBoundEditor(txtversion);
        //contlinkManAddress
        contlinkManAddress.setBoundEditor(txtlinkManAddress);
        //contprovince
        contprovince.setBoundEditor(prmtprovince);
        //contmonthSaleQty
        contmonthSaleQty.setBoundEditor(txtmonthSaleQty);
        //contpinPai
        contpinPai.setBoundEditor(txtpinPai);
        //contpinXiang
        contpinXiang.setBoundEditor(txtpinXiang);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane2.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 943, 199));        kdtCustomerGroupEntry.setBounds(new Rectangle(3, 3, 925, 189));
        kdtCustomerGroupEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCustomerGroupEntry,new com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryInfo(),null,false);
        kDPanel4.add(kdtCustomerGroupEntry_detailPanel, new KDLayout.Constraints(3, 3, 925, 189, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(0, 0, 943, 199));        kdtSettleCustomerEntry.setBounds(new Rectangle(6, 5, 924, 186));
        kdtSettleCustomerEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSettleCustomerEntry,new com.kingdee.eas.bdm.bdapply.CustomerInfoReqSettleCustomerEntryInfo(),null,false);
        kDPanel5.add(kdtSettleCustomerEntry_detailPanel, new KDLayout.Constraints(6, 5, 924, 186, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contcustomerType
        contcustomerType.setBoundEditor(customerType);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 979, 443));        contcompany.setBounds(new Rectangle(13, 12, 270, 19));
        kDPanel2.add(contcompany, new KDLayout.Constraints(13, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpayCondition.setBounds(new Rectangle(14, 103, 270, 19));
        kDPanel2.add(contpayCondition, new KDLayout.Constraints(14, 103, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlementCurrency.setBounds(new Rectangle(683, 8, 270, 19));
        kDPanel2.add(contsettlementCurrency, new KDLayout.Constraints(683, 8, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbank.setBounds(new Rectangle(13, 38, 270, 19));
        kDPanel2.add(contbank, new KDLayout.Constraints(13, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaccountName.setBounds(new Rectangle(13, 64, 270, 19));
        kDPanel2.add(contaccountName, new KDLayout.Constraints(13, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankAccount.setBounds(new Rectangle(348, 38, 270, 19));
        kDPanel2.add(contbankAccount, new KDLayout.Constraints(348, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaccountCurrency.setBounds(new Rectangle(348, 64, 270, 19));
        kDPanel2.add(contaccountCurrency, new KDLayout.Constraints(348, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbankAddress.setBounds(new Rectangle(683, 36, 270, 19));
        kDPanel2.add(contbankAddress, new KDLayout.Constraints(683, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contaccountArea.setBounds(new Rectangle(683, 64, 270, 19));
        kDPanel2.add(contaccountArea, new KDLayout.Constraints(683, 64, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpayType.setBounds(new Rectangle(348, 12, 270, 19));
        kDPanel2.add(contpayType, new KDLayout.Constraints(348, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contpayCondition
        contpayCondition.setBoundEditor(prmtpayCondition);
        //contsettlementCurrency
        contsettlementCurrency.setBoundEditor(prmtsettlementCurrency);
        //contbank
        contbank.setBoundEditor(txtbank);
        //contaccountName
        contaccountName.setBoundEditor(txtaccountName);
        //contbankAccount
        contbankAccount.setBoundEditor(txtbankAccount);
        //contaccountCurrency
        contaccountCurrency.setBoundEditor(txtaccountCurrency);
        //contbankAddress
        contbankAddress.setBoundEditor(txtbankAddress);
        //contaccountArea
        contaccountArea.setBoundEditor(txtaccountArea);
        //contpayType
        contpayType.setBoundEditor(prmtpayType);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 979, 443));        contfax.setBounds(new Rectangle(345, 67, 270, 19));
        kDPanel3.add(contfax, new KDLayout.Constraints(345, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contemail.setBounds(new Rectangle(680, 67, 270, 19));
        kDPanel3.add(contemail, new KDLayout.Constraints(680, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contphone.setBounds(new Rectangle(680, 40, 270, 19));
        kDPanel3.add(contphone, new KDLayout.Constraints(680, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractPersonPost.setBounds(new Rectangle(345, 40, 270, 19));
        kDPanel3.add(contcontractPersonPost, new KDLayout.Constraints(345, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmobile.setBounds(new Rectangle(10, 67, 270, 19));
        kDPanel3.add(contmobile, new KDLayout.Constraints(10, 67, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractPerson.setBounds(new Rectangle(10, 40, 270, 19));
        kDPanel3.add(contcontractPerson, new KDLayout.Constraints(10, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleGroup.setBounds(new Rectangle(680, 13, 270, 19));
        kDPanel3.add(contsaleGroup, new KDLayout.Constraints(680, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSalePerson.setBounds(new Rectangle(345, 13, 270, 19));
        kDPanel3.add(contSalePerson, new KDLayout.Constraints(345, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsaleOrgUnit.setBounds(new Rectangle(10, 13, 270, 19));
        kDPanel3.add(contsaleOrgUnit, new KDLayout.Constraints(10, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsalerAddress.setBounds(new Rectangle(345, 94, 605, 19));
        kDPanel3.add(contsalerAddress, new KDLayout.Constraints(345, 94, 605, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contpostcode.setBounds(new Rectangle(10, 94, 270, 19));
        kDPanel3.add(contpostcode, new KDLayout.Constraints(10, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contfax
        contfax.setBoundEditor(txtfax);
        //contemail
        contemail.setBoundEditor(txtemail);
        //contphone
        contphone.setBoundEditor(txtphone);
        //contcontractPersonPost
        contcontractPersonPost.setBoundEditor(txtcontractPersonPost);
        //contmobile
        contmobile.setBoundEditor(txtmobile);
        //contcontractPerson
        contcontractPerson.setBoundEditor(txtcontractPerson);
        //contsaleGroup
        contsaleGroup.setBoundEditor(prmtsaleGroup);
        //contSalePerson
        contSalePerson.setBoundEditor(prmtSalePerson);
        //contsaleOrgUnit
        contsaleOrgUnit.setBoundEditor(prmtsaleOrgUnit);
        //contsalerAddress
        contsalerAddress.setBoundEditor(txtsalerAddress);
        //contpostcode
        contpostcode.setBoundEditor(txtpostcode);
        //contname
        contname.setBoundEditor(txtname);
        //contcolordisplay
        contcolordisplay.setBoundEditor(txtcolordisplay);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //conterrorMsg
        conterrorMsg.setBoundEditor(scrollPaneerrorMsg);
        //scrollPaneerrorMsg
        scrollPaneerrorMsg.getViewport().add(txterrorMsg, null);
        //contstatus
        contstatus.setBoundEditor(status);
        //contCU
        contCU.setBoundEditor(prmtCU);
        //contCSSGroup
        contCSSGroup.setBoundEditor(prmtCSSGroup);

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
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
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
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
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
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
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
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(CustomerInfoReqAudit);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        menuBiz.add(newMenuItem1);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnPassAudit);
        this.toolBar.add(btnUnPassAudit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
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
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("isCredited", boolean.class, this.chkisCredited, "selected");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("simpleName", String.class, this.txtsimpleName, "text");
		dataBinder.registerBinding("foreignname", String.class, this.txtforeignname, "text");
		dataBinder.registerBinding("mnemonicCode", String.class, this.txtmnemonicCode, "text");
		dataBinder.registerBinding("parent", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtparent, "data");
		dataBinder.registerBinding("customerKind", com.kingdee.eas.basedata.master.cssp.CustomerKindEnum.class, this.customerKind, "selectedItem");
		dataBinder.registerBinding("bizRegisterNo", String.class, this.txtbizRegisterNo, "text");
		dataBinder.registerBinding("busiLicence", String.class, this.txtbusiLicence, "text");
		dataBinder.registerBinding("busiExequatur", String.class, this.txtbusiExequatur, "text");
		dataBinder.registerBinding("GSPAuthentication", String.class, this.txtGSPAuthentication, "text");
		dataBinder.registerBinding("taxRegisterNo", String.class, this.txttaxRegisterNo, "text");
		dataBinder.registerBinding("artificialPerson", String.class, this.txtartificialPerson, "text");
		dataBinder.registerBinding("industry", com.kingdee.eas.basedata.assistant.IndustryInfo.class, this.prmtindustry, "data");
		dataBinder.registerBinding("barcode", String.class, this.txtbarcode, "text");
		dataBinder.registerBinding("country", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtcountry, "data");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.assistant.CityInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("region", com.kingdee.eas.basedata.assistant.RegionInfo.class, this.prmtregion, "data");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("taxData", com.kingdee.eas.basedata.assistant.TaxDataInfo.class, this.prmttaxData, "data");
		dataBinder.registerBinding("taxRate", java.math.BigDecimal.class, this.txttaxRate, "value");
		dataBinder.registerBinding("invoicetype", com.kingdee.eas.basedata.master.cssp.PayInvoiceTypeEnum.class, this.invoicetype, "selectedItem");
		dataBinder.registerBinding("version", int.class, this.txtversion, "value");
		dataBinder.registerBinding("linkManAddress", String.class, this.txtlinkManAddress, "text");
		dataBinder.registerBinding("province", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtprovince, "data");
		dataBinder.registerBinding("monthSaleQty", java.math.BigDecimal.class, this.txtmonthSaleQty, "value");
		dataBinder.registerBinding("pinPai", String.class, this.txtpinPai, "text");
		dataBinder.registerBinding("pinXiang", String.class, this.txtpinXiang, "text");
		dataBinder.registerBinding("CustomerGroupEntry.seq", int.class, this.kdtCustomerGroupEntry, "seq.text");
		dataBinder.registerBinding("CustomerGroupEntry", com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryInfo.class, this.kdtCustomerGroupEntry, "userObject");
		dataBinder.registerBinding("CustomerGroupEntry.customerGroupstd", java.lang.Object.class, this.kdtCustomerGroupEntry, "customerGroupstd.text");
		dataBinder.registerBinding("CustomerGroupEntry.customerGroup", java.lang.Object.class, this.kdtCustomerGroupEntry, "customerGroup.text");
		dataBinder.registerBinding("CustomerGroupEntry.stdName", String.class, this.kdtCustomerGroupEntry, "stdName.text");
		dataBinder.registerBinding("CustomerGroupEntry.groupName", String.class, this.kdtCustomerGroupEntry, "groupName.text");
		dataBinder.registerBinding("CustomerGroupEntry.groupFullName", String.class, this.kdtCustomerGroupEntry, "groupFullName.text");
		dataBinder.registerBinding("SettleCustomerEntry.seq", int.class, this.kdtSettleCustomerEntry, "seq.text");
		dataBinder.registerBinding("SettleCustomerEntry", com.kingdee.eas.bdm.bdapply.CustomerInfoReqSettleCustomerEntryInfo.class, this.kdtSettleCustomerEntry, "userObject");
		dataBinder.registerBinding("SettleCustomerEntry.settleCustomer", java.lang.Object.class, this.kdtSettleCustomerEntry, "settleCustomer.text");
		dataBinder.registerBinding("customerType", com.kingdee.eas.bdm.bdapply.CustomerType.class, this.customerType, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("payCondition", com.kingdee.eas.basedata.assistant.PayConditionInfo.class, this.prmtpayCondition, "data");
		dataBinder.registerBinding("settlementCurrency", com.kingdee.eas.basedata.assistant.CurrencyInfo.class, this.prmtsettlementCurrency, "data");
		dataBinder.registerBinding("bank", String.class, this.txtbank, "text");
		dataBinder.registerBinding("accountName", String.class, this.txtaccountName, "text");
		dataBinder.registerBinding("bankAccount", String.class, this.txtbankAccount, "text");
		dataBinder.registerBinding("accountCurrency", String.class, this.txtaccountCurrency, "text");
		dataBinder.registerBinding("bankAddress", String.class, this.txtbankAddress, "text");
		dataBinder.registerBinding("accountArea", String.class, this.txtaccountArea, "text");
		dataBinder.registerBinding("payType", com.kingdee.eas.basedata.assistant.PaymentTypeInfo.class, this.prmtpayType, "data");
		dataBinder.registerBinding("fax", String.class, this.txtfax, "text");
		dataBinder.registerBinding("email", String.class, this.txtemail, "text");
		dataBinder.registerBinding("phone", String.class, this.txtphone, "text");
		dataBinder.registerBinding("contractPersonPost", String.class, this.txtcontractPersonPost, "text");
		dataBinder.registerBinding("mobile", String.class, this.txtmobile, "text");
		dataBinder.registerBinding("contractPerson", String.class, this.txtcontractPerson, "text");
		dataBinder.registerBinding("saleGroup", com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo.class, this.prmtsaleGroup, "data");
		dataBinder.registerBinding("SalePerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtSalePerson, "data");
		dataBinder.registerBinding("saleOrgUnit", com.kingdee.eas.basedata.org.SaleOrgUnitInfo.class, this.prmtsaleOrgUnit, "data");
		dataBinder.registerBinding("salerAddress", String.class, this.txtsalerAddress, "text");
		dataBinder.registerBinding("postcode", String.class, this.txtpostcode, "text");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("colordisplay", int.class, this.txtcolordisplay, "value");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("errorMsg", String.class, this.txterrorMsg, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.basedata.master.cssp.UsedStatusEnum.class, this.status, "selectedItem");
		dataBinder.registerBinding("CU", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtCU, "data");
		dataBinder.registerBinding("CSSGroup", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtCSSGroup, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.bdm.bdapply.app.CustomerInfoReqEditUIHandler";
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
        this.prmtCU.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo)ov;
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
		getValidateHelper().registerBindProperty("isCredited", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foreignname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mnemonicCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerKind", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizRegisterNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("busiLicence", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("busiExequatur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GSPAuthentication", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxRegisterNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("artificialPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("industry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("barcode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("region", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("invoicetype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("version", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkManAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("monthSaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pinPai", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pinXiang", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.customerGroupstd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.customerGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.stdName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.groupName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CustomerGroupEntry.groupFullName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SettleCustomerEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SettleCustomerEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SettleCustomerEntry.settleCustomer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customerType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payCondition", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAccount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountCurrency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("payType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("email", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("phone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractPersonPost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mobile", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SalePerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saleOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("salerAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("postcode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("colordisplay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("errorMsg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CU", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CSSGroup", ValidateHelper.ON_SAVE);    		
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
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output prmtSalePerson_dataChanged method
     */
    protected void prmtSalePerson_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtCustomerGroupEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtCustomerGroupEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("customerGroup".equalsIgnoreCase(kdtCustomerGroupEntry.getColumn(colIndex).getKey())) {
kdtCustomerGroupEntry.getCell(rowIndex,"groupFullName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCustomerGroupEntry.getCell(rowIndex,"customerGroup").getValue(),"displayName")));

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
        sic.add(new SelectorItemInfo("isCredited"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("foreignname"));
        sic.add(new SelectorItemInfo("mnemonicCode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parent.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parent.id"));
        	sic.add(new SelectorItemInfo("parent.number"));
        	sic.add(new SelectorItemInfo("parent.name"));
		}
        sic.add(new SelectorItemInfo("customerKind"));
        sic.add(new SelectorItemInfo("bizRegisterNo"));
        sic.add(new SelectorItemInfo("busiLicence"));
        sic.add(new SelectorItemInfo("busiExequatur"));
        sic.add(new SelectorItemInfo("GSPAuthentication"));
        sic.add(new SelectorItemInfo("taxRegisterNo"));
        sic.add(new SelectorItemInfo("artificialPerson"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("industry.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("industry.id"));
        	sic.add(new SelectorItemInfo("industry.number"));
        	sic.add(new SelectorItemInfo("industry.name"));
		}
        sic.add(new SelectorItemInfo("barcode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("country.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("country.id"));
        	sic.add(new SelectorItemInfo("country.number"));
        	sic.add(new SelectorItemInfo("country.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("city.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("city.id"));
        	sic.add(new SelectorItemInfo("city.number"));
        	sic.add(new SelectorItemInfo("city.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("region.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("region.id"));
        	sic.add(new SelectorItemInfo("region.number"));
        	sic.add(new SelectorItemInfo("region.name"));
		}
        sic.add(new SelectorItemInfo("address"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("taxData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("taxData.id"));
        	sic.add(new SelectorItemInfo("taxData.number"));
        	sic.add(new SelectorItemInfo("taxData.name"));
        	sic.add(new SelectorItemInfo("taxData.type"));
		}
        sic.add(new SelectorItemInfo("taxRate"));
        sic.add(new SelectorItemInfo("invoicetype"));
        sic.add(new SelectorItemInfo("version"));
        sic.add(new SelectorItemInfo("linkManAddress"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("province.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("province.id"));
        	sic.add(new SelectorItemInfo("province.number"));
        	sic.add(new SelectorItemInfo("province.name"));
		}
        sic.add(new SelectorItemInfo("monthSaleQty"));
        sic.add(new SelectorItemInfo("pinPai"));
        sic.add(new SelectorItemInfo("pinXiang"));
    	sic.add(new SelectorItemInfo("CustomerGroupEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CustomerGroupEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroupstd.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroupstd.id"));
			sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroupstd.name"));
        	sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroupstd.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroup.id"));
			sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroup.name"));
        	sic.add(new SelectorItemInfo("CustomerGroupEntry.customerGroup.number"));
		}
    	sic.add(new SelectorItemInfo("CustomerGroupEntry.stdName"));
    	sic.add(new SelectorItemInfo("CustomerGroupEntry.groupName"));
    	sic.add(new SelectorItemInfo("CustomerGroupEntry.groupFullName"));
    	sic.add(new SelectorItemInfo("SettleCustomerEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SettleCustomerEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SettleCustomerEntry.settleCustomer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SettleCustomerEntry.settleCustomer.id"));
			sic.add(new SelectorItemInfo("SettleCustomerEntry.settleCustomer.name"));
        	sic.add(new SelectorItemInfo("SettleCustomerEntry.settleCustomer.number"));
		}
        sic.add(new SelectorItemInfo("customerType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("payCondition.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("payCondition.id"));
        	sic.add(new SelectorItemInfo("payCondition.number"));
        	sic.add(new SelectorItemInfo("payCondition.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlementCurrency.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlementCurrency.id"));
        	sic.add(new SelectorItemInfo("settlementCurrency.number"));
        	sic.add(new SelectorItemInfo("settlementCurrency.name"));
		}
        sic.add(new SelectorItemInfo("bank"));
        sic.add(new SelectorItemInfo("accountName"));
        sic.add(new SelectorItemInfo("bankAccount"));
        sic.add(new SelectorItemInfo("accountCurrency"));
        sic.add(new SelectorItemInfo("bankAddress"));
        sic.add(new SelectorItemInfo("accountArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("payType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("payType.id"));
        	sic.add(new SelectorItemInfo("payType.number"));
        	sic.add(new SelectorItemInfo("payType.name"));
		}
        sic.add(new SelectorItemInfo("fax"));
        sic.add(new SelectorItemInfo("email"));
        sic.add(new SelectorItemInfo("phone"));
        sic.add(new SelectorItemInfo("contractPersonPost"));
        sic.add(new SelectorItemInfo("mobile"));
        sic.add(new SelectorItemInfo("contractPerson"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleGroup.id"));
        	sic.add(new SelectorItemInfo("saleGroup.number"));
        	sic.add(new SelectorItemInfo("saleGroup.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SalePerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("SalePerson.id"));
        	sic.add(new SelectorItemInfo("SalePerson.number"));
        	sic.add(new SelectorItemInfo("SalePerson.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("saleOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saleOrgUnit.id"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.number"));
        	sic.add(new SelectorItemInfo("saleOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("salerAddress"));
        sic.add(new SelectorItemInfo("postcode"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("colordisplay"));
        sic.add(new SelectorItemInfo("bizDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("errorMsg"));
        sic.add(new SelectorItemInfo("status"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CU.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CU.id"));
        	sic.add(new SelectorItemInfo("CU.number"));
        	sic.add(new SelectorItemInfo("CU.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CSSGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CSSGroup.id"));
        	sic.add(new SelectorItemInfo("CSSGroup.number"));
        	sic.add(new SelectorItemInfo("CSSGroup.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionLocate_actionPerformed method
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }
    	

    /**
     * output actionCustomerInfoReqAudit_actionPerformed method
     */
    public void actionCustomerInfoReqAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.CustomerInfoReqFactory.getRemoteInstance().customerInfoReqAudit(editData);
    }
    	

    /**
     * output actionNotby_actionPerformed method
     */
    public void actionNotby_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.CustomerInfoReqFactory.getRemoteInstance().notby(editData);
    }
    	

    /**
     * output actionAllAudit_actionPerformed method
     */
    public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.CustomerInfoReqFactory.getRemoteInstance().allAudit(editData);
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }
	public RequestContext prepareactionLocate(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareactionLocate(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareactionLocate() {
    	return false;
    }
	public RequestContext prepareActionCustomerInfoReqAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionCustomerInfoReqAudit() {
    	return false;
    }
	public RequestContext prepareActionNotby(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionNotby() {
    	return false;
    }
	public RequestContext prepareActionAllAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAllAudit() {
    	return false;
    }

    /**
     * output ActionCustomerInfoReqAudit class
     */     
    protected class ActionCustomerInfoReqAudit extends ItemAction {     
    
        public ActionCustomerInfoReqAudit()
        {
            this(null);
        }

        public ActionCustomerInfoReqAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionCustomerInfoReqAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCustomerInfoReqAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionCustomerInfoReqAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCustomerInfoReqEditUI.this, "ActionCustomerInfoReqAudit", "actionCustomerInfoReqAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionNotby class
     */     
    protected class ActionNotby extends ItemAction {     
    
        public ActionNotby()
        {
            this(null);
        }

        public ActionNotby(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionNotby.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionNotby.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionNotby.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCustomerInfoReqEditUI.this, "ActionNotby", "actionNotby_actionPerformed", e);
        }
    }

    /**
     * output ActionAllAudit class
     */     
    protected class ActionAllAudit extends ItemAction {     
    
        public ActionAllAudit()
        {
            this(null);
        }

        public ActionAllAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAllAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAllAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAllAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCustomerInfoReqEditUI.this, "ActionAllAudit", "actionAllAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.bdm.bdapply.client", "CustomerInfoReqEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.bdm.bdapply.client.CustomerInfoReqEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.bdm.bdapply.CustomerInfoReqFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/bdm/bdapply/CustomerInfoReq";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.bdm.bdapply.app.CustomerInfoReqQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmnemonicCode.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"助记码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttaxRegisterNo.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"税务登记号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcountry.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"国家"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcity.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"城市"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtaddress.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"地址"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtprovince.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"省份"});
		}
		for (int i=0,n=kdtSettleCustomerEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSettleCustomerEntry.getCell(i,"settleCustomer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结账客户"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"申请公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsettlementCurrency.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算币种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmobile.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"手机"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtcontractPerson.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"联系人"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtSalePerson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsaleOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtname.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtCustomerGroupEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("customerKind","-1");
vo.put("invoicetype","-1");
vo.put("customerType","1");
vo.put("billStatus","0");
vo.put("status",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}