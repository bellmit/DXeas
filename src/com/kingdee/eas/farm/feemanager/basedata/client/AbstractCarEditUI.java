/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

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
public abstract class AbstractCarEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttare;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarSize;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverID;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriverphone;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contexcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsafestartdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsafeenddaste;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarOwner;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contownerCell;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contownerID;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbasketsNumber;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contgeneralAsstActType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txttare;
    protected com.kingdee.bos.ctrl.swing.KDComboBox carType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCarSize;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriverID;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtdriverphone;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkexcar;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksafestartdate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pksafeenddaste;
    protected com.kingdee.bos.ctrl.swing.KDComboBox carstate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarOwner;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtownerCell;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtownerID;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtbasketsNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtgeneralAsstActType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton review;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unreview;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.publicdata.CarInfo editData = null;
    protected ActionReview actionReview = null;
    protected ActionUnreview actionUnreview = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractCarEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionReview
        this.actionReview = new ActionReview(this);
        getActionManager().registerAction("actionReview", actionReview);
        this.actionReview.setExtendProperty("canForewarn", "true");
        this.actionReview.setExtendProperty("userDefined", "false");
        this.actionReview.setExtendProperty("isObjectUpdateLock", "false");
         this.actionReview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionReview.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnreview
        this.actionUnreview = new ActionUnreview(this);
        getActionManager().registerAction("actionUnreview", actionUnreview);
        this.actionUnreview.setExtendProperty("canForewarn", "true");
        this.actionUnreview.setExtendProperty("userDefined", "false");
        this.actionUnreview.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnreview.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnreview.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttare = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarSize = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriverphone = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contexcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsafestartdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contsafeenddaste = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcarOwner = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contownerCell = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contownerID = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contbasketsNumber = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contgeneralAsstActType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txttare = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.carType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtCarSize = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtdriverID = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtdriverphone = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkexcar = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pksafestartdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pksafeenddaste = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.carstate = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtcarOwner = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtownerCell = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtownerID = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbasketsNumber = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtgeneralAsstActType = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.review = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unreview = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.conttare.setName("conttare");
        this.contcarType.setName("contcarType");
        this.contCarSize.setName("contCarSize");
        this.contdriverID.setName("contdriverID");
        this.contdriverphone.setName("contdriverphone");
        this.contexcar.setName("contexcar");
        this.contsafestartdate.setName("contsafestartdate");
        this.contsafeenddaste.setName("contsafeenddaste");
        this.contcarstate.setName("contcarstate");
        this.contstate.setName("contstate");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contcarOwner.setName("contcarOwner");
        this.contownerCell.setName("contownerCell");
        this.contownerID.setName("contownerID");
        this.kdtEntry.setName("kdtEntry");
        this.contbasketsNumber.setName("contbasketsNumber");
        this.contgeneralAsstActType.setName("contgeneralAsstActType");
        this.contbaseStatus.setName("contbaseStatus");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txttare.setName("txttare");
        this.carType.setName("carType");
        this.prmtCarSize.setName("prmtCarSize");
        this.prmtdriverID.setName("prmtdriverID");
        this.txtdriverphone.setName("txtdriverphone");
        this.pkexcar.setName("pkexcar");
        this.pksafestartdate.setName("pksafestartdate");
        this.pksafeenddaste.setName("pksafeenddaste");
        this.carstate.setName("carstate");
        this.state.setName("state");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.txtcarOwner.setName("txtcarOwner");
        this.txtownerCell.setName("txtownerCell");
        this.txtownerID.setName("txtownerID");
        this.txtbasketsNumber.setName("txtbasketsNumber");
        this.prmtgeneralAsstActType.setName("prmtgeneralAsstActType");
        this.baseStatus.setName("baseStatus");
        this.review.setName("review");
        this.unreview.setName("unreview");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // conttare		
        this.conttare.setBoundLabelText(resHelper.getString("conttare.boundLabelText"));		
        this.conttare.setBoundLabelLength(100);		
        this.conttare.setBoundLabelUnderline(true);		
        this.conttare.setVisible(false);
        // contcarType		
        this.contcarType.setBoundLabelText(resHelper.getString("contcarType.boundLabelText"));		
        this.contcarType.setBoundLabelLength(100);		
        this.contcarType.setBoundLabelUnderline(true);		
        this.contcarType.setVisible(true);
        // contCarSize		
        this.contCarSize.setBoundLabelText(resHelper.getString("contCarSize.boundLabelText"));		
        this.contCarSize.setBoundLabelLength(100);		
        this.contCarSize.setBoundLabelUnderline(true);		
        this.contCarSize.setVisible(false);
        // contdriverID		
        this.contdriverID.setBoundLabelText(resHelper.getString("contdriverID.boundLabelText"));		
        this.contdriverID.setBoundLabelLength(100);		
        this.contdriverID.setBoundLabelUnderline(true);		
        this.contdriverID.setVisible(true);
        // contdriverphone		
        this.contdriverphone.setBoundLabelText(resHelper.getString("contdriverphone.boundLabelText"));		
        this.contdriverphone.setBoundLabelLength(100);		
        this.contdriverphone.setBoundLabelUnderline(true);		
        this.contdriverphone.setVisible(true);
        // contexcar		
        this.contexcar.setBoundLabelText(resHelper.getString("contexcar.boundLabelText"));		
        this.contexcar.setBoundLabelLength(100);		
        this.contexcar.setBoundLabelUnderline(true);		
        this.contexcar.setVisible(false);
        // contsafestartdate		
        this.contsafestartdate.setBoundLabelText(resHelper.getString("contsafestartdate.boundLabelText"));		
        this.contsafestartdate.setBoundLabelLength(100);		
        this.contsafestartdate.setBoundLabelUnderline(true);		
        this.contsafestartdate.setVisible(false);
        // contsafeenddaste		
        this.contsafeenddaste.setBoundLabelText(resHelper.getString("contsafeenddaste.boundLabelText"));		
        this.contsafeenddaste.setBoundLabelLength(100);		
        this.contsafeenddaste.setBoundLabelUnderline(true);		
        this.contsafeenddaste.setVisible(false);
        // contcarstate		
        this.contcarstate.setBoundLabelText(resHelper.getString("contcarstate.boundLabelText"));		
        this.contcarstate.setBoundLabelLength(100);		
        this.contcarstate.setBoundLabelUnderline(true);		
        this.contcarstate.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contcarOwner		
        this.contcarOwner.setBoundLabelText(resHelper.getString("contcarOwner.boundLabelText"));		
        this.contcarOwner.setBoundLabelLength(100);		
        this.contcarOwner.setBoundLabelUnderline(true);		
        this.contcarOwner.setVisible(true);
        // contownerCell		
        this.contownerCell.setBoundLabelText(resHelper.getString("contownerCell.boundLabelText"));		
        this.contownerCell.setBoundLabelLength(100);		
        this.contownerCell.setBoundLabelUnderline(true);		
        this.contownerCell.setVisible(true);
        // contownerID		
        this.contownerID.setBoundLabelText(resHelper.getString("contownerID.boundLabelText"));		
        this.contownerID.setBoundLabelLength(100);		
        this.contownerID.setBoundLabelUnderline(true);		
        this.contownerID.setVisible(true);
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"driver\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"driverAge\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"driverID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"driverNative\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"isDefault\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{driver}</t:Cell><t:Cell>$Resource{driverAge}</t:Cell><t:Cell>$Resource{driverID}</t:Cell><t:Cell>$Resource{driverNative}</t:Cell><t:Cell>$Resource{isDefault}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","driver","driverAge","driverID","driverNative","isDefault"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_driver_PromptBox = new KDBizPromptBox();
        kdtEntry_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
        kdtEntry_driver_PromptBox.setVisible(true);
        kdtEntry_driver_PromptBox.setEditable(true);
        kdtEntry_driver_PromptBox.setDisplayFormat("$number$");
        kdtEntry_driver_PromptBox.setEditFormat("$number$");
        kdtEntry_driver_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_driver_CellEditor = new KDTDefaultCellEditor(kdtEntry_driver_PromptBox);
        this.kdtEntry.getColumn("driver").setEditor(kdtEntry_driver_CellEditor);
        ObjectValueRender kdtEntry_driver_OVR = new ObjectValueRender();
        kdtEntry_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
        this.kdtEntry.getColumn("driver").setRenderer(kdtEntry_driver_OVR);
        			kdtEntry_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntry_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_driver_PromptBox_F7ListUI));
					kdtEntry_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_driver_PromptBox.setSelector(kdtEntry_driver_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtEntry_driverAge_TextField = new KDTextField();
        kdtEntry_driverAge_TextField.setName("kdtEntry_driverAge_TextField");
        kdtEntry_driverAge_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_driverAge_CellEditor = new KDTDefaultCellEditor(kdtEntry_driverAge_TextField);
        this.kdtEntry.getColumn("driverAge").setEditor(kdtEntry_driverAge_CellEditor);
        KDTextField kdtEntry_driverID_TextField = new KDTextField();
        kdtEntry_driverID_TextField.setName("kdtEntry_driverID_TextField");
        kdtEntry_driverID_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_driverID_CellEditor = new KDTDefaultCellEditor(kdtEntry_driverID_TextField);
        this.kdtEntry.getColumn("driverID").setEditor(kdtEntry_driverID_CellEditor);
        KDTextField kdtEntry_driverNative_TextField = new KDTextField();
        kdtEntry_driverNative_TextField.setName("kdtEntry_driverNative_TextField");
        kdtEntry_driverNative_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_driverNative_CellEditor = new KDTDefaultCellEditor(kdtEntry_driverNative_TextField);
        this.kdtEntry.getColumn("driverNative").setEditor(kdtEntry_driverNative_CellEditor);
        KDCheckBox kdtEntry_isDefault_CheckBox = new KDCheckBox();
        kdtEntry_isDefault_CheckBox.setName("kdtEntry_isDefault_CheckBox");
        KDTDefaultCellEditor kdtEntry_isDefault_CellEditor = new KDTDefaultCellEditor(kdtEntry_isDefault_CheckBox);
        this.kdtEntry.getColumn("isDefault").setEditor(kdtEntry_isDefault_CellEditor);
        // contbasketsNumber		
        this.contbasketsNumber.setBoundLabelText(resHelper.getString("contbasketsNumber.boundLabelText"));		
        this.contbasketsNumber.setBoundLabelLength(100);		
        this.contbasketsNumber.setBoundLabelUnderline(true);		
        this.contbasketsNumber.setVisible(false);
        // contgeneralAsstActType		
        this.contgeneralAsstActType.setBoundLabelText(resHelper.getString("contgeneralAsstActType.boundLabelText"));		
        this.contgeneralAsstActType.setBoundLabelLength(100);		
        this.contgeneralAsstActType.setBoundLabelUnderline(true);		
        this.contgeneralAsstActType.setVisible(false);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // txttare		
        this.txttare.setVisible(false);		
        this.txttare.setHorizontalAlignment(2);		
        this.txttare.setDataType(1);		
        this.txttare.setSupportedEmpty(true);		
        this.txttare.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txttare.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txttare.setPrecision(4);		
        this.txttare.setRequired(false);
        // carType		
        this.carType.setVisible(true);		
        this.carType.addItems(EnumUtils.getEnumList("com.kingdee.eas.publicdata.CarType").toArray());		
        this.carType.setRequired(true);
        // prmtCarSize		
        this.prmtCarSize.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");		
        this.prmtCarSize.setVisible(false);		
        this.prmtCarSize.setEditable(true);		
        this.prmtCarSize.setDisplayFormat("$carriagename$");		
        this.prmtCarSize.setEditFormat("$number$");		
        this.prmtCarSize.setCommitFormat("$number$");		
        this.prmtCarSize.setRequired(false);
        		prmtCarSize.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI prmtCarSize_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtCarSize_F7ListUI == null) {
					try {
						prmtCarSize_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtCarSize_F7ListUI));
					prmtCarSize_F7ListUI.setF7Use(true,ctx);
					prmtCarSize.setSelector(prmtCarSize_F7ListUI);
				}
			}
		});
					
        // prmtdriverID		
        this.prmtdriverID.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriverID.setVisible(true);		
        this.prmtdriverID.setEditable(true);		
        this.prmtdriverID.setDisplayFormat("$drivername$");		
        this.prmtdriverID.setEditFormat("$number$");		
        this.prmtdriverID.setCommitFormat("$number$");		
        this.prmtdriverID.setRequired(false);
        		prmtdriverID.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriverID_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriverID_F7ListUI == null) {
					try {
						prmtdriverID_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriverID_F7ListUI));
					prmtdriverID_F7ListUI.setF7Use(true,ctx);
					prmtdriverID.setSelector(prmtdriverID_F7ListUI);
				}
			}
		});
					
        prmtdriverID.addDataChangeListener(new DataChangeListener() {
		public void dataChanged(DataChangeEvent e) {
			try {
				prmtdriverID_Changed();
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});

        // txtdriverphone		
        this.txtdriverphone.setVisible(true);		
        this.txtdriverphone.setHorizontalAlignment(2);		
        this.txtdriverphone.setMaxLength(80);		
        this.txtdriverphone.setRequired(false);
        // pkexcar		
        this.pkexcar.setVisible(false);		
        this.pkexcar.setRequired(false);
        // pksafestartdate		
        this.pksafestartdate.setVisible(false);		
        this.pksafestartdate.setRequired(false);
        // pksafeenddaste		
        this.pksafeenddaste.setVisible(false);		
        this.pksafeenddaste.setRequired(false);
        // carstate		
        this.carstate.setVisible(true);		
        this.carstate.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.feemanager.basedata.CarState").toArray());		
        this.carstate.setRequired(false);
        // state		
        this.state.setVisible(true);		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.state.setRequired(false);		
        this.state.setEnabled(false);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setVisible(true);		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // txtcarOwner		
        this.txtcarOwner.setVisible(true);		
        this.txtcarOwner.setHorizontalAlignment(2);		
        this.txtcarOwner.setMaxLength(100);		
        this.txtcarOwner.setRequired(false);
        // txtownerCell		
        this.txtownerCell.setVisible(true);		
        this.txtownerCell.setHorizontalAlignment(2);		
        this.txtownerCell.setMaxLength(100);		
        this.txtownerCell.setRequired(false);
        // txtownerID		
        this.txtownerID.setVisible(true);		
        this.txtownerID.setHorizontalAlignment(2);		
        this.txtownerID.setMaxLength(100);		
        this.txtownerID.setRequired(false);
        // txtbasketsNumber		
        this.txtbasketsNumber.setHorizontalAlignment(2);		
        this.txtbasketsNumber.setDataType(1);		
        this.txtbasketsNumber.setSupportedEmpty(true);		
        this.txtbasketsNumber.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtbasketsNumber.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtbasketsNumber.setPrecision(4);		
        this.txtbasketsNumber.setRequired(false);		
        this.txtbasketsNumber.setVisible(false);
        // prmtgeneralAsstActType		
        this.prmtgeneralAsstActType.setQueryInfo("com.kingdee.eas.basedata.master.auxacct.app.F7GeneralAsstActTypeQuery");		
        this.prmtgeneralAsstActType.setVisible(false);		
        this.prmtgeneralAsstActType.setEditable(true);		
        this.prmtgeneralAsstActType.setDisplayFormat("$name$");		
        this.prmtgeneralAsstActType.setEditFormat("$number$");		
        this.prmtgeneralAsstActType.setCommitFormat("$number$");		
        this.prmtgeneralAsstActType.setRequired(false);
        // baseStatus		
        this.baseStatus.setVisible(true);		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // review
        this.review.setAction((IItemAction)ActionProxyFactory.getProxy(actionReview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.review.setText(resHelper.getString("review.text"));
        // unreview
        this.unreview.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnreview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unreview.setText(resHelper.getString("unreview.text"));
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txttare,carType,prmtCarSize,prmtdriverID,txtdriverphone,pkexcar,pksafestartdate,pksafeenddaste,txtSimpleName,txtDescription,txtNumber,txtName,carstate,state,prmtcompanyOrgUnit,txtcarOwner,txtownerCell,txtownerID,txtbasketsNumber,prmtgeneralAsstActType,baseStatus}));
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
        this.setBounds(new Rectangle(0, 0, 681, 511));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(37, 92, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(389, 130, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(411, -433, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(37, 160, 270, 19));
        this.add(kDLabelContainer4, null);
        conttare.setBounds(new Rectangle(389, 228, 270, 19));
        this.add(conttare, null);
        contcarType.setBounds(new Rectangle(37, 24, 270, 19));
        this.add(contcarType, null);
        contCarSize.setBounds(new Rectangle(647, 320, 270, 19));
        this.add(contCarSize, null);
        contdriverID.setBounds(new Rectangle(389, 262, 270, 19));
        this.add(contdriverID, null);
        contdriverphone.setBounds(new Rectangle(37, 262, 270, 19));
        this.add(contdriverphone, null);
        contexcar.setBounds(new Rectangle(389, 160, 270, 19));
        this.add(contexcar, null);
        contsafestartdate.setBounds(new Rectangle(37, 227, 270, 19));
        this.add(contsafestartdate, null);
        contsafeenddaste.setBounds(new Rectangle(389, 194, 270, 19));
        this.add(contsafeenddaste, null);
        contcarstate.setBounds(new Rectangle(37, 130, 270, 19));
        this.add(contcarstate, null);
        contstate.setBounds(new Rectangle(409, -398, 270, 19));
        this.add(contstate, null);
        contcompanyOrgUnit.setBounds(new Rectangle(37, 58, 270, 19));
        this.add(contcompanyOrgUnit, null);
        contcarOwner.setBounds(new Rectangle(389, 24, 270, 19));
        this.add(contcarOwner, null);
        contownerCell.setBounds(new Rectangle(389, 58, 270, 19));
        this.add(contownerCell, null);
        contownerID.setBounds(new Rectangle(389, 92, 270, 19));
        this.add(contownerID, null);
        kdtEntry.setBounds(new Rectangle(32, 347, 624, 143));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.publicdata.CarEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, null);
        contbasketsNumber.setBounds(new Rectangle(395, 296, 270, 19));
        this.add(contbasketsNumber, null);
        contgeneralAsstActType.setBounds(new Rectangle(37, 295, 270, 19));
        this.add(contgeneralAsstActType, null);
        contbaseStatus.setBounds(new Rectangle(37, 194, 270, 19));
        this.add(contbaseStatus, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //conttare
        conttare.setBoundEditor(txttare);
        //contcarType
        contcarType.setBoundEditor(carType);
        //contCarSize
        contCarSize.setBoundEditor(prmtCarSize);
        //contdriverID
        contdriverID.setBoundEditor(prmtdriverID);
        //contdriverphone
        contdriverphone.setBoundEditor(txtdriverphone);
        //contexcar
        contexcar.setBoundEditor(pkexcar);
        //contsafestartdate
        contsafestartdate.setBoundEditor(pksafestartdate);
        //contsafeenddaste
        contsafeenddaste.setBoundEditor(pksafeenddaste);
        //contcarstate
        contcarstate.setBoundEditor(carstate);
        //contstate
        contstate.setBoundEditor(state);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contcarOwner
        contcarOwner.setBoundEditor(txtcarOwner);
        //contownerCell
        contownerCell.setBoundEditor(txtownerCell);
        //contownerID
        contownerID.setBoundEditor(txtownerID);
        //contbasketsNumber
        contbasketsNumber.setBoundEditor(txtbasketsNumber);
        //contgeneralAsstActType
        contgeneralAsstActType.setBoundEditor(prmtgeneralAsstActType);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);

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
        this.toolBar.add(review);
        this.toolBar.add(unreview);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.publicdata.CarEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.driver", java.lang.Object.class, this.kdtEntry, "driver.text");
		dataBinder.registerBinding("Entry.driverAge", String.class, this.kdtEntry, "driverAge.text");
		dataBinder.registerBinding("Entry.driverID", String.class, this.kdtEntry, "driverID.text");
		dataBinder.registerBinding("Entry.driverNative", String.class, this.kdtEntry, "driverNative.text");
		dataBinder.registerBinding("Entry.isDefault", boolean.class, this.kdtEntry, "isDefault.text");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("tare", java.math.BigDecimal.class, this.txttare, "value");
		dataBinder.registerBinding("carType", com.kingdee.eas.publicdata.CarType.class, this.carType, "selectedItem");
		dataBinder.registerBinding("CarSize", com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo.class, this.prmtCarSize, "data");
		dataBinder.registerBinding("driverID", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriverID, "data");
		dataBinder.registerBinding("driverphone", String.class, this.txtdriverphone, "text");
		dataBinder.registerBinding("excar", java.util.Date.class, this.pkexcar, "value");
		dataBinder.registerBinding("safestartdate", java.util.Date.class, this.pksafestartdate, "value");
		dataBinder.registerBinding("safeenddaste", java.util.Date.class, this.pksafeenddaste, "value");
		dataBinder.registerBinding("carstate", com.kingdee.eas.farm.feemanager.basedata.CarState.class, this.carstate, "selectedItem");
		dataBinder.registerBinding("state", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("carOwner", String.class, this.txtcarOwner, "text");
		dataBinder.registerBinding("ownerCell", String.class, this.txtownerCell, "text");
		dataBinder.registerBinding("ownerID", String.class, this.txtownerID, "text");
		dataBinder.registerBinding("basketsNumber", java.math.BigDecimal.class, this.txtbasketsNumber, "value");
		dataBinder.registerBinding("generalAsstActType", com.kingdee.eas.basedata.master.auxacct.AsstAccountInfo.class, this.prmtgeneralAsstActType, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");		
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
	    return "com.kingdee.eas.farm.feemanager.basedata.app.CarEditUIHandler";
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
        this.txttare.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.publicdata.CarInfo)ov;
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
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.driverAge", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.driverID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.driverNative", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.isDefault", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarSize", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driverphone", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("excar", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("safestartdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("safeenddaste", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carstate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carOwner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ownerCell", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ownerID", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("basketsNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("generalAsstActType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("driver".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"driverAge").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"driver").getValue(),"driverage")));

}

    if ("driver".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"driverID").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"driver").getValue(),"drivercardid")));

}

    if ("driver".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"driverNative").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"driver").getValue(),"driverplace")));

}


    }

    /**
     * output prmtdriverID_Changed() method
     */
    public void prmtdriverID_Changed() throws Exception
    {
        System.out.println("prmtdriverID_Changed() Function is executed!");
            txtdriverphone.setText(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)prmtdriverID.getData(),"driverphone")));
;


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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.driver.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.driver.id"));
			sic.add(new SelectorItemInfo("Entry.driver.drivername"));
			sic.add(new SelectorItemInfo("Entry.driver.name"));
        	sic.add(new SelectorItemInfo("Entry.driver.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.driverAge"));
    	sic.add(new SelectorItemInfo("Entry.driverID"));
    	sic.add(new SelectorItemInfo("Entry.driverNative"));
    	sic.add(new SelectorItemInfo("Entry.isDefault"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
        sic.add(new SelectorItemInfo("tare"));
        sic.add(new SelectorItemInfo("carType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CarSize.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("CarSize.id"));
        	sic.add(new SelectorItemInfo("CarSize.number"));
        	sic.add(new SelectorItemInfo("CarSize.name"));
        	sic.add(new SelectorItemInfo("CarSize.carriagename"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("driverID.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("driverID.id"));
        	sic.add(new SelectorItemInfo("driverID.number"));
        	sic.add(new SelectorItemInfo("driverID.name"));
        	sic.add(new SelectorItemInfo("driverID.drivername"));
		}
        sic.add(new SelectorItemInfo("driverphone"));
        sic.add(new SelectorItemInfo("excar"));
        sic.add(new SelectorItemInfo("safestartdate"));
        sic.add(new SelectorItemInfo("safeenddaste"));
        sic.add(new SelectorItemInfo("carstate"));
        sic.add(new SelectorItemInfo("state"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("carOwner"));
        sic.add(new SelectorItemInfo("ownerCell"));
        sic.add(new SelectorItemInfo("ownerID"));
        sic.add(new SelectorItemInfo("basketsNumber"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("generalAsstActType.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("generalAsstActType.id"));
        	sic.add(new SelectorItemInfo("generalAsstActType.number"));
        	sic.add(new SelectorItemInfo("generalAsstActType.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
        return sic;
    }        
    	

    /**
     * output actionReview_actionPerformed method
     */
    public void actionReview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.publicdata.CarFactory.getRemoteInstance().review(editData);
    }
    	

    /**
     * output actionUnreview_actionPerformed method
     */
    public void actionUnreview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.publicdata.CarFactory.getRemoteInstance().unreview(editData);
    }
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.publicdata.CarFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.publicdata.CarFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionReview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionReview() {
    	return false;
    }
	public RequestContext prepareActionUnreview(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnreview() {
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
     * output ActionReview class
     */     
    protected class ActionReview extends ItemAction {     
    
        public ActionReview()
        {
            this(null);
        }

        public ActionReview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionReview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionReview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCarEditUI.this, "ActionReview", "actionReview_actionPerformed", e);
        }
    }

    /**
     * output ActionUnreview class
     */     
    protected class ActionUnreview extends ItemAction {     
    
        public ActionUnreview()
        {
            this(null);
        }

        public ActionUnreview(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnreview.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnreview.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnreview.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractCarEditUI.this, "ActionUnreview", "actionUnreview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCarEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractCarEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basedata.client", "CarEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.CarEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.publicdata.CarFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.publicdata.CarInfo objectValue = new com.kingdee.eas.publicdata.CarInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(carType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车辆类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("carType","1");
vo.put("carstate","2");
vo.put("state",new Integer(-1));
vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}