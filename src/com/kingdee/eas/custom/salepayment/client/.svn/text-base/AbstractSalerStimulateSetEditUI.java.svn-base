/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

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
public abstract class AbstractSalerStimulateSetEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractSalerStimulateSetEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contsaler;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contindexType;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contprofitTarget;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contbaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contyear;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contquarter;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditor;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contauditTime;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer5;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer6;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer7;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer8;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompanyTargetInfo;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contareaTargetInfo;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtsaler;
    protected com.kingdee.bos.ctrl.swing.KDComboBox indexType;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtprofitTarget;
    protected com.kingdee.bos.ctrl.swing.KDComboBox baseStatus;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtStimulateEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtStimulateEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtyear;
    protected com.kingdee.bos.ctrl.swing.KDComboBox quarter;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtauditor;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker pkauditTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtCreator;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateCreateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtLastUpdateUser;
    protected com.kingdee.bos.ctrl.swing.KDDatePicker kDDateLastUpdateTime;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompanyTargetInfo;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtareaTargetInfo;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnAudit;
    protected com.kingdee.bos.ctrl.swing.KDWorkButton btnUnAudit;
    protected com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo editData = null;
    protected ActionAudit actionAudit = null;
    protected ActionUnAudit actionUnAudit = null;
    /**
     * output class constructor
     */
    public AbstractSalerStimulateSetEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractSalerStimulateSetEditUI.class.getName());
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
        this.contsaler = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contindexType = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contprofitTarget = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contbaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contyear = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contquarter = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditor = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contauditTime = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer5 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer6 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer7 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer8 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contcompanyTargetInfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contareaTargetInfo = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.prmtsaler = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.indexType = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.txtprofitTarget = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.baseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtStimulateEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.txtyear = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.quarter = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtauditor = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.pkauditTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtCreator = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateCreateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtLastUpdateUser = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDDateLastUpdateTime = new com.kingdee.bos.ctrl.swing.KDDatePicker();
        this.prmtcompanyTargetInfo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.prmtareaTargetInfo = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.btnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.btnUnAudit = new com.kingdee.bos.ctrl.swing.KDWorkButton();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.contsaler.setName("contsaler");
        this.contindexType.setName("contindexType");
        this.contprofitTarget.setName("contprofitTarget");
        this.contbaseStatus.setName("contbaseStatus");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contyear.setName("contyear");
        this.contquarter.setName("contquarter");
        this.contcompany.setName("contcompany");
        this.contauditor.setName("contauditor");
        this.contauditTime.setName("contauditTime");
        this.kDLabelContainer5.setName("kDLabelContainer5");
        this.kDLabelContainer6.setName("kDLabelContainer6");
        this.kDLabelContainer7.setName("kDLabelContainer7");
        this.kDLabelContainer8.setName("kDLabelContainer8");
        this.contcompanyTargetInfo.setName("contcompanyTargetInfo");
        this.contareaTargetInfo.setName("contareaTargetInfo");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.prmtsaler.setName("prmtsaler");
        this.indexType.setName("indexType");
        this.txtprofitTarget.setName("txtprofitTarget");
        this.baseStatus.setName("baseStatus");
        this.kDPanel1.setName("kDPanel1");
        this.kdtStimulateEntry.setName("kdtStimulateEntry");
        this.txtyear.setName("txtyear");
        this.quarter.setName("quarter");
        this.prmtcompany.setName("prmtcompany");
        this.prmtauditor.setName("prmtauditor");
        this.pkauditTime.setName("pkauditTime");
        this.prmtCreator.setName("prmtCreator");
        this.kDDateCreateTime.setName("kDDateCreateTime");
        this.prmtLastUpdateUser.setName("prmtLastUpdateUser");
        this.kDDateLastUpdateTime.setName("kDDateLastUpdateTime");
        this.prmtcompanyTargetInfo.setName("prmtcompanyTargetInfo");
        this.prmtareaTargetInfo.setName("prmtareaTargetInfo");
        this.btnAudit.setName("btnAudit");
        this.btnUnAudit.setName("btnUnAudit");
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
        // contsaler		
        this.contsaler.setBoundLabelText(resHelper.getString("contsaler.boundLabelText"));		
        this.contsaler.setBoundLabelLength(100);		
        this.contsaler.setBoundLabelUnderline(true);		
        this.contsaler.setVisible(true);
        // contindexType		
        this.contindexType.setBoundLabelText(resHelper.getString("contindexType.boundLabelText"));		
        this.contindexType.setBoundLabelLength(100);		
        this.contindexType.setBoundLabelUnderline(true);		
        this.contindexType.setVisible(true);
        // contprofitTarget		
        this.contprofitTarget.setBoundLabelText(resHelper.getString("contprofitTarget.boundLabelText"));		
        this.contprofitTarget.setBoundLabelLength(100);		
        this.contprofitTarget.setBoundLabelUnderline(true);		
        this.contprofitTarget.setVisible(true);
        // contbaseStatus		
        this.contbaseStatus.setBoundLabelText(resHelper.getString("contbaseStatus.boundLabelText"));		
        this.contbaseStatus.setBoundLabelLength(100);		
        this.contbaseStatus.setBoundLabelUnderline(true);		
        this.contbaseStatus.setVisible(true);
        // kDTabbedPane1
        // contyear		
        this.contyear.setBoundLabelText(resHelper.getString("contyear.boundLabelText"));		
        this.contyear.setBoundLabelLength(100);		
        this.contyear.setBoundLabelUnderline(true);		
        this.contyear.setVisible(true);
        // contquarter		
        this.contquarter.setBoundLabelText(resHelper.getString("contquarter.boundLabelText"));		
        this.contquarter.setBoundLabelLength(100);		
        this.contquarter.setBoundLabelUnderline(true);		
        this.contquarter.setVisible(true);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
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
        // kDLabelContainer5		
        this.kDLabelContainer5.setBoundLabelText(resHelper.getString("kDLabelContainer5.boundLabelText"));		
        this.kDLabelContainer5.setBoundLabelUnderline(true);		
        this.kDLabelContainer5.setBoundLabelLength(100);
        // kDLabelContainer6		
        this.kDLabelContainer6.setBoundLabelText(resHelper.getString("kDLabelContainer6.boundLabelText"));		
        this.kDLabelContainer6.setBoundLabelUnderline(true);		
        this.kDLabelContainer6.setBoundLabelLength(100);
        // kDLabelContainer7		
        this.kDLabelContainer7.setBoundLabelText(resHelper.getString("kDLabelContainer7.boundLabelText"));		
        this.kDLabelContainer7.setBoundLabelUnderline(true);		
        this.kDLabelContainer7.setBoundLabelLength(100);
        // kDLabelContainer8		
        this.kDLabelContainer8.setBoundLabelText(resHelper.getString("kDLabelContainer8.boundLabelText"));		
        this.kDLabelContainer8.setBoundLabelUnderline(true);		
        this.kDLabelContainer8.setBoundLabelLength(100);
        // contcompanyTargetInfo		
        this.contcompanyTargetInfo.setBoundLabelText(resHelper.getString("contcompanyTargetInfo.boundLabelText"));		
        this.contcompanyTargetInfo.setBoundLabelLength(100);		
        this.contcompanyTargetInfo.setBoundLabelUnderline(true);		
        this.contcompanyTargetInfo.setVisible(true);
        // contareaTargetInfo		
        this.contareaTargetInfo.setBoundLabelText(resHelper.getString("contareaTargetInfo.boundLabelText"));		
        this.contareaTargetInfo.setBoundLabelLength(100);		
        this.contareaTargetInfo.setBoundLabelUnderline(true);		
        this.contareaTargetInfo.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // prmtsaler		
        this.prmtsaler.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");		
        this.prmtsaler.setEditable(true);		
        this.prmtsaler.setDisplayFormat("$name$");		
        this.prmtsaler.setEditFormat("$number$");		
        this.prmtsaler.setCommitFormat("$number$");		
        this.prmtsaler.setRequired(true);
        // indexType		
        this.indexType.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.IndexType").toArray());		
        this.indexType.setRequired(true);
        // txtprofitTarget		
        this.txtprofitTarget.setHorizontalAlignment(2);		
        this.txtprofitTarget.setDataType(0);		
        this.txtprofitTarget.setSupportedEmpty(true);		
        this.txtprofitTarget.setRequired(true);
        // baseStatus		
        this.baseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.scm.common.BillBaseStatusEnum").toArray());		
        this.baseStatus.setRequired(false);		
        this.baseStatus.setEnabled(false);
        // kDPanel1
        // kdtStimulateEntry
		String kdtStimulateEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol1\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol3\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol4\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"stimulateBegin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol1\" /><t:Column t:key=\"profitBegin\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"stimulateEnd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"profitEnd\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol4\" /><t:Column t:key=\"stimulate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"payPercent\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{stimulateBegin}</t:Cell><t:Cell>$Resource{profitBegin}</t:Cell><t:Cell>$Resource{stimulateEnd}</t:Cell><t:Cell>$Resource{profitEnd}</t:Cell><t:Cell>$Resource{stimulate}</t:Cell><t:Cell>$Resource{payPercent}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtStimulateEntry.setFormatXml(resHelper.translateString("kdtStimulateEntry",kdtStimulateEntryStrXML));

                this.kdtStimulateEntry.putBindContents("editData",new String[] {"seq","stimulateBegin","profitBegin","stimulateEnd","profitEnd","stimulate","payPercent"});


        this.kdtStimulateEntry.checkParsed();
        KDFormattedTextField kdtStimulateEntry_stimulateBegin_TextField = new KDFormattedTextField();
        kdtStimulateEntry_stimulateBegin_TextField.setName("kdtStimulateEntry_stimulateBegin_TextField");
        kdtStimulateEntry_stimulateBegin_TextField.setVisible(true);
        kdtStimulateEntry_stimulateBegin_TextField.setEditable(true);
        kdtStimulateEntry_stimulateBegin_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_stimulateBegin_TextField.setDataType(1);
        	kdtStimulateEntry_stimulateBegin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_stimulateBegin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_stimulateBegin_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_stimulateBegin_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_stimulateBegin_TextField);
        this.kdtStimulateEntry.getColumn("stimulateBegin").setEditor(kdtStimulateEntry_stimulateBegin_CellEditor);
        KDFormattedTextField kdtStimulateEntry_profitBegin_TextField = new KDFormattedTextField();
        kdtStimulateEntry_profitBegin_TextField.setName("kdtStimulateEntry_profitBegin_TextField");
        kdtStimulateEntry_profitBegin_TextField.setVisible(true);
        kdtStimulateEntry_profitBegin_TextField.setEditable(true);
        kdtStimulateEntry_profitBegin_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_profitBegin_TextField.setDataType(1);
        	kdtStimulateEntry_profitBegin_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_profitBegin_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_profitBegin_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_profitBegin_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_profitBegin_TextField);
        this.kdtStimulateEntry.getColumn("profitBegin").setEditor(kdtStimulateEntry_profitBegin_CellEditor);
        KDFormattedTextField kdtStimulateEntry_stimulateEnd_TextField = new KDFormattedTextField();
        kdtStimulateEntry_stimulateEnd_TextField.setName("kdtStimulateEntry_stimulateEnd_TextField");
        kdtStimulateEntry_stimulateEnd_TextField.setVisible(true);
        kdtStimulateEntry_stimulateEnd_TextField.setEditable(true);
        kdtStimulateEntry_stimulateEnd_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_stimulateEnd_TextField.setDataType(1);
        	kdtStimulateEntry_stimulateEnd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_stimulateEnd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_stimulateEnd_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_stimulateEnd_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_stimulateEnd_TextField);
        this.kdtStimulateEntry.getColumn("stimulateEnd").setEditor(kdtStimulateEntry_stimulateEnd_CellEditor);
        KDFormattedTextField kdtStimulateEntry_profitEnd_TextField = new KDFormattedTextField();
        kdtStimulateEntry_profitEnd_TextField.setName("kdtStimulateEntry_profitEnd_TextField");
        kdtStimulateEntry_profitEnd_TextField.setVisible(true);
        kdtStimulateEntry_profitEnd_TextField.setEditable(true);
        kdtStimulateEntry_profitEnd_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_profitEnd_TextField.setDataType(1);
        	kdtStimulateEntry_profitEnd_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_profitEnd_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_profitEnd_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_profitEnd_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_profitEnd_TextField);
        this.kdtStimulateEntry.getColumn("profitEnd").setEditor(kdtStimulateEntry_profitEnd_CellEditor);
        KDFormattedTextField kdtStimulateEntry_stimulate_TextField = new KDFormattedTextField();
        kdtStimulateEntry_stimulate_TextField.setName("kdtStimulateEntry_stimulate_TextField");
        kdtStimulateEntry_stimulate_TextField.setVisible(true);
        kdtStimulateEntry_stimulate_TextField.setEditable(true);
        kdtStimulateEntry_stimulate_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_stimulate_TextField.setDataType(1);
        	kdtStimulateEntry_stimulate_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_stimulate_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_stimulate_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_stimulate_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_stimulate_TextField);
        this.kdtStimulateEntry.getColumn("stimulate").setEditor(kdtStimulateEntry_stimulate_CellEditor);
        KDFormattedTextField kdtStimulateEntry_payPercent_TextField = new KDFormattedTextField();
        kdtStimulateEntry_payPercent_TextField.setName("kdtStimulateEntry_payPercent_TextField");
        kdtStimulateEntry_payPercent_TextField.setVisible(true);
        kdtStimulateEntry_payPercent_TextField.setEditable(true);
        kdtStimulateEntry_payPercent_TextField.setHorizontalAlignment(2);
        kdtStimulateEntry_payPercent_TextField.setDataType(1);
        	kdtStimulateEntry_payPercent_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E26"));
        	kdtStimulateEntry_payPercent_TextField.setMaximumValue(new java.math.BigDecimal("1.0E26"));
        kdtStimulateEntry_payPercent_TextField.setPrecision(2);
        KDTDefaultCellEditor kdtStimulateEntry_payPercent_CellEditor = new KDTDefaultCellEditor(kdtStimulateEntry_payPercent_TextField);
        this.kdtStimulateEntry.getColumn("payPercent").setEditor(kdtStimulateEntry_payPercent_CellEditor);
        // txtyear		
        this.txtyear.setHorizontalAlignment(2);		
        this.txtyear.setDataType(0);		
        this.txtyear.setSupportedEmpty(true);		
        this.txtyear.setRequired(true);
        // quarter		
        this.quarter.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.salepayment.Quarter").toArray());		
        this.quarter.setRequired(true);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(false);
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
        // prmtCreator		
        this.prmtCreator.setEnabled(false);
        // kDDateCreateTime		
        this.kDDateCreateTime.setEnabled(false);
        // prmtLastUpdateUser		
        this.prmtLastUpdateUser.setEnabled(false);
        // kDDateLastUpdateTime		
        this.kDDateLastUpdateTime.setEnabled(false);
        // prmtcompanyTargetInfo		
        this.prmtcompanyTargetInfo.setQueryInfo("com.kingdee.eas.custom.salepayment.app.CompanyTargetQuery");		
        this.prmtcompanyTargetInfo.setVisible(true);		
        this.prmtcompanyTargetInfo.setEditable(true);		
        this.prmtcompanyTargetInfo.setDisplayFormat("$number$");		
        this.prmtcompanyTargetInfo.setEditFormat("$number$");		
        this.prmtcompanyTargetInfo.setCommitFormat("$number$");		
        this.prmtcompanyTargetInfo.setRequired(true);
        		prmtcompanyTargetInfo.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI prmtcompanyTargetInfo_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtcompanyTargetInfo_F7ListUI == null) {
					try {
						prmtcompanyTargetInfo_F7ListUI = new com.kingdee.eas.custom.salepayment.client.CompanyTargetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtcompanyTargetInfo_F7ListUI));
					prmtcompanyTargetInfo_F7ListUI.setF7Use(true,ctx);
					prmtcompanyTargetInfo.setSelector(prmtcompanyTargetInfo_F7ListUI);
				}
			}
		});
					
        // prmtareaTargetInfo		
        this.prmtareaTargetInfo.setQueryInfo("com.kingdee.eas.custom.salepayment.app.AreaTargetQuery");		
        this.prmtareaTargetInfo.setVisible(true);		
        this.prmtareaTargetInfo.setEditable(true);		
        this.prmtareaTargetInfo.setDisplayFormat("$number$");		
        this.prmtareaTargetInfo.setEditFormat("$number$");		
        this.prmtareaTargetInfo.setCommitFormat("$number$");		
        this.prmtareaTargetInfo.setRequired(true);
        		prmtareaTargetInfo.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.salepayment.client.AreaTargetListUI prmtareaTargetInfo_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtareaTargetInfo_F7ListUI == null) {
					try {
						prmtareaTargetInfo_F7ListUI = new com.kingdee.eas.custom.salepayment.client.AreaTargetListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtareaTargetInfo_F7ListUI));
					prmtareaTargetInfo_F7ListUI.setF7Use(true,ctx);
					prmtareaTargetInfo.setSelector(prmtareaTargetInfo_F7ListUI);
				}
			}
		});
					
        // btnAudit
        this.btnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnAudit.setText(resHelper.getString("btnAudit.text"));
        // btnUnAudit
        this.btnUnAudit.setAction((IItemAction)ActionProxyFactory.getProxy(actionUnAudit, new Class[] { IItemAction.class }, getServiceContext()));		
        this.btnUnAudit.setText(resHelper.getString("btnUnAudit.text"));
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {prmtCreator,kDDateCreateTime,prmtLastUpdateUser,kDDateLastUpdateTime,prmtsaler,indexType,txtprofitTarget,baseStatus,txtyear,quarter,txtSimpleName,txtDescription,txtNumber,txtName,prmtcompany,kdtStimulateEntry,prmtauditor,pkauditTime,prmtcompanyTargetInfo,prmtareaTargetInfo}));
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
        kDLabelContainer1.setBounds(new Rectangle(40, 13, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(40, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(380, 13, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(380, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(102, -81, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(102, -81, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(102, -81, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(102, -81, 270, 19, 0));
        contsaler.setBounds(new Rectangle(40, 65, 270, 19));
        this.add(contsaler, new KDLayout.Constraints(40, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contindexType.setBounds(new Rectangle(40, 39, 270, 19));
        this.add(contindexType, new KDLayout.Constraints(40, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contprofitTarget.setBounds(new Rectangle(380, 65, 270, 19));
        this.add(contprofitTarget, new KDLayout.Constraints(380, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbaseStatus.setBounds(new Rectangle(721, 65, 270, 19));
        this.add(contbaseStatus, new KDLayout.Constraints(721, 65, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(11, 126, 994, 438));
        this.add(kDTabbedPane1, new KDLayout.Constraints(11, 126, 994, 438, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contyear.setBounds(new Rectangle(380, 39, 270, 19));
        this.add(contyear, new KDLayout.Constraints(380, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contquarter.setBounds(new Rectangle(721, 39, 270, 19));
        this.add(contquarter, new KDLayout.Constraints(721, 39, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(721, 13, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(721, 13, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contauditor.setBounds(new Rectangle(27, 574, 270, 19));
        this.add(contauditor, new KDLayout.Constraints(27, 574, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(27, 599, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(27, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer5.setBounds(new Rectangle(380, 574, 270, 19));
        this.add(kDLabelContainer5, new KDLayout.Constraints(380, 574, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer6.setBounds(new Rectangle(380, 599, 270, 19));
        this.add(kDLabelContainer6, new KDLayout.Constraints(380, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer7.setBounds(new Rectangle(733, 574, 270, 19));
        this.add(kDLabelContainer7, new KDLayout.Constraints(733, 574, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDLabelContainer8.setBounds(new Rectangle(733, 599, 270, 19));
        this.add(kDLabelContainer8, new KDLayout.Constraints(733, 599, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompanyTargetInfo.setBounds(new Rectangle(40, 91, 270, 19));
        this.add(contcompanyTargetInfo, new KDLayout.Constraints(40, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contareaTargetInfo.setBounds(new Rectangle(380, 91, 270, 19));
        this.add(contareaTargetInfo, new KDLayout.Constraints(380, 91, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //contsaler
        contsaler.setBoundEditor(prmtsaler);
        //contindexType
        contindexType.setBoundEditor(indexType);
        //contprofitTarget
        contprofitTarget.setBoundEditor(txtprofitTarget);
        //contbaseStatus
        contbaseStatus.setBoundEditor(baseStatus);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 993, 405));        kdtStimulateEntry.setBounds(new Rectangle(0, 0, 968, 403));
        kdtStimulateEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtStimulateEntry,new com.kingdee.eas.custom.salepayment.SalerStimulateSetStimulateEntryInfo(),null,false);
        kDPanel1.add(kdtStimulateEntry_detailPanel, new KDLayout.Constraints(0, 0, 968, 403, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        //contyear
        contyear.setBoundEditor(txtyear);
        //contquarter
        contquarter.setBoundEditor(quarter);
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contauditor
        contauditor.setBoundEditor(prmtauditor);
        //contauditTime
        contauditTime.setBoundEditor(pkauditTime);
        //kDLabelContainer5
        kDLabelContainer5.setBoundEditor(prmtCreator);
        //kDLabelContainer6
        kDLabelContainer6.setBoundEditor(kDDateCreateTime);
        //kDLabelContainer7
        kDLabelContainer7.setBoundEditor(prmtLastUpdateUser);
        //kDLabelContainer8
        kDLabelContainer8.setBoundEditor(kDDateLastUpdateTime);
        //contcompanyTargetInfo
        contcompanyTargetInfo.setBoundEditor(prmtcompanyTargetInfo);
        //contareaTargetInfo
        contareaTargetInfo.setBoundEditor(prmtareaTargetInfo);

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
        this.toolBar.add(btnAudit);
        this.toolBar.add(btnUnAudit);
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
		dataBinder.registerBinding("saler", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtsaler, "data");
		dataBinder.registerBinding("indexType", com.kingdee.eas.custom.salepayment.IndexType.class, this.indexType, "selectedItem");
		dataBinder.registerBinding("profitTarget", int.class, this.txtprofitTarget, "value");
		dataBinder.registerBinding("baseStatus", com.kingdee.eas.scm.common.BillBaseStatusEnum.class, this.baseStatus, "selectedItem");
		dataBinder.registerBinding("StimulateEntry.seq", int.class, this.kdtStimulateEntry, "seq.text");
		dataBinder.registerBinding("StimulateEntry", com.kingdee.eas.custom.salepayment.SalerStimulateSetStimulateEntryInfo.class, this.kdtStimulateEntry, "userObject");
		dataBinder.registerBinding("StimulateEntry.stimulateBegin", java.math.BigDecimal.class, this.kdtStimulateEntry, "stimulateBegin.text");
		dataBinder.registerBinding("StimulateEntry.profitBegin", java.math.BigDecimal.class, this.kdtStimulateEntry, "profitBegin.text");
		dataBinder.registerBinding("StimulateEntry.stimulateEnd", java.math.BigDecimal.class, this.kdtStimulateEntry, "stimulateEnd.text");
		dataBinder.registerBinding("StimulateEntry.profitEnd", java.math.BigDecimal.class, this.kdtStimulateEntry, "profitEnd.text");
		dataBinder.registerBinding("StimulateEntry.stimulate", java.math.BigDecimal.class, this.kdtStimulateEntry, "stimulate.text");
		dataBinder.registerBinding("StimulateEntry.payPercent", java.math.BigDecimal.class, this.kdtStimulateEntry, "payPercent.text");
		dataBinder.registerBinding("year", int.class, this.txtyear, "value");
		dataBinder.registerBinding("quarter", com.kingdee.eas.custom.salepayment.Quarter.class, this.quarter, "selectedItem");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("auditor", com.kingdee.eas.base.permission.UserInfo.class, this.prmtauditor, "data");
		dataBinder.registerBinding("auditTime", java.util.Date.class, this.pkauditTime, "value");
		dataBinder.registerBinding("creator", com.kingdee.eas.base.permission.UserInfo.class, this.prmtCreator, "data");
		dataBinder.registerBinding("createTime", java.sql.Timestamp.class, this.kDDateCreateTime, "value");
		dataBinder.registerBinding("lastUpdateUser", com.kingdee.eas.base.permission.UserInfo.class, this.prmtLastUpdateUser, "data");
		dataBinder.registerBinding("lastUpdateTime", java.sql.Timestamp.class, this.kDDateLastUpdateTime, "value");
		dataBinder.registerBinding("companyTargetInfo", com.kingdee.eas.custom.salepayment.CompanyTargetInfo.class, this.prmtcompanyTargetInfo, "data");
		dataBinder.registerBinding("areaTargetInfo", com.kingdee.eas.custom.salepayment.AreaTargetInfo.class, this.prmtareaTargetInfo, "data");		
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
	    return "com.kingdee.eas.custom.salepayment.app.SalerStimulateSetEditUIHandler";
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
        this.prmtCreator.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo)ov;
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
		getValidateHelper().registerBindProperty("saler", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("indexType", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("profitTarget", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("baseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.stimulateBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.profitBegin", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.stimulateEnd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.profitEnd", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.stimulate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("StimulateEntry.payPercent", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("year", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("quarter", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditor", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("auditTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("creator", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("createTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateUser", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("lastUpdateTime", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("companyTargetInfo", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("areaTargetInfo", ValidateHelper.ON_SAVE);    		
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
			sic.add(new SelectorItemInfo("saler.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("saler.id"));
        	sic.add(new SelectorItemInfo("saler.number"));
        	sic.add(new SelectorItemInfo("saler.name"));
		}
        sic.add(new SelectorItemInfo("indexType"));
        sic.add(new SelectorItemInfo("profitTarget"));
        sic.add(new SelectorItemInfo("baseStatus"));
    	sic.add(new SelectorItemInfo("StimulateEntry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("StimulateEntry.*"));
		}
		else{
		}
    	sic.add(new SelectorItemInfo("StimulateEntry.stimulateBegin"));
    	sic.add(new SelectorItemInfo("StimulateEntry.profitBegin"));
    	sic.add(new SelectorItemInfo("StimulateEntry.stimulateEnd"));
    	sic.add(new SelectorItemInfo("StimulateEntry.profitEnd"));
    	sic.add(new SelectorItemInfo("StimulateEntry.stimulate"));
    	sic.add(new SelectorItemInfo("StimulateEntry.payPercent"));
        sic.add(new SelectorItemInfo("year"));
        sic.add(new SelectorItemInfo("quarter"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
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
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("companyTargetInfo.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("companyTargetInfo.id"));
        	sic.add(new SelectorItemInfo("companyTargetInfo.number"));
        	sic.add(new SelectorItemInfo("companyTargetInfo.name"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("areaTargetInfo.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("areaTargetInfo.id"));
        	sic.add(new SelectorItemInfo("areaTargetInfo.number"));
        	sic.add(new SelectorItemInfo("areaTargetInfo.name"));
		}
        return sic;
    }        
    	

    /**
     * output actionAudit_actionPerformed method
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory.getRemoteInstance().audit(editData);
    }
    	

    /**
     * output actionUnAudit_actionPerformed method
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
        com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory.getRemoteInstance().unAudit(editData);
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
            innerActionPerformed("eas", AbstractSalerStimulateSetEditUI.this, "ActionAudit", "actionAudit_actionPerformed", e);
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
            innerActionPerformed("eas", AbstractSalerStimulateSetEditUI.this, "ActionUnAudit", "actionUnAudit_actionPerformed", e);
        }
    }

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.salepayment.client", "SalerStimulateSetEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.salepayment.client.SalerStimulateSetEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo objectValue = new com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtsaler.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"销售员"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(indexType.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"指标类型"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtprofitTarget.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"损益指标(元)"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(txtyear.getValue())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"年"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(quarter.getSelectedItem())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"季度"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompanyTargetInfo.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"公司指标"});
		}
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtareaTargetInfo.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"大区指标"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtStimulateEntry;
	}
    /**
     * output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(-1));
vo.put("quarter","1");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}