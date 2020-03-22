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
public abstract class AbstractEAS2TempOPUI extends CoreUIObject
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractEAS2TempOPUI.class);
    protected ResourceBundleHelper resHelper = null;
    protected com.kingdee.bos.ctrl.swing.KDToolBar EAS2TempOPUI_toolbar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExecute;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCancel;
    protected com.kingdee.bos.ctrl.swing.KDButton btnQuery;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker kDTimePicker1;
    protected com.kingdee.bos.ctrl.swing.KDTimePicker kDTimePicker2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbOPType;
    protected com.kingdee.bos.ctrl.swing.KDComboBox cmbTempClass;
    /**
     * output class constructor
     */
    public AbstractEAS2TempOPUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractEAS2TempOPUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.toolBar = new com.kingdee.bos.ctrl.swing.KDToolBar();
        this.menuBar = new com.kingdee.bos.ctrl.swing.KDMenuBar();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnExecute = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCancel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDTimePicker1 = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.kDTimePicker2 = new com.kingdee.bos.ctrl.swing.KDTimePicker();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cmbOPType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.cmbTempClass = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.setName("EAS2TempOPUI");
        this.toolBar.setName("EAS2TempOPUI_toolbar");
        this.menuBar.setName("EAS2TempOPUI_menubar");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.btnExecute.setName("btnExecute");
        this.btnCancel.setName("btnCancel");
        this.btnQuery.setName("btnQuery");
        this.kDTable1.setName("kDTable1");
        this.kDTimePicker1.setName("kDTimePicker1");
        this.kDTimePicker2.setName("kDTimePicker2");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
        this.prmtCompany.setName("prmtCompany");
        this.cmbOPType.setName("cmbOPType");
        this.cmbTempClass.setName("cmbTempClass");
        // EAS2TempOPUI
        // EAS2TempOPUI_toolbar
        // EAS2TempOPUI_menubar
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
        // btnExecute		
        this.btnExecute.setText(resHelper.getString("btnExecute.text"));
        this.btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnExecute_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnCancel		
        this.btnCancel.setText(resHelper.getString("btnCancel.text"));
        this.btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCancel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
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
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"opDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"result\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"msg\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{billNum}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{opDate}</t:Cell><t:Cell>$Resource{result}</t:Cell><t:Cell>$Resource{msg}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // kDTimePicker1
        // kDTimePicker2
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(100);		
        this.kDLabelContainer5.setBoundLabelUnderline(true);
        // dpBeginDate
        // dpEndDate
        // prmtCompany
        // cmbOPType
        // cmbTempClass
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
		list.add(this.toolBar);
		return (com.kingdee.bos.ctrl.swing.KDToolBar[])list.toArray(new com.kingdee.bos.ctrl.swing.KDToolBar[list.size()]);
	}




    /**
     * output initUIContentLayout method
     */
    public void initUIContentLayout()
    {
        this.setBounds(new Rectangle(10, 10, 700, 600));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(31, 53, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(403, 53, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(30, 136, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(403, 107, 270, 19));
        this.add(kDLabelContainer4, null);
        btnExecute.setBounds(new Rectangle(68, 186, 73, 21));
        this.add(btnExecute, null);
        btnCancel.setBounds(new Rectangle(223, 186, 73, 21));
        this.add(btnCancel, null);
        btnQuery.setBounds(new Rectangle(537, 186, 73, 21));
        this.add(btnQuery, null);
        kDTable1.setBounds(new Rectangle(20, 227, 660, 353));
        this.add(kDTable1, null);
        kDTimePicker1.setBounds(new Rectangle(130, 80, 170, 19));
        this.add(kDTimePicker1, null);
        kDTimePicker2.setBounds(new Rectangle(503, 79, 170, 19));
        this.add(kDTimePicker2, null);
        kDLabelContainer5.setBounds(new Rectangle(30, 108, 270, 19));
        this.add(kDLabelContainer5, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(dpBeginDate);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(dpEndDate);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(prmtCompany);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(cmbOPType);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(cmbTempClass);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {

    }

    /**
     * output initUIToolBarLayout method
     */
    public void initUIToolBarLayout()
    {


    }

	//Regiester control's property binding.
	private void registerBindings(){		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.eas2temp.app.EAS2TempOPUIHandler";
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
     * output btnExecute_actionPerformed method
     */
    protected void btnExecute_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnQuery_actionPerformed method
     */
    protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.eas2temp.client", "EAS2TempOPUI");
    }




}