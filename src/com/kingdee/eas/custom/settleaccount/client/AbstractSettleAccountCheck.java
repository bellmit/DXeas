/**
 * output package name
 */
package com.kingdee.eas.custom.settleaccount.client;

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
public abstract class AbstractSettleAccountCheck extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettleAccountCheck.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable2;
    protected com.kingdee.bos.ctrl.swing.KDButton btnCheckAll;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtPeriod;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnReceivNoVoucher;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPaymentNoVoucher;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPurInWarehsNoVoucher;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnFaCurCardNoVoucher;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnLCMCurCardNoVoucher;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnPurInWarehsACost0;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSaleOrderNotClose;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnSaleIssueBillNoOtherBill;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnMaterialReqCCReWork;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnMaterialReqNotAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOtherIssueCCenterNot1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnOtherIssueACost0;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCompany;
    /**
     * output class constructor
     */
    public AbstractSettleAccountCheck() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSettleAccountCheck.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTable2 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.btnCheckAll = new com.kingdee.bos.ctrl.swing.KDButton();
        this.prmtPeriod = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.btnReceivNoVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPaymentNoVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPurInWarehsNoVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnFaCurCardNoVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnLCMCurCardNoVoucher = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnPurInWarehsACost0 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnSaleOrderNotClose = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnSaleIssueBillNoOtherBill = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnMaterialReqCCReWork = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnMaterialReqNotAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnOtherIssueCCenterNot1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnOtherIssueACost0 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.prmtCompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.kDTable1.setName("kDTable1");
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDTable2.setName("kDTable2");
        this.btnCheckAll.setName("btnCheckAll");
        this.prmtPeriod.setName("prmtPeriod");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.btnReceivNoVoucher.setName("btnReceivNoVoucher");
        this.btnPaymentNoVoucher.setName("btnPaymentNoVoucher");
        this.btnPurInWarehsNoVoucher.setName("btnPurInWarehsNoVoucher");
        this.btnFaCurCardNoVoucher.setName("btnFaCurCardNoVoucher");
        this.btnLCMCurCardNoVoucher.setName("btnLCMCurCardNoVoucher");
        this.btnPurInWarehsACost0.setName("btnPurInWarehsACost0");
        this.btnSaleOrderNotClose.setName("btnSaleOrderNotClose");
        this.btnSaleIssueBillNoOtherBill.setName("btnSaleIssueBillNoOtherBill");
        this.btnMaterialReqCCReWork.setName("btnMaterialReqCCReWork");
        this.btnMaterialReqNotAudit.setName("btnMaterialReqNotAudit");
        this.btnOtherIssueCCenterNot1.setName("btnOtherIssueCCenterNot1");
        this.btnOtherIssueACost0.setName("btnOtherIssueACost0");
        this.prmtCompany.setName("prmtCompany");
        // CoreUI		
        this.setToolTipText(resHelper.getString("this.toolTipText"));		
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
        // kDLabelContainer2		
        this.kDLabelContainer2.setBoundLabelText(resHelper.getString("kDLabelContainer2.boundLabelText"));		
        this.kDLabelContainer2.setBoundLabelLength(100);		
        this.kDLabelContainer2.setBoundLabelUnderline(true);
        // kDTabbedPane1
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"problemBillType\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"billNumber\" t:width=\"150\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"problem\" t:width=\"450\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"other\" t:width=\"100\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{problemBillType}</t:Cell><t:Cell>$Resource{billNumber}</t:Cell><t:Cell>$Resource{problem}</t:Cell><t:Cell>$Resource{other}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // kDLabelContainer1		
        this.kDLabelContainer1.setBoundLabelText(resHelper.getString("kDLabelContainer1.boundLabelText"));		
        this.kDLabelContainer1.setBoundLabelLength(100);		
        this.kDLabelContainer1.setBoundLabelUnderline(true);
        // kDTable2
		String kDTable2StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles /><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"checkItem\" t:width=\"200\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"result\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{checkItem}</t:Cell><t:Cell>$Resource{result}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable2.setFormatXml(resHelper.translateString("kDTable2",kDTable2StrXML));
        this.kDTable2.addKDTMouseListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener() {
            public void tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) {
                try {
                    kDTable2_tableClicked(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                }
            }
        });
        this.kDTable2.addKDTEditListener(new com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter() {
            public void editStopped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) {
                try {
                    kDTable2_editStoped(e);
                } catch(Exception exc) {
                    handUIException(exc);
                }
            }
        });

        

        // btnCheckAll		
        this.btnCheckAll.setText(resHelper.getString("btnCheckAll.text"));
        this.btnCheckAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnCheckAll_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtPeriod
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // btnReceivNoVoucher		
        this.btnReceivNoVoucher.setText(resHelper.getString("btnReceivNoVoucher.text"));
        this.btnReceivNoVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnReceivNoVoucher_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnPaymentNoVoucher		
        this.btnPaymentNoVoucher.setText(resHelper.getString("btnPaymentNoVoucher.text"));
        this.btnPaymentNoVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnPaymentNoVoucher_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnPurInWarehsNoVoucher		
        this.btnPurInWarehsNoVoucher.setText(resHelper.getString("btnPurInWarehsNoVoucher.text"));
        this.btnPurInWarehsNoVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnPurInWarehsNoVoucher_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnFaCurCardNoVoucher		
        this.btnFaCurCardNoVoucher.setText(resHelper.getString("btnFaCurCardNoVoucher.text"));
        this.btnFaCurCardNoVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnFaCurCardNoVoucher_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnLCMCurCardNoVoucher		
        this.btnLCMCurCardNoVoucher.setText(resHelper.getString("btnLCMCurCardNoVoucher.text"));
        this.btnLCMCurCardNoVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnLCMCurCardNoVoucher_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnPurInWarehsACost0		
        this.btnPurInWarehsACost0.setText(resHelper.getString("btnPurInWarehsACost0.text"));
        this.btnPurInWarehsACost0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnPurInWarehsACost0_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSaleOrderNotClose		
        this.btnSaleOrderNotClose.setText(resHelper.getString("btnSaleOrderNotClose.text"));
        this.btnSaleOrderNotClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSaleOrderNotClose_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnSaleIssueBillNoOtherBill		
        this.btnSaleIssueBillNoOtherBill.setText(resHelper.getString("btnSaleIssueBillNoOtherBill.text"));
        this.btnSaleIssueBillNoOtherBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnSaleIssueBillNoOtherBill_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnMaterialReqCCReWork		
        this.btnMaterialReqCCReWork.setText(resHelper.getString("btnMaterialReqCCReWork.text"));
        this.btnMaterialReqCCReWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnMaterialReqCCReWork_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnMaterialReqNotAudit		
        this.btnMaterialReqNotAudit.setText(resHelper.getString("btnMaterialReqNotAudit.text"));
        this.btnMaterialReqNotAudit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnMaterialReqNotAudit_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnOtherIssueCCenterNot1		
        this.btnOtherIssueCCenterNot1.setText(resHelper.getString("btnOtherIssueCCenterNot1.text"));
        this.btnOtherIssueCCenterNot1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOtherIssueCCenterNot1_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnOtherIssueACost0		
        this.btnOtherIssueACost0.setText(resHelper.getString("btnOtherIssueACost0.text"));
        this.btnOtherIssueACost0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnOtherIssueACost0_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // prmtCompany
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
        this.setBounds(new Rectangle(10, 10, 1113, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(10, 10, 1113, 629));
        kDLabelContainer2.setBounds(new Rectangle(324, 13, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(324, 13, 270, 19, 0));
        kDTabbedPane1.setBounds(new Rectangle(19, 46, 1059, 180));
        this.add(kDTabbedPane1, new KDLayout.Constraints(19, 46, 1059, 180, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTable1.setBounds(new Rectangle(355, 279, 722, 320));
        this.add(kDTable1, new KDLayout.Constraints(355, 279, 722, 320, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer1.setBounds(new Rectangle(26, 16, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(26, 16, 270, 19, 0));
        kDTable2.setBounds(new Rectangle(15, 279, 326, 321));
        this.add(kDTable2, new KDLayout.Constraints(15, 279, 326, 321, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnCheckAll.setBounds(new Rectangle(643, 13, 109, 21));
        this.add(btnCheckAll, new KDLayout.Constraints(643, 13, 109, 21, 0));
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(prmtPeriod);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1058, 147));        btnReceivNoVoucher.setBounds(new Rectangle(23, 16, 249, 19));
        kDPanel1.add(btnReceivNoVoucher, new KDLayout.Constraints(23, 16, 249, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnPaymentNoVoucher.setBounds(new Rectangle(23, 58, 249, 19));
        kDPanel1.add(btnPaymentNoVoucher, new KDLayout.Constraints(23, 58, 249, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnPurInWarehsNoVoucher.setBounds(new Rectangle(23, 98, 249, 19));
        kDPanel1.add(btnPurInWarehsNoVoucher, new KDLayout.Constraints(23, 98, 249, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnFaCurCardNoVoucher.setBounds(new Rectangle(382, 16, 256, 19));
        kDPanel1.add(btnFaCurCardNoVoucher, new KDLayout.Constraints(382, 16, 256, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnLCMCurCardNoVoucher.setBounds(new Rectangle(382, 55, 256, 19));
        kDPanel1.add(btnLCMCurCardNoVoucher, new KDLayout.Constraints(382, 55, 256, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnPurInWarehsACost0.setBounds(new Rectangle(382, 96, 256, 19));
        kDPanel1.add(btnPurInWarehsACost0, new KDLayout.Constraints(382, 96, 256, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSaleOrderNotClose.setBounds(new Rectangle(749, 16, 256, 19));
        kDPanel1.add(btnSaleOrderNotClose, new KDLayout.Constraints(749, 16, 256, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnSaleIssueBillNoOtherBill.setBounds(new Rectangle(749, 60, 256, 19));
        kDPanel1.add(btnSaleIssueBillNoOtherBill, new KDLayout.Constraints(749, 60, 256, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1058, 147));        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1058, 147));        btnMaterialReqCCReWork.setBounds(new Rectangle(21, 22, 248, 19));
        kDPanel3.add(btnMaterialReqCCReWork, new KDLayout.Constraints(21, 22, 248, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnMaterialReqNotAudit.setBounds(new Rectangle(21, 69, 248, 19));
        kDPanel3.add(btnMaterialReqNotAudit, new KDLayout.Constraints(21, 69, 248, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnOtherIssueCCenterNot1.setBounds(new Rectangle(320, 22, 248, 19));
        kDPanel3.add(btnOtherIssueCCenterNot1, new KDLayout.Constraints(320, 22, 248, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnOtherIssueACost0.setBounds(new Rectangle(320, 69, 248, 19));
        kDPanel3.add(btnOtherIssueACost0, new KDLayout.Constraints(320, 69, 248, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(prmtCompany);

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
	    return "com.kingdee.eas.custom.settleaccount.app.SettleAccountCheckHandler";
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
     * output kDTable2_editStoped method
     */
    protected void kDTable2_editStoped(com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent e) throws Exception
    {
    }

    /**
     * output kDTable2_tableClicked method
     */
    protected void kDTable2_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
    }

    /**
     * output btnCheckAll_actionPerformed method
     */
    protected void btnCheckAll_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnReceivNoVoucher_actionPerformed method
     */
    protected void btnReceivNoVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnPaymentNoVoucher_actionPerformed method
     */
    protected void btnPaymentNoVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnPurInWarehsNoVoucher_actionPerformed method
     */
    protected void btnPurInWarehsNoVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnFaCurCardNoVoucher_actionPerformed method
     */
    protected void btnFaCurCardNoVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnLCMCurCardNoVoucher_actionPerformed method
     */
    protected void btnLCMCurCardNoVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnPurInWarehsACost0_actionPerformed method
     */
    protected void btnPurInWarehsACost0_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSaleOrderNotClose_actionPerformed method
     */
    protected void btnSaleOrderNotClose_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnSaleIssueBillNoOtherBill_actionPerformed method
     */
    protected void btnSaleIssueBillNoOtherBill_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnMaterialReqCCReWork_actionPerformed method
     */
    protected void btnMaterialReqCCReWork_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnMaterialReqNotAudit_actionPerformed method
     */
    protected void btnMaterialReqNotAudit_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnOtherIssueCCenterNot1_actionPerformed method
     */
    protected void btnOtherIssueCCenterNot1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }

    /**
     * output btnOtherIssueACost0_actionPerformed method
     */
    protected void btnOtherIssueACost0_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        //write your code here
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.settleaccount.client", "SettleAccountCheck");
    }




}