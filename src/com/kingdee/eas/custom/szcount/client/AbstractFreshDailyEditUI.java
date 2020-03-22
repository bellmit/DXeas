/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

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
public abstract class AbstractFreshDailyEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFreshDailyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contslaughterAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuyFreight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuyMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossChickenCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementCarcass;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsettlementGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossChickenAPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcommodityChickenAPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcommodityChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmarketChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmallChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttodayNetProfit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarcassSCWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contwaterAbsorption;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainDivisionRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contviceRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contvicePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfinishedProductWgt;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator9;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomprehensiveRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdivisionRatio;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcomprehensivePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossChickenAWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthalfAPackProduct;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonPrice;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contratioConstant;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproductType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contShedBLossGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtslaughterAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbuyFreight;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbuyMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossChickenCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettlementCarcass;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsettlementGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossChickenAPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcommodityChickenAPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonGrossProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcommodityChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmarketChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmallChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttodayNetProfit;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCarcassSCWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtwaterAbsorption;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtallMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainDivisionRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtviceRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtvicePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfinishedProductWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassRatio;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomprehensiveRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdivisionRatio;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcomprehensivePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossChickenAWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthalfAPackProduct;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtratioConstant;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPaneDetail;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenPeatherPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenPeatherMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenBloodMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenBloodPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenIntestineMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenIntestinePrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenCropMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenCropPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmixedOilPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmixedOilMoney;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbackAreaLeafFatYield;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsuetQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contResidualChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarcassRCWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contResidualChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contheadQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainProductQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmainProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyProductQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbyProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenPeatherPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenPeatherMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenBloodMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenBloodPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenIntestineMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenIntestinePrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenCropMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenCropPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmixedOilPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmixedOilMoney;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbackAreaLeafFatYield;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsuetQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtResidualChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCarcassRCWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtResidualChickenAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtheadQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainProductQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmainProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyProductQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbyProductAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonProductWater;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonAllEle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonProductCoal;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonPackingCost;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonProductColdEle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttonProductionEle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonProductWater;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonAllEle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonProductCoal;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonPackingCost;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonProductColdEle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttonProductionEle;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperCatipaEfficiency;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contattendancePeople;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallPeople;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhalfWorkDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmorningQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contafternoonQty;
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
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmorningQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtafternoonQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtLeavenumber;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoffduty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox productType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtShedBLossGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnGetData;
    protected com.kingdee.eas.custom.szcount.FreshDailyInfo editData = null;
    protected ActionGetData actionGetData = null;
    /**
     * output class constructor
     */
    public AbstractFreshDailyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFreshDailyEditUI.class.getName());
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
        this.contbuyFreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuyMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossChickenCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementCarcass = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsettlementGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossChickenAPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcommodityChickenAPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonGrossProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcommodityChickenAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmarketChickenAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmallChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttodayNetProfit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarcassSCWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contwaterAbsorption = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator8 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contallMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainDivisionRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contviceRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contvicePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfinishedProductWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator9 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator10 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcarcassRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomprehensiveRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdivisionRatio = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcomprehensivePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossChickenAWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthalfAPackProduct = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator15 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contratioConstant = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contproductType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contShedBLossGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtslaughterAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbuyFreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbuyMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcostPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossChickenCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettlementCarcass = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsettlementGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarketPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossChickenAPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcommodityChickenAPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonGrossProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcommodityChickenAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmarketChickenAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmallChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttodayNetProfit = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCarcassSCWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtwaterAbsorption = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtallMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainDivisionRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtviceRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtvicePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfinishedProductWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcarcassRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcomprehensiveRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdivisionRatio = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcomprehensivePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossChickenAWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthalfAPackProduct = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtratioConstant = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPaneDetail = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contchickenPeatherPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenPeatherMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenBloodMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenBloodPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenIntestineMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenIntestinePrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenCropMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenCropPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmixedOilPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmixedOilMoney = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbackAreaLeafFatYield = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsuetQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contResidualChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarcassRCWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contResidualChickenAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contheadQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainProductQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmainProductAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyProductQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbyProductAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtchickenPeatherPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenPeatherMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenBloodMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenBloodPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenIntestineMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenIntestinePrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenCropMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenCropPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmixedOilPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmixedOilMoney = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbackAreaLeafFatYield = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsuetQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtResidualChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCarcassRCWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtResidualChickenAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtheadQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainProductQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtmainProductAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyProductQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbyProductAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.conttonProductWater = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonAllEle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonProductCoal = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonPackingCost = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonProductColdEle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttonProductionEle = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txttonProductWater = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonAllEle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonProductCoal = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonPackingCost = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonProductColdEle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttonProductionEle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contperCatipaEfficiency = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contattendancePeople = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallPeople = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.chkhalfWorkDay = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contmorningQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contafternoonQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
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
        this.txtmorningQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtafternoonQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtLeavenumber = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoffduty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.productType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtShedBLossGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.btnGetData = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contslaughterAmt.setName("contslaughterAmt");
        this.contbuyFreight.setName("contbuyFreight");
        this.contbuyMoney.setName("contbuyMoney");
        this.contcostPrice.setName("contcostPrice");
        this.contGrossChickenCost.setName("contGrossChickenCost");
        this.contsettlementCarcass.setName("contsettlementCarcass");
        this.contsettlementGrossWgt.setName("contsettlementGrossWgt");
        this.contmarketPrice.setName("contmarketPrice");
        this.contGrossChickenAPrice.setName("contGrossChickenAPrice");
        this.contcommodityChickenAPrice.setName("contcommodityChickenAPrice");
        this.conttonGrossProfit.setName("conttonGrossProfit");
        this.contcommodityChickenAmt.setName("contcommodityChickenAmt");
        this.contmarketChickenAmt.setName("contmarketChickenAmt");
        this.contSmallChickenWgt.setName("contSmallChickenWgt");
        this.conttodayNetProfit.setName("conttodayNetProfit");
        this.contCarcassSCWgt.setName("contCarcassSCWgt");
        this.contallGrossWgt.setName("contallGrossWgt");
        this.contwaterAbsorption.setName("contwaterAbsorption");
        this.kDSeparator8.setName("kDSeparator8");
        this.contallMoney.setName("contallMoney");
        this.contmainRatio.setName("contmainRatio");
        this.contmainDivisionRatio.setName("contmainDivisionRatio");
        this.contviceRatio.setName("contviceRatio");
        this.contmainPrice.setName("contmainPrice");
        this.contvicePrice.setName("contvicePrice");
        this.contfinishedProductWgt.setName("contfinishedProductWgt");
        this.kDSeparator9.setName("kDSeparator9");
        this.kDSeparator10.setName("kDSeparator10");
        this.contcarcassRatio.setName("contcarcassRatio");
        this.contcompany.setName("contcompany");
        this.contcomprehensiveRatio.setName("contcomprehensiveRatio");
        this.contdivisionRatio.setName("contdivisionRatio");
        this.contcomprehensivePrice.setName("contcomprehensivePrice");
        this.contGrossChickenAWgt.setName("contGrossChickenAWgt");
        this.conthalfAPackProduct.setName("conthalfAPackProduct");
        this.conttonPrice.setName("conttonPrice");
        this.kDSeparator15.setName("kDSeparator15");
        this.contratioConstant.setName("contratioConstant");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contproductType.setName("contproductType");
        this.contShedBLossGrossWgt.setName("contShedBLossGrossWgt");
        this.txtslaughterAmt.setName("txtslaughterAmt");
        this.txtbuyFreight.setName("txtbuyFreight");
        this.txtbuyMoney.setName("txtbuyMoney");
        this.txtcostPrice.setName("txtcostPrice");
        this.txtGrossChickenCost.setName("txtGrossChickenCost");
        this.txtsettlementCarcass.setName("txtsettlementCarcass");
        this.txtsettlementGrossWgt.setName("txtsettlementGrossWgt");
        this.txtmarketPrice.setName("txtmarketPrice");
        this.txtGrossChickenAPrice.setName("txtGrossChickenAPrice");
        this.txtcommodityChickenAPrice.setName("txtcommodityChickenAPrice");
        this.txttonGrossProfit.setName("txttonGrossProfit");
        this.txtcommodityChickenAmt.setName("txtcommodityChickenAmt");
        this.txtmarketChickenAmt.setName("txtmarketChickenAmt");
        this.txtSmallChickenWgt.setName("txtSmallChickenWgt");
        this.txttodayNetProfit.setName("txttodayNetProfit");
        this.txtCarcassSCWgt.setName("txtCarcassSCWgt");
        this.txtallGrossWgt.setName("txtallGrossWgt");
        this.txtwaterAbsorption.setName("txtwaterAbsorption");
        this.txtallMoney.setName("txtallMoney");
        this.txtmainRatio.setName("txtmainRatio");
        this.txtmainDivisionRatio.setName("txtmainDivisionRatio");
        this.txtviceRatio.setName("txtviceRatio");
        this.txtmainPrice.setName("txtmainPrice");
        this.txtvicePrice.setName("txtvicePrice");
        this.txtfinishedProductWgt.setName("txtfinishedProductWgt");
        this.txtcarcassRatio.setName("txtcarcassRatio");
        this.prmtcompany.setName("prmtcompany");
        this.txtcomprehensiveRatio.setName("txtcomprehensiveRatio");
        this.txtdivisionRatio.setName("txtdivisionRatio");
        this.txtcomprehensivePrice.setName("txtcomprehensivePrice");
        this.txtGrossChickenAWgt.setName("txtGrossChickenAWgt");
        this.txthalfAPackProduct.setName("txthalfAPackProduct");
        this.txttonPrice.setName("txttonPrice");
        this.txtratioConstant.setName("txtratioConstant");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel3.setName("kDPanel3");
        this.kDPaneDetail.setName("kDPaneDetail");
        this.contchickenPeatherPrice.setName("contchickenPeatherPrice");
        this.contchickenPeatherMoney.setName("contchickenPeatherMoney");
        this.contchickenBloodMoney.setName("contchickenBloodMoney");
        this.contchickenBloodPrice.setName("contchickenBloodPrice");
        this.contchickenIntestineMoney.setName("contchickenIntestineMoney");
        this.contchickenIntestinePrice.setName("contchickenIntestinePrice");
        this.contchickenCropMoney.setName("contchickenCropMoney");
        this.contchickenCropPrice.setName("contchickenCropPrice");
        this.contmixedOilPrice.setName("contmixedOilPrice");
        this.contmixedOilMoney.setName("contmixedOilMoney");
        this.contbackAreaLeafFatYield.setName("contbackAreaLeafFatYield");
        this.contsuetQty.setName("contsuetQty");
        this.contResidualChickenWgt.setName("contResidualChickenWgt");
        this.contCarcassRCWgt.setName("contCarcassRCWgt");
        this.contResidualChickenAmt.setName("contResidualChickenAmt");
        this.contheadQty.setName("contheadQty");
        this.contmainProductQty.setName("contmainProductQty");
        this.contmainProductAmt.setName("contmainProductAmt");
        this.contbyProductQty.setName("contbyProductQty");
        this.contbyProductAmt.setName("contbyProductAmt");
        this.txtchickenPeatherPrice.setName("txtchickenPeatherPrice");
        this.txtchickenPeatherMoney.setName("txtchickenPeatherMoney");
        this.txtchickenBloodMoney.setName("txtchickenBloodMoney");
        this.txtchickenBloodPrice.setName("txtchickenBloodPrice");
        this.txtchickenIntestineMoney.setName("txtchickenIntestineMoney");
        this.txtchickenIntestinePrice.setName("txtchickenIntestinePrice");
        this.txtchickenCropMoney.setName("txtchickenCropMoney");
        this.txtchickenCropPrice.setName("txtchickenCropPrice");
        this.txtmixedOilPrice.setName("txtmixedOilPrice");
        this.txtmixedOilMoney.setName("txtmixedOilMoney");
        this.txtbackAreaLeafFatYield.setName("txtbackAreaLeafFatYield");
        this.txtsuetQty.setName("txtsuetQty");
        this.txtResidualChickenWgt.setName("txtResidualChickenWgt");
        this.txtCarcassRCWgt.setName("txtCarcassRCWgt");
        this.txtResidualChickenAmt.setName("txtResidualChickenAmt");
        this.txtheadQty.setName("txtheadQty");
        this.txtmainProductQty.setName("txtmainProductQty");
        this.txtmainProductAmt.setName("txtmainProductAmt");
        this.txtbyProductQty.setName("txtbyProductQty");
        this.txtbyProductAmt.setName("txtbyProductAmt");
        this.conttonProductWater.setName("conttonProductWater");
        this.conttonAllEle.setName("conttonAllEle");
        this.conttonProductCoal.setName("conttonProductCoal");
        this.conttonPackingCost.setName("conttonPackingCost");
        this.conttonProductColdEle.setName("conttonProductColdEle");
        this.conttonProductionEle.setName("conttonProductionEle");
        this.txttonProductWater.setName("txttonProductWater");
        this.txttonAllEle.setName("txttonAllEle");
        this.txttonProductCoal.setName("txttonProductCoal");
        this.txttonPackingCost.setName("txttonPackingCost");
        this.txttonProductColdEle.setName("txttonProductColdEle");
        this.txttonProductionEle.setName("txttonProductionEle");
        this.contperCatipaEfficiency.setName("contperCatipaEfficiency");
        this.contworkTime.setName("contworkTime");
        this.contattendancePeople.setName("contattendancePeople");
        this.contallPeople.setName("contallPeople");
        this.kDPanel1.setName("kDPanel1");
        this.chkhalfWorkDay.setName("chkhalfWorkDay");
        this.contmorningQty.setName("contmorningQty");
        this.contafternoonQty.setName("contafternoonQty");
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
        this.txtmorningQty.setName("txtmorningQty");
        this.txtafternoonQty.setName("txtafternoonQty");
        this.txtLeavenumber.setName("txtLeavenumber");
        this.txtoffduty.setName("txtoffduty");
        this.kdtEntry.setName("kdtEntry");
        this.productType.setName("productType");
        this.txtShedBLossGrossWgt.setName("txtShedBLossGrossWgt");
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
        // contbuyFreight		
        this.contbuyFreight.setBoundLabelText(resHelper.getString("contbuyFreight.boundLabelText"));		
        this.contbuyFreight.setBoundLabelLength(100);		
        this.contbuyFreight.setBoundLabelUnderline(true);		
        this.contbuyFreight.setVisible(true);
        // contbuyMoney		
        this.contbuyMoney.setBoundLabelText(resHelper.getString("contbuyMoney.boundLabelText"));		
        this.contbuyMoney.setBoundLabelLength(100);		
        this.contbuyMoney.setBoundLabelUnderline(true);		
        this.contbuyMoney.setVisible(true);
        // contcostPrice		
        this.contcostPrice.setBoundLabelText(resHelper.getString("contcostPrice.boundLabelText"));		
        this.contcostPrice.setBoundLabelLength(100);		
        this.contcostPrice.setBoundLabelUnderline(true);		
        this.contcostPrice.setVisible(true);
        // contGrossChickenCost		
        this.contGrossChickenCost.setBoundLabelText(resHelper.getString("contGrossChickenCost.boundLabelText"));		
        this.contGrossChickenCost.setBoundLabelLength(100);		
        this.contGrossChickenCost.setBoundLabelUnderline(true);		
        this.contGrossChickenCost.setVisible(true);
        // contsettlementCarcass		
        this.contsettlementCarcass.setBoundLabelText(resHelper.getString("contsettlementCarcass.boundLabelText"));		
        this.contsettlementCarcass.setBoundLabelLength(100);		
        this.contsettlementCarcass.setBoundLabelUnderline(true);		
        this.contsettlementCarcass.setVisible(true);
        // contsettlementGrossWgt		
        this.contsettlementGrossWgt.setBoundLabelText(resHelper.getString("contsettlementGrossWgt.boundLabelText"));		
        this.contsettlementGrossWgt.setBoundLabelLength(100);		
        this.contsettlementGrossWgt.setBoundLabelUnderline(true);		
        this.contsettlementGrossWgt.setVisible(true);
        // contmarketPrice		
        this.contmarketPrice.setBoundLabelText(resHelper.getString("contmarketPrice.boundLabelText"));		
        this.contmarketPrice.setBoundLabelLength(100);		
        this.contmarketPrice.setBoundLabelUnderline(true);		
        this.contmarketPrice.setVisible(true);
        // contGrossChickenAPrice		
        this.contGrossChickenAPrice.setBoundLabelText(resHelper.getString("contGrossChickenAPrice.boundLabelText"));		
        this.contGrossChickenAPrice.setBoundLabelLength(100);		
        this.contGrossChickenAPrice.setBoundLabelUnderline(true);		
        this.contGrossChickenAPrice.setVisible(true);
        // contcommodityChickenAPrice		
        this.contcommodityChickenAPrice.setBoundLabelText(resHelper.getString("contcommodityChickenAPrice.boundLabelText"));		
        this.contcommodityChickenAPrice.setBoundLabelLength(100);		
        this.contcommodityChickenAPrice.setBoundLabelUnderline(true);		
        this.contcommodityChickenAPrice.setVisible(true);
        // conttonGrossProfit		
        this.conttonGrossProfit.setBoundLabelText(resHelper.getString("conttonGrossProfit.boundLabelText"));		
        this.conttonGrossProfit.setBoundLabelLength(100);		
        this.conttonGrossProfit.setBoundLabelUnderline(true);		
        this.conttonGrossProfit.setVisible(true);
        // contcommodityChickenAmt		
        this.contcommodityChickenAmt.setBoundLabelText(resHelper.getString("contcommodityChickenAmt.boundLabelText"));		
        this.contcommodityChickenAmt.setBoundLabelLength(100);		
        this.contcommodityChickenAmt.setBoundLabelUnderline(true);		
        this.contcommodityChickenAmt.setVisible(true);
        // contmarketChickenAmt		
        this.contmarketChickenAmt.setBoundLabelText(resHelper.getString("contmarketChickenAmt.boundLabelText"));		
        this.contmarketChickenAmt.setBoundLabelLength(100);		
        this.contmarketChickenAmt.setBoundLabelUnderline(true);		
        this.contmarketChickenAmt.setVisible(true);
        // contSmallChickenWgt		
        this.contSmallChickenWgt.setBoundLabelText(resHelper.getString("contSmallChickenWgt.boundLabelText"));		
        this.contSmallChickenWgt.setBoundLabelLength(100);		
        this.contSmallChickenWgt.setBoundLabelUnderline(true);		
        this.contSmallChickenWgt.setVisible(true);
        // conttodayNetProfit		
        this.conttodayNetProfit.setBoundLabelText(resHelper.getString("conttodayNetProfit.boundLabelText"));		
        this.conttodayNetProfit.setBoundLabelLength(100);		
        this.conttodayNetProfit.setBoundLabelUnderline(true);		
        this.conttodayNetProfit.setVisible(true);
        // contCarcassSCWgt		
        this.contCarcassSCWgt.setBoundLabelText(resHelper.getString("contCarcassSCWgt.boundLabelText"));		
        this.contCarcassSCWgt.setBoundLabelLength(150);		
        this.contCarcassSCWgt.setBoundLabelUnderline(true);		
        this.contCarcassSCWgt.setVisible(true);
        // contallGrossWgt		
        this.contallGrossWgt.setBoundLabelText(resHelper.getString("contallGrossWgt.boundLabelText"));		
        this.contallGrossWgt.setBoundLabelLength(100);		
        this.contallGrossWgt.setBoundLabelUnderline(true);		
        this.contallGrossWgt.setVisible(true);
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
        // contmainRatio		
        this.contmainRatio.setBoundLabelText(resHelper.getString("contmainRatio.boundLabelText"));		
        this.contmainRatio.setBoundLabelLength(100);		
        this.contmainRatio.setBoundLabelUnderline(true);		
        this.contmainRatio.setVisible(true);
        // contmainDivisionRatio		
        this.contmainDivisionRatio.setBoundLabelText(resHelper.getString("contmainDivisionRatio.boundLabelText"));		
        this.contmainDivisionRatio.setBoundLabelLength(100);		
        this.contmainDivisionRatio.setBoundLabelUnderline(true);		
        this.contmainDivisionRatio.setVisible(true);
        // contviceRatio		
        this.contviceRatio.setBoundLabelText(resHelper.getString("contviceRatio.boundLabelText"));		
        this.contviceRatio.setBoundLabelLength(100);		
        this.contviceRatio.setBoundLabelUnderline(true);		
        this.contviceRatio.setVisible(true);
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
        // contfinishedProductWgt		
        this.contfinishedProductWgt.setBoundLabelText(resHelper.getString("contfinishedProductWgt.boundLabelText"));		
        this.contfinishedProductWgt.setBoundLabelLength(100);		
        this.contfinishedProductWgt.setBoundLabelUnderline(true);		
        this.contfinishedProductWgt.setVisible(true);
        // kDSeparator9
        // kDSeparator10
        // contcarcassRatio		
        this.contcarcassRatio.setBoundLabelText(resHelper.getString("contcarcassRatio.boundLabelText"));		
        this.contcarcassRatio.setBoundLabelLength(100);		
        this.contcarcassRatio.setBoundLabelUnderline(true);		
        this.contcarcassRatio.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contcomprehensiveRatio		
        this.contcomprehensiveRatio.setBoundLabelText(resHelper.getString("contcomprehensiveRatio.boundLabelText"));		
        this.contcomprehensiveRatio.setBoundLabelLength(100);		
        this.contcomprehensiveRatio.setBoundLabelUnderline(true);		
        this.contcomprehensiveRatio.setVisible(true);
        // contdivisionRatio		
        this.contdivisionRatio.setBoundLabelText(resHelper.getString("contdivisionRatio.boundLabelText"));		
        this.contdivisionRatio.setBoundLabelLength(100);		
        this.contdivisionRatio.setBoundLabelUnderline(true);		
        this.contdivisionRatio.setVisible(true);
        // contcomprehensivePrice		
        this.contcomprehensivePrice.setBoundLabelText(resHelper.getString("contcomprehensivePrice.boundLabelText"));		
        this.contcomprehensivePrice.setBoundLabelLength(100);		
        this.contcomprehensivePrice.setBoundLabelUnderline(true);		
        this.contcomprehensivePrice.setVisible(true);
        // contGrossChickenAWgt		
        this.contGrossChickenAWgt.setBoundLabelText(resHelper.getString("contGrossChickenAWgt.boundLabelText"));		
        this.contGrossChickenAWgt.setBoundLabelLength(100);		
        this.contGrossChickenAWgt.setBoundLabelUnderline(true);		
        this.contGrossChickenAWgt.setVisible(true);
        // conthalfAPackProduct		
        this.conthalfAPackProduct.setBoundLabelText(resHelper.getString("conthalfAPackProduct.boundLabelText"));		
        this.conthalfAPackProduct.setBoundLabelLength(100);		
        this.conthalfAPackProduct.setBoundLabelUnderline(true);		
        this.conthalfAPackProduct.setVisible(true);
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
        this.contproductType.setVisible(true);
        // contShedBLossGrossWgt		
        this.contShedBLossGrossWgt.setBoundLabelText(resHelper.getString("contShedBLossGrossWgt.boundLabelText"));		
        this.contShedBLossGrossWgt.setBoundLabelLength(100);		
        this.contShedBLossGrossWgt.setBoundLabelUnderline(true);		
        this.contShedBLossGrossWgt.setVisible(true);
        // txtslaughterAmt		
        this.txtslaughterAmt.setHorizontalAlignment(2);		
        this.txtslaughterAmt.setDataType(0);		
        this.txtslaughterAmt.setSupportedEmpty(true);		
        this.txtslaughterAmt.setRequired(false);		
        this.txtslaughterAmt.setEnabled(false);
        // txtbuyFreight		
        this.txtbuyFreight.setHorizontalAlignment(2);		
        this.txtbuyFreight.setDataType(1);		
        this.txtbuyFreight.setSupportedEmpty(true);		
        this.txtbuyFreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbuyFreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbuyFreight.setPrecision(2);		
        this.txtbuyFreight.setRequired(false);		
        this.txtbuyFreight.setEnabled(false);
        // txtbuyMoney		
        this.txtbuyMoney.setHorizontalAlignment(2);		
        this.txtbuyMoney.setDataType(1);		
        this.txtbuyMoney.setSupportedEmpty(true);		
        this.txtbuyMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbuyMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbuyMoney.setPrecision(2);		
        this.txtbuyMoney.setRequired(false);		
        this.txtbuyMoney.setEnabled(false);
        // txtcostPrice		
        this.txtcostPrice.setHorizontalAlignment(2);		
        this.txtcostPrice.setDataType(1);		
        this.txtcostPrice.setSupportedEmpty(true);		
        this.txtcostPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostPrice.setPrecision(4);		
        this.txtcostPrice.setRequired(false);		
        this.txtcostPrice.setEnabled(false);
        // txtGrossChickenCost		
        this.txtGrossChickenCost.setHorizontalAlignment(2);		
        this.txtGrossChickenCost.setDataType(1);		
        this.txtGrossChickenCost.setSupportedEmpty(true);		
        this.txtGrossChickenCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossChickenCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossChickenCost.setPrecision(2);		
        this.txtGrossChickenCost.setRequired(false);		
        this.txtGrossChickenCost.setEnabled(false);
        // txtsettlementCarcass		
        this.txtsettlementCarcass.setHorizontalAlignment(2);		
        this.txtsettlementCarcass.setDataType(1);		
        this.txtsettlementCarcass.setSupportedEmpty(true);		
        this.txtsettlementCarcass.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsettlementCarcass.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsettlementCarcass.setPrecision(4);		
        this.txtsettlementCarcass.setRequired(false);		
        this.txtsettlementCarcass.setEnabled(false);
        // txtsettlementGrossWgt		
        this.txtsettlementGrossWgt.setHorizontalAlignment(2);		
        this.txtsettlementGrossWgt.setDataType(1);		
        this.txtsettlementGrossWgt.setSupportedEmpty(true);		
        this.txtsettlementGrossWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsettlementGrossWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsettlementGrossWgt.setPrecision(4);		
        this.txtsettlementGrossWgt.setRequired(false);		
        this.txtsettlementGrossWgt.setEnabled(false);
        // txtmarketPrice		
        this.txtmarketPrice.setHorizontalAlignment(2);		
        this.txtmarketPrice.setDataType(1);		
        this.txtmarketPrice.setSupportedEmpty(true);		
        this.txtmarketPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketPrice.setPrecision(4);		
        this.txtmarketPrice.setRequired(false);		
        this.txtmarketPrice.setEnabled(false);
        // txtGrossChickenAPrice		
        this.txtGrossChickenAPrice.setHorizontalAlignment(2);		
        this.txtGrossChickenAPrice.setDataType(1);		
        this.txtGrossChickenAPrice.setSupportedEmpty(true);		
        this.txtGrossChickenAPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossChickenAPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossChickenAPrice.setPrecision(4);		
        this.txtGrossChickenAPrice.setRequired(false);		
        this.txtGrossChickenAPrice.setEnabled(false);
        // txtcommodityChickenAPrice		
        this.txtcommodityChickenAPrice.setHorizontalAlignment(2);		
        this.txtcommodityChickenAPrice.setDataType(1);		
        this.txtcommodityChickenAPrice.setSupportedEmpty(true);		
        this.txtcommodityChickenAPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcommodityChickenAPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcommodityChickenAPrice.setPrecision(4);		
        this.txtcommodityChickenAPrice.setRequired(false);		
        this.txtcommodityChickenAPrice.setEnabled(false);
        // txttonGrossProfit		
        this.txttonGrossProfit.setHorizontalAlignment(2);		
        this.txttonGrossProfit.setDataType(1);		
        this.txttonGrossProfit.setSupportedEmpty(true);		
        this.txttonGrossProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonGrossProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonGrossProfit.setPrecision(2);		
        this.txttonGrossProfit.setRequired(false);
        // txtcommodityChickenAmt		
        this.txtcommodityChickenAmt.setHorizontalAlignment(2);		
        this.txtcommodityChickenAmt.setDataType(1);		
        this.txtcommodityChickenAmt.setSupportedEmpty(true);		
        this.txtcommodityChickenAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcommodityChickenAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcommodityChickenAmt.setPrecision(4);		
        this.txtcommodityChickenAmt.setRequired(false);		
        this.txtcommodityChickenAmt.setEnabled(false);
        // txtmarketChickenAmt		
        this.txtmarketChickenAmt.setHorizontalAlignment(2);		
        this.txtmarketChickenAmt.setDataType(1);		
        this.txtmarketChickenAmt.setSupportedEmpty(true);		
        this.txtmarketChickenAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmarketChickenAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmarketChickenAmt.setPrecision(4);		
        this.txtmarketChickenAmt.setRequired(false);		
        this.txtmarketChickenAmt.setEnabled(false);
        // txtSmallChickenWgt		
        this.txtSmallChickenWgt.setHorizontalAlignment(2);		
        this.txtSmallChickenWgt.setDataType(1);		
        this.txtSmallChickenWgt.setSupportedEmpty(true);		
        this.txtSmallChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSmallChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSmallChickenWgt.setPrecision(4);		
        this.txtSmallChickenWgt.setRequired(false);		
        this.txtSmallChickenWgt.setEnabled(false);
        // txttodayNetProfit		
        this.txttodayNetProfit.setHorizontalAlignment(2);		
        this.txttodayNetProfit.setDataType(1);		
        this.txttodayNetProfit.setSupportedEmpty(true);		
        this.txttodayNetProfit.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttodayNetProfit.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttodayNetProfit.setPrecision(2);		
        this.txttodayNetProfit.setRequired(false);
        // txtCarcassSCWgt		
        this.txtCarcassSCWgt.setHorizontalAlignment(2);		
        this.txtCarcassSCWgt.setDataType(1);		
        this.txtCarcassSCWgt.setSupportedEmpty(true);		
        this.txtCarcassSCWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCarcassSCWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCarcassSCWgt.setPrecision(4);		
        this.txtCarcassSCWgt.setRequired(false);		
        this.txtCarcassSCWgt.setEnabled(false);
        // txtallGrossWgt		
        this.txtallGrossWgt.setHorizontalAlignment(2);		
        this.txtallGrossWgt.setDataType(1);		
        this.txtallGrossWgt.setSupportedEmpty(true);		
        this.txtallGrossWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtallGrossWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtallGrossWgt.setPrecision(4);		
        this.txtallGrossWgt.setRequired(false);		
        this.txtallGrossWgt.setEnabled(false);
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
        this.txtallMoney.setEnabled(false);
        // txtmainRatio		
        this.txtmainRatio.setHorizontalAlignment(2);		
        this.txtmainRatio.setDataType(1);		
        this.txtmainRatio.setSupportedEmpty(true);		
        this.txtmainRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainRatio.setPrecision(4);		
        this.txtmainRatio.setRequired(false);		
        this.txtmainRatio.setEnabled(false);
        // txtmainDivisionRatio		
        this.txtmainDivisionRatio.setHorizontalAlignment(2);		
        this.txtmainDivisionRatio.setDataType(1);		
        this.txtmainDivisionRatio.setSupportedEmpty(true);		
        this.txtmainDivisionRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainDivisionRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainDivisionRatio.setPrecision(4);		
        this.txtmainDivisionRatio.setRequired(false);		
        this.txtmainDivisionRatio.setEnabled(false);
        // txtviceRatio		
        this.txtviceRatio.setHorizontalAlignment(2);		
        this.txtviceRatio.setDataType(1);		
        this.txtviceRatio.setSupportedEmpty(true);		
        this.txtviceRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtviceRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtviceRatio.setPrecision(4);		
        this.txtviceRatio.setRequired(false);		
        this.txtviceRatio.setEnabled(false);
        // txtmainPrice		
        this.txtmainPrice.setHorizontalAlignment(2);		
        this.txtmainPrice.setDataType(1);		
        this.txtmainPrice.setSupportedEmpty(true);		
        this.txtmainPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainPrice.setPrecision(4);		
        this.txtmainPrice.setRequired(false);		
        this.txtmainPrice.setEnabled(false);
        // txtvicePrice		
        this.txtvicePrice.setHorizontalAlignment(2);		
        this.txtvicePrice.setDataType(1);		
        this.txtvicePrice.setSupportedEmpty(true);		
        this.txtvicePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtvicePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtvicePrice.setPrecision(4);		
        this.txtvicePrice.setRequired(false);		
        this.txtvicePrice.setEnabled(false);
        // txtfinishedProductWgt		
        this.txtfinishedProductWgt.setHorizontalAlignment(2);		
        this.txtfinishedProductWgt.setDataType(1);		
        this.txtfinishedProductWgt.setSupportedEmpty(true);		
        this.txtfinishedProductWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfinishedProductWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfinishedProductWgt.setPrecision(4);		
        this.txtfinishedProductWgt.setRequired(false);		
        this.txtfinishedProductWgt.setEnabled(false);
        // txtcarcassRatio		
        this.txtcarcassRatio.setHorizontalAlignment(2);		
        this.txtcarcassRatio.setDataType(1);		
        this.txtcarcassRatio.setSupportedEmpty(true);		
        this.txtcarcassRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarcassRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarcassRatio.setPrecision(4);		
        this.txtcarcassRatio.setRequired(false);		
        this.txtcarcassRatio.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // txtcomprehensiveRatio		
        this.txtcomprehensiveRatio.setHorizontalAlignment(2);		
        this.txtcomprehensiveRatio.setDataType(1);		
        this.txtcomprehensiveRatio.setSupportedEmpty(true);		
        this.txtcomprehensiveRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomprehensiveRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomprehensiveRatio.setPrecision(4);		
        this.txtcomprehensiveRatio.setRequired(false);		
        this.txtcomprehensiveRatio.setEnabled(false);
        // txtdivisionRatio		
        this.txtdivisionRatio.setHorizontalAlignment(2);		
        this.txtdivisionRatio.setDataType(1);		
        this.txtdivisionRatio.setSupportedEmpty(true);		
        this.txtdivisionRatio.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdivisionRatio.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdivisionRatio.setPrecision(4);		
        this.txtdivisionRatio.setRequired(false);		
        this.txtdivisionRatio.setEnabled(false);
        // txtcomprehensivePrice		
        this.txtcomprehensivePrice.setHorizontalAlignment(2);		
        this.txtcomprehensivePrice.setDataType(1);		
        this.txtcomprehensivePrice.setSupportedEmpty(true);		
        this.txtcomprehensivePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcomprehensivePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcomprehensivePrice.setPrecision(4);		
        this.txtcomprehensivePrice.setRequired(false);		
        this.txtcomprehensivePrice.setEnabled(false);
        // txtGrossChickenAWgt		
        this.txtGrossChickenAWgt.setHorizontalAlignment(2);		
        this.txtGrossChickenAWgt.setDataType(1);		
        this.txtGrossChickenAWgt.setSupportedEmpty(true);		
        this.txtGrossChickenAWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossChickenAWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossChickenAWgt.setPrecision(4);		
        this.txtGrossChickenAWgt.setRequired(false);		
        this.txtGrossChickenAWgt.setEnabled(false);
        // txthalfAPackProduct		
        this.txthalfAPackProduct.setHorizontalAlignment(2);		
        this.txthalfAPackProduct.setDataType(1);		
        this.txthalfAPackProduct.setSupportedEmpty(true);		
        this.txthalfAPackProduct.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthalfAPackProduct.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthalfAPackProduct.setPrecision(4);		
        this.txthalfAPackProduct.setRequired(false);
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
        this.txtratioConstant.setEnabled(false);
        // kDPanel2
        // kDPanel4
        // kDPanel3
        // kDPaneDetail
        // contchickenPeatherPrice		
        this.contchickenPeatherPrice.setBoundLabelText(resHelper.getString("contchickenPeatherPrice.boundLabelText"));		
        this.contchickenPeatherPrice.setBoundLabelLength(70);		
        this.contchickenPeatherPrice.setBoundLabelUnderline(true);		
        this.contchickenPeatherPrice.setVisible(true);
        // contchickenPeatherMoney		
        this.contchickenPeatherMoney.setBoundLabelText(resHelper.getString("contchickenPeatherMoney.boundLabelText"));		
        this.contchickenPeatherMoney.setBoundLabelLength(70);		
        this.contchickenPeatherMoney.setBoundLabelUnderline(true);		
        this.contchickenPeatherMoney.setVisible(true);
        // contchickenBloodMoney		
        this.contchickenBloodMoney.setBoundLabelText(resHelper.getString("contchickenBloodMoney.boundLabelText"));		
        this.contchickenBloodMoney.setBoundLabelLength(70);		
        this.contchickenBloodMoney.setBoundLabelUnderline(true);		
        this.contchickenBloodMoney.setVisible(true);
        // contchickenBloodPrice		
        this.contchickenBloodPrice.setBoundLabelText(resHelper.getString("contchickenBloodPrice.boundLabelText"));		
        this.contchickenBloodPrice.setBoundLabelLength(70);		
        this.contchickenBloodPrice.setBoundLabelUnderline(true);		
        this.contchickenBloodPrice.setVisible(true);
        // contchickenIntestineMoney		
        this.contchickenIntestineMoney.setBoundLabelText(resHelper.getString("contchickenIntestineMoney.boundLabelText"));		
        this.contchickenIntestineMoney.setBoundLabelLength(70);		
        this.contchickenIntestineMoney.setBoundLabelUnderline(true);		
        this.contchickenIntestineMoney.setVisible(true);
        // contchickenIntestinePrice		
        this.contchickenIntestinePrice.setBoundLabelText(resHelper.getString("contchickenIntestinePrice.boundLabelText"));		
        this.contchickenIntestinePrice.setBoundLabelLength(70);		
        this.contchickenIntestinePrice.setBoundLabelUnderline(true);		
        this.contchickenIntestinePrice.setVisible(true);
        // contchickenCropMoney		
        this.contchickenCropMoney.setBoundLabelText(resHelper.getString("contchickenCropMoney.boundLabelText"));		
        this.contchickenCropMoney.setBoundLabelLength(70);		
        this.contchickenCropMoney.setBoundLabelUnderline(true);		
        this.contchickenCropMoney.setVisible(true);
        // contchickenCropPrice		
        this.contchickenCropPrice.setBoundLabelText(resHelper.getString("contchickenCropPrice.boundLabelText"));		
        this.contchickenCropPrice.setBoundLabelLength(70);		
        this.contchickenCropPrice.setBoundLabelUnderline(true);		
        this.contchickenCropPrice.setVisible(true);
        // contmixedOilPrice		
        this.contmixedOilPrice.setBoundLabelText(resHelper.getString("contmixedOilPrice.boundLabelText"));		
        this.contmixedOilPrice.setBoundLabelLength(70);		
        this.contmixedOilPrice.setBoundLabelUnderline(true);		
        this.contmixedOilPrice.setVisible(true);
        // contmixedOilMoney		
        this.contmixedOilMoney.setBoundLabelText(resHelper.getString("contmixedOilMoney.boundLabelText"));		
        this.contmixedOilMoney.setBoundLabelLength(70);		
        this.contmixedOilMoney.setBoundLabelUnderline(true);		
        this.contmixedOilMoney.setVisible(true);
        // contbackAreaLeafFatYield		
        this.contbackAreaLeafFatYield.setBoundLabelText(resHelper.getString("contbackAreaLeafFatYield.boundLabelText"));		
        this.contbackAreaLeafFatYield.setBoundLabelLength(150);		
        this.contbackAreaLeafFatYield.setBoundLabelUnderline(true);		
        this.contbackAreaLeafFatYield.setVisible(true);
        // contsuetQty		
        this.contsuetQty.setBoundLabelText(resHelper.getString("contsuetQty.boundLabelText"));		
        this.contsuetQty.setBoundLabelLength(100);		
        this.contsuetQty.setBoundLabelUnderline(true);		
        this.contsuetQty.setVisible(true);
        // contResidualChickenWgt		
        this.contResidualChickenWgt.setBoundLabelText(resHelper.getString("contResidualChickenWgt.boundLabelText"));		
        this.contResidualChickenWgt.setBoundLabelLength(100);		
        this.contResidualChickenWgt.setBoundLabelUnderline(true);		
        this.contResidualChickenWgt.setVisible(true);
        // contCarcassRCWgt		
        this.contCarcassRCWgt.setBoundLabelText(resHelper.getString("contCarcassRCWgt.boundLabelText"));		
        this.contCarcassRCWgt.setBoundLabelLength(150);		
        this.contCarcassRCWgt.setBoundLabelUnderline(true);		
        this.contCarcassRCWgt.setVisible(true);
        // contResidualChickenAmt		
        this.contResidualChickenAmt.setBoundLabelText(resHelper.getString("contResidualChickenAmt.boundLabelText"));		
        this.contResidualChickenAmt.setBoundLabelLength(100);		
        this.contResidualChickenAmt.setBoundLabelUnderline(true);		
        this.contResidualChickenAmt.setVisible(true);
        // contheadQty		
        this.contheadQty.setBoundLabelText(resHelper.getString("contheadQty.boundLabelText"));		
        this.contheadQty.setBoundLabelLength(100);		
        this.contheadQty.setBoundLabelUnderline(true);		
        this.contheadQty.setVisible(true);
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
        // txtchickenPeatherPrice		
        this.txtchickenPeatherPrice.setHorizontalAlignment(2);		
        this.txtchickenPeatherPrice.setDataType(1);		
        this.txtchickenPeatherPrice.setSupportedEmpty(true);		
        this.txtchickenPeatherPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenPeatherPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenPeatherPrice.setPrecision(4);		
        this.txtchickenPeatherPrice.setRequired(false);		
        this.txtchickenPeatherPrice.setEnabled(false);
        // txtchickenPeatherMoney		
        this.txtchickenPeatherMoney.setHorizontalAlignment(2);		
        this.txtchickenPeatherMoney.setDataType(1);		
        this.txtchickenPeatherMoney.setSupportedEmpty(true);		
        this.txtchickenPeatherMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenPeatherMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenPeatherMoney.setPrecision(2);		
        this.txtchickenPeatherMoney.setRequired(false);		
        this.txtchickenPeatherMoney.setEnabled(false);
        // txtchickenBloodMoney		
        this.txtchickenBloodMoney.setHorizontalAlignment(2);		
        this.txtchickenBloodMoney.setDataType(1);		
        this.txtchickenBloodMoney.setSupportedEmpty(true);		
        this.txtchickenBloodMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenBloodMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenBloodMoney.setPrecision(2);		
        this.txtchickenBloodMoney.setRequired(false);		
        this.txtchickenBloodMoney.setEnabled(false);
        // txtchickenBloodPrice		
        this.txtchickenBloodPrice.setHorizontalAlignment(2);		
        this.txtchickenBloodPrice.setDataType(1);		
        this.txtchickenBloodPrice.setSupportedEmpty(true);		
        this.txtchickenBloodPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenBloodPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenBloodPrice.setPrecision(4);		
        this.txtchickenBloodPrice.setRequired(false);		
        this.txtchickenBloodPrice.setEnabled(false);
        // txtchickenIntestineMoney		
        this.txtchickenIntestineMoney.setHorizontalAlignment(2);		
        this.txtchickenIntestineMoney.setDataType(1);		
        this.txtchickenIntestineMoney.setSupportedEmpty(true);		
        this.txtchickenIntestineMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenIntestineMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenIntestineMoney.setPrecision(2);		
        this.txtchickenIntestineMoney.setRequired(false);		
        this.txtchickenIntestineMoney.setEnabled(false);
        // txtchickenIntestinePrice		
        this.txtchickenIntestinePrice.setHorizontalAlignment(2);		
        this.txtchickenIntestinePrice.setDataType(1);		
        this.txtchickenIntestinePrice.setSupportedEmpty(true);		
        this.txtchickenIntestinePrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenIntestinePrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenIntestinePrice.setPrecision(4);		
        this.txtchickenIntestinePrice.setRequired(false);		
        this.txtchickenIntestinePrice.setEnabled(false);
        // txtchickenCropMoney		
        this.txtchickenCropMoney.setHorizontalAlignment(2);		
        this.txtchickenCropMoney.setDataType(1);		
        this.txtchickenCropMoney.setSupportedEmpty(true);		
        this.txtchickenCropMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenCropMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenCropMoney.setPrecision(2);		
        this.txtchickenCropMoney.setRequired(false);		
        this.txtchickenCropMoney.setEnabled(false);
        // txtchickenCropPrice		
        this.txtchickenCropPrice.setHorizontalAlignment(2);		
        this.txtchickenCropPrice.setDataType(1);		
        this.txtchickenCropPrice.setSupportedEmpty(true);		
        this.txtchickenCropPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenCropPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenCropPrice.setPrecision(4);		
        this.txtchickenCropPrice.setRequired(false);		
        this.txtchickenCropPrice.setEnabled(false);
        // txtmixedOilPrice		
        this.txtmixedOilPrice.setHorizontalAlignment(2);		
        this.txtmixedOilPrice.setDataType(1);		
        this.txtmixedOilPrice.setSupportedEmpty(true);		
        this.txtmixedOilPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmixedOilPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmixedOilPrice.setPrecision(4);		
        this.txtmixedOilPrice.setRequired(false);		
        this.txtmixedOilPrice.setEnabled(false);
        // txtmixedOilMoney		
        this.txtmixedOilMoney.setHorizontalAlignment(2);		
        this.txtmixedOilMoney.setDataType(1);		
        this.txtmixedOilMoney.setSupportedEmpty(true);		
        this.txtmixedOilMoney.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmixedOilMoney.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmixedOilMoney.setPrecision(2);		
        this.txtmixedOilMoney.setRequired(false);		
        this.txtmixedOilMoney.setEnabled(false);
        // txtbackAreaLeafFatYield		
        this.txtbackAreaLeafFatYield.setHorizontalAlignment(2);		
        this.txtbackAreaLeafFatYield.setDataType(1);		
        this.txtbackAreaLeafFatYield.setSupportedEmpty(true);		
        this.txtbackAreaLeafFatYield.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbackAreaLeafFatYield.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbackAreaLeafFatYield.setPrecision(4);		
        this.txtbackAreaLeafFatYield.setRequired(false);
        // txtsuetQty		
        this.txtsuetQty.setHorizontalAlignment(2);		
        this.txtsuetQty.setDataType(1);		
        this.txtsuetQty.setSupportedEmpty(true);		
        this.txtsuetQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtsuetQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtsuetQty.setPrecision(4);		
        this.txtsuetQty.setRequired(false);		
        this.txtsuetQty.setEnabled(false);
        // txtResidualChickenWgt		
        this.txtResidualChickenWgt.setHorizontalAlignment(2);		
        this.txtResidualChickenWgt.setDataType(1);		
        this.txtResidualChickenWgt.setSupportedEmpty(true);		
        this.txtResidualChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtResidualChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtResidualChickenWgt.setPrecision(4);		
        this.txtResidualChickenWgt.setRequired(false);
        // txtCarcassRCWgt		
        this.txtCarcassRCWgt.setHorizontalAlignment(2);		
        this.txtCarcassRCWgt.setDataType(1);		
        this.txtCarcassRCWgt.setSupportedEmpty(true);		
        this.txtCarcassRCWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCarcassRCWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCarcassRCWgt.setPrecision(4);		
        this.txtCarcassRCWgt.setRequired(false);
        // txtResidualChickenAmt		
        this.txtResidualChickenAmt.setHorizontalAlignment(2);		
        this.txtResidualChickenAmt.setDataType(0);		
        this.txtResidualChickenAmt.setSupportedEmpty(true);		
        this.txtResidualChickenAmt.setRequired(false);
        // txtheadQty		
        this.txtheadQty.setHorizontalAlignment(2);		
        this.txtheadQty.setDataType(1);		
        this.txtheadQty.setSupportedEmpty(true);		
        this.txtheadQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtheadQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtheadQty.setPrecision(4);		
        this.txtheadQty.setRequired(false);		
        this.txtheadQty.setEnabled(false);
        // txtmainProductQty		
        this.txtmainProductQty.setHorizontalAlignment(2);		
        this.txtmainProductQty.setDataType(1);		
        this.txtmainProductQty.setSupportedEmpty(true);		
        this.txtmainProductQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainProductQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainProductQty.setPrecision(4);		
        this.txtmainProductQty.setRequired(false);		
        this.txtmainProductQty.setEnabled(false);
        // txtmainProductAmt		
        this.txtmainProductAmt.setHorizontalAlignment(2);		
        this.txtmainProductAmt.setDataType(1);		
        this.txtmainProductAmt.setSupportedEmpty(true);		
        this.txtmainProductAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmainProductAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmainProductAmt.setPrecision(2);		
        this.txtmainProductAmt.setRequired(false);		
        this.txtmainProductAmt.setEnabled(false);
        // txtbyProductQty		
        this.txtbyProductQty.setHorizontalAlignment(2);		
        this.txtbyProductQty.setDataType(1);		
        this.txtbyProductQty.setSupportedEmpty(true);		
        this.txtbyProductQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyProductQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyProductQty.setPrecision(4);		
        this.txtbyProductQty.setRequired(false);		
        this.txtbyProductQty.setEnabled(false);
        // txtbyProductAmt		
        this.txtbyProductAmt.setHorizontalAlignment(2);		
        this.txtbyProductAmt.setDataType(1);		
        this.txtbyProductAmt.setSupportedEmpty(true);		
        this.txtbyProductAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbyProductAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbyProductAmt.setPrecision(2);		
        this.txtbyProductAmt.setRequired(false);		
        this.txtbyProductAmt.setEnabled(false);
        // conttonProductWater		
        this.conttonProductWater.setBoundLabelText(resHelper.getString("conttonProductWater.boundLabelText"));		
        this.conttonProductWater.setBoundLabelLength(100);		
        this.conttonProductWater.setBoundLabelUnderline(true);		
        this.conttonProductWater.setVisible(true);
        // conttonAllEle		
        this.conttonAllEle.setBoundLabelText(resHelper.getString("conttonAllEle.boundLabelText"));		
        this.conttonAllEle.setBoundLabelLength(100);		
        this.conttonAllEle.setBoundLabelUnderline(true);		
        this.conttonAllEle.setVisible(true);
        // conttonProductCoal		
        this.conttonProductCoal.setBoundLabelText(resHelper.getString("conttonProductCoal.boundLabelText"));		
        this.conttonProductCoal.setBoundLabelLength(100);		
        this.conttonProductCoal.setBoundLabelUnderline(true);		
        this.conttonProductCoal.setVisible(true);
        // conttonPackingCost		
        this.conttonPackingCost.setBoundLabelText(resHelper.getString("conttonPackingCost.boundLabelText"));		
        this.conttonPackingCost.setBoundLabelLength(100);		
        this.conttonPackingCost.setBoundLabelUnderline(true);		
        this.conttonPackingCost.setVisible(true);
        // conttonProductColdEle		
        this.conttonProductColdEle.setBoundLabelText(resHelper.getString("conttonProductColdEle.boundLabelText"));		
        this.conttonProductColdEle.setBoundLabelLength(100);		
        this.conttonProductColdEle.setBoundLabelUnderline(true);		
        this.conttonProductColdEle.setVisible(true);
        // conttonProductionEle		
        this.conttonProductionEle.setBoundLabelText(resHelper.getString("conttonProductionEle.boundLabelText"));		
        this.conttonProductionEle.setBoundLabelLength(100);		
        this.conttonProductionEle.setBoundLabelUnderline(true);		
        this.conttonProductionEle.setVisible(true);
        // txttonProductWater		
        this.txttonProductWater.setHorizontalAlignment(2);		
        this.txttonProductWater.setDataType(1);		
        this.txttonProductWater.setSupportedEmpty(true);		
        this.txttonProductWater.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonProductWater.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonProductWater.setPrecision(4);		
        this.txttonProductWater.setRequired(false);
        // txttonAllEle		
        this.txttonAllEle.setHorizontalAlignment(2);		
        this.txttonAllEle.setDataType(1);		
        this.txttonAllEle.setSupportedEmpty(true);		
        this.txttonAllEle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonAllEle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonAllEle.setPrecision(4);		
        this.txttonAllEle.setRequired(false);		
        this.txttonAllEle.setEnabled(false);
        // txttonProductCoal		
        this.txttonProductCoal.setHorizontalAlignment(2);		
        this.txttonProductCoal.setDataType(1);		
        this.txttonProductCoal.setSupportedEmpty(true);		
        this.txttonProductCoal.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonProductCoal.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonProductCoal.setPrecision(4);		
        this.txttonProductCoal.setRequired(false);
        // txttonPackingCost		
        this.txttonPackingCost.setHorizontalAlignment(2);		
        this.txttonPackingCost.setDataType(1);		
        this.txttonPackingCost.setSupportedEmpty(true);		
        this.txttonPackingCost.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonPackingCost.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonPackingCost.setPrecision(2);		
        this.txttonPackingCost.setRequired(false);
        // txttonProductColdEle		
        this.txttonProductColdEle.setHorizontalAlignment(2);		
        this.txttonProductColdEle.setDataType(1);		
        this.txttonProductColdEle.setSupportedEmpty(true);		
        this.txttonProductColdEle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonProductColdEle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonProductColdEle.setPrecision(4);		
        this.txttonProductColdEle.setRequired(false);
        txttonProductColdEle.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txttonProductColdEle_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txttonProductionEle		
        this.txttonProductionEle.setHorizontalAlignment(2);		
        this.txttonProductionEle.setDataType(1);		
        this.txttonProductionEle.setSupportedEmpty(true);		
        this.txttonProductionEle.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttonProductionEle.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttonProductionEle.setPrecision(4);		
        this.txttonProductionEle.setRequired(false);
        txttonProductionEle.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txttonProductionEle_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

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
        // chkhalfWorkDay		
        this.chkhalfWorkDay.setText(resHelper.getString("chkhalfWorkDay.text"));		
        this.chkhalfWorkDay.setVisible(true);		
        this.chkhalfWorkDay.setHorizontalAlignment(2);
        // contmorningQty		
        this.contmorningQty.setBoundLabelText(resHelper.getString("contmorningQty.boundLabelText"));		
        this.contmorningQty.setBoundLabelLength(100);		
        this.contmorningQty.setBoundLabelUnderline(true);		
        this.contmorningQty.setVisible(true);
        // contafternoonQty		
        this.contafternoonQty.setBoundLabelText(resHelper.getString("contafternoonQty.boundLabelText"));		
        this.contafternoonQty.setBoundLabelLength(100);		
        this.contafternoonQty.setBoundLabelUnderline(true);		
        this.contafternoonQty.setVisible(true);
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
        // txtmorningQty		
        this.txtmorningQty.setVisible(true);		
        this.txtmorningQty.setHorizontalAlignment(2);		
        this.txtmorningQty.setDataType(1);		
        this.txtmorningQty.setSupportedEmpty(true);		
        this.txtmorningQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmorningQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmorningQty.setPrecision(4);		
        this.txtmorningQty.setRequired(false);
        txtmorningQty.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				txtmorningQty_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtafternoonQty		
        this.txtafternoonQty.setVisible(true);		
        this.txtafternoonQty.setHorizontalAlignment(2);		
        this.txtafternoonQty.setDataType(1);		
        this.txtafternoonQty.setSupportedEmpty(true);		
        this.txtafternoonQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtafternoonQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtafternoonQty.setPrecision(4);		
        this.txtafternoonQty.setRequired(false);
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
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"materialGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"ccRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{materialGroup}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{ccRate}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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
        // productType		
        this.productType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.szcount.ProductType").toArray());		
        this.productType.setRequired(true);
        // txtShedBLossGrossWgt		
        this.txtShedBLossGrossWgt.setVisible(true);		
        this.txtShedBLossGrossWgt.setHorizontalAlignment(2);		
        this.txtShedBLossGrossWgt.setDataType(1);		
        this.txtShedBLossGrossWgt.setSupportedEmpty(true);		
        this.txtShedBLossGrossWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtShedBLossGrossWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtShedBLossGrossWgt.setPrecision(4);		
        this.txtShedBLossGrossWgt.setRequired(false);
        // btnGetData
        this.btnGetData.setAction((IItemAction)ActionProxyFactory.getProxy(actionGetData, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnGetData.setText(resHelper.getString("btnGetData.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtchickenBloodPrice,txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,pkauditTime,billStatus,txtslaughterAmt,txtsettlementGrossWgt,txtsettlementCarcass,txtGrossChickenCost,txtcostPrice,txtbuyMoney,txtbuyFreight,txtcommodityChickenAPrice,txtmarketPrice,txtGrossChickenAPrice,txttonGrossProfit,txtcommodityChickenAmt,txtmarketChickenAmt,txtSmallChickenWgt,txtResidualChickenWgt,txttodayNetProfit,txtCarcassRCWgt,txtCarcassSCWgt,txtallGrossWgt,txtbackAreaLeafFatYield,txtallMoney,txtmainDivisionRatio,txtmainRatio,txtmainPrice,txtviceRatio,txtvicePrice,txtfinishedProductWgt,txtchickenPeatherPrice,txtchickenIntestinePrice,txtchickenCropPrice,txtmixedOilPrice,txtchickenPeatherMoney,txtchickenBloodMoney,txtchickenIntestineMoney,txtchickenCropMoney,txtmixedOilMoney,txtcarcassRatio,prmtcompany,txtcomprehensiveRatio,txtdivisionRatio,txtcomprehensivePrice,txtGrossChickenAWgt,txthalfAPackProduct,txttonProductWater,txttonProductCoal,txttonProductColdEle,txttonProductionEle,txttonAllEle,txttonPackingCost,txtallPeople,txtattendancePeople,txtworkTime,txtperCatipaEfficiency,txttonPrice,txtratioConstant,txtmainProductQty,txtotherProductQty,txtmainProductAmt,txtotherProductAmt,txtsuetQty,txtheadQty,txtbyProductQty,txtbyProductAmt,productType,txtwaterAbsorption,txtResidualChickenAmt,kdtEntry,txtShedBLossGrossWgt,chkhalfWorkDay,txtmorningQty,txtafternoonQty,txtoffduty,txtLeavenumber}));
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
        contslaughterAmt.setBounds(new Rectangle(14, 148, 270, 19));
        this.add(contslaughterAmt, new KDLayout.Constraints(14, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbuyFreight.setBounds(new Rectangle(315, 175, 270, 19));
        this.add(contbuyFreight, new KDLayout.Constraints(315, 175, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbuyMoney.setBounds(new Rectangle(14, 175, 270, 19));
        this.add(contbuyMoney, new KDLayout.Constraints(14, 175, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostPrice.setBounds(new Rectangle(315, 229, 270, 19));
        this.add(contcostPrice, new KDLayout.Constraints(315, 229, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossChickenCost.setBounds(new Rectangle(14, 256, 270, 19));
        this.add(contGrossChickenCost, new KDLayout.Constraints(14, 256, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlementCarcass.setBounds(new Rectangle(315, 148, 270, 19));
        this.add(contsettlementCarcass, new KDLayout.Constraints(315, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsettlementGrossWgt.setBounds(new Rectangle(616, 148, 270, 19));
        this.add(contsettlementGrossWgt, new KDLayout.Constraints(616, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarketPrice.setBounds(new Rectangle(14, 229, 270, 19));
        this.add(contmarketPrice, new KDLayout.Constraints(14, 229, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossChickenAPrice.setBounds(new Rectangle(315, 256, 270, 19));
        this.add(contGrossChickenAPrice, new KDLayout.Constraints(315, 256, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcommodityChickenAPrice.setBounds(new Rectangle(315, 202, 270, 19));
        this.add(contcommodityChickenAPrice, new KDLayout.Constraints(315, 202, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonGrossProfit.setBounds(new Rectangle(14, 55, 270, 19));
        this.add(conttonGrossProfit, new KDLayout.Constraints(14, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcommodityChickenAmt.setBounds(new Rectangle(14, 202, 270, 19));
        this.add(contcommodityChickenAmt, new KDLayout.Constraints(14, 202, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmarketChickenAmt.setBounds(new Rectangle(616, 202, 270, 19));
        this.add(contmarketChickenAmt, new KDLayout.Constraints(616, 202, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSmallChickenWgt.setBounds(new Rectangle(14, 283, 270, 19));
        this.add(contSmallChickenWgt, new KDLayout.Constraints(14, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttodayNetProfit.setBounds(new Rectangle(14, 82, 270, 19));
        this.add(conttodayNetProfit, new KDLayout.Constraints(14, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarcassSCWgt.setBounds(new Rectangle(315, 283, 270, 19));
        this.add(contCarcassSCWgt, new KDLayout.Constraints(315, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallGrossWgt.setBounds(new Rectangle(917, 148, 270, 19));
        this.add(contallGrossWgt, new KDLayout.Constraints(917, 148, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contwaterAbsorption.setBounds(new Rectangle(917, 229, 270, 19));
        this.add(contwaterAbsorption, new KDLayout.Constraints(917, 229, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator8.setBounds(new Rectangle(17, 44, 1190, 10));
        this.add(kDSeparator8, new KDLayout.Constraints(17, 44, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contallMoney.setBounds(new Rectangle(917, 176, 270, 19));
        this.add(contallMoney, new KDLayout.Constraints(917, 176, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmainRatio.setBounds(new Rectangle(315, 82, 270, 19));
        this.add(contmainRatio, new KDLayout.Constraints(315, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainDivisionRatio.setBounds(new Rectangle(315, 109, 270, 19));
        this.add(contmainDivisionRatio, new KDLayout.Constraints(315, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contviceRatio.setBounds(new Rectangle(616, 82, 270, 19));
        this.add(contviceRatio, new KDLayout.Constraints(616, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainPrice.setBounds(new Rectangle(315, 55, 270, 19));
        this.add(contmainPrice, new KDLayout.Constraints(315, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contvicePrice.setBounds(new Rectangle(616, 55, 270, 19));
        this.add(contvicePrice, new KDLayout.Constraints(616, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfinishedProductWgt.setBounds(new Rectangle(616, 175, 270, 19));
        this.add(contfinishedProductWgt, new KDLayout.Constraints(616, 175, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator9.setBounds(new Rectangle(12, 139, 1190, 10));
        this.add(kDSeparator9, new KDLayout.Constraints(12, 139, 1190, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator10.setBounds(new Rectangle(445, 315, 1, 1));
        this.add(kDSeparator10, new KDLayout.Constraints(445, 315, 1, 1, 0));
        contcarcassRatio.setBounds(new Rectangle(917, 109, 270, 19));
        this.add(contcarcassRatio, new KDLayout.Constraints(917, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(315, 17, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(315, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcomprehensiveRatio.setBounds(new Rectangle(917, 82, 270, 19));
        this.add(contcomprehensiveRatio, new KDLayout.Constraints(917, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contdivisionRatio.setBounds(new Rectangle(616, 109, 270, 19));
        this.add(contdivisionRatio, new KDLayout.Constraints(616, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcomprehensivePrice.setBounds(new Rectangle(917, 55, 270, 19));
        this.add(contcomprehensivePrice, new KDLayout.Constraints(917, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contGrossChickenAWgt.setBounds(new Rectangle(616, 256, 270, 19));
        this.add(contGrossChickenAWgt, new KDLayout.Constraints(616, 256, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conthalfAPackProduct.setBounds(new Rectangle(616, 230, 270, 19));
        this.add(conthalfAPackProduct, new KDLayout.Constraints(616, 230, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonPrice.setBounds(new Rectangle(917, 202, 270, 19));
        this.add(conttonPrice, new KDLayout.Constraints(917, 202, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator15.setBounds(new Rectangle(19, 543, 1190, 10));
        this.add(kDSeparator15, new KDLayout.Constraints(19, 543, 1190, 10, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contratioConstant.setBounds(new Rectangle(14, 109, 270, 19));
        this.add(contratioConstant, new KDLayout.Constraints(14, 109, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(9, 310, 1183, 223));
        this.add(kDTabbedPane1, new KDLayout.Constraints(9, 310, 1183, 223, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contproductType.setBounds(new Rectangle(616, 17, 270, 19));
        this.add(contproductType, new KDLayout.Constraints(616, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contShedBLossGrossWgt.setBounds(new Rectangle(616, 283, 270, 19));
        this.add(contShedBLossGrossWgt, new KDLayout.Constraints(616, 283, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contbuyFreight
        contbuyFreight.setBoundEditor(txtbuyFreight);
        //contbuyMoney
        contbuyMoney.setBoundEditor(txtbuyMoney);
        //contcostPrice
        contcostPrice.setBoundEditor(txtcostPrice);
        //contGrossChickenCost
        contGrossChickenCost.setBoundEditor(txtGrossChickenCost);
        //contsettlementCarcass
        contsettlementCarcass.setBoundEditor(txtsettlementCarcass);
        //contsettlementGrossWgt
        contsettlementGrossWgt.setBoundEditor(txtsettlementGrossWgt);
        //contmarketPrice
        contmarketPrice.setBoundEditor(txtmarketPrice);
        //contGrossChickenAPrice
        contGrossChickenAPrice.setBoundEditor(txtGrossChickenAPrice);
        //contcommodityChickenAPrice
        contcommodityChickenAPrice.setBoundEditor(txtcommodityChickenAPrice);
        //conttonGrossProfit
        conttonGrossProfit.setBoundEditor(txttonGrossProfit);
        //contcommodityChickenAmt
        contcommodityChickenAmt.setBoundEditor(txtcommodityChickenAmt);
        //contmarketChickenAmt
        contmarketChickenAmt.setBoundEditor(txtmarketChickenAmt);
        //contSmallChickenWgt
        contSmallChickenWgt.setBoundEditor(txtSmallChickenWgt);
        //conttodayNetProfit
        conttodayNetProfit.setBoundEditor(txttodayNetProfit);
        //contCarcassSCWgt
        contCarcassSCWgt.setBoundEditor(txtCarcassSCWgt);
        //contallGrossWgt
        contallGrossWgt.setBoundEditor(txtallGrossWgt);
        //contwaterAbsorption
        contwaterAbsorption.setBoundEditor(txtwaterAbsorption);
        //contallMoney
        contallMoney.setBoundEditor(txtallMoney);
        //contmainRatio
        contmainRatio.setBoundEditor(txtmainRatio);
        //contmainDivisionRatio
        contmainDivisionRatio.setBoundEditor(txtmainDivisionRatio);
        //contviceRatio
        contviceRatio.setBoundEditor(txtviceRatio);
        //contmainPrice
        contmainPrice.setBoundEditor(txtmainPrice);
        //contvicePrice
        contvicePrice.setBoundEditor(txtvicePrice);
        //contfinishedProductWgt
        contfinishedProductWgt.setBoundEditor(txtfinishedProductWgt);
        //contcarcassRatio
        contcarcassRatio.setBoundEditor(txtcarcassRatio);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcomprehensiveRatio
        contcomprehensiveRatio.setBoundEditor(txtcomprehensiveRatio);
        //contdivisionRatio
        contdivisionRatio.setBoundEditor(txtdivisionRatio);
        //contcomprehensivePrice
        contcomprehensivePrice.setBoundEditor(txtcomprehensivePrice);
        //contGrossChickenAWgt
        contGrossChickenAWgt.setBoundEditor(txtGrossChickenAWgt);
        //conthalfAPackProduct
        conthalfAPackProduct.setBoundEditor(txthalfAPackProduct);
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
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 190));        contchickenPeatherPrice.setBounds(new Rectangle(17, 47, 200, 19));
        kDPanel2.add(contchickenPeatherPrice, new KDLayout.Constraints(17, 47, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenPeatherMoney.setBounds(new Rectangle(17, 74, 200, 19));
        kDPanel2.add(contchickenPeatherMoney, new KDLayout.Constraints(17, 74, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenBloodMoney.setBounds(new Rectangle(256, 74, 200, 19));
        kDPanel2.add(contchickenBloodMoney, new KDLayout.Constraints(256, 74, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenBloodPrice.setBounds(new Rectangle(256, 47, 200, 19));
        kDPanel2.add(contchickenBloodPrice, new KDLayout.Constraints(256, 47, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenIntestineMoney.setBounds(new Rectangle(495, 74, 200, 19));
        kDPanel2.add(contchickenIntestineMoney, new KDLayout.Constraints(495, 74, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenIntestinePrice.setBounds(new Rectangle(495, 47, 200, 19));
        kDPanel2.add(contchickenIntestinePrice, new KDLayout.Constraints(495, 47, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenCropMoney.setBounds(new Rectangle(734, 74, 200, 19));
        kDPanel2.add(contchickenCropMoney, new KDLayout.Constraints(734, 74, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenCropPrice.setBounds(new Rectangle(734, 47, 200, 19));
        kDPanel2.add(contchickenCropPrice, new KDLayout.Constraints(734, 47, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmixedOilPrice.setBounds(new Rectangle(973, 47, 200, 19));
        kDPanel2.add(contmixedOilPrice, new KDLayout.Constraints(973, 47, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contmixedOilMoney.setBounds(new Rectangle(973, 74, 200, 19));
        kDPanel2.add(contmixedOilMoney, new KDLayout.Constraints(973, 74, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbackAreaLeafFatYield.setBounds(new Rectangle(17, 110, 270, 19));
        kDPanel2.add(contbackAreaLeafFatYield, new KDLayout.Constraints(17, 110, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contsuetQty.setBounds(new Rectangle(354, 110, 270, 19));
        kDPanel2.add(contsuetQty, new KDLayout.Constraints(354, 110, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contResidualChickenWgt.setBounds(new Rectangle(17, 141, 270, 19));
        kDPanel2.add(contResidualChickenWgt, new KDLayout.Constraints(17, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarcassRCWgt.setBounds(new Rectangle(354, 141, 270, 19));
        kDPanel2.add(contCarcassRCWgt, new KDLayout.Constraints(354, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contResidualChickenAmt.setBounds(new Rectangle(691, 141, 270, 19));
        kDPanel2.add(contResidualChickenAmt, new KDLayout.Constraints(691, 141, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contheadQty.setBounds(new Rectangle(691, 110, 270, 19));
        kDPanel2.add(contheadQty, new KDLayout.Constraints(691, 110, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainProductQty.setBounds(new Rectangle(17, 11, 200, 19));
        kDPanel2.add(contmainProductQty, new KDLayout.Constraints(17, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmainProductAmt.setBounds(new Rectangle(256, 11, 200, 19));
        kDPanel2.add(contmainProductAmt, new KDLayout.Constraints(256, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyProductQty.setBounds(new Rectangle(495, 11, 200, 19));
        kDPanel2.add(contbyProductQty, new KDLayout.Constraints(495, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbyProductAmt.setBounds(new Rectangle(734, 11, 200, 19));
        kDPanel2.add(contbyProductAmt, new KDLayout.Constraints(734, 11, 200, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contchickenPeatherPrice
        contchickenPeatherPrice.setBoundEditor(txtchickenPeatherPrice);
        //contchickenPeatherMoney
        contchickenPeatherMoney.setBoundEditor(txtchickenPeatherMoney);
        //contchickenBloodMoney
        contchickenBloodMoney.setBoundEditor(txtchickenBloodMoney);
        //contchickenBloodPrice
        contchickenBloodPrice.setBoundEditor(txtchickenBloodPrice);
        //contchickenIntestineMoney
        contchickenIntestineMoney.setBoundEditor(txtchickenIntestineMoney);
        //contchickenIntestinePrice
        contchickenIntestinePrice.setBoundEditor(txtchickenIntestinePrice);
        //contchickenCropMoney
        contchickenCropMoney.setBoundEditor(txtchickenCropMoney);
        //contchickenCropPrice
        contchickenCropPrice.setBoundEditor(txtchickenCropPrice);
        //contmixedOilPrice
        contmixedOilPrice.setBoundEditor(txtmixedOilPrice);
        //contmixedOilMoney
        contmixedOilMoney.setBoundEditor(txtmixedOilMoney);
        //contbackAreaLeafFatYield
        contbackAreaLeafFatYield.setBoundEditor(txtbackAreaLeafFatYield);
        //contsuetQty
        contsuetQty.setBoundEditor(txtsuetQty);
        //contResidualChickenWgt
        contResidualChickenWgt.setBoundEditor(txtResidualChickenWgt);
        //contCarcassRCWgt
        contCarcassRCWgt.setBoundEditor(txtCarcassRCWgt);
        //contResidualChickenAmt
        contResidualChickenAmt.setBoundEditor(txtResidualChickenAmt);
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
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 190));        conttonProductWater.setBounds(new Rectangle(7, 17, 270, 19));
        kDPanel4.add(conttonProductWater, new KDLayout.Constraints(7, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonAllEle.setBounds(new Rectangle(7, 44, 270, 19));
        kDPanel4.add(conttonAllEle, new KDLayout.Constraints(7, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonProductCoal.setBounds(new Rectangle(306, 17, 270, 19));
        kDPanel4.add(conttonProductCoal, new KDLayout.Constraints(306, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonPackingCost.setBounds(new Rectangle(306, 44, 270, 19));
        kDPanel4.add(conttonPackingCost, new KDLayout.Constraints(306, 44, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonProductColdEle.setBounds(new Rectangle(605, 17, 270, 19));
        kDPanel4.add(conttonProductColdEle, new KDLayout.Constraints(605, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttonProductionEle.setBounds(new Rectangle(905, 17, 270, 19));
        kDPanel4.add(conttonProductionEle, new KDLayout.Constraints(905, 17, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //conttonProductWater
        conttonProductWater.setBoundEditor(txttonProductWater);
        //conttonAllEle
        conttonAllEle.setBoundEditor(txttonAllEle);
        //conttonProductCoal
        conttonProductCoal.setBoundEditor(txttonProductCoal);
        //conttonPackingCost
        conttonPackingCost.setBoundEditor(txttonPackingCost);
        //conttonProductColdEle
        conttonProductColdEle.setBoundEditor(txttonProductColdEle);
        //conttonProductionEle
        conttonProductionEle.setBoundEditor(txttonProductionEle);
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 190));        contperCatipaEfficiency.setBounds(new Rectangle(905, 24, 270, 19));
        kDPanel3.add(contperCatipaEfficiency, new KDLayout.Constraints(905, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contworkTime.setBounds(new Rectangle(605, 24, 270, 19));
        kDPanel3.add(contworkTime, new KDLayout.Constraints(605, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contattendancePeople.setBounds(new Rectangle(306, 24, 270, 19));
        kDPanel3.add(contattendancePeople, new KDLayout.Constraints(306, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contallPeople.setBounds(new Rectangle(7, 24, 270, 19));
        kDPanel3.add(contallPeople, new KDLayout.Constraints(7, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(486, 84, 874, 198));
        kDPanel3.add(kDPanel1, new KDLayout.Constraints(486, 84, 874, 198, 0));
        chkhalfWorkDay.setBounds(new Rectangle(605, 55, 270, 19));
        kDPanel3.add(chkhalfWorkDay, new KDLayout.Constraints(605, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contmorningQty.setBounds(new Rectangle(6, 55, 270, 19));
        kDPanel3.add(contmorningQty, new KDLayout.Constraints(6, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contafternoonQty.setBounds(new Rectangle(306, 55, 270, 19));
        kDPanel3.add(contafternoonQty, new KDLayout.Constraints(306, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contmorningQty
        contmorningQty.setBoundEditor(txtmorningQty);
        //contafternoonQty
        contafternoonQty.setBoundEditor(txtafternoonQty);
        //contLeavenumber
        contLeavenumber.setBoundEditor(txtLeavenumber);
        //contoffduty
        contoffduty.setBoundEditor(txtoffduty);
        //kDPaneDetail
        kDPaneDetail.setLayout(new KDLayout());
        kDPaneDetail.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1182, 190));        kdtEntry.setBounds(new Rectangle(0, 0, 1175, 190));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.szcount.FreshDailyEntryInfo(),null,false);
        kDPaneDetail.add(kdtEntry_detailPanel, new KDLayout.Constraints(0, 0, 1175, 190, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contproductType
        contproductType.setBoundEditor(productType);
        //contShedBLossGrossWgt
        contShedBLossGrossWgt.setBoundEditor(txtShedBLossGrossWgt);

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
		dataBinder.registerBinding("buyFreight", java.math.BigDecimal.class, this.txtbuyFreight, "value");
		dataBinder.registerBinding("buyMoney", java.math.BigDecimal.class, this.txtbuyMoney, "value");
		dataBinder.registerBinding("costPrice", java.math.BigDecimal.class, this.txtcostPrice, "value");
		dataBinder.registerBinding("GrossChickenCost", java.math.BigDecimal.class, this.txtGrossChickenCost, "value");
		dataBinder.registerBinding("settlementCarcass", java.math.BigDecimal.class, this.txtsettlementCarcass, "value");
		dataBinder.registerBinding("settlementGrossWgt", java.math.BigDecimal.class, this.txtsettlementGrossWgt, "value");
		dataBinder.registerBinding("marketPrice", java.math.BigDecimal.class, this.txtmarketPrice, "value");
		dataBinder.registerBinding("GrossChickenAPrice", java.math.BigDecimal.class, this.txtGrossChickenAPrice, "value");
		dataBinder.registerBinding("commodityChickenAPrice", java.math.BigDecimal.class, this.txtcommodityChickenAPrice, "value");
		dataBinder.registerBinding("tonGrossProfit", java.math.BigDecimal.class, this.txttonGrossProfit, "value");
		dataBinder.registerBinding("commodityChickenAmt", java.math.BigDecimal.class, this.txtcommodityChickenAmt, "value");
		dataBinder.registerBinding("marketChickenAmt", java.math.BigDecimal.class, this.txtmarketChickenAmt, "value");
		dataBinder.registerBinding("SmallChickenWgt", java.math.BigDecimal.class, this.txtSmallChickenWgt, "value");
		dataBinder.registerBinding("todayNetProfit", java.math.BigDecimal.class, this.txttodayNetProfit, "value");
		dataBinder.registerBinding("CarcassSCWgt", java.math.BigDecimal.class, this.txtCarcassSCWgt, "value");
		dataBinder.registerBinding("allGrossWgt", java.math.BigDecimal.class, this.txtallGrossWgt, "value");
		dataBinder.registerBinding("waterAbsorption", java.math.BigDecimal.class, this.txtwaterAbsorption, "value");
		dataBinder.registerBinding("allMoney", java.math.BigDecimal.class, this.txtallMoney, "value");
		dataBinder.registerBinding("mainRatio", java.math.BigDecimal.class, this.txtmainRatio, "value");
		dataBinder.registerBinding("mainDivisionRatio", java.math.BigDecimal.class, this.txtmainDivisionRatio, "value");
		dataBinder.registerBinding("viceRatio", java.math.BigDecimal.class, this.txtviceRatio, "value");
		dataBinder.registerBinding("mainPrice", java.math.BigDecimal.class, this.txtmainPrice, "value");
		dataBinder.registerBinding("vicePrice", java.math.BigDecimal.class, this.txtvicePrice, "value");
		dataBinder.registerBinding("finishedProductWgt", java.math.BigDecimal.class, this.txtfinishedProductWgt, "value");
		dataBinder.registerBinding("carcassRatio", java.math.BigDecimal.class, this.txtcarcassRatio, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("comprehensiveRatio", java.math.BigDecimal.class, this.txtcomprehensiveRatio, "value");
		dataBinder.registerBinding("divisionRatio", java.math.BigDecimal.class, this.txtdivisionRatio, "value");
		dataBinder.registerBinding("comprehensivePrice", java.math.BigDecimal.class, this.txtcomprehensivePrice, "value");
		dataBinder.registerBinding("GrossChickenAWgt", java.math.BigDecimal.class, this.txtGrossChickenAWgt, "value");
		dataBinder.registerBinding("halfAPackProduct", java.math.BigDecimal.class, this.txthalfAPackProduct, "value");
		dataBinder.registerBinding("tonPrice", java.math.BigDecimal.class, this.txttonPrice, "value");
		dataBinder.registerBinding("ratioConstant", java.math.BigDecimal.class, this.txtratioConstant, "value");
		dataBinder.registerBinding("chickenPeatherPrice", java.math.BigDecimal.class, this.txtchickenPeatherPrice, "value");
		dataBinder.registerBinding("chickenPeatherMoney", java.math.BigDecimal.class, this.txtchickenPeatherMoney, "value");
		dataBinder.registerBinding("chickenBloodMoney", java.math.BigDecimal.class, this.txtchickenBloodMoney, "value");
		dataBinder.registerBinding("chickenBloodPrice", java.math.BigDecimal.class, this.txtchickenBloodPrice, "value");
		dataBinder.registerBinding("chickenIntestineMoney", java.math.BigDecimal.class, this.txtchickenIntestineMoney, "value");
		dataBinder.registerBinding("chickenIntestinePrice", java.math.BigDecimal.class, this.txtchickenIntestinePrice, "value");
		dataBinder.registerBinding("chickenCropMoney", java.math.BigDecimal.class, this.txtchickenCropMoney, "value");
		dataBinder.registerBinding("chickenCropPrice", java.math.BigDecimal.class, this.txtchickenCropPrice, "value");
		dataBinder.registerBinding("mixedOilPrice", java.math.BigDecimal.class, this.txtmixedOilPrice, "value");
		dataBinder.registerBinding("mixedOilMoney", java.math.BigDecimal.class, this.txtmixedOilMoney, "value");
		dataBinder.registerBinding("backAreaLeafFatYield", java.math.BigDecimal.class, this.txtbackAreaLeafFatYield, "value");
		dataBinder.registerBinding("suetQty", java.math.BigDecimal.class, this.txtsuetQty, "value");
		dataBinder.registerBinding("ResidualChickenWgt", java.math.BigDecimal.class, this.txtResidualChickenWgt, "value");
		dataBinder.registerBinding("CarcassRCWgt", java.math.BigDecimal.class, this.txtCarcassRCWgt, "value");
		dataBinder.registerBinding("ResidualChickenAmt", int.class, this.txtResidualChickenAmt, "value");
		dataBinder.registerBinding("headQty", java.math.BigDecimal.class, this.txtheadQty, "value");
		dataBinder.registerBinding("mainProductQty", java.math.BigDecimal.class, this.txtmainProductQty, "value");
		dataBinder.registerBinding("mainProductAmt", java.math.BigDecimal.class, this.txtmainProductAmt, "value");
		dataBinder.registerBinding("byProductQty", java.math.BigDecimal.class, this.txtbyProductQty, "value");
		dataBinder.registerBinding("byProductAmt", java.math.BigDecimal.class, this.txtbyProductAmt, "value");
		dataBinder.registerBinding("tonProductWater", java.math.BigDecimal.class, this.txttonProductWater, "value");
		dataBinder.registerBinding("tonAllEle", java.math.BigDecimal.class, this.txttonAllEle, "value");
		dataBinder.registerBinding("tonProductCoal", java.math.BigDecimal.class, this.txttonProductCoal, "value");
		dataBinder.registerBinding("tonPackingCost", java.math.BigDecimal.class, this.txttonPackingCost, "value");
		dataBinder.registerBinding("tonProductColdEle", java.math.BigDecimal.class, this.txttonProductColdEle, "value");
		dataBinder.registerBinding("tonProductionEle", java.math.BigDecimal.class, this.txttonProductionEle, "value");
		dataBinder.registerBinding("halfWorkDay", boolean.class, this.chkhalfWorkDay, "selected");
		dataBinder.registerBinding("perCatipaEfficiency", java.math.BigDecimal.class, this.txtperCatipaEfficiency, "value");
		dataBinder.registerBinding("workTime", java.math.BigDecimal.class, this.txtworkTime, "value");
		dataBinder.registerBinding("attendancePeople", int.class, this.txtattendancePeople, "value");
		dataBinder.registerBinding("allPeople", int.class, this.txtallPeople, "value");
		dataBinder.registerBinding("otherProductQty", java.math.BigDecimal.class, this.txtotherProductQty, "value");
		dataBinder.registerBinding("otherProductAmt", java.math.BigDecimal.class, this.txtotherProductAmt, "value");
		dataBinder.registerBinding("morningQty", java.math.BigDecimal.class, this.txtmorningQty, "value");
		dataBinder.registerBinding("afternoonQty", java.math.BigDecimal.class, this.txtafternoonQty, "value");
		dataBinder.registerBinding("Leavenumber", int.class, this.txtLeavenumber, "value");
		dataBinder.registerBinding("offduty", int.class, this.txtoffduty, "value");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.szcount.FreshDailyEntryInfo.class, this.kdtEntry, "userObject");
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
		dataBinder.registerBinding("ShedBLossGrossWgt", java.math.BigDecimal.class, this.txtShedBLossGrossWgt, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.szcount.app.FreshDailyEditUIHandler";
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
        this.txtchickenBloodPrice.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.szcount.FreshDailyInfo)ov;
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
		getValidateHelper().registerBindProperty("buyFreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buyMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossChickenCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementCarcass", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("settlementGrossWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossChickenAPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("commodityChickenAPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonGrossProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("commodityChickenAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("marketChickenAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmallChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("todayNetProfit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarcassSCWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allGrossWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("waterAbsorption", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainDivisionRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("viceRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("vicePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("finishedProductWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comprehensiveRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("divisionRatio", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("comprehensivePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossChickenAWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("halfAPackProduct", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ratioConstant", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenPeatherPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenPeatherMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenBloodMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenBloodPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenIntestineMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenIntestinePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenCropMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenCropPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mixedOilPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mixedOilMoney", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("backAreaLeafFatYield", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("suetQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ResidualChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarcassRCWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ResidualChickenAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("headQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mainProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("byProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonProductWater", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonAllEle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonProductCoal", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonPackingCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonProductColdEle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tonProductionEle", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("halfWorkDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("perCatipaEfficiency", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("attendancePeople", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allPeople", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherProductQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherProductAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("morningQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("afternoonQty", ValidateHelper.ON_SAVE);    
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
		getValidateHelper().registerBindProperty("ShedBLossGrossWgt", ValidateHelper.ON_SAVE);    		
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
     * output txttonProductColdEle_Changed() method
     */
    public void txttonProductColdEle_Changed() throws Exception
    {
        System.out.println("txttonProductColdEle_Changed() Function is executed!");
            txttonAllEle.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttonProductionEle.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttonProductColdEle.getValue())));


    }

    /**
     * output txttonProductionEle_Changed() method
     */
    public void txttonProductionEle_Changed() throws Exception
    {
        System.out.println("txttonProductionEle_Changed() Function is executed!");
            txttonAllEle.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttonProductionEle.getValue())+ com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txttonProductColdEle.getValue())));


    }

    /**
     * output txtmorningQty_Changed() method
     */
    public void txtmorningQty_Changed() throws Exception
    {
        System.out.println("txtmorningQty_Changed() Function is executed!");
            txtafternoonQty.setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(txtslaughterAmt.getValue())- com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(txtmorningQty.getValue())));


    }

    /**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("materialNum".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"materialNum").getValue(),"name")));

}

    if ("materialNum".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"materialNum").getValue(),"model")));

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
        sic.add(new SelectorItemInfo("buyFreight"));
        sic.add(new SelectorItemInfo("buyMoney"));
        sic.add(new SelectorItemInfo("costPrice"));
        sic.add(new SelectorItemInfo("GrossChickenCost"));
        sic.add(new SelectorItemInfo("settlementCarcass"));
        sic.add(new SelectorItemInfo("settlementGrossWgt"));
        sic.add(new SelectorItemInfo("marketPrice"));
        sic.add(new SelectorItemInfo("GrossChickenAPrice"));
        sic.add(new SelectorItemInfo("commodityChickenAPrice"));
        sic.add(new SelectorItemInfo("tonGrossProfit"));
        sic.add(new SelectorItemInfo("commodityChickenAmt"));
        sic.add(new SelectorItemInfo("marketChickenAmt"));
        sic.add(new SelectorItemInfo("SmallChickenWgt"));
        sic.add(new SelectorItemInfo("todayNetProfit"));
        sic.add(new SelectorItemInfo("CarcassSCWgt"));
        sic.add(new SelectorItemInfo("allGrossWgt"));
        sic.add(new SelectorItemInfo("waterAbsorption"));
        sic.add(new SelectorItemInfo("allMoney"));
        sic.add(new SelectorItemInfo("mainRatio"));
        sic.add(new SelectorItemInfo("mainDivisionRatio"));
        sic.add(new SelectorItemInfo("viceRatio"));
        sic.add(new SelectorItemInfo("mainPrice"));
        sic.add(new SelectorItemInfo("vicePrice"));
        sic.add(new SelectorItemInfo("finishedProductWgt"));
        sic.add(new SelectorItemInfo("carcassRatio"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("comprehensiveRatio"));
        sic.add(new SelectorItemInfo("divisionRatio"));
        sic.add(new SelectorItemInfo("comprehensivePrice"));
        sic.add(new SelectorItemInfo("GrossChickenAWgt"));
        sic.add(new SelectorItemInfo("halfAPackProduct"));
        sic.add(new SelectorItemInfo("tonPrice"));
        sic.add(new SelectorItemInfo("ratioConstant"));
        sic.add(new SelectorItemInfo("chickenPeatherPrice"));
        sic.add(new SelectorItemInfo("chickenPeatherMoney"));
        sic.add(new SelectorItemInfo("chickenBloodMoney"));
        sic.add(new SelectorItemInfo("chickenBloodPrice"));
        sic.add(new SelectorItemInfo("chickenIntestineMoney"));
        sic.add(new SelectorItemInfo("chickenIntestinePrice"));
        sic.add(new SelectorItemInfo("chickenCropMoney"));
        sic.add(new SelectorItemInfo("chickenCropPrice"));
        sic.add(new SelectorItemInfo("mixedOilPrice"));
        sic.add(new SelectorItemInfo("mixedOilMoney"));
        sic.add(new SelectorItemInfo("backAreaLeafFatYield"));
        sic.add(new SelectorItemInfo("suetQty"));
        sic.add(new SelectorItemInfo("ResidualChickenWgt"));
        sic.add(new SelectorItemInfo("CarcassRCWgt"));
        sic.add(new SelectorItemInfo("ResidualChickenAmt"));
        sic.add(new SelectorItemInfo("headQty"));
        sic.add(new SelectorItemInfo("mainProductQty"));
        sic.add(new SelectorItemInfo("mainProductAmt"));
        sic.add(new SelectorItemInfo("byProductQty"));
        sic.add(new SelectorItemInfo("byProductAmt"));
        sic.add(new SelectorItemInfo("tonProductWater"));
        sic.add(new SelectorItemInfo("tonAllEle"));
        sic.add(new SelectorItemInfo("tonProductCoal"));
        sic.add(new SelectorItemInfo("tonPackingCost"));
        sic.add(new SelectorItemInfo("tonProductColdEle"));
        sic.add(new SelectorItemInfo("tonProductionEle"));
        sic.add(new SelectorItemInfo("halfWorkDay"));
        sic.add(new SelectorItemInfo("perCatipaEfficiency"));
        sic.add(new SelectorItemInfo("workTime"));
        sic.add(new SelectorItemInfo("attendancePeople"));
        sic.add(new SelectorItemInfo("allPeople"));
        sic.add(new SelectorItemInfo("otherProductQty"));
        sic.add(new SelectorItemInfo("otherProductAmt"));
        sic.add(new SelectorItemInfo("morningQty"));
        sic.add(new SelectorItemInfo("afternoonQty"));
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
        sic.add(new SelectorItemInfo("ShedBLossGrossWgt"));
        return sic;
    }        
    	

    /**
     * output actionGetData_actionPerformed method
     */
    public void actionGetData_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.szcount.FreshDailyFactory.getRemoteInstance().getData(editData);
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
            innerActionPerformed("eas", AbstractFreshDailyEditUI.this, "ActionGetData", "actionGetData_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.szcount.client", "FreshDailyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.szcount.client.FreshDailyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.szcount.FreshDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.FreshDailyInfo objectValue = new com.kingdee.eas.custom.szcount.FreshDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/szcount/FreshDaily";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.szcount.app.FreshDailyQuery");
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