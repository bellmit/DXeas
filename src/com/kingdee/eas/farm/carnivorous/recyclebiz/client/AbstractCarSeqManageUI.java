/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

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
public abstract class AbstractCarSeqManageUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractCarSeqManageUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDButton cmb_OK;
    protected com.kingdee.bos.ctrl.swing.KDButton cmb_Cancel;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator3;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkBizDate;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtQty;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFarmer;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtFarm;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtPlanAverageWgt;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBatchContract;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtWeekDay;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBreedData;
    /**
     * output class constructor
     */
    public AbstractCarSeqManageUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractCarSeqManageUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.cmb_OK = new com.kingdee.bos.ctrl.swing.KDButton();
        this.cmb_Cancel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDSeparator3 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.pkBizDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.prmtFarmer = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtFarm = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtPlanAverageWgt = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.prmtBatchContract = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtWeekDay = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.prmtBreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDSeparator2.setName("kDSeparator2");
        this.cmb_OK.setName("cmb_OK");
        this.cmb_Cancel.setName("cmb_Cancel");
        this.kDSeparator3.setName("kDSeparator3");
        this.kdtEntrys.setName("kdtEntrys");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.pkBizDate.setName("pkBizDate");
        this.txtQty.setName("txtQty");
        this.prmtFarmer.setName("prmtFarmer");
        this.prmtFarm.setName("prmtFarm");
        this.txtPlanAverageWgt.setName("txtPlanAverageWgt");
        this.prmtBatchContract.setName("prmtBatchContract");
        this.txtWeekDay.setName("txtWeekDay");
        this.prmtBreedData.setName("prmtBreedData");
        // CoreUI		
        this.setPreferredSize(new Dimension(800,600));		
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
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setEnabled(false);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setEnabled(false);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelLength(100);		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setEnabled(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setEnabled(false);
        // kDSeparator2
        // cmb_OK		
        this.cmb_OK.setText(resHelper.getString("cmb_OK.text"));		
        this.cmb_OK.setMaximumSize(new Dimension(115,40));		
        this.cmb_OK.setMinimumSize(new Dimension(34,40));		
        this.cmb_OK.setPreferredSize(new Dimension(34,40));
        // cmb_Cancel		
        this.cmb_Cancel.setText(resHelper.getString("cmb_Cancel.text"));		
        this.cmb_Cancel.setMaximumSize(new Dimension(115,40));		
        this.cmb_Cancel.setMinimumSize(new Dimension(34,40));		
        this.cmb_Cancel.setPreferredSize(new Dimension(34,40));
        // kDSeparator3
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:NumberFormat>&amp;int</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat><c:Alignment horizontal=\"right\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"qty\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" t:styleID=\"sCol1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{qty}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));

        

        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(100);		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setEnabled(false);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(100);		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setEnabled(false);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelLength(100);		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setEnabled(false);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelLength(100);		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setEnabled(false);
        // pkBizDate		
        this.pkBizDate.setEnabled(false);
        // txtQty		
        this.txtQty.setEnabled(false);
        // prmtFarmer		
        this.prmtFarmer.setEnabled(false);
        // prmtFarm		
        this.prmtFarm.setEnabled(false);
        // txtPlanAverageWgt		
        this.txtPlanAverageWgt.setEnabled(false);
        // prmtBatchContract		
        this.prmtBatchContract.setEnabled(false);
        // txtWeekDay		
        this.txtWeekDay.setEnabled(false);
        // prmtBreedData		
        this.prmtBreedData.setEnabled(false);
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
        this.setBounds(new Rectangle(10, 10, 800, 600));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 800, 600));
        kDLabelContainer1.setBounds(new Rectangle(70, 31, 300, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(70, 31, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(70, 103, 300, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(70, 103, 300, 19, 0));
        kDLabelContainer3.setBounds(new Rectangle(70, 67, 300, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(70, 67, 300, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(405, 67, 300, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(405, 67, 300, 19, 0));
        kDSeparator2.setBounds(new Rectangle(-36, 554, 860, 9));
        this.add(kDSeparator2, new KDLayout.Constraints(-36, 554, 860, 9, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        cmb_OK.setBounds(new Rectangle(208, 564, 100, 30));
        this.add(cmb_OK, new KDLayout.Constraints(208, 564, 100, 30, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cmb_Cancel.setBounds(new Rectangle(442, 564, 100, 30));
        this.add(cmb_Cancel, new KDLayout.Constraints(442, 564, 100, 30, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator3.setBounds(new Rectangle(-3, 174, 800, 12));
        this.add(kDSeparator3, new KDLayout.Constraints(-3, 174, 800, 12, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntrys.setBounds(new Rectangle(65, 192, 589, 345));
        this.add(kdtEntrys, new KDLayout.Constraints(65, 192, 589, 345, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer5.setBounds(new Rectangle(405, 103, 300, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(405, 103, 300, 19, 0));
        kDLabelContainer6.setBounds(new Rectangle(70, 140, 300, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(70, 140, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer9.setBounds(new Rectangle(405, 140, 300, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(405, 140, 300, 19, 0));
        kDLabelContainer8.setBounds(new Rectangle(405, 31, 300, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(405, 31, 300, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(pkBizDate);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtQty);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(prmtFarmer);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(prmtFarm);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(txtPlanAverageWgt);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(prmtBatchContract);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(txtWeekDay);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(prmtBreedData);

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
	    return "com.kingdee.eas.farm.carnivorous.recyclebiz.app.CarSeqManageUIHandler";
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
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.client", "CarSeqManageUI");
    }




}