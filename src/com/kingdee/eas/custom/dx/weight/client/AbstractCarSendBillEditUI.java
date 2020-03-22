/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

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
public abstract class AbstractCarSendBillEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarSendBillEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuttleWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contqty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisGross;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTara;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumGross;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsumTara;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstaplesupplier;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisweight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSettle;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuttleWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtqty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrysS;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrysS_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsumTara;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstaplesupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarm;
    protected com.kingdee.eas.custom.dx.weight.CarSendBillInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCarSendBillEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarSendBillEditUI.class.getName());
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
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuttleWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contqty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisGross = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisTara = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsumGross = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsumTara = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstaplesupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisweight = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisSettle = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsuttleWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtqty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntrysS = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtsumGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsumTara = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtstaplesupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contcarNum.setName("contcarNum");
        this.contdriver.setName("contdriver");
        this.contsuttleWgt.setName("contsuttleWgt");
        this.contqty.setName("contqty");
        this.contcompany.setName("contcompany");
        this.contchickenSZWgt.setName("contchickenSZWgt");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contcar.setName("contcar");
        this.chkisGross.setName("chkisGross");
        this.chkisTara.setName("chkisTara");
        this.contsumGross.setName("contsumGross");
        this.contsumTara.setName("contsumTara");
        this.contstaplesupplier.setName("contstaplesupplier");
        this.chkisweight.setName("chkisweight");
        this.contfarm.setName("contfarm");
        this.chkisSettle.setName("chkisSettle");
        this.txtcarNum.setName("txtcarNum");
        this.prmtdriver.setName("prmtdriver");
        this.txtsuttleWgt.setName("txtsuttleWgt");
        this.txtqty.setName("txtqty");
        this.prmtcompany.setName("prmtcompany");
        this.txtchickenSZWgt.setName("txtchickenSZWgt");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtEntrysS.setName("kdtEntrysS");
        this.prmtcar.setName("prmtcar");
        this.txtsumGross.setName("txtsumGross");
        this.txtsumTara.setName("txtsumTara");
        this.prmtstaplesupplier.setName("prmtstaplesupplier");
        this.txtfarm.setName("txtfarm");
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
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);		
        this.pkauditTime.setRequired(false);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);
        // contcarNum		
        this.contcarNum.setBoundLabelText(resHelper.getString("contcarNum.boundLabelText"));		
        this.contcarNum.setBoundLabelLength(100);		
        this.contcarNum.setBoundLabelUnderline(true);		
        this.contcarNum.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(false);
        // contsuttleWgt		
        this.contsuttleWgt.setBoundLabelText(resHelper.getString("contsuttleWgt.boundLabelText"));		
        this.contsuttleWgt.setBoundLabelLength(100);		
        this.contsuttleWgt.setBoundLabelUnderline(true);
        // contqty		
        this.contqty.setBoundLabelText(resHelper.getString("contqty.boundLabelText"));		
        this.contqty.setBoundLabelLength(100);		
        this.contqty.setBoundLabelUnderline(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contchickenSZWgt		
        this.contchickenSZWgt.setBoundLabelText(resHelper.getString("contchickenSZWgt.boundLabelText"));		
        this.contchickenSZWgt.setBoundLabelLength(100);		
        this.contchickenSZWgt.setBoundLabelUnderline(true);		
        this.contchickenSZWgt.setVisible(false);
        // kDTabbedPane1
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // chkisGross		
        this.chkisGross.setText(resHelper.getString("chkisGross.text"));		
        this.chkisGross.setVisible(true);		
        this.chkisGross.setHorizontalAlignment(2);		
        this.chkisGross.setEnabled(false);
        // chkisTara		
        this.chkisTara.setText(resHelper.getString("chkisTara.text"));		
        this.chkisTara.setVisible(true);		
        this.chkisTara.setHorizontalAlignment(2);		
        this.chkisTara.setEnabled(false);
        // contsumGross		
        this.contsumGross.setBoundLabelText(resHelper.getString("contsumGross.boundLabelText"));		
        this.contsumGross.setBoundLabelLength(100);		
        this.contsumGross.setBoundLabelUnderline(true);
        // contsumTara		
        this.contsumTara.setBoundLabelText(resHelper.getString("contsumTara.boundLabelText"));		
        this.contsumTara.setBoundLabelLength(100);		
        this.contsumTara.setBoundLabelUnderline(true);
        // contstaplesupplier		
        this.contstaplesupplier.setBoundLabelText(resHelper.getString("contstaplesupplier.boundLabelText"));		
        this.contstaplesupplier.setBoundLabelLength(100);		
        this.contstaplesupplier.setBoundLabelUnderline(true);		
        this.contstaplesupplier.setVisible(true);
        // chkisweight		
        this.chkisweight.setText(resHelper.getString("chkisweight.text"));		
        this.chkisweight.setVisible(true);		
        this.chkisweight.setHorizontalAlignment(2);		
        this.chkisweight.setEnabled(false);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // chkisSettle		
        this.chkisSettle.setText(resHelper.getString("chkisSettle.text"));		
        this.chkisSettle.setVisible(true);		
        this.chkisSettle.setHorizontalAlignment(2);		
        this.chkisSettle.setEnabled(false);
        // txtcarNum		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);		
        this.txtcarNum.setEnabled(false);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(false);		
        this.prmtdriver.setVisible(false);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        // txtsuttleWgt		
        this.txtsuttleWgt.setHorizontalAlignment(2);		
        this.txtsuttleWgt.setDataType(1);		
        this.txtsuttleWgt.setSupportedEmpty(true);		
        this.txtsuttleWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuttleWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuttleWgt.setPrecision(4);		
        this.txtsuttleWgt.setRequired(false);
        // txtqty		
        this.txtqty.setHorizontalAlignment(2);		
        this.txtqty.setDataType(1);		
        this.txtqty.setSupportedEmpty(true);		
        this.txtqty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtqty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtqty.setPrecision(4);		
        this.txtqty.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // txtchickenSZWgt		
        this.txtchickenSZWgt.setHorizontalAlignment(2);		
        this.txtchickenSZWgt.setDataType(1);		
        this.txtchickenSZWgt.setSupportedEmpty(true);		
        this.txtchickenSZWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSZWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSZWgt.setPrecision(4);		
        this.txtchickenSZWgt.setRequired(false);		
        this.txtchickenSZWgt.setVisible(false);
        // kDPanel1
        // kDPanel2
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carcassType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"wgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{carcassType}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{wgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

                this.kdtEntrys.putBindContents("editData",new String[] {"seq","carcassType","qty","wgt"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_seq_TextField = new KDFormattedTextField();
        kdtEntrys_seq_TextField.setName("kdtEntrys_seq_TextField");
        kdtEntrys_seq_TextField.setVisible(true);
        kdtEntrys_seq_TextField.setEditable(true);
        kdtEntrys_seq_TextField.setHorizontalAlignment(2);
        kdtEntrys_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seq_TextField);
        this.kdtEntrys.getColumn("seq").setEditor(kdtEntrys_seq_CellEditor);
        KDComboBox kdtEntrys_carcassType_ComboBox = new KDComboBox();
        kdtEntrys_carcassType_ComboBox.setName("kdtEntrys_carcassType_ComboBox");
        kdtEntrys_carcassType_ComboBox.setVisible(true);
        kdtEntrys_carcassType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.weight.CarcassType").toArray());
        KDTDefaultCellEditor kdtEntrys_carcassType_CellEditor = new KDTDefaultCellEditor(kdtEntrys_carcassType_ComboBox);
        this.kdtEntrys.getColumn("carcassType").setEditor(kdtEntrys_carcassType_CellEditor);
        KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
        kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
        kdtEntrys_qty_TextField.setVisible(true);
        kdtEntrys_qty_TextField.setEditable(true);
        kdtEntrys_qty_TextField.setHorizontalAlignment(2);
        kdtEntrys_qty_TextField.setDataType(1);
        	kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
        this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
        KDFormattedTextField kdtEntrys_wgt_TextField = new KDFormattedTextField();
        kdtEntrys_wgt_TextField.setName("kdtEntrys_wgt_TextField");
        kdtEntrys_wgt_TextField.setVisible(true);
        kdtEntrys_wgt_TextField.setEditable(true);
        kdtEntrys_wgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_wgt_TextField.setDataType(1);
        	kdtEntrys_wgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_wgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_wgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_wgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_wgt_TextField);
        this.kdtEntrys.getColumn("wgt").setEditor(kdtEntrys_wgt_CellEditor);
        // kdtEntrysS
		String kdtEntrysSStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>yyyy-MM-dd HH:mm:ss</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"Dtime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"Dweight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"Pweight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{Dtime}</t:Cell><t:Cell>$Resource{Dweight}</t:Cell><t:Cell>$Resource{Pweight}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrysS.setFormatXml(resHelper.translateString("kdtEntrysS",kdtEntrysSStrXML));

                this.kdtEntrysS.putBindContents("editData",new String[] {"seq","Dtime","Dweight","Pweight"});


        this.kdtEntrysS.checkParsed();
        KDFormattedTextField kdtEntrysS_seq_TextField = new KDFormattedTextField();
        kdtEntrysS_seq_TextField.setName("kdtEntrysS_seq_TextField");
        kdtEntrysS_seq_TextField.setVisible(true);
        kdtEntrysS_seq_TextField.setEditable(true);
        kdtEntrysS_seq_TextField.setHorizontalAlignment(2);
        kdtEntrysS_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrysS_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrysS_seq_TextField);
        this.kdtEntrysS.getColumn("seq").setEditor(kdtEntrysS_seq_CellEditor);
        KDDatePicker kdtEntrysS_Dtime_DatePicker = new KDDatePicker();
        kdtEntrysS_Dtime_DatePicker.setName("kdtEntrysS_Dtime_DatePicker");
        kdtEntrysS_Dtime_DatePicker.setVisible(true);
        kdtEntrysS_Dtime_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntrysS_Dtime_CellEditor = new KDTDefaultCellEditor(kdtEntrysS_Dtime_DatePicker);
        this.kdtEntrysS.getColumn("Dtime").setEditor(kdtEntrysS_Dtime_CellEditor);
        KDFormattedTextField kdtEntrysS_Dweight_TextField = new KDFormattedTextField();
        kdtEntrysS_Dweight_TextField.setName("kdtEntrysS_Dweight_TextField");
        kdtEntrysS_Dweight_TextField.setVisible(true);
        kdtEntrysS_Dweight_TextField.setEditable(true);
        kdtEntrysS_Dweight_TextField.setHorizontalAlignment(2);
        kdtEntrysS_Dweight_TextField.setDataType(1);
        	kdtEntrysS_Dweight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrysS_Dweight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrysS_Dweight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrysS_Dweight_CellEditor = new KDTDefaultCellEditor(kdtEntrysS_Dweight_TextField);
        this.kdtEntrysS.getColumn("Dweight").setEditor(kdtEntrysS_Dweight_CellEditor);
        KDFormattedTextField kdtEntrysS_Pweight_TextField = new KDFormattedTextField();
        kdtEntrysS_Pweight_TextField.setName("kdtEntrysS_Pweight_TextField");
        kdtEntrysS_Pweight_TextField.setVisible(true);
        kdtEntrysS_Pweight_TextField.setEditable(true);
        kdtEntrysS_Pweight_TextField.setHorizontalAlignment(2);
        kdtEntrysS_Pweight_TextField.setDataType(1);
        	kdtEntrysS_Pweight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrysS_Pweight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrysS_Pweight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrysS_Pweight_CellEditor = new KDTDefaultCellEditor(kdtEntrysS_Pweight_TextField);
        this.kdtEntrysS.getColumn("Pweight").setEditor(kdtEntrysS_Pweight_CellEditor);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$name$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        prmtcar.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtcar_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtsumGross		
        this.txtsumGross.setHorizontalAlignment(2);		
        this.txtsumGross.setDataType(1);		
        this.txtsumGross.setSupportedEmpty(true);		
        this.txtsumGross.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumGross.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumGross.setPrecision(4);		
        this.txtsumGross.setRequired(false);		
        this.txtsumGross.setEnabled(false);
        // txtsumTara		
        this.txtsumTara.setHorizontalAlignment(2);		
        this.txtsumTara.setDataType(1);		
        this.txtsumTara.setSupportedEmpty(true);		
        this.txtsumTara.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsumTara.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsumTara.setPrecision(4);		
        this.txtsumTara.setRequired(false);		
        this.txtsumTara.setEnabled(false);
        // prmtstaplesupplier		
        this.prmtstaplesupplier.setQueryInfo("com.kingdee.eas.custom.dx.weight.app.StapleSupplierQuery");		
        this.prmtstaplesupplier.setVisible(true);		
        this.prmtstaplesupplier.setEditable(true);		
        this.prmtstaplesupplier.setDisplayFormat("$name$");		
        this.prmtstaplesupplier.setEditFormat("$number$");		
        this.prmtstaplesupplier.setCommitFormat("$number$");		
        this.prmtstaplesupplier.setRequired(false);
        // txtfarm		
        this.txtfarm.setVisible(true);		
        this.txtfarm.setHorizontalAlignment(2);		
        this.txtfarm.setMaxLength(100);		
        this.txtfarm.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtcarNum,prmtdriver,txtsuttleWgt,txtqty,billStatus,pkauditTime,prmtcompany,txtchickenSZWgt,kdtEntrys,kdtEntrysS,prmtcar,chkisGross,chkisTara,txtsumGross,txtsumTara,prmtstaplesupplier,chkisweight,txtfarm,chkisSettle}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 531));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 531));
        contCreator.setBounds(new Rectangle(364, 465, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(364, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(709, 465, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(709, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(364, 496, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(364, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(709, 496, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(709, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(369, 18, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(369, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(24, 18, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(24, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(714, 49, 271, 19));
        this.add(contDescription, new KDLayout.Constraints(714, 49, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(19, 465, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(19, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(19, 496, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(19, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(714, 16, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(714, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarNum.setBounds(new Rectangle(369, 85, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(369, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(24, 90, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(24, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuttleWgt.setBounds(new Rectangle(23, 163, 270, 19));
        this.add(contsuttleWgt, new KDLayout.Constraints(23, 163, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contqty.setBounds(new Rectangle(368, 160, 270, 19));
        this.add(contqty, new KDLayout.Constraints(368, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(24, 55, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(24, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenSZWgt.setBounds(new Rectangle(809, 186, 270, 19));
        this.add(contchickenSZWgt, new KDLayout.Constraints(809, 186, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(18, 214, 965, 229));
        this.add(kDTabbedPane1, new KDLayout.Constraints(18, 214, 965, 229, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcar.setBounds(new Rectangle(369, 54, 270, 19));
        this.add(contcar, new KDLayout.Constraints(369, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisGross.setBounds(new Rectangle(457, 118, 99, 19));
        this.add(chkisGross, new KDLayout.Constraints(457, 118, 99, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisTara.setBounds(new Rectangle(369, 117, 87, 19));
        this.add(chkisTara, new KDLayout.Constraints(369, 117, 87, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsumGross.setBounds(new Rectangle(714, 153, 270, 19));
        this.add(contsumGross, new KDLayout.Constraints(714, 153, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsumTara.setBounds(new Rectangle(715, 118, 270, 19));
        this.add(contsumTara, new KDLayout.Constraints(715, 118, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contstaplesupplier.setBounds(new Rectangle(23, 127, 270, 19));
        this.add(contstaplesupplier, new KDLayout.Constraints(23, 127, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisweight.setBounds(new Rectangle(532, 118, 125, 19));
        this.add(chkisweight, new KDLayout.Constraints(532, 118, 125, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(715, 83, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(715, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisSettle.setBounds(new Rectangle(369, 139, 270, 19));
        this.add(chkisSettle, new KDLayout.Constraints(369, 139, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contsuttleWgt
        contsuttleWgt.setBoundEditor(txtsuttleWgt);
        //contqty
        contqty.setBoundEditor(txtqty);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contchickenSZWgt
        contchickenSZWgt.setBoundEditor(txtchickenSZWgt);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 196));        kdtEntrys.setBounds(new Rectangle(2, 0, 954, 238));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(2, 0, 954, 238, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 964, 196));        kdtEntrysS.setBounds(new Rectangle(1, -2, 965, 233));
        kdtEntrysS_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrysS,new com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSInfo(),null,false);
        kDPanel2.add(kdtEntrysS_detailPanel, new KDLayout.Constraints(1, -2, 965, 233, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contsumGross
        contsumGross.setBoundEditor(txtsumGross);
        //contsumTara
        contsumTara.setBoundEditor(txtsumTara);
        //contstaplesupplier
        contstaplesupplier.setBoundEditor(prmtstaplesupplier);
        //contfarm
        contfarm.setBoundEditor(txtfarm);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("isGross", boolean.class, this.chkisGross, "selected");
		dataBinder.registerBinding("isTara", boolean.class, this.chkisTara, "selected");
		dataBinder.registerBinding("isweight", boolean.class, this.chkisweight, "selected");
		dataBinder.registerBinding("isSettle", boolean.class, this.chkisSettle, "selected");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("suttleWgt", java.math.BigDecimal.class, this.txtsuttleWgt, "value");
		dataBinder.registerBinding("qty", java.math.BigDecimal.class, this.txtqty, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("chickenSZWgt", java.math.BigDecimal.class, this.txtchickenSZWgt, "value");
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.carcassType", com.kingdee.util.enums.Enum.class, this.kdtEntrys, "carcassType.text");
		dataBinder.registerBinding("Entrys.qty", java.math.BigDecimal.class, this.kdtEntrys, "qty.text");
		dataBinder.registerBinding("Entrys.wgt", java.math.BigDecimal.class, this.kdtEntrys, "wgt.text");
		dataBinder.registerBinding("EntrysS.seq", int.class, this.kdtEntrysS, "seq.text");
		dataBinder.registerBinding("EntrysS", com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSInfo.class, this.kdtEntrysS, "userObject");
		dataBinder.registerBinding("EntrysS.Dweight", java.math.BigDecimal.class, this.kdtEntrysS, "Dweight.text");
		dataBinder.registerBinding("EntrysS.Dtime", java.util.Date.class, this.kdtEntrysS, "Dtime.text");
		dataBinder.registerBinding("EntrysS.Pweight", java.math.BigDecimal.class, this.kdtEntrysS, "Pweight.text");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("sumGross", java.math.BigDecimal.class, this.txtsumGross, "value");
		dataBinder.registerBinding("sumTara", java.math.BigDecimal.class, this.txtsumTara, "value");
		dataBinder.registerBinding("staplesupplier", com.kingdee.eas.custom.dx.weight.StapleSupplierInfo.class, this.prmtstaplesupplier, "data");
		dataBinder.registerBinding("farm", String.class, this.txtfarm, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.weight.app.CarSendBillEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.dx.weight.CarSendBillInfo)ov;
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
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isTara", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isweight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSettle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suttleWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSZWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.carcassType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.wgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntrysS.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntrysS", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntrysS.Dweight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntrysS.Dtime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("EntrysS.Pweight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumGross", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sumTara", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("staplesupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    		
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
     * output prmtcar_Changed() method
     */
    public void prmtcar_Changed() throws Exception
    {
        System.out.println("prmtcar_Changed() Function is executed!");
            txtcarNum.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtcar.getData(),"name")));


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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("isGross"));
        sic.add(new SelectorItemInfo("isTara"));
        sic.add(new SelectorItemInfo("isweight"));
        sic.add(new SelectorItemInfo("isSettle"));
        sic.add(new SelectorItemInfo("carNum"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driver.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driver.id"));
        	sic.add(new SelectorItemInfo("driver.number"));
        	sic.add(new SelectorItemInfo("driver.name"));
        	sic.add(new SelectorItemInfo("driver.drivername"));
		}
        sic.add(new SelectorItemInfo("suttleWgt"));
        sic.add(new SelectorItemInfo("qty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("chickenSZWgt"));
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entrys.carcassType"));
    	sic.add(new SelectorItemInfo("Entrys.qty"));
    	sic.add(new SelectorItemInfo("Entrys.wgt"));
    	sic.add(new SelectorItemInfo("EntrysS.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("EntrysS.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("EntrysS.Dweight"));
    	sic.add(new SelectorItemInfo("EntrysS.Dtime"));
    	sic.add(new SelectorItemInfo("EntrysS.Pweight"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("car.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("car.id"));
        	sic.add(new SelectorItemInfo("car.number"));
        	sic.add(new SelectorItemInfo("car.name"));
		}
        sic.add(new SelectorItemInfo("sumGross"));
        sic.add(new SelectorItemInfo("sumTara"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("staplesupplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("staplesupplier.id"));
        	sic.add(new SelectorItemInfo("staplesupplier.number"));
        	sic.add(new SelectorItemInfo("staplesupplier.name"));
		}
        sic.add(new SelectorItemInfo("farm"));
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
        return new MetaDataPK("com.kingdee.eas.custom.dx.weight.client", "CarSendBillEditUI");
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
        return com.kingdee.eas.custom.dx.weight.client.CarSendBillEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.CarSendBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.CarSendBillInfo objectValue = new com.kingdee.eas.custom.dx.weight.CarSendBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/weight/CarSendBill";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.weight.app.CarSendBillQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"carcassType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"胴体类型"});
			}
		}
		for (int i=0,n=kdtEntrys.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(i,"wgt").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"重量"});
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
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}