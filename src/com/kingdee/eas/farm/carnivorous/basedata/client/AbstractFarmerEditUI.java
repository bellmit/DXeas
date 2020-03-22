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
public abstract class AbstractFarmerEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractFarmerEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcustomer;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsupplier;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgeneralAsstActType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contidentity;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsex;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contage;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnation;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteduLvl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfamilyPersonCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbEBank;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerActualName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankAddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtidentity;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtmobileTel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDComboBox sex;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNo;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtage;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnation;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eduLvl;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfamilyPersonCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbEBank;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmerActualName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankAddress;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFarmEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFarmEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoccupyMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalMargin;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtenableMargin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contborrowAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtborrowAmount;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsupplier;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtgeneralAsstActType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperson;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractFarmerEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractFarmerEditUI.class.getName());
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
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contsupplier = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgeneralAsstActType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contidentity = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmobileTel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsex = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contage = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnation = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteduLvl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfamilyPersonCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbEBank = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerActualName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmerType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankAddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtidentity = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmobileTel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.sex = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtbankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtage = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtnation = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.eduLvl = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtfamilyPersonCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbEBank = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmerActualName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmerType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbankAddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kdtFarmEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contoccupyMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenableMargin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtoccupyMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtenableMargin = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contborrowAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtborrowAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtsupplier = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtgeneralAsstActType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcustomer.setName("contcustomer");
        this.kDSeparator5.setName("kDSeparator5");
        this.kDSeparator6.setName("kDSeparator6");
        this.contsupplier.setName("contsupplier");
        this.contcostCenter.setName("contcostCenter");
        this.contcompany.setName("contcompany");
        this.contgeneralAsstActType.setName("contgeneralAsstActType");
        this.contperson.setName("contperson");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.contidentity.setName("contidentity");
        this.contmobileTel.setName("contmobileTel");
        this.conttel.setName("conttel");
        this.contaddress.setName("contaddress");
        this.contsex.setName("contsex");
        this.contbankNo.setName("contbankNo");
        this.contage.setName("contage");
        this.contnation.setName("contnation");
        this.conteduLvl.setName("conteduLvl");
        this.contfamilyPersonCount.setName("contfamilyPersonCount");
        this.contbEBank.setName("contbEBank");
        this.contfarmerActualName.setName("contfarmerActualName");
        this.contfarmerType.setName("contfarmerType");
        this.contbankAddress.setName("contbankAddress");
        this.txtidentity.setName("txtidentity");
        this.txtmobileTel.setName("txtmobileTel");
        this.txttel.setName("txttel");
        this.txtaddress.setName("txtaddress");
        this.sex.setName("sex");
        this.txtbankNo.setName("txtbankNo");
        this.txtage.setName("txtage");
        this.txtnation.setName("txtnation");
        this.eduLvl.setName("eduLvl");
        this.txtfamilyPersonCount.setName("txtfamilyPersonCount");
        this.prmtbEBank.setName("prmtbEBank");
        this.txtfarmerActualName.setName("txtfarmerActualName");
        this.prmtfarmerType.setName("prmtfarmerType");
        this.txtbankAddress.setName("txtbankAddress");
        this.kdtFarmEntry.setName("kdtFarmEntry");
        this.contoccupyMargin.setName("contoccupyMargin");
        this.conttotalMargin.setName("conttotalMargin");
        this.contenableMargin.setName("contenableMargin");
        this.txtoccupyMargin.setName("txtoccupyMargin");
        this.txttotalMargin.setName("txttotalMargin");
        this.txtenableMargin.setName("txtenableMargin");
        this.contborrowAmount.setName("contborrowAmount");
        this.txtborrowAmount.setName("txtborrowAmount");
        this.baseStatus.setName("baseStatus");
        this.prmtcustomer.setName("prmtcustomer");
        this.prmtsupplier.setName("prmtsupplier");
        this.prmtcostCenter.setName("prmtcostCenter");
        this.prmtcompany.setName("prmtcompany");
        this.prmtgeneralAsstActType.setName("prmtgeneralAsstActType");
        this.prmtperson.setName("prmtperson");
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
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcustomer		
        this.contcustomer.setBoundLabelText(resHelper.getString("contcustomer.boundLabelText"));		
        this.contcustomer.setBoundLabelLength(100);		
        this.contcustomer.setBoundLabelUnderline(true);		
        this.contcustomer.setVisible(true);
        // kDSeparator5
        // kDSeparator6
        // contsupplier		
        this.contsupplier.setBoundLabelText(resHelper.getString("contsupplier.boundLabelText"));		
        this.contsupplier.setBoundLabelLength(100);		
        this.contsupplier.setBoundLabelUnderline(true);		
        this.contsupplier.setVisible(true);
        // contcostCenter		
        this.contcostCenter.setBoundLabelText(resHelper.getString("contcostCenter.boundLabelText"));		
        this.contcostCenter.setBoundLabelLength(100);		
        this.contcostCenter.setBoundLabelUnderline(true);		
        this.contcostCenter.setVisible(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contgeneralAsstActType		
        this.contgeneralAsstActType.setBoundLabelText(resHelper.getString("contgeneralAsstActType.boundLabelText"));		
        this.contgeneralAsstActType.setBoundLabelLength(100);		
        this.contgeneralAsstActType.setBoundLabelUnderline(true);		
        this.contgeneralAsstActType.setVisible(true);
        // contperson		
        this.contperson.setBoundLabelText(resHelper.getString("contperson.boundLabelText"));		
        this.contperson.setBoundLabelLength(100);		
        this.contperson.setBoundLabelUnderline(true);		
        this.contperson.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);		
        this.txtName.setEnabled(false);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kDPanel4
        // contidentity		
        this.contidentity.setBoundLabelText(resHelper.getString("contidentity.boundLabelText"));		
        this.contidentity.setBoundLabelLength(100);		
        this.contidentity.setBoundLabelUnderline(true);		
        this.contidentity.setVisible(true);
        // contmobileTel		
        this.contmobileTel.setBoundLabelText(resHelper.getString("contmobileTel.boundLabelText"));		
        this.contmobileTel.setBoundLabelLength(100);		
        this.contmobileTel.setBoundLabelUnderline(true);		
        this.contmobileTel.setVisible(true);
        // conttel		
        this.conttel.setBoundLabelText(resHelper.getString("conttel.boundLabelText"));		
        this.conttel.setBoundLabelLength(100);		
        this.conttel.setBoundLabelUnderline(true);		
        this.conttel.setVisible(true);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contsex		
        this.contsex.setBoundLabelText(resHelper.getString("contsex.boundLabelText"));		
        this.contsex.setBoundLabelLength(100);		
        this.contsex.setBoundLabelUnderline(true);		
        this.contsex.setVisible(true);
        // contbankNo		
        this.contbankNo.setBoundLabelText(resHelper.getString("contbankNo.boundLabelText"));		
        this.contbankNo.setBoundLabelLength(100);		
        this.contbankNo.setBoundLabelUnderline(true);		
        this.contbankNo.setVisible(true);
        // contage		
        this.contage.setBoundLabelText(resHelper.getString("contage.boundLabelText"));		
        this.contage.setBoundLabelLength(100);		
        this.contage.setBoundLabelUnderline(true);		
        this.contage.setVisible(true);
        // contnation		
        this.contnation.setBoundLabelText(resHelper.getString("contnation.boundLabelText"));		
        this.contnation.setBoundLabelLength(100);		
        this.contnation.setBoundLabelUnderline(true);		
        this.contnation.setVisible(true);
        // conteduLvl		
        this.conteduLvl.setBoundLabelText(resHelper.getString("conteduLvl.boundLabelText"));		
        this.conteduLvl.setBoundLabelLength(100);		
        this.conteduLvl.setBoundLabelUnderline(true);		
        this.conteduLvl.setVisible(true);
        // contfamilyPersonCount		
        this.contfamilyPersonCount.setBoundLabelText(resHelper.getString("contfamilyPersonCount.boundLabelText"));		
        this.contfamilyPersonCount.setBoundLabelLength(100);		
        this.contfamilyPersonCount.setBoundLabelUnderline(true);		
        this.contfamilyPersonCount.setVisible(true);
        // contbEBank		
        this.contbEBank.setBoundLabelText(resHelper.getString("contbEBank.boundLabelText"));		
        this.contbEBank.setBoundLabelLength(100);		
        this.contbEBank.setBoundLabelUnderline(true);		
        this.contbEBank.setVisible(true);
        // contfarmerActualName		
        this.contfarmerActualName.setBoundLabelText(resHelper.getString("contfarmerActualName.boundLabelText"));		
        this.contfarmerActualName.setBoundLabelLength(100);		
        this.contfarmerActualName.setBoundLabelUnderline(true);		
        this.contfarmerActualName.setVisible(true);
        // contfarmerType		
        this.contfarmerType.setBoundLabelText(resHelper.getString("contfarmerType.boundLabelText"));		
        this.contfarmerType.setBoundLabelLength(100);		
        this.contfarmerType.setBoundLabelUnderline(true);		
        this.contfarmerType.setVisible(true);
        // contbankAddress		
        this.contbankAddress.setBoundLabelText(resHelper.getString("contbankAddress.boundLabelText"));		
        this.contbankAddress.setBoundLabelLength(100);		
        this.contbankAddress.setBoundLabelUnderline(true);		
        this.contbankAddress.setVisible(true);
        // txtidentity		
        this.txtidentity.setHorizontalAlignment(2);		
        this.txtidentity.setMaxLength(18);		
        this.txtidentity.setRequired(true);
        // txtmobileTel		
        this.txtmobileTel.setHorizontalAlignment(2);		
        this.txtmobileTel.setMaxLength(20);		
        this.txtmobileTel.setRequired(false);
        // txttel		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(20);		
        this.txttel.setRequired(false);
        // txtaddress		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // sex		
        this.sex.addItems(EnumUtils.getEnumList("com.kingdee.eas.basedata.person.Genders").toArray());		
        this.sex.setRequired(false);
        // txtbankNo		
        this.txtbankNo.setHorizontalAlignment(2);		
        this.txtbankNo.setMaxLength(50);		
        this.txtbankNo.setRequired(false);
        // txtage		
        this.txtage.setVisible(true);		
        this.txtage.setHorizontalAlignment(2);		
        this.txtage.setDataType(0);		
        this.txtage.setSupportedEmpty(true);		
        this.txtage.setRequired(false);
        // txtnation		
        this.txtnation.setVisible(true);		
        this.txtnation.setHorizontalAlignment(2);		
        this.txtnation.setMaxLength(20);		
        this.txtnation.setRequired(false);
        // eduLvl		
        this.eduLvl.setVisible(true);		
        this.eduLvl.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.EduLvlEnum").toArray());		
        this.eduLvl.setRequired(false);
        // txtfamilyPersonCount		
        this.txtfamilyPersonCount.setVisible(true);		
        this.txtfamilyPersonCount.setHorizontalAlignment(2);		
        this.txtfamilyPersonCount.setDataType(0);		
        this.txtfamilyPersonCount.setSupportedEmpty(true);		
        this.txtfamilyPersonCount.setRequired(false);
        // prmtbEBank		
        this.prmtbEBank.setQueryInfo("com.kingdee.eas.fm.be.app.BEBankQuery");		
        this.prmtbEBank.setVisible(true);		
        this.prmtbEBank.setEditable(true);		
        this.prmtbEBank.setDisplayFormat("$name$");		
        this.prmtbEBank.setEditFormat("$number$");		
        this.prmtbEBank.setCommitFormat("$number$");		
        this.prmtbEBank.setRequired(false);
        // txtfarmerActualName		
        this.txtfarmerActualName.setVisible(true);		
        this.txtfarmerActualName.setHorizontalAlignment(2);		
        this.txtfarmerActualName.setMaxLength(100);		
        this.txtfarmerActualName.setRequired(false);
        // prmtfarmerType		
        this.prmtfarmerType.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerTypeQuery");		
        this.prmtfarmerType.setVisible(true);		
        this.prmtfarmerType.setEditable(true);		
        this.prmtfarmerType.setDisplayFormat("$name$");		
        this.prmtfarmerType.setEditFormat("$number$");		
        this.prmtfarmerType.setCommitFormat("$number$");		
        this.prmtfarmerType.setRequired(false);
        		EntityViewInfo eviprmtfarmerType = new EntityViewInfo ();
		eviprmtfarmerType.setFilter(com.kingdee.eas.framework.FrameWorkUtils.getF7FilterInfoByAuthorizedOrg(com.kingdee.eas.basedata.org.OrgType.getEnum("Company"),"FICompany.id"));
		prmtfarmerType.setEntityViewInfo(eviprmtfarmerType);
					
        // txtbankAddress		
        this.txtbankAddress.setVisible(true);		
        this.txtbankAddress.setHorizontalAlignment(2);		
        this.txtbankAddress.setMaxLength(100);		
        this.txtbankAddress.setRequired(false);
        // kdtFarmEntry
		String kdtFarmEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farm\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"memoryCode\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farm}</t:Cell><t:Cell>$Resource{memoryCode}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFarmEntry.setFormatXml(resHelper.translateString("kdtFarmEntry",kdtFarmEntryStrXML));
        kdtFarmEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFarmEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFarmEntry.putBindContents("editData",new String[] {"seq","farm","memoryCode"});


        this.kdtFarmEntry.checkParsed();
        KDFormattedTextField kdtFarmEntry_seq_TextField = new KDFormattedTextField();
        kdtFarmEntry_seq_TextField.setName("kdtFarmEntry_seq_TextField");
        kdtFarmEntry_seq_TextField.setVisible(true);
        kdtFarmEntry_seq_TextField.setEditable(true);
        kdtFarmEntry_seq_TextField.setHorizontalAlignment(2);
        kdtFarmEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFarmEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_seq_TextField);
        this.kdtFarmEntry.getColumn("seq").setEditor(kdtFarmEntry_seq_CellEditor);
        final KDBizPromptBox kdtFarmEntry_farm_PromptBox = new KDBizPromptBox();
        kdtFarmEntry_farm_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmQuery");
        kdtFarmEntry_farm_PromptBox.setVisible(true);
        kdtFarmEntry_farm_PromptBox.setEditable(true);
        kdtFarmEntry_farm_PromptBox.setDisplayFormat("$number$");
        kdtFarmEntry_farm_PromptBox.setEditFormat("$number$");
        kdtFarmEntry_farm_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFarmEntry_farm_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_farm_PromptBox);
        this.kdtFarmEntry.getColumn("farm").setEditor(kdtFarmEntry_farm_CellEditor);
        ObjectValueRender kdtFarmEntry_farm_OVR = new ObjectValueRender();
        kdtFarmEntry_farm_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtFarmEntry.getColumn("farm").setRenderer(kdtFarmEntry_farm_OVR);
        			kdtFarmEntry_farm_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI kdtFarmEntry_farm_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtFarmEntry_farm_PromptBox_F7ListUI == null) {
					try {
						kdtFarmEntry_farm_PromptBox_F7ListUI = new com.kingdee.eas.farm.carnivorous.basedata.client.FarmListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtFarmEntry_farm_PromptBox_F7ListUI));
					kdtFarmEntry_farm_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtFarmEntry_farm_PromptBox.setSelector(kdtFarmEntry_farm_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtFarmEntry_memoryCode_TextField = new KDTextField();
        kdtFarmEntry_memoryCode_TextField.setName("kdtFarmEntry_memoryCode_TextField");
        kdtFarmEntry_memoryCode_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFarmEntry_memoryCode_CellEditor = new KDTDefaultCellEditor(kdtFarmEntry_memoryCode_TextField);
        this.kdtFarmEntry.getColumn("memoryCode").setEditor(kdtFarmEntry_memoryCode_CellEditor);
        // contoccupyMargin		
        this.contoccupyMargin.setBoundLabelText(resHelper.getString("contoccupyMargin.boundLabelText"));		
        this.contoccupyMargin.setBoundLabelLength(100);		
        this.contoccupyMargin.setBoundLabelUnderline(true);		
        this.contoccupyMargin.setVisible(true);
        // conttotalMargin		
        this.conttotalMargin.setBoundLabelText(resHelper.getString("conttotalMargin.boundLabelText"));		
        this.conttotalMargin.setBoundLabelLength(100);		
        this.conttotalMargin.setBoundLabelUnderline(true);		
        this.conttotalMargin.setVisible(true);
        // contenableMargin		
        this.contenableMargin.setBoundLabelText(resHelper.getString("contenableMargin.boundLabelText"));		
        this.contenableMargin.setBoundLabelLength(100);		
        this.contenableMargin.setBoundLabelUnderline(true);		
        this.contenableMargin.setVisible(true);
        // txtoccupyMargin		
        this.txtoccupyMargin.setVisible(true);		
        this.txtoccupyMargin.setHorizontalAlignment(2);		
        this.txtoccupyMargin.setDataType(1);		
        this.txtoccupyMargin.setSupportedEmpty(true);		
        this.txtoccupyMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoccupyMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoccupyMargin.setPrecision(2);		
        this.txtoccupyMargin.setRequired(false);		
        this.txtoccupyMargin.setEnabled(false);
        // txttotalMargin		
        this.txttotalMargin.setVisible(true);		
        this.txttotalMargin.setHorizontalAlignment(2);		
        this.txttotalMargin.setDataType(1);		
        this.txttotalMargin.setSupportedEmpty(true);		
        this.txttotalMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalMargin.setPrecision(2);		
        this.txttotalMargin.setRequired(false);		
        this.txttotalMargin.setEnabled(false);
        // txtenableMargin		
        this.txtenableMargin.setVisible(true);		
        this.txtenableMargin.setHorizontalAlignment(2);		
        this.txtenableMargin.setDataType(1);		
        this.txtenableMargin.setSupportedEmpty(true);		
        this.txtenableMargin.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtenableMargin.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtenableMargin.setPrecision(2);		
        this.txtenableMargin.setRequired(false);		
        this.txtenableMargin.setEnabled(false);
        // contborrowAmount		
        this.contborrowAmount.setBoundLabelText(resHelper.getString("contborrowAmount.boundLabelText"));		
        this.contborrowAmount.setBoundLabelLength(100);		
        this.contborrowAmount.setBoundLabelUnderline(true);		
        this.contborrowAmount.setVisible(true);
        // txtborrowAmount		
        this.txtborrowAmount.setVisible(true);		
        this.txtborrowAmount.setHorizontalAlignment(2);		
        this.txtborrowAmount.setDataType(1);		
        this.txtborrowAmount.setSupportedEmpty(true);		
        this.txtborrowAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtborrowAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtborrowAmount.setPrecision(10);		
        this.txtborrowAmount.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtcustomer		
        this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");		
        this.prmtcustomer.setEditable(true);		
        this.prmtcustomer.setDisplayFormat("$name$");		
        this.prmtcustomer.setEditFormat("$number$");		
        this.prmtcustomer.setCommitFormat("$number$");		
        this.prmtcustomer.setRequired(false);
        // prmtsupplier		
        this.prmtsupplier.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");		
        this.prmtsupplier.setEditable(true);		
        this.prmtsupplier.setDisplayFormat("$name$");		
        this.prmtsupplier.setEditFormat("$number$");		
        this.prmtsupplier.setCommitFormat("$number$");		
        this.prmtsupplier.setRequired(false);
        // prmtcostCenter		
        this.prmtcostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostCenter.setEditable(true);		
        this.prmtcostCenter.setDisplayFormat("$name$");		
        this.prmtcostCenter.setEditFormat("$number$");		
        this.prmtcostCenter.setCommitFormat("$number$");		
        this.prmtcostCenter.setRequired(false);		
        this.prmtcostCenter.setVisible(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setVisible(true);		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
        // prmtgeneralAsstActType		
        this.prmtgeneralAsstActType.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.F7GeneralAsstActTypeQuery");		
        this.prmtgeneralAsstActType.setVisible(true);		
        this.prmtgeneralAsstActType.setEditable(true);		
        this.prmtgeneralAsstActType.setDisplayFormat("$name$");		
        this.prmtgeneralAsstActType.setEditFormat("$number$");		
        this.prmtgeneralAsstActType.setCommitFormat("$number$");		
        this.prmtgeneralAsstActType.setRequired(false);		
        this.prmtgeneralAsstActType.setEnabled(false);
        // prmtperson		
        this.prmtperson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtperson.setVisible(true);		
        this.prmtperson.setEditable(true);		
        this.prmtperson.setDisplayFormat("$name$");		
        this.prmtperson.setEditFormat("$number$");		
        this.prmtperson.setCommitFormat("$number$");		
        this.prmtperson.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,txtaddress,txtidentity,txttel,txtmobileTel,prmtauditor,pkauditTime,sex,baseStatus,prmtcustomer,txtbankNo,prmtsupplier,prmtcostCenter,kdtFarmEntry,prmtcompany,txtage,txtnation,eduLvl,txtfamilyPersonCount,prmtbEBank,txtfarmerActualName,prmtgeneralAsstActType,txttotalMargin,txtenableMargin,txtoccupyMargin,prmtperson,prmtfarmerType,txtbankAddress,txtborrowAmount}));
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
        this.setBounds(new Rectangle(0, 0, 661, 586));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(29, 44, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(350, 17, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(819, 259, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(817, 294, 270, 19));
        this.add(kDLabelContainer4, null);
        contcreator.setBounds(new Rectangle(28, 537, 270, 19));
        this.add(contcreator, null);
        contcreateTime.setBounds(new Rectangle(344, 537, 270, 19));
        this.add(contcreateTime, null);
        contauditor.setBounds(new Rectangle(28, 506, 270, 19));
        this.add(contauditor, null);
        contauditTime.setBounds(new Rectangle(344, 506, 270, 19));
        this.add(contauditTime, null);
        kDTabbedPane1.setBounds(new Rectangle(23, 139, 599, 316));
        this.add(kDTabbedPane1, null);
        contbaseStatus.setBounds(new Rectangle(350, 43, 270, 19));
        this.add(contbaseStatus, null);
        contcustomer.setBounds(new Rectangle(350, 70, 270, 19));
        this.add(contcustomer, null);
        kDSeparator5.setBounds(new Rectangle(24, 476, 624, 1));
        this.add(kDSeparator5, null);
        kDSeparator6.setBounds(new Rectangle(13, 123, 622, 10));
        this.add(kDSeparator6, null);
        contsupplier.setBounds(new Rectangle(28, 72, 270, 19));
        this.add(contsupplier, null);
        contcostCenter.setBounds(new Rectangle(28, 72, 270, 19));
        this.add(contcostCenter, null);
        contcompany.setBounds(new Rectangle(27, 17, 270, 19));
        this.add(contcompany, null);
        contgeneralAsstActType.setBounds(new Rectangle(28, 99, 270, 19));
        this.add(contgeneralAsstActType, null);
        contperson.setBounds(new Rectangle(350, 99, 270, 19));
        this.add(contperson, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        contidentity.setBounds(new Rectangle(18, 8, 270, 19));
        kDPanel1.add(contidentity, null);
        contmobileTel.setBounds(new Rectangle(18, 36, 270, 19));
        kDPanel1.add(contmobileTel, null);
        conttel.setBounds(new Rectangle(306, 36, 270, 19));
        kDPanel1.add(conttel, null);
        contaddress.setBounds(new Rectangle(18, 120, 557, 19));
        kDPanel1.add(contaddress, null);
        contsex.setBounds(new Rectangle(306, 8, 270, 19));
        kDPanel1.add(contsex, null);
        contbankNo.setBounds(new Rectangle(306, 148, 266, 19));
        kDPanel1.add(contbankNo, null);
        contage.setBounds(new Rectangle(18, 64, 270, 19));
        kDPanel1.add(contage, null);
        contnation.setBounds(new Rectangle(306, 64, 270, 19));
        kDPanel1.add(contnation, null);
        conteduLvl.setBounds(new Rectangle(18, 92, 270, 19));
        kDPanel1.add(conteduLvl, null);
        contfamilyPersonCount.setBounds(new Rectangle(306, 92, 270, 19));
        kDPanel1.add(contfamilyPersonCount, null);
        contbEBank.setBounds(new Rectangle(18, 148, 270, 19));
        kDPanel1.add(contbEBank, null);
        contfarmerActualName.setBounds(new Rectangle(18, 209, 270, 19));
        kDPanel1.add(contfarmerActualName, null);
        contfarmerType.setBounds(new Rectangle(306, 209, 270, 19));
        kDPanel1.add(contfarmerType, null);
        contbankAddress.setBounds(new Rectangle(18, 176, 554, 19));
        kDPanel1.add(contbankAddress, null);
        //contidentity
        contidentity.setBoundEditor(txtidentity);
        //contmobileTel
        contmobileTel.setBoundEditor(txtmobileTel);
        //conttel
        conttel.setBoundEditor(txttel);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contsex
        contsex.setBoundEditor(sex);
        //contbankNo
        contbankNo.setBoundEditor(txtbankNo);
        //contage
        contage.setBoundEditor(txtage);
        //contnation
        contnation.setBoundEditor(txtnation);
        //conteduLvl
        conteduLvl.setBoundEditor(eduLvl);
        //contfamilyPersonCount
        contfamilyPersonCount.setBoundEditor(txtfamilyPersonCount);
        //contbEBank
        contbEBank.setBoundEditor(prmtbEBank);
        //contfarmerActualName
        contfarmerActualName.setBoundEditor(txtfarmerActualName);
        //contfarmerType
        contfarmerType.setBoundEditor(prmtfarmerType);
        //contbankAddress
        contbankAddress.setBoundEditor(txtbankAddress);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtFarmEntry.setBounds(new Rectangle(0, 0, 586, 281));
        kdtFarmEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFarmEntry,new com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo(),null,false);
        kDPanel2.add(kdtFarmEntry_detailPanel, null);
        //kDPanel3
        kDPanel3.setLayout(null);        contoccupyMargin.setBounds(new Rectangle(309, 44, 270, 19));
        kDPanel3.add(contoccupyMargin, null);
        conttotalMargin.setBounds(new Rectangle(21, 44, 270, 19));
        kDPanel3.add(conttotalMargin, null);
        contenableMargin.setBounds(new Rectangle(21, 87, 270, 19));
        kDPanel3.add(contenableMargin, null);
        //contoccupyMargin
        contoccupyMargin.setBoundEditor(txtoccupyMargin);
        //conttotalMargin
        conttotalMargin.setBoundEditor(txttotalMargin);
        //contenableMargin
        contenableMargin.setBoundEditor(txtenableMargin);
        //kDPanel4
        kDPanel4.setLayout(null);        contborrowAmount.setBounds(new Rectangle(11, 14, 270, 19));
        kDPanel4.add(contborrowAmount, null);
        //contborrowAmount
        contborrowAmount.setBoundEditor(txtborrowAmount);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcustomer
        contcustomer.setBoundEditor(prmtcustomer);
        //contsupplier
        contsupplier.setBoundEditor(prmtsupplier);
        //contcostCenter
        contcostCenter.setBoundEditor(prmtcostCenter);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contgeneralAsstActType
        contgeneralAsstActType.setBoundEditor(prmtgeneralAsstActType);
        //contperson
        contperson.setBoundEditor(prmtperson);

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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("identity", String.class, this.txtidentity, "text");
		dataBinder.registerBinding("mobileTel", String.class, this.txtmobileTel, "text");
		dataBinder.registerBinding("tel", String.class, this.txttel, "text");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("sex", com.kingdee.eas.basedata.person.Genders.class, this.sex, "selectedItem");
		dataBinder.registerBinding("bankNo", String.class, this.txtbankNo, "text");
		dataBinder.registerBinding("age", int.class, this.txtage, "value");
		dataBinder.registerBinding("nation", String.class, this.txtnation, "text");
		dataBinder.registerBinding("eduLvl", com.kingdee.eas.farm.stocking.basedata.EduLvlEnum.class, this.eduLvl, "selectedItem");
		dataBinder.registerBinding("familyPersonCount", int.class, this.txtfamilyPersonCount, "value");
		dataBinder.registerBinding("bEBank", com.kingdee.eas.fm.be.BEBankInfo.class, this.prmtbEBank, "data");
		dataBinder.registerBinding("farmerActualName", String.class, this.txtfarmerActualName, "text");
		dataBinder.registerBinding("farmerType", com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo.class, this.prmtfarmerType, "data");
		dataBinder.registerBinding("bankAddress", String.class, this.txtbankAddress, "text");
		dataBinder.registerBinding("FarmEntry.seq", int.class, this.kdtFarmEntry, "seq.text");
		dataBinder.registerBinding("FarmEntry", com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo.class, this.kdtFarmEntry, "userObject");
		dataBinder.registerBinding("FarmEntry.farm", java.lang.Object.class, this.kdtFarmEntry, "farm.text");
		dataBinder.registerBinding("FarmEntry.memoryCode", String.class, this.kdtFarmEntry, "memoryCode.text");
		dataBinder.registerBinding("occupyMargin", java.math.BigDecimal.class, this.txtoccupyMargin, "value");
		dataBinder.registerBinding("totalMargin", java.math.BigDecimal.class, this.txttotalMargin, "value");
		dataBinder.registerBinding("enableMargin", java.math.BigDecimal.class, this.txtenableMargin, "value");
		dataBinder.registerBinding("borrowAmount", java.math.BigDecimal.class, this.txtborrowAmount, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("customer", com.kingdee.eas.basedata.master.cssp.CustomerInfo.class, this.prmtcustomer, "data");
		dataBinder.registerBinding("supplier", com.kingdee.eas.basedata.master.cssp.SupplierInfo.class, this.prmtsupplier, "data");
		dataBinder.registerBinding("costCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostCenter, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("generalAsstActType", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtgeneralAsstActType, "data");
		dataBinder.registerBinding("person", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtperson, "data");		
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
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.FarmerEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)ov;
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
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("identity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("mobileTel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("sex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("age", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("nation", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eduLvl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("familyPersonCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bEBank", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerActualName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankAddress", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.farm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FarmEntry.memoryCode", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("occupyMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enableMargin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("borrowAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("customer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("generalAsstActType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("person", ValidateHelper.ON_SAVE);    		
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
     * output kdtFarmEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFarmEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("farm".equalsIgnoreCase(kdtFarmEntry.getColumn(colIndex).getKey())) {
kdtFarmEntry.getCell(rowIndex,"memoryCode").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFarmEntry.getCell(rowIndex,"farm").getValue(),"mnemonicCode")));

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
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("identity"));
        sic.add(new SelectorItemInfo("mobileTel"));
        sic.add(new SelectorItemInfo("tel"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("sex"));
        sic.add(new SelectorItemInfo("bankNo"));
        sic.add(new SelectorItemInfo("age"));
        sic.add(new SelectorItemInfo("nation"));
        sic.add(new SelectorItemInfo("eduLvl"));
        sic.add(new SelectorItemInfo("familyPersonCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bEBank.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bEBank.id"));
        	sic.add(new SelectorItemInfo("bEBank.number"));
        	sic.add(new SelectorItemInfo("bEBank.name"));
		}
        sic.add(new SelectorItemInfo("farmerActualName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerType.id"));
        	sic.add(new SelectorItemInfo("farmerType.number"));
        	sic.add(new SelectorItemInfo("farmerType.name"));
		}
        sic.add(new SelectorItemInfo("bankAddress"));
    	sic.add(new SelectorItemInfo("FarmEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FarmEntry.farm.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("FarmEntry.farm.id"));
			sic.add(new SelectorItemInfo("FarmEntry.farm.name"));
        	sic.add(new SelectorItemInfo("FarmEntry.farm.number"));
		}
    	sic.add(new SelectorItemInfo("FarmEntry.memoryCode"));
        sic.add(new SelectorItemInfo("occupyMargin"));
        sic.add(new SelectorItemInfo("totalMargin"));
        sic.add(new SelectorItemInfo("enableMargin"));
        sic.add(new SelectorItemInfo("borrowAmount"));
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("customer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("customer.id"));
        	sic.add(new SelectorItemInfo("customer.number"));
        	sic.add(new SelectorItemInfo("customer.name"));
		}
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
			sic.add(new SelectorItemInfo("costCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costCenter.id"));
        	sic.add(new SelectorItemInfo("costCenter.number"));
        	sic.add(new SelectorItemInfo("costCenter.name"));
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
			sic.add(new SelectorItemInfo("generalAsstActType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("generalAsstActType.id"));
        	sic.add(new SelectorItemInfo("generalAsstActType.number"));
        	sic.add(new SelectorItemInfo("generalAsstActType.name"));
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
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractFarmerEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractFarmerEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "FarmerEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.FarmerEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo();
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
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtidentity.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"身份证号码"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtFarmEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("sex",new Integer(1));
vo.put("eduLvl",new Integer(1));
vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}