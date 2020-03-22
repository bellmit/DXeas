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
public abstract class AbstractMaterialInfoReqEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMaterialInfoReqEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmodel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcolordisplay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contversion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conterrorMsg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCU;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandActivity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contshortname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contalias;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contforeignname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthelpCode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassistAtrr;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contassistUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contseqUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contregisteredmark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarrantnumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpricepPrecision;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbarcode;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpicturenumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contadmincu;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlengthUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlength;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwidth;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweightUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgrossWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnetWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvolummUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvolume;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continvUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexpirationDate;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisOutSourcePart;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisUseAsstAttrRelation;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMaterialStdEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMaterialStdEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxRate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtshortname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtalias;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtforeignname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txthelpCode;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtassistAtrr;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbaseUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtassistUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtseqUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtregisteredmark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtwarrantnumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpricepPrecision;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbarcode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpicturenumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox status;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtadmincu;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtlengthUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlength;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwidth;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtheight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweightUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtgrossWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtnetWeight;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtvolummUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtvolume;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterialGroup;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtinvUnit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtexpirationDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttaxRate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmodel;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcolordisplay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtversion;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneerrorMsg;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txterrorMsg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCU;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandActivity;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnPassAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem basenotby;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem materialInfoAudit;
    protected com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo editData = null;
    protected ActionMaterialInfoAudit actionMaterialInfoAudit = null;
    protected ActionBasenotby actionBasenotby = null;
    protected ActionAllAudit actionAllAudit = null;
    /**
     * output class constructor
     */
    public AbstractMaterialInfoReqEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMaterialInfoReqEditUI.class.getName());
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
        //actionMaterialInfoAudit
        this.actionMaterialInfoAudit = new ActionMaterialInfoAudit(this);
        getActionManager().registerAction("actionMaterialInfoAudit", actionMaterialInfoAudit);
        this.actionMaterialInfoAudit.setExtendProperty("canForewarn", "true");
        this.actionMaterialInfoAudit.setExtendProperty("userDefined", "true");
        this.actionMaterialInfoAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMaterialInfoAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMaterialInfoAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.contmodel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcolordisplay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contversion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conterrorMsg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCU = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandActivity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contshortname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contalias = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contforeignname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthelpCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassistAtrr = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contassistUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contseqUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contregisteredmark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwarrantnumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpricepPrecision = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbarcode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpicturenumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contadmincu = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlengthUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlength = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwidth = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweightUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgrossWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnetWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvolummUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvolume = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continvUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexpirationDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisOutSourcePart = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisUseAsstAttrRelation = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kdtMaterialStdEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.conttaxRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtshortname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtalias = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtforeignname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthelpCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtassistAtrr = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbaseUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtassistUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtseqUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtregisteredmark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtwarrantnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpricepPrecision = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbarcode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpicturenumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.status = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtadmincu = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtlengthUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtlength = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwidth = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtheight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtweightUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtgrossWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnetWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtvolummUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtvolume = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtmaterialGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtinvUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtexpirationDate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttaxRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmodel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtcolordisplay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtversion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPaneerrorMsg = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txterrorMsg = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtCU = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtstandActivity = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnPassAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.basenotby = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.materialInfoAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.contNumber.setName("contNumber");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contname.setName("contname");
        this.contmodel.setName("contmodel");
        this.contcolordisplay.setName("contcolordisplay");
        this.contAuditor.setName("contAuditor");
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contversion.setName("contversion");
        this.contbillStatus.setName("contbillStatus");
        this.conterrorMsg.setName("conterrorMsg");
        this.contCU.setName("contCU");
        this.contstandActivity.setName("contstandActivity");
        this.txtNumber.setName("txtNumber");
        this.kDPanel1.setName("kDPanel1");
        this.contshortname.setName("contshortname");
        this.contalias.setName("contalias");
        this.contforeignname.setName("contforeignname");
        this.conthelpCode.setName("conthelpCode");
        this.contassistAtrr.setName("contassistAtrr");
        this.contbaseUnit.setName("contbaseUnit");
        this.contassistUnit.setName("contassistUnit");
        this.contseqUnit.setName("contseqUnit");
        this.contregisteredmark.setName("contregisteredmark");
        this.contwarrantnumber.setName("contwarrantnumber");
        this.contpricepPrecision.setName("contpricepPrecision");
        this.contbarcode.setName("contbarcode");
        this.contpicturenumber.setName("contpicturenumber");
        this.contstatus.setName("contstatus");
        this.contadmincu.setName("contadmincu");
        this.contlengthUnit.setName("contlengthUnit");
        this.contlength.setName("contlength");
        this.contwidth.setName("contwidth");
        this.contheight.setName("contheight");
        this.contweightUnit.setName("contweightUnit");
        this.contgrossWeight.setName("contgrossWeight");
        this.contnetWeight.setName("contnetWeight");
        this.contvolummUnit.setName("contvolummUnit");
        this.contvolume.setName("contvolume");
        this.contmaterialGroup.setName("contmaterialGroup");
        this.continvUnit.setName("continvUnit");
        this.contexpirationDate.setName("contexpirationDate");
        this.chkisOutSourcePart.setName("chkisOutSourcePart");
        this.chkisUseAsstAttrRelation.setName("chkisUseAsstAttrRelation");
        this.kdtMaterialStdEntry.setName("kdtMaterialStdEntry");
        this.conttaxRate.setName("conttaxRate");
        this.txtshortname.setName("txtshortname");
        this.txtalias.setName("txtalias");
        this.txtforeignname.setName("txtforeignname");
        this.txthelpCode.setName("txthelpCode");
        this.prmtassistAtrr.setName("prmtassistAtrr");
        this.prmtbaseUnit.setName("prmtbaseUnit");
        this.prmtassistUnit.setName("prmtassistUnit");
        this.prmtseqUnit.setName("prmtseqUnit");
        this.txtregisteredmark.setName("txtregisteredmark");
        this.txtwarrantnumber.setName("txtwarrantnumber");
        this.txtpricepPrecision.setName("txtpricepPrecision");
        this.txtbarcode.setName("txtbarcode");
        this.txtpicturenumber.setName("txtpicturenumber");
        this.status.setName("status");
        this.prmtadmincu.setName("prmtadmincu");
        this.prmtlengthUnit.setName("prmtlengthUnit");
        this.txtlength.setName("txtlength");
        this.txtwidth.setName("txtwidth");
        this.txtheight.setName("txtheight");
        this.prmtweightUnit.setName("prmtweightUnit");
        this.txtgrossWeight.setName("txtgrossWeight");
        this.txtnetWeight.setName("txtnetWeight");
        this.prmtvolummUnit.setName("prmtvolummUnit");
        this.txtvolume.setName("txtvolume");
        this.prmtmaterialGroup.setName("prmtmaterialGroup");
        this.prmtinvUnit.setName("prmtinvUnit");
        this.txtexpirationDate.setName("txtexpirationDate");
        this.txttaxRate.setName("txttaxRate");
        this.txtname.setName("txtname");
        this.txtmodel.setName("txtmodel");
        this.txtcolordisplay.setName("txtcolordisplay");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.txtversion.setName("txtversion");
        this.billStatus.setName("billStatus");
        this.scrollPaneerrorMsg.setName("scrollPaneerrorMsg");
        this.txterrorMsg.setName("txterrorMsg");
        this.prmtCU.setName("prmtCU");
        this.txtstandActivity.setName("txtstandActivity");
        this.btnPassAudit.setName("btnPassAudit");
        this.btnUnPassAudit.setName("btnUnPassAudit");
        this.basenotby.setName("basenotby");
        this.materialInfoAudit.setName("materialInfoAudit");
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
        // contmodel		
        this.contmodel.setBoundLabelText(resHelper.getString("contmodel.boundLabelText"));		
        this.contmodel.setBoundLabelLength(100);		
        this.contmodel.setBoundLabelUnderline(true);		
        this.contmodel.setVisible(true);
        // contcolordisplay		
        this.contcolordisplay.setBoundLabelText(resHelper.getString("contcolordisplay.boundLabelText"));		
        this.contcolordisplay.setBoundLabelLength(100);		
        this.contcolordisplay.setBoundLabelUnderline(true);		
        this.contcolordisplay.setVisible(false);
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
        // contversion		
        this.contversion.setBoundLabelText(resHelper.getString("contversion.boundLabelText"));		
        this.contversion.setBoundLabelLength(100);		
        this.contversion.setBoundLabelUnderline(true);		
        this.contversion.setVisible(false);
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
        // contCU		
        this.contCU.setBoundLabelText(resHelper.getString("contCU.boundLabelText"));		
        this.contCU.setBoundLabelLength(100);		
        this.contCU.setBoundLabelUnderline(true);		
        this.contCU.setVisible(true);
        // contstandActivity		
        this.contstandActivity.setBoundLabelText(resHelper.getString("contstandActivity.boundLabelText"));		
        this.contstandActivity.setBoundLabelLength(100);		
        this.contstandActivity.setBoundLabelUnderline(true);		
        this.contstandActivity.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // kDPanel1
        // contshortname		
        this.contshortname.setBoundLabelText(resHelper.getString("contshortname.boundLabelText"));		
        this.contshortname.setBoundLabelLength(100);		
        this.contshortname.setBoundLabelUnderline(true);		
        this.contshortname.setVisible(true);
        // contalias		
        this.contalias.setBoundLabelText(resHelper.getString("contalias.boundLabelText"));		
        this.contalias.setBoundLabelLength(100);		
        this.contalias.setBoundLabelUnderline(true);		
        this.contalias.setVisible(true);
        // contforeignname		
        this.contforeignname.setBoundLabelText(resHelper.getString("contforeignname.boundLabelText"));		
        this.contforeignname.setBoundLabelLength(100);		
        this.contforeignname.setBoundLabelUnderline(true);		
        this.contforeignname.setVisible(true);
        // conthelpCode		
        this.conthelpCode.setBoundLabelText(resHelper.getString("conthelpCode.boundLabelText"));		
        this.conthelpCode.setBoundLabelLength(100);		
        this.conthelpCode.setBoundLabelUnderline(true);		
        this.conthelpCode.setVisible(true);
        // contassistAtrr		
        this.contassistAtrr.setBoundLabelText(resHelper.getString("contassistAtrr.boundLabelText"));		
        this.contassistAtrr.setBoundLabelLength(100);		
        this.contassistAtrr.setBoundLabelUnderline(true);		
        this.contassistAtrr.setVisible(true);
        // contbaseUnit		
        this.contbaseUnit.setBoundLabelText(resHelper.getString("contbaseUnit.boundLabelText"));		
        this.contbaseUnit.setBoundLabelLength(100);		
        this.contbaseUnit.setBoundLabelUnderline(true);		
        this.contbaseUnit.setVisible(true);
        // contassistUnit		
        this.contassistUnit.setBoundLabelText(resHelper.getString("contassistUnit.boundLabelText"));		
        this.contassistUnit.setBoundLabelLength(100);		
        this.contassistUnit.setBoundLabelUnderline(true);		
        this.contassistUnit.setVisible(true);
        // contseqUnit		
        this.contseqUnit.setBoundLabelText(resHelper.getString("contseqUnit.boundLabelText"));		
        this.contseqUnit.setBoundLabelLength(100);		
        this.contseqUnit.setBoundLabelUnderline(true);		
        this.contseqUnit.setVisible(false);
        // contregisteredmark		
        this.contregisteredmark.setBoundLabelText(resHelper.getString("contregisteredmark.boundLabelText"));		
        this.contregisteredmark.setBoundLabelLength(100);		
        this.contregisteredmark.setBoundLabelUnderline(true);		
        this.contregisteredmark.setVisible(true);
        // contwarrantnumber		
        this.contwarrantnumber.setBoundLabelText(resHelper.getString("contwarrantnumber.boundLabelText"));		
        this.contwarrantnumber.setBoundLabelLength(100);		
        this.contwarrantnumber.setBoundLabelUnderline(true);		
        this.contwarrantnumber.setVisible(true);
        // contpricepPrecision		
        this.contpricepPrecision.setBoundLabelText(resHelper.getString("contpricepPrecision.boundLabelText"));		
        this.contpricepPrecision.setBoundLabelLength(100);		
        this.contpricepPrecision.setBoundLabelUnderline(true);		
        this.contpricepPrecision.setVisible(true);
        // contbarcode		
        this.contbarcode.setBoundLabelText(resHelper.getString("contbarcode.boundLabelText"));		
        this.contbarcode.setBoundLabelLength(100);		
        this.contbarcode.setBoundLabelUnderline(true);		
        this.contbarcode.setVisible(false);
        // contpicturenumber		
        this.contpicturenumber.setBoundLabelText(resHelper.getString("contpicturenumber.boundLabelText"));		
        this.contpicturenumber.setBoundLabelLength(100);		
        this.contpicturenumber.setBoundLabelUnderline(true);		
        this.contpicturenumber.setVisible(true);
        // contstatus		
        this.contstatus.setBoundLabelText(resHelper.getString("contstatus.boundLabelText"));		
        this.contstatus.setBoundLabelLength(100);		
        this.contstatus.setBoundLabelUnderline(true);		
        this.contstatus.setVisible(true);
        // contadmincu		
        this.contadmincu.setBoundLabelText(resHelper.getString("contadmincu.boundLabelText"));		
        this.contadmincu.setBoundLabelLength(100);		
        this.contadmincu.setBoundLabelUnderline(true);		
        this.contadmincu.setVisible(true);
        // contlengthUnit		
        this.contlengthUnit.setBoundLabelText(resHelper.getString("contlengthUnit.boundLabelText"));		
        this.contlengthUnit.setBoundLabelLength(100);		
        this.contlengthUnit.setBoundLabelUnderline(true);		
        this.contlengthUnit.setVisible(false);
        // contlength		
        this.contlength.setBoundLabelText(resHelper.getString("contlength.boundLabelText"));		
        this.contlength.setBoundLabelLength(100);		
        this.contlength.setBoundLabelUnderline(true);		
        this.contlength.setVisible(false);
        // contwidth		
        this.contwidth.setBoundLabelText(resHelper.getString("contwidth.boundLabelText"));		
        this.contwidth.setBoundLabelLength(100);		
        this.contwidth.setBoundLabelUnderline(true);		
        this.contwidth.setVisible(false);
        // contheight		
        this.contheight.setBoundLabelText(resHelper.getString("contheight.boundLabelText"));		
        this.contheight.setBoundLabelLength(100);		
        this.contheight.setBoundLabelUnderline(true);		
        this.contheight.setVisible(false);
        // contweightUnit		
        this.contweightUnit.setBoundLabelText(resHelper.getString("contweightUnit.boundLabelText"));		
        this.contweightUnit.setBoundLabelLength(100);		
        this.contweightUnit.setBoundLabelUnderline(true);		
        this.contweightUnit.setVisible(false);
        // contgrossWeight		
        this.contgrossWeight.setBoundLabelText(resHelper.getString("contgrossWeight.boundLabelText"));		
        this.contgrossWeight.setBoundLabelLength(100);		
        this.contgrossWeight.setBoundLabelUnderline(true);		
        this.contgrossWeight.setVisible(false);
        // contnetWeight		
        this.contnetWeight.setBoundLabelText(resHelper.getString("contnetWeight.boundLabelText"));		
        this.contnetWeight.setBoundLabelLength(100);		
        this.contnetWeight.setBoundLabelUnderline(true);		
        this.contnetWeight.setVisible(false);
        // contvolummUnit		
        this.contvolummUnit.setBoundLabelText(resHelper.getString("contvolummUnit.boundLabelText"));		
        this.contvolummUnit.setBoundLabelLength(100);		
        this.contvolummUnit.setBoundLabelUnderline(true);		
        this.contvolummUnit.setVisible(false);
        // contvolume		
        this.contvolume.setBoundLabelText(resHelper.getString("contvolume.boundLabelText"));		
        this.contvolume.setBoundLabelLength(100);		
        this.contvolume.setBoundLabelUnderline(true);		
        this.contvolume.setVisible(false);
        // contmaterialGroup		
        this.contmaterialGroup.setBoundLabelText(resHelper.getString("contmaterialGroup.boundLabelText"));		
        this.contmaterialGroup.setBoundLabelLength(100);		
        this.contmaterialGroup.setBoundLabelUnderline(true);		
        this.contmaterialGroup.setVisible(true);
        // continvUnit		
        this.continvUnit.setBoundLabelText(resHelper.getString("continvUnit.boundLabelText"));		
        this.continvUnit.setBoundLabelLength(100);		
        this.continvUnit.setBoundLabelUnderline(true);		
        this.continvUnit.setVisible(true);
        // contexpirationDate		
        this.contexpirationDate.setBoundLabelText(resHelper.getString("contexpirationDate.boundLabelText"));		
        this.contexpirationDate.setBoundLabelLength(100);		
        this.contexpirationDate.setBoundLabelUnderline(true);		
        this.contexpirationDate.setVisible(true);
        // chkisOutSourcePart		
        this.chkisOutSourcePart.setText(resHelper.getString("chkisOutSourcePart.text"));		
        this.chkisOutSourcePart.setHorizontalAlignment(2);
        // chkisUseAsstAttrRelation		
        this.chkisUseAsstAttrRelation.setText(resHelper.getString("chkisUseAsstAttrRelation.text"));		
        this.chkisUseAsstAttrRelation.setHorizontalAlignment(2);
        // kdtMaterialStdEntry
		String kdtMaterialStdEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialClassifyStd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"materialClassify\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{materialClassifyStd}</t:Cell><t:Cell>$Resource{materialClassify}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMaterialStdEntry.setFormatXml(resHelper.translateString("kdtMaterialStdEntry",kdtMaterialStdEntryStrXML));

                this.kdtMaterialStdEntry.putBindContents("editData",new String[] {"seq","materialClassifyStd","materialClassify"});


        this.kdtMaterialStdEntry.checkParsed();
        // conttaxRate		
        this.conttaxRate.setBoundLabelText(resHelper.getString("conttaxRate.boundLabelText"));		
        this.conttaxRate.setBoundLabelLength(100);		
        this.conttaxRate.setBoundLabelUnderline(true);		
        this.conttaxRate.setVisible(true);
        // txtshortname		
        this.txtshortname.setHorizontalAlignment(2);		
        this.txtshortname.setMaxLength(100);		
        this.txtshortname.setRequired(false);
        // txtalias		
        this.txtalias.setHorizontalAlignment(2);		
        this.txtalias.setMaxLength(100);		
        this.txtalias.setRequired(false);
        // txtforeignname		
        this.txtforeignname.setHorizontalAlignment(2);		
        this.txtforeignname.setMaxLength(100);		
        this.txtforeignname.setRequired(false);
        // txthelpCode		
        this.txthelpCode.setHorizontalAlignment(2);		
        this.txthelpCode.setMaxLength(100);		
        this.txthelpCode.setRequired(true);
        // prmtassistAtrr		
        this.prmtassistAtrr.setQueryInfo("com.kingdee.eas.basedata.master.material.app.AsstAttrValueF7Query");		
        this.prmtassistAtrr.setEditable(true);		
        this.prmtassistAtrr.setDisplayFormat("$type$");		
        this.prmtassistAtrr.setEditFormat("$number$");		
        this.prmtassistAtrr.setCommitFormat("$number$");		
        this.prmtassistAtrr.setRequired(false);
        // prmtbaseUnit		
        this.prmtbaseUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtbaseUnit.setEditable(true);		
        this.prmtbaseUnit.setDisplayFormat("$name$");		
        this.prmtbaseUnit.setEditFormat("$number$");		
        this.prmtbaseUnit.setCommitFormat("$number$");		
        this.prmtbaseUnit.setRequired(true);
        // prmtassistUnit		
        this.prmtassistUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtassistUnit.setEditable(true);		
        this.prmtassistUnit.setDisplayFormat("$coefficient$");		
        this.prmtassistUnit.setEditFormat("$number$");		
        this.prmtassistUnit.setCommitFormat("$number$");		
        this.prmtassistUnit.setRequired(false);
        // prmtseqUnit		
        this.prmtseqUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtseqUnit.setEditable(true);		
        this.prmtseqUnit.setDisplayFormat("$name$");		
        this.prmtseqUnit.setEditFormat("$number$");		
        this.prmtseqUnit.setCommitFormat("$number$");		
        this.prmtseqUnit.setRequired(false);		
        this.prmtseqUnit.setVisible(false);
        // txtregisteredmark		
        this.txtregisteredmark.setHorizontalAlignment(2);		
        this.txtregisteredmark.setMaxLength(100);		
        this.txtregisteredmark.setRequired(false);
        // txtwarrantnumber		
        this.txtwarrantnumber.setHorizontalAlignment(2);		
        this.txtwarrantnumber.setMaxLength(100);		
        this.txtwarrantnumber.setRequired(false);
        // txtpricepPrecision		
        this.txtpricepPrecision.setHorizontalAlignment(2);		
        this.txtpricepPrecision.setDataType(1);		
        this.txtpricepPrecision.setSupportedEmpty(true);		
        this.txtpricepPrecision.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpricepPrecision.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpricepPrecision.setPrecision(4);		
        this.txtpricepPrecision.setRequired(false);
        // txtbarcode		
        this.txtbarcode.setHorizontalAlignment(2);		
        this.txtbarcode.setMaxLength(100);		
        this.txtbarcode.setRequired(false);		
        this.txtbarcode.setVisible(false);
        // txtpicturenumber		
        this.txtpicturenumber.setHorizontalAlignment(2);		
        this.txtpicturenumber.setMaxLength(100);		
        this.txtpicturenumber.setRequired(false);
        // status		
        this.status.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.master.material.UsedStatusEnum").toArray());		
        this.status.setRequired(false);		
        this.status.setEnabled(false);
        // prmtadmincu		
        this.prmtadmincu.setQueryInfo("com.kingdee.eas.basedata.org.app.CUQuery");		
        this.prmtadmincu.setEditable(true);		
        this.prmtadmincu.setDisplayFormat("$isGrouping$");		
        this.prmtadmincu.setEditFormat("$number$");		
        this.prmtadmincu.setCommitFormat("$number$");		
        this.prmtadmincu.setRequired(false);		
        this.prmtadmincu.setEnabled(false);
        // prmtlengthUnit		
        this.prmtlengthUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtlengthUnit.setEditable(true);		
        this.prmtlengthUnit.setDisplayFormat("$coefficient$");		
        this.prmtlengthUnit.setEditFormat("$number$");		
        this.prmtlengthUnit.setCommitFormat("$number$");		
        this.prmtlengthUnit.setRequired(false);		
        this.prmtlengthUnit.setVisible(false);
        // txtlength		
        this.txtlength.setHorizontalAlignment(2);		
        this.txtlength.setDataType(1);		
        this.txtlength.setSupportedEmpty(true);		
        this.txtlength.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtlength.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtlength.setPrecision(10);		
        this.txtlength.setRequired(false);		
        this.txtlength.setVisible(false);
        // txtwidth		
        this.txtwidth.setHorizontalAlignment(2);		
        this.txtwidth.setDataType(1);		
        this.txtwidth.setSupportedEmpty(true);		
        this.txtwidth.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtwidth.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtwidth.setPrecision(10);		
        this.txtwidth.setRequired(false);		
        this.txtwidth.setVisible(false);
        // txtheight		
        this.txtheight.setHorizontalAlignment(2);		
        this.txtheight.setDataType(1);		
        this.txtheight.setSupportedEmpty(true);		
        this.txtheight.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtheight.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtheight.setPrecision(10);		
        this.txtheight.setRequired(false);		
        this.txtheight.setVisible(false);
        // prmtweightUnit		
        this.prmtweightUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtweightUnit.setEditable(true);		
        this.prmtweightUnit.setDisplayFormat("$coefficient$");		
        this.prmtweightUnit.setEditFormat("$number$");		
        this.prmtweightUnit.setCommitFormat("$number$");		
        this.prmtweightUnit.setRequired(false);		
        this.prmtweightUnit.setVisible(false);
        // txtgrossWeight		
        this.txtgrossWeight.setHorizontalAlignment(2);		
        this.txtgrossWeight.setDataType(1);		
        this.txtgrossWeight.setSupportedEmpty(true);		
        this.txtgrossWeight.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtgrossWeight.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtgrossWeight.setPrecision(10);		
        this.txtgrossWeight.setRequired(false);		
        this.txtgrossWeight.setVisible(false);
        // txtnetWeight		
        this.txtnetWeight.setHorizontalAlignment(2);		
        this.txtnetWeight.setDataType(1);		
        this.txtnetWeight.setSupportedEmpty(true);		
        this.txtnetWeight.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtnetWeight.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtnetWeight.setPrecision(10);		
        this.txtnetWeight.setRequired(false);		
        this.txtnetWeight.setVisible(false);
        // prmtvolummUnit		
        this.prmtvolummUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtvolummUnit.setEditable(true);		
        this.prmtvolummUnit.setDisplayFormat("$coefficient$");		
        this.prmtvolummUnit.setEditFormat("$number$");		
        this.prmtvolummUnit.setCommitFormat("$number$");		
        this.prmtvolummUnit.setRequired(false);		
        this.prmtvolummUnit.setVisible(false);
        // txtvolume		
        this.txtvolume.setHorizontalAlignment(2);		
        this.txtvolume.setDataType(1);		
        this.txtvolume.setSupportedEmpty(true);		
        this.txtvolume.setMinimumValue( new java.math.BigDecimal("-999.9999999999"));		
        this.txtvolume.setMaximumValue( new java.math.BigDecimal("999.9999999999"));		
        this.txtvolume.setPrecision(10);		
        this.txtvolume.setRequired(false);		
        this.txtvolume.setVisible(false);
        // prmtmaterialGroup		
        this.prmtmaterialGroup.setEditable(true);		
        this.prmtmaterialGroup.setDisplayFormat("$name$");		
        this.prmtmaterialGroup.setEditFormat("$number$");		
        this.prmtmaterialGroup.setCommitFormat("$number$");		
        this.prmtmaterialGroup.setRequired(true);
        // prmtinvUnit		
        this.prmtinvUnit.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");		
        this.prmtinvUnit.setEditable(true);		
        this.prmtinvUnit.setDisplayFormat("$name$");		
        this.prmtinvUnit.setEditFormat("$number$");		
        this.prmtinvUnit.setCommitFormat("$number$");		
        this.prmtinvUnit.setRequired(true);
        // txtexpirationDate		
        this.txtexpirationDate.setHorizontalAlignment(2);		
        this.txtexpirationDate.setDataType(0);		
        this.txtexpirationDate.setSupportedEmpty(true);		
        this.txtexpirationDate.setRequired(false);
        // txttaxRate		
        this.txttaxRate.setVisible(true);		
        this.txttaxRate.setDataType(0);		
        this.txttaxRate.setSupportedEmpty(true);		
        this.txttaxRate.setRequired(false);
        // txtname		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(100);		
        this.txtname.setRequired(true);
        // txtmodel		
        this.txtmodel.setHorizontalAlignment(2);		
        this.txtmodel.setMaxLength(100);		
        this.txtmodel.setRequired(false);
        // txtcolordisplay		
        this.txtcolordisplay.setHorizontalAlignment(2);		
        this.txtcolordisplay.setDataType(0);		
        this.txtcolordisplay.setSupportedEmpty(true);		
        this.txtcolordisplay.setRequired(false);		
        this.txtcolordisplay.setVisible(false);
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
        // pkBizDate		
        this.pkBizDate.setEnabled(false);		
        this.pkBizDate.setVisible(false);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // txtversion		
        this.txtversion.setHorizontalAlignment(2);		
        this.txtversion.setDataType(0);		
        this.txtversion.setSupportedEmpty(true);		
        this.txtversion.setRequired(false);		
        this.txtversion.setVisible(false);		
        this.txtversion.setEnabled(false);
        // billStatus		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // scrollPaneerrorMsg
        // txterrorMsg		
        this.txterrorMsg.setRequired(false);		
        this.txterrorMsg.setMaxLength(500);		
        this.txterrorMsg.setEnabled(false);
        // prmtCU		
        this.prmtCU.setEditable(true);		
        this.prmtCU.setDisplayFormat("$name$");		
        this.prmtCU.setEditFormat("$number$");		
        this.prmtCU.setCommitFormat("$number$");		
        this.prmtCU.setRequired(false);		
        this.prmtCU.setEnabled(false);
        // txtstandActivity		
        this.txtstandActivity.setHorizontalAlignment(2);		
        this.txtstandActivity.setDataType(0);		
        this.txtstandActivity.setSupportedEmpty(true);		
        this.txtstandActivity.setRequired(false);		
        this.txtstandActivity.setVisible(false);		
        this.txtstandActivity.setEnabled(false);
        // btnPassAudit
        this.btnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionMaterialInfoAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnPassAudit.setText(resHelper.getString("btnPassAudit.text"));
        // btnUnPassAudit
        this.btnUnPassAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionBasenotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnPassAudit.setText(resHelper.getString("btnUnPassAudit.text"));
        // basenotby
        this.basenotby.setAction((IItemAction)ActionProxyFactory.getProxy(actionBasenotby, new Class[] { IItemAction.class }, getServiceContext()));		
        this.basenotby.setText(resHelper.getString("basenotby.text"));
        // materialInfoAudit
        this.materialInfoAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionMaterialInfoAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.materialInfoAudit.setText(resHelper.getString("materialInfoAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtshortname,txtalias,txtforeignname,txthelpCode,prmtassistAtrr,prmtbaseUnit,prmtassistUnit,prmtseqUnit,txtregisteredmark,txtwarrantnumber,txtpricepPrecision,txtbarcode,txtpicturenumber,status,prmtadmincu,txtversion,prmtlengthUnit,txtlength,txtwidth,txtheight,prmtweightUnit,txtgrossWeight,txtnetWeight,prmtvolummUnit,txtvolume,txtname,prmtmaterialGroup,txtmodel,txtcolordisplay,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,billStatus,txterrorMsg,prmtinvUnit,txtexpirationDate,txtstandActivity,chkisOutSourcePart,chkisUseAsstAttrRelation,prmtCU,kdtMaterialStdEntry,txttaxRate}));
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
        kDTabbedPane1.setBounds(new Rectangle(10, 119, 980, 431));
        this.add(kDTabbedPane1, new KDLayout.Constraints(10, 119, 980, 431, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contname.setBounds(new Rectangle(340, 10, 608, 19));
        this.add(contname, new KDLayout.Constraints(340, 10, 608, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmodel.setBounds(new Rectangle(10, 39, 270, 19));
        this.add(contmodel, new KDLayout.Constraints(10, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcolordisplay.setBounds(new Rectangle(680, 114, 270, 19));
        this.add(contcolordisplay, new KDLayout.Constraints(680, 114, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(10, 564, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(10, 564, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreator.setBounds(new Rectangle(340, 564, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(340, 564, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(340, 590, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(340, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(680, 564, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(680, 564, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(680, 590, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(680, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contBizDate.setBounds(new Rectangle(610, 105, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(610, 105, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(340, 39, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(340, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contversion.setBounds(new Rectangle(666, 109, 270, 19));
        this.add(contversion, new KDLayout.Constraints(666, 109, 270, 19, 0));
        contbillStatus.setBounds(new Rectangle(10, 74, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(10, 74, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conterrorMsg.setBounds(new Rectangle(340, 74, 604, 35));
        this.add(conterrorMsg, new KDLayout.Constraints(340, 74, 604, 35, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCU.setBounds(new Rectangle(10, 590, 270, 19));
        this.add(contCU, new KDLayout.Constraints(10, 590, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandActivity.setBounds(new Rectangle(678, 39, 270, 19));
        this.add(contstandActivity, new KDLayout.Constraints(678, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 979, 398));        contshortname.setBounds(new Rectangle(10, 10, 270, 19));
        kDPanel1.add(contshortname, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contalias.setBounds(new Rectangle(340, 10, 270, 19));
        kDPanel1.add(contalias, new KDLayout.Constraints(340, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contforeignname.setBounds(new Rectangle(680, 10, 270, 19));
        kDPanel1.add(contforeignname, new KDLayout.Constraints(680, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conthelpCode.setBounds(new Rectangle(340, 38, 270, 19));
        kDPanel1.add(conthelpCode, new KDLayout.Constraints(340, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contassistAtrr.setBounds(new Rectangle(680, 38, 270, 19));
        kDPanel1.add(contassistAtrr, new KDLayout.Constraints(680, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseUnit.setBounds(new Rectangle(10, 66, 270, 19));
        kDPanel1.add(contbaseUnit, new KDLayout.Constraints(10, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contassistUnit.setBounds(new Rectangle(340, 66, 270, 19));
        kDPanel1.add(contassistUnit, new KDLayout.Constraints(340, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contseqUnit.setBounds(new Rectangle(10, 363, 270, 19));
        kDPanel1.add(contseqUnit, new KDLayout.Constraints(10, 363, 270, 19, 0));
        contregisteredmark.setBounds(new Rectangle(680, 66, 270, 19));
        kDPanel1.add(contregisteredmark, new KDLayout.Constraints(680, 66, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contwarrantnumber.setBounds(new Rectangle(340, 94, 270, 19));
        kDPanel1.add(contwarrantnumber, new KDLayout.Constraints(340, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpricepPrecision.setBounds(new Rectangle(680, 122, 270, 19));
        kDPanel1.add(contpricepPrecision, new KDLayout.Constraints(680, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbarcode.setBounds(new Rectangle(629, 27, 270, 19));
        kDPanel1.add(contbarcode, new KDLayout.Constraints(629, 27, 270, 19, 0));
        contpicturenumber.setBounds(new Rectangle(10, 122, 270, 19));
        kDPanel1.add(contpicturenumber, new KDLayout.Constraints(10, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstatus.setBounds(new Rectangle(340, 122, 270, 19));
        kDPanel1.add(contstatus, new KDLayout.Constraints(340, 122, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contadmincu.setBounds(new Rectangle(680, 94, 270, 19));
        kDPanel1.add(contadmincu, new KDLayout.Constraints(680, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlengthUnit.setBounds(new Rectangle(10, 293, 270, 19));
        kDPanel1.add(contlengthUnit, new KDLayout.Constraints(10, 293, 270, 19, 0));
        contlength.setBounds(new Rectangle(340, 293, 270, 19));
        kDPanel1.add(contlength, new KDLayout.Constraints(340, 293, 270, 19, 0));
        contwidth.setBounds(new Rectangle(680, 293, 270, 19));
        kDPanel1.add(contwidth, new KDLayout.Constraints(680, 293, 270, 19, 0));
        contheight.setBounds(new Rectangle(10, 316, 270, 19));
        kDPanel1.add(contheight, new KDLayout.Constraints(10, 316, 270, 19, 0));
        contweightUnit.setBounds(new Rectangle(340, 316, 270, 19));
        kDPanel1.add(contweightUnit, new KDLayout.Constraints(340, 316, 270, 19, 0));
        contgrossWeight.setBounds(new Rectangle(680, 316, 270, 19));
        kDPanel1.add(contgrossWeight, new KDLayout.Constraints(680, 316, 270, 19, 0));
        contnetWeight.setBounds(new Rectangle(10, 339, 270, 19));
        kDPanel1.add(contnetWeight, new KDLayout.Constraints(10, 339, 270, 19, 0));
        contvolummUnit.setBounds(new Rectangle(340, 339, 270, 19));
        kDPanel1.add(contvolummUnit, new KDLayout.Constraints(340, 339, 270, 19, 0));
        contvolume.setBounds(new Rectangle(680, 339, 270, 19));
        kDPanel1.add(contvolume, new KDLayout.Constraints(680, 339, 270, 19, 0));
        contmaterialGroup.setBounds(new Rectangle(10, 38, 270, 19));
        kDPanel1.add(contmaterialGroup, new KDLayout.Constraints(10, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        continvUnit.setBounds(new Rectangle(10, 94, 270, 19));
        kDPanel1.add(continvUnit, new KDLayout.Constraints(10, 94, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contexpirationDate.setBounds(new Rectangle(680, 153, 270, 19));
        kDPanel1.add(contexpirationDate, new KDLayout.Constraints(680, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisOutSourcePart.setBounds(new Rectangle(10, 153, 70, 19));
        kDPanel1.add(chkisOutSourcePart, new KDLayout.Constraints(10, 153, 70, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisUseAsstAttrRelation.setBounds(new Rectangle(99, 153, 179, 19));
        kDPanel1.add(chkisUseAsstAttrRelation, new KDLayout.Constraints(99, 153, 179, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtMaterialStdEntry.setBounds(new Rectangle(12, 184, 952, 195));
        kdtMaterialStdEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMaterialStdEntry,new com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryInfo(),null,false);
        kDPanel1.add(kdtMaterialStdEntry_detailPanel, new KDLayout.Constraints(12, 184, 952, 195, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conttaxRate.setBounds(new Rectangle(340, 153, 270, 19));
        kDPanel1.add(conttaxRate, new KDLayout.Constraints(340, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contshortname
        contshortname.setBoundEditor(txtshortname);
        //contalias
        contalias.setBoundEditor(txtalias);
        //contforeignname
        contforeignname.setBoundEditor(txtforeignname);
        //conthelpCode
        conthelpCode.setBoundEditor(txthelpCode);
        //contassistAtrr
        contassistAtrr.setBoundEditor(prmtassistAtrr);
        //contbaseUnit
        contbaseUnit.setBoundEditor(prmtbaseUnit);
        //contassistUnit
        contassistUnit.setBoundEditor(prmtassistUnit);
        //contseqUnit
        contseqUnit.setBoundEditor(prmtseqUnit);
        //contregisteredmark
        contregisteredmark.setBoundEditor(txtregisteredmark);
        //contwarrantnumber
        contwarrantnumber.setBoundEditor(txtwarrantnumber);
        //contpricepPrecision
        contpricepPrecision.setBoundEditor(txtpricepPrecision);
        //contbarcode
        contbarcode.setBoundEditor(txtbarcode);
        //contpicturenumber
        contpicturenumber.setBoundEditor(txtpicturenumber);
        //contstatus
        contstatus.setBoundEditor(status);
        //contadmincu
        contadmincu.setBoundEditor(prmtadmincu);
        //contlengthUnit
        contlengthUnit.setBoundEditor(prmtlengthUnit);
        //contlength
        contlength.setBoundEditor(txtlength);
        //contwidth
        contwidth.setBoundEditor(txtwidth);
        //contheight
        contheight.setBoundEditor(txtheight);
        //contweightUnit
        contweightUnit.setBoundEditor(prmtweightUnit);
        //contgrossWeight
        contgrossWeight.setBoundEditor(txtgrossWeight);
        //contnetWeight
        contnetWeight.setBoundEditor(txtnetWeight);
        //contvolummUnit
        contvolummUnit.setBoundEditor(prmtvolummUnit);
        //contvolume
        contvolume.setBoundEditor(txtvolume);
        //contmaterialGroup
        contmaterialGroup.setBoundEditor(prmtmaterialGroup);
        //continvUnit
        continvUnit.setBoundEditor(prmtinvUnit);
        //contexpirationDate
        contexpirationDate.setBoundEditor(txtexpirationDate);
        //conttaxRate
        conttaxRate.setBoundEditor(txttaxRate);
        //contname
        contname.setBoundEditor(txtname);
        //contmodel
        contmodel.setBoundEditor(txtmodel);
        //contcolordisplay
        contcolordisplay.setBoundEditor(txtcolordisplay);
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
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contversion
        contversion.setBoundEditor(txtversion);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //conterrorMsg
        conterrorMsg.setBoundEditor(scrollPaneerrorMsg);
        //scrollPaneerrorMsg
        scrollPaneerrorMsg.getViewport().add(txterrorMsg, null);
        //contCU
        contCU.setBoundEditor(prmtCU);
        //contstandActivity
        contstandActivity.setBoundEditor(txtstandActivity);

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
        menuBiz.add(materialInfoAudit);
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
		dataBinder.registerBinding("isOutSourcePart", boolean.class, this.chkisOutSourcePart, "selected");
		dataBinder.registerBinding("isUseAsstAttrRelation", boolean.class, this.chkisUseAsstAttrRelation, "selected");
		dataBinder.registerBinding("MaterialStdEntry.seq", int.class, this.kdtMaterialStdEntry, "seq.text");
		dataBinder.registerBinding("MaterialStdEntry", com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryInfo.class, this.kdtMaterialStdEntry, "userObject");
		dataBinder.registerBinding("MaterialStdEntry.materialClassify", java.lang.Object.class, this.kdtMaterialStdEntry, "materialClassify.text");
		dataBinder.registerBinding("MaterialStdEntry.materialClassifyStd", java.lang.Object.class, this.kdtMaterialStdEntry, "materialClassifyStd.text");
		dataBinder.registerBinding("shortname", String.class, this.txtshortname, "text");
		dataBinder.registerBinding("alias", String.class, this.txtalias, "text");
		dataBinder.registerBinding("foreignname", String.class, this.txtforeignname, "text");
		dataBinder.registerBinding("helpCode", String.class, this.txthelpCode, "text");
		dataBinder.registerBinding("assistAtrr", com.kingdee.eas.basedata.master.material.AsstAttrValueInfo.class, this.prmtassistAtrr, "data");
		dataBinder.registerBinding("baseUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtbaseUnit, "data");
		dataBinder.registerBinding("assistUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtassistUnit, "data");
		dataBinder.registerBinding("seqUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtseqUnit, "data");
		dataBinder.registerBinding("registeredmark", String.class, this.txtregisteredmark, "text");
		dataBinder.registerBinding("warrantnumber", String.class, this.txtwarrantnumber, "text");
		dataBinder.registerBinding("pricepPrecision", java.math.BigDecimal.class, this.txtpricepPrecision, "value");
		dataBinder.registerBinding("barcode", String.class, this.txtbarcode, "text");
		dataBinder.registerBinding("picturenumber", String.class, this.txtpicturenumber, "text");
		dataBinder.registerBinding("status", com.kingdee.eas.basedata.master.material.UsedStatusEnum.class, this.status, "selectedItem");
		dataBinder.registerBinding("admincu", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtadmincu, "data");
		dataBinder.registerBinding("lengthUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtlengthUnit, "data");
		dataBinder.registerBinding("length", java.math.BigDecimal.class, this.txtlength, "value");
		dataBinder.registerBinding("width", java.math.BigDecimal.class, this.txtwidth, "value");
		dataBinder.registerBinding("height", java.math.BigDecimal.class, this.txtheight, "value");
		dataBinder.registerBinding("weightUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtweightUnit, "data");
		dataBinder.registerBinding("grossWeight", java.math.BigDecimal.class, this.txtgrossWeight, "value");
		dataBinder.registerBinding("netWeight", java.math.BigDecimal.class, this.txtnetWeight, "value");
		dataBinder.registerBinding("volummUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtvolummUnit, "data");
		dataBinder.registerBinding("volume", java.math.BigDecimal.class, this.txtvolume, "value");
		dataBinder.registerBinding("materialGroup", com.kingdee.eas.basedata.master.material.MaterialGroupInfo.class, this.prmtmaterialGroup, "data");
		dataBinder.registerBinding("invUnit", com.kingdee.eas.basedata.assistant.MeasureUnitInfo.class, this.prmtinvUnit, "data");
		dataBinder.registerBinding("expirationDate", int.class, this.txtexpirationDate, "value");
		dataBinder.registerBinding("taxRate", int.class, this.txttaxRate, "value");
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("model", String.class, this.txtmodel, "text");
		dataBinder.registerBinding("colordisplay", int.class, this.txtcolordisplay, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("version", int.class, this.txtversion, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("errorMsg", String.class, this.txterrorMsg, "text");
		dataBinder.registerBinding("CU", com.kingdee.eas.basedata.org.CtrlUnitInfo.class, this.prmtCU, "data");
		dataBinder.registerBinding("standActivity", int.class, this.txtstandActivity, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.bdm.bdapply.app.MaterialInfoReqEditUIHandler";
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
        this.txtshortname.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo)ov;
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
		getValidateHelper().registerBindProperty("isOutSourcePart", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isUseAsstAttrRelation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialStdEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialStdEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialStdEntry.materialClassify", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MaterialStdEntry.materialClassifyStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("shortname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("alias", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("foreignname", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("helpCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assistAtrr", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("assistUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("seqUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("registeredmark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warrantnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pricepPrecision", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("barcode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("picturenumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("status", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("admincu", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lengthUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("length", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("width", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("height", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weightUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("grossWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("netWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("volummUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("volume", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("invUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("expirationDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("colordisplay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("version", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("errorMsg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CU", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standActivity", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isOutSourcePart"));
        sic.add(new SelectorItemInfo("isUseAsstAttrRelation"));
    	sic.add(new SelectorItemInfo("MaterialStdEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialStdEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassify.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassify.id"));
			sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassify.name"));
        	sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassify.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassifyStd.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassifyStd.id"));
			sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassifyStd.name"));
        	sic.add(new SelectorItemInfo("MaterialStdEntry.materialClassifyStd.number"));
		}
        sic.add(new SelectorItemInfo("shortname"));
        sic.add(new SelectorItemInfo("alias"));
        sic.add(new SelectorItemInfo("foreignname"));
        sic.add(new SelectorItemInfo("helpCode"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("assistAtrr.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("assistAtrr.id"));
        	sic.add(new SelectorItemInfo("assistAtrr.number"));
        	sic.add(new SelectorItemInfo("assistAtrr.name"));
        	sic.add(new SelectorItemInfo("assistAtrr.type"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("baseUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("baseUnit.id"));
        	sic.add(new SelectorItemInfo("baseUnit.number"));
        	sic.add(new SelectorItemInfo("baseUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("assistUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("assistUnit.id"));
        	sic.add(new SelectorItemInfo("assistUnit.number"));
        	sic.add(new SelectorItemInfo("assistUnit.name"));
        	sic.add(new SelectorItemInfo("assistUnit.coefficient"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("seqUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("seqUnit.id"));
        	sic.add(new SelectorItemInfo("seqUnit.number"));
        	sic.add(new SelectorItemInfo("seqUnit.name"));
		}
        sic.add(new SelectorItemInfo("registeredmark"));
        sic.add(new SelectorItemInfo("warrantnumber"));
        sic.add(new SelectorItemInfo("pricepPrecision"));
        sic.add(new SelectorItemInfo("barcode"));
        sic.add(new SelectorItemInfo("picturenumber"));
        sic.add(new SelectorItemInfo("status"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("admincu.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("admincu.id"));
        	sic.add(new SelectorItemInfo("admincu.number"));
        	sic.add(new SelectorItemInfo("admincu.name"));
        	sic.add(new SelectorItemInfo("admincu.isGrouping"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lengthUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lengthUnit.id"));
        	sic.add(new SelectorItemInfo("lengthUnit.number"));
        	sic.add(new SelectorItemInfo("lengthUnit.name"));
        	sic.add(new SelectorItemInfo("lengthUnit.coefficient"));
		}
        sic.add(new SelectorItemInfo("length"));
        sic.add(new SelectorItemInfo("width"));
        sic.add(new SelectorItemInfo("height"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weightUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weightUnit.id"));
        	sic.add(new SelectorItemInfo("weightUnit.number"));
        	sic.add(new SelectorItemInfo("weightUnit.name"));
        	sic.add(new SelectorItemInfo("weightUnit.coefficient"));
		}
        sic.add(new SelectorItemInfo("grossWeight"));
        sic.add(new SelectorItemInfo("netWeight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("volummUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("volummUnit.id"));
        	sic.add(new SelectorItemInfo("volummUnit.number"));
        	sic.add(new SelectorItemInfo("volummUnit.name"));
        	sic.add(new SelectorItemInfo("volummUnit.coefficient"));
		}
        sic.add(new SelectorItemInfo("volume"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("materialGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("materialGroup.id"));
        	sic.add(new SelectorItemInfo("materialGroup.number"));
        	sic.add(new SelectorItemInfo("materialGroup.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("invUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("invUnit.id"));
        	sic.add(new SelectorItemInfo("invUnit.number"));
        	sic.add(new SelectorItemInfo("invUnit.name"));
		}
        sic.add(new SelectorItemInfo("expirationDate"));
        sic.add(new SelectorItemInfo("taxRate"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("model"));
        sic.add(new SelectorItemInfo("colordisplay"));
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
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("version"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("errorMsg"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CU.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CU.id"));
        	sic.add(new SelectorItemInfo("CU.number"));
        	sic.add(new SelectorItemInfo("CU.name"));
		}
        sic.add(new SelectorItemInfo("standActivity"));
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
     * output actionMaterialInfoAudit_actionPerformed method
     */
    public void actionMaterialInfoAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.MaterialInfoReqFactory.getRemoteInstance().materialInfoAudit(editData);
    }
    	

    /**
     * output actionBasenotby_actionPerformed method
     */
    public void actionBasenotby_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.MaterialInfoReqFactory.getRemoteInstance().basenotby(editData);
    }
    	

    /**
     * output actionAllAudit_actionPerformed method
     */
    public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.bdm.bdapply.MaterialInfoReqFactory.getRemoteInstance().allAudit(editData);
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
	public RequestContext prepareActionMaterialInfoAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMaterialInfoAudit() {
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
     * output ActionMaterialInfoAudit class
     */     
    protected class ActionMaterialInfoAudit extends ItemAction {     
    
        public ActionMaterialInfoAudit()
        {
            this(null);
        }

        public ActionMaterialInfoAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMaterialInfoAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMaterialInfoAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMaterialInfoAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractMaterialInfoReqEditUI.this, "ActionMaterialInfoAudit", "actionMaterialInfoAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMaterialInfoReqEditUI.this, "ActionBasenotby", "actionBasenotby_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractMaterialInfoReqEditUI.this, "ActionAllAudit", "actionAllAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.bdm.bdapply.client", "MaterialInfoReqEditUI");
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
        return com.kingdee.eas.bdm.bdapply.client.MaterialInfoReqEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.bdm.bdapply.MaterialInfoReqFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/bdm/bdapply/MaterialInfoReq";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.bdm.bdapply.app.MaterialInfoReqQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtMaterialStdEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtMaterialStdEntry.getCell(i,"materialClassifyStd").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"分类标准"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txthelpCode.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"助记码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbaseUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"基本计量单位"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtmaterialGroup.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料分类"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtinvUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存用计量单位"});
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
        return kdtMaterialStdEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
				vo.put("pricepPrecision",new java.math.BigDecimal(6));
vo.put("status",new Integer(0));
vo.put("billStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}