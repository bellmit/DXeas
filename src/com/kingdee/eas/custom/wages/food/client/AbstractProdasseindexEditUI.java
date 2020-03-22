/**
 * output package name
 */
package com.kingdee.eas.custom.wages.food.client;

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
public abstract class AbstractProdasseindexEditUI extends com.kingdee.eas.framework.client.EditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AbstractProdasseindexEditUI.class);
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer2;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer3;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer kDLabelContainer4;
    protected com.kingdee.bos.ctrl.swing.KDTabbedPane kDTabbedPane1;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contBaseStatus;
    protected com.kingdee.bos.ctrl.swing.KDLabelContainer contExaminPerson;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtNumber;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtName;
    protected com.kingdee.bos.ctrl.swing.KDTextField txtSimpleName;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox txtDescription;
    protected com.kingdee.bos.ctrl.swing.KDPanel kDPanel1;
    protected com.kingdee.bos.ctrl.kdf.table.KDTable kdtEntry;
	protected com.kingdee.eas.framework.client.multiDetail.DetailPanel kdtEntry_detailPanel = null;
    protected com.kingdee.bos.ctrl.swing.KDComboBox BaseStatus;
    protected com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox prmtExaminPerson;
    protected com.kingdee.eas.custom.wages.food.ProdasseindexInfo editData = null;
    /**
     * output class constructor
     */
    public AbstractProdasseindexEditUI() throws Exception
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
        this.resHelper = new ResourceBundleHelper(AbstractProdasseindexEditUI.class.getName());
        this.setUITitle(resHelper.getString("this.title"));
        this.kDLabelContainer1 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer2 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer3 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDLabelContainer4 = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.kDTabbedPane1 = new com.kingdee.bos.ctrl.swing.KDTabbedPane();
        this.contBaseStatus = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.contExaminPerson = new com.kingdee.bos.ctrl.swing.KDLabelContainer();
        this.txtNumber = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtName = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.txtSimpleName = new com.kingdee.bos.ctrl.swing.KDTextField();
        this.txtDescription = new com.kingdee.bos.ctrl.extendcontrols.KDBizMultiLangBox();
        this.kDPanel1 = new com.kingdee.bos.ctrl.swing.KDPanel();
        this.kdtEntry = new com.kingdee.bos.ctrl.kdf.table.KDTable();
        this.BaseStatus = new com.kingdee.bos.ctrl.swing.KDComboBox();
        this.prmtExaminPerson = new com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox();
        this.kDLabelContainer1.setName("kDLabelContainer1");
        this.kDLabelContainer2.setName("kDLabelContainer2");
        this.kDLabelContainer3.setName("kDLabelContainer3");
        this.kDLabelContainer4.setName("kDLabelContainer4");
        this.kDTabbedPane1.setName("kDTabbedPane1");
        this.contBaseStatus.setName("contBaseStatus");
        this.contExaminPerson.setName("contExaminPerson");
        this.txtNumber.setName("txtNumber");
        this.txtName.setName("txtName");
        this.txtSimpleName.setName("txtSimpleName");
        this.txtDescription.setName("txtDescription");
        this.kDPanel1.setName("kDPanel1");
        this.kdtEntry.setName("kdtEntry");
        this.BaseStatus.setName("BaseStatus");
        this.prmtExaminPerson.setName("prmtExaminPerson");
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
        // kDTabbedPane1
        // contBaseStatus		
        this.contBaseStatus.setBoundLabelText(resHelper.getString("contBaseStatus.boundLabelText"));		
        this.contBaseStatus.setBoundLabelLength(100);		
        this.contBaseStatus.setBoundLabelUnderline(true);		
        this.contBaseStatus.setVisible(true);
        // contExaminPerson		
        this.contExaminPerson.setBoundLabelText(resHelper.getString("contExaminPerson.boundLabelText"));		
        this.contExaminPerson.setBoundLabelLength(100);		
        this.contExaminPerson.setBoundLabelUnderline(true);		
        this.contExaminPerson.setVisible(true);
        // txtNumber		
        this.txtNumber.setMaxLength(80);
        // txtName
        // txtSimpleName		
        this.txtSimpleName.setMaxLength(80);
        // txtDescription
        // kDPanel1
        // kdtEntry
		String kdtEntryStrXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><DocRoot xmlns:c=\"http://www.kingdee.com/Common\" xmlns:f=\"http://www.kingdee.com/Form\" xmlns:t=\"http://www.kingdee.com/Table\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.kingdee.com/KDF KDFSchema.xsd\" version=\"0.0\"><Styles><c:Style id=\"sCol0\"><c:Protection hidden=\"true\" /><c:NumberFormat>&amp;int</c:NumberFormat></c:Style><c:Style id=\"sCol2\"><c:Protection locked=\"true\" /></c:Style><c:Style id=\"sCol5\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol6\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol7\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style><c:Style id=\"sCol8\"><c:NumberFormat>&amp;double</c:NumberFormat></c:Style></Styles><Table id=\"KDTable\"><t:Sheet name=\"sheet1\"><t:Table t:selectMode=\"15\" t:mergeMode=\"0\" t:dataRequestMode=\"0\" t:pageRowCount=\"100\"><t:ColumnGroup><t:Column t:key=\"seq\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol0\" /><t:Column t:key=\"person\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"personnumber\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol2\" /><t:Column t:key=\"Assessmentproject\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"AssessRates\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" /><t:Column t:key=\"AssesValue\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol5\" /><t:Column t:key=\"StandardAward\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol6\" /><t:Column t:key=\"AssesUnit\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol7\" /><t:Column t:key=\"Unitindex\" t:width=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\" t:moveable=\"true\" t:group=\"false\" t:required=\"false\" t:index=\"-1\" t:styleID=\"sCol8\" /></t:ColumnGroup><t:Head><t:Row t:name=\"header\" t:height=\"-1\" t:mergeable=\"true\" t:resizeable=\"true\"><t:Cell>$Resource{seq}</t:Cell><t:Cell>$Resource{person}</t:Cell><t:Cell>$Resource{personnumber}</t:Cell><t:Cell>$Resource{Assessmentproject}</t:Cell><t:Cell>$Resource{AssessRates}</t:Cell><t:Cell>$Resource{AssesValue}</t:Cell><t:Cell>$Resource{StandardAward}</t:Cell><t:Cell>$Resource{AssesUnit}</t:Cell><t:Cell>$Resource{Unitindex}</t:Cell></t:Row></t:Head></t:Table><t:SheetOptions><t:MergeBlocks><t:Head /></t:MergeBlocks></t:SheetOptions></t:Sheet></Table></DocRoot>";
		
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


                this.kdtEntry.putBindContents("editData",new String[] {"seq","person","personnumber","Assessmentproject","AssessRates","AssesValue","StandardAward","AssesUnit","Unitindex"});


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
        kdtEntry_person_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("person").setRenderer(kdtEntry_person_OVR);
        KDTextField kdtEntry_personnumber_TextField = new KDTextField();
        kdtEntry_personnumber_TextField.setName("kdtEntry_personnumber_TextField");
        kdtEntry_personnumber_TextField.setMaxLength(80);
        KDTDefaultCellEditor kdtEntry_personnumber_CellEditor = new KDTDefaultCellEditor(kdtEntry_personnumber_TextField);
        this.kdtEntry.getColumn("personnumber").setEditor(kdtEntry_personnumber_CellEditor);
        KDTextField kdtEntry_Assessmentproject_TextField = new KDTextField();
        kdtEntry_Assessmentproject_TextField.setName("kdtEntry_Assessmentproject_TextField");
        kdtEntry_Assessmentproject_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_Assessmentproject_CellEditor = new KDTDefaultCellEditor(kdtEntry_Assessmentproject_TextField);
        this.kdtEntry.getColumn("Assessmentproject").setEditor(kdtEntry_Assessmentproject_CellEditor);
        KDTextField kdtEntry_AssessRates_TextField = new KDTextField();
        kdtEntry_AssessRates_TextField.setName("kdtEntry_AssessRates_TextField");
        kdtEntry_AssessRates_TextField.setMaxLength(100);
        KDTDefaultCellEditor kdtEntry_AssessRates_CellEditor = new KDTDefaultCellEditor(kdtEntry_AssessRates_TextField);
        this.kdtEntry.getColumn("AssessRates").setEditor(kdtEntry_AssessRates_CellEditor);
        KDFormattedTextField kdtEntry_AssesValue_TextField = new KDFormattedTextField();
        kdtEntry_AssesValue_TextField.setName("kdtEntry_AssesValue_TextField");
        kdtEntry_AssesValue_TextField.setVisible(true);
        kdtEntry_AssesValue_TextField.setEditable(true);
        kdtEntry_AssesValue_TextField.setHorizontalAlignment(2);
        kdtEntry_AssesValue_TextField.setDataType(1);
        	kdtEntry_AssesValue_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_AssesValue_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_AssesValue_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_AssesValue_CellEditor = new KDTDefaultCellEditor(kdtEntry_AssesValue_TextField);
        this.kdtEntry.getColumn("AssesValue").setEditor(kdtEntry_AssesValue_CellEditor);
        KDFormattedTextField kdtEntry_StandardAward_TextField = new KDFormattedTextField();
        kdtEntry_StandardAward_TextField.setName("kdtEntry_StandardAward_TextField");
        kdtEntry_StandardAward_TextField.setVisible(true);
        kdtEntry_StandardAward_TextField.setEditable(true);
        kdtEntry_StandardAward_TextField.setHorizontalAlignment(2);
        kdtEntry_StandardAward_TextField.setDataType(1);
        	kdtEntry_StandardAward_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_StandardAward_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_StandardAward_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_StandardAward_CellEditor = new KDTDefaultCellEditor(kdtEntry_StandardAward_TextField);
        this.kdtEntry.getColumn("StandardAward").setEditor(kdtEntry_StandardAward_CellEditor);
        KDFormattedTextField kdtEntry_AssesUnit_TextField = new KDFormattedTextField();
        kdtEntry_AssesUnit_TextField.setName("kdtEntry_AssesUnit_TextField");
        kdtEntry_AssesUnit_TextField.setVisible(true);
        kdtEntry_AssesUnit_TextField.setEditable(true);
        kdtEntry_AssesUnit_TextField.setHorizontalAlignment(2);
        kdtEntry_AssesUnit_TextField.setDataType(1);
        	kdtEntry_AssesUnit_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_AssesUnit_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_AssesUnit_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_AssesUnit_CellEditor = new KDTDefaultCellEditor(kdtEntry_AssesUnit_TextField);
        this.kdtEntry.getColumn("AssesUnit").setEditor(kdtEntry_AssesUnit_CellEditor);
        KDFormattedTextField kdtEntry_Unitindex_TextField = new KDFormattedTextField();
        kdtEntry_Unitindex_TextField.setName("kdtEntry_Unitindex_TextField");
        kdtEntry_Unitindex_TextField.setVisible(true);
        kdtEntry_Unitindex_TextField.setEditable(true);
        kdtEntry_Unitindex_TextField.setHorizontalAlignment(2);
        kdtEntry_Unitindex_TextField.setDataType(1);
        	kdtEntry_Unitindex_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
        	kdtEntry_Unitindex_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
        kdtEntry_Unitindex_TextField.setPrecision(10);
        KDTDefaultCellEditor kdtEntry_Unitindex_CellEditor = new KDTDefaultCellEditor(kdtEntry_Unitindex_TextField);
        this.kdtEntry.getColumn("Unitindex").setEditor(kdtEntry_Unitindex_CellEditor);
        // BaseStatus		
        this.BaseStatus.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.wages.BasicStatus").toArray());		
        this.BaseStatus.setRequired(false);
        // prmtExaminPerson		
        this.prmtExaminPerson.setQueryInfo("com.kingdee.eas.basedata.person.app.PersonFilterQuery");		
        this.prmtExaminPerson.setEditable(true);		
        this.prmtExaminPerson.setDisplayFormat("$name$");		
        this.prmtExaminPerson.setEditFormat("$number$");		
        this.prmtExaminPerson.setCommitFormat("$number$");		
        this.prmtExaminPerson.setRequired(false);
        this.setFocusTraversalPolicy(new com.kingdee.bos.ui.UIFocusTraversalPolicy(new java.awt.Component[] {txtSimpleName,txtDescription,txtNumber,txtName,BaseStatus,prmtExaminPerson,kdtEntry}));
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
        this.setBounds(new Rectangle(0, 2, 1013, 629));
        this.setLayout(new KDLayout());
        this.putClientProperty("OriginalBounds", new Rectangle(0, 2, 1013, 629));
        kDLabelContainer1.setBounds(new Rectangle(30, 25, 270, 19));
        this.add(kDLabelContainer1, new KDLayout.Constraints(30, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer2.setBounds(new Rectangle(342, 25, 270, 19));
        this.add(kDLabelContainer2, new KDLayout.Constraints(342, 25, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        kDLabelContainer3.setBounds(new Rectangle(694, -23, 270, 19));
        this.add(kDLabelContainer3, new KDLayout.Constraints(694, -23, 270, 19, 0));
        kDLabelContainer4.setBounds(new Rectangle(695, 66, 270, 19));
        this.add(kDLabelContainer4, new KDLayout.Constraints(695, 66, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        kDTabbedPane1.setBounds(new Rectangle(30, 154, 939, 441));
        this.add(kDTabbedPane1, new KDLayout.Constraints(30, 154, 939, 441, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        contBaseStatus.setBounds(new Rectangle(696, 23, 270, 19));
        this.add(contBaseStatus, new KDLayout.Constraints(696, 23, 270, 19, KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT));
        contExaminPerson.setBounds(new Rectangle(30, 65, 270, 19));
        this.add(contExaminPerson, new KDLayout.Constraints(30, 65, 270, 19, KDLayout.Constraints.ANCHOR_LEFT | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //kDLabelContainer1
        kDLabelContainer1.setBoundEditor(txtNumber);
        //kDLabelContainer2
        kDLabelContainer2.setBoundEditor(txtName);
        //kDLabelContainer3
        kDLabelContainer3.setBoundEditor(txtSimpleName);
        //kDLabelContainer4
        kDLabelContainer4.setBoundEditor(txtDescription);
        //kDTabbedPane1
        kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
        //kDPanel1
        kDPanel1.setLayout(new KDLayout());
        kDPanel1.putClientProperty("OriginalBounds", new Rectangle(0, 0, 938, 408));        kdtEntry.setBounds(new Rectangle(1, 1, 931, 405));
        kdtEntry_detailPanel = (com.kingdee.eas.framework.client.multiDetail.DetailPanel)com.kingdee.eas.framework.client.multiDetail.HMDUtils.buildDetail(this,dataBinder,kdtEntry,new com.kingdee.eas.custom.wages.food.ProdasseindexEntryInfo(),null,false);
        kDPanel1.add(kdtEntry_detailPanel, new KDLayout.Constraints(1, 1, 931, 405, KDLayout.Constraints.ANCHOR_TOP_SCALE | KDLayout.Constraints.ANCHOR_BOTTOM_SCALE | KDLayout.Constraints.ANCHOR_LEFT_SCALE | KDLayout.Constraints.ANCHOR_RIGHT_SCALE));
        //contBaseStatus
        contBaseStatus.setBoundEditor(BaseStatus);
        //contExaminPerson
        contExaminPerson.setBoundEditor(prmtExaminPerson);

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
		dataBinder.registerBinding("Entry.seq", int.class, this.kdtEntry, "seq.text");
		dataBinder.registerBinding("Entry", com.kingdee.eas.custom.wages.food.ProdasseindexEntryInfo.class, this.kdtEntry, "userObject");
		dataBinder.registerBinding("Entry.person", java.lang.Object.class, this.kdtEntry, "person.text");
		dataBinder.registerBinding("Entry.Assessmentproject", String.class, this.kdtEntry, "Assessmentproject.text");
		dataBinder.registerBinding("Entry.AssesValue", java.math.BigDecimal.class, this.kdtEntry, "AssesValue.text");
		dataBinder.registerBinding("Entry.StandardAward", java.math.BigDecimal.class, this.kdtEntry, "StandardAward.text");
		dataBinder.registerBinding("Entry.AssesUnit", java.math.BigDecimal.class, this.kdtEntry, "AssesUnit.text");
		dataBinder.registerBinding("Entry.Unitindex", java.math.BigDecimal.class, this.kdtEntry, "Unitindex.text");
		dataBinder.registerBinding("Entry.personnumber", String.class, this.kdtEntry, "personnumber.text");
		dataBinder.registerBinding("Entry.AssessRates", String.class, this.kdtEntry, "AssessRates.text");
		dataBinder.registerBinding("BaseStatus", com.kingdee.eas.custom.wages.BasicStatus.class, this.BaseStatus, "selectedItem");
		dataBinder.registerBinding("ExaminPerson", com.kingdee.eas.basedata.person.PersonInfo.class, this.prmtExaminPerson, "data");		
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
	    return "com.kingdee.eas.custom.wages.food.app.ProdasseindexEditUIHandler";
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
        this.txtSimpleName.requestFocusInWindow();
    }

	
	

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject)
    {
        IObjectValue ov = dataObject;        	    	
        super.setDataObject(ov);
        this.editData = (com.kingdee.eas.custom.wages.food.ProdasseindexInfo)ov;
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
		getValidateHelper().registerBindProperty("number", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("name", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("simpleName", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("description", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.seq", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.person", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Assessmentproject", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AssesValue", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.StandardAward", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AssesUnit", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.Unitindex", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.personnumber", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("Entry.AssessRates", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("BaseStatus", ValidateHelper.ON_SAVE);    
		getValidateHelper().registerBindProperty("ExaminPerson", ValidateHelper.ON_SAVE);    		
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
     * output kdtEntry_Changed(int rowIndex,int colIndex) method
     */
    public void kdtEntry_Changed(int rowIndex,int colIndex) throws Exception
    {
            if ("person".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"personnumber").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getString(com.kingdee.bos.ui.face.UIRuleUtil.getProperty((com.kingdee.bos.dao.IObjectValue)kdtEntry.getCell(rowIndex,"person").getValue(),"number")));

}

    if ("StandardAward".equalsIgnoreCase(kdtEntry.getColumn(colIndex).getKey())) {
kdtEntry.getCell(rowIndex,"Unitindex").setValue(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimal(com.kingdee.bos.ui.face.UIRuleUtil.getBigDecimalValue(kdtEntry.getCell(rowIndex,"StandardAward").getValue())* 0.3));

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
			sic.add(new SelectorItemInfo("Entry.person.name"));
        	sic.add(new SelectorItemInfo("Entry.person.number"));
		}
    	sic.add(new SelectorItemInfo("Entry.Assessmentproject"));
    	sic.add(new SelectorItemInfo("Entry.AssesValue"));
    	sic.add(new SelectorItemInfo("Entry.StandardAward"));
    	sic.add(new SelectorItemInfo("Entry.AssesUnit"));
    	sic.add(new SelectorItemInfo("Entry.Unitindex"));
    	sic.add(new SelectorItemInfo("Entry.personnumber"));
    	sic.add(new SelectorItemInfo("Entry.AssessRates"));
        sic.add(new SelectorItemInfo("BaseStatus"));
		if(selectorAll.equalsIgnoreCase("true"))
		{
			sic.add(new SelectorItemInfo("ExaminPerson.*"));
		}
		else{
        	sic.add(new SelectorItemInfo("ExaminPerson.id"));
        	sic.add(new SelectorItemInfo("ExaminPerson.number"));
        	sic.add(new SelectorItemInfo("ExaminPerson.name"));
		}
        return sic;
    }        

    /**
     * output getMetaDataPK method
     */
    public IMetaDataPK getMetaDataPK()
    {
        return new MetaDataPK("com.kingdee.eas.custom.wages.food.client", "ProdasseindexEditUI");
    }

    /**
     * output getEditUIName method
     */
    protected String getEditUIName()
    {
        return com.kingdee.eas.custom.wages.food.client.ProdasseindexEditUI.class.getName();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.food.ProdasseindexFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.food.ProdasseindexInfo objectValue = new com.kingdee.eas.custom.wages.food.ProdasseindexInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));		
        return objectValue;
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
		vo.put("BaseStatus","0");
        
    }        
	protected void setFieldsNull(com.kingdee.bos.dao.AbstractObjectValue arg0) {
		super.setFieldsNull(arg0);
		arg0.put("number",null);
	}

}