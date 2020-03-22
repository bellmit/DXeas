/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractFarmerconfirmEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerconfirmEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBizDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contAuditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0001;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0002;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0003;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0004;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0005;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0006;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0007;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0008;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0009;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0010;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0011;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0012;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBIMUDF0013;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButton1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtAuditor;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBIMUDF0001;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBIMUDF0002;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBIMUDF0003;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBIMUDF0004;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBIMUDF0005;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBIMUDF0006;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBIMUDF0007;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtBIMUDF0008;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0009;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0010;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0011;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0012;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBIMUDF0013;
    protected com.kingdee.eas.farm.stocking.processbizill.FarmerconfirmInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractFarmerconfirmEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerconfirmEditUI.class.getName());
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
        this.contCreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBizDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contAuditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0001 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0002 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0003 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0004 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contBIMUDF0005 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0006 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0007 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0008 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0009 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0010 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0011 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBIMUDF0013 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDButton1 = new com.kingdee.bos.ctrl.swing.KDButton();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtDescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtAuditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBIMUDF0001 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBIMUDF0002 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBIMUDF0003 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBIMUDF0004 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBIMUDF0005 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtBIMUDF0006 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBIMUDF0007 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBIMUDF0008 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtBIMUDF0009 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0010 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0011 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0012 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtBIMUDF0013 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCreator.setName("contCreator");
        this.contCreateTime.setName("contCreateTime");
        this.contLastUpdateUser.setName("contLastUpdateUser");
        this.contLastUpdateTime.setName("contLastUpdateTime");
        this.contNumber.setName("contNumber");
        this.contBizDate.setName("contBizDate");
        this.contDescription.setName("contDescription");
        this.contAuditor.setName("contAuditor");
        this.contBIMUDF0001.setName("contBIMUDF0001");
        this.contBIMUDF0002.setName("contBIMUDF0002");
        this.contBIMUDF0003.setName("contBIMUDF0003");
        this.contBIMUDF0004.setName("contBIMUDF0004");
        this.kDSeparator8.setName("kDSeparator8");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDLabel1.setName("kDLabel1");
        this.contBIMUDF0005.setName("contBIMUDF0005");
        this.contBIMUDF0006.setName("contBIMUDF0006");
        this.contBIMUDF0007.setName("contBIMUDF0007");
        this.contBIMUDF0008.setName("contBIMUDF0008");
        this.contBIMUDF0009.setName("contBIMUDF0009");
        this.contBIMUDF0010.setName("contBIMUDF0010");
        this.contBIMUDF0011.setName("contBIMUDF0011");
        this.contBIMUDF0012.setName("contBIMUDF0012");
        this.contBIMUDF0013.setName("contBIMUDF0013");
        this.kDSeparator10.setName("kDSeparator10");
        this.kDButton1.setName("kDButton1");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.txtNumber.setName("txtNumber");
        this.pkBizDate.setName("pkBizDate");
        this.txtDescription.setName("txtDescription");
        this.prmtAuditor.setName("prmtAuditor");
        this.prmtBIMUDF0001.setName("prmtBIMUDF0001");
        this.prmtBIMUDF0002.setName("prmtBIMUDF0002");
        this.prmtBIMUDF0003.setName("prmtBIMUDF0003");
        this.prmtBIMUDF0004.setName("prmtBIMUDF0004");
        this.prmtBIMUDF0005.setName("prmtBIMUDF0005");
        this.txtBIMUDF0006.setName("txtBIMUDF0006");
        this.txtBIMUDF0007.setName("txtBIMUDF0007");
        this.txtBIMUDF0008.setName("txtBIMUDF0008");
        this.txtBIMUDF0009.setName("txtBIMUDF0009");
        this.txtBIMUDF0010.setName("txtBIMUDF0010");
        this.txtBIMUDF0011.setName("txtBIMUDF0011");
        this.txtBIMUDF0012.setName("txtBIMUDF0012");
        this.txtBIMUDF0013.setName("txtBIMUDF0013");
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
        // contBIMUDF0001		
        this.contBIMUDF0001.setBoundLabelText(resHelper.getString("contBIMUDF0001.boundLabelText"));		
        this.contBIMUDF0001.setBoundLabelLength(100);		
        this.contBIMUDF0001.setBoundLabelUnderline(true);		
        this.contBIMUDF0001.setVisible(true);
        // contBIMUDF0002		
        this.contBIMUDF0002.setBoundLabelText(resHelper.getString("contBIMUDF0002.boundLabelText"));		
        this.contBIMUDF0002.setBoundLabelLength(100);		
        this.contBIMUDF0002.setBoundLabelUnderline(true);		
        this.contBIMUDF0002.setVisible(true);
        // contBIMUDF0003		
        this.contBIMUDF0003.setBoundLabelText(resHelper.getString("contBIMUDF0003.boundLabelText"));		
        this.contBIMUDF0003.setBoundLabelLength(100);		
        this.contBIMUDF0003.setBoundLabelUnderline(true);		
        this.contBIMUDF0003.setVisible(true);
        // contBIMUDF0004		
        this.contBIMUDF0004.setBoundLabelText(resHelper.getString("contBIMUDF0004.boundLabelText"));		
        this.contBIMUDF0004.setBoundLabelLength(100);		
        this.contBIMUDF0004.setBoundLabelUnderline(true);		
        this.contBIMUDF0004.setVisible(true);
        // kDSeparator8
        // kDSeparator9
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // contBIMUDF0005		
        this.contBIMUDF0005.setBoundLabelText(resHelper.getString("contBIMUDF0005.boundLabelText"));		
        this.contBIMUDF0005.setBoundLabelLength(100);		
        this.contBIMUDF0005.setBoundLabelUnderline(true);		
        this.contBIMUDF0005.setVisible(true);
        // contBIMUDF0006		
        this.contBIMUDF0006.setBoundLabelText(resHelper.getString("contBIMUDF0006.boundLabelText"));		
        this.contBIMUDF0006.setBoundLabelLength(100);		
        this.contBIMUDF0006.setBoundLabelUnderline(true);		
        this.contBIMUDF0006.setVisible(true);
        // contBIMUDF0007		
        this.contBIMUDF0007.setBoundLabelText(resHelper.getString("contBIMUDF0007.boundLabelText"));		
        this.contBIMUDF0007.setBoundLabelLength(100);		
        this.contBIMUDF0007.setBoundLabelUnderline(true);		
        this.contBIMUDF0007.setVisible(true);
        // contBIMUDF0008		
        this.contBIMUDF0008.setBoundLabelText(resHelper.getString("contBIMUDF0008.boundLabelText"));		
        this.contBIMUDF0008.setBoundLabelLength(100);		
        this.contBIMUDF0008.setBoundLabelUnderline(true);		
        this.contBIMUDF0008.setVisible(true);
        // contBIMUDF0009		
        this.contBIMUDF0009.setBoundLabelText(resHelper.getString("contBIMUDF0009.boundLabelText"));		
        this.contBIMUDF0009.setBoundLabelLength(100);		
        this.contBIMUDF0009.setBoundLabelUnderline(true);		
        this.contBIMUDF0009.setVisible(true);
        // contBIMUDF0010		
        this.contBIMUDF0010.setBoundLabelText(resHelper.getString("contBIMUDF0010.boundLabelText"));		
        this.contBIMUDF0010.setBoundLabelLength(100);		
        this.contBIMUDF0010.setBoundLabelUnderline(true);		
        this.contBIMUDF0010.setVisible(true);
        // contBIMUDF0011		
        this.contBIMUDF0011.setBoundLabelText(resHelper.getString("contBIMUDF0011.boundLabelText"));		
        this.contBIMUDF0011.setBoundLabelLength(100);		
        this.contBIMUDF0011.setBoundLabelUnderline(true);		
        this.contBIMUDF0011.setVisible(true);
        // contBIMUDF0012		
        this.contBIMUDF0012.setBoundLabelText(resHelper.getString("contBIMUDF0012.boundLabelText"));		
        this.contBIMUDF0012.setBoundLabelLength(100);		
        this.contBIMUDF0012.setBoundLabelUnderline(true);		
        this.contBIMUDF0012.setVisible(true);
        // contBIMUDF0013		
        this.contBIMUDF0013.setBoundLabelText(resHelper.getString("contBIMUDF0013.boundLabelText"));		
        this.contBIMUDF0013.setBoundLabelLength(100);		
        this.contBIMUDF0013.setBoundLabelUnderline(true);		
        this.contBIMUDF0013.setVisible(true);
        // kDSeparator10
        // kDButton1		
        this.kDButton1.setText(resHelper.getString("kDButton1.text"));
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
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);
        // txtDescription		
        this.txtDescription.setMaxLength(80);
        // prmtAuditor		
        this.prmtAuditor.setEnabled(false);
        // prmtBIMUDF0001		
        this.prmtBIMUDF0001.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtBIMUDF0001.setVisible(true);		
        this.prmtBIMUDF0001.setEditable(true);		
        this.prmtBIMUDF0001.setDisplayFormat("$name$");		
        this.prmtBIMUDF0001.setEditFormat("$number$");		
        this.prmtBIMUDF0001.setCommitFormat("$number$");		
        this.prmtBIMUDF0001.setRequired(false);
        // prmtBIMUDF0002		
        this.prmtBIMUDF0002.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtBIMUDF0002.setVisible(true);		
        this.prmtBIMUDF0002.setEditable(true);		
        this.prmtBIMUDF0002.setDisplayFormat("$name$");		
        this.prmtBIMUDF0002.setEditFormat("$number$");		
        this.prmtBIMUDF0002.setCommitFormat("$number$");		
        this.prmtBIMUDF0002.setRequired(false);
        		prmtBIMUDF0002.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtBIMUDF0002_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtBIMUDF0002_F7ListUI == null) {
					try {
						prmtBIMUDF0002_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtBIMUDF0002_F7ListUI));
					prmtBIMUDF0002_F7ListUI.setF7Use(true,ctx);
					prmtBIMUDF0002.setSelector(prmtBIMUDF0002_F7ListUI);
				}
			}
		});
					
        // prmtBIMUDF0003		
        this.prmtBIMUDF0003.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");		
        this.prmtBIMUDF0003.setVisible(true);		
        this.prmtBIMUDF0003.setEditable(true);		
        this.prmtBIMUDF0003.setDisplayFormat("$name$");		
        this.prmtBIMUDF0003.setEditFormat("$number$");		
        this.prmtBIMUDF0003.setCommitFormat("$number$");		
        this.prmtBIMUDF0003.setRequired(false);
        		prmtBIMUDF0003.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI prmtBIMUDF0003_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtBIMUDF0003_F7ListUI == null) {
					try {
						prmtBIMUDF0003_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtBIMUDF0003_F7ListUI));
					prmtBIMUDF0003_F7ListUI.setF7Use(true,ctx);
					prmtBIMUDF0003.setSelector(prmtBIMUDF0003_F7ListUI);
				}
			}
		});
					
        // prmtBIMUDF0004		
        this.prmtBIMUDF0004.setQueryInfo("com.kingdee.eas.custom.salepayment.app.TechnicianQuery");		
        this.prmtBIMUDF0004.setVisible(true);		
        this.prmtBIMUDF0004.setEditable(true);		
        this.prmtBIMUDF0004.setDisplayFormat("$name$");		
        this.prmtBIMUDF0004.setEditFormat("$number$");		
        this.prmtBIMUDF0004.setCommitFormat("$number$");		
        this.prmtBIMUDF0004.setRequired(false);
        // prmtBIMUDF0005		
        this.prmtBIMUDF0005.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.BatchQuery");		
        this.prmtBIMUDF0005.setVisible(true);		
        this.prmtBIMUDF0005.setEditable(true);		
        this.prmtBIMUDF0005.setDisplayFormat("$name$");		
        this.prmtBIMUDF0005.setEditFormat("$number$");		
        this.prmtBIMUDF0005.setCommitFormat("$number$");		
        this.prmtBIMUDF0005.setRequired(false);
        		prmtBIMUDF0005.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI prmtBIMUDF0005_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtBIMUDF0005_F7ListUI == null) {
					try {
						prmtBIMUDF0005_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.BatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtBIMUDF0005_F7ListUI));
					prmtBIMUDF0005_F7ListUI.setF7Use(true,ctx);
					prmtBIMUDF0005.setSelector(prmtBIMUDF0005_F7ListUI);
				}
			}
		});
					
        // txtBIMUDF0006		
        this.txtBIMUDF0006.setVisible(true);		
        this.txtBIMUDF0006.setHorizontalAlignment(2);		
        this.txtBIMUDF0006.setDataType(1);		
        this.txtBIMUDF0006.setSupportedEmpty(true);		
        this.txtBIMUDF0006.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBIMUDF0006.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBIMUDF0006.setPrecision(4);		
        this.txtBIMUDF0006.setRequired(false);
        // txtBIMUDF0007		
        this.txtBIMUDF0007.setVisible(true);		
        this.txtBIMUDF0007.setHorizontalAlignment(2);		
        this.txtBIMUDF0007.setDataType(1);		
        this.txtBIMUDF0007.setSupportedEmpty(true);		
        this.txtBIMUDF0007.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBIMUDF0007.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBIMUDF0007.setPrecision(4);		
        this.txtBIMUDF0007.setRequired(false);
        // txtBIMUDF0008		
        this.txtBIMUDF0008.setVisible(true);		
        this.txtBIMUDF0008.setHorizontalAlignment(2);		
        this.txtBIMUDF0008.setDataType(1);		
        this.txtBIMUDF0008.setSupportedEmpty(true);		
        this.txtBIMUDF0008.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtBIMUDF0008.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtBIMUDF0008.setPrecision(4);		
        this.txtBIMUDF0008.setRequired(false);
        // txtBIMUDF0009		
        this.txtBIMUDF0009.setVisible(true);		
        this.txtBIMUDF0009.setHorizontalAlignment(2);		
        this.txtBIMUDF0009.setMaxLength(100);		
        this.txtBIMUDF0009.setRequired(false);
        // txtBIMUDF0010		
        this.txtBIMUDF0010.setVisible(true);		
        this.txtBIMUDF0010.setHorizontalAlignment(2);		
        this.txtBIMUDF0010.setMaxLength(100);		
        this.txtBIMUDF0010.setRequired(false);
        // txtBIMUDF0011		
        this.txtBIMUDF0011.setVisible(true);		
        this.txtBIMUDF0011.setHorizontalAlignment(2);		
        this.txtBIMUDF0011.setMaxLength(100);		
        this.txtBIMUDF0011.setRequired(false);
        // txtBIMUDF0012		
        this.txtBIMUDF0012.setVisible(true);		
        this.txtBIMUDF0012.setHorizontalAlignment(2);		
        this.txtBIMUDF0012.setMaxLength(100);		
        this.txtBIMUDF0012.setRequired(false);
        // txtBIMUDF0013		
        this.txtBIMUDF0013.setVisible(true);		
        this.txtBIMUDF0013.setHorizontalAlignment(2);		
        this.txtBIMUDF0013.setMaxLength(100);		
        this.txtBIMUDF0013.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtBIMUDF0001,prmtBIMUDF0002,prmtBIMUDF0003,prmtBIMUDF0004,prmtBIMUDF0005,txtBIMUDF0006,txtBIMUDF0007,txtBIMUDF0008,txtBIMUDF0009,txtBIMUDF0010,txtBIMUDF0011,txtBIMUDF0012,txtBIMUDF0013}));
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
        this.setBounds(new Rectangle(18, 5, 1013, 629));
        this.setLayout(null);
        contCreator.setBounds(new Rectangle(347, 383, 270, 19));
        this.add(contCreator, null);
        contCreateTime.setBounds(new Rectangle(706, 380, 270, 19));
        this.add(contCreateTime, null);
        contLastUpdateUser.setBounds(new Rectangle(17, 447, 270, 19));
        this.add(contLastUpdateUser, null);
        contLastUpdateTime.setBounds(new Rectangle(348, 449, 270, 19));
        this.add(contLastUpdateTime, null);
        contNumber.setBounds(new Rectangle(27, 15, 270, 19));
        this.add(contNumber, null);
        contBizDate.setBounds(new Rectangle(349, 18, 270, 19));
        this.add(contBizDate, null);
        contDescription.setBounds(new Rectangle(30, 127, 270, 19));
        this.add(contDescription, null);
        contAuditor.setBounds(new Rectangle(21, 378, 270, 19));
        this.add(contAuditor, null);
        contBIMUDF0001.setBounds(new Rectangle(27, 70, 270, 19));
        this.add(contBIMUDF0001, null);
        contBIMUDF0002.setBounds(new Rectangle(350, 73, 270, 19));
        this.add(contBIMUDF0002, null);
        contBIMUDF0003.setBounds(new Rectangle(699, 68, 270, 19));
        this.add(contBIMUDF0003, null);
        contBIMUDF0004.setBounds(new Rectangle(697, 16, 270, 19));
        this.add(contBIMUDF0004, null);
        kDSeparator8.setBounds(new Rectangle(23, 164, 954, 10));
        this.add(kDSeparator8, null);
        kDSeparator9.setBounds(new Rectangle(21, 336, 956, 11));
        this.add(kDSeparator9, null);
        kDLabel1.setBounds(new Rectangle(29, 168, 100, 19));
        this.add(kDLabel1, null);
        contBIMUDF0005.setBounds(new Rectangle(26, 205, 270, 19));
        this.add(contBIMUDF0005, null);
        contBIMUDF0006.setBounds(new Rectangle(701, 198, 270, 19));
        this.add(contBIMUDF0006, null);
        contBIMUDF0007.setBounds(new Rectangle(351, 198, 270, 19));
        this.add(contBIMUDF0007, null);
        contBIMUDF0008.setBounds(new Rectangle(28, 258, 270, 19));
        this.add(contBIMUDF0008, null);
        contBIMUDF0009.setBounds(new Rectangle(349, 260, 270, 19));
        this.add(contBIMUDF0009, null);
        contBIMUDF0010.setBounds(new Rectangle(700, 259, 270, 19));
        this.add(contBIMUDF0010, null);
        contBIMUDF0011.setBounds(new Rectangle(19, 307, 270, 19));
        this.add(contBIMUDF0011, null);
        contBIMUDF0012.setBounds(new Rectangle(349, 309, 270, 19));
        this.add(contBIMUDF0012, null);
        contBIMUDF0013.setBounds(new Rectangle(706, 448, 270, 19));
        this.add(contBIMUDF0013, null);
        kDSeparator10.setBounds(new Rectangle(12, 497, 969, 10));
        this.add(kDSeparator10, null);
        kDButton1.setBounds(new Rectangle(427, 555, 73, 21));
        this.add(kDButton1, null);
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
        //contBIMUDF0001
        contBIMUDF0001.setBoundEditor(prmtBIMUDF0001);
        //contBIMUDF0002
        contBIMUDF0002.setBoundEditor(prmtBIMUDF0002);
        //contBIMUDF0003
        contBIMUDF0003.setBoundEditor(prmtBIMUDF0003);
        //contBIMUDF0004
        contBIMUDF0004.setBoundEditor(prmtBIMUDF0004);
        //contBIMUDF0005
        contBIMUDF0005.setBoundEditor(prmtBIMUDF0005);
        //contBIMUDF0006
        contBIMUDF0006.setBoundEditor(txtBIMUDF0006);
        //contBIMUDF0007
        contBIMUDF0007.setBoundEditor(txtBIMUDF0007);
        //contBIMUDF0008
        contBIMUDF0008.setBoundEditor(txtBIMUDF0008);
        //contBIMUDF0009
        contBIMUDF0009.setBoundEditor(txtBIMUDF0009);
        //contBIMUDF0010
        contBIMUDF0010.setBoundEditor(txtBIMUDF0010);
        //contBIMUDF0011
        contBIMUDF0011.setBoundEditor(txtBIMUDF0011);
        //contBIMUDF0012
        contBIMUDF0012.setBoundEditor(txtBIMUDF0012);
        //contBIMUDF0013
        contBIMUDF0013.setBoundEditor(txtBIMUDF0013);

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
		dataBinder.registerBinding("BIMUDF0001", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtBIMUDF0001, "data");
		dataBinder.registerBinding("BIMUDF0002", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtBIMUDF0002, "data");
		dataBinder.registerBinding("BIMUDF0003", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtBIMUDF0003, "data");
		dataBinder.registerBinding("BIMUDF0004", com.kingdee.eas.custom.salepayment.TechnicianInfo.class, this.prmtBIMUDF0004, "data");
		dataBinder.registerBinding("BIMUDF0005", com.kingdee.eas.farm.carnivorous.basedata.BatchInfo.class, this.prmtBIMUDF0005, "data");
		dataBinder.registerBinding("BIMUDF0006", java.math.BigDecimal.class, this.txtBIMUDF0006, "value");
		dataBinder.registerBinding("BIMUDF0007", java.math.BigDecimal.class, this.txtBIMUDF0007, "value");
		dataBinder.registerBinding("BIMUDF0008", java.math.BigDecimal.class, this.txtBIMUDF0008, "value");
		dataBinder.registerBinding("BIMUDF0009", String.class, this.txtBIMUDF0009, "text");
		dataBinder.registerBinding("BIMUDF0010", String.class, this.txtBIMUDF0010, "text");
		dataBinder.registerBinding("BIMUDF0011", String.class, this.txtBIMUDF0011, "text");
		dataBinder.registerBinding("BIMUDF0012", String.class, this.txtBIMUDF0012, "text");
		dataBinder.registerBinding("BIMUDF0013", String.class, this.txtBIMUDF0013, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.FarmerconfirmEditUIHandler";
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
        this.prmtBIMUDF0001.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.FarmerconfirmInfo)ov;
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
	 * ????????§µ??
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
		getValidateHelper().registerBindProperty("BIMUDF0001", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0002", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0003", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0004", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0005", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0006", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0007", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0008", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0009", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0010", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0011", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0012", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BIMUDF0013", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("BIMUDF0001.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BIMUDF0001.id"));
        	sic.add(new SelectorItemInfo("BIMUDF0001.number"));
        	sic.add(new SelectorItemInfo("BIMUDF0001.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BIMUDF0002.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BIMUDF0002.id"));
        	sic.add(new SelectorItemInfo("BIMUDF0002.number"));
        	sic.add(new SelectorItemInfo("BIMUDF0002.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BIMUDF0003.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BIMUDF0003.id"));
        	sic.add(new SelectorItemInfo("BIMUDF0003.number"));
        	sic.add(new SelectorItemInfo("BIMUDF0003.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BIMUDF0004.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BIMUDF0004.id"));
        	sic.add(new SelectorItemInfo("BIMUDF0004.number"));
        	sic.add(new SelectorItemInfo("BIMUDF0004.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("BIMUDF0005.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("BIMUDF0005.id"));
        	sic.add(new SelectorItemInfo("BIMUDF0005.number"));
        	sic.add(new SelectorItemInfo("BIMUDF0005.name"));
		}
        sic.add(new SelectorItemInfo("BIMUDF0006"));
        sic.add(new SelectorItemInfo("BIMUDF0007"));
        sic.add(new SelectorItemInfo("BIMUDF0008"));
        sic.add(new SelectorItemInfo("BIMUDF0009"));
        sic.add(new SelectorItemInfo("BIMUDF0010"));
        sic.add(new SelectorItemInfo("BIMUDF0011"));
        sic.add(new SelectorItemInfo("BIMUDF0012"));
        sic.add(new SelectorItemInfo("BIMUDF0013"));
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

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "FarmerconfirmEditUI");
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
        return com.kingdee.eas.farm.stocking.processbizill.client.FarmerconfirmEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.FarmerconfirmFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.FarmerconfirmInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.FarmerconfirmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/Farmerconfirm";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.FarmerconfirmQuery");
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}