/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

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
public abstract class AbstractBreedStandardEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractBreedStandardEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer9;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contlimitBreedDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbreedData;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDCheckBox chkmolting;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel2;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel3;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel4;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtLayEggEntrys;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtLayEggEntrys_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDrugEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDrugEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtDepcEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtDepcEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtlimitBreedDays;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtbreedData;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton tBtnUnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnAudit;
    protected com.kingdee.bos.ctrl.swing.KDMenuItem mBtnUnAudit;
    protected com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractBreedStandardEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractBreedStandardEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        //actionAudit
        this.actionAudit = new ActionAudit(this);
        getActionManager().registerAction("actionAudit", actionAudit);
        this.actionAudit.setExtendProperty("canForewarn", "true");
        this.actionAudit.setExtendProperty("userDefined", "true");
        this.actionAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        //actionUnAudit
        this.actionUnAudit = new ActionUnAudit(this);
        getActionManager().registerAction("actionUnAudit", actionUnAudit);
        this.actionUnAudit.setExtendProperty("canForewarn", "true");
        this.actionUnAudit.setExtendProperty("userDefined", "true");
        this.actionUnAudit.setExtendProperty("isObjectUpdateLock", "false");
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.PermissionService());
         this.actionUnAudit.addService(new com.kingdee.eas.framework.client.service.ForewarnService());
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer9 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contlimitBreedDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbreedData = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.chkmolting = new com.kingdee.bos.ctrl.swing.KDCheckBox();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel2 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel3 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kDPanel4 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtLayEggEntrys = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDrugEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.kdtDepcEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.txtlimitBreedDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.prmtbreedData = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.tBtnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.tBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.mBtnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.mBtnUnAudit = new com.kingdee.bos.ctrl.swing.KDMenuItem();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.kDLabelContainer9.setName("kDLabelContainer9");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.contlimitBreedDays.setName("contlimitBreedDays");
        this.contbreedData.setName("contbreedData");
        this.contbaseStatus.setName("contbaseStatus");
        this.contcompany.setName("contcompany");
        this.chkmolting.setName("chkmolting");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtCreator.setName("prmtCreator");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.kDPanel1.setName("kDPanel1");
        this.kDPanel2.setName("kDPanel2");
        this.kDPanel3.setName("kDPanel3");
        this.kDPanel4.setName("kDPanel4");
        this.kdtEntrys.setName("kdtEntrys");
        this.kdtLayEggEntrys.setName("kdtLayEggEntrys");
        this.kdtDrugEntry.setName("kdtDrugEntry");
        this.kdtDepcEntry.setName("kdtDepcEntry");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.txtlimitBreedDays.setName("txtlimitBreedDays");
        this.prmtbreedData.setName("prmtbreedData");
        this.baseStatus.setName("baseStatus");
        this.prmtcompany.setName("prmtcompany");
        this.tBtnAudit.setName("tBtnAudit");
        this.tBtnUnAudit.setName("tBtnUnAudit");
        this.mBtnAudit.setName("mBtnAudit");
        this.mBtnUnAudit.setName("mBtnUnAudit");
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
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // kDLabelContainer9		
        this.kDLabelContainer9.setBoundLabelText(resHelper.getString("kDLabelContainer9.boundLabelText"));		
        this.kDLabelContainer9.setBoundLabelUnderline(true);		
        this.kDLabelContainer9.setBoundLabelLength(100);
        // kDTabbedPane1
        // contauditor		
        this.contauditor.setBoundLabelText(resHelper.getString("contauditor.boundLabelText"));		
        this.contauditor.setBoundLabelLength(100);		
        this.contauditor.setBoundLabelUnderline(true);		
        this.contauditor.setVisible(true);
        // contauditTime		
        this.contauditTime.setBoundLabelText(resHelper.getString("contauditTime.boundLabelText"));		
        this.contauditTime.setBoundLabelLength(100);		
        this.contauditTime.setBoundLabelUnderline(true);		
        this.contauditTime.setVisible(true);
        // contlimitBreedDays		
        this.contlimitBreedDays.setBoundLabelText(resHelper.getString("contlimitBreedDays.boundLabelText"));		
        this.contlimitBreedDays.setBoundLabelLength(100);		
        this.contlimitBreedDays.setBoundLabelUnderline(true);		
        this.contlimitBreedDays.setVisible(true);
        // contbreedData		
        this.contbreedData.setBoundLabelText(resHelper.getString("contbreedData.boundLabelText"));		
        this.contbreedData.setBoundLabelLength(100);		
        this.contbreedData.setBoundLabelUnderline(true);		
        this.contbreedData.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // chkmolting		
        this.chkmolting.setText(resHelper.getString("chkmolting.text"));		
        this.chkmolting.setHorizontalAlignment(2);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setEnabled(false);
        // kDPanel1
        // kDPanel2
        // kDPanel3
        // kDPanel4
        // kdtEntrys
		String kdtEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection locked=\"true\" hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol32\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol33\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol34\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol35\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"endWeek\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"endDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"henMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"henQtyPerday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"femaleTotalFeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"cockMaterial\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"cockQtyPerday\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"totalFeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"allTotalFeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"femaleStandardWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"standardWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"dailyDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"femalePerWeekDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"femaleTotalWeekDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"femaleLivability\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"femaleLossWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"femaleLossRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"perWeekDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"totalWeekDCRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"livability\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"maleLossWeight\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"maleLossRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"uniformRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"FemaleWgtMin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"FemaleWgtMax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"dynamiting\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"waterQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"breedTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"lightingTime\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /><t:Column t:key=\"temperatureTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol32\" /><t:Column t:key=\"temperatureFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol33\" /><t:Column t:key=\"humidityFrom\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol34\" /><t:Column t:key=\"humidityTo\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol35\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{endWeek}</t:Cell><t:Cell>$Resource{endDays}</t:Cell><t:Cell>$Resource{henMaterial}</t:Cell><t:Cell>$Resource{henQtyPerday}</t:Cell><t:Cell>$Resource{femaleTotalFeedCost}</t:Cell><t:Cell>$Resource{cockMaterial}</t:Cell><t:Cell>$Resource{cockQtyPerday}</t:Cell><t:Cell>$Resource{totalFeedCost}</t:Cell><t:Cell>$Resource{allTotalFeedCost}</t:Cell><t:Cell>$Resource{femaleStandardWgt}</t:Cell><t:Cell>$Resource{standardWeight}</t:Cell><t:Cell>$Resource{dailyDCRate}</t:Cell><t:Cell>$Resource{femalePerWeekDCRate}</t:Cell><t:Cell>$Resource{femaleTotalWeekDCRate}</t:Cell><t:Cell>$Resource{femaleLivability}</t:Cell><t:Cell>$Resource{femaleLossWeight}</t:Cell><t:Cell>$Resource{femaleLossRate}</t:Cell><t:Cell>$Resource{perWeekDCRate}</t:Cell><t:Cell>$Resource{totalWeekDCRate}</t:Cell><t:Cell>$Resource{livability}</t:Cell><t:Cell>$Resource{maleLossWeight}</t:Cell><t:Cell>$Resource{maleLossRate}</t:Cell><t:Cell>$Resource{uniformRate}</t:Cell><t:Cell>$Resource{FemaleWgtMin}</t:Cell><t:Cell>$Resource{FemaleWgtMax}</t:Cell><t:Cell>$Resource{dynamiting}</t:Cell><t:Cell>$Resource{waterQty}</t:Cell><t:Cell>$Resource{breedTime}</t:Cell><t:Cell>$Resource{lightingTime}</t:Cell><t:Cell>$Resource{temperatureTo}</t:Cell><t:Cell>$Resource{temperatureFrom}</t:Cell><t:Cell>$Resource{humidityFrom}</t:Cell><t:Cell>$Resource{humidityTo}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntrys.setFormatXml(resHelper.translateString("kdtEntrys",kdtEntrysStrXML));
        kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntrys.putBindContents("editData",new String[] {"seq","week","days","endWeek","endDays","henMaterial","henQtyPerday","femaleTotalFeedCost","cockMaterial","cockQtyPerday","totalFeedCost","allTotalFeedCost","femaleStandardWgt","standardWeight","dailyDCRate","femalePerWeekDCRate","femaleTotalWeekDCRate","femaleLivability","femaleLossWeight","femaleLossRate","perWeekDCRate","totalWeekDCRate","livability","maleLossWeight","maleLossRate","uniformRate","FemaleWgtMin","FemaleWgtMax","dynamiting","waterQty","breedTime","lightingTime","temperatureTo","temperatureFrom","humidityFrom","humidityTo"});


        this.kdtEntrys.checkParsed();
        KDFormattedTextField kdtEntrys_week_TextField = new KDFormattedTextField();
        kdtEntrys_week_TextField.setName("kdtEntrys_week_TextField");
        kdtEntrys_week_TextField.setVisible(true);
        kdtEntrys_week_TextField.setEditable(true);
        kdtEntrys_week_TextField.setHorizontalAlignment(2);
        kdtEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtEntrys_week_TextField);
        this.kdtEntrys.getColumn("week").setEditor(kdtEntrys_week_CellEditor);
        KDFormattedTextField kdtEntrys_days_TextField = new KDFormattedTextField();
        kdtEntrys_days_TextField.setName("kdtEntrys_days_TextField");
        kdtEntrys_days_TextField.setVisible(true);
        kdtEntrys_days_TextField.setEditable(true);
        kdtEntrys_days_TextField.setHorizontalAlignment(2);
        kdtEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtEntrys_days_TextField);
        this.kdtEntrys.getColumn("days").setEditor(kdtEntrys_days_CellEditor);
        KDFormattedTextField kdtEntrys_endWeek_TextField = new KDFormattedTextField();
        kdtEntrys_endWeek_TextField.setName("kdtEntrys_endWeek_TextField");
        kdtEntrys_endWeek_TextField.setVisible(true);
        kdtEntrys_endWeek_TextField.setEditable(true);
        kdtEntrys_endWeek_TextField.setHorizontalAlignment(2);
        kdtEntrys_endWeek_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_endWeek_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endWeek_TextField);
        this.kdtEntrys.getColumn("endWeek").setEditor(kdtEntrys_endWeek_CellEditor);
        KDFormattedTextField kdtEntrys_endDays_TextField = new KDFormattedTextField();
        kdtEntrys_endDays_TextField.setName("kdtEntrys_endDays_TextField");
        kdtEntrys_endDays_TextField.setVisible(true);
        kdtEntrys_endDays_TextField.setEditable(true);
        kdtEntrys_endDays_TextField.setHorizontalAlignment(2);
        kdtEntrys_endDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntrys_endDays_CellEditor = new KDTDefaultCellEditor(kdtEntrys_endDays_TextField);
        this.kdtEntrys.getColumn("endDays").setEditor(kdtEntrys_endDays_CellEditor);
        final KDBizPromptBox kdtEntrys_henMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_henMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_henMaterial_PromptBox.setVisible(true);
        kdtEntrys_henMaterial_PromptBox.setEditable(true);
        kdtEntrys_henMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_henMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_henMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henMaterial_PromptBox);
        this.kdtEntrys.getColumn("henMaterial").setEditor(kdtEntrys_henMaterial_CellEditor);
        ObjectValueRender kdtEntrys_henMaterial_OVR = new ObjectValueRender();
        kdtEntrys_henMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("henMaterial").setRenderer(kdtEntrys_henMaterial_OVR);
        KDFormattedTextField kdtEntrys_henQtyPerday_TextField = new KDFormattedTextField();
        kdtEntrys_henQtyPerday_TextField.setName("kdtEntrys_henQtyPerday_TextField");
        kdtEntrys_henQtyPerday_TextField.setVisible(true);
        kdtEntrys_henQtyPerday_TextField.setEditable(true);
        kdtEntrys_henQtyPerday_TextField.setHorizontalAlignment(2);
        kdtEntrys_henQtyPerday_TextField.setDataType(1);
        	kdtEntrys_henQtyPerday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_henQtyPerday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_henQtyPerday_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_henQtyPerday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henQtyPerday_TextField);
        this.kdtEntrys.getColumn("henQtyPerday").setEditor(kdtEntrys_henQtyPerday_CellEditor);
        KDFormattedTextField kdtEntrys_femaleTotalFeedCost_TextField = new KDFormattedTextField();
        kdtEntrys_femaleTotalFeedCost_TextField.setName("kdtEntrys_femaleTotalFeedCost_TextField");
        kdtEntrys_femaleTotalFeedCost_TextField.setVisible(true);
        kdtEntrys_femaleTotalFeedCost_TextField.setEditable(true);
        kdtEntrys_femaleTotalFeedCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleTotalFeedCost_TextField.setDataType(1);
        	kdtEntrys_femaleTotalFeedCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleTotalFeedCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleTotalFeedCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleTotalFeedCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleTotalFeedCost_TextField);
        this.kdtEntrys.getColumn("femaleTotalFeedCost").setEditor(kdtEntrys_femaleTotalFeedCost_CellEditor);
        final KDBizPromptBox kdtEntrys_cockMaterial_PromptBox = new KDBizPromptBox();
        kdtEntrys_cockMaterial_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtEntrys_cockMaterial_PromptBox.setVisible(true);
        kdtEntrys_cockMaterial_PromptBox.setEditable(true);
        kdtEntrys_cockMaterial_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setEditFormat("$number$");
        kdtEntrys_cockMaterial_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntrys_cockMaterial_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockMaterial_PromptBox);
        this.kdtEntrys.getColumn("cockMaterial").setEditor(kdtEntrys_cockMaterial_CellEditor);
        ObjectValueRender kdtEntrys_cockMaterial_OVR = new ObjectValueRender();
        kdtEntrys_cockMaterial_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntrys.getColumn("cockMaterial").setRenderer(kdtEntrys_cockMaterial_OVR);
        KDFormattedTextField kdtEntrys_cockQtyPerday_TextField = new KDFormattedTextField();
        kdtEntrys_cockQtyPerday_TextField.setName("kdtEntrys_cockQtyPerday_TextField");
        kdtEntrys_cockQtyPerday_TextField.setVisible(true);
        kdtEntrys_cockQtyPerday_TextField.setEditable(true);
        kdtEntrys_cockQtyPerday_TextField.setHorizontalAlignment(2);
        kdtEntrys_cockQtyPerday_TextField.setDataType(1);
        	kdtEntrys_cockQtyPerday_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_cockQtyPerday_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_cockQtyPerday_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_cockQtyPerday_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cockQtyPerday_TextField);
        this.kdtEntrys.getColumn("cockQtyPerday").setEditor(kdtEntrys_cockQtyPerday_CellEditor);
        KDFormattedTextField kdtEntrys_totalFeedCost_TextField = new KDFormattedTextField();
        kdtEntrys_totalFeedCost_TextField.setName("kdtEntrys_totalFeedCost_TextField");
        kdtEntrys_totalFeedCost_TextField.setVisible(true);
        kdtEntrys_totalFeedCost_TextField.setEditable(true);
        kdtEntrys_totalFeedCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_totalFeedCost_TextField.setDataType(1);
        	kdtEntrys_totalFeedCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totalFeedCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totalFeedCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totalFeedCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totalFeedCost_TextField);
        this.kdtEntrys.getColumn("totalFeedCost").setEditor(kdtEntrys_totalFeedCost_CellEditor);
        KDFormattedTextField kdtEntrys_allTotalFeedCost_TextField = new KDFormattedTextField();
        kdtEntrys_allTotalFeedCost_TextField.setName("kdtEntrys_allTotalFeedCost_TextField");
        kdtEntrys_allTotalFeedCost_TextField.setVisible(true);
        kdtEntrys_allTotalFeedCost_TextField.setEditable(true);
        kdtEntrys_allTotalFeedCost_TextField.setHorizontalAlignment(2);
        kdtEntrys_allTotalFeedCost_TextField.setDataType(1);
        	kdtEntrys_allTotalFeedCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_allTotalFeedCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_allTotalFeedCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_allTotalFeedCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_allTotalFeedCost_TextField);
        this.kdtEntrys.getColumn("allTotalFeedCost").setEditor(kdtEntrys_allTotalFeedCost_CellEditor);
        KDFormattedTextField kdtEntrys_femaleStandardWgt_TextField = new KDFormattedTextField();
        kdtEntrys_femaleStandardWgt_TextField.setName("kdtEntrys_femaleStandardWgt_TextField");
        kdtEntrys_femaleStandardWgt_TextField.setVisible(true);
        kdtEntrys_femaleStandardWgt_TextField.setEditable(true);
        kdtEntrys_femaleStandardWgt_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleStandardWgt_TextField.setDataType(1);
        	kdtEntrys_femaleStandardWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleStandardWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleStandardWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleStandardWgt_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleStandardWgt_TextField);
        this.kdtEntrys.getColumn("femaleStandardWgt").setEditor(kdtEntrys_femaleStandardWgt_CellEditor);
        KDFormattedTextField kdtEntrys_standardWeight_TextField = new KDFormattedTextField();
        kdtEntrys_standardWeight_TextField.setName("kdtEntrys_standardWeight_TextField");
        kdtEntrys_standardWeight_TextField.setVisible(true);
        kdtEntrys_standardWeight_TextField.setEditable(true);
        kdtEntrys_standardWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_standardWeight_TextField.setDataType(1);
        	kdtEntrys_standardWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_standardWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_standardWeight_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_standardWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_standardWeight_TextField);
        this.kdtEntrys.getColumn("standardWeight").setEditor(kdtEntrys_standardWeight_CellEditor);
        KDFormattedTextField kdtEntrys_dailyDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_dailyDCRate_TextField.setName("kdtEntrys_dailyDCRate_TextField");
        kdtEntrys_dailyDCRate_TextField.setVisible(true);
        kdtEntrys_dailyDCRate_TextField.setEditable(true);
        kdtEntrys_dailyDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_dailyDCRate_TextField.setDataType(1);
        	kdtEntrys_dailyDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dailyDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dailyDCRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dailyDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dailyDCRate_TextField);
        this.kdtEntrys.getColumn("dailyDCRate").setEditor(kdtEntrys_dailyDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_femalePerWeekDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_femalePerWeekDCRate_TextField.setName("kdtEntrys_femalePerWeekDCRate_TextField");
        kdtEntrys_femalePerWeekDCRate_TextField.setVisible(true);
        kdtEntrys_femalePerWeekDCRate_TextField.setEditable(true);
        kdtEntrys_femalePerWeekDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_femalePerWeekDCRate_TextField.setDataType(1);
        	kdtEntrys_femalePerWeekDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femalePerWeekDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femalePerWeekDCRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femalePerWeekDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femalePerWeekDCRate_TextField);
        this.kdtEntrys.getColumn("femalePerWeekDCRate").setEditor(kdtEntrys_femalePerWeekDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_femaleTotalWeekDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_femaleTotalWeekDCRate_TextField.setName("kdtEntrys_femaleTotalWeekDCRate_TextField");
        kdtEntrys_femaleTotalWeekDCRate_TextField.setVisible(true);
        kdtEntrys_femaleTotalWeekDCRate_TextField.setEditable(true);
        kdtEntrys_femaleTotalWeekDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleTotalWeekDCRate_TextField.setDataType(1);
        	kdtEntrys_femaleTotalWeekDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleTotalWeekDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleTotalWeekDCRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleTotalWeekDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleTotalWeekDCRate_TextField);
        this.kdtEntrys.getColumn("femaleTotalWeekDCRate").setEditor(kdtEntrys_femaleTotalWeekDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_femaleLivability_TextField = new KDFormattedTextField();
        kdtEntrys_femaleLivability_TextField.setName("kdtEntrys_femaleLivability_TextField");
        kdtEntrys_femaleLivability_TextField.setVisible(true);
        kdtEntrys_femaleLivability_TextField.setEditable(true);
        kdtEntrys_femaleLivability_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleLivability_TextField.setDataType(1);
        	kdtEntrys_femaleLivability_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleLivability_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleLivability_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleLivability_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleLivability_TextField);
        this.kdtEntrys.getColumn("femaleLivability").setEditor(kdtEntrys_femaleLivability_CellEditor);
        KDFormattedTextField kdtEntrys_femaleLossWeight_TextField = new KDFormattedTextField();
        kdtEntrys_femaleLossWeight_TextField.setName("kdtEntrys_femaleLossWeight_TextField");
        kdtEntrys_femaleLossWeight_TextField.setVisible(true);
        kdtEntrys_femaleLossWeight_TextField.setEditable(true);
        kdtEntrys_femaleLossWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleLossWeight_TextField.setDataType(1);
        	kdtEntrys_femaleLossWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleLossWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleLossWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleLossWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleLossWeight_TextField);
        this.kdtEntrys.getColumn("femaleLossWeight").setEditor(kdtEntrys_femaleLossWeight_CellEditor);
        KDFormattedTextField kdtEntrys_femaleLossRate_TextField = new KDFormattedTextField();
        kdtEntrys_femaleLossRate_TextField.setName("kdtEntrys_femaleLossRate_TextField");
        kdtEntrys_femaleLossRate_TextField.setVisible(true);
        kdtEntrys_femaleLossRate_TextField.setEditable(true);
        kdtEntrys_femaleLossRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_femaleLossRate_TextField.setDataType(1);
        	kdtEntrys_femaleLossRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_femaleLossRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_femaleLossRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_femaleLossRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_femaleLossRate_TextField);
        this.kdtEntrys.getColumn("femaleLossRate").setEditor(kdtEntrys_femaleLossRate_CellEditor);
        KDFormattedTextField kdtEntrys_perWeekDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_perWeekDCRate_TextField.setName("kdtEntrys_perWeekDCRate_TextField");
        kdtEntrys_perWeekDCRate_TextField.setVisible(true);
        kdtEntrys_perWeekDCRate_TextField.setEditable(true);
        kdtEntrys_perWeekDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_perWeekDCRate_TextField.setDataType(1);
        	kdtEntrys_perWeekDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_perWeekDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_perWeekDCRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_perWeekDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_perWeekDCRate_TextField);
        this.kdtEntrys.getColumn("perWeekDCRate").setEditor(kdtEntrys_perWeekDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_totalWeekDCRate_TextField = new KDFormattedTextField();
        kdtEntrys_totalWeekDCRate_TextField.setName("kdtEntrys_totalWeekDCRate_TextField");
        kdtEntrys_totalWeekDCRate_TextField.setVisible(true);
        kdtEntrys_totalWeekDCRate_TextField.setEditable(true);
        kdtEntrys_totalWeekDCRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_totalWeekDCRate_TextField.setDataType(1);
        	kdtEntrys_totalWeekDCRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_totalWeekDCRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_totalWeekDCRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_totalWeekDCRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_totalWeekDCRate_TextField);
        this.kdtEntrys.getColumn("totalWeekDCRate").setEditor(kdtEntrys_totalWeekDCRate_CellEditor);
        KDFormattedTextField kdtEntrys_livability_TextField = new KDFormattedTextField();
        kdtEntrys_livability_TextField.setName("kdtEntrys_livability_TextField");
        kdtEntrys_livability_TextField.setVisible(true);
        kdtEntrys_livability_TextField.setEditable(true);
        kdtEntrys_livability_TextField.setHorizontalAlignment(2);
        kdtEntrys_livability_TextField.setDataType(1);
        	kdtEntrys_livability_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_livability_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_livability_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_livability_CellEditor = new KDTDefaultCellEditor(kdtEntrys_livability_TextField);
        this.kdtEntrys.getColumn("livability").setEditor(kdtEntrys_livability_CellEditor);
        KDFormattedTextField kdtEntrys_maleLossWeight_TextField = new KDFormattedTextField();
        kdtEntrys_maleLossWeight_TextField.setName("kdtEntrys_maleLossWeight_TextField");
        kdtEntrys_maleLossWeight_TextField.setVisible(true);
        kdtEntrys_maleLossWeight_TextField.setEditable(true);
        kdtEntrys_maleLossWeight_TextField.setHorizontalAlignment(2);
        kdtEntrys_maleLossWeight_TextField.setDataType(1);
        	kdtEntrys_maleLossWeight_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_maleLossWeight_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_maleLossWeight_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_maleLossWeight_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maleLossWeight_TextField);
        this.kdtEntrys.getColumn("maleLossWeight").setEditor(kdtEntrys_maleLossWeight_CellEditor);
        KDFormattedTextField kdtEntrys_maleLossRate_TextField = new KDFormattedTextField();
        kdtEntrys_maleLossRate_TextField.setName("kdtEntrys_maleLossRate_TextField");
        kdtEntrys_maleLossRate_TextField.setVisible(true);
        kdtEntrys_maleLossRate_TextField.setEditable(true);
        kdtEntrys_maleLossRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_maleLossRate_TextField.setDataType(1);
        	kdtEntrys_maleLossRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_maleLossRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_maleLossRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_maleLossRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_maleLossRate_TextField);
        this.kdtEntrys.getColumn("maleLossRate").setEditor(kdtEntrys_maleLossRate_CellEditor);
        KDFormattedTextField kdtEntrys_uniformRate_TextField = new KDFormattedTextField();
        kdtEntrys_uniformRate_TextField.setName("kdtEntrys_uniformRate_TextField");
        kdtEntrys_uniformRate_TextField.setVisible(true);
        kdtEntrys_uniformRate_TextField.setEditable(true);
        kdtEntrys_uniformRate_TextField.setHorizontalAlignment(2);
        kdtEntrys_uniformRate_TextField.setDataType(1);
        	kdtEntrys_uniformRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_uniformRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_uniformRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_uniformRate_CellEditor = new KDTDefaultCellEditor(kdtEntrys_uniformRate_TextField);
        this.kdtEntrys.getColumn("uniformRate").setEditor(kdtEntrys_uniformRate_CellEditor);
        KDFormattedTextField kdtEntrys_FemaleWgtMin_TextField = new KDFormattedTextField();
        kdtEntrys_FemaleWgtMin_TextField.setName("kdtEntrys_FemaleWgtMin_TextField");
        kdtEntrys_FemaleWgtMin_TextField.setVisible(true);
        kdtEntrys_FemaleWgtMin_TextField.setEditable(true);
        kdtEntrys_FemaleWgtMin_TextField.setHorizontalAlignment(2);
        kdtEntrys_FemaleWgtMin_TextField.setDataType(1);
        	kdtEntrys_FemaleWgtMin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_FemaleWgtMin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_FemaleWgtMin_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_FemaleWgtMin_CellEditor = new KDTDefaultCellEditor(kdtEntrys_FemaleWgtMin_TextField);
        this.kdtEntrys.getColumn("FemaleWgtMin").setEditor(kdtEntrys_FemaleWgtMin_CellEditor);
        KDFormattedTextField kdtEntrys_FemaleWgtMax_TextField = new KDFormattedTextField();
        kdtEntrys_FemaleWgtMax_TextField.setName("kdtEntrys_FemaleWgtMax_TextField");
        kdtEntrys_FemaleWgtMax_TextField.setVisible(true);
        kdtEntrys_FemaleWgtMax_TextField.setEditable(true);
        kdtEntrys_FemaleWgtMax_TextField.setHorizontalAlignment(2);
        kdtEntrys_FemaleWgtMax_TextField.setDataType(1);
        	kdtEntrys_FemaleWgtMax_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntrys_FemaleWgtMax_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntrys_FemaleWgtMax_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntrys_FemaleWgtMax_CellEditor = new KDTDefaultCellEditor(kdtEntrys_FemaleWgtMax_TextField);
        this.kdtEntrys.getColumn("FemaleWgtMax").setEditor(kdtEntrys_FemaleWgtMax_CellEditor);
        KDFormattedTextField kdtEntrys_dynamiting_TextField = new KDFormattedTextField();
        kdtEntrys_dynamiting_TextField.setName("kdtEntrys_dynamiting_TextField");
        kdtEntrys_dynamiting_TextField.setVisible(true);
        kdtEntrys_dynamiting_TextField.setEditable(true);
        kdtEntrys_dynamiting_TextField.setHorizontalAlignment(2);
        kdtEntrys_dynamiting_TextField.setDataType(1);
        	kdtEntrys_dynamiting_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_dynamiting_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_dynamiting_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_dynamiting_CellEditor = new KDTDefaultCellEditor(kdtEntrys_dynamiting_TextField);
        this.kdtEntrys.getColumn("dynamiting").setEditor(kdtEntrys_dynamiting_CellEditor);
        KDFormattedTextField kdtEntrys_waterQty_TextField = new KDFormattedTextField();
        kdtEntrys_waterQty_TextField.setName("kdtEntrys_waterQty_TextField");
        kdtEntrys_waterQty_TextField.setVisible(true);
        kdtEntrys_waterQty_TextField.setEditable(true);
        kdtEntrys_waterQty_TextField.setHorizontalAlignment(2);
        kdtEntrys_waterQty_TextField.setDataType(1);
        	kdtEntrys_waterQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_waterQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_waterQty_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_waterQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_waterQty_TextField);
        this.kdtEntrys.getColumn("waterQty").setEditor(kdtEntrys_waterQty_CellEditor);
        KDFormattedTextField kdtEntrys_breedTime_TextField = new KDFormattedTextField();
        kdtEntrys_breedTime_TextField.setName("kdtEntrys_breedTime_TextField");
        kdtEntrys_breedTime_TextField.setVisible(true);
        kdtEntrys_breedTime_TextField.setEditable(true);
        kdtEntrys_breedTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_breedTime_TextField.setDataType(1);
        	kdtEntrys_breedTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_breedTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_breedTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_breedTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_breedTime_TextField);
        this.kdtEntrys.getColumn("breedTime").setEditor(kdtEntrys_breedTime_CellEditor);
        KDFormattedTextField kdtEntrys_lightingTime_TextField = new KDFormattedTextField();
        kdtEntrys_lightingTime_TextField.setName("kdtEntrys_lightingTime_TextField");
        kdtEntrys_lightingTime_TextField.setVisible(true);
        kdtEntrys_lightingTime_TextField.setEditable(true);
        kdtEntrys_lightingTime_TextField.setHorizontalAlignment(2);
        kdtEntrys_lightingTime_TextField.setDataType(1);
        	kdtEntrys_lightingTime_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_lightingTime_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_lightingTime_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_lightingTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_lightingTime_TextField);
        this.kdtEntrys.getColumn("lightingTime").setEditor(kdtEntrys_lightingTime_CellEditor);
        KDFormattedTextField kdtEntrys_temperatureTo_TextField = new KDFormattedTextField();
        kdtEntrys_temperatureTo_TextField.setName("kdtEntrys_temperatureTo_TextField");
        kdtEntrys_temperatureTo_TextField.setVisible(true);
        kdtEntrys_temperatureTo_TextField.setEditable(true);
        kdtEntrys_temperatureTo_TextField.setHorizontalAlignment(2);
        kdtEntrys_temperatureTo_TextField.setDataType(1);
        	kdtEntrys_temperatureTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_temperatureTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_temperatureTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_temperatureTo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_temperatureTo_TextField);
        this.kdtEntrys.getColumn("temperatureTo").setEditor(kdtEntrys_temperatureTo_CellEditor);
        KDFormattedTextField kdtEntrys_temperatureFrom_TextField = new KDFormattedTextField();
        kdtEntrys_temperatureFrom_TextField.setName("kdtEntrys_temperatureFrom_TextField");
        kdtEntrys_temperatureFrom_TextField.setVisible(true);
        kdtEntrys_temperatureFrom_TextField.setEditable(true);
        kdtEntrys_temperatureFrom_TextField.setHorizontalAlignment(2);
        kdtEntrys_temperatureFrom_TextField.setDataType(1);
        	kdtEntrys_temperatureFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_temperatureFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_temperatureFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_temperatureFrom_CellEditor = new KDTDefaultCellEditor(kdtEntrys_temperatureFrom_TextField);
        this.kdtEntrys.getColumn("temperatureFrom").setEditor(kdtEntrys_temperatureFrom_CellEditor);
        KDFormattedTextField kdtEntrys_humidityFrom_TextField = new KDFormattedTextField();
        kdtEntrys_humidityFrom_TextField.setName("kdtEntrys_humidityFrom_TextField");
        kdtEntrys_humidityFrom_TextField.setVisible(true);
        kdtEntrys_humidityFrom_TextField.setEditable(true);
        kdtEntrys_humidityFrom_TextField.setHorizontalAlignment(2);
        kdtEntrys_humidityFrom_TextField.setDataType(1);
        	kdtEntrys_humidityFrom_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_humidityFrom_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_humidityFrom_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_humidityFrom_CellEditor = new KDTDefaultCellEditor(kdtEntrys_humidityFrom_TextField);
        this.kdtEntrys.getColumn("humidityFrom").setEditor(kdtEntrys_humidityFrom_CellEditor);
        KDFormattedTextField kdtEntrys_humidityTo_TextField = new KDFormattedTextField();
        kdtEntrys_humidityTo_TextField.setName("kdtEntrys_humidityTo_TextField");
        kdtEntrys_humidityTo_TextField.setVisible(true);
        kdtEntrys_humidityTo_TextField.setEditable(true);
        kdtEntrys_humidityTo_TextField.setHorizontalAlignment(2);
        kdtEntrys_humidityTo_TextField.setDataType(1);
        	kdtEntrys_humidityTo_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtEntrys_humidityTo_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtEntrys_humidityTo_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtEntrys_humidityTo_CellEditor = new KDTDefaultCellEditor(kdtEntrys_humidityTo_TextField);
        this.kdtEntrys.getColumn("humidityTo").setEditor(kdtEntrys_humidityTo_CellEditor);
        // kdtLayEggEntrys
		String kdtLayEggEntrysStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol9\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol27\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol28\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol29\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol30\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol31\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"endWeek\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"endDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"freakRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"doubleYolkRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"brokenRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"innerPrice\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"eggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol9\" /><t:Column t:key=\"inHouseLayRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"livestockWeekLayEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"livestockTotalLayEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"inHouseWeekLayEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"inHouseTotalLayEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"upEggRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"livestockWeekQEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"livestockTotalQEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"inHouseWeekQEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"inHouseTotalQEggs\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"qEggWeekFeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"qEggTotalFeedCost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"eggFertity\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"fEggHatchability\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"weekSaleableChicks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"hatchability\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"totalSaleableChicks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /><t:Column t:key=\"inHouseWeekSChicks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol27\" /><t:Column t:key=\"inHouseTotalSChicks\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol28\" /><t:Column t:key=\"zcUtilization\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol29\" /><t:Column t:key=\"saleableChickHatchRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol30\" /><t:Column t:key=\"averageEggWgt\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol31\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{endWeek}</t:Cell><t:Cell>$Resource{endDays}</t:Cell><t:Cell>$Resource{freakRate}</t:Cell><t:Cell>$Resource{doubleYolkRate}</t:Cell><t:Cell>$Resource{brokenRate}</t:Cell><t:Cell>$Resource{innerPrice}</t:Cell><t:Cell>$Resource{eggRate}</t:Cell><t:Cell>$Resource{inHouseLayRate}</t:Cell><t:Cell>$Resource{livestockWeekLayEggs}</t:Cell><t:Cell>$Resource{livestockTotalLayEggs}</t:Cell><t:Cell>$Resource{inHouseWeekLayEggs}</t:Cell><t:Cell>$Resource{inHouseTotalLayEggs}</t:Cell><t:Cell>$Resource{upEggRate}</t:Cell><t:Cell>$Resource{livestockWeekQEggs}</t:Cell><t:Cell>$Resource{livestockTotalQEggs}</t:Cell><t:Cell>$Resource{inHouseWeekQEggs}</t:Cell><t:Cell>$Resource{inHouseTotalQEggs}</t:Cell><t:Cell>$Resource{qEggWeekFeedCost}</t:Cell><t:Cell>$Resource{qEggTotalFeedCost}</t:Cell><t:Cell>$Resource{eggFertity}</t:Cell><t:Cell>$Resource{fEggHatchability}</t:Cell><t:Cell>$Resource{weekSaleableChicks}</t:Cell><t:Cell>$Resource{hatchability}</t:Cell><t:Cell>$Resource{totalSaleableChicks}</t:Cell><t:Cell>$Resource{inHouseWeekSChicks}</t:Cell><t:Cell>$Resource{inHouseTotalSChicks}</t:Cell><t:Cell>$Resource{zcUtilization}</t:Cell><t:Cell>$Resource{saleableChickHatchRate}</t:Cell><t:Cell>$Resource{averageEggWgt}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtLayEggEntrys.setFormatXml(resHelper.translateString("kdtLayEggEntrys",kdtLayEggEntrysStrXML));
        kdtLayEggEntrys.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtLayEggEntrys_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtLayEggEntrys.putBindContents("editData",new String[] {"seq","week","days","endWeek","endDays","freakRate","doubleYolkRate","brokenRate","innerPrice","eggRate","inHouseLayRate","livestockWeekLayEggs","livestockTotalLayEggs","inHouseWeekLayEggs","inHouseTotalLayEggs","upEggRate","livestockWeekQEggs","livestockTotalQEggs","inHouseWeekQEggs","inHouseTotalQEggs","qEggWeekFeedCost","qEggTotalFeedCost","eggFertity","fEggHatchability","weekSaleableChicks","hatchability","totalSaleableChicks","inHouseWeekSChicks","inHouseTotalSChicks","zcUtilization","saleableChickHatchRate","averageEggWgt"});


        this.kdtLayEggEntrys.checkParsed();
        KDFormattedTextField kdtLayEggEntrys_week_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_week_TextField.setName("kdtLayEggEntrys_week_TextField");
        kdtLayEggEntrys_week_TextField.setVisible(true);
        kdtLayEggEntrys_week_TextField.setEditable(true);
        kdtLayEggEntrys_week_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_week_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_week_TextField);
        this.kdtLayEggEntrys.getColumn("week").setEditor(kdtLayEggEntrys_week_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_days_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_days_TextField.setName("kdtLayEggEntrys_days_TextField");
        kdtLayEggEntrys_days_TextField.setVisible(true);
        kdtLayEggEntrys_days_TextField.setEditable(true);
        kdtLayEggEntrys_days_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_days_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_days_TextField);
        this.kdtLayEggEntrys.getColumn("days").setEditor(kdtLayEggEntrys_days_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_endWeek_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_endWeek_TextField.setName("kdtLayEggEntrys_endWeek_TextField");
        kdtLayEggEntrys_endWeek_TextField.setVisible(true);
        kdtLayEggEntrys_endWeek_TextField.setEditable(true);
        kdtLayEggEntrys_endWeek_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_endWeek_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_endWeek_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_endWeek_TextField);
        this.kdtLayEggEntrys.getColumn("endWeek").setEditor(kdtLayEggEntrys_endWeek_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_endDays_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_endDays_TextField.setName("kdtLayEggEntrys_endDays_TextField");
        kdtLayEggEntrys_endDays_TextField.setVisible(true);
        kdtLayEggEntrys_endDays_TextField.setEditable(true);
        kdtLayEggEntrys_endDays_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_endDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtLayEggEntrys_endDays_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_endDays_TextField);
        this.kdtLayEggEntrys.getColumn("endDays").setEditor(kdtLayEggEntrys_endDays_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_freakRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_freakRate_TextField.setName("kdtLayEggEntrys_freakRate_TextField");
        kdtLayEggEntrys_freakRate_TextField.setVisible(true);
        kdtLayEggEntrys_freakRate_TextField.setEditable(true);
        kdtLayEggEntrys_freakRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_freakRate_TextField.setDataType(1);
        	kdtLayEggEntrys_freakRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_freakRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_freakRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_freakRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_freakRate_TextField);
        this.kdtLayEggEntrys.getColumn("freakRate").setEditor(kdtLayEggEntrys_freakRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_doubleYolkRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_doubleYolkRate_TextField.setName("kdtLayEggEntrys_doubleYolkRate_TextField");
        kdtLayEggEntrys_doubleYolkRate_TextField.setVisible(true);
        kdtLayEggEntrys_doubleYolkRate_TextField.setEditable(true);
        kdtLayEggEntrys_doubleYolkRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_doubleYolkRate_TextField.setDataType(1);
        	kdtLayEggEntrys_doubleYolkRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_doubleYolkRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_doubleYolkRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_doubleYolkRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_doubleYolkRate_TextField);
        this.kdtLayEggEntrys.getColumn("doubleYolkRate").setEditor(kdtLayEggEntrys_doubleYolkRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_brokenRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_brokenRate_TextField.setName("kdtLayEggEntrys_brokenRate_TextField");
        kdtLayEggEntrys_brokenRate_TextField.setVisible(true);
        kdtLayEggEntrys_brokenRate_TextField.setEditable(true);
        kdtLayEggEntrys_brokenRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_brokenRate_TextField.setDataType(1);
        	kdtLayEggEntrys_brokenRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_brokenRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_brokenRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_brokenRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_brokenRate_TextField);
        this.kdtLayEggEntrys.getColumn("brokenRate").setEditor(kdtLayEggEntrys_brokenRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_innerPrice_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_innerPrice_TextField.setName("kdtLayEggEntrys_innerPrice_TextField");
        kdtLayEggEntrys_innerPrice_TextField.setVisible(true);
        kdtLayEggEntrys_innerPrice_TextField.setEditable(true);
        kdtLayEggEntrys_innerPrice_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_innerPrice_TextField.setDataType(1);
        	kdtLayEggEntrys_innerPrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_innerPrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_innerPrice_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_innerPrice_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_innerPrice_TextField);
        this.kdtLayEggEntrys.getColumn("innerPrice").setEditor(kdtLayEggEntrys_innerPrice_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_eggRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_eggRate_TextField.setName("kdtLayEggEntrys_eggRate_TextField");
        kdtLayEggEntrys_eggRate_TextField.setVisible(true);
        kdtLayEggEntrys_eggRate_TextField.setEditable(true);
        kdtLayEggEntrys_eggRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_eggRate_TextField.setDataType(1);
        	kdtLayEggEntrys_eggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_eggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_eggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_eggRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_eggRate_TextField);
        this.kdtLayEggEntrys.getColumn("eggRate").setEditor(kdtLayEggEntrys_eggRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseLayRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseLayRate_TextField.setName("kdtLayEggEntrys_inHouseLayRate_TextField");
        kdtLayEggEntrys_inHouseLayRate_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseLayRate_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseLayRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseLayRate_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseLayRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseLayRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseLayRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseLayRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseLayRate_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseLayRate").setEditor(kdtLayEggEntrys_inHouseLayRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_livestockWeekLayEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setName("kdtLayEggEntrys_livestockWeekLayEggs_TextField");
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setVisible(true);
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setEditable(true);
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_livestockWeekLayEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_livestockWeekLayEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_livestockWeekLayEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_livestockWeekLayEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_livestockWeekLayEggs_TextField);
        this.kdtLayEggEntrys.getColumn("livestockWeekLayEggs").setEditor(kdtLayEggEntrys_livestockWeekLayEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_livestockTotalLayEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setName("kdtLayEggEntrys_livestockTotalLayEggs_TextField");
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setVisible(true);
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setEditable(true);
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_livestockTotalLayEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_livestockTotalLayEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_livestockTotalLayEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_livestockTotalLayEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_livestockTotalLayEggs_TextField);
        this.kdtLayEggEntrys.getColumn("livestockTotalLayEggs").setEditor(kdtLayEggEntrys_livestockTotalLayEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseWeekLayEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setName("kdtLayEggEntrys_inHouseWeekLayEggs_TextField");
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseWeekLayEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseWeekLayEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseWeekLayEggs_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseWeekLayEggs").setEditor(kdtLayEggEntrys_inHouseWeekLayEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseTotalLayEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setName("kdtLayEggEntrys_inHouseTotalLayEggs_TextField");
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseTotalLayEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseTotalLayEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseTotalLayEggs_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseTotalLayEggs").setEditor(kdtLayEggEntrys_inHouseTotalLayEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_upEggRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_upEggRate_TextField.setName("kdtLayEggEntrys_upEggRate_TextField");
        kdtLayEggEntrys_upEggRate_TextField.setVisible(true);
        kdtLayEggEntrys_upEggRate_TextField.setEditable(true);
        kdtLayEggEntrys_upEggRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_upEggRate_TextField.setDataType(1);
        	kdtLayEggEntrys_upEggRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtLayEggEntrys_upEggRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtLayEggEntrys_upEggRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtLayEggEntrys_upEggRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_upEggRate_TextField);
        this.kdtLayEggEntrys.getColumn("upEggRate").setEditor(kdtLayEggEntrys_upEggRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_livestockWeekQEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setName("kdtLayEggEntrys_livestockWeekQEggs_TextField");
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setVisible(true);
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setEditable(true);
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_livestockWeekQEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_livestockWeekQEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_livestockWeekQEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_livestockWeekQEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_livestockWeekQEggs_TextField);
        this.kdtLayEggEntrys.getColumn("livestockWeekQEggs").setEditor(kdtLayEggEntrys_livestockWeekQEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_livestockTotalQEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setName("kdtLayEggEntrys_livestockTotalQEggs_TextField");
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setVisible(true);
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setEditable(true);
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_livestockTotalQEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_livestockTotalQEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_livestockTotalQEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_livestockTotalQEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_livestockTotalQEggs_TextField);
        this.kdtLayEggEntrys.getColumn("livestockTotalQEggs").setEditor(kdtLayEggEntrys_livestockTotalQEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseWeekQEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setName("kdtLayEggEntrys_inHouseWeekQEggs_TextField");
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseWeekQEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseWeekQEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseWeekQEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseWeekQEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseWeekQEggs_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseWeekQEggs").setEditor(kdtLayEggEntrys_inHouseWeekQEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseTotalQEggs_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setName("kdtLayEggEntrys_inHouseTotalQEggs_TextField");
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseTotalQEggs_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseTotalQEggs_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseTotalQEggs_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseTotalQEggs_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseTotalQEggs_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseTotalQEggs").setEditor(kdtLayEggEntrys_inHouseTotalQEggs_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_qEggWeekFeedCost_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setName("kdtLayEggEntrys_qEggWeekFeedCost_TextField");
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setVisible(true);
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setEditable(true);
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setDataType(1);
        	kdtLayEggEntrys_qEggWeekFeedCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_qEggWeekFeedCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_qEggWeekFeedCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_qEggWeekFeedCost_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_qEggWeekFeedCost_TextField);
        this.kdtLayEggEntrys.getColumn("qEggWeekFeedCost").setEditor(kdtLayEggEntrys_qEggWeekFeedCost_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_qEggTotalFeedCost_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setName("kdtLayEggEntrys_qEggTotalFeedCost_TextField");
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setVisible(true);
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setEditable(true);
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setDataType(1);
        	kdtLayEggEntrys_qEggTotalFeedCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_qEggTotalFeedCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_qEggTotalFeedCost_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_qEggTotalFeedCost_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_qEggTotalFeedCost_TextField);
        this.kdtLayEggEntrys.getColumn("qEggTotalFeedCost").setEditor(kdtLayEggEntrys_qEggTotalFeedCost_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_eggFertity_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_eggFertity_TextField.setName("kdtLayEggEntrys_eggFertity_TextField");
        kdtLayEggEntrys_eggFertity_TextField.setVisible(true);
        kdtLayEggEntrys_eggFertity_TextField.setEditable(true);
        kdtLayEggEntrys_eggFertity_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_eggFertity_TextField.setDataType(1);
        	kdtLayEggEntrys_eggFertity_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_eggFertity_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_eggFertity_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_eggFertity_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_eggFertity_TextField);
        this.kdtLayEggEntrys.getColumn("eggFertity").setEditor(kdtLayEggEntrys_eggFertity_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_fEggHatchability_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_fEggHatchability_TextField.setName("kdtLayEggEntrys_fEggHatchability_TextField");
        kdtLayEggEntrys_fEggHatchability_TextField.setVisible(true);
        kdtLayEggEntrys_fEggHatchability_TextField.setEditable(true);
        kdtLayEggEntrys_fEggHatchability_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_fEggHatchability_TextField.setDataType(1);
        	kdtLayEggEntrys_fEggHatchability_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_fEggHatchability_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_fEggHatchability_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_fEggHatchability_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_fEggHatchability_TextField);
        this.kdtLayEggEntrys.getColumn("fEggHatchability").setEditor(kdtLayEggEntrys_fEggHatchability_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_weekSaleableChicks_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_weekSaleableChicks_TextField.setName("kdtLayEggEntrys_weekSaleableChicks_TextField");
        kdtLayEggEntrys_weekSaleableChicks_TextField.setVisible(true);
        kdtLayEggEntrys_weekSaleableChicks_TextField.setEditable(true);
        kdtLayEggEntrys_weekSaleableChicks_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_weekSaleableChicks_TextField.setDataType(1);
        	kdtLayEggEntrys_weekSaleableChicks_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_weekSaleableChicks_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_weekSaleableChicks_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_weekSaleableChicks_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_weekSaleableChicks_TextField);
        this.kdtLayEggEntrys.getColumn("weekSaleableChicks").setEditor(kdtLayEggEntrys_weekSaleableChicks_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_hatchability_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_hatchability_TextField.setName("kdtLayEggEntrys_hatchability_TextField");
        kdtLayEggEntrys_hatchability_TextField.setVisible(true);
        kdtLayEggEntrys_hatchability_TextField.setEditable(true);
        kdtLayEggEntrys_hatchability_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_hatchability_TextField.setDataType(1);
        	kdtLayEggEntrys_hatchability_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_hatchability_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_hatchability_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_hatchability_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_hatchability_TextField);
        this.kdtLayEggEntrys.getColumn("hatchability").setEditor(kdtLayEggEntrys_hatchability_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_totalSaleableChicks_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_totalSaleableChicks_TextField.setName("kdtLayEggEntrys_totalSaleableChicks_TextField");
        kdtLayEggEntrys_totalSaleableChicks_TextField.setVisible(true);
        kdtLayEggEntrys_totalSaleableChicks_TextField.setEditable(true);
        kdtLayEggEntrys_totalSaleableChicks_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_totalSaleableChicks_TextField.setDataType(1);
        	kdtLayEggEntrys_totalSaleableChicks_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_totalSaleableChicks_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_totalSaleableChicks_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_totalSaleableChicks_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_totalSaleableChicks_TextField);
        this.kdtLayEggEntrys.getColumn("totalSaleableChicks").setEditor(kdtLayEggEntrys_totalSaleableChicks_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseWeekSChicks_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setName("kdtLayEggEntrys_inHouseWeekSChicks_TextField");
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseWeekSChicks_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseWeekSChicks_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseWeekSChicks_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseWeekSChicks_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseWeekSChicks_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseWeekSChicks").setEditor(kdtLayEggEntrys_inHouseWeekSChicks_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_inHouseTotalSChicks_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setName("kdtLayEggEntrys_inHouseTotalSChicks_TextField");
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setVisible(true);
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setEditable(true);
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setDataType(1);
        	kdtLayEggEntrys_inHouseTotalSChicks_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_inHouseTotalSChicks_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_inHouseTotalSChicks_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_inHouseTotalSChicks_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_inHouseTotalSChicks_TextField);
        this.kdtLayEggEntrys.getColumn("inHouseTotalSChicks").setEditor(kdtLayEggEntrys_inHouseTotalSChicks_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_zcUtilization_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_zcUtilization_TextField.setName("kdtLayEggEntrys_zcUtilization_TextField");
        kdtLayEggEntrys_zcUtilization_TextField.setVisible(true);
        kdtLayEggEntrys_zcUtilization_TextField.setEditable(true);
        kdtLayEggEntrys_zcUtilization_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_zcUtilization_TextField.setDataType(1);
        	kdtLayEggEntrys_zcUtilization_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_zcUtilization_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_zcUtilization_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_zcUtilization_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_zcUtilization_TextField);
        this.kdtLayEggEntrys.getColumn("zcUtilization").setEditor(kdtLayEggEntrys_zcUtilization_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_saleableChickHatchRate_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setName("kdtLayEggEntrys_saleableChickHatchRate_TextField");
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setVisible(true);
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setEditable(true);
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setDataType(1);
        	kdtLayEggEntrys_saleableChickHatchRate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_saleableChickHatchRate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_saleableChickHatchRate_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_saleableChickHatchRate_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_saleableChickHatchRate_TextField);
        this.kdtLayEggEntrys.getColumn("saleableChickHatchRate").setEditor(kdtLayEggEntrys_saleableChickHatchRate_CellEditor);
        KDFormattedTextField kdtLayEggEntrys_averageEggWgt_TextField = new KDFormattedTextField();
        kdtLayEggEntrys_averageEggWgt_TextField.setName("kdtLayEggEntrys_averageEggWgt_TextField");
        kdtLayEggEntrys_averageEggWgt_TextField.setVisible(true);
        kdtLayEggEntrys_averageEggWgt_TextField.setEditable(true);
        kdtLayEggEntrys_averageEggWgt_TextField.setHorizontalAlignment(2);
        kdtLayEggEntrys_averageEggWgt_TextField.setDataType(1);
        	kdtLayEggEntrys_averageEggWgt_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtLayEggEntrys_averageEggWgt_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtLayEggEntrys_averageEggWgt_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtLayEggEntrys_averageEggWgt_CellEditor = new KDTDefaultCellEditor(kdtLayEggEntrys_averageEggWgt_TextField);
        this.kdtLayEggEntrys.getColumn("averageEggWgt").setEditor(kdtLayEggEntrys_averageEggWgt_CellEditor);
        // kdtDrugEntry
		String kdtDrugEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol8\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"days\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"endWeek\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"endDays\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"material\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"materialName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"strain\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"model\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /><t:Column t:key=\"unit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"true\" t:index=\"-1\" /><t:Column t:key=\"qty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"vaccineWay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"manufacturer\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"remark\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{days}</t:Cell><t:Cell>$Resource{endWeek}</t:Cell><t:Cell>$Resource{endDays}</t:Cell><t:Cell>$Resource{material}</t:Cell><t:Cell>$Resource{materialName}</t:Cell><t:Cell>$Resource{strain}</t:Cell><t:Cell>$Resource{model}</t:Cell><t:Cell>$Resource{unit}</t:Cell><t:Cell>$Resource{qty}</t:Cell><t:Cell>$Resource{vaccineWay}</t:Cell><t:Cell>$Resource{manufacturer}</t:Cell><t:Cell>$Resource{remark}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDrugEntry.setFormatXml(resHelper.translateString("kdtDrugEntry",kdtDrugEntryStrXML));
        kdtDrugEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtDrugEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtDrugEntry.putBindContents("editData",new String[] {"seq","week","days","endWeek","endDays","material","materialName","strain","model","unit","qty","vaccineWay","manufacturer","remark"});


        this.kdtDrugEntry.checkParsed();
        KDFormattedTextField kdtDrugEntry_week_TextField = new KDFormattedTextField();
        kdtDrugEntry_week_TextField.setName("kdtDrugEntry_week_TextField");
        kdtDrugEntry_week_TextField.setVisible(true);
        kdtDrugEntry_week_TextField.setEditable(true);
        kdtDrugEntry_week_TextField.setHorizontalAlignment(2);
        kdtDrugEntry_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDrugEntry_week_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_week_TextField);
        this.kdtDrugEntry.getColumn("week").setEditor(kdtDrugEntry_week_CellEditor);
        KDFormattedTextField kdtDrugEntry_days_TextField = new KDFormattedTextField();
        kdtDrugEntry_days_TextField.setName("kdtDrugEntry_days_TextField");
        kdtDrugEntry_days_TextField.setVisible(true);
        kdtDrugEntry_days_TextField.setEditable(true);
        kdtDrugEntry_days_TextField.setHorizontalAlignment(2);
        kdtDrugEntry_days_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDrugEntry_days_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_days_TextField);
        this.kdtDrugEntry.getColumn("days").setEditor(kdtDrugEntry_days_CellEditor);
        KDFormattedTextField kdtDrugEntry_endWeek_TextField = new KDFormattedTextField();
        kdtDrugEntry_endWeek_TextField.setName("kdtDrugEntry_endWeek_TextField");
        kdtDrugEntry_endWeek_TextField.setVisible(true);
        kdtDrugEntry_endWeek_TextField.setEditable(true);
        kdtDrugEntry_endWeek_TextField.setHorizontalAlignment(2);
        kdtDrugEntry_endWeek_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDrugEntry_endWeek_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_endWeek_TextField);
        this.kdtDrugEntry.getColumn("endWeek").setEditor(kdtDrugEntry_endWeek_CellEditor);
        KDFormattedTextField kdtDrugEntry_endDays_TextField = new KDFormattedTextField();
        kdtDrugEntry_endDays_TextField.setName("kdtDrugEntry_endDays_TextField");
        kdtDrugEntry_endDays_TextField.setVisible(true);
        kdtDrugEntry_endDays_TextField.setEditable(true);
        kdtDrugEntry_endDays_TextField.setHorizontalAlignment(2);
        kdtDrugEntry_endDays_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDrugEntry_endDays_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_endDays_TextField);
        this.kdtDrugEntry.getColumn("endDays").setEditor(kdtDrugEntry_endDays_CellEditor);
        final KDBizPromptBox kdtDrugEntry_material_PromptBox = new KDBizPromptBox();
        kdtDrugEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtDrugEntry_material_PromptBox.setVisible(true);
        kdtDrugEntry_material_PromptBox.setEditable(true);
        kdtDrugEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntry_material_PromptBox.setEditFormat("$number$");
        kdtDrugEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntry_material_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_material_PromptBox);
        this.kdtDrugEntry.getColumn("material").setEditor(kdtDrugEntry_material_CellEditor);
        ObjectValueRender kdtDrugEntry_material_OVR = new ObjectValueRender();
        kdtDrugEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtDrugEntry.getColumn("material").setRenderer(kdtDrugEntry_material_OVR);
        KDTextField kdtDrugEntry_materialName_TextField = new KDTextField();
        kdtDrugEntry_materialName_TextField.setName("kdtDrugEntry_materialName_TextField");
        kdtDrugEntry_materialName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtDrugEntry_materialName_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_materialName_TextField);
        this.kdtDrugEntry.getColumn("materialName").setEditor(kdtDrugEntry_materialName_CellEditor);
        KDTextField kdtDrugEntry_strain_TextField = new KDTextField();
        kdtDrugEntry_strain_TextField.setName("kdtDrugEntry_strain_TextField");
        kdtDrugEntry_strain_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntry_strain_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_strain_TextField);
        this.kdtDrugEntry.getColumn("strain").setEditor(kdtDrugEntry_strain_CellEditor);
        KDTextField kdtDrugEntry_model_TextField = new KDTextField();
        kdtDrugEntry_model_TextField.setName("kdtDrugEntry_model_TextField");
        kdtDrugEntry_model_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtDrugEntry_model_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_model_TextField);
        this.kdtDrugEntry.getColumn("model").setEditor(kdtDrugEntry_model_CellEditor);
        final KDBizPromptBox kdtDrugEntry_unit_PromptBox = new KDBizPromptBox();
        kdtDrugEntry_unit_PromptBox.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7MeasureUnitQuery");
        kdtDrugEntry_unit_PromptBox.setVisible(true);
        kdtDrugEntry_unit_PromptBox.setEditable(true);
        kdtDrugEntry_unit_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntry_unit_PromptBox.setEditFormat("$number$");
        kdtDrugEntry_unit_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntry_unit_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_unit_PromptBox);
        this.kdtDrugEntry.getColumn("unit").setEditor(kdtDrugEntry_unit_CellEditor);
        ObjectValueRender kdtDrugEntry_unit_OVR = new ObjectValueRender();
        kdtDrugEntry_unit_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDrugEntry.getColumn("unit").setRenderer(kdtDrugEntry_unit_OVR);
        KDFormattedTextField kdtDrugEntry_qty_TextField = new KDFormattedTextField();
        kdtDrugEntry_qty_TextField.setName("kdtDrugEntry_qty_TextField");
        kdtDrugEntry_qty_TextField.setVisible(true);
        kdtDrugEntry_qty_TextField.setEditable(true);
        kdtDrugEntry_qty_TextField.setHorizontalAlignment(2);
        kdtDrugEntry_qty_TextField.setDataType(1);
        	kdtDrugEntry_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtDrugEntry_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtDrugEntry_qty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtDrugEntry_qty_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_qty_TextField);
        this.kdtDrugEntry.getColumn("qty").setEditor(kdtDrugEntry_qty_CellEditor);
        final KDBizPromptBox kdtDrugEntry_vaccineWay_PromptBox = new KDBizPromptBox();
        kdtDrugEntry_vaccineWay_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.ImmuneWayQuery");
        kdtDrugEntry_vaccineWay_PromptBox.setVisible(true);
        kdtDrugEntry_vaccineWay_PromptBox.setEditable(true);
        kdtDrugEntry_vaccineWay_PromptBox.setDisplayFormat("$number$");
        kdtDrugEntry_vaccineWay_PromptBox.setEditFormat("$number$");
        kdtDrugEntry_vaccineWay_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtDrugEntry_vaccineWay_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_vaccineWay_PromptBox);
        this.kdtDrugEntry.getColumn("vaccineWay").setEditor(kdtDrugEntry_vaccineWay_CellEditor);
        ObjectValueRender kdtDrugEntry_vaccineWay_OVR = new ObjectValueRender();
        kdtDrugEntry_vaccineWay_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtDrugEntry.getColumn("vaccineWay").setRenderer(kdtDrugEntry_vaccineWay_OVR);
        KDTextField kdtDrugEntry_manufacturer_TextField = new KDTextField();
        kdtDrugEntry_manufacturer_TextField.setName("kdtDrugEntry_manufacturer_TextField");
        kdtDrugEntry_manufacturer_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntry_manufacturer_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_manufacturer_TextField);
        this.kdtDrugEntry.getColumn("manufacturer").setEditor(kdtDrugEntry_manufacturer_CellEditor);
        KDTextField kdtDrugEntry_remark_TextField = new KDTextField();
        kdtDrugEntry_remark_TextField.setName("kdtDrugEntry_remark_TextField");
        kdtDrugEntry_remark_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtDrugEntry_remark_CellEditor = new KDTDefaultCellEditor(kdtDrugEntry_remark_TextField);
        this.kdtDrugEntry.getColumn("remark").setEditor(kdtDrugEntry_remark_CellEditor);
        // kdtDepcEntry
		String kdtDepcEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"week\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"depreciationRate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{week}</t:Cell><t:Cell>$Resource{depreciationRate}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtDepcEntry.setFormatXml(resHelper.translateString("kdtDepcEntry",kdtDepcEntryStrXML));

                this.kdtDepcEntry.putBindContents("editData",new String[] {"seq","week","depreciationRate"});


        this.kdtDepcEntry.checkParsed();
        KDFormattedTextField kdtDepcEntry_week_TextField = new KDFormattedTextField();
        kdtDepcEntry_week_TextField.setName("kdtDepcEntry_week_TextField");
        kdtDepcEntry_week_TextField.setVisible(true);
        kdtDepcEntry_week_TextField.setEditable(true);
        kdtDepcEntry_week_TextField.setHorizontalAlignment(2);
        kdtDepcEntry_week_TextField.setDataType(0);
        KDTDefaultCellEditor kdtDepcEntry_week_CellEditor = new KDTDefaultCellEditor(kdtDepcEntry_week_TextField);
        this.kdtDepcEntry.getColumn("week").setEditor(kdtDepcEntry_week_CellEditor);
        KDFormattedTextField kdtDepcEntry_depreciationRate_TextField = new KDFormattedTextField();
        kdtDepcEntry_depreciationRate_TextField.setName("kdtDepcEntry_depreciationRate_TextField");
        kdtDepcEntry_depreciationRate_TextField.setVisible(true);
        kdtDepcEntry_depreciationRate_TextField.setEditable(true);
        kdtDepcEntry_depreciationRate_TextField.setHorizontalAlignment(2);
        kdtDepcEntry_depreciationRate_TextField.setDataType(1);
        	kdtDepcEntry_depreciationRate_TextField.setMinimumValue(new java.math.BigDecimal("-9.999999999E7"));
        	kdtDepcEntry_depreciationRate_TextField.setMaximumValue(new java.math.BigDecimal("9.999999999E7"));
        kdtDepcEntry_depreciationRate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtDepcEntry_depreciationRate_CellEditor = new KDTDefaultCellEditor(kdtDepcEntry_depreciationRate_TextField);
        this.kdtDepcEntry.getColumn("depreciationRate").setEditor(kdtDepcEntry_depreciationRate_CellEditor);
        // prmtauditor		
        this.prmtauditor.setQueryInfo("com.kingdee.eas.base.permission.app.UserListQuery");		
        this.prmtauditor.setEditable(true);		
        this.prmtauditor.setDisplayFormat("$number$");		
        this.prmtauditor.setEditFormat("$number$");		
        this.prmtauditor.setCommitFormat("$number$");		
        this.prmtauditor.setRequired(false);		
        this.prmtauditor.setEnabled(false);
        // pkauditTime		
        this.pkauditTime.setRequired(false);		
        this.pkauditTime.setEnabled(false);
        // txtlimitBreedDays		
        this.txtlimitBreedDays.setHorizontalAlignment(2);		
        this.txtlimitBreedDays.setDataType(0);		
        this.txtlimitBreedDays.setSupportedEmpty(true);		
        this.txtlimitBreedDays.setRequired(false);
        // prmtbreedData		
        this.prmtbreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
        this.prmtbreedData.setEditable(true);		
        this.prmtbreedData.setDisplayFormat("$name$");		
        this.prmtbreedData.setEditFormat("$number$");		
        this.prmtbreedData.setCommitFormat("$number$");		
        this.prmtbreedData.setRequired(true);
        		prmtbreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtbreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});
					
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // tBtnAudit
        this.tBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnAudit.setText(resHelper.getString("tBtnAudit.text"));
        // tBtnUnAudit
        this.tBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.tBtnUnAudit.setText(resHelper.getString("tBtnUnAudit.text"));
        // mBtnAudit
        this.mBtnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnAudit.setText(resHelper.getString("mBtnAudit.text"));
        // mBtnUnAudit
        this.mBtnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.mBtnUnAudit.setText(resHelper.getString("mBtnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtauditor,pkauditTime,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,txtSimpleName,txtDescription,txtNumber,txtName,txtlimitBreedDays,prmtbreedData,baseStatus,prmtcompany,chkmolting,kdtEntrys,kdtLayEggEntrys,kdtDrugEntry,kdtDepcEntry}));
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
        this.setBounds(new Rectangle(0, 0, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 0, 1013, 629));
        kDLabelContainer1.setBounds(new Rectangle(33, 23, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(33, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(378, 23, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(378, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(33, -75, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(33, -75, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer4.setBounds(new Rectangle(33, 81, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(33, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(36, 575, 270, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(36, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(379, 575, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(379, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer8.setBounds(new Rectangle(36, 598, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(36, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer9.setBounds(new Rectangle(379, 598, 270, 19));
        this.add(kDLabelContainer9, new KDLayout.Constraints(379, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDTabbedPane1.setBounds(new Rectangle(26, 108, 972, 455));
        this.add(kDTabbedPane1, new KDLayout.Constraints(26, 108, 972, 455, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(726, 575, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(726, 575, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditTime.setBounds(new Rectangle(726, 598, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(726, 598, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contlimitBreedDays.setBounds(new Rectangle(715, 50, 270, 19));
        this.add(contlimitBreedDays, new KDLayout.Constraints(715, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contbreedData.setBounds(new Rectangle(33, 50, 270, 19));
        this.add(contbreedData, new KDLayout.Constraints(33, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(715, 23, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(715, 23, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(378, 50, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(378, 50, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        chkmolting.setBounds(new Rectangle(378, 81, 270, 19));
        this.add(chkmolting, new KDLayout.Constraints(378, 81, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(prmtCreator);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(prmtLastUpdateUser);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(kDDateCreateTime);
        //kDLabelContainer9
        kDLabelContainer9.setBoundEditor(kDDateLastUpdateTime);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
        kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
        kDTabbedPane1.add(kDPanel4, resHelper.getString("kDPanel4.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 422));        kdtEntrys.setBounds(new Rectangle(1, 1, 963, 405));
        kdtEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntrys,new com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryInfo(),null,false);
        kDPanel1.add(kdtEntrys_detailPanel, new KDLayout.Constraints(1, 1, 963, 405, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel2
        kDPanel2.setLayout(new KDLayout());
        kDPanel2.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 422));        kdtLayEggEntrys.setBounds(new Rectangle(2, 1, 962, 421));
        kdtLayEggEntrys_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtLayEggEntrys,new com.kingdee.eas.farm.stocking.basedata.BreedStandardLayEggEntryInfo(),null,false);
        kDPanel2.add(kdtLayEggEntrys_detailPanel, new KDLayout.Constraints(2, 1, 962, 421, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel3
        kDPanel3.setLayout(new KDLayout());
        kDPanel3.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 422));        kdtDrugEntry.setBounds(new Rectangle(0, 2, 967, 421));
        kdtDrugEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDrugEntry,new com.kingdee.eas.farm.stocking.basedata.BreedStandardDrugEntryInfo(),null,false);
        kDPanel3.add(kdtDrugEntry_detailPanel, new KDLayout.Constraints(0, 2, 967, 421, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //kDPanel4
        kDPanel4.setLayout(new KDLayout());
        kDPanel4.putClientProperty("OriginalBounds", new Rectangle(0, 0, 971, 422));        kdtDepcEntry.setBounds(new Rectangle(3, 2, 963, 419));
        kdtDepcEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtDepcEntry,new com.kingdee.eas.farm.stocking.basedata.BreedStandardDepcEntryInfo(),null,false);
        kDPanel4.add(kdtDepcEntry_detailPanel, new KDLayout.Constraints(3, 2, 963, 419, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //contlimitBreedDays
        contlimitBreedDays.setBoundEditor(txtlimitBreedDays);
        //contbreedData
        contbreedData.setBoundEditor(prmtbreedData);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);

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
        menuBiz.add(mBtnAudit);
        menuBiz.add(mBtnUnAudit);
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
        this.toolBar.add(tBtnAudit);
        this.toolBar.add(tBtnUnAudit);
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
		dataBinder.registerBinding("molting", boolean.class, this.chkmolting, "selected");
		dataBinder.registerBinding("number", String.class, this.txtNumber, "text");
		dataBinder.registerBinding("name", String.class, this.txtName, "_multiLangItem");
		dataBinder.registerBinding("simpleName", String.class, this.txtSimpleName, "text");
		dataBinder.registerBinding("description", String.class, this.txtDescription, "_multiLangItem");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("Entrys.seq", int.class, this.kdtEntrys, "seq.text");
		dataBinder.registerBinding("Entrys", com.kingdee.eas.farm.stocking.basedata.BreedStandardEntryInfo.class, this.kdtEntrys, "userObject");
		dataBinder.registerBinding("Entrys.week", int.class, this.kdtEntrys, "week.text");
		dataBinder.registerBinding("Entrys.henMaterial", java.lang.Object.class, this.kdtEntrys, "henMaterial.text");
		dataBinder.registerBinding("Entrys.henQtyPerday", java.math.BigDecimal.class, this.kdtEntrys, "henQtyPerday.text");
		dataBinder.registerBinding("Entrys.cockMaterial", java.lang.Object.class, this.kdtEntrys, "cockMaterial.text");
		dataBinder.registerBinding("Entrys.cockQtyPerday", java.math.BigDecimal.class, this.kdtEntrys, "cockQtyPerday.text");
		dataBinder.registerBinding("Entrys.waterQty", java.math.BigDecimal.class, this.kdtEntrys, "waterQty.text");
		dataBinder.registerBinding("Entrys.breedTime", java.math.BigDecimal.class, this.kdtEntrys, "breedTime.text");
		dataBinder.registerBinding("Entrys.lightingTime", java.math.BigDecimal.class, this.kdtEntrys, "lightingTime.text");
		dataBinder.registerBinding("Entrys.temperatureTo", java.math.BigDecimal.class, this.kdtEntrys, "temperatureTo.text");
		dataBinder.registerBinding("Entrys.temperatureFrom", java.math.BigDecimal.class, this.kdtEntrys, "temperatureFrom.text");
		dataBinder.registerBinding("Entrys.humidityFrom", java.math.BigDecimal.class, this.kdtEntrys, "humidityFrom.text");
		dataBinder.registerBinding("Entrys.humidityTo", java.math.BigDecimal.class, this.kdtEntrys, "humidityTo.text");
		dataBinder.registerBinding("Entrys.days", int.class, this.kdtEntrys, "days.text");
		dataBinder.registerBinding("Entrys.standardWeight", java.math.BigDecimal.class, this.kdtEntrys, "standardWeight.text");
		dataBinder.registerBinding("Entrys.dynamiting", java.math.BigDecimal.class, this.kdtEntrys, "dynamiting.text");
		dataBinder.registerBinding("Entrys.dailyDCRate", java.math.BigDecimal.class, this.kdtEntrys, "dailyDCRate.text");
		dataBinder.registerBinding("Entrys.endWeek", int.class, this.kdtEntrys, "endWeek.text");
		dataBinder.registerBinding("Entrys.endDays", int.class, this.kdtEntrys, "endDays.text");
		dataBinder.registerBinding("Entrys.femaleLivability", java.math.BigDecimal.class, this.kdtEntrys, "femaleLivability.text");
		dataBinder.registerBinding("Entrys.femaleTotalWeekDCRate", java.math.BigDecimal.class, this.kdtEntrys, "femaleTotalWeekDCRate.text");
		dataBinder.registerBinding("Entrys.femalePerWeekDCRate", java.math.BigDecimal.class, this.kdtEntrys, "femalePerWeekDCRate.text");
		dataBinder.registerBinding("Entrys.perWeekDCRate", java.math.BigDecimal.class, this.kdtEntrys, "perWeekDCRate.text");
		dataBinder.registerBinding("Entrys.totalWeekDCRate", java.math.BigDecimal.class, this.kdtEntrys, "totalWeekDCRate.text");
		dataBinder.registerBinding("Entrys.livability", java.math.BigDecimal.class, this.kdtEntrys, "livability.text");
		dataBinder.registerBinding("Entrys.femaleStandardWgt", java.math.BigDecimal.class, this.kdtEntrys, "femaleStandardWgt.text");
		dataBinder.registerBinding("Entrys.femaleTotalFeedCost", java.math.BigDecimal.class, this.kdtEntrys, "femaleTotalFeedCost.text");
		dataBinder.registerBinding("Entrys.allTotalFeedCost", java.math.BigDecimal.class, this.kdtEntrys, "allTotalFeedCost.text");
		dataBinder.registerBinding("Entrys.FemaleWgtMin", java.math.BigDecimal.class, this.kdtEntrys, "FemaleWgtMin.text");
		dataBinder.registerBinding("Entrys.FemaleWgtMax", java.math.BigDecimal.class, this.kdtEntrys, "FemaleWgtMax.text");
		dataBinder.registerBinding("Entrys.uniformRate", java.math.BigDecimal.class, this.kdtEntrys, "uniformRate.text");
		dataBinder.registerBinding("Entrys.totalFeedCost", java.math.BigDecimal.class, this.kdtEntrys, "totalFeedCost.text");
		dataBinder.registerBinding("Entrys.femaleLossWeight", java.math.BigDecimal.class, this.kdtEntrys, "femaleLossWeight.text");
		dataBinder.registerBinding("Entrys.femaleLossRate", java.math.BigDecimal.class, this.kdtEntrys, "femaleLossRate.text");
		dataBinder.registerBinding("Entrys.maleLossWeight", java.math.BigDecimal.class, this.kdtEntrys, "maleLossWeight.text");
		dataBinder.registerBinding("Entrys.maleLossRate", java.math.BigDecimal.class, this.kdtEntrys, "maleLossRate.text");
		dataBinder.registerBinding("LayEggEntrys.seq", int.class, this.kdtLayEggEntrys, "seq.text");
		dataBinder.registerBinding("LayEggEntrys", com.kingdee.eas.farm.stocking.basedata.BreedStandardLayEggEntryInfo.class, this.kdtLayEggEntrys, "userObject");
		dataBinder.registerBinding("LayEggEntrys.week", int.class, this.kdtLayEggEntrys, "week.text");
		dataBinder.registerBinding("LayEggEntrys.days", int.class, this.kdtLayEggEntrys, "days.text");
		dataBinder.registerBinding("LayEggEntrys.eggRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "eggRate.text");
		dataBinder.registerBinding("LayEggEntrys.upEggRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "upEggRate.text");
		dataBinder.registerBinding("LayEggEntrys.freakRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "freakRate.text");
		dataBinder.registerBinding("LayEggEntrys.doubleYolkRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "doubleYolkRate.text");
		dataBinder.registerBinding("LayEggEntrys.brokenRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "brokenRate.text");
		dataBinder.registerBinding("LayEggEntrys.endWeek", int.class, this.kdtLayEggEntrys, "endWeek.text");
		dataBinder.registerBinding("LayEggEntrys.endDays", int.class, this.kdtLayEggEntrys, "endDays.text");
		dataBinder.registerBinding("LayEggEntrys.innerPrice", java.math.BigDecimal.class, this.kdtLayEggEntrys, "innerPrice.text");
		dataBinder.registerBinding("LayEggEntrys.eggFertity", java.math.BigDecimal.class, this.kdtLayEggEntrys, "eggFertity.text");
		dataBinder.registerBinding("LayEggEntrys.fEggHatchability", java.math.BigDecimal.class, this.kdtLayEggEntrys, "fEggHatchability.text");
		dataBinder.registerBinding("LayEggEntrys.hatchability", java.math.BigDecimal.class, this.kdtLayEggEntrys, "hatchability.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseLayRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseLayRate.text");
		dataBinder.registerBinding("LayEggEntrys.livestockWeekLayEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "livestockWeekLayEggs.text");
		dataBinder.registerBinding("LayEggEntrys.livestockTotalLayEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "livestockTotalLayEggs.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseWeekLayEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseWeekLayEggs.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseTotalLayEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseTotalLayEggs.text");
		dataBinder.registerBinding("LayEggEntrys.livestockWeekQEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "livestockWeekQEggs.text");
		dataBinder.registerBinding("LayEggEntrys.livestockTotalQEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "livestockTotalQEggs.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseWeekQEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseWeekQEggs.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseTotalQEggs", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseTotalQEggs.text");
		dataBinder.registerBinding("LayEggEntrys.qEggWeekFeedCost", java.math.BigDecimal.class, this.kdtLayEggEntrys, "qEggWeekFeedCost.text");
		dataBinder.registerBinding("LayEggEntrys.qEggTotalFeedCost", java.math.BigDecimal.class, this.kdtLayEggEntrys, "qEggTotalFeedCost.text");
		dataBinder.registerBinding("LayEggEntrys.weekSaleableChicks", java.math.BigDecimal.class, this.kdtLayEggEntrys, "weekSaleableChicks.text");
		dataBinder.registerBinding("LayEggEntrys.totalSaleableChicks", java.math.BigDecimal.class, this.kdtLayEggEntrys, "totalSaleableChicks.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseWeekSChicks", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseWeekSChicks.text");
		dataBinder.registerBinding("LayEggEntrys.inHouseTotalSChicks", java.math.BigDecimal.class, this.kdtLayEggEntrys, "inHouseTotalSChicks.text");
		dataBinder.registerBinding("LayEggEntrys.zcUtilization", java.math.BigDecimal.class, this.kdtLayEggEntrys, "zcUtilization.text");
		dataBinder.registerBinding("LayEggEntrys.saleableChickHatchRate", java.math.BigDecimal.class, this.kdtLayEggEntrys, "saleableChickHatchRate.text");
		dataBinder.registerBinding("LayEggEntrys.averageEggWgt", java.math.BigDecimal.class, this.kdtLayEggEntrys, "averageEggWgt.text");
		dataBinder.registerBinding("DrugEntry.seq", int.class, this.kdtDrugEntry, "seq.text");
		dataBinder.registerBinding("DrugEntry", com.kingdee.eas.farm.stocking.basedata.BreedStandardDrugEntryInfo.class, this.kdtDrugEntry, "userObject");
		dataBinder.registerBinding("DrugEntry.week", int.class, this.kdtDrugEntry, "week.text");
		dataBinder.registerBinding("DrugEntry.days", int.class, this.kdtDrugEntry, "days.text");
		dataBinder.registerBinding("DrugEntry.material", java.lang.Object.class, this.kdtDrugEntry, "material.text");
		dataBinder.registerBinding("DrugEntry.materialName", String.class, this.kdtDrugEntry, "materialName.text");
		dataBinder.registerBinding("DrugEntry.model", String.class, this.kdtDrugEntry, "model.text");
		dataBinder.registerBinding("DrugEntry.unit", java.lang.Object.class, this.kdtDrugEntry, "unit.text");
		dataBinder.registerBinding("DrugEntry.qty", java.math.BigDecimal.class, this.kdtDrugEntry, "qty.text");
		dataBinder.registerBinding("DrugEntry.endWeek", int.class, this.kdtDrugEntry, "endWeek.text");
		dataBinder.registerBinding("DrugEntry.endDays", int.class, this.kdtDrugEntry, "endDays.text");
		dataBinder.registerBinding("DrugEntry.remark", String.class, this.kdtDrugEntry, "remark.text");
		dataBinder.registerBinding("DrugEntry.strain", String.class, this.kdtDrugEntry, "strain.text");
		dataBinder.registerBinding("DrugEntry.vaccineWay", java.lang.Object.class, this.kdtDrugEntry, "vaccineWay.text");
		dataBinder.registerBinding("DrugEntry.manufacturer", String.class, this.kdtDrugEntry, "manufacturer.text");
		dataBinder.registerBinding("DepcEntry.seq", int.class, this.kdtDepcEntry, "seq.text");
		dataBinder.registerBinding("DepcEntry", com.kingdee.eas.farm.stocking.basedata.BreedStandardDepcEntryInfo.class, this.kdtDepcEntry, "userObject");
		dataBinder.registerBinding("DepcEntry.week", int.class, this.kdtDepcEntry, "week.text");
		dataBinder.registerBinding("DepcEntry.depreciationRate", java.math.BigDecimal.class, this.kdtDepcEntry, "depreciationRate.text");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("limitBreedDays", int.class, this.txtlimitBreedDays, "value");
		dataBinder.registerBinding("breedData", com.kingdee.eas.farm.stocking.basedata.BreedDataInfo.class, this.prmtbreedData, "data");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");		
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
	    return "com.kingdee.eas.farm.stocking.basedata.app.BreedStandardEditUIHandler";
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
        this.prmtauditor.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo)ov;
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
		getValidateHelper().registerBindProperty("molting", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.henMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.henQtyPerday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.cockMaterial", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.cockQtyPerday", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.waterQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.breedTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.lightingTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.temperatureTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.temperatureFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.humidityFrom", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.humidityTo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.standardWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.dynamiting", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.dailyDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.endWeek", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.endDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleLivability", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleTotalWeekDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femalePerWeekDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.perWeekDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.totalWeekDCRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.livability", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleStandardWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleTotalFeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.allTotalFeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.FemaleWgtMin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.FemaleWgtMax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.uniformRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.totalFeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleLossWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.femaleLossRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.maleLossWeight", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entrys.maleLossRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.eggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.upEggRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.freakRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.doubleYolkRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.brokenRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.endWeek", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.endDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.innerPrice", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.eggFertity", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.fEggHatchability", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.hatchability", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseLayRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.livestockWeekLayEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.livestockTotalLayEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseWeekLayEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseTotalLayEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.livestockWeekQEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.livestockTotalQEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseWeekQEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseTotalQEggs", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.qEggWeekFeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.qEggTotalFeedCost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.weekSaleableChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.totalSaleableChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseWeekSChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.inHouseTotalSChicks", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.zcUtilization", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.saleableChickHatchRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("LayEggEntrys.averageEggWgt", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.days", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.material", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.materialName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.model", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.unit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.qty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.endWeek", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.endDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.remark", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.strain", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.vaccineWay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DrugEntry.manufacturer", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DepcEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DepcEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DepcEntry.week", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("DepcEntry.depreciationRate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("limitBreedDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("breedData", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("week".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntrys.getCell(rowIndex,"endWeek").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"endWeek").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtEntrys.getCell(rowIndex,"week").getValue()));
}

}

    if ("days".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntrys.getCell(rowIndex,"endDays").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"endDays").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtEntrys.getCell(rowIndex,"days").getValue()));
}

}

    if ("endWeek".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntrys.getCell(rowIndex,"week").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"week").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtEntrys.getCell(rowIndex,"endWeek").getValue()));
}

}

    if ("endDays".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtEntrys.getCell(rowIndex,"days").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"days").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtEntrys.getCell(rowIndex,"endDays").getValue()));
}

}

    if ("henMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(rowIndex,"cockMaterial").getValue())) 
{
    kdtEntrys.getCell(rowIndex,"cockMaterial").setValue(kdtEntrys.getCell(rowIndex,"henMaterial").getValue());
}

}

    if ("henQtyPerday".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"cockQtyPerday").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"cockQtyPerday").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"cockQtyPerday").getValue()));
}

}

    if ("cockMaterial".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtEntrys.getCell(rowIndex,"henMaterial").getValue())) 
{
    kdtEntrys.getCell(rowIndex,"henMaterial").setValue(kdtEntrys.getCell(rowIndex,"cockMaterial").getValue());
}

}

    if ("cockQtyPerday".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntrys.getCell(rowIndex,"cockQtyPerday").getValue())<= 0) 
{
    kdtEntrys.getCell(rowIndex,"cockQtyPerday").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"cockQtyPerday").getValue()));
}

}


    }

    /**
     * output kdtLayEggEntrys_Changed(int rowIndex,int colIndex) method
     */
    public void kdtLayEggEntrys_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("week".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"endWeek").getValue())<= 0) 
{
    kdtLayEggEntrys.getCell(rowIndex,"endWeek").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtLayEggEntrys.getCell(rowIndex,"week").getValue()));
}

}

    if ("days".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"endDays").getValue())<= 0) 
{
    kdtLayEggEntrys.getCell(rowIndex,"endDays").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtLayEggEntrys.getCell(rowIndex,"days").getValue()));
}

}

    if ("endWeek".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"week").getValue())<= 0) 
{
    kdtLayEggEntrys.getCell(rowIndex,"week").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtLayEggEntrys.getCell(rowIndex,"endWeek").getValue()));
}

}

    if ("endDays".equalsIgnoreCase(kdtLayEggEntrys.getColumn(colIndex).getKey())) {
if (com.kingdee.bos.ui.face.UIRuleUtil.getIntValue(kdtLayEggEntrys.getCell(rowIndex,"days").getValue())<= 0) 
{
    kdtLayEggEntrys.getCell(rowIndex,"days").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getInt(kdtLayEggEntrys.getCell(rowIndex,"endDays").getValue()));
}

}


    }

    /**
     * output kdtDrugEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtDrugEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("material".equalsIgnoreCase(kdtDrugEntry.getColumn(colIndex).getKey())) {
kdtDrugEntry.getCell(rowIndex,"materialName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntry.getCell(rowIndex,"material").getValue(),"name")));

}

    if ("material".equalsIgnoreCase(kdtDrugEntry.getColumn(colIndex).getKey())) {
kdtDrugEntry.getCell(rowIndex,"model").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntry.getCell(rowIndex,"material").getValue(),"model")));

}

    if ("material".equalsIgnoreCase(kdtDrugEntry.getColumn(colIndex).getKey())) {
kdtDrugEntry.getCell(rowIndex,"unit").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtDrugEntry.getCell(rowIndex,"material").getValue(),"baseUnit"));

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
        sic.add(new SelectorItemInfo("molting"));
        sic.add(new SelectorItemInfo("number"));
        sic.add(new SelectorItemInfo("name"));
        sic.add(new SelectorItemInfo("simpleName"));
        sic.add(new SelectorItemInfo("description"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("creator.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("creator.id"));
        	sic.add(new SelectorItemInfo("creator.number"));
        	sic.add(new SelectorItemInfo("creator.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("lastUpdateUser.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("lastUpdateUser.id"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.number"));
        	sic.add(new SelectorItemInfo("lastUpdateUser.name"));
		}
        sic.add(new SelectorItemInfo("createTime"));
        sic.add(new SelectorItemInfo("lastUpdateTime"));
    	sic.add(new SelectorItemInfo("Entrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("Entrys.week"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.henMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.henMaterial.id"));
			sic.add(new SelectorItemInfo("Entrys.henMaterial.name"));
        	sic.add(new SelectorItemInfo("Entrys.henMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.henQtyPerday"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entrys.cockMaterial.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entrys.cockMaterial.id"));
			sic.add(new SelectorItemInfo("Entrys.cockMaterial.name"));
        	sic.add(new SelectorItemInfo("Entrys.cockMaterial.number"));
		}
    	sic.add(new SelectorItemInfo("Entrys.cockQtyPerday"));
    	sic.add(new SelectorItemInfo("Entrys.waterQty"));
    	sic.add(new SelectorItemInfo("Entrys.breedTime"));
    	sic.add(new SelectorItemInfo("Entrys.lightingTime"));
    	sic.add(new SelectorItemInfo("Entrys.temperatureTo"));
    	sic.add(new SelectorItemInfo("Entrys.temperatureFrom"));
    	sic.add(new SelectorItemInfo("Entrys.humidityFrom"));
    	sic.add(new SelectorItemInfo("Entrys.humidityTo"));
    	sic.add(new SelectorItemInfo("Entrys.days"));
    	sic.add(new SelectorItemInfo("Entrys.standardWeight"));
    	sic.add(new SelectorItemInfo("Entrys.dynamiting"));
    	sic.add(new SelectorItemInfo("Entrys.dailyDCRate"));
    	sic.add(new SelectorItemInfo("Entrys.endWeek"));
    	sic.add(new SelectorItemInfo("Entrys.endDays"));
    	sic.add(new SelectorItemInfo("Entrys.femaleLivability"));
    	sic.add(new SelectorItemInfo("Entrys.femaleTotalWeekDCRate"));
    	sic.add(new SelectorItemInfo("Entrys.femalePerWeekDCRate"));
    	sic.add(new SelectorItemInfo("Entrys.perWeekDCRate"));
    	sic.add(new SelectorItemInfo("Entrys.totalWeekDCRate"));
    	sic.add(new SelectorItemInfo("Entrys.livability"));
    	sic.add(new SelectorItemInfo("Entrys.femaleStandardWgt"));
    	sic.add(new SelectorItemInfo("Entrys.femaleTotalFeedCost"));
    	sic.add(new SelectorItemInfo("Entrys.allTotalFeedCost"));
    	sic.add(new SelectorItemInfo("Entrys.FemaleWgtMin"));
    	sic.add(new SelectorItemInfo("Entrys.FemaleWgtMax"));
    	sic.add(new SelectorItemInfo("Entrys.uniformRate"));
    	sic.add(new SelectorItemInfo("Entrys.totalFeedCost"));
    	sic.add(new SelectorItemInfo("Entrys.femaleLossWeight"));
    	sic.add(new SelectorItemInfo("Entrys.femaleLossRate"));
    	sic.add(new SelectorItemInfo("Entrys.maleLossWeight"));
    	sic.add(new SelectorItemInfo("Entrys.maleLossRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("LayEggEntrys.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("LayEggEntrys.week"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.days"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.eggRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.upEggRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.freakRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.doubleYolkRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.brokenRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.endWeek"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.endDays"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.innerPrice"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.eggFertity"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.fEggHatchability"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.hatchability"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseLayRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.livestockWeekLayEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.livestockTotalLayEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseWeekLayEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseTotalLayEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.livestockWeekQEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.livestockTotalQEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseWeekQEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseTotalQEggs"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.qEggWeekFeedCost"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.qEggTotalFeedCost"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.weekSaleableChicks"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.totalSaleableChicks"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseWeekSChicks"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.inHouseTotalSChicks"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.zcUtilization"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.saleableChickHatchRate"));
    	sic.add(new SelectorItemInfo("LayEggEntrys.averageEggWgt"));
    	sic.add(new SelectorItemInfo("DrugEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DrugEntry.week"));
    	sic.add(new SelectorItemInfo("DrugEntry.days"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntry.material.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntry.material.id"));
			sic.add(new SelectorItemInfo("DrugEntry.material.number"));
			sic.add(new SelectorItemInfo("DrugEntry.material.name"));
		}
    	sic.add(new SelectorItemInfo("DrugEntry.materialName"));
    	sic.add(new SelectorItemInfo("DrugEntry.model"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntry.unit.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntry.unit.id"));
			sic.add(new SelectorItemInfo("DrugEntry.unit.name"));
        	sic.add(new SelectorItemInfo("DrugEntry.unit.number"));
		}
    	sic.add(new SelectorItemInfo("DrugEntry.qty"));
    	sic.add(new SelectorItemInfo("DrugEntry.endWeek"));
    	sic.add(new SelectorItemInfo("DrugEntry.endDays"));
    	sic.add(new SelectorItemInfo("DrugEntry.remark"));
    	sic.add(new SelectorItemInfo("DrugEntry.strain"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DrugEntry.vaccineWay.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("DrugEntry.vaccineWay.id"));
			sic.add(new SelectorItemInfo("DrugEntry.vaccineWay.name"));
        	sic.add(new SelectorItemInfo("DrugEntry.vaccineWay.number"));
		}
    	sic.add(new SelectorItemInfo("DrugEntry.manufacturer"));
    	sic.add(new SelectorItemInfo("DepcEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("DepcEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("DepcEntry.week"));
    	sic.add(new SelectorItemInfo("DepcEntry.depreciationRate"));
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
        sic.add(new SelectorItemInfo("limitBreedDays"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("breedData.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("breedData.id"));
        	sic.add(new SelectorItemInfo("breedData.number"));
        	sic.add(new SelectorItemInfo("breedData.name"));
		}
        sic.add(new SelectorItemInfo("baseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory.getRemoteInstance().unAudit(editData);
    }
	public RequestContext prepareActionAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionAudit() {
    	return false;
    }
	public RequestContext prepareActionUnAudit(IItemAction itemAction) throws Exception {
			RequestContext request = new RequestContext();		
		if (request != null) {
    		request.setClassName(getUIHandlerClassName());
		}
		return request;
    }
	
	public boolean isPrepareActionUnAudit() {
    	return false;
    }

    /**
     * output ActionAudit class
     */     
    protected class ActionAudit extends ItemAction {     
    
        public ActionAudit()
        {
            this(null);
        }

        public ActionAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBreedStandardEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
        }
    }

    /**
     * output ActionUnAudit class
     */     
    protected class ActionUnAudit extends ItemAction {     
    
        public ActionUnAudit()
        {
            this(null);
        }

        public ActionUnAudit(IUIObject uiObject)
        {     
		super(uiObject);     
        
            String _tempStr = null;
            _tempStr = resHelper.getString("ActionUnAudit.SHORT_DESCRIPTION");
            this.putValue(ItemAction.SHORT_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.LONG_DESCRIPTION");
            this.putValue(ItemAction.LONG_DESCRIPTION, _tempStr);
            _tempStr = resHelper.getString("ActionUnAudit.NAME");
            this.putValue(ItemAction.NAME, _tempStr);
        }

        public void actionPerformed(ActionEvent e)
        {
        	getUIContext().put("ORG.PK", getOrgPK(this));
            innerActionPerformed("eas", AbstractBreedStandardEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.farm.stocking.basedata.client", "BreedStandardEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.BreedStandardEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedStandardFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		for (int i=0,n=kdtDrugEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtDrugEntry.getCell(i,"material").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"药品编码"});
			}
		}
		for (int i=0,n=kdtDrugEntry.getRowCount();i<n;i++) {
			if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(kdtDrugEntry.getCell(i,"unit").getValue())) {
				throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"单位"});
			}
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtbreedData.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"品种"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"财务组织"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntrys;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(1));
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}