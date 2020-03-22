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
public abstract class AbstractBreedDataEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedDataEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbridMaterial;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfemaleMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contweedoutMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgenerateType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgenderType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbroodMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpreEggMaterial;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conteggMaterial;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtmaterial;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbridMaterial;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtSeedEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtSeedEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtStageEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtStageEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDTextArea txtremark;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfemaleMaterial;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtweedoutMaterial;
    protected com.kingdee.bos.ctrl.swing.KDComboBox generateType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox genderType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbroodMaterial;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpreEggMaterial;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmteggMaterial;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.BreedDataInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBreedDataEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedDataEditUI.class.getName());
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
        this.contmaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbridMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contfemaleMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contweedoutMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgenerateType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgenderType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbroodMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpreEggMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conteggMaterial = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtmaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbridMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtSeedEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtStageEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtremark = new com.kingdee.bos.ctrl.swing.KDTextArea();
        this.prmtfemaleMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtweedoutMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.generateType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.genderType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtbroodMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpreEggMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmteggMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contmaterial.setName("contmaterial");
        this.contbaseStatus.setName("contbaseStatus");
        this.contbridMaterial.setName("contbridMaterial");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contfemaleMaterial.setName("contfemaleMaterial");
        this.contweedoutMaterial.setName("contweedoutMaterial");
        this.contgenerateType.setName("contgenerateType");
        this.contgenderType.setName("contgenderType");
        this.contbroodMaterial.setName("contbroodMaterial");
        this.contpreEggMaterial.setName("contpreEggMaterial");
        this.conteggMaterial.setName("conteggMaterial");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtmaterial.setName("prmtmaterial");
        this.baseStatus.setName("baseStatus");
        this.prmtbridMaterial.setName("prmtbridMaterial");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtSeedEntry.setName("kdtSeedEntry");
        this.kdtEntry.setName("kdtEntry");
        this.kdtStageEntry.setName("kdtStageEntry");
        this.txtremark.setName("txtremark");
        this.prmtfemaleMaterial.setName("prmtfemaleMaterial");
        this.prmtweedoutMaterial.setName("prmtweedoutMaterial");
        this.generateType.setName("generateType");
        this.genderType.setName("genderType");
        this.prmtbroodMaterial.setName("prmtbroodMaterial");
        this.prmtpreEggMaterial.setName("prmtpreEggMaterial");
        this.prmteggMaterial.setName("prmteggMaterial");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
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
        // contmaterial		
        this.contmaterial.setBoundLabelText(resHelper.getString("contmaterial.boundLabelText"));		
        this.contmaterial.setBoundLabelLength(100);		
        this.contmaterial.setBoundLabelUnderline(true);		
        this.contmaterial.setVisible(false);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contbridMaterial		
        this.contbridMaterial.setBoundLabelText(resHelper.getString("contbridMaterial.boundLabelText"));		
        this.contbridMaterial.setBoundLabelLength(100);		
        this.contbridMaterial.setBoundLabelUnderline(true);		
        this.contbridMaterial.setVisible(true);
        // kDTabbedPane1
        // contfemaleMaterial		
        this.contfemaleMaterial.setBoundLabelText(resHelper.getString("contfemaleMaterial.boundLabelText"));		
        this.contfemaleMaterial.setBoundLabelLength(100);		
        this.contfemaleMaterial.setBoundLabelUnderline(true);		
        this.contfemaleMaterial.setVisible(false);
        // contweedoutMaterial		
        this.contweedoutMaterial.setBoundLabelText(resHelper.getString("contweedoutMaterial.boundLabelText"));		
        this.contweedoutMaterial.setBoundLabelLength(100);		
        this.contweedoutMaterial.setBoundLabelUnderline(true);		
        this.contweedoutMaterial.setVisible(true);
        // contgenerateType		
        this.contgenerateType.setBoundLabelText(resHelper.getString("contgenerateType.boundLabelText"));		
        this.contgenerateType.setBoundLabelLength(100);		
        this.contgenerateType.setBoundLabelUnderline(true);		
        this.contgenerateType.setVisible(true);
        // contgenderType		
        this.contgenderType.setBoundLabelText(resHelper.getString("contgenderType.boundLabelText"));		
        this.contgenderType.setBoundLabelLength(100);		
        this.contgenderType.setBoundLabelUnderline(true);		
        this.contgenderType.setVisible(true);
        // contbroodMaterial		
        this.contbroodMaterial.setBoundLabelText(resHelper.getString("contbroodMaterial.boundLabelText"));		
        this.contbroodMaterial.setBoundLabelLength(100);		
        this.contbroodMaterial.setBoundLabelUnderline(true);		
        this.contbroodMaterial.setVisible(true);
        // contpreEggMaterial		
        this.contpreEggMaterial.setBoundLabelText(resHelper.getString("contpreEggMaterial.boundLabelText"));		
        this.contpreEggMaterial.setBoundLabelLength(100);		
        this.contpreEggMaterial.setBoundLabelUnderline(true);		
        this.contpreEggMaterial.setVisible(true);
        // conteggMaterial		
        this.conteggMaterial.setBoundLabelText(resHelper.getString("conteggMaterial.boundLabelText"));		
        this.conteggMaterial.setBoundLabelLength(100);		
        this.conteggMaterial.setBoundLabelUnderline(true);		
        this.conteggMaterial.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtmaterial		
        this.prmtmaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtmaterial.setEditable(true);		
        this.prmtmaterial.setDisplayFormat("$name$");		
        this.prmtmaterial.setEditFormat("$number$");		
        this.prmtmaterial.setCommitFormat("$number$");		
        this.prmtmaterial.setRequired(false);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtbridMaterial		
        this.prmtbridMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtbridMaterial.setEditable(true);		
        this.prmtbridMaterial.setDisplayFormat("$name$");		
        this.prmtbridMaterial.setEditFormat("$number$");		
        this.prmtbridMaterial.setCommitFormat("$number$");		
        this.prmtbridMaterial.setRequired(true);
        // kDPanel4
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtSeedEntry
		String kdtSeedEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"maleOrFemale\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{maleOrFemale}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtSeedEntry.setFormatXml(resHelper.translateString("kdtSeedEntry",kdtSeedEntryStrXML));
        kdtSeedEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtSeedEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtSeedEntry.putBindContents("editData",new String[] {"seq","maleOrFemale","material","materialName","model"});


        this.kdtSeedEntry.checkParsed();
        KDComboBox kdtSeedEntry_maleOrFemale_ComboBox = new KDComboBox();
        kdtSeedEntry_maleOrFemale_ComboBox.setName("kdtSeedEntry_maleOrFemale_ComboBox");
        kdtSeedEntry_maleOrFemale_ComboBox.setVisible(true);
        kdtSeedEntry_maleOrFemale_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.MaleOrFemaleEnum").toArray());
        KDTDefaultCellEditor kdtSeedEntry_maleOrFemale_CellEditor = new KDTDefaultCellEditor(kdtSeedEntry_maleOrFemale_ComboBox);
        this.kdtSeedEntry.getColumn("maleOrFemale").setEditor(kdtSeedEntry_maleOrFemale_CellEditor);
        final KDBizPromptBox kdtSeedEntry_material_PromptBox = new KDBizPromptBox();
        kdtSeedEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtSeedEntry_material_PromptBox.setVisible(true);
        kdtSeedEntry_material_PromptBox.setEditable(true);
        kdtSeedEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtSeedEntry_material_PromptBox.setEditFormat("$number$");
        kdtSeedEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtSeedEntry_material_CellEditor = new KDTDefaultCellEditor(kdtSeedEntry_material_PromptBox);
        this.kdtSeedEntry.getColumn("material").setEditor(kdtSeedEntry_material_CellEditor);
        ObjectValueRender kdtSeedEntry_material_OVR = new ObjectValueRender();
        kdtSeedEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtSeedEntry.getColumn("material").setRenderer(kdtSeedEntry_material_OVR);
        KDTextField kdtSeedEntry_materialName_TextField = new KDTextField();
        kdtSeedEntry_materialName_TextField.setName("kdtSeedEntry_materialName_TextField");
        kdtSeedEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtSeedEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtSeedEntry_materialName_TextField);
        this.kdtSeedEntry.getColumn("materialName").setEditor(kdtSeedEntry_materialName_CellEditor);
        KDTextField kdtSeedEntry_model_TextField = new KDTextField();
        kdtSeedEntry_model_TextField.setName("kdtSeedEntry_model_TextField");
        kdtSeedEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtSeedEntry_model_CellEditor = new KDTDefaultCellEditor(kdtSeedEntry_model_TextField);
        this.kdtSeedEntry.getColumn("model").setEditor(kdtSeedEntry_model_CellEditor);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"isQualified\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{isQualified}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","material","materialName","model","isQualified"});


        this.kdtEntry.checkParsed();
        final KDBizPromptBox kdtEntry_material_PromptBox = new KDBizPromptBox();
        kdtEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntry_material_PromptBox.setVisible(true);
        kdtEntry_material_PromptBox.setEditable(true);
        kdtEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtEntry_material_PromptBox.setEditFormat("$number$");
        kdtEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_material_CellEditor = new KDTDefaultCellEditor(kdtEntry_material_PromptBox);
        this.kdtEntry.getColumn("material").setEditor(kdtEntry_material_CellEditor);
        ObjectValueRender kdtEntry_material_OVR = new ObjectValueRender();
        kdtEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("material").setRenderer(kdtEntry_material_OVR);
        KDTextField kdtEntry_materialName_TextField = new KDTextField();
        kdtEntry_materialName_TextField.setName("kdtEntry_materialName_TextField");
        kdtEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialName_TextField);
        this.kdtEntry.getColumn("materialName").setEditor(kdtEntry_materialName_CellEditor);
        KDTextField kdtEntry_model_TextField = new KDTextField();
        kdtEntry_model_TextField.setName("kdtEntry_model_TextField");
        kdtEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_model_CellEditor = new KDTDefaultCellEditor(kdtEntry_model_TextField);
        this.kdtEntry.getColumn("model").setEditor(kdtEntry_model_CellEditor);
        KDCheckBox kdtEntry_isQualified_CheckBox = new KDCheckBox();
        kdtEntry_isQualified_CheckBox.setName("kdtEntry_isQualified_CheckBox");
        KDTDefaultCellEditor kdtEntry_isQualified_CellEditor = new KDTDefaultCellEditor(kdtEntry_isQualified_CheckBox);
        this.kdtEntry.getColumn("isQualified").setEditor(kdtEntry_isQualified_CellEditor);
        // kdtStageEntry
		String kdtStageEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"farmStage\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"endWeek\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"endDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{farmStage}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{endWeek}</t:Cell><t:Cell>$Resource{endDays}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtStageEntry.setFormatXml(resHelper.translateString("kdtStageEntry",kdtStageEntryStrXML));

                this.kdtStageEntry.putBindContents("editData",new String[] {"seq","farmStage","week","days","endWeek","endDays"});


        this.kdtStageEntry.checkParsed();
        KDComboBox kdtStageEntry_farmStage_ComboBox = new KDComboBox();
        kdtStageEntry_farmStage_ComboBox.setName("kdtStageEntry_farmStage_ComboBox");
        kdtStageEntry_farmStage_ComboBox.setVisible(true);
        kdtStageEntry_farmStage_ComboBox.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmStageEnum").toArray());
        KDTDefaultCellEditor kdtStageEntry_farmStage_CellEditor = new KDTDefaultCellEditor(kdtStageEntry_farmStage_ComboBox);
        this.kdtStageEntry.getColumn("farmStage").setEditor(kdtStageEntry_farmStage_CellEditor);
        KDFormattedTextField kdtStageEntry_week_TextField = new KDFormattedTextField();
        kdtStageEntry_week_TextField.setName("kdtStageEntry_week_TextField");
        kdtStageEntry_week_TextField.setVisible(true);
        kdtStageEntry_week_TextField.setEditable(true);
        kdtStageEntry_week_TextField.setHorizontalAlignment(2);
        kdtStageEntry_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStageEntry_week_CellEditor = new KDTDefaultCellEditor(kdtStageEntry_week_TextField);
        this.kdtStageEntry.getColumn("week").setEditor(kdtStageEntry_week_CellEditor);
        KDFormattedTextField kdtStageEntry_days_TextField = new KDFormattedTextField();
        kdtStageEntry_days_TextField.setName("kdtStageEntry_days_TextField");
        kdtStageEntry_days_TextField.setVisible(true);
        kdtStageEntry_days_TextField.setEditable(true);
        kdtStageEntry_days_TextField.setHorizontalAlignment(2);
        kdtStageEntry_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStageEntry_days_CellEditor = new KDTDefaultCellEditor(kdtStageEntry_days_TextField);
        this.kdtStageEntry.getColumn("days").setEditor(kdtStageEntry_days_CellEditor);
        KDFormattedTextField kdtStageEntry_endWeek_TextField = new KDFormattedTextField();
        kdtStageEntry_endWeek_TextField.setName("kdtStageEntry_endWeek_TextField");
        kdtStageEntry_endWeek_TextField.setVisible(true);
        kdtStageEntry_endWeek_TextField.setEditable(true);
        kdtStageEntry_endWeek_TextField.setHorizontalAlignment(2);
        kdtStageEntry_endWeek_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStageEntry_endWeek_CellEditor = new KDTDefaultCellEditor(kdtStageEntry_endWeek_TextField);
        this.kdtStageEntry.getColumn("endWeek").setEditor(kdtStageEntry_endWeek_CellEditor);
        KDFormattedTextField kdtStageEntry_endDays_TextField = new KDFormattedTextField();
        kdtStageEntry_endDays_TextField.setName("kdtStageEntry_endDays_TextField");
        kdtStageEntry_endDays_TextField.setVisible(true);
        kdtStageEntry_endDays_TextField.setEditable(true);
        kdtStageEntry_endDays_TextField.setHorizontalAlignment(2);
        kdtStageEntry_endDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtStageEntry_endDays_CellEditor = new KDTDefaultCellEditor(kdtStageEntry_endDays_TextField);
        this.kdtStageEntry.getColumn("endDays").setEditor(kdtStageEntry_endDays_CellEditor);
        // txtremark		
        this.txtremark.setRequired(false);		
        this.txtremark.setMaxLength(255);
        // prmtfemaleMaterial		
        this.prmtfemaleMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtfemaleMaterial.setEditable(true);		
        this.prmtfemaleMaterial.setDisplayFormat("$name$");		
        this.prmtfemaleMaterial.setEditFormat("$number$");		
        this.prmtfemaleMaterial.setCommitFormat("$number$");		
        this.prmtfemaleMaterial.setRequired(false);
        // prmtweedoutMaterial		
        this.prmtweedoutMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtweedoutMaterial.setEditable(true);		
        this.prmtweedoutMaterial.setDisplayFormat("$name$");		
        this.prmtweedoutMaterial.setEditFormat("$number$");		
        this.prmtweedoutMaterial.setCommitFormat("$number$");		
        this.prmtweedoutMaterial.setRequired(true);
        // generateType		
        this.generateType.setVisible(true);		
        this.generateType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenerateType").toArray());		
        this.generateType.setRequired(true);
        // genderType		
        this.genderType.setVisible(true);		
        this.genderType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.hatch.GenderType").toArray());		
        this.genderType.setRequired(false);
        // prmtbroodMaterial		
        this.prmtbroodMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtbroodMaterial.setVisible(true);		
        this.prmtbroodMaterial.setEditable(true);		
        this.prmtbroodMaterial.setDisplayFormat("$name$");		
        this.prmtbroodMaterial.setEditFormat("$number$");		
        this.prmtbroodMaterial.setCommitFormat("$number$");		
        this.prmtbroodMaterial.setRequired(false);
        // prmtpreEggMaterial		
        this.prmtpreEggMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmtpreEggMaterial.setVisible(true);		
        this.prmtpreEggMaterial.setEditable(true);		
        this.prmtpreEggMaterial.setDisplayFormat("$name$");		
        this.prmtpreEggMaterial.setEditFormat("$number$");		
        this.prmtpreEggMaterial.setCommitFormat("$number$");		
        this.prmtpreEggMaterial.setRequired(false);
        // prmteggMaterial		
        this.prmteggMaterial.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialQuery");		
        this.prmteggMaterial.setVisible(true);		
        this.prmteggMaterial.setEditable(true);		
        this.prmteggMaterial.setDisplayFormat("$name$");		
        this.prmteggMaterial.setEditFormat("$number$");		
        this.prmteggMaterial.setCommitFormat("$number$");		
        this.prmteggMaterial.setRequired(false);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,txtDescription,txtSimpleName,prmtmaterial,baseStatus,prmtbridMaterial,txtremark,prmtfemaleMaterial,prmtweedoutMaterial,kdtEntry,kdtStageEntry,kdtSeedEntry,generateType,genderType,prmtbroodMaterial,prmtpreEggMaterial,prmteggMaterial}));
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
        this.setBounds(new Rectangle(0, 0, 618, 402));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(32, 23, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(323, 23, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(768, 172, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(778, 211, 270, 19));
        this.add(kDLabelContainer4, null);
        contmaterial.setBounds(new Rectangle(600, 107, 270, 19));
        this.add(contmaterial, null);
        contbaseStatus.setBounds(new Rectangle(32, 128, 270, 19));
        this.add(contbaseStatus, null);
        contbridMaterial.setBounds(new Rectangle(323, 58, 270, 19));
        this.add(contbridMaterial, null);
        kDTabbedPane1.setBounds(new Rectangle(28, 200, 555, 178));
        this.add(kDTabbedPane1, null);
        contfemaleMaterial.setBounds(new Rectangle(597, 74, 270, 19));
        this.add(contfemaleMaterial, null);
        contweedoutMaterial.setBounds(new Rectangle(323, 128, 270, 19));
        this.add(contweedoutMaterial, null);
        contgenerateType.setBounds(new Rectangle(323, 164, 270, 19));
        this.add(contgenerateType, null);
        contgenderType.setBounds(new Rectangle(32, 166, 270, 19));
        this.add(contgenderType, null);
        contbroodMaterial.setBounds(new Rectangle(32, 58, 270, 19));
        this.add(contbroodMaterial, null);
        contpreEggMaterial.setBounds(new Rectangle(32, 93, 270, 19));
        this.add(contpreEggMaterial, null);
        conteggMaterial.setBounds(new Rectangle(323, 93, 270, 19));
        this.add(conteggMaterial, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contmaterial
        contmaterial.setBoundEditor(prmtmaterial);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contbridMaterial
        contbridMaterial.setBoundEditor(prmtbridMaterial);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel4
        kDPanel4.setLayout(null);        kdtSeedEntry.setBounds(new Rectangle(3, 2, 543, 152));
        kdtSeedEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtSeedEntry,new com.kingdee.eas.farm.stocking.basedata.BreedDataSeedEntryInfo(),null,false);
        kDPanel4.add(kdtSeedEntry_detailPanel, null);
		kdtSeedEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("maleOrFemale",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel1
        kDPanel1.setLayout(null);        kdtEntry.setBounds(new Rectangle(4, 2, 543, 149));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.farm.stocking.basedata.BreedDataEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, null);
        //kDPanel2
        kDPanel2.setLayout(null);        kdtStageEntry.setBounds(new Rectangle(1, 1, 548, 151));
        kdtStageEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtStageEntry,new com.kingdee.eas.farm.stocking.basedata.BreedDataStageEntryInfo(),null,false);
        kDPanel2.add(kdtStageEntry_detailPanel, null);
		kdtStageEntry_detailPanel.addAddListener(new com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener() {
			public void beforeEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
				IObjectValue vo = event.getObjectValue();
vo.put("farmStage",new Integer(1));
			}
			public void afterEvent(com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent event) throws Exception {
			}
		});
        //kDPanel3
        kDPanel3.setLayout(null);        txtremark.setBounds(new Rectangle(3, 4, 544, 150));
        kDPanel3.add(txtremark, null);
        //contfemaleMaterial
        contfemaleMaterial.setBoundEditor(prmtfemaleMaterial);
        //contweedoutMaterial
        contweedoutMaterial.setBoundEditor(prmtweedoutMaterial);
        //contgenerateType
        contgenerateType.setBoundEditor(generateType);
        //contgenderType
        contgenderType.setBoundEditor(genderType);
        //contbroodMaterial
        contbroodMaterial.setBoundEditor(prmtbroodMaterial);
        //contpreEggMaterial
        contpreEggMaterial.setBoundEditor(prmtpreEggMaterial);
        //conteggMaterial
        conteggMaterial.setBoundEditor(prmteggMaterial);

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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("material", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtmaterial, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("bridMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtbridMaterial, "data");
		dataBinder.registerBinding("SeedEntry.seq", int.class, this.kdtSeedEntry, "seq.text");
		dataBinder.registerBinding("SeedEntry", com.kingdee.eas.farm.stocking.basedata.BreedDataSeedEntryInfo.class, this.kdtSeedEntry, "userObject");
		dataBinder.registerBinding("SeedEntry.material", java.lang.Object.class, this.kdtSeedEntry, "material.text");
		dataBinder.registerBinding("SeedEntry.materialName", String.class, this.kdtSeedEntry, "materialName.text");
		dataBinder.registerBinding("SeedEntry.model", String.class, this.kdtSeedEntry, "model.text");
		dataBinder.registerBinding("SeedEntry.maleOrFemale", com.kingdee.util.enums.Enum.class, this.kdtSeedEntry, "maleOrFemale.text");
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.farm.stocking.basedata.BreedDataEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.material", java.lang.Object.class, this.kdtEntry, "material.text");
		dataBinder.registerBinding("Entry.materialName", String.class, this.kdtEntry, "materialName.text");
		dataBinder.registerBinding("Entry.model", String.class, this.kdtEntry, "model.text");
		dataBinder.registerBinding("Entry.isQualified", boolean.class, this.kdtEntry, "isQualified.text");
		dataBinder.registerBinding("StageEntry.seq", int.class, this.kdtStageEntry, "seq.text");
		dataBinder.registerBinding("StageEntry", com.kingdee.eas.farm.stocking.basedata.BreedDataStageEntryInfo.class, this.kdtStageEntry, "userObject");
		dataBinder.registerBinding("StageEntry.farmStage", com.kingdee.util.enums.Enum.class, this.kdtStageEntry, "farmStage.text");
		dataBinder.registerBinding("StageEntry.week", int.class, this.kdtStageEntry, "week.text");
		dataBinder.registerBinding("StageEntry.days", int.class, this.kdtStageEntry, "days.text");
		dataBinder.registerBinding("StageEntry.endWeek", int.class, this.kdtStageEntry, "endWeek.text");
		dataBinder.registerBinding("StageEntry.endDays", int.class, this.kdtStageEntry, "endDays.text");
		dataBinder.registerBinding("remark", String.class, this.txtremark, "text");
		dataBinder.registerBinding("femaleMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtfemaleMaterial, "data");
		dataBinder.registerBinding("weedoutMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtweedoutMaterial, "data");
		dataBinder.registerBinding("generateType", com.kingdee.eas.farm.stocking.hatch.GenerateType.class, this.generateType, "selectedItem");
		dataBinder.registerBinding("genderType", com.kingdee.eas.farm.stocking.hatch.GenderType.class, this.genderType, "selectedItem");
		dataBinder.registerBinding("broodMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtbroodMaterial, "data");
		dataBinder.registerBinding("preEggMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmtpreEggMaterial, "data");
		dataBinder.registerBinding("eggMaterial", com.kingdee.eas.basedata.master.material.MaterialInfo.class, this.prmteggMaterial, "data");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.BreedDataEditUIHandler";
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
        this.editData = (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)ov;
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
		getValidateHelper().registerBindProperty("material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bridMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SeedEntry.maleOrFemale", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.isQualified", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.farmStage", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.endWeek", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StageEntry.endDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("femaleMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("weedoutMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("generateType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("genderType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("broodMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("preEggMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("eggMaterial", ValidateHelper.ON_SAVE);    		
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
     * output kdtSeedEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtSeedEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtSeedEntry.getColumn(colIndex).getKey())) {
kdtSeedEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtSeedEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtSeedEntry.getColumn(colIndex).getKey())) {
kdtSeedEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtSeedEntry.getCell(rowIndex,"material").getValue(),"model")));

}


    }

    /**
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"material").getValue(),"model")));

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
			sic.add(new SelectorItemInfo("material.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("material.id"));
        	sic.add(new SelectorItemInfo("material.number"));
        	sic.add(new SelectorItemInfo("material.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("bridMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("bridMaterial.id"));
        	sic.add(new SelectorItemInfo("bridMaterial.number"));
        	sic.add(new SelectorItemInfo("bridMaterial.name"));
		}
    	sic.add(new SelectorItemInfo("SeedEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedEntry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("SeedEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("SeedEntry.material.id"));
			sic.add(new SelectorItemInfo("SeedEntry.material.number"));
			sic.add(new SelectorItemInfo("SeedEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("SeedEntry.materialName"));
    	sic.add(new SelectorItemInfo("SeedEntry.model"));
    	sic.add(new SelectorItemInfo("SeedEntry.maleOrFemale"));
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.material.id"));
			sic.add(new SelectorItemInfo("Entry.material.number"));
			sic.add(new SelectorItemInfo("Entry.material.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.materialName"));
    	sic.add(new SelectorItemInfo("Entry.model"));
    	sic.add(new SelectorItemInfo("Entry.isQualified"));
    	sic.add(new SelectorItemInfo("StageEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StageEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("StageEntry.farmStage"));
    	sic.add(new SelectorItemInfo("StageEntry.week"));
    	sic.add(new SelectorItemInfo("StageEntry.days"));
    	sic.add(new SelectorItemInfo("StageEntry.endWeek"));
    	sic.add(new SelectorItemInfo("StageEntry.endDays"));
        sic.add(new SelectorItemInfo("remark"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("femaleMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("femaleMaterial.id"));
        	sic.add(new SelectorItemInfo("femaleMaterial.number"));
        	sic.add(new SelectorItemInfo("femaleMaterial.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("weedoutMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("weedoutMaterial.id"));
        	sic.add(new SelectorItemInfo("weedoutMaterial.number"));
        	sic.add(new SelectorItemInfo("weedoutMaterial.name"));
		}
        sic.add(new SelectorItemInfo("generateType"));
        sic.add(new SelectorItemInfo("genderType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("broodMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("broodMaterial.id"));
        	sic.add(new SelectorItemInfo("broodMaterial.number"));
        	sic.add(new SelectorItemInfo("broodMaterial.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("preEggMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("preEggMaterial.id"));
        	sic.add(new SelectorItemInfo("preEggMaterial.number"));
        	sic.add(new SelectorItemInfo("preEggMaterial.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("eggMaterial.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("eggMaterial.id"));
        	sic.add(new SelectorItemInfo("eggMaterial.number"));
        	sic.add(new SelectorItemInfo("eggMaterial.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.BreedDataFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.BreedDataFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractBreedDataEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractBreedDataEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "BreedDataEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.BreedDataEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedDataFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.BreedDataInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.BreedDataInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbridMaterial.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成体物料"});
		}
		for (int i=0,n=kdtSeedEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtSeedEntry.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料编码"});
			}
		}
		for (int i=0,n=kdtStageEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtStageEntry.getCell(i,"farmStage").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"阶段"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtweedoutMaterial.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"淘汰物料"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(generateType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"代系"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtSeedEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
vo.put("generateType","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}