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
public abstract class AbstractSystemSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSystemSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisInner;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisHouseManager;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtStorageEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtStorageEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostGroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaccountType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparentCostCenter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdefaultStorageOrgUnit;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtMarginTypeEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtMarginTypeEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contparentAdminOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostGroup;
    protected com.kingdee.bos.ctrl.swing.KDComboBox accountType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparentCostCenter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdefaultStorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtparentAdminOrg;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisAutoSCM;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisCreateFarmerAsst;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmerAsstActGro;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmerAsstActGro;
    protected com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractSystemSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSystemSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkisInner = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.chkisHouseManager = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtStorageEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contcostGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaccountType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contparentCostCenter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdefaultStorageOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtMarginTypeEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.contparentAdminOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcostGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.accountType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtparentCostCenter = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdefaultStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtparentAdminOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.chkisAutoSCM = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisCreateFarmerAsst = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.contfarmerAsstActGro = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtfarmerAsstActGro = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcompany.setName("contcompany");
        this.chkisInner.setName("chkisInner");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.chkisHouseManager.setName("chkisHouseManager");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcompany.setName("prmtcompany");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtStorageEntry.setName("kdtStorageEntry");
        this.contcostGroup.setName("contcostGroup");
        this.contaccountType.setName("contaccountType");
        this.contparentCostCenter.setName("contparentCostCenter");
        this.contdefaultStorageOrgUnit.setName("contdefaultStorageOrgUnit");
        this.kdtMarginTypeEntry.setName("kdtMarginTypeEntry");
        this.kDLabel1.setName("kDLabel1");
        this.contparentAdminOrg.setName("contparentAdminOrg");
        this.prmtcostGroup.setName("prmtcostGroup");
        this.accountType.setName("accountType");
        this.prmtparentCostCenter.setName("prmtparentCostCenter");
        this.prmtdefaultStorageOrgUnit.setName("prmtdefaultStorageOrgUnit");
        this.prmtparentAdminOrg.setName("prmtparentAdminOrg");
        this.chkisAutoSCM.setName("chkisAutoSCM");
        this.chkisCreateFarmerAsst.setName("chkisCreateFarmerAsst");
        this.contfarmerAsstActGro.setName("contfarmerAsstActGro");
        this.prmtfarmerAsstActGro.setName("prmtfarmerAsstActGro");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setVisible(false);
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
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // chkisInner		
        this.chkisInner.setText(resHelper.getString("chkisInner.text"));		
        this.chkisInner.setHorizontalAlignment(2);
        // kDTabbedPane1
        // chkisHouseManager		
        this.chkisHouseManager.setText(resHelper.getString("chkisHouseManager.text"));		
        this.chkisHouseManager.setHorizontalAlignment(2);		
        this.chkisHouseManager.setVisible(false);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
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
        // kdtStorageEntry
		String kdtStorageEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"outOrgType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"storageOrgUnitName\" t:width=\"300\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{outOrgType}</t:Cell><t:Cell>$Resource{storageOrgUnit}</t:Cell><t:Cell>$Resource{storageOrgUnitName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtStorageEntry.setFormatXml(resHelper.translateString("kdtStorageEntry",kdtStorageEntryStrXML));
        kdtStorageEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtStorageEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtStorageEntry.putBindContents("editData",new String[] {"seq","outOrgType","storageOrgUnit","storageOrgUnitName"});


        this.kdtStorageEntry.checkParsed();
        KDComboBox kdtStorageEntry_outOrgType_ComboBox = new KDComboBox();
        kdtStorageEntry_outOrgType_ComboBox.setName("kdtStorageEntry_outOrgType_ComboBox");
        kdtStorageEntry_outOrgType_ComboBox.setVisible(true);
        kdtStorageEntry_outOrgType_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.OutOrgEnum").toArray());
        KDTDefaultCellEditor kdtStorageEntry_outOrgType_CellEditor = new KDTDefaultCellEditor(kdtStorageEntry_outOrgType_ComboBox);
        this.kdtStorageEntry.getColumn("outOrgType").setEditor(kdtStorageEntry_outOrgType_CellEditor);
        final KDBizPromptBox kdtStorageEntry_storageOrgUnit_PromptBox = new KDBizPromptBox();
        kdtStorageEntry_storageOrgUnit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");
        kdtStorageEntry_storageOrgUnit_PromptBox.setVisible(true);
        kdtStorageEntry_storageOrgUnit_PromptBox.setEditable(true);
        kdtStorageEntry_storageOrgUnit_PromptBox.setDisplayFormat("$number$");
        kdtStorageEntry_storageOrgUnit_PromptBox.setEditFormat("$number$");
        kdtStorageEntry_storageOrgUnit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtStorageEntry_storageOrgUnit_CellEditor = new KDTDefaultCellEditor(kdtStorageEntry_storageOrgUnit_PromptBox);
        this.kdtStorageEntry.getColumn("storageOrgUnit").setEditor(kdtStorageEntry_storageOrgUnit_CellEditor);
        ObjectValueRender kdtStorageEntry_storageOrgUnit_OVR = new ObjectValueRender();
        kdtStorageEntry_storageOrgUnit_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtStorageEntry.getColumn("storageOrgUnit").setRenderer(kdtStorageEntry_storageOrgUnit_OVR);
        KDTextField kdtStorageEntry_storageOrgUnitName_TextField = new KDTextField();
        kdtStorageEntry_storageOrgUnitName_TextField.setName("kdtStorageEntry_storageOrgUnitName_TextField");
        kdtStorageEntry_storageOrgUnitName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtStorageEntry_storageOrgUnitName_CellEditor = new KDTDefaultCellEditor(kdtStorageEntry_storageOrgUnitName_TextField);
        this.kdtStorageEntry.getColumn("storageOrgUnitName").setEditor(kdtStorageEntry_storageOrgUnitName_CellEditor);
        // contcostGroup		
        this.contcostGroup.setBoundLabelText(resHelper.getString("contcostGroup.boundLabelText"));		
        this.contcostGroup.setBoundLabelLength(100);		
        this.contcostGroup.setBoundLabelUnderline(true);		
        this.contcostGroup.setVisible(true);
        // contaccountType		
        this.contaccountType.setBoundLabelText(resHelper.getString("contaccountType.boundLabelText"));		
        this.contaccountType.setBoundLabelLength(100);		
        this.contaccountType.setBoundLabelUnderline(true);		
        this.contaccountType.setVisible(true);
        // contparentCostCenter		
        this.contparentCostCenter.setBoundLabelText(resHelper.getString("contparentCostCenter.boundLabelText"));		
        this.contparentCostCenter.setBoundLabelLength(100);		
        this.contparentCostCenter.setBoundLabelUnderline(true);		
        this.contparentCostCenter.setVisible(false);
        // contdefaultStorageOrgUnit		
        this.contdefaultStorageOrgUnit.setBoundLabelText(resHelper.getString("contdefaultStorageOrgUnit.boundLabelText"));		
        this.contdefaultStorageOrgUnit.setBoundLabelLength(100);		
        this.contdefaultStorageOrgUnit.setBoundLabelUnderline(true);		
        this.contdefaultStorageOrgUnit.setVisible(true);
        // kdtMarginTypeEntry
		String kdtMarginTypeEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"receiveType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{receiveType}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtMarginTypeEntry.setFormatXml(resHelper.translateString("kdtMarginTypeEntry",kdtMarginTypeEntryStrXML));

                this.kdtMarginTypeEntry.putBindContents("editData",new String[] {"seq","receiveType"});


        this.kdtMarginTypeEntry.checkParsed();
        final KDBizPromptBox kdtMarginTypeEntry_receiveType_PromptBox = new KDBizPromptBox();
        kdtMarginTypeEntry_receiveType_PromptBox.setQueryInfo("com.kingdee.eas.fi.cas.ReceivingBillTypeQuery");
        kdtMarginTypeEntry_receiveType_PromptBox.setVisible(true);
        kdtMarginTypeEntry_receiveType_PromptBox.setEditable(true);
        kdtMarginTypeEntry_receiveType_PromptBox.setDisplayFormat("$number$");
        kdtMarginTypeEntry_receiveType_PromptBox.setEditFormat("$number$");
        kdtMarginTypeEntry_receiveType_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtMarginTypeEntry_receiveType_CellEditor = new KDTDefaultCellEditor(kdtMarginTypeEntry_receiveType_PromptBox);
        this.kdtMarginTypeEntry.getColumn("receiveType").setEditor(kdtMarginTypeEntry_receiveType_CellEditor);
        ObjectValueRender kdtMarginTypeEntry_receiveType_OVR = new ObjectValueRender();
        kdtMarginTypeEntry_receiveType_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtMarginTypeEntry.getColumn("receiveType").setRenderer(kdtMarginTypeEntry_receiveType_OVR);
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));
        // contparentAdminOrg		
        this.contparentAdminOrg.setBoundLabelText(resHelper.getString("contparentAdminOrg.boundLabelText"));		
        this.contparentAdminOrg.setBoundLabelLength(100);		
        this.contparentAdminOrg.setBoundLabelUnderline(true);		
        this.contparentAdminOrg.setVisible(true);
        // prmtcostGroup		
        this.prmtcostGroup.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectGroupQuery");		
        this.prmtcostGroup.setEditable(true);		
        this.prmtcostGroup.setDisplayFormat("$name$");		
        this.prmtcostGroup.setEditFormat("$number$");		
        this.prmtcostGroup.setCommitFormat("$number$");		
        this.prmtcostGroup.setRequired(false);
        // accountType		
        this.accountType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum").toArray());		
        this.accountType.setRequired(true);
        // prmtparentCostCenter		
        this.prmtparentCostCenter.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtparentCostCenter.setEditable(true);		
        this.prmtparentCostCenter.setDisplayFormat("$name$");		
        this.prmtparentCostCenter.setEditFormat("$number$");		
        this.prmtparentCostCenter.setCommitFormat("$number$");		
        this.prmtparentCostCenter.setRequired(false);
        // prmtdefaultStorageOrgUnit		
        this.prmtdefaultStorageOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtdefaultStorageOrgUnit.setEditable(true);		
        this.prmtdefaultStorageOrgUnit.setDisplayFormat("$name$");		
        this.prmtdefaultStorageOrgUnit.setEditFormat("$number$");		
        this.prmtdefaultStorageOrgUnit.setCommitFormat("$number$");		
        this.prmtdefaultStorageOrgUnit.setRequired(true);
        // prmtparentAdminOrg		
        this.prmtparentAdminOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminItemQuery");		
        this.prmtparentAdminOrg.setVisible(true);		
        this.prmtparentAdminOrg.setEditable(true);		
        this.prmtparentAdminOrg.setDisplayFormat("$name$");		
        this.prmtparentAdminOrg.setEditFormat("$number$");		
        this.prmtparentAdminOrg.setCommitFormat("$number$");		
        this.prmtparentAdminOrg.setRequired(true);
        // chkisAutoSCM		
        this.chkisAutoSCM.setText(resHelper.getString("chkisAutoSCM.text"));		
        this.chkisAutoSCM.setVisible(true);		
        this.chkisAutoSCM.setHorizontalAlignment(2);
        // chkisCreateFarmerAsst		
        this.chkisCreateFarmerAsst.setText(resHelper.getString("chkisCreateFarmerAsst.text"));		
        this.chkisCreateFarmerAsst.setVisible(true);		
        this.chkisCreateFarmerAsst.setHorizontalAlignment(2);
        // contfarmerAsstActGro		
        this.contfarmerAsstActGro.setBoundLabelText(resHelper.getString("contfarmerAsstActGro.boundLabelText"));		
        this.contfarmerAsstActGro.setBoundLabelLength(100);		
        this.contfarmerAsstActGro.setBoundLabelUnderline(true);		
        this.contfarmerAsstActGro.setVisible(true);
        // prmtfarmerAsstActGro		
        this.prmtfarmerAsstActGro.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.F7GeneralAsstActTypeGroupQuery");		
        this.prmtfarmerAsstActGro.setVisible(true);		
        this.prmtfarmerAsstActGro.setEditable(true);		
        this.prmtfarmerAsstActGro.setDisplayFormat("$name$");		
        this.prmtfarmerAsstActGro.setEditFormat("$number$");		
        this.prmtfarmerAsstActGro.setCommitFormat("$number$");		
        this.prmtfarmerAsstActGro.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtcompany,chkisInner,prmtcostGroup,accountType,chkisHouseManager,prmtparentCostCenter,prmtdefaultStorageOrgUnit,kdtStorageEntry,kdtMarginTypeEntry,chkisAutoSCM,prmtparentAdminOrg,chkisCreateFarmerAsst,prmtfarmerAsstActGro}));
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
        this.setBounds(new Rectangle(0, 0, 649, 356));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(593, 49, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(32, 29, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(593, 123, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(593, 160, 270, 19));
        this.add(kDLabelContainer4, null);
        contcompany.setBounds(new Rectangle(342, 29, 270, 19));
        this.add(contcompany, null);
        chkisInner.setBounds(new Rectangle(32, 70, 122, 19));
        this.add(chkisInner, null);
        kDTabbedPane1.setBounds(new Rectangle(21, 102, 610, 238));
        this.add(kDTabbedPane1, null);
        chkisHouseManager.setBounds(new Rectangle(208, 70, 94, 19));
        this.add(chkisHouseManager, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(null);        kdtStorageEntry.setBounds(new Rectangle(4, 2, 596, 203));
        kdtStorageEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtStorageEntry,new com.kingdee.eas.farm.carnivorous.basedata.SystemSettingStorageEntryInfo(),null,false);
        kDPanel1.add(kdtStorageEntry_detailPanel, null);
		kdtStorageEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("outOrgType",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel2
        kDPanel2.setLayout(null);        contcostGroup.setBounds(new Rectangle(17, 47, 270, 19));
        kDPanel2.add(contcostGroup, null);
        contaccountType.setBounds(new Rectangle(18, 16, 270, 19));
        kDPanel2.add(contaccountType, null);
        contparentCostCenter.setBounds(new Rectangle(308, 76, 270, 19));
        kDPanel2.add(contparentCostCenter, null);
        contdefaultStorageOrgUnit.setBounds(new Rectangle(308, 47, 270, 19));
        kDPanel2.add(contdefaultStorageOrgUnit, null);
        kdtMarginTypeEntry.setBounds(new Rectangle(17, 101, 274, 102));
        kdtMarginTypeEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtMarginTypeEntry,new com.kingdee.eas.farm.carnivorous.basedata.SystemSettingMarginTypeEntryInfo(),null,false);
        kDPanel2.add(kdtMarginTypeEntry_detailPanel, null);
        kDLabel1.setBounds(new Rectangle(17, 78, 100, 19));
        kDPanel2.add(kDLabel1, null);
        contparentAdminOrg.setBounds(new Rectangle(308, 16, 270, 19));
        kDPanel2.add(contparentAdminOrg, null);
        //contcostGroup
        contcostGroup.setBoundEditor(prmtcostGroup);
        //contaccountType
        contaccountType.setBoundEditor(accountType);
        //contparentCostCenter
        contparentCostCenter.setBoundEditor(prmtparentCostCenter);
        //contdefaultStorageOrgUnit
        contdefaultStorageOrgUnit.setBoundEditor(prmtdefaultStorageOrgUnit);
        //contparentAdminOrg
        contparentAdminOrg.setBoundEditor(prmtparentAdminOrg);
        //kDPanel3
        kDPanel3.setLayout(null);        chkisAutoSCM.setBounds(new Rectangle(25, 19, 139, 19));
        kDPanel3.add(chkisAutoSCM, null);
        chkisCreateFarmerAsst.setBounds(new Rectangle(26, 56, 157, 19));
        kDPanel3.add(chkisCreateFarmerAsst, null);
        contfarmerAsstActGro.setBounds(new Rectangle(271, 54, 270, 19));
        kDPanel3.add(contfarmerAsstActGro, null);
        //contfarmerAsstActGro
        contfarmerAsstActGro.setBoundEditor(prmtfarmerAsstActGro);

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
		dataBinder.registerBinding("isInner", boolean.class, this.chkisInner, "selected");
		dataBinder.registerBinding("isHouseManager", boolean.class, this.chkisHouseManager, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("StorageEntry.seq", int.class, this.kdtStorageEntry, "seq.text");
		dataBinder.registerBinding("StorageEntry", com.kingdee.eas.farm.carnivorous.basedata.SystemSettingStorageEntryInfo.class, this.kdtStorageEntry, "userObject");
		dataBinder.registerBinding("StorageEntry.storageOrgUnit", java.lang.Object.class, this.kdtStorageEntry, "storageOrgUnit.text");
		dataBinder.registerBinding("StorageEntry.storageOrgUnitName", String.class, this.kdtStorageEntry, "storageOrgUnitName.text");
		dataBinder.registerBinding("StorageEntry.outOrgType", com.kingdee.util.enums.Enum.class, this.kdtStorageEntry, "outOrgType.text");
		dataBinder.registerBinding("MarginTypeEntry.seq", int.class, this.kdtMarginTypeEntry, "seq.text");
		dataBinder.registerBinding("MarginTypeEntry", com.kingdee.eas.farm.carnivorous.basedata.SystemSettingMarginTypeEntryInfo.class, this.kdtMarginTypeEntry, "userObject");
		dataBinder.registerBinding("MarginTypeEntry.receiveType", java.lang.Object.class, this.kdtMarginTypeEntry, "receiveType.text");
		dataBinder.registerBinding("costGroup", com.kingdee.eas.basedata.assistant.CostObjectGroupInfo.class, this.prmtcostGroup, "data");
		dataBinder.registerBinding("accountType", com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum.class, this.accountType, "selectedItem");
		dataBinder.registerBinding("parentCostCenter", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtparentCostCenter, "data");
		dataBinder.registerBinding("defaultStorageOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtdefaultStorageOrgUnit, "data");
		dataBinder.registerBinding("parentAdminOrg", com.kingdee.eas.basedata.org.AdminOrgUnitInfo.class, this.prmtparentAdminOrg, "data");
		dataBinder.registerBinding("isAutoSCM", boolean.class, this.chkisAutoSCM, "selected");
		dataBinder.registerBinding("isCreateFarmerAsst", boolean.class, this.chkisCreateFarmerAsst, "selected");
		dataBinder.registerBinding("farmerAsstActGro", com.kingdee.eas.farm.carnivorous.basedata.FarmInfo.class, this.prmtfarmerAsstActGro, "data");		
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
	    return "com.kingdee.eas.farm.carnivorous.basedata.app.SystemSettingEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("isInner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isHouseManager", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageEntry.storageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageEntry.storageOrgUnitName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StorageEntry.outOrgType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginTypeEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginTypeEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("MarginTypeEntry.receiveType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("accountType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parentCostCenter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("defaultStorageOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("parentAdminOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isAutoSCM", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("isCreateFarmerAsst", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmerAsstActGro", ValidateHelper.ON_SAVE);    		
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
     * output kdtStorageEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtStorageEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("storageOrgUnit".equalsIgnoreCase(kdtStorageEntry.getColumn(colIndex).getKey())) {
kdtStorageEntry.getCell(rowIndex,"storageOrgUnitName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtStorageEntry.getCell(rowIndex,"storageOrgUnit").getValue(),"name")));

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
        sic.add(new SelectorItemInfo("isInner"));
        sic.add(new SelectorItemInfo("isHouseManager"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
    	sic.add(new SelectorItemInfo("StorageEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StorageEntry.storageOrgUnit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("StorageEntry.storageOrgUnit.id"));
			sic.add(new SelectorItemInfo("StorageEntry.storageOrgUnit.number"));
			sic.add(new SelectorItemInfo("StorageEntry.storageOrgUnit.name"));
		}
    	sic.add(new SelectorItemInfo("StorageEntry.storageOrgUnitName"));
    	sic.add(new SelectorItemInfo("StorageEntry.outOrgType"));
    	sic.add(new SelectorItemInfo("MarginTypeEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MarginTypeEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("MarginTypeEntry.receiveType.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("MarginTypeEntry.receiveType.id"));
			sic.add(new SelectorItemInfo("MarginTypeEntry.receiveType.name"));
        	sic.add(new SelectorItemInfo("MarginTypeEntry.receiveType.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costGroup.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costGroup.id"));
        	sic.add(new SelectorItemInfo("costGroup.number"));
        	sic.add(new SelectorItemInfo("costGroup.name"));
		}
        sic.add(new SelectorItemInfo("accountType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parentCostCenter.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parentCostCenter.id"));
        	sic.add(new SelectorItemInfo("parentCostCenter.number"));
        	sic.add(new SelectorItemInfo("parentCostCenter.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("defaultStorageOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("defaultStorageOrgUnit.id"));
        	sic.add(new SelectorItemInfo("defaultStorageOrgUnit.number"));
        	sic.add(new SelectorItemInfo("defaultStorageOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("parentAdminOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("parentAdminOrg.id"));
        	sic.add(new SelectorItemInfo("parentAdminOrg.number"));
        	sic.add(new SelectorItemInfo("parentAdminOrg.name"));
		}
        sic.add(new SelectorItemInfo("isAutoSCM"));
        sic.add(new SelectorItemInfo("isCreateFarmerAsst"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmerAsstActGro.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmerAsstActGro.id"));
        	sic.add(new SelectorItemInfo("farmerAsstActGro.number"));
        	sic.add(new SelectorItemInfo("farmerAsstActGro.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.client", "SystemSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.SystemSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		for (int i=0,n=kdtStorageEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtStorageEntry.getCell(i,"outOrgType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"类型"});
			}
		}
		for (int i=0,n=kdtMarginTypeEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtMarginTypeEntry.getCell(i,"receiveType").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"收款类型"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(accountType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"核算维度"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtdefaultStorageOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"默认库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtparentAdminOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"父行政组织"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtStorageEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("accountType",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}