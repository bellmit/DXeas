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
public abstract class AbstractDiscountCashPlatform extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractDiscountCashPlatform.class);
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAll;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAllUnSelect;
    protected com.kingdee.bos.ctrl.swing.KDButton btnDel;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtCustomer;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDButton btnConfirm;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCancel;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSelectAllData;
    protected com.kingdee.bos.ctrl.swing.KDButton btnAllUnSelectData;
    protected com.kingdee.bos.ctrl.swing.KDButton btnSearch;
    protected com.kingdee.bos.ctrl.swing.KDButton btnGenerateRecord;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDSeparator kDSeparator2;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbNoReveiving;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbHaveReveiving;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtSelectCustomers;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbLz;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbSw;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbYz;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbNz;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox cbFx;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpBeginDate;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker dpEndDate;
    /**
     * output class constructor
     */
    public AbstractDiscountCashPlatform() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractDiscountCashPlatform.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kdtData = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.btnSelectAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAllUnSelect = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnDel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtCustomer = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.btnConfirm = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnCancel = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSelectAllData = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnAllUnSelectData = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnSearch = new com.kingdee.bos.ctrl.swing.KDButton();
        this.btnGenerateRecord = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDSeparator2 = new com.kingdee.bos.ctrl.swing.KDSeparator();
        this.cbNoReveiving = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbHaveReveiving = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.prmtSelectCustomers = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.cbLz = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbSw = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbYz = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbNz = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.cbFx = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.dpBeginDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.dpEndDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kdtData.setName("kdtData");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.btnSelectAll.setName("btnSelectAll");
        this.btnAllUnSelect.setName("btnAllUnSelect");
        this.btnDel.setName("btnDel");
        this.kdtCustomer.setName("kdtCustomer");
        this.kDPanel1.setName("kDPanel1");
        this.btnConfirm.setName("btnConfirm");
        this.btnCancel.setName("btnCancel");
        this.btnSelectAllData.setName("btnSelectAllData");
        this.btnAllUnSelectData.setName("btnAllUnSelectData");
        this.btnSearch.setName("btnSearch");
        this.btnGenerateRecord.setName("btnGenerateRecord");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDSeparator2.setName("kDSeparator2");
        this.cbNoReveiving.setName("cbNoReveiving");
        this.cbHaveReveiving.setName("cbHaveReveiving");
        this.prmtSelectCustomers.setName("prmtSelectCustomers");
        this.cbLz.setName("cbLz");
        this.cbSw.setName("cbSw");
        this.cbYz.setName("cbYz");
        this.cbNz.setName("cbNz");
        this.cbFx.setName("cbFx");
        this.dpBeginDate.setName("dpBeginDate");
        this.dpEndDate.setName("dpEndDate");
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
        // kdtData
		String kdtDataStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol3\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol11\"><c:Alignment horizontal=\"right\" /></c:Style><c:Style id=\"sCol12\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol18\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"selected\" t:width=\"40\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"detail\" t:width=\"30\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"80\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"customerNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"4\" /><t:Column t:key=\"customerName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"5\" /><t:Column t:key=\"billID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"6\" t:styleID=\"sCol6\" /><t:Column t:key=\"billNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"7\" /><t:Column t:key=\"billType\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"8\" /><t:Column t:key=\"billQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"9\" /><t:Column t:key=\"status\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"10\" /><t:Column t:key=\"amount\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"11\" t:styleID=\"sCol11\" /><t:Column t:key=\"receiveBillID\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"12\" t:styleID=\"sCol12\" /><t:Column t:key=\"receiveBillNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"13\" /><t:Column t:key=\"receiveBillStatus\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"14\" /><t:Column t:key=\"receiveUser\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"15\" /><t:Column t:key=\"receiveTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"16\" /><t:Column t:key=\"receiveDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"17\" /><t:Column t:key=\"isBill\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{detail}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{customerNumber}</t:Cell><t:Cell>$Resource{customerName}</t:Cell><t:Cell>$Resource{billID}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{billType}</t:Cell><t:Cell>$Resource{billQty}</t:Cell><t:Cell>$Resource{status}</t:Cell><t:Cell>$Resource{amount}</t:Cell><t:Cell>$Resource{receiveBillID}</t:Cell><t:Cell>$Resource{receiveBillNumber}</t:Cell><t:Cell>$Resource{receiveBillStatus}</t:Cell><t:Cell>$Resource{receiveUser}</t:Cell><t:Cell>$Resource{receiveTime}</t:Cell><t:Cell>$Resource{receiveDate}</t:Cell><t:Cell>$Resource{isBill}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtData.setFormatXml(resHelper.translateString("kdtData",kdtDataStrXML));
        this.kdtData.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kdtData_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.kdtData.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtData_editStopped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
            public void editValueChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kdtData_editValueChanged(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));
        // btnSelectAll		
        this.btnSelectAll.setText(resHelper.getString("btnSelectAll.text"));
        this.btnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSelectAll_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAllUnSelect		
        this.btnAllUnSelect.setText(resHelper.getString("btnAllUnSelect.text"));
        this.btnAllUnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAllUnSelect_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnDel		
        this.btnDel.setText(resHelper.getString("btnDel.text"));
        this.btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnDel_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kdtCustomer
		String kdtCustomerStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol1\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"selected\" t:width=\"30\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customer\" t:width=\"0\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"customerNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"customerName\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{selected}</t:Cell><t:Cell>$Resource{customer}</t:Cell><t:Cell>$Resource{customerNumber}</t:Cell><t:Cell>$Resource{customerName}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtCustomer.setFormatXml(resHelper.translateString("kdtCustomer",kdtCustomerStrXML));

        

        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
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
        // btnSelectAllData		
        this.btnSelectAllData.setText(resHelper.getString("btnSelectAllData.text"));
        this.btnSelectAllData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSelectAllData_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnAllUnSelectData		
        this.btnAllUnSelectData.setText(resHelper.getString("btnAllUnSelectData.text"));
        this.btnAllUnSelectData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnAllUnSelectData_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSearch		
        this.btnSearch.setText(resHelper.getString("btnSearch.text"));
        this.btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSearch_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnGenerateRecord		
        this.btnGenerateRecord.setText(resHelper.getString("btnGenerateRecord.text"));
        this.btnGenerateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnGenerateRecord_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelUnderline(true);		
        this.kDLabelContainer2.setBoundLabelLength(60);
        // kDLabelContainer3		
        this.kDLabelContainer3.setBoundLabelText(resHelper.getString("kDLabelContainer3.boundLabelText"));		
        this.kDLabelContainer3.setBoundLabelUnderline(true);		
        this.kDLabelContainer3.setBoundLabelLength(60);
        // kDSeparator2
        // cbNoReveiving		
        this.cbNoReveiving.setText(resHelper.getString("cbNoReveiving.text"));
        // cbHaveReveiving		
        this.cbHaveReveiving.setText(resHelper.getString("cbHaveReveiving.text"));
        // prmtSelectCustomers
        // cbLz		
        this.cbLz.setText(resHelper.getString("cbLz.text"));
        // cbSw		
        this.cbSw.setText(resHelper.getString("cbSw.text"));
        // cbYz		
        this.cbYz.setText(resHelper.getString("cbYz.text"));
        // cbNz		
        this.cbNz.setText(resHelper.getString("cbNz.text"));
        // cbFx		
        this.cbFx.setText(resHelper.getString("cbFx.text"));		
        this.cbFx.setVisible(false);		
        this.cbFx.setEnabled(false);
        // dpBeginDate
        // dpEndDate
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
        kdtData.setBounds(new Rectangle(291, 10, 713, 570));
        this.add(kdtData, new KDLayout.Constraints(291, 10, 713, 570, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(6, 164, 278, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(6, 164, 278, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSelectAll.setBounds(new Rectangle(11, 186, 60, 21));
        this.add(btnSelectAll, new KDLayout.Constraints(11, 186, 60, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAllUnSelect.setBounds(new Rectangle(77, 186, 60, 21));
        this.add(btnAllUnSelect, new KDLayout.Constraints(77, 186, 60, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnDel.setBounds(new Rectangle(222, 186, 60, 21));
        this.add(btnDel, new KDLayout.Constraints(222, 186, 60, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kdtCustomer.setBounds(new Rectangle(10, 209, 276, 406));
        this.add(kdtCustomer, new KDLayout.Constraints(10, 209, 276, 406, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(8, 9, 279, 72));
        this.add(kDPanel1, new KDLayout.Constraints(8, 9, 279, 72, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnConfirm.setBounds(new Rectangle(725, 588, 114, 21));
        this.add(btnConfirm, new KDLayout.Constraints(725, 588, 114, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnCancel.setBounds(new Rectangle(868, 588, 121, 21));
        this.add(btnCancel, new KDLayout.Constraints(868, 588, 121, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnSelectAllData.setBounds(new Rectangle(297, 588, 73, 21));
        this.add(btnSelectAllData, new KDLayout.Constraints(297, 588, 73, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnAllUnSelectData.setBounds(new Rectangle(385, 588, 73, 21));
        this.add(btnAllUnSelectData, new KDLayout.Constraints(385, 588, 73, 21, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSearch.setBounds(new Rectangle(193, 110, 92, 21));
        this.add(btnSearch, new KDLayout.Constraints(193, 110, 92, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnGenerateRecord.setBounds(new Rectangle(192, 82, 94, 21));
        this.add(btnGenerateRecord, new KDLayout.Constraints(192, 82, 94, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(11, 83, 175, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(11, 83, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(12, 111, 175, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(12, 111, 175, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDSeparator2.setBounds(new Rectangle(8, 157, 277, 10));
        this.add(kDSeparator2, new KDLayout.Constraints(8, 157, 277, 10, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbNoReveiving.setBounds(new Rectangle(12, 136, 129, 19));
        this.add(cbNoReveiving, new KDLayout.Constraints(12, 136, 129, 19, 0));
        cbHaveReveiving.setBounds(new Rectangle(154, 136, 116, 19));
        this.add(cbHaveReveiving, new KDLayout.Constraints(154, 136, 116, 19, 0));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtSelectCustomers);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(8, 9, 279, 72));        cbLz.setBounds(new Rectangle(17, 15, 56, 19));
        kDPanel1.add(cbLz, new KDLayout.Constraints(17, 15, 56, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbSw.setBounds(new Rectangle(98, 15, 58, 19));
        kDPanel1.add(cbSw, new KDLayout.Constraints(98, 15, 58, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbYz.setBounds(new Rectangle(181, 15, 69, 19));
        kDPanel1.add(cbYz, new KDLayout.Constraints(181, 15, 69, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        cbNz.setBounds(new Rectangle(17, 41, 62, 19));
        kDPanel1.add(cbNz, new KDLayout.Constraints(17, 41, 62, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        cbFx.setBounds(new Rectangle(98, 41, 65, 19));
        kDPanel1.add(cbFx, new KDLayout.Constraints(98, 41, 65, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(dpBeginDate);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(dpEndDate);

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
	    return "com.kingdee.eas.custom.salediscount.app.DiscountCashPlatformHandler";
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
     * output kdtData_tableClicked method
     */
    protected void kdtData_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtData_editStopped method
     */
    protected void kdtData_editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output kdtData_editValueChanged method
     */
    protected void kdtData_editValueChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSelectAll_actionPerformed method
     */
    protected void btnSelectAll_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnAllUnSelect_actionPerformed method
     */
    protected void btnAllUnSelect_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnDel_actionPerformed method
     */
    protected void btnDel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSelectAllData_actionPerformed method
     */
    protected void btnSelectAllData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnAllUnSelectData_actionPerformed method
     */
    protected void btnAllUnSelectData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSearch_actionPerformed method
     */
    protected void btnSearch_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnGenerateRecord_actionPerformed method
     */
    protected void btnGenerateRecord_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salediscount.client", "DiscountCashPlatform");
    }




}