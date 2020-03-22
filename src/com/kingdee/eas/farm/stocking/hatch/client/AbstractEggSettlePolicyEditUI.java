/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

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
public abstract class AbstractEggSettlePolicyEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEggSettlePolicyEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreator;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcreateTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator6;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contendDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continsteadPrice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggSettleType;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkcreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPolicyEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtPolicyEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSaleEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSaleEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtRangeEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtRangeEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkendDate;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinsteadPrice;
    protected com.kingdee.bos.ctrl.swing.KDComboBox eggSettleType;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractEggSettlePolicyEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEggSettlePolicyEditUI.class.getName());
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
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator5 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.contcreator = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcreateTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator6 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contbeginDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contendDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continsteadPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggSettleType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkcreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtPolicyEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtSaleEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtRangeEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.pkbeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkendDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtinsteadPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.eggSettleType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contbaseStatus.setName("contbaseStatus");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDSeparator5.setName("kDSeparator5");
        this.contcreator.setName("contcreator");
        this.contcreateTime.setName("contcreateTime");
        this.contcompany.setName("contcompany");
        this.kDSeparator6.setName("kDSeparator6");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contbeginDate.setName("contbeginDate");
        this.contendDate.setName("contendDate");
        this.continsteadPrice.setName("continsteadPrice");
        this.conteggSettleType.setName("conteggSettleType");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.baseStatus.setName("baseStatus");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtcreator.setName("prmtcreator");
        this.pkcreateTime.setName("pkcreateTime");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtPolicyEntry.setName("kdtPolicyEntry");
        this.kdtSaleEntry.setName("kdtSaleEntry");
        this.kdtRangeEntry.setName("kdtRangeEntry");
        this.pkbeginDate.setName("pkbeginDate");
        this.pkendDate.setName("pkendDate");
        this.txtinsteadPrice.setName("txtinsteadPrice");
        this.eggSettleType.setName("eggSettleType");
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
        // kDTabbedPane1
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
        // continsteadPrice		
        this.continsteadPrice.setBoundLabelText(resHelper.getString("continsteadPrice.boundLabelText"));		
        this.continsteadPrice.setBoundLabelLength(100);		
        this.continsteadPrice.setBoundLabelUnderline(true);		
        this.continsteadPrice.setVisible(true);
        // conteggSettleType		
        this.conteggSettleType.setBoundLabelText(resHelper.getString("conteggSettleType.boundLabelText"));		
        this.conteggSettleType.setBoundLabelLength(100);		
        this.conteggSettleType.setBoundLabelUnderline(true);		
        this.conteggSettleType.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtPolicyEntry
		String kdtPolicyEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settleItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settleItem}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{price}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPolicyEntry.setFormatXml(resHelper.translateString("kdtPolicyEntry",kdtPolicyEntryStrXML));
        kdtPolicyEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtPolicyEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtPolicyEntry.putBindContents("editData",new String[] {"seq","settleItem","material","unit","price"});


        this.kdtPolicyEntry.checkParsed();
        final KDBizPromptBox kdtPolicyEntry_settleItem_PromptBox = new KDBizPromptBox();
        kdtPolicyEntry_settleItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtPolicyEntry_settleItem_PromptBox.setVisible(true);
        kdtPolicyEntry_settleItem_PromptBox.setEditable(true);
        kdtPolicyEntry_settleItem_PromptBox.setDisplayFormat("$number$");
        kdtPolicyEntry_settleItem_PromptBox.setEditFormat("$number$");
        kdtPolicyEntry_settleItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPolicyEntry_settleItem_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_settleItem_PromptBox);
        this.kdtPolicyEntry.getColumn("settleItem").setEditor(kdtPolicyEntry_settleItem_CellEditor);
        ObjectValueRender kdtPolicyEntry_settleItem_OVR = new ObjectValueRender();
        kdtPolicyEntry_settleItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPolicyEntry.getColumn("settleItem").setRenderer(kdtPolicyEntry_settleItem_OVR);
        			kdtPolicyEntry_settleItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtPolicyEntry_settleItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPolicyEntry_settleItem_PromptBox_F7ListUI == null) {
					try {
						kdtPolicyEntry_settleItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPolicyEntry_settleItem_PromptBox_F7ListUI));
					kdtPolicyEntry_settleItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPolicyEntry_settleItem_PromptBox.setSelector(kdtPolicyEntry_settleItem_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtPolicyEntry_material_PromptBox = new KDBizPromptBox();
        kdtPolicyEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtPolicyEntry_material_PromptBox.setVisible(true);
        kdtPolicyEntry_material_PromptBox.setEditable(true);
        kdtPolicyEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtPolicyEntry_material_PromptBox.setEditFormat("$number$");
        kdtPolicyEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPolicyEntry_material_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_material_PromptBox);
        this.kdtPolicyEntry.getColumn("material").setEditor(kdtPolicyEntry_material_CellEditor);
        ObjectValueRender kdtPolicyEntry_material_OVR = new ObjectValueRender();
        kdtPolicyEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPolicyEntry.getColumn("material").setRenderer(kdtPolicyEntry_material_OVR);
        final KDBizPromptBox kdtPolicyEntry_unit_PromptBox = new KDBizPromptBox();
        kdtPolicyEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtPolicyEntry_unit_PromptBox.setVisible(true);
        kdtPolicyEntry_unit_PromptBox.setEditable(true);
        kdtPolicyEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtPolicyEntry_unit_PromptBox.setEditFormat("$number$");
        kdtPolicyEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtPolicyEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_unit_PromptBox);
        this.kdtPolicyEntry.getColumn("unit").setEditor(kdtPolicyEntry_unit_CellEditor);
        ObjectValueRender kdtPolicyEntry_unit_OVR = new ObjectValueRender();
        kdtPolicyEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtPolicyEntry.getColumn("unit").setRenderer(kdtPolicyEntry_unit_OVR);
        KDFormattedTextField kdtPolicyEntry_price_TextField = new KDFormattedTextField();
        kdtPolicyEntry_price_TextField.setName("kdtPolicyEntry_price_TextField");
        kdtPolicyEntry_price_TextField.setVisible(true);
        kdtPolicyEntry_price_TextField.setEditable(true);
        kdtPolicyEntry_price_TextField.setHorizontalAlignment(2);
        kdtPolicyEntry_price_TextField.setDataType(1);
        	kdtPolicyEntry_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtPolicyEntry_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtPolicyEntry_price_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtPolicyEntry_price_CellEditor = new KDTDefaultCellEditor(kdtPolicyEntry_price_TextField);
        this.kdtPolicyEntry.getColumn("price").setEditor(kdtPolicyEntry_price_CellEditor);
        // kdtSaleEntry
		String kdtSaleEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"settleItem\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{settleItem}</t:Cell><t:Cell>$Resource{material}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSaleEntry.setFormatXml(resHelper.translateString("kdtSaleEntry",kdtSaleEntryStrXML));

                this.kdtSaleEntry.putBindContents("editData",new String[] {"seq","settleItem","material"});


        this.kdtSaleEntry.checkParsed();
        final KDBizPromptBox kdtSaleEntry_settleItem_PromptBox = new KDBizPromptBox();
        kdtSaleEntry_settleItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.SettlementItemQuery");
        kdtSaleEntry_settleItem_PromptBox.setVisible(true);
        kdtSaleEntry_settleItem_PromptBox.setEditable(true);
        kdtSaleEntry_settleItem_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntry_settleItem_PromptBox.setEditFormat("$number$");
        kdtSaleEntry_settleItem_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntry_settleItem_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_settleItem_PromptBox);
        this.kdtSaleEntry.getColumn("settleItem").setEditor(kdtSaleEntry_settleItem_CellEditor);
        ObjectValueRender kdtSaleEntry_settleItem_OVR = new ObjectValueRender();
        kdtSaleEntry_settleItem_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntry.getColumn("settleItem").setRenderer(kdtSaleEntry_settleItem_OVR);
        			kdtSaleEntry_settleItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtSaleEntry_settleItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtSaleEntry_settleItem_PromptBox_F7ListUI == null) {
					try {
						kdtSaleEntry_settleItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtSaleEntry_settleItem_PromptBox_F7ListUI));
					kdtSaleEntry_settleItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtSaleEntry_settleItem_PromptBox.setSelector(kdtSaleEntry_settleItem_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtSaleEntry_material_PromptBox = new KDBizPromptBox();
        kdtSaleEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtSaleEntry_material_PromptBox.setVisible(true);
        kdtSaleEntry_material_PromptBox.setEditable(true);
        kdtSaleEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtSaleEntry_material_PromptBox.setEditFormat("$number$");
        kdtSaleEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSaleEntry_material_CellEditor = new KDTDefaultCellEditor(kdtSaleEntry_material_PromptBox);
        this.kdtSaleEntry.getColumn("material").setEditor(kdtSaleEntry_material_CellEditor);
        ObjectValueRender kdtSaleEntry_material_OVR = new ObjectValueRender();
        kdtSaleEntry_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtSaleEntry.getColumn("material").setRenderer(kdtSaleEntry_material_OVR);
        // kdtRangeEntry
		String kdtRangeEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"supplier\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"farmer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{supplier}</t:Cell><t:Cell>$Resource{farmer}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtRangeEntry.setFormatXml(resHelper.translateString("kdtRangeEntry",kdtRangeEntryStrXML));

                this.kdtRangeEntry.putBindContents("editData",new String[] {"seq","supplier","farmer"});


        this.kdtRangeEntry.checkParsed();
        final KDBizPromptBox kdtRangeEntry_supplier_PromptBox = new KDBizPromptBox();
        kdtRangeEntry_supplier_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerInfoQuery");
        kdtRangeEntry_supplier_PromptBox.setVisible(true);
        kdtRangeEntry_supplier_PromptBox.setEditable(true);
        kdtRangeEntry_supplier_PromptBox.setDisplayFormat("$number$");
        kdtRangeEntry_supplier_PromptBox.setEditFormat("$number$");
        kdtRangeEntry_supplier_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRangeEntry_supplier_CellEditor = new KDTDefaultCellEditor(kdtRangeEntry_supplier_PromptBox);
        this.kdtRangeEntry.getColumn("supplier").setEditor(kdtRangeEntry_supplier_CellEditor);
        ObjectValueRender kdtRangeEntry_supplier_OVR = new ObjectValueRender();
        kdtRangeEntry_supplier_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRangeEntry.getColumn("supplier").setRenderer(kdtRangeEntry_supplier_OVR);
        final KDBizPromptBox kdtRangeEntry_farmer_PromptBox = new KDBizPromptBox();
        kdtRangeEntry_farmer_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmersQuery");
        kdtRangeEntry_farmer_PromptBox.setVisible(true);
        kdtRangeEntry_farmer_PromptBox.setEditable(true);
        kdtRangeEntry_farmer_PromptBox.setDisplayFormat("$number$");
        kdtRangeEntry_farmer_PromptBox.setEditFormat("$number$");
        kdtRangeEntry_farmer_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtRangeEntry_farmer_CellEditor = new KDTDefaultCellEditor(kdtRangeEntry_farmer_PromptBox);
        this.kdtRangeEntry.getColumn("farmer").setEditor(kdtRangeEntry_farmer_CellEditor);
        ObjectValueRender kdtRangeEntry_farmer_OVR = new ObjectValueRender();
        kdtRangeEntry_farmer_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtRangeEntry.getColumn("farmer").setRenderer(kdtRangeEntry_farmer_OVR);
        			kdtRangeEntry_farmer_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI kdtRangeEntry_farmer_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtRangeEntry_farmer_PromptBox_F7ListUI == null) {
					try {
						kdtRangeEntry_farmer_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.FarmersListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtRangeEntry_farmer_PromptBox_F7ListUI));
					kdtRangeEntry_farmer_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtRangeEntry_farmer_PromptBox.setSelector(kdtRangeEntry_farmer_PromptBox_F7ListUI);
				}
			}
		});
					
        // pkbeginDate		
        this.pkbeginDate.setRequired(true);
        // pkendDate		
        this.pkendDate.setRequired(false);
        // txtinsteadPrice		
        this.txtinsteadPrice.setHorizontalAlignment(2);		
        this.txtinsteadPrice.setDataType(1);		
        this.txtinsteadPrice.setSupportedEmpty(true);		
        this.txtinsteadPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtinsteadPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtinsteadPrice.setPrecision(4);		
        this.txtinsteadPrice.setRequired(false);
        // eggSettleType		
        this.eggSettleType.setVisible(true);		
        this.eggSettleType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType").toArray());		
        this.eggSettleType.setRequired(false);
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
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcreator,pkcreateTime,baseStatus,prmtauditor,pkauditTime,prmtcompany,pkbeginDate,pkendDate,txtinsteadPrice,kdtPolicyEntry,kdtRangeEntry,kdtSaleEntry,eggSettleType}));
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
        this.setBounds(new Rectangle(0, 0, 955, 589));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 955, 589));
        kDLabelContainer1.setBounds(new Rectangle(37, 14, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(37, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(345, 14, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(345, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(392, 548, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(392, 548, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(37, 85, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(37, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(657, 14, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(657, 14, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(37, 524, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(37, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(37, 553, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(37, 553, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator5.setBounds(new Rectangle(27, 512, 905, 9));
        this.add(kDSeparator5, new KDLayout.Constraints(27, 512, 905, 9, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contcreator.setBounds(new Rectangle(345, 524, 270, 19));
        this.add(contcreator, new KDLayout.Constraints(345, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcreateTime.setBounds(new Rectangle(657, 524, 270, 19));
        this.add(contcreateTime, new KDLayout.Constraints(657, 524, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(37, 52, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(37, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator6.setBounds(new Rectangle(36, 112, 890, 10));
        this.add(kDSeparator6, new KDLayout.Constraints(36, 112, 890, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(32, 124, 892, 373));
        this.add(kDTabbedPane1, new KDLayout.Constraints(32, 124, 892, 373, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contbeginDate.setBounds(new Rectangle(345, 52, 270, 19));
        this.add(contbeginDate, new KDLayout.Constraints(345, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contendDate.setBounds(new Rectangle(657, 52, 270, 19));
        this.add(contendDate, new KDLayout.Constraints(657, 52, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        continsteadPrice.setBounds(new Rectangle(345, 85, 270, 19));
        this.add(continsteadPrice, new KDLayout.Constraints(345, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        conteggSettleType.setBounds(new Rectangle(657, 83, 270, 19));
        this.add(conteggSettleType, new KDLayout.Constraints(657, 83, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
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
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 891, 340));        kdtPolicyEntry.setBounds(new Rectangle(3, 2, 883, 336));
        kdtPolicyEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtPolicyEntry,new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyPolicyEntryInfo(),null,false);
        kDPanel1.add(kdtPolicyEntry_detailPanel, new KDLayout.Constraints(3, 2, 883, 336, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 891, 340));        kdtSaleEntry.setBounds(new Rectangle(2, 3, 883, 338));
        kdtSaleEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSaleEntry,new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicySaleEntryInfo(),null,false);
        kDPanel2.add(kdtSaleEntry_detailPanel, new KDLayout.Constraints(2, 3, 883, 338, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 891, 340));        kdtRangeEntry.setBounds(new Rectangle(2, 1, 883, 339));
        kdtRangeEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtRangeEntry,new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyRangeEntryInfo(),null,false);
        kDPanel3.add(kdtRangeEntry_detailPanel, new KDLayout.Constraints(2, 1, 883, 339, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contbeginDate
        contbeginDate.setBoundEditor(pkbeginDate);
        //contendDate
        contendDate.setBoundEditor(pkendDate);
        //continsteadPrice
        continsteadPrice.setBoundEditor(txtinsteadPrice);
        //conteggSettleType
        conteggSettleType.setBoundEditor(eggSettleType);

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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtcreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.pkcreateTime, "value");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("PolicyEntry.seq", int.class, this.kdtPolicyEntry, "seq.text");
		dataBinder.registerBinding("PolicyEntry", com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyPolicyEntryInfo.class, this.kdtPolicyEntry, "userObject");
		dataBinder.registerBinding("PolicyEntry.settleItem", java.lang.Object.class, this.kdtPolicyEntry, "settleItem.text");
		dataBinder.registerBinding("PolicyEntry.unit", java.lang.Object.class, this.kdtPolicyEntry, "unit.text");
		dataBinder.registerBinding("PolicyEntry.material", java.lang.Object.class, this.kdtPolicyEntry, "material.text");
		dataBinder.registerBinding("PolicyEntry.price", java.math.BigDecimal.class, this.kdtPolicyEntry, "price.text");
		dataBinder.registerBinding("SaleEntry.seq", int.class, this.kdtSaleEntry, "seq.text");
		dataBinder.registerBinding("SaleEntry", com.kingdee.eas.farm.stocking.hatch.EggSettlePolicySaleEntryInfo.class, this.kdtSaleEntry, "userObject");
		dataBinder.registerBinding("SaleEntry.settleItem", java.lang.Object.class, this.kdtSaleEntry, "settleItem.text");
		dataBinder.registerBinding("SaleEntry.material", java.lang.Object.class, this.kdtSaleEntry, "material.text");
		dataBinder.registerBinding("RangeEntry.seq", int.class, this.kdtRangeEntry, "seq.text");
		dataBinder.registerBinding("RangeEntry", com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyRangeEntryInfo.class, this.kdtRangeEntry, "userObject");
		dataBinder.registerBinding("RangeEntry.supplier", java.lang.Object.class, this.kdtRangeEntry, "supplier.text");
		dataBinder.registerBinding("RangeEntry.farmer", java.lang.Object.class, this.kdtRangeEntry, "farmer.text");
		dataBinder.registerBinding("beginDate", java.util.Date.class, this.pkbeginDate, "value");
		dataBinder.registerBinding("endDate", java.util.Date.class, this.pkendDate, "value");
		dataBinder.registerBinding("insteadPrice", java.math.BigDecimal.class, this.txtinsteadPrice, "value");
		dataBinder.registerBinding("eggSettleType", com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyType.class, this.eggSettleType, "selectedItem");		
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
	    return "com.kingdee.eas.farm.stocking.hatch.app.EggSettlePolicyEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo)ov;
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
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.settleItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("PolicyEntry.price", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.settleItem", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SaleEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RangeEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RangeEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RangeEntry.supplier", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("RangeEntry.farmer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("beginDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("endDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("insteadPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggSettleType", ValidateHelper.ON_SAVE);    		
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
     * output kdtPolicyEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtPolicyEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("settleItem".equalsIgnoreCase(kdtPolicyEntry.getColumn(colIndex).getKey())) {
kdtPolicyEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtPolicyEntry.getCell(rowIndex,"settleItem").getValue(),"settleUnit"));

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
    	sic.add(new SelectorItemInfo("PolicyEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.settleItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PolicyEntry.settleItem.id"));
			sic.add(new SelectorItemInfo("PolicyEntry.settleItem.name"));
        	sic.add(new SelectorItemInfo("PolicyEntry.settleItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PolicyEntry.unit.id"));
			sic.add(new SelectorItemInfo("PolicyEntry.unit.name"));
        	sic.add(new SelectorItemInfo("PolicyEntry.unit.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("PolicyEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("PolicyEntry.material.id"));
			sic.add(new SelectorItemInfo("PolicyEntry.material.name"));
        	sic.add(new SelectorItemInfo("PolicyEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("PolicyEntry.price"));
    	sic.add(new SelectorItemInfo("SaleEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.settleItem.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntry.settleItem.id"));
			sic.add(new SelectorItemInfo("SaleEntry.settleItem.name"));
        	sic.add(new SelectorItemInfo("SaleEntry.settleItem.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SaleEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SaleEntry.material.id"));
			sic.add(new SelectorItemInfo("SaleEntry.material.name"));
        	sic.add(new SelectorItemInfo("SaleEntry.material.number"));
		}
    	sic.add(new SelectorItemInfo("RangeEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RangeEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RangeEntry.supplier.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RangeEntry.supplier.id"));
			sic.add(new SelectorItemInfo("RangeEntry.supplier.name"));
        	sic.add(new SelectorItemInfo("RangeEntry.supplier.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("RangeEntry.farmer.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("RangeEntry.farmer.id"));
			sic.add(new SelectorItemInfo("RangeEntry.farmer.name"));
        	sic.add(new SelectorItemInfo("RangeEntry.farmer.number"));
		}
        sic.add(new SelectorItemInfo("beginDate"));
        sic.add(new SelectorItemInfo("endDate"));
        sic.add(new SelectorItemInfo("insteadPrice"));
        sic.add(new SelectorItemInfo("eggSettleType"));
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractEggSettlePolicyEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractEggSettlePolicyEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.hatch.client", "EggSettlePolicyEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.hatch.client.EggSettlePolicyEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		for (int i=0,n=kdtPolicyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPolicyEntry.getCell(i,"settleItem").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"结算项目"});
			}
		}
		for (int i=0,n=kdtPolicyEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtPolicyEntry.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkbeginDate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效日期"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtPolicyEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
vo.put("eggSettleType",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}