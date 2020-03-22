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
public abstract class AbstractForcastToNOrdersUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractForcastToNOrdersUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCustomer;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contStartTimeBegin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contEnddateBegin;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSaleOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSaleGroup;
    protected com.kingdee.bos.ctrl.swing.KDButton btQuery;
    protected com.kingdee.bos.ctrl.swing.KDButton btClear;
    protected com.kingdee.bos.ctrl.swing.KDButton btReject;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtForecastTable;
    protected com.kingdee.bos.ctrl.swing.KDButton btCloseForecast;
    protected com.kingdee.bos.ctrl.swing.KDButton btnViewInv;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisClose;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisError;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkischange;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkisaudit;
    protected com.kingdee.bos.ctrl.swing.KDButton btnImport;
    protected com.kingdee.bos.ctrl.swing.KDButton btnReturn;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCustomer;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSalePerson;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSaleGroup;
    /**
     * output class constructor
     */
    public AbstractForcastToNOrdersUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractForcastToNOrdersUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contCustomer = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contStartTimeBegin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contEnddateBegin = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSaleOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSaleGroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btClear = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btReject = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtForecastTable = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btCloseForecast = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnViewInv = new com.kingdee.bos.ctrl.swing.KDButton();
        this.chkisClose = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisError = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkischange = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkisaudit = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.btnImport = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnReturn = new com.kingdee.bos.ctrl.swing.KDButton();
        this.prmtCustomer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtSalePerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtSaleGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contCustomer.setName("contCustomer");
        this.contStartTimeBegin.setName("contStartTimeBegin");
        this.contEnddateBegin.setName("contEnddateBegin");
        this.contSaleOrg.setName("contSaleOrg");
        this.contSaleGroup.setName("contSaleGroup");
        this.btQuery.setName("btQuery");
        this.btClear.setName("btClear");
        this.btReject.setName("btReject");
        this.kdtForecastTable.setName("kdtForecastTable");
        this.btCloseForecast.setName("btCloseForecast");
        this.btnViewInv.setName("btnViewInv");
        this.chkisClose.setName("chkisClose");
        this.chkisError.setName("chkisError");
        this.chkischange.setName("chkischange");
        this.chkisaudit.setName("chkisaudit");
        this.btnImport.setName("btnImport");
        this.btnReturn.setName("btnReturn");
        this.prmtCustomer.setName("prmtCustomer");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.prmtSalePerson.setName("prmtSalePerson");
        this.prmtSaleGroup.setName("prmtSaleGroup");
        // CoreUI
        // contCustomer		
        this.contCustomer.setBoundLabelText(resHelper.getString("contCustomer.boundLabelText"));		
        this.contCustomer.setBoundLabelLength(100);		
        this.contCustomer.setBoundLabelUnderline(true);
        // contStartTimeBegin		
        this.contStartTimeBegin.setBoundLabelText(resHelper.getString("contStartTimeBegin.boundLabelText"));		
        this.contStartTimeBegin.setBoundLabelLength(100);		
        this.contStartTimeBegin.setBoundLabelUnderline(true);
        // contEnddateBegin		
        this.contEnddateBegin.setBoundLabelText(resHelper.getString("contEnddateBegin.boundLabelText"));		
        this.contEnddateBegin.setBoundLabelLength(100);		
        this.contEnddateBegin.setBoundLabelUnderline(true);
        // contSaleOrg		
        this.contSaleOrg.setBoundLabelText(resHelper.getString("contSaleOrg.boundLabelText"));		
        this.contSaleOrg.setBoundLabelLength(100);		
        this.contSaleOrg.setBoundLabelUnderline(true);
        // contSaleGroup		
        this.contSaleGroup.setBoundLabelText(resHelper.getString("contSaleGroup.boundLabelText"));		
        this.contSaleGroup.setBoundLabelLength(100);		
        this.contSaleGroup.setVisible(false);		
        this.contSaleGroup.setBoundLabelUnderline(true);
        // btQuery		
        this.btQuery.setText(resHelper.getString("btQuery.text"));
        this.btQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btClear		
        this.btClear.setText(resHelper.getString("btClear.text"));
        this.btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btClear_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btReject		
        this.btReject.setText(resHelper.getString("btReject.text"));
        this.btReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btReject_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kdtForecastTable
		String kdtForecastTableStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol1\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol7\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol13\"><c:Protection locked=\"true\" hidden=\"true\" /></c:Style><c:Style id=\"sCol15\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol16\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol17\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" t:styleID=\"sCol0\" /><t:Column t:key=\"entryID\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" t:styleID=\"sCol1\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"date\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" t:styleID=\"sCol3\" /><t:Column t:key=\"status\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"creator\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"salePerson\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"customerID\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" t:styleID=\"sCol7\" /><t:Column t:key=\"customer\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"linkman\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"tel\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"carryWay\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" /><t:Column t:key=\"abtract\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"materialID\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" t:styleID=\"sCol13\" /><t:Column t:key=\"companyname\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" t:styleID=\"sCol15\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" t:styleID=\"sCol16\" /><t:Column t:key=\"unitID\" t:width=\"0\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" t:styleID=\"sCol17\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"18\" /><t:Column t:key=\"price\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"19\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"20\" /><t:Column t:key=\"qtya\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"21\" /><t:Column t:key=\"qtyb\" t:width=\"-1\" t:mergeable=\"false\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"22\" /><t:Column t:key=\"company\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"23\" /><t:Column t:key=\"companyqty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"24\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{entryID}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{date}</t:Cell><t:Cell>$Resource{status}</t:Cell><t:Cell>$Resource{creator}</t:Cell><t:Cell>$Resource{salePerson}</t:Cell><t:Cell>$Resource{customerID}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{linkman}</t:Cell><t:Cell>$Resource{tel}</t:Cell><t:Cell>$Resource{carryWay}</t:Cell><t:Cell>$Resource{abtract}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{companyname}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{unitID}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{price}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{qtya}</t:Cell><t:Cell>$Resource{qtyb}</t:Cell><t:Cell>$Resource{company}</t:Cell><t:Cell>$Resource{companyqty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtForecastTable.setFormatXml(resHelper.translateString("kdtForecastTable",kdtForecastTableStrXML));

        

        // btCloseForecast		
        this.btCloseForecast.setText(resHelper.getString("btCloseForecast.text"));
        this.btCloseForecast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btCloseForecast_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnViewInv		
        this.btnViewInv.setText(resHelper.getString("btnViewInv.text"));
        // chkisClose		
        this.chkisClose.setText(resHelper.getString("chkisClose.text"));
        // chkisError		
        this.chkisError.setText(resHelper.getString("chkisError.text"));
        // chkischange		
        this.chkischange.setText(resHelper.getString("chkischange.text"));
        // chkisaudit		
        this.chkisaudit.setText(resHelper.getString("chkisaudit.text"));		
        this.chkisaudit.setRolloverEnabled(true);
        // btnImport		
        this.btnImport.setText(resHelper.getString("btnImport.text"));
        // btnReturn		
        this.btnReturn.setText(resHelper.getString("btnReturn.text"));
        // prmtCustomer
        // dpBeginDate
        // dpEndDate
        // prmtSalePerson
        // prmtSaleGroup		
        this.prmtSaleGroup.setVisible(false);
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
        this.setBounds(new Rectangle(10, 10, 1013, 650));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1013, 650));
        contCustomer.setBounds(new Rectangle(10, 10, 270, 19));
        this.add(contCustomer, new KDLayout.Constraints(10, 10, 270, 19, 0));
        contStartTimeBegin.setBounds(new Rectangle(10, 37, 270, 19));
        this.add(contStartTimeBegin, new KDLayout.Constraints(10, 37, 270, 19, 0));
        contEnddateBegin.setBounds(new Rectangle(349, 36, 270, 19));
        this.add(contEnddateBegin, new KDLayout.Constraints(349, 36, 270, 19, 0));
        contSaleOrg.setBounds(new Rectangle(350, 9, 270, 19));
        this.add(contSaleOrg, new KDLayout.Constraints(350, 9, 270, 19, 0));
        contSaleGroup.setBounds(new Rectangle(142, 100, 270, 19));
        this.add(contSaleGroup, new KDLayout.Constraints(142, 100, 270, 19, 0));
        btQuery.setBounds(new Rectangle(710, 60, 73, 21));
        this.add(btQuery, new KDLayout.Constraints(710, 60, 73, 21, 0));
        btClear.setBounds(new Rectangle(840, 30, 73, 21));
        this.add(btClear, new KDLayout.Constraints(840, 30, 73, 21, 0));
        btReject.setBounds(new Rectangle(710, 90, 73, 21));
        this.add(btReject, new KDLayout.Constraints(710, 90, 73, 21, 0));
        kdtForecastTable.setBounds(new Rectangle(12, 130, 980, 500));
        this.add(kdtForecastTable, new KDLayout.Constraints(12, 130, 980, 500, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btCloseForecast.setBounds(new Rectangle(840, 90, 73, 21));
        this.add(btCloseForecast, new KDLayout.Constraints(840, 90, 73, 21, 0));
        btnViewInv.setBounds(new Rectangle(14, 100, 95, 21));
        this.add(btnViewInv, new KDLayout.Constraints(14, 100, 95, 21, 0));
        chkisClose.setBounds(new Rectangle(10, 60, 137, 20));
        this.add(chkisClose, new KDLayout.Constraints(10, 60, 137, 20, 0));
        chkisError.setBounds(new Rectangle(160, 60, 140, 19));
        this.add(chkisError, new KDLayout.Constraints(160, 60, 140, 19, 0));
        chkischange.setBounds(new Rectangle(310, 60, 79, 19));
        this.add(chkischange, new KDLayout.Constraints(310, 60, 79, 19, 0));
        chkisaudit.setBounds(new Rectangle(420, 60, 140, 19));
        this.add(chkisaudit, new KDLayout.Constraints(420, 60, 140, 19, 0));
        btnImport.setBounds(new Rectangle(840, 60, 73, 21));
        this.add(btnImport, new KDLayout.Constraints(840, 60, 73, 21, 0));
        btnReturn.setBounds(new Rectangle(710, 30, 73, 21));
        this.add(btnReturn, new KDLayout.Constraints(710, 30, 73, 21, 0));
        //contCustomer
        contCustomer.setBoundEditor(prmtCustomer);
        //contStartTimeBegin
        contStartTimeBegin.setBoundEditor(dpBeginDate);
        //contEnddateBegin
        contEnddateBegin.setBoundEditor(dpEndDate);
        //contSaleOrg
        contSaleOrg.setBoundEditor(prmtSalePerson);
        //contSaleGroup
        contSaleGroup.setBoundEditor(prmtSaleGroup);

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
	    return "com.kingdee.eas.custom.lhsm.app.ForcastToNOrdersUIHandler";
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
     * output btQuery_actionPerformed method
     */
    protected void btQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btClear_actionPerformed method
     */
    protected void btClear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code hereaa
    }

    /**
     * output btReject_actionPerformed method
     */
    protected void btReject_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here0000
    }

    /**
     * output btCloseForecast_actionPerformed method
     */
    protected void btCloseForecast_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code hereaa
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.lhsm.client", "ForcastToNOrdersUI");
    }




}