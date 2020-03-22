/**
 * output package name
 */
package com.kingdee.eas.custom.shr;

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
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer bus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer stop;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer IDCardNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer number;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer name;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enterDateFrom;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer enterDateTo;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCheck;
    protected com.kingdee.bos.ctrl.swing.KDButton Search;
    protected com.kingdee.bos.ctrl.swing.KDButton clearAll;
    protected com.kingdee.bos.ctrl.swing.KDButton selectAll;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtPerson;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer transformBus;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer transformStop;
    protected com.kingdee.bos.ctrl.swing.KDButton Confirm;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxBusList;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cboxStopList;
    protected com.kingdee.bos.ctrl.swing.KDTextField textIDCardNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField textNumber;
    protected com.kingdee.bos.ctrl.swing.KDTextField textName;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker DatePickerFrom;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker DatePickerTo;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cBoxBus;
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
        this.bus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.stop = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.IDCardNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.number = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.name = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.enterDateFrom = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.enterDateTo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnCheck = new com.kingdee.bos.ctrl.swing.KDButton();
        this.Search = new com.kingdee.bos.ctrl.swing.KDButton();
        this.clearAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.selectAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtPerson = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.transformBus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.transformStop = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.Confirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.cboxBusList = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cboxStopList = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.textIDCardNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.textNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.textName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.DatePickerFrom = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.DatePickerTo = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.cBoxBus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cBoxStop = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.bus.setName("bus");
        this.stop.setName("stop");
        this.IDCardNum.setName("IDCardNum");
        this.number.setName("number");
        this.name.setName("name");
        this.enterDateFrom.setName("enterDateFrom");
        this.enterDateTo.setName("enterDateTo");
        this.btnCheck.setName("btnCheck");
        this.Search.setName("Search");
        this.clearAll.setName("clearAll");
        this.selectAll.setName("selectAll");
        this.kdtPerson.setName("kdtPerson");
        this.kDSeparator2.setName("kDSeparator2");
        this.transformBus.setName("transformBus");
        this.kDSeparator3.setName("kDSeparator3");
        this.transformStop.setName("transformStop");
        this.Confirm.setName("Confirm");
        this.cboxBusList.setName("cboxBusList");
        this.cboxStopList.setName("cboxStopList");
        this.textIDCardNum.setName("textIDCardNum");
        this.textNumber.setName("textNumber");
        this.textName.setName("textName");
        this.DatePickerFrom.setName("DatePickerFrom");
        this.DatePickerTo.setName("DatePickerTo");
        this.cBoxBus.setName("cBoxBus");
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
        // bus		
        this.bus.setBoundLabelText(resHelper.getString("bus.boundLabelText"));		
        this.bus.setBoundLabelUnderline(true);		
        this.bus.setBoundLabelLength(100);
        // stop		
        this.stop.setBoundLabelText(resHelper.getString("stop.boundLabelText"));		
        this.stop.setBoundLabelUnderline(true);		
        this.stop.setBoundLabelLength(100);
        // IDCardNum		
        this.IDCardNum.setBoundLabelText(resHelper.getString("IDCardNum.boundLabelText"));		
        this.IDCardNum.setBoundLabelUnderline(true);		
        this.IDCardNum.setBoundLabelLength(100);
        // number		
        this.number.setBoundLabelText(resHelper.getString("number.boundLabelText"));		
        this.number.setBoundLabelUnderline(true);		
        this.number.setBoundLabelLength(100);
        // name		
        this.name.setBoundLabelText(resHelper.getString("name.boundLabelText"));		
        this.name.setBoundLabelUnderline(true);		
        this.name.setBoundLabelLength(100);
        // enterDateFrom		
        this.enterDateFrom.setBoundLabelText(resHelper.getString("enterDateFrom.boundLabelText"));		
        this.enterDateFrom.setBoundLabelUnderline(true);		
        this.enterDateFrom.setBoundLabelLength(100);
        // enterDateTo		
        this.enterDateTo.setBoundLabelText(resHelper.getString("enterDateTo.boundLabelText"));		
        this.enterDateTo.setBoundLabelUnderline(true);		
        this.enterDateTo.setBoundLabelLength(100);
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
        // kdtPerson
		String kdtPersonStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"isSelected\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"0\" /><t:Column t:key=\"number\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"1\" /><t:Column t:key=\"name\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"2\" /><t:Column t:key=\"enterDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"IDCardNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"bus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"stop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"class\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{isSelected}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{name}</t:Cell><t:Cell>$Resource{enterDate}</t:Cell><t:Cell>$Resource{IDCardNum}</t:Cell><t:Cell>$Resource{bus}</t:Cell><t:Cell>$Resource{stop}</t:Cell><t:Cell>$Resource{class}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtPerson.setFormatXml(resHelper.translateString("kdtPerson",kdtPersonStrXML));

        

        // kDSeparator2
        // transformBus		
        this.transformBus.setBoundLabelText(resHelper.getString("transformBus.boundLabelText"));		
        this.transformBus.setBoundLabelUnderline(true);		
        this.transformBus.setBoundLabelLength(100);
        // kDSeparator3
        // transformStop		
        this.transformStop.setBoundLabelText(resHelper.getString("transformStop.boundLabelText"));		
        this.transformStop.setBoundLabelUnderline(true);		
        this.transformStop.setBoundLabelLength(100);
        // Confirm		
        this.Confirm.setText(resHelper.getString("Confirm.text"));
        this.Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                try {
                    Confirm_mouseClicke(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // cboxBusList		
        this.cboxBusList.setActionCommand("cboxBusList");
        // cboxStopList		
        this.cboxStopList.setActionCommand("cboxStopList");
        // textIDCardNum
        // textNumber
        // textName
        // DatePickerFrom
        // DatePickerTo
        // cBoxBus		
        this.cBoxBus.setActionCommand("cBoxStopChange");
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
        bus.setBounds(new Rectangle(26, 25, 270, 19));
        this.add(bus, new KDLayout.Constraints(26, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        stop.setBounds(new Rectangle(26, 55, 270, 19));
        this.add(stop, new KDLayout.Constraints(26, 55, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        IDCardNum.setBounds(new Rectangle(26, 85, 270, 19));
        this.add(IDCardNum, new KDLayout.Constraints(26, 85, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        number.setBounds(new Rectangle(362, 25, 270, 19));
        this.add(number, new KDLayout.Constraints(362, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        name.setBounds(new Rectangle(362, 55, 270, 19));
        this.add(name, new KDLayout.Constraints(362, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        enterDateFrom.setBounds(new Rectangle(699, 25, 270, 19));
        this.add(enterDateFrom, new KDLayout.Constraints(699, 25, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        enterDateTo.setBounds(new Rectangle(699, 55, 270, 19));
        this.add(enterDateTo, new KDLayout.Constraints(699, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnCheck.setBounds(new Rectangle(712, 85, 80, 31));
        this.add(btnCheck, new KDLayout.Constraints(712, 85, 80, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        Search.setBounds(new Rectangle(842, 85, 80, 31));
        this.add(Search, new KDLayout.Constraints(842, 85, 80, 31, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        clearAll.setBounds(new Rectangle(120, 145, 73, 21));
        this.add(clearAll, new KDLayout.Constraints(120, 145, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        selectAll.setBounds(new Rectangle(32, 146, 73, 21));
        this.add(selectAll, new KDLayout.Constraints(32, 146, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        kdtPerson.setBounds(new Rectangle(16, 174, 971, 362));
        this.add(kdtPerson, new KDLayout.Constraints(16, 174, 971, 362, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDSeparator2.setBounds(new Rectangle(10, 127, 998, 8));
        this.add(kDSeparator2, new KDLayout.Constraints(10, 127, 998, 8, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        transformBus.setBounds(new Rectangle(31, 566, 270, 19));
        this.add(transformBus, new KDLayout.Constraints(31, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator3.setBounds(new Rectangle(-1, 547, 1000, 8));
        this.add(kDSeparator3, new KDLayout.Constraints(-1, 547, 1000, 8, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        transformStop.setBounds(new Rectangle(407, 566, 270, 19));
        this.add(transformStop, new KDLayout.Constraints(407, 566, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        Confirm.setBounds(new Rectangle(784, 566, 91, 26));
        this.add(Confirm, new KDLayout.Constraints(784, 566, 91, 26, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_RIGHT));
        //bus
        bus.setBoundEditor(cboxBusList);
        //stop
        stop.setBoundEditor(cboxStopList);
        //IDCardNum
        IDCardNum.setBoundEditor(textIDCardNum);
        //number
        number.setBoundEditor(textNumber);
        //name
        name.setBoundEditor(textName);
        //enterDateFrom
        enterDateFrom.setBoundEditor(DatePickerFrom);
        //enterDateTo
        enterDateTo.setBoundEditor(DatePickerTo);
        //transformBus
        transformBus.setBoundEditor(cBoxBus);
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
	    return "com.kingdee.eas.custom.shr.UpdateBusAndStopUIHandler";
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
     * output Confirm_mouseClicke method
     */
    protected void Confirm_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.shr", "UpdateBusAndStopUI");
    }




}