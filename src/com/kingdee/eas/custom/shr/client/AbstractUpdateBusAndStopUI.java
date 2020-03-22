/**
 * output package name
 */
package com.kingdee.eas.custom.shr.client;

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
public abstract class AbstractUpdateBusAndStopUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractUpdateBusAndStopUI.class);
    protected com.kingdee.bos.ctrl.swing.KDButton clearAll;
    protected com.kingdee.bos.ctrl.swing.KDButton selectAll;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCheck;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enterDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enterDateTo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer IDCardNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer name;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer transformBus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer stop;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDButton Search;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer bus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer transformStop;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPerson;
    protected com.kingdee.bos.ctrl.swing.KDButton confirm;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker DatePickerFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker DatePickerTo;
    protected com.kingdee.bos.ctrl.swing.KDTextField textIDCardNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField textName;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxBus;
    protected com.kingdee.bos.ctrl.swing.KDTextField textNumber;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxStopList;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxBusList;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxStop;
    /**
     * output class constructor
     */
    public AbstractUpdateBusAndStopUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractUpdateBusAndStopUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.clearAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.selectAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCheck = new com.kingdee.bos.ctrl.swing.KDButton();
        this.enterDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.enterDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.IDCardNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.name = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.transformBus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.stop = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.Search = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.bus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.transformStop = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kdtPerson = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.confirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.DatePickerFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.DatePickerTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.textIDCardNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.textName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cBoxBus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.textNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.cboxStopList = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cboxBusList = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cBoxStop = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.clearAll.setName("clearAll");
        this.selectAll.setName("selectAll");
        this.btnCheck.setName("btnCheck");
        this.enterDateFrom.setName("enterDateFrom");
        this.enterDateTo.setName("enterDateTo");
        this.IDCardNum.setName("IDCardNum");
        this.name.setName("name");
        this.transformBus.setName("transformBus");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.stop.setName("stop");
        this.kDSeparator2.setName("kDSeparator2");
        this.Search.setName("Search");
        this.kDSeparator3.setName("kDSeparator3");
        this.bus.setName("bus");
        this.transformStop.setName("transformStop");
        this.kdtPerson.setName("kdtPerson");
        this.confirm.setName("confirm");
        this.DatePickerFrom.setName("DatePickerFrom");
        this.DatePickerTo.setName("DatePickerTo");
        this.textIDCardNum.setName("textIDCardNum");
        this.textName.setName("textName");
        this.cBoxBus.setName("cBoxBus");
        this.textNumber.setName("textNumber");
        this.cboxStopList.setName("cboxStopList");
        this.cboxBusList.setName("cboxBusList");
        this.cBoxStop.setName("cBoxStop");
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
        // clearAll		
        this.clearAll.setText(resHelper.getString("clearAll.text"));
        this.clearAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    clearAll_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // selectAll		
        this.selectAll.setText(resHelper.getString("selectAll.text"));
        this.selectAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    selectAll_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // btnCheck		
        this.btnCheck.setText(resHelper.getString("btnCheck.text"));
        this.btnCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    btnFilter_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // enterDateFrom		
        this.enterDateFrom.setBoundLabelText(resHelper.getString("enterDateFrom.boundLabelText"));		
        this.enterDateFrom.setBoundLabelUnderline(true);		
        this.enterDateFrom.setBoundLabelLength(100);
        // enterDateTo		
        this.enterDateTo.setBoundLabelText(resHelper.getString("enterDateTo.boundLabelText"));		
        this.enterDateTo.setBoundLabelUnderline(true);		
        this.enterDateTo.setBoundLabelLength(100);
        // IDCardNum		
        this.IDCardNum.setBoundLabelText(resHelper.getString("IDCardNum.boundLabelText"));		
        this.IDCardNum.setBoundLabelUnderline(true);		
        this.IDCardNum.setBoundLabelLength(100);
        // name		
        this.name.setBoundLabelText(resHelper.getString("name.boundLabelText"));		
        this.name.setBoundLabelUnderline(true);		
        this.name.setBoundLabelLength(100);
        // transformBus		
        this.transformBus.setBoundLabelText(resHelper.getString("transformBus.boundLabelText"));		
        this.transformBus.setBoundLabelUnderline(true);		
        this.transformBus.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // stop		
        this.stop.setBoundLabelText(resHelper.getString("stop.boundLabelText"));		
        this.stop.setBoundLabelUnderline(true);		
        this.stop.setBoundLabelLength(100);
        // kDSeparator2
        // Search		
        this.Search.setText(resHelper.getString("Search.text"));
        this.Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    Search_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kDSeparator3
        // bus		
        this.bus.setBoundLabelText(resHelper.getString("bus.boundLabelText"));		
        this.bus.setBoundLabelUnderline(true);		
        this.bus.setBoundLabelLength(100);
        // transformStop		
        this.transformStop.setBoundLabelText(resHelper.getString("transformStop.boundLabelText"));		
        this.transformStop.setBoundLabelUnderline(true);		
        this.transformStop.setBoundLabelLength(100);
        // kdtPerson
		String kdtPersonStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"isSelected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"IDCardNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"bus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"stop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"class\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{isSelected}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{IDCardNum}</t:Cell><t:Cell>$Resource{bus}</t:Cell><t:Cell>$Resource{stop}</t:Cell><t:Cell>$Resource{class}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPerson.setFormatXml(resHelper.translateString("kdtPerson",kdtPersonStrXML));

        

        // confirm		
        this.confirm.setText(resHelper.getString("confirm.text"));
        this.confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    confirm_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // DatePickerFrom
        // DatePickerTo
        // textIDCardNum
        // textName
        // cBoxBus		
        this.cBoxBus.setActionCommand("cBoxStopChange");
        // textNumber
        // cboxStopList		
        this.cboxStopList.setActionCommand("cboxStopList");
        // cboxBusList		
        this.cboxBusList.setActionCommand("cboxBusList");
        // cBoxStop		
        this.cBoxStop.setActionCommand("cboxBusChange");
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
        clearAll.setBounds(new Rectangle(145, 152, 73, 21));
        this.add(clearAll, new KDLayout.Constraints(145, 152, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        selectAll.setBounds(new Rectangle(49, 153, 73, 21));
        this.add(selectAll, new KDLayout.Constraints(49, 153, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        btnCheck.setBounds(new Rectangle(725, 93, 80, 31));
        this.add(btnCheck, new KDLayout.Constraints(725, 93, 80, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        enterDateFrom.setBounds(new Rectangle(712, 26, 270, 19));
        this.add(enterDateFrom, new KDLayout.Constraints(712, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        enterDateTo.setBounds(new Rectangle(712, 57, 270, 19));
        this.add(enterDateTo, new KDLayout.Constraints(712, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        IDCardNum.setBounds(new Rectangle(44, 96, 270, 19));
        this.add(IDCardNum, new KDLayout.Constraints(44, 96, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        name.setBounds(new Rectangle(375, 57, 270, 19));
        this.add(name, new KDLayout.Constraints(375, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        transformBus.setBounds(new Rectangle(54, 572, 270, 19));
        this.add(transformBus, new KDLayout.Constraints(54, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(375, 26, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(375, 26, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        stop.setBounds(new Rectangle(44, 57, 270, 19));
        this.add(stop, new KDLayout.Constraints(44, 57, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator2.setBounds(new Rectangle(7, 555, 1000, 8));
        this.add(kDSeparator2, new KDLayout.Constraints(7, 555, 1000, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        Search.setBounds(new Rectangle(857, 94, 80, 31));
        this.add(Search, new KDLayout.Constraints(857, 94, 80, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator3.setBounds(new Rectangle(5, 136, 998, 8));
        this.add(kDSeparator3, new KDLayout.Constraints(5, 136, 998, 8, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        bus.setBounds(new Rectangle(44, 24, 270, 19));
        this.add(bus, new KDLayout.Constraints(44, 24, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        transformStop.setBounds(new Rectangle(406, 572, 270, 19));
        this.add(transformStop, new KDLayout.Constraints(406, 572, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtPerson.setBounds(new Rectangle(24, 193, 971, 349));
        this.add(kdtPerson, new KDLayout.Constraints(24, 193, 971, 349, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        confirm.setBounds(new Rectangle(824, 572, 91, 26));
        this.add(confirm, new KDLayout.Constraints(824, 572, 91, 26, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_RIGHT));
        //enterDateFrom
        enterDateFrom.setBoundEditor(DatePickerFrom);
        //enterDateTo
        enterDateTo.setBoundEditor(DatePickerTo);
        //IDCardNum
        IDCardNum.setBoundEditor(textIDCardNum);
        //name
        name.setBoundEditor(textName);
        //transformBus
        transformBus.setBoundEditor(cBoxBus);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(textNumber);
        //stop
        stop.setBoundEditor(cboxStopList);
        //bus
        bus.setBoundEditor(cboxBusList);
        //transformStop
        transformStop.setBoundEditor(cBoxStop);

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
	    return "com.kingdee.eas.custom.shr.app.UpdateBusAndStopUIHandler";
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
     * output clearAll_mouseClicke method
     */
    protected void clearAll_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output selectAll_mouseClicke method
     */
    protected void selectAll_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output btnFilter_mouseClicke method
     */
    protected void btnFilter_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output Search_mouseClicke method
     */
    protected void Search_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }

    /**
     * output confirm_mouseClicke method
     */
    protected void confirm_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.shr.client", "UpdateBusAndStopUI");
    }




}