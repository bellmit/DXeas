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
public abstract class AbstractSettlementEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettlementEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstartdate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contenddate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contduckamount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoilprice;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpolicyfreight;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoilstandprice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkstartdate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkenddate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDComboBox state;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtduckamount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoilprice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtpolicyfreight;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDE;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDE_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtME;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtME_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfrightfloat;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contoilfloat;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtfrightfloat;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtoilfloat;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCE;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtCE_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtoilstandprice;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton review;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton unreview;
    protected com.kingdee.eas.farm.feemanager.basedata.SettlementInfo editData = null;
    protected ActionReview actionReview = null;
    protected ActionUnreview actionUnreview = null;
    /**
     * output class constructor
     */
    public AbstractSettlementEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettlementEditUI.class.getName());
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
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstartdate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contenddate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contduckamount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoilprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpolicyfreight = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contoilstandprice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.pkstartdate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pkenddate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompanyOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.state = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtduckamount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtoilprice = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtpolicyfreight = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtDE = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtME = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contfrightfloat = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contoilfloat = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtfrightfloat = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtoilfloat = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kdtCE = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtoilstandprice = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.review = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.unreview = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contstartdate.setName("contstartdate");
        this.contenddate.setName("contenddate");
        this.contcompanyOrgUnit.setName("contcompanyOrgUnit");
        this.contstate.setName("contstate");
        this.contduckamount.setName("contduckamount");
        this.contoilprice.setName("contoilprice");
        this.contpolicyfreight.setName("contpolicyfreight");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contoilstandprice.setName("contoilstandprice");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.pkstartdate.setName("pkstartdate");
        this.pkenddate.setName("pkenddate");
        this.prmtcompanyOrgUnit.setName("prmtcompanyOrgUnit");
        this.state.setName("state");
        this.txtduckamount.setName("txtduckamount");
        this.prmtoilprice.setName("prmtoilprice");
        this.txtpolicyfreight.setName("txtpolicyfreight");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kdtDE.setName("kdtDE");
        this.kdtME.setName("kdtME");
        this.contfrightfloat.setName("contfrightfloat");
        this.contoilfloat.setName("contoilfloat");
        this.txtfrightfloat.setName("txtfrightfloat");
        this.txtoilfloat.setName("txtoilfloat");
        this.kdtCE.setName("kdtCE");
        this.prmtoilstandprice.setName("prmtoilstandprice");
        this.review.setName("review");
        this.unreview.setName("unreview");
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
        // contstartdate		
        this.contstartdate.setBoundLabelText(resHelper.getString("contstartdate.boundLabelText"));		
        this.contstartdate.setBoundLabelLength(100);		
        this.contstartdate.setBoundLabelUnderline(true);		
        this.contstartdate.setVisible(true);
        // contenddate		
        this.contenddate.setBoundLabelText(resHelper.getString("contenddate.boundLabelText"));		
        this.contenddate.setBoundLabelLength(100);		
        this.contenddate.setBoundLabelUnderline(true);		
        this.contenddate.setVisible(true);
        // contcompanyOrgUnit		
        this.contcompanyOrgUnit.setBoundLabelText(resHelper.getString("contcompanyOrgUnit.boundLabelText"));		
        this.contcompanyOrgUnit.setBoundLabelLength(100);		
        this.contcompanyOrgUnit.setBoundLabelUnderline(true);		
        this.contcompanyOrgUnit.setVisible(true);
        // contstate		
        this.contstate.setBoundLabelText(resHelper.getString("contstate.boundLabelText"));		
        this.contstate.setBoundLabelLength(100);		
        this.contstate.setBoundLabelUnderline(true);		
        this.contstate.setVisible(true);
        // contduckamount		
        this.contduckamount.setBoundLabelText(resHelper.getString("contduckamount.boundLabelText"));		
        this.contduckamount.setBoundLabelLength(100);		
        this.contduckamount.setBoundLabelUnderline(true);		
        this.contduckamount.setVisible(true);
        // contoilprice		
        this.contoilprice.setBoundLabelText(resHelper.getString("contoilprice.boundLabelText"));		
        this.contoilprice.setBoundLabelLength(100);		
        this.contoilprice.setBoundLabelUnderline(true);		
        this.contoilprice.setVisible(true);
        // contpolicyfreight		
        this.contpolicyfreight.setBoundLabelText(resHelper.getString("contpolicyfreight.boundLabelText"));		
        this.contpolicyfreight.setBoundLabelLength(100);		
        this.contpolicyfreight.setBoundLabelUnderline(true);		
        this.contpolicyfreight.setVisible(true);
        // kDTabbedPane1
        // contoilstandprice		
        this.contoilstandprice.setBoundLabelText(resHelper.getString("contoilstandprice.boundLabelText"));		
        this.contoilstandprice.setBoundLabelLength(100);		
        this.contoilstandprice.setBoundLabelUnderline(true);		
        this.contoilstandprice.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setVisible(false);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);		
        this.txtSimpleName.setVisible(false);
        // txtDescription
        // pkstartdate		
        this.pkstartdate.setRequired(true);
        // pkenddate		
        this.pkenddate.setRequired(true);
        // prmtcompanyOrgUnit		
        this.prmtcompanyOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompanyOrgUnit.setEditable(true);		
        this.prmtcompanyOrgUnit.setDisplayFormat("$name$");		
        this.prmtcompanyOrgUnit.setEditFormat("$number$");		
        this.prmtcompanyOrgUnit.setCommitFormat("$number$");		
        this.prmtcompanyOrgUnit.setRequired(true);
        // state		
        this.state.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.state.setRequired(false);
        // txtduckamount		
        this.txtduckamount.setVisible(true);		
        this.txtduckamount.setHorizontalAlignment(2);		
        this.txtduckamount.setDataType(1);		
        this.txtduckamount.setSupportedEmpty(true);		
        this.txtduckamount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtduckamount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtduckamount.setPrecision(2);		
        this.txtduckamount.setRequired(true);
        // prmtoilprice		
        this.prmtoilprice.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.OilPriceQuery");		
        this.prmtoilprice.setVisible(true);		
        this.prmtoilprice.setEditable(true);		
        this.prmtoilprice.setDisplayFormat("$oilname$");		
        this.prmtoilprice.setEditFormat("$number$");		
        this.prmtoilprice.setCommitFormat("$number$");		
        this.prmtoilprice.setRequired(false);
        		prmtoilprice.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.OilPriceListUI prmtoilprice_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtoilprice_F7ListUI == null) {
					try {
						prmtoilprice_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.OilPriceListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtoilprice_F7ListUI));
					prmtoilprice_F7ListUI.setF7Use(true,ctx);
					prmtoilprice.setSelector(prmtoilprice_F7ListUI);
				}
			}
		});
					
        // txtpolicyfreight		
        this.txtpolicyfreight.setVisible(true);		
        this.txtpolicyfreight.setHorizontalAlignment(2);		
        this.txtpolicyfreight.setDataType(1);		
        this.txtpolicyfreight.setSupportedEmpty(true);		
        this.txtpolicyfreight.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtpolicyfreight.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtpolicyfreight.setPrecision(2);		
        this.txtpolicyfreight.setRequired(false);		
        this.txtpolicyfreight.setEnabled(false);
        // kDPanel4
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kdtDE
		String kdtDEStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"kilometerend\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"kilometertop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"subprice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{kilometerend}</t:Cell><t:Cell>$Resource{kilometertop}</t:Cell><t:Cell>$Resource{subprice}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDE.setFormatXml(resHelper.translateString("kdtDE",kdtDEStrXML));
        kdtDE.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtDE_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtDE.putBindContents("editData",new String[] {"seq","kilometerend","kilometertop","subprice"});


        this.kdtDE.checkParsed();
        KDFormattedTextField kdtDE_kilometerend_TextField = new KDFormattedTextField();
        kdtDE_kilometerend_TextField.setName("kdtDE_kilometerend_TextField");
        kdtDE_kilometerend_TextField.setVisible(true);
        kdtDE_kilometerend_TextField.setEditable(true);
        kdtDE_kilometerend_TextField.setHorizontalAlignment(2);
        kdtDE_kilometerend_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDE_kilometerend_CellEditor = new KDTDefaultCellEditor(kdtDE_kilometerend_TextField);
        this.kdtDE.getColumn("kilometerend").setEditor(kdtDE_kilometerend_CellEditor);
        KDFormattedTextField kdtDE_kilometertop_TextField = new KDFormattedTextField();
        kdtDE_kilometertop_TextField.setName("kdtDE_kilometertop_TextField");
        kdtDE_kilometertop_TextField.setVisible(true);
        kdtDE_kilometertop_TextField.setEditable(true);
        kdtDE_kilometertop_TextField.setHorizontalAlignment(2);
        kdtDE_kilometertop_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDE_kilometertop_CellEditor = new KDTDefaultCellEditor(kdtDE_kilometertop_TextField);
        this.kdtDE.getColumn("kilometertop").setEditor(kdtDE_kilometertop_CellEditor);
        KDFormattedTextField kdtDE_subprice_TextField = new KDFormattedTextField();
        kdtDE_subprice_TextField.setName("kdtDE_subprice_TextField");
        kdtDE_subprice_TextField.setVisible(true);
        kdtDE_subprice_TextField.setEditable(true);
        kdtDE_subprice_TextField.setHorizontalAlignment(2);
        kdtDE_subprice_TextField.setDataType(1);
        	kdtDE_subprice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDE_subprice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDE_subprice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDE_subprice_CellEditor = new KDTDefaultCellEditor(kdtDE_subprice_TextField);
        this.kdtDE.getColumn("subprice").setEditor(kdtDE_subprice_CellEditor);
        // kdtME
		String kdtMEStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtME.setFormatXml(resHelper.translateString("kdtME",kdtMEStrXML));
        kdtME.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtME_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtME.putBindContents("editData",new String[] {"seq","material","unit"});


        this.kdtME.checkParsed();
        final KDBizPromptBox kdtME_material_PromptBox = new KDBizPromptBox();
        kdtME_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtME_material_PromptBox.setVisible(true);
        kdtME_material_PromptBox.setEditable(true);
        kdtME_material_PromptBox.setDisplayFormat("$number$");
        kdtME_material_PromptBox.setEditFormat("$number$");
        kdtME_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtME_material_CellEditor = new KDTDefaultCellEditor(kdtME_material_PromptBox);
        this.kdtME.getColumn("material").setEditor(kdtME_material_CellEditor);
        ObjectValueRender kdtME_material_OVR = new ObjectValueRender();
        kdtME_material_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtME.getColumn("material").setRenderer(kdtME_material_OVR);
        KDTextField kdtME_unit_TextField = new KDTextField();
        kdtME_unit_TextField.setName("kdtME_unit_TextField");
        kdtME_unit_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtME_unit_CellEditor = new KDTDefaultCellEditor(kdtME_unit_TextField);
        this.kdtME.getColumn("unit").setEditor(kdtME_unit_CellEditor);
        // contfrightfloat		
        this.contfrightfloat.setBoundLabelText(resHelper.getString("contfrightfloat.boundLabelText"));		
        this.contfrightfloat.setBoundLabelLength(100);		
        this.contfrightfloat.setBoundLabelUnderline(true);		
        this.contfrightfloat.setVisible(true);
        // contoilfloat		
        this.contoilfloat.setBoundLabelText(resHelper.getString("contoilfloat.boundLabelText"));		
        this.contoilfloat.setBoundLabelLength(100);		
        this.contoilfloat.setBoundLabelUnderline(true);		
        this.contoilfloat.setVisible(true);
        // txtfrightfloat		
        this.txtfrightfloat.setVisible(true);		
        this.txtfrightfloat.setHorizontalAlignment(2);		
        this.txtfrightfloat.setDataType(1);		
        this.txtfrightfloat.setSupportedEmpty(true);		
        this.txtfrightfloat.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtfrightfloat.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtfrightfloat.setPrecision(2);		
        this.txtfrightfloat.setRequired(true);
        // txtoilfloat		
        this.txtoilfloat.setVisible(true);		
        this.txtoilfloat.setHorizontalAlignment(2);		
        this.txtoilfloat.setDataType(1);		
        this.txtoilfloat.setSupportedEmpty(true);		
        this.txtoilfloat.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtoilfloat.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtoilfloat.setPrecision(2);		
        this.txtoilfloat.setRequired(true);
        // kdtCE
		String kdtCEStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carsize\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"carsizetype\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"kilamount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{carsize}</t:Cell><t:Cell>$Resource{carsizetype}</t:Cell><t:Cell>$Resource{kilamount}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCE.setFormatXml(resHelper.translateString("kdtCE",kdtCEStrXML));
        kdtCE.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtCE_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtCE.putBindContents("editData",new String[] {"seq","carsize","carsizetype","kilamount"});


        this.kdtCE.checkParsed();
        final KDBizPromptBox kdtCE_carsize_PromptBox = new KDBizPromptBox();
        kdtCE_carsize_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");
        kdtCE_carsize_PromptBox.setVisible(true);
        kdtCE_carsize_PromptBox.setEditable(true);
        kdtCE_carsize_PromptBox.setDisplayFormat("$number$");
        kdtCE_carsize_PromptBox.setEditFormat("$number$");
        kdtCE_carsize_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCE_carsize_CellEditor = new KDTDefaultCellEditor(kdtCE_carsize_PromptBox);
        this.kdtCE.getColumn("carsize").setEditor(kdtCE_carsize_CellEditor);
        ObjectValueRender kdtCE_carsize_OVR = new ObjectValueRender();
        kdtCE_carsize_OVR.setFormat(new BizDataFormat("$carriagename$"));
        this.kdtCE.getColumn("carsize").setRenderer(kdtCE_carsize_OVR);
        			kdtCE_carsize_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI kdtCE_carsize_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtCE_carsize_PromptBox_F7ListUI == null) {
					try {
						kdtCE_carsize_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtCE_carsize_PromptBox_F7ListUI));
					kdtCE_carsize_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtCE_carsize_PromptBox.setSelector(kdtCE_carsize_PromptBox_F7ListUI);
				}
			}
		});
					
        KDTextField kdtCE_carsizetype_TextField = new KDTextField();
        kdtCE_carsizetype_TextField.setName("kdtCE_carsizetype_TextField");
        kdtCE_carsizetype_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtCE_carsizetype_CellEditor = new KDTDefaultCellEditor(kdtCE_carsizetype_TextField);
        this.kdtCE.getColumn("carsizetype").setEditor(kdtCE_carsizetype_CellEditor);
        KDFormattedTextField kdtCE_kilamount_TextField = new KDFormattedTextField();
        kdtCE_kilamount_TextField.setName("kdtCE_kilamount_TextField");
        kdtCE_kilamount_TextField.setVisible(true);
        kdtCE_kilamount_TextField.setEditable(true);
        kdtCE_kilamount_TextField.setHorizontalAlignment(2);
        kdtCE_kilamount_TextField.setDataType(1);
        	kdtCE_kilamount_TextField.setMinimumValue(new java.math.BigDecimal("-3.4028234663852886E38"));
        	kdtCE_kilamount_TextField.setMaximumValue(new java.math.BigDecimal("3.4028234663852886E38"));
        kdtCE_kilamount_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtCE_kilamount_CellEditor = new KDTDefaultCellEditor(kdtCE_kilamount_TextField);
        this.kdtCE.getColumn("kilamount").setEditor(kdtCE_kilamount_CellEditor);
        // prmtoilstandprice		
        this.prmtoilstandprice.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.OilStandPriceQuery");		
        this.prmtoilstandprice.setVisible(true);		
        this.prmtoilstandprice.setEditable(true);		
        this.prmtoilstandprice.setDisplayFormat("$oilname$");		
        this.prmtoilstandprice.setEditFormat("$number$");		
        this.prmtoilstandprice.setCommitFormat("$number$");		
        this.prmtoilstandprice.setRequired(true);
        		prmtoilstandprice.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.OilStandPriceListUI prmtoilstandprice_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtoilstandprice_F7ListUI == null) {
					try {
						prmtoilstandprice_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.OilStandPriceListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtoilstandprice_F7ListUI));
					prmtoilstandprice_F7ListUI.setF7Use(true,ctx);
					prmtoilstandprice.setSelector(prmtoilstandprice_F7ListUI);
				}
			}
		});
					
        // review
        this.review.setAction((IItemAction)ActionProxyFactory.getProxy(actionReview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.review.setText(resHelper.getString("review.text"));
        // unreview
        this.unreview.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnreview, new Class[] { IItemAction.class }, getServiceContext()));		
        this.unreview.setText(resHelper.getString("unreview.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtcompanyOrgUnit,state,pkstartdate,pkenddate,txtName,txtNumber,txtDescription,txtSimpleName,kdtME,kdtDE,txtduckamount,prmtoilprice,txtpolicyfreight,txtoilfloat,txtfrightfloat,prmtoilstandprice}));
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
        this.setBounds(new Rectangle(-1, -2, 715, 629));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(638, -100, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(31, 12, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(638, -44, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(638, -121, 270, 19));
        this.add(kDLabelContainer4, null);
        contstartdate.setBounds(new Rectangle(31, 85, 270, 19));
        this.add(contstartdate, null);
        contenddate.setBounds(new Rectangle(32, 123, 270, 19));
        this.add(contenddate, null);
        contcompanyOrgUnit.setBounds(new Rectangle(32, 44, 270, 19));
        this.add(contcompanyOrgUnit, null);
        contstate.setBounds(new Rectangle(335, 9, 270, 19));
        this.add(contstate, null);
        contduckamount.setBounds(new Rectangle(335, 43, 270, 19));
        this.add(contduckamount, null);
        contoilprice.setBounds(new Rectangle(-336, 84, 270, 19));
        this.add(contoilprice, null);
        contpolicyfreight.setBounds(new Rectangle(412, -144, 270, 19));
        this.add(contpolicyfreight, null);
        kDTabbedPane1.setBounds(new Rectangle(24, 168, 661, 445));
        this.add(kDTabbedPane1, null);
        contoilstandprice.setBounds(new Rectangle(335, 83, 270, 19));
        this.add(contoilstandprice, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contstartdate
        contstartdate.setBoundEditor(pkstartdate);
        //contenddate
        contenddate.setBoundEditor(pkenddate);
        //contcompanyOrgUnit
        contcompanyOrgUnit.setBoundEditor(prmtcompanyOrgUnit);
        //contstate
        contstate.setBoundEditor(state);
        //contduckamount
        contduckamount.setBoundEditor(txtduckamount);
        //contoilprice
        contoilprice.setBoundEditor(prmtoilprice);
        //contpolicyfreight
        contpolicyfreight.setBoundEditor(txtpolicyfreight);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel4
        kDPanel4.setLayout(null);        kdtCE.setBounds(new Rectangle(2, 3, 651, 408));
        kdtCE_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtCE,new com.kingdee.eas.farm.feemanager.basedata.SettlementCEInfo(),null,false);
        kDPanel4.add(kdtCE_detailPanel, null);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 660, 412));        kdtDE.setBounds(new Rectangle(3, 3, 647, 377));
        kdtDE_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDE,new com.kingdee.eas.farm.feemanager.basedata.SettlementDEInfo(),null,false);
        kDPanel1.add(kdtDE_detailPanel, new KDLayout.Constraints(3, 3, 647, 377, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 660, 412));        kdtME.setBounds(new Rectangle(3, 2, 649, 374));
        kdtME_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtME,new com.kingdee.eas.farm.feemanager.basedata.SettlementMEInfo(),null,false);
        kDPanel2.add(kdtME_detailPanel, new KDLayout.Constraints(3, 2, 649, 374, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(null);        contfrightfloat.setBounds(new Rectangle(51, 92, 270, 19));
        kDPanel3.add(contfrightfloat, null);
        contoilfloat.setBounds(new Rectangle(51, 41, 270, 19));
        kDPanel3.add(contoilfloat, null);
        //contfrightfloat
        contfrightfloat.setBoundEditor(txtfrightfloat);
        //contoilfloat
        contoilfloat.setBoundEditor(txtoilfloat);
        //contoilstandprice
        contoilstandprice.setBoundEditor(prmtoilstandprice);

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


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("startdate", java.util.Date.class, this.pkstartdate, "value");
		dataBinder.registerBinding("enddate", java.util.Date.class, this.pkenddate, "value");
		dataBinder.registerBinding("companyOrgUnit", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompanyOrgUnit, "data");
		dataBinder.registerBinding("state", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.state, "selectedItem");
		dataBinder.registerBinding("duckamount", java.math.BigDecimal.class, this.txtduckamount, "value");
		dataBinder.registerBinding("oilprice", com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo.class, this.prmtoilprice, "data");
		dataBinder.registerBinding("policyfreight", java.math.BigDecimal.class, this.txtpolicyfreight, "value");
		dataBinder.registerBinding("DE.seq", int.class, this.kdtDE, "seq.text");
		dataBinder.registerBinding("DE", com.kingdee.eas.farm.feemanager.basedata.SettlementDEInfo.class, this.kdtDE, "userObject");
		dataBinder.registerBinding("DE.kilometertop", int.class, this.kdtDE, "kilometertop.text");
		dataBinder.registerBinding("DE.kilometerend", int.class, this.kdtDE, "kilometerend.text");
		dataBinder.registerBinding("DE.subprice", java.math.BigDecimal.class, this.kdtDE, "subprice.text");
		dataBinder.registerBinding("ME.seq", int.class, this.kdtME, "seq.text");
		dataBinder.registerBinding("ME", com.kingdee.eas.farm.feemanager.basedata.SettlementMEInfo.class, this.kdtME, "userObject");
		dataBinder.registerBinding("ME.material", java.lang.Object.class, this.kdtME, "material.text");
		dataBinder.registerBinding("ME.unit", String.class, this.kdtME, "unit.text");
		dataBinder.registerBinding("frightfloat", java.math.BigDecimal.class, this.txtfrightfloat, "value");
		dataBinder.registerBinding("oilfloat", java.math.BigDecimal.class, this.txtoilfloat, "value");
		dataBinder.registerBinding("CE.seq", int.class, this.kdtCE, "seq.text");
		dataBinder.registerBinding("CE", com.kingdee.eas.farm.feemanager.basedata.SettlementCEInfo.class, this.kdtCE, "userObject");
		dataBinder.registerBinding("CE.carsize", java.lang.Object.class, this.kdtCE, "carsize.text");
		dataBinder.registerBinding("CE.carsizetype", String.class, this.kdtCE, "carsizetype.text");
		dataBinder.registerBinding("CE.kilamount", java.math.BigDecimal.class, this.kdtCE, "kilamount.text");
		dataBinder.registerBinding("oilstandprice", com.kingdee.eas.farm.feemanager.basedata.OilStandPriceInfo.class, this.prmtoilstandprice, "data");		
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
	    return "com.kingdee.eas.farm.feemanager.basedata.app.SettlementEditUIHandler";
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
        this.prmtcompanyOrgUnit.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.feemanager.basedata.SettlementInfo)ov;
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
		getValidateHelper().registerBindProperty("startdate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("enddate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("state", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("duckamount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oilprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("policyfreight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DE.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DE", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DE.kilometertop", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DE.kilometerend", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DE.subprice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ME.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ME", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ME.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ME.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("frightfloat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oilfloat", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CE.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CE", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CE.carsize", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CE.carsizetype", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CE.kilamount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("oilstandprice", ValidateHelper.ON_SAVE);    		
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
     * output kdtDE_Changed(int rowIndex,int colIndex) method
     */
    public void kdtDE_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("kilometertop".equalsIgnoreCase(kdtDE.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtDE.getCell(rowIndex,"kilometertop").getValue())< com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtDE.getCell(rowIndex,"kilometerend").getValue())) 
{
    com.kingdee.eas.util.client.MsgBox.showInfo(this,"运程上限不能低于运程下限！");com.kingdee.eas.util.SysUtil.abort();
}

}


    }

    /**
     * output kdtME_Changed(int rowIndex,int colIndex) method
     */
    public void kdtME_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtME.getColumn(colIndex).getKey())) {
kdtME.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtME.getCell(rowIndex,"material").getValue(),"baseUnit.name")));

}


    }

    /**
     * output kdtCE_Changed(int rowIndex,int colIndex) method
     */
    public void kdtCE_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("carsize".equalsIgnoreCase(kdtCE.getColumn(colIndex).getKey())) {
kdtCE.getCell(rowIndex,"carsizetype").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCE.getCell(rowIndex,"carsize").getValue(),"carriagesize")));

}

    if ("carsize".equalsIgnoreCase(kdtCE.getColumn(colIndex).getKey())) {
kdtCE.getCell(rowIndex,"kilamount").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtCE.getCell(rowIndex,"carsize").getValue(),"FKilpfreightkil")));

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
        sic.add(new SelectorItemInfo("startdate"));
        sic.add(new SelectorItemInfo("enddate"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyOrgUnit.id"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.number"));
        	sic.add(new SelectorItemInfo("companyOrgUnit.name"));
		}
        sic.add(new SelectorItemInfo("state"));
        sic.add(new SelectorItemInfo("duckamount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("oilprice.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("oilprice.id"));
        	sic.add(new SelectorItemInfo("oilprice.number"));
        	sic.add(new SelectorItemInfo("oilprice.name"));
        	sic.add(new SelectorItemInfo("oilprice.oilname"));
		}
        sic.add(new SelectorItemInfo("policyfreight"));
    	sic.add(new SelectorItemInfo("DE.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DE.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DE.kilometertop"));
    	sic.add(new SelectorItemInfo("DE.kilometerend"));
    	sic.add(new SelectorItemInfo("DE.subprice"));
    	sic.add(new SelectorItemInfo("ME.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ME.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ME.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("ME.material.id"));
			sic.add(new SelectorItemInfo("ME.material.name"));
        	sic.add(new SelectorItemInfo("ME.material.number"));
		}
    	sic.add(new SelectorItemInfo("ME.unit"));
        sic.add(new SelectorItemInfo("frightfloat"));
        sic.add(new SelectorItemInfo("oilfloat"));
    	sic.add(new SelectorItemInfo("CE.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CE.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("CE.carsize.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("CE.carsize.id"));
			sic.add(new SelectorItemInfo("CE.carsize.carriagename"));
			sic.add(new SelectorItemInfo("CE.carsize.name"));
        	sic.add(new SelectorItemInfo("CE.carsize.number"));
		}
    	sic.add(new SelectorItemInfo("CE.carsizetype"));
    	sic.add(new SelectorItemInfo("CE.kilamount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("oilstandprice.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("oilstandprice.id"));
        	sic.add(new SelectorItemInfo("oilstandprice.number"));
        	sic.add(new SelectorItemInfo("oilstandprice.name"));
        	sic.add(new SelectorItemInfo("oilstandprice.oilname"));
		}
        return sic;
    }        
    	

    /**
     * output actionReview_actionPerformed method
     */
    public void actionReview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.SettlementFactory.getRemoteInstance().review(editData);
    }
    	

    /**
     * output actionUnreview_actionPerformed method
     */
    public void actionUnreview_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.feemanager.basedata.SettlementFactory.getRemoteInstance().unreview(editData);
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
            innerActionPerformed("eas", AbstractSettlementEditUI.this, "ActionReview", "actionReview_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSettlementEditUI.this, "ActionUnreview", "actionUnreview_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.feemanager.basedata.client", "SettlementEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.feemanager.basedata.client.SettlementEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.SettlementFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.SettlementInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.SettlementInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkstartdate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"生效时间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pkenddate.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"失效时间"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtduckamount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"鸭苗补贴单价"});
		}
		for (int i=0,n=kdtME.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtME.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"物料"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfrightfloat.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"运费升降"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtoilfloat.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"油价升降"});
		}
		for (int i=0,n=kdtCE.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtCE.getCell(i,"carsize").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"车厢"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtoilstandprice.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"柴油标准单价"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtCE;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("state",new Integer(-1));
		vo.put("duckamount",new java.math.BigDecimal(0));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}