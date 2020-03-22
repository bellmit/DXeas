/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

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
public abstract class AbstractSettlePolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettlePolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTemplate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoutDaysStd;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisForbidUnSettle;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisProDiv;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPriceEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPriceEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRecycleEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRecycleEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAwardsEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAwardsEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSubsidyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSubsidyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepositRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovisionType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer controadLossRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contminSingleDrug;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstandardRecRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfmRatePunishStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfreightSubsidiesStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contUnEnoungh;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaxSingleDrug;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneTost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcleanHouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreserveRiskOne;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreserveCheck;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdepositRate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox provisionType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtroadLossRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtminSingleDrug;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtstandardRecRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfmRatePunishStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfreightSubsidiesStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmuneCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtUnEnoungh;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmaxSingleDrug;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtimmuneTost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcleanHouse;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreserveRiskOne;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtreserveCheck;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoutDaysStd;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo editData = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionMulUpdate actionMulUpdate = null;
    /**
     * output class constructor
     */
    public AbstractSettlePolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettlePolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionIsTemplate
        this.actionIsTemplate = new ActionIsTemplate(this);
        getActionManager().registerAction("actionIsTemplate", actionIsTemplate);
        this.actionIsTemplate.setExtendProperty("canForewarn", "true");
        this.actionIsTemplate.setExtendProperty("userDefined", "false");
        this.actionIsTemplate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        //actionMulUpdate
        this.actionMulUpdate = new ActionMulUpdate(this);
        getActionManager().registerAction("actionMulUpdate", actionMulUpdate);
        this.actionMulUpdate.setExtendProperty("canForewarn", "true");
        this.actionMulUpdate.setExtendProperty("userDefined", "true");
        this.actionMulUpdate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionMulUpdate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionMulUpdate.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.chkisTemplate = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoutDaysStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisForbidUnSettle = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisProDiv = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtPriceEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRecycleEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAwardsEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSubsidyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contdepositRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovisionType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.controadLossRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contminSingleDrug = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstandardRecRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfmRatePunishStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfreightSubsidiesStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contUnEnoungh = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaxSingleDrug = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneTost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcleanHouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreserveRiskOne = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreserveCheck = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdepositRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.provisionType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtroadLossRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtminSingleDrug = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtstandardRecRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfmRatePunishStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfreightSubsidiesStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimmuneCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtUnEnoungh = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmaxSingleDrug = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtimmuneTost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcleanHouse = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreserveRiskOne = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtreserveCheck = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtoutDaysStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator5.setName("kDSeparator5");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.contcompany.setName("contcompany");
        this.kDSeparator6.setName("kDSeparator6");
        this.chkisTemplate.setName("chkisTemplate");
        this.contbreedData.setName("contbreedData");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contoutDaysStd.setName("contoutDaysStd");
        this.chkisForbidUnSettle.setName("chkisForbidUnSettle");
        this.chkisProDiv.setName("chkisProDiv");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtPriceEntry.setName("kdtPriceEntry");
        this.kdtRecycleEntry.setName("kdtRecycleEntry");
        this.kdtAwardsEntry.setName("kdtAwardsEntry");
        this.kdtSubsidyEntry.setName("kdtSubsidyEntry");
        this.contdepositRate.setName("contdepositRate");
        this.contprovisionType.setName("contprovisionType");
        this.controadLossRate.setName("controadLossRate");
        this.contminSingleDrug.setName("contminSingleDrug");
        this.contstandardRecRate.setName("contstandardRecRate");
        this.contfmRatePunishStd.setName("contfmRatePunishStd");
        this.contfreightSubsidiesStd.setName("contfreightSubsidiesStd");
        this.contimmuneCost.setName("contimmuneCost");
        this.contUnEnoungh.setName("contUnEnoungh");
        this.contmaxSingleDrug.setName("contmaxSingleDrug");
        this.contimmuneTost.setName("contimmuneTost");
        this.contcleanHouse.setName("contcleanHouse");
        this.contreserveRiskOne.setName("contreserveRiskOne");
        this.contreserveCheck.setName("contreserveCheck");
        this.txtdepositRate.setName("txtdepositRate");
        this.provisionType.setName("provisionType");
        this.txtroadLossRate.setName("txtroadLossRate");
        this.txtminSingleDrug.setName("txtminSingleDrug");
        this.txtstandardRecRate.setName("txtstandardRecRate");
        this.txtfmRatePunishStd.setName("txtfmRatePunishStd");
        this.txtfreightSubsidiesStd.setName("txtfreightSubsidiesStd");
        this.txtimmuneCost.setName("txtimmuneCost");
        this.txtUnEnoungh.setName("txtUnEnoungh");
        this.txtmaxSingleDrug.setName("txtmaxSingleDrug");
        this.txtimmuneTost.setName("txtimmuneTost");
        this.txtcleanHouse.setName("txtcleanHouse");
        this.txtreserveRiskOne.setName("txtreserveRiskOne");
        this.txtreserveCheck.setName("txtreserveCheck");
        this.baseStatus.setName("baseStatus");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtcompany.setName("prmtcompany");
        this.prmtbreedData.setName("prmtbreedData");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtoutDaysStd.setName("txtoutDaysStd");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contauditor		
        this.contauditor.setBoundLabelText(resHelper.getString("contauditor.boundLabelText"));		
        this.contauditor.setBoundLabelLength(100);		
        this.contauditor.setBoundLabelUnderline(true);		
        this.contauditor.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // kDSeparator5
        // contcreator		
        this.contcreator.setBoundLabelText(resHelper.getString("contcreator.boundLabelText"));		
        this.contcreator.setBoundLabelLength(100);		
        this.contcreator.setBoundLabelUnderline(true);		
        this.contcreator.setVisible(true);
        // contcreateTime		
        this.contcreateTime.setBoundLabelText(resHelper.getString("contcreateTime.boundLabelText"));		
        this.contcreateTime.setBoundLabelLength(100);		
        this.contcreateTime.setBoundLabelUnderline(true);		
        this.contcreateTime.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDSeparator6
        // chkisTemplate		
        this.chkisTemplate.setText(resHelper.getString("chkisTemplate.text"));		
        this.chkisTemplate.setHorizontalAlignment(2);		
        this.chkisTemplate.setVisible(false);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contoutDaysStd		
        this.contoutDaysStd.setBoundLabelText(resHelper.getString("contoutDaysStd.boundLabelText"));		
        this.contoutDaysStd.setBoundLabelLength(100);		
        this.contoutDaysStd.setBoundLabelUnderline(true);		
        this.contoutDaysStd.setVisible(true);
        // chkisForbidUnSettle		
        this.chkisForbidUnSettle.setText(resHelper.getString("chkisForbidUnSettle.text"));		
        this.chkisForbidUnSettle.setHorizontalAlignment(2);
        // chkisProDiv		
        this.chkisProDiv.setText(resHelper.getString("chkisProDiv.text"));		
        this.chkisProDiv.setVisible(true);		
        this.chkisProDiv.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kDPanel4
        // kdtPriceEntry
		String kdtPriceEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"3\" /><t:Column t:key=\"settleItemType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"overRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{settleItemType}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{overRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPriceEntry.setFormatXml(resHelper.translateString("kdtPriceEntry",kdtPriceEntryStrXML));
        kdtPriceEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPriceEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        this.kdtPriceEntry.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kdtPriceEntry_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });

                this.kdtPriceEntry.putBindContents("editData",new String[] {"seq","material","materialName","settlementItem","settleItemType","model","unit","basePrice","overRate"});


        this.kdtPriceEntry.checkParsed();
        final KDBizPromptBox kdtPriceEntry_material_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtPriceEntry_material_PromptBox.setVisible(true);
        kdtPriceEntry_material_PromptBox.setEditable(true);
        kdtPriceEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_material_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_material_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_material_PromptBox);
        this.kdtPriceEntry.getColumn("material").setEditor(kdtPriceEntry_material_CellEditor);
        ObjectValueRender kdtPriceEntry_material_OVR = new ObjectValueRender();
        kdtPriceEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtPriceEntry.getColumn("material").setRenderer(kdtPriceEntry_material_OVR);
        KDTextField kdtPriceEntry_materialName_TextField = new KDTextField();
        kdtPriceEntry_materialName_TextField.setName("kdtPriceEntry_materialName_TextField");
        kdtPriceEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_materialName_TextField);
        this.kdtPriceEntry.getColumn("materialName").setEditor(kdtPriceEntry_materialName_CellEditor);
        final KDBizPromptBox kdtPriceEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtPriceEntry_settlementItem_PromptBox.setVisible(true);
        kdtPriceEntry_settlementItem_PromptBox.setEditable(true);
        kdtPriceEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settlementItem_PromptBox);
        this.kdtPriceEntry.getColumn("settlementItem").setEditor(kdtPriceEntry_settlementItem_CellEditor);
        ObjectValueRender kdtPriceEntry_settlementItem_OVR = new ObjectValueRender();
        kdtPriceEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("settlementItem").setRenderer(kdtPriceEntry_settlementItem_OVR);
        			kdtPriceEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtPriceEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPriceEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtPriceEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPriceEntry_settlementItem_PromptBox_F7ListUI));
					kdtPriceEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPriceEntry_settlementItem_PromptBox.setSelector(kdtPriceEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDComboBox kdtPriceEntry_settleItemType_ComboBox = new KDComboBox();
        kdtPriceEntry_settleItemType_ComboBox.setName("kdtPriceEntry_settleItemType_ComboBox");
        kdtPriceEntry_settleItemType_ComboBox.setVisible(true);
        kdtPriceEntry_settleItemType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.SettleItemType").toArray());
        KDTDefaultCellEditor kdtPriceEntry_settleItemType_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settleItemType_ComboBox);
        this.kdtPriceEntry.getColumn("settleItemType").setEditor(kdtPriceEntry_settleItemType_CellEditor);
        KDTextField kdtPriceEntry_model_TextField = new KDTextField();
        kdtPriceEntry_model_TextField.setName("kdtPriceEntry_model_TextField");
        kdtPriceEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_model_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_model_TextField);
        this.kdtPriceEntry.getColumn("model").setEditor(kdtPriceEntry_model_CellEditor);
        final KDBizPromptBox kdtPriceEntry_unit_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtPriceEntry_unit_PromptBox.setVisible(true);
        kdtPriceEntry_unit_PromptBox.setEditable(true);
        kdtPriceEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_unit_PromptBox);
        this.kdtPriceEntry.getColumn("unit").setEditor(kdtPriceEntry_unit_CellEditor);
        ObjectValueRender kdtPriceEntry_unit_OVR = new ObjectValueRender();
        kdtPriceEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("unit").setRenderer(kdtPriceEntry_unit_OVR);
        KDFormattedTextField kdtPriceEntry_basePrice_TextField = new KDFormattedTextField();
        kdtPriceEntry_basePrice_TextField.setName("kdtPriceEntry_basePrice_TextField");
        kdtPriceEntry_basePrice_TextField.setVisible(true);
        kdtPriceEntry_basePrice_TextField.setEditable(true);
        kdtPriceEntry_basePrice_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_basePrice_TextField.setDataType(1);
        	kdtPriceEntry_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_basePrice_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_basePrice_TextField);
        this.kdtPriceEntry.getColumn("basePrice").setEditor(kdtPriceEntry_basePrice_CellEditor);
        KDFormattedTextField kdtPriceEntry_overRate_TextField = new KDFormattedTextField();
        kdtPriceEntry_overRate_TextField.setName("kdtPriceEntry_overRate_TextField");
        kdtPriceEntry_overRate_TextField.setVisible(true);
        kdtPriceEntry_overRate_TextField.setEditable(true);
        kdtPriceEntry_overRate_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_overRate_TextField.setDataType(1);
        	kdtPriceEntry_overRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_overRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_overRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_overRate_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_overRate_TextField);
        this.kdtPriceEntry.getColumn("overRate").setEditor(kdtPriceEntry_overRate_CellEditor);
        // kdtRecycleEntry
		String kdtRecycleEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"recType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"minSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"minValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"maxSymbol\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"maxValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"fmRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"isUseAcualPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{recType}</t:Cell><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{minSymbol}</t:Cell><t:Cell>$Resource{minValue}</t:Cell><t:Cell>$Resource{maxSymbol}</t:Cell><t:Cell>$Resource{maxValue}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell><t:Cell>$Resource{fmRate}</t:Cell><t:Cell>$Resource{isUseAcualPrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRecycleEntry.setFormatXml(resHelper.translateString("kdtRecycleEntry",kdtRecycleEntryStrXML));
        kdtRecycleEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtRecycleEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtRecycleEntry.putBindContents("editData",new String[] {"recType","seq","material","materialName","settlementItem","model","unit","minSymbol","minValue","maxSymbol","maxValue","basePrice","fmRate","isUseAcualPrice"});


        this.kdtRecycleEntry.checkParsed();
        KDComboBox kdtRecycleEntry_recType_ComboBox = new KDComboBox();
        kdtRecycleEntry_recType_ComboBox.setName("kdtRecycleEntry_recType_ComboBox");
        kdtRecycleEntry_recType_ComboBox.setVisible(true);
        kdtRecycleEntry_recType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.recType").toArray());
        KDTDefaultCellEditor kdtRecycleEntry_recType_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_recType_ComboBox);
        this.kdtRecycleEntry.getColumn("recType").setEditor(kdtRecycleEntry_recType_CellEditor);
        final KDBizPromptBox kdtRecycleEntry_material_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtRecycleEntry_material_PromptBox.setVisible(true);
        kdtRecycleEntry_material_PromptBox.setEditable(true);
        kdtRecycleEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_material_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_material_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_material_PromptBox);
        this.kdtRecycleEntry.getColumn("material").setEditor(kdtRecycleEntry_material_CellEditor);
        ObjectValueRender kdtRecycleEntry_material_OVR = new ObjectValueRender();
        kdtRecycleEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtRecycleEntry.getColumn("material").setRenderer(kdtRecycleEntry_material_OVR);
        KDTextField kdtRecycleEntry_materialName_TextField = new KDTextField();
        kdtRecycleEntry_materialName_TextField.setName("kdtRecycleEntry_materialName_TextField");
        kdtRecycleEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtRecycleEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_materialName_TextField);
        this.kdtRecycleEntry.getColumn("materialName").setEditor(kdtRecycleEntry_materialName_CellEditor);
        final KDBizPromptBox kdtRecycleEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtRecycleEntry_settlementItem_PromptBox.setVisible(true);
        kdtRecycleEntry_settlementItem_PromptBox.setEditable(true);
        kdtRecycleEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_settlementItem_PromptBox);
        this.kdtRecycleEntry.getColumn("settlementItem").setEditor(kdtRecycleEntry_settlementItem_CellEditor);
        ObjectValueRender kdtRecycleEntry_settlementItem_OVR = new ObjectValueRender();
        kdtRecycleEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecycleEntry.getColumn("settlementItem").setRenderer(kdtRecycleEntry_settlementItem_OVR);
        			kdtRecycleEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtRecycleEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtRecycleEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtRecycleEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtRecycleEntry_settlementItem_PromptBox_F7ListUI));
					kdtRecycleEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtRecycleEntry_settlementItem_PromptBox.setSelector(kdtRecycleEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtRecycleEntry_model_TextField = new KDTextField();
        kdtRecycleEntry_model_TextField.setName("kdtRecycleEntry_model_TextField");
        kdtRecycleEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtRecycleEntry_model_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_model_TextField);
        this.kdtRecycleEntry.getColumn("model").setEditor(kdtRecycleEntry_model_CellEditor);
        final KDBizPromptBox kdtRecycleEntry_unit_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtRecycleEntry_unit_PromptBox.setVisible(true);
        kdtRecycleEntry_unit_PromptBox.setEditable(true);
        kdtRecycleEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_unit_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_unit_PromptBox);
        this.kdtRecycleEntry.getColumn("unit").setEditor(kdtRecycleEntry_unit_CellEditor);
        ObjectValueRender kdtRecycleEntry_unit_OVR = new ObjectValueRender();
        kdtRecycleEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecycleEntry.getColumn("unit").setRenderer(kdtRecycleEntry_unit_OVR);
        KDComboBox kdtRecycleEntry_minSymbol_ComboBox = new KDComboBox();
        kdtRecycleEntry_minSymbol_ComboBox.setName("kdtRecycleEntry_minSymbol_ComboBox");
        kdtRecycleEntry_minSymbol_ComboBox.setVisible(true);
        kdtRecycleEntry_minSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.highSymbol").toArray());
        KDTDefaultCellEditor kdtRecycleEntry_minSymbol_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_minSymbol_ComboBox);
        this.kdtRecycleEntry.getColumn("minSymbol").setEditor(kdtRecycleEntry_minSymbol_CellEditor);
        KDFormattedTextField kdtRecycleEntry_minValue_TextField = new KDFormattedTextField();
        kdtRecycleEntry_minValue_TextField.setName("kdtRecycleEntry_minValue_TextField");
        kdtRecycleEntry_minValue_TextField.setVisible(true);
        kdtRecycleEntry_minValue_TextField.setEditable(true);
        kdtRecycleEntry_minValue_TextField.setHorizontalAlignment(2);
        kdtRecycleEntry_minValue_TextField.setDataType(1);
        	kdtRecycleEntry_minValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtRecycleEntry_minValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtRecycleEntry_minValue_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtRecycleEntry_minValue_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_minValue_TextField);
        this.kdtRecycleEntry.getColumn("minValue").setEditor(kdtRecycleEntry_minValue_CellEditor);
        KDComboBox kdtRecycleEntry_maxSymbol_ComboBox = new KDComboBox();
        kdtRecycleEntry_maxSymbol_ComboBox.setName("kdtRecycleEntry_maxSymbol_ComboBox");
        kdtRecycleEntry_maxSymbol_ComboBox.setVisible(true);
        kdtRecycleEntry_maxSymbol_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.LessSymbol").toArray());
        KDTDefaultCellEditor kdtRecycleEntry_maxSymbol_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_maxSymbol_ComboBox);
        this.kdtRecycleEntry.getColumn("maxSymbol").setEditor(kdtRecycleEntry_maxSymbol_CellEditor);
        KDFormattedTextField kdtRecycleEntry_maxValue_TextField = new KDFormattedTextField();
        kdtRecycleEntry_maxValue_TextField.setName("kdtRecycleEntry_maxValue_TextField");
        kdtRecycleEntry_maxValue_TextField.setVisible(true);
        kdtRecycleEntry_maxValue_TextField.setEditable(true);
        kdtRecycleEntry_maxValue_TextField.setHorizontalAlignment(2);
        kdtRecycleEntry_maxValue_TextField.setDataType(1);
        	kdtRecycleEntry_maxValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtRecycleEntry_maxValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtRecycleEntry_maxValue_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtRecycleEntry_maxValue_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_maxValue_TextField);
        this.kdtRecycleEntry.getColumn("maxValue").setEditor(kdtRecycleEntry_maxValue_CellEditor);
        KDFormattedTextField kdtRecycleEntry_basePrice_TextField = new KDFormattedTextField();
        kdtRecycleEntry_basePrice_TextField.setName("kdtRecycleEntry_basePrice_TextField");
        kdtRecycleEntry_basePrice_TextField.setVisible(true);
        kdtRecycleEntry_basePrice_TextField.setEditable(true);
        kdtRecycleEntry_basePrice_TextField.setHorizontalAlignment(2);
        kdtRecycleEntry_basePrice_TextField.setDataType(1);
        	kdtRecycleEntry_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtRecycleEntry_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtRecycleEntry_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtRecycleEntry_basePrice_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_basePrice_TextField);
        this.kdtRecycleEntry.getColumn("basePrice").setEditor(kdtRecycleEntry_basePrice_CellEditor);
        KDFormattedTextField kdtRecycleEntry_fmRate_TextField = new KDFormattedTextField();
        kdtRecycleEntry_fmRate_TextField.setName("kdtRecycleEntry_fmRate_TextField");
        kdtRecycleEntry_fmRate_TextField.setVisible(true);
        kdtRecycleEntry_fmRate_TextField.setEditable(true);
        kdtRecycleEntry_fmRate_TextField.setHorizontalAlignment(2);
        kdtRecycleEntry_fmRate_TextField.setDataType(1);
        	kdtRecycleEntry_fmRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtRecycleEntry_fmRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtRecycleEntry_fmRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtRecycleEntry_fmRate_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_fmRate_TextField);
        this.kdtRecycleEntry.getColumn("fmRate").setEditor(kdtRecycleEntry_fmRate_CellEditor);
        KDCheckBox kdtRecycleEntry_isUseAcualPrice_CheckBox = new KDCheckBox();
        kdtRecycleEntry_isUseAcualPrice_CheckBox.setName("kdtRecycleEntry_isUseAcualPrice_CheckBox");
        KDTDefaultCellEditor kdtRecycleEntry_isUseAcualPrice_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_isUseAcualPrice_CheckBox);
        this.kdtRecycleEntry.getColumn("isUseAcualPrice").setEditor(kdtRecycleEntry_isUseAcualPrice_CellEditor);
        // kdtAwardsEntry
		String kdtAwardsEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"policy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"policyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"randPPolicy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"randPPolicyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{policy}</t:Cell><t:Cell>$Resource{policyName}</t:Cell><t:Cell>$Resource{randPPolicy}</t:Cell><t:Cell>$Resource{randPPolicyName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAwardsEntry.setFormatXml(resHelper.translateString("kdtAwardsEntry",kdtAwardsEntryStrXML));
        kdtAwardsEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtAwardsEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtAwardsEntry.putBindContents("editData",new String[] {"seq","policy","policyName","randPPolicy","randPPolicyName"});


        this.kdtAwardsEntry.checkParsed();
        final KDBizPromptBox kdtAwardsEntry_policy_PromptBox = new KDBizPromptBox();
        kdtAwardsEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.RewardsPolicyQuery");
        kdtAwardsEntry_policy_PromptBox.setVisible(true);
        kdtAwardsEntry_policy_PromptBox.setEditable(true);
        kdtAwardsEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setEditFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAwardsEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_policy_PromptBox);
        this.kdtAwardsEntry.getColumn("policy").setEditor(kdtAwardsEntry_policy_CellEditor);
        ObjectValueRender kdtAwardsEntry_policy_OVR = new ObjectValueRender();
        kdtAwardsEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAwardsEntry.getColumn("policy").setRenderer(kdtAwardsEntry_policy_OVR);
        			kdtAwardsEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI kdtAwardsEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAwardsEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtAwardsEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAwardsEntry_policy_PromptBox_F7ListUI));
					kdtAwardsEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAwardsEntry_policy_PromptBox.setSelector(kdtAwardsEntry_policy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtAwardsEntry_policyName_TextField = new KDTextField();
        kdtAwardsEntry_policyName_TextField.setName("kdtAwardsEntry_policyName_TextField");
        kdtAwardsEntry_policyName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtAwardsEntry_policyName_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_policyName_TextField);
        this.kdtAwardsEntry.getColumn("policyName").setEditor(kdtAwardsEntry_policyName_CellEditor);
        final KDBizPromptBox kdtAwardsEntry_randPPolicy_PromptBox = new KDBizPromptBox();
        kdtAwardsEntry_randPPolicy_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.RandPPolicyQuery");
        kdtAwardsEntry_randPPolicy_PromptBox.setVisible(true);
        kdtAwardsEntry_randPPolicy_PromptBox.setEditable(true);
        kdtAwardsEntry_randPPolicy_PromptBox.setDisplayFormat("$number$");
        kdtAwardsEntry_randPPolicy_PromptBox.setEditFormat("$number$");
        kdtAwardsEntry_randPPolicy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAwardsEntry_randPPolicy_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_randPPolicy_PromptBox);
        this.kdtAwardsEntry.getColumn("randPPolicy").setEditor(kdtAwardsEntry_randPPolicy_CellEditor);
        ObjectValueRender kdtAwardsEntry_randPPolicy_OVR = new ObjectValueRender();
        kdtAwardsEntry_randPPolicy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAwardsEntry.getColumn("randPPolicy").setRenderer(kdtAwardsEntry_randPPolicy_OVR);
        			kdtAwardsEntry_randPPolicy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.RandPPolicyListUI kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI == null) {
					try {
						kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.RandPPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI));
					kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAwardsEntry_randPPolicy_PromptBox.setSelector(kdtAwardsEntry_randPPolicy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtAwardsEntry_randPPolicyName_TextField = new KDTextField();
        kdtAwardsEntry_randPPolicyName_TextField.setName("kdtAwardsEntry_randPPolicyName_TextField");
        kdtAwardsEntry_randPPolicyName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtAwardsEntry_randPPolicyName_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_randPPolicyName_TextField);
        this.kdtAwardsEntry.getColumn("randPPolicyName").setEditor(kdtAwardsEntry_randPPolicyName_CellEditor);
        // kdtSubsidyEntry
		String kdtSubsidyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"policy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"policyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{policy}</t:Cell><t:Cell>$Resource{policyName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSubsidyEntry.setFormatXml(resHelper.translateString("kdtSubsidyEntry",kdtSubsidyEntryStrXML));
        kdtSubsidyEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtSubsidyEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtSubsidyEntry.putBindContents("editData",new String[] {"seq","policy","policyName"});


        this.kdtSubsidyEntry.checkParsed();
        final KDBizPromptBox kdtSubsidyEntry_policy_PromptBox = new KDBizPromptBox();
        kdtSubsidyEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.SubsidyPolicyQuery");
        kdtSubsidyEntry_policy_PromptBox.setVisible(true);
        kdtSubsidyEntry_policy_PromptBox.setEditable(true);
        kdtSubsidyEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setEditFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSubsidyEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtSubsidyEntry_policy_PromptBox);
        this.kdtSubsidyEntry.getColumn("policy").setEditor(kdtSubsidyEntry_policy_CellEditor);
        ObjectValueRender kdtSubsidyEntry_policy_OVR = new ObjectValueRender();
        kdtSubsidyEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSubsidyEntry.getColumn("policy").setRenderer(kdtSubsidyEntry_policy_OVR);
        			EntityViewInfo evikdtSubsidyEntry_policy_PromptBox = new EntityViewInfo ();
		evikdtSubsidyEntry_policy_PromptBox.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		kdtSubsidyEntry_policy_PromptBox.setEntityViewInfo(evikdtSubsidyEntry_policy_PromptBox);
					
        			kdtSubsidyEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.SubsidyPolicyListUI kdtSubsidyEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSubsidyEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtSubsidyEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.SubsidyPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSubsidyEntry_policy_PromptBox_F7ListUI));
					kdtSubsidyEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSubsidyEntry_policy_PromptBox.setSelector(kdtSubsidyEntry_policy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtSubsidyEntry_policyName_TextField = new KDTextField();
        kdtSubsidyEntry_policyName_TextField.setName("kdtSubsidyEntry_policyName_TextField");
        kdtSubsidyEntry_policyName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtSubsidyEntry_policyName_CellEditor = new KDTDefaultCellEditor(kdtSubsidyEntry_policyName_TextField);
        this.kdtSubsidyEntry.getColumn("policyName").setEditor(kdtSubsidyEntry_policyName_CellEditor);
        // contdepositRate		
        this.contdepositRate.setBoundLabelText(resHelper.getString("contdepositRate.boundLabelText"));		
        this.contdepositRate.setBoundLabelLength(130);		
        this.contdepositRate.setBoundLabelUnderline(true);		
        this.contdepositRate.setVisible(false);
        // contprovisionType		
        this.contprovisionType.setBoundLabelText(resHelper.getString("contprovisionType.boundLabelText"));		
        this.contprovisionType.setBoundLabelLength(130);		
        this.contprovisionType.setBoundLabelUnderline(true);		
        this.contprovisionType.setVisible(false);
        // controadLossRate		
        this.controadLossRate.setBoundLabelText(resHelper.getString("controadLossRate.boundLabelText"));		
        this.controadLossRate.setBoundLabelLength(130);		
        this.controadLossRate.setBoundLabelUnderline(true);		
        this.controadLossRate.setVisible(true);
        // contminSingleDrug		
        this.contminSingleDrug.setBoundLabelText(resHelper.getString("contminSingleDrug.boundLabelText"));		
        this.contminSingleDrug.setBoundLabelLength(130);		
        this.contminSingleDrug.setBoundLabelUnderline(true);		
        this.contminSingleDrug.setVisible(false);
        // contstandardRecRate		
        this.contstandardRecRate.setBoundLabelText(resHelper.getString("contstandardRecRate.boundLabelText"));		
        this.contstandardRecRate.setBoundLabelLength(130);		
        this.contstandardRecRate.setBoundLabelUnderline(true);		
        this.contstandardRecRate.setVisible(false);
        // contfmRatePunishStd		
        this.contfmRatePunishStd.setBoundLabelText(resHelper.getString("contfmRatePunishStd.boundLabelText"));		
        this.contfmRatePunishStd.setBoundLabelLength(130);		
        this.contfmRatePunishStd.setBoundLabelUnderline(true);		
        this.contfmRatePunishStd.setVisible(true);
        // contfreightSubsidiesStd		
        this.contfreightSubsidiesStd.setBoundLabelText(resHelper.getString("contfreightSubsidiesStd.boundLabelText"));		
        this.contfreightSubsidiesStd.setBoundLabelLength(130);		
        this.contfreightSubsidiesStd.setBoundLabelUnderline(true);		
        this.contfreightSubsidiesStd.setVisible(false);
        // contimmuneCost		
        this.contimmuneCost.setBoundLabelText(resHelper.getString("contimmuneCost.boundLabelText"));		
        this.contimmuneCost.setBoundLabelLength(120);		
        this.contimmuneCost.setBoundLabelUnderline(true);		
        this.contimmuneCost.setVisible(true);
        // contUnEnoungh		
        this.contUnEnoungh.setBoundLabelText(resHelper.getString("contUnEnoungh.boundLabelText"));		
        this.contUnEnoungh.setBoundLabelLength(120);		
        this.contUnEnoungh.setBoundLabelUnderline(true);		
        this.contUnEnoungh.setVisible(true);
        // contmaxSingleDrug		
        this.contmaxSingleDrug.setBoundLabelText(resHelper.getString("contmaxSingleDrug.boundLabelText"));		
        this.contmaxSingleDrug.setBoundLabelLength(130);		
        this.contmaxSingleDrug.setBoundLabelUnderline(true);		
        this.contmaxSingleDrug.setVisible(false);
        // contimmuneTost		
        this.contimmuneTost.setBoundLabelText(resHelper.getString("contimmuneTost.boundLabelText"));		
        this.contimmuneTost.setBoundLabelLength(100);		
        this.contimmuneTost.setBoundLabelUnderline(true);		
        this.contimmuneTost.setVisible(false);
        // contcleanHouse		
        this.contcleanHouse.setBoundLabelText(resHelper.getString("contcleanHouse.boundLabelText"));		
        this.contcleanHouse.setBoundLabelLength(130);		
        this.contcleanHouse.setBoundLabelUnderline(true);		
        this.contcleanHouse.setVisible(false);
        // contreserveRiskOne		
        this.contreserveRiskOne.setBoundLabelText(resHelper.getString("contreserveRiskOne.boundLabelText"));		
        this.contreserveRiskOne.setBoundLabelLength(120);		
        this.contreserveRiskOne.setBoundLabelUnderline(true);		
        this.contreserveRiskOne.setVisible(false);
        // contreserveCheck		
        this.contreserveCheck.setBoundLabelText(resHelper.getString("contreserveCheck.boundLabelText"));		
        this.contreserveCheck.setBoundLabelLength(100);		
        this.contreserveCheck.setBoundLabelUnderline(true);		
        this.contreserveCheck.setVisible(false);
        // txtdepositRate		
        this.txtdepositRate.setHorizontalAlignment(2);		
        this.txtdepositRate.setDataType(1);		
        this.txtdepositRate.setSupportedEmpty(true);		
        this.txtdepositRate.setMinimumValue( new java.math.BigDecimal("-999999.9999"));		
        this.txtdepositRate.setMaximumValue( new java.math.BigDecimal("999999.9999"));		
        this.txtdepositRate.setPrecision(4);		
        this.txtdepositRate.setRequired(false);		
        this.txtdepositRate.setVisible(false);
        // provisionType		
        this.provisionType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum").toArray());		
        this.provisionType.setRequired(false);		
        this.provisionType.setVisible(false);
        // txtroadLossRate		
        this.txtroadLossRate.setHorizontalAlignment(2);		
        this.txtroadLossRate.setDataType(1);		
        this.txtroadLossRate.setSupportedEmpty(true);		
        this.txtroadLossRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtroadLossRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtroadLossRate.setPrecision(4);		
        this.txtroadLossRate.setRequired(false);
        // txtminSingleDrug		
        this.txtminSingleDrug.setHorizontalAlignment(2);		
        this.txtminSingleDrug.setDataType(1);		
        this.txtminSingleDrug.setSupportedEmpty(true);		
        this.txtminSingleDrug.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtminSingleDrug.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtminSingleDrug.setPrecision(2);		
        this.txtminSingleDrug.setRequired(false);		
        this.txtminSingleDrug.setVisible(false);
        // txtstandardRecRate		
        this.txtstandardRecRate.setHorizontalAlignment(2);		
        this.txtstandardRecRate.setDataType(1);		
        this.txtstandardRecRate.setSupportedEmpty(true);		
        this.txtstandardRecRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtstandardRecRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtstandardRecRate.setPrecision(4);		
        this.txtstandardRecRate.setRequired(false);		
        this.txtstandardRecRate.setVisible(false);
        // txtfmRatePunishStd		
        this.txtfmRatePunishStd.setHorizontalAlignment(2);		
        this.txtfmRatePunishStd.setDataType(1);		
        this.txtfmRatePunishStd.setSupportedEmpty(true);		
        this.txtfmRatePunishStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfmRatePunishStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfmRatePunishStd.setPrecision(2);		
        this.txtfmRatePunishStd.setRequired(false);
        // txtfreightSubsidiesStd		
        this.txtfreightSubsidiesStd.setHorizontalAlignment(2);		
        this.txtfreightSubsidiesStd.setDataType(1);		
        this.txtfreightSubsidiesStd.setSupportedEmpty(true);		
        this.txtfreightSubsidiesStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfreightSubsidiesStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfreightSubsidiesStd.setPrecision(2);		
        this.txtfreightSubsidiesStd.setRequired(false);		
        this.txtfreightSubsidiesStd.setVisible(false);
        // txtimmuneCost		
        this.txtimmuneCost.setVisible(true);		
        this.txtimmuneCost.setHorizontalAlignment(2);		
        this.txtimmuneCost.setDataType(1);		
        this.txtimmuneCost.setSupportedEmpty(true);		
        this.txtimmuneCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmuneCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmuneCost.setPrecision(10);		
        this.txtimmuneCost.setRequired(false);
        // txtUnEnoungh		
        this.txtUnEnoungh.setVisible(true);		
        this.txtUnEnoungh.setHorizontalAlignment(2);		
        this.txtUnEnoungh.setDataType(1);		
        this.txtUnEnoungh.setSupportedEmpty(true);		
        this.txtUnEnoungh.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtUnEnoungh.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtUnEnoungh.setPrecision(10);		
        this.txtUnEnoungh.setRequired(false);
        // txtmaxSingleDrug		
        this.txtmaxSingleDrug.setVisible(false);		
        this.txtmaxSingleDrug.setHorizontalAlignment(2);		
        this.txtmaxSingleDrug.setDataType(1);		
        this.txtmaxSingleDrug.setSupportedEmpty(true);		
        this.txtmaxSingleDrug.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmaxSingleDrug.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmaxSingleDrug.setPrecision(10);		
        this.txtmaxSingleDrug.setRequired(false);
        // txtimmuneTost		
        this.txtimmuneTost.setVisible(false);		
        this.txtimmuneTost.setHorizontalAlignment(2);		
        this.txtimmuneTost.setDataType(1);		
        this.txtimmuneTost.setSupportedEmpty(true);		
        this.txtimmuneTost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtimmuneTost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtimmuneTost.setPrecision(10);		
        this.txtimmuneTost.setRequired(false);
        // txtcleanHouse		
        this.txtcleanHouse.setVisible(false);		
        this.txtcleanHouse.setHorizontalAlignment(2);		
        this.txtcleanHouse.setDataType(1);		
        this.txtcleanHouse.setSupportedEmpty(true);		
        this.txtcleanHouse.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcleanHouse.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcleanHouse.setPrecision(10);		
        this.txtcleanHouse.setRequired(false);
        // txtreserveRiskOne		
        this.txtreserveRiskOne.setVisible(false);		
        this.txtreserveRiskOne.setHorizontalAlignment(2);		
        this.txtreserveRiskOne.setDataType(1);		
        this.txtreserveRiskOne.setSupportedEmpty(true);		
        this.txtreserveRiskOne.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreserveRiskOne.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreserveRiskOne.setPrecision(10);		
        this.txtreserveRiskOne.setRequired(false);
        // txtreserveCheck		
        this.txtreserveCheck.setVisible(false);		
        this.txtreserveCheck.setHorizontalAlignment(2);		
        this.txtreserveCheck.setDataType(1);		
        this.txtreserveCheck.setSupportedEmpty(true);		
        this.txtreserveCheck.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtreserveCheck.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtreserveCheck.setPrecision(10);		
        this.txtreserveCheck.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtauditor		
        this.prmtauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditor.setEditable(true);		
        this.prmtauditor.setDisplayFormat("$number$");		
        this.prmtauditor.setEditFormat("$number$");		
        this.prmtauditor.setCommitFormat("$number$");		
        this.prmtauditor.setRequired(false);		
        this.prmtauditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // prmtcreator		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);
        // pkcreateTime		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // pkbeginDate		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(true);
        // txtoutDaysStd		
        this.txtoutDaysStd.setHorizontalAlignment(2);		
        this.txtoutDaysStd.setDataType(0);		
        this.txtoutDaysStd.setSupportedEmpty(true);		
        this.txtoutDaysStd.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,prmtcreator,pkcreateTime,baseStatus,prmtauditor,pkauditTime,prmtcompany,chkisTemplate,prmtbreedData,pkbeginDate,pkendDate,txtdepositRate,provisionType,txtoutDaysStd,txtroadLossRate,txtminSingleDrug,txtstandardRecRate,txtfmRatePunishStd,txtfreightSubsidiesStd,chkisForbidUnSettle,kdtRecycleEntry,kdtPriceEntry,kdtAwardsEntry,kdtSubsidyEntry,txtimmuneCost,txtUnEnoungh,txtmaxSingleDrug,txtimmuneTost,txtcleanHouse,txtreserveRiskOne,txtreserveCheck,chkisProDiv}));
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
        kDLabelContainer1.setBounds(new Rectangle(38, 15, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(38, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(367, 15, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(367, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(20, 149, 970, 379));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 149, 970, 379, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(701, 15, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(701, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(38, 556, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(38, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(38, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(38, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator5.setBounds(new Rectangle(16, 538, 984, 8));
        this.add(kDSeparator5, new KDLayout.Constraints(16, 538, 984, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcreator.setBounds(new Rectangle(368, 557, 270, 19));
        this.add(contcreator, new KDLayout.Constraints(368, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcreateTime.setBounds(new Rectangle(706, 556, 270, 19));
        this.add(contcreateTime, new KDLayout.Constraints(706, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(38, 46, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(38, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator6.setBounds(new Rectangle(19, 136, 969, 10));
        this.add(kDSeparator6, new KDLayout.Constraints(19, 136, 969, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(986, 44, 213, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(986, 44, 213, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(367, 46, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(367, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(38, 82, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(38, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(367, 82, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(367, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contoutDaysStd.setBounds(new Rectangle(701, 46, 270, 19));
        this.add(contoutDaysStd, new KDLayout.Constraints(701, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisForbidUnSettle.setBounds(new Rectangle(701, 82, 212, 19));
        this.add(chkisForbidUnSettle, new KDLayout.Constraints(701, 82, 212, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisProDiv.setBounds(new Rectangle(38, 107, 270, 19));
        this.add(chkisProDiv, new KDLayout.Constraints(38, 107, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 346));        kdtPriceEntry.setBounds(new Rectangle(5, 6, 957, 334));
        kdtPriceEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPriceEntry,new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo(),null,false);
        kDPanel1.add(kdtPriceEntry_detailPanel, new KDLayout.Constraints(5, 6, 957, 334, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtPriceEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("settleItemType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 346));        kdtRecycleEntry.setBounds(new Rectangle(5, 4, 956, 360));
        kdtRecycleEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRecycleEntry,new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryInfo(),null,false);
        kDPanel2.add(kdtRecycleEntry_detailPanel, new KDLayout.Constraints(5, 4, 956, 360, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
		kdtRecycleEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("recType","1");
vo.put("minSymbol",">");
vo.put("maxSymbol","<");
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 346));        kdtAwardsEntry.setBounds(new Rectangle(0, 2, 491, 360));
        kdtAwardsEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAwardsEntry,new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryInfo(),null,false);
        kDPanel3.add(kdtAwardsEntry_detailPanel, new KDLayout.Constraints(0, 2, 491, 360, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtSubsidyEntry.setBounds(new Rectangle(500, 4, 457, 354));
        kdtSubsidyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSubsidyEntry,new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryInfo(),null,false);
        kDPanel3.add(kdtSubsidyEntry_detailPanel, new KDLayout.Constraints(500, 4, 457, 354, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 346));        contdepositRate.setBounds(new Rectangle(19, 247, 270, 19));
        kDPanel4.add(contdepositRate, new KDLayout.Constraints(19, 247, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprovisionType.setBounds(new Rectangle(19, 261, 270, 19));
        kDPanel4.add(contprovisionType, new KDLayout.Constraints(19, 261, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        controadLossRate.setBounds(new Rectangle(13, 11, 270, 19));
        kDPanel4.add(controadLossRate, new KDLayout.Constraints(13, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contminSingleDrug.setBounds(new Rectangle(7, 184, 270, 19));
        kDPanel4.add(contminSingleDrug, new KDLayout.Constraints(7, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contstandardRecRate.setBounds(new Rectangle(22, 285, 270, 19));
        kDPanel4.add(contstandardRecRate, new KDLayout.Constraints(22, 285, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfmRatePunishStd.setBounds(new Rectangle(313, 11, 270, 19));
        kDPanel4.add(contfmRatePunishStd, new KDLayout.Constraints(313, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfreightSubsidiesStd.setBounds(new Rectangle(22, 302, 270, 19));
        kDPanel4.add(contfreightSubsidiesStd, new KDLayout.Constraints(22, 302, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contimmuneCost.setBounds(new Rectangle(313, 45, 270, 19));
        kDPanel4.add(contimmuneCost, new KDLayout.Constraints(313, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contUnEnoungh.setBounds(new Rectangle(618, 11, 270, 19));
        kDPanel4.add(contUnEnoungh, new KDLayout.Constraints(618, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmaxSingleDrug.setBounds(new Rectangle(21, 206, 270, 19));
        kDPanel4.add(contmaxSingleDrug, new KDLayout.Constraints(21, 206, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contimmuneTost.setBounds(new Rectangle(16, 229, 270, 19));
        kDPanel4.add(contimmuneTost, new KDLayout.Constraints(16, 229, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcleanHouse.setBounds(new Rectangle(13, 45, 270, 19));
        kDPanel4.add(contcleanHouse, new KDLayout.Constraints(13, 45, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreserveRiskOne.setBounds(new Rectangle(10, 173, 270, 19));
        kDPanel4.add(contreserveRiskOne, new KDLayout.Constraints(10, 173, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contreserveCheck.setBounds(new Rectangle(17, 159, 270, 19));
        kDPanel4.add(contreserveCheck, new KDLayout.Constraints(17, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contdepositRate
        contdepositRate.setBoundEditor(txtdepositRate);
        //contprovisionType
        contprovisionType.setBoundEditor(provisionType);
        //controadLossRate
        controadLossRate.setBoundEditor(txtroadLossRate);
        //contminSingleDrug
        contminSingleDrug.setBoundEditor(txtminSingleDrug);
        //contstandardRecRate
        contstandardRecRate.setBoundEditor(txtstandardRecRate);
        //contfmRatePunishStd
        contfmRatePunishStd.setBoundEditor(txtfmRatePunishStd);
        //contfreightSubsidiesStd
        contfreightSubsidiesStd.setBoundEditor(txtfreightSubsidiesStd);
        //contimmuneCost
        contimmuneCost.setBoundEditor(txtimmuneCost);
        //contUnEnoungh
        contUnEnoungh.setBoundEditor(txtUnEnoungh);
        //contmaxSingleDrug
        contmaxSingleDrug.setBoundEditor(txtmaxSingleDrug);
        //contimmuneTost
        contimmuneTost.setBoundEditor(txtimmuneTost);
        //contcleanHouse
        contcleanHouse.setBoundEditor(txtcleanHouse);
        //contreserveRiskOne
        contreserveRiskOne.setBoundEditor(txtreserveRiskOne);
        //contreserveCheck
        contreserveCheck.setBoundEditor(txtreserveCheck);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contoutDaysStd
        contoutDaysStd.setBoundEditor(txtoutDaysStd);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("isTemplate", boolean.class, this.chkisTemplate, "selected");
		dataBinder.registerBinding("isForbidUnSettle", boolean.class, this.chkisForbidUnSettle, "selected");
		dataBinder.registerBinding("isProDiv", boolean.class, this.chkisProDiv, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("PriceEntry.seq", int.class, this.kdtPriceEntry, "seq.text");
		dataBinder.registerBinding("PriceEntry", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo.class, this.kdtPriceEntry, "userObject");
		dataBinder.registerBinding("PriceEntry.material", java.lang.Object.class, this.kdtPriceEntry, "material.text");
		dataBinder.registerBinding("PriceEntry.materialName", String.class, this.kdtPriceEntry, "materialName.text");
		dataBinder.registerBinding("PriceEntry.model", String.class, this.kdtPriceEntry, "model.text");
		dataBinder.registerBinding("PriceEntry.basePrice", java.math.BigDecimal.class, this.kdtPriceEntry, "basePrice.text");
		dataBinder.registerBinding("PriceEntry.settlementItem", java.lang.Object.class, this.kdtPriceEntry, "settlementItem.text");
		dataBinder.registerBinding("PriceEntry.unit", java.lang.Object.class, this.kdtPriceEntry, "unit.text");
		dataBinder.registerBinding("PriceEntry.settleItemType", com.kingdee.util.enums.Enum.class, this.kdtPriceEntry, "settleItemType.text");
		dataBinder.registerBinding("PriceEntry.overRate", java.math.BigDecimal.class, this.kdtPriceEntry, "overRate.text");
		dataBinder.registerBinding("RecycleEntry.seq", int.class, this.kdtRecycleEntry, "seq.text");
		dataBinder.registerBinding("RecycleEntry", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryInfo.class, this.kdtRecycleEntry, "userObject");
		dataBinder.registerBinding("RecycleEntry.material", java.lang.Object.class, this.kdtRecycleEntry, "material.text");
		dataBinder.registerBinding("RecycleEntry.materialName", String.class, this.kdtRecycleEntry, "materialName.text");
		dataBinder.registerBinding("RecycleEntry.model", String.class, this.kdtRecycleEntry, "model.text");
		dataBinder.registerBinding("RecycleEntry.basePrice", java.math.BigDecimal.class, this.kdtRecycleEntry, "basePrice.text");
		dataBinder.registerBinding("RecycleEntry.settlementItem", java.lang.Object.class, this.kdtRecycleEntry, "settlementItem.text");
		dataBinder.registerBinding("RecycleEntry.unit", java.lang.Object.class, this.kdtRecycleEntry, "unit.text");
		dataBinder.registerBinding("RecycleEntry.minValue", java.math.BigDecimal.class, this.kdtRecycleEntry, "minValue.text");
		dataBinder.registerBinding("RecycleEntry.maxSymbol", com.kingdee.util.enums.Enum.class, this.kdtRecycleEntry, "maxSymbol.text");
		dataBinder.registerBinding("RecycleEntry.maxValue", java.math.BigDecimal.class, this.kdtRecycleEntry, "maxValue.text");
		dataBinder.registerBinding("RecycleEntry.fmRate", java.math.BigDecimal.class, this.kdtRecycleEntry, "fmRate.text");
		dataBinder.registerBinding("RecycleEntry.minSymbol", com.kingdee.util.enums.Enum.class, this.kdtRecycleEntry, "minSymbol.text");
		dataBinder.registerBinding("RecycleEntry.isUseAcualPrice", boolean.class, this.kdtRecycleEntry, "isUseAcualPrice.text");
		dataBinder.registerBinding("RecycleEntry.recType", com.kingdee.util.enums.Enum.class, this.kdtRecycleEntry, "recType.text");
		dataBinder.registerBinding("AwardsEntry.seq", int.class, this.kdtAwardsEntry, "seq.text");
		dataBinder.registerBinding("AwardsEntry", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryInfo.class, this.kdtAwardsEntry, "userObject");
		dataBinder.registerBinding("AwardsEntry.policy", java.lang.Object.class, this.kdtAwardsEntry, "policy.text");
		dataBinder.registerBinding("AwardsEntry.policyName", String.class, this.kdtAwardsEntry, "policyName.text");
		dataBinder.registerBinding("AwardsEntry.randPPolicy", java.lang.Object.class, this.kdtAwardsEntry, "randPPolicy.text");
		dataBinder.registerBinding("AwardsEntry.randPPolicyName", String.class, this.kdtAwardsEntry, "randPPolicyName.text");
		dataBinder.registerBinding("SubsidyEntry.seq", int.class, this.kdtSubsidyEntry, "seq.text");
		dataBinder.registerBinding("SubsidyEntry", com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryInfo.class, this.kdtSubsidyEntry, "userObject");
		dataBinder.registerBinding("SubsidyEntry.policy", java.lang.Object.class, this.kdtSubsidyEntry, "policy.text");
		dataBinder.registerBinding("SubsidyEntry.policyName", String.class, this.kdtSubsidyEntry, "policyName.text");
		dataBinder.registerBinding("depositRate", java.math.BigDecimal.class, this.txtdepositRate, "value");
		dataBinder.registerBinding("provisionType", com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum.class, this.provisionType, "selectedItem");
		dataBinder.registerBinding("roadLossRate", java.math.BigDecimal.class, this.txtroadLossRate, "value");
		dataBinder.registerBinding("minSingleDrug", java.math.BigDecimal.class, this.txtminSingleDrug, "value");
		dataBinder.registerBinding("standardRecRate", java.math.BigDecimal.class, this.txtstandardRecRate, "value");
		dataBinder.registerBinding("fmRatePunishStd", java.math.BigDecimal.class, this.txtfmRatePunishStd, "value");
		dataBinder.registerBinding("freightSubsidiesStd", java.math.BigDecimal.class, this.txtfreightSubsidiesStd, "value");
		dataBinder.registerBinding("immuneCost", java.math.BigDecimal.class, this.txtimmuneCost, "value");
		dataBinder.registerBinding("UnEnoungh", java.math.BigDecimal.class, this.txtUnEnoungh, "value");
		dataBinder.registerBinding("maxSingleDrug", java.math.BigDecimal.class, this.txtmaxSingleDrug, "value");
		dataBinder.registerBinding("immuneTost", java.math.BigDecimal.class, this.txtimmuneTost, "value");
		dataBinder.registerBinding("cleanHouse", java.math.BigDecimal.class, this.txtcleanHouse, "value");
		dataBinder.registerBinding("reserveRiskOne", java.math.BigDecimal.class, this.txtreserveRiskOne, "value");
		dataBinder.registerBinding("reserveCheck", java.math.BigDecimal.class, this.txtreserveCheck, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("outDaysStd", int.class, this.txtoutDaysStd, "value");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.SettlePolicyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("isTemplate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isForbidUnSettle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isProDiv", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.settleItemType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.overRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.minValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.maxSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.maxValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.fmRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.minSymbol", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.isUseAcualPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.recType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.policyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.randPPolicy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.randPPolicyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.policyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("depositRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("provisionType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("roadLossRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("minSingleDrug", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("standardRecRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fmRatePunishStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("freightSubsidiesStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("UnEnoungh", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maxSingleDrug", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneTost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cleanHouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reserveRiskOne", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reserveCheck", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("outDaysStd", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtNumber.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtNumber.setEnabled(false);
        }
    }

    /**
     * output kdtPriceEntry_tableClicked method
     */
    protected void kdtPriceEntry_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }


    /**
     * output kdtPriceEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPriceEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

}

    if ("settlementItem".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"settlementItem").getValue(),"settleUnit"));

}

    if ("settlementItem".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"settleItemType").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"settlementItem").getValue(),"settleItemType"));

}


    }

    /**
     * output kdtRecycleEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtRecycleEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

}

    if ("settlementItem".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"settlementItem").getValue(),"settleUnit"));

}


    }

    /**
     * output kdtAwardsEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAwardsEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("randPPolicy".equalsIgnoreCase(kdtAwardsEntry.getColumn(colIndex).getKey())) {
kdtAwardsEntry.getCell(rowIndex,"randPPolicyName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAwardsEntry.getCell(rowIndex,"randPPolicy").getValue(),"name")));

}


    }

    /**
     * output kdtSubsidyEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtSubsidyEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("policy".equalsIgnoreCase(kdtSubsidyEntry.getColumn(colIndex).getKey())) {
kdtSubsidyEntry.getCell(rowIndex,"policyName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtSubsidyEntry.getCell(rowIndex,"policy").getValue(),"name")));

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
        sic.add(new SelectorItemInfo("isTemplate"));
        sic.add(new SelectorItemInfo("isForbidUnSettle"));
        sic.add(new SelectorItemInfo("isProDiv"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
    	sic.add(new SelectorItemInfo("PriceEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.material.id"));
			sic.add(new SelectorItemInfo("PriceEntry.material.number"));
			sic.add(new SelectorItemInfo("PriceEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("PriceEntry.materialName"));
    	sic.add(new SelectorItemInfo("PriceEntry.model"));
    	sic.add(new SelectorItemInfo("PriceEntry.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.settlementItem.id"));
			sic.add(new SelectorItemInfo("PriceEntry.settlementItem.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.settlementItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.unit.id"));
			sic.add(new SelectorItemInfo("PriceEntry.unit.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("PriceEntry.settleItemType"));
    	sic.add(new SelectorItemInfo("PriceEntry.overRate"));
    	sic.add(new SelectorItemInfo("RecycleEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.material.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.material.number"));
			sic.add(new SelectorItemInfo("RecycleEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("RecycleEntry.materialName"));
    	sic.add(new SelectorItemInfo("RecycleEntry.model"));
    	sic.add(new SelectorItemInfo("RecycleEntry.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.name"));
        	sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.unit.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.unit.name"));
        	sic.add(new SelectorItemInfo("RecycleEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("RecycleEntry.minValue"));
    	sic.add(new SelectorItemInfo("RecycleEntry.maxSymbol"));
    	sic.add(new SelectorItemInfo("RecycleEntry.maxValue"));
    	sic.add(new SelectorItemInfo("RecycleEntry.fmRate"));
    	sic.add(new SelectorItemInfo("RecycleEntry.minSymbol"));
    	sic.add(new SelectorItemInfo("RecycleEntry.isUseAcualPrice"));
    	sic.add(new SelectorItemInfo("RecycleEntry.recType"));
    	sic.add(new SelectorItemInfo("AwardsEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardsEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardsEntry.policy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AwardsEntry.policy.id"));
			sic.add(new SelectorItemInfo("AwardsEntry.policy.number"));
			sic.add(new SelectorItemInfo("AwardsEntry.policy.name"));
		}
    	sic.add(new SelectorItemInfo("AwardsEntry.policyName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardsEntry.randPPolicy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AwardsEntry.randPPolicy.id"));
			sic.add(new SelectorItemInfo("AwardsEntry.randPPolicy.number"));
			sic.add(new SelectorItemInfo("AwardsEntry.randPPolicy.name"));
		}
    	sic.add(new SelectorItemInfo("AwardsEntry.randPPolicyName"));
    	sic.add(new SelectorItemInfo("SubsidyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SubsidyEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SubsidyEntry.policy.id"));
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.number"));
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.name"));
		}
    	sic.add(new SelectorItemInfo("SubsidyEntry.policyName"));
        sic.add(new SelectorItemInfo("depositRate"));
        sic.add(new SelectorItemInfo("provisionType"));
        sic.add(new SelectorItemInfo("roadLossRate"));
        sic.add(new SelectorItemInfo("minSingleDrug"));
        sic.add(new SelectorItemInfo("standardRecRate"));
        sic.add(new SelectorItemInfo("fmRatePunishStd"));
        sic.add(new SelectorItemInfo("freightSubsidiesStd"));
        sic.add(new SelectorItemInfo("immuneCost"));
        sic.add(new SelectorItemInfo("UnEnoungh"));
        sic.add(new SelectorItemInfo("maxSingleDrug"));
        sic.add(new SelectorItemInfo("immuneTost"));
        sic.add(new SelectorItemInfo("cleanHouse"));
        sic.add(new SelectorItemInfo("reserveRiskOne"));
        sic.add(new SelectorItemInfo("reserveCheck"));
        sic.add(new SelectorItemInfo("baseStatus"));
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
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("outDaysStd"));
        return sic;
    }        
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionMulUpdate_actionPerformed method
     */
    public void actionMulUpdate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance().mulUpdate(editData);
    }
	public RequestContext prepareActionIsTemplate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionIsTemplate() {
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
	public RequestContext prepareActionMulUpdate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionMulUpdate() {
    	return false;
    }

    /**
     * output ActionIsTemplate class
     */     
    protected class ActionIsTemplate extends ItemAction {     
    
        public ActionIsTemplate()
        {
            this(null);
        }

        public ActionIsTemplate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionIsTemplate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettlePolicyEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettlePolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettlePolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionMulUpdate class
     */     
    protected class ActionMulUpdate extends ItemAction {     
    
        public ActionMulUpdate()
        {
            this(null);
        }

        public ActionMulUpdate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionMulUpdate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMulUpdate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionMulUpdate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractSettlePolicyEditUI.this, "ActionMulUpdate", "actionMulUpdate_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "SettlePolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.SettlePolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"settlementItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算项目"});
			}
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"basePrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"基础价格"});
			}
		}
		for (int i=0,n=kdtRecycleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtRecycleEntry.getCell(i,"minSymbol").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"下限比较符"});
			}
		}
		for (int i=0,n=kdtRecycleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtRecycleEntry.getCell(i,"maxSymbol").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"上限比较符"});
			}
		}
		for (int i=0,n=kdtRecycleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtRecycleEntry.getCell(i,"basePrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"回收单价(元/公斤)"});
			}
		}
		for (int i=0,n=kdtAwardsEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtAwardsEntry.getCell(i,"randPPolicy").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"奖惩政策编码"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkendDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPriceEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("provisionType",new Integer(1));
vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}