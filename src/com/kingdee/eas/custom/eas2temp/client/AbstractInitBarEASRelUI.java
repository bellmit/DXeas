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
public abstract class AbstractInitBarEASRelUI extends CoreUIObject
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractInitBarEASRelUI.class);
    protected ResourceBundleHelper resHelper = null;
    protected com.kingdee.bos.ctrl.swing.KDToolBar InitBarEASRelUI_toolbar;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonInit;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonAdd;
    protected com.kingdee.bos.ctrl.swing.KDButton kDButtonRemove;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstorageUnitOrg;
    /**
     * output class constructor
     */
    public AbstractInitBarEASRelUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractInitBarEASRelUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.toolBar = new com.kingdee.bos.ctrl.swing.KDToolBar();
        this.menuBar = new com.kingdee.bos.ctrl.swing.KDMenuBar();
        this.kDButtonInit = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDButtonAdd = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDButtonRemove = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtstorageUnitOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.setName("InitBarEASRelUI");
        this.toolBar.setName("InitBarEASRelUI_toolbar");
        this.menuBar.setName("InitBarEASRelUI_menubar");
        this.kDButtonInit.setName("kDButtonInit");
        this.kDButtonAdd.setName("kDButtonAdd");
        this.kDButtonRemove.setName("kDButtonRemove");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDTable1.setName("kDTable1");
        this.prmtstorageUnitOrg.setName("prmtstorageUnitOrg");
        // InitBarEASRelUI
        // InitBarEASRelUI_toolbar
        // InitBarEASRelUI_menubar
        // kDButtonInit		
        this.kDButtonInit.setText(resHelper.getString("kDButtonInit.text"));
        this.kDButtonInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonInit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDButtonAdd		
        this.kDButtonAdd.setText(resHelper.getString("kDButtonAdd.text"));
        this.kDButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonAdd_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDButtonRemove		
        this.kDButtonRemove.setText(resHelper.getString("kDButtonRemove.text"));
        this.kDButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    kDButtonRemove_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        this.kDButtonRemove.addAncestorListener(new com.kingdee.bos.ctrl.swing.event.AncestorAdapter() {
            public void ancestorMoved(javax.swing.event.AncestorEvent e) {
                try {
                    kDButton3_ancestorMoved(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{material}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // prmtstorageUnitOrg
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
        this.setBounds(new Rectangle(10, 10, 1016, 600));
        this.setLayout(null);
        kDButtonInit.setBounds(new Rectangle(312, 60, 107, 21));
        this.add(kDButtonInit, null);
        kDButtonAdd.setBounds(new Rectangle(312, 99, 107, 21));
        this.add(kDButtonAdd, null);
        kDButtonRemove.setBounds(new Rectangle(312, 143, 107, 21));
        this.add(kDButtonRemove, null);
        kDLabelContainer1.setBounds(new Rectangle(22, 60, 270, 19));
        this.add(kDLabelContainer1, null);
        kDTable1.setBounds(new Rectangle(20, 104, 267, 458));
        this.add(kDTable1, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtstorageUnitOrg);

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
	    return "com.kingdee.eas.custom.eas2temp.app.InitBarEASRelUIHandler";
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
     * output kDButtonInit_actionPerformed method
     */
    protected void kDButtonInit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output kDButtonAdd_actionPerformed method
     */
    protected void kDButtonAdd_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output kDButtonRemove_actionPerformed method
     */
    protected void kDButtonRemove_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output kDButton3_ancestorMoved method
     */
    protected void kDButton3_ancestorMoved(javax.swing.event.AncestorEvent e) throws Exception
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
        return new MetaDataPK("com.kingdee.eas.custom.eas2temp.client", "InitBarEASRelUI");
    }




}