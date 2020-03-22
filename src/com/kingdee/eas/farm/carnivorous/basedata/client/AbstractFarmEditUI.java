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
public abstract class AbstractFarmEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contarea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuccahQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfloorArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHouseManager;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmileStd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contrecyMiles;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmnemonicCode;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllot;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfaemsType;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitSettleBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalSettleBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettledBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbunker;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbunkerBuildDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarginAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contborrowAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttransPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtarea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuccahQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfloorArea;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtwarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox farmType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmileStd;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtrecyMiles;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmnemonicCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtgm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox faemsType;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtHouseEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtHouseEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitSettleBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalSettleBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettledBatchNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox bunker;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbunkerBuildDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarginAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtborrowAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttransPrice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.FarmInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFarmEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmEditUI.class.getName());
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
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contarea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuccahQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfloorArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisHouseManager = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contwarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmileStd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contrecyMiles = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmnemonicCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAllot = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contgm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfaemsType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.continitSettleBatchNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalSettleBatchNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettledBatchNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbunker = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbunkerBuildDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarginAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contborrowAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttransPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtarea = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtsuccahQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfloorArea = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtwarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtstorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.farmType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtmileStd = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtrecyMiles = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmnemonicCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtgm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.faemsType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtHouseEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtinitSettleBatchNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalSettleBatchNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettledBatchNum = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.bunker = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkbunkerBuildDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtmarginAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtborrowAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttransPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contaddress.setName("contaddress");
        this.contarea.setName("contarea");
        this.contbaseStatus.setName("contbaseStatus");
        this.contsuccahQty.setName("contsuccahQty");
        this.contcompany.setName("contcompany");
        this.contfloorArea.setName("contfloorArea");
        this.contcostCenter.setName("contcostCenter");
        this.chkisHouseManager.setName("chkisHouseManager");
        this.contwarehouse.setName("contwarehouse");
        this.contstorageOrgUnit.setName("contstorageOrgUnit");
        this.contfarmType.setName("contfarmType");
        this.contfarmer.setName("contfarmer");
        this.contmileStd.setName("contmileStd");
        this.contrecyMiles.setName("contrecyMiles");
        this.contmnemonicCode.setName("contmnemonicCode");
        this.chkisAllot.setName("chkisAllot");
        this.contgm.setName("contgm");
        this.contfaemsType.setName("contfaemsType");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.continitSettleBatchNum.setName("continitSettleBatchNum");
        this.conttotalSettleBatchNum.setName("conttotalSettleBatchNum");
        this.contsettledBatchNum.setName("contsettledBatchNum");
        this.contbunker.setName("contbunker");
        this.contbunkerBuildDate.setName("contbunkerBuildDate");
        this.contmarginAmt.setName("contmarginAmt");
        this.contborrowAmt.setName("contborrowAmt");
        this.conttransPrice.setName("conttransPrice");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txtaddress.setName("txtaddress");
        this.txtarea.setName("txtarea");
        this.baseStatus.setName("baseStatus");
        this.txtsuccahQty.setName("txtsuccahQty");
        this.prmtcompany.setName("prmtcompany");
        this.txtfloorArea.setName("txtfloorArea");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtwarehouse.setName("prmtwarehouse");
        this.prmtstorageOrgUnit.setName("prmtstorageOrgUnit");
        this.farmType.setName("farmType");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtmileStd.setName("txtmileStd");
        this.txtrecyMiles.setName("txtrecyMiles");
        this.txtmnemonicCode.setName("txtmnemonicCode");
        this.txtgm.setName("txtgm");
        this.faemsType.setName("faemsType");
        this.kDPanel1.setName("kDPanel1");
        this.kdtHouseEntry.setName("kdtHouseEntry");
        this.txtinitSettleBatchNum.setName("txtinitSettleBatchNum");
        this.txttotalSettleBatchNum.setName("txttotalSettleBatchNum");
        this.txtsettledBatchNum.setName("txtsettledBatchNum");
        this.bunker.setName("bunker");
        this.pkbunkerBuildDate.setName("pkbunkerBuildDate");
        this.txtmarginAmt.setName("txtmarginAmt");
        this.txtborrowAmt.setName("txtborrowAmt");
        this.txttransPrice.setName("txttransPrice");
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
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contarea		
        this.contarea.setBoundLabelText(resHelper.getString("contarea.boundLabelText"));		
        this.contarea.setBoundLabelLength(80);		
        this.contarea.setBoundLabelUnderline(true);		
        this.contarea.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contsuccahQty		
        this.contsuccahQty.setBoundLabelText(resHelper.getString("contsuccahQty.boundLabelText"));		
        this.contsuccahQty.setBoundLabelLength(100);		
        this.contsuccahQty.setBoundLabelUnderline(true);		
        this.contsuccahQty.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contfloorArea		
        this.contfloorArea.setBoundLabelText(resHelper.getString("contfloorArea.boundLabelText"));		
        this.contfloorArea.setBoundLabelLength(80);		
        this.contfloorArea.setBoundLabelUnderline(true);		
        this.contfloorArea.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // chkisHouseManager		
        this.chkisHouseManager.setText(resHelper.getString("chkisHouseManager.text"));		
        this.chkisHouseManager.setHorizontalAlignment(2);
        // contwarehouse		
        this.contwarehouse.setBoundLabelText(resHelper.getString("contwarehouse.boundLabelText"));		
        this.contwarehouse.setBoundLabelLength(100);		
        this.contwarehouse.setBoundLabelUnderline(true);		
        this.contwarehouse.setVisible(true);
        // contstorageOrgUnit		
        this.contstorageOrgUnit.setBoundLabelText(resHelper.getString("contstorageOrgUnit.boundLabelText"));		
        this.contstorageOrgUnit.setBoundLabelLength(100);		
        this.contstorageOrgUnit.setBoundLabelUnderline(true);		
        this.contstorageOrgUnit.setVisible(true);
        // contfarmType		
        this.contfarmType.setBoundLabelText(resHelper.getString("contfarmType.boundLabelText"));		
        this.contfarmType.setBoundLabelLength(100);		
        this.contfarmType.setBoundLabelUnderline(true);		
        this.contfarmType.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(false);
        // contmileStd		
        this.contmileStd.setBoundLabelText(resHelper.getString("contmileStd.boundLabelText"));		
        this.contmileStd.setBoundLabelLength(100);		
        this.contmileStd.setBoundLabelUnderline(true);		
        this.contmileStd.setVisible(true);
        // contrecyMiles		
        this.contrecyMiles.setBoundLabelText(resHelper.getString("contrecyMiles.boundLabelText"));		
        this.contrecyMiles.setBoundLabelLength(100);		
        this.contrecyMiles.setBoundLabelUnderline(true);		
        this.contrecyMiles.setVisible(true);
        // contmnemonicCode		
        this.contmnemonicCode.setBoundLabelText(resHelper.getString("contmnemonicCode.boundLabelText"));		
        this.contmnemonicCode.setBoundLabelLength(100);		
        this.contmnemonicCode.setBoundLabelUnderline(true);
        // chkisAllot		
        this.chkisAllot.setText(resHelper.getString("chkisAllot.text"));		
        this.chkisAllot.setVisible(true);		
        this.chkisAllot.setHorizontalAlignment(2);		
        this.chkisAllot.setEnabled(false);
        // contgm		
        this.contgm.setBoundLabelText(resHelper.getString("contgm.boundLabelText"));		
        this.contgm.setBoundLabelLength(100);		
        this.contgm.setBoundLabelUnderline(true);		
        this.contgm.setVisible(true);
        // contfaemsType		
        this.contfaemsType.setBoundLabelText(resHelper.getString("contfaemsType.boundLabelText"));		
        this.contfaemsType.setBoundLabelLength(100);		
        this.contfaemsType.setBoundLabelUnderline(true);		
        this.contfaemsType.setVisible(true);
        // kDTabbedPane1
        // continitSettleBatchNum		
        this.continitSettleBatchNum.setBoundLabelText(resHelper.getString("continitSettleBatchNum.boundLabelText"));		
        this.continitSettleBatchNum.setBoundLabelLength(100);		
        this.continitSettleBatchNum.setBoundLabelUnderline(true);		
        this.continitSettleBatchNum.setVisible(true);
        // conttotalSettleBatchNum		
        this.conttotalSettleBatchNum.setBoundLabelText(resHelper.getString("conttotalSettleBatchNum.boundLabelText"));		
        this.conttotalSettleBatchNum.setBoundLabelLength(100);		
        this.conttotalSettleBatchNum.setBoundLabelUnderline(true);		
        this.conttotalSettleBatchNum.setVisible(true);
        // contsettledBatchNum		
        this.contsettledBatchNum.setBoundLabelText(resHelper.getString("contsettledBatchNum.boundLabelText"));		
        this.contsettledBatchNum.setBoundLabelLength(100);		
        this.contsettledBatchNum.setBoundLabelUnderline(true);		
        this.contsettledBatchNum.setVisible(true);
        // contbunker		
        this.contbunker.setBoundLabelText(resHelper.getString("contbunker.boundLabelText"));		
        this.contbunker.setBoundLabelLength(100);		
        this.contbunker.setBoundLabelUnderline(true);		
        this.contbunker.setVisible(true);
        // contbunkerBuildDate		
        this.contbunkerBuildDate.setBoundLabelText(resHelper.getString("contbunkerBuildDate.boundLabelText"));		
        this.contbunkerBuildDate.setBoundLabelLength(100);		
        this.contbunkerBuildDate.setBoundLabelUnderline(true);		
        this.contbunkerBuildDate.setVisible(true);
        // contmarginAmt		
        this.contmarginAmt.setBoundLabelText(resHelper.getString("contmarginAmt.boundLabelText"));		
        this.contmarginAmt.setBoundLabelLength(100);		
        this.contmarginAmt.setBoundLabelUnderline(true);		
        this.contmarginAmt.setVisible(true);
        // contborrowAmt		
        this.contborrowAmt.setBoundLabelText(resHelper.getString("contborrowAmt.boundLabelText"));		
        this.contborrowAmt.setBoundLabelLength(100);		
        this.contborrowAmt.setBoundLabelUnderline(true);		
        this.contborrowAmt.setVisible(true);
        // conttransPrice		
        this.conttransPrice.setBoundLabelText(resHelper.getString("conttransPrice.boundLabelText"));		
        this.conttransPrice.setBoundLabelLength(100);		
        this.conttransPrice.setBoundLabelUnderline(true);		
        this.conttransPrice.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // txtarea		
        this.txtarea.setHorizontalAlignment(2);		
        this.txtarea.setDataType(1);		
        this.txtarea.setSupportedEmpty(true);		
        this.txtarea.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtarea.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtarea.setPrecision(4);		
        this.txtarea.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // txtsuccahQty		
        this.txtsuccahQty.setHorizontalAlignment(2);		
        this.txtsuccahQty.setDataType(0);		
        this.txtsuccahQty.setSupportedEmpty(true);		
        this.txtsuccahQty.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);		
        this.prmtcompany.setEnabled(false);
        // txtfloorArea		
        this.txtfloorArea.setVisible(true);		
        this.txtfloorArea.setHorizontalAlignment(2);		
        this.txtfloorArea.setDataType(1);		
        this.txtfloorArea.setSupportedEmpty(true);		
        this.txtfloorArea.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfloorArea.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfloorArea.setPrecision(4);		
        this.txtfloorArea.setRequired(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setVisible(true);		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);
        // prmtwarehouse		
        this.prmtwarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");		
        this.prmtwarehouse.setVisible(true);		
        this.prmtwarehouse.setEditable(true);		
        this.prmtwarehouse.setDisplayFormat("$name$");		
        this.prmtwarehouse.setEditFormat("$number$");		
        this.prmtwarehouse.setCommitFormat("$number$");		
        this.prmtwarehouse.setRequired(false);
        // prmtstorageOrgUnit		
        this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstorageOrgUnit.setVisible(true);		
        this.prmtstorageOrgUnit.setEditable(true);		
        this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtstorageOrgUnit.setEditFormat("$number$");		
        this.prmtstorageOrgUnit.setCommitFormat("$number$");		
        this.prmtstorageOrgUnit.setRequired(false);
        // farmType		
        this.farmType.setVisible(true);		
        this.farmType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum").toArray());		
        this.farmType.setRequired(true);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerQuery");		
        this.prmtfarmer.setVisible(false);		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmerListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtfarmer_F7ListUI));
					prmtfarmer_F7ListUI.setF7Use(true,ctx);
					prmtfarmer.setSelector(prmtfarmer_F7ListUI);
				}
			}
		});
					
        // txtmileStd		
        this.txtmileStd.setHorizontalAlignment(2);		
        this.txtmileStd.setDataType(1);		
        this.txtmileStd.setSupportedEmpty(true);		
        this.txtmileStd.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmileStd.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmileStd.setPrecision(4);		
        this.txtmileStd.setRequired(false);
        // txtrecyMiles		
        this.txtrecyMiles.setHorizontalAlignment(2);		
        this.txtrecyMiles.setDataType(1);		
        this.txtrecyMiles.setSupportedEmpty(true);		
        this.txtrecyMiles.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtrecyMiles.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtrecyMiles.setPrecision(4);		
        this.txtrecyMiles.setRequired(false);
        // txtmnemonicCode		
        this.txtmnemonicCode.setHorizontalAlignment(2);		
        this.txtmnemonicCode.setMaxLength(100);		
        this.txtmnemonicCode.setRequired(false);
        // txtgm		
        this.txtgm.setVisible(true);		
        this.txtgm.setHorizontalAlignment(2);		
        this.txtgm.setMaxLength(100);		
        this.txtgm.setRequired(false);
        // faemsType		
        this.faemsType.setVisible(true);		
        this.faemsType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmsType").toArray());		
        this.faemsType.setRequired(false);
        // kDPanel1
        // kdtHouseEntry
		String kdtHouseEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"area\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"floorArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"costCentor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"warehouse\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{area}</t:Cell><t:Cell>$Resource{floorArea}</t:Cell><t:Cell>$Resource{costCentor}</t:Cell><t:Cell>$Resource{warehouse}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtHouseEntry.setFormatXml(resHelper.translateString("kdtHouseEntry",kdtHouseEntryStrXML));

                this.kdtHouseEntry.putBindContents("editData",new String[] {"seq","number","name","area","floorArea","costCentor","warehouse"});


        this.kdtHouseEntry.checkParsed();
        KDTextField kdtHouseEntry_number_TextField = new KDTextField();
        kdtHouseEntry_number_TextField.setName("kdtHouseEntry_number_TextField");
        kdtHouseEntry_number_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtHouseEntry_number_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_number_TextField);
        this.kdtHouseEntry.getColumn("number").setEditor(kdtHouseEntry_number_CellEditor);
        KDTextField kdtHouseEntry_name_TextField = new KDTextField();
        kdtHouseEntry_name_TextField.setName("kdtHouseEntry_name_TextField");
        kdtHouseEntry_name_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtHouseEntry_name_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_name_TextField);
        this.kdtHouseEntry.getColumn("name").setEditor(kdtHouseEntry_name_CellEditor);
        KDFormattedTextField kdtHouseEntry_area_TextField = new KDFormattedTextField();
        kdtHouseEntry_area_TextField.setName("kdtHouseEntry_area_TextField");
        kdtHouseEntry_area_TextField.setVisible(true);
        kdtHouseEntry_area_TextField.setEditable(true);
        kdtHouseEntry_area_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_area_TextField.setDataType(1);
        	kdtHouseEntry_area_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_area_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_area_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_area_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_area_TextField);
        this.kdtHouseEntry.getColumn("area").setEditor(kdtHouseEntry_area_CellEditor);
        KDFormattedTextField kdtHouseEntry_floorArea_TextField = new KDFormattedTextField();
        kdtHouseEntry_floorArea_TextField.setName("kdtHouseEntry_floorArea_TextField");
        kdtHouseEntry_floorArea_TextField.setVisible(true);
        kdtHouseEntry_floorArea_TextField.setEditable(true);
        kdtHouseEntry_floorArea_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_floorArea_TextField.setDataType(1);
        	kdtHouseEntry_floorArea_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_floorArea_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_floorArea_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_floorArea_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_floorArea_TextField);
        this.kdtHouseEntry.getColumn("floorArea").setEditor(kdtHouseEntry_floorArea_CellEditor);
        final KDBizPromptBox kdtHouseEntry_costCentor_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_costCentor_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");
        kdtHouseEntry_costCentor_PromptBox.setVisible(true);
        kdtHouseEntry_costCentor_PromptBox.setEditable(true);
        kdtHouseEntry_costCentor_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_costCentor_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_costCentor_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_costCentor_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_costCentor_PromptBox);
        this.kdtHouseEntry.getColumn("costCentor").setEditor(kdtHouseEntry_costCentor_CellEditor);
        ObjectValueRender kdtHouseEntry_costCentor_OVR = new ObjectValueRender();
        kdtHouseEntry_costCentor_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("costCentor").setRenderer(kdtHouseEntry_costCentor_OVR);
        final KDBizPromptBox kdtHouseEntry_warehouse_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_warehouse_PromptBox.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.F7AllWarehouseQuery");
        kdtHouseEntry_warehouse_PromptBox.setVisible(true);
        kdtHouseEntry_warehouse_PromptBox.setEditable(true);
        kdtHouseEntry_warehouse_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_warehouse_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_warehouse_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_warehouse_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_warehouse_PromptBox);
        this.kdtHouseEntry.getColumn("warehouse").setEditor(kdtHouseEntry_warehouse_CellEditor);
        ObjectValueRender kdtHouseEntry_warehouse_OVR = new ObjectValueRender();
        kdtHouseEntry_warehouse_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("warehouse").setRenderer(kdtHouseEntry_warehouse_OVR);
        // txtinitSettleBatchNum		
        this.txtinitSettleBatchNum.setVisible(true);		
        this.txtinitSettleBatchNum.setHorizontalAlignment(2);		
        this.txtinitSettleBatchNum.setDataType(0);		
        this.txtinitSettleBatchNum.setSupportedEmpty(true);		
        this.txtinitSettleBatchNum.setRequired(false);
        // txttotalSettleBatchNum		
        this.txttotalSettleBatchNum.setVisible(true);		
        this.txttotalSettleBatchNum.setHorizontalAlignment(2);		
        this.txttotalSettleBatchNum.setDataType(0);		
        this.txttotalSettleBatchNum.setSupportedEmpty(true);		
        this.txttotalSettleBatchNum.setRequired(false);		
        this.txttotalSettleBatchNum.setEnabled(false);
        // txtsettledBatchNum		
        this.txtsettledBatchNum.setVisible(true);		
        this.txtsettledBatchNum.setHorizontalAlignment(2);		
        this.txtsettledBatchNum.setDataType(0);		
        this.txtsettledBatchNum.setSupportedEmpty(true);		
        this.txtsettledBatchNum.setRequired(false);		
        this.txtsettledBatchNum.setEnabled(false);
        // bunker		
        this.bunker.setVisible(true);		
        this.bunker.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum").toArray());		
        this.bunker.setRequired(false);
        // pkbunkerBuildDate		
        this.pkbunkerBuildDate.setVisible(true);		
        this.pkbunkerBuildDate.setRequired(false);
        // txtmarginAmt		
        this.txtmarginAmt.setVisible(true);		
        this.txtmarginAmt.setHorizontalAlignment(2);		
        this.txtmarginAmt.setDataType(1);		
        this.txtmarginAmt.setSupportedEmpty(true);		
        this.txtmarginAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarginAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarginAmt.setPrecision(2);		
        this.txtmarginAmt.setRequired(false);		
        this.txtmarginAmt.setEnabled(false);
        // txtborrowAmt		
        this.txtborrowAmt.setVisible(true);		
        this.txtborrowAmt.setHorizontalAlignment(2);		
        this.txtborrowAmt.setDataType(1);		
        this.txtborrowAmt.setSupportedEmpty(true);		
        this.txtborrowAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtborrowAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtborrowAmt.setPrecision(2);		
        this.txtborrowAmt.setRequired(false);		
        this.txtborrowAmt.setEnabled(false);
        // txttransPrice		
        this.txttransPrice.setVisible(true);		
        this.txttransPrice.setHorizontalAlignment(2);		
        this.txttransPrice.setDataType(1);		
        this.txttransPrice.setSupportedEmpty(true);		
        this.txttransPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttransPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttransPrice.setPrecision(4);		
        this.txttransPrice.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,txtaddress,txtarea,baseStatus,txtsuccahQty,prmtcompany,kdtHouseEntry,txtfloorArea,prmtcostCenter,chkisHouseManager,prmtwarehouse,prmtstorageOrgUnit,farmType,prmtfarmer,txtmileStd,txtrecyMiles,txtmnemonicCode,chkisAllot,txtgm,faemsType,txtinitSettleBatchNum,bunker,pkbunkerBuildDate,txtmarginAmt,txtborrowAmt,txttransPrice}));
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
        this.setBounds(new Rectangle(0, 0, 680, 550));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(26, 17, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(373, 17, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(768, 177, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(766, 210, 270, 19));
        this.add(kDLabelContainer4, null);
        contaddress.setBounds(new Rectangle(26, 104, 441, 19));
        this.add(contaddress, null);
        contarea.setBounds(new Rectangle(26, 75, 135, 19));
        this.add(contarea, null);
        contbaseStatus.setBounds(new Rectangle(373, 46, 270, 19));
        this.add(contbaseStatus, null);
        contsuccahQty.setBounds(new Rectangle(26, 46, 270, 19));
        this.add(contsuccahQty, null);
        contcompany.setBounds(new Rectangle(26, 133, 270, 19));
        this.add(contcompany, null);
        contfloorArea.setBounds(new Rectangle(172, 75, 128, 19));
        this.add(contfloorArea, null);
        contcostCenter.setBounds(new Rectangle(373, 133, 270, 19));
        this.add(contcostCenter, null);
        chkisHouseManager.setBounds(new Rectangle(557, 104, 85, 19));
        this.add(chkisHouseManager, null);
        contwarehouse.setBounds(new Rectangle(373, 162, 270, 19));
        this.add(contwarehouse, null);
        contstorageOrgUnit.setBounds(new Rectangle(26, 162, 270, 19));
        this.add(contstorageOrgUnit, null);
        contfarmType.setBounds(new Rectangle(373, 75, 270, 19));
        this.add(contfarmType, null);
        contfarmer.setBounds(new Rectangle(619, 205, 270, 19));
        this.add(contfarmer, null);
        contmileStd.setBounds(new Rectangle(373, 220, 270, 19));
        this.add(contmileStd, null);
        contrecyMiles.setBounds(new Rectangle(26, 220, 270, 19));
        this.add(contrecyMiles, null);
        contmnemonicCode.setBounds(new Rectangle(373, 278, 270, 19));
        this.add(contmnemonicCode, null);
        chkisAllot.setBounds(new Rectangle(477, 104, 70, 19));
        this.add(chkisAllot, null);
        contgm.setBounds(new Rectangle(26, 191, 270, 19));
        this.add(contgm, null);
        contfaemsType.setBounds(new Rectangle(373, 191, 270, 19));
        this.add(contfaemsType, null);
        kDTabbedPane1.setBounds(new Rectangle(26, 390, 622, 147));
        this.add(kDTabbedPane1, null);
        continitSettleBatchNum.setBounds(new Rectangle(26, 249, 270, 19));
        this.add(continitSettleBatchNum, null);
        conttotalSettleBatchNum.setBounds(new Rectangle(26, 278, 270, 19));
        this.add(conttotalSettleBatchNum, null);
        contsettledBatchNum.setBounds(new Rectangle(373, 249, 270, 19));
        this.add(contsettledBatchNum, null);
        contbunker.setBounds(new Rectangle(26, 310, 270, 19));
        this.add(contbunker, null);
        contbunkerBuildDate.setBounds(new Rectangle(373, 311, 270, 19));
        this.add(contbunkerBuildDate, null);
        contmarginAmt.setBounds(new Rectangle(26, 340, 270, 19));
        this.add(contmarginAmt, null);
        contborrowAmt.setBounds(new Rectangle(373, 340, 270, 19));
        this.add(contborrowAmt, null);
        conttransPrice.setBounds(new Rectangle(26, 366, 270, 19));
        this.add(conttransPrice, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contarea
        contarea.setBoundEditor(txtarea);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contsuccahQty
        contsuccahQty.setBoundEditor(txtsuccahQty);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contfloorArea
        contfloorArea.setBoundEditor(txtfloorArea);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contwarehouse
        contwarehouse.setBoundEditor(prmtwarehouse);
        //contstorageOrgUnit
        contstorageOrgUnit.setBoundEditor(prmtstorageOrgUnit);
        //contfarmType
        contfarmType.setBoundEditor(farmType);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contmileStd
        contmileStd.setBoundEditor(txtmileStd);
        //contrecyMiles
        contrecyMiles.setBoundEditor(txtrecyMiles);
        //contmnemonicCode
        contmnemonicCode.setBoundEditor(txtmnemonicCode);
        //contgm
        contgm.setBoundEditor(txtgm);
        //contfaemsType
        contfaemsType.setBoundEditor(faemsType);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtHouseEntry.setBounds(new Rectangle(4, 12, 607, 145));
        kdtHouseEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtHouseEntry,new com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo(),null,false);
        kDPanel1.add(kdtHouseEntry_detailPanel, null);
        //continitSettleBatchNum
        continitSettleBatchNum.setBoundEditor(txtinitSettleBatchNum);
        //conttotalSettleBatchNum
        conttotalSettleBatchNum.setBoundEditor(txttotalSettleBatchNum);
        //contsettledBatchNum
        contsettledBatchNum.setBoundEditor(txtsettledBatchNum);
        //contbunker
        contbunker.setBoundEditor(bunker);
        //contbunkerBuildDate
        contbunkerBuildDate.setBoundEditor(pkbunkerBuildDate);
        //contmarginAmt
        contmarginAmt.setBoundEditor(txtmarginAmt);
        //contborrowAmt
        contborrowAmt.setBoundEditor(txtborrowAmt);
        //conttransPrice
        conttransPrice.setBoundEditor(txttransPrice);

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
		dataBinder.registerBinding("isHouseManager", boolean.class, this.chkisHouseManager, "selected");
		dataBinder.registerBinding("isAllot", boolean.class, this.chkisAllot, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("area", java.math.BigDecimal.class, this.txtarea, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("succahQty", int.class, this.txtsuccahQty, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("floorArea", java.math.BigDecimal.class, this.txtfloorArea, "value");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("warehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtwarehouse, "data");
		dataBinder.registerBinding("storageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstorageOrgUnit, "data");
		dataBinder.registerBinding("farmType", com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum.class, this.farmType, "selectedItem");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("mileStd", java.math.BigDecimal.class, this.txtmileStd, "value");
		dataBinder.registerBinding("recyMiles", java.math.BigDecimal.class, this.txtrecyMiles, "value");
		dataBinder.registerBinding("mnemonicCode", String.class, this.txtmnemonicCode, "text");
		dataBinder.registerBinding("gm", String.class, this.txtgm, "text");
		dataBinder.registerBinding("faemsType", com.kingdee.eas.farm.stocking.basedata.FarmsType.class, this.faemsType, "selectedItem");
		dataBinder.registerBinding("HouseEntry.seq", int.class, this.kdtHouseEntry, "seq.text");
		dataBinder.registerBinding("HouseEntry", com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo.class, this.kdtHouseEntry, "userObject");
		dataBinder.registerBinding("HouseEntry.number", String.class, this.kdtHouseEntry, "number.text");
		dataBinder.registerBinding("HouseEntry.name", String.class, this.kdtHouseEntry, "name.text");
		dataBinder.registerBinding("HouseEntry.area", java.math.BigDecimal.class, this.kdtHouseEntry, "area.text");
		dataBinder.registerBinding("HouseEntry.floorArea", java.math.BigDecimal.class, this.kdtHouseEntry, "floorArea.text");
		dataBinder.registerBinding("HouseEntry.costCentor", java.lang.Object.class, this.kdtHouseEntry, "costCentor.text");
		dataBinder.registerBinding("HouseEntry.warehouse", java.lang.Object.class, this.kdtHouseEntry, "warehouse.text");
		dataBinder.registerBinding("initSettleBatchNum", int.class, this.txtinitSettleBatchNum, "value");
		dataBinder.registerBinding("totalSettleBatchNum", int.class, this.txttotalSettleBatchNum, "value");
		dataBinder.registerBinding("settledBatchNum", int.class, this.txtsettledBatchNum, "value");
		dataBinder.registerBinding("bunker", com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum.class, this.bunker, "selectedItem");
		dataBinder.registerBinding("bunkerBuildDate", java.util.Date.class, this.pkbunkerBuildDate, "value");
		dataBinder.registerBinding("marginAmt", java.math.BigDecimal.class, this.txtmarginAmt, "value");
		dataBinder.registerBinding("borrowAmt", java.math.BigDecimal.class, this.txtborrowAmt, "value");
		dataBinder.registerBinding("transPrice", java.math.BigDecimal.class, this.txttransPrice, "value");		
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
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.FarmEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)ov;
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
		getValidateHelper().registerBindProperty("isHouseManager", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAllot", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("succahQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mileStd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("recyMiles", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mnemonicCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("gm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("faemsType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.area", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.floorArea", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.costCentor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.warehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initSettleBatchNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalSettleBatchNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settledBatchNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bunker", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bunkerBuildDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marginAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("borrowAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("transPrice", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("isHouseManager"));
        sic.add(new SelectorItemInfo("isAllot"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("area"));
        sic.add(new SelectorItemInfo("baseStatus"));
        sic.add(new SelectorItemInfo("succahQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("floorArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("warehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("warehouse.id"));
        	sic.add(new SelectorItemInfo("warehouse.number"));
        	sic.add(new SelectorItemInfo("warehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("storageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("storageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("storageOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("farmType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
        sic.add(new SelectorItemInfo("mileStd"));
        sic.add(new SelectorItemInfo("recyMiles"));
        sic.add(new SelectorItemInfo("mnemonicCode"));
        sic.add(new SelectorItemInfo("gm"));
        sic.add(new SelectorItemInfo("faemsType"));
    	sic.add(new SelectorItemInfo("HouseEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.*"));
		}
		else{
			sic.add(new SelectorItemInfo("HouseEntry.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.number"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.area"));
    	sic.add(new SelectorItemInfo("HouseEntry.floorArea"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.costCentor.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.costCentor.id"));
			sic.add(new SelectorItemInfo("HouseEntry.costCentor.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.costCentor.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.warehouse.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.warehouse.id"));
			sic.add(new SelectorItemInfo("HouseEntry.warehouse.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.warehouse.number"));
		}
        sic.add(new SelectorItemInfo("initSettleBatchNum"));
        sic.add(new SelectorItemInfo("totalSettleBatchNum"));
        sic.add(new SelectorItemInfo("settledBatchNum"));
        sic.add(new SelectorItemInfo("bunker"));
        sic.add(new SelectorItemInfo("bunkerBuildDate"));
        sic.add(new SelectorItemInfo("marginAmt"));
        sic.add(new SelectorItemInfo("borrowAmt"));
        sic.add(new SelectorItemInfo("transPrice"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractFarmEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "FarmEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.FarmEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.FarmFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(farmType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"养殖场类别"});
		}
		for (int i=0,n=kdtHouseEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHouseEntry.getCell(i,"number").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
			}
		}
		for (int i=0,n=kdtHouseEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHouseEntry.getCell(i,"name").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
			}
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtHouseEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
vo.put("farmType",new Integer(3));
vo.put("faemsType","0");
vo.put("bunker","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}