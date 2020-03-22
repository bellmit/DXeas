/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractStockingBatchEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStockingBatchEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkmoltingBatch;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanelHouseEntry;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAllOut;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmatureDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contformalDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contallOutDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkinDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarm;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfemaleQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbatchQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkmatureDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkformalDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbreedDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkallOutDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitBalanceAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbalanceAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitAllEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitQcEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitFertilizeEggQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitLoanMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggCostItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contreBatch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbroodCostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreCostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostItem;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbatchContract;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitBalanceAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbalanceAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitAllEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitQcEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitFertilizeEggQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitLoanMargin;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggCostItem;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtreBatch;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbroodCostObject;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpreCostObject;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtHouseEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtHouseEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    protected ActionRecalQty actionRecalQty = null;
    /**
     * output class constructor
     */
    public AbstractStockingBatchEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractStockingBatchEditUI.class.getName());
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
        //actionRecalQty
        this.actionRecalQty = new ActionRecalQty(this);
        getActionManager().registerAction("actionRecalQty", actionRecalQty);
        this.actionRecalQty.setExtendProperty("canForewarn", "true");
        this.actionRecalQty.setExtendProperty("userDefined", "false");
        this.actionRecalQty.setExtendProperty("isObjectUpdateLock", "false");
         this.actionRecalQty.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionRecalQty.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkmoltingBatch = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanelHouseEntry = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfemaleQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisAllOut = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contmatureDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contformalDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contallOutDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkinDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtfarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfemaleQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbatchQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkmatureDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkformalDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkbreedDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkallOutDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txttotalQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcostItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbatchContract = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitBalanceAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbalanceAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitAllEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitQcEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitFertilizeEggQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitLoanMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggCostItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contreBatch = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbroodCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreCostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcostItem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtinitBalanceAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtbalanceAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitAllEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitQcEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitFertilizeEggQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtinitLoanMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmteggCostItem = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtreBatch = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbroodCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpreCostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kdtHouseEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcompany.setName("contcompany");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator5.setName("kDSeparator5");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contsex.setName("contsex");
        this.chkmoltingBatch.setName("chkmoltingBatch");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.baseStatus.setName("baseStatus");
        this.prmtcompany.setName("prmtcompany");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanelHouseEntry.setName("kDPanelHouseEntry");
        this.contbreedData.setName("contbreedData");
        this.continDate.setName("continDate");
        this.contfarm.setName("contfarm");
        this.contfemaleQty.setName("contfemaleQty");
        this.contbatchQty.setName("contbatchQty");
        this.contfarmer.setName("contfarmer");
        this.chkisAllOut.setName("chkisAllOut");
        this.contmatureDate.setName("contmatureDate");
        this.contformalDate.setName("contformalDate");
        this.contbreedDate.setName("contbreedDate");
        this.contallOutDate.setName("contallOutDate");
        this.conttotalQty.setName("conttotalQty");
        this.prmtbreedData.setName("prmtbreedData");
        this.pkinDate.setName("pkinDate");
        this.prmtfarm.setName("prmtfarm");
        this.txtfemaleQty.setName("txtfemaleQty");
        this.txtbatchQty.setName("txtbatchQty");
        this.prmtfarmer.setName("prmtfarmer");
        this.pkmatureDate.setName("pkmatureDate");
        this.pkformalDate.setName("pkformalDate");
        this.pkbreedDate.setName("pkbreedDate");
        this.pkallOutDate.setName("pkallOutDate");
        this.txttotalQty.setName("txttotalQty");
        this.contcostItem.setName("contcostItem");
        this.contbatchContract.setName("contbatchContract");
        this.continitBalanceAmount.setName("continitBalanceAmount");
        this.contbalanceAmount.setName("contbalanceAmount");
        this.continitMargin.setName("continitMargin");
        this.continitAllEggQty.setName("continitAllEggQty");
        this.continitQcEggQty.setName("continitQcEggQty");
        this.continitFertilizeEggQty.setName("continitFertilizeEggQty");
        this.continitLoanMargin.setName("continitLoanMargin");
        this.conteggCostItem.setName("conteggCostItem");
        this.contreBatch.setName("contreBatch");
        this.contbroodCostObject.setName("contbroodCostObject");
        this.contpreCostObject.setName("contpreCostObject");
        this.prmtcostItem.setName("prmtcostItem");
        this.prmtbatchContract.setName("prmtbatchContract");
        this.txtinitBalanceAmount.setName("txtinitBalanceAmount");
        this.txtbalanceAmount.setName("txtbalanceAmount");
        this.txtinitMargin.setName("txtinitMargin");
        this.txtinitAllEggQty.setName("txtinitAllEggQty");
        this.txtinitQcEggQty.setName("txtinitQcEggQty");
        this.txtinitFertilizeEggQty.setName("txtinitFertilizeEggQty");
        this.txtinitLoanMargin.setName("txtinitLoanMargin");
        this.prmteggCostItem.setName("prmteggCostItem");
        this.prmtreBatch.setName("prmtreBatch");
        this.prmtbroodCostObject.setName("prmtbroodCostObject");
        this.prmtpreCostObject.setName("prmtpreCostObject");
        this.kdtHouseEntry.setName("kdtHouseEntry");
        this.sex.setName("sex");
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
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
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
        // kDTabbedPane1
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // chkmoltingBatch		
        this.chkmoltingBatch.setText(resHelper.getString("chkmoltingBatch.text"));		
        this.chkmoltingBatch.setVisible(true);		
        this.chkmoltingBatch.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
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
        // kDPanel1
        // kDPanel2
        // kDPanelHouseEntry
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // continDate		
        this.continDate.setBoundLabelText(resHelper.getString("continDate.boundLabelText"));		
        this.continDate.setBoundLabelLength(100);		
        this.continDate.setBoundLabelUnderline(true);		
        this.continDate.setVisible(true);
        // contfarm		
        this.contfarm.setBoundLabelText(resHelper.getString("contfarm.boundLabelText"));		
        this.contfarm.setBoundLabelLength(100);		
        this.contfarm.setBoundLabelUnderline(true);		
        this.contfarm.setVisible(true);
        // contfemaleQty		
        this.contfemaleQty.setBoundLabelText(resHelper.getString("contfemaleQty.boundLabelText"));		
        this.contfemaleQty.setBoundLabelLength(100);		
        this.contfemaleQty.setBoundLabelUnderline(true);		
        this.contfemaleQty.setVisible(false);
        // contbatchQty		
        this.contbatchQty.setBoundLabelText(resHelper.getString("contbatchQty.boundLabelText"));		
        this.contbatchQty.setBoundLabelLength(100);		
        this.contbatchQty.setBoundLabelUnderline(true);		
        this.contbatchQty.setVisible(false);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // chkisAllOut		
        this.chkisAllOut.setText(resHelper.getString("chkisAllOut.text"));		
        this.chkisAllOut.setHorizontalAlignment(2);
        // contmatureDate		
        this.contmatureDate.setBoundLabelText(resHelper.getString("contmatureDate.boundLabelText"));		
        this.contmatureDate.setBoundLabelLength(100);		
        this.contmatureDate.setBoundLabelUnderline(true);		
        this.contmatureDate.setVisible(true);
        // contformalDate		
        this.contformalDate.setBoundLabelText(resHelper.getString("contformalDate.boundLabelText"));		
        this.contformalDate.setBoundLabelLength(100);		
        this.contformalDate.setBoundLabelUnderline(true);		
        this.contformalDate.setVisible(false);
        // contbreedDate		
        this.contbreedDate.setBoundLabelText(resHelper.getString("contbreedDate.boundLabelText"));		
        this.contbreedDate.setBoundLabelLength(100);		
        this.contbreedDate.setBoundLabelUnderline(true);		
        this.contbreedDate.setVisible(true);
        // contallOutDate		
        this.contallOutDate.setBoundLabelText(resHelper.getString("contallOutDate.boundLabelText"));		
        this.contallOutDate.setBoundLabelLength(100);		
        this.contallOutDate.setBoundLabelUnderline(true);		
        this.contallOutDate.setVisible(true);
        // conttotalQty		
        this.conttotalQty.setBoundLabelText(resHelper.getString("conttotalQty.boundLabelText"));		
        this.conttotalQty.setBoundLabelLength(100);		
        this.conttotalQty.setBoundLabelUnderline(true);		
        this.conttotalQty.setVisible(true);
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
					
        // pkinDate		
        this.pkinDate.setRequired(true);
        // prmtfarm		
        this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmQuery");		
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
					
        // txtfemaleQty		
        this.txtfemaleQty.setHorizontalAlignment(2);		
        this.txtfemaleQty.setDataType(1);		
        this.txtfemaleQty.setSupportedEmpty(true);		
        this.txtfemaleQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfemaleQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfemaleQty.setPrecision(4);		
        this.txtfemaleQty.setRequired(true);		
        this.txtfemaleQty.setVisible(false);
        // txtbatchQty		
        this.txtbatchQty.setHorizontalAlignment(2);		
        this.txtbatchQty.setDataType(1);		
        this.txtbatchQty.setSupportedEmpty(true);		
        this.txtbatchQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbatchQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbatchQty.setPrecision(4);		
        this.txtbatchQty.setRequired(false);		
        this.txtbatchQty.setVisible(false);
        // prmtfarmer		
        this.prmtfarmer.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");		
        this.prmtfarmer.setEditable(true);		
        this.prmtfarmer.setDisplayFormat("$name$");		
        this.prmtfarmer.setEditFormat("$number$");		
        this.prmtfarmer.setCommitFormat("$number$");		
        this.prmtfarmer.setRequired(false);
        		prmtfarmer.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI prmtfarmer_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtfarmer_F7ListUI == null) {
					try {
						prmtfarmer_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
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
					
        // pkmatureDate		
        this.pkmatureDate.setRequired(false);
        // pkformalDate		
        this.pkformalDate.setRequired(false);		
        this.pkformalDate.setVisible(false);
        // pkbreedDate		
        this.pkbreedDate.setRequired(false);
        // pkallOutDate		
        this.pkallOutDate.setRequired(false);
        // txttotalQty		
        this.txttotalQty.setHorizontalAlignment(2);		
        this.txttotalQty.setDataType(1);		
        this.txttotalQty.setSupportedEmpty(true);		
        this.txttotalQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalQty.setPrecision(4);		
        this.txttotalQty.setRequired(false);
        // contcostItem		
        this.contcostItem.setBoundLabelText(resHelper.getString("contcostItem.boundLabelText"));		
        this.contcostItem.setBoundLabelLength(100);		
        this.contcostItem.setBoundLabelUnderline(true);		
        this.contcostItem.setVisible(true);
        // contbatchContract		
        this.contbatchContract.setBoundLabelText(resHelper.getString("contbatchContract.boundLabelText"));		
        this.contbatchContract.setBoundLabelLength(100);		
        this.contbatchContract.setBoundLabelUnderline(true);		
        this.contbatchContract.setVisible(true);
        // continitBalanceAmount		
        this.continitBalanceAmount.setBoundLabelText(resHelper.getString("continitBalanceAmount.boundLabelText"));		
        this.continitBalanceAmount.setBoundLabelLength(100);		
        this.continitBalanceAmount.setBoundLabelUnderline(true);		
        this.continitBalanceAmount.setVisible(true);
        // contbalanceAmount		
        this.contbalanceAmount.setBoundLabelText(resHelper.getString("contbalanceAmount.boundLabelText"));		
        this.contbalanceAmount.setBoundLabelLength(100);		
        this.contbalanceAmount.setBoundLabelUnderline(true);		
        this.contbalanceAmount.setVisible(true);
        // continitMargin		
        this.continitMargin.setBoundLabelText(resHelper.getString("continitMargin.boundLabelText"));		
        this.continitMargin.setBoundLabelLength(100);		
        this.continitMargin.setBoundLabelUnderline(true);		
        this.continitMargin.setVisible(true);
        // continitAllEggQty		
        this.continitAllEggQty.setBoundLabelText(resHelper.getString("continitAllEggQty.boundLabelText"));		
        this.continitAllEggQty.setBoundLabelLength(100);		
        this.continitAllEggQty.setBoundLabelUnderline(true);		
        this.continitAllEggQty.setVisible(true);
        // continitQcEggQty		
        this.continitQcEggQty.setBoundLabelText(resHelper.getString("continitQcEggQty.boundLabelText"));		
        this.continitQcEggQty.setBoundLabelLength(100);		
        this.continitQcEggQty.setBoundLabelUnderline(true);		
        this.continitQcEggQty.setVisible(true);
        // continitFertilizeEggQty		
        this.continitFertilizeEggQty.setBoundLabelText(resHelper.getString("continitFertilizeEggQty.boundLabelText"));		
        this.continitFertilizeEggQty.setBoundLabelLength(100);		
        this.continitFertilizeEggQty.setBoundLabelUnderline(true);		
        this.continitFertilizeEggQty.setVisible(true);
        // continitLoanMargin		
        this.continitLoanMargin.setBoundLabelText(resHelper.getString("continitLoanMargin.boundLabelText"));		
        this.continitLoanMargin.setBoundLabelLength(100);		
        this.continitLoanMargin.setBoundLabelUnderline(true);		
        this.continitLoanMargin.setVisible(true);
        // conteggCostItem		
        this.conteggCostItem.setBoundLabelText(resHelper.getString("conteggCostItem.boundLabelText"));		
        this.conteggCostItem.setBoundLabelLength(100);		
        this.conteggCostItem.setBoundLabelUnderline(true);		
        this.conteggCostItem.setVisible(true);
        // contreBatch		
        this.contreBatch.setBoundLabelText(resHelper.getString("contreBatch.boundLabelText"));		
        this.contreBatch.setBoundLabelLength(100);		
        this.contreBatch.setBoundLabelUnderline(true);		
        this.contreBatch.setVisible(true);
        // contbroodCostObject		
        this.contbroodCostObject.setBoundLabelText(resHelper.getString("contbroodCostObject.boundLabelText"));		
        this.contbroodCostObject.setBoundLabelLength(100);		
        this.contbroodCostObject.setBoundLabelUnderline(true);		
        this.contbroodCostObject.setVisible(true);
        // contpreCostObject		
        this.contpreCostObject.setBoundLabelText(resHelper.getString("contpreCostObject.boundLabelText"));		
        this.contpreCostObject.setBoundLabelLength(100);		
        this.contpreCostObject.setBoundLabelUnderline(true);		
        this.contpreCostObject.setVisible(true);
        // prmtcostItem		
        this.prmtcostItem.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtcostItem.setEditable(true);		
        this.prmtcostItem.setDisplayFormat("$name$");		
        this.prmtcostItem.setEditFormat("$number$");		
        this.prmtcostItem.setCommitFormat("$number$");		
        this.prmtcostItem.setRequired(false);
        // prmtbatchContract		
        this.prmtbatchContract.setQueryInfo("com.kingdee.eas.farm.stocking.processbizill.app.BatchContractQuery");		
        this.prmtbatchContract.setEditable(true);		
        this.prmtbatchContract.setDisplayFormat("$number$");		
        this.prmtbatchContract.setEditFormat("$number$");		
        this.prmtbatchContract.setCommitFormat("$number$");		
        this.prmtbatchContract.setRequired(false);
        // txtinitBalanceAmount		
        this.txtinitBalanceAmount.setHorizontalAlignment(2);		
        this.txtinitBalanceAmount.setDataType(1);		
        this.txtinitBalanceAmount.setSupportedEmpty(true);		
        this.txtinitBalanceAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitBalanceAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitBalanceAmount.setPrecision(2);		
        this.txtinitBalanceAmount.setRequired(false);		
        this.txtinitBalanceAmount.setEnabled(false);
        // txtbalanceAmount		
        this.txtbalanceAmount.setHorizontalAlignment(2);		
        this.txtbalanceAmount.setDataType(1);		
        this.txtbalanceAmount.setSupportedEmpty(true);		
        this.txtbalanceAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbalanceAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbalanceAmount.setPrecision(2);		
        this.txtbalanceAmount.setRequired(false);		
        this.txtbalanceAmount.setEnabled(false);
        // txtinitMargin		
        this.txtinitMargin.setHorizontalAlignment(2);		
        this.txtinitMargin.setDataType(1);		
        this.txtinitMargin.setSupportedEmpty(true);		
        this.txtinitMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitMargin.setPrecision(2);		
        this.txtinitMargin.setRequired(false);
        // txtinitAllEggQty		
        this.txtinitAllEggQty.setHorizontalAlignment(2);		
        this.txtinitAllEggQty.setDataType(1);		
        this.txtinitAllEggQty.setSupportedEmpty(true);		
        this.txtinitAllEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitAllEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitAllEggQty.setPrecision(4);		
        this.txtinitAllEggQty.setRequired(false);
        // txtinitQcEggQty		
        this.txtinitQcEggQty.setHorizontalAlignment(2);		
        this.txtinitQcEggQty.setDataType(1);		
        this.txtinitQcEggQty.setSupportedEmpty(true);		
        this.txtinitQcEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitQcEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitQcEggQty.setPrecision(4);		
        this.txtinitQcEggQty.setRequired(false);
        // txtinitFertilizeEggQty		
        this.txtinitFertilizeEggQty.setHorizontalAlignment(2);		
        this.txtinitFertilizeEggQty.setDataType(1);		
        this.txtinitFertilizeEggQty.setSupportedEmpty(true);		
        this.txtinitFertilizeEggQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitFertilizeEggQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitFertilizeEggQty.setPrecision(4);		
        this.txtinitFertilizeEggQty.setRequired(false);
        // txtinitLoanMargin		
        this.txtinitLoanMargin.setHorizontalAlignment(2);		
        this.txtinitLoanMargin.setDataType(1);		
        this.txtinitLoanMargin.setSupportedEmpty(true);		
        this.txtinitLoanMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinitLoanMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinitLoanMargin.setPrecision(2);		
        this.txtinitLoanMargin.setRequired(false);
        // prmteggCostItem		
        this.prmteggCostItem.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmteggCostItem.setEditable(true);		
        this.prmteggCostItem.setDisplayFormat("$number$");		
        this.prmteggCostItem.setEditFormat("$number$");		
        this.prmteggCostItem.setCommitFormat("$number$");		
        this.prmteggCostItem.setRequired(false);
        // prmtreBatch		
        this.prmtreBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        this.prmtreBatch.setVisible(true);		
        this.prmtreBatch.setEditable(true);		
        this.prmtreBatch.setDisplayFormat("$name$");		
        this.prmtreBatch.setEditFormat("$number$");		
        this.prmtreBatch.setCommitFormat("$number$");		
        this.prmtreBatch.setRequired(false);
        		prmtreBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtreBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtreBatch_F7ListUI == null) {
					try {
						prmtreBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtreBatch_F7ListUI));
					prmtreBatch_F7ListUI.setF7Use(true,ctx);
					prmtreBatch.setSelector(prmtreBatch_F7ListUI);
				}
			}
		});
					
        // prmtbroodCostObject		
        this.prmtbroodCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtbroodCostObject.setVisible(true);		
        this.prmtbroodCostObject.setEditable(true);		
        this.prmtbroodCostObject.setDisplayFormat("$name$");		
        this.prmtbroodCostObject.setEditFormat("$number$");		
        this.prmtbroodCostObject.setCommitFormat("$number$");		
        this.prmtbroodCostObject.setRequired(false);
        // prmtpreCostObject		
        this.prmtpreCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtpreCostObject.setVisible(true);		
        this.prmtpreCostObject.setEditable(true);		
        this.prmtpreCostObject.setDisplayFormat("$name$");		
        this.prmtpreCostObject.setEditFormat("$number$");		
        this.prmtpreCostObject.setCommitFormat("$number$");		
        this.prmtpreCostObject.setRequired(false);
        // kdtHouseEntry
		String kdtHouseEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"house\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"rlData\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"femaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"isAllOut\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"formalDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"allOutDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{house}</t:Cell><t:Cell>$Resource{inData}</t:Cell><t:Cell>$Resource{rlData}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{femaleQty}</t:Cell><t:Cell>$Resource{isAllOut}</t:Cell><t:Cell>$Resource{formalDate}</t:Cell><t:Cell>$Resource{allOutDate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtHouseEntry.setFormatXml(resHelper.translateString("kdtHouseEntry",kdtHouseEntryStrXML));

                this.kdtHouseEntry.putBindContents("editData",new String[] {"seq","house","inData","rlData","qty","femaleQty","isAllOut","formalDate","allOutDate"});


        this.kdtHouseEntry.checkParsed();
        final KDBizPromptBox kdtHouseEntry_house_PromptBox = new KDBizPromptBox();
        kdtHouseEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
        kdtHouseEntry_house_PromptBox.setVisible(true);
        kdtHouseEntry_house_PromptBox.setEditable(true);
        kdtHouseEntry_house_PromptBox.setDisplayFormat("$number$");
        kdtHouseEntry_house_PromptBox.setEditFormat("$number$");
        kdtHouseEntry_house_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtHouseEntry_house_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_house_PromptBox);
        this.kdtHouseEntry.getColumn("house").setEditor(kdtHouseEntry_house_CellEditor);
        ObjectValueRender kdtHouseEntry_house_OVR = new ObjectValueRender();
        kdtHouseEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtHouseEntry.getColumn("house").setRenderer(kdtHouseEntry_house_OVR);
        KDDatePicker kdtHouseEntry_inData_DatePicker = new KDDatePicker();
        kdtHouseEntry_inData_DatePicker.setName("kdtHouseEntry_inData_DatePicker");
        kdtHouseEntry_inData_DatePicker.setVisible(true);
        kdtHouseEntry_inData_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtHouseEntry_inData_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_inData_DatePicker);
        this.kdtHouseEntry.getColumn("inData").setEditor(kdtHouseEntry_inData_CellEditor);
        KDDatePicker kdtHouseEntry_rlData_DatePicker = new KDDatePicker();
        kdtHouseEntry_rlData_DatePicker.setName("kdtHouseEntry_rlData_DatePicker");
        kdtHouseEntry_rlData_DatePicker.setVisible(true);
        kdtHouseEntry_rlData_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtHouseEntry_rlData_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_rlData_DatePicker);
        this.kdtHouseEntry.getColumn("rlData").setEditor(kdtHouseEntry_rlData_CellEditor);
        KDFormattedTextField kdtHouseEntry_qty_TextField = new KDFormattedTextField();
        kdtHouseEntry_qty_TextField.setName("kdtHouseEntry_qty_TextField");
        kdtHouseEntry_qty_TextField.setVisible(true);
        kdtHouseEntry_qty_TextField.setEditable(true);
        kdtHouseEntry_qty_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_qty_TextField.setDataType(1);
        	kdtHouseEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_qty_TextField);
        this.kdtHouseEntry.getColumn("qty").setEditor(kdtHouseEntry_qty_CellEditor);
        KDFormattedTextField kdtHouseEntry_femaleQty_TextField = new KDFormattedTextField();
        kdtHouseEntry_femaleQty_TextField.setName("kdtHouseEntry_femaleQty_TextField");
        kdtHouseEntry_femaleQty_TextField.setVisible(true);
        kdtHouseEntry_femaleQty_TextField.setEditable(true);
        kdtHouseEntry_femaleQty_TextField.setHorizontalAlignment(2);
        kdtHouseEntry_femaleQty_TextField.setDataType(1);
        	kdtHouseEntry_femaleQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtHouseEntry_femaleQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtHouseEntry_femaleQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtHouseEntry_femaleQty_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_femaleQty_TextField);
        this.kdtHouseEntry.getColumn("femaleQty").setEditor(kdtHouseEntry_femaleQty_CellEditor);
        KDCheckBox kdtHouseEntry_isAllOut_CheckBox = new KDCheckBox();
        kdtHouseEntry_isAllOut_CheckBox.setName("kdtHouseEntry_isAllOut_CheckBox");
        KDTDefaultCellEditor kdtHouseEntry_isAllOut_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_isAllOut_CheckBox);
        this.kdtHouseEntry.getColumn("isAllOut").setEditor(kdtHouseEntry_isAllOut_CellEditor);
        KDDatePicker kdtHouseEntry_formalDate_DatePicker = new KDDatePicker();
        kdtHouseEntry_formalDate_DatePicker.setName("kdtHouseEntry_formalDate_DatePicker");
        kdtHouseEntry_formalDate_DatePicker.setVisible(true);
        kdtHouseEntry_formalDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtHouseEntry_formalDate_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_formalDate_DatePicker);
        this.kdtHouseEntry.getColumn("formalDate").setEditor(kdtHouseEntry_formalDate_CellEditor);
        KDDatePicker kdtHouseEntry_allOutDate_DatePicker = new KDDatePicker();
        kdtHouseEntry_allOutDate_DatePicker.setName("kdtHouseEntry_allOutDate_DatePicker");
        kdtHouseEntry_allOutDate_DatePicker.setVisible(true);
        kdtHouseEntry_allOutDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtHouseEntry_allOutDate_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_allOutDate_DatePicker);
        this.kdtHouseEntry.getColumn("allOutDate").setEditor(kdtHouseEntry_allOutDate_CellEditor);
        // sex		
        this.sex.setVisible(true);		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.app.sex").toArray());		
        this.sex.setRequired(true);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,prmtbreedData,baseStatus,txtbatchQty,pkinDate,prmtcompany,prmtauditor,pkauditTime,txtfemaleQty,prmtcostItem,prmtfarmer,prmtfarm,prmtbatchContract,txtinitBalanceAmount,txtbalanceAmount,txtinitMargin,txtinitAllEggQty,txtinitQcEggQty,txtinitFertilizeEggQty,txtinitLoanMargin,chkisAllOut,pkmatureDate,prmteggCostItem,pkformalDate,pkbreedDate,pkallOutDate,txttotalQty,kdtHouseEntry,prmtreBatch,prmtbroodCostObject,prmtpreCostObject,sex,chkmoltingBatch}));
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
        this.setBounds(new Rectangle(0, 0, 704, 444));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(46, 3, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(371, 4, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(695, 124, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(695, 161, 270, 19));
        this.add(kDLabelContainer4, null);
        contbaseStatus.setBounds(new Rectangle(373, 40, 270, 19));
        this.add(contbaseStatus, null);
        contcompany.setBounds(new Rectangle(46, 40, 270, 19));
        this.add(contcompany, null);
        contauditor.setBounds(new Rectangle(53, 368, 270, 19));
        this.add(contauditor, null);
        contauditTime.setBounds(new Rectangle(368, 368, 270, 19));
        this.add(contauditTime, null);
        kDSeparator5.setBounds(new Rectangle(37, 353, 637, 8));
        this.add(kDSeparator5, null);
        contcreator.setBounds(new Rectangle(53, 402, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(368, 402, 270, 19));
        this.add(contcreateTime, null);
        kDTabbedPane1.setBounds(new Rectangle(33, 93, 617, 257));
        this.add(kDTabbedPane1, null);
        contsex.setBounds(new Rectangle(46, 71, 270, 19));
        this.add(contsex, null);
        chkmoltingBatch.setBounds(new Rectangle(373, 71, 270, 19));
        this.add(chkmoltingBatch, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanelHouseEntry, resHelper.getString("kDPanelHouseEntry.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        contbreedData.setBounds(new Rectangle(12, 21, 270, 19));
        kDPanel1.add(contbreedData, null);
        continDate.setBounds(new Rectangle(327, 21, 270, 19));
        kDPanel1.add(continDate, null);
        contfarm.setBounds(new Rectangle(327, 58, 270, 19));
        kDPanel1.add(contfarm, null);
        contfemaleQty.setBounds(new Rectangle(327, 95, 270, 19));
        kDPanel1.add(contfemaleQty, null);
        contbatchQty.setBounds(new Rectangle(12, 95, 270, 19));
        kDPanel1.add(contbatchQty, null);
        contfarmer.setBounds(new Rectangle(12, 58, 270, 19));
        kDPanel1.add(contfarmer, null);
        chkisAllOut.setBounds(new Rectangle(327, 161, 95, 19));
        kDPanel1.add(chkisAllOut, null);
        contmatureDate.setBounds(new Rectangle(327, 135, 270, 19));
        kDPanel1.add(contmatureDate, null);
        contformalDate.setBounds(new Rectangle(12, 170, 270, 19));
        kDPanel1.add(contformalDate, null);
        contbreedDate.setBounds(new Rectangle(12, 132, 270, 19));
        kDPanel1.add(contbreedDate, null);
        contallOutDate.setBounds(new Rectangle(328, 182, 270, 19));
        kDPanel1.add(contallOutDate, null);
        conttotalQty.setBounds(new Rectangle(12, 200, 270, 19));
        kDPanel1.add(conttotalQty, null);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //continDate
        continDate.setBoundEditor(pkinDate);
        //contfarm
        contfarm.setBoundEditor(prmtfarm);
        //contfemaleQty
        contfemaleQty.setBoundEditor(txtfemaleQty);
        //contbatchQty
        contbatchQty.setBoundEditor(txtbatchQty);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contmatureDate
        contmatureDate.setBoundEditor(pkmatureDate);
        //contformalDate
        contformalDate.setBoundEditor(pkformalDate);
        //contbreedDate
        contbreedDate.setBoundEditor(pkbreedDate);
        //contallOutDate
        contallOutDate.setBoundEditor(pkallOutDate);
        //conttotalQty
        conttotalQty.setBoundEditor(txttotalQty);
        //kDPanel2
        kDPanel2.setLayout(null);        contcostItem.setBounds(new Rectangle(325, 12, 270, 19));
        kDPanel2.add(contcostItem, null);
        contbatchContract.setBounds(new Rectangle(325, 105, 270, 19));
        kDPanel2.add(contbatchContract, null);
        continitBalanceAmount.setBounds(new Rectangle(23, 74, 270, 19));
        kDPanel2.add(continitBalanceAmount, null);
        contbalanceAmount.setBounds(new Rectangle(325, 74, 270, 19));
        kDPanel2.add(contbalanceAmount, null);
        continitMargin.setBounds(new Rectangle(23, 105, 270, 19));
        kDPanel2.add(continitMargin, null);
        continitAllEggQty.setBounds(new Rectangle(23, 167, 270, 19));
        kDPanel2.add(continitAllEggQty, null);
        continitQcEggQty.setBounds(new Rectangle(23, 136, 270, 19));
        kDPanel2.add(continitQcEggQty, null);
        continitFertilizeEggQty.setBounds(new Rectangle(325, 169, 270, 19));
        kDPanel2.add(continitFertilizeEggQty, null);
        continitLoanMargin.setBounds(new Rectangle(325, 136, 270, 19));
        kDPanel2.add(continitLoanMargin, null);
        conteggCostItem.setBounds(new Rectangle(325, 43, 270, 19));
        kDPanel2.add(conteggCostItem, null);
        contreBatch.setBounds(new Rectangle(23, 203, 270, 19));
        kDPanel2.add(contreBatch, null);
        contbroodCostObject.setBounds(new Rectangle(23, 12, 270, 19));
        kDPanel2.add(contbroodCostObject, null);
        contpreCostObject.setBounds(new Rectangle(23, 43, 270, 19));
        kDPanel2.add(contpreCostObject, null);
        //contcostItem
        contcostItem.setBoundEditor(prmtcostItem);
        //contbatchContract
        contbatchContract.setBoundEditor(prmtbatchContract);
        //continitBalanceAmount
        continitBalanceAmount.setBoundEditor(txtinitBalanceAmount);
        //contbalanceAmount
        contbalanceAmount.setBoundEditor(txtbalanceAmount);
        //continitMargin
        continitMargin.setBoundEditor(txtinitMargin);
        //continitAllEggQty
        continitAllEggQty.setBoundEditor(txtinitAllEggQty);
        //continitQcEggQty
        continitQcEggQty.setBoundEditor(txtinitQcEggQty);
        //continitFertilizeEggQty
        continitFertilizeEggQty.setBoundEditor(txtinitFertilizeEggQty);
        //continitLoanMargin
        continitLoanMargin.setBoundEditor(txtinitLoanMargin);
        //conteggCostItem
        conteggCostItem.setBoundEditor(prmteggCostItem);
        //contreBatch
        contreBatch.setBoundEditor(prmtreBatch);
        //contbroodCostObject
        contbroodCostObject.setBoundEditor(prmtbroodCostObject);
        //contpreCostObject
        contpreCostObject.setBoundEditor(prmtpreCostObject);
        //kDPanelHouseEntry
        kDPanelHouseEntry.setLayout(null);        kdtHouseEntry.setBounds(new Rectangle(5, 4, 606, 201));
        kdtHouseEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtHouseEntry,new com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo(),null,false);
        kDPanelHouseEntry.add(kdtHouseEntry_detailPanel, null);
		kdtHouseEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
		vo.put("qty",new java.math.BigDecimal(0));
		vo.put("femaleQty",new java.math.BigDecimal(0));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //contsex
        contsex.setBoundEditor(sex);

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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnRemove);
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
		dataBinder.registerBinding("moltingBatch", boolean.class, this.chkmoltingBatch, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("isAllOut", boolean.class, this.chkisAllOut, "selected");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("inDate", java.util.Date.class, this.pkinDate, "value");
		dataBinder.registerBinding("farm", com.kingdee.eas.farm.stocking.basedata.FarmInfo.class, this.prmtfarm, "data");
		dataBinder.registerBinding("femaleQty", java.math.BigDecimal.class, this.txtfemaleQty, "value");
		dataBinder.registerBinding("batchQty", java.math.BigDecimal.class, this.txtbatchQty, "value");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("matureDate", java.util.Date.class, this.pkmatureDate, "value");
		dataBinder.registerBinding("formalDate", java.util.Date.class, this.pkformalDate, "value");
		dataBinder.registerBinding("breedDate", java.util.Date.class, this.pkbreedDate, "value");
		dataBinder.registerBinding("allOutDate", java.util.Date.class, this.pkallOutDate, "value");
		dataBinder.registerBinding("totalQty", java.math.BigDecimal.class, this.txttotalQty, "value");
		dataBinder.registerBinding("costItem", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtcostItem, "data");
		dataBinder.registerBinding("batchContract", com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo.class, this.prmtbatchContract, "data");
		dataBinder.registerBinding("initBalanceAmount", java.math.BigDecimal.class, this.txtinitBalanceAmount, "value");
		dataBinder.registerBinding("balanceAmount", java.math.BigDecimal.class, this.txtbalanceAmount, "value");
		dataBinder.registerBinding("initMargin", java.math.BigDecimal.class, this.txtinitMargin, "value");
		dataBinder.registerBinding("initAllEggQty", java.math.BigDecimal.class, this.txtinitAllEggQty, "value");
		dataBinder.registerBinding("initQcEggQty", java.math.BigDecimal.class, this.txtinitQcEggQty, "value");
		dataBinder.registerBinding("initFertilizeEggQty", java.math.BigDecimal.class, this.txtinitFertilizeEggQty, "value");
		dataBinder.registerBinding("initLoanMargin", java.math.BigDecimal.class, this.txtinitLoanMargin, "value");
		dataBinder.registerBinding("eggCostItem", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmteggCostItem, "data");
		dataBinder.registerBinding("reBatch", com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo.class, this.prmtreBatch, "data");
		dataBinder.registerBinding("broodCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtbroodCostObject, "data");
		dataBinder.registerBinding("preCostObject", com.kingdee.eas.basedata.assistant.CostObjectInfo.class, this.prmtpreCostObject, "data");
		dataBinder.registerBinding("HouseEntry.seq", int.class, this.kdtHouseEntry, "seq.text");
		dataBinder.registerBinding("HouseEntry", com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo.class, this.kdtHouseEntry, "userObject");
		dataBinder.registerBinding("HouseEntry.house", java.lang.Object.class, this.kdtHouseEntry, "house.text");
		dataBinder.registerBinding("HouseEntry.qty", java.math.BigDecimal.class, this.kdtHouseEntry, "qty.text");
		dataBinder.registerBinding("HouseEntry.femaleQty", java.math.BigDecimal.class, this.kdtHouseEntry, "femaleQty.text");
		dataBinder.registerBinding("HouseEntry.inData", java.util.Date.class, this.kdtHouseEntry, "inData.text");
		dataBinder.registerBinding("HouseEntry.isAllOut", boolean.class, this.kdtHouseEntry, "isAllOut.text");
		dataBinder.registerBinding("HouseEntry.formalDate", java.util.Date.class, this.kdtHouseEntry, "formalDate.text");
		dataBinder.registerBinding("HouseEntry.allOutDate", java.util.Date.class, this.kdtHouseEntry, "allOutDate.text");
		dataBinder.registerBinding("HouseEntry.rlData", java.util.Date.class, this.kdtHouseEntry, "rlData.text");
		dataBinder.registerBinding("sex", com.kingdee.eas.farm.stocking.basedata.app.sex.class, this.sex, "selectedItem");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.StockingBatchEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)ov;
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
		getValidateHelper().registerBindProperty("moltingBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAllOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("matureDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("formalDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("allOutDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("batchContract", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initBalanceAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("balanceAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initAllEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initQcEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initFertilizeEggQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initLoanMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggCostItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("reBatch", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("broodCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preCostObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.house", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.femaleQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.inData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.isAllOut", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.formalDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.allOutDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("HouseEntry.rlData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("moltingBatch"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("baseStatus"));
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
        sic.add(new SelectorItemInfo("isAllOut"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("inDate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farm.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farm.id"));
        	sic.add(new SelectorItemInfo("farm.number"));
        	sic.add(new SelectorItemInfo("farm.name"));
		}
        sic.add(new SelectorItemInfo("femaleQty"));
        sic.add(new SelectorItemInfo("batchQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
        sic.add(new SelectorItemInfo("matureDate"));
        sic.add(new SelectorItemInfo("formalDate"));
        sic.add(new SelectorItemInfo("breedDate"));
        sic.add(new SelectorItemInfo("allOutDate"));
        sic.add(new SelectorItemInfo("totalQty"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costItem.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costItem.id"));
        	sic.add(new SelectorItemInfo("costItem.number"));
        	sic.add(new SelectorItemInfo("costItem.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("batchContract.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("batchContract.id"));
        	sic.add(new SelectorItemInfo("batchContract.number"));
		}
        sic.add(new SelectorItemInfo("initBalanceAmount"));
        sic.add(new SelectorItemInfo("balanceAmount"));
        sic.add(new SelectorItemInfo("initMargin"));
        sic.add(new SelectorItemInfo("initAllEggQty"));
        sic.add(new SelectorItemInfo("initQcEggQty"));
        sic.add(new SelectorItemInfo("initFertilizeEggQty"));
        sic.add(new SelectorItemInfo("initLoanMargin"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggCostItem.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggCostItem.id"));
        	sic.add(new SelectorItemInfo("eggCostItem.number"));
        	sic.add(new SelectorItemInfo("eggCostItem.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("reBatch.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("reBatch.id"));
        	sic.add(new SelectorItemInfo("reBatch.number"));
        	sic.add(new SelectorItemInfo("reBatch.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("broodCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("broodCostObject.id"));
        	sic.add(new SelectorItemInfo("broodCostObject.number"));
        	sic.add(new SelectorItemInfo("broodCostObject.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("preCostObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("preCostObject.id"));
        	sic.add(new SelectorItemInfo("preCostObject.number"));
        	sic.add(new SelectorItemInfo("preCostObject.name"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("HouseEntry.house.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("HouseEntry.house.id"));
			sic.add(new SelectorItemInfo("HouseEntry.house.name"));
        	sic.add(new SelectorItemInfo("HouseEntry.house.number"));
		}
    	sic.add(new SelectorItemInfo("HouseEntry.qty"));
    	sic.add(new SelectorItemInfo("HouseEntry.femaleQty"));
    	sic.add(new SelectorItemInfo("HouseEntry.inData"));
    	sic.add(new SelectorItemInfo("HouseEntry.isAllOut"));
    	sic.add(new SelectorItemInfo("HouseEntry.formalDate"));
    	sic.add(new SelectorItemInfo("HouseEntry.allOutDate"));
    	sic.add(new SelectorItemInfo("HouseEntry.rlData"));
        sic.add(new SelectorItemInfo("sex"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance().unAudit(editData);
    }
    	

    /**
     * output actionRecalQty_actionPerformed method
     */
    public void actionRecalQty_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance().recalQty(editData);
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
	public RequestContext prepareActionRecalQty(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionRecalQty() {
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
            innerActionPerformed("eas", AbstractStockingBatchEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractStockingBatchEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionRecalQty class
     */     
    protected class ActionRecalQty extends ItemAction {     
    
        public ActionRecalQty()
        {
            this(null);
        }

        public ActionRecalQty(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionRecalQty.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRecalQty.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionRecalQty.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStockingBatchEditUI.this, "ActionRecalQty", "actionRecalQty_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "StockingBatchEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.StockingBatchEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo();
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种信息"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkinDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"批次日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfemaleQty.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"母禽数量"});
		}
		for (int i=0,n=kdtHouseEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtHouseEntry.getCell(i,"inData").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"入栏日期"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(sex.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"性别"});
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
vo.put("sex","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}