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
public abstract class AbstractSupplierReqEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSupplierReqEditUI.class);
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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contuserstated;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCU;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsimplename;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforeignName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmnemonicCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparent;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbusiExequatur;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGSPAuthentication;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contartificialPerson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindustry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbarcode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcountry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contregion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvesion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCSSGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovince;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurInOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkMan;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlinkCell;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsimplename;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtforeignName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmnemonicCode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparent;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttaxRegisterNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbusiExequatur;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtGSPAuthentication;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtartificialPerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtindustry;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbarcode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcountry;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcity;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtregion;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtvesion;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttaxData;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttaxRate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCSSGroup;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaccountNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtprovince;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurInOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBEBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkMan;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtlinkCell;
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
    protected com.kingdee.bos.ctrl.swing.KDComboBox userstated;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCU;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem basenotby;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem supplieraduit;
    protected com.kingdee.eas.bdm.bdapply.SupplierReqInfo editData = null;
    protected ActionSupplierAudit actionSupplierAudit = null;
    protected ActionBasenotby actionBasenotby = null;
    protected ActionAllAudit actionAllAudit = null;
    /**
     * output class constructor
     */
    public AbstractSupplierReqEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSupplierReqEditUI.class.getName());
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
        //actionSupplierAudit
        this.actionSupplierAudit = new ActionSupplierAudit(this);
        getActionManager().registerAction("actionSupplierAudit", actionSupplierAudit);
        this.actionSupplierAudit.setExtendProperty("canForewarn", "true");
        this.actionSupplierAudit.setExtendProperty("userDefined", "true");
        this.actionSupplierAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionSupplierAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSupplierAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionBasenotby
        this.actionBasenotby = new ActionBasenotby(this);
        getActionManager().registerAction("actionBasenotby", actionBasenotby);
        this.actionBasenotby.setExtendProperty("canForewarn", "true");
        this.actionBasenotby.setExtendProperty("userDefined", "true");
        this.actionBasenotby.setExtendProperty("isObjectUpdateLock", "false");
         this.actionBasenotby.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionBasenotby.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.contuserstated = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCU = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsimplename = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforeignName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmnemonicCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxRegisterNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbusiExequatur = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGSPAuthentication = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contartificialPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindustry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbarcode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcountry = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contregion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvesion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttaxRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCSSGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovince = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurInOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkMan = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlinkCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsimplename = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtforeignName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmnemonicCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtparent = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttaxRegisterNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbusiExequatur = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtGSPAuthentication = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtartificialPerson = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtindustry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbarcode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcountry = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcity = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtregion = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtvesion = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmttaxData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttaxRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtCSSGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbank = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaccountNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtprovince = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpurInOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtlinkMan = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtlinkCell = new com.kingdee.bos.ctrl.swing.KDTextField();
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
        this.userstated = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCU = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.basenotby = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.supplieraduit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
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
        this.contuserstated.setName("contuserstated");
        this.contCU.setName("contCU");
        this.txtNumber.setName("txtNumber");
        this.kDPanel2.setName("kDPanel2");
        this.contDescription.setName("contDescription");
        this.contsimplename.setName("contsimplename");
        this.contforeignName.setName("contforeignName");
        this.contmnemonicCode.setName("contmnemonicCode");
        this.contparent.setName("contparent");
        this.conttaxRegisterNo.setName("conttaxRegisterNo");
        this.contbusiExequatur.setName("contbusiExequatur");
        this.contGSPAuthentication.setName("contGSPAuthentication");
        this.contartificialPerson.setName("contartificialPerson");
        this.contindustry.setName("contindustry");
        this.contbarcode.setName("contbarcode");
        this.contcountry.setName("contcountry");
        this.contcity.setName("contcity");
        this.contregion.setName("contregion");
        this.contaddress.setName("contaddress");
        this.contvesion.setName("contvesion");
        this.conttaxData.setName("conttaxData");
        this.conttaxRate.setName("conttaxRate");
        this.contCSSGroup.setName("contCSSGroup");
        this.contbank.setName("contbank");
        this.contaccountNum.setName("contaccountNum");
        this.contprovince.setName("contprovince");
        this.contpurInOrgUnit.setName("contpurInOrgUnit");
        this.contcompany.setName("contcompany");
        this.contBEBank.setName("contBEBank");
        this.contlinkMan.setName("contlinkMan");
        this.contlinkCell.setName("contlinkCell");
        this.txtDescription.setName("txtDescription");
        this.txtsimplename.setName("txtsimplename");
        this.txtforeignName.setName("txtforeignName");
        this.txtmnemonicCode.setName("txtmnemonicCode");
        this.prmtparent.setName("prmtparent");
        this.txttaxRegisterNo.setName("txttaxRegisterNo");
        this.txtbusiExequatur.setName("txtbusiExequatur");
        this.txtGSPAuthentication.setName("txtGSPAuthentication");
        this.txtartificialPerson.setName("txtartificialPerson");
        this.prmtindustry.setName("prmtindustry");
        this.txtbarcode.setName("txtbarcode");
        this.prmtcountry.setName("prmtcountry");
        this.prmtcity.setName("prmtcity");
        this.prmtregion.setName("prmtregion");
        this.txtaddress.setName("txtaddress");
        this.txtvesion.setName("txtvesion");
        this.prmttaxData.setName("prmttaxData");
        this.txttaxRate.setName("txttaxRate");
        this.prmtCSSGroup.setName("prmtCSSGroup");
        this.txtbank.setName("txtbank");
        this.txtaccountNum.setName("txtaccountNum");
        this.prmtprovince.setName("prmtprovince");
        this.prmtpurInOrgUnit.setName("prmtpurInOrgUnit");
        this.prmtcompany.setName("prmtcompany");
        this.prmtBEBank.setName("prmtBEBank");
        this.txtlinkMan.setName("txtlinkMan");
        this.txtlinkCell.setName("txtlinkCell");
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
        this.userstated.setName("userstated");
        this.prmtCU.setName("prmtCU");
        this.btnPassAudit.setName("btnPassAudit");
        this.btnUnPassAudit.setName("btnUnPassAudit");
        this.basenotby.setName("basenotby");
        this.supplieraduit.setName("supplieraduit");
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
        // contuserstated		
        this.contuserstated.setBoundLabelText(resHelper.getString("contuserstated.boundLabelText"));		
        this.contuserstated.setBoundLabelLength(100);		
        this.contuserstated.setBoundLabelUnderline(true);		
        this.contuserstated.setVisible(true);
        // contCU		
        this.contCU.setBoundLabelText(resHelper.getString("contCU.boundLabelText"));		
        this.contCU.setBoundLabelLength(100);		
        this.contCU.setBoundLabelUnderline(true);		
        this.contCU.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // kDPanel2
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contsimplename		
        this.contsimplename.setBoundLabelText(resHelper.getString("contsimplename.boundLabelText"));		
        this.contsimplename.setBoundLabelLength(100);		
        this.contsimplename.setBoundLabelUnderline(true);		
        this.contsimplename.setVisible(true);
        // contforeignName		
        this.contforeignName.setBoundLabelText(resHelper.getString("contforeignName.boundLabelText"));		
        this.contforeignName.setBoundLabelLength(100);		
        this.contforeignName.setBoundLabelUnderline(true);		
        this.contforeignName.setVisible(true);
        // contmnemonicCode		
        this.contmnemonicCode.setBoundLabelText(resHelper.getString("contmnemonicCode.boundLabelText"));		
        this.contmnemonicCode.setBoundLabelLength(100);		
        this.contmnemonicCode.setBoundLabelUnderline(true);		
        this.contmnemonicCode.setVisible(true);
        // contparent		
        this.contparent.setBoundLabelText(resHelper.getString("contparent.boundLabelText"));		
        this.contparent.setBoundLabelLength(100);		
        this.contparent.setBoundLabelUnderline(true);		
        this.contparent.setVisible(true);
        // conttaxRegisterNo		
        this.conttaxRegisterNo.setBoundLabelText(resHelper.getString("conttaxRegisterNo.boundLabelText"));		
        this.conttaxRegisterNo.setBoundLabelLength(100);		
        this.conttaxRegisterNo.setBoundLabelUnderline(true);		
        this.conttaxRegisterNo.setVisible(true);
        // contbusiExequatur		
        this.contbusiExequatur.setBoundLabelText(resHelper.getString("contbusiExequatur.boundLabelText"));		
        this.contbusiExequatur.setBoundLabelLength(100);		
        this.contbusiExequatur.setBoundLabelUnderline(true);		
        this.contbusiExequatur.setVisible(true);
        // contGSPAuthentication		
        this.contGSPAuthentication.setBoundLabelText(resHelper.getString("contGSPAuthentication.boundLabelText"));		
        this.contGSPAuthentication.setBoundLabelLength(100);		
        this.contGSPAuthentication.setBoundLabelUnderline(true);		
        this.contGSPAuthentication.setVisible(true);
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
        this.contbarcode.setVisible(true);
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
        // contvesion		
        this.contvesion.setBoundLabelText(resHelper.getString("contvesion.boundLabelText"));		
        this.contvesion.setBoundLabelLength(100);		
        this.contvesion.setBoundLabelUnderline(true);		
        this.contvesion.setVisible(true);
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
        // contCSSGroup		
        this.contCSSGroup.setBoundLabelText(resHelper.getString("contCSSGroup.boundLabelText"));		
        this.contCSSGroup.setBoundLabelLength(100);		
        this.contCSSGroup.setBoundLabelUnderline(true);		
        this.contCSSGroup.setVisible(true);
        // contbank		
        this.contbank.setBoundLabelText(resHelper.getString("contbank.boundLabelText"));		
        this.contbank.setBoundLabelLength(100);		
        this.contbank.setBoundLabelUnderline(true);		
        this.contbank.setVisible(false);
        // contaccountNum		
        this.contaccountNum.setBoundLabelText(resHelper.getString("contaccountNum.boundLabelText"));		
        this.contaccountNum.setBoundLabelLength(100);		
        this.contaccountNum.setBoundLabelUnderline(true);
        // contprovince		
        this.contprovince.setBoundLabelText(resHelper.getString("contprovince.boundLabelText"));		
        this.contprovince.setBoundLabelLength(100);		
        this.contprovince.setBoundLabelUnderline(true);		
        this.contprovince.setVisible(true);
        // contpurInOrgUnit		
        this.contpurInOrgUnit.setBoundLabelText(resHelper.getString("contpurInOrgUnit.boundLabelText"));		
        this.contpurInOrgUnit.setBoundLabelLength(100);		
        this.contpurInOrgUnit.setBoundLabelUnderline(true);		
        this.contpurInOrgUnit.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contBEBank		
        this.contBEBank.setBoundLabelText(resHelper.getString("contBEBank.boundLabelText"));		
        this.contBEBank.setBoundLabelLength(100);		
        this.contBEBank.setBoundLabelUnderline(true);		
        this.contBEBank.setVisible(true);
        // contlinkMan		
        this.contlinkMan.setBoundLabelText(resHelper.getString("contlinkMan.boundLabelText"));		
        this.contlinkMan.setBoundLabelLength(100);		
        this.contlinkMan.setBoundLabelUnderline(true);		
        this.contlinkMan.setVisible(true);
        // contlinkCell		
        this.contlinkCell.setBoundLabelText(resHelper.getString("contlinkCell.boundLabelText"));		
        this.contlinkCell.setBoundLabelLength(100);		
        this.contlinkCell.setBoundLabelUnderline(true);		
        this.contlinkCell.setVisible(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // txtsimplename		
        this.txtsimplename.setHorizontalAlignment(2);		
        this.txtsimplename.setMaxLength(100);		
        this.txtsimplename.setRequired(false);
        // txtforeignName		
        this.txtforeignName.setHorizontalAlignment(2);		
        this.txtforeignName.setMaxLength(100);		
        this.txtforeignName.setRequired(false);
        // txtmnemonicCode		
        this.txtmnemonicCode.setHorizontalAlignment(2);		
        this.txtmnemonicCode.setMaxLength(100);		
        this.txtmnemonicCode.setRequired(true);
        // prmtparent		
        this.prmtparent.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtparent.setEditable(true);		
        this.prmtparent.setDisplayFormat("$artificialPerson$");		
        this.prmtparent.setEditFormat("$number$");		
        this.prmtparent.setCommitFormat("$number$");		
        this.prmtparent.setRequired(false);
        // txttaxRegisterNo		
        this.txttaxRegisterNo.setHorizontalAlignment(2);		
        this.txttaxRegisterNo.setMaxLength(100);		
        this.txttaxRegisterNo.setRequired(true);
        // txtbusiExequatur		
        this.txtbusiExequatur.setHorizontalAlignment(2);		
        this.txtbusiExequatur.setMaxLength(100);		
        this.txtbusiExequatur.setRequired(false);
        // txtGSPAuthentication		
        this.txtGSPAuthentication.setHorizontalAlignment(2);		
        this.txtGSPAuthentication.setMaxLength(100);		
        this.txtGSPAuthentication.setRequired(false);
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
        this.prmtcity.setDisplayFormat("$cityNumber$");		
        this.prmtcity.setEditFormat("$number$");		
        this.prmtcity.setCommitFormat("$number$");		
        this.prmtcity.setRequired(true);
        // prmtregion		
        this.prmtregion.setQueryInfo("com.kingdee.eas.basedata.assistant.app.RegionQuery");		
        this.prmtregion.setEditable(true);		
        this.prmtregion.setDisplayFormat("$deletedStatus$");		
        this.prmtregion.setEditFormat("$number$");		
        this.prmtregion.setCommitFormat("$number$");		
        this.prmtregion.setRequired(false);
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(100);		
        this.txtaddress.setRequired(true);
        // txtvesion		
        this.txtvesion.setHorizontalAlignment(2);		
        this.txtvesion.setMaxLength(100);		
        this.txtvesion.setRequired(false);
        // prmttaxData		
        this.prmttaxData.setQueryInfo("com.kingdee.eas.basedata.assistant.app.TaxDataQuery");		
        this.prmttaxData.setEditable(true);		
        this.prmttaxData.setDisplayFormat("$name$");		
        this.prmttaxData.setEditFormat("$number$");		
        this.prmttaxData.setCommitFormat("$number$");		
        this.prmttaxData.setRequired(false);
        // txttaxRate		
        this.txttaxRate.setHorizontalAlignment(2);		
        this.txttaxRate.setDataType(1);		
        this.txttaxRate.setSupportedEmpty(true);		
        this.txttaxRate.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txttaxRate.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txttaxRate.setPrecision(10);		
        this.txttaxRate.setRequired(false);
        // prmtCSSGroup		
        this.prmtCSSGroup.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierGroupQuery");		
        this.prmtCSSGroup.setVisible(true);		
        this.prmtCSSGroup.setEditable(true);		
        this.prmtCSSGroup.setDisplayFormat("$name$");		
        this.prmtCSSGroup.setEditFormat("$number$");		
        this.prmtCSSGroup.setCommitFormat("$number$");		
        this.prmtCSSGroup.setRequired(true);
        // txtbank		
        this.txtbank.setVisible(true);		
        this.txtbank.setHorizontalAlignment(2);		
        this.txtbank.setMaxLength(200);		
        this.txtbank.setRequired(false);
        // txtaccountNum		
        this.txtaccountNum.setVisible(true);		
        this.txtaccountNum.setHorizontalAlignment(2);		
        this.txtaccountNum.setMaxLength(100);		
        this.txtaccountNum.setRequired(true);
        // prmtprovince		
        this.prmtprovince.setQueryInfo("com.kingdee.eas.basedata.assistant.app.ProvinceQuery");		
        this.prmtprovince.setVisible(true);		
        this.prmtprovince.setEditable(true);		
        this.prmtprovince.setDisplayFormat("$name$");		
        this.prmtprovince.setEditFormat("$number$");		
        this.prmtprovince.setCommitFormat("$number$");		
        this.prmtprovince.setRequired(true);
        // prmtpurInOrgUnit		
        this.prmtpurInOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.PurchaseItemQuery");		
        this.prmtpurInOrgUnit.setVisible(true);		
        this.prmtpurInOrgUnit.setEditable(true);		
        this.prmtpurInOrgUnit.setDisplayFormat("$name$");		
        this.prmtpurInOrgUnit.setEditFormat("$number$");		
        this.prmtpurInOrgUnit.setCommitFormat("$number$");		
        this.prmtpurInOrgUnit.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtBEBank		
        this.prmtBEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtBEBank.setVisible(true);		
        this.prmtBEBank.setEditable(true);		
        this.prmtBEBank.setDisplayFormat("$name$");		
        this.prmtBEBank.setEditFormat("$number$");		
        this.prmtBEBank.setCommitFormat("$number$");		
        this.prmtBEBank.setRequired(false);
        // txtlinkMan		
        this.txtlinkMan.setVisible(true);		
        this.txtlinkMan.setHorizontalAlignment(2);		
        this.txtlinkMan.setMaxLength(100);		
        this.txtlinkMan.setRequired(false);
        // txtlinkCell		
        this.txtlinkCell.setVisible(true);		
        this.txtlinkCell.setHorizontalAlignment(2);		
        this.txtlinkCell.setMaxLength(100);		
        this.txtlinkCell.setRequired(false);
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
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setTimeEnabled(true);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // scrollPaneerrorMsg
        // txterrorMsg		
        this.txterrorMsg.setVisible(true);		
        this.txterrorMsg.setRequired(false);		
        this.txterrorMsg.setMaxLength(500);		
        this.txterrorMsg.setEnabled(false);
        // userstated		
        this.userstated.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.master.cssp.UsedStatusEnum").toArray());		
        this.userstated.setRequired(false);		
        this.userstated.setEnabled(false);
        // prmtCU		
        this.prmtCU.setVisible(true);		
        this.prmtCU.setEditable(true);		
        this.prmtCU.setDisplayFormat("$name$");		
        this.prmtCU.setEditFormat("$number$");		
        this.prmtCU.setCommitFormat("$number$");		
        this.prmtCU.setRequired(false);		
        this.prmtCU.setEnabled(false);
        // btnPassAudit
        this.btnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionSupplierAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPassAudit.setText(resHelper.getString("btnPassAudit.text"));
        // btnUnPassAudit
        this.btnUnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBasenotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnPassAudit.setText(resHelper.getString("btnUnPassAudit.text"));
        // basenotby
        this.basenotby.setAction((IItemAction)ActionProxyFactory.getProxy(actionBasenotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.basenotby.setText(resHelper.getString("basenotby.text"));
        // supplieraduit
        this.supplieraduit.setAction((IItemAction)ActionProxyFactory.getProxy(actionSupplierAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.supplieraduit.setText(resHelper.getString("supplieraduit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,txtname,txtsimplename,txtforeignName,txtmnemonicCode,prmtparent,txtbusiExequatur,txttaxRegisterNo,prmttaxData,txttaxRate,txtGSPAuthentication,txtartificialPerson,prmtindustry,txtbarcode,prmtcountry,prmtcity,prmtregion,txtaddress,userstated,txtvesion,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtcolordisplay,billStatus,txterrorMsg,prmtCSSGroup,txtbank,txtaccountNum,prmtprovince,prmtcompany,prmtpurInOrgUnit,prmtBEBank,txtlinkMan,txtlinkCell}));
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
        contNumber.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(10, 148, 980, 392));
        this.add(kDTabbedPane1, new KDLayout.Constraints(10, 148, 980, 392, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contname.setBounds(new Rectangle(340, 10, 600, 19));
        this.add(contname, new KDLayout.Constraints(340, 10, 600, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcolordisplay.setBounds(new Rectangle(547, 157, 270, 19));
        this.add(contcolordisplay, new KDLayout.Constraints(547, 157, 270, 19, 0));
        contBizDate.setBounds(new Rectangle(340, 48, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(340, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(10, 560, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreator.setBounds(new Rectangle(340, 560, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(340, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(340, 590, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(340, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(680, 560, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(680, 560, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(680, 590, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(680, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbillStatus.setBounds(new Rectangle(10, 48, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(10, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conterrorMsg.setBounds(new Rectangle(10, 87, 936, 35));
        this.add(conterrorMsg, new KDLayout.Constraints(10, 87, 936, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contuserstated.setBounds(new Rectangle(670, 48, 270, 19));
        this.add(contuserstated, new KDLayout.Constraints(670, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCU.setBounds(new Rectangle(10, 590, 270, 19));
        this.add(contCU, new KDLayout.Constraints(10, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 979, 359));        contDescription.setBounds(new Rectangle(340, 192, 270, 19));
        kDPanel2.add(contDescription, new KDLayout.Constraints(340, 192, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsimplename.setBounds(new Rectangle(10, 10, 270, 19));
        kDPanel2.add(contsimplename, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contforeignName.setBounds(new Rectangle(340, 10, 270, 19));
        kDPanel2.add(contforeignName, new KDLayout.Constraints(340, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmnemonicCode.setBounds(new Rectangle(680, 10, 270, 19));
        kDPanel2.add(contmnemonicCode, new KDLayout.Constraints(680, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contparent.setBounds(new Rectangle(10, 36, 270, 19));
        kDPanel2.add(contparent, new KDLayout.Constraints(10, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttaxRegisterNo.setBounds(new Rectangle(10, 62, 270, 19));
        kDPanel2.add(conttaxRegisterNo, new KDLayout.Constraints(10, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbusiExequatur.setBounds(new Rectangle(340, 36, 270, 19));
        kDPanel2.add(contbusiExequatur, new KDLayout.Constraints(340, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGSPAuthentication.setBounds(new Rectangle(680, 88, 270, 19));
        kDPanel2.add(contGSPAuthentication, new KDLayout.Constraints(680, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contartificialPerson.setBounds(new Rectangle(680, 36, 270, 19));
        kDPanel2.add(contartificialPerson, new KDLayout.Constraints(680, 36, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contindustry.setBounds(new Rectangle(10, 114, 270, 19));
        kDPanel2.add(contindustry, new KDLayout.Constraints(10, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbarcode.setBounds(new Rectangle(340, 114, 270, 19));
        kDPanel2.add(contbarcode, new KDLayout.Constraints(340, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcountry.setBounds(new Rectangle(680, 114, 270, 19));
        kDPanel2.add(contcountry, new KDLayout.Constraints(680, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcity.setBounds(new Rectangle(340, 140, 270, 19));
        kDPanel2.add(contcity, new KDLayout.Constraints(340, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contregion.setBounds(new Rectangle(680, 140, 270, 19));
        kDPanel2.add(contregion, new KDLayout.Constraints(680, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contaddress.setBounds(new Rectangle(10, 166, 602, 19));
        kDPanel2.add(contaddress, new KDLayout.Constraints(10, 166, 602, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvesion.setBounds(new Rectangle(680, 166, 270, 19));
        kDPanel2.add(contvesion, new KDLayout.Constraints(680, 166, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttaxData.setBounds(new Rectangle(10, 88, 270, 19));
        kDPanel2.add(conttaxData, new KDLayout.Constraints(10, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttaxRate.setBounds(new Rectangle(340, 88, 270, 19));
        kDPanel2.add(conttaxRate, new KDLayout.Constraints(340, 88, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCSSGroup.setBounds(new Rectangle(10, 192, 270, 19));
        kDPanel2.add(contCSSGroup, new KDLayout.Constraints(10, 192, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbank.setBounds(new Rectangle(9, 271, 603, 19));
        kDPanel2.add(contbank, new KDLayout.Constraints(9, 271, 603, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contaccountNum.setBounds(new Rectangle(10, 244, 605, 19));
        kDPanel2.add(contaccountNum, new KDLayout.Constraints(10, 244, 605, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprovince.setBounds(new Rectangle(10, 140, 270, 19));
        kDPanel2.add(contprovince, new KDLayout.Constraints(10, 140, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurInOrgUnit.setBounds(new Rectangle(680, 218, 270, 19));
        kDPanel2.add(contpurInOrgUnit, new KDLayout.Constraints(680, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(680, 192, 270, 19));
        kDPanel2.add(contcompany, new KDLayout.Constraints(680, 192, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBEBank.setBounds(new Rectangle(10, 218, 270, 19));
        kDPanel2.add(contBEBank, new KDLayout.Constraints(10, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlinkMan.setBounds(new Rectangle(340, 62, 270, 19));
        kDPanel2.add(contlinkMan, new KDLayout.Constraints(340, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contlinkCell.setBounds(new Rectangle(680, 62, 270, 19));
        kDPanel2.add(contlinkCell, new KDLayout.Constraints(680, 62, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contsimplename
        contsimplename.setBoundEditor(txtsimplename);
        //contforeignName
        contforeignName.setBoundEditor(txtforeignName);
        //contmnemonicCode
        contmnemonicCode.setBoundEditor(txtmnemonicCode);
        //contparent
        contparent.setBoundEditor(prmtparent);
        //conttaxRegisterNo
        conttaxRegisterNo.setBoundEditor(txttaxRegisterNo);
        //contbusiExequatur
        contbusiExequatur.setBoundEditor(txtbusiExequatur);
        //contGSPAuthentication
        contGSPAuthentication.setBoundEditor(txtGSPAuthentication);
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
        //contvesion
        contvesion.setBoundEditor(txtvesion);
        //conttaxData
        conttaxData.setBoundEditor(prmttaxData);
        //conttaxRate
        conttaxRate.setBoundEditor(txttaxRate);
        //contCSSGroup
        contCSSGroup.setBoundEditor(prmtCSSGroup);
        //contbank
        contbank.setBoundEditor(txtbank);
        //contaccountNum
        contaccountNum.setBoundEditor(txtaccountNum);
        //contprovince
        contprovince.setBoundEditor(prmtprovince);
        //contpurInOrgUnit
        contpurInOrgUnit.setBoundEditor(prmtpurInOrgUnit);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contBEBank
        contBEBank.setBoundEditor(prmtBEBank);
        //contlinkMan
        contlinkMan.setBoundEditor(txtlinkMan);
        //contlinkCell
        contlinkCell.setBoundEditor(txtlinkCell);
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
        //contuserstated
        contuserstated.setBoundEditor(userstated);
        //contCU
        contCU.setBoundEditor(prmtCU);

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
        menuBiz.add(basenotby);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(supplieraduit);
        menuBiz.add(menuItemDelPCVoucher);
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
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("simplename", String.class, this.txtsimplename, "text");
		dataBinder.registerBinding("foreignName", String.class, this.txtforeignName, "text");
		dataBinder.registerBinding("mnemonicCode", String.class, this.txtmnemonicCode, "text");
		dataBinder.registerBinding("parent", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtparent, "data");
		dataBinder.registerBinding("taxRegisterNo", String.class, this.txttaxRegisterNo, "text");
		dataBinder.registerBinding("busiExequatur", String.class, this.txtbusiExequatur, "text");
		dataBinder.registerBinding("GSPAuthentication", String.class, this.txtGSPAuthentication, "text");
		dataBinder.registerBinding("artificialPerson", String.class, this.txtartificialPerson, "text");
		dataBinder.registerBinding("industry", com.kingdee.eas.basedata.assistant.IndustryInfo.class, this.prmtindustry, "data");
		dataBinder.registerBinding("barcode", String.class, this.txtbarcode, "text");
		dataBinder.registerBinding("country", com.kingdee.eas.basedata.assistant.CountryInfo.class, this.prmtcountry, "data");
		dataBinder.registerBinding("city", com.kingdee.eas.basedata.assistant.CityInfo.class, this.prmtcity, "data");
		dataBinder.registerBinding("region", com.kingdee.eas.basedata.assistant.RegionInfo.class, this.prmtregion, "data");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("vesion", String.class, this.txtvesion, "text");
		dataBinder.registerBinding("taxData", com.kingdee.eas.basedata.assistant.TaxDataInfo.class, this.prmttaxData, "data");
		dataBinder.registerBinding("taxRate", java.math.BigDecimal.class, this.txttaxRate, "value");
		dataBinder.registerBinding("CSSGroup", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtCSSGroup, "data");
		dataBinder.registerBinding("bank", String.class, this.txtbank, "text");
		dataBinder.registerBinding("accountNum", String.class, this.txtaccountNum, "text");
		dataBinder.registerBinding("province", com.kingdee.eas.basedata.assistant.ProvinceInfo.class, this.prmtprovince, "data");
		dataBinder.registerBinding("purInOrgUnit", com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo.class, this.prmtpurInOrgUnit, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("BEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtBEBank, "data");
		dataBinder.registerBinding("linkMan", String.class, this.txtlinkMan, "text");
		dataBinder.registerBinding("linkCell", String.class, this.txtlinkCell, "text");
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
		dataBinder.registerBinding("userstated", com.kingdee.eas.basedata.master.cssp.UsedStatusEnum.class, this.userstated, "selectedItem");
		dataBinder.registerBinding("CU", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtCU, "data");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.bdm.bdapply.app.SupplierReqEditUIHandler";
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
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.bdm.bdapply.SupplierReqInfo)ov;
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
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simplename", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foreignName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mnemonicCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxRegisterNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("busiExequatur", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GSPAuthentication", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("artificialPerson", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("industry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("barcode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("country", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("city", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("region", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vesion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CSSGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("province", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purInOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkMan", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("linkCell", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("userstated", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CU", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("simplename"));
        sic.add(new SelectorItemInfo("foreignName"));
        sic.add(new SelectorItemInfo("mnemonicCode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parent.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parent.id"));
        	sic.add(new SelectorItemInfo("parent.number"));
        	sic.add(new SelectorItemInfo("parent.name"));
        	sic.add(new SelectorItemInfo("parent.artificialPerson"));
		}
        sic.add(new SelectorItemInfo("taxRegisterNo"));
        sic.add(new SelectorItemInfo("busiExequatur"));
        sic.add(new SelectorItemInfo("GSPAuthentication"));
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
        	sic.add(new SelectorItemInfo("city.cityNumber"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("region.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("region.id"));
        	sic.add(new SelectorItemInfo("region.number"));
        	sic.add(new SelectorItemInfo("region.name"));
        	sic.add(new SelectorItemInfo("region.deletedStatus"));
		}
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("vesion"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("taxData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("taxData.id"));
        	sic.add(new SelectorItemInfo("taxData.number"));
        	sic.add(new SelectorItemInfo("taxData.name"));
		}
        sic.add(new SelectorItemInfo("taxRate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CSSGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CSSGroup.id"));
        	sic.add(new SelectorItemInfo("CSSGroup.number"));
        	sic.add(new SelectorItemInfo("CSSGroup.name"));
		}
        sic.add(new SelectorItemInfo("bank"));
        sic.add(new SelectorItemInfo("accountNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("province.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("province.id"));
        	sic.add(new SelectorItemInfo("province.number"));
        	sic.add(new SelectorItemInfo("province.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purInOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purInOrgUnit.id"));
        	sic.add(new SelectorItemInfo("purInOrgUnit.number"));
        	sic.add(new SelectorItemInfo("purInOrgUnit.name"));
		}
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
			sic.add(new SelectorItemInfo("BEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BEBank.id"));
        	sic.add(new SelectorItemInfo("BEBank.number"));
        	sic.add(new SelectorItemInfo("BEBank.name"));
		}
        sic.add(new SelectorItemInfo("linkMan"));
        sic.add(new SelectorItemInfo("linkCell"));
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
        sic.add(new SelectorItemInfo("userstated"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CU.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CU.id"));
        	sic.add(new SelectorItemInfo("CU.number"));
        	sic.add(new SelectorItemInfo("CU.name"));
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
     * output actionSupplierAudit_actionPerformed method
     */
    public void actionSupplierAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.SupplierReqFactory.getRemoteInstance().supplierAudit(editData);
    }
    	

    /**
     * output actionBasenotby_actionPerformed method
     */
    public void actionBasenotby_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.SupplierReqFactory.getRemoteInstance().basenotby(editData);
    }
    	

    /**
     * output actionAllAudit_actionPerformed method
     */
    public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.SupplierReqFactory.getRemoteInstance().allAudit(editData);
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
	public RequestContext prepareActionSupplierAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSupplierAudit() {
    	return false;
    }
	public RequestContext prepareActionBasenotby(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionBasenotby() {
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
     * output ActionSupplierAudit class
     */     
    protected class ActionSupplierAudit extends ItemAction {     
    
        public ActionSupplierAudit()
        {
            this(null);
        }

        public ActionSupplierAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionSupplierAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSupplierAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionSupplierAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSupplierReqEditUI.this, "ActionSupplierAudit", "actionSupplierAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionBasenotby class
     */     
    protected class ActionBasenotby extends ItemAction {     
    
        public ActionBasenotby()
        {
            this(null);
        }

        public ActionBasenotby(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionBasenotby.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBasenotby.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionBasenotby.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSupplierReqEditUI.this, "ActionBasenotby", "actionBasenotby_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSupplierReqEditUI.this, "ActionAllAudit", "actionAllAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.bdm.bdapply.client", "SupplierReqEditUI");
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
        return com.kingdee.eas.bdm.bdapply.client.SupplierReqEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.bdm.bdapply.SupplierReqFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.bdm.bdapply.SupplierReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.SupplierReqInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/bdm/bdapply/SupplierReq";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.bdm.bdapply.app.SupplierReqQuery");
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtCSSGroup.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"供应商分类"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtaccountNum.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"银行账号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtprovince.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"省份"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpurInOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"采购组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
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
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus","0");
vo.put("userstated",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}