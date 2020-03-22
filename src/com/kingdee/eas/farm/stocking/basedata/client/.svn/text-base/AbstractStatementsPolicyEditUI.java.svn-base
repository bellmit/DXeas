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
public abstract class AbstractStatementsPolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractStatementsPolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisTemplate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contavgFemaleFee;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPriceEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPriceEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRecycleEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRecycleEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSubsidyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSubsidyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtAwardsEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtAwardsEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdepositRate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprovisionType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtdepositRate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox provisionType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtavgFemaleFee;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo editData = null;
    protected ActionIsTemplate actionIsTemplate = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractStatementsPolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractStatementsPolicyEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionIsTemplate
        this.actionIsTemplate = new ActionIsTemplate(this);
        getActionManager().registerAction("actionIsTemplate", actionIsTemplate);
        this.actionIsTemplate.setExtendProperty("canForewarn", "true");
        this.actionIsTemplate.setExtendProperty("userDefined", "false");
        this.actionIsTemplate.setExtendProperty("isObjectUpdateLock", "false");
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionIsTemplate.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
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
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.chkisTemplate = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contavgFemaleFee = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtPriceEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRecycleEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSubsidyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtAwardsEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contdepositRate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprovisionType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtdepositRate = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.provisionType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtavgFemaleFee = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbaseStatus.setName("contbaseStatus");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator5.setName("kDSeparator5");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.contcompany.setName("contcompany");
        this.kDSeparator6.setName("kDSeparator6");
        this.chkisTemplate.setName("chkisTemplate");
        this.contbreedData.setName("contbreedData");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.contavgFemaleFee.setName("contavgFemaleFee");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtPriceEntry.setName("kdtPriceEntry");
        this.kdtRecycleEntry.setName("kdtRecycleEntry");
        this.kdtSubsidyEntry.setName("kdtSubsidyEntry");
        this.kdtAwardsEntry.setName("kdtAwardsEntry");
        this.contdepositRate.setName("contdepositRate");
        this.contprovisionType.setName("contprovisionType");
        this.txtdepositRate.setName("txtdepositRate");
        this.provisionType.setName("provisionType");
        this.baseStatus.setName("baseStatus");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtcompany.setName("prmtcompany");
        this.prmtbreedData.setName("prmtbreedData");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtavgFemaleFee.setName("txtavgFemaleFee");
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
        // kDTabbedPane1
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // kDSeparator6
        // chkisTemplate		
        this.chkisTemplate.setText(resHelper.getString("chkisTemplate.text"));		
        this.chkisTemplate.setHorizontalAlignment(2);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contbeginDate		
        this.contbeginDate.setBoundLabelText(resHelper.getString("contbeginDate.boundLabelText"));		
        this.contbeginDate.setBoundLabelLength(100);		
        this.contbeginDate.setBoundLabelUnderline(true);		
        this.contbeginDate.setVisible(true);
        // contendDate		
        this.contendDate.setBoundLabelText(resHelper.getString("contendDate.boundLabelText"));		
        this.contendDate.setBoundLabelLength(100);		
        this.contendDate.setBoundLabelUnderline(true);		
        this.contendDate.setVisible(true);
        // contavgFemaleFee		
        this.contavgFemaleFee.setBoundLabelText(resHelper.getString("contavgFemaleFee.boundLabelText"));		
        this.contavgFemaleFee.setBoundLabelLength(100);		
        this.contavgFemaleFee.setBoundLabelUnderline(true);		
        this.contavgFemaleFee.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kDPanel4
        // kdtPriceEntry
		String kdtPriceEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPriceEntry.setFormatXml(resHelper.translateString("kdtPriceEntry",kdtPriceEntryStrXML));
        kdtPriceEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPriceEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPriceEntry.putBindContents("editData",new String[] {"seq","settlementItem","material","materialName","model","unit","basePrice"});


        this.kdtPriceEntry.checkParsed();
        final KDBizPromptBox kdtPriceEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtPriceEntry_settlementItem_PromptBox.setVisible(true);
        kdtPriceEntry_settlementItem_PromptBox.setEditable(true);
        kdtPriceEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settlementItem_PromptBox);
        this.kdtPriceEntry.getColumn("settlementItem").setEditor(kdtPriceEntry_settlementItem_CellEditor);
        ObjectValueRender kdtPriceEntry_settlementItem_OVR = new ObjectValueRender();
        kdtPriceEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("settlementItem").setRenderer(kdtPriceEntry_settlementItem_OVR);
        			kdtPriceEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtPriceEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPriceEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtPriceEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPriceEntry_settlementItem_PromptBox_F7ListUI));
					kdtPriceEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPriceEntry_settlementItem_PromptBox.setSelector(kdtPriceEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtPriceEntry_material_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtPriceEntry_material_PromptBox.setVisible(true);
        kdtPriceEntry_material_PromptBox.setEditable(true);
        kdtPriceEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_material_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_material_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_material_PromptBox);
        this.kdtPriceEntry.getColumn("material").setEditor(kdtPriceEntry_material_CellEditor);
        ObjectValueRender kdtPriceEntry_material_OVR = new ObjectValueRender();
        kdtPriceEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtPriceEntry.getColumn("material").setRenderer(kdtPriceEntry_material_OVR);
        KDTextField kdtPriceEntry_materialName_TextField = new KDTextField();
        kdtPriceEntry_materialName_TextField.setName("kdtPriceEntry_materialName_TextField");
        kdtPriceEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_materialName_TextField);
        this.kdtPriceEntry.getColumn("materialName").setEditor(kdtPriceEntry_materialName_CellEditor);
        KDTextField kdtPriceEntry_model_TextField = new KDTextField();
        kdtPriceEntry_model_TextField.setName("kdtPriceEntry_model_TextField");
        kdtPriceEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtPriceEntry_model_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_model_TextField);
        this.kdtPriceEntry.getColumn("model").setEditor(kdtPriceEntry_model_CellEditor);
        final KDBizPromptBox kdtPriceEntry_unit_PromptBox = new KDBizPromptBox();
        kdtPriceEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtPriceEntry_unit_PromptBox.setVisible(true);
        kdtPriceEntry_unit_PromptBox.setEditable(true);
        kdtPriceEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setEditFormat("$number$");
        kdtPriceEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPriceEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_unit_PromptBox);
        this.kdtPriceEntry.getColumn("unit").setEditor(kdtPriceEntry_unit_CellEditor);
        ObjectValueRender kdtPriceEntry_unit_OVR = new ObjectValueRender();
        kdtPriceEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPriceEntry.getColumn("unit").setRenderer(kdtPriceEntry_unit_OVR);
        KDFormattedTextField kdtPriceEntry_basePrice_TextField = new KDFormattedTextField();
        kdtPriceEntry_basePrice_TextField.setName("kdtPriceEntry_basePrice_TextField");
        kdtPriceEntry_basePrice_TextField.setVisible(true);
        kdtPriceEntry_basePrice_TextField.setEditable(true);
        kdtPriceEntry_basePrice_TextField.setHorizontalAlignment(2);
        kdtPriceEntry_basePrice_TextField.setDataType(1);
        	kdtPriceEntry_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPriceEntry_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPriceEntry_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPriceEntry_basePrice_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_basePrice_TextField);
        this.kdtPriceEntry.getColumn("basePrice").setEditor(kdtPriceEntry_basePrice_CellEditor);
        // kdtRecycleEntry
		String kdtRecycleEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settlementItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"basePrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settlementItem}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{basePrice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRecycleEntry.setFormatXml(resHelper.translateString("kdtRecycleEntry",kdtRecycleEntryStrXML));
        kdtRecycleEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtRecycleEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtRecycleEntry.putBindContents("editData",new String[] {"seq","settlementItem","material","materialName","model","unit","basePrice"});


        this.kdtRecycleEntry.checkParsed();
        final KDBizPromptBox kdtRecycleEntry_settlementItem_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtRecycleEntry_settlementItem_PromptBox.setVisible(true);
        kdtRecycleEntry_settlementItem_PromptBox.setEditable(true);
        kdtRecycleEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_settlementItem_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_settlementItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_settlementItem_PromptBox);
        this.kdtRecycleEntry.getColumn("settlementItem").setEditor(kdtRecycleEntry_settlementItem_CellEditor);
        ObjectValueRender kdtRecycleEntry_settlementItem_OVR = new ObjectValueRender();
        kdtRecycleEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecycleEntry.getColumn("settlementItem").setRenderer(kdtRecycleEntry_settlementItem_OVR);
        			kdtRecycleEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtRecycleEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtRecycleEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtRecycleEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtRecycleEntry_settlementItem_PromptBox_F7ListUI));
					kdtRecycleEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtRecycleEntry_settlementItem_PromptBox.setSelector(kdtRecycleEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtRecycleEntry_material_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtRecycleEntry_material_PromptBox.setVisible(true);
        kdtRecycleEntry_material_PromptBox.setEditable(true);
        kdtRecycleEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_material_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_material_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_material_PromptBox);
        this.kdtRecycleEntry.getColumn("material").setEditor(kdtRecycleEntry_material_CellEditor);
        ObjectValueRender kdtRecycleEntry_material_OVR = new ObjectValueRender();
        kdtRecycleEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtRecycleEntry.getColumn("material").setRenderer(kdtRecycleEntry_material_OVR);
        KDTextField kdtRecycleEntry_materialName_TextField = new KDTextField();
        kdtRecycleEntry_materialName_TextField.setName("kdtRecycleEntry_materialName_TextField");
        kdtRecycleEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtRecycleEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_materialName_TextField);
        this.kdtRecycleEntry.getColumn("materialName").setEditor(kdtRecycleEntry_materialName_CellEditor);
        KDTextField kdtRecycleEntry_model_TextField = new KDTextField();
        kdtRecycleEntry_model_TextField.setName("kdtRecycleEntry_model_TextField");
        kdtRecycleEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtRecycleEntry_model_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_model_TextField);
        this.kdtRecycleEntry.getColumn("model").setEditor(kdtRecycleEntry_model_CellEditor);
        final KDBizPromptBox kdtRecycleEntry_unit_PromptBox = new KDBizPromptBox();
        kdtRecycleEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtRecycleEntry_unit_PromptBox.setVisible(true);
        kdtRecycleEntry_unit_PromptBox.setEditable(true);
        kdtRecycleEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtRecycleEntry_unit_PromptBox.setEditFormat("$number$");
        kdtRecycleEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRecycleEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_unit_PromptBox);
        this.kdtRecycleEntry.getColumn("unit").setEditor(kdtRecycleEntry_unit_CellEditor);
        ObjectValueRender kdtRecycleEntry_unit_OVR = new ObjectValueRender();
        kdtRecycleEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRecycleEntry.getColumn("unit").setRenderer(kdtRecycleEntry_unit_OVR);
        KDFormattedTextField kdtRecycleEntry_basePrice_TextField = new KDFormattedTextField();
        kdtRecycleEntry_basePrice_TextField.setName("kdtRecycleEntry_basePrice_TextField");
        kdtRecycleEntry_basePrice_TextField.setVisible(true);
        kdtRecycleEntry_basePrice_TextField.setEditable(true);
        kdtRecycleEntry_basePrice_TextField.setHorizontalAlignment(2);
        kdtRecycleEntry_basePrice_TextField.setDataType(1);
        	kdtRecycleEntry_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtRecycleEntry_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtRecycleEntry_basePrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtRecycleEntry_basePrice_CellEditor = new KDTDefaultCellEditor(kdtRecycleEntry_basePrice_TextField);
        this.kdtRecycleEntry.getColumn("basePrice").setEditor(kdtRecycleEntry_basePrice_CellEditor);
        // kdtSubsidyEntry
		String kdtSubsidyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"policy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"policyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{policy}</t:Cell><t:Cell>$Resource{policyName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSubsidyEntry.setFormatXml(resHelper.translateString("kdtSubsidyEntry",kdtSubsidyEntryStrXML));
        kdtSubsidyEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtSubsidyEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtSubsidyEntry.putBindContents("editData",new String[] {"seq","policy","policyName"});


        this.kdtSubsidyEntry.checkParsed();
        final KDBizPromptBox kdtSubsidyEntry_policy_PromptBox = new KDBizPromptBox();
        kdtSubsidyEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SubsidyQuery");
        kdtSubsidyEntry_policy_PromptBox.setVisible(true);
        kdtSubsidyEntry_policy_PromptBox.setEditable(true);
        kdtSubsidyEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setEditFormat("$number$");
        kdtSubsidyEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSubsidyEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtSubsidyEntry_policy_PromptBox);
        this.kdtSubsidyEntry.getColumn("policy").setEditor(kdtSubsidyEntry_policy_CellEditor);
        ObjectValueRender kdtSubsidyEntry_policy_OVR = new ObjectValueRender();
        kdtSubsidyEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSubsidyEntry.getColumn("policy").setRenderer(kdtSubsidyEntry_policy_OVR);
        			kdtSubsidyEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SubsidyListUI kdtSubsidyEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSubsidyEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtSubsidyEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SubsidyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSubsidyEntry_policy_PromptBox_F7ListUI));
					kdtSubsidyEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSubsidyEntry_policy_PromptBox.setSelector(kdtSubsidyEntry_policy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtSubsidyEntry_policyName_TextField = new KDTextField();
        kdtSubsidyEntry_policyName_TextField.setName("kdtSubsidyEntry_policyName_TextField");
        kdtSubsidyEntry_policyName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtSubsidyEntry_policyName_CellEditor = new KDTDefaultCellEditor(kdtSubsidyEntry_policyName_TextField);
        this.kdtSubsidyEntry.getColumn("policyName").setEditor(kdtSubsidyEntry_policyName_CellEditor);
        // kdtAwardsEntry
		String kdtAwardsEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"policy\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"policyName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{policy}</t:Cell><t:Cell>$Resource{policyName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtAwardsEntry.setFormatXml(resHelper.translateString("kdtAwardsEntry",kdtAwardsEntryStrXML));
        kdtAwardsEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtAwardsEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtAwardsEntry.putBindContents("editData",new String[] {"seq","policy","policyName"});


        this.kdtAwardsEntry.checkParsed();
        final KDBizPromptBox kdtAwardsEntry_policy_PromptBox = new KDBizPromptBox();
        kdtAwardsEntry_policy_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.RewardsPolicyQuery");
        kdtAwardsEntry_policy_PromptBox.setVisible(true);
        kdtAwardsEntry_policy_PromptBox.setEditable(true);
        kdtAwardsEntry_policy_PromptBox.setDisplayFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setEditFormat("$number$");
        kdtAwardsEntry_policy_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtAwardsEntry_policy_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_policy_PromptBox);
        this.kdtAwardsEntry.getColumn("policy").setEditor(kdtAwardsEntry_policy_CellEditor);
        ObjectValueRender kdtAwardsEntry_policy_OVR = new ObjectValueRender();
        kdtAwardsEntry_policy_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtAwardsEntry.getColumn("policy").setRenderer(kdtAwardsEntry_policy_OVR);
        			kdtAwardsEntry_policy_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI kdtAwardsEntry_policy_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtAwardsEntry_policy_PromptBox_F7ListUI == null) {
					try {
						kdtAwardsEntry_policy_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.RewardsPolicyListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtAwardsEntry_policy_PromptBox_F7ListUI));
					kdtAwardsEntry_policy_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtAwardsEntry_policy_PromptBox.setSelector(kdtAwardsEntry_policy_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtAwardsEntry_policyName_TextField = new KDTextField();
        kdtAwardsEntry_policyName_TextField.setName("kdtAwardsEntry_policyName_TextField");
        kdtAwardsEntry_policyName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtAwardsEntry_policyName_CellEditor = new KDTDefaultCellEditor(kdtAwardsEntry_policyName_TextField);
        this.kdtAwardsEntry.getColumn("policyName").setEditor(kdtAwardsEntry_policyName_CellEditor);
        // contdepositRate		
        this.contdepositRate.setBoundLabelText(resHelper.getString("contdepositRate.boundLabelText"));		
        this.contdepositRate.setBoundLabelLength(100);		
        this.contdepositRate.setBoundLabelUnderline(true);		
        this.contdepositRate.setVisible(true);
        // contprovisionType		
        this.contprovisionType.setBoundLabelText(resHelper.getString("contprovisionType.boundLabelText"));		
        this.contprovisionType.setBoundLabelLength(100);		
        this.contprovisionType.setBoundLabelUnderline(true);		
        this.contprovisionType.setVisible(true);
        // txtdepositRate		
        this.txtdepositRate.setHorizontalAlignment(2);		
        this.txtdepositRate.setDataType(1);		
        this.txtdepositRate.setSupportedEmpty(true);		
        this.txtdepositRate.setMinimumValue( new java.math.BigDecimal("-999999.9999"));		
        this.txtdepositRate.setMaximumValue( new java.math.BigDecimal("999999.9999"));		
        this.txtdepositRate.setPrecision(4);		
        this.txtdepositRate.setRequired(false);
        // provisionType		
        this.provisionType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum").toArray());		
        this.provisionType.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
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
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
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
					
        // pkbeginDate		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(true);
        // txtavgFemaleFee		
        this.txtavgFemaleFee.setHorizontalAlignment(2);		
        this.txtavgFemaleFee.setDataType(1);		
        this.txtavgFemaleFee.setSupportedEmpty(true);		
        this.txtavgFemaleFee.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtavgFemaleFee.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtavgFemaleFee.setPrecision(2);		
        this.txtavgFemaleFee.setRequired(true);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,baseStatus,prmtauditor,pkauditTime,prmtcompany,chkisTemplate,prmtbreedData,pkbeginDate,pkendDate,txtavgFemaleFee,txtdepositRate,provisionType,kdtRecycleEntry,kdtPriceEntry,kdtSubsidyEntry,kdtAwardsEntry}));
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
        kDLabelContainer1.setBounds(new Rectangle(38, 15, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(38, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(367, 15, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(367, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(907, 169, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(907, 169, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(906, 210, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(906, 210, 270, 19, 0));
        kDTabbedPane1.setBounds(new Rectangle(20, 132, 970, 396));
        this.add(kDTabbedPane1, new KDLayout.Constraints(20, 132, 970, 396, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbaseStatus.setBounds(new Rectangle(696, 15, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(696, 15, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(38, 556, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(38, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(38, 591, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(38, 591, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator5.setBounds(new Rectangle(16, 538, 984, 8));
        this.add(kDSeparator5, new KDLayout.Constraints(16, 538, 984, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcreator.setBounds(new Rectangle(368, 557, 270, 19));
        this.add(contcreator, new KDLayout.Constraints(368, 557, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcreateTime.setBounds(new Rectangle(706, 556, 270, 19));
        this.add(contcreateTime, new KDLayout.Constraints(706, 556, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(38, 46, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(38, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator6.setBounds(new Rectangle(19, 118, 969, 10));
        this.add(kDSeparator6, new KDLayout.Constraints(19, 118, 969, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        chkisTemplate.setBounds(new Rectangle(696, 82, 270, 19));
        this.add(chkisTemplate, new KDLayout.Constraints(696, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(367, 46, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(367, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbeginDate.setBounds(new Rectangle(38, 82, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(38, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(367, 82, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(367, 82, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contavgFemaleFee.setBounds(new Rectangle(696, 46, 270, 19));
        this.add(contavgFemaleFee, new KDLayout.Constraints(696, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 363));        kdtPriceEntry.setBounds(new Rectangle(5, 6, 957, 361));
        kdtPriceEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPriceEntry,new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyPriceEntryInfo(),null,false);
        kDPanel1.add(kdtPriceEntry_detailPanel, new KDLayout.Constraints(5, 6, 957, 361, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 363));        kdtRecycleEntry.setBounds(new Rectangle(5, 4, 956, 360));
        kdtRecycleEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRecycleEntry,new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryInfo(),null,false);
        kDPanel2.add(kdtRecycleEntry_detailPanel, new KDLayout.Constraints(5, 4, 956, 360, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 363));        kdtSubsidyEntry.setBounds(new Rectangle(495, 3, 466, 358));
        kdtSubsidyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSubsidyEntry,new com.kingdee.eas.farm.stocking.basedata.StatementsPolicySubsidyEntryInfo(),null,false);
        kDPanel3.add(kdtSubsidyEntry_detailPanel, new KDLayout.Constraints(495, 3, 466, 358, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtAwardsEntry.setBounds(new Rectangle(0, 2, 491, 360));
        kdtAwardsEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtAwardsEntry,new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyAwardsEntryInfo(),null,false);
        kDPanel3.add(kdtAwardsEntry_detailPanel, new KDLayout.Constraints(0, 2, 491, 360, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 969, 363));        contdepositRate.setBounds(new Rectangle(16, 26, 270, 19));
        kDPanel4.add(contdepositRate, new KDLayout.Constraints(16, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprovisionType.setBounds(new Rectangle(329, 26, 270, 19));
        kDPanel4.add(contprovisionType, new KDLayout.Constraints(329, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contdepositRate
        contdepositRate.setBoundEditor(txtdepositRate);
        //contprovisionType
        contprovisionType.setBoundEditor(provisionType);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contcreator
        contcreator.setBoundEditor(prmtcreator);
        //contcreateTime
        contcreateTime.setBoundEditor(pkcreateTime);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //contavgFemaleFee
        contavgFemaleFee.setBoundEditor(txtavgFemaleFee);

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
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("isTemplate", boolean.class, this.chkisTemplate, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("PriceEntry.seq", int.class, this.kdtPriceEntry, "seq.text");
		dataBinder.registerBinding("PriceEntry", com.kingdee.eas.farm.stocking.basedata.StatementsPolicyPriceEntryInfo.class, this.kdtPriceEntry, "userObject");
		dataBinder.registerBinding("PriceEntry.material", java.lang.Object.class, this.kdtPriceEntry, "material.text");
		dataBinder.registerBinding("PriceEntry.materialName", String.class, this.kdtPriceEntry, "materialName.text");
		dataBinder.registerBinding("PriceEntry.model", String.class, this.kdtPriceEntry, "model.text");
		dataBinder.registerBinding("PriceEntry.basePrice", java.math.BigDecimal.class, this.kdtPriceEntry, "basePrice.text");
		dataBinder.registerBinding("PriceEntry.settlementItem", java.lang.Object.class, this.kdtPriceEntry, "settlementItem.text");
		dataBinder.registerBinding("PriceEntry.unit", java.lang.Object.class, this.kdtPriceEntry, "unit.text");
		dataBinder.registerBinding("RecycleEntry.seq", int.class, this.kdtRecycleEntry, "seq.text");
		dataBinder.registerBinding("RecycleEntry", com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryInfo.class, this.kdtRecycleEntry, "userObject");
		dataBinder.registerBinding("RecycleEntry.material", java.lang.Object.class, this.kdtRecycleEntry, "material.text");
		dataBinder.registerBinding("RecycleEntry.materialName", String.class, this.kdtRecycleEntry, "materialName.text");
		dataBinder.registerBinding("RecycleEntry.model", String.class, this.kdtRecycleEntry, "model.text");
		dataBinder.registerBinding("RecycleEntry.basePrice", java.math.BigDecimal.class, this.kdtRecycleEntry, "basePrice.text");
		dataBinder.registerBinding("RecycleEntry.settlementItem", java.lang.Object.class, this.kdtRecycleEntry, "settlementItem.text");
		dataBinder.registerBinding("RecycleEntry.unit", java.lang.Object.class, this.kdtRecycleEntry, "unit.text");
		dataBinder.registerBinding("SubsidyEntry.seq", int.class, this.kdtSubsidyEntry, "seq.text");
		dataBinder.registerBinding("SubsidyEntry", com.kingdee.eas.farm.stocking.basedata.StatementsPolicySubsidyEntryInfo.class, this.kdtSubsidyEntry, "userObject");
		dataBinder.registerBinding("SubsidyEntry.policy", java.lang.Object.class, this.kdtSubsidyEntry, "policy.text");
		dataBinder.registerBinding("SubsidyEntry.policyName", String.class, this.kdtSubsidyEntry, "policyName.text");
		dataBinder.registerBinding("AwardsEntry.seq", int.class, this.kdtAwardsEntry, "seq.text");
		dataBinder.registerBinding("AwardsEntry", com.kingdee.eas.farm.stocking.basedata.StatementsPolicyAwardsEntryInfo.class, this.kdtAwardsEntry, "userObject");
		dataBinder.registerBinding("AwardsEntry.policy", java.lang.Object.class, this.kdtAwardsEntry, "policy.text");
		dataBinder.registerBinding("AwardsEntry.policyName", String.class, this.kdtAwardsEntry, "policyName.text");
		dataBinder.registerBinding("depositRate", java.math.BigDecimal.class, this.txtdepositRate, "value");
		dataBinder.registerBinding("provisionType", com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum.class, this.provisionType, "selectedItem");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("avgFemaleFee", java.math.BigDecimal.class, this.txtavgFemaleFee, "value");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.StatementsPolicyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("isTemplate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PriceEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.basePrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.settlementItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RecycleEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SubsidyEntry.policyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.policy", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("AwardsEntry.policyName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("depositRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("provisionType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("avgFemaleFee", ValidateHelper.ON_SAVE);    		
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
     * output kdtPriceEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPriceEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("settlementItem".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"settlementItem").getValue(),"settleUnit"));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtPriceEntry.getColumn(colIndex).getKey())) {
kdtPriceEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPriceEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

}


    }

    /**
     * output kdtRecycleEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtRecycleEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("settlementItem".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"settlementItem").getValue(),"settleUnit"));

}

    if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtRecycleEntry.getColumn(colIndex).getKey())) {
kdtRecycleEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtRecycleEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

}


    }

    /**
     * output kdtSubsidyEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtSubsidyEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("policy".equalsIgnoreCase(kdtSubsidyEntry.getColumn(colIndex).getKey())) {
kdtSubsidyEntry.getCell(rowIndex,"policyName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtSubsidyEntry.getCell(rowIndex,"policy").getValue(),"name")));

}


    }

    /**
     * output kdtAwardsEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtAwardsEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("policy".equalsIgnoreCase(kdtAwardsEntry.getColumn(colIndex).getKey())) {
kdtAwardsEntry.getCell(rowIndex,"policyName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtAwardsEntry.getCell(rowIndex,"policy").getValue(),"name")));

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
        sic.add(new SelectorItemInfo("isTemplate"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
    	sic.add(new SelectorItemInfo("PriceEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.material.id"));
			sic.add(new SelectorItemInfo("PriceEntry.material.number"));
			sic.add(new SelectorItemInfo("PriceEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("PriceEntry.materialName"));
    	sic.add(new SelectorItemInfo("PriceEntry.model"));
    	sic.add(new SelectorItemInfo("PriceEntry.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.settlementItem.id"));
			sic.add(new SelectorItemInfo("PriceEntry.settlementItem.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.settlementItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PriceEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PriceEntry.unit.id"));
			sic.add(new SelectorItemInfo("PriceEntry.unit.name"));
        	sic.add(new SelectorItemInfo("PriceEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("RecycleEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.material.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.material.number"));
			sic.add(new SelectorItemInfo("RecycleEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("RecycleEntry.materialName"));
    	sic.add(new SelectorItemInfo("RecycleEntry.model"));
    	sic.add(new SelectorItemInfo("RecycleEntry.basePrice"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.name"));
        	sic.add(new SelectorItemInfo("RecycleEntry.settlementItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RecycleEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RecycleEntry.unit.id"));
			sic.add(new SelectorItemInfo("RecycleEntry.unit.name"));
        	sic.add(new SelectorItemInfo("RecycleEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("SubsidyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SubsidyEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SubsidyEntry.policy.id"));
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.number"));
			sic.add(new SelectorItemInfo("SubsidyEntry.policy.name"));
		}
    	sic.add(new SelectorItemInfo("SubsidyEntry.policyName"));
    	sic.add(new SelectorItemInfo("AwardsEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardsEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("AwardsEntry.policy.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("AwardsEntry.policy.id"));
			sic.add(new SelectorItemInfo("AwardsEntry.policy.number"));
			sic.add(new SelectorItemInfo("AwardsEntry.policy.name"));
		}
    	sic.add(new SelectorItemInfo("AwardsEntry.policyName"));
        sic.add(new SelectorItemInfo("depositRate"));
        sic.add(new SelectorItemInfo("provisionType"));
        sic.add(new SelectorItemInfo("baseStatus"));
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
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("avgFemaleFee"));
        return sic;
    }        
    	

    /**
     * output actionIsTemplate_actionPerformed method
     */
    public void actionIsTemplate_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory.getRemoteInstance().isTemplate(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionIsTemplate(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionIsTemplate() {
    	return false;
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
     * output ActionIsTemplate class
     */     
    protected class ActionIsTemplate extends ItemAction {     
    
        public ActionIsTemplate()
        {
            this(null);
        }

        public ActionIsTemplate(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionIsTemplate.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionIsTemplate.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractStatementsPolicyEditUI.this, "ActionIsTemplate", "actionIsTemplate_actionPerformed", e);
        }
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
            innerActionPerformed("eas", AbstractStatementsPolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractStatementsPolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "StatementsPolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.StatementsPolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"settlementItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算项目"});
			}
		}
		for (int i=0,n=kdtPriceEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPriceEntry.getCell(i,"basePrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"基础价格"});
			}
		}
		for (int i=0,n=kdtRecycleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtRecycleEntry.getCell(i,"settlementItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算项目"});
			}
		}
		for (int i=0,n=kdtRecycleEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtRecycleEntry.getCell(i,"basePrice").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"基础回收价格"});
			}
		}
		for (int i=0,n=kdtSubsidyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSubsidyEntry.getCell(i,"policy").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"政策编码"});
			}
		}
		for (int i=0,n=kdtAwardsEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtAwardsEntry.getCell(i,"policy").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"政策编码"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkendDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效日期"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtavgFemaleFee.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"母鸭生活费(只)"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPriceEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("provisionType",new Integer(1));
vo.put("baseStatus",new Integer(1));
		vo.put("avgFemaleFee",new java.math.BigDecimal(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}