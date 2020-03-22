/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

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
public abstract class AbstractSettlDetectionEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSettlDetectionEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcarNum;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contdriver;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcar;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCarSend;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contChickenSet;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCQtyt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contQCWgt;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtcarNum;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtdriver;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcar;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCarSend;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenZYWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contchickenPYWgt;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contFaecesPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenSZWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenZYWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtchickenPYWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionPY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionZY;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionSZ;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtDeductionKF;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtFaecesPrice;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtChickenSet;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtGrossWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtSmChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenQty;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtCriChickenWgt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQCQtyt;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtQCWgt;
    protected com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo editData = null;
    protected com.kingdee.eas.custom.dx.weight.SettlDetectionInfo entitySettlDetection = null;
    /**
     * output class constructor
     */
    public AbstractSettlDetectionEditUI() throws Exception
    {
        super();
        this.defaultObjectName = "editData";
        jbInit();
        
        initUIP();
    }

    /**
     * output jbInit method
     */
    private void jbInit() throws Exception
    {
        this.resHelper = new ResourceBundleHelper(AbstractSettlDetectionEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcarNum = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contdriver = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcar = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCarSend = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.contChickenSet = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contGrossWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenQty = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQCQtyt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contQCWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtcarNum = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtdriver = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcar = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtCarSend = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.contchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenZYWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contchickenPYWgt = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionPY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionZY = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionSZ = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contDeductionKF = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contFaecesPrice = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtchickenSZWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenZYWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtchickenPYWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionPY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionZY = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionSZ = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtDeductionKF = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtFaecesPrice = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtChickenSet = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtGrossWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSmChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenQty = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtCriChickenWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtQCQtyt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtQCWgt = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcarNum.setName("contcarNum");
        this.contdriver.setName("contdriver");
        this.contcompany.setName("contcompany");
        this.contcar.setName("contcar");
        this.contCarSend.setName("contCarSend");
        this.kDPanel1.setName("kDPanel1");
        this.contChickenSet.setName("contChickenSet");
        this.contGrossQty.setName("contGrossQty");
        this.contGrossWgt.setName("contGrossWgt");
        this.contSmChickenQty.setName("contSmChickenQty");
        this.contSmChickenWgt.setName("contSmChickenWgt");
        this.contCriChickenQty.setName("contCriChickenQty");
        this.contCriChickenWgt.setName("contCriChickenWgt");
        this.contQCQtyt.setName("contQCQtyt");
        this.contQCWgt.setName("contQCWgt");
        this.txtcarNum.setName("txtcarNum");
        this.prmtdriver.setName("prmtdriver");
        this.prmtcompany.setName("prmtcompany");
        this.prmtcar.setName("prmtcar");
        this.prmtCarSend.setName("prmtCarSend");
        this.contchickenSZWgt.setName("contchickenSZWgt");
        this.contchickenZYWgt.setName("contchickenZYWgt");
        this.contchickenPYWgt.setName("contchickenPYWgt");
        this.contDeductionPY.setName("contDeductionPY");
        this.contDeductionZY.setName("contDeductionZY");
        this.contDeductionSZ.setName("contDeductionSZ");
        this.contDeductionKF.setName("contDeductionKF");
        this.contFaecesPrice.setName("contFaecesPrice");
        this.txtchickenSZWgt.setName("txtchickenSZWgt");
        this.txtchickenZYWgt.setName("txtchickenZYWgt");
        this.txtchickenPYWgt.setName("txtchickenPYWgt");
        this.txtDeductionPY.setName("txtDeductionPY");
        this.txtDeductionZY.setName("txtDeductionZY");
        this.txtDeductionSZ.setName("txtDeductionSZ");
        this.txtDeductionKF.setName("txtDeductionKF");
        this.txtFaecesPrice.setName("txtFaecesPrice");
        this.txtChickenSet.setName("txtChickenSet");
        this.txtGrossQty.setName("txtGrossQty");
        this.txtGrossWgt.setName("txtGrossWgt");
        this.txtSmChickenQty.setName("txtSmChickenQty");
        this.txtSmChickenWgt.setName("txtSmChickenWgt");
        this.txtCriChickenQty.setName("txtCriChickenQty");
        this.txtCriChickenWgt.setName("txtCriChickenWgt");
        this.txtQCQtyt.setName("txtQCQtyt");
        this.txtQCWgt.setName("txtQCWgt");
        // CoreUI		
        this.setBorder(null);		
        this.contCreator.setBoundLabelText(resHelper.getString("contCreator.boundLabelText"));		
        this.contCreator.setBoundLabelLength(100);		
        this.contCreator.setBoundLabelUnderline(true);		
        this.contCreator.setEnabled(false);		
        this.contCreateTime.setBoundLabelText(resHelper.getString("contCreateTime.boundLabelText"));		
        this.contCreateTime.setBoundLabelLength(100);		
        this.contCreateTime.setBoundLabelUnderline(true);		
        this.contCreateTime.setEnabled(false);		
        this.contLastUpdateUser.setBoundLabelText(resHelper.getString("contLastUpdateUser.boundLabelText"));		
        this.contLastUpdateUser.setBoundLabelLength(100);		
        this.contLastUpdateUser.setBoundLabelUnderline(true);		
        this.contLastUpdateUser.setEnabled(false);		
        this.contLastUpdateUser.setVisible(true);		
        this.contLastUpdateTime.setBoundLabelText(resHelper.getString("contLastUpdateTime.boundLabelText"));		
        this.contLastUpdateTime.setBoundLabelLength(100);		
        this.contLastUpdateTime.setBoundLabelUnderline(true);		
        this.contLastUpdateTime.setEnabled(false);		
        this.contLastUpdateTime.setVisible(true);		
        this.contNumber.setBoundLabelText(resHelper.getString("contNumber.boundLabelText"));		
        this.contNumber.setBoundLabelLength(100);		
        this.contNumber.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelText(resHelper.getString("contBizDate.boundLabelText"));		
        this.contBizDate.setBoundLabelLength(100);		
        this.contBizDate.setBoundLabelUnderline(true);		
        this.contBizDate.setBoundLabelAlignment(7);		
        this.contBizDate.setVisible(true);		
        this.contDescription.setBoundLabelText(resHelper.getString("contDescription.boundLabelText"));		
        this.contDescription.setBoundLabelLength(100);		
        this.contDescription.setBoundLabelUnderline(true);		
        this.contAuditor.setBoundLabelText(resHelper.getString("contAuditor.boundLabelText"));		
        this.contAuditor.setBoundLabelLength(100);		
        this.contAuditor.setBoundLabelUnderline(true);		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);		
        this.contbillStatus.setBoundLabelText(resHelper.getString("contbillStatus.boundLabelText"));		
        this.contbillStatus.setBoundLabelLength(100);		
        this.contbillStatus.setBoundLabelUnderline(true);		
        this.contbillStatus.setVisible(true);		
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setEnabled(false);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);		
        this.pkauditTime.setRequired(false);		
        this.billStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.billStatus.setRequired(false);
        // contcarNum		
        this.contcarNum.setBoundLabelText(resHelper.getString("contcarNum.boundLabelText"));		
        this.contcarNum.setBoundLabelLength(100);		
        this.contcarNum.setBoundLabelUnderline(true);		
        this.contcarNum.setVisible(true);
        // contdriver		
        this.contdriver.setBoundLabelText(resHelper.getString("contdriver.boundLabelText"));		
        this.contdriver.setBoundLabelLength(100);		
        this.contdriver.setBoundLabelUnderline(true);		
        this.contdriver.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contcar		
        this.contcar.setBoundLabelText(resHelper.getString("contcar.boundLabelText"));		
        this.contcar.setBoundLabelLength(100);		
        this.contcar.setBoundLabelUnderline(true);		
        this.contcar.setVisible(true);
        // contCarSend		
        this.contCarSend.setBoundLabelText(resHelper.getString("contCarSend.boundLabelText"));		
        this.contCarSend.setBoundLabelLength(100);		
        this.contCarSend.setBoundLabelUnderline(true);		
        this.contCarSend.setVisible(true);
        // kDPanel1		
        this.kDPanel1.setBorder(new TitledBorder(BorderFactory.createEtchedBorder(new Color(255,255,255),new Color(148,145,140)), resHelper.getString("kDPanel1.border.title")));
        // contChickenSet		
        this.contChickenSet.setBoundLabelText(resHelper.getString("contChickenSet.boundLabelText"));		
        this.contChickenSet.setBoundLabelLength(100);		
        this.contChickenSet.setBoundLabelUnderline(true);		
        this.contChickenSet.setVisible(true);
        // contGrossQty		
        this.contGrossQty.setBoundLabelText(resHelper.getString("contGrossQty.boundLabelText"));		
        this.contGrossQty.setBoundLabelLength(100);		
        this.contGrossQty.setBoundLabelUnderline(true);		
        this.contGrossQty.setVisible(true);
        // contGrossWgt		
        this.contGrossWgt.setBoundLabelText(resHelper.getString("contGrossWgt.boundLabelText"));		
        this.contGrossWgt.setBoundLabelLength(100);		
        this.contGrossWgt.setBoundLabelUnderline(true);		
        this.contGrossWgt.setVisible(true);
        // contSmChickenQty		
        this.contSmChickenQty.setBoundLabelText(resHelper.getString("contSmChickenQty.boundLabelText"));		
        this.contSmChickenQty.setBoundLabelLength(100);		
        this.contSmChickenQty.setBoundLabelUnderline(true);		
        this.contSmChickenQty.setVisible(true);
        // contSmChickenWgt		
        this.contSmChickenWgt.setBoundLabelText(resHelper.getString("contSmChickenWgt.boundLabelText"));		
        this.contSmChickenWgt.setBoundLabelLength(100);		
        this.contSmChickenWgt.setBoundLabelUnderline(true);		
        this.contSmChickenWgt.setVisible(true);
        // contCriChickenQty		
        this.contCriChickenQty.setBoundLabelText(resHelper.getString("contCriChickenQty.boundLabelText"));		
        this.contCriChickenQty.setBoundLabelLength(100);		
        this.contCriChickenQty.setBoundLabelUnderline(true);		
        this.contCriChickenQty.setVisible(true);
        // contCriChickenWgt		
        this.contCriChickenWgt.setBoundLabelText(resHelper.getString("contCriChickenWgt.boundLabelText"));		
        this.contCriChickenWgt.setBoundLabelLength(100);		
        this.contCriChickenWgt.setBoundLabelUnderline(true);		
        this.contCriChickenWgt.setVisible(true);
        // contQCQtyt		
        this.contQCQtyt.setBoundLabelText(resHelper.getString("contQCQtyt.boundLabelText"));		
        this.contQCQtyt.setBoundLabelLength(100);		
        this.contQCQtyt.setBoundLabelUnderline(true);		
        this.contQCQtyt.setVisible(true);
        // contQCWgt		
        this.contQCWgt.setBoundLabelText(resHelper.getString("contQCWgt.boundLabelText"));		
        this.contQCWgt.setBoundLabelLength(100);		
        this.contQCWgt.setBoundLabelUnderline(true);		
        this.contQCWgt.setVisible(true);
        // txtcarNum		
        this.txtcarNum.setHorizontalAlignment(2);		
        this.txtcarNum.setMaxLength(100);		
        this.txtcarNum.setRequired(false);		
        this.txtcarNum.setEnabled(false);
        // prmtdriver		
        this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
        this.prmtdriver.setEditable(true);		
        this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$number$");		
        this.prmtdriver.setCommitFormat("$number$");		
        this.prmtdriver.setRequired(true);
        		prmtdriver.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI prmtdriver_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtdriver_F7ListUI == null) {
					try {
						prmtdriver_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtdriver_F7ListUI));
					prmtdriver_F7ListUI.setF7Use(true,ctx);
					prmtdriver.setSelector(prmtdriver_F7ListUI);
				}
			}
		});
					
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // prmtcar		
        this.prmtcar.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");		
        this.prmtcar.setVisible(true);		
        this.prmtcar.setEditable(true);		
        this.prmtcar.setDisplayFormat("$name$");		
        this.prmtcar.setEditFormat("$number$");		
        this.prmtcar.setCommitFormat("$number$");		
        this.prmtcar.setRequired(false);
        		prmtcar.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI prmtcar_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcar_F7ListUI == null) {
					try {
						prmtcar_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcar_F7ListUI));
					prmtcar_F7ListUI.setF7Use(true,ctx);
					prmtcar.setSelector(prmtcar_F7ListUI);
				}
			}
		});
					
        // prmtCarSend		
        this.prmtCarSend.setQueryInfo("com.kingdee.eas.custom.dx.weight.app.CarSendBillQuery");		
        this.prmtCarSend.setVisible(true);		
        this.prmtCarSend.setEditable(true);		
        this.prmtCarSend.setDisplayFormat("$number$");		
        this.prmtCarSend.setEditFormat("$number$");		
        this.prmtCarSend.setCommitFormat("$number$");		
        this.prmtCarSend.setRequired(true);
        // contchickenSZWgt		
        this.contchickenSZWgt.setBoundLabelText(resHelper.getString("contchickenSZWgt.boundLabelText"));		
        this.contchickenSZWgt.setBoundLabelLength(100);		
        this.contchickenSZWgt.setBoundLabelUnderline(true);		
        this.contchickenSZWgt.setVisible(true);
        // contchickenZYWgt		
        this.contchickenZYWgt.setBoundLabelText(resHelper.getString("contchickenZYWgt.boundLabelText"));		
        this.contchickenZYWgt.setBoundLabelLength(100);		
        this.contchickenZYWgt.setBoundLabelUnderline(true);		
        this.contchickenZYWgt.setVisible(true);
        // contchickenPYWgt		
        this.contchickenPYWgt.setBoundLabelText(resHelper.getString("contchickenPYWgt.boundLabelText"));		
        this.contchickenPYWgt.setBoundLabelLength(100);		
        this.contchickenPYWgt.setBoundLabelUnderline(true);		
        this.contchickenPYWgt.setVisible(true);
        // contDeductionPY		
        this.contDeductionPY.setBoundLabelText(resHelper.getString("contDeductionPY.boundLabelText"));		
        this.contDeductionPY.setBoundLabelLength(100);		
        this.contDeductionPY.setBoundLabelUnderline(true);		
        this.contDeductionPY.setVisible(true);
        // contDeductionZY		
        this.contDeductionZY.setBoundLabelText(resHelper.getString("contDeductionZY.boundLabelText"));		
        this.contDeductionZY.setBoundLabelLength(100);		
        this.contDeductionZY.setBoundLabelUnderline(true);		
        this.contDeductionZY.setVisible(true);
        // contDeductionSZ		
        this.contDeductionSZ.setBoundLabelText(resHelper.getString("contDeductionSZ.boundLabelText"));		
        this.contDeductionSZ.setBoundLabelLength(100);		
        this.contDeductionSZ.setBoundLabelUnderline(true);		
        this.contDeductionSZ.setVisible(true);
        // contDeductionKF		
        this.contDeductionKF.setBoundLabelText(resHelper.getString("contDeductionKF.boundLabelText"));		
        this.contDeductionKF.setBoundLabelLength(100);		
        this.contDeductionKF.setBoundLabelUnderline(true);		
        this.contDeductionKF.setVisible(true);
        // contFaecesPrice		
        this.contFaecesPrice.setBoundLabelText(resHelper.getString("contFaecesPrice.boundLabelText"));		
        this.contFaecesPrice.setBoundLabelLength(100);		
        this.contFaecesPrice.setBoundLabelUnderline(true);		
        this.contFaecesPrice.setVisible(true);
        // txtchickenSZWgt		
        this.txtchickenSZWgt.setHorizontalAlignment(2);		
        this.txtchickenSZWgt.setDataType(1);		
        this.txtchickenSZWgt.setSupportedEmpty(true);		
        this.txtchickenSZWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenSZWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenSZWgt.setPrecision(4);		
        this.txtchickenSZWgt.setRequired(false);
        // txtchickenZYWgt		
        this.txtchickenZYWgt.setVisible(true);		
        this.txtchickenZYWgt.setHorizontalAlignment(2);		
        this.txtchickenZYWgt.setDataType(1);		
        this.txtchickenZYWgt.setSupportedEmpty(true);		
        this.txtchickenZYWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenZYWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenZYWgt.setPrecision(4);		
        this.txtchickenZYWgt.setRequired(false);
        // txtchickenPYWgt		
        this.txtchickenPYWgt.setVisible(true);		
        this.txtchickenPYWgt.setHorizontalAlignment(2);		
        this.txtchickenPYWgt.setDataType(1);		
        this.txtchickenPYWgt.setSupportedEmpty(true);		
        this.txtchickenPYWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtchickenPYWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtchickenPYWgt.setPrecision(4);		
        this.txtchickenPYWgt.setRequired(false);
        // txtDeductionPY		
        this.txtDeductionPY.setVisible(true);		
        this.txtDeductionPY.setHorizontalAlignment(2);		
        this.txtDeductionPY.setDataType(1);		
        this.txtDeductionPY.setSupportedEmpty(true);		
        this.txtDeductionPY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionPY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionPY.setPrecision(2);		
        this.txtDeductionPY.setRequired(false);
        // txtDeductionZY		
        this.txtDeductionZY.setVisible(true);		
        this.txtDeductionZY.setHorizontalAlignment(2);		
        this.txtDeductionZY.setDataType(1);		
        this.txtDeductionZY.setSupportedEmpty(true);		
        this.txtDeductionZY.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionZY.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionZY.setPrecision(2);		
        this.txtDeductionZY.setRequired(false);
        // txtDeductionSZ		
        this.txtDeductionSZ.setVisible(true);		
        this.txtDeductionSZ.setHorizontalAlignment(2);		
        this.txtDeductionSZ.setDataType(1);		
        this.txtDeductionSZ.setSupportedEmpty(true);		
        this.txtDeductionSZ.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionSZ.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionSZ.setPrecision(2);		
        this.txtDeductionSZ.setRequired(false);
        // txtDeductionKF		
        this.txtDeductionKF.setVisible(true);		
        this.txtDeductionKF.setHorizontalAlignment(2);		
        this.txtDeductionKF.setDataType(1);		
        this.txtDeductionKF.setSupportedEmpty(true);		
        this.txtDeductionKF.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtDeductionKF.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtDeductionKF.setPrecision(2);		
        this.txtDeductionKF.setRequired(false);
        // txtFaecesPrice		
        this.txtFaecesPrice.setVisible(true);		
        this.txtFaecesPrice.setHorizontalAlignment(2);		
        this.txtFaecesPrice.setDataType(1);		
        this.txtFaecesPrice.setSupportedEmpty(true);		
        this.txtFaecesPrice.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtFaecesPrice.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtFaecesPrice.setPrecision(4);		
        this.txtFaecesPrice.setRequired(false);
        // txtChickenSet		
        this.txtChickenSet.setVisible(true);		
        this.txtChickenSet.setHorizontalAlignment(2);		
        this.txtChickenSet.setDataType(1);		
        this.txtChickenSet.setSupportedEmpty(true);		
        this.txtChickenSet.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtChickenSet.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtChickenSet.setPrecision(4);		
        this.txtChickenSet.setRequired(false);
        // txtGrossQty		
        this.txtGrossQty.setVisible(true);		
        this.txtGrossQty.setHorizontalAlignment(2);		
        this.txtGrossQty.setDataType(1);		
        this.txtGrossQty.setSupportedEmpty(true);		
        this.txtGrossQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossQty.setPrecision(4);		
        this.txtGrossQty.setRequired(false);
        // txtGrossWgt		
        this.txtGrossWgt.setVisible(true);		
        this.txtGrossWgt.setHorizontalAlignment(2);		
        this.txtGrossWgt.setDataType(1);		
        this.txtGrossWgt.setSupportedEmpty(true);		
        this.txtGrossWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtGrossWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtGrossWgt.setPrecision(4);		
        this.txtGrossWgt.setRequired(false);
        // txtSmChickenQty		
        this.txtSmChickenQty.setVisible(true);		
        this.txtSmChickenQty.setHorizontalAlignment(2);		
        this.txtSmChickenQty.setDataType(1);		
        this.txtSmChickenQty.setSupportedEmpty(true);		
        this.txtSmChickenQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSmChickenQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSmChickenQty.setPrecision(4);		
        this.txtSmChickenQty.setRequired(false);
        // txtSmChickenWgt		
        this.txtSmChickenWgt.setVisible(true);		
        this.txtSmChickenWgt.setHorizontalAlignment(2);		
        this.txtSmChickenWgt.setDataType(1);		
        this.txtSmChickenWgt.setSupportedEmpty(true);		
        this.txtSmChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtSmChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtSmChickenWgt.setPrecision(4);		
        this.txtSmChickenWgt.setRequired(false);
        // txtCriChickenQty		
        this.txtCriChickenQty.setVisible(true);		
        this.txtCriChickenQty.setHorizontalAlignment(2);		
        this.txtCriChickenQty.setDataType(1);		
        this.txtCriChickenQty.setSupportedEmpty(true);		
        this.txtCriChickenQty.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCriChickenQty.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCriChickenQty.setPrecision(4);		
        this.txtCriChickenQty.setRequired(false);
        // txtCriChickenWgt		
        this.txtCriChickenWgt.setVisible(true);		
        this.txtCriChickenWgt.setHorizontalAlignment(2);		
        this.txtCriChickenWgt.setDataType(1);		
        this.txtCriChickenWgt.setSupportedEmpty(true);		
        this.txtCriChickenWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtCriChickenWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtCriChickenWgt.setPrecision(4);		
        this.txtCriChickenWgt.setRequired(false);
        // txtQCQtyt		
        this.txtQCQtyt.setVisible(true);		
        this.txtQCQtyt.setHorizontalAlignment(2);		
        this.txtQCQtyt.setDataType(1);		
        this.txtQCQtyt.setSupportedEmpty(true);		
        this.txtQCQtyt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQCQtyt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQCQtyt.setPrecision(4);		
        this.txtQCQtyt.setRequired(false);
        // txtQCWgt		
        this.txtQCWgt.setVisible(true);		
        this.txtQCWgt.setHorizontalAlignment(2);		
        this.txtQCWgt.setDataType(1);		
        this.txtQCWgt.setSupportedEmpty(true);		
        this.txtQCWgt.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtQCWgt.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtQCWgt.setPrecision(4);		
        this.txtQCWgt.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtNumber,pkBizDate,txtDescription,prmtAuditor,prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,txtcarNum,prmtdriver,pkauditTime,prmtcompany,txtchickenSZWgt,billStatus,prmtCarSend,txtchickenPYWgt,txtchickenZYWgt,txtChickenSet,txtGrossQty,txtGrossWgt,prmtcar,txtSmChickenQty,txtSmChickenWgt,txtCriChickenQty,txtCriChickenWgt,txtQCQtyt,txtQCWgt,txtDeductionSZ,txtDeductionZY,txtDeductionPY,txtDeductionKF,txtFaecesPrice}));
        this.setFocusCycleRoot(true);
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
        this.setBounds(new Rectangle(0, 0, 1013, 531));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 531));
        contCreator.setBounds(new Rectangle(364, 465, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(364, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(709, 465, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(709, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateUser.setBounds(new Rectangle(364, 496, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(364, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateTime.setBounds(new Rectangle(709, 496, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(709, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(369, 18, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(369, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(24, 18, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(24, 18, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(714, 51, 271, 19));
        this.add(contDescription, new KDLayout.Constraints(714, 51, 271, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(19, 465, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(19, 465, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(19, 496, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(19, 496, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(714, 16, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(714, 16, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcarNum.setBounds(new Rectangle(369, 87, 270, 19));
        this.add(contcarNum, new KDLayout.Constraints(369, 87, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contdriver.setBounds(new Rectangle(24, 90, 270, 19));
        this.add(contdriver, new KDLayout.Constraints(24, 90, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcompany.setBounds(new Rectangle(24, 55, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(24, 55, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contcar.setBounds(new Rectangle(714, 85, 270, 19));
        this.add(contcar, new KDLayout.Constraints(714, 85, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCarSend.setBounds(new Rectangle(369, 53, 270, 19));
        this.add(contCarSend, new KDLayout.Constraints(369, 53, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDPanel1.setBounds(new Rectangle(9, 227, 998, 224));
        this.add(kDPanel1, new KDLayout.Constraints(9, 227, 998, 224, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contChickenSet.setBounds(new Rectangle(23, 127, 270, 19));
        this.add(contChickenSet, new KDLayout.Constraints(23, 127, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossQty.setBounds(new Rectangle(23, 160, 270, 19));
        this.add(contGrossQty, new KDLayout.Constraints(23, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contGrossWgt.setBounds(new Rectangle(24, 195, 270, 19));
        this.add(contGrossWgt, new KDLayout.Constraints(24, 195, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSmChickenQty.setBounds(new Rectangle(368, 159, 270, 19));
        this.add(contSmChickenQty, new KDLayout.Constraints(368, 159, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contSmChickenWgt.setBounds(new Rectangle(368, 193, 270, 19));
        this.add(contSmChickenWgt, new KDLayout.Constraints(368, 193, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCriChickenQty.setBounds(new Rectangle(715, 156, 270, 19));
        this.add(contCriChickenQty, new KDLayout.Constraints(715, 156, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contCriChickenWgt.setBounds(new Rectangle(715, 191, 270, 19));
        this.add(contCriChickenWgt, new KDLayout.Constraints(715, 191, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contQCQtyt.setBounds(new Rectangle(368, 125, 270, 19));
        this.add(contQCQtyt, new KDLayout.Constraints(368, 125, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contQCWgt.setBounds(new Rectangle(714, 120, 270, 19));
        this.add(contQCWgt, new KDLayout.Constraints(714, 120, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        //contCreator
        contCreator.setBoundEditor(prmtCreator);
        //contCreateTime
        contCreateTime.setBoundEditor(kDDateCreateTime);
        //contLastUpdateUser
        contLastUpdateUser.setBoundEditor(prmtLastUpdateUser);
        //contLastUpdateTime
        contLastUpdateTime.setBoundEditor(kDDateLastUpdateTime);
        //contNumber
        contNumber.setBoundEditor(txtNumber);
        //contBizDate
        contBizDate.setBoundEditor(pkBizDate);
        //contDescription
        contDescription.setBoundEditor(txtDescription);
        //contAuditor
        contAuditor.setBoundEditor(prmtAuditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contbillStatus
        contbillStatus.setBoundEditor(billStatus);
        //contcarNum
        contcarNum.setBoundEditor(txtcarNum);
        //contdriver
        contdriver.setBoundEditor(prmtdriver);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contcar
        contcar.setBoundEditor(prmtcar);
        //contCarSend
        contCarSend.setBoundEditor(prmtCarSend);
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(9, 227, 998, 224));        contchickenSZWgt.setBounds(new Rectangle(19, 29, 270, 19));
        kDPanel1.add(contchickenSZWgt, new KDLayout.Constraints(19, 29, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenZYWgt.setBounds(new Rectangle(19, 73, 270, 19));
        kDPanel1.add(contchickenZYWgt, new KDLayout.Constraints(19, 73, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contchickenPYWgt.setBounds(new Rectangle(19, 117, 270, 19));
        kDPanel1.add(contchickenPYWgt, new KDLayout.Constraints(19, 117, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionPY.setBounds(new Rectangle(359, 111, 270, 19));
        kDPanel1.add(contDeductionPY, new KDLayout.Constraints(359, 111, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionZY.setBounds(new Rectangle(359, 68, 270, 19));
        kDPanel1.add(contDeductionZY, new KDLayout.Constraints(359, 68, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionSZ.setBounds(new Rectangle(358, 27, 270, 19));
        kDPanel1.add(contDeductionSZ, new KDLayout.Constraints(358, 27, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDeductionKF.setBounds(new Rectangle(359, 160, 270, 19));
        kDPanel1.add(contDeductionKF, new KDLayout.Constraints(359, 160, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contFaecesPrice.setBounds(new Rectangle(19, 162, 270, 19));
        kDPanel1.add(contFaecesPrice, new KDLayout.Constraints(19, 162, 270, 19, 0));
        //contchickenSZWgt
        contchickenSZWgt.setBoundEditor(txtchickenSZWgt);
        //contchickenZYWgt
        contchickenZYWgt.setBoundEditor(txtchickenZYWgt);
        //contchickenPYWgt
        contchickenPYWgt.setBoundEditor(txtchickenPYWgt);
        //contDeductionPY
        contDeductionPY.setBoundEditor(txtDeductionPY);
        //contDeductionZY
        contDeductionZY.setBoundEditor(txtDeductionZY);
        //contDeductionSZ
        contDeductionSZ.setBoundEditor(txtDeductionSZ);
        //contDeductionKF
        contDeductionKF.setBoundEditor(txtDeductionKF);
        //contFaecesPrice
        contFaecesPrice.setBoundEditor(txtFaecesPrice);
        //contChickenSet
        contChickenSet.setBoundEditor(txtChickenSet);
        //contGrossQty
        contGrossQty.setBoundEditor(txtGrossQty);
        //contGrossWgt
        contGrossWgt.setBoundEditor(txtGrossWgt);
        //contSmChickenQty
        contSmChickenQty.setBoundEditor(txtSmChickenQty);
        //contSmChickenWgt
        contSmChickenWgt.setBoundEditor(txtSmChickenWgt);
        //contCriChickenQty
        contCriChickenQty.setBoundEditor(txtCriChickenQty);
        //contCriChickenWgt
        contCriChickenWgt.setBoundEditor(txtCriChickenWgt);
        //contQCQtyt
        contQCQtyt.setBoundEditor(txtQCQtyt);
        //contQCWgt
        contQCWgt.setBoundEditor(txtQCWgt);

    }


    /**
     * output initUIMenuBarLayout method
     */
    public void initUIMenuBarLayout()
    {
        this.menuBar.add(menuFile);
        this.menuBar.add(menuEdit);
        this.menuBar.add(MenuService);
        this.menuBar.add(menuView);
        this.menuBar.add(menuBiz);
        this.menuBar.add(menuTable1);
        this.menuBar.add(menuTool);
        this.menuBar.add(menuWorkflow);
        this.menuBar.add(menuHelp);
        //menuFile
        menuFile.add(menuItemAddNew);
        menuFile.add(kDSeparator1);
        menuFile.add(menuItemCloudFeed);
        menuFile.add(menuItemSave);
        menuFile.add(menuItemCloudScreen);
        menuFile.add(menuItemSubmit);
        menuFile.add(menuItemCloudShare);
        menuFile.add(menuSubmitOption);
        menuFile.add(kdSeparatorFWFile1);
        menuFile.add(rMenuItemSubmit);
        menuFile.add(rMenuItemSubmitAndAddNew);
        menuFile.add(rMenuItemSubmitAndPrint);
        menuFile.add(separatorFile1);
        menuFile.add(MenuItemAttachment);
        menuFile.add(kDSeparator2);
        menuFile.add(menuItemPageSetup);
        menuFile.add(menuItemPrint);
        menuFile.add(menuItemPrintPreview);
        menuFile.add(kDSeparator6);
        menuFile.add(menuItemSendMail);
        menuFile.add(kDSeparator3);
        menuFile.add(menuItemExitCurrent);
        //menuSubmitOption
        menuSubmitOption.add(chkMenuItemSubmitAndAddNew);
        menuSubmitOption.add(chkMenuItemSubmitAndPrint);
        //menuEdit
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemEdit);
        menuEdit.add(menuItemRemove);
        menuEdit.add(kDSeparator4);
        menuEdit.add(menuItemReset);
        menuEdit.add(separator1);
        menuEdit.add(menuItemCreateFrom);
        menuEdit.add(menuItemCreateTo);
        menuEdit.add(menuItemCopyFrom);
        menuEdit.add(separatorEdit1);
        menuEdit.add(menuItemEnterToNextRow);
        menuEdit.add(separator2);
        //MenuService
        MenuService.add(MenuItemKnowStore);
        MenuService.add(MenuItemAnwser);
        MenuService.add(SepratorService);
        MenuService.add(MenuItemRemoteAssist);
        //menuView
        menuView.add(menuItemFirst);
        menuView.add(menuItemPre);
        menuView.add(menuItemNext);
        menuView.add(menuItemLast);
        menuView.add(separator3);
        menuView.add(menuItemTraceUp);
        menuView.add(menuItemTraceDown);
        menuView.add(kDSeparator7);
        menuView.add(menuItemLocate);
        //menuBiz
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        menuBiz.add(MenuItemVoucher);
        menuBiz.add(MenuItemPCVoucher);
        menuBiz.add(menuItemDelVoucher);
        menuBiz.add(menuItemDelPCVoucher);
        //menuTable1
        menuTable1.add(menuItemAddLine);
        menuTable1.add(menuItemCopyLine);
        menuTable1.add(menuItemInsertLine);
        menuTable1.add(menuItemRemoveLine);
        //menuTool
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
        //menuWorkflow
        menuWorkflow.add(menuItemStartWorkFlow);
        menuWorkflow.add(separatorWF1);
        menuWorkflow.add(menuItemViewSubmitProccess);
        menuWorkflow.add(menuItemViewDoProccess);
        menuWorkflow.add(MenuItemWFG);
        menuWorkflow.add(menuItemWorkFlowList);
        menuWorkflow.add(separatorWF2);
        menuWorkflow.add(menuItemMultiapprove);
        menuWorkflow.add(menuItemNextPerson);
        menuWorkflow.add(menuItemAuditResult);
        menuWorkflow.add(kDSeparator5);
        menuWorkflow.add(kDMenuItemSendMessage);
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
        this.toolBar.add(btnAddNew);
        this.toolBar.add(btnCloud);
        this.toolBar.add(btnEdit);
        this.toolBar.add(btnXunTong);
        this.toolBar.add(btnSave);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnReset);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);
        this.toolBar.add(btnAttachment);
        this.toolBar.add(separatorFW1);
        this.toolBar.add(btnPageSetup);
        this.toolBar.add(btnPrint);
        this.toolBar.add(btnPrintPreview);
        this.toolBar.add(separatorFW2);
        this.toolBar.add(btnFirst);
        this.toolBar.add(btnPre);
        this.toolBar.add(btnNext);
        this.toolBar.add(btnLast);
        this.toolBar.add(separatorFW3);
        this.toolBar.add(btnTraceUp);
        this.toolBar.add(btnTraceDown);
        this.toolBar.add(btnWorkFlowG);
        this.toolBar.add(btnSignature);
        this.toolBar.add(btnViewSignature);
        this.toolBar.add(separatorFW4);
        this.toolBar.add(btnNumberSign);
        this.toolBar.add(separatorFW7);
        this.toolBar.add(btnCreateFrom);
        this.toolBar.add(btnCopyFrom);
        this.toolBar.add(btnCreateTo);
        this.toolBar.add(separatorFW5);
        this.toolBar.add(separatorFW8);
        this.toolBar.add(btnAddLine);
        this.toolBar.add(btnCopyLine);
        this.toolBar.add(btnInsertLine);
        this.toolBar.add(btnRemoveLine);
        this.toolBar.add(separatorFW6);
        this.toolBar.add(separatorFW9);
        this.toolBar.add(btnVoucher);
        this.toolBar.add(btnPCVoucher);
        this.toolBar.add(btnDelVoucher);
        this.toolBar.add(btnDelPCVoucher);
        this.toolBar.add(btnAuditResult);
        this.toolBar.add(btnMultiapprove);
        this.toolBar.add(btnWFViewdoProccess);
        this.toolBar.add(btnWFViewSubmitProccess);
        this.toolBar.add(btnNextPerson);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("bizDate", java.util.Date.class, this.pkBizDate, "value");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtAuditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("billStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.billStatus, "selectedItem");
		dataBinder.registerBinding("carNum", String.class, this.txtcarNum, "text");
		dataBinder.registerBinding("driver", com.kingdee.eas.farm.feemanager.basedata.DriverInfo.class, this.prmtdriver, "data");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("car", com.kingdee.eas.publicdata.CarInfo.class, this.prmtcar, "data");
		dataBinder.registerBinding("CarSend", com.kingdee.eas.custom.dx.weight.CarSendBillInfo.class, this.prmtCarSend, "data");
		dataBinder.registerBinding("chickenSZWgt", java.math.BigDecimal.class, this.txtchickenSZWgt, "value");
		dataBinder.registerBinding("chickenZYWgt", java.math.BigDecimal.class, this.txtchickenZYWgt, "value");
		dataBinder.registerBinding("chickenPYWgt", java.math.BigDecimal.class, this.txtchickenPYWgt, "value");
		dataBinder.registerBinding("DeductionPY", java.math.BigDecimal.class, this.txtDeductionPY, "value");
		dataBinder.registerBinding("DeductionZY", java.math.BigDecimal.class, this.txtDeductionZY, "value");
		dataBinder.registerBinding("DeductionSZ", java.math.BigDecimal.class, this.txtDeductionSZ, "value");
		dataBinder.registerBinding("DeductionKF", java.math.BigDecimal.class, this.txtDeductionKF, "value");
		dataBinder.registerBinding("FaecesPrice", java.math.BigDecimal.class, this.txtFaecesPrice, "value");
		dataBinder.registerBinding("ChickenSet", java.math.BigDecimal.class, this.txtChickenSet, "value");
		dataBinder.registerBinding("GrossQty", java.math.BigDecimal.class, this.txtGrossQty, "value");
		dataBinder.registerBinding("GrossWgt", java.math.BigDecimal.class, this.txtGrossWgt, "value");
		dataBinder.registerBinding("SmChickenQty", java.math.BigDecimal.class, this.txtSmChickenQty, "value");
		dataBinder.registerBinding("SmChickenWgt", java.math.BigDecimal.class, this.txtSmChickenWgt, "value");
		dataBinder.registerBinding("CriChickenQty", java.math.BigDecimal.class, this.txtCriChickenQty, "value");
		dataBinder.registerBinding("CriChickenWgt", java.math.BigDecimal.class, this.txtCriChickenWgt, "value");
		dataBinder.registerBinding("QCQtyt", java.math.BigDecimal.class, this.txtQCQtyt, "value");
		dataBinder.registerBinding("QCWgt", java.math.BigDecimal.class, this.txtQCWgt, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.dx.weight.app.SettlDetectionEditUIHandler";
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
     * output onShow method
     */
    public void onShow() throws Exception
    {
        super.onShow();
        this.txtNumber.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo)ov;
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(String key, IObjectValue dataObject)
    {
        super.setDataObject(key, dataObject);
	}
    protected void removeByPK(IObjectPK pk) throws Exception {
    	IObjectValue editData = this.editData;
    	super.removeByPK(pk);
    	recycleNumberByOrg(editData,"NONE",editData.getString("number"));
    }
    
    protected void recycleNumberByOrg(IObjectValue editData,String orgType,String number) {
        if (!StringUtils.isEmpty(number))
        {
            try {
            	String companyID = null;            
            	com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID =com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}				
				if (!StringUtils.isEmpty(companyID) && iCodingRuleManager.isExist(editData, companyID) && iCodingRuleManager.isUseIntermitNumber(editData, companyID)) {
					iCodingRuleManager.recycleNumber(editData,companyID,number);					
				}
            }
            catch (Exception e)
            {
                handUIException(e);
            }
        }
    }
    protected void setAutoNumberByOrg(String orgType) {
    	if (editData == null) return;
		if (editData.getNumber() == null) {
            try {
            	String companyID = null;
				if(!com.kingdee.util.StringUtils.isEmpty(orgType) && !"NONE".equalsIgnoreCase(orgType) && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType))!=null) {
					companyID = com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum(orgType)).getString("id");
				}
				else if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit() != null) {
					companyID = ((com.kingdee.eas.basedata.org.OrgUnitInfo)com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit()).getString("id");
            	}
				com.kingdee.eas.base.codingrule.ICodingRuleManager iCodingRuleManager = com.kingdee.eas.base.codingrule.CodingRuleManagerFactory.getRemoteInstance();
		        if (iCodingRuleManager.isExist(editData, companyID)) {
		            if (iCodingRuleManager.isAddView(editData, companyID)) {
		            	editData.setNumber(iCodingRuleManager.getNumber(editData,companyID));
		            }
	                txtNumber.setEnabled(false);
		        }
            }
            catch (Exception e) {
                handUIException(e);
                this.oldData = editData;
                com.kingdee.eas.util.SysUtil.abort();
            } 
        } 
        else {
            if (editData.getNumber().trim().length() > 0) {
                txtNumber.setText(editData.getNumber());
            }
        }
    }

    /**
     * output loadFields method
     */
    public void loadFields()
    {
        		setAutoNumberByOrg("NONE");
        dataBinder.loadFields();
    }
		protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
		{
			com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
			oufip.getModel().setIsCUFilter(true);
			f7.setFilterInfoProducer(oufip);
		}

    /**
     * output storeFields method
     */
    public void storeFields()
    {
		dataBinder.storeFields();
    }

	/**
	 * ????????У??
	 */
	protected void registerValidator() {
    	getValidateHelper().setCustomValidator( getValidator() );
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bizDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("billStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("carNum", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("driver", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("car", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CarSend", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenSZWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenZYWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("chickenPYWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionPY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionZY", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionSZ", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DeductionKF", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("FaecesPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ChickenSet", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("GrossWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("SmChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("CriChickenWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCQtyt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("QCWgt", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
        } else if (STATUS_EDIT.equals(this.oprtState)) {
        } else if (STATUS_VIEW.equals(this.oprtState)) {
        } else if (STATUS_FINDVIEW.equals(this.oprtState)) {
        }
    }

    /**
     * output getSelectors method
     */
    public SelectorItemCollection getSelectors()
    {
        SelectorItemCollection sic = new SelectorItemCollection();
		String selectorAll = System.getProperty("selector.all");
		if(StringUtils.isEmpty(selectorAll)){
			selectorAll = "true";
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("lastUpdateTime"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("bizDate"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("auditor.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("auditor.id"));
        	sic.add(new SelectorItemInfo("auditor.number"));
        	sic.add(new SelectorItemInfo("auditor.name"));
		}
        sic.add(new SelectorItemInfo("auditTime"));
        sic.add(new SelectorItemInfo("billStatus"));
        sic.add(new SelectorItemInfo("carNum"));
        sic.add(new SelectorItemInfo("driver"));
        sic.add(new SelectorItemInfo("company"));
        sic.add(new SelectorItemInfo("car"));
        sic.add(new SelectorItemInfo("chickenSZWgt"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.dx.weight.client", "SettlDetectionEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.dx.weight.client.SettlDetectionEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.SettlDetectionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.SettlDetectionInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettlDetectionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/dx/weight/SettlDetection";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.dx.weight.app.SettlDetectionQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtdriver.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"司机"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtCarSend.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"派车单"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {        
        return null;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}