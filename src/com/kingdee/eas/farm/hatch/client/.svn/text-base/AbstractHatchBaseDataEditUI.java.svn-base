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
public abstract class AbstractHatchBaseDataEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractHatchBaseDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggQtyPerCar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaveDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchingDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchingRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultBabyWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultEggWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultEggType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultEggSourceType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultParentWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultGrandWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultCDWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contotherProductWare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultSPDWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmthatchFactory;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteggQtyPerCar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtsaveDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthatchingDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthatchingRate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultBabyWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultEggWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDComboBox defaultEggType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox defaultEggSourceType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultParentWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultGrandWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultCDWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtotherProductWare;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultSPDWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected javax.swing.JToolBar.Separator newSeparator1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnRefresh;
    protected com.kingdee.eas.farm.hatch.HatchBaseDataInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractHatchBaseDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractHatchBaseDataEditUI.class.getName());
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
        this.conthatchFactory = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggQtyPerCar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsaveDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchingDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conthatchingRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultBabyWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultEggWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultEggType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultEggSourceType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultParentWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultGrandWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultCDWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contotherProductWare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultSPDWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmthatchFactory = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txteggQtyPerCar = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtsaveDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthatchingDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txthatchingRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtdefaultBabyWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdefaultEggWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.defaultEggType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.defaultEggSourceType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtdefaultParentWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdefaultGrandWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdefaultCDWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtotherProductWare = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdefaultSPDWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.newSeparator1 = new javax.swing.JToolBar.Separator();
        this.btnRefresh = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.conthatchFactory.setName("conthatchFactory");
        this.conteggQtyPerCar.setName("conteggQtyPerCar");
        this.contsaveDays.setName("contsaveDays");
        this.conthatchingDays.setName("conthatchingDays");
        this.conthatchingRate.setName("conthatchingRate");
        this.contbillStatus.setName("contbillStatus");
        this.contdefaultBabyWarehouse.setName("contdefaultBabyWarehouse");
        this.contdefaultEggWarehouse.setName("contdefaultEggWarehouse");
        this.contdefaultEggType.setName("contdefaultEggType");
        this.contdefaultEggSourceType.setName("contdefaultEggSourceType");
        this.contdefaultParentWarehouse.setName("contdefaultParentWarehouse");
        this.contdefaultGrandWarehouse.setName("contdefaultGrandWarehouse");
        this.contdefaultCDWarehouse.setName("contdefaultCDWarehouse");
        this.contcostCenter.setName("contcostCenter");
        this.contotherProductWare.setName("contotherProductWare");
        this.contdefaultSPDWarehouse.setName("contdefaultSPDWarehouse");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmthatchFactory.setName("prmthatchFactory");
        this.txteggQtyPerCar.setName("txteggQtyPerCar");
        this.txtsaveDays.setName("txtsaveDays");
        this.txthatchingDays.setName("txthatchingDays");
        this.txthatchingRate.setName("txthatchingRate");
        this.billStatus.setName("billStatus");
        this.prmtdefaultBabyWarehouse.setName("prmtdefaultBabyWarehouse");
        this.prmtdefaultEggWarehouse.setName("prmtdefaultEggWarehouse");
        this.defaultEggType.setName("defaultEggType");
        this.defaultEggSourceType.setName("defaultEggSourceType");
        this.prmtdefaultParentWarehouse.setName("prmtdefaultParentWarehouse");
        this.prmtdefaultGrandWarehouse.setName("prmtdefaultGrandWarehouse");
        this.prmtdefaultCDWarehouse.setName("prmtdefaultCDWarehouse");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtotherProductWare.setName("prmtotherProductWare");
        this.prmtdefaultSPDWarehouse.setName("prmtdefaultSPDWarehouse");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        this.newSeparator1.setName("newSeparator1");
        this.btnRefresh.setName("btnRefresh");
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // conthatchFactory		
        this.conthatchFactory.setBoundLabelText(resHelper.getString("conthatchFactory.boundLabelText"));		
        this.conthatchFactory.setBoundLabelLength(100);		
        this.conthatchFactory.setBoundLabelUnderline(true);		
        this.conthatchFactory.setVisible(true);
        // conteggQtyPerCar		
        this.conteggQtyPerCar.setBoundLabelText(resHelper.getString("conteggQtyPerCar.boundLabelText"));		
        this.conteggQtyPerCar.setBoundLabelLength(100);		
        this.conteggQtyPerCar.setBoundLabelUnderline(true);		
        this.conteggQtyPerCar.setVisible(true);
        // contsaveDays		
        this.contsaveDays.setBoundLabelText(resHelper.getString("contsaveDays.boundLabelText"));		
        this.contsaveDays.setBoundLabelLength(100);		
        this.contsaveDays.setBoundLabelUnderline(true);		
        this.contsaveDays.setVisible(true);
        // conthatchingDays		
        this.conthatchingDays.setBoundLabelText(resHelper.getString("conthatchingDays.boundLabelText"));		
        this.conthatchingDays.setBoundLabelLength(100);		
        this.conthatchingDays.setBoundLabelUnderline(true);		
        this.conthatchingDays.setVisible(true);
        // conthatchingRate		
        this.conthatchingRate.setBoundLabelText(resHelper.getString("conthatchingRate.boundLabelText"));		
        this.conthatchingRate.setBoundLabelLength(100);		
        this.conthatchingRate.setBoundLabelUnderline(true);		
        this.conthatchingRate.setVisible(true);
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // contdefaultBabyWarehouse		
        this.contdefaultBabyWarehouse.setBoundLabelText(resHelper.getString("contdefaultBabyWarehouse.boundLabelText"));		
        this.contdefaultBabyWarehouse.setBoundLabelLength(100);		
        this.contdefaultBabyWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultBabyWarehouse.setVisible(true);
        // contdefaultEggWarehouse		
        this.contdefaultEggWarehouse.setBoundLabelText(resHelper.getString("contdefaultEggWarehouse.boundLabelText"));		
        this.contdefaultEggWarehouse.setBoundLabelLength(100);		
        this.contdefaultEggWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultEggWarehouse.setVisible(true);
        // contdefaultEggType		
        this.contdefaultEggType.setBoundLabelText(resHelper.getString("contdefaultEggType.boundLabelText"));		
        this.contdefaultEggType.setBoundLabelLength(100);		
        this.contdefaultEggType.setBoundLabelUnderline(true);		
        this.contdefaultEggType.setVisible(true);
        // contdefaultEggSourceType		
        this.contdefaultEggSourceType.setBoundLabelText(resHelper.getString("contdefaultEggSourceType.boundLabelText"));		
        this.contdefaultEggSourceType.setBoundLabelLength(100);		
        this.contdefaultEggSourceType.setBoundLabelUnderline(true);		
        this.contdefaultEggSourceType.setVisible(true);
        // contdefaultParentWarehouse		
        this.contdefaultParentWarehouse.setBoundLabelText(resHelper.getString("contdefaultParentWarehouse.boundLabelText"));		
        this.contdefaultParentWarehouse.setBoundLabelLength(100);		
        this.contdefaultParentWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultParentWarehouse.setVisible(true);
        // contdefaultGrandWarehouse		
        this.contdefaultGrandWarehouse.setBoundLabelText(resHelper.getString("contdefaultGrandWarehouse.boundLabelText"));		
        this.contdefaultGrandWarehouse.setBoundLabelLength(100);		
        this.contdefaultGrandWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultGrandWarehouse.setVisible(true);
        // contdefaultCDWarehouse		
        this.contdefaultCDWarehouse.setBoundLabelText(resHelper.getString("contdefaultCDWarehouse.boundLabelText"));		
        this.contdefaultCDWarehouse.setBoundLabelLength(100);		
        this.contdefaultCDWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultCDWarehouse.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(true);
        // contotherProductWare		
        this.contotherProductWare.setBoundLabelText(resHelper.getString("contotherProductWare.boundLabelText"));		
        this.contotherProductWare.setBoundLabelLength(100);		
        this.contotherProductWare.setBoundLabelUnderline(true);		
        this.contotherProductWare.setVisible(true);
        // contdefaultSPDWarehouse		
        this.contdefaultSPDWarehouse.setBoundLabelText(resHelper.getString("contdefaultSPDWarehouse.boundLabelText"));		
        this.contdefaultSPDWarehouse.setBoundLabelLength(100);		
        this.contdefaultSPDWarehouse.setBoundLabelUnderline(true);		
        this.contdefaultSPDWarehouse.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmthatchFactory		
        this.prmthatchFactory.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmthatchFactory.setVisible(true);		
        this.prmthatchFactory.setEditable(true);		
        this.prmthatchFactory.setDisplayFormat("$name$");		
        this.prmthatchFactory.setEditFormat("$number$");		
        this.prmthatchFactory.setCommitFormat("$number$");		
        this.prmthatchFactory.setRequired(true);
        // txteggQtyPerCar		
        this.txteggQtyPerCar.setVisible(true);		
        this.txteggQtyPerCar.setHorizontalAlignment(2);		
        this.txteggQtyPerCar.setDataType(0);		
        this.txteggQtyPerCar.setSupportedEmpty(true);		
        this.txteggQtyPerCar.setRequired(true);
        // txtsaveDays		
        this.txtsaveDays.setVisible(true);		
        this.txtsaveDays.setHorizontalAlignment(2);		
        this.txtsaveDays.setDataType(0);		
        this.txtsaveDays.setSupportedEmpty(true);		
        this.txtsaveDays.setRequired(false);
        // txthatchingDays		
        this.txthatchingDays.setVisible(true);		
        this.txthatchingDays.setHorizontalAlignment(2);		
        this.txthatchingDays.setDataType(0);		
        this.txthatchingDays.setSupportedEmpty(true);		
        this.txthatchingDays.setRequired(true);
        // txthatchingRate		
        this.txthatchingRate.setVisible(true);		
        this.txthatchingRate.setHorizontalAlignment(2);		
        this.txthatchingRate.setDataType(1);		
        this.txthatchingRate.setSupportedEmpty(true);		
        this.txthatchingRate.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthatchingRate.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthatchingRate.setPrecision(10);		
        this.txthatchingRate.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // prmtdefaultBabyWarehouse		
        this.prmtdefaultBabyWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultBabyWarehouse.setVisible(true);		
        this.prmtdefaultBabyWarehouse.setEditable(true);		
        this.prmtdefaultBabyWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultBabyWarehouse.setEditFormat("$number$");		
        this.prmtdefaultBabyWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultBabyWarehouse.setRequired(false);
        // prmtdefaultEggWarehouse		
        this.prmtdefaultEggWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultEggWarehouse.setVisible(true);		
        this.prmtdefaultEggWarehouse.setEditable(true);		
        this.prmtdefaultEggWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultEggWarehouse.setEditFormat("$number$");		
        this.prmtdefaultEggWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultEggWarehouse.setRequired(true);
        // defaultEggType		
        this.defaultEggType.setVisible(true);		
        this.defaultEggType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggType").toArray());		
        this.defaultEggType.setRequired(false);
        // defaultEggSourceType		
        this.defaultEggSourceType.setVisible(true);		
        this.defaultEggSourceType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.hatch.EggSourceType").toArray());		
        this.defaultEggSourceType.setRequired(false);
        // prmtdefaultParentWarehouse		
        this.prmtdefaultParentWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultParentWarehouse.setVisible(true);		
        this.prmtdefaultParentWarehouse.setEditable(true);		
        this.prmtdefaultParentWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultParentWarehouse.setEditFormat("$number$");		
        this.prmtdefaultParentWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultParentWarehouse.setRequired(false);
        // prmtdefaultGrandWarehouse		
        this.prmtdefaultGrandWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultGrandWarehouse.setVisible(true);		
        this.prmtdefaultGrandWarehouse.setEditable(true);		
        this.prmtdefaultGrandWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultGrandWarehouse.setEditFormat("$number$");		
        this.prmtdefaultGrandWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultGrandWarehouse.setRequired(false);
        // prmtdefaultCDWarehouse		
        this.prmtdefaultCDWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultCDWarehouse.setVisible(true);		
        this.prmtdefaultCDWarehouse.setEditable(true);		
        this.prmtdefaultCDWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultCDWarehouse.setEditFormat("$number$");		
        this.prmtdefaultCDWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultCDWarehouse.setRequired(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setVisible(true);		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);
        // prmtotherProductWare		
        this.prmtotherProductWare.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtotherProductWare.setVisible(true);		
        this.prmtotherProductWare.setEditable(true);		
        this.prmtotherProductWare.setDisplayFormat("$name$");		
        this.prmtotherProductWare.setEditFormat("$number$");		
        this.prmtotherProductWare.setCommitFormat("$number$");		
        this.prmtotherProductWare.setRequired(false);
        // prmtdefaultSPDWarehouse		
        this.prmtdefaultSPDWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtdefaultSPDWarehouse.setVisible(true);		
        this.prmtdefaultSPDWarehouse.setEditable(true);		
        this.prmtdefaultSPDWarehouse.setDisplayFormat("$name$");		
        this.prmtdefaultSPDWarehouse.setEditFormat("$number$");		
        this.prmtdefaultSPDWarehouse.setCommitFormat("$number$");		
        this.prmtdefaultSPDWarehouse.setRequired(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        // newSeparator1		
        this.newSeparator1.setOrientation(1);
        // btnRefresh		
        this.btnRefresh.setText(resHelper.getString("btnRefresh.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmthatchFactory,txteggQtyPerCar,txtsaveDays,txthatchingDays,txthatchingRate,billStatus,prmtdefaultBabyWarehouse,prmtdefaultEggWarehouse,defaultEggType,defaultEggSourceType,prmtdefaultParentWarehouse,prmtdefaultGrandWarehouse,prmtdefaultCDWarehouse,prmtcostCenter,prmtotherProductWare,prmtdefaultSPDWarehouse}));
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
        this.setBounds(new Rectangle(0, 0, 651, 559));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(36, 46, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(340, 46, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(36, 83, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(340, 83, 270, 19));
        this.add(kDLabelContainer4, null);
        conthatchFactory.setBounds(new Rectangle(36, 120, 270, 19));
        this.add(conthatchFactory, null);
        conteggQtyPerCar.setBounds(new Rectangle(340, 157, 270, 19));
        this.add(conteggQtyPerCar, null);
        contsaveDays.setBounds(new Rectangle(36, 157, 270, 19));
        this.add(contsaveDays, null);
        conthatchingDays.setBounds(new Rectangle(36, 194, 270, 19));
        this.add(conthatchingDays, null);
        conthatchingRate.setBounds(new Rectangle(340, 194, 270, 19));
        this.add(conthatchingRate, null);
        contbillStatus.setBounds(new Rectangle(338, 343, 270, 19));
        this.add(contbillStatus, null);
        contdefaultBabyWarehouse.setBounds(new Rectangle(36, 268, 270, 19));
        this.add(contdefaultBabyWarehouse, null);
        contdefaultEggWarehouse.setBounds(new Rectangle(340, 268, 270, 19));
        this.add(contdefaultEggWarehouse, null);
        contdefaultEggType.setBounds(new Rectangle(36, 231, 270, 19));
        this.add(contdefaultEggType, null);
        contdefaultEggSourceType.setBounds(new Rectangle(340, 231, 270, 19));
        this.add(contdefaultEggSourceType, null);
        contdefaultParentWarehouse.setBounds(new Rectangle(36, 305, 270, 19));
        this.add(contdefaultParentWarehouse, null);
        contdefaultGrandWarehouse.setBounds(new Rectangle(340, 305, 270, 19));
        this.add(contdefaultGrandWarehouse, null);
        contdefaultCDWarehouse.setBounds(new Rectangle(36, 343, 270, 19));
        this.add(contdefaultCDWarehouse, null);
        contcostCenter.setBounds(new Rectangle(340, 120, 270, 19));
        this.add(contcostCenter, null);
        contotherProductWare.setBounds(new Rectangle(37, 379, 270, 19));
        this.add(contotherProductWare, null);
        contdefaultSPDWarehouse.setBounds(new Rectangle(339, 376, 270, 19));
        this.add(contdefaultSPDWarehouse, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //conthatchFactory
        conthatchFactory.setBoundEditor(prmthatchFactory);
        //conteggQtyPerCar
        conteggQtyPerCar.setBoundEditor(txteggQtyPerCar);
        //contsaveDays
        contsaveDays.setBoundEditor(txtsaveDays);
        //conthatchingDays
        conthatchingDays.setBoundEditor(txthatchingDays);
        //conthatchingRate
        conthatchingRate.setBoundEditor(txthatchingRate);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contdefaultBabyWarehouse
        contdefaultBabyWarehouse.setBoundEditor(prmtdefaultBabyWarehouse);
        //contdefaultEggWarehouse
        contdefaultEggWarehouse.setBoundEditor(prmtdefaultEggWarehouse);
        //contdefaultEggType
        contdefaultEggType.setBoundEditor(defaultEggType);
        //contdefaultEggSourceType
        contdefaultEggSourceType.setBoundEditor(defaultEggSourceType);
        //contdefaultParentWarehouse
        contdefaultParentWarehouse.setBoundEditor(prmtdefaultParentWarehouse);
        //contdefaultGrandWarehouse
        contdefaultGrandWarehouse.setBoundEditor(prmtdefaultGrandWarehouse);
        //contdefaultCDWarehouse
        contdefaultCDWarehouse.setBoundEditor(prmtdefaultCDWarehouse);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contotherProductWare
        contotherProductWare.setBoundEditor(prmtotherProductWare);
        //contdefaultSPDWarehouse
        contdefaultSPDWarehouse.setBoundEditor(prmtdefaultSPDWarehouse);

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
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
        this.toolBar.add(newSeparator1);
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
        this.toolBar.add(btnRefresh);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("hatchFactory", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmthatchFactory, "data");
		dataBinder.registerBinding("eggQtyPerCar", int.class, this.txteggQtyPerCar, "value");
		dataBinder.registerBinding("saveDays", int.class, this.txtsaveDays, "value");
		dataBinder.registerBinding("hatchingDays", int.class, this.txthatchingDays, "value");
		dataBinder.registerBinding("hatchingRate", java.math.BigDecimal.class, this.txthatchingRate, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.farm.hatch.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("defaultBabyWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultBabyWarehouse, "data");
		dataBinder.registerBinding("defaultEggWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultEggWarehouse, "data");
		dataBinder.registerBinding("defaultEggType", com.kingdee.eas.farm.hatch.EggType.class, this.defaultEggType, "selectedItem");
		dataBinder.registerBinding("defaultEggSourceType", com.kingdee.eas.farm.hatch.EggSourceType.class, this.defaultEggSourceType, "selectedItem");
		dataBinder.registerBinding("defaultParentWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultParentWarehouse, "data");
		dataBinder.registerBinding("defaultGrandWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultGrandWarehouse, "data");
		dataBinder.registerBinding("defaultCDWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultCDWarehouse, "data");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("otherProductWare", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtotherProductWare, "data");
		dataBinder.registerBinding("defaultSPDWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtdefaultSPDWarehouse, "data");		
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
	    return "com.kingdee.eas.farm.hatch.app.HatchBaseDataEditUIHandler";
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
        this.prmthatchFactory.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)ov;
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
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchFactory", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggQtyPerCar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("saveDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchingDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchingRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultBabyWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultEggWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultEggType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultEggSourceType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultParentWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultGrandWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultCDWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("otherProductWare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultSPDWarehouse", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("hatchFactory.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("hatchFactory.id"));
        	sic.add(new SelectorItemInfo("hatchFactory.number"));
        	sic.add(new SelectorItemInfo("hatchFactory.name"));
		}
        sic.add(new SelectorItemInfo("eggQtyPerCar"));
        sic.add(new SelectorItemInfo("saveDays"));
        sic.add(new SelectorItemInfo("hatchingDays"));
        sic.add(new SelectorItemInfo("hatchingRate"));
        sic.add(new SelectorItemInfo("billStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultBabyWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultBabyWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultBabyWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultBabyWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultEggWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultEggWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultEggWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultEggWarehouse.name"));
		}
        sic.add(new SelectorItemInfo("defaultEggType"));
        sic.add(new SelectorItemInfo("defaultEggSourceType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultParentWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultParentWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultParentWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultParentWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultGrandWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultGrandWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultGrandWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultGrandWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultCDWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultCDWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultCDWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultCDWarehouse.name"));
		}
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
			sic.add(new SelectorItemInfo("otherProductWare.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("otherProductWare.id"));
        	sic.add(new SelectorItemInfo("otherProductWare.number"));
        	sic.add(new SelectorItemInfo("otherProductWare.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultSPDWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultSPDWarehouse.id"));
        	sic.add(new SelectorItemInfo("defaultSPDWarehouse.number"));
        	sic.add(new SelectorItemInfo("defaultSPDWarehouse.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchBaseDataFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.hatch.HatchBaseDataFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractHatchBaseDataEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractHatchBaseDataEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.hatch.client", "HatchBaseDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.hatch.client.HatchBaseDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchBaseDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchBaseDataInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBaseDataInfo();
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmthatchFactory.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"孵化场"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txteggQtyPerCar.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"孵化蛋车装蛋数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txthatchingDays.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"出雏标准日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtdefaultEggWarehouse.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"默认蛋库"});
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
				vo.put("saveDays",new Integer(0));
vo.put("billStatus","0");
vo.put("defaultEggType","Grand");
vo.put("defaultEggSourceType",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}