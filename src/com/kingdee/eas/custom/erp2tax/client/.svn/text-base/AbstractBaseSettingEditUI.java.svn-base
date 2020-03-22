/**
 * output package name
 */
package com.kingdee.eas.custom.erp2tax.client;

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
public abstract class AbstractBaseSettingEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBaseSettingEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxmlPath;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contxmlBackupPath;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttxtPath;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaxRow;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contSpbm;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttxtBackupPath;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contmaxAmount;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtxmlPath;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtxmlBackupPath;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttxtPath;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmaxRow;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSpbm;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttxtBackupPath;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtmaxAmount;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttaxNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbankNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttaxNo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtbankNo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkeystoreName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continterfaceUrl;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpasswd;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contkeystoreAbner;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contappCode;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtkeystoreName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtinterfaceUrl;
    protected com.kingdee.bos.ctrl.swing.KDPasswordField txtpasswd;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtkeystoreAbner;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtappCode;
    protected com.kingdee.eas.custom.erp2tax.BaseSettingInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractBaseSettingEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBaseSettingEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxmlPath = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contxmlBackupPath = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttxtPath = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaxRow = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contSpbm = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttxtBackupPath = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contmaxAmount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtxmlPath = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtxmlBackupPath = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttxtPath = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmaxRow = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtSpbm = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttxtBackupPath = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtmaxAmount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.conttaxNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbankNo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txttaxNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtbankNo = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.contkeystoreName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continterfaceUrl = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpasswd = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contkeystoreAbner = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contappCode = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtkeystoreName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtinterfaceUrl = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtpasswd = new com.kingdee.bos.ctrl.swing.KDPasswordField();
        this.txtkeystoreAbner = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtappCode = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contcompany.setName("contcompany");
        this.contxmlPath.setName("contxmlPath");
        this.contxmlBackupPath.setName("contxmlBackupPath");
        this.conttxtPath.setName("conttxtPath");
        this.contmaxRow.setName("contmaxRow");
        this.contSpbm.setName("contSpbm");
        this.conttxtBackupPath.setName("conttxtBackupPath");
        this.contmaxAmount.setName("contmaxAmount");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtcompany.setName("prmtcompany");
        this.txtxmlPath.setName("txtxmlPath");
        this.txtxmlBackupPath.setName("txtxmlBackupPath");
        this.txttxtPath.setName("txttxtPath");
        this.txtmaxRow.setName("txtmaxRow");
        this.txtSpbm.setName("txtSpbm");
        this.txttxtBackupPath.setName("txttxtBackupPath");
        this.txtmaxAmount.setName("txtmaxAmount");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel1.setName("kDPanel1");
        this.conttaxNo.setName("conttaxNo");
        this.contaddress.setName("contaddress");
        this.contbankName.setName("contbankName");
        this.conttel.setName("conttel");
        this.contbankNo.setName("contbankNo");
        this.txttaxNo.setName("txttaxNo");
        this.txtaddress.setName("txtaddress");
        this.txtbankName.setName("txtbankName");
        this.txttel.setName("txttel");
        this.txtbankNo.setName("txtbankNo");
        this.contkeystoreName.setName("contkeystoreName");
        this.continterfaceUrl.setName("continterfaceUrl");
        this.contpasswd.setName("contpasswd");
        this.contkeystoreAbner.setName("contkeystoreAbner");
        this.contappCode.setName("contappCode");
        this.txtkeystoreName.setName("txtkeystoreName");
        this.txtinterfaceUrl.setName("txtinterfaceUrl");
        this.txtpasswd.setName("txtpasswd");
        this.txtkeystoreAbner.setName("txtkeystoreAbner");
        this.txtappCode.setName("txtappCode");
        // CoreUI		
        this.btnPrint.setVisible(false);		
        this.btnPrintPreview.setVisible(false);		
        this.menuItemPrint.setVisible(false);		
        this.menuItemPrintPreview.setVisible(false);
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
        this.kDLabelContainer3.setVisible(false);
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contxmlPath		
        this.contxmlPath.setBoundLabelText(resHelper.getString("contxmlPath.boundLabelText"));		
        this.contxmlPath.setBoundLabelLength(100);		
        this.contxmlPath.setBoundLabelUnderline(true);		
        this.contxmlPath.setVisible(false);
        // contxmlBackupPath		
        this.contxmlBackupPath.setBoundLabelText(resHelper.getString("contxmlBackupPath.boundLabelText"));		
        this.contxmlBackupPath.setBoundLabelLength(100);		
        this.contxmlBackupPath.setBoundLabelUnderline(true);		
        this.contxmlBackupPath.setVisible(false);
        // conttxtPath		
        this.conttxtPath.setBoundLabelText(resHelper.getString("conttxtPath.boundLabelText"));		
        this.conttxtPath.setBoundLabelLength(100);		
        this.conttxtPath.setBoundLabelUnderline(true);		
        this.conttxtPath.setVisible(false);
        // contmaxRow		
        this.contmaxRow.setBoundLabelText(resHelper.getString("contmaxRow.boundLabelText"));		
        this.contmaxRow.setBoundLabelLength(100);		
        this.contmaxRow.setBoundLabelUnderline(true);		
        this.contmaxRow.setVisible(true);
        // contSpbm		
        this.contSpbm.setBoundLabelText(resHelper.getString("contSpbm.boundLabelText"));		
        this.contSpbm.setBoundLabelLength(100);		
        this.contSpbm.setBoundLabelUnderline(true);		
        this.contSpbm.setVisible(true);
        // conttxtBackupPath		
        this.conttxtBackupPath.setBoundLabelText(resHelper.getString("conttxtBackupPath.boundLabelText"));		
        this.conttxtBackupPath.setBoundLabelLength(100);		
        this.conttxtBackupPath.setBoundLabelUnderline(true);		
        this.conttxtBackupPath.setVisible(false);
        // contmaxAmount		
        this.contmaxAmount.setBoundLabelText(resHelper.getString("contmaxAmount.boundLabelText"));		
        this.contmaxAmount.setBoundLabelLength(100);		
        this.contmaxAmount.setBoundLabelUnderline(true);		
        this.contmaxAmount.setVisible(true);
        // kDTabbedPane1
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // txtxmlPath		
        this.txtxmlPath.setHorizontalAlignment(2);		
        this.txtxmlPath.setMaxLength(200);		
        this.txtxmlPath.setRequired(false);
        // txtxmlBackupPath		
        this.txtxmlBackupPath.setHorizontalAlignment(2);		
        this.txtxmlBackupPath.setMaxLength(200);		
        this.txtxmlBackupPath.setRequired(false);
        // txttxtPath		
        this.txttxtPath.setHorizontalAlignment(2);		
        this.txttxtPath.setMaxLength(200);		
        this.txttxtPath.setRequired(false);
        // txtmaxRow		
        this.txtmaxRow.setHorizontalAlignment(2);		
        this.txtmaxRow.setDataType(0);		
        this.txtmaxRow.setSupportedEmpty(true);		
        this.txtmaxRow.setRequired(true);
        // txtSpbm		
        this.txtSpbm.setHorizontalAlignment(2);		
        this.txtSpbm.setMaxLength(100);		
        this.txtSpbm.setRequired(true);
        // txttxtBackupPath		
        this.txttxtBackupPath.setVisible(true);		
        this.txttxtBackupPath.setHorizontalAlignment(2);		
        this.txttxtBackupPath.setMaxLength(200);		
        this.txttxtBackupPath.setRequired(false);
        // txtmaxAmount		
        this.txtmaxAmount.setVisible(true);		
        this.txtmaxAmount.setHorizontalAlignment(2);		
        this.txtmaxAmount.setDataType(1);		
        this.txtmaxAmount.setSupportedEmpty(true);		
        this.txtmaxAmount.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtmaxAmount.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtmaxAmount.setPrecision(2);		
        this.txtmaxAmount.setRequired(true);
        // kDPanel2
        // kDPanel3
        // kDPanel1		
        this.kDPanel1.setBorder(null);
        // conttaxNo		
        this.conttaxNo.setBoundLabelText(resHelper.getString("conttaxNo.boundLabelText"));		
        this.conttaxNo.setBoundLabelLength(100);		
        this.conttaxNo.setBoundLabelUnderline(true);		
        this.conttaxNo.setVisible(true);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contbankName		
        this.contbankName.setBoundLabelText(resHelper.getString("contbankName.boundLabelText"));		
        this.contbankName.setBoundLabelLength(100);		
        this.contbankName.setBoundLabelUnderline(true);		
        this.contbankName.setVisible(true);
        // conttel		
        this.conttel.setBoundLabelText(resHelper.getString("conttel.boundLabelText"));		
        this.conttel.setBoundLabelLength(100);		
        this.conttel.setBoundLabelUnderline(true);		
        this.conttel.setVisible(true);
        // contbankNo		
        this.contbankNo.setBoundLabelText(resHelper.getString("contbankNo.boundLabelText"));		
        this.contbankNo.setBoundLabelLength(100);		
        this.contbankNo.setBoundLabelUnderline(true);		
        this.contbankNo.setVisible(true);
        // txttaxNo		
        this.txttaxNo.setVisible(true);		
        this.txttaxNo.setHorizontalAlignment(2);		
        this.txttaxNo.setMaxLength(100);		
        this.txttaxNo.setRequired(false);
        // txtaddress		
        this.txtaddress.setVisible(true);		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // txtbankName		
        this.txtbankName.setVisible(true);		
        this.txtbankName.setHorizontalAlignment(2);		
        this.txtbankName.setMaxLength(200);		
        this.txtbankName.setRequired(false);
        // txttel		
        this.txttel.setVisible(true);		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(20);		
        this.txttel.setRequired(false);
        // txtbankNo		
        this.txtbankNo.setVisible(true);		
        this.txtbankNo.setHorizontalAlignment(2);		
        this.txtbankNo.setMaxLength(100);		
        this.txtbankNo.setRequired(false);
        // contkeystoreName		
        this.contkeystoreName.setBoundLabelText(resHelper.getString("contkeystoreName.boundLabelText"));		
        this.contkeystoreName.setBoundLabelLength(100);		
        this.contkeystoreName.setBoundLabelUnderline(true);		
        this.contkeystoreName.setVisible(true);
        // continterfaceUrl		
        this.continterfaceUrl.setBoundLabelText(resHelper.getString("continterfaceUrl.boundLabelText"));		
        this.continterfaceUrl.setBoundLabelLength(100);		
        this.continterfaceUrl.setBoundLabelUnderline(true);		
        this.continterfaceUrl.setVisible(true);
        // contpasswd		
        this.contpasswd.setBoundLabelText(resHelper.getString("contpasswd.boundLabelText"));		
        this.contpasswd.setBoundLabelLength(100);		
        this.contpasswd.setBoundLabelUnderline(true);		
        this.contpasswd.setVisible(true);
        // contkeystoreAbner		
        this.contkeystoreAbner.setBoundLabelText(resHelper.getString("contkeystoreAbner.boundLabelText"));		
        this.contkeystoreAbner.setBoundLabelLength(100);		
        this.contkeystoreAbner.setBoundLabelUnderline(true);		
        this.contkeystoreAbner.setVisible(true);
        // contappCode		
        this.contappCode.setBoundLabelText(resHelper.getString("contappCode.boundLabelText"));		
        this.contappCode.setBoundLabelLength(100);		
        this.contappCode.setBoundLabelUnderline(true);		
        this.contappCode.setVisible(true);
        // txtkeystoreName		
        this.txtkeystoreName.setVisible(true);		
        this.txtkeystoreName.setHorizontalAlignment(2);		
        this.txtkeystoreName.setMaxLength(100);		
        this.txtkeystoreName.setRequired(true);
        // txtinterfaceUrl		
        this.txtinterfaceUrl.setVisible(true);		
        this.txtinterfaceUrl.setHorizontalAlignment(2);		
        this.txtinterfaceUrl.setMaxLength(200);		
        this.txtinterfaceUrl.setRequired(true);
        // txtpasswd		
        this.txtpasswd.setText(resHelper.getString("txtpasswd.text"));		
        // txtkeystoreAbner		
        this.txtkeystoreAbner.setVisible(true);		
        this.txtkeystoreAbner.setHorizontalAlignment(2);		
        this.txtkeystoreAbner.setMaxLength(50);		
        this.txtkeystoreAbner.setRequired(true);
        // txtappCode		
        this.txtappCode.setVisible(true);		
        this.txtappCode.setHorizontalAlignment(2);		
        this.txtappCode.setMaxLength(50);		
        this.txtappCode.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtName,txtNumber,prmtcompany,txtxmlPath,txtxmlBackupPath,txttxtPath,txtmaxRow,txtSpbm,txtDescription,txtSimpleName,txttxtBackupPath,txtmaxAmount,txtinterfaceUrl,txttaxNo,txtaddress,txttel,txtbankName,txtbankNo,txtkeystoreName,txtkeystoreAbner,txtappCode}));
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
        this.setBounds(new Rectangle(0, 0, 595, 352));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(19, 14, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(313, 14, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(610, 107, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(610, 144, 270, 19));
        this.add(kDLabelContainer4, null);
        contcompany.setBounds(new Rectangle(19, 46, 270, 19));
        this.add(contcompany, null);
        contxmlPath.setBounds(new Rectangle(610, 199, 560, 19));
        this.add(contxmlPath, null);
        contxmlBackupPath.setBounds(new Rectangle(610, 228, 560, 19));
        this.add(contxmlBackupPath, null);
        conttxtPath.setBounds(new Rectangle(610, 251, 560, 19));
        this.add(conttxtPath, null);
        contmaxRow.setBounds(new Rectangle(19, 80, 270, 19));
        this.add(contmaxRow, null);
        contSpbm.setBounds(new Rectangle(313, 46, 270, 19));
        this.add(contSpbm, null);
        conttxtBackupPath.setBounds(new Rectangle(610, 275, 559, 19));
        this.add(conttxtBackupPath, null);
        contmaxAmount.setBounds(new Rectangle(313, 80, 270, 19));
        this.add(contmaxAmount, null);
        kDTabbedPane1.setBounds(new Rectangle(12, 118, 573, 211));
        this.add(kDTabbedPane1, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contxmlPath
        contxmlPath.setBoundEditor(txtxmlPath);
        //contxmlBackupPath
        contxmlBackupPath.setBoundEditor(txtxmlBackupPath);
        //conttxtPath
        conttxtPath.setBoundEditor(txttxtPath);
        //contmaxRow
        contmaxRow.setBoundEditor(txtmaxRow);
        //contSpbm
        contSpbm.setBoundEditor(txtSpbm);
        //conttxtBackupPath
        conttxtBackupPath.setBoundEditor(txttxtBackupPath);
        //contmaxAmount
        contmaxAmount.setBoundEditor(txtmaxAmount);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        //kDPanel2
        kDPanel2.setLayout(null);        kDPanel1.setBounds(new Rectangle(2, -1, 581, 160));
        kDPanel2.add(kDPanel1, null);
        //kDPanel1
        kDPanel1.setLayout(null);        conttaxNo.setBounds(new Rectangle(12, 16, 270, 19));
        kDPanel1.add(conttaxNo, null);
        contaddress.setBounds(new Rectangle(12, 49, 550, 19));
        kDPanel1.add(contaddress, null);
        contbankName.setBounds(new Rectangle(12, 81, 550, 19));
        kDPanel1.add(contbankName, null);
        conttel.setBounds(new Rectangle(292, 15, 270, 19));
        kDPanel1.add(conttel, null);
        contbankNo.setBounds(new Rectangle(12, 121, 550, 19));
        kDPanel1.add(contbankNo, null);
        //conttaxNo
        conttaxNo.setBoundEditor(txttaxNo);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contbankName
        contbankName.setBoundEditor(txtbankName);
        //conttel
        conttel.setBoundEditor(txttel);
        //contbankNo
        contbankNo.setBoundEditor(txtbankNo);
        //kDPanel3
        kDPanel3.setLayout(null);        contkeystoreName.setBounds(new Rectangle(6, 64, 270, 19));
        kDPanel3.add(contkeystoreName, null);
        continterfaceUrl.setBounds(new Rectangle(2, 19, 556, 19));
        kDPanel3.add(continterfaceUrl, null);
        contpasswd.setBounds(new Rectangle(6, 100, 270, 19));
        kDPanel3.add(contpasswd, null);
        contkeystoreAbner.setBounds(new Rectangle(288, 64, 270, 19));
        kDPanel3.add(contkeystoreAbner, null);
        contappCode.setBounds(new Rectangle(288, 100, 270, 19));
        kDPanel3.add(contappCode, null);
        //contkeystoreName
        contkeystoreName.setBoundEditor(txtkeystoreName);
        //continterfaceUrl
        continterfaceUrl.setBoundEditor(txtinterfaceUrl);
        //contpasswd
        contpasswd.setBoundEditor(txtpasswd);
        //contkeystoreAbner
        contkeystoreAbner.setBoundEditor(txtkeystoreAbner);
        //contappCode
        contappCode.setBoundEditor(txtappCode);

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
        this.menuBar.add(menuTool);
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
        //menuBiz
        menuBiz.add(menuItemCancelCancel);
        menuBiz.add(menuItemCancel);
        //menuTool
        menuTool.add(menuItemMsgFormat);
        menuTool.add(menuItemSendMessage);
        menuTool.add(menuItemCalculator);
        menuTool.add(menuItemToolBarCustom);
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
        this.toolBar.add(btnReset);
        this.toolBar.add(kDSeparatorCloud);
        this.toolBar.add(btnSave);
        this.toolBar.add(btnSubmit);
        this.toolBar.add(btnCopy);
        this.toolBar.add(btnRemove);
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
        this.toolBar.add(btnCancelCancel);
        this.toolBar.add(btnCancel);


    }

	//Regiester control's property binding.
	private void registerBindings(){
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("xmlPath", String.class, this.txtxmlPath, "text");
		dataBinder.registerBinding("xmlBackupPath", String.class, this.txtxmlBackupPath, "text");
		dataBinder.registerBinding("txtPath", String.class, this.txttxtPath, "text");
		dataBinder.registerBinding("maxRow", int.class, this.txtmaxRow, "value");
		dataBinder.registerBinding("Spbm", String.class, this.txtSpbm, "text");
		dataBinder.registerBinding("txtBackupPath", String.class, this.txttxtBackupPath, "text");
		dataBinder.registerBinding("maxAmount", java.math.BigDecimal.class, this.txtmaxAmount, "value");
		dataBinder.registerBinding("taxNo", String.class, this.txttaxNo, "text");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("bankName", String.class, this.txtbankName, "text");
		dataBinder.registerBinding("tel", String.class, this.txttel, "text");
		dataBinder.registerBinding("bankNo", String.class, this.txtbankNo, "text");
		dataBinder.registerBinding("keystoreName", String.class, this.txtkeystoreName, "text");
		dataBinder.registerBinding("interfaceUrl", String.class, this.txtinterfaceUrl, "text");
		dataBinder.registerBinding("passwd", String.class, this.txtpasswd, "text");
		dataBinder.registerBinding("keystoreAbner", String.class, this.txtkeystoreAbner, "text");
		dataBinder.registerBinding("appCode", String.class, this.txtappCode, "text");		
	}
	//Regiester UI State
	private void registerUIState(){
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_ADDNEW, this.txtSimpleName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtName, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtDescription, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtNumber, ActionStateConst.ENABLED);
	        getActionManager().registerUIState(STATUS_EDIT, this.txtSimpleName, ActionStateConst.ENABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtName, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtDescription, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtNumber, ActionStateConst.DISABLED);					 	        		
	        getActionManager().registerUIState(STATUS_VIEW, this.txtSimpleName, ActionStateConst.DISABLED);		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.erp2tax.app.BaseSettingEditUIHandler";
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
        this.txtName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.erp2tax.BaseSettingInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xmlPath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("xmlBackupPath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("txtPath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maxRow", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Spbm", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("txtBackupPath", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("maxAmount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("taxNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("bankNo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("keystoreName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("interfaceUrl", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("passwd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("keystoreAbner", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("appCode", ValidateHelper.ON_SAVE);    		
	}



    /**
     * output setOprtState method
     */
    public void setOprtState(String oprtType)
    {
        super.setOprtState(oprtType);
        if (STATUS_ADDNEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_EDIT.equals(this.oprtState)) {
		            this.txtName.setEnabled(true);
		            this.txtDescription.setEnabled(true);
		            this.txtNumber.setEnabled(true);
		            this.txtSimpleName.setEnabled(true);
        } else if (STATUS_VIEW.equals(this.oprtState)) {
		            this.txtName.setEnabled(false);
		            this.txtDescription.setEnabled(false);
		            this.txtNumber.setEnabled(false);
		            this.txtSimpleName.setEnabled(false);
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
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("xmlPath"));
        sic.add(new SelectorItemInfo("xmlBackupPath"));
        sic.add(new SelectorItemInfo("txtPath"));
        sic.add(new SelectorItemInfo("maxRow"));
        sic.add(new SelectorItemInfo("Spbm"));
        sic.add(new SelectorItemInfo("txtBackupPath"));
        sic.add(new SelectorItemInfo("maxAmount"));
        sic.add(new SelectorItemInfo("taxNo"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("bankName"));
        sic.add(new SelectorItemInfo("tel"));
        sic.add(new SelectorItemInfo("bankNo"));
        sic.add(new SelectorItemInfo("keystoreName"));
        sic.add(new SelectorItemInfo("interfaceUrl"));
        sic.add(new SelectorItemInfo("passwd"));
        sic.add(new SelectorItemInfo("keystoreAbner"));
        sic.add(new SelectorItemInfo("appCode"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.erp2tax.client", "BaseSettingEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.erp2tax.client.BaseSettingEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.erp2tax.BaseSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.erp2tax.BaseSettingInfo objectValue = new com.kingdee.eas.custom.erp2tax.BaseSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmaxRow.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"发票最大行数"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtSpbm.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"税收分类代码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtmaxAmount.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"最大开票金额"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtkeystoreName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"证书文件名"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtinterfaceUrl.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"接口地址"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtkeystoreAbner.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"证书别名"});
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
				vo.put("maxRow",new Integer(7));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}