/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

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
public abstract class AbstractDayRateCloseUI extends CoreUIObject
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDayRateCloseUI.class);
    protected ResourceBundleHelper resHelper = null;
    protected com.kingdee.bos.ctrl.swing.KDToolBar DayRateCloseUI_toolbar;
    protected com.kingdee.bos.ctrl.swing.KDButton btnExe;
    protected com.kingdee.bos.ctrl.swing.KDButton btnUnExe;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCurPeriod;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkEggActualCost;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkBreedDayRateCost;
    /**
     * output class constructor
     */
    public AbstractDayRateCloseUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDayRateCloseUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.toolBar = new com.kingdee.bos.ctrl.swing.KDToolBar();
        this.menuBar = new com.kingdee.bos.ctrl.swing.KDMenuBar();
        this.btnExe = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnUnExe = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.prmtCurPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.chkEggActualCost = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.chkBreedDayRateCost = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.setName("DayRateCloseUI");
        this.toolBar.setName("DayRateCloseUI_toolbar");
        this.menuBar.setName("DayRateCloseUI_menubar");
        this.btnExe.setName("btnExe");
        this.btnUnExe.setName("btnUnExe");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDPanel1.setName("kDPanel1");
        this.prmtCurPeriod.setName("prmtCurPeriod");
        this.prmtCompany.setName("prmtCompany");
        this.chkEggActualCost.setName("chkEggActualCost");
        this.chkBreedDayRateCost.setName("chkBreedDayRateCost");
        // DayRateCloseUI
        // DayRateCloseUI_toolbar
        // DayRateCloseUI_menubar
        // btnExe		
        this.btnExe.setText(resHelper.getString("btnExe.text"));
        this.btnExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnExe_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnUnExe		
        this.btnUnExe.setText(resHelper.getString("btnUnExe.text"));
        this.btnUnExe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnUnExe_actionPerformed(e);
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
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // prmtCurPeriod		
        this.prmtCurPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
        this.prmtCurPeriod.setCommitFormat("$number$");		
        this.prmtCurPeriod.setEditFormat("$number$");		
        this.prmtCurPeriod.setDisplayFormat("$number$");
        // prmtCompany		
        this.prmtCompany.setCommitFormat("$number$;$name$");		
        this.prmtCompany.setEditFormat("$number$");		
        this.prmtCompany.setDisplayFormat("$name$");
        // chkEggActualCost		
        this.chkEggActualCost.setText(resHelper.getString("chkEggActualCost.text"));		
        this.chkEggActualCost.setSelected(true);
        // chkBreedDayRateCost		
        this.chkBreedDayRateCost.setText(resHelper.getString("chkBreedDayRateCost.text"));		
        this.chkBreedDayRateCost.setEnabled(false);
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
        this.setBounds(new Rectangle(10, 10, 300, 200));
        this.setLayout(null);
        btnExe.setBounds(new Rectangle(32, 157, 73, 21));
        this.add(btnExe, null);
        btnUnExe.setBounds(new Rectangle(180, 157, 73, 21));
        this.add(btnUnExe, null);
        kDLabelContainer1.setBounds(new Rectangle(19, 58, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(19, 26, 270, 19));
        this.add(kDLabelContainer2, null);
        kDPanel1.setBounds(new Rectangle(8, 87, 279, 56));
        this.add(kDPanel1, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCurPeriod);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtCompany);
        //kDPanel1
        kDPanel1.setLayout(null);        chkEggActualCost.setBounds(new Rectangle(154, 21, 112, 19));
        kDPanel1.add(chkEggActualCost, null);
        chkBreedDayRateCost.setBounds(new Rectangle(15, 21, 123, 19));
        kDPanel1.add(chkBreedDayRateCost, null);

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
	    return "com.kingdee.eas.farm.dayratecost.app.DayRateCloseUIHandler";
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
     * output btnExe_actionPerformed method
     */
    protected void btnExe_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnUnExe_actionPerformed method
     */
    protected void btnUnExe_actionPerformed(java.awt.event.ActionEvent e) throws Exception
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
        return new MetaDataPK("com.kingdee.eas.farm.dayratecost.client", "DayRateCloseUI");
    }




}