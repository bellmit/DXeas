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
public abstract class AbstractSetQtyAndStandard extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSetQtyAndStandard.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDButton btnClose;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer10;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer11;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer12;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer lcmaterialgroup;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer13;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer14;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer15;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer16;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer17;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer18;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer19;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer20;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard1;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard2;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty3;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard3;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtMaterialGroup;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard4;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfQty5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfStandard5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwQty5;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField ftfSwStandard5;
    /**
     * output class constructor
     */
    public AbstractSetQtyAndStandard() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSetQtyAndStandard.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnClose = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer10 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer11 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer12 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.lcmaterialgroup = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer13 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer14 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer15 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer16 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer17 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer18 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer19 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer20 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.ftfQty1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard1 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard2 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard3 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtMaterialGroup = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.ftfQty4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard4 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfQty5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfStandard5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwQty5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.ftfSwStandard5 = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.btnConfirm.setName("btnConfirm");
        this.btnClose.setName("btnClose");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDLabelContainer10.setName("kDLabelContainer10");
        this.kDLabelContainer11.setName("kDLabelContainer11");
        this.kDLabelContainer12.setName("kDLabelContainer12");
        this.lcmaterialgroup.setName("lcmaterialgroup");
        this.kDLabelContainer13.setName("kDLabelContainer13");
        this.kDLabelContainer14.setName("kDLabelContainer14");
        this.kDLabelContainer15.setName("kDLabelContainer15");
        this.kDLabelContainer16.setName("kDLabelContainer16");
        this.kDLabelContainer17.setName("kDLabelContainer17");
        this.kDLabelContainer18.setName("kDLabelContainer18");
        this.kDLabelContainer19.setName("kDLabelContainer19");
        this.kDLabelContainer20.setName("kDLabelContainer20");
        this.ftfQty1.setName("ftfQty1");
        this.ftfStandard1.setName("ftfStandard1");
        this.ftfQty2.setName("ftfQty2");
        this.ftfStandard2.setName("ftfStandard2");
        this.ftfSwQty1.setName("ftfSwQty1");
        this.ftfSwStandard1.setName("ftfSwStandard1");
        this.ftfSwQty2.setName("ftfSwQty2");
        this.ftfSwStandard2.setName("ftfSwStandard2");
        this.ftfQty3.setName("ftfQty3");
        this.ftfStandard3.setName("ftfStandard3");
        this.ftfSwQty3.setName("ftfSwQty3");
        this.ftfSwStandard3.setName("ftfSwStandard3");
        this.prmtMaterialGroup.setName("prmtMaterialGroup");
        this.ftfQty4.setName("ftfQty4");
        this.ftfStandard4.setName("ftfStandard4");
        this.ftfSwQty4.setName("ftfSwQty4");
        this.ftfSwStandard4.setName("ftfSwStandard4");
        this.ftfQty5.setName("ftfQty5");
        this.ftfStandard5.setName("ftfStandard5");
        this.ftfSwQty5.setName("ftfSwQty5");
        this.ftfSwStandard5.setName("ftfSwStandard5");
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
        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelUnderline(true);		
        this.kDLabelContainer1.setBoundLabelLength(110);
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(100);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(110);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelLength(100);
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelLength(110);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelLength(100);		
        this.kDLabelContainer6.setBoundLabelUnderline(true);
        // btnConfirm		
        this.btnConfirm.setText(resHelper.getString("btnConfirm.text"));
        this.btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnConfirm_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnClose		
        this.btnClose.setText(resHelper.getString("btnClose.text"));
        this.btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnClose_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(110);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelLength(100);		
        this.kDLabelContainer8.setBoundLabelUnderline(true);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(110);
        // kDLabelContainer10		
        this.kDLabelContainer10.setBoundLabelText(resHelper.getString("kDLabelContainer10.boundLabelText"));		
        this.kDLabelContainer10.setBoundLabelUnderline(true);		
        this.kDLabelContainer10.setBoundLabelLength(100);
        // kDLabelContainer11		
        this.kDLabelContainer11.setBoundLabelUnderline(true);		
        this.kDLabelContainer11.setBoundLabelText(resHelper.getString("kDLabelContainer11.boundLabelText"));		
        this.kDLabelContainer11.setBoundLabelLength(110);
        // kDLabelContainer12		
        this.kDLabelContainer12.setBoundLabelText(resHelper.getString("kDLabelContainer12.boundLabelText"));		
        this.kDLabelContainer12.setBoundLabelLength(100);		
        this.kDLabelContainer12.setBoundLabelUnderline(true);
        // lcmaterialgroup		
        this.lcmaterialgroup.setBoundLabelText(resHelper.getString("lcmaterialgroup.boundLabelText"));		
        this.lcmaterialgroup.setBoundLabelUnderline(true);		
        this.lcmaterialgroup.setBoundLabelLength(100);
        // kDLabelContainer13		
        this.kDLabelContainer13.setBoundLabelText(resHelper.getString("kDLabelContainer13.boundLabelText"));		
        this.kDLabelContainer13.setBoundLabelUnderline(true);		
        this.kDLabelContainer13.setBoundLabelLength(110);
        // kDLabelContainer14		
        this.kDLabelContainer14.setBoundLabelText(resHelper.getString("kDLabelContainer14.boundLabelText"));		
        this.kDLabelContainer14.setBoundLabelUnderline(true);		
        this.kDLabelContainer14.setBoundLabelLength(110);
        // kDLabelContainer15		
        this.kDLabelContainer15.setBoundLabelText(resHelper.getString("kDLabelContainer15.boundLabelText"));		
        this.kDLabelContainer15.setBoundLabelUnderline(true);		
        this.kDLabelContainer15.setBoundLabelLength(110);
        // kDLabelContainer16		
        this.kDLabelContainer16.setBoundLabelText(resHelper.getString("kDLabelContainer16.boundLabelText"));		
        this.kDLabelContainer16.setBoundLabelUnderline(true);		
        this.kDLabelContainer16.setBoundLabelLength(110);
        // kDLabelContainer17		
        this.kDLabelContainer17.setBoundLabelText(resHelper.getString("kDLabelContainer17.boundLabelText"));		
        this.kDLabelContainer17.setBoundLabelUnderline(true);		
        this.kDLabelContainer17.setBoundLabelLength(110);
        // kDLabelContainer18		
        this.kDLabelContainer18.setBoundLabelText(resHelper.getString("kDLabelContainer18.boundLabelText"));		
        this.kDLabelContainer18.setBoundLabelUnderline(true);		
        this.kDLabelContainer18.setBoundLabelLength(110);
        // kDLabelContainer19		
        this.kDLabelContainer19.setBoundLabelText(resHelper.getString("kDLabelContainer19.boundLabelText"));		
        this.kDLabelContainer19.setBoundLabelUnderline(true);		
        this.kDLabelContainer19.setBoundLabelLength(110);
        // kDLabelContainer20		
        this.kDLabelContainer20.setBoundLabelText(resHelper.getString("kDLabelContainer20.boundLabelText"));		
        this.kDLabelContainer20.setBoundLabelUnderline(true);		
        this.kDLabelContainer20.setBoundLabelLength(110);
        // ftfQty1		
        this.ftfQty1.setDataType(1);
        // ftfStandard1		
        this.ftfStandard1.setDataType(1);
        // ftfQty2		
        this.ftfQty2.setDataType(1);
        // ftfStandard2		
        this.ftfStandard2.setDataType(1);
        // ftfSwQty1
        // ftfSwStandard1
        // ftfSwQty2
        // ftfSwStandard2
        // ftfQty3		
        this.ftfQty3.setDataType(1);
        // ftfStandard3		
        this.ftfStandard3.setDataType(1);
        // ftfSwQty3
        // ftfSwStandard3
        // prmtMaterialGroup
        // ftfQty4
        // ftfStandard4
        // ftfSwQty4
        // ftfSwStandard4
        // ftfQty5
        // ftfStandard5
        // ftfSwQty5
        // ftfSwStandard5
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
        this.setBounds(new Rectangle(10, 10, 600, 500));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(14, 21, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(305, 21, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(14, 83, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(305, 83, 270, 19));
        this.add(kDLabelContainer4, null);
        kDLabelContainer5.setBounds(new Rectangle(14, 52, 270, 19));
        this.add(kDLabelContainer5, null);
        kDLabelContainer6.setBounds(new Rectangle(305, 52, 270, 19));
        this.add(kDLabelContainer6, null);
        btnConfirm.setBounds(new Rectangle(159, 453, 91, 21));
        this.add(btnConfirm, null);
        btnClose.setBounds(new Rectangle(326, 453, 91, 21));
        this.add(btnClose, null);
        kDLabelContainer7.setBounds(new Rectangle(14, 114, 270, 19));
        this.add(kDLabelContainer7, null);
        kDLabelContainer8.setBounds(new Rectangle(305, 114, 270, 19));
        this.add(kDLabelContainer8, null);
        kDLabelContainer9.setBounds(new Rectangle(15, 145, 270, 19));
        this.add(kDLabelContainer9, null);
        kDLabelContainer10.setBounds(new Rectangle(305, 145, 270, 19));
        this.add(kDLabelContainer10, null);
        kDLabelContainer11.setBounds(new Rectangle(15, 176, 270, 19));
        this.add(kDLabelContainer11, null);
        kDLabelContainer12.setBounds(new Rectangle(305, 176, 270, 19));
        this.add(kDLabelContainer12, null);
        lcmaterialgroup.setBounds(new Rectangle(24, 354, 270, 19));
        this.add(lcmaterialgroup, null);
        kDLabelContainer13.setBounds(new Rectangle(15, 207, 270, 19));
        this.add(kDLabelContainer13, null);
        kDLabelContainer14.setBounds(new Rectangle(305, 207, 270, 19));
        this.add(kDLabelContainer14, null);
        kDLabelContainer15.setBounds(new Rectangle(15, 238, 270, 19));
        this.add(kDLabelContainer15, null);
        kDLabelContainer16.setBounds(new Rectangle(305, 238, 270, 19));
        this.add(kDLabelContainer16, null);
        kDLabelContainer17.setBounds(new Rectangle(15, 269, 270, 19));
        this.add(kDLabelContainer17, null);
        kDLabelContainer18.setBounds(new Rectangle(305, 269, 270, 19));
        this.add(kDLabelContainer18, null);
        kDLabelContainer19.setBounds(new Rectangle(15, 301, 270, 19));
        this.add(kDLabelContainer19, null);
        kDLabelContainer20.setBounds(new Rectangle(305, 301, 270, 19));
        this.add(kDLabelContainer20, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(ftfQty1);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(ftfStandard1);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(ftfQty2);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(ftfStandard2);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(ftfSwQty1);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(ftfSwStandard1);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(ftfSwQty2);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(ftfSwStandard2);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(ftfQty3);
        //kDLabelContainer10
        kDLabelContainer10.setBoundEditor(ftfStandard3);
        //kDLabelContainer11
        kDLabelContainer11.setBoundEditor(ftfSwQty3);
        //kDLabelContainer12
        kDLabelContainer12.setBoundEditor(ftfSwStandard3);
        //lcmaterialgroup
        lcmaterialgroup.setBoundEditor(prmtMaterialGroup);
        //kDLabelContainer13
        kDLabelContainer13.setBoundEditor(ftfQty4);
        //kDLabelContainer14
        kDLabelContainer14.setBoundEditor(ftfStandard4);
        //kDLabelContainer15
        kDLabelContainer15.setBoundEditor(ftfSwQty4);
        //kDLabelContainer16
        kDLabelContainer16.setBoundEditor(ftfSwStandard4);
        //kDLabelContainer17
        kDLabelContainer17.setBoundEditor(ftfQty5);
        //kDLabelContainer18
        kDLabelContainer18.setBoundEditor(ftfStandard5);
        //kDLabelContainer19
        kDLabelContainer19.setBoundEditor(ftfSwQty5);
        //kDLabelContainer20
        kDLabelContainer20.setBoundEditor(ftfSwStandard5);

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
	    return "com.kingdee.eas.custom.salediscount.app.SetQtyAndStandardHandler";
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
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnClose_actionPerformed method
     */
    protected void btnClose_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "SetQtyAndStandard");
    }




}