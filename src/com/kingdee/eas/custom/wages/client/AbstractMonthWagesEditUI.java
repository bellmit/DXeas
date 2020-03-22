/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

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
public abstract class AbstractMonthWagesEditUI extends com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractMonthWagesEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contcompany;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contscore;
    protected com.kingdee.bos.ctrl.swing.KDButton calculation;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkDays;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkDay;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contworkDayss;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtcompany;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtscore;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkDays;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkDay;
    protected com.kingdee.bos.ctrl.swing.KDFormattedTextField txtworkDayss;
    protected com.kingdee.eas.custom.wages.MonthWagesInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractMonthWagesEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractMonthWagesEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.contcompany = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contscore = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.calculation = new com.kingdee.bos.ctrl.swing.KDButton();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.contworkDays = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkDay = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contworkDayss = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.prmtcompany = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.txtscore = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkDays = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkDay = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.txtworkDayss = new com.kingdee.bos.ctrl.swing.KDFormattedTextField();
        this.contcompany.setName("contcompany");
        this.contscore.setName("contscore");
        this.calculation.setName("calculation");
        this.kdtEntry.setName("kdtEntry");
        this.contworkDays.setName("contworkDays");
        this.contworkDay.setName("contworkDay");
        this.contworkDayss.setName("contworkDayss");
        this.prmtcompany.setName("prmtcompany");
        this.txtscore.setName("txtscore");
        this.txtworkDays.setName("txtworkDays");
        this.txtworkDay.setName("txtworkDay");
        this.txtworkDayss.setName("txtworkDayss");
        // CoreUI		
        this.btnTraceUp.setVisible(false);		
        this.btnTraceDown.setVisible(false);		
        this.btnCreateTo.setVisible(true);		
        this.btnAddLine.setVisible(false);		
        this.btnCopyLine.setVisible(false);		
        this.btnInsertLine.setVisible(false);		
        this.btnRemoveLine.setVisible(false);		
        this.btnAuditResult.setVisible(false);		
        this.separator1.setVisible(false);		
        this.menuItemCreateTo.setVisible(true);		
        this.separator3.setVisible(false);		
        this.menuItemTraceUp.setVisible(false);		
        this.menuItemTraceDown.setVisible(false);		
        this.menuTable1.setVisible(false);		
        this.menuItemAddLine.setVisible(false);		
        this.menuItemCopyLine.setVisible(false);		
        this.menuItemInsertLine.setVisible(false);		
        this.menuItemRemoveLine.setVisible(false);		
        this.menuItemViewSubmitProccess.setVisible(false);		
        this.menuItemViewDoProccess.setVisible(false);		
        this.menuItemAuditResult.setVisible(false);		
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
        this.prmtCreator.setEnabled(false);		
        this.kDDateCreateTime.setTimeEnabled(true);		
        this.kDDateCreateTime.setEnabled(false);		
        this.prmtLastUpdateUser.setEnabled(false);		
        this.kDDateLastUpdateTime.setTimeEnabled(true);		
        this.kDDateLastUpdateTime.setEnabled(false);		
        this.txtNumber.setMaxLength(80);		
        this.pkBizDate.setEnabled(true);		
        this.txtDescription.setMaxLength(80);		
        this.prmtAuditor.setEnabled(false);
        // contcompany		
        this.contcompany.setBoundLabelText(resHelper.getString("contcompany.boundLabelText"));		
        this.contcompany.setBoundLabelLength(100);		
        this.contcompany.setBoundLabelUnderline(true);		
        this.contcompany.setVisible(true);
        // contscore		
        this.contscore.setBoundLabelText(resHelper.getString("contscore.boundLabelText"));		
        this.contscore.setBoundLabelLength(100);		
        this.contscore.setBoundLabelUnderline(true);		
        this.contscore.setVisible(false);
        // calculation		
        this.calculation.setText(resHelper.getString("calculation.text"));
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol3\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;date</c:NumberFormat></c:Style><c:Style id=\"sCol10\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol11\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol12\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol13\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol14\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol15\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol16\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol17\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol18\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol19\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol20\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol21\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol22\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol23\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol24\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol25\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol26\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personName\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"worknature\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol3\" /><t:Column t:key=\"theGroup\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personPost\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"inDate\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"BankCard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"IDCard\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"PhoneNumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"workDay\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol10\" /><t:Column t:key=\"basicWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol11\" /><t:Column t:key=\"fractionQty\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol12\" /><t:Column t:key=\"fractionWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol13\" /><t:Column t:key=\"bythejobWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol14\" /><t:Column t:key=\"sanctionWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol15\" /><t:Column t:key=\"seniorityWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol16\" /><t:Column t:key=\"attendanceWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol17\" /><t:Column t:key=\"lifeWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol18\" /><t:Column t:key=\"postWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol19\" /><t:Column t:key=\"introduceWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol20\" /><t:Column t:key=\"adjustmentWages\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol21\" /><t:Column t:key=\"allWags\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol22\" /><t:Column t:key=\"EmployerInsurance\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol23\" /><t:Column t:key=\"Welfare\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol24\" /><t:Column t:key=\"PersonTax\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol25\" /><t:Column t:key=\"Payroll\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol26\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personName}</t:Cell><t:Cell>$Resource{worknature}</t:Cell><t:Cell>$Resource{theGroup}</t:Cell><t:Cell>$Resource{personPost}</t:Cell><t:Cell>$Resource{inDate}</t:Cell><t:Cell>$Resource{BankCard}</t:Cell><t:Cell>$Resource{IDCard}</t:Cell><t:Cell>$Resource{PhoneNumber}</t:Cell><t:Cell>$Resource{workDay}</t:Cell><t:Cell>$Resource{basicWages}</t:Cell><t:Cell>$Resource{fractionQty}</t:Cell><t:Cell>$Resource{fractionWages}</t:Cell><t:Cell>$Resource{bythejobWages}</t:Cell><t:Cell>$Resource{sanctionWages}</t:Cell><t:Cell>$Resource{seniorityWages}</t:Cell><t:Cell>$Resource{attendanceWages}</t:Cell><t:Cell>$Resource{lifeWages}</t:Cell><t:Cell>$Resource{postWages}</t:Cell><t:Cell>$Resource{introduceWages}</t:Cell><t:Cell>$Resource{adjustmentWages}</t:Cell><t:Cell>$Resource{allWags}</t:Cell><t:Cell>$Resource{EmployerInsurance}</t:Cell><t:Cell>$Resource{Welfare}</t:Cell><t:Cell>$Resource{PersonTax}</t:Cell><t:Cell>$Resource{Payroll}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
        this.kdtEntry.setFormatXml(resHelper.translateString("kdtEntry",kdtEntryStrXML));
        kdtEntry.addKDTEditListener(new KDTEditAdapter() {
		public void editStopped(KDTEditEvent e) {
			try {
				kdtEntry_Changed(e.getRowIndex(),e.getColIndex());
			}
			catch (Exception exc) {
				handUIException(exc);
			}
		}
	});


                this.kdtEntry.putBindContents("editData",new String[] {"seq","person","personName","worknature","theGroup","personPost","inDate","BankCard","IDCard","PhoneNumber","workDay","basicWages","fractionQty","fractionWages","bythejobWages","sanctionWages","seniorityWages","attendanceWages","lifeWages","postWages","introduceWages","adjustmentWages","allWags","EmployerInsurance","Welfare","PersonTax","Payroll"});


        this.kdtEntry.checkParsed();
        KDFormattedTextField kdtEntry_seq_TextField = new KDFormattedTextField();
        kdtEntry_seq_TextField.setName("kdtEntry_seq_TextField");
        kdtEntry_seq_TextField.setVisible(true);
        kdtEntry_seq_TextField.setEditable(true);
        kdtEntry_seq_TextField.setHorizontalAlignment(2);
        kdtEntry_seq_TextField.setDataType(0);
        KDTDefaultCellEditor kdtEntry_seq_CellEditor = new KDTDefaultCellEditor(kdtEntry_seq_TextField);
        this.kdtEntry.getColumn("seq").setEditor(kdtEntry_seq_CellEditor);
        final KDBizPromptBox kdtEntry_person_PromptBox = new KDBizPromptBox();
        kdtEntry_person_PromptBox.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonQuery");
        kdtEntry_person_PromptBox.setVisible(true);
        kdtEntry_person_PromptBox.setEditable(true);
        kdtEntry_person_PromptBox.setDisplayFormat("$number$");
        kdtEntry_person_PromptBox.setEditFormat("$number$");
        kdtEntry_person_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_person_CellEditor = new KDTDefaultCellEditor(kdtEntry_person_PromptBox);
        this.kdtEntry.getColumn("person").setEditor(kdtEntry_person_CellEditor);
        ObjectValueRender kdtEntry_person_OVR = new ObjectValueRender();
        kdtEntry_person_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtEntry.getColumn("person").setRenderer(kdtEntry_person_OVR);
        KDTextField kdtEntry_personName_TextField = new KDTextField();
        kdtEntry_personName_TextField.setName("kdtEntry_personName_TextField");
        kdtEntry_personName_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_personName_CellEditor = new KDTDefaultCellEditor(kdtEntry_personName_TextField);
        this.kdtEntry.getColumn("personName").setEditor(kdtEntry_personName_CellEditor);
        final KDBizPromptBox kdtEntry_worknature_PromptBox = new KDBizPromptBox();
        kdtEntry_worknature_PromptBox.setQueryInfo("com.kingdee.eas.hr.base.app.EmployeePropertQuery");
        kdtEntry_worknature_PromptBox.setVisible(true);
        kdtEntry_worknature_PromptBox.setEditable(true);
        kdtEntry_worknature_PromptBox.setDisplayFormat("$number$");
        kdtEntry_worknature_PromptBox.setEditFormat("$number$");
        kdtEntry_worknature_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_worknature_CellEditor = new KDTDefaultCellEditor(kdtEntry_worknature_PromptBox);
        this.kdtEntry.getColumn("worknature").setEditor(kdtEntry_worknature_CellEditor);
        ObjectValueRender kdtEntry_worknature_OVR = new ObjectValueRender();
        kdtEntry_worknature_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("worknature").setRenderer(kdtEntry_worknature_OVR);
        final KDBizPromptBox kdtEntry_theGroup_PromptBox = new KDBizPromptBox();
        kdtEntry_theGroup_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.WageOrganizationQuery");
        kdtEntry_theGroup_PromptBox.setVisible(true);
        kdtEntry_theGroup_PromptBox.setEditable(true);
        kdtEntry_theGroup_PromptBox.setDisplayFormat("$number$");
        kdtEntry_theGroup_PromptBox.setEditFormat("$number$");
        kdtEntry_theGroup_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_theGroup_CellEditor = new KDTDefaultCellEditor(kdtEntry_theGroup_PromptBox);
        this.kdtEntry.getColumn("theGroup").setEditor(kdtEntry_theGroup_CellEditor);
        ObjectValueRender kdtEntry_theGroup_OVR = new ObjectValueRender();
        kdtEntry_theGroup_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("theGroup").setRenderer(kdtEntry_theGroup_OVR);
        			kdtEntry_theGroup_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.custom.wages.client.WageOrganizationListUI kdtEntry_theGroup_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntry_theGroup_PromptBox_F7ListUI == null) {
					try {
						kdtEntry_theGroup_PromptBox_F7ListUI = new com.kingdee.eas.custom.wages.client.WageOrganizationListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntry_theGroup_PromptBox_F7ListUI));
					kdtEntry_theGroup_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntry_theGroup_PromptBox.setSelector(kdtEntry_theGroup_PromptBox_F7ListUI);
				}
			}
		});
					
        final KDBizPromptBox kdtEntry_personPost_PromptBox = new KDBizPromptBox();
        kdtEntry_personPost_PromptBox.setQueryInfo("com.kingdee.eas.custom.wages.app.BasicPostQuery");
        kdtEntry_personPost_PromptBox.setVisible(true);
        kdtEntry_personPost_PromptBox.setEditable(true);
        kdtEntry_personPost_PromptBox.setDisplayFormat("$number$");
        kdtEntry_personPost_PromptBox.setEditFormat("$number$");
        kdtEntry_personPost_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_personPost_CellEditor = new KDTDefaultCellEditor(kdtEntry_personPost_PromptBox);
        this.kdtEntry.getColumn("personPost").setEditor(kdtEntry_personPost_CellEditor);
        ObjectValueRender kdtEntry_personPost_OVR = new ObjectValueRender();
        kdtEntry_personPost_OVR.setFormat(new BizDataFormat("$postname$"));
        this.kdtEntry.getColumn("personPost").setRenderer(kdtEntry_personPost_OVR);
        KDDatePicker kdtEntry_inDate_DatePicker = new KDDatePicker();
        kdtEntry_inDate_DatePicker.setName("kdtEntry_inDate_DatePicker");
        kdtEntry_inDate_DatePicker.setVisible(true);
        kdtEntry_inDate_DatePicker.setEditable(true);
        KDTDefaultCellEditor kdtEntry_inDate_CellEditor = new KDTDefaultCellEditor(kdtEntry_inDate_DatePicker);
        this.kdtEntry.getColumn("inDate").setEditor(kdtEntry_inDate_CellEditor);
        KDTextField kdtEntry_BankCard_TextField = new KDTextField();
        kdtEntry_BankCard_TextField.setName("kdtEntry_BankCard_TextField");
        kdtEntry_BankCard_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_BankCard_CellEditor = new KDTDefaultCellEditor(kdtEntry_BankCard_TextField);
        this.kdtEntry.getColumn("BankCard").setEditor(kdtEntry_BankCard_CellEditor);
        KDTextField kdtEntry_IDCard_TextField = new KDTextField();
        kdtEntry_IDCard_TextField.setName("kdtEntry_IDCard_TextField");
        kdtEntry_IDCard_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_IDCard_CellEditor = new KDTDefaultCellEditor(kdtEntry_IDCard_TextField);
        this.kdtEntry.getColumn("IDCard").setEditor(kdtEntry_IDCard_CellEditor);
        KDTextField kdtEntry_PhoneNumber_TextField = new KDTextField();
        kdtEntry_PhoneNumber_TextField.setName("kdtEntry_PhoneNumber_TextField");
        kdtEntry_PhoneNumber_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_PhoneNumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_PhoneNumber_TextField);
        this.kdtEntry.getColumn("PhoneNumber").setEditor(kdtEntry_PhoneNumber_CellEditor);
        KDFormattedTextField kdtEntry_workDay_TextField = new KDFormattedTextField();
        kdtEntry_workDay_TextField.setName("kdtEntry_workDay_TextField");
        kdtEntry_workDay_TextField.setVisible(true);
        kdtEntry_workDay_TextField.setEditable(true);
        kdtEntry_workDay_TextField.setHorizontalAlignment(2);
        kdtEntry_workDay_TextField.setDataType(1);
        	kdtEntry_workDay_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_workDay_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_workDay_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_workDay_CellEditor = new KDTDefaultCellEditor(kdtEntry_workDay_TextField);
        this.kdtEntry.getColumn("workDay").setEditor(kdtEntry_workDay_CellEditor);
        KDFormattedTextField kdtEntry_basicWages_TextField = new KDFormattedTextField();
        kdtEntry_basicWages_TextField.setName("kdtEntry_basicWages_TextField");
        kdtEntry_basicWages_TextField.setVisible(true);
        kdtEntry_basicWages_TextField.setEditable(true);
        kdtEntry_basicWages_TextField.setHorizontalAlignment(2);
        kdtEntry_basicWages_TextField.setDataType(1);
        	kdtEntry_basicWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_basicWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_basicWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_basicWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_basicWages_TextField);
        this.kdtEntry.getColumn("basicWages").setEditor(kdtEntry_basicWages_CellEditor);
        KDFormattedTextField kdtEntry_fractionQty_TextField = new KDFormattedTextField();
        kdtEntry_fractionQty_TextField.setName("kdtEntry_fractionQty_TextField");
        kdtEntry_fractionQty_TextField.setVisible(true);
        kdtEntry_fractionQty_TextField.setEditable(true);
        kdtEntry_fractionQty_TextField.setHorizontalAlignment(2);
        kdtEntry_fractionQty_TextField.setDataType(1);
        	kdtEntry_fractionQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_fractionQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_fractionQty_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_fractionQty_CellEditor = new KDTDefaultCellEditor(kdtEntry_fractionQty_TextField);
        this.kdtEntry.getColumn("fractionQty").setEditor(kdtEntry_fractionQty_CellEditor);
        KDFormattedTextField kdtEntry_fractionWages_TextField = new KDFormattedTextField();
        kdtEntry_fractionWages_TextField.setName("kdtEntry_fractionWages_TextField");
        kdtEntry_fractionWages_TextField.setVisible(true);
        kdtEntry_fractionWages_TextField.setEditable(true);
        kdtEntry_fractionWages_TextField.setHorizontalAlignment(2);
        kdtEntry_fractionWages_TextField.setDataType(1);
        	kdtEntry_fractionWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_fractionWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_fractionWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_fractionWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_fractionWages_TextField);
        this.kdtEntry.getColumn("fractionWages").setEditor(kdtEntry_fractionWages_CellEditor);
        KDFormattedTextField kdtEntry_bythejobWages_TextField = new KDFormattedTextField();
        kdtEntry_bythejobWages_TextField.setName("kdtEntry_bythejobWages_TextField");
        kdtEntry_bythejobWages_TextField.setVisible(true);
        kdtEntry_bythejobWages_TextField.setEditable(true);
        kdtEntry_bythejobWages_TextField.setHorizontalAlignment(2);
        kdtEntry_bythejobWages_TextField.setDataType(1);
        	kdtEntry_bythejobWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_bythejobWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_bythejobWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_bythejobWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_bythejobWages_TextField);
        this.kdtEntry.getColumn("bythejobWages").setEditor(kdtEntry_bythejobWages_CellEditor);
        KDFormattedTextField kdtEntry_sanctionWages_TextField = new KDFormattedTextField();
        kdtEntry_sanctionWages_TextField.setName("kdtEntry_sanctionWages_TextField");
        kdtEntry_sanctionWages_TextField.setVisible(true);
        kdtEntry_sanctionWages_TextField.setEditable(true);
        kdtEntry_sanctionWages_TextField.setHorizontalAlignment(2);
        kdtEntry_sanctionWages_TextField.setDataType(1);
        	kdtEntry_sanctionWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_sanctionWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_sanctionWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_sanctionWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_sanctionWages_TextField);
        this.kdtEntry.getColumn("sanctionWages").setEditor(kdtEntry_sanctionWages_CellEditor);
        KDFormattedTextField kdtEntry_seniorityWages_TextField = new KDFormattedTextField();
        kdtEntry_seniorityWages_TextField.setName("kdtEntry_seniorityWages_TextField");
        kdtEntry_seniorityWages_TextField.setVisible(true);
        kdtEntry_seniorityWages_TextField.setEditable(true);
        kdtEntry_seniorityWages_TextField.setHorizontalAlignment(2);
        kdtEntry_seniorityWages_TextField.setDataType(1);
        	kdtEntry_seniorityWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_seniorityWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_seniorityWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_seniorityWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_seniorityWages_TextField);
        this.kdtEntry.getColumn("seniorityWages").setEditor(kdtEntry_seniorityWages_CellEditor);
        KDFormattedTextField kdtEntry_attendanceWages_TextField = new KDFormattedTextField();
        kdtEntry_attendanceWages_TextField.setName("kdtEntry_attendanceWages_TextField");
        kdtEntry_attendanceWages_TextField.setVisible(true);
        kdtEntry_attendanceWages_TextField.setEditable(true);
        kdtEntry_attendanceWages_TextField.setHorizontalAlignment(2);
        kdtEntry_attendanceWages_TextField.setDataType(1);
        	kdtEntry_attendanceWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_attendanceWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_attendanceWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_attendanceWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_attendanceWages_TextField);
        this.kdtEntry.getColumn("attendanceWages").setEditor(kdtEntry_attendanceWages_CellEditor);
        KDFormattedTextField kdtEntry_lifeWages_TextField = new KDFormattedTextField();
        kdtEntry_lifeWages_TextField.setName("kdtEntry_lifeWages_TextField");
        kdtEntry_lifeWages_TextField.setVisible(true);
        kdtEntry_lifeWages_TextField.setEditable(true);
        kdtEntry_lifeWages_TextField.setHorizontalAlignment(2);
        kdtEntry_lifeWages_TextField.setDataType(1);
        	kdtEntry_lifeWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_lifeWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_lifeWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_lifeWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_lifeWages_TextField);
        this.kdtEntry.getColumn("lifeWages").setEditor(kdtEntry_lifeWages_CellEditor);
        KDFormattedTextField kdtEntry_postWages_TextField = new KDFormattedTextField();
        kdtEntry_postWages_TextField.setName("kdtEntry_postWages_TextField");
        kdtEntry_postWages_TextField.setVisible(true);
        kdtEntry_postWages_TextField.setEditable(true);
        kdtEntry_postWages_TextField.setHorizontalAlignment(2);
        kdtEntry_postWages_TextField.setDataType(1);
        	kdtEntry_postWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_postWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_postWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_postWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_postWages_TextField);
        this.kdtEntry.getColumn("postWages").setEditor(kdtEntry_postWages_CellEditor);
        KDFormattedTextField kdtEntry_introduceWages_TextField = new KDFormattedTextField();
        kdtEntry_introduceWages_TextField.setName("kdtEntry_introduceWages_TextField");
        kdtEntry_introduceWages_TextField.setVisible(true);
        kdtEntry_introduceWages_TextField.setEditable(true);
        kdtEntry_introduceWages_TextField.setHorizontalAlignment(2);
        kdtEntry_introduceWages_TextField.setDataType(1);
        	kdtEntry_introduceWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_introduceWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_introduceWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_introduceWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_introduceWages_TextField);
        this.kdtEntry.getColumn("introduceWages").setEditor(kdtEntry_introduceWages_CellEditor);
        KDFormattedTextField kdtEntry_adjustmentWages_TextField = new KDFormattedTextField();
        kdtEntry_adjustmentWages_TextField.setName("kdtEntry_adjustmentWages_TextField");
        kdtEntry_adjustmentWages_TextField.setVisible(true);
        kdtEntry_adjustmentWages_TextField.setEditable(true);
        kdtEntry_adjustmentWages_TextField.setHorizontalAlignment(2);
        kdtEntry_adjustmentWages_TextField.setDataType(1);
        	kdtEntry_adjustmentWages_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_adjustmentWages_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_adjustmentWages_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_adjustmentWages_CellEditor = new KDTDefaultCellEditor(kdtEntry_adjustmentWages_TextField);
        this.kdtEntry.getColumn("adjustmentWages").setEditor(kdtEntry_adjustmentWages_CellEditor);
        KDFormattedTextField kdtEntry_allWags_TextField = new KDFormattedTextField();
        kdtEntry_allWags_TextField.setName("kdtEntry_allWags_TextField");
        kdtEntry_allWags_TextField.setVisible(true);
        kdtEntry_allWags_TextField.setEditable(true);
        kdtEntry_allWags_TextField.setHorizontalAlignment(2);
        kdtEntry_allWags_TextField.setDataType(1);
        	kdtEntry_allWags_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_allWags_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_allWags_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_allWags_CellEditor = new KDTDefaultCellEditor(kdtEntry_allWags_TextField);
        this.kdtEntry.getColumn("allWags").setEditor(kdtEntry_allWags_CellEditor);
        KDFormattedTextField kdtEntry_EmployerInsurance_TextField = new KDFormattedTextField();
        kdtEntry_EmployerInsurance_TextField.setName("kdtEntry_EmployerInsurance_TextField");
        kdtEntry_EmployerInsurance_TextField.setVisible(true);
        kdtEntry_EmployerInsurance_TextField.setEditable(true);
        kdtEntry_EmployerInsurance_TextField.setHorizontalAlignment(2);
        kdtEntry_EmployerInsurance_TextField.setDataType(1);
        	kdtEntry_EmployerInsurance_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_EmployerInsurance_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_EmployerInsurance_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_EmployerInsurance_CellEditor = new KDTDefaultCellEditor(kdtEntry_EmployerInsurance_TextField);
        this.kdtEntry.getColumn("EmployerInsurance").setEditor(kdtEntry_EmployerInsurance_CellEditor);
        KDFormattedTextField kdtEntry_Welfare_TextField = new KDFormattedTextField();
        kdtEntry_Welfare_TextField.setName("kdtEntry_Welfare_TextField");
        kdtEntry_Welfare_TextField.setVisible(true);
        kdtEntry_Welfare_TextField.setEditable(true);
        kdtEntry_Welfare_TextField.setHorizontalAlignment(2);
        kdtEntry_Welfare_TextField.setDataType(1);
        	kdtEntry_Welfare_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Welfare_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Welfare_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Welfare_CellEditor = new KDTDefaultCellEditor(kdtEntry_Welfare_TextField);
        this.kdtEntry.getColumn("Welfare").setEditor(kdtEntry_Welfare_CellEditor);
        KDFormattedTextField kdtEntry_PersonTax_TextField = new KDFormattedTextField();
        kdtEntry_PersonTax_TextField.setName("kdtEntry_PersonTax_TextField");
        kdtEntry_PersonTax_TextField.setVisible(true);
        kdtEntry_PersonTax_TextField.setEditable(true);
        kdtEntry_PersonTax_TextField.setHorizontalAlignment(2);
        kdtEntry_PersonTax_TextField.setDataType(1);
        	kdtEntry_PersonTax_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_PersonTax_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_PersonTax_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_PersonTax_CellEditor = new KDTDefaultCellEditor(kdtEntry_PersonTax_TextField);
        this.kdtEntry.getColumn("PersonTax").setEditor(kdtEntry_PersonTax_CellEditor);
        KDFormattedTextField kdtEntry_Payroll_TextField = new KDFormattedTextField();
        kdtEntry_Payroll_TextField.setName("kdtEntry_Payroll_TextField");
        kdtEntry_Payroll_TextField.setVisible(true);
        kdtEntry_Payroll_TextField.setEditable(true);
        kdtEntry_Payroll_TextField.setHorizontalAlignment(2);
        kdtEntry_Payroll_TextField.setDataType(1);
        	kdtEntry_Payroll_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Payroll_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Payroll_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Payroll_CellEditor = new KDTDefaultCellEditor(kdtEntry_Payroll_TextField);
        this.kdtEntry.getColumn("Payroll").setEditor(kdtEntry_Payroll_CellEditor);
        // contworkDays		
        this.contworkDays.setBoundLabelText(resHelper.getString("contworkDays.boundLabelText"));		
        this.contworkDays.setBoundLabelLength(100);		
        this.contworkDays.setBoundLabelUnderline(true);		
        this.contworkDays.setVisible(false);
        // contworkDay		
        this.contworkDay.setBoundLabelText(resHelper.getString("contworkDay.boundLabelText"));		
        this.contworkDay.setBoundLabelLength(100);		
        this.contworkDay.setBoundLabelUnderline(true);		
        this.contworkDay.setVisible(false);
        // contworkDayss		
        this.contworkDayss.setBoundLabelText(resHelper.getString("contworkDayss.boundLabelText"));		
        this.contworkDayss.setBoundLabelLength(100);		
        this.contworkDayss.setBoundLabelUnderline(true);		
        this.contworkDayss.setVisible(false);
        // prmtcompany		
        this.prmtcompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtcompany.setEditable(true);		
        this.prmtcompany.setDisplayFormat("$name$");		
        this.prmtcompany.setEditFormat("$number$");		
        this.prmtcompany.setCommitFormat("$number$");		
        this.prmtcompany.setRequired(true);
        // txtscore		
        this.txtscore.setHorizontalAlignment(2);		
        this.txtscore.setDataType(1);		
        this.txtscore.setSupportedEmpty(true);		
        this.txtscore.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtscore.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtscore.setPrecision(4);		
        this.txtscore.setRequired(false);		
        this.txtscore.setVisible(false);
        // txtworkDays		
        this.txtworkDays.setHorizontalAlignment(2);		
        this.txtworkDays.setDataType(0);		
        this.txtworkDays.setSupportedEmpty(true);		
        this.txtworkDays.setRequired(false);		
        this.txtworkDays.setEnabled(false);		
        this.txtworkDays.setVisible(false);
        // txtworkDay		
        this.txtworkDay.setHorizontalAlignment(2);		
        this.txtworkDay.setDataType(1);		
        this.txtworkDay.setSupportedEmpty(true);		
        this.txtworkDay.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtworkDay.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtworkDay.setPrecision(4);		
        this.txtworkDay.setRequired(false);		
        this.txtworkDay.setEnabled(false);		
        this.txtworkDay.setVisible(false);
        // txtworkDayss		
        this.txtworkDayss.setVisible(false);		
        this.txtworkDayss.setHorizontalAlignment(2);		
        this.txtworkDayss.setDataType(1);		
        this.txtworkDayss.setSupportedEmpty(true);		
        this.txtworkDayss.setMinimumValue( new java.math.BigDecimal("-1.0E18"));		
        this.txtworkDayss.setMaximumValue( new java.math.BigDecimal("1.0E18"));		
        this.txtworkDayss.setPrecision(4);		
        this.txtworkDayss.setRequired(false);		
        this.txtworkDayss.setEnabled(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {pkauditTime,billStatus,prmtcompany,txtscore,kDDateLastUpdateTime,prmtLastUpdateUser,kDDateCreateTime,prmtCreator,prmtAuditor,txtDescription,pkBizDate,txtNumber,txtworkDays,txtworkDay,txtworkDayss,kdtEntry}));
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
        contCreator.setBounds(new Rectangle(370, 548, 270, 19));
        this.add(contCreator, new KDLayout.Constraints(370, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contCreateTime.setBounds(new Rectangle(370, 581, 270, 19));
        this.add(contCreateTime, new KDLayout.Constraints(370, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contLastUpdateUser.setBounds(new Rectangle(717, 548, 270, 19));
        this.add(contLastUpdateUser, new KDLayout.Constraints(717, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contLastUpdateTime.setBounds(new Rectangle(717, 581, 270, 19));
        this.add(contLastUpdateTime, new KDLayout.Constraints(717, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contNumber.setBounds(new Rectangle(23, 19, 270, 19));
        this.add(contNumber, new KDLayout.Constraints(23, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBizDate.setBounds(new Rectangle(370, 19, 270, 19));
        this.add(contBizDate, new KDLayout.Constraints(370, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contDescription.setBounds(new Rectangle(717, 51, 270, 19));
        this.add(contDescription, new KDLayout.Constraints(717, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contAuditor.setBounds(new Rectangle(23, 548, 270, 19));
        this.add(contAuditor, new KDLayout.Constraints(23, 548, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contauditTime.setBounds(new Rectangle(23, 581, 270, 19));
        this.add(contauditTime, new KDLayout.Constraints(23, 581, 270, 19, KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contbillStatus.setBounds(new Rectangle(717, 19, 270, 19));
        this.add(contbillStatus, new KDLayout.Constraints(717, 19, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contcompany.setBounds(new Rectangle(23, 51, 270, 19));
        this.add(contcompany, new KDLayout.Constraints(23, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contscore.setBounds(new Rectangle(370, 51, 270, 19));
        this.add(contscore, new KDLayout.Constraints(370, 51, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        calculation.setBounds(new Rectangle(840, 82, 148, 21));
        this.add(calculation, new KDLayout.Constraints(840, 82, 148, 21, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kdtEntry.setBounds(new Rectangle(27, 118, 960, 403));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.wages.MonthWagesEntryInfo(),null,false);
        this.add(kdtEntry_detailPanel, new KDLayout.Constraints(27, 118, 960, 403, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_BOTTOM | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT));
        contworkDays.setBounds(new Rectangle(295, -2, 270, 19));
        this.add(contworkDays, new KDLayout.Constraints(295, -2, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contworkDay.setBounds(new Rectangle(18, -3, 270, 19));
        this.add(contworkDay, new KDLayout.Constraints(18, -3, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contworkDayss.setBounds(new Rectangle(23, 84, 270, 19));
        this.add(contworkDayss, new KDLayout.Constraints(23, 84, 270, 19, KDLayout.Constraints.ANCHOR_TOP | KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
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
        //contcompany
        contcompany.setBoundEditor(prmtcompany);
        //contscore
        contscore.setBoundEditor(txtscore);
        //contworkDays
        contworkDays.setBoundEditor(txtworkDays);
        //contworkDay
        contworkDay.setBoundEditor(txtworkDay);
        //contworkDayss
        contworkDayss.setBoundEditor(txtworkDayss);

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
        menuBiz.add(menuItemDelVoucher);
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
        this.toolBar.add(btnDelVoucher);
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
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.wages.MonthWagesEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.person", java.lang.Object.class, this.kdtEntry, "person.text");
		dataBinder.registerBinding("Entry.personName", String.class, this.kdtEntry, "personName.text");
		dataBinder.registerBinding("Entry.personPost", java.lang.Object.class, this.kdtEntry, "personPost.text");
		dataBinder.registerBinding("Entry.fractionWages", java.math.BigDecimal.class, this.kdtEntry, "fractionWages.text");
		dataBinder.registerBinding("Entry.bythejobWages", java.math.BigDecimal.class, this.kdtEntry, "bythejobWages.text");
		dataBinder.registerBinding("Entry.seniorityWages", java.math.BigDecimal.class, this.kdtEntry, "seniorityWages.text");
		dataBinder.registerBinding("Entry.sanctionWages", java.math.BigDecimal.class, this.kdtEntry, "sanctionWages.text");
		dataBinder.registerBinding("Entry.attendanceWages", java.math.BigDecimal.class, this.kdtEntry, "attendanceWages.text");
		dataBinder.registerBinding("Entry.lifeWages", java.math.BigDecimal.class, this.kdtEntry, "lifeWages.text");
		dataBinder.registerBinding("Entry.postWages", java.math.BigDecimal.class, this.kdtEntry, "postWages.text");
		dataBinder.registerBinding("Entry.introduceWages", java.math.BigDecimal.class, this.kdtEntry, "introduceWages.text");
		dataBinder.registerBinding("Entry.adjustmentWages", java.math.BigDecimal.class, this.kdtEntry, "adjustmentWages.text");
		dataBinder.registerBinding("Entry.allWags", java.math.BigDecimal.class, this.kdtEntry, "allWags.text");
		dataBinder.registerBinding("Entry.fractionQty", java.math.BigDecimal.class, this.kdtEntry, "fractionQty.text");
		dataBinder.registerBinding("Entry.basicWages", java.math.BigDecimal.class, this.kdtEntry, "basicWages.text");
		dataBinder.registerBinding("Entry.BankCard", String.class, this.kdtEntry, "BankCard.text");
		dataBinder.registerBinding("Entry.IDCard", String.class, this.kdtEntry, "IDCard.text");
		dataBinder.registerBinding("Entry.PhoneNumber", String.class, this.kdtEntry, "PhoneNumber.text");
		dataBinder.registerBinding("Entry.workDay", java.math.BigDecimal.class, this.kdtEntry, "workDay.text");
		dataBinder.registerBinding("Entry.theGroup", java.lang.Object.class, this.kdtEntry, "theGroup.text");
		dataBinder.registerBinding("Entry.inDate", java.util.Date.class, this.kdtEntry, "inDate.text");
		dataBinder.registerBinding("Entry.EmployerInsurance", java.math.BigDecimal.class, this.kdtEntry, "EmployerInsurance.text");
		dataBinder.registerBinding("Entry.PersonTax", java.math.BigDecimal.class, this.kdtEntry, "PersonTax.text");
		dataBinder.registerBinding("Entry.Payroll", java.math.BigDecimal.class, this.kdtEntry, "Payroll.text");
		dataBinder.registerBinding("Entry.Welfare", java.math.BigDecimal.class, this.kdtEntry, "Welfare.text");
		dataBinder.registerBinding("Entry.worknature", java.lang.Object.class, this.kdtEntry, "worknature.text");
		dataBinder.registerBinding("company", com.kingdee.eas.basedata.org.CompanyOrgUnitInfo.class, this.prmtcompany, "data");
		dataBinder.registerBinding("score", java.math.BigDecimal.class, this.txtscore, "value");
		dataBinder.registerBinding("workDays", int.class, this.txtworkDays, "value");
		dataBinder.registerBinding("workDay", java.math.BigDecimal.class, this.txtworkDay, "value");
		dataBinder.registerBinding("workDayss", java.math.BigDecimal.class, this.txtworkDayss, "value");		
	}
	//Regiester UI State
	private void registerUIState(){		
	}
	public String getUIHandlerClassName() {
	    return "com.kingdee.eas.custom.wages.app.MonthWagesEditUIHandler";
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
        this.pkauditTime.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.MonthWagesInfo)ov;
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
	 * ????????§µ??
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
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personPost", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.fractionWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.bythejobWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seniorityWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.sanctionWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.attendanceWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.lifeWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.postWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.introduceWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.adjustmentWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.allWags", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.fractionQty", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.basicWages", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.BankCard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.IDCard", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.PhoneNumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.workDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.theGroup", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.inDate", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.EmployerInsurance", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.PersonTax", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Payroll", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Welfare", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.worknature", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("company", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("score", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workDays", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workDay", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("workDayss", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"personName").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"name")));

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
    	sic.add(new SelectorItemInfo("Entry.seq"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.*"));
		}
		else{
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.person.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.person.id"));
			sic.add(new SelectorItemInfo("Entry.person.number"));
			sic.add(new SelectorItemInfo("Entry.person.name"));
		}
    	sic.add(new SelectorItemInfo("Entry.personName"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.personPost.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.personPost.id"));
			sic.add(new SelectorItemInfo("Entry.personPost.postname"));
			sic.add(new SelectorItemInfo("Entry.personPost.name"));
        	sic.add(new SelectorItemInfo("Entry.personPost.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.fractionWages"));
    	sic.add(new SelectorItemInfo("Entry.bythejobWages"));
    	sic.add(new SelectorItemInfo("Entry.seniorityWages"));
    	sic.add(new SelectorItemInfo("Entry.sanctionWages"));
    	sic.add(new SelectorItemInfo("Entry.attendanceWages"));
    	sic.add(new SelectorItemInfo("Entry.lifeWages"));
    	sic.add(new SelectorItemInfo("Entry.postWages"));
    	sic.add(new SelectorItemInfo("Entry.introduceWages"));
    	sic.add(new SelectorItemInfo("Entry.adjustmentWages"));
    	sic.add(new SelectorItemInfo("Entry.allWags"));
    	sic.add(new SelectorItemInfo("Entry.fractionQty"));
    	sic.add(new SelectorItemInfo("Entry.basicWages"));
    	sic.add(new SelectorItemInfo("Entry.BankCard"));
    	sic.add(new SelectorItemInfo("Entry.IDCard"));
    	sic.add(new SelectorItemInfo("Entry.PhoneNumber"));
    	sic.add(new SelectorItemInfo("Entry.workDay"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.theGroup.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.theGroup.id"));
			sic.add(new SelectorItemInfo("Entry.theGroup.name"));
        	sic.add(new SelectorItemInfo("Entry.theGroup.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.inDate"));
    	sic.add(new SelectorItemInfo("Entry.EmployerInsurance"));
    	sic.add(new SelectorItemInfo("Entry.PersonTax"));
    	sic.add(new SelectorItemInfo("Entry.Payroll"));
    	sic.add(new SelectorItemInfo("Entry.Welfare"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("Entry.worknature.*"));
		}
		else{
	    	sic.add(new SelectorItemInfo("Entry.worknature.id"));
			sic.add(new SelectorItemInfo("Entry.worknature.name"));
        	sic.add(new SelectorItemInfo("Entry.worknature.number"));
		}
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("company.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("company.id"));
        	sic.add(new SelectorItemInfo("company.number"));
        	sic.add(new SelectorItemInfo("company.name"));
		}
        sic.add(new SelectorItemInfo("score"));
        sic.add(new SelectorItemInfo("workDays"));
        sic.add(new SelectorItemInfo("workDay"));
        sic.add(new SelectorItemInfo("workDayss"));
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.client", "MonthWagesEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.client.MonthWagesEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.MonthWagesFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.MonthWagesInfo objectValue = new com.kingdee.eas.custom.wages.MonthWagesInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
    }


    	protected String getTDFileName() {
    	return "/bim/custom/wages/MonthWages";
	}
    protected IMetaDataPK getTDQueryPK() {
    	return new MetaDataPK("com.kingdee.eas.custom.wages.app.MonthWagesQuery");
	}
    
        
					protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		if (com.kingdee.bos.ui.face.UIRuleUtil.isNull(prmtcompany.getData())) {
			throw new com.kingdee.eas.common.EASBizException(com.kingdee.eas.common.EASBizException.CHECKBLANK,new Object[] {"¹«Ë¾"});
		}
			super.beforeStoreFields(arg0);
		}

    /**
     * output getDetailTable method
     */
    protected KDTable getDetailTable() {
        return kdtEntry;
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