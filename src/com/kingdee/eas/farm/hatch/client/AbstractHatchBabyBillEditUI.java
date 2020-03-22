/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

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
public abstract class AbstractHatchBabyBillEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchBabyBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransferBoxBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcommercialStoorg;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallTransQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthealthQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlossQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherLossQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contunhatchedEggQty;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherStoorg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherHealthQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoneHealthQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPanetransDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txttransDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmttransferBoxBill;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcommercialStoorg;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtImmuneEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtImmuneEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSaleEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSaleEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallTransQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthealthQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdeathQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlossQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherLossQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtunhatchedEggQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtotherStoorg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherHealthQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoneHealthQty;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.farm.hatch.HatchBabyBillInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractHatchBabyBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchBabyBillEditUI.class.getName());
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
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransferBoxBill = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcommercialStoorg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contstorageOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallTransQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthealthQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdeathQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherLossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contunhatchedEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contotherStoorg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherHealthQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoneHealthQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.scrollPanetransDescription = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txttransDescription = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmttransferBoxBill = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcommercialStoorg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtImmuneEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSaleEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtstorageOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtallTransQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthealthQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdeathQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtlossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherLossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtunhatchedEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtotherStoorg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtotherHealthQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoneHealthQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contperson.setName("contperson");
        this.contauditTime.setName("contauditTime");
        this.contbaseStatus.setName("contbaseStatus");
        this.conttransDescription.setName("conttransDescription");
        this.conttransferBoxBill.setName("conttransferBoxBill");
        this.contcommercialStoorg.setName("contcommercialStoorg");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contstorageOrg.setName("contstorageOrg");
        this.contcompany.setName("contcompany");
        this.contallTransQty.setName("contallTransQty");
        this.conthealthQty.setName("conthealthQty");
        this.contdeathQty.setName("contdeathQty");
        this.contlossQty.setName("contlossQty");
        this.contotherLossQty.setName("contotherLossQty");
        this.contunhatchedEggQty.setName("contunhatchedEggQty");
        this.kDSeparator8.setName("kDSeparator8");
        this.contotherStoorg.setName("contotherStoorg");
        this.contotherHealthQty.setName("contotherHealthQty");
        this.contoneHealthQty.setName("contoneHealthQty");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtperson.setName("prmtperson");
        this.pkauditTime.setName("pkauditTime");
        this.baseStatus.setName("baseStatus");
        this.scrollPanetransDescription.setName("scrollPanetransDescription");
        this.txttransDescription.setName("txttransDescription");
        this.prmttransferBoxBill.setName("prmttransferBoxBill");
        this.prmtcommercialStoorg.setName("prmtcommercialStoorg");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtImmuneEntrys.setName("kdtImmuneEntrys");
        this.kdtSaleEntry.setName("kdtSaleEntry");
        this.prmtstorageOrg.setName("prmtstorageOrg");
        this.prmtcompany.setName("prmtcompany");
        this.txtallTransQty.setName("txtallTransQty");
        this.txthealthQty.setName("txthealthQty");
        this.txtdeathQty.setName("txtdeathQty");
        this.txtlossQty.setName("txtlossQty");
        this.txtotherLossQty.setName("txtotherLossQty");
        this.txtunhatchedEggQty.setName("txtunhatchedEggQty");
        this.prmtotherStoorg.setName("prmtotherStoorg");
        this.txtotherHealthQty.setName("txtotherHealthQty");
        this.txtoneHealthQty.setName("txtoneHealthQty");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // conttransDescription		
        this.conttransDescription.setBoundLabelText(resHelper.getString("conttransDescription.boundLabelText"));		
        this.conttransDescription.setBoundLabelLength(100);		
        this.conttransDescription.setBoundLabelUnderline(true);		
        this.conttransDescription.setVisible(true);
        // conttransferBoxBill		
        this.conttransferBoxBill.setBoundLabelText(resHelper.getString("conttransferBoxBill.boundLabelText"));		
        this.conttransferBoxBill.setBoundLabelLength(100);		
        this.conttransferBoxBill.setBoundLabelUnderline(true);		
        this.conttransferBoxBill.setVisible(true);
        // contcommercialStoorg		
        this.contcommercialStoorg.setBoundLabelText(resHelper.getString("contcommercialStoorg.boundLabelText"));		
        this.contcommercialStoorg.setBoundLabelLength(100);		
        this.contcommercialStoorg.setBoundLabelUnderline(true);		
        this.contcommercialStoorg.setVisible(true);
        // kDTabbedPane1
        // contstorageOrg		
        this.contstorageOrg.setBoundLabelText(resHelper.getString("contstorageOrg.boundLabelText"));		
        this.contstorageOrg.setBoundLabelLength(100);		
        this.contstorageOrg.setBoundLabelUnderline(true);		
        this.contstorageOrg.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contallTransQty		
        this.contallTransQty.setBoundLabelText(resHelper.getString("contallTransQty.boundLabelText"));		
        this.contallTransQty.setBoundLabelLength(100);		
        this.contallTransQty.setBoundLabelUnderline(true);		
        this.contallTransQty.setVisible(true);
        // conthealthQty		
        this.conthealthQty.setBoundLabelText(resHelper.getString("conthealthQty.boundLabelText"));		
        this.conthealthQty.setBoundLabelLength(100);		
        this.conthealthQty.setBoundLabelUnderline(true);		
        this.conthealthQty.setVisible(true);
        // contdeathQty		
        this.contdeathQty.setBoundLabelText(resHelper.getString("contdeathQty.boundLabelText"));		
        this.contdeathQty.setBoundLabelLength(100);		
        this.contdeathQty.setBoundLabelUnderline(true);		
        this.contdeathQty.setVisible(true);
        // contlossQty		
        this.contlossQty.setBoundLabelText(resHelper.getString("contlossQty.boundLabelText"));		
        this.contlossQty.setBoundLabelLength(100);		
        this.contlossQty.setBoundLabelUnderline(true);		
        this.contlossQty.setVisible(true);
        // contotherLossQty		
        this.contotherLossQty.setBoundLabelText(resHelper.getString("contotherLossQty.boundLabelText"));		
        this.contotherLossQty.setBoundLabelLength(100);		
        this.contotherLossQty.setBoundLabelUnderline(true);		
        this.contotherLossQty.setVisible(true);
        // contunhatchedEggQty		
        this.contunhatchedEggQty.setBoundLabelText(resHelper.getString("contunhatchedEggQty.boundLabelText"));		
        this.contunhatchedEggQty.setBoundLabelLength(100);		
        this.contunhatchedEggQty.setBoundLabelUnderline(true);		
        this.contunhatchedEggQty.setVisible(true);
        // kDSeparator8
        // contotherStoorg		
        this.contotherStoorg.setBoundLabelText(resHelper.getString("contotherStoorg.boundLabelText"));		
        this.contotherStoorg.setBoundLabelLength(100);		
        this.contotherStoorg.setBoundLabelUnderline(true);		
        this.contotherStoorg.setVisible(true);
        // contotherHealthQty		
        this.contotherHealthQty.setBoundLabelText(resHelper.getString("contotherHealthQty.boundLabelText"));		
        this.contotherHealthQty.setBoundLabelLength(100);		
        this.contotherHealthQty.setBoundLabelUnderline(true);		
        this.contotherHealthQty.setVisible(true);
        // contoneHealthQty		
        this.contoneHealthQty.setBoundLabelText(resHelper.getString("contoneHealthQty.boundLabelText"));		
        this.contoneHealthQty.setBoundLabelLength(100);		
        this.contoneHealthQty.setBoundLabelUnderline(true);		
        this.contoneHealthQty.setVisible(true);
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
        this.txtNumber.setRequired(true);
        // pkBizDate		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(true);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(true);		
        this.baseStatus.setEnabled(false);
        // scrollPanetransDescription
        // txttransDescription		
        this.txttransDescription.setRequired(false);		
        this.txttransDescription.setMaxLength(500);
        // prmttransferBoxBill		
        this.prmttransferBoxBill.setQueryInfo("com.kingdee.eas.farm.hatch.app.TranferBoxBillQuery");		
        this.prmttransferBoxBill.setEditable(true);		
        this.prmttransferBoxBill.setDisplayFormat("$number$");		
        this.prmttransferBoxBill.setEditFormat("$number$");		
        this.prmttransferBoxBill.setCommitFormat("$number$");		
        this.prmttransferBoxBill.setRequired(true);
        this.prmttransferBoxBill.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmttransferBoxBill_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // prmtcommercialStoorg		
        this.prmtcommercialStoorg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtcommercialStoorg.setEditable(true);		
        this.prmtcommercialStoorg.setDisplayFormat("$name$");		
        this.prmtcommercialStoorg.setEditFormat("$number$");		
        this.prmtcommercialStoorg.setCommitFormat("$number$");		
        this.prmtcommercialStoorg.setRequired(false);
        this.prmtcommercialStoorg.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    prmtcommercialStoorg_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"hatchingBox\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"transQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"healthQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"dealthQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"lossQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unhatchedEgg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"description\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{hatchingBox}</t:Cell><t:Cell>$Resource{transQty}</t:Cell><t:Cell>$Resource{healthQty}</t:Cell><t:Cell>$Resource{dealthQty}</t:Cell><t:Cell>$Resource{lossQty}</t:Cell><t:Cell>$Resource{unhatchedEgg}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"id","hatchingBox","transQty","healthQty","dealthQty","lossQty","unhatchedEgg","description"});


        this.kdtEntrys.checkParsed();
        final KDBizPromptBox kdtEntrys_hatchingBox_PromptBox = new KDBizPromptBox();
        kdtEntrys_hatchingBox_PromptBox.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchingBoxQuery");
        kdtEntrys_hatchingBox_PromptBox.setVisible(true);
        kdtEntrys_hatchingBox_PromptBox.setEditable(true);
        kdtEntrys_hatchingBox_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_hatchingBox_PromptBox.setEditFormat("$number$");
        kdtEntrys_hatchingBox_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_hatchingBox_CellEditor = new KDTDefaultCellEditor(kdtEntrys_hatchingBox_PromptBox);
        this.kdtEntrys.getColumn("hatchingBox").setEditor(kdtEntrys_hatchingBox_CellEditor);
        ObjectValueRender kdtEntrys_hatchingBox_OVR = new ObjectValueRender();
        kdtEntrys_hatchingBox_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("hatchingBox").setRenderer(kdtEntrys_hatchingBox_OVR);
        			kdtEntrys_hatchingBox_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.hatch.client.HatchingBoxListUI kdtEntrys_hatchingBox_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_hatchingBox_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_hatchingBox_PromptBox_F7ListUI = new com.kingdee.eas.farm.hatch.client.HatchingBoxListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_hatchingBox_PromptBox_F7ListUI));
					kdtEntrys_hatchingBox_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_hatchingBox_PromptBox.setSelector(kdtEntrys_hatchingBox_PromptBox_F7ListUI);
				}
			}
		});
					
        KDFormattedTextField kdtEntrys_transQty_TextField = new KDFormattedTextField();
        kdtEntrys_transQty_TextField.setName("kdtEntrys_transQty_TextField");
        kdtEntrys_transQty_TextField.setVisible(true);
        kdtEntrys_transQty_TextField.setEditable(true);
        kdtEntrys_transQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_transQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_transQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_transQty_TextField);
        this.kdtEntrys.getColumn("transQty").setEditor(kdtEntrys_transQty_CellEditor);
        KDFormattedTextField kdtEntrys_healthQty_TextField = new KDFormattedTextField();
        kdtEntrys_healthQty_TextField.setName("kdtEntrys_healthQty_TextField");
        kdtEntrys_healthQty_TextField.setVisible(true);
        kdtEntrys_healthQty_TextField.setEditable(true);
        kdtEntrys_healthQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_healthQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_healthQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_healthQty_TextField);
        this.kdtEntrys.getColumn("healthQty").setEditor(kdtEntrys_healthQty_CellEditor);
        KDFormattedTextField kdtEntrys_dealthQty_TextField = new KDFormattedTextField();
        kdtEntrys_dealthQty_TextField.setName("kdtEntrys_dealthQty_TextField");
        kdtEntrys_dealthQty_TextField.setVisible(true);
        kdtEntrys_dealthQty_TextField.setEditable(true);
        kdtEntrys_dealthQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_dealthQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_dealthQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dealthQty_TextField);
        this.kdtEntrys.getColumn("dealthQty").setEditor(kdtEntrys_dealthQty_CellEditor);
        KDFormattedTextField kdtEntrys_lossQty_TextField = new KDFormattedTextField();
        kdtEntrys_lossQty_TextField.setName("kdtEntrys_lossQty_TextField");
        kdtEntrys_lossQty_TextField.setVisible(true);
        kdtEntrys_lossQty_TextField.setEditable(true);
        kdtEntrys_lossQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_lossQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_lossQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lossQty_TextField);
        this.kdtEntrys.getColumn("lossQty").setEditor(kdtEntrys_lossQty_CellEditor);
        KDFormattedTextField kdtEntrys_unhatchedEgg_TextField = new KDFormattedTextField();
        kdtEntrys_unhatchedEgg_TextField.setName("kdtEntrys_unhatchedEgg_TextField");
        kdtEntrys_unhatchedEgg_TextField.setVisible(true);
        kdtEntrys_unhatchedEgg_TextField.setEditable(true);
        kdtEntrys_unhatchedEgg_TextField.setHorizontalAlignment(2);
        kdtEntrys_unhatchedEgg_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_unhatchedEgg_CellEditor = new KDTDefaultCellEditor(kdtEntrys_unhatchedEgg_TextField);
        this.kdtEntrys.getColumn("unhatchedEgg").setEditor(kdtEntrys_unhatchedEgg_CellEditor);
        KDTextArea kdtEntrys_description_TextArea = new KDTextArea();
        kdtEntrys_description_TextArea.setName("kdtEntrys_description_TextArea");
        kdtEntrys_description_TextArea.setMaxLength(255);
        KDTDefaultCellEditor kdtEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtEntrys_description_TextArea);
        this.kdtEntrys.getColumn("description").setEditor(kdtEntrys_description_CellEditor);
        // kdtImmuneEntrys
		String kdtImmuneEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"immuneMaterial\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"usedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"description\" t:width=\"400\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{immuneMaterial}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{usedQty}</t:Cell><t:Cell>$Resource{description}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtImmuneEntrys.setFormatXml(resHelper.translateString("kdtImmuneEntrys",kdtImmuneEntrysStrXML));
        kdtImmuneEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtImmuneEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtImmuneEntrys.putBindContents("editData",new String[] {"seq","immuneMaterial","unit","usedQty","description"});


        this.kdtImmuneEntrys.checkParsed();
        KDFormattedTextField kdtImmuneEntrys_seq_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_seq_TextField.setName("kdtImmuneEntrys_seq_TextField");
        kdtImmuneEntrys_seq_TextField.setVisible(true);
        kdtImmuneEntrys_seq_TextField.setEditable(true);
        kdtImmuneEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_seq_TextField);
        this.kdtImmuneEntrys.getColumn("seq").setEditor(kdtImmuneEntrys_seq_CellEditor);
        final KDBizPromptBox kdtImmuneEntrys_immuneMaterial_PromptBox = new KDBizPromptBox();
        kdtImmuneEntrys_immuneMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setVisible(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditable(true);
        kdtImmuneEntrys_immuneMaterial_PromptBox.setDisplayFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setEditFormat("$number$");
        kdtImmuneEntrys_immuneMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtImmuneEntrys_immuneMaterial_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_immuneMaterial_PromptBox);
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setEditor(kdtImmuneEntrys_immuneMaterial_CellEditor);
        ObjectValueRender kdtImmuneEntrys_immuneMaterial_OVR = new ObjectValueRender();
        kdtImmuneEntrys_immuneMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtImmuneEntrys.getColumn("immuneMaterial").setRenderer(kdtImmuneEntrys_immuneMaterial_OVR);
        KDTextField kdtImmuneEntrys_unit_TextField = new KDTextField();
        kdtImmuneEntrys_unit_TextField.setName("kdtImmuneEntrys_unit_TextField");
        kdtImmuneEntrys_unit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtImmuneEntrys_unit_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_unit_TextField);
        this.kdtImmuneEntrys.getColumn("unit").setEditor(kdtImmuneEntrys_unit_CellEditor);
        KDFormattedTextField kdtImmuneEntrys_usedQty_TextField = new KDFormattedTextField();
        kdtImmuneEntrys_usedQty_TextField.setName("kdtImmuneEntrys_usedQty_TextField");
        kdtImmuneEntrys_usedQty_TextField.setVisible(true);
        kdtImmuneEntrys_usedQty_TextField.setEditable(true);
        kdtImmuneEntrys_usedQty_TextField.setHorizontalAlignment(2);
        kdtImmuneEntrys_usedQty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtImmuneEntrys_usedQty_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_usedQty_TextField);
        this.kdtImmuneEntrys.getColumn("usedQty").setEditor(kdtImmuneEntrys_usedQty_CellEditor);
        KDTextField kdtImmuneEntrys_description_TextField = new KDTextField();
        kdtImmuneEntrys_description_TextField.setName("kdtImmuneEntrys_description_TextField");
        kdtImmuneEntrys_description_TextField.setMaxLength(255);
        KDTDefaultCellEditor kdtImmuneEntrys_description_CellEditor = new KDTDefaultCellEditor(kdtImmuneEntrys_description_TextField);
        this.kdtImmuneEntrys.getColumn("description").setEditor(kdtImmuneEntrys_description_CellEditor);
        // kdtSaleEntry
		String kdtSaleEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"customer\" t:width=\"350\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSaleEntry.setFormatXml(resHelper.translateString("kdtSaleEntry",kdtSaleEntryStrXML));

                this.kdtSaleEntry.putBindContents("editData",new String[] {"seq","customer","qty","price"});


        this.kdtSaleEntry.checkParsed();
        KDFormattedTextField kdtSaleEntry_seq_TextField = new KDFormattedTextField();
        kdtSaleEntry_seq_TextField.setName("kdtSaleEntry_seq_TextField");
        kdtSaleEntry_seq_TextField.setVisible(true);
        kdtSaleEntry_seq_TextField.setEditable(true);
        kdtSaleEntry_seq_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_seq_TextField);
        this.kdtSaleEntry.getColumn("seq").setEditor(kdtSaleEntry_seq_CellEditor);
        final KDBizPromptBox kdtSaleEntry_customer_PromptBox = new KDBizPromptBox();
        kdtSaleEntry_customer_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtSaleEntry_customer_PromptBox.setVisible(true);
        kdtSaleEntry_customer_PromptBox.setEditable(true);
        kdtSaleEntry_customer_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntry_customer_PromptBox.setEditFormat("$number$");
        kdtSaleEntry_customer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntry_customer_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_customer_PromptBox);
        this.kdtSaleEntry.getColumn("customer").setEditor(kdtSaleEntry_customer_CellEditor);
        ObjectValueRender kdtSaleEntry_customer_OVR = new ObjectValueRender();
        kdtSaleEntry_customer_OVR.setFormat(new BizDataFormat("$number$-$name$"));
        this.kdtSaleEntry.getColumn("customer").setRenderer(kdtSaleEntry_customer_OVR);
        KDFormattedTextField kdtSaleEntry_qty_TextField = new KDFormattedTextField();
        kdtSaleEntry_qty_TextField.setName("kdtSaleEntry_qty_TextField");
        kdtSaleEntry_qty_TextField.setVisible(true);
        kdtSaleEntry_qty_TextField.setEditable(true);
        kdtSaleEntry_qty_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_qty_TextField.setDataType(0);
        KDTDefaultCellEditor kdtSaleEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_qty_TextField);
        this.kdtSaleEntry.getColumn("qty").setEditor(kdtSaleEntry_qty_CellEditor);
        KDFormattedTextField kdtSaleEntry_price_TextField = new KDFormattedTextField();
        kdtSaleEntry_price_TextField.setName("kdtSaleEntry_price_TextField");
        kdtSaleEntry_price_TextField.setVisible(true);
        kdtSaleEntry_price_TextField.setEditable(true);
        kdtSaleEntry_price_TextField.setHorizontalAlignment(2);
        kdtSaleEntry_price_TextField.setDataType(1);
        	kdtSaleEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtSaleEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtSaleEntry_price_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtSaleEntry_price_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_price_TextField);
        this.kdtSaleEntry.getColumn("price").setEditor(kdtSaleEntry_price_CellEditor);
        // prmtstorageOrg		
        this.prmtstorageOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrg.setEditable(true);		
        this.prmtstorageOrg.setDisplayFormat("$name$");		
        this.prmtstorageOrg.setEditFormat("$number$");		
        this.prmtstorageOrg.setCommitFormat("$number$");		
        this.prmtstorageOrg.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txtallTransQty		
        this.txtallTransQty.setHorizontalAlignment(2);		
        this.txtallTransQty.setDataType(0);		
        this.txtallTransQty.setSupportedEmpty(true);		
        this.txtallTransQty.setRequired(false);		
        this.txtallTransQty.setEnabled(false);
        // txthealthQty		
        this.txthealthQty.setHorizontalAlignment(2);		
        this.txthealthQty.setDataType(0);		
        this.txthealthQty.setSupportedEmpty(true);		
        this.txthealthQty.setRequired(false);
        txthealthQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txthealthQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtdeathQty		
        this.txtdeathQty.setHorizontalAlignment(2);		
        this.txtdeathQty.setDataType(0);		
        this.txtdeathQty.setSupportedEmpty(true);		
        this.txtdeathQty.setRequired(false);
        // txtlossQty		
        this.txtlossQty.setHorizontalAlignment(2);		
        this.txtlossQty.setDataType(0);		
        this.txtlossQty.setSupportedEmpty(true);		
        this.txtlossQty.setRequired(false);
        // txtotherLossQty		
        this.txtotherLossQty.setHorizontalAlignment(2);		
        this.txtotherLossQty.setDataType(0);		
        this.txtotherLossQty.setSupportedEmpty(true);		
        this.txtotherLossQty.setRequired(false);
        // txtunhatchedEggQty		
        this.txtunhatchedEggQty.setHorizontalAlignment(2);		
        this.txtunhatchedEggQty.setDataType(0);		
        this.txtunhatchedEggQty.setSupportedEmpty(true);		
        this.txtunhatchedEggQty.setRequired(false);
        // prmtotherStoorg		
        this.prmtotherStoorg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtotherStoorg.setVisible(true);		
        this.prmtotherStoorg.setEditable(true);		
        this.prmtotherStoorg.setDisplayFormat("$name$");		
        this.prmtotherStoorg.setEditFormat("$number$");		
        this.prmtotherStoorg.setCommitFormat("$number$");		
        this.prmtotherStoorg.setRequired(false);
        // txtotherHealthQty		
        this.txtotherHealthQty.setVisible(true);		
        this.txtotherHealthQty.setHorizontalAlignment(2);		
        this.txtotherHealthQty.setDataType(0);		
        this.txtotherHealthQty.setSupportedEmpty(true);		
        this.txtotherHealthQty.setRequired(false);
        txtotherHealthQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtotherHealthQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtoneHealthQty		
        this.txtoneHealthQty.setVisible(true);		
        this.txtoneHealthQty.setHorizontalAlignment(2);		
        this.txtoneHealthQty.setDataType(0);		
        this.txtoneHealthQty.setSupportedEmpty(true);		
        this.txtoneHealthQty.setRequired(false);		
        this.txtoneHealthQty.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtperson,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,pkauditTime,baseStatus,txttransDescription,prmttransferBoxBill,prmtcommercialStoorg,prmtstorageOrg,prmtcompany,txtallTransQty,txthealthQty,txtdeathQty,txtlossQty,kdtEntrys,txtotherLossQty,kdtImmuneEntrys,txtunhatchedEggQty,prmtotherStoorg,txtotherHealthQty,txtoneHealthQty}));
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
        contCreator.setBounds(new Rectangle(13, 558, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(13, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(13, 587, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(13, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(370, 558, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(370, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(370, 587, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(370, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(13, 16, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(13, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(719, 16, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(719, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contDescription.setBounds(new Rectangle(13, -118, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(13, -118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contAuditor.setBounds(new Rectangle(727, 558, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(727, 558, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contperson.setBounds(new Rectangle(366, 48, 270, 19));
        this.add(contperson, new KDLayout.Constraints(366, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(727, 587, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(727, 587, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(719, 48, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(719, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttransDescription.setBounds(new Rectangle(13, 162, 993, 71));
        this.add(conttransDescription, new KDLayout.Constraints(13, 162, 993, 71, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        conttransferBoxBill.setBounds(new Rectangle(366, 16, 270, 19));
        this.add(conttransferBoxBill, new KDLayout.Constraints(366, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcommercialStoorg.setBounds(new Rectangle(13, 48, 270, 19));
        this.add(contcommercialStoorg, new KDLayout.Constraints(13, 48, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(11, 237, 986, 315));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 237, 986, 315, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contstorageOrg.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contstorageOrg, new KDLayout.Constraints(0, -100, 270, 19, 0));
        contcompany.setBounds(new Rectangle(0, -100, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(0, -100, 270, 19, 0));
        contallTransQty.setBounds(new Rectangle(13, 78, 270, 19));
        this.add(contallTransQty, new KDLayout.Constraints(13, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthealthQty.setBounds(new Rectangle(366, 78, 270, 19));
        this.add(conthealthQty, new KDLayout.Constraints(366, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdeathQty.setBounds(new Rectangle(719, 78, 270, 19));
        this.add(contdeathQty, new KDLayout.Constraints(719, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlossQty.setBounds(new Rectangle(366, 107, 270, 19));
        this.add(contlossQty, new KDLayout.Constraints(366, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherLossQty.setBounds(new Rectangle(719, 107, 270, 19));
        this.add(contotherLossQty, new KDLayout.Constraints(719, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contunhatchedEggQty.setBounds(new Rectangle(13, 107, 270, 19));
        this.add(contunhatchedEggQty, new KDLayout.Constraints(13, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator8.setBounds(new Rectangle(7, 130, 1000, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(7, 130, 1000, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contotherStoorg.setBounds(new Rectangle(366, 136, 270, 19));
        this.add(contotherStoorg, new KDLayout.Constraints(366, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherHealthQty.setBounds(new Rectangle(719, 136, 270, 19));
        this.add(contotherHealthQty, new KDLayout.Constraints(719, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoneHealthQty.setBounds(new Rectangle(13, 136, 270, 19));
        this.add(contoneHealthQty, new KDLayout.Constraints(13, 136, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contperson
        contperson.setBoundEditor(prmtperson);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //conttransDescription
        conttransDescription.setBoundEditor(scrollPanetransDescription);
        //scrollPanetransDescription
        scrollPanetransDescription.getViewport().add(txttransDescription, null);
        //conttransferBoxBill
        conttransferBoxBill.setBoundEditor(prmttransferBoxBill);
        //contcommercialStoorg
        contcommercialStoorg.setBoundEditor(prmtcommercialStoorg);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 282));        kdtEntrys.setBounds(new Rectangle(0, 0, 982, 282));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.hatch.HatchBabyBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(0, 0, 982, 282, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 985, 282));        kdtImmuneEntrys.setBounds(new Rectangle(0, 0, 981, 284));
        kdtImmuneEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtImmuneEntrys,new com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryInfo(),null,false);
        kDPanel2.add(kdtImmuneEntrys_detailPanel, new KDLayout.Constraints(0, 0, 981, 284, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(null);        kdtSaleEntry.setBounds(new Rectangle(2, 0, 974, 280));
        kdtSaleEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSaleEntry,new com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryInfo(),null,false);
        kDPanel3.add(kdtSaleEntry_detailPanel, null);
        //contstorageOrg
        contstorageOrg.setBoundEditor(prmtstorageOrg);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contallTransQty
        contallTransQty.setBoundEditor(txtallTransQty);
        //conthealthQty
        conthealthQty.setBoundEditor(txthealthQty);
        //contdeathQty
        contdeathQty.setBoundEditor(txtdeathQty);
        //contlossQty
        contlossQty.setBoundEditor(txtlossQty);
        //contotherLossQty
        contotherLossQty.setBoundEditor(txtotherLossQty);
        //contunhatchedEggQty
        contunhatchedEggQty.setBoundEditor(txtunhatchedEggQty);
        //contotherStoorg
        contotherStoorg.setBoundEditor(prmtotherStoorg);
        //contotherHealthQty
        contotherHealthQty.setBoundEditor(txtotherHealthQty);
        //contoneHealthQty
        contoneHealthQty.setBoundEditor(txtoneHealthQty);

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
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("transDescription", String.class, this.txttransDescription, "text");
		dataBinder.registerBinding("transferBoxBill", com.kingdee.eas.farm.hatch.TranferBoxBillInfo.class, this.prmttransferBoxBill, "data");
		dataBinder.registerBinding("commercialStoorg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtcommercialStoorg, "data");
		dataBinder.registerBinding("entrys.id", com.kingdee.bos.util.BOSUuid.class, this.kdtEntrys, "id.text");
		dataBinder.registerBinding("entrys", com.kingdee.eas.farm.hatch.HatchBabyBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("entrys.hatchingBox", java.lang.Object.class, this.kdtEntrys, "hatchingBox.text");
		dataBinder.registerBinding("entrys.transQty", int.class, this.kdtEntrys, "transQty.text");
		dataBinder.registerBinding("entrys.description", String.class, this.kdtEntrys, "description.text");
		dataBinder.registerBinding("entrys.healthQty", int.class, this.kdtEntrys, "healthQty.text");
		dataBinder.registerBinding("entrys.dealthQty", int.class, this.kdtEntrys, "dealthQty.text");
		dataBinder.registerBinding("entrys.lossQty", int.class, this.kdtEntrys, "lossQty.text");
		dataBinder.registerBinding("entrys.unhatchedEgg", int.class, this.kdtEntrys, "unhatchedEgg.text");
		dataBinder.registerBinding("ImmuneEntrys.seq", int.class, this.kdtImmuneEntrys, "seq.text");
		dataBinder.registerBinding("ImmuneEntrys", com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryInfo.class, this.kdtImmuneEntrys, "userObject");
		dataBinder.registerBinding("ImmuneEntrys.immuneMaterial", java.lang.Object.class, this.kdtImmuneEntrys, "immuneMaterial.text");
		dataBinder.registerBinding("ImmuneEntrys.usedQty", int.class, this.kdtImmuneEntrys, "usedQty.text");
		dataBinder.registerBinding("ImmuneEntrys.description", String.class, this.kdtImmuneEntrys, "description.text");
		dataBinder.registerBinding("ImmuneEntrys.unit", String.class, this.kdtImmuneEntrys, "unit.text");
		dataBinder.registerBinding("SaleEntry.seq", int.class, this.kdtSaleEntry, "seq.text");
		dataBinder.registerBinding("SaleEntry", com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryInfo.class, this.kdtSaleEntry, "userObject");
		dataBinder.registerBinding("SaleEntry.customer", java.lang.Object.class, this.kdtSaleEntry, "customer.text");
		dataBinder.registerBinding("SaleEntry.qty", int.class, this.kdtSaleEntry, "qty.text");
		dataBinder.registerBinding("SaleEntry.price", java.math.BigDecimal.class, this.kdtSaleEntry, "price.text");
		dataBinder.registerBinding("storageOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrg, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("allTransQty", int.class, this.txtallTransQty, "value");
		dataBinder.registerBinding("healthQty", int.class, this.txthealthQty, "value");
		dataBinder.registerBinding("deathQty", int.class, this.txtdeathQty, "value");
		dataBinder.registerBinding("lossQty", int.class, this.txtlossQty, "value");
		dataBinder.registerBinding("otherLossQty", int.class, this.txtotherLossQty, "value");
		dataBinder.registerBinding("unhatchedEggQty", int.class, this.txtunhatchedEggQty, "value");
		dataBinder.registerBinding("otherStoorg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtotherStoorg, "data");
		dataBinder.registerBinding("otherHealthQty", int.class, this.txtotherHealthQty, "value");
		dataBinder.registerBinding("oneHealthQty", int.class, this.txtoneHealthQty, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.hatch.app.HatchBabyBillEditUIHandler";
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
        this.prmtperson.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchBabyBillInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transDescription", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transferBoxBill", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("commercialStoorg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.id", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.hatchingBox", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.transQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.healthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.dealthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("entrys.unhatchedEgg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.immuneMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.usedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ImmuneEntrys.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allTransQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("healthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("deathQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherLossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("unhatchedEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherStoorg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherHealthQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oneHealthQty", ValidateHelper.ON_SAVE);    		
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
     * output prmttransferBoxBill_dataChanged method
     */
    protected void prmttransferBoxBill_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output prmtcommercialStoorg_dataChanged method
     */
    protected void prmtcommercialStoorg_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output kdtImmuneEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtImmuneEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("immuneMaterial".equalsIgnoreCase(kdtImmuneEntrys.getColumn(colIndex).getKey())) {
kdtImmuneEntrys.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtImmuneEntrys.getCell(rowIndex,"immuneMaterial").getValue(),"baseUnit.name")));

}


    }

    /**
     * output txthealthQty_Changed() method
     */
    public void txthealthQty_Changed() throws Exception
    {
        System.out.println("txthealthQty_Changed() Function is executed!");
            txtoneHealthQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txthealthQty.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtotherHealthQty.getValue())));


    }

    /**
     * output txtotherHealthQty_Changed() method
     */
    public void txtotherHealthQty_Changed() throws Exception
    {
        System.out.println("txtotherHealthQty_Changed() Function is executed!");
            txtoneHealthQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txthealthQty.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtotherHealthQty.getValue())));


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
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("transDescription"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("transferBoxBill.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("transferBoxBill.id"));
        	sic.add(new SelectorItemInfo("transferBoxBill.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("commercialStoorg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("commercialStoorg.id"));
        	sic.add(new SelectorItemInfo("commercialStoorg.number"));
        	sic.add(new SelectorItemInfo("commercialStoorg.name"));
		}
    	sic.add(new SelectorItemInfo("entrys.id"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("entrys.hatchingBox.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("entrys.hatchingBox.id"));
			sic.add(new SelectorItemInfo("entrys.hatchingBox.name"));
        	sic.add(new SelectorItemInfo("entrys.hatchingBox.number"));
		}
    	sic.add(new SelectorItemInfo("entrys.transQty"));
    	sic.add(new SelectorItemInfo("entrys.description"));
    	sic.add(new SelectorItemInfo("entrys.healthQty"));
    	sic.add(new SelectorItemInfo("entrys.dealthQty"));
    	sic.add(new SelectorItemInfo("entrys.lossQty"));
    	sic.add(new SelectorItemInfo("entrys.unhatchedEgg"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.id"));
			sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.name"));
        	sic.add(new SelectorItemInfo("ImmuneEntrys.immuneMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("ImmuneEntrys.usedQty"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.description"));
    	sic.add(new SelectorItemInfo("ImmuneEntrys.unit"));
    	sic.add(new SelectorItemInfo("SaleEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.customer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntry.customer.id"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.number"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.-"));
			sic.add(new SelectorItemInfo("SaleEntry.customer.name"));
		}
    	sic.add(new SelectorItemInfo("SaleEntry.qty"));
    	sic.add(new SelectorItemInfo("SaleEntry.price"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrg.id"));
        	sic.add(new SelectorItemInfo("storageOrg.number"));
        	sic.add(new SelectorItemInfo("storageOrg.name"));
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
        sic.add(new SelectorItemInfo("allTransQty"));
        sic.add(new SelectorItemInfo("healthQty"));
        sic.add(new SelectorItemInfo("deathQty"));
        sic.add(new SelectorItemInfo("lossQty"));
        sic.add(new SelectorItemInfo("otherLossQty"));
        sic.add(new SelectorItemInfo("unhatchedEggQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("otherStoorg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("otherStoorg.id"));
        	sic.add(new SelectorItemInfo("otherStoorg.number"));
        	sic.add(new SelectorItemInfo("otherStoorg.name"));
		}
        sic.add(new SelectorItemInfo("otherHealthQty"));
        sic.add(new SelectorItemInfo("oneHealthQty"));
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
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchBabyBillFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchBabyBillFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractHatchBabyBillEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractHatchBabyBillEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchBabyBillEditUI");
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
        return com.kingdee.eas.farm.hatch.client.HatchBabyBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchBabyBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchBabyBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBabyBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/hatch/HatchBabyBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.hatch.app.HatchBabyBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单据编号"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkBizDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"业务日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtperson.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"操作员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(baseStatus.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"状态"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmttransferBoxBill.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"转箱单"});
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"customer").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"客户"});
			}
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"qty").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"数量"});
			}
		}
		for (int i=0,n=kdtSaleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSaleEntry.getCell(i,"price").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单价"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
		vo.put("otherHealthQty",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntrys,new String[] {"transQty","dealthQty","lossQty","unhatchedEgg"});
		}


}