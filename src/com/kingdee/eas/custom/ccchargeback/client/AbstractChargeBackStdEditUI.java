/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

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
public abstract class AbstractChargeBackStdEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractChargeBackStdEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contname;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contnumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelDermatitis;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelPulvillus;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelCrop;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbillStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelRemark;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcancelcanceler;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcancelcancelTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcancelUser;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcancelTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtname;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtnumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtlastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pklastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdescription;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdermatitisSTD;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincrProportionDer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincrAmtDer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdermatitisSTD;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincrProportionDer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincrAmtDer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpulvillusSTD;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contincrProportion;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contproportionAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpulvillusSTD;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtincrProportion;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtproportionAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcropSTD;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoefficient;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcoefficientGold;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcropSTD;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoefficient;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcoefficientGold;
    protected com.kingdee.bos.ctrl.swing.KDComboBox billStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarcassSTD;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcarcassSTD;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyieldRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contremark;
    protected com.kingdee.bos.ctrl.swing.KDScrollPane scrollPaneremark;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcancelcanceler;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcancelcancelTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcancelUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcancelTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractChargeBackStdEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractChargeBackStdEditUI.class.getName());
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
        this.contname = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contnumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlastUpdateUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlastUpdateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdescription = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.panelDermatitis = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.panelPulvillus = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.panelCrop = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contbillStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.panelRemark = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contcancelcanceler = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcancelcancelTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcancelUser = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcancelTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtname = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtlastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pklastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtdescription = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contdermatitisSTD = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincrProportionDer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincrAmtDer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdermatitisSTD = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincrProportionDer = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincrAmtDer = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contpulvillusSTD = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contincrProportion = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contproportionAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtpulvillusSTD = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtincrProportion = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtproportionAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcropSTD = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoefficient = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcoefficientGold = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcropSTD = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoefficient = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcoefficientGold = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.billStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.contcarcassSTD = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contyieldRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcarcassSTD = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtyieldRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contremark = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.scrollPaneremark = new com.kingdee.bos.ctrl.swing.KDScrollPane();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtcancelcanceler = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcancelcancelTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcancelUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcancelTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.contname.setName("contname");
        this.contnumber.setName("contnumber");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.contlastUpdateUser.setName("contlastUpdateUser");
        this.contlastUpdateTime.setName("contlastUpdateTime");
        this.contdescription.setName("contdescription");
        this.panelDermatitis.setName("panelDermatitis");
        this.panelPulvillus.setName("panelPulvillus");
        this.panelCrop.setName("panelCrop");
        this.contbillStatus.setName("contbillStatus");
        this.kDPanel1.setName("kDPanel1");
        this.panelRemark.setName("panelRemark");
        this.contcancelcanceler.setName("contcancelcanceler");
        this.contcancelcancelTime.setName("contcancelcancelTime");
        this.contcancelUser.setName("contcancelUser");
        this.contcancelTime.setName("contcancelTime");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.txtname.setName("txtname");
        this.txtnumber.setName("txtnumber");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtlastUpdateUser.setName("prmtlastUpdateUser");
        this.pklastUpdateTime.setName("pklastUpdateTime");
        this.txtdescription.setName("txtdescription");
        this.contdermatitisSTD.setName("contdermatitisSTD");
        this.contincrProportionDer.setName("contincrProportionDer");
        this.contincrAmtDer.setName("contincrAmtDer");
        this.txtdermatitisSTD.setName("txtdermatitisSTD");
        this.txtincrProportionDer.setName("txtincrProportionDer");
        this.txtincrAmtDer.setName("txtincrAmtDer");
        this.contpulvillusSTD.setName("contpulvillusSTD");
        this.contincrProportion.setName("contincrProportion");
        this.contproportionAmt.setName("contproportionAmt");
        this.txtpulvillusSTD.setName("txtpulvillusSTD");
        this.txtincrProportion.setName("txtincrProportion");
        this.txtproportionAmt.setName("txtproportionAmt");
        this.contcropSTD.setName("contcropSTD");
        this.contcoefficient.setName("contcoefficient");
        this.contcoefficientGold.setName("contcoefficientGold");
        this.txtcropSTD.setName("txtcropSTD");
        this.txtcoefficient.setName("txtcoefficient");
        this.txtcoefficientGold.setName("txtcoefficientGold");
        this.billStatus.setName("billStatus");
        this.contcarcassSTD.setName("contcarcassSTD");
        this.contyieldRate.setName("contyieldRate");
        this.txtcarcassSTD.setName("txtcarcassSTD");
        this.txtyieldRate.setName("txtyieldRate");
        this.contremark.setName("contremark");
        this.scrollPaneremark.setName("scrollPaneremark");
        this.txtremark.setName("txtremark");
        this.prmtcancelcanceler.setName("prmtcancelcanceler");
        this.pkcancelcancelTime.setName("pkcancelcancelTime");
        this.prmtcancelUser.setName("prmtcancelUser");
        this.pkcancelTime.setName("pkcancelTime");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // contname		
        this.contname.setBoundLabelText(resHelper.getString("contname.boundLabelText"));		
        this.contname.setBoundLabelLength(100);		
        this.contname.setBoundLabelUnderline(true);		
        this.contname.setVisible(true);
        // contnumber		
        this.contnumber.setBoundLabelText(resHelper.getString("contnumber.boundLabelText"));		
        this.contnumber.setBoundLabelLength(100);		
        this.contnumber.setBoundLabelUnderline(true);		
        this.contnumber.setVisible(true);
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
        // contlastUpdateUser		
        this.contlastUpdateUser.setBoundLabelText(resHelper.getString("contlastUpdateUser.boundLabelText"));		
        this.contlastUpdateUser.setBoundLabelLength(100);		
        this.contlastUpdateUser.setBoundLabelUnderline(true);		
        this.contlastUpdateUser.setVisible(true);
        // contlastUpdateTime		
        this.contlastUpdateTime.setBoundLabelText(resHelper.getString("contlastUpdateTime.boundLabelText"));		
        this.contlastUpdateTime.setBoundLabelLength(100);		
        this.contlastUpdateTime.setBoundLabelUnderline(true);		
        this.contlastUpdateTime.setVisible(true);
        // contdescription		
        this.contdescription.setBoundLabelText(resHelper.getString("contdescription.boundLabelText"));		
        this.contdescription.setBoundLabelLength(100);		
        this.contdescription.setBoundLabelUnderline(true);		
        this.contdescription.setVisible(true);
        // panelDermatitis		
        this.panelDermatitis.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("panelDermatitis.border.title")));
        // panelPulvillus		
        this.panelPulvillus.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("panelPulvillus.border.title")));
        // panelCrop		
        this.panelCrop.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("panelCrop.border.title")));
        // contbillStatus		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("kDPanel1.border.title")));
        // panelRemark		
        this.panelRemark.setBorder(new TitledBorder(BorderFactory.createLineBorder(new Color(0,0,0),1), resHelper.getString("panelRemark.border.title")));
        // contcancelcanceler		
        this.contcancelcanceler.setBoundLabelText(resHelper.getString("contcancelcanceler.boundLabelText"));		
        this.contcancelcanceler.setBoundLabelLength(100);		
        this.contcancelcanceler.setBoundLabelUnderline(true);		
        this.contcancelcanceler.setVisible(true);
        // contcancelcancelTime		
        this.contcancelcancelTime.setBoundLabelText(resHelper.getString("contcancelcancelTime.boundLabelText"));		
        this.contcancelcancelTime.setBoundLabelLength(100);		
        this.contcancelcancelTime.setBoundLabelUnderline(true);		
        this.contcancelcancelTime.setVisible(true);
        // contcancelUser		
        this.contcancelUser.setBoundLabelText(resHelper.getString("contcancelUser.boundLabelText"));		
        this.contcancelUser.setBoundLabelLength(100);		
        this.contcancelUser.setBoundLabelUnderline(true);		
        this.contcancelUser.setVisible(true);
        // contcancelTime		
        this.contcancelTime.setBoundLabelText(resHelper.getString("contcancelTime.boundLabelText"));		
        this.contcancelTime.setBoundLabelLength(100);		
        this.contcancelTime.setBoundLabelUnderline(true);		
        this.contcancelTime.setVisible(true);
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
        // txtname		
        this.txtname.setVisible(true);		
        this.txtname.setHorizontalAlignment(2);		
        this.txtname.setMaxLength(255);		
        this.txtname.setRequired(true);
        // txtnumber		
        this.txtnumber.setVisible(true);		
        this.txtnumber.setHorizontalAlignment(2);		
        this.txtnumber.setMaxLength(80);		
        this.txtnumber.setRequired(true);
        // prmtcreator		
        this.prmtcreator.setVisible(true);		
        this.prmtcreator.setEditable(true);		
        this.prmtcreator.setDisplayFormat("$name$");		
        this.prmtcreator.setEditFormat("$number$");		
        this.prmtcreator.setCommitFormat("$number$");		
        this.prmtcreator.setRequired(false);		
        this.prmtcreator.setEnabled(false);
        // pkcreateTime		
        this.pkcreateTime.setVisible(true);		
        this.pkcreateTime.setRequired(false);		
        this.pkcreateTime.setEnabled(false);
        // prmtlastUpdateUser		
        this.prmtlastUpdateUser.setVisible(true);		
        this.prmtlastUpdateUser.setEditable(true);		
        this.prmtlastUpdateUser.setDisplayFormat("$name$");		
        this.prmtlastUpdateUser.setEditFormat("$number$");		
        this.prmtlastUpdateUser.setCommitFormat("$number$");		
        this.prmtlastUpdateUser.setRequired(false);		
        this.prmtlastUpdateUser.setEnabled(false);
        // pklastUpdateTime		
        this.pklastUpdateTime.setVisible(true);		
        this.pklastUpdateTime.setRequired(false);		
        this.pklastUpdateTime.setEnabled(false);
        // txtdescription		
        this.txtdescription.setVisible(true);		
        this.txtdescription.setHorizontalAlignment(2);		
        this.txtdescription.setMaxLength(255);		
        this.txtdescription.setRequired(false);
        // contdermatitisSTD		
        this.contdermatitisSTD.setBoundLabelText(resHelper.getString("contdermatitisSTD.boundLabelText"));		
        this.contdermatitisSTD.setBoundLabelLength(100);		
        this.contdermatitisSTD.setBoundLabelUnderline(true);		
        this.contdermatitisSTD.setVisible(true);
        // contincrProportionDer		
        this.contincrProportionDer.setBoundLabelText(resHelper.getString("contincrProportionDer.boundLabelText"));		
        this.contincrProportionDer.setBoundLabelLength(100);		
        this.contincrProportionDer.setBoundLabelUnderline(true);		
        this.contincrProportionDer.setVisible(true);
        // contincrAmtDer		
        this.contincrAmtDer.setBoundLabelText(resHelper.getString("contincrAmtDer.boundLabelText"));		
        this.contincrAmtDer.setBoundLabelLength(100);		
        this.contincrAmtDer.setBoundLabelUnderline(true);		
        this.contincrAmtDer.setVisible(true);
        // txtdermatitisSTD		
        this.txtdermatitisSTD.setVisible(true);		
        this.txtdermatitisSTD.setHorizontalAlignment(2);		
        this.txtdermatitisSTD.setDataType(1);		
        this.txtdermatitisSTD.setSupportedEmpty(true);		
        this.txtdermatitisSTD.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtdermatitisSTD.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtdermatitisSTD.setPrecision(4);		
        this.txtdermatitisSTD.setRequired(true);
        // txtincrProportionDer		
        this.txtincrProportionDer.setVisible(true);		
        this.txtincrProportionDer.setHorizontalAlignment(2);		
        this.txtincrProportionDer.setDataType(1);		
        this.txtincrProportionDer.setSupportedEmpty(true);		
        this.txtincrProportionDer.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtincrProportionDer.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtincrProportionDer.setPrecision(2);		
        this.txtincrProportionDer.setRequired(false);
        // txtincrAmtDer		
        this.txtincrAmtDer.setVisible(true);		
        this.txtincrAmtDer.setHorizontalAlignment(2);		
        this.txtincrAmtDer.setDataType(1);		
        this.txtincrAmtDer.setSupportedEmpty(true);		
        this.txtincrAmtDer.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtincrAmtDer.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtincrAmtDer.setPrecision(2);		
        this.txtincrAmtDer.setRequired(false);
        // contpulvillusSTD		
        this.contpulvillusSTD.setBoundLabelText(resHelper.getString("contpulvillusSTD.boundLabelText"));		
        this.contpulvillusSTD.setBoundLabelLength(100);		
        this.contpulvillusSTD.setBoundLabelUnderline(true);		
        this.contpulvillusSTD.setVisible(true);
        // contincrProportion		
        this.contincrProportion.setBoundLabelText(resHelper.getString("contincrProportion.boundLabelText"));		
        this.contincrProportion.setBoundLabelLength(100);		
        this.contincrProportion.setBoundLabelUnderline(true);		
        this.contincrProportion.setVisible(true);
        // contproportionAmt		
        this.contproportionAmt.setBoundLabelText(resHelper.getString("contproportionAmt.boundLabelText"));		
        this.contproportionAmt.setBoundLabelLength(100);		
        this.contproportionAmt.setBoundLabelUnderline(true);		
        this.contproportionAmt.setVisible(true);
        // txtpulvillusSTD		
        this.txtpulvillusSTD.setVisible(true);		
        this.txtpulvillusSTD.setHorizontalAlignment(2);		
        this.txtpulvillusSTD.setDataType(1);		
        this.txtpulvillusSTD.setSupportedEmpty(true);		
        this.txtpulvillusSTD.setMinimumValue( new java.math.BigDecimal("-1.0E24"));		
        this.txtpulvillusSTD.setMaximumValue( new java.math.BigDecimal("1.0E24"));		
        this.txtpulvillusSTD.setPrecision(4);		
        this.txtpulvillusSTD.setRequired(true);
        // txtincrProportion		
        this.txtincrProportion.setVisible(true);		
        this.txtincrProportion.setHorizontalAlignment(2);		
        this.txtincrProportion.setDataType(1);		
        this.txtincrProportion.setSupportedEmpty(true);		
        this.txtincrProportion.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtincrProportion.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtincrProportion.setPrecision(2);		
        this.txtincrProportion.setRequired(false);
        // txtproportionAmt		
        this.txtproportionAmt.setVisible(true);		
        this.txtproportionAmt.setHorizontalAlignment(2);		
        this.txtproportionAmt.setDataType(1);		
        this.txtproportionAmt.setSupportedEmpty(true);		
        this.txtproportionAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtproportionAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtproportionAmt.setPrecision(2);		
        this.txtproportionAmt.setRequired(false);
        // contcropSTD		
        this.contcropSTD.setBoundLabelText(resHelper.getString("contcropSTD.boundLabelText"));		
        this.contcropSTD.setBoundLabelLength(100);		
        this.contcropSTD.setBoundLabelUnderline(true);		
        this.contcropSTD.setVisible(true);
        // contcoefficient		
        this.contcoefficient.setBoundLabelText(resHelper.getString("contcoefficient.boundLabelText"));		
        this.contcoefficient.setBoundLabelLength(100);		
        this.contcoefficient.setBoundLabelUnderline(true);		
        this.contcoefficient.setVisible(true);
        // contcoefficientGold		
        this.contcoefficientGold.setBoundLabelText(resHelper.getString("contcoefficientGold.boundLabelText"));		
        this.contcoefficientGold.setBoundLabelLength(100);		
        this.contcoefficientGold.setBoundLabelUnderline(true);
        // txtcropSTD		
        this.txtcropSTD.setVisible(true);		
        this.txtcropSTD.setHorizontalAlignment(2);		
        this.txtcropSTD.setDataType(1);		
        this.txtcropSTD.setSupportedEmpty(true);		
        this.txtcropSTD.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcropSTD.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcropSTD.setPrecision(2);		
        this.txtcropSTD.setRequired(false);
        // txtcoefficient		
        this.txtcoefficient.setVisible(true);		
        this.txtcoefficient.setHorizontalAlignment(2);		
        this.txtcoefficient.setDataType(1);		
        this.txtcoefficient.setSupportedEmpty(true);		
        this.txtcoefficient.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcoefficient.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcoefficient.setPrecision(2);		
        this.txtcoefficient.setRequired(false);
        // txtcoefficientGold		
        this.txtcoefficientGold.setVisible(true);		
        this.txtcoefficientGold.setHorizontalAlignment(2);		
        this.txtcoefficientGold.setDataType(1);		
        this.txtcoefficientGold.setSupportedEmpty(true);		
        this.txtcoefficientGold.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtcoefficientGold.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtcoefficientGold.setPrecision(2);		
        this.txtcoefficientGold.setRequired(false);
        // billStatus		
        this.billStatus.setVisible(true);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.ccchargeback.billStatus").toArray());		
        this.billStatus.setRequired(false);		
        this.billStatus.setEnabled(false);
        // contcarcassSTD		
        this.contcarcassSTD.setBoundLabelText(resHelper.getString("contcarcassSTD.boundLabelText"));		
        this.contcarcassSTD.setBoundLabelLength(100);		
        this.contcarcassSTD.setBoundLabelUnderline(true);		
        this.contcarcassSTD.setVisible(true);
        // contyieldRate		
        this.contyieldRate.setBoundLabelText(resHelper.getString("contyieldRate.boundLabelText"));		
        this.contyieldRate.setBoundLabelLength(100);		
        this.contyieldRate.setBoundLabelUnderline(true);		
        this.contyieldRate.setVisible(true);
        // txtcarcassSTD		
        this.txtcarcassSTD.setVisible(true);		
        this.txtcarcassSTD.setHorizontalAlignment(2);		
        this.txtcarcassSTD.setDataType(1);		
        this.txtcarcassSTD.setSupportedEmpty(true);		
        this.txtcarcassSTD.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcarcassSTD.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcarcassSTD.setPrecision(4);		
        this.txtcarcassSTD.setRequired(false);
        // txtyieldRate		
        this.txtyieldRate.setVisible(true);		
        this.txtyieldRate.setHorizontalAlignment(2);		
        this.txtyieldRate.setDataType(1);		
        this.txtyieldRate.setSupportedEmpty(true);		
        this.txtyieldRate.setMinimumValue( new java.math.BigDecimal("-1.0E26"));		
        this.txtyieldRate.setMaximumValue( new java.math.BigDecimal("1.0E26"));		
        this.txtyieldRate.setPrecision(2);		
        this.txtyieldRate.setRequired(false);
        // contremark		
        this.contremark.setBoundLabelText(resHelper.getString("contremark.boundLabelText"));		
        this.contremark.setBoundLabelLength(0);		
        this.contremark.setBoundLabelUnderline(true);		
        this.contremark.setVisible(true);
        // scrollPaneremark
        // txtremark		
        this.txtremark.setVisible(true);		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(2000);
        // prmtcancelcanceler		
        this.prmtcancelcanceler.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtcancelcanceler.setVisible(true);		
        this.prmtcancelcanceler.setEditable(true);		
        this.prmtcancelcanceler.setDisplayFormat("$number$");		
        this.prmtcancelcanceler.setEditFormat("$number$");		
        this.prmtcancelcanceler.setCommitFormat("$number$");		
        this.prmtcancelcanceler.setRequired(false);		
        this.prmtcancelcanceler.setEnabled(false);
        // pkcancelcancelTime		
        this.pkcancelcancelTime.setVisible(true);		
        this.pkcancelcancelTime.setRequired(false);		
        this.pkcancelcancelTime.setEnabled(false);
        // prmtcancelUser		
        this.prmtcancelUser.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtcancelUser.setVisible(true);		
        this.prmtcancelUser.setEditable(true);		
        this.prmtcancelUser.setDisplayFormat("$number$");		
        this.prmtcancelUser.setEditFormat("$number$");		
        this.prmtcancelUser.setCommitFormat("$number$");		
        this.prmtcancelUser.setRequired(false);		
        this.prmtcancelUser.setEnabled(false);
        // pkcancelTime		
        this.pkcancelTime.setVisible(true);		
        this.pkcancelTime.setRequired(false);		
        this.pkcancelTime.setEnabled(false);
        // prmtauditor		
        this.prmtauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditor.setVisible(true);		
        this.prmtauditor.setEditable(true);		
        this.prmtauditor.setDisplayFormat("$number$");		
        this.prmtauditor.setEditFormat("$number$");		
        this.prmtauditor.setCommitFormat("$number$");		
        this.prmtauditor.setRequired(false);		
        this.prmtauditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setVisible(true);		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtpulvillusSTD,txtincrProportion,txtproportionAmt,txtdermatitisSTD,txtincrProportionDer,txtincrAmtDer,billStatus,txtcropSTD,txtcoefficient,txtcoefficientGold,txtcarcassSTD,txtyieldRate,txtremark,prmtcancelcanceler,pkcancelcancelTime,prmtcancelUser,pkcancelTime,prmtauditor,pkauditTime}));
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
        this.setBounds(new Rectangle(0, 0, 806, 581));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 806, 581));
        contname.setBounds(new Rectangle(275, 10, 249, 19));
        this.add(contname, new KDLayout.Constraints(275, 10, 249, 19, 0));
        contnumber.setBounds(new Rectangle(10, 10, 249, 19));
        this.add(contnumber, new KDLayout.Constraints(10, 10, 249, 19, 0));
        contcreator.setBounds(new Rectangle(10, 514, 249, 19));
        this.add(contcreator, new KDLayout.Constraints(10, 514, 249, 19, 0));
        contcreateTime.setBounds(new Rectangle(10, 543, 249, 19));
        this.add(contcreateTime, new KDLayout.Constraints(10, 543, 249, 19, 0));
        contlastUpdateUser.setBounds(new Rectangle(533, 514, 249, 19));
        this.add(contlastUpdateUser, new KDLayout.Constraints(533, 514, 249, 19, 0));
        contlastUpdateTime.setBounds(new Rectangle(533, 543, 249, 19));
        this.add(contlastUpdateTime, new KDLayout.Constraints(533, 543, 249, 19, 0));
        contdescription.setBounds(new Rectangle(533, 10, 249, 19));
        this.add(contdescription, new KDLayout.Constraints(533, 10, 249, 19, 0));
        panelDermatitis.setBounds(new Rectangle(10, 76, 772, 70));
        this.add(panelDermatitis, new KDLayout.Constraints(10, 76, 772, 70, 0));
        panelPulvillus.setBounds(new Rectangle(10, 155, 772, 68));
        this.add(panelPulvillus, new KDLayout.Constraints(10, 155, 772, 68, 0));
        panelCrop.setBounds(new Rectangle(10, 238, 772, 60));
        this.add(panelCrop, new KDLayout.Constraints(10, 238, 772, 60, 0));
        contbillStatus.setBounds(new Rectangle(10, 34, 249, 19));
        this.add(contbillStatus, new KDLayout.Constraints(10, 34, 249, 19, 0));
        kDPanel1.setBounds(new Rectangle(10, 316, 772, 60));
        this.add(kDPanel1, new KDLayout.Constraints(10, 316, 772, 60, 0));
        panelRemark.setBounds(new Rectangle(10, 385, 772, 105));
        this.add(panelRemark, new KDLayout.Constraints(10, 385, 772, 105, 0));
        contcancelcanceler.setBounds(new Rectangle(275, 513, 249, 19));
        this.add(contcancelcanceler, new KDLayout.Constraints(275, 513, 249, 19, 0));
        contcancelcancelTime.setBounds(new Rectangle(275, 543, 249, 19));
        this.add(contcancelcancelTime, new KDLayout.Constraints(275, 543, 249, 19, 0));
        contcancelUser.setBounds(new Rectangle(533, 514, 249, 19));
        this.add(contcancelUser, new KDLayout.Constraints(533, 514, 249, 19, 0));
        contcancelTime.setBounds(new Rectangle(533, 543, 249, 19));
        this.add(contcancelTime, new KDLayout.Constraints(533, 543, 249, 19, 0));
        contauditor.setBounds(new Rectangle(275, 513, 249, 19));
        this.add(contauditor, new KDLayout.Constraints(275, 513, 249, 19, 0));
        contauditTime.setBounds(new Rectangle(275, 543, 249, 19));
        this.add(contauditTime, new KDLayout.Constraints(275, 543, 249, 19, 0));
        //contname
        contname.setBoundEditor(txtname);
        //contnumber
        contnumber.setBoundEditor(txtnumber);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contlastUpdateUser
        contlastUpdateUser.setBoundEditor(prmtlastUpdateUser);
        //contlastUpdateTime
        contlastUpdateTime.setBoundEditor(pklastUpdateTime);
        //contdescription
        contdescription.setBoundEditor(txtdescription);
        //panelDermatitis
        panelDermatitis.setLayout(new KDLayout());
        panelDermatitis.putClientProperty("OriginalBounds", new Rectangle(10, 76, 772, 70));        contdermatitisSTD.setBounds(new Rectangle(19, 36, 220, 19));
        panelDermatitis.add(contdermatitisSTD, new KDLayout.Constraints(19, 36, 220, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincrProportionDer.setBounds(new Rectangle(269, 36, 220, 19));
        panelDermatitis.add(contincrProportionDer, new KDLayout.Constraints(269, 36, 220, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contincrAmtDer.setBounds(new Rectangle(520, 36, 220, 19));
        panelDermatitis.add(contincrAmtDer, new KDLayout.Constraints(520, 36, 220, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contdermatitisSTD
        contdermatitisSTD.setBoundEditor(txtdermatitisSTD);
        //contincrProportionDer
        contincrProportionDer.setBoundEditor(txtincrProportionDer);
        //contincrAmtDer
        contincrAmtDer.setBoundEditor(txtincrAmtDer);
        //panelPulvillus
        panelPulvillus.setLayout(new KDLayout());
        panelPulvillus.putClientProperty("OriginalBounds", new Rectangle(10, 155, 772, 68));        contpulvillusSTD.setBounds(new Rectangle(15, 26, 220, 19));
        panelPulvillus.add(contpulvillusSTD, new KDLayout.Constraints(15, 26, 220, 19, 0));
        contincrProportion.setBounds(new Rectangle(267, 26, 220, 19));
        panelPulvillus.add(contincrProportion, new KDLayout.Constraints(267, 26, 220, 19, 0));
        contproportionAmt.setBounds(new Rectangle(520, 26, 220, 19));
        panelPulvillus.add(contproportionAmt, new KDLayout.Constraints(520, 26, 220, 19, 0));
        //contpulvillusSTD
        contpulvillusSTD.setBoundEditor(txtpulvillusSTD);
        //contincrProportion
        contincrProportion.setBoundEditor(txtincrProportion);
        //contproportionAmt
        contproportionAmt.setBoundEditor(txtproportionAmt);
        //panelCrop
        panelCrop.setLayout(new KDLayout());
        panelCrop.putClientProperty("OriginalBounds", new Rectangle(10, 238, 772, 60));        contcropSTD.setBounds(new Rectangle(13, 21, 220, 19));
        panelCrop.add(contcropSTD, new KDLayout.Constraints(13, 21, 220, 19, 0));
        contcoefficient.setBounds(new Rectangle(266, 21, 220, 19));
        panelCrop.add(contcoefficient, new KDLayout.Constraints(266, 21, 220, 19, 0));
        contcoefficientGold.setBounds(new Rectangle(520, 21, 220, 19));
        panelCrop.add(contcoefficientGold, new KDLayout.Constraints(520, 21, 220, 19, 0));
        //contcropSTD
        contcropSTD.setBoundEditor(txtcropSTD);
        //contcoefficient
        contcoefficient.setBoundEditor(txtcoefficient);
        //contcoefficientGold
        contcoefficientGold.setBoundEditor(txtcoefficientGold);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(10, 316, 772, 60));        contcarcassSTD.setBounds(new Rectangle(17, 20, 220, 19));
        kDPanel1.add(contcarcassSTD, new KDLayout.Constraints(17, 20, 220, 19, 0));
        contyieldRate.setBounds(new Rectangle(263, 18, 220, 19));
        kDPanel1.add(contyieldRate, new KDLayout.Constraints(263, 18, 220, 19, 0));
        //contcarcassSTD
        contcarcassSTD.setBoundEditor(txtcarcassSTD);
        //contyieldRate
        contyieldRate.setBoundEditor(txtyieldRate);
        //panelRemark
        panelRemark.setLayout(new KDLayout());
        panelRemark.putClientProperty("OriginalBounds", new Rectangle(10, 385, 772, 105));        contremark.setBounds(new Rectangle(10, 14, 745, 86));
        panelRemark.add(contremark, new KDLayout.Constraints(10, 14, 745, 86, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contremark
        contremark.setBoundEditor(scrollPaneremark);
        //scrollPaneremark
        scrollPaneremark.getViewport().add(txtremark, null);
        //contcancelcanceler
        contcancelcanceler.setBoundEditor(prmtcancelcanceler);
        //contcancelcancelTime
        contcancelcancelTime.setBoundEditor(pkcancelcancelTime);
        //contcancelUser
        contcancelUser.setBoundEditor(prmtcancelUser);
        //contcancelTime
        contcancelTime.setBoundEditor(pkcancelTime);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("name", String.class, this.txtname, "text");
		dataBinder.registerBinding("number", String.class, this.txtnumber, "text");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtlastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.pklastUpdateTime, "value");
		dataBinder.registerBinding("description", String.class, this.txtdescription, "text");
		dataBinder.registerBinding("dermatitisSTD", java.math.BigDecimal.class, this.txtdermatitisSTD, "value");
		dataBinder.registerBinding("incrProportionDer", java.math.BigDecimal.class, this.txtincrProportionDer, "value");
		dataBinder.registerBinding("incrAmtDer", java.math.BigDecimal.class, this.txtincrAmtDer, "value");
		dataBinder.registerBinding("pulvillusSTD", java.math.BigDecimal.class, this.txtpulvillusSTD, "value");
		dataBinder.registerBinding("incrProportion", java.math.BigDecimal.class, this.txtincrProportion, "value");
		dataBinder.registerBinding("proportionAmt", java.math.BigDecimal.class, this.txtproportionAmt, "value");
		dataBinder.registerBinding("cropSTD", java.math.BigDecimal.class, this.txtcropSTD, "value");
		dataBinder.registerBinding("coefficient", java.math.BigDecimal.class, this.txtcoefficient, "value");
		dataBinder.registerBinding("coefficientGold", java.math.BigDecimal.class, this.txtcoefficientGold, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.custom.ccchargeback.billStatus.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("carcassSTD", java.math.BigDecimal.class, this.txtcarcassSTD, "value");
		dataBinder.registerBinding("yieldRate", java.math.BigDecimal.class, this.txtyieldRate, "value");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("cancelcanceler", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcancelcanceler, "data");
		dataBinder.registerBinding("cancelcancelTime", java.util.Date.class, this.pkcancelcancelTime, "value");
		dataBinder.registerBinding("cancelUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcancelUser, "data");
		dataBinder.registerBinding("cancelTime", java.util.Date.class, this.pkcancelTime, "value");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.ccchargeback.app.ChargeBackStdEditUIHandler";
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
        this.txtpulvillusSTD.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
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
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("dermatitisSTD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incrProportionDer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incrAmtDer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pulvillusSTD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("incrProportion", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("proportionAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cropSTD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coefficient", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("coefficientGold", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carcassSTD", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("yieldRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cancelcanceler", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cancelcancelTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cancelUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("cancelTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("number"));
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
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("dermatitisSTD"));
        sic.add(new SelectorItemInfo("incrProportionDer"));
        sic.add(new SelectorItemInfo("incrAmtDer"));
        sic.add(new SelectorItemInfo("pulvillusSTD"));
        sic.add(new SelectorItemInfo("incrProportion"));
        sic.add(new SelectorItemInfo("proportionAmt"));
        sic.add(new SelectorItemInfo("cropSTD"));
        sic.add(new SelectorItemInfo("coefficient"));
        sic.add(new SelectorItemInfo("coefficientGold"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("carcassSTD"));
        sic.add(new SelectorItemInfo("yieldRate"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cancelcanceler.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cancelcanceler.id"));
        	sic.add(new SelectorItemInfo("cancelcanceler.number"));
        	sic.add(new SelectorItemInfo("cancelcanceler.name"));
		}
        sic.add(new SelectorItemInfo("cancelcancelTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("cancelUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("cancelUser.id"));
        	sic.add(new SelectorItemInfo("cancelUser.number"));
        	sic.add(new SelectorItemInfo("cancelUser.name"));
		}
        sic.add(new SelectorItemInfo("cancelTime"));
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
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractChargeBackStdEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractChargeBackStdEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.ccchargeback.client", "ChargeBackStdEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.ccchargeback.client.ChargeBackStdEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo objectValue = new com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtname.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtnumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtdermatitisSTD.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"胸部皮炎标准"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtpulvillusSTD.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"爪垫标准"});
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
				vo.put("dermatitisSTD",new java.math.BigDecimal(5));
		vo.put("incrProportionDer",new java.math.BigDecimal(1));
		vo.put("incrAmtDer",new java.math.BigDecimal(50));
		vo.put("pulvillusSTD",new java.math.BigDecimal(40));
		vo.put("incrProportion",new java.math.BigDecimal(5));
		vo.put("proportionAmt",new java.math.BigDecimal(300));
		vo.put("cropSTD",new java.math.BigDecimal(0));
		vo.put("coefficient",new java.math.BigDecimal(90));
vo.put("billStatus","0");
		vo.put("carcassSTD",new java.math.BigDecimal(0.75));
		vo.put("yieldRate",new java.math.BigDecimal(75));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}