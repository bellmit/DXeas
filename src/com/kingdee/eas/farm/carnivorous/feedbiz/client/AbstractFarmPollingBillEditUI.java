/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

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
public abstract class AbstractFarmPollingBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmPollingBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasConfirm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconfirmMsg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmers;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarms;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignInTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignInAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignInX;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignInY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignOutTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignOutAddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignOutX;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsignOutY;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksignInTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsignInAddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsignInX;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsignInY;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksignOutTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtsignOutAddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsignOutX;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsignOutY;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtInventoryEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtInventoryEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtconfirmMsg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmers;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarms;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdayAge;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttemp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthumidity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutHygiene;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continHygiene;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeviceCircumstances;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugCircumstances;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstockingFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathAndCullMaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdayAge;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttemp;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthumidity;
    protected com.kingdee.bos.ctrl.swing.KDComboBox outHygiene;
    protected com.kingdee.bos.ctrl.swing.KDComboBox inHygiene;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdeviceCircumstances;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdrugCircumstances;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstockingFemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathAndCullMaleQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttodayDeatchRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteightDayDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteightDayDeathRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalDeathRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdayFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoneChickendayFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualRestFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrestFeedDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandAllFeed;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contactualAllFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttodayDeatchRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteightDayDeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteightDayDeathRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalDeathRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdayFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoneChickendayFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualRestFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrestFeedDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandAllFeed;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtactualAllFeed;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnDisplayPic;
    protected com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo editData = null;
    protected ActionDisplayPic actionDisplayPic = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFarmPollingBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmPollingBillEditUI.class.getName());
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
        //actionDisplayPic
        this.actionDisplayPic = new ActionDisplayPic(this);
        getActionManager().registerAction("actionDisplayPic", actionDisplayPic);
        this.actionDisplayPic.setExtendProperty("canForewarn", "true");
        this.actionDisplayPic.setExtendProperty("userDefined", "false");
        this.actionDisplayPic.setExtendProperty("isObjectUpdateLock", "false");
         this.actionDisplayPic.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionDisplayPic.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhasConfirm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contconfirmTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconfirmMsg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmers = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarms = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contsignInTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignInAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignInX = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignInY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignOutTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignOutAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignOutX = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsignOutY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pksignInTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtsignInAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsignInX = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsignInY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pksignOutTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtsignOutAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtsignOutX = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsignOutY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtInventoryEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkconfirmTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtconfirmMsg = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmers = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarms = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contdayAge = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttemp = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthumidity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutHygiene = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continHygiene = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeviceCircumstances = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugCircumstances = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstockingFemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeathAndCullMaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallDeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdayAge = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttemp = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthumidity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.outHygiene = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.inHygiene = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtdeviceCircumstances = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtdrugCircumstances = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtstockingFemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeathAndCullMaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallDeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.conttodayDeatchRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteightDayDeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteightDayDeathRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalDeathRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdayFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoneChickendayFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualRestFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrestFeedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandAllFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contactualAllFeed = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txttodayDeatchRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteightDayDeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteightDayDeathRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalDeathRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdayFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoneChickendayFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualRestFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrestFeedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandAllFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtactualAllFeed = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnDisplayPic = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contbillStatus.setName("contbillStatus");
        this.contcompany.setName("contcompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contperson.setName("contperson");
        this.contauditTime.setName("contauditTime");
        this.chkhasConfirm.setName("chkhasConfirm");
        this.contconfirmTime.setName("contconfirmTime");
        this.contconfirmMsg.setName("contconfirmMsg");
        this.contfarmers.setName("contfarmers");
        this.contfarms.setName("contfarms");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.billStatus.setName("billStatus");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.contsignInTime.setName("contsignInTime");
        this.contsignInAddress.setName("contsignInAddress");
        this.contsignInX.setName("contsignInX");
        this.contsignInY.setName("contsignInY");
        this.contsignOutTime.setName("contsignOutTime");
        this.contsignOutAddress.setName("contsignOutAddress");
        this.contsignOutX.setName("contsignOutX");
        this.contsignOutY.setName("contsignOutY");
        this.pksignInTime.setName("pksignInTime");
        this.txtsignInAddress.setName("txtsignInAddress");
        this.txtsignInX.setName("txtsignInX");
        this.txtsignInY.setName("txtsignInY");
        this.pksignOutTime.setName("pksignOutTime");
        this.txtsignOutAddress.setName("txtsignOutAddress");
        this.txtsignOutX.setName("txtsignOutX");
        this.txtsignOutY.setName("txtsignOutY");
        this.kdtInventoryEntry.setName("kdtInventoryEntry");
        this.txtremark.setName("txtremark");
        this.prmtperson.setName("prmtperson");
        this.pkauditTime.setName("pkauditTime");
        this.pkconfirmTime.setName("pkconfirmTime");
        this.txtconfirmMsg.setName("txtconfirmMsg");
        this.prmtfarmers.setName("prmtfarmers");
        this.prmtfarms.setName("prmtfarms");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel5.setName("kDPanel5");
        this.contdayAge.setName("contdayAge");
        this.conttemp.setName("conttemp");
        this.conthumidity.setName("conthumidity");
        this.contoutHygiene.setName("contoutHygiene");
        this.continHygiene.setName("continHygiene");
        this.contdeviceCircumstances.setName("contdeviceCircumstances");
        this.contdrugCircumstances.setName("contdrugCircumstances");
        this.contstockingFemaleQty.setName("contstockingFemaleQty");
        this.contdeathAndCullMaleQty.setName("contdeathAndCullMaleQty");
        this.contbatch.setName("contbatch");
        this.contbatchContract.setName("contbatchContract");
        this.contallDeathQty.setName("contallDeathQty");
        this.txtdayAge.setName("txtdayAge");
        this.txttemp.setName("txttemp");
        this.txthumidity.setName("txthumidity");
        this.outHygiene.setName("outHygiene");
        this.inHygiene.setName("inHygiene");
        this.txtdeviceCircumstances.setName("txtdeviceCircumstances");
        this.txtdrugCircumstances.setName("txtdrugCircumstances");
        this.txtstockingFemaleQty.setName("txtstockingFemaleQty");
        this.txtdeathAndCullMaleQty.setName("txtdeathAndCullMaleQty");
        this.prmtbatch.setName("prmtbatch");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.txtallDeathQty.setName("txtallDeathQty");
        this.conttodayDeatchRate.setName("conttodayDeatchRate");
        this.conteightDayDeathQty.setName("conteightDayDeathQty");
        this.conteightDayDeathRate.setName("conteightDayDeathRate");
        this.conttotalDeathRate.setName("conttotalDeathRate");
        this.contdayFeed.setName("contdayFeed");
        this.contoneChickendayFeed.setName("contoneChickendayFeed");
        this.contactualRestFeed.setName("contactualRestFeed");
        this.contrestFeedDays.setName("contrestFeedDays");
        this.contstandAllFeed.setName("contstandAllFeed");
        this.contactualAllFeed.setName("contactualAllFeed");
        this.txttodayDeatchRate.setName("txttodayDeatchRate");
        this.txteightDayDeathQty.setName("txteightDayDeathQty");
        this.txteightDayDeathRate.setName("txteightDayDeathRate");
        this.txttotalDeathRate.setName("txttotalDeathRate");
        this.txtdayFeed.setName("txtdayFeed");
        this.txtoneChickendayFeed.setName("txtoneChickendayFeed");
        this.txtactualRestFeed.setName("txtactualRestFeed");
        this.txtrestFeedDays.setName("txtrestFeedDays");
        this.txtstandAllFeed.setName("txtstandAllFeed");
        this.txtactualAllFeed.setName("txtactualAllFeed");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.btnDisplayPic.setName("btnDisplayPic");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);
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
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // contBizDate		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);
        // contDescription		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);
        // contAuditor		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDTabbedPane1
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // chkhasConfirm		
        this.chkhasConfirm.setText(resHelper.getString("chkhasConfirm.text"));		
        this.chkhasConfirm.setVisible(true);		
        this.chkhasConfirm.setHorizontalAlignment(2);		
        this.chkhasConfirm.setEnabled(false);
        // contconfirmTime		
        this.contconfirmTime.setBoundLabelText(resHelper.getString("contconfirmTime.boundLabelText"));		
        this.contconfirmTime.setBoundLabelLength(100);		
        this.contconfirmTime.setBoundLabelUnderline(true);		
        this.contconfirmTime.setVisible(true);
        // contconfirmMsg		
        this.contconfirmMsg.setBoundLabelText(resHelper.getString("contconfirmMsg.boundLabelText"));		
        this.contconfirmMsg.setBoundLabelLength(100);		
        this.contconfirmMsg.setBoundLabelUnderline(true);		
        this.contconfirmMsg.setVisible(true);
        // contfarmers		
        this.contfarmers.setBoundLabelText(resHelper.getString("contfarmers.boundLabelText"));		
        this.contfarmers.setBoundLabelLength(100);		
        this.contfarmers.setBoundLabelUnderline(true);		
        this.contfarmers.setVisible(true);
        // contfarms		
        this.contfarms.setBoundLabelText(resHelper.getString("contfarms.boundLabelText"));		
        this.contfarms.setBoundLabelLength(100);		
        this.contfarms.setBoundLabelUnderline(true);		
        this.contfarms.setVisible(true);
        // kDTabbedPane2
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
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // contsignInTime		
        this.contsignInTime.setBoundLabelText(resHelper.getString("contsignInTime.boundLabelText"));		
        this.contsignInTime.setBoundLabelLength(100);		
        this.contsignInTime.setBoundLabelUnderline(true);		
        this.contsignInTime.setVisible(true);
        // contsignInAddress		
        this.contsignInAddress.setBoundLabelText(resHelper.getString("contsignInAddress.boundLabelText"));		
        this.contsignInAddress.setBoundLabelLength(100);		
        this.contsignInAddress.setBoundLabelUnderline(true);		
        this.contsignInAddress.setVisible(true);
        // contsignInX		
        this.contsignInX.setBoundLabelText(resHelper.getString("contsignInX.boundLabelText"));		
        this.contsignInX.setBoundLabelLength(100);		
        this.contsignInX.setBoundLabelUnderline(true);		
        this.contsignInX.setVisible(true);
        // contsignInY		
        this.contsignInY.setBoundLabelText(resHelper.getString("contsignInY.boundLabelText"));		
        this.contsignInY.setBoundLabelLength(100);		
        this.contsignInY.setBoundLabelUnderline(true);		
        this.contsignInY.setVisible(true);
        // contsignOutTime		
        this.contsignOutTime.setBoundLabelText(resHelper.getString("contsignOutTime.boundLabelText"));		
        this.contsignOutTime.setBoundLabelLength(100);		
        this.contsignOutTime.setBoundLabelUnderline(true);		
        this.contsignOutTime.setVisible(true);
        // contsignOutAddress		
        this.contsignOutAddress.setBoundLabelText(resHelper.getString("contsignOutAddress.boundLabelText"));		
        this.contsignOutAddress.setBoundLabelLength(100);		
        this.contsignOutAddress.setBoundLabelUnderline(true);		
        this.contsignOutAddress.setVisible(true);
        // contsignOutX		
        this.contsignOutX.setBoundLabelText(resHelper.getString("contsignOutX.boundLabelText"));		
        this.contsignOutX.setBoundLabelLength(100);		
        this.contsignOutX.setBoundLabelUnderline(true);		
        this.contsignOutX.setVisible(true);
        // contsignOutY		
        this.contsignOutY.setBoundLabelText(resHelper.getString("contsignOutY.boundLabelText"));		
        this.contsignOutY.setBoundLabelLength(100);		
        this.contsignOutY.setBoundLabelUnderline(true);		
        this.contsignOutY.setVisible(true);
        // pksignInTime		
        this.pksignInTime.setVisible(true);		
        this.pksignInTime.setRequired(false);
        // txtsignInAddress		
        this.txtsignInAddress.setVisible(true);		
        this.txtsignInAddress.setHorizontalAlignment(2);		
        this.txtsignInAddress.setMaxLength(100);		
        this.txtsignInAddress.setRequired(false);
        // txtsignInX		
        this.txtsignInX.setVisible(true);		
        this.txtsignInX.setHorizontalAlignment(2);		
        this.txtsignInX.setDataType(1);		
        this.txtsignInX.setSupportedEmpty(true);		
        this.txtsignInX.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsignInX.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsignInX.setPrecision(10);		
        this.txtsignInX.setRequired(false);
        // txtsignInY		
        this.txtsignInY.setVisible(true);		
        this.txtsignInY.setHorizontalAlignment(2);		
        this.txtsignInY.setDataType(1);		
        this.txtsignInY.setSupportedEmpty(true);		
        this.txtsignInY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsignInY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsignInY.setPrecision(10);		
        this.txtsignInY.setRequired(false);
        // pksignOutTime		
        this.pksignOutTime.setVisible(true);		
        this.pksignOutTime.setRequired(false);
        // txtsignOutAddress		
        this.txtsignOutAddress.setVisible(true);		
        this.txtsignOutAddress.setHorizontalAlignment(2);		
        this.txtsignOutAddress.setMaxLength(100);		
        this.txtsignOutAddress.setRequired(false);
        // txtsignOutX		
        this.txtsignOutX.setVisible(true);		
        this.txtsignOutX.setHorizontalAlignment(2);		
        this.txtsignOutX.setDataType(1);		
        this.txtsignOutX.setSupportedEmpty(true);		
        this.txtsignOutX.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsignOutX.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsignOutX.setPrecision(10);		
        this.txtsignOutX.setRequired(false);
        // txtsignOutY		
        this.txtsignOutY.setVisible(true);		
        this.txtsignOutY.setHorizontalAlignment(2);		
        this.txtsignOutY.setDataType(1);		
        this.txtsignOutY.setSupportedEmpty(true);		
        this.txtsignOutY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsignOutY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsignOutY.setPrecision(10);		
        this.txtsignOutY.setRequired(false);
        // kdtInventoryEntry
		String kdtInventoryEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bagQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unitQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"dailyUsgBags\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{bagQty}</t:Cell><t:Cell>$Resource{unitQty}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{dailyUsgBags}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtInventoryEntry.setFormatXml(resHelper.translateString("kdtInventoryEntry",kdtInventoryEntryStrXML));
        kdtInventoryEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtInventoryEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtInventoryEntry.putBindContents("editData",new String[] {"seq","material","materialName","model","unit","bagQty","unitQty","qty","dailyUsgBags"});


        this.kdtInventoryEntry.checkParsed();
        final KDBizPromptBox kdtInventoryEntry_material_PromptBox = new KDBizPromptBox();
        kdtInventoryEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtInventoryEntry_material_PromptBox.setVisible(true);
        kdtInventoryEntry_material_PromptBox.setEditable(true);
        kdtInventoryEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtInventoryEntry_material_PromptBox.setEditFormat("$number$");
        kdtInventoryEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtInventoryEntry_material_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_material_PromptBox);
        this.kdtInventoryEntry.getColumn("material").setEditor(kdtInventoryEntry_material_CellEditor);
        ObjectValueRender kdtInventoryEntry_material_OVR = new ObjectValueRender();
        kdtInventoryEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtInventoryEntry.getColumn("material").setRenderer(kdtInventoryEntry_material_OVR);
        KDTextField kdtInventoryEntry_materialName_TextField = new KDTextField();
        kdtInventoryEntry_materialName_TextField.setName("kdtInventoryEntry_materialName_TextField");
        kdtInventoryEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtInventoryEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_materialName_TextField);
        this.kdtInventoryEntry.getColumn("materialName").setEditor(kdtInventoryEntry_materialName_CellEditor);
        KDTextField kdtInventoryEntry_model_TextField = new KDTextField();
        kdtInventoryEntry_model_TextField.setName("kdtInventoryEntry_model_TextField");
        kdtInventoryEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtInventoryEntry_model_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_model_TextField);
        this.kdtInventoryEntry.getColumn("model").setEditor(kdtInventoryEntry_model_CellEditor);
        final KDBizPromptBox kdtInventoryEntry_unit_PromptBox = new KDBizPromptBox();
        kdtInventoryEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtInventoryEntry_unit_PromptBox.setVisible(true);
        kdtInventoryEntry_unit_PromptBox.setEditable(true);
        kdtInventoryEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtInventoryEntry_unit_PromptBox.setEditFormat("$number$");
        kdtInventoryEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtInventoryEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_unit_PromptBox);
        this.kdtInventoryEntry.getColumn("unit").setEditor(kdtInventoryEntry_unit_CellEditor);
        ObjectValueRender kdtInventoryEntry_unit_OVR = new ObjectValueRender();
        kdtInventoryEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtInventoryEntry.getColumn("unit").setRenderer(kdtInventoryEntry_unit_OVR);
        KDFormattedTextField kdtInventoryEntry_bagQty_TextField = new KDFormattedTextField();
        kdtInventoryEntry_bagQty_TextField.setName("kdtInventoryEntry_bagQty_TextField");
        kdtInventoryEntry_bagQty_TextField.setVisible(true);
        kdtInventoryEntry_bagQty_TextField.setEditable(true);
        kdtInventoryEntry_bagQty_TextField.setHorizontalAlignment(2);
        kdtInventoryEntry_bagQty_TextField.setDataType(1);
        	kdtInventoryEntry_bagQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtInventoryEntry_bagQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtInventoryEntry_bagQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtInventoryEntry_bagQty_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_bagQty_TextField);
        this.kdtInventoryEntry.getColumn("bagQty").setEditor(kdtInventoryEntry_bagQty_CellEditor);
        KDFormattedTextField kdtInventoryEntry_unitQty_TextField = new KDFormattedTextField();
        kdtInventoryEntry_unitQty_TextField.setName("kdtInventoryEntry_unitQty_TextField");
        kdtInventoryEntry_unitQty_TextField.setVisible(true);
        kdtInventoryEntry_unitQty_TextField.setEditable(true);
        kdtInventoryEntry_unitQty_TextField.setHorizontalAlignment(2);
        kdtInventoryEntry_unitQty_TextField.setDataType(1);
        	kdtInventoryEntry_unitQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtInventoryEntry_unitQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtInventoryEntry_unitQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtInventoryEntry_unitQty_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_unitQty_TextField);
        this.kdtInventoryEntry.getColumn("unitQty").setEditor(kdtInventoryEntry_unitQty_CellEditor);
        KDFormattedTextField kdtInventoryEntry_qty_TextField = new KDFormattedTextField();
        kdtInventoryEntry_qty_TextField.setName("kdtInventoryEntry_qty_TextField");
        kdtInventoryEntry_qty_TextField.setVisible(true);
        kdtInventoryEntry_qty_TextField.setEditable(true);
        kdtInventoryEntry_qty_TextField.setHorizontalAlignment(2);
        kdtInventoryEntry_qty_TextField.setDataType(1);
        	kdtInventoryEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtInventoryEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtInventoryEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtInventoryEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_qty_TextField);
        this.kdtInventoryEntry.getColumn("qty").setEditor(kdtInventoryEntry_qty_CellEditor);
        KDFormattedTextField kdtInventoryEntry_dailyUsgBags_TextField = new KDFormattedTextField();
        kdtInventoryEntry_dailyUsgBags_TextField.setName("kdtInventoryEntry_dailyUsgBags_TextField");
        kdtInventoryEntry_dailyUsgBags_TextField.setVisible(true);
        kdtInventoryEntry_dailyUsgBags_TextField.setEditable(true);
        kdtInventoryEntry_dailyUsgBags_TextField.setHorizontalAlignment(2);
        kdtInventoryEntry_dailyUsgBags_TextField.setDataType(1);
        	kdtInventoryEntry_dailyUsgBags_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtInventoryEntry_dailyUsgBags_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtInventoryEntry_dailyUsgBags_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtInventoryEntry_dailyUsgBags_CellEditor = new KDTDefaultCellEditor(kdtInventoryEntry_dailyUsgBags_TextField);
        this.kdtInventoryEntry.getColumn("dailyUsgBags").setEditor(kdtInventoryEntry_dailyUsgBags_CellEditor);
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(500);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // pkconfirmTime		
        this.pkconfirmTime.setVisible(true);		
        this.pkconfirmTime.setRequired(false);		
        this.pkconfirmTime.setEnabled(false);
        // txtconfirmMsg		
        this.txtconfirmMsg.setVisible(true);		
        this.txtconfirmMsg.setHorizontalAlignment(2);		
        this.txtconfirmMsg.setMaxLength(100);		
        this.txtconfirmMsg.setRequired(false);		
        this.txtconfirmMsg.setEnabled(false);
        // prmtfarmers		
        this.prmtfarmers.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmers.setVisible(true);		
        this.prmtfarmers.setEditable(true);		
        this.prmtfarmers.setDisplayFormat("$name$");		
        this.prmtfarmers.setEditFormat("$number$");		
        this.prmtfarmers.setCommitFormat("$number$");		
        this.prmtfarmers.setRequired(true);
        		prmtfarmers.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmers_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmers_F7ListUI == null) {
					try {
						prmtfarmers_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmers_F7ListUI));
					prmtfarmers_F7ListUI.setF7Use(true,ctx);
					prmtfarmers.setSelector(prmtfarmers_F7ListUI);
				}
			}
		});
					
        // prmtfarms		
        this.prmtfarms.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtfarms.setVisible(true);		
        this.prmtfarms.setEditable(true);		
        this.prmtfarms.setDisplayFormat("$name$");		
        this.prmtfarms.setEditFormat("$number$");		
        this.prmtfarms.setCommitFormat("$number$");		
        this.prmtfarms.setRequired(true);
        		prmtfarms.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtfarms_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarms_F7ListUI == null) {
					try {
						prmtfarms_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarms_F7ListUI));
					prmtfarms_F7ListUI.setF7Use(true,ctx);
					prmtfarms.setSelector(prmtfarms_F7ListUI);
				}
			}
		});
					
        // kDPanel4		
        this.kDPanel4.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel4.border.title")));
        // kDPanel5
        // contdayAge		
        this.contdayAge.setBoundLabelText(resHelper.getString("contdayAge.boundLabelText"));		
        this.contdayAge.setBoundLabelLength(100);		
        this.contdayAge.setBoundLabelUnderline(true);		
        this.contdayAge.setVisible(true);
        // conttemp		
        this.conttemp.setBoundLabelText(resHelper.getString("conttemp.boundLabelText"));		
        this.conttemp.setBoundLabelLength(100);		
        this.conttemp.setBoundLabelUnderline(true);		
        this.conttemp.setVisible(true);
        // conthumidity		
        this.conthumidity.setBoundLabelText(resHelper.getString("conthumidity.boundLabelText"));		
        this.conthumidity.setBoundLabelLength(100);		
        this.conthumidity.setBoundLabelUnderline(true);		
        this.conthumidity.setVisible(true);
        // contoutHygiene		
        this.contoutHygiene.setBoundLabelText(resHelper.getString("contoutHygiene.boundLabelText"));		
        this.contoutHygiene.setBoundLabelLength(100);		
        this.contoutHygiene.setBoundLabelUnderline(true);		
        this.contoutHygiene.setVisible(true);
        // continHygiene		
        this.continHygiene.setBoundLabelText(resHelper.getString("continHygiene.boundLabelText"));		
        this.continHygiene.setBoundLabelLength(100);		
        this.continHygiene.setBoundLabelUnderline(true);		
        this.continHygiene.setVisible(true);
        // contdeviceCircumstances		
        this.contdeviceCircumstances.setBoundLabelText(resHelper.getString("contdeviceCircumstances.boundLabelText"));		
        this.contdeviceCircumstances.setBoundLabelLength(100);		
        this.contdeviceCircumstances.setBoundLabelUnderline(true);		
        this.contdeviceCircumstances.setVisible(true);
        // contdrugCircumstances		
        this.contdrugCircumstances.setBoundLabelText(resHelper.getString("contdrugCircumstances.boundLabelText"));		
        this.contdrugCircumstances.setBoundLabelLength(100);		
        this.contdrugCircumstances.setBoundLabelUnderline(true);		
        this.contdrugCircumstances.setVisible(true);
        // contstockingFemaleQty		
        this.contstockingFemaleQty.setBoundLabelText(resHelper.getString("contstockingFemaleQty.boundLabelText"));		
        this.contstockingFemaleQty.setBoundLabelLength(100);		
        this.contstockingFemaleQty.setBoundLabelUnderline(true);		
        this.contstockingFemaleQty.setVisible(true);
        // contdeathAndCullMaleQty		
        this.contdeathAndCullMaleQty.setBoundLabelText(resHelper.getString("contdeathAndCullMaleQty.boundLabelText"));		
        this.contdeathAndCullMaleQty.setBoundLabelLength(100);		
        this.contdeathAndCullMaleQty.setBoundLabelUnderline(true);		
        this.contdeathAndCullMaleQty.setVisible(true);
        // contbatch		
        this.contbatch.setBoundLabelText(resHelper.getString("contbatch.boundLabelText"));		
        this.contbatch.setBoundLabelLength(100);		
        this.contbatch.setBoundLabelUnderline(true);		
        this.contbatch.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // contallDeathQty		
        this.contallDeathQty.setBoundLabelText(resHelper.getString("contallDeathQty.boundLabelText"));		
        this.contallDeathQty.setBoundLabelLength(100);		
        this.contallDeathQty.setBoundLabelUnderline(true);		
        this.contallDeathQty.setVisible(true);
        // txtdayAge		
        this.txtdayAge.setVisible(true);		
        this.txtdayAge.setHorizontalAlignment(2);		
        this.txtdayAge.setDataType(0);		
        this.txtdayAge.setSupportedEmpty(true);		
        this.txtdayAge.setRequired(false);
        // txttemp		
        this.txttemp.setVisible(true);		
        this.txttemp.setHorizontalAlignment(2);		
        this.txttemp.setDataType(1);		
        this.txttemp.setSupportedEmpty(true);		
        this.txttemp.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttemp.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttemp.setPrecision(4);		
        this.txttemp.setRequired(false);
        // txthumidity		
        this.txthumidity.setVisible(true);		
        this.txthumidity.setHorizontalAlignment(2);		
        this.txthumidity.setDataType(1);		
        this.txthumidity.setSupportedEmpty(true);		
        this.txthumidity.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthumidity.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthumidity.setPrecision(4);		
        this.txthumidity.setRequired(false);
        // outHygiene		
        this.outHygiene.setVisible(true);		
        this.outHygiene.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.farmpolling.evaluationLvEnum").toArray());		
        this.outHygiene.setRequired(false);
        // inHygiene		
        this.inHygiene.setVisible(true);		
        this.inHygiene.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.farmpolling.evaluationLvEnum").toArray());		
        this.inHygiene.setRequired(false);
        // txtdeviceCircumstances		
        this.txtdeviceCircumstances.setVisible(true);		
        this.txtdeviceCircumstances.setHorizontalAlignment(2);		
        this.txtdeviceCircumstances.setMaxLength(100);		
        this.txtdeviceCircumstances.setRequired(false);
        // txtdrugCircumstances		
        this.txtdrugCircumstances.setVisible(true);		
        this.txtdrugCircumstances.setHorizontalAlignment(2);		
        this.txtdrugCircumstances.setMaxLength(100);		
        this.txtdrugCircumstances.setRequired(false);
        // txtstockingFemaleQty		
        this.txtstockingFemaleQty.setVisible(true);		
        this.txtstockingFemaleQty.setHorizontalAlignment(2);		
        this.txtstockingFemaleQty.setDataType(0);		
        this.txtstockingFemaleQty.setSupportedEmpty(true);		
        this.txtstockingFemaleQty.setRequired(false);
        // txtdeathAndCullMaleQty		
        this.txtdeathAndCullMaleQty.setVisible(true);		
        this.txtdeathAndCullMaleQty.setHorizontalAlignment(2);		
        this.txtdeathAndCullMaleQty.setDataType(0);		
        this.txtdeathAndCullMaleQty.setSupportedEmpty(true);		
        this.txtdeathAndCullMaleQty.setRequired(false);
        // prmtbatch		
        this.prmtbatch.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtbatch.setVisible(true);		
        this.prmtbatch.setEditable(true);		
        this.prmtbatch.setDisplayFormat("$name$");		
        this.prmtbatch.setEditFormat("$number$");		
        this.prmtbatch.setCommitFormat("$number$");		
        this.prmtbatch.setRequired(false);
        		prmtbatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtbatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbatch_F7ListUI == null) {
					try {
						prmtbatch_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbatch_F7ListUI));
					prmtbatch_F7ListUI.setF7Use(true,ctx);
					prmtbatch.setSelector(prmtbatch_F7ListUI);
				}
			}
		});
					
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.BatchContractBillQuery");		
        this.prmtbatchContract.setVisible(true);		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // txtallDeathQty		
        this.txtallDeathQty.setVisible(true);		
        this.txtallDeathQty.setHorizontalAlignment(2);		
        this.txtallDeathQty.setDataType(1);		
        this.txtallDeathQty.setSupportedEmpty(true);		
        this.txtallDeathQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallDeathQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallDeathQty.setPrecision(4);		
        this.txtallDeathQty.setRequired(false);
        // conttodayDeatchRate		
        this.conttodayDeatchRate.setBoundLabelText(resHelper.getString("conttodayDeatchRate.boundLabelText"));		
        this.conttodayDeatchRate.setBoundLabelLength(100);		
        this.conttodayDeatchRate.setBoundLabelUnderline(true);		
        this.conttodayDeatchRate.setVisible(true);
        // conteightDayDeathQty		
        this.conteightDayDeathQty.setBoundLabelText(resHelper.getString("conteightDayDeathQty.boundLabelText"));		
        this.conteightDayDeathQty.setBoundLabelLength(100);		
        this.conteightDayDeathQty.setBoundLabelUnderline(true);		
        this.conteightDayDeathQty.setVisible(true);
        // conteightDayDeathRate		
        this.conteightDayDeathRate.setBoundLabelText(resHelper.getString("conteightDayDeathRate.boundLabelText"));		
        this.conteightDayDeathRate.setBoundLabelLength(100);		
        this.conteightDayDeathRate.setBoundLabelUnderline(true);		
        this.conteightDayDeathRate.setVisible(true);
        // conttotalDeathRate		
        this.conttotalDeathRate.setBoundLabelText(resHelper.getString("conttotalDeathRate.boundLabelText"));		
        this.conttotalDeathRate.setBoundLabelLength(100);		
        this.conttotalDeathRate.setBoundLabelUnderline(true);		
        this.conttotalDeathRate.setVisible(true);
        // contdayFeed		
        this.contdayFeed.setBoundLabelText(resHelper.getString("contdayFeed.boundLabelText"));		
        this.contdayFeed.setBoundLabelLength(100);		
        this.contdayFeed.setBoundLabelUnderline(true);		
        this.contdayFeed.setVisible(true);
        // contoneChickendayFeed		
        this.contoneChickendayFeed.setBoundLabelText(resHelper.getString("contoneChickendayFeed.boundLabelText"));		
        this.contoneChickendayFeed.setBoundLabelLength(100);		
        this.contoneChickendayFeed.setBoundLabelUnderline(true);		
        this.contoneChickendayFeed.setVisible(true);
        // contactualRestFeed		
        this.contactualRestFeed.setBoundLabelText(resHelper.getString("contactualRestFeed.boundLabelText"));		
        this.contactualRestFeed.setBoundLabelLength(100);		
        this.contactualRestFeed.setBoundLabelUnderline(true);		
        this.contactualRestFeed.setVisible(true);
        // contrestFeedDays		
        this.contrestFeedDays.setBoundLabelText(resHelper.getString("contrestFeedDays.boundLabelText"));		
        this.contrestFeedDays.setBoundLabelLength(100);		
        this.contrestFeedDays.setBoundLabelUnderline(true);		
        this.contrestFeedDays.setVisible(true);
        // contstandAllFeed		
        this.contstandAllFeed.setBoundLabelText(resHelper.getString("contstandAllFeed.boundLabelText"));		
        this.contstandAllFeed.setBoundLabelLength(100);		
        this.contstandAllFeed.setBoundLabelUnderline(true);		
        this.contstandAllFeed.setVisible(true);
        // contactualAllFeed		
        this.contactualAllFeed.setBoundLabelText(resHelper.getString("contactualAllFeed.boundLabelText"));		
        this.contactualAllFeed.setBoundLabelLength(100);		
        this.contactualAllFeed.setBoundLabelUnderline(true);		
        this.contactualAllFeed.setVisible(true);
        // txttodayDeatchRate		
        this.txttodayDeatchRate.setVisible(true);		
        this.txttodayDeatchRate.setHorizontalAlignment(2);		
        this.txttodayDeatchRate.setDataType(1);		
        this.txttodayDeatchRate.setSupportedEmpty(true);		
        this.txttodayDeatchRate.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txttodayDeatchRate.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txttodayDeatchRate.setPrecision(5);		
        this.txttodayDeatchRate.setRequired(false);
        // txteightDayDeathQty		
        this.txteightDayDeathQty.setVisible(true);		
        this.txteightDayDeathQty.setHorizontalAlignment(2);		
        this.txteightDayDeathQty.setDataType(1);		
        this.txteightDayDeathQty.setSupportedEmpty(true);		
        this.txteightDayDeathQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteightDayDeathQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteightDayDeathQty.setPrecision(4);		
        this.txteightDayDeathQty.setRequired(false);
        // txteightDayDeathRate		
        this.txteightDayDeathRate.setVisible(true);		
        this.txteightDayDeathRate.setHorizontalAlignment(2);		
        this.txteightDayDeathRate.setDataType(1);		
        this.txteightDayDeathRate.setSupportedEmpty(true);		
        this.txteightDayDeathRate.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txteightDayDeathRate.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txteightDayDeathRate.setPrecision(5);		
        this.txteightDayDeathRate.setRequired(false);
        // txttotalDeathRate		
        this.txttotalDeathRate.setVisible(true);		
        this.txttotalDeathRate.setHorizontalAlignment(2);		
        this.txttotalDeathRate.setDataType(1);		
        this.txttotalDeathRate.setSupportedEmpty(true);		
        this.txttotalDeathRate.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txttotalDeathRate.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txttotalDeathRate.setPrecision(5);		
        this.txttotalDeathRate.setRequired(false);
        // txtdayFeed		
        this.txtdayFeed.setVisible(true);		
        this.txtdayFeed.setHorizontalAlignment(2);		
        this.txtdayFeed.setDataType(1);		
        this.txtdayFeed.setSupportedEmpty(true);		
        this.txtdayFeed.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtdayFeed.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtdayFeed.setPrecision(5);		
        this.txtdayFeed.setRequired(false);
        // txtoneChickendayFeed		
        this.txtoneChickendayFeed.setVisible(true);		
        this.txtoneChickendayFeed.setHorizontalAlignment(2);		
        this.txtoneChickendayFeed.setDataType(1);		
        this.txtoneChickendayFeed.setSupportedEmpty(true);		
        this.txtoneChickendayFeed.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtoneChickendayFeed.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtoneChickendayFeed.setPrecision(5);		
        this.txtoneChickendayFeed.setRequired(false);
        // txtactualRestFeed		
        this.txtactualRestFeed.setVisible(true);		
        this.txtactualRestFeed.setHorizontalAlignment(2);		
        this.txtactualRestFeed.setDataType(1);		
        this.txtactualRestFeed.setSupportedEmpty(true);		
        this.txtactualRestFeed.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtactualRestFeed.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtactualRestFeed.setPrecision(5);		
        this.txtactualRestFeed.setRequired(false);
        // txtrestFeedDays		
        this.txtrestFeedDays.setVisible(true);		
        this.txtrestFeedDays.setHorizontalAlignment(2);		
        this.txtrestFeedDays.setDataType(1);		
        this.txtrestFeedDays.setSupportedEmpty(true);		
        this.txtrestFeedDays.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrestFeedDays.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrestFeedDays.setPrecision(4);		
        this.txtrestFeedDays.setRequired(false);
        // txtstandAllFeed		
        this.txtstandAllFeed.setVisible(true);		
        this.txtstandAllFeed.setHorizontalAlignment(2);		
        this.txtstandAllFeed.setDataType(1);		
        this.txtstandAllFeed.setSupportedEmpty(true);		
        this.txtstandAllFeed.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtstandAllFeed.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtstandAllFeed.setPrecision(5);		
        this.txtstandAllFeed.setRequired(false);
        // txtactualAllFeed		
        this.txtactualAllFeed.setVisible(true);		
        this.txtactualAllFeed.setHorizontalAlignment(2);		
        this.txtactualAllFeed.setDataType(1);		
        this.txtactualAllFeed.setSupportedEmpty(true);		
        this.txtactualAllFeed.setMinimumValue( new java.math.BigDecimal("-9.999999999999999E22"));		
        this.txtactualAllFeed.setMaximumValue( new java.math.BigDecimal("9.999999999999999E22"));		
        this.txtactualAllFeed.setPrecision(5);		
        this.txtactualAllFeed.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // btnDisplayPic
        this.btnDisplayPic.setAction((IItemAction)ActionProxyFactory.getProxy(actionDisplayPic, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnDisplayPic.setText(resHelper.getString("btnDisplayPic.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {billStatus,prmtcompany,prmtperson,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,kdtInventoryEntry,pkauditTime,txtdayAge,txttemp,txthumidity,txtremark,outHygiene,inHygiene,txtdrugCircumstances,txtdeviceCircumstances,pksignInTime,txtsignInAddress,txtsignInX,txtsignInY,pksignOutTime,txtsignOutAddress,txtsignOutX,txtsignOutY,chkhasConfirm,pkconfirmTime,txtconfirmMsg,txtstockingFemaleQty,txtdeathAndCullMaleQty,prmtbatch,prmtfarmers,prmtfarms,prmtbatchContract,txtallDeathQty,txttodayDeatchRate,txteightDayDeathQty,txteightDayDeathRate,txttotalDeathRate,txtdayFeed,txtoneChickendayFeed,txtactualRestFeed,txtrestFeedDays,txtstandAllFeed,txtactualAllFeed}));
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
        contCreator.setBounds(new Rectangle(378, 571, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(378, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(725, 571, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(725, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(378, 602, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(378, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(725, 602, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(725, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(18, 9, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(18, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(365, 9, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(365, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(365, 72, 618, 19));
        this.add(contDescription, new KDLayout.Constraints(365, 72, 618, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(16, 571, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(16, 571, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(713, 7, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(713, 7, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(18, 40, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(18, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(16, 342, 975, 222));
        this.add(kDTabbedPane1, new KDLayout.Constraints(16, 342, 975, 222, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(18, 72, 270, 19));
        this.add(contperson, new KDLayout.Constraints(18, 72, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(16, 602, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(16, 602, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkhasConfirm.setBounds(new Rectangle(18, 96, 270, 19));
        this.add(chkhasConfirm, new KDLayout.Constraints(18, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contconfirmTime.setBounds(new Rectangle(365, 100, 270, 19));
        this.add(contconfirmTime, new KDLayout.Constraints(365, 100, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconfirmMsg.setBounds(new Rectangle(713, 100, 270, 19));
        this.add(contconfirmMsg, new KDLayout.Constraints(713, 100, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmers.setBounds(new Rectangle(365, 40, 270, 19));
        this.add(contfarmers, new KDLayout.Constraints(365, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarms.setBounds(new Rectangle(716, 40, 270, 19));
        this.add(contfarms, new KDLayout.Constraints(716, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane2.setBounds(new Rectangle(20, 128, 971, 204));
        this.add(kDTabbedPane2, new KDLayout.Constraints(20, 128, 971, 204, 0));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 189));        contsignInTime.setBounds(new Rectangle(18, 25, 211, 19));
        kDPanel1.add(contsignInTime, new KDLayout.Constraints(18, 25, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignInAddress.setBounds(new Rectangle(260, 25, 211, 19));
        kDPanel1.add(contsignInAddress, new KDLayout.Constraints(260, 25, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignInX.setBounds(new Rectangle(502, 25, 211, 19));
        kDPanel1.add(contsignInX, new KDLayout.Constraints(502, 25, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignInY.setBounds(new Rectangle(744, 25, 211, 19));
        kDPanel1.add(contsignInY, new KDLayout.Constraints(744, 25, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsignOutTime.setBounds(new Rectangle(18, 69, 211, 19));
        kDPanel1.add(contsignOutTime, new KDLayout.Constraints(18, 69, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignOutAddress.setBounds(new Rectangle(260, 66, 211, 19));
        kDPanel1.add(contsignOutAddress, new KDLayout.Constraints(260, 66, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignOutX.setBounds(new Rectangle(502, 67, 211, 19));
        kDPanel1.add(contsignOutX, new KDLayout.Constraints(502, 67, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsignOutY.setBounds(new Rectangle(744, 68, 211, 19));
        kDPanel1.add(contsignOutY, new KDLayout.Constraints(744, 68, 211, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contsignInTime
        contsignInTime.setBoundEditor(pksignInTime);
        //contsignInAddress
        contsignInAddress.setBoundEditor(txtsignInAddress);
        //contsignInX
        contsignInX.setBoundEditor(txtsignInX);
        //contsignInY
        contsignInY.setBoundEditor(txtsignInY);
        //contsignOutTime
        contsignOutTime.setBoundEditor(pksignOutTime);
        //contsignOutAddress
        contsignOutAddress.setBoundEditor(txtsignOutAddress);
        //contsignOutX
        contsignOutX.setBoundEditor(txtsignOutX);
        //contsignOutY
        contsignOutY.setBoundEditor(txtsignOutY);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 189));        kdtInventoryEntry.setBounds(new Rectangle(10, 10, 926, 189));
        kdtInventoryEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtInventoryEntry,new com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryInfo(),null,false);
        kDPanel2.add(kdtInventoryEntry_detailPanel, new KDLayout.Constraints(10, 10, 926, 189, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 974, 189));        txtremark.setBounds(new Rectangle(4, 4, 965, 202));
        kDPanel3.add(txtremark, new KDLayout.Constraints(4, 4, 965, 202, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contconfirmTime
        contconfirmTime.setBoundEditor(pkconfirmTime);
        //contconfirmMsg
        contconfirmMsg.setBoundEditor(txtconfirmMsg);
        //contfarmers
        contfarmers.setBoundEditor(prmtfarmers);
        //contfarms
        contfarms.setBoundEditor(prmtfarms);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane2.add(kDPanel5, resHelper.getString("kDPanel5.constraints"));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 970, 171));        contdayAge.setBounds(new Rectangle(351, 23, 270, 19));
        kDPanel4.add(contdayAge, new KDLayout.Constraints(351, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttemp.setBounds(new Rectangle(351, 96, 270, 19));
        kDPanel4.add(conttemp, new KDLayout.Constraints(351, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthumidity.setBounds(new Rectangle(683, 96, 270, 19));
        kDPanel4.add(conthumidity, new KDLayout.Constraints(683, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoutHygiene.setBounds(new Rectangle(20, 96, 270, 19));
        kDPanel4.add(contoutHygiene, new KDLayout.Constraints(20, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continHygiene.setBounds(new Rectangle(351, 135, 270, 19));
        kDPanel4.add(continHygiene, new KDLayout.Constraints(351, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeviceCircumstances.setBounds(new Rectangle(683, 135, 270, 19));
        kDPanel4.add(contdeviceCircumstances, new KDLayout.Constraints(683, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdrugCircumstances.setBounds(new Rectangle(20, 135, 270, 19));
        kDPanel4.add(contdrugCircumstances, new KDLayout.Constraints(20, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstockingFemaleQty.setBounds(new Rectangle(20, 58, 270, 19));
        kDPanel4.add(contstockingFemaleQty, new KDLayout.Constraints(20, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeathAndCullMaleQty.setBounds(new Rectangle(351, 58, 270, 19));
        kDPanel4.add(contdeathAndCullMaleQty, new KDLayout.Constraints(351, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatch.setBounds(new Rectangle(20, 23, 270, 19));
        kDPanel4.add(contbatch, new KDLayout.Constraints(20, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbatchContract.setBounds(new Rectangle(683, 23, 270, 19));
        kDPanel4.add(contbatchContract, new KDLayout.Constraints(683, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contallDeathQty.setBounds(new Rectangle(683, 58, 270, 19));
        kDPanel4.add(contallDeathQty, new KDLayout.Constraints(683, 58, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contdayAge
        contdayAge.setBoundEditor(txtdayAge);
        //conttemp
        conttemp.setBoundEditor(txttemp);
        //conthumidity
        conthumidity.setBoundEditor(txthumidity);
        //contoutHygiene
        contoutHygiene.setBoundEditor(outHygiene);
        //continHygiene
        continHygiene.setBoundEditor(inHygiene);
        //contdeviceCircumstances
        contdeviceCircumstances.setBoundEditor(txtdeviceCircumstances);
        //contdrugCircumstances
        contdrugCircumstances.setBoundEditor(txtdrugCircumstances);
        //contstockingFemaleQty
        contstockingFemaleQty.setBoundEditor(txtstockingFemaleQty);
        //contdeathAndCullMaleQty
        contdeathAndCullMaleQty.setBoundEditor(txtdeathAndCullMaleQty);
        //contbatch
        contbatch.setBoundEditor(prmtbatch);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //contallDeathQty
        contallDeathQty.setBoundEditor(txtallDeathQty);
        //kDPanel5
        kDPanel5.setLayout(null);        conttodayDeatchRate.setBounds(new Rectangle(14, 8, 270, 19));
        kDPanel5.add(conttodayDeatchRate, null);
        conteightDayDeathQty.setBounds(new Rectangle(309, 8, 270, 19));
        kDPanel5.add(conteightDayDeathQty, null);
        conteightDayDeathRate.setBounds(new Rectangle(604, 8, 270, 19));
        kDPanel5.add(conteightDayDeathRate, null);
        conttotalDeathRate.setBounds(new Rectangle(14, 36, 270, 19));
        kDPanel5.add(conttotalDeathRate, null);
        contdayFeed.setBounds(new Rectangle(309, 36, 270, 19));
        kDPanel5.add(contdayFeed, null);
        contoneChickendayFeed.setBounds(new Rectangle(604, 36, 270, 19));
        kDPanel5.add(contoneChickendayFeed, null);
        contactualRestFeed.setBounds(new Rectangle(14, 70, 270, 19));
        kDPanel5.add(contactualRestFeed, null);
        contrestFeedDays.setBounds(new Rectangle(309, 70, 270, 19));
        kDPanel5.add(contrestFeedDays, null);
        contstandAllFeed.setBounds(new Rectangle(604, 70, 270, 19));
        kDPanel5.add(contstandAllFeed, null);
        contactualAllFeed.setBounds(new Rectangle(14, 97, 270, 19));
        kDPanel5.add(contactualAllFeed, null);
        //conttodayDeatchRate
        conttodayDeatchRate.setBoundEditor(txttodayDeatchRate);
        //conteightDayDeathQty
        conteightDayDeathQty.setBoundEditor(txteightDayDeathQty);
        //conteightDayDeathRate
        conteightDayDeathRate.setBoundEditor(txteightDayDeathRate);
        //conttotalDeathRate
        conttotalDeathRate.setBoundEditor(txttotalDeathRate);
        //contdayFeed
        contdayFeed.setBoundEditor(txtdayFeed);
        //contoneChickendayFeed
        contoneChickendayFeed.setBoundEditor(txtoneChickendayFeed);
        //contactualRestFeed
        contactualRestFeed.setBoundEditor(txtactualRestFeed);
        //contrestFeedDays
        contrestFeedDays.setBoundEditor(txtrestFeedDays);
        //contstandAllFeed
        contstandAllFeed.setBoundEditor(txtstandAllFeed);
        //contactualAllFeed
        contactualAllFeed.setBoundEditor(txtactualAllFeed);

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
        menuBiz.add(MenuItemPCVoucher);
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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);
        this.toolBar.add(btnDisplayPic);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("hasConfirm", boolean.class, this.chkhasConfirm, "selected");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("signInTime", java.util.Date.class, this.pksignInTime, "value");
		dataBinder.registerBinding("signInAddress", String.class, this.txtsignInAddress, "text");
		dataBinder.registerBinding("signInX", java.math.BigDecimal.class, this.txtsignInX, "value");
		dataBinder.registerBinding("signInY", java.math.BigDecimal.class, this.txtsignInY, "value");
		dataBinder.registerBinding("signOutTime", java.util.Date.class, this.pksignOutTime, "value");
		dataBinder.registerBinding("signOutAddress", String.class, this.txtsignOutAddress, "text");
		dataBinder.registerBinding("signOutX", java.math.BigDecimal.class, this.txtsignOutX, "value");
		dataBinder.registerBinding("signOutY", java.math.BigDecimal.class, this.txtsignOutY, "value");
		dataBinder.registerBinding("InventoryEntry.seq", int.class, this.kdtInventoryEntry, "seq.text");
		dataBinder.registerBinding("InventoryEntry", com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryInfo.class, this.kdtInventoryEntry, "userObject");
		dataBinder.registerBinding("InventoryEntry.material", java.lang.Object.class, this.kdtInventoryEntry, "material.text");
		dataBinder.registerBinding("InventoryEntry.materialName", String.class, this.kdtInventoryEntry, "materialName.text");
		dataBinder.registerBinding("InventoryEntry.model", String.class, this.kdtInventoryEntry, "model.text");
		dataBinder.registerBinding("InventoryEntry.unit", java.lang.Object.class, this.kdtInventoryEntry, "unit.text");
		dataBinder.registerBinding("InventoryEntry.bagQty", java.math.BigDecimal.class, this.kdtInventoryEntry, "bagQty.text");
		dataBinder.registerBinding("InventoryEntry.unitQty", java.math.BigDecimal.class, this.kdtInventoryEntry, "unitQty.text");
		dataBinder.registerBinding("InventoryEntry.qty", java.math.BigDecimal.class, this.kdtInventoryEntry, "qty.text");
		dataBinder.registerBinding("InventoryEntry.dailyUsgBags", java.math.BigDecimal.class, this.kdtInventoryEntry, "dailyUsgBags.text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("confirmTime", java.util.Date.class, this.pkconfirmTime, "value");
		dataBinder.registerBinding("confirmMsg", String.class, this.txtconfirmMsg, "text");
		dataBinder.registerBinding("farmers", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmers, "data");
		dataBinder.registerBinding("farms", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarms, "data");
		dataBinder.registerBinding("dayAge", int.class, this.txtdayAge, "value");
		dataBinder.registerBinding("temp", java.math.BigDecimal.class, this.txttemp, "value");
		dataBinder.registerBinding("humidity", java.math.BigDecimal.class, this.txthumidity, "value");
		dataBinder.registerBinding("outHygiene", com.kingdee.eas.custom.farmpolling.evaluationLvEnum.class, this.outHygiene, "selectedItem");
		dataBinder.registerBinding("inHygiene", com.kingdee.eas.custom.farmpolling.evaluationLvEnum.class, this.inHygiene, "selectedItem");
		dataBinder.registerBinding("deviceCircumstances", String.class, this.txtdeviceCircumstances, "text");
		dataBinder.registerBinding("drugCircumstances", String.class, this.txtdrugCircumstances, "text");
		dataBinder.registerBinding("stockingFemaleQty", int.class, this.txtstockingFemaleQty, "value");
		dataBinder.registerBinding("deathAndCullMaleQty", int.class, this.txtdeathAndCullMaleQty, "value");
		dataBinder.registerBinding("batch", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtbatch, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("allDeathQty", java.math.BigDecimal.class, this.txtallDeathQty, "value");
		dataBinder.registerBinding("todayDeatchRate", java.math.BigDecimal.class, this.txttodayDeatchRate, "value");
		dataBinder.registerBinding("eightDayDeathQty", java.math.BigDecimal.class, this.txteightDayDeathQty, "value");
		dataBinder.registerBinding("eightDayDeathRate", java.math.BigDecimal.class, this.txteightDayDeathRate, "value");
		dataBinder.registerBinding("totalDeathRate", java.math.BigDecimal.class, this.txttotalDeathRate, "value");
		dataBinder.registerBinding("dayFeed", java.math.BigDecimal.class, this.txtdayFeed, "value");
		dataBinder.registerBinding("oneChickendayFeed", java.math.BigDecimal.class, this.txtoneChickendayFeed, "value");
		dataBinder.registerBinding("actualRestFeed", java.math.BigDecimal.class, this.txtactualRestFeed, "value");
		dataBinder.registerBinding("restFeedDays", java.math.BigDecimal.class, this.txtrestFeedDays, "value");
		dataBinder.registerBinding("standAllFeed", java.math.BigDecimal.class, this.txtstandAllFeed, "value");
		dataBinder.registerBinding("actualAllFeed", java.math.BigDecimal.class, this.txtactualAllFeed, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.feedbiz.app.FarmPollingBillEditUIHandler";
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
        this.billStatus.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo)ov;
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
		getValidateHelper().registerBindProperty("hasConfirm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signInTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signInAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signInX", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signInY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signOutTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signOutAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signOutX", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("signOutY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.bagQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.unitQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("InventoryEntry.dailyUsgBags", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("confirmTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("confirmMsg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmers", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farms", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dayAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("temp", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("humidity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outHygiene", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inHygiene", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deviceCircumstances", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugCircumstances", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stockingFemaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathAndCullMaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allDeathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("todayDeatchRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eightDayDeathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eightDayDeathRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalDeathRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dayFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oneChickendayFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualRestFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("restFeedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standAllFeed", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("actualAllFeed", ValidateHelper.ON_SAVE);    		
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
     * output kdtInventoryEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtInventoryEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtInventoryEntry.getColumn(colIndex).getKey())) {
kdtInventoryEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtInventoryEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtInventoryEntry.getColumn(colIndex).getKey())) {
kdtInventoryEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtInventoryEntry.getCell(rowIndex,"material").getValue(),"model")));

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
        sic.add(new SelectorItemInfo("hasConfirm"));
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("signInTime"));
        sic.add(new SelectorItemInfo("signInAddress"));
        sic.add(new SelectorItemInfo("signInX"));
        sic.add(new SelectorItemInfo("signInY"));
        sic.add(new SelectorItemInfo("signOutTime"));
        sic.add(new SelectorItemInfo("signOutAddress"));
        sic.add(new SelectorItemInfo("signOutX"));
        sic.add(new SelectorItemInfo("signOutY"));
    	sic.add(new SelectorItemInfo("InventoryEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("InventoryEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("InventoryEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("InventoryEntry.material.id"));
			sic.add(new SelectorItemInfo("InventoryEntry.material.number"));
			sic.add(new SelectorItemInfo("InventoryEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("InventoryEntry.materialName"));
    	sic.add(new SelectorItemInfo("InventoryEntry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("InventoryEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("InventoryEntry.unit.id"));
			sic.add(new SelectorItemInfo("InventoryEntry.unit.name"));
        	sic.add(new SelectorItemInfo("InventoryEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("InventoryEntry.bagQty"));
    	sic.add(new SelectorItemInfo("InventoryEntry.unitQty"));
    	sic.add(new SelectorItemInfo("InventoryEntry.qty"));
    	sic.add(new SelectorItemInfo("InventoryEntry.dailyUsgBags"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("person.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("person.id"));
        	sic.add(new SelectorItemInfo("person.number"));
        	sic.add(new SelectorItemInfo("person.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("confirmTime"));
        sic.add(new SelectorItemInfo("confirmMsg"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmers.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmers.id"));
        	sic.add(new SelectorItemInfo("farmers.number"));
        	sic.add(new SelectorItemInfo("farmers.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farms.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farms.id"));
        	sic.add(new SelectorItemInfo("farms.number"));
        	sic.add(new SelectorItemInfo("farms.name"));
		}
        sic.add(new SelectorItemInfo("dayAge"));
        sic.add(new SelectorItemInfo("temp"));
        sic.add(new SelectorItemInfo("humidity"));
        sic.add(new SelectorItemInfo("outHygiene"));
        sic.add(new SelectorItemInfo("inHygiene"));
        sic.add(new SelectorItemInfo("deviceCircumstances"));
        sic.add(new SelectorItemInfo("drugCircumstances"));
        sic.add(new SelectorItemInfo("stockingFemaleQty"));
        sic.add(new SelectorItemInfo("deathAndCullMaleQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batch.id"));
        	sic.add(new SelectorItemInfo("batch.number"));
        	sic.add(new SelectorItemInfo("batch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
        sic.add(new SelectorItemInfo("allDeathQty"));
        sic.add(new SelectorItemInfo("todayDeatchRate"));
        sic.add(new SelectorItemInfo("eightDayDeathQty"));
        sic.add(new SelectorItemInfo("eightDayDeathRate"));
        sic.add(new SelectorItemInfo("totalDeathRate"));
        sic.add(new SelectorItemInfo("dayFeed"));
        sic.add(new SelectorItemInfo("oneChickendayFeed"));
        sic.add(new SelectorItemInfo("actualRestFeed"));
        sic.add(new SelectorItemInfo("restFeedDays"));
        sic.add(new SelectorItemInfo("standAllFeed"));
        sic.add(new SelectorItemInfo("actualAllFeed"));
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
     * output actionDisplayPic_actionPerformed method
     */
    public void actionDisplayPic_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory.getRemoteInstance().displayPic(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory.getRemoteInstance().unAudit(editData);
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
	public RequestContext prepareActionDisplayPic(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionDisplayPic() {
    	return false;
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
     * output ActionDisplayPic class
     */     
    protected class ActionDisplayPic extends ItemAction {     
    
        public ActionDisplayPic()
        {
            this(null);
        }

        public ActionDisplayPic(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionDisplayPic.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDisplayPic.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionDisplayPic.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFarmPollingBillEditUI.this, "ActionDisplayPic", "actionDisplayPic_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractFarmPollingBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmPollingBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.client", "FarmPollingBillEditUI");
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
        return com.kingdee.eas.farm.carnivorous.feedbiz.client.FarmPollingBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/carnivorous/feedbiz/FarmPollingBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.carnivorous.feedbiz.app.FarmPollingBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarmers.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖户"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfarms.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtInventoryEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("billStatus",new Integer(0));
vo.put("outHygiene",new Integer(1));
vo.put("inHygiene",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}