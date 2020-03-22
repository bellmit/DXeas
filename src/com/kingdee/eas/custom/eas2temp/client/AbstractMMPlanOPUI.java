/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

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
public abstract class AbstractMMPlanOPUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMMPlanOPUI.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDButton btnOpenBOM;
    protected com.kingdee.bos.ctrl.swing.KDButton btnOPBill;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCreateToBill;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbWorkShop;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterial;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtQty;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdDetail;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtStorageOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtBOM;
    /**
     * output class constructor
     */
    public AbstractMMPlanOPUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMMPlanOPUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.btnOpenBOM = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnOPBill = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCreateToBill = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.cmbWorkShop = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtMaterial = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kdDetail = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtStorageOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtBOM = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDTable1.setName("kDTable1");
        this.btnQuery.setName("btnQuery");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDSeparator2.setName("kDSeparator2");
        this.btnOpenBOM.setName("btnOpenBOM");
        this.btnOPBill.setName("btnOPBill");
        this.btnCreateToBill.setName("btnCreateToBill");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.cmbWorkShop.setName("cmbWorkShop");
        this.prmtMaterial.setName("prmtMaterial");
        this.txtQty.setName("txtQty");
        this.kdDetail.setName("kdDetail");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.prmtStorageOrgUnit.setName("prmtStorageOrgUnit");
        this.prmtBOM.setName("prmtBOM");
        // CoreUI		
        this.btnPageSetup.setVisible(false);		
        this.btnCloud.setVisible(false);		
   	
        this.kDSeparatorCloud.setVisible(false);		
        this.menuItemPageSetup.setVisible(false);		
        this.menuItemCloudFeed.setVisible(false);		
        this.menuItemCloudScreen.setEnabled(false);		
        this.menuItemCloudScreen.setVisible(false);		
        this.menuItemCloudShare.setVisible(false);		
        this.kdSeparatorFWFile1.setVisible(false);
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workShop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"finishDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"materialID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"materialNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"materialName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"exedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"entryID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"unExedQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" /><t:Column t:key=\"remark\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{workShop}</t:Cell><t:Cell>$Resource{finishDate}</t:Cell><t:Cell>$Resource{materialID}</t:Cell><t:Cell>$Resource{materialNum}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{exedQty}</t:Cell><t:Cell>$Resource{entryID}</t:Cell><t:Cell>$Resource{unExedQty}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));
        this.btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnQuery_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(100);
        // kDSeparator2
        // btnOpenBOM		
        this.btnOpenBOM.setText(resHelper.getString("btnOpenBOM.text"));
        this.btnOpenBOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOpenBOM_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnOPBill		
        this.btnOPBill.setText(resHelper.getString("btnOPBill.text"));
        this.btnOPBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOPBill_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnCreateToBill		
        this.btnCreateToBill.setText(resHelper.getString("btnCreateToBill.text"));
        this.btnCreateToBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCreateToBill_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // cmbWorkShop		
        this.cmbWorkShop.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.eas2temp.workShopNumEnum").toArray());
        // prmtMaterial		
        this.prmtMaterial.setVisible(false);
        // txtQty
        // kdDetail
		String kdDetailStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"number\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workshop\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"3\" /><t:Column t:key=\"orderQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"bomID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" t:styleID=\"sCol5\" /><t:Column t:key=\"bomNumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" /><t:Column t:key=\"bomName\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"billStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"productStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{workshop}</t:Cell><t:Cell>$Resource{orderQty}</t:Cell><t:Cell>$Resource{bomID}</t:Cell><t:Cell>$Resource{bomNumber}</t:Cell><t:Cell>$Resource{bomName}</t:Cell><t:Cell>$Resource{billStatus}</t:Cell><t:Cell>$Resource{productStatus}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdDetail.setFormatXml(resHelper.translateString("kdDetail",kdDetailStrXML));

        

        // dpBeginDate
        // dpEndDate
        // prmtStorageOrgUnit
        // prmtBOM
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
        kDTable1.setBounds(new Rectangle(16, 91, 981, 308));
        this.add(kDTable1, new KDLayout.Constraints(16, 91, 981, 308, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btnQuery.setBounds(new Rectangle(912, 16, 73, 21));
        this.add(btnQuery, new KDLayout.Constraints(912, 16, 73, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(18, 16, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(18, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(316, 16, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(316, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(614, 16, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(614, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator2.setBounds(new Rectangle(19, 78, 986, 9));
        this.add(kDSeparator2, new KDLayout.Constraints(19, 78, 986, 9, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        btnOpenBOM.setBounds(new Rectangle(18, 46, 90, 21));
        this.add(btnOpenBOM, new KDLayout.Constraints(18, 46, 90, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnOPBill.setBounds(new Rectangle(162, 46, 126, 21));
        this.add(btnOPBill, new KDLayout.Constraints(162, 46, 126, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnCreateToBill.setBounds(new Rectangle(869, 46, 116, 21));
        this.add(btnCreateToBill, new KDLayout.Constraints(869, 46, 116, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer4.setBounds(new Rectangle(316, 46, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(316, 46, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cmbWorkShop.setBounds(new Rectangle(614, 46, 123, 19));
        this.add(cmbWorkShop, new KDLayout.Constraints(614, 46, 123, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        prmtMaterial.setBounds(new Rectangle(618, 612, 170, 19));
        this.add(prmtMaterial, new KDLayout.Constraints(618, 612, 170, 19, 0));
        txtQty.setBounds(new Rectangle(745, 46, 114, 19));
        this.add(txtQty, new KDLayout.Constraints(745, 46, 114, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdDetail.setBounds(new Rectangle(16, 410, 983, 200));
        this.add(kdDetail, new KDLayout.Constraints(16, 410, 983, 200, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(dpBeginDate);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(dpEndDate);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(prmtStorageOrgUnit);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(prmtBOM);

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
  
        this.toolBar.add(kDSeparatorCloud);


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.eas2temp.app.MMPlanOPUIHandler";
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
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnOpenBOM_actionPerformed method
     */
    protected void btnOpenBOM_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnOPBill_actionPerformed method
     */
    protected void btnOPBill_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnCreateToBill_actionPerformed method
     */
    protected void btnCreateToBill_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.eas2temp.client", "MMPlanOPUI");
    }




}