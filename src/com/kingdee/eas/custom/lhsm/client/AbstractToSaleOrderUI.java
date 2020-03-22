/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

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
public abstract class AbstractToSaleOrderUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractToSaleOrderUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSaleOrg;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtOrdersTable;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtForecastTable;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSalePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterial;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAllInsert;
    protected com.kingdee.bos.ctrl.swing.KDButton btnInsert;
    protected com.kingdee.bos.ctrl.swing.KDButton btnRemove;
    protected com.kingdee.bos.ctrl.swing.KDButton btAddOrder;
    protected com.kingdee.bos.ctrl.swing.KDButton btSaveOrders;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDButton btnOpenOrderBill;
    protected com.kingdee.bos.ctrl.swing.KDButton btnViewPrice;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtRemark;
    /**
     * output class constructor
     */
    public AbstractToSaleOrderUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractToSaleOrderUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contCustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSaleOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtOrdersTable = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtForecastTable = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.prmtCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSalePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAllInsert = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnInsert = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnRemove = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btAddOrder = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btSaveOrders = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnOpenOrderBill = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnViewPrice = new com.kingdee.bos.ctrl.swing.KDButton();
        this.txtRemark = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contCustomer.setName("contCustomer");
        this.contSaleOrg.setName("contSaleOrg");
        this.kdtOrdersTable.setName("kdtOrdersTable");
        this.kdtForecastTable.setName("kdtForecastTable");
        this.kDTable1.setName("kDTable1");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.btnQuery.setName("btnQuery");
        this.kDPanel1.setName("kDPanel1");
        this.prmtCustomer.setName("prmtCustomer");
        this.prmtSalePerson.setName("prmtSalePerson");
        this.prmtCompany.setName("prmtCompany");
        this.prmtMaterial.setName("prmtMaterial");
        this.btnAllInsert.setName("btnAllInsert");
        this.btnInsert.setName("btnInsert");
        this.btnRemove.setName("btnRemove");
        this.btAddOrder.setName("btAddOrder");
        this.btSaveOrders.setName("btSaveOrders");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.btnOpenOrderBill.setName("btnOpenOrderBill");
        this.btnViewPrice.setName("btnViewPrice");
        this.txtRemark.setName("txtRemark");
        // CoreUI
        // contCustomer		
        this.contCustomer.setBoundLabelText(resHelper.getString("contCustomer.boundLabelText"));		
        this.contCustomer.setBoundLabelLength(100);		
        this.contCustomer.setEnabled(false);		
        this.contCustomer.setBoundLabelUnderline(true);
        // contSaleOrg		
        this.contSaleOrg.setBoundLabelText(resHelper.getString("contSaleOrg.boundLabelText"));		
        this.contSaleOrg.setBoundLabelLength(100);		
        this.contSaleOrg.setEnabled(false);		
        this.contSaleOrg.setBoundLabelUnderline(true);
        // kdtOrdersTable
		String kdtOrdersTableStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol12\"><c:Protection locked=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"status\" t:width=\"40\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"entryid\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"material\" t:width=\"150\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"companyInv\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"company\" t:width=\"200\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"saleOrder\" t:width=\"200\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{status}</t:Cell><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{entryid}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{companyInv}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{saleOrder}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtOrdersTable.setFormatXml(resHelper.translateString("kdtOrdersTable",kdtOrdersTableStrXML));

        

        // kdtForecastTable
		String kdtForecastTableStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"entryID\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"materialID\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" t:styleID=\"sCol2\" /><t:Column t:key=\"status\" t:width=\"40\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"company\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" t:styleID=\"sCol4\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"unitID\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" t:styleID=\"sCol10\" /><t:Column t:key=\"qtya\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"qtyb\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"companyqty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{entryID}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{status}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{unitID}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{qtya}</t:Cell><t:Cell>$Resource{qtyb}</t:Cell><t:Cell>$Resource{remark}</t:Cell><t:Cell>$Resource{companyqty}</t:Cell><t:Cell>$Resource{seq}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtForecastTable.setFormatXml(resHelper.translateString("kdtForecastTable",kdtForecastTableStrXML));

        

        // kDTable1

        

        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        // kDPanel1
        // prmtCustomer		
        this.prmtCustomer.setEnabled(false);
        // prmtSalePerson		
        this.prmtSalePerson.setEnabled(false);
        // prmtCompany
        // prmtMaterial
        // btnAllInsert		
        this.btnAllInsert.setText(resHelper.getString("btnAllInsert.text"));
        // btnInsert		
        this.btnInsert.setText(resHelper.getString("btnInsert.text"));
        // btnRemove		
        this.btnRemove.setText(resHelper.getString("btnRemove.text"));
        this.btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnRemove_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btAddOrder		
        this.btAddOrder.setText(resHelper.getString("btAddOrder.text"));
        this.btAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btAddOrder_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btSaveOrders		
        this.btSaveOrders.setText(resHelper.getString("btSaveOrders.text"));
        this.btSaveOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btSaveOrders_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);
        // btnOpenOrderBill		
        this.btnOpenOrderBill.setText(resHelper.getString("btnOpenOrderBill.text"));
        // btnViewPrice		
        this.btnViewPrice.setText(resHelper.getString("btnViewPrice.text"));
        // txtRemark
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
        this.setBounds(new Rectangle(10, 10, 1100, 650));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1100, 650));
        contCustomer.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contCustomer, new KDLayout.Constraints(10, 10, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSaleOrg.setBounds(new Rectangle(350, 9, 270, 19));
        this.add(contSaleOrg, new KDLayout.Constraints(350, 9, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtOrdersTable.setBounds(new Rectangle(10, 438, 1080, 166));
        this.add(kdtOrdersTable, new KDLayout.Constraints(10, 438, 1080, 166, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtForecastTable.setBounds(new Rectangle(10, 230, 1080, 153));
        this.add(kdtForecastTable, new KDLayout.Constraints(10, 230, 1080, 153, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTable1.setBounds(new Rectangle(10, 72, 1080, 120));
        this.add(kDTable1, new KDLayout.Constraints(10, 72, 1080, 120, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer1.setBounds(new Rectangle(10, 40, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(10, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(350, 40, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(350, 40, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnQuery.setBounds(new Rectangle(683, 40, 73, 21));
        this.add(btnQuery, new KDLayout.Constraints(683, 40, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel1.setBounds(new Rectangle(13, 399, 1074, 28));
        this.add(kDPanel1, new KDLayout.Constraints(13, 399, 1074, 28, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contCustomer
        contCustomer.setBoundEditor(prmtCustomer);
        //contSaleOrg
        contSaleOrg.setBoundEditor(prmtSalePerson);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCompany);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtMaterial);
        //kDPanel1
        kDPanel1.setLayout(null);        btnAllInsert.setBounds(new Rectangle(4, 1, 100, 21));
        kDPanel1.add(btnAllInsert, null);
        btnInsert.setBounds(new Rectangle(112, 2, 100, 21));
        kDPanel1.add(btnInsert, null);
        btnRemove.setBounds(new Rectangle(224, 2, 100, 21));
        kDPanel1.add(btnRemove, null);
        btAddOrder.setBounds(new Rectangle(338, 2, 100, 21));
        kDPanel1.add(btAddOrder, null);
        btSaveOrders.setBounds(new Rectangle(453, 2, 100, 21));
        kDPanel1.add(btSaveOrders, null);
        kDLabelContainer3.setBounds(new Rectangle(568, 3, 300, 19));
        kDPanel1.add(kDLabelContainer3, null);
        btnOpenOrderBill.setBounds(new Rectangle(975, 3, 89, 21));
        kDPanel1.add(btnOpenOrderBill, null);
        btnViewPrice.setBounds(new Rectangle(880, 2, 82, 21));
        kDPanel1.add(btnViewPrice, null);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtRemark);

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
	    return "com.kingdee.eas.custom.lhsm.app.ToSaleOrderUIHandler";
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
     * output btnRemove_actionPerformed method
     */
    protected void btnRemove_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code hereaa
    }

    /**
     * output btAddOrder_actionPerformed method
     */
    protected void btAddOrder_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code hereas
    }

    /**
     * output btSaveOrders_actionPerformed method
     */
    protected void btSaveOrders_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code hereaa
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "ToSaleOrderUI");
    }




}