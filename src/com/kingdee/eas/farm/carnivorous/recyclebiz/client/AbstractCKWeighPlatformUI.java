/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCKWeighPlatformUI extends com.kingdee.eas.framework.client.BillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCKWeighPlatformUI.class);
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabel labShowWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer12;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup kDButtonGroup1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer16;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelKG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer17;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnWeight;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAllSave;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkIsTemp;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnShowOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer19;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer20;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtBillEntrys;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tbList;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker QBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtQcarnumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbQueryBillStatus;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker QEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCar;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTare;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSuttle;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBizDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpInTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpOutTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbBizType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbBillStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBox2;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRemark;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCarNum;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtExpectSuttle;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbWeightType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtDriver;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtMaterial;
    protected com.kingdee.eas.framework.CoreBillBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCKWeighPlatformUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCKWeighPlatformUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.labShowWeight = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contCar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer12 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDButtonGroup1 = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.kDLabelContainer13 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer15 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer16 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labelKG = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer17 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnWeight = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAllSave = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.chkIsTemp = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contCarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnShowOrder = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer19 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer20 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtBillEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDWorkButton1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tbList = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.QBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtQcarnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cmbQueryBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.QEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtCar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.dpBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpInTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpOutTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cmbBizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cmbBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDBizPromptBox2 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtRemark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtCarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtExpectSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.cmbWeightType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtDriver = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtMaterial = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.labShowWeight.setName("labShowWeight");
        this.contCar.setName("contCar");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.kDLabelContainer12.setName("kDLabelContainer12");
        this.kDLabelContainer13.setName("kDLabelContainer13");
        this.kDLabelContainer15.setName("kDLabelContainer15");
        this.kDLabelContainer16.setName("kDLabelContainer16");
        this.labelKG.setName("labelKG");
        this.kDLabelContainer17.setName("kDLabelContainer17");
        this.btnWeight.setName("btnWeight");
        this.btnAllSave.setName("btnAllSave");
        this.chkIsTemp.setName("chkIsTemp");
        this.contCarNum.setName("contCarNum");
        this.btnShowOrder.setName("btnShowOrder");
        this.kDLabelContainer19.setName("kDLabelContainer19");
        this.kDLabelContainer20.setName("kDLabelContainer20");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.kdtBillEntrys.setName("kdtBillEntrys");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDWorkButton1.setName("kDWorkButton1");
        this.tbList.setName("tbList");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.QBeginDate.setName("QBeginDate");
        this.txtQcarnumber.setName("txtQcarnumber");
        this.cmbQueryBillStatus.setName("cmbQueryBillStatus");
        this.QEndDate.setName("QEndDate");
        this.prmtCar.setName("prmtCar");
        this.txtTare.setName("txtTare");
        this.txtGross.setName("txtGross");
        this.txtSuttle.setName("txtSuttle");
        this.dpBizDate.setName("dpBizDate");
        this.dpInTime.setName("dpInTime");
        this.dpOutTime.setName("dpOutTime");
        this.txtNumber.setName("txtNumber");
        this.cmbBizType.setName("cmbBizType");
        this.cmbBillStatus.setName("cmbBillStatus");
        this.kDBizPromptBox2.setName("kDBizPromptBox2");
        this.txtRemark.setName("txtRemark");
        this.txtCarNum.setName("txtCarNum");
        this.txtExpectSuttle.setName("txtExpectSuttle");
        this.cmbWeightType.setName("cmbWeightType");
        this.txtDriver.setName("txtDriver");
        this.txtMaterial.setName("txtMaterial");
        // CoreUI		
        this.btnPageSetup.setVisible(false);		
        this.btnCloud.setVisible(false);		
        this.btnXunTong.setVisible(false);		
        this.kDSeparatorCloud.setVisible(false);		
        this.menuItemPageSetup.setVisible(false);		
        this.menuItemCloudFeed.setVisible(false);		
        this.menuItemCloudScreen.setEnabled(false);		
        this.menuItemCloudScreen.setVisible(false);		
        this.menuItemCloudShare.setVisible(false);		
        this.kdSeparatorFWFile1.setVisible(false);		
        this.btnCancelCancel.setVisible(false);		
        this.btnCancelCancel.setEnabled(false);		
        this.btnCancel.setEnabled(false);		
        this.btnCancel.setVisible(false);		
        this.kDSeparator2.setVisible(false);		
        this.menuItemPrint.setVisible(true);		
        this.menuItemPrintPreview.setVisible(true);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator4.setEnabled(false);		
        this.rMenuItemSubmit.setVisible(false);		
        this.rMenuItemSubmit.setEnabled(false);		
        this.rMenuItemSubmitAndAddNew.setVisible(false);		
        this.rMenuItemSubmitAndAddNew.setEnabled(false);		
        this.rMenuItemSubmitAndPrint.setVisible(false);		
        this.rMenuItemSubmitAndPrint.setEnabled(false);		
        this.menuItemCancelCancel.setVisible(false);		
        this.menuItemCancelCancel.setEnabled(false);		
        this.menuItemCancel.setEnabled(false);		
        this.menuItemCancel.setVisible(false);		
        this.btnReset.setEnabled(false);		
        this.btnReset.setVisible(false);		
        this.menuItemReset.setEnabled(false);		
        this.menuItemReset.setVisible(false);		
        this.btnSignature.setVisible(false);		
        this.btnSignature.setEnabled(false);		
        this.btnViewSignature.setEnabled(false);		
        this.btnViewSignature.setVisible(false);		
        this.separatorFW4.setVisible(false);		
        this.separatorFW4.setEnabled(false);		
        this.btnNumberSign.setEnabled(false);		
        this.btnNumberSign.setVisible(false);		
        this.btnCopyFrom.setVisible(false);		
        this.btnCopyFrom.setEnabled(false);		
        this.btnCreateTo.setVisible(false);		
        this.separatorFW5.setVisible(false);		
        this.separatorFW5.setEnabled(false);		
        this.btnCopyLine.setVisible(false);		
        this.separatorFW6.setVisible(false);		
        this.separatorFW6.setEnabled(false);		
        this.btnVoucher.setVisible(false);		
        this.btnDelVoucher.setVisible(false);		
        this.btnWFViewdoProccess.setEnabled(false);		
        this.btnWFViewdoProccess.setVisible(false);		
        this.btnWFViewSubmitProccess.setEnabled(false);		
        this.btnWFViewSubmitProccess.setVisible(false);		
        this.menuItemCreateTo.setVisible(false);		
        this.separatorEdit1.setVisible(false);		
        this.menuItemEnterToNextRow.setVisible(false);		
        this.separator2.setVisible(false);		
        this.menuItemLocate.setVisible(false);		
        this.MenuItemVoucher.setVisible(false);		
        this.menuItemDelVoucher.setVisible(false);		
        this.menuItemStartWorkFlow.setVisible(false);		
        this.separatorWF1.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewSubmitProccess.setEnabled(false);		
        this.menuItemViewDoProccess.setEnabled(false);		
        this.menuItemViewDoProccess.setVisible(false);
        // kDContainer1		
        this.kDContainer1.setTitle(resHelper.getString("kDContainer1.title"));
        // kDContainer2		
        this.kDContainer2.setTitle(resHelper.getString("kDContainer2.title"));
        // labShowWeight		
        this.labShowWeight.setText(resHelper.getString("labShowWeight.text"));		
        this.labShowWeight.setFont(resHelper.getFont("labShowWeight.font"));		
        this.labShowWeight.setForeground(new java.awt.Color(86,210,45));		
        this.labShowWeight.setHorizontalAlignment(4);
        // contCar		
        this.contCar.setBoundLabelText(resHelper.getString("contCar.boundLabelText"));		
        this.contCar.setBoundLabelUnderline(true);		
        this.contCar.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));		
        this.kDLabelContainer10.setBoundLabelUnderline(true);		
        this.kDLabelContainer10.setBoundLabelLength(100);
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelUnderline(true);		
        this.kDLabelContainer11.setBoundLabelLength(100);
        // kDLabelContainer12		
        this.kDLabelContainer12.setBoundLabelText(resHelper.getString("kDLabelContainer12.boundLabelText"));		
        this.kDLabelContainer12.setBoundLabelUnderline(true);		
        this.kDLabelContainer12.setBoundLabelLength(100);
        // kDButtonGroup1
        // kDLabelContainer13		
        this.kDLabelContainer13.setBoundLabelText(resHelper.getString("kDLabelContainer13.boundLabelText"));		
        this.kDLabelContainer13.setBoundLabelLength(100);		
        this.kDLabelContainer13.setBoundLabelUnderline(true);
        // kDLabelContainer15		
        this.kDLabelContainer15.setBoundLabelText(resHelper.getString("kDLabelContainer15.boundLabelText"));		
        this.kDLabelContainer15.setBoundLabelUnderline(true);		
        this.kDLabelContainer15.setBoundLabelLength(100);
        // kDLabelContainer16		
        this.kDLabelContainer16.setBoundLabelText(resHelper.getString("kDLabelContainer16.boundLabelText"));		
        this.kDLabelContainer16.setBoundLabelUnderline(true);		
        this.kDLabelContainer16.setBoundLabelLength(100);		
        this.kDLabelContainer16.setVisible(false);
        // labelKG		
        this.labelKG.setText(resHelper.getString("labelKG.text"));		
        this.labelKG.setFont(resHelper.getFont("labelKG.font"));		
        this.labelKG.setForeground(new java.awt.Color(0,187,0));
        // kDLabelContainer17		
        this.kDLabelContainer17.setBoundLabelText(resHelper.getString("kDLabelContainer17.boundLabelText"));		
        this.kDLabelContainer17.setBoundLabelLength(100);		
        this.kDLabelContainer17.setBoundLabelUnderline(true);
        // btnWeight		
        this.btnWeight.setText(resHelper.getString("btnWeight.text"));		
        this.btnWeight.setFont(resHelper.getFont("btnWeight.font"));
        this.btnWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnWeight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAllSave		
        this.btnAllSave.setText(resHelper.getString("btnAllSave.text"));		
        this.btnAllSave.setFont(resHelper.getFont("btnAllSave.font"));
        this.btnAllSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAllSave_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // chkIsTemp		
        this.chkIsTemp.setText(resHelper.getString("chkIsTemp.text"));
        // contCarNum		
        this.contCarNum.setBoundLabelText(resHelper.getString("contCarNum.boundLabelText"));		
        this.contCarNum.setBoundLabelUnderline(true);		
        this.contCarNum.setBoundLabelLength(100);		
        this.contCarNum.setVisible(false);
        // btnShowOrder		
        this.btnShowOrder.setText(resHelper.getString("btnShowOrder.text"));		
        this.btnShowOrder.setFont(resHelper.getFont("btnShowOrder.font"));
        this.btnShowOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnShowOrder_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer19		
        this.kDLabelContainer19.setBoundLabelText(resHelper.getString("kDLabelContainer19.boundLabelText"));		
        this.kDLabelContainer19.setBoundLabelUnderline(true);		
        this.kDLabelContainer19.setBoundLabelLength(100);
        // kDLabelContainer20		
        this.kDLabelContainer20.setBoundLabelText(resHelper.getString("kDLabelContainer20.boundLabelText"));		
        this.kDLabelContainer20.setBoundLabelUnderline(true);		
        this.kDLabelContainer20.setBoundLabelLength(100);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelUnderline(true);		
        this.kDLabelContainer14.setBoundLabelLength(100);
        // kdtBillEntrys

        

        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);
        // kDWorkButton1		
        this.kDWorkButton1.setText(resHelper.getString("kDWorkButton1.text"));
        this.kDWorkButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // tbList
		String tbListStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol14\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol19\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"bizType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"weighType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"orderNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"orderStorageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"inTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"outTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"materialID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"tare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"gross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"tare2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol19\" /><t:Column t:key=\"impurity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol20\" /><t:Column t:key=\"impurity2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol21\" /><t:Column t:key=\"suttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" /><t:Column t:key=\"entryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" t:styleID=\"sCol24\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizType}</t:Cell><t:Cell>$Resource{weighType}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{orderNumber}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{orderStorageOrgUnit}</t:Cell><t:Cell>$Resource{inTime}</t:Cell><t:Cell>$Resource{outTime}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{tare}</t:Cell><t:Cell>$Resource{gross}</t:Cell><t:Cell>$Resource{tare2}</t:Cell><t:Cell>$Resource{impurity}</t:Cell><t:Cell>$Resource{impurity2}</t:Cell><t:Cell>$Resource{suttle}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{entryID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tbList.setFormatXml(resHelper.translateString("tbList",tbListStrXML));

        

        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // QBeginDate
        // txtQcarnumber
        // cmbQueryBillStatus		
        this.cmbQueryBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // QEndDate
        // prmtCar
        // txtTare
        // txtGross
        // txtSuttle
        // dpBizDate
        // dpInTime		
        this.dpInTime.setRequired(true);
        // dpOutTime		
        this.dpOutTime.setRequired(true);
        // txtNumber
        // cmbBizType		
        this.cmbBizType.setActionCommand("cmbWeighType");		
        this.cmbBizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBizType").toArray());
        // cmbBillStatus		
        this.cmbBillStatus.setActionCommand("");		
        this.cmbBillStatus.setEnabled(false);		
        this.cmbBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // kDBizPromptBox2
        // txtRemark
        // txtCarNum
        // txtExpectSuttle
        // cmbWeightType		
        this.cmbWeightType.setActionCommand("");		
        this.cmbWeightType.setEnabled(false);		
        this.cmbWeightType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseType").toArray());
        // txtDriver
        // txtMaterial
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
        this.setBounds(new Rectangle(10, 10, 1200, 800));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1200, 800));
        kDContainer1.setBounds(new Rectangle(17, 306, 1166, 116));
        this.add(kDContainer1, new KDLayout.Constraints(17, 306, 1166, 116, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDContainer2.setBounds(new Rectangle(16, 447, 1175, 341));
        this.add(kDContainer2, new KDLayout.Constraints(16, 447, 1175, 341, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        labShowWeight.setBounds(new Rectangle(303, 2, 219, 80));
        this.add(labShowWeight, new KDLayout.Constraints(303, 2, 219, 80, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCar.setBounds(new Rectangle(325, 154, 270, 19));
        this.add(contCar, new KDLayout.Constraints(325, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(325, 214, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(325, 214, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(32, 214, 270, 19));
        this.add(kDLabelContainer7, new KDLayout.Constraints(32, 214, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(624, 214, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(624, 214, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer9.setBounds(new Rectangle(325, 93, 270, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(325, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer10.setBounds(new Rectangle(32, 184, 270, 19));
        this.add(kDLabelContainer10, new KDLayout.Constraints(32, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer11.setBounds(new Rectangle(325, 184, 270, 19));
        this.add(kDLabelContainer11, new KDLayout.Constraints(325, 184, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer12.setBounds(new Rectangle(32, 93, 270, 19));
        this.add(kDLabelContainer12, new KDLayout.Constraints(32, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer13.setBounds(new Rectangle(32, 124, 270, 19));
        this.add(kDLabelContainer13, new KDLayout.Constraints(32, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer15.setBounds(new Rectangle(624, 93, 270, 19));
        this.add(kDLabelContainer15, new KDLayout.Constraints(624, 93, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer16.setBounds(new Rectangle(-655, 325, 270, 19));
        this.add(kDLabelContainer16, new KDLayout.Constraints(-655, 325, 270, 19, 0));
        labelKG.setBounds(new Rectangle(530, 2, 100, 80));
        this.add(labelKG, new KDLayout.Constraints(530, 2, 100, 80, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer17.setBounds(new Rectangle(327, 245, 568, 19));
        this.add(kDLabelContainer17, new KDLayout.Constraints(327, 245, 568, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnWeight.setBounds(new Rectangle(1009, 93, 128, 60));
        this.add(btnWeight, new KDLayout.Constraints(1009, 93, 128, 60, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnAllSave.setBounds(new Rectangle(1009, 176, 128, 60));
        this.add(btnAllSave, new KDLayout.Constraints(1009, 176, 128, 60, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkIsTemp.setBounds(new Rectangle(32, 154, 144, 19));
        this.add(chkIsTemp, new KDLayout.Constraints(32, 154, 144, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarNum.setBounds(new Rectangle(624, 124, 270, 19));
        this.add(contCarNum, new KDLayout.Constraints(624, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnShowOrder.setBounds(new Rectangle(16, 276, 114, 27));
        this.add(btnShowOrder, new KDLayout.Constraints(16, 276, 114, 27, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer19.setBounds(new Rectangle(624, 183, 270, 19));
        this.add(kDLabelContainer19, new KDLayout.Constraints(624, 183, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer20.setBounds(new Rectangle(325, 124, 270, 19));
        this.add(kDLabelContainer20, new KDLayout.Constraints(325, 124, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(624, 154, 270, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(624, 154, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer14.setBounds(new Rectangle(32, 245, 270, 19));
        this.add(kDLabelContainer14, new KDLayout.Constraints(32, 245, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDContainer1
        kDContainer1.getContentPane().setLayout(new KDLayout());
        kDContainer1.getContentPane().putClientProperty("OriginalBounds", new Rectangle(17, 306, 1166, 116));        kdtBillEntrys.setBounds(new Rectangle(1, 0, 1162, 109));
        kDContainer1.getContentPane().add(kdtBillEntrys, new KDLayout.Constraints(1, 0, 1162, 109, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDContainer2
        kDContainer2.getContentPane().setLayout(new KDLayout());
        kDContainer2.getContentPane().putClientProperty("OriginalBounds", new Rectangle(16, 447, 1175, 341));        kDLabelContainer1.setBounds(new Rectangle(15, 18, 270, 19));
        kDContainer2.getContentPane().add(kDLabelContainer1, new KDLayout.Constraints(15, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(706, 18, 275, 19));
        kDContainer2.getContentPane().add(kDLabelContainer3, new KDLayout.Constraints(706, 18, 275, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(15, 47, 270, 19));
        kDContainer2.getContentPane().add(kDLabelContainer4, new KDLayout.Constraints(15, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDWorkButton1.setBounds(new Rectangle(1057, 18, 78, 23));
        kDContainer2.getContentPane().add(kDWorkButton1, new KDLayout.Constraints(1057, 18, 78, 23, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        tbList.setBounds(new Rectangle(-23, 79, 1160, 240));
        kDContainer2.getContentPane().add(tbList, new KDLayout.Constraints(-23, 79, 1160, 240, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer2.setBounds(new Rectangle(360, 18, 270, 19));
        kDContainer2.getContentPane().add(kDLabelContainer2, new KDLayout.Constraints(360, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(QBeginDate);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtQcarnumber);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(cmbQueryBillStatus);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(QEndDate);
        //contCar
        contCar.setBoundEditor(prmtCar);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(txtTare);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(txtGross);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(txtSuttle);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(dpBizDate);
        //kDLabelContainer10
        kDLabelContainer10.setBoundEditor(dpInTime);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(dpOutTime);
        //kDLabelContainer12
        kDLabelContainer12.setBoundEditor(txtNumber);
        //kDLabelContainer13
        kDLabelContainer13.setBoundEditor(cmbBizType);
        //kDLabelContainer15
        kDLabelContainer15.setBoundEditor(cmbBillStatus);
        //kDLabelContainer16
        kDLabelContainer16.setBoundEditor(kDBizPromptBox2);
        //kDLabelContainer17
        kDLabelContainer17.setBoundEditor(txtRemark);
        //contCarNum
        contCarNum.setBoundEditor(txtCarNum);
        //kDLabelContainer19
        kDLabelContainer19.setBoundEditor(txtExpectSuttle);
        //kDLabelContainer20
        kDLabelContainer20.setBoundEditor(cmbWeightType);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(txtDriver);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(txtMaterial);

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
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKWeighPlatformUIHandler";
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
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.framework.CoreBillBaseInfo)ov;
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        dataBinder.loadFields();
    }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );		
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
     * output btnWeight_actionPerformed method
     */
    protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnAllSave_actionPerformed method
     */
    protected void btnAllSave_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnShowOrder_actionPerformed method
     */
    protected void btnShowOrder_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
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
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CKWeighPlatformUI");
    }




}