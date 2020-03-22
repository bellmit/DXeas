/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

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
public abstract class AbstractDiscountAdjustPlatform extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDiscountAdjustPlatform.class);
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbByDiscountQty;
    protected com.kingdee.bos.ctrl.swing.KDRadioButton rbByAllQty;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCancel;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAllSelect;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAllUnSelect;
    protected com.kingdee.bos.ctrl.swing.KDButtonGroup kDButtonGroup1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSearch;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbDiscountType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndTime;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cbAdjustType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPeriod;
    protected com.kingdee.bos.ctrl.swing.KDComboBox dbAdjustType;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBizDate;
    protected Search search = null;
    protected Confirm confirm = null;
    /**
     * output class constructor
     */
    public AbstractDiscountAdjustPlatform() throws Exception
    {
        super();
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractDiscountAdjustPlatform.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //search
        this.search = new Search(this);
        getActionManager().registerAction("search", search);
         this.search.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        //confirm
        this.confirm = new Confirm(this);
        getActionManager().registerAction("confirm", confirm);
         this.confirm.addService(new com.kingdee.eas.framework.client.service.PermissionService());
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.rbByDiscountQty = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.rbByAllQty = new com.kingdee.bos.ctrl.swing.KDRadioButton();
        this.btnCancel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAllSelect = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAllUnSelect = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDButtonGroup1 = new com.kingdee.bos.ctrl.swing.KDButtonGroup();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnSearch = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dpBeginTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cbDiscountType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.dpEndTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cbAdjustType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dbAdjustType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.dpBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1.setName("kDPanel1");
        this.kDTable1.setName("kDTable1");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.btnConfirm.setName("btnConfirm");
        this.rbByDiscountQty.setName("rbByDiscountQty");
        this.rbByAllQty.setName("rbByAllQty");
        this.btnCancel.setName("btnCancel");
        this.btnAllSelect.setName("btnAllSelect");
        this.btnAllUnSelect.setName("btnAllUnSelect");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.btnSearch.setName("btnSearch");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.prmtCompany.setName("prmtCompany");
        this.dpBeginTime.setName("dpBeginTime");
        this.cbDiscountType.setName("cbDiscountType");
        this.dpEndTime.setName("dpEndTime");
        this.cbAdjustType.setName("cbAdjustType");
        this.prmtPeriod.setName("prmtPeriod");
        this.dbAdjustType.setName("dbAdjustType");
        this.dpBizDate.setName("dpBizDate");
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
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol9\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.00}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.00}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>%r{0.00}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.0000}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol14\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.0000}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol15\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.00}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol16\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection locked=\"true\" /><c:NumberFormat>%r{0.00}f</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol19\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol20\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol21\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol22\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol23\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol24\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol25\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"selected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"customerNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"customerName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"groupID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"groupNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"groupName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"material\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"materialNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" t:styleID=\"sCol8\" /><t:Column t:key=\"materialName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" t:styleID=\"sCol9\" /><t:Column t:key=\"orderDSAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"adjustAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"confirmAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /><t:Column t:key=\"discountSaleQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"saleBaseQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" t:styleID=\"sCol14\" /><t:Column t:key=\"saleAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"vision\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"disRecordNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"disRecordAmount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" t:styleID=\"sCol18\" /><t:Column t:key=\"disRecordState\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" t:styleID=\"sCol19\" /><t:Column t:key=\"adjustType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" t:styleID=\"sCol20\" /><t:Column t:key=\"adjustor\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" t:styleID=\"sCol21\" /><t:Column t:key=\"disRecordCreateTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" t:styleID=\"sCol22\" /><t:Column t:key=\"disRecordBizdate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" t:styleID=\"sCol23\" /><t:Column t:key=\"disRecordID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"disRecordEntryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{customerNumber}</t:Cell><t:Cell>$Resource{customerName}</t:Cell><t:Cell>$Resource{groupID}</t:Cell><t:Cell>$Resource{groupNumber}</t:Cell><t:Cell>$Resource{groupName}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialNumber}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{orderDSAmount}</t:Cell><t:Cell>$Resource{adjustAmount}</t:Cell><t:Cell>$Resource{confirmAmount}</t:Cell><t:Cell>$Resource{discountSaleQty}</t:Cell><t:Cell>$Resource{saleBaseQty}</t:Cell><t:Cell>$Resource{saleAmount}</t:Cell><t:Cell>$Resource{vision}</t:Cell><t:Cell>$Resource{disRecordNumber}</t:Cell><t:Cell>$Resource{disRecordAmount}</t:Cell><t:Cell>$Resource{disRecordState}</t:Cell><t:Cell>$Resource{adjustType}</t:Cell><t:Cell>$Resource{adjustor}</t:Cell><t:Cell>$Resource{disRecordCreateTime}</t:Cell><t:Cell>$Resource{disRecordBizdate}</t:Cell><t:Cell>$Resource{disRecordID}</t:Cell><t:Cell>$Resource{disRecordEntryID}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));
        this.kDTable1.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kDTable1_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // btnConfirm
        this.btnConfirm.setAction((IItemAction)ActionProxyFactory.getProxy(confirm, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnConfirm.setText(resHelper.getString("btnConfirm.text"));
        // rbByDiscountQty		
        this.rbByDiscountQty.setText(resHelper.getString("rbByDiscountQty.text"));
        // rbByAllQty		
        this.rbByAllQty.setText(resHelper.getString("rbByAllQty.text"));
        // btnCancel		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));
        // btnAllSelect		
        this.btnAllSelect.setText(resHelper.getString("btnAllSelect.text"));
        // btnAllUnSelect		
        this.btnAllUnSelect.setText(resHelper.getString("btnAllUnSelect.text"));
        // kDButtonGroup1
        this.kDButtonGroup1.add(this.rbByDiscountQty);
        this.kDButtonGroup1.add(this.rbByAllQty);
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(100);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // btnSearch
        this.btnSearch.setAction((IItemAction)ActionProxyFactory.getProxy(search, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnSearch.setText(resHelper.getString("btnSearch.text"));
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelLength(100);		
        this.kDLabelContainer8.setBoundLabelUnderline(true);
        // prmtCompany		
        this.prmtCompany.setEnabled(false);
        // dpBeginTime
        this.dpBeginTime.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
            public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
                try {
                    dpBeginTime_dataChanged(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        // cbDiscountType
        // dpEndTime
        // cbAdjustType
        this.cbAdjustType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    cbAdjustType_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtPeriod
        // dbAdjustType		
        this.dbAdjustType.addItems(resHelper.getArray("dbAdjustType.items"));
        // dpBizDate
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
        kDPanel1.setBounds(new Rectangle(8, 6, 998, 129));
        this.add(kDPanel1, new KDLayout.Constraints(8, 6, 998, 129, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTable1.setBounds(new Rectangle(9, 139, 995, 443));
        this.add(kDTable1, new KDLayout.Constraints(9, 139, 995, 443, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer6.setBounds(new Rectangle(501, 594, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(501, 594, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnConfirm.setBounds(new Rectangle(786, 594, 99, 21));
        this.add(btnConfirm, new KDLayout.Constraints(786, 594, 99, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        rbByDiscountQty.setBounds(new Rectangle(191, 594, 140, 19));
        this.add(rbByDiscountQty, new KDLayout.Constraints(191, 594, 140, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        rbByAllQty.setBounds(new Rectangle(346, 594, 140, 19));
        this.add(rbByAllQty, new KDLayout.Constraints(346, 594, 140, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnCancel.setBounds(new Rectangle(903, 594, 99, 21));
        this.add(btnCancel, new KDLayout.Constraints(903, 594, 99, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnAllSelect.setBounds(new Rectangle(15, 594, 73, 21));
        this.add(btnAllSelect, new KDLayout.Constraints(15, 594, 73, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAllUnSelect.setBounds(new Rectangle(103, 594, 73, 21));
        this.add(btnAllUnSelect, new KDLayout.Constraints(103, 594, 73, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(8, 6, 998, 129));        kDLabelContainer1.setBounds(new Rectangle(21, 20, 270, 19));
        kDPanel1.add(kDLabelContainer1, new KDLayout.Constraints(21, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(21, 50, 270, 19));
        kDPanel1.add(kDLabelContainer2, new KDLayout.Constraints(21, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(360, 20, 270, 19));
        kDPanel1.add(kDLabelContainer3, new KDLayout.Constraints(360, 20, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(360, 50, 270, 19));
        kDPanel1.add(kDLabelContainer4, new KDLayout.Constraints(360, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(698, 19, 270, 19));
        kDPanel1.add(kDLabelContainer5, new KDLayout.Constraints(698, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnSearch.setBounds(new Rectangle(699, 49, 113, 21));
        kDPanel1.add(btnSearch, new KDLayout.Constraints(699, 49, 113, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(21, 80, 270, 19));
        kDPanel1.add(kDLabelContainer7, new KDLayout.Constraints(21, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(360, 80, 270, 19));
        kDPanel1.add(kDLabelContainer8, new KDLayout.Constraints(360, 80, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCompany);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(dpBeginTime);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(cbDiscountType);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(dpEndTime);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(cbAdjustType);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(prmtPeriod);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(dbAdjustType);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(dpBizDate);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuTool);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemPageSetup);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemCloudShare);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(menuItemExitCurrent);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
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
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(kDSeparatorCloud);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.salediscount.app.DiscountAdjustPlatformHandler";
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
    }

    /**
     * output kDTable1_editStopped method
     */
    protected void kDTable1_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output dpBeginTime_dataChanged method
     */
    protected void dpBeginTime_dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output cbAdjustType_actionPerformed method
     */
    protected void cbAdjustType_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    	

    /**
     * output search_actionPerformed method
     */
    public void search_actionPerformed(ActionEvent e) throws Exception
    {
    }
    	

    /**
     * output confirm_actionPerformed method
     */
    public void confirm_actionPerformed(ActionEvent e) throws Exception
    {
    }
	public RequestContext prepareSearch(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareSearch() {
    	return false;
    }
	public RequestContext prepareConfirm(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareConfirm() {
    	return false;
    }

    /**
     * output Search class
     */     
    protected class Search extends ItemAction {     
    
        public Search()
        {
            this(null);
        }

        public Search(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("Search.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("Search.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("Search.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountAdjustPlatform.this, "Search", "search_actionPerformed", e);
        }
    }

    /**
     * output Confirm class
     */     
    protected class Confirm extends ItemAction {     
    
        public Confirm()
        {
            this(null);
        }

        public Confirm(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            this.setEnabled(false);
            _tempStr = resHelper.getString("Confirm.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("Confirm.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("Confirm.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractDiscountAdjustPlatform.this, "Confirm", "confirm_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DiscountAdjustPlatform");
    }




}