/**
 * output package name
 */
package com.kingdee.eas.custom.dx.baseset.client;

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
public abstract class AbstractFoodDailyEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFoodDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossChickenCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttodayNetProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwaterAbsorption;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvicePrice;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonPrice;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioConstant;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossWeight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtslaughterAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossChickenCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttodayNetProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwaterAbsorption;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtvicePrice;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioConstant;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPaneDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuetQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheadQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainProductQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyProductQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchaochanfei;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherpay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzulengku;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcailiao;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzcf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contzjf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuetQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtheadQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainProductQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyProductQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchaochanfei;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherpay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzulengku;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcailiao;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzcf;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtzjf;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperCatipaEfficiency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendancePeople;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallPeople;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contLeavenumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoffduty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtperCatipaEfficiency;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtattendancePeople;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallPeople;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherProductQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherProductQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtotherProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtLeavenumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoffduty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDComboBox productType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossWeight;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGetData;
    protected com.kingdee.eas.custom.dx.baseset.FoodDailyInfo editData = null;
    protected ActionGetData actionGetData = null;
    /**
     * output class constructor
     */
    public AbstractFoodDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFoodDailyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionGetData
        this.actionGetData = new ActionGetData(this);
        getActionManager().registerAction("actionGetData", actionGetData);
        this.actionGetData.setExtendProperty("canForewarn", "true");
        this.actionGetData.setExtendProperty("userDefined", "false");
        this.actionGetData.setExtendProperty("isObjectUpdateLock", "false");
         this.actionGetData.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionGetData.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.contslaughterAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossChickenCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttodayNetProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwaterAbsorption = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contallMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvicePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator15 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contratioConstant = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contproductType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossWeight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtslaughterAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossChickenCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttodayNetProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwaterAbsorption = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtvicePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txttonPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioConstant = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPaneDetail = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contsuetQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheadQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainProductQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainProductAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyProductQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyProductAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchaochanfei = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherpay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzulengku = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcailiao = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzcf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contzjf = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtsuetQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtheadQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainProductQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainProductAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyProductQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyProductAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchaochanfei = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherpay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzulengku = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcailiao = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzcf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtzjf = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contperCatipaEfficiency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendancePeople = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallPeople = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contLeavenumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoffduty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtperCatipaEfficiency = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkTime = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtattendancePeople = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallPeople = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contotherProductQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherProductAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtotherProductQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtotherProductAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtLeavenumber = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoffduty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.productType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtGrossWeight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnGetData = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contslaughterAmt.setName("contslaughterAmt");
        this.contGrossChickenCost.setName("contGrossChickenCost");
        this.conttodayNetProfit.setName("conttodayNetProfit");
        this.contwaterAbsorption.setName("contwaterAbsorption");
        this.kDSeparator8.setName("kDSeparator8");
        this.contallMoney.setName("contallMoney");
        this.contmainPrice.setName("contmainPrice");
        this.contvicePrice.setName("contvicePrice");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.contcompany.setName("contcompany");
        this.conttonPrice.setName("conttonPrice");
        this.kDSeparator15.setName("kDSeparator15");
        this.contratioConstant.setName("contratioConstant");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contproductType.setName("contproductType");
        this.contGrossWeight.setName("contGrossWeight");
        this.txtslaughterAmt.setName("txtslaughterAmt");
        this.txtGrossChickenCost.setName("txtGrossChickenCost");
        this.txttodayNetProfit.setName("txttodayNetProfit");
        this.txtwaterAbsorption.setName("txtwaterAbsorption");
        this.txtallMoney.setName("txtallMoney");
        this.txtmainPrice.setName("txtmainPrice");
        this.txtvicePrice.setName("txtvicePrice");
        this.prmtcompany.setName("prmtcompany");
        this.txttonPrice.setName("txttonPrice");
        this.txtratioConstant.setName("txtratioConstant");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel3.setName("kDPanel3");
        this.kDPaneDetail.setName("kDPaneDetail");
        this.contsuetQty.setName("contsuetQty");
        this.contheadQty.setName("contheadQty");
        this.contmainProductQty.setName("contmainProductQty");
        this.contmainProductAmt.setName("contmainProductAmt");
        this.contbyProductQty.setName("contbyProductQty");
        this.contbyProductAmt.setName("contbyProductAmt");
        this.contchaochanfei.setName("contchaochanfei");
        this.contotherpay.setName("contotherpay");
        this.contzulengku.setName("contzulengku");
        this.contcailiao.setName("contcailiao");
        this.contzcf.setName("contzcf");
        this.contzjf.setName("contzjf");
        this.txtsuetQty.setName("txtsuetQty");
        this.txtheadQty.setName("txtheadQty");
        this.txtmainProductQty.setName("txtmainProductQty");
        this.txtmainProductAmt.setName("txtmainProductAmt");
        this.txtbyProductQty.setName("txtbyProductQty");
        this.txtbyProductAmt.setName("txtbyProductAmt");
        this.txtchaochanfei.setName("txtchaochanfei");
        this.txtotherpay.setName("txtotherpay");
        this.txtzulengku.setName("txtzulengku");
        this.txtcailiao.setName("txtcailiao");
        this.txtzcf.setName("txtzcf");
        this.txtzjf.setName("txtzjf");
        this.contperCatipaEfficiency.setName("contperCatipaEfficiency");
        this.contworkTime.setName("contworkTime");
        this.contattendancePeople.setName("contattendancePeople");
        this.contallPeople.setName("contallPeople");
        this.kDPanel1.setName("kDPanel1");
        this.contLeavenumber.setName("contLeavenumber");
        this.contoffduty.setName("contoffduty");
        this.txtperCatipaEfficiency.setName("txtperCatipaEfficiency");
        this.txtworkTime.setName("txtworkTime");
        this.txtattendancePeople.setName("txtattendancePeople");
        this.txtallPeople.setName("txtallPeople");
        this.contotherProductQty.setName("contotherProductQty");
        this.contotherProductAmt.setName("contotherProductAmt");
        this.txtotherProductQty.setName("txtotherProductQty");
        this.txtotherProductAmt.setName("txtotherProductAmt");
        this.txtLeavenumber.setName("txtLeavenumber");
        this.txtoffduty.setName("txtoffduty");
        this.kdtEntry.setName("kdtEntry");
        this.kDLabel1.setName("kDLabel1");
        this.productType.setName("productType");
        this.txtGrossWeight.setName("txtGrossWeight");
        this.btnGetData.setName("btnGetData");
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
        this.contNumber.setVisible(false);		
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
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);
        // contslaughterAmt		
        this.contslaughterAmt.setBoundLabelText(resHelper.getString("contslaughterAmt.boundLabelText"));		
        this.contslaughterAmt.setBoundLabelLength(100);		
        this.contslaughterAmt.setBoundLabelUnderline(true);		
        this.contslaughterAmt.setVisible(true);
        // contGrossChickenCost		
        this.contGrossChickenCost.setBoundLabelText(resHelper.getString("contGrossChickenCost.boundLabelText"));		
        this.contGrossChickenCost.setBoundLabelLength(100);		
        this.contGrossChickenCost.setBoundLabelUnderline(true);		
        this.contGrossChickenCost.setVisible(true);
        // conttodayNetProfit		
        this.conttodayNetProfit.setBoundLabelText(resHelper.getString("conttodayNetProfit.boundLabelText"));		
        this.conttodayNetProfit.setBoundLabelLength(100);		
        this.conttodayNetProfit.setBoundLabelUnderline(true);		
        this.conttodayNetProfit.setVisible(true);
        // contwaterAbsorption		
        this.contwaterAbsorption.setBoundLabelText(resHelper.getString("contwaterAbsorption.boundLabelText"));		
        this.contwaterAbsorption.setBoundLabelLength(100);		
        this.contwaterAbsorption.setBoundLabelUnderline(true);		
        this.contwaterAbsorption.setVisible(true);
        // kDSeparator8
        // contallMoney		
        this.contallMoney.setBoundLabelText(resHelper.getString("contallMoney.boundLabelText"));		
        this.contallMoney.setBoundLabelLength(100);		
        this.contallMoney.setBoundLabelUnderline(true);		
        this.contallMoney.setVisible(true);
        // contmainPrice		
        this.contmainPrice.setBoundLabelText(resHelper.getString("contmainPrice.boundLabelText"));		
        this.contmainPrice.setBoundLabelLength(100);		
        this.contmainPrice.setBoundLabelUnderline(true);		
        this.contmainPrice.setVisible(true);
        // contvicePrice		
        this.contvicePrice.setBoundLabelText(resHelper.getString("contvicePrice.boundLabelText"));		
        this.contvicePrice.setBoundLabelLength(100);		
        this.contvicePrice.setBoundLabelUnderline(true);		
        this.contvicePrice.setVisible(true);
        // kDSeparator9
        // kDSeparator10
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // conttonPrice		
        this.conttonPrice.setBoundLabelText(resHelper.getString("conttonPrice.boundLabelText"));		
        this.conttonPrice.setBoundLabelLength(100);		
        this.conttonPrice.setBoundLabelUnderline(true);		
        this.conttonPrice.setVisible(true);
        // kDSeparator15
        // contratioConstant		
        this.contratioConstant.setBoundLabelText(resHelper.getString("contratioConstant.boundLabelText"));		
        this.contratioConstant.setBoundLabelLength(100);		
        this.contratioConstant.setBoundLabelUnderline(true);		
        this.contratioConstant.setVisible(true);
        // kDTabbedPane1
        // contproductType		
        this.contproductType.setBoundLabelText(resHelper.getString("contproductType.boundLabelText"));		
        this.contproductType.setBoundLabelLength(100);		
        this.contproductType.setBoundLabelUnderline(true);		
        this.contproductType.setVisible(false);
        // contGrossWeight		
        this.contGrossWeight.setBoundLabelText(resHelper.getString("contGrossWeight.boundLabelText"));		
        this.contGrossWeight.setBoundLabelLength(100);		
        this.contGrossWeight.setBoundLabelUnderline(true);		
        this.contGrossWeight.setVisible(true);
        // txtslaughterAmt		
        this.txtslaughterAmt.setHorizontalAlignment(2);		
        this.txtslaughterAmt.setDataType(0);		
        this.txtslaughterAmt.setSupportedEmpty(true);		
        this.txtslaughterAmt.setRequired(false);
        // txtGrossChickenCost		
        this.txtGrossChickenCost.setHorizontalAlignment(2);		
        this.txtGrossChickenCost.setDataType(1);		
        this.txtGrossChickenCost.setSupportedEmpty(true);		
        this.txtGrossChickenCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossChickenCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossChickenCost.setPrecision(2);		
        this.txtGrossChickenCost.setRequired(false);
        // txttodayNetProfit		
        this.txttodayNetProfit.setHorizontalAlignment(2);		
        this.txttodayNetProfit.setDataType(1);		
        this.txttodayNetProfit.setSupportedEmpty(true);		
        this.txttodayNetProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttodayNetProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttodayNetProfit.setPrecision(2);		
        this.txttodayNetProfit.setRequired(false);
        // txtwaterAbsorption		
        this.txtwaterAbsorption.setHorizontalAlignment(2);		
        this.txtwaterAbsorption.setDataType(1);		
        this.txtwaterAbsorption.setSupportedEmpty(true);		
        this.txtwaterAbsorption.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtwaterAbsorption.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtwaterAbsorption.setPrecision(4);		
        this.txtwaterAbsorption.setRequired(false);
        // txtallMoney		
        this.txtallMoney.setHorizontalAlignment(2);		
        this.txtallMoney.setDataType(1);		
        this.txtallMoney.setSupportedEmpty(true);		
        this.txtallMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallMoney.setPrecision(2);		
        this.txtallMoney.setRequired(false);
        // txtmainPrice		
        this.txtmainPrice.setHorizontalAlignment(2);		
        this.txtmainPrice.setDataType(1);		
        this.txtmainPrice.setSupportedEmpty(true);		
        this.txtmainPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainPrice.setPrecision(4);		
        this.txtmainPrice.setRequired(false);
        // txtvicePrice		
        this.txtvicePrice.setHorizontalAlignment(2);		
        this.txtvicePrice.setDataType(1);		
        this.txtvicePrice.setSupportedEmpty(true);		
        this.txtvicePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtvicePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtvicePrice.setPrecision(4);		
        this.txtvicePrice.setRequired(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txttonPrice		
        this.txttonPrice.setHorizontalAlignment(2);		
        this.txttonPrice.setDataType(1);		
        this.txttonPrice.setSupportedEmpty(true);		
        this.txttonPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonPrice.setPrecision(4);		
        this.txttonPrice.setRequired(false);
        // txtratioConstant		
        this.txtratioConstant.setHorizontalAlignment(2);		
        this.txtratioConstant.setDataType(1);		
        this.txtratioConstant.setSupportedEmpty(true);		
        this.txtratioConstant.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtratioConstant.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtratioConstant.setPrecision(4);		
        this.txtratioConstant.setRequired(false);
        // kDPanel2		
        this.kDPanel2.setVisible(false);
        // kDPanel4
        // kDPanel3
        // kDPaneDetail
        // contsuetQty		
        this.contsuetQty.setBoundLabelText(resHelper.getString("contsuetQty.boundLabelText"));		
        this.contsuetQty.setBoundLabelLength(70);		
        this.contsuetQty.setBoundLabelUnderline(true);
        // contheadQty		
        this.contheadQty.setBoundLabelText(resHelper.getString("contheadQty.boundLabelText"));		
        this.contheadQty.setBoundLabelLength(100);		
        this.contheadQty.setBoundLabelUnderline(true);
        // contmainProductQty		
        this.contmainProductQty.setBoundLabelText(resHelper.getString("contmainProductQty.boundLabelText"));		
        this.contmainProductQty.setBoundLabelLength(70);		
        this.contmainProductQty.setBoundLabelUnderline(true);
        // contmainProductAmt		
        this.contmainProductAmt.setBoundLabelText(resHelper.getString("contmainProductAmt.boundLabelText"));		
        this.contmainProductAmt.setBoundLabelLength(70);		
        this.contmainProductAmt.setBoundLabelUnderline(true);
        // contbyProductQty		
        this.contbyProductQty.setBoundLabelText(resHelper.getString("contbyProductQty.boundLabelText"));		
        this.contbyProductQty.setBoundLabelLength(70);		
        this.contbyProductQty.setBoundLabelUnderline(true);
        // contbyProductAmt		
        this.contbyProductAmt.setBoundLabelText(resHelper.getString("contbyProductAmt.boundLabelText"));		
        this.contbyProductAmt.setBoundLabelLength(70);		
        this.contbyProductAmt.setBoundLabelUnderline(true);
        // contchaochanfei		
        this.contchaochanfei.setBoundLabelText(resHelper.getString("contchaochanfei.boundLabelText"));		
        this.contchaochanfei.setBoundLabelLength(100);		
        this.contchaochanfei.setBoundLabelUnderline(true);		
        this.contchaochanfei.setVisible(true);
        // contotherpay		
        this.contotherpay.setBoundLabelText(resHelper.getString("contotherpay.boundLabelText"));		
        this.contotherpay.setBoundLabelLength(100);		
        this.contotherpay.setBoundLabelUnderline(true);		
        this.contotherpay.setVisible(true);
        // contzulengku		
        this.contzulengku.setBoundLabelText(resHelper.getString("contzulengku.boundLabelText"));		
        this.contzulengku.setBoundLabelLength(100);		
        this.contzulengku.setBoundLabelUnderline(true);		
        this.contzulengku.setVisible(true);
        // contcailiao		
        this.contcailiao.setBoundLabelText(resHelper.getString("contcailiao.boundLabelText"));		
        this.contcailiao.setBoundLabelLength(100);		
        this.contcailiao.setBoundLabelUnderline(true);		
        this.contcailiao.setVisible(true);
        // contzcf		
        this.contzcf.setBoundLabelText(resHelper.getString("contzcf.boundLabelText"));		
        this.contzcf.setBoundLabelLength(100);		
        this.contzcf.setBoundLabelUnderline(true);		
        this.contzcf.setVisible(true);
        // contzjf		
        this.contzjf.setBoundLabelText(resHelper.getString("contzjf.boundLabelText"));		
        this.contzjf.setBoundLabelLength(100);		
        this.contzjf.setBoundLabelUnderline(true);		
        this.contzjf.setVisible(true);
        // txtsuetQty		
        this.txtsuetQty.setHorizontalAlignment(2);		
        this.txtsuetQty.setDataType(1);		
        this.txtsuetQty.setSupportedEmpty(true);		
        this.txtsuetQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuetQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuetQty.setPrecision(4);		
        this.txtsuetQty.setRequired(false);
        // txtheadQty		
        this.txtheadQty.setHorizontalAlignment(2);		
        this.txtheadQty.setDataType(1);		
        this.txtheadQty.setSupportedEmpty(true);		
        this.txtheadQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtheadQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtheadQty.setPrecision(4);		
        this.txtheadQty.setRequired(false);
        // txtmainProductQty		
        this.txtmainProductQty.setHorizontalAlignment(2);		
        this.txtmainProductQty.setDataType(1);		
        this.txtmainProductQty.setSupportedEmpty(true);		
        this.txtmainProductQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainProductQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainProductQty.setPrecision(4);		
        this.txtmainProductQty.setRequired(false);
        // txtmainProductAmt		
        this.txtmainProductAmt.setHorizontalAlignment(2);		
        this.txtmainProductAmt.setDataType(1);		
        this.txtmainProductAmt.setSupportedEmpty(true);		
        this.txtmainProductAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainProductAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainProductAmt.setPrecision(2);		
        this.txtmainProductAmt.setRequired(false);
        // txtbyProductQty		
        this.txtbyProductQty.setHorizontalAlignment(2);		
        this.txtbyProductQty.setDataType(1);		
        this.txtbyProductQty.setSupportedEmpty(true);		
        this.txtbyProductQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyProductQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyProductQty.setPrecision(4);		
        this.txtbyProductQty.setRequired(false);
        // txtbyProductAmt		
        this.txtbyProductAmt.setHorizontalAlignment(2);		
        this.txtbyProductAmt.setDataType(1);		
        this.txtbyProductAmt.setSupportedEmpty(true);		
        this.txtbyProductAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyProductAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyProductAmt.setPrecision(2);		
        this.txtbyProductAmt.setRequired(false);
        // txtchaochanfei		
        this.txtchaochanfei.setVisible(true);		
        this.txtchaochanfei.setHorizontalAlignment(2);		
        this.txtchaochanfei.setDataType(1);		
        this.txtchaochanfei.setSupportedEmpty(true);		
        this.txtchaochanfei.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchaochanfei.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchaochanfei.setPrecision(4);		
        this.txtchaochanfei.setRequired(false);
        // txtotherpay		
        this.txtotherpay.setVisible(true);		
        this.txtotherpay.setHorizontalAlignment(2);		
        this.txtotherpay.setDataType(1);		
        this.txtotherpay.setSupportedEmpty(true);		
        this.txtotherpay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherpay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherpay.setPrecision(4);		
        this.txtotherpay.setRequired(false);
        // txtzulengku		
        this.txtzulengku.setVisible(true);		
        this.txtzulengku.setHorizontalAlignment(2);		
        this.txtzulengku.setDataType(1);		
        this.txtzulengku.setSupportedEmpty(true);		
        this.txtzulengku.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzulengku.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzulengku.setPrecision(4);		
        this.txtzulengku.setRequired(false);
        // txtcailiao		
        this.txtcailiao.setVisible(true);		
        this.txtcailiao.setHorizontalAlignment(2);		
        this.txtcailiao.setDataType(1);		
        this.txtcailiao.setSupportedEmpty(true);		
        this.txtcailiao.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcailiao.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcailiao.setPrecision(4);		
        this.txtcailiao.setRequired(false);
        // txtzcf		
        this.txtzcf.setVisible(true);		
        this.txtzcf.setHorizontalAlignment(2);		
        this.txtzcf.setDataType(1);		
        this.txtzcf.setSupportedEmpty(true);		
        this.txtzcf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzcf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzcf.setPrecision(4);		
        this.txtzcf.setRequired(false);
        // txtzjf		
        this.txtzjf.setVisible(true);		
        this.txtzjf.setHorizontalAlignment(2);		
        this.txtzjf.setDataType(1);		
        this.txtzjf.setSupportedEmpty(true);		
        this.txtzjf.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtzjf.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtzjf.setPrecision(4);		
        this.txtzjf.setRequired(false);
        // contperCatipaEfficiency		
        this.contperCatipaEfficiency.setBoundLabelText(resHelper.getString("contperCatipaEfficiency.boundLabelText"));		
        this.contperCatipaEfficiency.setBoundLabelLength(100);		
        this.contperCatipaEfficiency.setBoundLabelUnderline(true);		
        this.contperCatipaEfficiency.setVisible(true);
        // contworkTime		
        this.contworkTime.setBoundLabelText(resHelper.getString("contworkTime.boundLabelText"));		
        this.contworkTime.setBoundLabelLength(100);		
        this.contworkTime.setBoundLabelUnderline(true);		
        this.contworkTime.setVisible(true);
        // contattendancePeople		
        this.contattendancePeople.setBoundLabelText(resHelper.getString("contattendancePeople.boundLabelText"));		
        this.contattendancePeople.setBoundLabelLength(100);		
        this.contattendancePeople.setBoundLabelUnderline(true);		
        this.contattendancePeople.setVisible(true);
        // contallPeople		
        this.contallPeople.setBoundLabelText(resHelper.getString("contallPeople.boundLabelText"));		
        this.contallPeople.setBoundLabelLength(100);		
        this.contallPeople.setBoundLabelUnderline(true);		
        this.contallPeople.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setVisible(false);
        // contLeavenumber		
        this.contLeavenumber.setBoundLabelText(resHelper.getString("contLeavenumber.boundLabelText"));		
        this.contLeavenumber.setBoundLabelLength(100);		
        this.contLeavenumber.setBoundLabelUnderline(true);		
        this.contLeavenumber.setVisible(true);
        // contoffduty		
        this.contoffduty.setBoundLabelText(resHelper.getString("contoffduty.boundLabelText"));		
        this.contoffduty.setBoundLabelLength(100);		
        this.contoffduty.setBoundLabelUnderline(true);		
        this.contoffduty.setVisible(true);
        // txtperCatipaEfficiency		
        this.txtperCatipaEfficiency.setHorizontalAlignment(2);		
        this.txtperCatipaEfficiency.setDataType(1);		
        this.txtperCatipaEfficiency.setSupportedEmpty(true);		
        this.txtperCatipaEfficiency.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtperCatipaEfficiency.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtperCatipaEfficiency.setPrecision(4);		
        this.txtperCatipaEfficiency.setRequired(false);		
        this.txtperCatipaEfficiency.setEnabled(false);
        // txtworkTime		
        this.txtworkTime.setHorizontalAlignment(2);		
        this.txtworkTime.setDataType(1);		
        this.txtworkTime.setSupportedEmpty(true);		
        this.txtworkTime.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtworkTime.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtworkTime.setPrecision(4);		
        this.txtworkTime.setRequired(false);
        // txtattendancePeople		
        this.txtattendancePeople.setHorizontalAlignment(2);		
        this.txtattendancePeople.setDataType(0);		
        this.txtattendancePeople.setSupportedEmpty(true);		
        this.txtattendancePeople.setRequired(false);
        // txtallPeople		
        this.txtallPeople.setHorizontalAlignment(2);		
        this.txtallPeople.setDataType(0);		
        this.txtallPeople.setSupportedEmpty(true);		
        this.txtallPeople.setRequired(false);
        // contotherProductQty		
        this.contotherProductQty.setBoundLabelText(resHelper.getString("contotherProductQty.boundLabelText"));		
        this.contotherProductQty.setBoundLabelLength(100);		
        this.contotherProductQty.setBoundLabelUnderline(true);		
        this.contotherProductQty.setVisible(false);
        // contotherProductAmt		
        this.contotherProductAmt.setBoundLabelText(resHelper.getString("contotherProductAmt.boundLabelText"));		
        this.contotherProductAmt.setBoundLabelLength(100);		
        this.contotherProductAmt.setBoundLabelUnderline(true);		
        this.contotherProductAmt.setVisible(false);
        // txtotherProductQty		
        this.txtotherProductQty.setHorizontalAlignment(2);		
        this.txtotherProductQty.setDataType(1);		
        this.txtotherProductQty.setSupportedEmpty(true);		
        this.txtotherProductQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherProductQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherProductQty.setPrecision(4);		
        this.txtotherProductQty.setRequired(false);
        // txtotherProductAmt		
        this.txtotherProductAmt.setHorizontalAlignment(2);		
        this.txtotherProductAmt.setDataType(1);		
        this.txtotherProductAmt.setSupportedEmpty(true);		
        this.txtotherProductAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtotherProductAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtotherProductAmt.setPrecision(2);		
        this.txtotherProductAmt.setRequired(false);
        // txtLeavenumber		
        this.txtLeavenumber.setVisible(true);		
        this.txtLeavenumber.setHorizontalAlignment(2);		
        this.txtLeavenumber.setDataType(0);		
        this.txtLeavenumber.setSupportedEmpty(true);		
        this.txtLeavenumber.setRequired(false);
        // txtoffduty		
        this.txtoffduty.setVisible(true);		
        this.txtoffduty.setHorizontalAlignment(2);		
        this.txtoffduty.setDataType(0);		
        this.txtoffduty.setSupportedEmpty(true);		
        this.txtoffduty.setRequired(false);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>0.00</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>0.00</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>0.00</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>0.00</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"ccRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{materialGroup}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{ccRate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","materialGroup","materialNum","materialName","model","qty","price","amount","ccRate","remark"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_materialNum_PromptBox = new KDBizPromptBox();
        kdtEntry_materialNum_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_materialNum_PromptBox.setVisible(true);
        kdtEntry_materialNum_PromptBox.setEditable(true);
        kdtEntry_materialNum_PromptBox.setDisplayFormat("$number$");
        kdtEntry_materialNum_PromptBox.setEditFormat("$number$");
        kdtEntry_materialNum_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_materialNum_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialNum_PromptBox);
        this.kdtEntry.getColumn("materialNum").setEditor(kdtEntry_materialNum_CellEditor);
        ObjectValueRender kdtEntry_materialNum_OVR = new ObjectValueRender();
        kdtEntry_materialNum_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("materialNum").setRenderer(kdtEntry_materialNum_OVR);
        KDTextField kdtEntry_materialName_TextField = new KDTextField();
        kdtEntry_materialName_TextField.setName("kdtEntry_materialName_TextField");
        kdtEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialName_TextField);
        this.kdtEntry.getColumn("materialName").setEditor(kdtEntry_materialName_CellEditor);
        KDTextField kdtEntry_model_TextField = new KDTextField();
        kdtEntry_model_TextField.setName("kdtEntry_model_TextField");
        kdtEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEntry_model_TextField);
        this.kdtEntry.getColumn("model").setEditor(kdtEntry_model_CellEditor);
        KDFormattedTextField kdtEntry_qty_TextField = new KDFormattedTextField();
        kdtEntry_qty_TextField.setName("kdtEntry_qty_TextField");
        kdtEntry_qty_TextField.setVisible(true);
        kdtEntry_qty_TextField.setEditable(true);
        kdtEntry_qty_TextField.setHorizontalAlignment(2);
        kdtEntry_qty_TextField.setDataType(1);
        	kdtEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtEntry_qty_TextField);
        this.kdtEntry.getColumn("qty").setEditor(kdtEntry_qty_CellEditor);
        KDFormattedTextField kdtEntry_price_TextField = new KDFormattedTextField();
        kdtEntry_price_TextField.setName("kdtEntry_price_TextField");
        kdtEntry_price_TextField.setVisible(true);
        kdtEntry_price_TextField.setEditable(true);
        kdtEntry_price_TextField.setHorizontalAlignment(2);
        kdtEntry_price_TextField.setDataType(1);
        	kdtEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_price_CellEditor = new KDTDefaultCellEditor(kdtEntry_price_TextField);
        this.kdtEntry.getColumn("price").setEditor(kdtEntry_price_CellEditor);
        KDFormattedTextField kdtEntry_amount_TextField = new KDFormattedTextField();
        kdtEntry_amount_TextField.setName("kdtEntry_amount_TextField");
        kdtEntry_amount_TextField.setVisible(true);
        kdtEntry_amount_TextField.setEditable(true);
        kdtEntry_amount_TextField.setHorizontalAlignment(2);
        kdtEntry_amount_TextField.setDataType(1);
        	kdtEntry_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_amount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_amount_CellEditor = new KDTDefaultCellEditor(kdtEntry_amount_TextField);
        this.kdtEntry.getColumn("amount").setEditor(kdtEntry_amount_CellEditor);
        KDFormattedTextField kdtEntry_ccRate_TextField = new KDFormattedTextField();
        kdtEntry_ccRate_TextField.setName("kdtEntry_ccRate_TextField");
        kdtEntry_ccRate_TextField.setVisible(true);
        kdtEntry_ccRate_TextField.setEditable(true);
        kdtEntry_ccRate_TextField.setHorizontalAlignment(2);
        kdtEntry_ccRate_TextField.setDataType(1);
        	kdtEntry_ccRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_ccRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_ccRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_ccRate_CellEditor = new KDTDefaultCellEditor(kdtEntry_ccRate_TextField);
        this.kdtEntry.getColumn("ccRate").setEditor(kdtEntry_ccRate_CellEditor);
        KDTextField kdtEntry_remark_TextField = new KDTextField();
        kdtEntry_remark_TextField.setName("kdtEntry_remark_TextField");
        kdtEntry_remark_TextField.setMaxLength(200);
        KDTDefaultCellEditor kdtEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtEntry_remark_TextField);
        this.kdtEntry.getColumn("remark").setEditor(kdtEntry_remark_CellEditor);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // productType		
        this.productType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.ProductType").toArray());		
        this.productType.setRequired(true);		
        this.productType.setVisible(false);
        // txtGrossWeight		
        this.txtGrossWeight.setVisible(true);		
        this.txtGrossWeight.setHorizontalAlignment(2);		
        this.txtGrossWeight.setDataType(1);		
        this.txtGrossWeight.setSupportedEmpty(true);		
        this.txtGrossWeight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossWeight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossWeight.setPrecision(4);		
        this.txtGrossWeight.setRequired(false);
        // btnGetData
        this.btnGetData.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetData, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGetData.setText(resHelper.getString("btnGetData.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,billStatus,txtslaughterAmt,txtGrossChickenCost,txttodayNetProfit,txtallMoney,txtmainPrice,txtvicePrice,prmtcompany,txtallPeople,txtattendancePeople,txtworkTime,txtperCatipaEfficiency,txttonPrice,txtratioConstant,txtmainProductQty,txtotherProductQty,txtmainProductAmt,txtotherProductAmt,txtsuetQty,txtheadQty,txtbyProductQty,txtbyProductAmt,productType,txtwaterAbsorption,kdtEntry,txtoffduty,txtLeavenumber,txtzjf,txtzcf,txtcailiao,txtzulengku,txtotherpay,txtchaochanfei,txtGrossWeight}));
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
        this.setBounds(new Rectangle(0, 0, 1217, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1217, 629));
        contCreator.setBounds(new Rectangle(318, 557, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(318, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(318, 586, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(318, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(617, 557, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(617, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(617, 586, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(617, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(14, 17, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(14, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(917, 557, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(917, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(19, 557, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(19, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(19, 586, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(19, 586, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(917, 17, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(917, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contslaughterAmt.setBounds(new Rectangle(16, 55, 270, 19));
        this.add(contslaughterAmt, new KDLayout.Constraints(16, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossChickenCost.setBounds(new Rectangle(316, 81, 270, 19));
        this.add(contGrossChickenCost, new KDLayout.Constraints(316, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttodayNetProfit.setBounds(new Rectangle(14, 82, 270, 19));
        this.add(conttodayNetProfit, new KDLayout.Constraints(14, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contwaterAbsorption.setBounds(new Rectangle(920, 106, 270, 19));
        this.add(contwaterAbsorption, new KDLayout.Constraints(920, 106, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(17, 44, 1190, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(17, 44, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallMoney.setBounds(new Rectangle(920, 53, 270, 19));
        this.add(contallMoney, new KDLayout.Constraints(920, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmainPrice.setBounds(new Rectangle(315, 55, 270, 19));
        this.add(contmainPrice, new KDLayout.Constraints(315, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvicePrice.setBounds(new Rectangle(616, 54, 270, 19));
        this.add(contvicePrice, new KDLayout.Constraints(616, 54, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator9.setBounds(new Rectangle(12, 139, 1190, 10));
        this.add(kDSeparator9, new KDLayout.Constraints(12, 139, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(445, 315, 1, 1));
        this.add(kDSeparator10, new KDLayout.Constraints(445, 315, 1, 1, 0));
        contcompany.setBounds(new Rectangle(315, 17, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(315, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonPrice.setBounds(new Rectangle(920, 79, 270, 19));
        this.add(conttonPrice, new KDLayout.Constraints(920, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator15.setBounds(new Rectangle(19, 543, 1190, 10));
        this.add(kDSeparator15, new KDLayout.Constraints(19, 543, 1190, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contratioConstant.setBounds(new Rectangle(14, 109, 270, 19));
        this.add(contratioConstant, new KDLayout.Constraints(14, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(9, 165, 1183, 368));
        this.add(kDTabbedPane1, new KDLayout.Constraints(9, 165, 1183, 368, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contproductType.setBounds(new Rectangle(616, 17, 270, 19));
        this.add(contproductType, new KDLayout.Constraints(616, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossWeight.setBounds(new Rectangle(616, 79, 270, 19));
        this.add(contGrossWeight, new KDLayout.Constraints(616, 79, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contslaughterAmt
        contslaughterAmt.setBoundEditor(txtslaughterAmt);
        //contGrossChickenCost
        contGrossChickenCost.setBoundEditor(txtGrossChickenCost);
        //conttodayNetProfit
        conttodayNetProfit.setBoundEditor(txttodayNetProfit);
        //contwaterAbsorption
        contwaterAbsorption.setBoundEditor(txtwaterAbsorption);
        //contallMoney
        contallMoney.setBoundEditor(txtallMoney);
        //contmainPrice
        contmainPrice.setBoundEditor(txtmainPrice);
        //contvicePrice
        contvicePrice.setBoundEditor(txtvicePrice);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //conttonPrice
        conttonPrice.setBoundEditor(txttonPrice);
        //contratioConstant
        contratioConstant.setBoundEditor(txtratioConstant);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPaneDetail, resHelper.getString("kDPaneDetail.constraints"));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 335));        contsuetQty.setBounds(new Rectangle(267, 41, 270, 19));
        kDPanel2.add(contsuetQty, new KDLayout.Constraints(267, 41, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheadQty.setBounds(new Rectangle(267, 11, 270, 19));
        kDPanel2.add(contheadQty, new KDLayout.Constraints(267, 11, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainProductQty.setBounds(new Rectangle(17, 11, 200, 19));
        kDPanel2.add(contmainProductQty, new KDLayout.Constraints(17, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainProductAmt.setBounds(new Rectangle(17, 41, 200, 19));
        kDPanel2.add(contmainProductAmt, new KDLayout.Constraints(17, 41, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyProductQty.setBounds(new Rectangle(17, 72, 200, 19));
        kDPanel2.add(contbyProductQty, new KDLayout.Constraints(17, 72, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyProductAmt.setBounds(new Rectangle(17, 106, 200, 19));
        kDPanel2.add(contbyProductAmt, new KDLayout.Constraints(17, 106, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchaochanfei.setBounds(new Rectangle(612, 157, 270, 19));
        kDPanel2.add(contchaochanfei, new KDLayout.Constraints(612, 157, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contotherpay.setBounds(new Rectangle(612, 125, 270, 19));
        kDPanel2.add(contotherpay, new KDLayout.Constraints(612, 125, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contzulengku.setBounds(new Rectangle(611, 94, 270, 19));
        kDPanel2.add(contzulengku, new KDLayout.Constraints(611, 94, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcailiao.setBounds(new Rectangle(611, 65, 270, 19));
        kDPanel2.add(contcailiao, new KDLayout.Constraints(611, 65, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contzcf.setBounds(new Rectangle(611, 37, 270, 19));
        kDPanel2.add(contzcf, new KDLayout.Constraints(611, 37, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contzjf.setBounds(new Rectangle(610, 8, 270, 19));
        kDPanel2.add(contzjf, new KDLayout.Constraints(610, 8, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contsuetQty
        contsuetQty.setBoundEditor(txtsuetQty);
        //contheadQty
        contheadQty.setBoundEditor(txtheadQty);
        //contmainProductQty
        contmainProductQty.setBoundEditor(txtmainProductQty);
        //contmainProductAmt
        contmainProductAmt.setBoundEditor(txtmainProductAmt);
        //contbyProductQty
        contbyProductQty.setBoundEditor(txtbyProductQty);
        //contbyProductAmt
        contbyProductAmt.setBoundEditor(txtbyProductAmt);
        //contchaochanfei
        contchaochanfei.setBoundEditor(txtchaochanfei);
        //contotherpay
        contotherpay.setBoundEditor(txtotherpay);
        //contzulengku
        contzulengku.setBoundEditor(txtzulengku);
        //contcailiao
        contcailiao.setBoundEditor(txtcailiao);
        //contzcf
        contzcf.setBoundEditor(txtzcf);
        //contzjf
        contzjf.setBoundEditor(txtzjf);
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 335));        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 335));        contperCatipaEfficiency.setBounds(new Rectangle(905, 24, 270, 19));
        kDPanel3.add(contperCatipaEfficiency, new KDLayout.Constraints(905, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contworkTime.setBounds(new Rectangle(605, 24, 270, 19));
        kDPanel3.add(contworkTime, new KDLayout.Constraints(605, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contattendancePeople.setBounds(new Rectangle(306, 24, 270, 19));
        kDPanel3.add(contattendancePeople, new KDLayout.Constraints(306, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallPeople.setBounds(new Rectangle(7, 24, 270, 19));
        kDPanel3.add(contallPeople, new KDLayout.Constraints(7, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(468, 97, 874, 198));
        kDPanel3.add(kDPanel1, new KDLayout.Constraints(468, 97, 874, 198, 0));
        contLeavenumber.setBounds(new Rectangle(905, 52, 270, 19));
        kDPanel3.add(contLeavenumber, new KDLayout.Constraints(905, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contoffduty.setBounds(new Rectangle(6, 86, 270, 19));
        kDPanel3.add(contoffduty, new KDLayout.Constraints(6, 86, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contperCatipaEfficiency
        contperCatipaEfficiency.setBoundEditor(txtperCatipaEfficiency);
        //contworkTime
        contworkTime.setBoundEditor(txtworkTime);
        //contattendancePeople
        contattendancePeople.setBoundEditor(txtattendancePeople);
        //contallPeople
        contallPeople.setBoundEditor(txtallPeople);
        //kDPanel1
        kDPanel1.setLayout(null);        contNumber.setBounds(new Rectangle(20, 51, 270, 19));
        kDPanel1.add(contNumber, null);
        contotherProductQty.setBounds(new Rectangle(274, 8, 270, 19));
        kDPanel1.add(contotherProductQty, null);
        contotherProductAmt.setBounds(new Rectangle(278, 34, 270, 19));
        kDPanel1.add(contotherProductAmt, null);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contotherProductQty
        contotherProductQty.setBoundEditor(txtotherProductQty);
        //contotherProductAmt
        contotherProductAmt.setBoundEditor(txtotherProductAmt);
        //contLeavenumber
        contLeavenumber.setBoundEditor(txtLeavenumber);
        //contoffduty
        contoffduty.setBoundEditor(txtoffduty);
        //kDPaneDetail
        kDPaneDetail.setLayout(new KDLayout());
        kDPaneDetail.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 335));        kdtEntry.setBounds(new Rectangle(0, 32, 1175, 300));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.dx.baseset.FoodDailyEntryInfo(),null,false);
        kDPaneDetail.add(kdtEntry_detailPanel, new KDLayout.Constraints(0, 32, 1175, 300, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel1.setBounds(new Rectangle(7, 8, 465, 19));
        kDPaneDetail.add(kDLabel1, new KDLayout.Constraints(7, 8, 465, 19, 0));
        //contproductType
        contproductType.setBoundEditor(productType);
        //contGrossWeight
        contGrossWeight.setBoundEditor(txtGrossWeight);

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
        this.toolBar.add(btnGetData);
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
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnDelPCVoucher);
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
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("slaughterAmt", int.class, this.txtslaughterAmt, "value");
		dataBinder.registerBinding("GrossChickenCost", java.math.BigDecimal.class, this.txtGrossChickenCost, "value");
		dataBinder.registerBinding("todayNetProfit", java.math.BigDecimal.class, this.txttodayNetProfit, "value");
		dataBinder.registerBinding("waterAbsorption", java.math.BigDecimal.class, this.txtwaterAbsorption, "value");
		dataBinder.registerBinding("allMoney", java.math.BigDecimal.class, this.txtallMoney, "value");
		dataBinder.registerBinding("mainPrice", java.math.BigDecimal.class, this.txtmainPrice, "value");
		dataBinder.registerBinding("vicePrice", java.math.BigDecimal.class, this.txtvicePrice, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("tonPrice", java.math.BigDecimal.class, this.txttonPrice, "value");
		dataBinder.registerBinding("ratioConstant", java.math.BigDecimal.class, this.txtratioConstant, "value");
		dataBinder.registerBinding("suetQty", java.math.BigDecimal.class, this.txtsuetQty, "value");
		dataBinder.registerBinding("headQty", java.math.BigDecimal.class, this.txtheadQty, "value");
		dataBinder.registerBinding("mainProductQty", java.math.BigDecimal.class, this.txtmainProductQty, "value");
		dataBinder.registerBinding("mainProductAmt", java.math.BigDecimal.class, this.txtmainProductAmt, "value");
		dataBinder.registerBinding("byProductQty", java.math.BigDecimal.class, this.txtbyProductQty, "value");
		dataBinder.registerBinding("byProductAmt", java.math.BigDecimal.class, this.txtbyProductAmt, "value");
		dataBinder.registerBinding("chaochanfei", java.math.BigDecimal.class, this.txtchaochanfei, "value");
		dataBinder.registerBinding("otherpay", java.math.BigDecimal.class, this.txtotherpay, "value");
		dataBinder.registerBinding("zulengku", java.math.BigDecimal.class, this.txtzulengku, "value");
		dataBinder.registerBinding("cailiao", java.math.BigDecimal.class, this.txtcailiao, "value");
		dataBinder.registerBinding("zcf", java.math.BigDecimal.class, this.txtzcf, "value");
		dataBinder.registerBinding("zjf", java.math.BigDecimal.class, this.txtzjf, "value");
		dataBinder.registerBinding("perCatipaEfficiency", java.math.BigDecimal.class, this.txtperCatipaEfficiency, "value");
		dataBinder.registerBinding("workTime", java.math.BigDecimal.class, this.txtworkTime, "value");
		dataBinder.registerBinding("attendancePeople", int.class, this.txtattendancePeople, "value");
		dataBinder.registerBinding("allPeople", int.class, this.txtallPeople, "value");
		dataBinder.registerBinding("otherProductQty", java.math.BigDecimal.class, this.txtotherProductQty, "value");
		dataBinder.registerBinding("otherProductAmt", java.math.BigDecimal.class, this.txtotherProductAmt, "value");
		dataBinder.registerBinding("Leavenumber", int.class, this.txtLeavenumber, "value");
		dataBinder.registerBinding("offduty", int.class, this.txtoffduty, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.dx.baseset.FoodDailyEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.materialNum", java.lang.Object.class, this.kdtEntry, "materialNum.text");
		dataBinder.registerBinding("Entry.materialName", String.class, this.kdtEntry, "materialName.text");
		dataBinder.registerBinding("Entry.model", String.class, this.kdtEntry, "model.text");
		dataBinder.registerBinding("Entry.materialGroup", java.lang.Object.class, this.kdtEntry, "materialGroup.text");
		dataBinder.registerBinding("Entry.qty", java.math.BigDecimal.class, this.kdtEntry, "qty.text");
		dataBinder.registerBinding("Entry.price", java.math.BigDecimal.class, this.kdtEntry, "price.text");
		dataBinder.registerBinding("Entry.amount", java.math.BigDecimal.class, this.kdtEntry, "amount.text");
		dataBinder.registerBinding("Entry.remark", String.class, this.kdtEntry, "remark.text");
		dataBinder.registerBinding("Entry.ccRate", java.math.BigDecimal.class, this.kdtEntry, "ccRate.text");
		dataBinder.registerBinding("productType", com.kingdee.eas.custom.szcount.ProductType.class, this.productType, "selectedItem");
		dataBinder.registerBinding("GrossWeight", java.math.BigDecimal.class, this.txtGrossWeight, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.baseset.app.FoodDailyEditUIHandler";
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
        this.editData = (com.kingdee.eas.custom.dx.baseset.FoodDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("slaughterAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossChickenCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("todayNetProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("waterAbsorption", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vicePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioConstant", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("headQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chaochanfei", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherpay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zulengku", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cailiao", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zcf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("zjf", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perCatipaEfficiency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendancePeople", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allPeople", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Leavenumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("offduty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.amount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.ccRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("productType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossWeight", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("materialNum".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"materialNum").getValue(),"name")));

}

    if ("qty".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"qty").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"price").getValue())));

}

    if ("qty".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"ccRate").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal((com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"qty").getValue())/ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtGrossWeight.getValue()))* 100));

}

    if ("price".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"amount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"price").getValue())* com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"qty").getValue())));

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
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("slaughterAmt"));
        sic.add(new SelectorItemInfo("GrossChickenCost"));
        sic.add(new SelectorItemInfo("todayNetProfit"));
        sic.add(new SelectorItemInfo("waterAbsorption"));
        sic.add(new SelectorItemInfo("allMoney"));
        sic.add(new SelectorItemInfo("mainPrice"));
        sic.add(new SelectorItemInfo("vicePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("tonPrice"));
        sic.add(new SelectorItemInfo("ratioConstant"));
        sic.add(new SelectorItemInfo("suetQty"));
        sic.add(new SelectorItemInfo("headQty"));
        sic.add(new SelectorItemInfo("mainProductQty"));
        sic.add(new SelectorItemInfo("mainProductAmt"));
        sic.add(new SelectorItemInfo("byProductQty"));
        sic.add(new SelectorItemInfo("byProductAmt"));
        sic.add(new SelectorItemInfo("chaochanfei"));
        sic.add(new SelectorItemInfo("otherpay"));
        sic.add(new SelectorItemInfo("zulengku"));
        sic.add(new SelectorItemInfo("cailiao"));
        sic.add(new SelectorItemInfo("zcf"));
        sic.add(new SelectorItemInfo("zjf"));
        sic.add(new SelectorItemInfo("perCatipaEfficiency"));
        sic.add(new SelectorItemInfo("workTime"));
        sic.add(new SelectorItemInfo("attendancePeople"));
        sic.add(new SelectorItemInfo("allPeople"));
        sic.add(new SelectorItemInfo("otherProductQty"));
        sic.add(new SelectorItemInfo("otherProductAmt"));
        sic.add(new SelectorItemInfo("Leavenumber"));
        sic.add(new SelectorItemInfo("offduty"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.materialNum.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.materialNum.id"));
			sic.add(new SelectorItemInfo("Entry.materialNum.number"));
			sic.add(new SelectorItemInfo("Entry.materialNum.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.materialName"));
    	sic.add(new SelectorItemInfo("Entry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.materialGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.materialGroup.id"));
			sic.add(new SelectorItemInfo("Entry.materialGroup.name"));
        	sic.add(new SelectorItemInfo("Entry.materialGroup.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.qty"));
    	sic.add(new SelectorItemInfo("Entry.price"));
    	sic.add(new SelectorItemInfo("Entry.amount"));
    	sic.add(new SelectorItemInfo("Entry.remark"));
    	sic.add(new SelectorItemInfo("Entry.ccRate"));
        sic.add(new SelectorItemInfo("productType"));
        sic.add(new SelectorItemInfo("GrossWeight"));
        return sic;
    }        
    	

    /**
     * output actionGetData_actionPerformed method
     */
    public void actionGetData_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.dx.baseset.FoodDailyFactory.getRemoteInstance().getData(editData);
    }
	public RequestContext prepareActionGetData(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionGetData() {
    	return false;
    }

    /**
     * output ActionGetData class
     */     
    protected class ActionGetData extends ItemAction {     
    
        public ActionGetData()
        {
            this(null);
        }

        public ActionGetData(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionGetData.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetData.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionGetData.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractFoodDailyEditUI.this, "ActionGetData", "actionGetData_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.dx.baseset.client", "FoodDailyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.dx.baseset.client.FoodDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.baseset.FoodDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.baseset.FoodDailyInfo objectValue = new com.kingdee.eas.custom.dx.baseset.FoodDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/baseset/FoodDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.baseset.app.FoodDailyQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(productType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"产品类型"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("productType",new Integer(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}        
				protected void setTableToSumField() {
			setTableToSumField(kdtEntry,new String[] {"qty","amount"});
		}


}