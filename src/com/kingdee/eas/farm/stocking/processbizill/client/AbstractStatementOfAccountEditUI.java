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
public abstract class AbstractStatementOfAccountEditUI extends com.kingdee.eas.framework.client.CoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStatementOfAccountEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contNumber;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane2;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtFeedsnew;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtFeedsnew_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFIUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contperiods;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginningBalance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contclosingBalance;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalAPAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttotalARAmount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contconfirmTime;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkhasConfirm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccessoryac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostOfLivingac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfundInterestac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contothersac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contloanInterestac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfeedsall;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdrugac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtaccessoryac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtcostOfLivingac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfundInterestac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtothersac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtloanInterestac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfeedsall;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdrugac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteggPayAmt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conthatchEggac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteliminateac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfertilizationac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepositInterestac;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepositac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txthatchEggac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txteliminateac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfertilizationac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdepositInterestac;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdepositac;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFIUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtperiods;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmer;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbeginningBalance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtclosingBalance;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalAPAmount;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttotalARAmount;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkconfirmTime;
    protected com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractStatementOfAccountEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractStatementOfAccountEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionSubmit
        String _tempStr = null;
        actionSubmit.setEnabled(true);
        actionSubmit.setDaemonRun(false);

        actionSubmit.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
        _tempStr = resHelper.getString("ActionSubmit.SHORT_DESCRIPTION");
        actionSubmit.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.LONG_DESCRIPTION");
        actionSubmit.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionSubmit.NAME");
        actionSubmit.putValue(ItemAction.NAME, _tempStr);
        this.actionSubmit.setBindWorkFlow(true);
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionSubmit.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrint
        actionPrint.setEnabled(true);
        actionPrint.setDaemonRun(false);

        actionPrint.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
        _tempStr = resHelper.getString("ActionPrint.SHORT_DESCRIPTION");
        actionPrint.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.LONG_DESCRIPTION");
        actionPrint.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrint.NAME");
        actionPrint.putValue(ItemAction.NAME, _tempStr);
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrint.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        //actionPrintPreview
        actionPrintPreview.setEnabled(true);
        actionPrintPreview.setDaemonRun(false);

        actionPrintPreview.putValue(ItemAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke("shift ctrl P"));
        _tempStr = resHelper.getString("ActionPrintPreview.SHORT_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.LONG_DESCRIPTION");
        actionPrintPreview.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
        _tempStr = resHelper.getString("ActionPrintPreview.NAME");
        actionPrintPreview.putValue(ItemAction.NAME, _tempStr);
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.NetFunctionService());
         this.actionPrintPreview.addService(new com.kingdee.eas.framework.client.service.UserMonitorService());
        this.contNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane2 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kdtFeedsnew = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contFIUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contperiods = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginningBalance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contclosingBalance = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalAPAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttotalARAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contconfirmTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkhasConfirm = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contaccessoryac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostOfLivingac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfundInterestac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contothersac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contloanInterestac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfeedsall = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdrugac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggPayAmt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtaccessoryac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtcostOfLivingac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfundInterestac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtothersac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtloanInterestac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfeedsall = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdrugac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteggPayAmt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.conthatchEggac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteliminateac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfertilizationac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepositInterestac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdepositac = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txthatchEggac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txteliminateac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtfertilizationac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdepositInterestac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtdepositac = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtFIUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtperiods = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtbeginningBalance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtclosingBalance = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalAPAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txttotalARAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.pkconfirmTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.contNumber.setName("contNumber");
        this.kDTabbedPane2.setName("kDTabbedPane2");
        this.kdtFeedsnew.setName("kdtFeedsnew");
        this.contFIUnit.setName("contFIUnit");
        this.contperiods.setName("contperiods");
        this.contfarmer.setName("contfarmer");
        this.contbeginningBalance.setName("contbeginningBalance");
        this.contclosingBalance.setName("contclosingBalance");
        this.conttotalAPAmount.setName("conttotalAPAmount");
        this.conttotalARAmount.setName("conttotalARAmount");
        this.contconfirmTime.setName("contconfirmTime");
        this.chkhasConfirm.setName("chkhasConfirm");
        this.txtNumber.setName("txtNumber");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.contaccessoryac.setName("contaccessoryac");
        this.contcostOfLivingac.setName("contcostOfLivingac");
        this.contfundInterestac.setName("contfundInterestac");
        this.contothersac.setName("contothersac");
        this.contloanInterestac.setName("contloanInterestac");
        this.contfeedsall.setName("contfeedsall");
        this.contdrugac.setName("contdrugac");
        this.conteggPayAmt.setName("conteggPayAmt");
        this.txtaccessoryac.setName("txtaccessoryac");
        this.txtcostOfLivingac.setName("txtcostOfLivingac");
        this.txtfundInterestac.setName("txtfundInterestac");
        this.txtothersac.setName("txtothersac");
        this.txtloanInterestac.setName("txtloanInterestac");
        this.txtfeedsall.setName("txtfeedsall");
        this.txtdrugac.setName("txtdrugac");
        this.txteggPayAmt.setName("txteggPayAmt");
        this.conthatchEggac.setName("conthatchEggac");
        this.conteliminateac.setName("conteliminateac");
        this.contfertilizationac.setName("contfertilizationac");
        this.contdepositInterestac.setName("contdepositInterestac");
        this.contdepositac.setName("contdepositac");
        this.txthatchEggac.setName("txthatchEggac");
        this.txteliminateac.setName("txteliminateac");
        this.txtfertilizationac.setName("txtfertilizationac");
        this.txtdepositInterestac.setName("txtdepositInterestac");
        this.txtdepositac.setName("txtdepositac");
        this.prmtFIUnit.setName("prmtFIUnit");
        this.prmtperiods.setName("prmtperiods");
        this.prmtfarmer.setName("prmtfarmer");
        this.txtbeginningBalance.setName("txtbeginningBalance");
        this.txtclosingBalance.setName("txtclosingBalance");
        this.txttotalAPAmount.setName("txttotalAPAmount");
        this.txttotalARAmount.setName("txttotalARAmount");
        this.pkconfirmTime.setName("pkconfirmTime");
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
        // contNumber		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);
        // kDTabbedPane2
        // kdtFeedsnew
		String kdtFeedsnewStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"feedsone\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"feedName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"feedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"feedWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"packageNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"feedAC\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{feedsone}</t:Cell><t:Cell>$Resource{feedName}</t:Cell><t:Cell>$Resource{feedQty}</t:Cell><t:Cell>$Resource{feedWeight}</t:Cell><t:Cell>$Resource{packageNumber}</t:Cell><t:Cell>$Resource{feedAC}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtFeedsnew.setFormatXml(resHelper.translateString("kdtFeedsnew",kdtFeedsnewStrXML));
        kdtFeedsnew.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtFeedsnew_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtFeedsnew.putBindContents("editData",new String[] {"seq","feedsone","feedName","feedQty","feedWeight","packageNumber","feedAC"});


        this.kdtFeedsnew.checkParsed();
        KDFormattedTextField kdtFeedsnew_seq_TextField = new KDFormattedTextField();
        kdtFeedsnew_seq_TextField.setName("kdtFeedsnew_seq_TextField");
        kdtFeedsnew_seq_TextField.setVisible(true);
        kdtFeedsnew_seq_TextField.setEditable(true);
        kdtFeedsnew_seq_TextField.setHorizontalAlignment(2);
        kdtFeedsnew_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtFeedsnew_seq_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_seq_TextField);
        this.kdtFeedsnew.getColumn("seq").setEditor(kdtFeedsnew_seq_CellEditor);
        final KDBizPromptBox kdtFeedsnew_feedsone_PromptBox = new KDBizPromptBox();
        kdtFeedsnew_feedsone_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtFeedsnew_feedsone_PromptBox.setVisible(true);
        kdtFeedsnew_feedsone_PromptBox.setEditable(true);
        kdtFeedsnew_feedsone_PromptBox.setDisplayFormat("$number$");
        kdtFeedsnew_feedsone_PromptBox.setEditFormat("$number$");
        kdtFeedsnew_feedsone_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtFeedsnew_feedsone_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_feedsone_PromptBox);
        this.kdtFeedsnew.getColumn("feedsone").setEditor(kdtFeedsnew_feedsone_CellEditor);
        ObjectValueRender kdtFeedsnew_feedsone_OVR = new ObjectValueRender();
        kdtFeedsnew_feedsone_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtFeedsnew.getColumn("feedsone").setRenderer(kdtFeedsnew_feedsone_OVR);
        KDTextField kdtFeedsnew_feedName_TextField = new KDTextField();
        kdtFeedsnew_feedName_TextField.setName("kdtFeedsnew_feedName_TextField");
        kdtFeedsnew_feedName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtFeedsnew_feedName_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_feedName_TextField);
        this.kdtFeedsnew.getColumn("feedName").setEditor(kdtFeedsnew_feedName_CellEditor);
        KDFormattedTextField kdtFeedsnew_feedQty_TextField = new KDFormattedTextField();
        kdtFeedsnew_feedQty_TextField.setName("kdtFeedsnew_feedQty_TextField");
        kdtFeedsnew_feedQty_TextField.setVisible(true);
        kdtFeedsnew_feedQty_TextField.setEditable(true);
        kdtFeedsnew_feedQty_TextField.setHorizontalAlignment(2);
        kdtFeedsnew_feedQty_TextField.setDataType(1);
        	kdtFeedsnew_feedQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedsnew_feedQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedsnew_feedQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedsnew_feedQty_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_feedQty_TextField);
        this.kdtFeedsnew.getColumn("feedQty").setEditor(kdtFeedsnew_feedQty_CellEditor);
        KDFormattedTextField kdtFeedsnew_feedWeight_TextField = new KDFormattedTextField();
        kdtFeedsnew_feedWeight_TextField.setName("kdtFeedsnew_feedWeight_TextField");
        kdtFeedsnew_feedWeight_TextField.setVisible(true);
        kdtFeedsnew_feedWeight_TextField.setEditable(true);
        kdtFeedsnew_feedWeight_TextField.setHorizontalAlignment(2);
        kdtFeedsnew_feedWeight_TextField.setDataType(1);
        	kdtFeedsnew_feedWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedsnew_feedWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedsnew_feedWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedsnew_feedWeight_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_feedWeight_TextField);
        this.kdtFeedsnew.getColumn("feedWeight").setEditor(kdtFeedsnew_feedWeight_CellEditor);
        KDFormattedTextField kdtFeedsnew_packageNumber_TextField = new KDFormattedTextField();
        kdtFeedsnew_packageNumber_TextField.setName("kdtFeedsnew_packageNumber_TextField");
        kdtFeedsnew_packageNumber_TextField.setVisible(true);
        kdtFeedsnew_packageNumber_TextField.setEditable(true);
        kdtFeedsnew_packageNumber_TextField.setHorizontalAlignment(2);
        kdtFeedsnew_packageNumber_TextField.setDataType(1);
        	kdtFeedsnew_packageNumber_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedsnew_packageNumber_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedsnew_packageNumber_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedsnew_packageNumber_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_packageNumber_TextField);
        this.kdtFeedsnew.getColumn("packageNumber").setEditor(kdtFeedsnew_packageNumber_CellEditor);
        KDFormattedTextField kdtFeedsnew_feedAC_TextField = new KDFormattedTextField();
        kdtFeedsnew_feedAC_TextField.setName("kdtFeedsnew_feedAC_TextField");
        kdtFeedsnew_feedAC_TextField.setVisible(true);
        kdtFeedsnew_feedAC_TextField.setEditable(true);
        kdtFeedsnew_feedAC_TextField.setHorizontalAlignment(2);
        kdtFeedsnew_feedAC_TextField.setDataType(1);
        	kdtFeedsnew_feedAC_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtFeedsnew_feedAC_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtFeedsnew_feedAC_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtFeedsnew_feedAC_CellEditor = new KDTDefaultCellEditor(kdtFeedsnew_feedAC_TextField);
        this.kdtFeedsnew.getColumn("feedAC").setEditor(kdtFeedsnew_feedAC_CellEditor);
        // contFIUnit		
        this.contFIUnit.setBoundLabelText(resHelper.getString("contFIUnit.boundLabelText"));		
        this.contFIUnit.setBoundLabelLength(100);		
        this.contFIUnit.setBoundLabelUnderline(true);		
        this.contFIUnit.setVisible(true);
        // contperiods		
        this.contperiods.setBoundLabelText(resHelper.getString("contperiods.boundLabelText"));		
        this.contperiods.setBoundLabelLength(100);		
        this.contperiods.setBoundLabelUnderline(true);		
        this.contperiods.setVisible(true);
        // contfarmer		
        this.contfarmer.setBoundLabelText(resHelper.getString("contfarmer.boundLabelText"));		
        this.contfarmer.setBoundLabelLength(100);		
        this.contfarmer.setBoundLabelUnderline(true);		
        this.contfarmer.setVisible(true);
        // contbeginningBalance		
        this.contbeginningBalance.setBoundLabelText(resHelper.getString("contbeginningBalance.boundLabelText"));		
        this.contbeginningBalance.setBoundLabelLength(100);		
        this.contbeginningBalance.setBoundLabelUnderline(true);		
        this.contbeginningBalance.setVisible(true);
        // contclosingBalance		
        this.contclosingBalance.setBoundLabelText(resHelper.getString("contclosingBalance.boundLabelText"));		
        this.contclosingBalance.setBoundLabelLength(100);		
        this.contclosingBalance.setBoundLabelUnderline(true);		
        this.contclosingBalance.setVisible(true);
        // conttotalAPAmount		
        this.conttotalAPAmount.setBoundLabelText(resHelper.getString("conttotalAPAmount.boundLabelText"));		
        this.conttotalAPAmount.setBoundLabelLength(100);		
        this.conttotalAPAmount.setBoundLabelUnderline(true);		
        this.conttotalAPAmount.setVisible(true);
        // conttotalARAmount		
        this.conttotalARAmount.setBoundLabelText(resHelper.getString("conttotalARAmount.boundLabelText"));		
        this.conttotalARAmount.setBoundLabelLength(100);		
        this.conttotalARAmount.setBoundLabelUnderline(true);		
        this.conttotalARAmount.setVisible(true);
        // contconfirmTime		
        this.contconfirmTime.setBoundLabelText(resHelper.getString("contconfirmTime.boundLabelText"));		
        this.contconfirmTime.setBoundLabelLength(100);		
        this.contconfirmTime.setBoundLabelUnderline(true);		
        this.contconfirmTime.setVisible(true);
        // chkhasConfirm		
        this.chkhasConfirm.setText(resHelper.getString("chkhasConfirm.text"));		
        this.chkhasConfirm.setVisible(true);		
        this.chkhasConfirm.setHorizontalAlignment(2);		
        this.chkhasConfirm.setEnabled(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        this.txtNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    txtNumber_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDPanel1
        // kDPanel2
        // contaccessoryac		
        this.contaccessoryac.setBoundLabelText(resHelper.getString("contaccessoryac.boundLabelText"));		
        this.contaccessoryac.setBoundLabelLength(150);		
        this.contaccessoryac.setBoundLabelUnderline(true);		
        this.contaccessoryac.setVisible(true);
        // contcostOfLivingac		
        this.contcostOfLivingac.setBoundLabelText(resHelper.getString("contcostOfLivingac.boundLabelText"));		
        this.contcostOfLivingac.setBoundLabelLength(150);		
        this.contcostOfLivingac.setBoundLabelUnderline(true);		
        this.contcostOfLivingac.setVisible(true);
        // contfundInterestac		
        this.contfundInterestac.setBoundLabelText(resHelper.getString("contfundInterestac.boundLabelText"));		
        this.contfundInterestac.setBoundLabelLength(150);		
        this.contfundInterestac.setBoundLabelUnderline(true);		
        this.contfundInterestac.setVisible(true);
        // contothersac		
        this.contothersac.setBoundLabelText(resHelper.getString("contothersac.boundLabelText"));		
        this.contothersac.setBoundLabelLength(150);		
        this.contothersac.setBoundLabelUnderline(true);		
        this.contothersac.setVisible(true);
        // contloanInterestac		
        this.contloanInterestac.setBoundLabelText(resHelper.getString("contloanInterestac.boundLabelText"));		
        this.contloanInterestac.setBoundLabelLength(150);		
        this.contloanInterestac.setBoundLabelUnderline(true);		
        this.contloanInterestac.setVisible(true);
        // contfeedsall		
        this.contfeedsall.setBoundLabelText(resHelper.getString("contfeedsall.boundLabelText"));		
        this.contfeedsall.setBoundLabelLength(150);		
        this.contfeedsall.setBoundLabelUnderline(true);		
        this.contfeedsall.setVisible(true);
        // contdrugac		
        this.contdrugac.setBoundLabelText(resHelper.getString("contdrugac.boundLabelText"));		
        this.contdrugac.setBoundLabelLength(150);		
        this.contdrugac.setBoundLabelUnderline(true);		
        this.contdrugac.setVisible(true);
        // conteggPayAmt		
        this.conteggPayAmt.setBoundLabelText(resHelper.getString("conteggPayAmt.boundLabelText"));		
        this.conteggPayAmt.setBoundLabelLength(150);		
        this.conteggPayAmt.setBoundLabelUnderline(true);		
        this.conteggPayAmt.setVisible(true);
        // txtaccessoryac		
        this.txtaccessoryac.setHorizontalAlignment(2);		
        this.txtaccessoryac.setDataType(1);		
        this.txtaccessoryac.setSupportedEmpty(true);		
        this.txtaccessoryac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtaccessoryac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtaccessoryac.setPrecision(2);		
        this.txtaccessoryac.setRequired(false);
        // txtcostOfLivingac		
        this.txtcostOfLivingac.setHorizontalAlignment(2);		
        this.txtcostOfLivingac.setDataType(1);		
        this.txtcostOfLivingac.setSupportedEmpty(true);		
        this.txtcostOfLivingac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtcostOfLivingac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtcostOfLivingac.setPrecision(2);		
        this.txtcostOfLivingac.setRequired(false);
        // txtfundInterestac		
        this.txtfundInterestac.setHorizontalAlignment(2);		
        this.txtfundInterestac.setDataType(1);		
        this.txtfundInterestac.setSupportedEmpty(true);		
        this.txtfundInterestac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfundInterestac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfundInterestac.setPrecision(2);		
        this.txtfundInterestac.setRequired(false);
        // txtothersac		
        this.txtothersac.setHorizontalAlignment(2);		
        this.txtothersac.setDataType(1);		
        this.txtothersac.setSupportedEmpty(true);		
        this.txtothersac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtothersac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtothersac.setPrecision(2);		
        this.txtothersac.setRequired(false);
        // txtloanInterestac		
        this.txtloanInterestac.setHorizontalAlignment(2);		
        this.txtloanInterestac.setDataType(1);		
        this.txtloanInterestac.setSupportedEmpty(true);		
        this.txtloanInterestac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtloanInterestac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtloanInterestac.setPrecision(2);		
        this.txtloanInterestac.setRequired(false);
        // txtfeedsall		
        this.txtfeedsall.setHorizontalAlignment(2);		
        this.txtfeedsall.setDataType(1);		
        this.txtfeedsall.setSupportedEmpty(true);		
        this.txtfeedsall.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfeedsall.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfeedsall.setPrecision(2);		
        this.txtfeedsall.setRequired(false);
        // txtdrugac		
        this.txtdrugac.setHorizontalAlignment(2);		
        this.txtdrugac.setDataType(1);		
        this.txtdrugac.setSupportedEmpty(true);		
        this.txtdrugac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdrugac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdrugac.setPrecision(2);		
        this.txtdrugac.setRequired(false);
        // txteggPayAmt		
        this.txteggPayAmt.setVisible(true);		
        this.txteggPayAmt.setHorizontalAlignment(2);		
        this.txteggPayAmt.setDataType(1);		
        this.txteggPayAmt.setSupportedEmpty(true);		
        this.txteggPayAmt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteggPayAmt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteggPayAmt.setPrecision(2);		
        this.txteggPayAmt.setRequired(false);
        // conthatchEggac		
        this.conthatchEggac.setBoundLabelText(resHelper.getString("conthatchEggac.boundLabelText"));		
        this.conthatchEggac.setBoundLabelLength(150);		
        this.conthatchEggac.setBoundLabelUnderline(true);		
        this.conthatchEggac.setVisible(true);
        // conteliminateac		
        this.conteliminateac.setBoundLabelText(resHelper.getString("conteliminateac.boundLabelText"));		
        this.conteliminateac.setBoundLabelLength(150);		
        this.conteliminateac.setBoundLabelUnderline(true);		
        this.conteliminateac.setVisible(true);
        // contfertilizationac		
        this.contfertilizationac.setBoundLabelText(resHelper.getString("contfertilizationac.boundLabelText"));		
        this.contfertilizationac.setBoundLabelLength(150);		
        this.contfertilizationac.setBoundLabelUnderline(true);		
        this.contfertilizationac.setVisible(true);
        // contdepositInterestac		
        this.contdepositInterestac.setBoundLabelText(resHelper.getString("contdepositInterestac.boundLabelText"));		
        this.contdepositInterestac.setBoundLabelLength(150);		
        this.contdepositInterestac.setBoundLabelUnderline(true);		
        this.contdepositInterestac.setVisible(true);
        // contdepositac		
        this.contdepositac.setBoundLabelText(resHelper.getString("contdepositac.boundLabelText"));		
        this.contdepositac.setBoundLabelLength(150);		
        this.contdepositac.setBoundLabelUnderline(true);		
        this.contdepositac.setVisible(true);
        // txthatchEggac		
        this.txthatchEggac.setHorizontalAlignment(2);		
        this.txthatchEggac.setDataType(1);		
        this.txthatchEggac.setSupportedEmpty(true);		
        this.txthatchEggac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txthatchEggac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txthatchEggac.setPrecision(2);		
        this.txthatchEggac.setRequired(false);
        // txteliminateac		
        this.txteliminateac.setHorizontalAlignment(2);		
        this.txteliminateac.setDataType(1);		
        this.txteliminateac.setSupportedEmpty(true);		
        this.txteliminateac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txteliminateac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txteliminateac.setPrecision(2);		
        this.txteliminateac.setRequired(false);
        // txtfertilizationac		
        this.txtfertilizationac.setHorizontalAlignment(2);		
        this.txtfertilizationac.setDataType(1);		
        this.txtfertilizationac.setSupportedEmpty(true);		
        this.txtfertilizationac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfertilizationac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfertilizationac.setPrecision(2);		
        this.txtfertilizationac.setRequired(false);
        // txtdepositInterestac		
        this.txtdepositInterestac.setHorizontalAlignment(2);		
        this.txtdepositInterestac.setDataType(1);		
        this.txtdepositInterestac.setSupportedEmpty(true);		
        this.txtdepositInterestac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdepositInterestac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdepositInterestac.setPrecision(2);		
        this.txtdepositInterestac.setRequired(false);
        // txtdepositac		
        this.txtdepositac.setHorizontalAlignment(2);		
        this.txtdepositac.setDataType(1);		
        this.txtdepositac.setSupportedEmpty(true);		
        this.txtdepositac.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtdepositac.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtdepositac.setPrecision(2);		
        this.txtdepositac.setRequired(false);
        // prmtFIUnit		
        this.prmtFIUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtFIUnit.setEditable(true);		
        this.prmtFIUnit.setDisplayFormat("$name$");		
        this.prmtFIUnit.setEditFormat("$number$");		
        this.prmtFIUnit.setCommitFormat("$number$");		
        this.prmtFIUnit.setRequired(false);
        // prmtperiods		
        this.prmtperiods.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtperiods.setEditable(true);		
        this.prmtperiods.setDisplayFormat("$number$");		
        this.prmtperiods.setEditFormat("$number$");		
        this.prmtperiods.setCommitFormat("$number$");		
        this.prmtperiods.setRequired(false);
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
					
        // txtbeginningBalance		
        this.txtbeginningBalance.setHorizontalAlignment(2);		
        this.txtbeginningBalance.setDataType(1);		
        this.txtbeginningBalance.setSupportedEmpty(true);		
        this.txtbeginningBalance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbeginningBalance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbeginningBalance.setPrecision(2);		
        this.txtbeginningBalance.setRequired(false);
        // txtclosingBalance		
        this.txtclosingBalance.setHorizontalAlignment(2);		
        this.txtclosingBalance.setDataType(1);		
        this.txtclosingBalance.setSupportedEmpty(true);		
        this.txtclosingBalance.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtclosingBalance.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtclosingBalance.setPrecision(2);		
        this.txtclosingBalance.setRequired(false);
        // txttotalAPAmount		
        this.txttotalAPAmount.setVisible(true);		
        this.txttotalAPAmount.setHorizontalAlignment(2);		
        this.txttotalAPAmount.setDataType(1);		
        this.txttotalAPAmount.setSupportedEmpty(true);		
        this.txttotalAPAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalAPAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalAPAmount.setPrecision(2);		
        this.txttotalAPAmount.setRequired(false);
        // txttotalARAmount		
        this.txttotalARAmount.setVisible(true);		
        this.txttotalARAmount.setHorizontalAlignment(2);		
        this.txttotalARAmount.setDataType(1);		
        this.txttotalARAmount.setSupportedEmpty(true);		
        this.txttotalARAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttotalARAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttotalARAmount.setPrecision(2);		
        this.txttotalARAmount.setRequired(false);
        // pkconfirmTime		
        this.pkconfirmTime.setVisible(true);		
        this.pkconfirmTime.setRequired(false);		
        this.pkconfirmTime.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtdrugac,txtaccessoryac,txtcostOfLivingac,txtfundInterestac,txtothersac,txtloanInterestac,txthatchEggac,txteliminateac,txtfertilizationac,txtdepositInterestac,txtdepositac,txtNumber,txtfeedsall,prmtFIUnit,prmtperiods,prmtfarmer,txtbeginningBalance,txtclosingBalance,kdtFeedsnew,txttotalAPAmount,txttotalARAmount,txteggPayAmt,pkconfirmTime,chkhasConfirm}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        contNumber.setBounds(new Rectangle(672, 30, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(672, 30, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane2.setBounds(new Rectangle(33, 164, 909, 275));
        this.add(kDTabbedPane2, new KDLayout.Constraints(33, 164, 909, 275, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtFeedsnew.setBounds(new Rectangle(33, 459, 909, 129));
        kdtFeedsnew_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtFeedsnew,new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewInfo(),null,false);
        this.add(kdtFeedsnew_detailPanel, new KDLayout.Constraints(33, 459, 909, 129, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contFIUnit.setBounds(new Rectangle(33, 31, 270, 19));
        this.add(contFIUnit, new KDLayout.Constraints(33, 31, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contperiods.setBounds(new Rectangle(352, 28, 270, 19));
        this.add(contperiods, new KDLayout.Constraints(352, 28, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfarmer.setBounds(new Rectangle(33, 70, 270, 19));
        this.add(contfarmer, new KDLayout.Constraints(33, 70, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginningBalance.setBounds(new Rectangle(352, 65, 270, 19));
        this.add(contbeginningBalance, new KDLayout.Constraints(352, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contclosingBalance.setBounds(new Rectangle(672, 65, 270, 19));
        this.add(contclosingBalance, new KDLayout.Constraints(672, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        conttotalAPAmount.setBounds(new Rectangle(352, 101, 270, 19));
        this.add(conttotalAPAmount, new KDLayout.Constraints(352, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conttotalARAmount.setBounds(new Rectangle(33, 101, 270, 19));
        this.add(conttotalARAmount, new KDLayout.Constraints(33, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contconfirmTime.setBounds(new Rectangle(672, 101, 270, 19));
        this.add(contconfirmTime, new KDLayout.Constraints(672, 101, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        chkhasConfirm.setBounds(new Rectangle(33, 135, 270, 19));
        this.add(chkhasConfirm, new KDLayout.Constraints(33, 135, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //kDTabbedPane2
        kDTabbedPane2.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane2.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 908, 242));        contaccessoryac.setBounds(new Rectangle(29, 124, 320, 19));
        kDPanel1.add(contaccessoryac, new KDLayout.Constraints(29, 124, 320, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcostOfLivingac.setBounds(new Rectangle(29, 52, 319, 19));
        kDPanel1.add(contcostOfLivingac, new KDLayout.Constraints(29, 52, 319, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfundInterestac.setBounds(new Rectangle(29, 88, 321, 19));
        kDPanel1.add(contfundInterestac, new KDLayout.Constraints(29, 88, 321, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contothersac.setBounds(new Rectangle(29, 160, 321, 19));
        kDPanel1.add(contothersac, new KDLayout.Constraints(29, 160, 321, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contloanInterestac.setBounds(new Rectangle(29, 196, 322, 19));
        kDPanel1.add(contloanInterestac, new KDLayout.Constraints(29, 196, 322, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfeedsall.setBounds(new Rectangle(29, 235, 322, 19));
        kDPanel1.add(contfeedsall, new KDLayout.Constraints(29, 235, 322, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdrugac.setBounds(new Rectangle(30, 15, 319, 19));
        kDPanel1.add(contdrugac, new KDLayout.Constraints(30, 15, 319, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggPayAmt.setBounds(new Rectangle(488, 15, 319, 19));
        kDPanel1.add(conteggPayAmt, new KDLayout.Constraints(488, 15, 319, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contaccessoryac
        contaccessoryac.setBoundEditor(txtaccessoryac);
        //contcostOfLivingac
        contcostOfLivingac.setBoundEditor(txtcostOfLivingac);
        //contfundInterestac
        contfundInterestac.setBoundEditor(txtfundInterestac);
        //contothersac
        contothersac.setBoundEditor(txtothersac);
        //contloanInterestac
        contloanInterestac.setBoundEditor(txtloanInterestac);
        //contfeedsall
        contfeedsall.setBoundEditor(txtfeedsall);
        //contdrugac
        contdrugac.setBoundEditor(txtdrugac);
        //conteggPayAmt
        conteggPayAmt.setBoundEditor(txteggPayAmt);
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 908, 242));        conthatchEggac.setBounds(new Rectangle(28, 30, 318, 19));
        kDPanel2.add(conthatchEggac, new KDLayout.Constraints(28, 30, 318, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteliminateac.setBounds(new Rectangle(28, 76, 317, 19));
        kDPanel2.add(conteliminateac, new KDLayout.Constraints(28, 76, 317, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contfertilizationac.setBounds(new Rectangle(28, 122, 317, 19));
        kDPanel2.add(contfertilizationac, new KDLayout.Constraints(28, 122, 317, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdepositInterestac.setBounds(new Rectangle(28, 168, 317, 19));
        kDPanel2.add(contdepositInterestac, new KDLayout.Constraints(28, 168, 317, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdepositac.setBounds(new Rectangle(28, 215, 316, 19));
        kDPanel2.add(contdepositac, new KDLayout.Constraints(28, 215, 316, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //conthatchEggac
        conthatchEggac.setBoundEditor(txthatchEggac);
        //conteliminateac
        conteliminateac.setBoundEditor(txteliminateac);
        //contfertilizationac
        contfertilizationac.setBoundEditor(txtfertilizationac);
        //contdepositInterestac
        contdepositInterestac.setBoundEditor(txtdepositInterestac);
        //contdepositac
        contdepositac.setBoundEditor(txtdepositac);
        //contFIUnit
        contFIUnit.setBoundEditor(prmtFIUnit);
        //contperiods
        contperiods.setBoundEditor(prmtperiods);
        //contfarmer
        contfarmer.setBoundEditor(prmtfarmer);
        //contbeginningBalance
        contbeginningBalance.setBoundEditor(txtbeginningBalance);
        //contclosingBalance
        contclosingBalance.setBoundEditor(txtclosingBalance);
        //conttotalAPAmount
        conttotalAPAmount.setBoundEditor(txttotalAPAmount);
        //conttotalARAmount
        conttotalARAmount.setBoundEditor(txttotalARAmount);
        //contconfirmTime
        contconfirmTime.setBoundEditor(pkconfirmTime);

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
		dataBinder.registerBinding("Feedsnew.seq", int.class, this.kdtFeedsnew, "seq.text");
		dataBinder.registerBinding("Feedsnew", com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewInfo.class, this.kdtFeedsnew, "userObject");
		dataBinder.registerBinding("Feedsnew.feedsone", java.lang.Object.class, this.kdtFeedsnew, "feedsone.text");
		dataBinder.registerBinding("Feedsnew.feedName", String.class, this.kdtFeedsnew, "feedName.text");
		dataBinder.registerBinding("Feedsnew.feedQty", java.math.BigDecimal.class, this.kdtFeedsnew, "feedQty.text");
		dataBinder.registerBinding("Feedsnew.feedAC", java.math.BigDecimal.class, this.kdtFeedsnew, "feedAC.text");
		dataBinder.registerBinding("Feedsnew.feedWeight", java.math.BigDecimal.class, this.kdtFeedsnew, "feedWeight.text");
		dataBinder.registerBinding("Feedsnew.packageNumber", java.math.BigDecimal.class, this.kdtFeedsnew, "packageNumber.text");
		dataBinder.registerBinding("hasConfirm", boolean.class, this.chkhasConfirm, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("accessoryac", java.math.BigDecimal.class, this.txtaccessoryac, "value");
		dataBinder.registerBinding("costOfLivingac", java.math.BigDecimal.class, this.txtcostOfLivingac, "value");
		dataBinder.registerBinding("fundInterestac", java.math.BigDecimal.class, this.txtfundInterestac, "value");
		dataBinder.registerBinding("othersac", java.math.BigDecimal.class, this.txtothersac, "value");
		dataBinder.registerBinding("loanInterestac", java.math.BigDecimal.class, this.txtloanInterestac, "value");
		dataBinder.registerBinding("feedsall", java.math.BigDecimal.class, this.txtfeedsall, "value");
		dataBinder.registerBinding("drugac", java.math.BigDecimal.class, this.txtdrugac, "value");
		dataBinder.registerBinding("eggPayAmt", java.math.BigDecimal.class, this.txteggPayAmt, "value");
		dataBinder.registerBinding("hatchEggac", java.math.BigDecimal.class, this.txthatchEggac, "value");
		dataBinder.registerBinding("eliminateac", java.math.BigDecimal.class, this.txteliminateac, "value");
		dataBinder.registerBinding("fertilizationac", java.math.BigDecimal.class, this.txtfertilizationac, "value");
		dataBinder.registerBinding("depositInterestac", java.math.BigDecimal.class, this.txtdepositInterestac, "value");
		dataBinder.registerBinding("depositac", java.math.BigDecimal.class, this.txtdepositac, "value");
		dataBinder.registerBinding("FIUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtFIUnit, "data");
		dataBinder.registerBinding("periods", com.kingdee.eas.basedata.assistant.PeriodInfo.class, this.prmtperiods, "data");
		dataBinder.registerBinding("farmer", com.kingdee.eas.farm.stocking.basedata.FarmersInfo.class, this.prmtfarmer, "data");
		dataBinder.registerBinding("beginningBalance", java.math.BigDecimal.class, this.txtbeginningBalance, "value");
		dataBinder.registerBinding("closingBalance", java.math.BigDecimal.class, this.txtclosingBalance, "value");
		dataBinder.registerBinding("totalAPAmount", java.math.BigDecimal.class, this.txttotalAPAmount, "value");
		dataBinder.registerBinding("totalARAmount", java.math.BigDecimal.class, this.txttotalARAmount, "value");
		dataBinder.registerBinding("confirmTime", java.util.Date.class, this.pkconfirmTime, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.farm.stocking.processbizill.app.StatementOfAccountEditUIHandler";
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
        this.txtdrugac.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo)ov;
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
	 * ????????§µ??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("Feedsnew.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.feedsone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.feedName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.feedQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.feedAC", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.feedWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Feedsnew.packageNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hasConfirm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accessoryac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costOfLivingac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fundInterestac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("othersac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("loanInterestac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("feedsall", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("drugac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggPayAmt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("hatchEggac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eliminateac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fertilizationac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("depositInterestac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("depositac", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FIUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("periods", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginningBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("closingBalance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalAPAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("totalARAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("confirmTime", ValidateHelper.ON_SAVE);    		
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
     * output txtNumber_actionPerformed method
     */
    protected void txtNumber_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output kdtFeedsnew_Changed(int rowIndex,int colIndex) method
     */
    public void kdtFeedsnew_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("feedsone".equalsIgnoreCase(kdtFeedsnew.getColumn(colIndex).getKey())) {
kdtFeedsnew.getCell(rowIndex,"feedName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtFeedsnew.getCell(rowIndex,"feedsone").getValue(),"name")));

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
    	sic.add(new SelectorItemInfo("Feedsnew.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Feedsnew.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Feedsnew.feedsone.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Feedsnew.feedsone.id"));
			sic.add(new SelectorItemInfo("Feedsnew.feedsone.number"));
			sic.add(new SelectorItemInfo("Feedsnew.feedsone.name"));
		}
    	sic.add(new SelectorItemInfo("Feedsnew.feedName"));
    	sic.add(new SelectorItemInfo("Feedsnew.feedQty"));
    	sic.add(new SelectorItemInfo("Feedsnew.feedAC"));
    	sic.add(new SelectorItemInfo("Feedsnew.feedWeight"));
    	sic.add(new SelectorItemInfo("Feedsnew.packageNumber"));
        sic.add(new SelectorItemInfo("hasConfirm"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("accessoryac"));
        sic.add(new SelectorItemInfo("costOfLivingac"));
        sic.add(new SelectorItemInfo("fundInterestac"));
        sic.add(new SelectorItemInfo("othersac"));
        sic.add(new SelectorItemInfo("loanInterestac"));
        sic.add(new SelectorItemInfo("feedsall"));
        sic.add(new SelectorItemInfo("drugac"));
        sic.add(new SelectorItemInfo("eggPayAmt"));
        sic.add(new SelectorItemInfo("hatchEggac"));
        sic.add(new SelectorItemInfo("eliminateac"));
        sic.add(new SelectorItemInfo("fertilizationac"));
        sic.add(new SelectorItemInfo("depositInterestac"));
        sic.add(new SelectorItemInfo("depositac"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("FIUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("FIUnit.id"));
        	sic.add(new SelectorItemInfo("FIUnit.number"));
        	sic.add(new SelectorItemInfo("FIUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("periods.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("periods.id"));
        	sic.add(new SelectorItemInfo("periods.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmer.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmer.id"));
        	sic.add(new SelectorItemInfo("farmer.number"));
        	sic.add(new SelectorItemInfo("farmer.name"));
		}
        sic.add(new SelectorItemInfo("beginningBalance"));
        sic.add(new SelectorItemInfo("closingBalance"));
        sic.add(new SelectorItemInfo("totalAPAmount"));
        sic.add(new SelectorItemInfo("totalARAmount"));
        sic.add(new SelectorItemInfo("confirmTime"));
        return sic;
    }        
    	

    /**
     * output actionSubmit_actionPerformed method
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }
    	

    /**
     * output actionPrint_actionPerformed method
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
    	if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.print(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
    	

    /**
     * output actionPrintPreview_actionPerformed method
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        ArrayList idList = new ArrayList();
        if (editData != null && !StringUtils.isEmpty(editData.getString("id"))) {
    		idList.add(editData.getString("id"));
    	}
        if (idList == null || idList.size() == 0 || getTDQueryPK() == null || getTDFileName() == null)
            return;
        com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate data = new com.kingdee.eas.framework.util.CommonDataProvider(idList,getTDQueryPK());
        com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper appHlp = new com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper();
        appHlp.printPreview(getTDFileName(), data, javax.swing.SwingUtilities.getWindowAncestor(this));
    }
	public RequestContext prepareActionSubmit(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionSubmit(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionSubmit() {
    	return false;
    }
	public RequestContext prepareActionPrint(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrint(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrint() {
    	return false;
    }
	public RequestContext prepareActionPrintPreview(IItemAction itemAction) throws Exception {
			RequestContext request = super.prepareActionPrintPreview(itemAction);		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionPrintPreview() {
    	return false;
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.client", "StatementOfAccountEditUI");
    }
    /**
     * output isBindWorkFlow method
     */
    public boolean isBindWorkFlow()
    {
        return true;
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.processbizill.client.StatementOfAccountEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/farm/stocking/processbizill/StatementOfAccount";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app.StatementOfAccountQuery");
	}
    

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtFeedsnew;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}