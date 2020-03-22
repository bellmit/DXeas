/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

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
public abstract class AbstractSquareAccountCheckUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSquareAccountCheckUI.class);
    protected com.kingdee.bos.ctrl.swing.KDButton btnCheckAll;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contPeriod;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCompany;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPeriod;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelCheck;
    protected com.kingdee.bos.ctrl.swing.KDPanel panelFunction;
    protected com.kingdee.bos.ctrl.swing.KDPanel kdPanelOther;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDButton btnFeed;
    protected com.kingdee.bos.ctrl.swing.KDButton btnDrug;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGermchit;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGermchitReceive;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAccessory;
    protected com.kingdee.bos.ctrl.swing.KDButton btnHatcheggBalance;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAsset;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCost;
    protected com.kingdee.bos.ctrl.swing.KDButton btnReward;
    protected com.kingdee.bos.ctrl.swing.KDButton btnByproduct;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCheckResult;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDetails;
    protected com.kingdee.bos.ctrl.swing.KDButton btnBegin;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFunction;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contItem;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEndDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFunction;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contHatchArea;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSelectModel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contContent;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSearch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBillNum;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxItem;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkEndDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxFunction;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtHatchArea;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxSelectModel;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxContent;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBillNum;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUpdateBatch;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUpdateFarm;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUpdateFarmer;
    protected com.kingdee.eas.framework.CoreBaseInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSquareAccountCheckUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSquareAccountCheckUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.btnCheckAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contPeriod = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.prmtPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.panelCheck = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.panelFunction = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdPanelOther = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.btnFeed = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnDrug = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnGermchit = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnGermchitReceive = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAccessory = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnHatcheggBalance = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAsset = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCost = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnReward = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnByproduct = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtCheckResult = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDetails = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnBegin = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtFunction = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contItem = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEndDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contBeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFunction = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contHatchArea = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSelectModel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contContent = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnSearch = new com.kingdee.bos.ctrl.swing.KDButton();
        this.contBillNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cboxItem = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.pkEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cboxFunction = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtHatchArea = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cboxSelectModel = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cboxContent = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtBillNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.btnUpdateBatch = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUpdateFarm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUpdateFarmer = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCheckAll.setName("btnCheckAll");
        this.contPeriod.setName("contPeriod");
        this.contCompany.setName("contCompany");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.prmtPeriod.setName("prmtPeriod");
        this.prmtCompany.setName("prmtCompany");
        this.panelCheck.setName("panelCheck");
        this.panelFunction.setName("panelFunction");
        this.kdPanelOther.setName("kdPanelOther");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.btnFeed.setName("btnFeed");
        this.btnDrug.setName("btnDrug");
        this.btnGermchit.setName("btnGermchit");
        this.btnGermchitReceive.setName("btnGermchitReceive");
        this.btnAccessory.setName("btnAccessory");
        this.btnHatcheggBalance.setName("btnHatcheggBalance");
        this.btnAsset.setName("btnAsset");
        this.btnCost.setName("btnCost");
        this.btnReward.setName("btnReward");
        this.btnByproduct.setName("btnByproduct");
        this.kdtCheckResult.setName("kdtCheckResult");
        this.kdtDetails.setName("kdtDetails");
        this.btnBegin.setName("btnBegin");
        this.kdtFunction.setName("kdtFunction");
        this.contItem.setName("contItem");
        this.contEndDate.setName("contEndDate");
        this.contBeginDate.setName("contBeginDate");
        this.contFunction.setName("contFunction");
        this.contHatchArea.setName("contHatchArea");
        this.contSelectModel.setName("contSelectModel");
        this.contContent.setName("contContent");
        this.btnSearch.setName("btnSearch");
        this.contBillNum.setName("contBillNum");
        this.cboxItem.setName("cboxItem");
        this.pkEndDate.setName("pkEndDate");
        this.pkBeginDate.setName("pkBeginDate");
        this.cboxFunction.setName("cboxFunction");
        this.prmtHatchArea.setName("prmtHatchArea");
        this.cboxSelectModel.setName("cboxSelectModel");
        this.cboxContent.setName("cboxContent");
        this.txtBillNum.setName("txtBillNum");
        this.btnUpdateBatch.setName("btnUpdateBatch");
        this.btnUpdateFarm.setName("btnUpdateFarm");
        this.btnUpdateFarmer.setName("btnUpdateFarmer");
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
        // btnCheckAll		
        this.btnCheckAll.setText(resHelper.getString("btnCheckAll.text"));
        this.btnCheckAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnCheckAll_mouseClick(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // contPeriod		
        this.contPeriod.setBoundLabelText(resHelper.getString("contPeriod.boundLabelText"));		
        this.contPeriod.setBoundLabelLength(100);		
        this.contPeriod.setBoundLabelUnderline(true);
        // contCompany		
        this.contCompany.setBoundLabelText(resHelper.getString("contCompany.boundLabelText"));		
        this.contCompany.setBoundLabelLength(100);		
        this.contCompany.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // prmtPeriod		
        this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtPeriod.setCommitFormat("$number$");		
        this.prmtPeriod.setEditFormat("$number$");		
        this.prmtPeriod.setDisplayFormat("$number$");
        // prmtCompany		
        this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtCompany.setCommitFormat("$number$;$name$");		
        this.prmtCompany.setDisplayFormat("$name$");		
        this.prmtCompany.setEditFormat("$number$");
        // panelCheck		
        this.panelCheck.setBorder(null);
        // panelFunction
        // kdPanelOther
        // kDPanel3		
        this.kDPanel3.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
        // kDPanel4		
        this.kDPanel4.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
        // btnFeed		
        this.btnFeed.setText(resHelper.getString("btnFeed.text"));
        this.btnFeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnFeed_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnDrug		
        this.btnDrug.setText(resHelper.getString("btnDrug.text"));
        // btnGermchit		
        this.btnGermchit.setText(resHelper.getString("btnGermchit.text"));
        this.btnGermchit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnGermchit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnGermchitReceive		
        this.btnGermchitReceive.setText(resHelper.getString("btnGermchitReceive.text"));
        // btnAccessory		
        this.btnAccessory.setText(resHelper.getString("btnAccessory.text"));
        // btnHatcheggBalance		
        this.btnHatcheggBalance.setText(resHelper.getString("btnHatcheggBalance.text"));
        // btnAsset		
        this.btnAsset.setText(resHelper.getString("btnAsset.text"));
        // btnCost		
        this.btnCost.setText(resHelper.getString("btnCost.text"));
        // btnReward		
        this.btnReward.setText(resHelper.getString("btnReward.text"));
        // btnByproduct		
        this.btnByproduct.setText(resHelper.getString("btnByproduct.text"));
        // kdtCheckResult
		String kdtCheckResultStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"checkType\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkResult\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"type\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{checkType}</t:Cell><t:Cell>$Resource{checkResult}</t:Cell><t:Cell>$Resource{type}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCheckResult.setFormatXml(resHelper.translateString("kdtCheckResult",kdtCheckResultStrXML));

        

        // kdtDetails
		String kdtDetailsStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"selected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNumber\" t:width=\"125\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"question\" t:width=\"260\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{question}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDetails.setFormatXml(resHelper.translateString("kdtDetails",kdtDetailsStrXML));

        

        // btnBegin		
        this.btnBegin.setText(resHelper.getString("btnBegin.text"));
        // kdtFunction
		String kdtFunctionStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"Selected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"BillNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"hatchArea\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"checkContent\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{Selected}</t:Cell><t:Cell>$Resource{BillNumber}</t:Cell><t:Cell>$Resource{hatchArea}</t:Cell><t:Cell>$Resource{checkContent}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFunction.setFormatXml(resHelper.translateString("kdtFunction",kdtFunctionStrXML));

        

        // contItem		
        this.contItem.setBoundLabelText(resHelper.getString("contItem.boundLabelText"));		
        this.contItem.setBoundLabelLength(100);		
        this.contItem.setBoundLabelUnderline(true);
        // contEndDate		
        this.contEndDate.setBoundLabelText(resHelper.getString("contEndDate.boundLabelText"));		
        this.contEndDate.setBoundLabelLength(100);		
        this.contEndDate.setBoundLabelUnderline(true);
        // contBeginDate		
        this.contBeginDate.setBoundLabelLength(100);		
        this.contBeginDate.setBoundLabelUnderline(true);		
        this.contBeginDate.setBoundLabelText(resHelper.getString("contBeginDate.boundLabelText"));
        // contFunction		
        this.contFunction.setBoundLabelText(resHelper.getString("contFunction.boundLabelText"));		
        this.contFunction.setBoundLabelLength(100);		
        this.contFunction.setBoundLabelUnderline(true);
        // contHatchArea		
        this.contHatchArea.setBoundLabelText(resHelper.getString("contHatchArea.boundLabelText"));		
        this.contHatchArea.setBoundLabelLength(100);		
        this.contHatchArea.setBoundLabelUnderline(true);
        // contSelectModel		
        this.contSelectModel.setBoundLabelText(resHelper.getString("contSelectModel.boundLabelText"));		
        this.contSelectModel.setBoundLabelLength(80);		
        this.contSelectModel.setBoundLabelUnderline(true);
        // contContent		
        this.contContent.setBoundLabelText(resHelper.getString("contContent.boundLabelText"));		
        this.contContent.setBoundLabelLength(80);		
        this.contContent.setBoundLabelUnderline(true);
        // btnSearch		
        this.btnSearch.setText(resHelper.getString("btnSearch.text"));
        // contBillNum		
        this.contBillNum.setBoundLabelText(resHelper.getString("contBillNum.boundLabelText"));		
        this.contBillNum.setBoundLabelLength(100);		
        this.contBillNum.setBoundLabelUnderline(true);
        // cboxItem
        this.cboxItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cboxItem_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // pkEndDate
        // pkBeginDate
        // cboxFunction
        this.cboxFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cboxFunction_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtHatchArea		
        this.prmtHatchArea.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtHatchArea.setCommitFormat("$number$;$name$");		
        this.prmtHatchArea.setDisplayFormat("$name$");		
        this.prmtHatchArea.setEditFormat("$number$");
        // cboxSelectModel
        // cboxContent
        // txtBillNum
        // btnUpdateBatch		
        this.btnUpdateBatch.setText(resHelper.getString("btnUpdateBatch.text"));
        // btnUpdateFarm		
        this.btnUpdateFarm.setText(resHelper.getString("btnUpdateFarm.text"));
        // btnUpdateFarmer		
        this.btnUpdateFarmer.setText(resHelper.getString("btnUpdateFarmer.text"));
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
        this.setBounds(new Rectangle(10, 10, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 629));
        btnCheckAll.setBounds(new Rectangle(851, 38, 86, 21));
        this.add(btnCheckAll, new KDLayout.Constraints(851, 38, 86, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contPeriod.setBounds(new Rectangle(360, 38, 270, 19));
        this.add(contPeriod, new KDLayout.Constraints(360, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCompany.setBounds(new Rectangle(12, 38, 270, 19));
        this.add(contCompany, new KDLayout.Constraints(12, 38, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(12, 81, 983, 531));
        this.add(kDTabbedPane1, new KDLayout.Constraints(12, 81, 983, 531, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contPeriod
        contPeriod.setBoundEditor(prmtPeriod);
        //contCompany
        contCompany.setBoundEditor(prmtCompany);
        //kDTabbedPane1
        kDTabbedPane1.add(panelCheck, resHelper.getString("panelCheck.constraints"));
        kDTabbedPane1.add(panelFunction, resHelper.getString("panelFunction.constraints"));
        kDTabbedPane1.add(kdPanelOther, resHelper.getString("kdPanelOther.constraints"));
        //panelCheck
        panelCheck.setLayout(new KDLayout());
        panelCheck.putClientProperty("OriginalBounds", new Rectangle(0, 0, 982, 498));        kDPanel3.setBounds(new Rectangle(4, 14, 970, 88));
        panelCheck.add(kDPanel3, new KDLayout.Constraints(4, 14, 970, 88, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel4.setBounds(new Rectangle(3, 135, 970, 354));
        panelCheck.add(kDPanel4, new KDLayout.Constraints(3, 135, 970, 354, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(4, 14, 970, 88));        btnFeed.setBounds(new Rectangle(12, 16, 125, 21));
        kDPanel3.add(btnFeed, new KDLayout.Constraints(12, 16, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnDrug.setBounds(new Rectangle(172, 16, 125, 21));
        kDPanel3.add(btnDrug, new KDLayout.Constraints(172, 16, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGermchit.setBounds(new Rectangle(332, 16, 125, 21));
        kDPanel3.add(btnGermchit, new KDLayout.Constraints(332, 16, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGermchitReceive.setBounds(new Rectangle(492, 16, 125, 21));
        kDPanel3.add(btnGermchitReceive, new KDLayout.Constraints(492, 16, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAccessory.setBounds(new Rectangle(172, 50, 125, 21));
        kDPanel3.add(btnAccessory, new KDLayout.Constraints(172, 50, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnHatcheggBalance.setBounds(new Rectangle(652, 16, 125, 21));
        kDPanel3.add(btnHatcheggBalance, new KDLayout.Constraints(652, 16, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAsset.setBounds(new Rectangle(814, 15, 125, 21));
        kDPanel3.add(btnAsset, new KDLayout.Constraints(814, 15, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnCost.setBounds(new Rectangle(13, 50, 125, 21));
        kDPanel3.add(btnCost, new KDLayout.Constraints(13, 50, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnReward.setBounds(new Rectangle(332, 50, 125, 21));
        kDPanel3.add(btnReward, new KDLayout.Constraints(332, 50, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnByproduct.setBounds(new Rectangle(492, 51, 125, 21));
        kDPanel3.add(btnByproduct, new KDLayout.Constraints(492, 51, 125, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(3, 135, 970, 354));        kdtCheckResult.setBounds(new Rectangle(11, 14, 417, 332));
        kDPanel4.add(kdtCheckResult, new KDLayout.Constraints(11, 14, 417, 332, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtDetails.setBounds(new Rectangle(442, 14, 493, 329));
        kDPanel4.add(kdtDetails, new KDLayout.Constraints(442, 14, 493, 329, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //panelFunction
        panelFunction.setLayout(new KDLayout());
        panelFunction.putClientProperty("OriginalBounds", new Rectangle(0, 0, 982, 498));        btnBegin.setBounds(new Rectangle(175, 100, 86, 21));
        panelFunction.add(btnBegin, new KDLayout.Constraints(175, 100, 86, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtFunction.setBounds(new Rectangle(17, 137, 937, 327));
        panelFunction.add(kdtFunction, new KDLayout.Constraints(17, 137, 937, 327, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contItem.setBounds(new Rectangle(16, 16, 270, 19));
        panelFunction.add(contItem, new KDLayout.Constraints(16, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contEndDate.setBounds(new Rectangle(360, 60, 270, 19));
        panelFunction.add(contEndDate, new KDLayout.Constraints(360, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBeginDate.setBounds(new Rectangle(360, 13, 270, 19));
        panelFunction.add(contBeginDate, new KDLayout.Constraints(360, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFunction.setBounds(new Rectangle(16, 60, 270, 19));
        panelFunction.add(contFunction, new KDLayout.Constraints(16, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contHatchArea.setBounds(new Rectangle(658, 15, 270, 19));
        panelFunction.add(contHatchArea, new KDLayout.Constraints(658, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contSelectModel.setBounds(new Rectangle(300, 105, 191, 19));
        panelFunction.add(contSelectModel, new KDLayout.Constraints(300, 105, 191, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contContent.setBounds(new Rectangle(533, 102, 191, 19));
        panelFunction.add(contContent, new KDLayout.Constraints(533, 102, 191, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSearch.setBounds(new Rectangle(18, 100, 86, 21));
        panelFunction.add(btnSearch, new KDLayout.Constraints(18, 100, 86, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBillNum.setBounds(new Rectangle(658, 60, 270, 19));
        panelFunction.add(contBillNum, new KDLayout.Constraints(658, 60, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contItem
        contItem.setBoundEditor(cboxItem);
        //contEndDate
        contEndDate.setBoundEditor(pkEndDate);
        //contBeginDate
        contBeginDate.setBoundEditor(pkBeginDate);
        //contFunction
        contFunction.setBoundEditor(cboxFunction);
        //contHatchArea
        contHatchArea.setBoundEditor(prmtHatchArea);
        //contSelectModel
        contSelectModel.setBoundEditor(cboxSelectModel);
        //contContent
        contContent.setBoundEditor(cboxContent);
        //contBillNum
        contBillNum.setBoundEditor(txtBillNum);
        //kdPanelOther
        kdPanelOther.setLayout(null);        btnUpdateBatch.setBounds(new Rectangle(28, 25, 102, 21));
        kdPanelOther.add(btnUpdateBatch, null);
        btnUpdateFarm.setBounds(new Rectangle(373, 25, 102, 21));
        kdPanelOther.add(btnUpdateFarm, null);
        btnUpdateFarmer.setBounds(new Rectangle(188, 25, 102, 21));
        kdPanelOther.add(btnUpdateFarmer, null);

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
	    return "com.kingdee.eas.farm.stocking.processbizill.app.SquareAccountCheckUIHandler";
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
     * output btnCheckAll_mouseClick method
     */
    protected void btnCheckAll_mouseClick(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnFeed_actionPerformed method
     */
    protected void btnFeed_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnGermchit_actionPerformed method
     */
    protected void btnGermchit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output cboxItem_actionPerformed method
     */
    protected void cboxItem_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output cboxFunction_actionPerformed method
     */
    protected void cboxFunction_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
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
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "SquareAccountCheckUI");
    }




}