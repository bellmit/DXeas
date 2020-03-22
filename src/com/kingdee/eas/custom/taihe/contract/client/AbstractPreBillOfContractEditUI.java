/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

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
public abstract class AbstractPreBillOfContractEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPreBillOfContractEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSuccessive;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestiSignDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterialClerk;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestiInQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contestiInDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSuccessiveBatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsafePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpromisePrice;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSignContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbailPolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheardcell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpurchasePeron;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicyPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmilesStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteveyHomeNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthomeNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedingType;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkprohibitArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccessiveContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheard;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmScale;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisSupplier;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnewSupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnewFarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheardcell1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmside;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyzjincrease;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSource;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtpartyBCell;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkestiSignDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmaterialClerk;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtestiInQty;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkestiInDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSuccessiveBatchQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsafePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpromisePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcontractType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbailPolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtheardcell;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpurchasePeron;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsettlePolicy;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpolicyPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcontractPrice;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmilesStd;
    protected com.kingdee.bos.ctrl.swing.KDTextField txteveyHomeNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthomeNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox feedingType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsuccessiveContract;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheard;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfarmScale;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnewSupplier;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnewFarm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtheardcell1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmside;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtyzjincrease;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtchickenSource;
    protected com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPreBillOfContractEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPreBillOfContractEditUI.class.getName());
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
        this.chkisSuccessive = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contpartyBCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestiSignDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaterialClerk = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestiInQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contestiInDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSuccessiveBatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsafePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpromisePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisSignContract = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contcontractType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.contbailPolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheardcell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpurchasePeron = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlePolicy = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpolicyPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcontractPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuildDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmilesStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteveyHomeNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthomeNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedingType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkprohibitArea = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contsuccessiveContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheard = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmScale = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisSupplier = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisFarm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contnewSupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnewFarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheardcell1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmside = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyzjincrease = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenSource = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpartyBCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkestiSignDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtmaterialClerk = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtestiInQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkestiInDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtSuccessiveBatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsafePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtpromisePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcontractType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbailPolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtheardcell = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpurchasePeron = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsettlePolicy = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpolicyPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcontractPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkbuildDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtmilesStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteveyHomeNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txthomeNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.feedingType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtsuccessiveContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtheard = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmScale = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnewSupplier = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtnewFarm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtheardcell1 = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtfarmside = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtyzjincrease = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtchickenSource = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.chkisSuccessive.setName("chkisSuccessive");
        this.contpartyBCell.setName("contpartyBCell");
        this.contestiSignDate.setName("contestiSignDate");
        this.contmaterialClerk.setName("contmaterialClerk");
        this.contestiInQty.setName("contestiInQty");
        this.contestiInDate.setName("contestiInDate");
        this.contSuccessiveBatchQty.setName("contSuccessiveBatchQty");
        this.contsafePrice.setName("contsafePrice");
        this.contpromisePrice.setName("contpromisePrice");
        this.chkisSignContract.setName("chkisSignContract");
        this.contcontractType.setName("contcontractType");
        this.contfarm.setName("contfarm");
        this.contcompany.setName("contcompany");
        this.txtremark.setName("txtremark");
        this.contbailPolicy.setName("contbailPolicy");
        this.contheardcell.setName("contheardcell");
        this.contsupplier.setName("contsupplier");
        this.contpurchasePeron.setName("contpurchasePeron");
        this.contsettlePolicy.setName("contsettlePolicy");
        this.contpolicyPrice.setName("contpolicyPrice");
        this.contcontractPrice.setName("contcontractPrice");
        this.contbuildDate.setName("contbuildDate");
        this.contmilesStd.setName("contmilesStd");
        this.conteveyHomeNum.setName("conteveyHomeNum");
        this.conthomeNum.setName("conthomeNum");
        this.contfeedingType.setName("contfeedingType");
        this.chkprohibitArea.setName("chkprohibitArea");
        this.contsuccessiveContract.setName("contsuccessiveContract");
        this.contheard.setName("contheard");
        this.contfarmScale.setName("contfarmScale");
        this.chkisSupplier.setName("chkisSupplier");
        this.chkisFarm.setName("chkisFarm");
        this.contnewSupplier.setName("contnewSupplier");
        this.contnewFarm.setName("contnewFarm");
        this.contheardcell1.setName("contheardcell1");
        this.contfarmside.setName("contfarmside");
        this.contyzjincrease.setName("contyzjincrease");
        this.contchickenSource.setName("contchickenSource");
        this.txtpartyBCell.setName("txtpartyBCell");
        this.pkestiSignDate.setName("pkestiSignDate");
        this.txtmaterialClerk.setName("txtmaterialClerk");
        this.txtestiInQty.setName("txtestiInQty");
        this.pkestiInDate.setName("pkestiInDate");
        this.txtSuccessiveBatchQty.setName("txtSuccessiveBatchQty");
        this.txtsafePrice.setName("txtsafePrice");
        this.txtpromisePrice.setName("txtpromisePrice");
        this.prmtcontractType.setName("prmtcontractType");
        this.prmtfarm.setName("prmtfarm");
        this.prmtcompany.setName("prmtcompany");
        this.prmtbailPolicy.setName("prmtbailPolicy");
        this.txtheardcell.setName("txtheardcell");
        this.prmtsupplier.setName("prmtsupplier");
        this.prmtpurchasePeron.setName("prmtpurchasePeron");
        this.prmtsettlePolicy.setName("prmtsettlePolicy");
        this.txtpolicyPrice.setName("txtpolicyPrice");
        this.txtcontractPrice.setName("txtcontractPrice");
        this.pkbuildDate.setName("pkbuildDate");
        this.txtmilesStd.setName("txtmilesStd");
        this.txteveyHomeNum.setName("txteveyHomeNum");
        this.txthomeNum.setName("txthomeNum");
        this.feedingType.setName("feedingType");
        this.prmtsuccessiveContract.setName("prmtsuccessiveContract");
        this.txtheard.setName("txtheard");
        this.txtfarmScale.setName("txtfarmScale");
        this.txtnewSupplier.setName("txtnewSupplier");
        this.txtnewFarm.setName("txtnewFarm");
        this.txtheardcell1.setName("txtheardcell1");
        this.txtfarmside.setName("txtfarmside");
        this.txtyzjincrease.setName("txtyzjincrease");
        this.txtchickenSource.setName("txtchickenSource");
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
        this.contDescription.setVisible(false);		
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
        this.txtNumber.setRequired(true);		
        this.pkBizDate.setVisible(true);		
        this.pkBizDate.setEnabled(true);		
        this.pkBizDate.setRequired(true);		
        this.prmtAuditor.setEnabled(false);		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // chkisSuccessive		
        this.chkisSuccessive.setText(resHelper.getString("chkisSuccessive.text"));		
        this.chkisSuccessive.setVisible(true);		
        this.chkisSuccessive.setHorizontalAlignment(2);
        // contpartyBCell		
        this.contpartyBCell.setBoundLabelText(resHelper.getString("contpartyBCell.boundLabelText"));		
        this.contpartyBCell.setBoundLabelLength(100);		
        this.contpartyBCell.setBoundLabelUnderline(true);		
        this.contpartyBCell.setVisible(true);
        // contestiSignDate		
        this.contestiSignDate.setBoundLabelText(resHelper.getString("contestiSignDate.boundLabelText"));		
        this.contestiSignDate.setBoundLabelLength(100);		
        this.contestiSignDate.setBoundLabelUnderline(true);		
        this.contestiSignDate.setVisible(true);
        // contmaterialClerk		
        this.contmaterialClerk.setBoundLabelText(resHelper.getString("contmaterialClerk.boundLabelText"));		
        this.contmaterialClerk.setBoundLabelLength(100);		
        this.contmaterialClerk.setBoundLabelUnderline(true);		
        this.contmaterialClerk.setVisible(false);
        // contestiInQty		
        this.contestiInQty.setBoundLabelText(resHelper.getString("contestiInQty.boundLabelText"));		
        this.contestiInQty.setBoundLabelLength(100);		
        this.contestiInQty.setBoundLabelUnderline(true);		
        this.contestiInQty.setVisible(true);
        // contestiInDate		
        this.contestiInDate.setBoundLabelText(resHelper.getString("contestiInDate.boundLabelText"));		
        this.contestiInDate.setBoundLabelLength(100);		
        this.contestiInDate.setBoundLabelUnderline(true);		
        this.contestiInDate.setVisible(true);
        // contSuccessiveBatchQty		
        this.contSuccessiveBatchQty.setBoundLabelText(resHelper.getString("contSuccessiveBatchQty.boundLabelText"));		
        this.contSuccessiveBatchQty.setBoundLabelLength(100);		
        this.contSuccessiveBatchQty.setBoundLabelUnderline(true);		
        this.contSuccessiveBatchQty.setVisible(true);
        // contsafePrice		
        this.contsafePrice.setBoundLabelText(resHelper.getString("contsafePrice.boundLabelText"));		
        this.contsafePrice.setBoundLabelLength(100);		
        this.contsafePrice.setBoundLabelUnderline(true);		
        this.contsafePrice.setVisible(true);
        // contpromisePrice		
        this.contpromisePrice.setBoundLabelText(resHelper.getString("contpromisePrice.boundLabelText"));		
        this.contpromisePrice.setBoundLabelLength(100);		
        this.contpromisePrice.setBoundLabelUnderline(true);		
        this.contpromisePrice.setVisible(true);
        // chkisSignContract		
        this.chkisSignContract.setText(resHelper.getString("chkisSignContract.text"));		
        this.chkisSignContract.setVisible(true);		
        this.chkisSignContract.setHorizontalAlignment(2);
        // contcontractType		
        this.contcontractType.setBoundLabelText(resHelper.getString("contcontractType.boundLabelText"));		
        this.contcontractType.setBoundLabelLength(100);		
        this.contcontractType.setBoundLabelUnderline(true);		
        this.contcontractType.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
        // contbailPolicy		
        this.contbailPolicy.setBoundLabelText(resHelper.getString("contbailPolicy.boundLabelText"));		
        this.contbailPolicy.setBoundLabelLength(100);		
        this.contbailPolicy.setBoundLabelUnderline(true);		
        this.contbailPolicy.setVisible(true);
        // contheardcell		
        this.contheardcell.setBoundLabelText(resHelper.getString("contheardcell.boundLabelText"));		
        this.contheardcell.setBoundLabelLength(100);		
        this.contheardcell.setBoundLabelUnderline(true);		
        this.contheardcell.setVisible(true);
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contpurchasePeron		
        this.contpurchasePeron.setBoundLabelText(resHelper.getString("contpurchasePeron.boundLabelText"));		
        this.contpurchasePeron.setBoundLabelLength(100);		
        this.contpurchasePeron.setBoundLabelUnderline(true);		
        this.contpurchasePeron.setVisible(true);
        // contsettlePolicy		
        this.contsettlePolicy.setBoundLabelText(resHelper.getString("contsettlePolicy.boundLabelText"));		
        this.contsettlePolicy.setBoundLabelLength(100);		
        this.contsettlePolicy.setBoundLabelUnderline(true);		
        this.contsettlePolicy.setVisible(true);
        // contpolicyPrice		
        this.contpolicyPrice.setBoundLabelText(resHelper.getString("contpolicyPrice.boundLabelText"));		
        this.contpolicyPrice.setBoundLabelLength(100);		
        this.contpolicyPrice.setBoundLabelUnderline(true);		
        this.contpolicyPrice.setVisible(true);
        // contcontractPrice		
        this.contcontractPrice.setBoundLabelText(resHelper.getString("contcontractPrice.boundLabelText"));		
        this.contcontractPrice.setBoundLabelLength(100);		
        this.contcontractPrice.setBoundLabelUnderline(true);		
        this.contcontractPrice.setVisible(true);
        // contbuildDate		
        this.contbuildDate.setBoundLabelText(resHelper.getString("contbuildDate.boundLabelText"));		
        this.contbuildDate.setBoundLabelLength(100);		
        this.contbuildDate.setBoundLabelUnderline(true);		
        this.contbuildDate.setVisible(true);
        // contmilesStd		
        this.contmilesStd.setBoundLabelText(resHelper.getString("contmilesStd.boundLabelText"));		
        this.contmilesStd.setBoundLabelLength(100);		
        this.contmilesStd.setBoundLabelUnderline(true);		
        this.contmilesStd.setVisible(true);
        // conteveyHomeNum		
        this.conteveyHomeNum.setBoundLabelText(resHelper.getString("conteveyHomeNum.boundLabelText"));		
        this.conteveyHomeNum.setBoundLabelLength(100);		
        this.conteveyHomeNum.setBoundLabelUnderline(true);		
        this.conteveyHomeNum.setVisible(true);
        // conthomeNum		
        this.conthomeNum.setBoundLabelText(resHelper.getString("conthomeNum.boundLabelText"));		
        this.conthomeNum.setBoundLabelLength(100);		
        this.conthomeNum.setBoundLabelUnderline(true);		
        this.conthomeNum.setVisible(true);
        // contfeedingType		
        this.contfeedingType.setBoundLabelText(resHelper.getString("contfeedingType.boundLabelText"));		
        this.contfeedingType.setBoundLabelLength(100);		
        this.contfeedingType.setBoundLabelUnderline(true);		
        this.contfeedingType.setVisible(true);
        // chkprohibitArea		
        this.chkprohibitArea.setText(resHelper.getString("chkprohibitArea.text"));		
        this.chkprohibitArea.setVisible(true);		
        this.chkprohibitArea.setHorizontalAlignment(2);
        // contsuccessiveContract		
        this.contsuccessiveContract.setBoundLabelText(resHelper.getString("contsuccessiveContract.boundLabelText"));		
        this.contsuccessiveContract.setBoundLabelLength(100);		
        this.contsuccessiveContract.setBoundLabelUnderline(true);		
        this.contsuccessiveContract.setVisible(true);
        // contheard		
        this.contheard.setBoundLabelText(resHelper.getString("contheard.boundLabelText"));		
        this.contheard.setBoundLabelLength(100);		
        this.contheard.setBoundLabelUnderline(true);		
        this.contheard.setVisible(true);
        // contfarmScale		
        this.contfarmScale.setBoundLabelText(resHelper.getString("contfarmScale.boundLabelText"));		
        this.contfarmScale.setBoundLabelLength(100);		
        this.contfarmScale.setBoundLabelUnderline(true);		
        this.contfarmScale.setVisible(true);
        // chkisSupplier		
        this.chkisSupplier.setText(resHelper.getString("chkisSupplier.text"));		
        this.chkisSupplier.setVisible(true);		
        this.chkisSupplier.setHorizontalAlignment(2);
        // chkisFarm		
        this.chkisFarm.setText(resHelper.getString("chkisFarm.text"));		
        this.chkisFarm.setVisible(true);		
        this.chkisFarm.setHorizontalAlignment(2);
        // contnewSupplier		
        this.contnewSupplier.setBoundLabelText(resHelper.getString("contnewSupplier.boundLabelText"));		
        this.contnewSupplier.setBoundLabelLength(100);		
        this.contnewSupplier.setBoundLabelUnderline(true);		
        this.contnewSupplier.setVisible(true);
        // contnewFarm		
        this.contnewFarm.setBoundLabelText(resHelper.getString("contnewFarm.boundLabelText"));		
        this.contnewFarm.setBoundLabelLength(100);		
        this.contnewFarm.setBoundLabelUnderline(true);		
        this.contnewFarm.setVisible(true);
        // contheardcell1		
        this.contheardcell1.setBoundLabelText(resHelper.getString("contheardcell1.boundLabelText"));		
        this.contheardcell1.setBoundLabelLength(100);		
        this.contheardcell1.setBoundLabelUnderline(true);		
        this.contheardcell1.setVisible(true);
        // contfarmside		
        this.contfarmside.setBoundLabelText(resHelper.getString("contfarmside.boundLabelText"));		
        this.contfarmside.setBoundLabelLength(100);		
        this.contfarmside.setBoundLabelUnderline(true);		
        this.contfarmside.setVisible(true);
        // contyzjincrease		
        this.contyzjincrease.setBoundLabelText(resHelper.getString("contyzjincrease.boundLabelText"));		
        this.contyzjincrease.setBoundLabelLength(100);		
        this.contyzjincrease.setBoundLabelUnderline(true);		
        this.contyzjincrease.setVisible(true);
        // contchickenSource		
        this.contchickenSource.setBoundLabelText(resHelper.getString("contchickenSource.boundLabelText"));		
        this.contchickenSource.setBoundLabelLength(100);		
        this.contchickenSource.setBoundLabelUnderline(true);		
        this.contchickenSource.setVisible(true);
        // txtpartyBCell		
        this.txtpartyBCell.setVisible(true);		
        this.txtpartyBCell.setHorizontalAlignment(2);		
        this.txtpartyBCell.setMaxLength(100);		
        this.txtpartyBCell.setRequired(false);
        // pkestiSignDate		
        this.pkestiSignDate.setVisible(true);		
        this.pkestiSignDate.setRequired(false);
        // txtmaterialClerk		
        this.txtmaterialClerk.setVisible(true);		
        this.txtmaterialClerk.setHorizontalAlignment(2);		
        this.txtmaterialClerk.setMaxLength(100);		
        this.txtmaterialClerk.setRequired(false);
        // txtestiInQty		
        this.txtestiInQty.setVisible(true);		
        this.txtestiInQty.setHorizontalAlignment(2);		
        this.txtestiInQty.setDataType(1);		
        this.txtestiInQty.setSupportedEmpty(true);		
        this.txtestiInQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtestiInQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtestiInQty.setPrecision(4);		
        this.txtestiInQty.setRequired(false);
        // pkestiInDate		
        this.pkestiInDate.setVisible(true);		
        this.pkestiInDate.setRequired(false);
        // txtSuccessiveBatchQty		
        this.txtSuccessiveBatchQty.setVisible(true);		
        this.txtSuccessiveBatchQty.setHorizontalAlignment(2);		
        this.txtSuccessiveBatchQty.setDataType(0);		
        this.txtSuccessiveBatchQty.setSupportedEmpty(true);		
        this.txtSuccessiveBatchQty.setRequired(false);
        // txtsafePrice		
        this.txtsafePrice.setVisible(true);		
        this.txtsafePrice.setHorizontalAlignment(2);		
        this.txtsafePrice.setDataType(1);		
        this.txtsafePrice.setSupportedEmpty(true);		
        this.txtsafePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsafePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsafePrice.setPrecision(4);		
        this.txtsafePrice.setRequired(false);
        // txtpromisePrice		
        this.txtpromisePrice.setVisible(true);		
        this.txtpromisePrice.setHorizontalAlignment(2);		
        this.txtpromisePrice.setDataType(1);		
        this.txtpromisePrice.setSupportedEmpty(true);		
        this.txtpromisePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpromisePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpromisePrice.setPrecision(4);		
        this.txtpromisePrice.setRequired(false);
        // prmtcontractType		
        this.prmtcontractType.setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.ContractTypeQuery");		
        this.prmtcontractType.setVisible(true);		
        this.prmtcontractType.setEditable(true);		
        this.prmtcontractType.setDisplayFormat("$name$");		
        this.prmtcontractType.setEditFormat("$number$");		
        this.prmtcontractType.setCommitFormat("$number$");		
        this.prmtcontractType.setRequired(true);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
        this.prmtfarm.setVisible(true);		
        this.prmtfarm.setEditable(true);		
        this.prmtfarm.setDisplayFormat("$name$");		
        this.prmtfarm.setEditFormat("$number$");		
        this.prmtfarm.setCommitFormat("$number$");		
        this.prmtfarm.setRequired(false);
        		prmtfarm.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmListUI prmtfarm_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarm_F7ListUI == null) {
					try {
						prmtfarm_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarm_F7ListUI));
					prmtfarm_F7ListUI.setF7Use(true,ctx);
					prmtfarm.setSelector(prmtfarm_F7ListUI);
				}
			}
		});
					
        prmtfarm.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtfarm_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtbailPolicy		
        this.prmtbailPolicy.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.AssureAmtPolicyQuery");		
        this.prmtbailPolicy.setVisible(true);		
        this.prmtbailPolicy.setEditable(true);		
        this.prmtbailPolicy.setDisplayFormat("$name$");		
        this.prmtbailPolicy.setEditFormat("$number$");		
        this.prmtbailPolicy.setCommitFormat("$number$");		
        this.prmtbailPolicy.setRequired(false);
        		prmtbailPolicy.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.taihe.contract.client.AssureAmtPolicyListUI prmtbailPolicy_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbailPolicy_F7ListUI == null) {
					try {
						prmtbailPolicy_F7ListUI = new com.kingdee.eas.custom.taihe.contract.client.AssureAmtPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbailPolicy_F7ListUI));
					prmtbailPolicy_F7ListUI.setF7Use(true,ctx);
					prmtbailPolicy.setSelector(prmtbailPolicy_F7ListUI);
				}
			}
		});
					
        // txtheardcell		
        this.txtheardcell.setVisible(true);		
        this.txtheardcell.setHorizontalAlignment(2);		
        this.txtheardcell.setDataType(0);		
        this.txtheardcell.setSupportedEmpty(true);		
        this.txtheardcell.setRequired(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setVisible(true);		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(true);
        // prmtpurchasePeron		
        this.prmtpurchasePeron.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtpurchasePeron.setVisible(true);		
        this.prmtpurchasePeron.setEditable(true);		
        this.prmtpurchasePeron.setDisplayFormat("$name$");		
        this.prmtpurchasePeron.setEditFormat("$number$");		
        this.prmtpurchasePeron.setCommitFormat("$number$");		
        this.prmtpurchasePeron.setRequired(false);
        // prmtsettlePolicy		
        this.prmtsettlePolicy.setQueryInfo("com.kingdee.eas.custom.taihe.settle.app.TaiHeSettlePolicyQuery");		
        this.prmtsettlePolicy.setVisible(true);		
        this.prmtsettlePolicy.setEditable(true);		
        this.prmtsettlePolicy.setDisplayFormat("$name$");		
        this.prmtsettlePolicy.setEditFormat("$number$");		
        this.prmtsettlePolicy.setCommitFormat("$number$");		
        this.prmtsettlePolicy.setRequired(false);
        prmtsettlePolicy.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtsettlePolicy_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtpolicyPrice		
        this.txtpolicyPrice.setVisible(true);		
        this.txtpolicyPrice.setHorizontalAlignment(2);		
        this.txtpolicyPrice.setDataType(1);		
        this.txtpolicyPrice.setSupportedEmpty(true);		
        this.txtpolicyPrice.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtpolicyPrice.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtpolicyPrice.setPrecision(10);		
        this.txtpolicyPrice.setRequired(false);
        // txtcontractPrice		
        this.txtcontractPrice.setVisible(true);		
        this.txtcontractPrice.setHorizontalAlignment(2);		
        this.txtcontractPrice.setDataType(1);		
        this.txtcontractPrice.setSupportedEmpty(true);		
        this.txtcontractPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcontractPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcontractPrice.setPrecision(4);		
        this.txtcontractPrice.setRequired(false);
        // pkbuildDate		
        this.pkbuildDate.setVisible(true);		
        this.pkbuildDate.setRequired(false);
        // txtmilesStd		
        this.txtmilesStd.setVisible(true);		
        this.txtmilesStd.setHorizontalAlignment(2);		
        this.txtmilesStd.setDataType(1);		
        this.txtmilesStd.setSupportedEmpty(true);		
        this.txtmilesStd.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtmilesStd.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtmilesStd.setPrecision(10);		
        this.txtmilesStd.setRequired(false);
        // txteveyHomeNum		
        this.txteveyHomeNum.setVisible(true);		
        this.txteveyHomeNum.setHorizontalAlignment(2);		
        this.txteveyHomeNum.setMaxLength(80);		
        this.txteveyHomeNum.setRequired(false);
        // txthomeNum		
        this.txthomeNum.setVisible(true);		
        this.txthomeNum.setHorizontalAlignment(2);		
        this.txthomeNum.setDataType(1);		
        this.txthomeNum.setSupportedEmpty(true);		
        this.txthomeNum.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txthomeNum.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txthomeNum.setPrecision(10);		
        this.txthomeNum.setRequired(false);
        // feedingType		
        this.feedingType.setVisible(true);		
        this.feedingType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.taihe.contract.FeedType").toArray());		
        this.feedingType.setRequired(false);
        // prmtsuccessiveContract		
        this.prmtsuccessiveContract.setQueryInfo("com.kingdee.eas.custom.taihe.contract.app.SuccessiveContractQuery");		
        this.prmtsuccessiveContract.setVisible(true);		
        this.prmtsuccessiveContract.setEditable(true);		
        this.prmtsuccessiveContract.setDisplayFormat("$number$");		
        this.prmtsuccessiveContract.setEditFormat("$number$");		
        this.prmtsuccessiveContract.setCommitFormat("$number$");		
        this.prmtsuccessiveContract.setRequired(false);
        // txtheard		
        this.txtheard.setVisible(true);		
        this.txtheard.setHorizontalAlignment(2);		
        this.txtheard.setMaxLength(80);		
        this.txtheard.setRequired(false);
        // txtfarmScale		
        this.txtfarmScale.setVisible(true);		
        this.txtfarmScale.setHorizontalAlignment(2);		
        this.txtfarmScale.setDataType(1);		
        this.txtfarmScale.setSupportedEmpty(true);		
        this.txtfarmScale.setMinimumValue( new java.math.BigDecimal("-3.4028234663852886E38"));		
        this.txtfarmScale.setMaximumValue( new java.math.BigDecimal("3.4028234663852886E38"));		
        this.txtfarmScale.setPrecision(10);		
        this.txtfarmScale.setRequired(false);
        // txtnewSupplier		
        this.txtnewSupplier.setVisible(true);		
        this.txtnewSupplier.setHorizontalAlignment(2);		
        this.txtnewSupplier.setMaxLength(100);		
        this.txtnewSupplier.setRequired(false);		
        this.txtnewSupplier.setEnabled(false);
        // txtnewFarm		
        this.txtnewFarm.setVisible(true);		
        this.txtnewFarm.setHorizontalAlignment(2);		
        this.txtnewFarm.setMaxLength(100);		
        this.txtnewFarm.setRequired(false);		
        this.txtnewFarm.setEnabled(false);
        // txtheardcell1		
        this.txtheardcell1.setVisible(true);		
        this.txtheardcell1.setHorizontalAlignment(2);		
        this.txtheardcell1.setMaxLength(100);		
        this.txtheardcell1.setRequired(false);
        // txtfarmside		
        this.txtfarmside.setVisible(true);		
        this.txtfarmside.setHorizontalAlignment(2);		
        this.txtfarmside.setMaxLength(80);		
        this.txtfarmside.setRequired(false);
        // txtyzjincrease		
        this.txtyzjincrease.setVisible(true);		
        this.txtyzjincrease.setHorizontalAlignment(2);		
        this.txtyzjincrease.setMaxLength(100);		
        this.txtyzjincrease.setRequired(false);
        // txtchickenSource		
        this.txtchickenSource.setVisible(true);		
        this.txtchickenSource.setHorizontalAlignment(2);		
        this.txtchickenSource.setMaxLength(100);		
        this.txtchickenSource.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {chkisSuccessive,txtpartyBCell,pkestiSignDate,txtmaterialClerk,txtestiInQty,pkestiInDate,txtSuccessiveBatchQty,txtsafePrice,txtpromisePrice,chkisSignContract,pkauditTime,prmtcontractType,prmtfarm,prmtcompany,billStatus,txtremark,prmtbailPolicy,txtheardcell,prmtsupplier,prmtpurchasePeron,prmtsettlePolicy,txtpolicyPrice,txtcontractPrice,pkbuildDate,txtmilesStd,txteveyHomeNum,txthomeNum,feedingType,chkprohibitArea,prmtsuccessiveContract,txtheard,txtfarmScale,chkisSupplier,chkisFarm,txtnewSupplier,txtnewFarm,txtheardcell1,txtfarmside,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtyzjincrease,txtchickenSource}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 506));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 506));
        contCreator.setBounds(new Rectangle(372, 440, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(372, 440, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(730, 440, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(730, 440, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(372, 471, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(372, 471, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(730, 471, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(730, 471, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contNumber.setBounds(new Rectangle(22, 12, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(22, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(372, 12, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(372, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(979, 78, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(979, 78, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(22, 440, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(22, 440, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(22, 471, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(22, 471, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(723, 12, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(723, 12, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisSuccessive.setBounds(new Rectangle(128, 236, 84, 19));
        this.add(chkisSuccessive, new KDLayout.Constraints(128, 236, 84, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpartyBCell.setBounds(new Rectangle(723, 45, 270, 19));
        this.add(contpartyBCell, new KDLayout.Constraints(723, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contestiSignDate.setBounds(new Rectangle(22, 267, 270, 19));
        this.add(contestiSignDate, new KDLayout.Constraints(22, 267, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmaterialClerk.setBounds(new Rectangle(1001, 315, 270, 19));
        this.add(contmaterialClerk, new KDLayout.Constraints(1001, 315, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contestiInQty.setBounds(new Rectangle(723, 267, 270, 19));
        this.add(contestiInQty, new KDLayout.Constraints(723, 267, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contestiInDate.setBounds(new Rectangle(372, 267, 270, 19));
        this.add(contestiInDate, new KDLayout.Constraints(372, 267, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSuccessiveBatchQty.setBounds(new Rectangle(723, 236, 270, 19));
        this.add(contSuccessiveBatchQty, new KDLayout.Constraints(723, 236, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contsafePrice.setBounds(new Rectangle(372, 300, 270, 19));
        this.add(contsafePrice, new KDLayout.Constraints(372, 300, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpromisePrice.setBounds(new Rectangle(723, 300, 270, 19));
        this.add(contpromisePrice, new KDLayout.Constraints(723, 300, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisSignContract.setBounds(new Rectangle(723, 333, 270, 19));
        this.add(chkisSignContract, new KDLayout.Constraints(723, 333, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcontractType.setBounds(new Rectangle(22, 45, 270, 19));
        this.add(contcontractType, new KDLayout.Constraints(22, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarm.setBounds(new Rectangle(22, 135, 270, 19));
        this.add(contfarm, new KDLayout.Constraints(22, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(372, 333, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(372, 333, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        txtremark.setBounds(new Rectangle(21, 394, 979, 26));
        this.add(txtremark, new KDLayout.Constraints(21, 394, 979, 26, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbailPolicy.setBounds(new Rectangle(22, 300, 270, 19));
        this.add(contbailPolicy, new KDLayout.Constraints(22, 300, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheardcell.setBounds(new Rectangle(-372, 135, 270, 19));
        this.add(contheardcell, new KDLayout.Constraints(-372, 135, 270, 19, 0));
        contsupplier.setBounds(new Rectangle(372, 45, 270, 19));
        this.add(contsupplier, new KDLayout.Constraints(372, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpurchasePeron.setBounds(new Rectangle(22, 333, 270, 19));
        this.add(contpurchasePeron, new KDLayout.Constraints(22, 333, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlePolicy.setBounds(new Rectangle(22, 102, 270, 19));
        this.add(contsettlePolicy, new KDLayout.Constraints(22, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contpolicyPrice.setBounds(new Rectangle(372, 102, 270, 19));
        this.add(contpolicyPrice, new KDLayout.Constraints(372, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcontractPrice.setBounds(new Rectangle(723, 102, 270, 19));
        this.add(contcontractPrice, new KDLayout.Constraints(723, 102, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbuildDate.setBounds(new Rectangle(372, 168, 270, 19));
        this.add(contbuildDate, new KDLayout.Constraints(372, 168, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmilesStd.setBounds(new Rectangle(723, 168, 270, 19));
        this.add(contmilesStd, new KDLayout.Constraints(723, 168, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conteveyHomeNum.setBounds(new Rectangle(22, 201, 270, 19));
        this.add(conteveyHomeNum, new KDLayout.Constraints(22, 201, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthomeNum.setBounds(new Rectangle(372, 201, 270, 19));
        this.add(conthomeNum, new KDLayout.Constraints(372, 201, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedingType.setBounds(new Rectangle(723, 201, 270, 19));
        this.add(contfeedingType, new KDLayout.Constraints(723, 201, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkprohibitArea.setBounds(new Rectangle(22, 236, 92, 19));
        this.add(chkprohibitArea, new KDLayout.Constraints(22, 236, 92, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuccessiveContract.setBounds(new Rectangle(372, 236, 270, 19));
        this.add(contsuccessiveContract, new KDLayout.Constraints(372, 236, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheard.setBounds(new Rectangle(723, 135, 270, 19));
        this.add(contheard, new KDLayout.Constraints(723, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contfarmScale.setBounds(new Rectangle(22, 168, 270, 19));
        this.add(contfarmScale, new KDLayout.Constraints(22, 168, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisSupplier.setBounds(new Rectangle(22, 77, 102, 19));
        this.add(chkisSupplier, new KDLayout.Constraints(22, 77, 102, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkisFarm.setBounds(new Rectangle(150, 77, 139, 19));
        this.add(chkisFarm, new KDLayout.Constraints(150, 77, 139, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnewSupplier.setBounds(new Rectangle(372, 73, 270, 19));
        this.add(contnewSupplier, new KDLayout.Constraints(372, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contnewFarm.setBounds(new Rectangle(723, 73, 270, 19));
        this.add(contnewFarm, new KDLayout.Constraints(723, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contheardcell1.setBounds(new Rectangle(372, 134, 270, 19));
        this.add(contheardcell1, new KDLayout.Constraints(372, 134, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmside.setBounds(new Rectangle(23, 365, 270, 19));
        this.add(contfarmside, new KDLayout.Constraints(23, 365, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contyzjincrease.setBounds(new Rectangle(373, 364, 270, 19));
        this.add(contyzjincrease, new KDLayout.Constraints(373, 364, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenSource.setBounds(new Rectangle(723, 362, 270, 19));
        this.add(contchickenSource, new KDLayout.Constraints(723, 362, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //contpartyBCell
        contpartyBCell.setBoundEditor(txtpartyBCell);
        //contestiSignDate
        contestiSignDate.setBoundEditor(pkestiSignDate);
        //contmaterialClerk
        contmaterialClerk.setBoundEditor(txtmaterialClerk);
        //contestiInQty
        contestiInQty.setBoundEditor(txtestiInQty);
        //contestiInDate
        contestiInDate.setBoundEditor(pkestiInDate);
        //contSuccessiveBatchQty
        contSuccessiveBatchQty.setBoundEditor(txtSuccessiveBatchQty);
        //contsafePrice
        contsafePrice.setBoundEditor(txtsafePrice);
        //contpromisePrice
        contpromisePrice.setBoundEditor(txtpromisePrice);
        //contcontractType
        contcontractType.setBoundEditor(prmtcontractType);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contbailPolicy
        contbailPolicy.setBoundEditor(prmtbailPolicy);
        //contheardcell
        contheardcell.setBoundEditor(txtheardcell);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contpurchasePeron
        contpurchasePeron.setBoundEditor(prmtpurchasePeron);
        //contsettlePolicy
        contsettlePolicy.setBoundEditor(prmtsettlePolicy);
        //contpolicyPrice
        contpolicyPrice.setBoundEditor(txtpolicyPrice);
        //contcontractPrice
        contcontractPrice.setBoundEditor(txtcontractPrice);
        //contbuildDate
        contbuildDate.setBoundEditor(pkbuildDate);
        //contmilesStd
        contmilesStd.setBoundEditor(txtmilesStd);
        //conteveyHomeNum
        conteveyHomeNum.setBoundEditor(txteveyHomeNum);
        //conthomeNum
        conthomeNum.setBoundEditor(txthomeNum);
        //contfeedingType
        contfeedingType.setBoundEditor(feedingType);
        //contsuccessiveContract
        contsuccessiveContract.setBoundEditor(prmtsuccessiveContract);
        //contheard
        contheard.setBoundEditor(txtheard);
        //contfarmScale
        contfarmScale.setBoundEditor(txtfarmScale);
        //contnewSupplier
        contnewSupplier.setBoundEditor(txtnewSupplier);
        //contnewFarm
        contnewFarm.setBoundEditor(txtnewFarm);
        //contheardcell1
        contheardcell1.setBoundEditor(txtheardcell1);
        //contfarmside
        contfarmside.setBoundEditor(txtfarmside);
        //contyzjincrease
        contyzjincrease.setBoundEditor(txtyzjincrease);
        //contchickenSource
        contchickenSource.setBoundEditor(txtchickenSource);

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
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("isSuccessive", boolean.class, this.chkisSuccessive, "selected");
		dataBinder.registerBinding("isSignContract", boolean.class, this.chkisSignContract, "selected");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("prohibitArea", boolean.class, this.chkprohibitArea, "selected");
		dataBinder.registerBinding("isSupplier", boolean.class, this.chkisSupplier, "selected");
		dataBinder.registerBinding("isFarm", boolean.class, this.chkisFarm, "selected");
		dataBinder.registerBinding("partyBCell", String.class, this.txtpartyBCell, "text");
		dataBinder.registerBinding("estiSignDate", java.util.Date.class, this.pkestiSignDate, "value");
		dataBinder.registerBinding("materialClerk", String.class, this.txtmaterialClerk, "text");
		dataBinder.registerBinding("estiInQty", java.math.BigDecimal.class, this.txtestiInQty, "value");
		dataBinder.registerBinding("estiInDate", java.util.Date.class, this.pkestiInDate, "value");
		dataBinder.registerBinding("SuccessiveBatchQty", int.class, this.txtSuccessiveBatchQty, "value");
		dataBinder.registerBinding("safePrice", java.math.BigDecimal.class, this.txtsafePrice, "value");
		dataBinder.registerBinding("promisePrice", java.math.BigDecimal.class, this.txtpromisePrice, "value");
		dataBinder.registerBinding("contractType", com.kingdee.eas.custom.signwasthetable.ContractTypeInfo.class, this.prmtcontractType, "data");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("bailPolicy", com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo.class, this.prmtbailPolicy, "data");
		dataBinder.registerBinding("heardcell", int.class, this.txtheardcell, "value");
		dataBinder.registerBinding("supplier", com.kingdee.eas.bdm.bdapply.SupplierReqInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("purchasePeron", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtpurchasePeron, "data");
		dataBinder.registerBinding("settlePolicy", com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo.class, this.prmtsettlePolicy, "data");
		dataBinder.registerBinding("policyPrice", java.math.BigDecimal.class, this.txtpolicyPrice, "value");
		dataBinder.registerBinding("contractPrice", java.math.BigDecimal.class, this.txtcontractPrice, "value");
		dataBinder.registerBinding("buildDate", java.util.Date.class, this.pkbuildDate, "value");
		dataBinder.registerBinding("milesStd", java.math.BigDecimal.class, this.txtmilesStd, "value");
		dataBinder.registerBinding("eveyHomeNum", String.class, this.txteveyHomeNum, "text");
		dataBinder.registerBinding("homeNum", java.math.BigDecimal.class, this.txthomeNum, "value");
		dataBinder.registerBinding("feedingType", com.kingdee.eas.custom.taihe.contract.FeedType.class, this.feedingType, "selectedItem");
		dataBinder.registerBinding("successiveContract", com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo.class, this.prmtsuccessiveContract, "data");
		dataBinder.registerBinding("heard", String.class, this.txtheard, "text");
		dataBinder.registerBinding("farmScale", java.math.BigDecimal.class, this.txtfarmScale, "value");
		dataBinder.registerBinding("newSupplier", String.class, this.txtnewSupplier, "text");
		dataBinder.registerBinding("newFarm", String.class, this.txtnewFarm, "text");
		dataBinder.registerBinding("heardcell1", String.class, this.txtheardcell1, "text");
		dataBinder.registerBinding("farmside", String.class, this.txtfarmside, "text");
		dataBinder.registerBinding("yzjincrease", String.class, this.txtyzjincrease, "text");
		dataBinder.registerBinding("chickenSource", String.class, this.txtchickenSource, "text");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.taihe.contract.app.PreBillOfContractEditUIHandler";
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
        this.chkisSuccessive.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo)ov;
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
		getValidateHelper().registerBindProperty("isSuccessive", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSignContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("prohibitArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isSupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("partyBCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estiSignDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("materialClerk", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estiInQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("estiInDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SuccessiveBatchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("safePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("promisePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bailPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("heardcell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("purchasePeron", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlePolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policyPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("contractPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buildDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("milesStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eveyHomeNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("homeNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedingType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("successiveContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("heard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmScale", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("newSupplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("newFarm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("heardcell1", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmside", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yzjincrease", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSource", ValidateHelper.ON_SAVE);    		
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
     * output prmtfarm_Changed() method
     */
    public void prmtfarm_Changed() throws Exception
    {
        System.out.println("prmtfarm_Changed() Function is executed!");
            pkbuildDate.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getDateValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"buildDate")));

    txtmilesStd.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"milesStd")));

    txteveyHomeNum.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"everyHomeNum")));

    txthomeNum.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"homesNum")));

    feedingType.setSelectedItem(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"feedType"));

    chkprohibitArea.setSelected(com.kingdee.bos.ui.face.UIRuleUtil.getBooleanValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"prohibitArea")));

    txtheard.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"theHeader")));

    txtfarmScale.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"capacity")));

    txtfarmside.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtfarm.getData(),"address")));


    }

    /**
     * output prmtsettlePolicy_Changed() method
     */
    public void prmtsettlePolicy_Changed() throws Exception
    {
        System.out.println("prmtsettlePolicy_Changed() Function is executed!");
            txtpolicyPrice.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtsettlePolicy.getData(),"policyPrice")));


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
        sic.add(new SelectorItemInfo("isSuccessive"));
        sic.add(new SelectorItemInfo("isSignContract"));
        sic.add(new SelectorItemInfo("remark"));
        sic.add(new SelectorItemInfo("prohibitArea"));
        sic.add(new SelectorItemInfo("isSupplier"));
        sic.add(new SelectorItemInfo("isFarm"));
        sic.add(new SelectorItemInfo("partyBCell"));
        sic.add(new SelectorItemInfo("estiSignDate"));
        sic.add(new SelectorItemInfo("materialClerk"));
        sic.add(new SelectorItemInfo("estiInQty"));
        sic.add(new SelectorItemInfo("estiInDate"));
        sic.add(new SelectorItemInfo("SuccessiveBatchQty"));
        sic.add(new SelectorItemInfo("safePrice"));
        sic.add(new SelectorItemInfo("promisePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("contractType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("contractType.id"));
        	sic.add(new SelectorItemInfo("contractType.number"));
        	sic.add(new SelectorItemInfo("contractType.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
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
			sic.add(new SelectorItemInfo("bailPolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bailPolicy.id"));
        	sic.add(new SelectorItemInfo("bailPolicy.number"));
        	sic.add(new SelectorItemInfo("bailPolicy.name"));
		}
        sic.add(new SelectorItemInfo("heardcell"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("supplier.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("supplier.id"));
        	sic.add(new SelectorItemInfo("supplier.number"));
        	sic.add(new SelectorItemInfo("supplier.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("purchasePeron.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("purchasePeron.id"));
        	sic.add(new SelectorItemInfo("purchasePeron.number"));
        	sic.add(new SelectorItemInfo("purchasePeron.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("settlePolicy.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("settlePolicy.id"));
        	sic.add(new SelectorItemInfo("settlePolicy.number"));
        	sic.add(new SelectorItemInfo("settlePolicy.name"));
		}
        sic.add(new SelectorItemInfo("policyPrice"));
        sic.add(new SelectorItemInfo("contractPrice"));
        sic.add(new SelectorItemInfo("buildDate"));
        sic.add(new SelectorItemInfo("milesStd"));
        sic.add(new SelectorItemInfo("eveyHomeNum"));
        sic.add(new SelectorItemInfo("homeNum"));
        sic.add(new SelectorItemInfo("feedingType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("successiveContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("successiveContract.id"));
        	sic.add(new SelectorItemInfo("successiveContract.number"));
		}
        sic.add(new SelectorItemInfo("heard"));
        sic.add(new SelectorItemInfo("farmScale"));
        sic.add(new SelectorItemInfo("newSupplier"));
        sic.add(new SelectorItemInfo("newFarm"));
        sic.add(new SelectorItemInfo("heardcell1"));
        sic.add(new SelectorItemInfo("farmside"));
        sic.add(new SelectorItemInfo("yzjincrease"));
        sic.add(new SelectorItemInfo("chickenSource"));
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
        return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.client", "PreBillOfContractEditUI");
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
        return com.kingdee.eas.custom.taihe.contract.client.PreBillOfContractEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.PreBillOfContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.PreBillOfContractInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/taihe/contract/PreBillOfContract";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.taihe.contract.app.PreBillOfContractQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcontractType.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"合同类别"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsupplier.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"供应商"});
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
		vo.put("feedingType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}