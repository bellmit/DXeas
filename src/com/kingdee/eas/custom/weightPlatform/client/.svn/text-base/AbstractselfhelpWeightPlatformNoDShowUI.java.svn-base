/**
 * output package name
 */
package com.kingdee.eas.custom.weightPlatform.client;

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
public abstract class AbstractselfhelpWeightPlatformNoDShowUI extends com.kingdee.eas.framework.client.CoreUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractselfhelpWeightPlatformNoDShowUI.class);
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel6;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel5;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel7;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblWeightValue;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnQuery;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtWeightNum;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblWeightNum;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn2;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnX;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn1;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn5;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn3;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn6;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn8;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn4;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn7;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnN;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn9;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnM;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnBackspace;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnClear;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btn0;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnA;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnB;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnC;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnD;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnE;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnF;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnG;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnH;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnJ;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnK;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnL;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnP;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtCarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel5;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtBillNum;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtFirstTime;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSecondTime;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel7;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel8;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnWeight;
    protected com.kingdee.bos.ctrl.swing.KDLabel lblStatus;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kDTable1;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel6;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtBillQty;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel3;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtFirstQty;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel2;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtSecondQty;
    protected com.kingdee.bos.ctrl.swing.KDLabel kDLabel4;
    protected com.kingdee.bos.ctrl.swing.KDNumberTextField txtSuttleQty;
    /**
     * output class constructor
     */
    public AbstractselfhelpWeightPlatformNoDShowUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractselfhelpWeightPlatformNoDShowUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel6 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel5 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel7 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.lblWeightValue = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.btnQuery = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.txtWeightNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.lblWeightNum = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.btn2 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnX = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn1 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn5 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn3 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn6 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn8 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn4 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn7 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnN = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn9 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnM = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnBackspace = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnClear = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btn0 = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnA = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnB = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnC = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnD = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnE = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnF = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnG = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnH = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnJ = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnK = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnL = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnP = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabel1 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtCarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabel5 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtBillNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtFirstTime = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtSecondTime = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabel7 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDLabel8 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.btnWeight = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.lblStatus = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.kDTable1 = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kDLabel6 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtBillQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kDLabel3 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtFirstQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kDLabel2 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtSecondQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kDLabel4 = new com.kingdee.bos.ctrl.swing.KDLabel();
        this.txtSuttleQty = new com.kingdee.bos.ctrl.swing.KDNumberTextField();
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel4.setName("kDPanel4");
        this.kDPanel6.setName("kDPanel6");
        this.kDPanel5.setName("kDPanel5");
        this.kDPanel7.setName("kDPanel7");
        this.lblWeightValue.setName("lblWeightValue");
        this.btnQuery.setName("btnQuery");
        this.txtWeightNum.setName("txtWeightNum");
        this.kDPanel3.setName("kDPanel3");
        this.lblWeightNum.setName("lblWeightNum");
        this.btn2.setName("btn2");
        this.btnX.setName("btnX");
        this.btn1.setName("btn1");
        this.btn5.setName("btn5");
        this.btn3.setName("btn3");
        this.btn6.setName("btn6");
        this.btn8.setName("btn8");
        this.btn4.setName("btn4");
        this.btn7.setName("btn7");
        this.btnN.setName("btnN");
        this.btn9.setName("btn9");
        this.btnM.setName("btnM");
        this.btnBackspace.setName("btnBackspace");
        this.btnClear.setName("btnClear");
        this.btn0.setName("btn0");
        this.btnA.setName("btnA");
        this.btnB.setName("btnB");
        this.btnC.setName("btnC");
        this.btnD.setName("btnD");
        this.btnE.setName("btnE");
        this.btnF.setName("btnF");
        this.btnG.setName("btnG");
        this.btnH.setName("btnH");
        this.btnJ.setName("btnJ");
        this.btnK.setName("btnK");
        this.btnL.setName("btnL");
        this.btnP.setName("btnP");
        this.kDLabel1.setName("kDLabel1");
        this.txtCarNum.setName("txtCarNum");
        this.kDLabel5.setName("kDLabel5");
        this.txtBillNum.setName("txtBillNum");
        this.txtFirstTime.setName("txtFirstTime");
        this.txtSecondTime.setName("txtSecondTime");
        this.kDLabel7.setName("kDLabel7");
        this.kDLabel8.setName("kDLabel8");
        this.btnWeight.setName("btnWeight");
        this.lblStatus.setName("lblStatus");
        this.kDTable1.setName("kDTable1");
        this.kDLabel6.setName("kDLabel6");
        this.txtBillQty.setName("txtBillQty");
        this.kDLabel3.setName("kDLabel3");
        this.txtFirstQty.setName("txtFirstQty");
        this.kDLabel2.setName("kDLabel2");
        this.txtSecondQty.setName("txtSecondQty");
        this.kDLabel4.setName("kDLabel4");
        this.txtSuttleQty.setName("txtSuttleQty");
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
        // kDPanel1		
        this.kDPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED,new Color(255,255,255),new Color(255,255,255),new Color(103,101,98),new Color(148,145,140)));		
        this.kDPanel1.setVisible(false);
        // kDPanel2
        // kDPanel4		
        this.kDPanel4.setBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)));
        // kDPanel6
        // kDPanel5		
        this.kDPanel5.setBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)));
        // kDPanel7		
        this.kDPanel7.setVisible(false);
        // lblWeightValue		
        this.lblWeightValue.setText(resHelper.getString("lblWeightValue.text"));		
        this.lblWeightValue.setFont(resHelper.getFont("lblWeightValue.font"));		
        this.lblWeightValue.setForeground(new java.awt.Color(0,128,0));		
        this.lblWeightValue.setHorizontalAlignment(4);
        // btnQuery		
        this.btnQuery.setText(resHelper.getString("btnQuery.text"));		
        this.btnQuery.setFont(resHelper.getFont("btnQuery.font"));
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
        // txtWeightNum		
        this.txtWeightNum.setFont(resHelper.getFont("txtWeightNum.font"));		
        this.txtWeightNum.setForeground(new java.awt.Color(255,0,0));		
        this.txtWeightNum.setEnabled(false);
        // kDPanel3		
        this.kDPanel3.setBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)));
        // lblWeightNum		
        this.lblWeightNum.setText(resHelper.getString("lblWeightNum.text"));		
        this.lblWeightNum.setFont(resHelper.getFont("lblWeightNum.font"));		
        this.lblWeightNum.setForeground(new java.awt.Color(255,0,0));
        // btn2		
        this.btn2.setText(resHelper.getString("btn2.text"));		
        this.btn2.setFont(resHelper.getFont("btn2.font"));
        // btnX		
        this.btnX.setText(resHelper.getString("btnX.text"));		
        this.btnX.setFont(resHelper.getFont("btnX.font"));
        // btn1		
        this.btn1.setText(resHelper.getString("btn1.text"));		
        this.btn1.setFont(resHelper.getFont("btn1.font"));
        // btn5		
        this.btn5.setText(resHelper.getString("btn5.text"));		
        this.btn5.setFont(resHelper.getFont("btn5.font"));
        // btn3		
        this.btn3.setText(resHelper.getString("btn3.text"));		
        this.btn3.setFont(resHelper.getFont("btn3.font"));
        // btn6		
        this.btn6.setText(resHelper.getString("btn6.text"));		
        this.btn6.setFont(resHelper.getFont("btn6.font"));
        // btn8		
        this.btn8.setText(resHelper.getString("btn8.text"));		
        this.btn8.setFont(resHelper.getFont("btn8.font"));
        // btn4		
        this.btn4.setText(resHelper.getString("btn4.text"));		
        this.btn4.setFont(resHelper.getFont("btn4.font"));
        // btn7		
        this.btn7.setText(resHelper.getString("btn7.text"));		
        this.btn7.setFont(resHelper.getFont("btn7.font"));
        // btnN		
        this.btnN.setText(resHelper.getString("btnN.text"));		
        this.btnN.setFont(resHelper.getFont("btnN.font"));
        // btn9		
        this.btn9.setText(resHelper.getString("btn9.text"));		
        this.btn9.setFont(resHelper.getFont("btn9.font"));
        // btnM		
        this.btnM.setText(resHelper.getString("btnM.text"));		
        this.btnM.setFont(resHelper.getFont("btnM.font"));
        // btnBackspace		
        this.btnBackspace.setText(resHelper.getString("btnBackspace.text"));		
        this.btnBackspace.setFont(resHelper.getFont("btnBackspace.font"));
        this.btnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnBackspace_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btnClear		
        this.btnClear.setText(resHelper.getString("btnClear.text"));		
        this.btnClear.setFont(resHelper.getFont("btnClear.font"));
        this.btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnClear_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // btn0		
        this.btn0.setText(resHelper.getString("btn0.text"));		
        this.btn0.setFont(resHelper.getFont("btn0.font"));
        // btnA		
        this.btnA.setText(resHelper.getString("btnA.text"));		
        this.btnA.setFont(resHelper.getFont("btnA.font"));
        // btnB		
        this.btnB.setText(resHelper.getString("btnB.text"));		
        this.btnB.setFont(resHelper.getFont("btnB.font"));
        // btnC		
        this.btnC.setText(resHelper.getString("btnC.text"));		
        this.btnC.setFont(resHelper.getFont("btnC.font"));
        // btnD		
        this.btnD.setText(resHelper.getString("btnD.text"));		
        this.btnD.setFont(resHelper.getFont("btnD.font"));
        // btnE		
        this.btnE.setText(resHelper.getString("btnE.text"));		
        this.btnE.setFont(resHelper.getFont("btnE.font"));
        // btnF		
        this.btnF.setText(resHelper.getString("btnF.text"));		
        this.btnF.setFont(resHelper.getFont("btnF.font"));
        // btnG		
        this.btnG.setText(resHelper.getString("btnG.text"));		
        this.btnG.setFont(resHelper.getFont("btnG.font"));
        // btnH		
        this.btnH.setText(resHelper.getString("btnH.text"));		
        this.btnH.setFont(resHelper.getFont("btnH.font"));
        // btnJ		
        this.btnJ.setText(resHelper.getString("btnJ.text"));		
        this.btnJ.setFont(resHelper.getFont("btnJ.font"));
        // btnK		
        this.btnK.setText(resHelper.getString("btnK.text"));		
        this.btnK.setFont(resHelper.getFont("btnK.font"));
        // btnL		
        this.btnL.setText(resHelper.getString("btnL.text"));		
        this.btnL.setFont(resHelper.getFont("btnL.font"));
        // btnP		
        this.btnP.setText(resHelper.getString("btnP.text"));		
        this.btnP.setFont(resHelper.getFont("btnP.font"));
        // kDLabel1		
        this.kDLabel1.setText(resHelper.getString("kDLabel1.text"));		
        this.kDLabel1.setFont(resHelper.getFont("kDLabel1.font"));
        // txtCarNum		
        this.txtCarNum.setEnabled(false);		
        this.txtCarNum.setFont(resHelper.getFont("txtCarNum.font"));
        // kDLabel5		
        this.kDLabel5.setText(resHelper.getString("kDLabel5.text"));		
        this.kDLabel5.setFont(resHelper.getFont("kDLabel5.font"));
        // txtBillNum		
        this.txtBillNum.setFont(resHelper.getFont("txtBillNum.font"));		
        this.txtBillNum.setEnabled(false);
        // txtFirstTime		
        this.txtFirstTime.setEnabled(false);		
        this.txtFirstTime.setFont(resHelper.getFont("txtFirstTime.font"));
        // txtSecondTime		
        this.txtSecondTime.setEnabled(false);		
        this.txtSecondTime.setFont(resHelper.getFont("txtSecondTime.font"));
        // kDLabel7		
        this.kDLabel7.setText(resHelper.getString("kDLabel7.text"));		
        this.kDLabel7.setFont(resHelper.getFont("kDLabel7.font"));
        // kDLabel8		
        this.kDLabel8.setText(resHelper.getString("kDLabel8.text"));		
        this.kDLabel8.setFont(resHelper.getFont("kDLabel8.font"));
        // btnWeight		
        this.btnWeight.setText(resHelper.getString("btnWeight.text"));		
        this.btnWeight.setFont(resHelper.getFont("btnWeight.font"));		
        this.btnWeight.setForeground(new java.awt.Color(0,0,255));
        this.btnWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                beforeActionPerformed(e);
                try {
                    btnWeight_actionPerformed(e);
                } catch (Exception exc) {
                    handUIException(exc);
                } finally {
                    afterActionPerformed(e);
                }
            }
        });
        // lblStatus		
        this.lblStatus.setText(resHelper.getString("lblStatus.text"));		
        this.lblStatus.setFont(resHelper.getFont("lblStatus.font"));		
        this.lblStatus.setForeground(new java.awt.Color(0,181,0));
        // kDTable1
		String kDTable1StrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol4\"><c:Protection hidden=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"id\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"carNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"number\" t:width=\"120\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"bizDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"status\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"weightNum\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"firstTime\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"secondTime\" t:width=\"180\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header1\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{id}</t:Cell><t:Cell>$Resource{carNum}</t:Cell><t:Cell>$Resource{number}</t:Cell><t:Cell>$Resource{bizDate}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{status}</t:Cell><t:Cell>$Resource{weightNum}</t:Cell><t:Cell>$Resource{firstTime}</t:Cell><t:Cell>$Resource{secondTime}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kDTable1.setFormatXml(resHelper.translateString("kDTable1",kDTable1StrXML));

        

        // kDLabel6		
        this.kDLabel6.setText(resHelper.getString("kDLabel6.text"));		
        this.kDLabel6.setFont(resHelper.getFont("kDLabel6.font"));
        // txtBillQty		
        this.txtBillQty.setFont(resHelper.getFont("txtBillQty.font"));
        // kDLabel3		
        this.kDLabel3.setText(resHelper.getString("kDLabel3.text"));		
        this.kDLabel3.setFont(resHelper.getFont("kDLabel3.font"));
        // txtFirstQty		
        this.txtFirstQty.setEnabled(false);		
        this.txtFirstQty.setFont(resHelper.getFont("txtFirstQty.font"));
        // kDLabel2		
        this.kDLabel2.setText(resHelper.getString("kDLabel2.text"));		
        this.kDLabel2.setFont(resHelper.getFont("kDLabel2.font"));
        // txtSecondQty		
        this.txtSecondQty.setEnabled(false);		
        this.txtSecondQty.setFont(resHelper.getFont("txtSecondQty.font"));
        // kDLabel4		
        this.kDLabel4.setText(resHelper.getString("kDLabel4.text"));		
        this.kDLabel4.setFont(resHelper.getFont("kDLabel4.font"));
        // txtSuttleQty		
        this.txtSuttleQty.setEnabled(false);		
        this.txtSuttleQty.setFont(resHelper.getFont("txtSuttleQty.font"));
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
        kDPanel1.setBounds(new Rectangle(1006, 401, 471, 101));
        this.add(kDPanel1, new KDLayout.Constraints(1006, 401, 471, 101, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel2.setBounds(new Rectangle(489, 9, 511, 312));
        this.add(kDPanel2, new KDLayout.Constraints(489, 9, 511, 312, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel4.setBounds(new Rectangle(12, 90, 473, 230));
        this.add(kDPanel4, new KDLayout.Constraints(12, 90, 473, 230, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel6.setBounds(new Rectangle(14, 9, 470, 78));
        this.add(kDPanel6, new KDLayout.Constraints(14, 9, 470, 78, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel5.setBounds(new Rectangle(13, 324, 986, 304));
        this.add(kDPanel5, new KDLayout.Constraints(13, 324, 986, 304, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDPanel7.setBounds(new Rectangle(1004, 537, 398, 100));
        this.add(kDPanel7, new KDLayout.Constraints(1004, 537, 398, 100, 0));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(1006, 401, 471, 101));        lblWeightValue.setBounds(new Rectangle(12, 14, 441, 74));
        kDPanel1.add(lblWeightValue, new KDLayout.Constraints(12, 14, 441, 74, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(489, 9, 511, 312));        btnQuery.setBounds(new Rectangle(362, 15, 133, 39));
        kDPanel2.add(btnQuery, new KDLayout.Constraints(362, 15, 133, 39, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        txtWeightNum.setBounds(new Rectangle(143, 16, 209, 37));
        kDPanel2.add(txtWeightNum, new KDLayout.Constraints(143, 16, 209, 37, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel3.setBounds(new Rectangle(3, 81, 504, 231));
        kDPanel2.add(kDPanel3, new KDLayout.Constraints(3, 81, 504, 231, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        lblWeightNum.setBounds(new Rectangle(10, 13, 133, 43));
        kDPanel2.add(lblWeightNum, new KDLayout.Constraints(10, 13, 133, 43, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(3, 81, 504, 231));        btn2.setBounds(new Rectangle(361, 64, 45, 45));
        kDPanel3.add(btn2, new KDLayout.Constraints(361, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnX.setBounds(new Rectangle(154, 170, 45, 45));
        kDPanel3.add(btnX, new KDLayout.Constraints(154, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn1.setBounds(new Rectangle(292, 64, 45, 45));
        kDPanel3.add(btn1, new KDLayout.Constraints(292, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn5.setBounds(new Rectangle(361, 116, 45, 45));
        kDPanel3.add(btn5, new KDLayout.Constraints(361, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn3.setBounds(new Rectangle(432, 64, 45, 45));
        kDPanel3.add(btn3, new KDLayout.Constraints(432, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btn6.setBounds(new Rectangle(432, 116, 45, 45));
        kDPanel3.add(btn6, new KDLayout.Constraints(432, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btn8.setBounds(new Rectangle(361, 170, 45, 45));
        kDPanel3.add(btn8, new KDLayout.Constraints(361, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn4.setBounds(new Rectangle(292, 116, 45, 45));
        kDPanel3.add(btn4, new KDLayout.Constraints(292, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn7.setBounds(new Rectangle(292, 170, 45, 45));
        kDPanel3.add(btn7, new KDLayout.Constraints(292, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnN.setBounds(new Rectangle(16, 170, 45, 45));
        kDPanel3.add(btnN, new KDLayout.Constraints(16, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btn9.setBounds(new Rectangle(432, 170, 45, 45));
        kDPanel3.add(btn9, new KDLayout.Constraints(432, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btnM.setBounds(new Rectangle(223, 116, 45, 45));
        kDPanel3.add(btnM, new KDLayout.Constraints(223, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnBackspace.setBounds(new Rectangle(292, 12, 85, 45));
        kDPanel3.add(btnBackspace, new KDLayout.Constraints(292, 12, 85, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnClear.setBounds(new Rectangle(393, 12, 85, 45));
        kDPanel3.add(btnClear, new KDLayout.Constraints(393, 12, 85, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        btn0.setBounds(new Rectangle(223, 170, 45, 45));
        kDPanel3.add(btn0, new KDLayout.Constraints(223, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnA.setBounds(new Rectangle(16, 12, 45, 45));
        kDPanel3.add(btnA, new KDLayout.Constraints(16, 12, 45, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnB.setBounds(new Rectangle(85, 12, 45, 45));
        kDPanel3.add(btnB, new KDLayout.Constraints(85, 12, 45, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnC.setBounds(new Rectangle(154, 12, 45, 45));
        kDPanel3.add(btnC, new KDLayout.Constraints(154, 12, 45, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnD.setBounds(new Rectangle(223, 12, 45, 45));
        kDPanel3.add(btnD, new KDLayout.Constraints(223, 12, 45, 45, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnE.setBounds(new Rectangle(16, 64, 45, 45));
        kDPanel3.add(btnE, new KDLayout.Constraints(16, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnF.setBounds(new Rectangle(85, 64, 45, 45));
        kDPanel3.add(btnF, new KDLayout.Constraints(85, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnG.setBounds(new Rectangle(154, 64, 45, 45));
        kDPanel3.add(btnG, new KDLayout.Constraints(154, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnH.setBounds(new Rectangle(223, 64, 45, 45));
        kDPanel3.add(btnH, new KDLayout.Constraints(223, 64, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnJ.setBounds(new Rectangle(16, 116, 45, 45));
        kDPanel3.add(btnJ, new KDLayout.Constraints(16, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnK.setBounds(new Rectangle(85, 116, 45, 45));
        kDPanel3.add(btnK, new KDLayout.Constraints(85, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnL.setBounds(new Rectangle(154, 116, 45, 45));
        kDPanel3.add(btnL, new KDLayout.Constraints(154, 116, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        btnP.setBounds(new Rectangle(85, 170, 45, 45));
        kDPanel3.add(btnP, new KDLayout.Constraints(85, 170, 45, 45, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(12, 90, 473, 230));        kDLabel1.setBounds(new Rectangle(16, 69, 175, 40));
        kDPanel4.add(kDLabel1, new KDLayout.Constraints(16, 69, 175, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        txtCarNum.setBounds(new Rectangle(195, 20, 260, 40));
        kDPanel4.add(txtCarNum, new KDLayout.Constraints(195, 20, 260, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel5.setBounds(new Rectangle(16, 20, 175, 40));
        kDPanel4.add(kDLabel5, new KDLayout.Constraints(16, 20, 175, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        txtBillNum.setBounds(new Rectangle(195, 69, 260, 40));
        kDPanel4.add(txtBillNum, new KDLayout.Constraints(195, 69, 260, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        txtFirstTime.setBounds(new Rectangle(195, 118, 260, 40));
        kDPanel4.add(txtFirstTime, new KDLayout.Constraints(195, 118, 260, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        txtSecondTime.setBounds(new Rectangle(195, 169, 260, 40));
        kDPanel4.add(txtSecondTime, new KDLayout.Constraints(195, 169, 260, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabel7.setBounds(new Rectangle(16, 118, 175, 40));
        kDPanel4.add(kDLabel7, new KDLayout.Constraints(16, 118, 175, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        kDLabel8.setBounds(new Rectangle(16, 169, 175, 40));
        kDPanel4.add(kDLabel8, new KDLayout.Constraints(16, 169, 175, 40, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT));
        //kDPanel6
        kDPanel6.setLayout(new KDLayout());
        kDPanel6.putClientProperty("OriginalBounds", new Rectangle(14, 9, 470, 78));        btnWeight.setBounds(new Rectangle(258, 6, 185, 57));
        kDPanel6.add(btnWeight, new KDLayout.Constraints(258, 6, 185, 57, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_RIGHT));
        lblStatus.setBounds(new Rectangle(7, 10, 153, 50));
        kDPanel6.add(lblStatus, new KDLayout.Constraints(7, 10, 153, 50, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDPanel5
        kDPanel5.setLayout(new KDLayout());
        kDPanel5.putClientProperty("OriginalBounds", new Rectangle(13, 324, 986, 304));        kDTable1.setBounds(new Rectangle(10, 10, 961, 280));
        kDPanel5.add(kDTable1, new KDLayout.Constraints(10, 10, 961, 280, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel7
        kDPanel7.setLayout(null);        kDLabel6.setBounds(new Rectangle(9, 9, 175, 40));
        kDPanel7.add(kDLabel6, null);
        txtBillQty.setBounds(new Rectangle(188, 9, 260, 40));
        kDPanel7.add(txtBillQty, null);
        kDLabel3.setBounds(new Rectangle(11, 58, 175, 40));
        kDPanel7.add(kDLabel3, null);
        txtFirstQty.setBounds(new Rectangle(190, 58, 260, 40));
        kDPanel7.add(txtFirstQty, null);
        kDLabel2.setBounds(new Rectangle(11, 105, 175, 40));
        kDPanel7.add(kDLabel2, null);
        txtSecondQty.setBounds(new Rectangle(190, 105, 260, 40));
        kDPanel7.add(txtSecondQty, null);
        kDLabel4.setBounds(new Rectangle(11, 152, 175, 40));
        kDPanel7.add(kDLabel4, null);
        txtSuttleQty.setBounds(new Rectangle(190, 152, 260, 40));
        kDPanel7.add(txtSuttleQty, null);

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
	    return "com.kingdee.eas.custom.weightPlatform.app.selfhelpWeightPlatformNoDShowUIHandler";
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
     * output btnBackspace_actionPerformed method
     */
    protected void btnBackspace_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnClear_actionPerformed method
     */
    protected void btnClear_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }

    /**
     * output btnWeight_actionPerformed method
     */
    protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    }


    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.weightPlatform.client", "selfhelpWeightPlatformNoDShowUI");
    }




}