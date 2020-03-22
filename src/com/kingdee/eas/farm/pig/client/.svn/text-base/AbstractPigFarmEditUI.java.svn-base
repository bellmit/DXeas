/**
 * output package name
 */
package com.kingdee.eas.farm.pig.client;

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
public abstract class AbstractPigFarmEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractPigFarmEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer conttel;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contaddress;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contstoOrgUnit;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcostObject;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmHeaderName;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfarmHeader;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderStoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneStoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer continitBatchCount;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contfodderWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contimmuneWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigStoOrg;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contpigWarehouse;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDTextField txttel;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtaddress;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkbuildDate;
    protected com.kingdee.bos.ctrl.swing.KDComboBox pigType;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtstoOrgUnit;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcostObject;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtfarmHeaderName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfarmHeader;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfodderStoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtimmuneStoOrg;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtinitBatchCount;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtfodderWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtimmuneWarehouse;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigStoOrg;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtpigWarehouse;
    protected com.kingdee.eas.farm.pig.PigFarmInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractPigFarmEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractPigFarmEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.conttel = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contaddress = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbuildDate = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contstoOrgUnit = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcostObject = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmHeaderName = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfarmHeader = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderStoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneStoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.continitBatchCount = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contfodderWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contimmuneWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigStoOrg = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contpigWarehouse = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txttel = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtaddress = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.pkbuildDate = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.pigType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtstoOrgUnit = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtcostObject = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtfarmHeaderName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.prmtfarmHeader = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtfodderStoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtimmuneStoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtinitBatchCount = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtfodderWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtimmuneWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpigStoOrg = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtpigWarehouse = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.conttel.setName("conttel");
        this.contaddress.setName("contaddress");
        this.contbuildDate.setName("contbuildDate");
        this.contpigType.setName("contpigType");
        this.contstoOrgUnit.setName("contstoOrgUnit");
        this.contcostObject.setName("contcostObject");
        this.contfarmHeaderName.setName("contfarmHeaderName");
        this.contfarmHeader.setName("contfarmHeader");
        this.contfodderStoOrg.setName("contfodderStoOrg");
        this.contimmuneStoOrg.setName("contimmuneStoOrg");
        this.continitBatchCount.setName("continitBatchCount");
        this.contfodderWarehouse.setName("contfodderWarehouse");
        this.contimmuneWarehouse.setName("contimmuneWarehouse");
        this.contpigStoOrg.setName("contpigStoOrg");
        this.contpigWarehouse.setName("contpigWarehouse");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.txttel.setName("txttel");
        this.txtaddress.setName("txtaddress");
        this.pkbuildDate.setName("pkbuildDate");
        this.pigType.setName("pigType");
        this.prmtstoOrgUnit.setName("prmtstoOrgUnit");
        this.prmtcostObject.setName("prmtcostObject");
        this.txtfarmHeaderName.setName("txtfarmHeaderName");
        this.prmtfarmHeader.setName("prmtfarmHeader");
        this.prmtfodderStoOrg.setName("prmtfodderStoOrg");
        this.prmtimmuneStoOrg.setName("prmtimmuneStoOrg");
        this.txtinitBatchCount.setName("txtinitBatchCount");
        this.prmtfodderWarehouse.setName("prmtfodderWarehouse");
        this.prmtimmuneWarehouse.setName("prmtimmuneWarehouse");
        this.prmtpigStoOrg.setName("prmtpigStoOrg");
        this.prmtpigWarehouse.setName("prmtpigWarehouse");
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
        // kDLabelContainer4		
        this.kDLabelContainer4.setBoundLabelText(resHelper.getString("kDLabelContainer4.boundLabelText"));		
        this.kDLabelContainer4.setBoundLabelLength(100);		
        this.kDLabelContainer4.setBoundLabelUnderline(true);		
        this.kDLabelContainer4.setBoundLabelAlignment(7);		
        this.kDLabelContainer4.setVisible(true);
        // conttel		
        this.conttel.setBoundLabelText(resHelper.getString("conttel.boundLabelText"));		
        this.conttel.setBoundLabelLength(100);		
        this.conttel.setBoundLabelUnderline(true);		
        this.conttel.setVisible(true);
        // contaddress		
        this.contaddress.setBoundLabelText(resHelper.getString("contaddress.boundLabelText"));		
        this.contaddress.setBoundLabelLength(100);		
        this.contaddress.setBoundLabelUnderline(true);		
        this.contaddress.setVisible(true);
        // contbuildDate		
        this.contbuildDate.setBoundLabelText(resHelper.getString("contbuildDate.boundLabelText"));		
        this.contbuildDate.setBoundLabelLength(100);		
        this.contbuildDate.setBoundLabelUnderline(true);		
        this.contbuildDate.setVisible(true);
        // contpigType		
        this.contpigType.setBoundLabelText(resHelper.getString("contpigType.boundLabelText"));		
        this.contpigType.setBoundLabelLength(100);		
        this.contpigType.setBoundLabelUnderline(true);		
        this.contpigType.setVisible(true);
        // contstoOrgUnit		
        this.contstoOrgUnit.setBoundLabelText(resHelper.getString("contstoOrgUnit.boundLabelText"));		
        this.contstoOrgUnit.setBoundLabelLength(100);		
        this.contstoOrgUnit.setBoundLabelUnderline(true);		
        this.contstoOrgUnit.setVisible(true);
        // contcostObject		
        this.contcostObject.setBoundLabelText(resHelper.getString("contcostObject.boundLabelText"));		
        this.contcostObject.setBoundLabelLength(100);		
        this.contcostObject.setBoundLabelUnderline(true);		
        this.contcostObject.setVisible(true);
        // contfarmHeaderName		
        this.contfarmHeaderName.setBoundLabelText(resHelper.getString("contfarmHeaderName.boundLabelText"));		
        this.contfarmHeaderName.setBoundLabelLength(100);		
        this.contfarmHeaderName.setBoundLabelUnderline(true);		
        this.contfarmHeaderName.setVisible(true);
        // contfarmHeader		
        this.contfarmHeader.setBoundLabelText(resHelper.getString("contfarmHeader.boundLabelText"));		
        this.contfarmHeader.setBoundLabelLength(100);		
        this.contfarmHeader.setBoundLabelUnderline(true);		
        this.contfarmHeader.setVisible(true);
        // contfodderStoOrg		
        this.contfodderStoOrg.setBoundLabelText(resHelper.getString("contfodderStoOrg.boundLabelText"));		
        this.contfodderStoOrg.setBoundLabelLength(100);		
        this.contfodderStoOrg.setBoundLabelUnderline(true);		
        this.contfodderStoOrg.setVisible(true);
        // contimmuneStoOrg		
        this.contimmuneStoOrg.setBoundLabelText(resHelper.getString("contimmuneStoOrg.boundLabelText"));		
        this.contimmuneStoOrg.setBoundLabelLength(100);		
        this.contimmuneStoOrg.setBoundLabelUnderline(true);		
        this.contimmuneStoOrg.setVisible(true);
        // continitBatchCount		
        this.continitBatchCount.setBoundLabelText(resHelper.getString("continitBatchCount.boundLabelText"));		
        this.continitBatchCount.setBoundLabelLength(100);		
        this.continitBatchCount.setBoundLabelUnderline(true);		
        this.continitBatchCount.setVisible(true);
        // contfodderWarehouse		
        this.contfodderWarehouse.setBoundLabelText(resHelper.getString("contfodderWarehouse.boundLabelText"));		
        this.contfodderWarehouse.setBoundLabelLength(100);		
        this.contfodderWarehouse.setBoundLabelUnderline(true);		
        this.contfodderWarehouse.setVisible(true);
        // contimmuneWarehouse		
        this.contimmuneWarehouse.setBoundLabelText(resHelper.getString("contimmuneWarehouse.boundLabelText"));		
        this.contimmuneWarehouse.setBoundLabelLength(100);		
        this.contimmuneWarehouse.setBoundLabelUnderline(true);		
        this.contimmuneWarehouse.setVisible(true);
        // contpigStoOrg		
        this.contpigStoOrg.setBoundLabelText(resHelper.getString("contpigStoOrg.boundLabelText"));		
        this.contpigStoOrg.setBoundLabelLength(100);		
        this.contpigStoOrg.setBoundLabelUnderline(true);		
        this.contpigStoOrg.setVisible(true);
        // contpigWarehouse		
        this.contpigWarehouse.setBoundLabelText(resHelper.getString("contpigWarehouse.boundLabelText"));		
        this.contpigWarehouse.setBoundLabelLength(100);		
        this.contpigWarehouse.setBoundLabelUnderline(true);		
        this.contpigWarehouse.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);		
        this.txtNumber.setRequired(true);
        // txtName		
        this.txtName.setRequired(true);
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // txttel		
        this.txttel.setVisible(true);		
        this.txttel.setHorizontalAlignment(2);		
        this.txttel.setMaxLength(50);		
        this.txttel.setRequired(true);
        // txtaddress		
        this.txtaddress.setVisible(true);		
        this.txtaddress.setHorizontalAlignment(2);		
        this.txtaddress.setMaxLength(200);		
        this.txtaddress.setRequired(false);
        // pkbuildDate		
        this.pkbuildDate.setVisible(true);		
        this.pkbuildDate.setRequired(false);
        // pigType		
        this.pigType.setVisible(true);		
        this.pigType.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.pig.PigFarmType").toArray());		
        this.pigType.setRequired(true);
        // prmtstoOrgUnit		
        this.prmtstoOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtstoOrgUnit.setVisible(true);		
        this.prmtstoOrgUnit.setEditable(true);		
        this.prmtstoOrgUnit.setDisplayFormat("$name$");		
        this.prmtstoOrgUnit.setEditFormat("$number$");		
        this.prmtstoOrgUnit.setCommitFormat("$number$");		
        this.prmtstoOrgUnit.setRequired(true);
        // prmtcostObject		
        this.prmtcostObject.setQueryInfo("com.kingdee.eas.basedata.org.app.CostCenterItemQuery");		
        this.prmtcostObject.setVisible(true);		
        this.prmtcostObject.setEditable(true);		
        this.prmtcostObject.setDisplayFormat("$name$");		
        this.prmtcostObject.setEditFormat("$number$");		
        this.prmtcostObject.setCommitFormat("$number$");		
        this.prmtcostObject.setRequired(true);
        // txtfarmHeaderName		
        this.txtfarmHeaderName.setVisible(true);		
        this.txtfarmHeaderName.setHorizontalAlignment(2);		
        this.txtfarmHeaderName.setMaxLength(100);		
        this.txtfarmHeaderName.setRequired(true);
        // prmtfarmHeader		
        this.prmtfarmHeader.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtfarmHeader.setVisible(true);		
        this.prmtfarmHeader.setEditable(true);		
        this.prmtfarmHeader.setDisplayFormat("$name$");		
        this.prmtfarmHeader.setEditFormat("$number$");		
        this.prmtfarmHeader.setCommitFormat("$number$");		
        this.prmtfarmHeader.setRequired(false);
        // prmtfodderStoOrg		
        this.prmtfodderStoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtfodderStoOrg.setVisible(true);		
        this.prmtfodderStoOrg.setEditable(true);		
        this.prmtfodderStoOrg.setDisplayFormat("$name$");		
        this.prmtfodderStoOrg.setEditFormat("$number$");		
        this.prmtfodderStoOrg.setCommitFormat("$number$");		
        this.prmtfodderStoOrg.setRequired(true);
        // prmtimmuneStoOrg		
        this.prmtimmuneStoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtimmuneStoOrg.setVisible(true);		
        this.prmtimmuneStoOrg.setEditable(true);		
        this.prmtimmuneStoOrg.setDisplayFormat("$name$");		
        this.prmtimmuneStoOrg.setEditFormat("$number$");		
        this.prmtimmuneStoOrg.setCommitFormat("$number$");		
        this.prmtimmuneStoOrg.setRequired(true);
        // txtinitBatchCount		
        this.txtinitBatchCount.setVisible(true);		
        this.txtinitBatchCount.setHorizontalAlignment(2);		
        this.txtinitBatchCount.setDataType(0);		
        this.txtinitBatchCount.setSupportedEmpty(true);		
        this.txtinitBatchCount.setRequired(false);
        // prmtfodderWarehouse		
        this.prmtfodderWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtfodderWarehouse.setVisible(true);		
        this.prmtfodderWarehouse.setEditable(true);		
        this.prmtfodderWarehouse.setDisplayFormat("$name$");		
        this.prmtfodderWarehouse.setEditFormat("$number$");		
        this.prmtfodderWarehouse.setCommitFormat("$number$");		
        this.prmtfodderWarehouse.setRequired(true);
        // prmtimmuneWarehouse		
        this.prmtimmuneWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtimmuneWarehouse.setVisible(true);		
        this.prmtimmuneWarehouse.setEditable(true);		
        this.prmtimmuneWarehouse.setDisplayFormat("$name$");		
        this.prmtimmuneWarehouse.setEditFormat("$number$");		
        this.prmtimmuneWarehouse.setCommitFormat("$number$");		
        this.prmtimmuneWarehouse.setRequired(true);
        // prmtpigStoOrg		
        this.prmtpigStoOrg.setQueryInfo("com.kingdee.eas.basedata.org.app.StorageItemQuery");		
        this.prmtpigStoOrg.setVisible(true);		
        this.prmtpigStoOrg.setEditable(true);		
        this.prmtpigStoOrg.setDisplayFormat("$name$");		
        this.prmtpigStoOrg.setEditFormat("$number$");		
        this.prmtpigStoOrg.setCommitFormat("$number$");		
        this.prmtpigStoOrg.setRequired(true);
        // prmtpigWarehouse		
        this.prmtpigWarehouse.setQueryInfo("com.kingdee.eas.basedata.scm.im.inv.app.WarehouseQuery");		
        this.prmtpigWarehouse.setVisible(true);		
        this.prmtpigWarehouse.setEditable(true);		
        this.prmtpigWarehouse.setDisplayFormat("$name$");		
        this.prmtpigWarehouse.setEditFormat("$number$");		
        this.prmtpigWarehouse.setCommitFormat("$number$");		
        this.prmtpigWarehouse.setRequired(true);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txttel,txtaddress,pkbuildDate,pigType,prmtstoOrgUnit,prmtcostObject,txtfarmHeaderName,prmtfarmHeader,prmtfodderStoOrg,prmtimmuneStoOrg,txtinitBatchCount,prmtfodderWarehouse,prmtimmuneWarehouse,prmtpigStoOrg,prmtpigWarehouse}));
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
        this.setBounds(new Rectangle(0, 0, 650, 600));
        this.setLayout(null);
        kDLabelContainer1.setBounds(new Rectangle(20, 26, 270, 19));
        this.add(kDLabelContainer1, null);
        kDLabelContainer2.setBounds(new Rectangle(347, 26, 270, 19));
        this.add(kDLabelContainer2, null);
        kDLabelContainer3.setBounds(new Rectangle(190, -64, 270, 19));
        this.add(kDLabelContainer3, null);
        kDLabelContainer4.setBounds(new Rectangle(20, 342, 596, 19));
        this.add(kDLabelContainer4, null);
        conttel.setBounds(new Rectangle(20, 131, 270, 19));
        this.add(conttel, null);
        contaddress.setBounds(new Rectangle(20, 306, 596, 19));
        this.add(contaddress, null);
        contbuildDate.setBounds(new Rectangle(347, 61, 270, 19));
        this.add(contbuildDate, null);
        contpigType.setBounds(new Rectangle(20, 61, 270, 19));
        this.add(contpigType, null);
        contstoOrgUnit.setBounds(new Rectangle(347, 131, 270, 19));
        this.add(contstoOrgUnit, null);
        contcostObject.setBounds(new Rectangle(20, 271, 270, 19));
        this.add(contcostObject, null);
        contfarmHeaderName.setBounds(new Rectangle(20, 96, 270, 19));
        this.add(contfarmHeaderName, null);
        contfarmHeader.setBounds(new Rectangle(347, 96, 270, 19));
        this.add(contfarmHeader, null);
        contfodderStoOrg.setBounds(new Rectangle(20, 201, 270, 19));
        this.add(contfodderStoOrg, null);
        contimmuneStoOrg.setBounds(new Rectangle(20, 236, 270, 19));
        this.add(contimmuneStoOrg, null);
        continitBatchCount.setBounds(new Rectangle(347, 274, 270, 19));
        this.add(continitBatchCount, null);
        contfodderWarehouse.setBounds(new Rectangle(347, 201, 270, 19));
        this.add(contfodderWarehouse, null);
        contimmuneWarehouse.setBounds(new Rectangle(347, 236, 270, 19));
        this.add(contimmuneWarehouse, null);
        contpigStoOrg.setBounds(new Rectangle(20, 166, 270, 19));
        this.add(contpigStoOrg, null);
        contpigWarehouse.setBounds(new Rectangle(347, 166, 270, 19));
        this.add(contpigWarehouse, null);
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //conttel
        conttel.setBoundEditor(txttel);
        //contaddress
        contaddress.setBoundEditor(txtaddress);
        //contbuildDate
        contbuildDate.setBoundEditor(pkbuildDate);
        //contpigType
        contpigType.setBoundEditor(pigType);
        //contstoOrgUnit
        contstoOrgUnit.setBoundEditor(prmtstoOrgUnit);
        //contcostObject
        contcostObject.setBoundEditor(prmtcostObject);
        //contfarmHeaderName
        contfarmHeaderName.setBoundEditor(txtfarmHeaderName);
        //contfarmHeader
        contfarmHeader.setBoundEditor(prmtfarmHeader);
        //contfodderStoOrg
        contfodderStoOrg.setBoundEditor(prmtfodderStoOrg);
        //contimmuneStoOrg
        contimmuneStoOrg.setBoundEditor(prmtimmuneStoOrg);
        //continitBatchCount
        continitBatchCount.setBoundEditor(txtinitBatchCount);
        //contfodderWarehouse
        contfodderWarehouse.setBoundEditor(prmtfodderWarehouse);
        //contimmuneWarehouse
        contimmuneWarehouse.setBoundEditor(prmtimmuneWarehouse);
        //contpigStoOrg
        contpigStoOrg.setBoundEditor(prmtpigStoOrg);
        //contpigWarehouse
        contpigWarehouse.setBoundEditor(prmtpigWarehouse);

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
		dataBinder.registerBinding("tel", String.class, this.txttel, "text");
		dataBinder.registerBinding("address", String.class, this.txtaddress, "text");
		dataBinder.registerBinding("buildDate", java.util.Date.class, this.pkbuildDate, "value");
		dataBinder.registerBinding("pigType", com.kingdee.eas.farm.pig.PigFarmType.class, this.pigType, "selectedItem");
		dataBinder.registerBinding("stoOrgUnit", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtstoOrgUnit, "data");
		dataBinder.registerBinding("costObject", com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo.class, this.prmtcostObject, "data");
		dataBinder.registerBinding("farmHeaderName", String.class, this.txtfarmHeaderName, "text");
		dataBinder.registerBinding("farmHeader", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtfarmHeader, "data");
		dataBinder.registerBinding("fodderStoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtfodderStoOrg, "data");
		dataBinder.registerBinding("immuneStoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtimmuneStoOrg, "data");
		dataBinder.registerBinding("initBatchCount", int.class, this.txtinitBatchCount, "value");
		dataBinder.registerBinding("fodderWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtfodderWarehouse, "data");
		dataBinder.registerBinding("immuneWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtimmuneWarehouse, "data");
		dataBinder.registerBinding("pigStoOrg", com.kingdee.eas.basedata.org.StorageOrgUnitInfo.class, this.prmtpigStoOrg, "data");
		dataBinder.registerBinding("pigWarehouse", com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo.class, this.prmtpigWarehouse, "data");		
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
	    return "com.kingdee.eas.farm.pig.app.PigFarmEditUIHandler";
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
        this.txttel.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.pig.PigFarmInfo)ov;
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
		getValidateHelper().registerBindProperty("tel", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("address", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("buildDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("stoOrgUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("costObject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmHeaderName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("farmHeader", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderStoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneStoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("initBatchCount", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("fodderWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("immuneWarehouse", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigStoOrg", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("pigWarehouse", ValidateHelper.ON_SAVE);    		
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
        sic.add(new SelectorItemInfo("tel"));
        sic.add(new SelectorItemInfo("address"));
        sic.add(new SelectorItemInfo("buildDate"));
        sic.add(new SelectorItemInfo("pigType"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("stoOrgUnit.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("stoOrgUnit.id"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.number"));
        	sic.add(new SelectorItemInfo("stoOrgUnit.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("costObject.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("costObject.id"));
        	sic.add(new SelectorItemInfo("costObject.number"));
        	sic.add(new SelectorItemInfo("costObject.name"));
		}
        sic.add(new SelectorItemInfo("farmHeaderName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("farmHeader.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("farmHeader.id"));
        	sic.add(new SelectorItemInfo("farmHeader.number"));
        	sic.add(new SelectorItemInfo("farmHeader.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("fodderStoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("fodderStoOrg.id"));
        	sic.add(new SelectorItemInfo("fodderStoOrg.number"));
        	sic.add(new SelectorItemInfo("fodderStoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("immuneStoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("immuneStoOrg.id"));
        	sic.add(new SelectorItemInfo("immuneStoOrg.number"));
        	sic.add(new SelectorItemInfo("immuneStoOrg.name"));
		}
        sic.add(new SelectorItemInfo("initBatchCount"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("fodderWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("fodderWarehouse.id"));
        	sic.add(new SelectorItemInfo("fodderWarehouse.number"));
        	sic.add(new SelectorItemInfo("fodderWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("immuneWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("immuneWarehouse.id"));
        	sic.add(new SelectorItemInfo("immuneWarehouse.number"));
        	sic.add(new SelectorItemInfo("immuneWarehouse.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigStoOrg.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigStoOrg.id"));
        	sic.add(new SelectorItemInfo("pigStoOrg.number"));
        	sic.add(new SelectorItemInfo("pigStoOrg.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("pigWarehouse.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("pigWarehouse.id"));
        	sic.add(new SelectorItemInfo("pigWarehouse.number"));
        	sic.add(new SelectorItemInfo("pigWarehouse.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.pig.client", "PigFarmEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.pig.client.PigFarmEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.PigFarmFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.PigFarmInfo objectValue = new com.kingdee.eas.farm.pig.PigFarmInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtNumber.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"编码"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtName.getItemDataByLang(new LanguageInfo(com.kingdee.eas.common.client.SysContext.getSysContext().getLocale())))) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"名称"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txttel.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"电话"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(pigType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"猪场类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtstoOrgUnit.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"对应库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcostObject.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"成本中心"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtfarmHeaderName.getText())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"厂长"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfodderStoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料核算库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtimmuneStoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtfodderWarehouse.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"饲料仓库"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtimmuneWarehouse.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"疫苗仓库"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpigStoOrg.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存猪库存组织"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtpigWarehouse.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"库存猪仓库"});
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
		vo.put("pigType","3");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}