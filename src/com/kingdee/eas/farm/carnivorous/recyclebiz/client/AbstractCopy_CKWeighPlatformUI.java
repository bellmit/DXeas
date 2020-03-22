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
public abstract class AbstractCopy_CKWeighPlatformUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCopy_CKWeighPlatformUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnShowOrder;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkIsTemp;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton kDWorkButton3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabel labelKG;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup kDButtonGroup1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer16;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer18;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer19;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer20;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer21;
    protected com.kingdee.bos.ctrl.swing.KDLabel labShowWeight;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer1;
    protected com.kingdee.bos.ctrl.swing.KDContainer kDContainer2;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbWeightType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtExpectSuttle;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCarNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRemark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox kDBizPromptBox2;
    protected com.kingdee.bos.ctrl.swing.KDComboBox kDComboBox3;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbBizType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpOutTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpInTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBizDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSuttle;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGross;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtTare;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer12;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnQuery;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable tbList;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtQcarnumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbQueryBillStatus;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.eas.framework.CoreBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractCopy_CKWeighPlatformUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCopy_CKWeighPlatformUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnShowOrder = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkIsTemp = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDWorkButton2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDWorkButton3 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labelKG = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDButtonGroup1 = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer15 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer16 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer17 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer18 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer19 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer20 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer21 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.labShowWeight = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDContainer1 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.kDContainer2 = new com.kingdee.bos.ctrl.swing.KDContainer();
        this.cmbWeightType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtExpectSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCarNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtRemark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDBizPromptBox2 = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDComboBox3 = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cmbBizType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.dpOutTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpInTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtSuttle = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGross = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtTare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtCar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer13 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer12 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tbList = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtQcarnumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cmbQueryBillStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.btnShowOrder.setName("btnShowOrder");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.chkIsTemp.setName("chkIsTemp");
        this.kDWorkButton2.setName("kDWorkButton2");
        this.kDWorkButton3.setName("kDWorkButton3");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.labelKG.setName("labelKG");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.kDLabelContainer15.setName("kDLabelContainer15");
        this.kDLabelContainer16.setName("kDLabelContainer16");
        this.kDLabelContainer17.setName("kDLabelContainer17");
        this.kDLabelContainer18.setName("kDLabelContainer18");
        this.kDLabelContainer19.setName("kDLabelContainer19");
        this.kDLabelContainer20.setName("kDLabelContainer20");
        this.kDLabelContainer21.setName("kDLabelContainer21");
        this.labShowWeight.setName("labShowWeight");
        this.kDContainer1.setName("kDContainer1");
        this.kDContainer2.setName("kDContainer2");
        this.cmbWeightType.setName("cmbWeightType");
        this.txtExpectSuttle.setName("txtExpectSuttle");
        this.txtCarNumber.setName("txtCarNumber");
        this.txtRemark.setName("txtRemark");
        this.kDBizPromptBox2.setName("kDBizPromptBox2");
        this.kDComboBox3.setName("kDComboBox3");
        this.cmbBizType.setName("cmbBizType");
        this.txtNumber.setName("txtNumber");
        this.dpOutTime.setName("dpOutTime");
        this.dpInTime.setName("dpInTime");
        this.dpBizDate.setName("dpBizDate");
        this.txtSuttle.setName("txtSuttle");
        this.txtGross.setName("txtGross");
        this.txtTare.setName("txtTare");
        this.prmtCar.setName("prmtCar");
        this.kDLabelContainer13.setName("kDLabelContainer13");
        this.kDLabelContainer12.setName("kDLabelContainer12");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.btnQuery.setName("btnQuery");
        this.tbList.setName("tbList");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.txtQcarnumber.setName("txtQcarnumber");
        this.cmbQueryBillStatus.setName("cmbQueryBillStatus");
        this.kDTable1.setName("kDTable1");
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
        this.kDSeparator2.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);		
        this.kDSeparator4.setVisible(false);		
        this.kDSeparator4.setEnabled(false);		
        this.rMenuItemSubmit.setVisible(false);		
        this.rMenuItemSubmit.setEnabled(false);		
        this.rMenuItemSubmitAndAddNew.setVisible(false);		
        this.rMenuItemSubmitAndAddNew.setEnabled(false);		
        this.rMenuItemSubmitAndPrint.setVisible(false);		
        this.rMenuItemSubmitAndPrint.setEnabled(false);		
        this.btnReset.setEnabled(false);		
        this.btnReset.setVisible(false);		
        this.menuItemReset.setEnabled(false);		
        this.menuItemReset.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // btnShowOrder		
        this.btnShowOrder.setText(resHelper.getString("btnShowOrder.text"));
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setVisible(false);
        // chkIsTemp		
        this.chkIsTemp.setText(resHelper.getString("chkIsTemp.text"));
        // kDWorkButton2		
        this.kDWorkButton2.setText(resHelper.getString("kDWorkButton2.text"));		
        this.kDWorkButton2.setFont(resHelper.getFont("kDWorkButton2.font"));
        this.kDWorkButton2.addActionListener(new java.awt.event.ActionListener() {
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
        // kDWorkButton3		
        this.kDWorkButton3.setText(resHelper.getString("kDWorkButton3.text"));		
        this.kDWorkButton3.setFont(resHelper.getFont("kDWorkButton3.font"));
        this.kDWorkButton3.addActionListener(new java.awt.event.ActionListener() {
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
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(100);		
        this.kDLabelContainer5.setBoundLabelUnderline(true);
        // labelKG		
        this.labelKG.setText(resHelper.getString("labelKG.text"));		
        this.labelKG.setFont(resHelper.getFont("labelKG.font"));		
        this.labelKG.setForeground(new java.awt.Color(0,187,0));
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);		
        this.kDLabelContainer8.setVisible(false);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));		
        this.kDLabelContainer10.setBoundLabelUnderline(true);		
        this.kDLabelContainer10.setBoundLabelLength(100);		
        this.kDLabelContainer10.setVisible(false);
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelLength(100);		
        this.kDLabelContainer11.setBoundLabelUnderline(true);
        // kDButtonGroup1
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelUnderline(true);		
        this.kDLabelContainer14.setBoundLabelLength(100);
        // kDLabelContainer15		
        this.kDLabelContainer15.setBoundLabelText(resHelper.getString("kDLabelContainer15.boundLabelText"));		
        this.kDLabelContainer15.setBoundLabelUnderline(true);		
        this.kDLabelContainer15.setBoundLabelLength(100);
        // kDLabelContainer16		
        this.kDLabelContainer16.setBoundLabelText(resHelper.getString("kDLabelContainer16.boundLabelText"));		
        this.kDLabelContainer16.setBoundLabelUnderline(true);		
        this.kDLabelContainer16.setBoundLabelLength(100);
        // kDLabelContainer17		
        this.kDLabelContainer17.setBoundLabelText(resHelper.getString("kDLabelContainer17.boundLabelText"));		
        this.kDLabelContainer17.setBoundLabelUnderline(true);		
        this.kDLabelContainer17.setBoundLabelLength(100);
        // kDLabelContainer18		
        this.kDLabelContainer18.setBoundLabelText(resHelper.getString("kDLabelContainer18.boundLabelText"));		
        this.kDLabelContainer18.setBoundLabelUnderline(true);		
        this.kDLabelContainer18.setBoundLabelLength(100);
        // kDLabelContainer19		
        this.kDLabelContainer19.setBoundLabelText(resHelper.getString("kDLabelContainer19.boundLabelText"));		
        this.kDLabelContainer19.setBoundLabelUnderline(true);		
        this.kDLabelContainer19.setBoundLabelLength(100);
        // kDLabelContainer20		
        this.kDLabelContainer20.setBoundLabelText(resHelper.getString("kDLabelContainer20.boundLabelText"));		
        this.kDLabelContainer20.setBoundLabelUnderline(true);		
        this.kDLabelContainer20.setBoundLabelLength(100);
        // kDLabelContainer21		
        this.kDLabelContainer21.setBoundLabelText(resHelper.getString("kDLabelContainer21.boundLabelText"));		
        this.kDLabelContainer21.setBoundLabelUnderline(true);		
        this.kDLabelContainer21.setBoundLabelLength(100);
        // labShowWeight		
        this.labShowWeight.setText(resHelper.getString("labShowWeight.text"));		
        this.labShowWeight.setFont(resHelper.getFont("labShowWeight.font"));		
        this.labShowWeight.setForeground(new java.awt.Color(86,210,45));		
        this.labShowWeight.setHorizontalAlignment(4);
        // kDContainer1
        // kDContainer2
        // cmbWeightType		
        this.cmbWeightType.setActionCommand("");		
        this.cmbWeightType.setEnabled(false);		
        this.cmbWeightType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseType").toArray());
        // txtExpectSuttle
        // txtCarNumber
        // txtRemark
        // kDBizPromptBox2
        // kDComboBox3		
        this.kDComboBox3.setActionCommand("");		
        this.kDComboBox3.setEnabled(false);		
        this.kDComboBox3.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // cmbBizType		
        this.cmbBizType.setActionCommand("cmbWeighType");		
        this.cmbBizType.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBizType").toArray());
        // txtNumber
        // dpOutTime		
        this.dpOutTime.setRequired(true);
        // dpInTime		
        this.dpInTime.setRequired(true);
        // dpBizDate
        // txtSuttle
        // txtGross
        // txtTare
        // prmtCar
        // kDLabelContainer13		
        this.kDLabelContainer13.setBoundLabelText(resHelper.getString("kDLabelContainer13.boundLabelText"));		
        this.kDLabelContainer13.setBoundLabelLength(100);		
        this.kDLabelContainer13.setBoundLabelUnderline(true);
        // kDLabelContainer12		
        this.kDLabelContainer12.setBoundLabelText(resHelper.getString("kDLabelContainer12.boundLabelText"));		
        this.kDLabelContainer12.setBoundLabelLength(100);		
        this.kDLabelContainer12.setBoundLabelUnderline(true);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(100);		
        this.kDLabelContainer6.setBoundLabelUnderline(true);
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        this.btnQuery.addActionListener(new java.awt.event.ActionListener() {
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
		String tbListStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"car\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"orderNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"orderStorageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"inTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"outTime\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"materialID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"tare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"gross\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" /><t:Column t:key=\"tare2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"impurity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"impurity2\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"suttle\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"entryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol20\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{car}</t:Cell><t:Cell>$Resource{orderNumber}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{orderStorageOrgUnit}</t:Cell><t:Cell>$Resource{inTime}</t:Cell><t:Cell>$Resource{outTime}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{tare}</t:Cell><t:Cell>$Resource{gross}</t:Cell><t:Cell>$Resource{tare2}</t:Cell><t:Cell>$Resource{impurity}</t:Cell><t:Cell>$Resource{impurity2}</t:Cell><t:Cell>$Resource{suttle}</t:Cell><t:Cell>$Resource{entryID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.tbList.setFormatXml(resHelper.translateString("tbList",tbListStrXML));

        

        // dpBeginDate
        // dpEndDate
        // txtQcarnumber
        // cmbQueryBillStatus		
        this.cmbQueryBillStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.weighbridge.WeighBaseStatus").toArray());
        // kDTable1

        

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
        kDLabelContainer1.setBounds(new Rectangle(325, 128, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(325, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(624, 187, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(624, 187, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnShowOrder.setBounds(new Rectangle(16, 280, 110, 27));
        this.add(btnShowOrder, new KDLayout.Constraints(16, 280, 110, 27, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(624, 156, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(624, 156, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkIsTemp.setBounds(new Rectangle(32, 158, 144, 19));
        this.add(chkIsTemp, new KDLayout.Constraints(32, 158, 144, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDWorkButton2.setBounds(new Rectangle(1009, 180, 128, 60));
        this.add(kDWorkButton2, new KDLayout.Constraints(1009, 180, 128, 60, 0));
        kDWorkButton3.setBounds(new Rectangle(1009, 97, 128, 60));
        this.add(kDWorkButton3, new KDLayout.Constraints(1009, 97, 128, 60, 0));
        kDLabelContainer5.setBounds(new Rectangle(32, 249, 860, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(32, 249, 860, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labelKG.setBounds(new Rectangle(529, 39, 100, 31));
        this.add(labelKG, new KDLayout.Constraints(529, 39, 100, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(-683, 382, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(-683, 382, 270, 19, 0));
        kDLabelContainer9.setBounds(new Rectangle(624, 97, 270, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(624, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer10.setBounds(new Rectangle(-217, 293, 270, 19));
        this.add(kDLabelContainer10, new KDLayout.Constraints(-217, 293, 270, 19, 0));
        kDLabelContainer11.setBounds(new Rectangle(32, 128, 270, 19));
        this.add(kDLabelContainer11, new KDLayout.Constraints(32, 128, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer14.setBounds(new Rectangle(32, 97, 270, 19));
        this.add(kDLabelContainer14, new KDLayout.Constraints(32, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer15.setBounds(new Rectangle(325, 188, 270, 19));
        this.add(kDLabelContainer15, new KDLayout.Constraints(325, 188, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer16.setBounds(new Rectangle(32, 188, 270, 19));
        this.add(kDLabelContainer16, new KDLayout.Constraints(32, 188, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer17.setBounds(new Rectangle(325, 97, 270, 19));
        this.add(kDLabelContainer17, new KDLayout.Constraints(325, 97, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer18.setBounds(new Rectangle(624, 218, 270, 19));
        this.add(kDLabelContainer18, new KDLayout.Constraints(624, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer19.setBounds(new Rectangle(32, 218, 270, 19));
        this.add(kDLabelContainer19, new KDLayout.Constraints(32, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer20.setBounds(new Rectangle(325, 218, 270, 19));
        this.add(kDLabelContainer20, new KDLayout.Constraints(325, 218, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer21.setBounds(new Rectangle(325, 158, 270, 19));
        this.add(kDLabelContainer21, new KDLayout.Constraints(325, 158, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        labShowWeight.setBounds(new Rectangle(302, -2, 219, 96));
        this.add(labShowWeight, new KDLayout.Constraints(302, -2, 219, 96, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDContainer1.setBounds(new Rectangle(11, 451, 1175, 341));
        this.add(kDContainer1, new KDLayout.Constraints(11, 451, 1175, 341, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDContainer2.setBounds(new Rectangle(17, 311, 1166, 116));
        this.add(kDContainer2, new KDLayout.Constraints(17, 311, 1166, 116, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(cmbWeightType);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtExpectSuttle);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtCarNumber);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(txtRemark);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(kDBizPromptBox2);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(kDComboBox3);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(cmbBizType);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(txtNumber);
        //kDLabelContainer15
        kDLabelContainer15.setBoundEditor(dpOutTime);
        //kDLabelContainer16
        kDLabelContainer16.setBoundEditor(dpInTime);
        //kDLabelContainer17
        kDLabelContainer17.setBoundEditor(dpBizDate);
        //kDLabelContainer18
        kDLabelContainer18.setBoundEditor(txtSuttle);
        //kDLabelContainer19
        kDLabelContainer19.setBoundEditor(txtGross);
        //kDLabelContainer20
        kDLabelContainer20.setBoundEditor(txtTare);
        //kDLabelContainer21
        kDLabelContainer21.setBoundEditor(prmtCar);
        //kDContainer1
        kDContainer1.getContentPane().setLayout(new KDLayout());
        kDContainer1.getContentPane().putClientProperty("OriginalBounds", new Rectangle(11, 451, 1175, 341));        kDLabelContainer13.setBounds(new Rectangle(15, 18, 270, 19));
        kDContainer1.getContentPane().add(kDLabelContainer13, new KDLayout.Constraints(15, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer12.setBounds(new Rectangle(360, 18, 270, 19));
        kDContainer1.getContentPane().add(kDLabelContainer12, new KDLayout.Constraints(360, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(706, 18, 275, 19));
        kDContainer1.getContentPane().add(kDLabelContainer3, new KDLayout.Constraints(706, 18, 275, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(15, 47, 270, 19));
        kDContainer1.getContentPane().add(kDLabelContainer6, new KDLayout.Constraints(15, 47, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnQuery.setBounds(new Rectangle(1057, 18, 78, 23));
        kDContainer1.getContentPane().add(btnQuery, new KDLayout.Constraints(1057, 18, 78, 23, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        tbList.setBounds(new Rectangle(11, 79, 1160, 230));
        kDContainer1.getContentPane().add(tbList, new KDLayout.Constraints(11, 79, 1160, 230, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer13
        kDLabelContainer13.setBoundEditor(dpBeginDate);
        //kDLabelContainer12
        kDLabelContainer12.setBoundEditor(dpEndDate);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtQcarnumber);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(cmbQueryBillStatus);
        //kDContainer2
        kDContainer2.getContentPane().setLayout(new KDLayout());
        kDContainer2.getContentPane().putClientProperty("OriginalBounds", new Rectangle(17, 311, 1166, 116));        kDTable1.setBounds(new Rectangle(5, 5, 1145, 86));
        kDContainer2.getContentPane().add(kDTable1, new KDLayout.Constraints(5, 5, 1145, 86, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));

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


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.Copy_CKWeighPlatformUIHandler";
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
        this.editData = (com.kingdee.eas.framework.CoreBaseInfo)ov;
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
        }
    }

    /**
     * output btnShowOrder_actionPerformed method
     */
    protected void btnShowOrder_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnAllSave_actionPerformed method
     */
    protected void btnAllSave_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnWeight_actionPerformed method
     */
    protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "Copy_CKWeighPlatformUI");
    }




}